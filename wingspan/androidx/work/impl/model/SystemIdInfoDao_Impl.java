package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfSystemIdInfo;
    private final SharedSQLiteStatement __preparedStmtOfRemoveSystemIdInfo;
    private final SharedSQLiteStatement __preparedStmtOfRemoveSystemIdInfo_1;

    public SystemIdInfoDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfSystemIdInfo = new EntityInsertionAdapter(__db) {
            public void bind(SupportSQLiteStatement stmt, SystemIdInfo value) {
                if(value.workSpecId == null) {
                    stmt.bindNull(1);
                }
                else {
                    stmt.bindString(1, value.workSpecId);
                }
                stmt.bindLong(2, ((long)value.getGeneration()));
                stmt.bindLong(3, ((long)value.systemId));
            }

            @Override  // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, Object value) {
                this.bind(stmt, ((SystemIdInfo)value));
            }

            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`generation`,`system_id`) VALUES (?,?,?)";
            }
        };
        this.__preparedStmtOfRemoveSystemIdInfo = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?";
            }
        };
        this.__preparedStmtOfRemoveSystemIdInfo_1 = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override  // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo getSystemIdInfo(WorkGenerationalId id) {
        return DefaultImpls.getSystemIdInfo(this, id);
    }

    @Override  // androidx.work.impl.model.SystemIdInfoDao
    public SystemIdInfo getSystemIdInfo(String workSpecId, int generation) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", 2);
        if(workSpecId == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, workSpecId);
        }
        roomSQLiteQuery0.bindLong(2, ((long)generation));
        this.__db.assertNotSuspendingTransaction();
        SystemIdInfo systemIdInfo0 = null;
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            int v2 = CursorUtil.getColumnIndexOrThrow(cursor0, "work_spec_id");
            int v3 = CursorUtil.getColumnIndexOrThrow(cursor0, "generation");
            int v4 = CursorUtil.getColumnIndexOrThrow(cursor0, "system_id");
            if(cursor0.moveToFirst()) {
                if(!cursor0.isNull(v2)) {
                    systemIdInfo0 = cursor0.getString(v2);
                }
                systemIdInfo0 = new SystemIdInfo(((String)systemIdInfo0), cursor0.getInt(v3), cursor0.getInt(v4));
            }
            return systemIdInfo0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.SystemIdInfoDao
    public List getWorkSpecIds() {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            List list0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                list0.add((cursor0.isNull(0) ? null : cursor0.getString(0)));
            }
            return list0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.SystemIdInfoDao
    public void insertSystemIdInfo(SystemIdInfo systemIdInfo) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfSystemIdInfo.insert(systemIdInfo);
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override  // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(WorkGenerationalId id) {
        DefaultImpls.removeSystemIdInfo(this, id);
    }

    @Override  // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String workSpecId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfRemoveSystemIdInfo_1.acquire();
        if(workSpecId == null) {
            supportSQLiteStatement0.bindNull(1);
        }
        else {
            supportSQLiteStatement0.bindString(1, workSpecId);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveSystemIdInfo_1.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.SystemIdInfoDao
    public void removeSystemIdInfo(String workSpecId, int generation) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfRemoveSystemIdInfo.acquire();
        if(workSpecId == null) {
            supportSQLiteStatement0.bindNull(1);
        }
        else {
            supportSQLiteStatement0.bindString(1, workSpecId);
        }
        supportSQLiteStatement0.bindLong(2, ((long)generation));
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfRemoveSystemIdInfo.release(supportSQLiteStatement0);
        }
    }
}

