package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.zzb;
import com.google.android.gms.drive.query.Filter;
import java.util.List;

public final class zzk implements zzj {
    private Boolean zzmm;

    private zzk() {
        this.zzmm = Boolean.FALSE;
    }

    public static boolean zza(Filter filter0) {
        return filter0 == null ? false : ((Boolean)filter0.zza(new zzk())).booleanValue();
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zza(zzb zzb0, Object object0) {
        return this.zzmm;
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zza(zzx zzx0, MetadataField metadataField0, Object object0) {
        return this.zzmm;
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zza(zzx zzx0, List list0) {
        return this.zzmm;
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zza(Object object0) {
        return this.zzmm;
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zzbj() {
        return this.zzmm;
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zzbk() {
        return this.zzmm;
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zzc(MetadataField metadataField0, Object object0) {
        return this.zzmm;
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zze(MetadataField metadataField0) {
        return this.zzmm;
    }

    @Override  // com.google.android.gms.drive.query.internal.zzj
    public final Object zzi(String s) {
        if(!s.isEmpty()) {
            this.zzmm = Boolean.TRUE;
        }
        return this.zzmm;
    }
}

