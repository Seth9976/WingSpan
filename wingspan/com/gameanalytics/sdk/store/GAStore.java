package com.gameanalytics.sdk.store;

import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import com.gameanalytics.sdk.device.GADevice;
import com.gameanalytics.sdk.events.EGASdkErrorAction;
import com.gameanalytics.sdk.events.EGASdkErrorArea;
import com.gameanalytics.sdk.events.EGASdkErrorCategory;
import com.gameanalytics.sdk.http.GAHTTPApi;
import com.gameanalytics.sdk.logging.GALogger;
import com.gameanalytics.sdk.state.GAState;
import com.gameanalytics.sdk.utilities.GAUtilities;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

public class GAStore {
    private static final GAStore INSTANCE = null;
    private static final long MaxDbSizeBytes = 0x600000L;
    private static final long MaxDbSizeBytesBeforeTrim = 0x500000L;
    private String dbPath;
    boolean dbReady;
    private SQLiteDatabase sqlDatabase;
    boolean tableReady;

    static {
        GAStore.INSTANCE = new GAStore();
    }

    private GAStore() {
        this.dbPath = "";
        this.sqlDatabase = null;
        this.dbReady = false;
        this.tableReady = false;
    }

    public static boolean ensureDatabase(boolean dropDatabase) {
        try {
            GAStore.getInstance().dbPath = GADevice.getWritableFilePath() + "/ga.sqlite3";
            GAStore.getInstance().sqlDatabase = SQLiteDatabase.openOrCreateDatabase("", null);
            GAStore.getInstance().dbReady = true;
            GALogger.i("Database opened: ");
        }
        catch(Exception exception0) {
            GAStore.getInstance().dbReady = false;
            GALogger.w("Could not open database: ");
            exception0.printStackTrace();
            String s = GAState.getGameKey();
            String s1 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Database, EGASdkErrorArea.Sql, EGASdkErrorAction.DatabaseOpenOrCreate, exception0.toString(), s, s1);
            return false;
        }
        if(dropDatabase) {
            GALogger.d("Drop tables");
            GAStore.executeQuerySync("DROP TABLE ga_events");
            GAStore.executeQuerySync("DROP TABLE ga_state");
            GAStore.executeQuerySync("DROP TABLE ga_session");
            GAStore.executeQuerySync("DROP TABLE ga_progression");
            GAStore.executeQuerySync("VACUUM");
        }
        if(GAStore.executeQuerySync("CREATE TABLE IF NOT EXISTS ga_events(status CHAR(50) NOT NULL, category CHAR(50) NOT NULL, session_id CHAR(50) NOT NULL, client_ts CHAR(50) NOT NULL, event TEXT NOT NULL);") == null) {
            return false;
        }
        if(GAStore.executeQuerySync("SELECT status FROM ga_events LIMIT 0,1") == null) {
            GALogger.d("ga_events corrupt, recreating.");
            GAStore.executeQuerySync("DROP TABLE ga_events");
            if(GAStore.executeQuerySync("CREATE TABLE IF NOT EXISTS ga_events(status CHAR(50) NOT NULL, category CHAR(50) NOT NULL, session_id CHAR(50) NOT NULL, client_ts CHAR(50) NOT NULL, event TEXT NOT NULL);") == null) {
                GALogger.w("ga_events corrupt, could not recreate it.");
                return false;
            }
        }
        if(GAStore.executeQuerySync("CREATE TABLE IF NOT EXISTS ga_session(session_id CHAR(50) PRIMARY KEY NOT NULL, timestamp CHAR(50) NOT NULL, event TEXT NOT NULL);") == null) {
            return false;
        }
        if(GAStore.executeQuerySync("SELECT session_id FROM ga_session LIMIT 0,1") == null) {
            GALogger.d("ga_session corrupt, recreating.");
            GAStore.executeQuerySync("DROP TABLE ga_session");
            if(GAStore.executeQuerySync("CREATE TABLE IF NOT EXISTS ga_session(session_id CHAR(50) PRIMARY KEY NOT NULL, timestamp CHAR(50) NOT NULL, event TEXT NOT NULL);") == null) {
                GALogger.w("ga_session corrupt, could not recreate it.");
                return false;
            }
        }
        if(GAStore.executeQuerySync("CREATE TABLE IF NOT EXISTS ga_state(key CHAR(255) PRIMARY KEY NOT NULL, value TEXT);") == null) {
            return false;
        }
        if(GAStore.executeQuerySync("SELECT key FROM ga_state LIMIT 0,1") == null) {
            GALogger.d("ga_state corrupt, recreating.");
            GAStore.executeQuerySync("DROP TABLE ga_state");
            if(GAStore.executeQuerySync("CREATE TABLE IF NOT EXISTS ga_state(key CHAR(255) PRIMARY KEY NOT NULL, value TEXT);") == null) {
                GALogger.w("ga_state corrupt, could not recreate it.");
                return false;
            }
        }
        if(GAStore.executeQuerySync("CREATE TABLE IF NOT EXISTS ga_progression(progression CHAR(255) PRIMARY KEY NOT NULL, tries CHAR(255));") == null) {
            return false;
        }
        if(GAStore.executeQuerySync("SELECT progression FROM ga_progression LIMIT 0,1") == null) {
            GALogger.d("ga_progression corrupt, recreating.");
            GAStore.executeQuerySync("DROP TABLE ga_progression");
            if(GAStore.executeQuerySync("CREATE TABLE IF NOT EXISTS ga_progression(progression CHAR(255) PRIMARY KEY NOT NULL, tries CHAR(255));") == null) {
                GALogger.w("ga_progression corrupt, could not recreate it.");
                return false;
            }
        }
        GAStore.trimEventTable();
        GAStore.getInstance().tableReady = true;
        GALogger.d("Database tables ensured present");
        return true;
    }

    public static JSONArray executeQuerySync(String sql) {
        return GAStore.executeQuerySync(sql, new ArrayList());
    }

    public static JSONArray executeQuerySync(String sql, ArrayList parameters) {
        return GAStore.executeQuerySync(sql, parameters, false);
    }

    public static JSONArray executeQuerySync(String sql, ArrayList parameters, boolean useTransaction) {
        Cursor cursor1;
        Cursor cursor0;
        boolean z1 = GAUtilities.stringMatch(sql.toUpperCase(Locale.US), "^(UPDATE|INSERT|DELETE)") ? true : useTransaction;
        SQLiteDatabase sQLiteDatabase0 = GAStore.getInstance().getDatabase();
        JSONArray jSONArray0 = new JSONArray();
        if(z1) {
            try {
                sQLiteDatabase0.execSQL("BEGIN;");
            }
            catch(Exception exception0) {
                GALogger.e("SQLITE3 BEGIN ERROR: ");
                exception0.printStackTrace();
                String s1 = GAState.getGameKey();
                String s2 = GAState.getSecretKey();
                GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Database, EGASdkErrorArea.Sql, EGASdkErrorAction.SqlBegin, exception0.toString(), s1, s2);
                return null;
            }
        }
        try {
            cursor0 = parameters.isEmpty() ? sQLiteDatabase0.rawQuery(sql, null) : sQLiteDatabase0.rawQuery(sql, ((String[])parameters.toArray(new String[parameters.size()])));
        }
        catch(Exception exception1) {
            cursor1 = null;
            goto label_38;
        }
        try {
            cursor1 = cursor0;
            int v = cursor1.getColumnCount();
            while(true) {
                if(!cursor1.moveToNext()) {
                    goto label_44;
                }
                JSONObject jSONObject0 = new JSONObject();
                int v1 = 0;
            label_23:
                if(v1 >= v) {
                    jSONArray0.put(jSONObject0);
                    continue;
                }
                String s3 = cursor1.getColumnName(v1);
                if(s3 != null) {
                    try {
                        GAStore.setColumn(cursor1, ((SQLiteCursor)cursor1).getWindow(), cursor1.getPosition(), v1, jSONObject0, s3);
                    }
                    catch(Exception exception2) {
                        exception2.printStackTrace();
                        String s4 = GAState.getGameKey();
                        String s5 = GAState.getSecretKey();
                        GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Database, EGASdkErrorArea.Sql, EGASdkErrorAction.SqlSetColumn, exception2.toString(), s4, s5);
                    }
                }
                ++v1;
                goto label_23;
            }
        }
        catch(Exception exception1) {
        }
    label_38:
        GALogger.e("SQLITE3 PREPARE ERROR: ");
        exception1.printStackTrace();
        String s6 = GAState.getGameKey();
        String s7 = GAState.getSecretKey();
        GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Database, EGASdkErrorArea.Sql, EGASdkErrorAction.SqlRawQuery, exception1.toString(), s6, s7);
        jSONArray0 = null;
        try {
        label_44:
            cursor1.close();
            if(z1) {
                try {
                    sQLiteDatabase0.execSQL("COMMIT");
                    return jSONArray0;
                }
                catch(Exception exception4) {
                    GALogger.e("SQLITE3 COMMIT ERROR: ");
                    exception4.printStackTrace();
                    String s8 = GAState.getGameKey();
                    String s9 = GAState.getSecretKey();
                    GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Database, EGASdkErrorArea.Sql, EGASdkErrorAction.SqlCommit, exception4.toString(), s8, s9);
                    return null;
                }
            }
            return jSONArray0;
        }
        catch(Exception exception3) {
            GALogger.d("SQLITE3 FINALIZE ERROR: ");
            exception3.printStackTrace();
            String s10 = GAState.getGameKey();
            String s11 = GAState.getSecretKey();
            GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Database, EGASdkErrorArea.Sql, EGASdkErrorAction.SqlCommit, exception3.toString(), s10, s11);
            if(z1) {
                try {
                    sQLiteDatabase0.execSQL("ROLLBACK");
                    return null;
                }
                catch(Exception exception5) {
                    GALogger.e("SQLITE3 ROLLBACK ERROR: ");
                    exception5.printStackTrace();
                    String s12 = GAState.getGameKey();
                    String s13 = GAState.getSecretKey();
                    GAHTTPApi.getInstance().sendSdkErrorEvent(EGASdkErrorCategory.Database, EGASdkErrorArea.Sql, EGASdkErrorAction.SqlRollback, exception5.toString(), s12, s13);
                }
            }
            return null;
        }
    }

    private SQLiteDatabase getDatabase() {
        return this.sqlDatabase;
    }

    public static long getDbSizeBytes() {
        return new File(GAStore.getInstance().sqlDatabase.getPath()).length();
    }

    private static GAStore getInstance() {
        return GAStore.INSTANCE;
    }

    public static boolean getTableReady() [...] // 潜在的解密器

    public static boolean isDbTooLargeForEvents() {
        return GAStore.getDbSizeBytes() > 0x600000L;
    }

    private static void setColumn(Cursor cursor, CursorWindow cursorWindow, int pos, int i, JSONObject row, String column) throws Exception {
        try {
            switch(cursorWindow.getType(pos, i)) {
                case 1: {
                    row.put(column, cursor.getInt(i));
                    return;
                }
                case 2: {
                    row.put(column, cursor.getDouble(i));
                    return;
                }
                default: {
                    row.put(column, cursor.getString(i));
                }
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            throw exception0;
        }
    }

    public static boolean setState(String key, String value) {
        if(value != null && value.length() != 0) {
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(key);
            arrayList0.add(value);
            return GAStore.executeQuerySync("INSERT OR REPLACE INTO ga_state (key, value) VALUES(?, ?);", arrayList0, true) != null;
        }
        ArrayList arrayList1 = new ArrayList();
        arrayList1.add(key);
        return GAStore.executeQuerySync("DELETE FROM ga_state WHERE key = ?;", arrayList1) != null;
    }

    private static boolean trimEventTable() {
        if(Long.compare(GAStore.getDbSizeBytes(), 0x500000L) > 0) {
            JSONArray jSONArray0 = GAStore.executeQuerySync("SELECT session_id, Max(client_ts) FROM ga_events GROUP BY session_id ORDER BY client_ts LIMIT 3");
            if(jSONArray0 != null && jSONArray0.length() > 0) {
                String s = "";
                for(int v = 0; v < jSONArray0.length(); ++v) {
                    s = s + jSONArray0.optString(v, "");
                    if(v < jSONArray0.length() - 1) {
                        s = s + ",";
                    }
                }
                GALogger.w("Database too large when initializing. Deleting the oldest 3 sessions.");
                GAStore.executeQuerySync(("DELETE FROM ga_events WHERE session_id IN (\"" + s + "\");"));
                GAStore.executeQuerySync("VACUUM");
                return true;
            }
            return false;
        }
        return true;
    }
}

