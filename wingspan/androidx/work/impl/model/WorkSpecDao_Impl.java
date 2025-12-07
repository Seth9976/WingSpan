package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class WorkSpecDao_Impl implements WorkSpecDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter __insertionAdapterOfWorkSpec;
    private final SharedSQLiteStatement __preparedStmtOfDelete;
    private final SharedSQLiteStatement __preparedStmtOfIncrementGeneration;
    private final SharedSQLiteStatement __preparedStmtOfIncrementPeriodCount;
    private final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    private final SharedSQLiteStatement __preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast;
    private final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    private final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    private final SharedSQLiteStatement __preparedStmtOfSetLastEnqueuedTime;
    private final SharedSQLiteStatement __preparedStmtOfSetOutput;
    private final SharedSQLiteStatement __preparedStmtOfSetState;
    private final EntityDeletionOrUpdateAdapter __updateAdapterOfWorkSpec;

    public WorkSpecDao_Impl(RoomDatabase __db) {
        this.__db = __db;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter(__db) {
            public void bind(SupportSQLiteStatement stmt, WorkSpec value) {
                if(value.id == null) {
                    stmt.bindNull(1);
                }
                else {
                    stmt.bindString(1, value.id);
                }
                stmt.bindLong(2, ((long)WorkTypeConverters.stateToInt(value.state)));
                if(value.workerClassName == null) {
                    stmt.bindNull(3);
                }
                else {
                    stmt.bindString(3, value.workerClassName);
                }
                if(value.inputMergerClassName == null) {
                    stmt.bindNull(4);
                }
                else {
                    stmt.bindString(4, value.inputMergerClassName);
                }
                byte[] arr_b = Data.toByteArrayInternal(value.input);
                if(arr_b == null) {
                    stmt.bindNull(5);
                }
                else {
                    stmt.bindBlob(5, arr_b);
                }
                byte[] arr_b1 = Data.toByteArrayInternal(value.output);
                if(arr_b1 == null) {
                    stmt.bindNull(6);
                }
                else {
                    stmt.bindBlob(6, arr_b1);
                }
                stmt.bindLong(7, value.initialDelay);
                stmt.bindLong(8, value.intervalDuration);
                stmt.bindLong(9, value.flexDuration);
                stmt.bindLong(10, ((long)value.runAttemptCount));
                stmt.bindLong(11, ((long)WorkTypeConverters.backoffPolicyToInt(value.backoffPolicy)));
                stmt.bindLong(12, value.backoffDelayDuration);
                stmt.bindLong(13, value.lastEnqueueTime);
                stmt.bindLong(14, value.minimumRetentionDuration);
                stmt.bindLong(15, value.scheduleRequestedAt);
                stmt.bindLong(16, ((long)value.expedited));
                stmt.bindLong(17, ((long)WorkTypeConverters.outOfQuotaPolicyToInt(value.outOfQuotaPolicy)));
                stmt.bindLong(18, ((long)value.getPeriodCount()));
                stmt.bindLong(19, ((long)value.getGeneration()));
                Constraints constraints0 = value.constraints;
                if(constraints0 != null) {
                    stmt.bindLong(20, ((long)WorkTypeConverters.networkTypeToInt(constraints0.getRequiredNetworkType())));
                    stmt.bindLong(21, ((long)constraints0.requiresCharging()));
                    stmt.bindLong(22, ((long)constraints0.requiresDeviceIdle()));
                    stmt.bindLong(23, ((long)constraints0.requiresBatteryNotLow()));
                    stmt.bindLong(24, ((long)constraints0.requiresStorageNotLow()));
                    stmt.bindLong(25, constraints0.getContentTriggerUpdateDelayMillis());
                    stmt.bindLong(26, constraints0.getContentTriggerMaxDelayMillis());
                    byte[] arr_b2 = WorkTypeConverters.setOfTriggersToByteArray(constraints0.getContentUriTriggers());
                    if(arr_b2 == null) {
                        stmt.bindNull(27);
                        return;
                    }
                    stmt.bindBlob(27, arr_b2);
                    return;
                }
                stmt.bindNull(20);
                stmt.bindNull(21);
                stmt.bindNull(22);
                stmt.bindNull(23);
                stmt.bindNull(24);
                stmt.bindNull(25);
                stmt.bindNull(26);
                stmt.bindNull(27);
            }

            @Override  // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement stmt, Object value) {
                this.bind(stmt, ((WorkSpec)value));
            }

            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`last_enqueue_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`period_count`,`generation`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__updateAdapterOfWorkSpec = new EntityDeletionOrUpdateAdapter(__db) {
            public void bind(SupportSQLiteStatement stmt, WorkSpec value) {
                if(value.id == null) {
                    stmt.bindNull(1);
                }
                else {
                    stmt.bindString(1, value.id);
                }
                stmt.bindLong(2, ((long)WorkTypeConverters.stateToInt(value.state)));
                if(value.workerClassName == null) {
                    stmt.bindNull(3);
                }
                else {
                    stmt.bindString(3, value.workerClassName);
                }
                if(value.inputMergerClassName == null) {
                    stmt.bindNull(4);
                }
                else {
                    stmt.bindString(4, value.inputMergerClassName);
                }
                byte[] arr_b = Data.toByteArrayInternal(value.input);
                if(arr_b == null) {
                    stmt.bindNull(5);
                }
                else {
                    stmt.bindBlob(5, arr_b);
                }
                byte[] arr_b1 = Data.toByteArrayInternal(value.output);
                if(arr_b1 == null) {
                    stmt.bindNull(6);
                }
                else {
                    stmt.bindBlob(6, arr_b1);
                }
                stmt.bindLong(7, value.initialDelay);
                stmt.bindLong(8, value.intervalDuration);
                stmt.bindLong(9, value.flexDuration);
                stmt.bindLong(10, ((long)value.runAttemptCount));
                stmt.bindLong(11, ((long)WorkTypeConverters.backoffPolicyToInt(value.backoffPolicy)));
                stmt.bindLong(12, value.backoffDelayDuration);
                stmt.bindLong(13, value.lastEnqueueTime);
                stmt.bindLong(14, value.minimumRetentionDuration);
                stmt.bindLong(15, value.scheduleRequestedAt);
                stmt.bindLong(16, ((long)value.expedited));
                stmt.bindLong(17, ((long)WorkTypeConverters.outOfQuotaPolicyToInt(value.outOfQuotaPolicy)));
                stmt.bindLong(18, ((long)value.getPeriodCount()));
                stmt.bindLong(19, ((long)value.getGeneration()));
                Constraints constraints0 = value.constraints;
                if(constraints0 == null) {
                    stmt.bindNull(20);
                    stmt.bindNull(21);
                    stmt.bindNull(22);
                    stmt.bindNull(23);
                    stmt.bindNull(24);
                    stmt.bindNull(25);
                    stmt.bindNull(26);
                    stmt.bindNull(27);
                }
                else {
                    stmt.bindLong(20, ((long)WorkTypeConverters.networkTypeToInt(constraints0.getRequiredNetworkType())));
                    stmt.bindLong(21, ((long)constraints0.requiresCharging()));
                    stmt.bindLong(22, ((long)constraints0.requiresDeviceIdle()));
                    stmt.bindLong(23, ((long)constraints0.requiresBatteryNotLow()));
                    stmt.bindLong(24, ((long)constraints0.requiresStorageNotLow()));
                    stmt.bindLong(25, constraints0.getContentTriggerUpdateDelayMillis());
                    stmt.bindLong(26, constraints0.getContentTriggerMaxDelayMillis());
                    byte[] arr_b2 = WorkTypeConverters.setOfTriggersToByteArray(constraints0.getContentUriTriggers());
                    if(arr_b2 == null) {
                        stmt.bindNull(27);
                    }
                    else {
                        stmt.bindBlob(27, arr_b2);
                    }
                }
                if(value.id == null) {
                    stmt.bindNull(28);
                    return;
                }
                stmt.bindString(28, value.id);
            }

            @Override  // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement stmt, Object value) {
                this.bind(stmt, ((WorkSpec)value));
            }

            @Override  // androidx.room.EntityDeletionOrUpdateAdapter
            public String createQuery() {
                return "UPDATE OR ABORT `WorkSpec` SET `id` = ?,`state` = ?,`worker_class_name` = ?,`input_merger_class_name` = ?,`input` = ?,`output` = ?,`initial_delay` = ?,`interval_duration` = ?,`flex_duration` = ?,`run_attempt_count` = ?,`backoff_policy` = ?,`backoff_delay_duration` = ?,`last_enqueue_time` = ?,`minimum_retention_duration` = ?,`schedule_requested_at` = ?,`run_in_foreground` = ?,`out_of_quota_policy` = ?,`period_count` = ?,`generation` = ?,`required_network_type` = ?,`requires_charging` = ?,`requires_device_idle` = ?,`requires_battery_not_low` = ?,`requires_storage_not_low` = ?,`trigger_content_update_delay` = ?,`trigger_max_content_delay` = ?,`content_uri_triggers` = ? WHERE `id` = ?";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetState = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET state=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementPeriodCount = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET period_count=period_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetLastEnqueuedTime = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET last_enqueue_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
        this.__preparedStmtOfIncrementGeneration = new SharedSQLiteStatement(__db) {
            @Override  // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET generation=generation+1 WHERE id=?";
            }
        };
    }

    private void __fetchRelationshipWorkProgressAsandroidxWorkData(ArrayMap _map) {
        byte[] arr_b;
        Set set0 = _map.keySet();
        if(set0.isEmpty()) {
            return;
        }
        if(_map.size() > 999) {
            ArrayMap arrayMap1 = new ArrayMap(999);
            int v = _map.size();
            int v1 = 0;
            int v2 = 0;
            while(v1 < v) {
                arrayMap1.put(((String)_map.keyAt(v1)), ((ArrayList)_map.valueAt(v1)));
                ++v1;
                if(v2 + 1 == 999) {
                    this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
                    arrayMap1 = new ArrayMap(999);
                    v2 = 0;
                }
                else {
                    ++v2;
                }
            }
            if(v2 > 0) {
                this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
            }
            return;
        }
        StringBuilder stringBuilder0 = StringUtil.newStringBuilder();
        stringBuilder0.append("SELECT `progress`,`work_spec_id` FROM `WorkProgress` WHERE `work_spec_id` IN (");
        int v3 = set0.size();
        StringUtil.appendPlaceholders(stringBuilder0, v3);
        stringBuilder0.append(")");
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire(stringBuilder0.toString(), v3);
        int v4 = 1;
        for(Object object0: set0) {
            String s = (String)object0;
            if(s == null) {
                roomSQLiteQuery0.bindNull(v4);
            }
            else {
                roomSQLiteQuery0.bindString(v4, s);
            }
            ++v4;
        }
        try(Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null)) {
            int v5 = CursorUtil.getColumnIndex(cursor0, "work_spec_id");
            if(v5 != -1) {
                while(true) {
                    if(!cursor0.moveToNext()) {
                        break;
                    }
                    ArrayList arrayList0 = (ArrayList)_map.get(cursor0.getString(v5));
                    if(arrayList0 != null) {
                        arr_b = cursor0.isNull(0) ? null : cursor0.getBlob(0);
                        arrayList0.add(Data.fromByteArray(arr_b));
                    }
                }
            }
        }
    }

    private void __fetchRelationshipWorkTagAsjavaLangString(ArrayMap _map) {
        String s1;
        Set set0 = _map.keySet();
        if(set0.isEmpty()) {
            return;
        }
        if(_map.size() > 999) {
            ArrayMap arrayMap1 = new ArrayMap(999);
            int v = _map.size();
            int v1 = 0;
            int v2 = 0;
            while(v1 < v) {
                arrayMap1.put(((String)_map.keyAt(v1)), ((ArrayList)_map.valueAt(v1)));
                ++v1;
                if(v2 + 1 == 999) {
                    this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap1);
                    arrayMap1 = new ArrayMap(999);
                    v2 = 0;
                }
                else {
                    ++v2;
                }
            }
            if(v2 > 0) {
                this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap1);
            }
            return;
        }
        StringBuilder stringBuilder0 = StringUtil.newStringBuilder();
        stringBuilder0.append("SELECT `tag`,`work_spec_id` FROM `WorkTag` WHERE `work_spec_id` IN (");
        int v3 = set0.size();
        StringUtil.appendPlaceholders(stringBuilder0, v3);
        stringBuilder0.append(")");
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire(stringBuilder0.toString(), v3);
        int v4 = 1;
        for(Object object0: set0) {
            String s = (String)object0;
            if(s == null) {
                roomSQLiteQuery0.bindNull(v4);
            }
            else {
                roomSQLiteQuery0.bindString(v4, s);
            }
            ++v4;
        }
        try(Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null)) {
            int v5 = CursorUtil.getColumnIndex(cursor0, "work_spec_id");
            if(v5 != -1) {
                while(true) {
                    if(!cursor0.moveToNext()) {
                        break;
                    }
                    ArrayList arrayList0 = (ArrayList)_map.get(cursor0.getString(v5));
                    if(arrayList0 != null) {
                        s1 = cursor0.isNull(0) ? null : cursor0.getString(0);
                        arrayList0.add(s1);
                    }
                }
            }
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public void delete(String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfDelete.acquire();
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
            this.__preparedStmtOfDelete.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getAllEligibleWorkSpecsForScheduling(int maxLimit) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT ?", 1);
        roomSQLiteQuery0.bindLong(1, ((long)maxLimit));
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            int v2 = CursorUtil.getColumnIndexOrThrow(cursor0, "id");
            int v3 = CursorUtil.getColumnIndexOrThrow(cursor0, "state");
            int v4 = CursorUtil.getColumnIndexOrThrow(cursor0, "worker_class_name");
            int v5 = CursorUtil.getColumnIndexOrThrow(cursor0, "input_merger_class_name");
            int v6 = CursorUtil.getColumnIndexOrThrow(cursor0, "input");
            int v7 = CursorUtil.getColumnIndexOrThrow(cursor0, "output");
            int v8 = CursorUtil.getColumnIndexOrThrow(cursor0, "initial_delay");
            int v9 = CursorUtil.getColumnIndexOrThrow(cursor0, "interval_duration");
            int v10 = CursorUtil.getColumnIndexOrThrow(cursor0, "flex_duration");
            int v11 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_attempt_count");
            int v12 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_policy");
            int v13 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_delay_duration");
            int v14 = CursorUtil.getColumnIndexOrThrow(cursor0, "last_enqueue_time");
            int v15 = CursorUtil.getColumnIndexOrThrow(cursor0, "minimum_retention_duration");
            int v16 = CursorUtil.getColumnIndexOrThrow(cursor0, "schedule_requested_at");
            int v17 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_in_foreground");
            int v18 = CursorUtil.getColumnIndexOrThrow(cursor0, "out_of_quota_policy");
            int v19 = CursorUtil.getColumnIndexOrThrow(cursor0, "period_count");
            int v20 = CursorUtil.getColumnIndexOrThrow(cursor0, "generation");
            int v21 = CursorUtil.getColumnIndexOrThrow(cursor0, "required_network_type");
            int v22 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_charging");
            int v23 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_device_idle");
            int v24 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_battery_not_low");
            int v25 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_storage_not_low");
            int v26 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_content_update_delay");
            int v27 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_max_content_delay");
            int v28 = CursorUtil.getColumnIndexOrThrow(cursor0, "content_uri_triggers");
            List list0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s = cursor0.isNull(v2) ? null : cursor0.getString(v2);
                State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(v3));
                String s1 = cursor0.isNull(v4) ? null : cursor0.getString(v4);
                String s2 = cursor0.isNull(v5) ? null : cursor0.getString(v5);
                Data data0 = Data.fromByteArray((cursor0.isNull(v6) ? null : cursor0.getBlob(v6)));
                Data data1 = Data.fromByteArray((cursor0.isNull(v7) ? null : cursor0.getBlob(v7)));
                long v29 = cursor0.getLong(v8);
                long v30 = cursor0.getLong(v9);
                long v31 = cursor0.getLong(v10);
                int v32 = cursor0.getInt(v11);
                BackoffPolicy backoffPolicy0 = WorkTypeConverters.intToBackoffPolicy(cursor0.getInt(v12));
                long v33 = cursor0.getLong(v13);
                long v34 = cursor0.getLong(v14);
                long v35 = cursor0.getLong(v15);
                long v36 = cursor0.getLong(v16);
                boolean z = cursor0.getInt(v17) != 0;
                OutOfQuotaPolicy outOfQuotaPolicy0 = WorkTypeConverters.intToOutOfQuotaPolicy(cursor0.getInt(v18));
                int v37 = cursor0.getInt(v19);
                int v38 = cursor0.getInt(v20);
                list0.add(new WorkSpec(s, workInfo$State0, s1, s2, data0, data1, v29, v30, v31, new Constraints(WorkTypeConverters.intToNetworkType(cursor0.getInt(v21)), cursor0.getInt(v22) != 0, cursor0.getInt(v23) != 0, cursor0.getInt(v24) != 0, cursor0.getInt(v25) != 0, cursor0.getLong(v26), cursor0.getLong(v27), WorkTypeConverters.byteArrayToSetOfTriggers((cursor0.isNull(v28) ? null : cursor0.getBlob(v28)))), v32, backoffPolicy0, v33, v34, v35, v36, z, outOfQuotaPolicy0, v37, v38));
            }
            return list0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getAllUnfinishedWork() {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
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

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getAllWorkSpecIds() {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0);
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

    @Override  // androidx.work.impl.model.WorkSpecDao
    public LiveData getAllWorkSpecIdsLiveData() {
        androidx.work.impl.model.WorkSpecDao_Impl.14 workSpecDao_Impl$140 = new Callable() {
            @Override
            public Object call() throws Exception {
                return this.call();
            }

            public List call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursor0 = DBUtil.query(WorkSpecDao_Impl.this.__db, RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0), false, null);
                    try {
                        List list0 = new ArrayList(cursor0.getCount());
                        while(cursor0.moveToNext()) {
                            list0.add((cursor0.isNull(0) ? null : cursor0.getString(0)));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return list0;
                    }
                    finally {
                        cursor0.close();
                    }
                }
                finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            @Override
            protected void finalize() {
                RoomSQLiteQuery.acquire("SELECT id FROM workspec", 0).release();
            }
        };
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, true, workSpecDao_Impl$140);
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getEligibleWorkForScheduling(int schedulerLimit) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        roomSQLiteQuery0.bindLong(1, ((long)schedulerLimit));
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            int v2 = CursorUtil.getColumnIndexOrThrow(cursor0, "id");
            int v3 = CursorUtil.getColumnIndexOrThrow(cursor0, "state");
            int v4 = CursorUtil.getColumnIndexOrThrow(cursor0, "worker_class_name");
            int v5 = CursorUtil.getColumnIndexOrThrow(cursor0, "input_merger_class_name");
            int v6 = CursorUtil.getColumnIndexOrThrow(cursor0, "input");
            int v7 = CursorUtil.getColumnIndexOrThrow(cursor0, "output");
            int v8 = CursorUtil.getColumnIndexOrThrow(cursor0, "initial_delay");
            int v9 = CursorUtil.getColumnIndexOrThrow(cursor0, "interval_duration");
            int v10 = CursorUtil.getColumnIndexOrThrow(cursor0, "flex_duration");
            int v11 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_attempt_count");
            int v12 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_policy");
            int v13 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_delay_duration");
            int v14 = CursorUtil.getColumnIndexOrThrow(cursor0, "last_enqueue_time");
            int v15 = CursorUtil.getColumnIndexOrThrow(cursor0, "minimum_retention_duration");
            int v16 = CursorUtil.getColumnIndexOrThrow(cursor0, "schedule_requested_at");
            int v17 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_in_foreground");
            int v18 = CursorUtil.getColumnIndexOrThrow(cursor0, "out_of_quota_policy");
            int v19 = CursorUtil.getColumnIndexOrThrow(cursor0, "period_count");
            int v20 = CursorUtil.getColumnIndexOrThrow(cursor0, "generation");
            int v21 = CursorUtil.getColumnIndexOrThrow(cursor0, "required_network_type");
            int v22 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_charging");
            int v23 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_device_idle");
            int v24 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_battery_not_low");
            int v25 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_storage_not_low");
            int v26 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_content_update_delay");
            int v27 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_max_content_delay");
            int v28 = CursorUtil.getColumnIndexOrThrow(cursor0, "content_uri_triggers");
            List list0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s = cursor0.isNull(v2) ? null : cursor0.getString(v2);
                State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(v3));
                String s1 = cursor0.isNull(v4) ? null : cursor0.getString(v4);
                String s2 = cursor0.isNull(v5) ? null : cursor0.getString(v5);
                Data data0 = Data.fromByteArray((cursor0.isNull(v6) ? null : cursor0.getBlob(v6)));
                Data data1 = Data.fromByteArray((cursor0.isNull(v7) ? null : cursor0.getBlob(v7)));
                long v29 = cursor0.getLong(v8);
                long v30 = cursor0.getLong(v9);
                long v31 = cursor0.getLong(v10);
                int v32 = cursor0.getInt(v11);
                BackoffPolicy backoffPolicy0 = WorkTypeConverters.intToBackoffPolicy(cursor0.getInt(v12));
                long v33 = cursor0.getLong(v13);
                long v34 = cursor0.getLong(v14);
                long v35 = cursor0.getLong(v15);
                long v36 = cursor0.getLong(v16);
                boolean z = cursor0.getInt(v17) != 0;
                OutOfQuotaPolicy outOfQuotaPolicy0 = WorkTypeConverters.intToOutOfQuotaPolicy(cursor0.getInt(v18));
                int v37 = cursor0.getInt(v19);
                int v38 = cursor0.getInt(v20);
                list0.add(new WorkSpec(s, workInfo$State0, s1, s2, data0, data1, v29, v30, v31, new Constraints(WorkTypeConverters.intToNetworkType(cursor0.getInt(v21)), cursor0.getInt(v22) != 0, cursor0.getInt(v23) != 0, cursor0.getInt(v24) != 0, cursor0.getInt(v25) != 0, cursor0.getLong(v26), cursor0.getLong(v27), WorkTypeConverters.byteArrayToSetOfTriggers((cursor0.isNull(v28) ? null : cursor0.getBlob(v28)))), v32, backoffPolicy0, v33, v34, v35, v36, z, outOfQuotaPolicy0, v37, v38));
            }
            return list0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getInputsFromPrerequisites(String id) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
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
                list0.add(Data.fromByteArray((cursor0.isNull(0) ? null : cursor0.getBlob(0))));
            }
            return list0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getRecentlyCompletedWork(long startingAt) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE last_enqueue_time >= ? AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC", 1);
        roomSQLiteQuery0.bindLong(1, startingAt);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            int v2 = CursorUtil.getColumnIndexOrThrow(cursor0, "id");
            int v3 = CursorUtil.getColumnIndexOrThrow(cursor0, "state");
            int v4 = CursorUtil.getColumnIndexOrThrow(cursor0, "worker_class_name");
            int v5 = CursorUtil.getColumnIndexOrThrow(cursor0, "input_merger_class_name");
            int v6 = CursorUtil.getColumnIndexOrThrow(cursor0, "input");
            int v7 = CursorUtil.getColumnIndexOrThrow(cursor0, "output");
            int v8 = CursorUtil.getColumnIndexOrThrow(cursor0, "initial_delay");
            int v9 = CursorUtil.getColumnIndexOrThrow(cursor0, "interval_duration");
            int v10 = CursorUtil.getColumnIndexOrThrow(cursor0, "flex_duration");
            int v11 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_attempt_count");
            int v12 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_policy");
            int v13 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_delay_duration");
            int v14 = CursorUtil.getColumnIndexOrThrow(cursor0, "last_enqueue_time");
            int v15 = CursorUtil.getColumnIndexOrThrow(cursor0, "minimum_retention_duration");
            int v16 = CursorUtil.getColumnIndexOrThrow(cursor0, "schedule_requested_at");
            int v17 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_in_foreground");
            int v18 = CursorUtil.getColumnIndexOrThrow(cursor0, "out_of_quota_policy");
            int v19 = CursorUtil.getColumnIndexOrThrow(cursor0, "period_count");
            int v20 = CursorUtil.getColumnIndexOrThrow(cursor0, "generation");
            int v21 = CursorUtil.getColumnIndexOrThrow(cursor0, "required_network_type");
            int v22 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_charging");
            int v23 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_device_idle");
            int v24 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_battery_not_low");
            int v25 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_storage_not_low");
            int v26 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_content_update_delay");
            int v27 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_max_content_delay");
            int v28 = CursorUtil.getColumnIndexOrThrow(cursor0, "content_uri_triggers");
            List list0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s = cursor0.isNull(v2) ? null : cursor0.getString(v2);
                State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(v3));
                String s1 = cursor0.isNull(v4) ? null : cursor0.getString(v4);
                String s2 = cursor0.isNull(v5) ? null : cursor0.getString(v5);
                Data data0 = Data.fromByteArray((cursor0.isNull(v6) ? null : cursor0.getBlob(v6)));
                Data data1 = Data.fromByteArray((cursor0.isNull(v7) ? null : cursor0.getBlob(v7)));
                long v29 = cursor0.getLong(v8);
                long v30 = cursor0.getLong(v9);
                long v31 = cursor0.getLong(v10);
                int v32 = cursor0.getInt(v11);
                BackoffPolicy backoffPolicy0 = WorkTypeConverters.intToBackoffPolicy(cursor0.getInt(v12));
                long v33 = cursor0.getLong(v13);
                long v34 = cursor0.getLong(v14);
                long v35 = cursor0.getLong(v15);
                long v36 = cursor0.getLong(v16);
                boolean z = cursor0.getInt(v17) != 0;
                OutOfQuotaPolicy outOfQuotaPolicy0 = WorkTypeConverters.intToOutOfQuotaPolicy(cursor0.getInt(v18));
                int v37 = cursor0.getInt(v19);
                int v38 = cursor0.getInt(v20);
                list0.add(new WorkSpec(s, workInfo$State0, s1, s2, data0, data1, v29, v30, v31, new Constraints(WorkTypeConverters.intToNetworkType(cursor0.getInt(v21)), cursor0.getInt(v22) != 0, cursor0.getInt(v23) != 0, cursor0.getInt(v24) != 0, cursor0.getInt(v25) != 0, cursor0.getLong(v26), cursor0.getLong(v27), WorkTypeConverters.byteArrayToSetOfTriggers((cursor0.isNull(v28) ? null : cursor0.getBlob(v28)))), v32, backoffPolicy0, v33, v34, v35, v36, z, outOfQuotaPolicy0, v37, v38));
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

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            int v1 = CursorUtil.getColumnIndexOrThrow(cursor0, "id");
            int v2 = CursorUtil.getColumnIndexOrThrow(cursor0, "state");
            int v3 = CursorUtil.getColumnIndexOrThrow(cursor0, "worker_class_name");
            int v4 = CursorUtil.getColumnIndexOrThrow(cursor0, "input_merger_class_name");
            int v5 = CursorUtil.getColumnIndexOrThrow(cursor0, "input");
            int v6 = CursorUtil.getColumnIndexOrThrow(cursor0, "output");
            int v7 = CursorUtil.getColumnIndexOrThrow(cursor0, "initial_delay");
            int v8 = CursorUtil.getColumnIndexOrThrow(cursor0, "interval_duration");
            int v9 = CursorUtil.getColumnIndexOrThrow(cursor0, "flex_duration");
            int v10 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_attempt_count");
            int v11 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_policy");
            int v12 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_delay_duration");
            int v13 = CursorUtil.getColumnIndexOrThrow(cursor0, "last_enqueue_time");
            int v14 = CursorUtil.getColumnIndexOrThrow(cursor0, "minimum_retention_duration");
            int v15 = CursorUtil.getColumnIndexOrThrow(cursor0, "schedule_requested_at");
            int v16 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_in_foreground");
            int v17 = CursorUtil.getColumnIndexOrThrow(cursor0, "out_of_quota_policy");
            int v18 = CursorUtil.getColumnIndexOrThrow(cursor0, "period_count");
            int v19 = CursorUtil.getColumnIndexOrThrow(cursor0, "generation");
            int v20 = CursorUtil.getColumnIndexOrThrow(cursor0, "required_network_type");
            int v21 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_charging");
            int v22 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_device_idle");
            int v23 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_battery_not_low");
            int v24 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_storage_not_low");
            int v25 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_content_update_delay");
            int v26 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_max_content_delay");
            int v27 = CursorUtil.getColumnIndexOrThrow(cursor0, "content_uri_triggers");
            List list0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s = cursor0.isNull(v1) ? null : cursor0.getString(v1);
                State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(v2));
                String s1 = cursor0.isNull(v3) ? null : cursor0.getString(v3);
                String s2 = cursor0.isNull(v4) ? null : cursor0.getString(v4);
                Data data0 = Data.fromByteArray((cursor0.isNull(v5) ? null : cursor0.getBlob(v5)));
                Data data1 = Data.fromByteArray((cursor0.isNull(v6) ? null : cursor0.getBlob(v6)));
                long v28 = cursor0.getLong(v7);
                long v29 = cursor0.getLong(v8);
                long v30 = cursor0.getLong(v9);
                int v31 = cursor0.getInt(v10);
                BackoffPolicy backoffPolicy0 = WorkTypeConverters.intToBackoffPolicy(cursor0.getInt(v11));
                long v32 = cursor0.getLong(v12);
                long v33 = cursor0.getLong(v13);
                long v34 = cursor0.getLong(v14);
                long v35 = cursor0.getLong(v15);
                boolean z = cursor0.getInt(v16) != 0;
                OutOfQuotaPolicy outOfQuotaPolicy0 = WorkTypeConverters.intToOutOfQuotaPolicy(cursor0.getInt(v17));
                int v36 = cursor0.getInt(v18);
                int v37 = cursor0.getInt(v19);
                list0.add(new WorkSpec(s, workInfo$State0, s1, s2, data0, data1, v28, v29, v30, new Constraints(WorkTypeConverters.intToNetworkType(cursor0.getInt(v20)), cursor0.getInt(v21) != 0, cursor0.getInt(v22) != 0, cursor0.getInt(v23) != 0, cursor0.getInt(v24) != 0, cursor0.getLong(v25), cursor0.getLong(v26), WorkTypeConverters.byteArrayToSetOfTriggers((cursor0.isNull(v27) ? null : cursor0.getBlob(v27)))), v31, backoffPolicy0, v32, v33, v34, v35, z, outOfQuotaPolicy0, v36, v37));
            }
            return list0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public LiveData getScheduleRequestedAtLiveData(String id) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT schedule_requested_at FROM workspec WHERE id=?", 1);
        if(id == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, id);
        }
        androidx.work.impl.model.WorkSpecDao_Impl.18 workSpecDao_Impl$180 = new Callable() {
            public Long call() throws Exception {
                try(Cursor cursor0 = DBUtil.query(WorkSpecDao_Impl.this.__db, roomSQLiteQuery0, false, null)) {
                    return cursor0.moveToFirst() ? cursor0.getLong(0) : 0L;
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
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"workspec"}, false, workSpecDao_Impl$180);
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            int v1 = CursorUtil.getColumnIndexOrThrow(cursor0, "id");
            int v2 = CursorUtil.getColumnIndexOrThrow(cursor0, "state");
            int v3 = CursorUtil.getColumnIndexOrThrow(cursor0, "worker_class_name");
            int v4 = CursorUtil.getColumnIndexOrThrow(cursor0, "input_merger_class_name");
            int v5 = CursorUtil.getColumnIndexOrThrow(cursor0, "input");
            int v6 = CursorUtil.getColumnIndexOrThrow(cursor0, "output");
            int v7 = CursorUtil.getColumnIndexOrThrow(cursor0, "initial_delay");
            int v8 = CursorUtil.getColumnIndexOrThrow(cursor0, "interval_duration");
            int v9 = CursorUtil.getColumnIndexOrThrow(cursor0, "flex_duration");
            int v10 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_attempt_count");
            int v11 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_policy");
            int v12 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_delay_duration");
            int v13 = CursorUtil.getColumnIndexOrThrow(cursor0, "last_enqueue_time");
            int v14 = CursorUtil.getColumnIndexOrThrow(cursor0, "minimum_retention_duration");
            int v15 = CursorUtil.getColumnIndexOrThrow(cursor0, "schedule_requested_at");
            int v16 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_in_foreground");
            int v17 = CursorUtil.getColumnIndexOrThrow(cursor0, "out_of_quota_policy");
            int v18 = CursorUtil.getColumnIndexOrThrow(cursor0, "period_count");
            int v19 = CursorUtil.getColumnIndexOrThrow(cursor0, "generation");
            int v20 = CursorUtil.getColumnIndexOrThrow(cursor0, "required_network_type");
            int v21 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_charging");
            int v22 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_device_idle");
            int v23 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_battery_not_low");
            int v24 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_storage_not_low");
            int v25 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_content_update_delay");
            int v26 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_max_content_delay");
            int v27 = CursorUtil.getColumnIndexOrThrow(cursor0, "content_uri_triggers");
            List list0 = new ArrayList(cursor0.getCount());
            while(cursor0.moveToNext()) {
                String s = cursor0.isNull(v1) ? null : cursor0.getString(v1);
                State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(v2));
                String s1 = cursor0.isNull(v3) ? null : cursor0.getString(v3);
                String s2 = cursor0.isNull(v4) ? null : cursor0.getString(v4);
                Data data0 = Data.fromByteArray((cursor0.isNull(v5) ? null : cursor0.getBlob(v5)));
                Data data1 = Data.fromByteArray((cursor0.isNull(v6) ? null : cursor0.getBlob(v6)));
                long v28 = cursor0.getLong(v7);
                long v29 = cursor0.getLong(v8);
                long v30 = cursor0.getLong(v9);
                int v31 = cursor0.getInt(v10);
                BackoffPolicy backoffPolicy0 = WorkTypeConverters.intToBackoffPolicy(cursor0.getInt(v11));
                long v32 = cursor0.getLong(v12);
                long v33 = cursor0.getLong(v13);
                long v34 = cursor0.getLong(v14);
                long v35 = cursor0.getLong(v15);
                boolean z = cursor0.getInt(v16) != 0;
                OutOfQuotaPolicy outOfQuotaPolicy0 = WorkTypeConverters.intToOutOfQuotaPolicy(cursor0.getInt(v17));
                int v36 = cursor0.getInt(v18);
                int v37 = cursor0.getInt(v19);
                list0.add(new WorkSpec(s, workInfo$State0, s1, s2, data0, data1, v28, v29, v30, new Constraints(WorkTypeConverters.intToNetworkType(cursor0.getInt(v20)), cursor0.getInt(v21) != 0, cursor0.getInt(v22) != 0, cursor0.getInt(v23) != 0, cursor0.getInt(v24) != 0, cursor0.getLong(v25), cursor0.getLong(v26), WorkTypeConverters.byteArrayToSetOfTriggers((cursor0.isNull(v27) ? null : cursor0.getBlob(v27)))), v31, backoffPolicy0, v32, v33, v34, v35, z, outOfQuotaPolicy0, v36, v37));
            }
            return list0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public State getState(String id) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if(id == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, id);
        }
        this.__db.assertNotSuspendingTransaction();
        State workInfo$State0 = null;
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            if(cursor0.moveToFirst()) {
                Integer integer0 = cursor0.isNull(0) ? null : cursor0.getInt(0);
                if(integer0 != null) {
                    workInfo$State0 = WorkTypeConverters.intToState(((int)integer0));
                }
            }
            return workInfo$State0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getUnfinishedWorkWithName(String name) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
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

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getUnfinishedWorkWithTag(String tag) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
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

    @Override  // androidx.work.impl.model.WorkSpecDao
    public WorkSpec getWorkSpec(String id) {
        WorkSpec workSpec0;
        boolean z4;
        int v42;
        boolean z3;
        int v41;
        boolean z2;
        int v40;
        boolean z1;
        int v39;
        boolean z;
        int v36;
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT * FROM workspec WHERE id=?", 1);
        if(id == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, id);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            int v1 = CursorUtil.getColumnIndexOrThrow(cursor0, "id");
            int v2 = CursorUtil.getColumnIndexOrThrow(cursor0, "state");
            int v3 = CursorUtil.getColumnIndexOrThrow(cursor0, "worker_class_name");
            int v4 = CursorUtil.getColumnIndexOrThrow(cursor0, "input_merger_class_name");
            int v5 = CursorUtil.getColumnIndexOrThrow(cursor0, "input");
            int v6 = CursorUtil.getColumnIndexOrThrow(cursor0, "output");
            int v7 = CursorUtil.getColumnIndexOrThrow(cursor0, "initial_delay");
            int v8 = CursorUtil.getColumnIndexOrThrow(cursor0, "interval_duration");
            int v9 = CursorUtil.getColumnIndexOrThrow(cursor0, "flex_duration");
            int v10 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_attempt_count");
            int v11 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_policy");
            int v12 = CursorUtil.getColumnIndexOrThrow(cursor0, "backoff_delay_duration");
            int v13 = CursorUtil.getColumnIndexOrThrow(cursor0, "last_enqueue_time");
            int v14 = CursorUtil.getColumnIndexOrThrow(cursor0, "minimum_retention_duration");
            int v15 = CursorUtil.getColumnIndexOrThrow(cursor0, "schedule_requested_at");
            int v16 = CursorUtil.getColumnIndexOrThrow(cursor0, "run_in_foreground");
            int v17 = CursorUtil.getColumnIndexOrThrow(cursor0, "out_of_quota_policy");
            int v18 = CursorUtil.getColumnIndexOrThrow(cursor0, "period_count");
            int v19 = CursorUtil.getColumnIndexOrThrow(cursor0, "generation");
            int v20 = CursorUtil.getColumnIndexOrThrow(cursor0, "required_network_type");
            int v21 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_charging");
            int v22 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_device_idle");
            int v23 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_battery_not_low");
            int v24 = CursorUtil.getColumnIndexOrThrow(cursor0, "requires_storage_not_low");
            int v25 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_content_update_delay");
            int v26 = CursorUtil.getColumnIndexOrThrow(cursor0, "trigger_max_content_delay");
            int v27 = CursorUtil.getColumnIndexOrThrow(cursor0, "content_uri_triggers");
            if(cursor0.moveToFirst()) {
                String s1 = cursor0.isNull(v1) ? null : cursor0.getString(v1);
                State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(v2));
                String s2 = cursor0.isNull(v3) ? null : cursor0.getString(v3);
                String s3 = cursor0.isNull(v4) ? null : cursor0.getString(v4);
                Data data0 = Data.fromByteArray((cursor0.isNull(v5) ? null : cursor0.getBlob(v5)));
                Data data1 = Data.fromByteArray((cursor0.isNull(v6) ? null : cursor0.getBlob(v6)));
                long v28 = cursor0.getLong(v7);
                long v29 = cursor0.getLong(v8);
                long v30 = cursor0.getLong(v9);
                int v31 = cursor0.getInt(v10);
                BackoffPolicy backoffPolicy0 = WorkTypeConverters.intToBackoffPolicy(cursor0.getInt(v11));
                long v32 = cursor0.getLong(v12);
                long v33 = cursor0.getLong(v13);
                long v34 = cursor0.getLong(v14);
                long v35 = cursor0.getLong(v15);
                if(cursor0.getInt(v16) == 0) {
                    v36 = v17;
                    z = false;
                }
                else {
                    v36 = v17;
                    z = true;
                }
                OutOfQuotaPolicy outOfQuotaPolicy0 = WorkTypeConverters.intToOutOfQuotaPolicy(cursor0.getInt(v36));
                int v37 = cursor0.getInt(v18);
                int v38 = cursor0.getInt(v19);
                NetworkType networkType0 = WorkTypeConverters.intToNetworkType(cursor0.getInt(v20));
                if(cursor0.getInt(v21) == 0) {
                    v39 = v22;
                    z1 = false;
                }
                else {
                    v39 = v22;
                    z1 = true;
                }
                if(cursor0.getInt(v39) == 0) {
                    v40 = v23;
                    z2 = false;
                }
                else {
                    v40 = v23;
                    z2 = true;
                }
                if(cursor0.getInt(v40) == 0) {
                    v41 = v24;
                    z3 = false;
                }
                else {
                    v41 = v24;
                    z3 = true;
                }
                if(cursor0.getInt(v41) == 0) {
                    v42 = v25;
                    z4 = false;
                }
                else {
                    v42 = v25;
                    z4 = true;
                }
                workSpec0 = new WorkSpec(s1, workInfo$State0, s2, s3, data0, data1, v28, v29, v30, new Constraints(networkType0, z1, z2, z3, z4, cursor0.getLong(v42), cursor0.getLong(v26), WorkTypeConverters.byteArrayToSetOfTriggers((cursor0.isNull(v27) ? null : cursor0.getBlob(v27)))), v31, backoffPolicy0, v32, v33, v34, v35, z, outOfQuotaPolicy0, v37, v38);
            }
            else {
                workSpec0 = null;
            }
            return workSpec0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getWorkSpecIdAndStatesForName(String name) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
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
                list0.add(new IdAndState((cursor0.isNull(0) ? null : cursor0.getString(0)), WorkTypeConverters.intToState(cursor0.getInt(1))));
            }
            return list0;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public WorkInfoPojo getWorkStatusPojoForId(String id) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id=?", 1);
        if(id == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, id);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            WorkInfoPojo workSpec$WorkInfoPojo0 = null;
            Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, true, null);
            try {
                ArrayMap arrayMap0 = new ArrayMap();
                ArrayMap arrayMap1 = new ArrayMap();
                while(cursor0.moveToNext()) {
                    String s1 = cursor0.getString(0);
                    if(((ArrayList)arrayMap0.get(s1)) == null) {
                        arrayMap0.put(s1, new ArrayList());
                    }
                    String s2 = cursor0.getString(0);
                    if(((ArrayList)arrayMap1.get(s2)) == null) {
                        arrayMap1.put(s2, new ArrayList());
                    }
                }
                cursor0.moveToPosition(-1);
                this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap0);
                this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
                if(cursor0.moveToFirst()) {
                    String s3 = cursor0.isNull(0) ? null : cursor0.getString(0);
                    State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(1));
                    if(!cursor0.isNull(2)) {
                        workSpec$WorkInfoPojo0 = cursor0.getBlob(2);
                    }
                    Data data0 = Data.fromByteArray(((byte[])workSpec$WorkInfoPojo0));
                    int v2 = cursor0.getInt(3);
                    int v3 = cursor0.getInt(4);
                    ArrayList arrayList0 = (ArrayList)arrayMap0.get(cursor0.getString(0));
                    if(arrayList0 == null) {
                        arrayList0 = new ArrayList();
                    }
                    ArrayList arrayList1 = (ArrayList)arrayMap1.get(cursor0.getString(0));
                    if(arrayList1 == null) {
                        arrayList1 = new ArrayList();
                    }
                    workSpec$WorkInfoPojo0 = new WorkInfoPojo(s3, workInfo$State0, data0, v2, v3, arrayList0, arrayList1);
                }
                this.__db.setTransactionSuccessful();
                return workSpec$WorkInfoPojo0;
            }
            finally {
                cursor0.close();
                roomSQLiteQuery0.release();
            }
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getWorkStatusPojoForIds(List ids) {
        StringBuilder stringBuilder0 = StringUtil.newStringBuilder();
        stringBuilder0.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int v = ids.size();
        StringUtil.appendPlaceholders(stringBuilder0, v);
        stringBuilder0.append(")");
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire(stringBuilder0.toString(), v);
        int v1 = 1;
        for(Object object0: ids) {
            String s = (String)object0;
            if(s == null) {
                roomSQLiteQuery0.bindNull(v1);
            }
            else {
                roomSQLiteQuery0.bindString(v1, s);
            }
            ++v1;
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, true, null);
            try {
                ArrayMap arrayMap0 = new ArrayMap();
                ArrayMap arrayMap1 = new ArrayMap();
                while(cursor0.moveToNext()) {
                    String s1 = cursor0.getString(0);
                    if(((ArrayList)arrayMap0.get(s1)) == null) {
                        arrayMap0.put(s1, new ArrayList());
                    }
                    String s2 = cursor0.getString(0);
                    if(((ArrayList)arrayMap1.get(s2)) == null) {
                        arrayMap1.put(s2, new ArrayList());
                    }
                }
                cursor0.moveToPosition(-1);
                this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap0);
                this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
                List list1 = new ArrayList(cursor0.getCount());
                while(cursor0.moveToNext()) {
                    String s3 = cursor0.isNull(0) ? null : cursor0.getString(0);
                    State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(1));
                    Data data0 = Data.fromByteArray((cursor0.isNull(2) ? null : cursor0.getBlob(2)));
                    int v4 = cursor0.getInt(3);
                    int v5 = cursor0.getInt(4);
                    ArrayList arrayList0 = (ArrayList)arrayMap0.get(cursor0.getString(0));
                    if(arrayList0 == null) {
                        arrayList0 = new ArrayList();
                    }
                    ArrayList arrayList1 = (ArrayList)arrayMap1.get(cursor0.getString(0));
                    if(arrayList1 == null) {
                        arrayList1 = new ArrayList();
                    }
                    list1.add(new WorkInfoPojo(s3, workInfo$State0, data0, v4, v5, arrayList0, arrayList1));
                }
                this.__db.setTransactionSuccessful();
                return list1;
            }
            finally {
                cursor0.close();
                roomSQLiteQuery0.release();
            }
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getWorkStatusPojoForName(String name) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if(name == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, name);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, true, null);
            try {
                ArrayMap arrayMap0 = new ArrayMap();
                ArrayMap arrayMap1 = new ArrayMap();
                while(cursor0.moveToNext()) {
                    String s1 = cursor0.getString(0);
                    if(((ArrayList)arrayMap0.get(s1)) == null) {
                        arrayMap0.put(s1, new ArrayList());
                    }
                    String s2 = cursor0.getString(0);
                    if(((ArrayList)arrayMap1.get(s2)) == null) {
                        arrayMap1.put(s2, new ArrayList());
                    }
                }
                cursor0.moveToPosition(-1);
                this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap0);
                this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
                List list0 = new ArrayList(cursor0.getCount());
                while(cursor0.moveToNext()) {
                    String s3 = cursor0.isNull(0) ? null : cursor0.getString(0);
                    State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(1));
                    Data data0 = Data.fromByteArray((cursor0.isNull(2) ? null : cursor0.getBlob(2)));
                    int v2 = cursor0.getInt(3);
                    int v3 = cursor0.getInt(4);
                    ArrayList arrayList0 = (ArrayList)arrayMap0.get(cursor0.getString(0));
                    if(arrayList0 == null) {
                        arrayList0 = new ArrayList();
                    }
                    ArrayList arrayList1 = (ArrayList)arrayMap1.get(cursor0.getString(0));
                    if(arrayList1 == null) {
                        arrayList1 = new ArrayList();
                    }
                    list0.add(new WorkInfoPojo(s3, workInfo$State0, data0, v2, v3, arrayList0, arrayList1));
                }
                this.__db.setTransactionSuccessful();
                return list0;
            }
            finally {
                cursor0.close();
                roomSQLiteQuery0.release();
            }
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public List getWorkStatusPojoForTag(String tag) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if(tag == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, tag);
        }
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, true, null);
            try {
                ArrayMap arrayMap0 = new ArrayMap();
                ArrayMap arrayMap1 = new ArrayMap();
                while(cursor0.moveToNext()) {
                    String s1 = cursor0.getString(0);
                    if(((ArrayList)arrayMap0.get(s1)) == null) {
                        arrayMap0.put(s1, new ArrayList());
                    }
                    String s2 = cursor0.getString(0);
                    if(((ArrayList)arrayMap1.get(s2)) == null) {
                        arrayMap1.put(s2, new ArrayList());
                    }
                }
                cursor0.moveToPosition(-1);
                this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap0);
                this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
                List list0 = new ArrayList(cursor0.getCount());
                while(cursor0.moveToNext()) {
                    String s3 = cursor0.isNull(0) ? null : cursor0.getString(0);
                    State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(1));
                    Data data0 = Data.fromByteArray((cursor0.isNull(2) ? null : cursor0.getBlob(2)));
                    int v2 = cursor0.getInt(3);
                    int v3 = cursor0.getInt(4);
                    ArrayList arrayList0 = (ArrayList)arrayMap0.get(cursor0.getString(0));
                    if(arrayList0 == null) {
                        arrayList0 = new ArrayList();
                    }
                    ArrayList arrayList1 = (ArrayList)arrayMap1.get(cursor0.getString(0));
                    if(arrayList1 == null) {
                        arrayList1 = new ArrayList();
                    }
                    list0.add(new WorkInfoPojo(s3, workInfo$State0, data0, v2, v3, arrayList0, arrayList1));
                }
                this.__db.setTransactionSuccessful();
                return list0;
            }
            finally {
                cursor0.close();
                roomSQLiteQuery0.release();
            }
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public LiveData getWorkStatusPojoLiveDataForIds(List ids) {
        StringBuilder stringBuilder0 = StringUtil.newStringBuilder();
        stringBuilder0.append("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (");
        int v = ids.size();
        StringUtil.appendPlaceholders(stringBuilder0, v);
        stringBuilder0.append(")");
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire(stringBuilder0.toString(), v);
        int v1 = 1;
        for(Object object0: ids) {
            String s = (String)object0;
            if(s == null) {
                roomSQLiteQuery0.bindNull(v1);
            }
            else {
                roomSQLiteQuery0.bindString(v1, s);
            }
            ++v1;
        }
        androidx.work.impl.model.WorkSpecDao_Impl.15 workSpecDao_Impl$150 = new Callable() {
            @Override
            public Object call() throws Exception {
                return this.call();
            }

            public List call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursor0 = DBUtil.query(WorkSpecDao_Impl.this.__db, roomSQLiteQuery0, true, null);
                    try {
                        ArrayMap arrayMap0 = new ArrayMap();
                        ArrayMap arrayMap1 = new ArrayMap();
                        while(cursor0.moveToNext()) {
                            String s = cursor0.getString(0);
                            if(((ArrayList)arrayMap0.get(s)) == null) {
                                arrayMap0.put(s, new ArrayList());
                            }
                            String s1 = cursor0.getString(0);
                            if(((ArrayList)arrayMap1.get(s1)) == null) {
                                arrayMap1.put(s1, new ArrayList());
                            }
                        }
                        cursor0.moveToPosition(-1);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap0);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
                        List list0 = new ArrayList(cursor0.getCount());
                        while(cursor0.moveToNext()) {
                            String s2 = cursor0.isNull(0) ? null : cursor0.getString(0);
                            State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(1));
                            Data data0 = Data.fromByteArray((cursor0.isNull(2) ? null : cursor0.getBlob(2)));
                            int v2 = cursor0.getInt(3);
                            int v3 = cursor0.getInt(4);
                            ArrayList arrayList0 = (ArrayList)arrayMap0.get(cursor0.getString(0));
                            if(arrayList0 == null) {
                                arrayList0 = new ArrayList();
                            }
                            ArrayList arrayList1 = (ArrayList)arrayMap1.get(cursor0.getString(0));
                            if(arrayList1 == null) {
                                arrayList1 = new ArrayList();
                            }
                            list0.add(new WorkInfoPojo(s2, workInfo$State0, data0, v2, v3, arrayList0, arrayList1));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return list0;
                    }
                    finally {
                        cursor0.close();
                    }
                }
                finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            @Override
            protected void finalize() {
                roomSQLiteQuery0.release();
            }
        };
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec"}, true, workSpecDao_Impl$150);
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public LiveData getWorkStatusPojoLiveDataForName(String name) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if(name == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, name);
        }
        androidx.work.impl.model.WorkSpecDao_Impl.17 workSpecDao_Impl$170 = new Callable() {
            @Override
            public Object call() throws Exception {
                return this.call();
            }

            public List call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursor0 = DBUtil.query(WorkSpecDao_Impl.this.__db, roomSQLiteQuery0, true, null);
                    try {
                        ArrayMap arrayMap0 = new ArrayMap();
                        ArrayMap arrayMap1 = new ArrayMap();
                        while(cursor0.moveToNext()) {
                            String s = cursor0.getString(0);
                            if(((ArrayList)arrayMap0.get(s)) == null) {
                                arrayMap0.put(s, new ArrayList());
                            }
                            String s1 = cursor0.getString(0);
                            if(((ArrayList)arrayMap1.get(s1)) == null) {
                                arrayMap1.put(s1, new ArrayList());
                            }
                        }
                        cursor0.moveToPosition(-1);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap0);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
                        List list0 = new ArrayList(cursor0.getCount());
                        while(cursor0.moveToNext()) {
                            String s2 = cursor0.isNull(0) ? null : cursor0.getString(0);
                            State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(1));
                            Data data0 = Data.fromByteArray((cursor0.isNull(2) ? null : cursor0.getBlob(2)));
                            int v2 = cursor0.getInt(3);
                            int v3 = cursor0.getInt(4);
                            ArrayList arrayList0 = (ArrayList)arrayMap0.get(cursor0.getString(0));
                            if(arrayList0 == null) {
                                arrayList0 = new ArrayList();
                            }
                            ArrayList arrayList1 = (ArrayList)arrayMap1.get(cursor0.getString(0));
                            if(arrayList1 == null) {
                                arrayList1 = new ArrayList();
                            }
                            list0.add(new WorkInfoPojo(s2, workInfo$State0, data0, v2, v3, arrayList0, arrayList1));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return list0;
                    }
                    finally {
                        cursor0.close();
                    }
                }
                finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            @Override
            protected void finalize() {
                roomSQLiteQuery0.release();
            }
        };
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "workname"}, true, workSpecDao_Impl$170);
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public LiveData getWorkStatusPojoLiveDataForTag(String tag) {
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if(tag == null) {
            roomSQLiteQuery0.bindNull(1);
        }
        else {
            roomSQLiteQuery0.bindString(1, tag);
        }
        androidx.work.impl.model.WorkSpecDao_Impl.16 workSpecDao_Impl$160 = new Callable() {
            @Override
            public Object call() throws Exception {
                return this.call();
            }

            public List call() throws Exception {
                WorkSpecDao_Impl.this.__db.beginTransaction();
                try {
                    Cursor cursor0 = DBUtil.query(WorkSpecDao_Impl.this.__db, roomSQLiteQuery0, true, null);
                    try {
                        ArrayMap arrayMap0 = new ArrayMap();
                        ArrayMap arrayMap1 = new ArrayMap();
                        while(cursor0.moveToNext()) {
                            String s = cursor0.getString(0);
                            if(((ArrayList)arrayMap0.get(s)) == null) {
                                arrayMap0.put(s, new ArrayList());
                            }
                            String s1 = cursor0.getString(0);
                            if(((ArrayList)arrayMap1.get(s1)) == null) {
                                arrayMap1.put(s1, new ArrayList());
                            }
                        }
                        cursor0.moveToPosition(-1);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap0);
                        WorkSpecDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
                        List list0 = new ArrayList(cursor0.getCount());
                        while(cursor0.moveToNext()) {
                            String s2 = cursor0.isNull(0) ? null : cursor0.getString(0);
                            State workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(1));
                            Data data0 = Data.fromByteArray((cursor0.isNull(2) ? null : cursor0.getBlob(2)));
                            int v2 = cursor0.getInt(3);
                            int v3 = cursor0.getInt(4);
                            ArrayList arrayList0 = (ArrayList)arrayMap0.get(cursor0.getString(0));
                            if(arrayList0 == null) {
                                arrayList0 = new ArrayList();
                            }
                            ArrayList arrayList1 = (ArrayList)arrayMap1.get(cursor0.getString(0));
                            if(arrayList1 == null) {
                                arrayList1 = new ArrayList();
                            }
                            list0.add(new WorkInfoPojo(s2, workInfo$State0, data0, v2, v3, arrayList0, arrayList1));
                        }
                        WorkSpecDao_Impl.this.__db.setTransactionSuccessful();
                        return list0;
                    }
                    finally {
                        cursor0.close();
                    }
                }
                finally {
                    WorkSpecDao_Impl.this.__db.endTransaction();
                }
            }

            @Override
            protected void finalize() {
                roomSQLiteQuery0.release();
            }
        };
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "workspec", "worktag"}, true, workSpecDao_Impl$160);
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public boolean hasUnfinishedWork() {
        boolean z = false;
        RoomSQLiteQuery roomSQLiteQuery0 = RoomSQLiteQuery.acquire("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursor0 = DBUtil.query(this.__db, roomSQLiteQuery0, false, null);
        try {
            if(cursor0.moveToFirst() && cursor0.getInt(0) != 0) {
                z = true;
            }
            return z;
        }
        finally {
            cursor0.close();
            roomSQLiteQuery0.release();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public void incrementGeneration(String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfIncrementGeneration.acquire();
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
            this.__preparedStmtOfIncrementGeneration.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public void incrementPeriodCount(String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfIncrementPeriodCount.acquire();
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
            this.__preparedStmtOfIncrementPeriodCount.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public int incrementWorkSpecRunAttemptCount(String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if(id == null) {
            supportSQLiteStatement0.bindNull(1);
        }
        else {
            supportSQLiteStatement0.bindString(1, id);
        }
        this.__db.beginTransaction();
        try {
            int v1 = supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return v1;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public void insertWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfWorkSpec.insert(workSpec);
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public int markWorkSpecScheduled(String id, long startTime) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        supportSQLiteStatement0.bindLong(1, startTime);
        if(id == null) {
            supportSQLiteStatement0.bindNull(2);
        }
        else {
            supportSQLiteStatement0.bindString(2, id);
        }
        this.__db.beginTransaction();
        try {
            int v2 = supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return v2;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkWorkSpecScheduled.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfPruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public int resetScheduledState() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfResetScheduledState.acquire();
        this.__db.beginTransaction();
        try {
            int v1 = supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return v1;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetScheduledState.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public int resetWorkSpecRunAttemptCount(String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if(id == null) {
            supportSQLiteStatement0.bindNull(1);
        }
        else {
            supportSQLiteStatement0.bindString(1, id);
        }
        this.__db.beginTransaction();
        try {
            int v1 = supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return v1;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public void setLastEnqueuedTime(String id, long enqueueTime) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfSetLastEnqueuedTime.acquire();
        supportSQLiteStatement0.bindLong(1, enqueueTime);
        if(id == null) {
            supportSQLiteStatement0.bindNull(2);
        }
        else {
            supportSQLiteStatement0.bindString(2, id);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetLastEnqueuedTime.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public void setOutput(String id, Data output) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfSetOutput.acquire();
        byte[] arr_b = Data.toByteArrayInternal(output);
        if(arr_b == null) {
            supportSQLiteStatement0.bindNull(1);
        }
        else {
            supportSQLiteStatement0.bindBlob(1, arr_b);
        }
        if(id == null) {
            supportSQLiteStatement0.bindNull(2);
        }
        else {
            supportSQLiteStatement0.bindString(2, id);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public int setState(State state, String id) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatement0 = this.__preparedStmtOfSetState.acquire();
        supportSQLiteStatement0.bindLong(1, ((long)WorkTypeConverters.stateToInt(state)));
        if(id == null) {
            supportSQLiteStatement0.bindNull(2);
        }
        else {
            supportSQLiteStatement0.bindString(2, id);
        }
        this.__db.beginTransaction();
        try {
            int v1 = supportSQLiteStatement0.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return v1;
        }
        finally {
            this.__db.endTransaction();
            this.__preparedStmtOfSetState.release(supportSQLiteStatement0);
        }
    }

    @Override  // androidx.work.impl.model.WorkSpecDao
    public void updateWorkSpec(WorkSpec workSpec) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfWorkSpec.handle(workSpec);
            this.__db.setTransactionSuccessful();
        }
        finally {
            this.__db.endTransaction();
        }
    }
}

