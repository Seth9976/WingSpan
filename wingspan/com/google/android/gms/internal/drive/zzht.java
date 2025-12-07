package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.zzb;
import java.util.Collection;

final class zzht extends zzb {
    zzht(String s, Collection collection0, Collection collection1, int v) {
        super(s, collection0, collection1, 7000000);
    }

    @Override  // com.google.android.gms.drive.metadata.internal.zzb
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        return this.zze(dataHolder0, v, v1);
    }

    @Override  // com.google.android.gms.drive.metadata.internal.zzb
    protected final Boolean zze(DataHolder dataHolder0, int v, int v1) {
        return dataHolder0.getInteger("trashed", v, v1) == 2;
    }
}

