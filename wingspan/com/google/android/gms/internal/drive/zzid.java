package com.google.android.gms.internal.drive;

import android.os.Bundle;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzc;
import com.google.android.gms.drive.metadata.internal.zzg;
import com.google.android.gms.drive.metadata.internal.zzm;
import java.util.Arrays;

public class zzid extends zzm {
    public static final zzg zzlc;

    static {
        zzid.zzlc = new zzie();
    }

    public zzid(int v) {
        super("customProperties", Arrays.asList(new String[]{"hasCustomProperties", "sqlId"}), Arrays.asList(new String[]{"customPropertiesExtra", "customPropertiesExtraHolder"}), 5000000);
    }

    private static void zzc(DataHolder dataHolder0) {
        Bundle bundle0 = dataHolder0.getMetadata();
        if(bundle0 == null) {
            return;
        }
        synchronized(dataHolder0) {
            DataHolder dataHolder1 = (DataHolder)bundle0.getParcelable("customPropertiesExtraHolder");
            if(dataHolder1 != null) {
                dataHolder1.close();
                bundle0.remove("customPropertiesExtraHolder");
            }
        }
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        return zzid.zzf(dataHolder0, v, v1);
    }

    private static AppVisibleCustomProperties zzf(DataHolder dataHolder0, int v, int v1) {
        Bundle bundle0 = dataHolder0.getMetadata();
        SparseArray sparseArray0 = bundle0.getSparseParcelableArray("customPropertiesExtra");
        if(sparseArray0 == null) {
            if(bundle0.getParcelable("customPropertiesExtraHolder") == null) {
                throw new NullPointerException();
            }
            synchronized(dataHolder0) {
                DataHolder dataHolder1 = (DataHolder)dataHolder0.getMetadata().getParcelable("customPropertiesExtraHolder");
                if(dataHolder1 != null) {
                    try {
                        Bundle bundle1 = dataHolder1.getMetadata();
                        String s = bundle1.getString("entryIdColumn");
                        String s1 = bundle1.getString("keyColumn");
                        String s2 = bundle1.getString("visibilityColumn");
                        String s3 = bundle1.getString("valueColumn");
                        LongSparseArray longSparseArray0 = new LongSparseArray();
                        for(int v4 = 0; v4 < dataHolder1.getCount(); ++v4) {
                            int v5 = dataHolder1.getWindowIndex(v4);
                            long v6 = dataHolder1.getLong(s, v4, v5);
                            String s4 = dataHolder1.getString(s1, v4, v5);
                            int v7 = dataHolder1.getInteger(s2, v4, v5);
                            String s5 = dataHolder1.getString(s3, v4, v5);
                            zzc zzc0 = new zzc(new CustomPropertyKey(s4, v7), s5);
                            zza appVisibleCustomProperties$zza0 = (zza)longSparseArray0.get(v6);
                            if(appVisibleCustomProperties$zza0 == null) {
                                appVisibleCustomProperties$zza0 = new zza();
                                longSparseArray0.put(v6, appVisibleCustomProperties$zza0);
                            }
                            appVisibleCustomProperties$zza0.zza(zzc0);
                        }
                        SparseArray sparseArray1 = new SparseArray();
                        for(int v8 = 0; v8 < dataHolder0.getCount(); ++v8) {
                            zza appVisibleCustomProperties$zza1 = (zza)longSparseArray0.get(dataHolder0.getLong("sqlId", v8, dataHolder0.getWindowIndex(v8)));
                            if(appVisibleCustomProperties$zza1 != null) {
                                sparseArray1.append(v8, appVisibleCustomProperties$zza1.zzbb());
                            }
                        }
                        dataHolder0.getMetadata().putSparseParcelableArray("customPropertiesExtra", sparseArray1);
                    }
                    finally {
                        dataHolder1.close();
                        dataHolder0.getMetadata().remove("customPropertiesExtraHolder");
                    }
                }
            }
            sparseArray0 = bundle0.getSparseParcelableArray("customPropertiesExtra");
            return sparseArray0 == null ? AppVisibleCustomProperties.zzjb : ((AppVisibleCustomProperties)sparseArray0.get(v, AppVisibleCustomProperties.zzjb));
        }
        return (AppVisibleCustomProperties)sparseArray0.get(v, AppVisibleCustomProperties.zzjb);
    }
}

