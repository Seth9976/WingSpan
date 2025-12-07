package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zzd;
import java.util.Date;

public class zze extends zzd {
    public zze(String s, int v) {
        super(s, v);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final void zza(Bundle bundle0, Object object0) {
        bundle0.putLong(this.getName(), ((Date)object0).getTime());
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzb(Bundle bundle0) {
        return new Date(bundle0.getLong(this.getName()));
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        return new Date(dataHolder0.getLong(this.getName(), v, v1));
    }
}

