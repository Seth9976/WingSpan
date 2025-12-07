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

public final class DependencyDao_Impl implements DependencyDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfDependency;

    public DependencyDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfDependency = new EntityInsertionAdapter(__db) {
            public void bind(SupportSQLiteStatement stmt, Dependency value) {
                if(value.getWorkSpecId() == null) {
                    stmt.bindNull(1);
                }
                else {
                    stmt.bindString(1, value.getWorkSpecId());
                }
                if(value.getPrerequisiteId() == null) {
                    stmt.bindNull(2);
                    return;
                }
                stmt.bindString(2, value.getPrerequisiteId());
            }

            @Override  // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, Object value) {
                this.bind(stmt, ((Dependency)value));
            }

            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `Dependency` (`work_spec_id`,`prerequisite_id`) VALUES (?,?)";
            }
        };
    }

    @Override  // androidx.work.impl.model.DependencyDao
    public List getDependentWorkIds(String id) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT work_spec_id FROM dependency WHERE prerequisite_id=?", 1);
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

    @Override  // androidx.work.impl.model.DependencyDao
    public List getPrerequisites(String id) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT prerequisite_id FROM dependency WHERE work_spec_id=?", 1);
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

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override  // androidx.work.impl.model.DependencyDao
    public boolean hasCompletedAllPrerequisites(String id) {
        boolean z = true;
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT COUNT(*)=0 FROM dependency WHERE work_spec_id=? AND prerequisite_id IN (SELECT id FROM workspec WHERE state!=2)", 1);
        if(id == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, id);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z1 = false;
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            if(cursor0.moveToFirst()) {
                if(cursor0.getInt(0) == 0) {
                    z = false;
                }
                z1 = z;
            }
            return z1;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.DependencyDao
    public boolean hasDependents(String id) {
        boolean z = true;
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
        if(id == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, id);
        }
        this.__db.assertNotSuspendingTransaction();
        boolean z1 = false;
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            if(cursor0.moveToFirst()) {
                if(cursor0.getInt(0) == 0) {
                    z = false;
                }
                z1 = z;
            }
            return z1;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.DependencyDao
    public void insertDependency(Dependency dependency) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfDependency.insert(dependency);
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

