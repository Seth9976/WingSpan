package androidx.work.impl.model;

import android.database.Cursor;
import androidx.collection.ArrayMap;
import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.Data;
import androidx.work.WorkInfo.State;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

public final class RawWorkInfoDao_Impl implements RawWorkInfoDao {
    private final RoomDatabase __db;

    public RawWorkInfoDao_Impl(RoomDatabase __db) {
        this.__db = __db;
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

    public static List getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override  // androidx.work.impl.model.RawWorkInfoDao
    public List getWorkInfoPojos(SupportSQLiteQuery query) {
        int v6;
        Data data0;
        byte[] arr_b;
        State workInfo$State0;
        String s2;
        try {
            this.__db.assertNotSuspendingTransaction();
            try(Cursor cursor0 = DBUtil.query(this.__db, query, true, null)) {
                int v = CursorUtil.getColumnIndex(cursor0, "id");
                int v1 = CursorUtil.getColumnIndex(cursor0, "state");
                int v2 = CursorUtil.getColumnIndex(cursor0, "output");
                int v3 = CursorUtil.getColumnIndex(cursor0, "run_attempt_count");
                int v4 = CursorUtil.getColumnIndex(cursor0, "generation");
                ArrayMap arrayMap0 = new ArrayMap();
                ArrayMap arrayMap1 = new ArrayMap();
                while(true) {
                    if(!cursor0.moveToNext()) {
                        break;
                    }
                    String s = cursor0.getString(v);
                    if(((ArrayList)arrayMap0.get(s)) == null) {
                        arrayMap0.put(s, new ArrayList());
                    }
                    String s1 = cursor0.getString(v);
                    if(((ArrayList)arrayMap1.get(s1)) != null) {
                        continue;
                    }
                    arrayMap1.put(s1, new ArrayList());
                }
                cursor0.moveToPosition(-1);
                this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap0);
                this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
                List list0 = new ArrayList(cursor0.getCount());
                while(true) {
                    if(!cursor0.moveToNext()) {
                        break;
                    }
                    if(v == -1) {
                        s2 = null;
                    }
                    else if(!cursor0.isNull(v)) {
                        s2 = cursor0.getString(v);
                    }
                    if(v1 == -1) {
                        workInfo$State0 = null;
                    }
                    else {
                        workInfo$State0 = WorkTypeConverters.intToState(cursor0.getInt(v1));
                    }
                    if(v2 == -1) {
                        data0 = null;
                    }
                    else {
                        if(cursor0.isNull(v2)) {
                            arr_b = null;
                        }
                        else {
                            arr_b = cursor0.getBlob(v2);
                        }
                        data0 = Data.fromByteArray(arr_b);
                    }
                    int v5 = 0;
                    if(v3 == -1) {
                        v6 = 0;
                    }
                    else {
                        v6 = cursor0.getInt(v3);
                    }
                    if(v4 != -1) {
                        v5 = cursor0.getInt(v4);
                    }
                    ArrayList arrayList0 = (ArrayList)arrayMap0.get(cursor0.getString(v));
                    if(arrayList0 == null) {
                        arrayList0 = new ArrayList();
                    }
                    ArrayList arrayList1 = (ArrayList)arrayMap1.get(cursor0.getString(v));
                    if(arrayList1 == null) {
                        arrayList1 = new ArrayList();
                    }
                    list0.add(new WorkInfoPojo(s2, workInfo$State0, data0, v6, v5, arrayList0, arrayList1));
                }
            }
            return list0;
        }
        catch(Throwable throwable0) {
            throw throwable0;
        }
    }

    @Override  // androidx.work.impl.model.RawWorkInfoDao
    public LiveData getWorkInfoPojosLiveData(SupportSQLiteQuery query) {
        androidx.work.impl.model.RawWorkInfoDao_Impl.1 rawWorkInfoDao_Impl$10 = new Callable() {
            @Override
            public Object call() throws Exception {
                return this.call();
            }

            public List call() throws Exception {
                int v6;
                Data data0;
                byte[] arr_b;
                State workInfo$State0;
                String s2;
                try(Cursor cursor0 = DBUtil.query(RawWorkInfoDao_Impl.this.__db, query, true, null)) {
                    int v = CursorUtil.getColumnIndex(cursor0, "id");
                    int v1 = CursorUtil.getColumnIndex(cursor0, "state");
                    int v2 = CursorUtil.getColumnIndex(cursor0, "output");
                    int v3 = CursorUtil.getColumnIndex(cursor0, "run_attempt_count");
                    int v4 = CursorUtil.getColumnIndex(cursor0, "generation");
                    ArrayMap arrayMap0 = new ArrayMap();
                    ArrayMap arrayMap1 = new ArrayMap();
                    while(true) {
                        if(!cursor0.moveToNext()) {
                            break;
                        }
                        String s = cursor0.getString(v);
                        if(((ArrayList)arrayMap0.get(s)) == null) {
                            arrayMap0.put(s, new ArrayList());
                        }
                        String s1 = cursor0.getString(v);
                        if(((ArrayList)arrayMap1.get(s1)) != null) {
                            continue;
                        }
                        arrayMap1.put(s1, new ArrayList());
                    }
                    cursor0.moveToPosition(-1);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkTagAsjavaLangString(arrayMap0);
                    RawWorkInfoDao_Impl.this.__fetchRelationshipWorkProgressAsandroidxWorkData(arrayMap1);
                    List list0 = new ArrayList(cursor0.getCount());
                    while(true) {
                        if(!cursor0.moveToNext()) {
                            break;
                        }
                        if(v == -1) {
                            s2 = null;
                        }
                        else if(!cursor0.isNull(v)) {
                            s2 = cursor0.getString(v);
                        }
                        workInfo$State0 = v1 == -1 ? null : WorkTypeConverters.intToState(cursor0.getInt(v1));
                        if(v2 == -1) {
                            data0 = null;
                        }
                        else {
                            arr_b = cursor0.isNull(v2) ? null : cursor0.getBlob(v2);
                            data0 = Data.fromByteArray(arr_b);
                        }
                        int v5 = 0;
                        v6 = v3 == -1 ? 0 : cursor0.getInt(v3);
                        if(v4 != -1) {
                            v5 = cursor0.getInt(v4);
                        }
                        ArrayList arrayList0 = (ArrayList)arrayMap0.get(cursor0.getString(v));
                        if(arrayList0 == null) {
                            arrayList0 = new ArrayList();
                        }
                        ArrayList arrayList1 = (ArrayList)arrayMap1.get(cursor0.getString(v));
                        if(arrayList1 == null) {
                            arrayList1 = new ArrayList();
                        }
                        list0.add(new WorkInfoPojo(s2, workInfo$State0, data0, v6, v5, arrayList0, arrayList1));
                    }
                }
                return list0;
            }
        };
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WorkTag", "WorkProgress", "WorkSpec"}, false, rawWorkInfoDao_Impl$10);
    }
}

