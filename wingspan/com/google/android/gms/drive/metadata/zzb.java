package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

public abstract class zzb extends zza {
    protected zzb(String s, Collection collection0, Collection collection1, int v) {
        super(s, collection0, collection1, v);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected Object zzc(DataHolder dataHolder0, int v, int v1) {
        return this.zzd(dataHolder0, v, v1);
    }

    protected Collection zzd(DataHolder dataHolder0, int v, int v1) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}

