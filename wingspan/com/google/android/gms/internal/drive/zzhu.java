package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.zzm;
import java.util.Collection;

final class zzhu extends zzm {
    zzhu(String s, Collection collection0, Collection collection1, int v) {
        super(s, collection0, collection1, 4400000);
    }

    @Override  // com.google.android.gms.drive.metadata.zza
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        throw new IllegalStateException("Thumbnail field is write only");
    }
}

