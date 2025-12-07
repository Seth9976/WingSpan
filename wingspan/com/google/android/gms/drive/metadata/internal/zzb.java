package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public class zzb extends zza {
    public zzb(String s, int v) {
        super(s, v);
    }

    public zzb(String s, Collection collection0, Collection collection1, int v) {
        super(s, collection0, collection1, 7000000);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final void zza(Bundle bundle0, Object object0) {
        bundle0.putBoolean(this.getName(), ((Boolean)object0).booleanValue());
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzb(Bundle bundle0) {
        return Boolean.valueOf(bundle0.getBoolean(this.getName()));
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected Object zzc(DataHolder dataHolder0, int v, int v1) {
        return this.zze(dataHolder0, v, v1);
    }

    protected Boolean zze(DataHolder dataHolder0, int v, int v1) {
        return Boolean.valueOf(dataHolder0.getBoolean(this.getName(), v, v1));
    }
}

