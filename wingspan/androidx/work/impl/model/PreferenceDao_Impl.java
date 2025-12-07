package androidx.work.impl.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class PreferenceDao_Impl implements PreferenceDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfPreference;

    public PreferenceDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfPreference = new EntityInsertionAdapter(__db) {
            public void bind(SupportSQLiteStatement stmt, Preference value) {
                if(value.getKey() == null) {
                    stmt.bindNull(1);
                }
                else {
                    stmt.bindString(1, value.getKey());
                }
                if(value.getValue() == null) {
                    stmt.bindNull(2);
                    return;
                }
                stmt.bindLong(2, ((long)value.getValue()));
            }

            @Override  // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, Object value) {
                this.bind(stmt, ((Preference)value));
            }

            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }
        };
    }

    @Override  // androidx.work.impl.model.PreferenceDao
    public Long getLongValue(String key) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if(key == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, key);
        }
        this.__db.assertNotSuspendingTransaction();
        Long long0 = null;
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            if(cursor0.moveToFirst() && !cursor0.isNull(0)) {
                long0 = cursor0.getLong(0);
            }
            return long0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.PreferenceDao
    public LiveData getObservableLongValue(String key) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if(key == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, key);
        }
        androidx.work.impl.model.PreferenceDao_Impl.2 preferenceDao_Impl$20 = new Callable() {
            public Long call() throws Exception {
                try(Cursor cursor0 = DBUtil.query(PreferenceDao_Impl.this.__db, roomSQLiteQuery0, false, null)) {
                    return cursor0.moveToFirst() && !cursor0.isNull(0) ? cursor0.getLong(0) : null;
                }
            }

            @Override
            public Object call() throws Exception {
                return this.call();
            }

            @Override
            protected void finalize() {
                roomSQLiteQuery0.release();
            }
        };
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"Preference"}, false, preferenceDao_Impl$20);
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override  // androidx.work.impl.model.PreferenceDao
    public void insertPreference(Preference preference) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPreference.insert(preference);
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

