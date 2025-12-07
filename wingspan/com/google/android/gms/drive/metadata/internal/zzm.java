package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.drive.metadata.zza;
import java.util.Collection;

public abstract class zzm extends zza {
    public zzm(String s, Collection collection0, Collection collection1, int v) {
        super(s, collection0, collection1, v);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final void zza(Bundle bundle0, Object object0) {
        bundle0.putParcelable(this.getName(), ((ReflectedParcelable)object0));
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzb(Bundle bundle0) {
        return (ReflectedParcelable)bundle0.getParcelable(this.getName());
    }
}

