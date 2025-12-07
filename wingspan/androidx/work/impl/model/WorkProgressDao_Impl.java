package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;
import java.util.Collections;
import java.util.List;

public final class WorkProgressDao_Impl implements WorkProgressDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfWorkProgress;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

    public WorkProgressDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkProgress = new EntityInsertionAdapter(__db) {
            public void bind(SupportSQLiteStatement stmt, WorkProgress value) {
                if(value.getWorkSpecId() == null) {
                    stmt.bindNull(1);
                }
                else {
                    stmt.bindString(1, value.getWorkSpecId());
                }
                byte[] arr_b = Data.toByteArrayInternal(value.getProgress());
                if(arr_b == null) {
                    stmt.bindNull(2);
                    return;
                }
                stmt.bindBlob(2, arr_b);
            }

            @Override  // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, Object value) {
                this.bind(stmt, ((WorkProgress)value));
            }

            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    @Override  // androidx.work.impl.model.WorkProgressDao
    public void delete(String workSpecId) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfDelete.acquire();
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
            this.__preparedStmtOfDelete.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkProgressDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkProgressDao
    public Data getProgressForWorkSpecId(String workSpecId) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT progress FROM WorkProgress WHERE work_spec_id=?", 1);
        if(workSpecId == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, workSpecId);
        }
        this.__db.assertNotSuspendingTransaction();
        Data data0 = null;
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            if(cursor0.moveToFirst()) {
                byte[] arr_b = cursor0.isNull(0) ? null : cursor0.getBlob(0);
                if(arr_b != null) {
                    data0 = Data.fromByteArray(arr_b);
                }
            }
            return data0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override  // androidx.work.impl.model.WorkProgressDao
    public void insert(WorkProgress progress) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkProgress.insert(progress);
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

