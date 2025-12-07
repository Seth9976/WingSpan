package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.drive.zzhs;
import com.google.android.gms.internal.drive.zzid;
import com.google.android.gms.internal.drive.zzif;
import com.google.android.gms.internal.drive.zzin;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzf {
    private static final Map zzjf;
    private static final Map zzjg;

    static {
        zzf.zzjf = new HashMap();
        zzf.zzjg = new HashMap();
        zzf.zzb(zzhs.zzjl);
        zzf.zzb(zzhs.zzkr);
        zzf.zzb(zzhs.zzki);
        zzf.zzb(zzhs.zzkp);
        zzf.zzb(zzhs.zzks);
        zzf.zzb(zzhs.zzjy);
        zzf.zzb(zzhs.zzjx);
        zzf.zzb(zzhs.zzjz);
        zzf.zzb(zzhs.zzka);
        zzf.zzb(zzhs.zzkb);
        zzf.zzb(zzhs.zzjv);
        zzf.zzb(zzhs.zzkd);
        zzf.zzb(zzhs.zzke);
        zzf.zzb(zzhs.zzkf);
        zzf.zzb(zzhs.zzkn);
        zzf.zzb(zzhs.zzjm);
        zzf.zzb(zzhs.zzkk);
        zzf.zzb(zzhs.zzjo);
        zzf.zzb(zzhs.zzjw);
        zzf.zzb(zzhs.zzjp);
        zzf.zzb(zzhs.zzjq);
        zzf.zzb(zzhs.zzjr);
        zzf.zzb(zzhs.zzjs);
        zzf.zzb(zzhs.zzkh);
        zzf.zzb(zzhs.zzkc);
        zzf.zzb(zzhs.zzkj);
        zzf.zzb(zzhs.zzkl);
        zzf.zzb(zzhs.zzkm);
        zzf.zzb(zzhs.zzko);
        zzf.zzb(zzhs.zzkt);
        zzf.zzb(zzhs.zzku);
        zzf.zzb(zzhs.zzju);
        zzf.zzb(zzhs.zzjt);
        zzf.zzb(zzhs.zzkq);
        zzf.zzb(zzhs.zzkg);
        zzf.zzb(zzhs.zzjn);
        zzf.zzb(zzhs.zzkv);
        zzf.zzb(zzhs.zzkw);
        zzf.zzb(zzhs.zzkx);
        zzf.zzb(zzhs.zzky);
        zzf.zzb(zzhs.zzkz);
        zzf.zzb(zzhs.zzla);
        zzf.zzb(zzhs.zzlb);
        zzf.zzb(zzif.zzld);
        zzf.zzb(zzif.zzlf);
        zzf.zzb(zzif.zzlg);
        zzf.zzb(zzif.zzlh);
        zzf.zzb(zzif.zzle);
        zzf.zzb(zzif.zzli);
        zzf.zzb(zzin.zzlk);
        zzf.zzb(zzin.zzll);
        zzf.zza(zzo.zzjk);
        zzf.zza(zzid.zzlc);
    }

    public static void zza(DataHolder dataHolder0) {
        for(Object object0: zzf.zzjg.values()) {
            ((zzg)object0).zzb(dataHolder0);
        }
    }

    private static void zza(zzg zzg0) {
        String s = zzg0.zzbd();
        if(zzf.zzjg.put(s, zzg0) != null) {
            throw new IllegalStateException("A cleaner for key " + zzg0.zzbd() + " has already been registered");
        }
    }

    private static void zzb(MetadataField metadataField0) {
        Map map0 = zzf.zzjf;
        if(map0.containsKey(metadataField0.getName())) {
            String s = metadataField0.getName();
            throw new IllegalArgumentException((s.length() == 0 ? new String("Duplicate field name registered: ") : "Duplicate field name registered: " + s));
        }
        map0.put(metadataField0.getName(), metadataField0);
    }

    public static Collection zzbc() {
        return Collections.unmodifiableCollection(zzf.zzjf.values());
    }

    public static MetadataField zzf(String s) {
        return (MetadataField)zzf.zzjf.get(s);
    }
}

