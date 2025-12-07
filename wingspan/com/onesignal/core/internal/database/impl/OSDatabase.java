package com.onesignal.core.internal.database.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.session.internal.outcomes.impl.OutcomeTableProvider;
import java.io.Closeable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0010\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B!\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001A\u00020\b\u00A2\u0006\u0002\u0010\tJ/\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\u000E\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016\u00A2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001A\u00020\u0013H\u0002J\b\u0010\u0014\u001A\u00020\u0013H\u0002J$\u0010\u0015\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\u0010\u0016\u001A\u0004\u0018\u00010\r2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0016J$\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\b\u0010\u0016\u001A\u0004\u0018\u00010\r2\b\u0010\u0017\u001A\u0004\u0018\u00010\u0018H\u0016J \u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u00132\u0006\u0010\u001C\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\bH\u0002J\u0010\u0010\u001E\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0013H\u0016J \u0010\u001F\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u00132\u0006\u0010\u001C\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\bH\u0016J \u0010 \u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u00132\u0006\u0010\u001C\u001A\u00020\b2\u0006\u0010\u001D\u001A\u00020\bH\u0016J{\u0010!\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u000E\u0010\"\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\u000E\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00102\b\u0010#\u001A\u0004\u0018\u00010\r2\b\u0010$\u001A\u0004\u0018\u00010\r2\b\u0010%\u001A\u0004\u0018\u00010\r2\b\u0010&\u001A\u0004\u0018\u00010\r2\u0012\u0010\'\u001A\u000E\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000B0(H\u0016\u00A2\u0006\u0002\u0010*J\u0018\u0010+\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u00132\u0006\u0010,\u001A\u00020\rH\u0002J7\u0010-\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u00182\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\u000E\u0010\u000F\u001A\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0010H\u0016\u00A2\u0006\u0002\u0010.J\u0010\u0010/\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0013H\u0002J\u0010\u00100\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0013H\u0002J\u0010\u00101\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0013H\u0002J\u0010\u00102\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0013H\u0002J\u0010\u00103\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0013H\u0002J\u0010\u00104\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0013H\u0002J\u0010\u00105\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0013H\u0002J\u0010\u00106\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u0013H\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004\u00A2\u0006\u0002\n\u0000\u00A8\u00068"}, d2 = {"Lcom/onesignal/core/internal/database/impl/OSDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Lcom/onesignal/core/internal/database/IDatabase;", "_outcomeTableProvider", "Lcom/onesignal/session/internal/outcomes/impl/OutcomeTableProvider;", "context", "Landroid/content/Context;", "version", "", "(Lcom/onesignal/session/internal/outcomes/impl/OutcomeTableProvider;Landroid/content/Context;I)V", "delete", "", "table", "", "whereClause", "whereArgs", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getSQLiteDatabase", "Landroid/database/sqlite/SQLiteDatabase;", "getSQLiteDatabaseWithRetries", "insert", "nullColumnHack", "values", "Landroid/content/ContentValues;", "insertOrThrow", "internalOnUpgrade", "db", "oldVersion", "newVersion", "onCreate", "onDowngrade", "onUpgrade", "query", "columns", "groupBy", "having", "orderBy", "limit", "action", "Lkotlin/Function1;", "Lcom/onesignal/core/internal/database/ICursor;", "(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "safeExecSQL", "sql", "update", "(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "upgradeFromV5ToV6", "upgradeToV2", "upgradeToV3", "upgradeToV4", "upgradeToV5", "upgradeToV7", "upgradeToV8", "upgradeToV9", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class OSDatabase extends SQLiteOpenHelper implements IDatabase {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001A\b\u0012\u0004\u0012\u00020\u00040\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000E\u0010\u0014\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/onesignal/core/internal/database/impl/OSDatabase$Companion;", "", "()V", "COMMA_SEP", "", "DATABASE_NAME", "DB_OPEN_RETRY_BACKOFF", "", "DB_OPEN_RETRY_MAX", "DB_VERSION", "DEFAULT_TTL_IF_NOT_IN_PAYLOAD", "FLOAT_TYPE", "INTEGER_PRIMARY_KEY_TYPE", "INT_TYPE", "LOCK", "SQL_CREATE_ENTRIES", "SQL_CREATE_IN_APP_MESSAGE_ENTRIES", "SQL_INDEX_ENTRIES", "", "[Ljava/lang/String;", "TEXT_TYPE", "TIMESTAMP_TYPE", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    private static final String COMMA_SEP = ",";
    public static final Companion Companion = null;
    private static final String DATABASE_NAME = "OneSignal.db";
    private static final int DB_OPEN_RETRY_BACKOFF = 400;
    private static final int DB_OPEN_RETRY_MAX = 5;
    private static final int DB_VERSION = 9;
    public static final int DEFAULT_TTL_IF_NOT_IN_PAYLOAD = 0x3F480;
    private static final String FLOAT_TYPE = " FLOAT";
    private static final String INTEGER_PRIMARY_KEY_TYPE = " INTEGER PRIMARY KEY";
    private static final String INT_TYPE = " INTEGER";
    private static final Object LOCK = null;
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime(\'%s\', \'now\')),expire_time TIMESTAMP);";
    private static final String SQL_CREATE_IN_APP_MESSAGE_ENTRIES = "CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);";
    private static final String[] SQL_INDEX_ENTRIES = null;
    private static final String TEXT_TYPE = " TEXT";
    private static final String TIMESTAMP_TYPE = " TIMESTAMP";
    private final OutcomeTableProvider _outcomeTableProvider;

    static {
        OSDatabase.Companion = new Companion(null);
        OSDatabase.LOCK = new Object();
        OSDatabase.SQL_INDEX_ENTRIES = new String[]{"CREATE INDEX notification_notification_id_idx ON notification(notification_id); ", "CREATE INDEX notification_android_notification_id_idx ON notification(android_notification_id); ", "CREATE INDEX notification_group_id_idx ON notification(group_id); ", "CREATE INDEX notification_collapse_id_idx ON notification(collapse_id); ", "CREATE INDEX notification_created_time_idx ON notification(created_time); ", "CREATE INDEX notification_expire_time_idx ON notification(expire_time); "};
    }

    public OSDatabase(OutcomeTableProvider outcomeTableProvider0, Context context0, int v) {
        Intrinsics.checkNotNullParameter(outcomeTableProvider0, "_outcomeTableProvider");
        super(context0, "OneSignal.db", null, v);
        this._outcomeTableProvider = outcomeTableProvider0;
    }

    public OSDatabase(OutcomeTableProvider outcomeTableProvider0, Context context0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 4) != 0) {
            v = 9;
        }
        this(outcomeTableProvider0, context0, v);
    }

    @Override  // com.onesignal.core.internal.database.IDatabase
    public void delete(String s, String s1, String[] arr_s) {
        Throwable throwable2;
        Throwable throwable1;
        Intrinsics.checkNotNullParameter(s, "table");
        synchronized(OSDatabase.LOCK) {
            SQLiteDatabase sQLiteDatabase0 = this.getSQLiteDatabaseWithRetries();
            try {
                try {
                    sQLiteDatabase0.beginTransaction();
                    sQLiteDatabase0.delete(s, s1, arr_s);
                    sQLiteDatabase0.setTransactionSuccessful();
                    goto label_39;
                }
                catch(SQLiteException sQLiteException0) {
                }
                catch(IllegalStateException illegalStateException0) {
                    goto label_20;
                }
                Logging.error(("Error deleting on table: " + s + " with whereClause: " + s1 + " and whereArgs: " + arr_s), sQLiteException0);
            }
            catch(Throwable throwable0) {
                goto label_30;
            }
            try {
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException1) {
                throwable1 = illegalStateException1;
                Logging.error("Error closing transaction! ", throwable1);
            }
            catch(SQLiteException sQLiteException1) {
                throwable2 = sQLiteException1;
                Logging.error("Error closing transaction! ", throwable2);
            }
            return;
            try {
            label_20:
                Logging.error(("Error under delete transaction under table: " + s + " with whereClause: " + s1 + " and whereArgs: " + arr_s), illegalStateException0);
            }
            catch(Throwable throwable0) {
                goto label_30;
            }
            try {
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException2) {
                throwable1 = illegalStateException2;
                Logging.error("Error closing transaction! ", throwable1);
            }
            catch(SQLiteException sQLiteException2) {
                throwable2 = sQLiteException2;
                Logging.error("Error closing transaction! ", throwable2);
            }
            return;
            try {
            label_30:
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException3) {
                Logging.error("Error closing transaction! ", illegalStateException3);
            }
            catch(SQLiteException sQLiteException3) {
                Logging.error("Error closing transaction! ", sQLiteException3);
            }
            throw throwable0;
            try {
            label_39:
                sQLiteDatabase0.endTransaction();
                return;
            }
            catch(IllegalStateException illegalStateException4) {
                throwable1 = illegalStateException4;
                Logging.error("Error closing transaction! ", throwable1);
                return;
            }
            catch(SQLiteException sQLiteException4) {
                throwable2 = sQLiteException4;
            }
            Logging.error("Error closing transaction! ", throwable2);
        }
    }

    private final SQLiteDatabase getSQLiteDatabase() {
        synchronized(OSDatabase.LOCK) {
            SQLiteDatabase sQLiteDatabase0 = this.getWritableDatabase();
            Intrinsics.checkNotNullExpressionValue(sQLiteDatabase0, "{\n                writableDatabase\n            }");
            return sQLiteDatabase0;
        }
    }

    private final SQLiteDatabase getSQLiteDatabaseWithRetries() {
        SQLiteDatabase sQLiteDatabase0;
        synchronized(OSDatabase.LOCK) {
            int v1 = 0;
            while(true) {
                try {
                    sQLiteDatabase0 = this.getSQLiteDatabase();
                    break;
                }
                catch(SQLiteCantOpenDatabaseException sQLiteCantOpenDatabaseException0) {
                    ++v1;
                    if(v1 >= 5) {
                        throw sQLiteCantOpenDatabaseException0;
                    }
                    SystemClock.sleep(v1 * 400);
                }
                catch(SQLiteDatabaseLockedException sQLiteDatabaseLockedException0) {
                    ++v1;
                    if(v1 >= 5) {
                        throw sQLiteDatabaseLockedException0;
                    }
                    SystemClock.sleep(v1 * 400);
                }
            }
            return sQLiteDatabase0;
        }
    }

    @Override  // com.onesignal.core.internal.database.IDatabase
    public void insert(String s, String s1, ContentValues contentValues0) {
        Throwable throwable2;
        Throwable throwable1;
        Intrinsics.checkNotNullParameter(s, "table");
        synchronized(OSDatabase.LOCK) {
            SQLiteDatabase sQLiteDatabase0 = this.getSQLiteDatabaseWithRetries();
            try {
                try {
                    sQLiteDatabase0.beginTransaction();
                    sQLiteDatabase0.insert(s, s1, contentValues0);
                    sQLiteDatabase0.setTransactionSuccessful();
                    goto label_39;
                }
                catch(SQLiteException sQLiteException0) {
                }
                catch(IllegalStateException illegalStateException0) {
                    goto label_20;
                }
                Logging.error(("Error inserting on table: " + s + " with nullColumnHack: " + s1 + " and values: " + contentValues0), sQLiteException0);
            }
            catch(Throwable throwable0) {
                goto label_30;
            }
            try {
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException1) {
                throwable1 = illegalStateException1;
                Logging.error("Error closing transaction! ", throwable1);
            }
            catch(SQLiteException sQLiteException1) {
                throwable2 = sQLiteException1;
                Logging.error("Error closing transaction! ", throwable2);
            }
            return;
            try {
            label_20:
                Logging.error(("Error under inserting transaction under table: " + s + " with nullColumnHack: " + s1 + " and values: " + contentValues0), illegalStateException0);
            }
            catch(Throwable throwable0) {
                goto label_30;
            }
            try {
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException2) {
                throwable1 = illegalStateException2;
                Logging.error("Error closing transaction! ", throwable1);
            }
            catch(SQLiteException sQLiteException2) {
                throwable2 = sQLiteException2;
                Logging.error("Error closing transaction! ", throwable2);
            }
            return;
            try {
            label_30:
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException3) {
                Logging.error("Error closing transaction! ", illegalStateException3);
            }
            catch(SQLiteException sQLiteException3) {
                Logging.error("Error closing transaction! ", sQLiteException3);
            }
            throw throwable0;
            try {
            label_39:
                sQLiteDatabase0.endTransaction();
                return;
            }
            catch(IllegalStateException illegalStateException4) {
                throwable1 = illegalStateException4;
                Logging.error("Error closing transaction! ", throwable1);
                return;
            }
            catch(SQLiteException sQLiteException4) {
                throwable2 = sQLiteException4;
            }
            Logging.error("Error closing transaction! ", throwable2);
        }
    }

    @Override  // com.onesignal.core.internal.database.IDatabase
    public void insertOrThrow(String s, String s1, ContentValues contentValues0) throws SQLException {
        Throwable throwable2;
        Throwable throwable1;
        Intrinsics.checkNotNullParameter(s, "table");
        synchronized(OSDatabase.LOCK) {
            SQLiteDatabase sQLiteDatabase0 = this.getSQLiteDatabaseWithRetries();
            try {
                try {
                    sQLiteDatabase0.beginTransaction();
                    sQLiteDatabase0.insertOrThrow(s, s1, contentValues0);
                    sQLiteDatabase0.setTransactionSuccessful();
                    goto label_39;
                }
                catch(SQLiteException sQLiteException0) {
                }
                catch(IllegalStateException illegalStateException0) {
                    goto label_20;
                }
                Logging.error(("Error inserting or throw on table: " + s + " with nullColumnHack: " + s1 + " and values: " + contentValues0), sQLiteException0);
            }
            catch(Throwable throwable0) {
                goto label_30;
            }
            try {
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException1) {
                throwable1 = illegalStateException1;
                Logging.error("Error closing transaction! ", throwable1);
            }
            catch(SQLiteException sQLiteException1) {
                throwable2 = sQLiteException1;
                Logging.error("Error closing transaction! ", throwable2);
            }
            return;
            try {
            label_20:
                Logging.error(("Error under inserting or throw transaction under table: " + s + " with nullColumnHack: " + s1 + " and values: " + contentValues0), illegalStateException0);
            }
            catch(Throwable throwable0) {
                goto label_30;
            }
            try {
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException2) {
                throwable1 = illegalStateException2;
                Logging.error("Error closing transaction! ", throwable1);
            }
            catch(SQLiteException sQLiteException2) {
                throwable2 = sQLiteException2;
                Logging.error("Error closing transaction! ", throwable2);
            }
            return;
            try {
            label_30:
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException3) {
                Logging.error("Error closing transaction! ", illegalStateException3);
            }
            catch(SQLiteException sQLiteException3) {
                Logging.error("Error closing transaction! ", sQLiteException3);
            }
            throw throwable0;
            try {
            label_39:
                sQLiteDatabase0.endTransaction();
                return;
            }
            catch(IllegalStateException illegalStateException4) {
                throwable1 = illegalStateException4;
                Logging.error("Error closing transaction! ", throwable1);
                return;
            }
            catch(SQLiteException sQLiteException4) {
                throwable2 = sQLiteException4;
            }
            Logging.error("Error closing transaction! ", throwable2);
        }
    }

    private final void internalOnUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        synchronized(this) {
            if(v < 2 && v1 >= 2) {
                this.upgradeToV2(sQLiteDatabase0);
            }
            if(v < 3 && v1 >= 3) {
                this.upgradeToV3(sQLiteDatabase0);
            }
            if(v < 4 && v1 >= 4) {
                this.upgradeToV4(sQLiteDatabase0);
            }
            if(v < 5 && v1 >= 5) {
                this.upgradeToV5(sQLiteDatabase0);
            }
            if(v == 5 && v1 >= 6) {
                this.upgradeFromV5ToV6(sQLiteDatabase0);
            }
            if(v < 7 && v1 >= 7) {
                this.upgradeToV7(sQLiteDatabase0);
            }
            if(v < 8 && v1 >= 8) {
                this.upgradeToV8(sQLiteDatabase0);
            }
            if(v < 9 && v1 >= 9) {
                this.upgradeToV9(sQLiteDatabase0);
            }
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase0) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase0, "db");
        sQLiteDatabase0.execSQL("CREATE TABLE notification (_id INTEGER PRIMARY KEY,notification_id TEXT,android_notification_id INTEGER,group_id TEXT,collapse_id TEXT,is_summary INTEGER DEFAULT 0,opened INTEGER DEFAULT 0,dismissed INTEGER DEFAULT 0,title TEXT,message TEXT,full_data TEXT,created_time TIMESTAMP DEFAULT (strftime(\'%s\', \'now\')),expire_time TIMESTAMP);");
        sQLiteDatabase0.execSQL("CREATE TABLE outcome (_id INTEGER PRIMARY KEY,notification_influence_type TEXT,iam_influence_type TEXT,notification_ids TEXT,iam_ids TEXT,name TEXT,timestamp TIMESTAMP,weight FLOAT,session_time INTEGER);");
        sQLiteDatabase0.execSQL("CREATE TABLE cached_unique_outcome (_id INTEGER PRIMARY KEY,channel_influence_id TEXT,channel_type TEXT,name TEXT);");
        sQLiteDatabase0.execSQL("CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);");
        String[] arr_s = OSDatabase.SQL_INDEX_ENTRIES;
        for(int v = 0; v < arr_s.length; ++v) {
            sQLiteDatabase0.execSQL(arr_s[v]);
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase0, "db");
        Logging.warn$default("SDK version rolled back! Clearing OneSignal.db as it could be in an unexpected state.", null, 2, null);
        Closeable closeable0 = sQLiteDatabase0.rawQuery("SELECT name FROM sqlite_master WHERE type=\'table\'", null);
        try {
            ArrayList arrayList0 = new ArrayList(((Cursor)closeable0).getCount());
            while(((Cursor)closeable0).moveToNext()) {
                String s = ((Cursor)closeable0).getString(0);
                Intrinsics.checkNotNullExpressionValue(s, "it.getString(0)");
                arrayList0.add(s);
            }
            for(Object object0: arrayList0) {
                String s1 = (String)object0;
                if(!StringsKt.startsWith$default(s1, "sqlite_", false, 2, null)) {
                    sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS " + s1);
                }
            }
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(closeable0, throwable0);
            throw throwable0;
        }
        CloseableKt.closeFinally(closeable0, null);
        this.onCreate(sQLiteDatabase0);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase0, "db");
        Logging.debug$default(("OneSignal Database onUpgrade from: " + v + " to: " + v1), null, 2, null);
        try {
            this.internalOnUpgrade(sQLiteDatabase0, v, v1);
        }
        catch(SQLiteException sQLiteException0) {
            Logging.error("Error in upgrade, migration may have already run! Skipping!", sQLiteException0);
        }
    }

    @Override  // com.onesignal.core.internal.database.IDatabase
    public void query(String s, String[] arr_s, String s1, String[] arr_s1, String s2, String s3, String s4, String s5, Function1 function10) {
        Cursor cursor0;
        Intrinsics.checkNotNullParameter(s, "table");
        Intrinsics.checkNotNullParameter(function10, "action");
        synchronized(OSDatabase.LOCK) {
            if(s5 == null) {
                cursor0 = this.getSQLiteDatabaseWithRetries().query(s, arr_s, s1, arr_s1, s2, s3, s4);
                Intrinsics.checkNotNullExpressionValue(cursor0, "getSQLiteDatabaseWithRet…By,\n                    )");
            }
            else {
                cursor0 = this.getSQLiteDatabaseWithRetries().query(s, arr_s, s1, arr_s1, s2, s3, s4, s5);
                Intrinsics.checkNotNullExpressionValue(cursor0, "getSQLiteDatabaseWithRet…it,\n                    )");
            }
        }
        try {
            function10.invoke(new DatabaseCursor(cursor0));
        }
        catch(Throwable throwable0) {
            CloseableKt.closeFinally(cursor0, throwable0);
            throw throwable0;
        }
        CloseableKt.closeFinally(cursor0, null);
    }

    private final void safeExecSQL(SQLiteDatabase sQLiteDatabase0, String s) {
        try {
            sQLiteDatabase0.execSQL(s);
        }
        catch(SQLiteException sQLiteException0) {
            sQLiteException0.printStackTrace();
        }
    }

    @Override  // com.onesignal.core.internal.database.IDatabase
    public int update(String s, ContentValues contentValues0, String s1, String[] arr_s) {
        Throwable throwable2;
        Throwable throwable1;
        Intrinsics.checkNotNullParameter(s, "table");
        Intrinsics.checkNotNullParameter(contentValues0, "values");
        String s2 = contentValues0.toString();
        Intrinsics.checkNotNullExpressionValue(s2, "values.toString()");
        int v = 0;
        if(s2.length() == 0) {
            return 0;
        }
        synchronized(OSDatabase.LOCK) {
            SQLiteDatabase sQLiteDatabase0 = this.getSQLiteDatabaseWithRetries();
            try {
                try {
                    sQLiteDatabase0.beginTransaction();
                    v = sQLiteDatabase0.update(s, contentValues0, s1, arr_s);
                    sQLiteDatabase0.setTransactionSuccessful();
                    goto label_45;
                }
                catch(SQLiteException sQLiteException0) {
                }
                catch(IllegalStateException illegalStateException0) {
                    goto label_26;
                }
                Logging.error(("Error updating on table: " + s + " with whereClause: " + s1 + " and whereArgs: " + arr_s), sQLiteException0);
            }
            catch(Throwable throwable0) {
                goto label_36;
            }
            try {
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException1) {
                throwable1 = illegalStateException1;
                Logging.error("Error closing transaction! ", throwable1);
            }
            catch(SQLiteException sQLiteException1) {
                throwable2 = sQLiteException1;
                Logging.error("Error closing transaction! ", throwable2);
            }
            return v;
            try {
            label_26:
                Logging.error(("Error under update transaction under table: " + s + " with whereClause: " + s1 + " and whereArgs: " + arr_s), illegalStateException0);
            }
            catch(Throwable throwable0) {
                goto label_36;
            }
            try {
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException2) {
                throwable1 = illegalStateException2;
                Logging.error("Error closing transaction! ", throwable1);
            }
            catch(SQLiteException sQLiteException2) {
                throwable2 = sQLiteException2;
                Logging.error("Error closing transaction! ", throwable2);
            }
            return v;
            try {
            label_36:
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException illegalStateException3) {
                Logging.error("Error closing transaction! ", illegalStateException3);
            }
            catch(SQLiteException sQLiteException3) {
                Logging.error("Error closing transaction! ", sQLiteException3);
            }
            throw throwable0;
            try {
            label_45:
                sQLiteDatabase0.endTransaction();
                return v;
            }
            catch(IllegalStateException illegalStateException4) {
                throwable1 = illegalStateException4;
                Logging.error("Error closing transaction! ", throwable1);
                return v;
            }
            catch(SQLiteException sQLiteException4) {
                throwable2 = sQLiteException4;
            }
            Logging.error("Error closing transaction! ", throwable2);
            return v;
        }
    }

    private final void upgradeFromV5ToV6(SQLiteDatabase sQLiteDatabase0) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision1To2(sQLiteDatabase0);
    }

    private final void upgradeToV2(SQLiteDatabase sQLiteDatabase0) {
        this.safeExecSQL(sQLiteDatabase0, "ALTER TABLE notification ADD COLUMN collapse_id TEXT;");
        this.safeExecSQL(sQLiteDatabase0, "CREATE INDEX notification_group_id_idx ON notification(group_id); ");
    }

    private final void upgradeToV3(SQLiteDatabase sQLiteDatabase0) {
        this.safeExecSQL(sQLiteDatabase0, "ALTER TABLE notification ADD COLUMN expire_time TIMESTAMP;");
        this.safeExecSQL(sQLiteDatabase0, "UPDATE notification SET expire_time = created_time + 259200;");
        this.safeExecSQL(sQLiteDatabase0, "CREATE INDEX notification_expire_time_idx ON notification(expire_time); ");
    }

    private final void upgradeToV4(SQLiteDatabase sQLiteDatabase0) {
        this.safeExecSQL(sQLiteDatabase0, "CREATE TABLE outcome (_id INTEGER PRIMARY KEY,notification_ids TEXT,name TEXT,session TEXT,params TEXT,timestamp TIMESTAMP);");
    }

    private final void upgradeToV5(SQLiteDatabase sQLiteDatabase0) {
        this.safeExecSQL(sQLiteDatabase0, "CREATE TABLE cached_unique_outcome_notification (_id INTEGER PRIMARY KEY,notification_id TEXT,name TEXT);");
        this.upgradeFromV5ToV6(sQLiteDatabase0);
    }

    private final void upgradeToV7(SQLiteDatabase sQLiteDatabase0) {
        this.safeExecSQL(sQLiteDatabase0, "CREATE TABLE in_app_message (_id INTEGER PRIMARY KEY,display_quantity INTEGER,last_display INTEGER,message_id TEXT,displayed_in_session INTEGER,click_ids TEXT);");
    }

    private final void upgradeToV8(SQLiteDatabase sQLiteDatabase0) {
        synchronized(this) {
            this._outcomeTableProvider.upgradeOutcomeTableRevision2To3(sQLiteDatabase0);
            this._outcomeTableProvider.upgradeCacheOutcomeTableRevision1To2(sQLiteDatabase0);
        }
    }

    private final void upgradeToV9(SQLiteDatabase sQLiteDatabase0) {
        this._outcomeTableProvider.upgradeOutcomeTableRevision3To4(sQLiteDatabase0);
    }
}

