package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class WorkNameDao_Impl implements WorkNameDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfWorkName;

    public WorkNameDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkName = new EntityInsertionAdapter(__db) {
            public void bind(SupportSQLiteStatement stmt, WorkName value) {
                if(value.getName() == null) {
                    stmt.bindNull(1);
                }
                else {
                    stmt.bindString(1, value.getName());
                }
                if(value.getWorkSpecId() == null) {
                    stmt.bindNull(2);
                    return;
                }
                stmt.bindString(2, value.getWorkSpecId());
            }

            @Override  // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, Object value) {
                this.bind(stmt, ((WorkName)value));
            }

            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }
        };
    }

    @Override  // androidx.work.impl.model.WorkNameDao
    public List getNamesForWorkSpecId(String workSpecId) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if(workSpecId == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, workSpecId);
        }
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

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override  // androidx.work.impl.model.WorkNameDao
    public List getWorkSpecIdsWithName(String name) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM workname WHERE name=?", 1);
        if(name == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, name);
        }
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

    @Override  // androidx.work.impl.model.WorkNameDao
    public void insert(WorkName workName) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkName.insert(workName);
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

