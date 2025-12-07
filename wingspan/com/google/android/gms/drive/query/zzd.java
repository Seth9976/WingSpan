package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.internal.zzj;
import com.google.android.gms.drive.query.internal.zzx;
import java.util.List;

public final class zzd implements zzj {
    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zza(zzb zzb0, Object object0) {
        return String.format("contains(%s,%s)", zzb0.getName(), object0);
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zza(zzx zzx0, MetadataField metadataField0, Object object0) {
        return String.format("cmp(%s,%s,%s)", zzx0.getTag(), metadataField0.getName(), object0);
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zza(zzx zzx0, List list0) {
        StringBuilder stringBuilder0 = new StringBuilder(zzx0.getTag() + "(");
        String s = "";
        for(Object object0: list0) {
            stringBuilder0.append(s);
            stringBuilder0.append(((String)object0));
            s = ",";
        }
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zza(Object object0) {
        return String.format("not(%s)", ((String)object0));
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zzbj() {
        return "ownedByMe()";
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zzbk() {
        return "all()";
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zzc(MetadataField metadataField0, Object object0) {
        return String.format("has(%s,%s)", metadataField0.getName(), object0);
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zze(MetadataField metadataField0) {
        return String.format("fieldOnly(%s)", metadataField0.getName());
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zzi(String s) {
        return String.format("fullTextSearch(%s)", s);
    }
}

