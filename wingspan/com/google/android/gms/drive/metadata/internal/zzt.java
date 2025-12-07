package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public class zzt extends zza {
    public zzt(String s, int v) {
        super(s, v);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final void zza(Bundle bundle0, Object object0) {
        bundle0.putString(this.getName(), ((String)object0));
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzb(Bundle bundle0) {
        return bundle0.getString(this.getName());
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        return dataHolder0.getString(this.getName(), v, v1);
    }
}

