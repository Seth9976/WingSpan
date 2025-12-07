package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.zzb;

public final class zzic extends zzb implements SearchableMetadataField {
    public zzic(String s, int v) {
        super(s, 4100000);
    }

    @Override  // com.google.android.gms.drive.metadata.internal.zzb
    protected final Object zzc(DataHolder dataHolder0, int v, int v1) {
        return this.zze(dataHolder0, v, v1);
    }

    @Override  // com.google.android.gms.drive.metadata.internal.zzb
    protected final Boolean zze(DataHolder dataHolder0, int v, int v1) {
        return dataHolder0.getInteger(this.getName(), v, v1) == 0 ? false : true;
    }
}

