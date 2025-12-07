package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zza;

public final class zzh extends zza {
    public zzh(String s, int v) {
        super(s, 4300000);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final void zza(Bundle bundle0, Object object0) {
        bundle0.putInt(this.getName(), ((int)(((Integer)object0))));
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzb(Bundle bundle0) {
        return bundle0.getInt(this.getName());
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        return dataHolder0.getInteger(this.getName(), v, v1);
    }
}

