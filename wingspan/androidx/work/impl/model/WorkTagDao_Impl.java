package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public final class WorkTagDao_Impl implements WorkTagDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfWorkTag;
    private final SharedSQLiteStatement __preparedStmtOfDeleteByWorkSpecId;

    public WorkTagDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkTag = new EntityInsertionAdapter(__db) {
            public void bind(SupportSQLiteStatement stmt, WorkTag value) {
                if(value.getTag() == null) {
                    stmt.bindNull(1);
                }
                else {
                    stmt.bindString(1, value.getTag());
                }
                if(value.getWorkSpecId() == null) {
                    stmt.bindNull(2);
                    return;
                }
                stmt.bindString(2, value.getWorkSpecId());
            }

            @Override  // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, Object value) {
                this.bind(stmt, ((WorkTag)value));
            }

            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }
        };
        this.__preparedStmtOfDeleteByWorkSpecId = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM worktag WHERE work_spec_id=?";
            }
        };
    }

    @Override  // androidx.work.impl.model.WorkTagDao
    public void deleteByWorkSpecId(String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfDeleteByWorkSpecId.acquire();
        if(id == null) {
            supportSQLiteStatement0.bindNull(1);
        }
        else {
            supportSQLiteStatement0.bindString(1, id);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteByWorkSpecId.release(supportSQLiteStatement0);
        }
    }

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override  // androidx.work.impl.model.WorkTagDao
    public List getTagsForWorkSpecId(String id) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if(id == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, id);
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

    @Override  // androidx.work.impl.model.WorkTagDao
    public List getWorkSpecIdsWithTag(String tag) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM worktag WHERE tag=?", 1);
        if(tag == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, tag);
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

    @Override  // androidx.work.impl.model.WorkTagDao
    public void insert(WorkTag workTag) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkTag.insert(workTag);
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override  // androidx.work.impl.model.WorkTagDao
    public void insertTags(String id, Set tags) {
        DefaultImpls.insertTags(this, id, tags);
    }
}

