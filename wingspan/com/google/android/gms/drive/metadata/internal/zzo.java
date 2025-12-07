package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class zzo extends zzl implements SearchableCollectionMetadataField {
    public static final zzg zzjk;

    static {
        zzo.zzjk = new zzp();
    }

    public zzo(int v) {
        super("parents", Collections.emptySet(), Arrays.asList(new String[]{"parentsExtra", "dbInstanceId", "parentsExtraHolder"}), 4100000);
    }

    @Override  // com.google.android.gms.drive.metadata.internal.zzl
    protected final Object zzb(Bundle bundle0) {
        return this.zzc(bundle0);
    }

    private static void zzc(DataHolder dataHolder0) {
        Bundle bundle0 = dataHolder0.getMetadata();
        if(bundle0 == null) {
            return;
        }
        synchronized(dataHolder0) {
            DataHolder dataHolder1 = (DataHolder)bundle0.getParcelable("parentsExtraHolder");
            if(dataHolder1 != null) {
                dataHolder1.close();
                bundle0.remove("parentsExtraHolder");
            }
        }
    }

    @Override  // com.google.android.gms.drive.metadata.zzb
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        return this.zzd(dataHolder0, v, v1);
    }

    @Override  // com.google.android.gms.drive.metadata.internal.zzl
    protected final Collection zzc(Bundle bundle0) {
        Collection collection0 = super.zzc(bundle0);
        return collection0 == null ? null : new HashSet(collection0);
    }

    @Override  // com.google.android.gms.drive.metadata.zzb
    protected final Collection zzd(DataHolder dataHolder0, int v, int v1) {
        Bundle bundle0 = dataHolder0.getMetadata();
        ArrayList arrayList0 = bundle0.getParcelableArrayList("parentsExtra");
        if(arrayList0 == null) {
            if(bundle0.getParcelable("parentsExtraHolder") != null) {
                synchronized(dataHolder0) {
                    DataHolder dataHolder1 = (DataHolder)dataHolder0.getMetadata().getParcelable("parentsExtraHolder");
                    if(dataHolder1 != null) {
                        try {
                            int v4 = dataHolder0.getCount();
                            ArrayList arrayList1 = new ArrayList(v4);
                            HashMap hashMap0 = new HashMap(v4);
                            for(int v6 = 0; v6 < v4; ++v6) {
                                int v7 = dataHolder0.getWindowIndex(v6);
                                ParentDriveIdSet parentDriveIdSet0 = new ParentDriveIdSet();
                                arrayList1.add(parentDriveIdSet0);
                                hashMap0.put(dataHolder0.getLong("sqlId", v6, v7), parentDriveIdSet0);
                            }
                            Bundle bundle1 = dataHolder1.getMetadata();
                            String s = bundle1.getString("childSqlIdColumn");
                            String s1 = bundle1.getString("parentSqlIdColumn");
                            String s2 = bundle1.getString("parentResIdColumn");
                            int v8 = dataHolder1.getCount();
                            for(int v5 = 0; v5 < v8; ++v5) {
                                int v9 = dataHolder1.getWindowIndex(v5);
                                ParentDriveIdSet parentDriveIdSet1 = (ParentDriveIdSet)hashMap0.get(dataHolder1.getLong(s, v5, v9));
                                zzq zzq0 = new zzq(dataHolder1.getString(s2, v5, v9), dataHolder1.getLong(s1, v5, v9), 1);
                                parentDriveIdSet1.zzjj.add(zzq0);
                            }
                            dataHolder0.getMetadata().putParcelableArrayList("parentsExtra", arrayList1);
                        }
                        finally {
                            dataHolder1.close();
                            dataHolder0.getMetadata().remove("parentsExtraHolder");
                        }
                    }
                }
                arrayList0 = bundle0.getParcelableArrayList("parentsExtra");
            }
            if(arrayList0 == null) {
                return null;
            }
        }
        long v10 = bundle0.getLong("dbInstanceId");
        ParentDriveIdSet parentDriveIdSet2 = (ParentDriveIdSet)arrayList0.get(v);
        Collection collection0 = new HashSet();
        for(Object object0: parentDriveIdSet2.zzjj) {
            ((Set)collection0).add(new DriveId(((zzq)object0).zzad, ((zzq)object0).zzae, v10, ((zzq)object0).zzaf));
        }
        return collection0;
    }
}

