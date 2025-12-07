package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzaa extends Metadata {
    private final MetadataBundle zzdt;

    public zzaa(MetadataBundle metadataBundle0) {
        this.zzdt = metadataBundle0;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        return new zzaa(this.zzdt.zzbf());
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return this.zzdt != null;
    }

    @Override
    public final String toString() {
        return "Metadata [mImpl=" + this.zzdt + "]";
    }

    @Override  // com.google.android.gms.drive.Metadata
    public final Object zza(MetadataField metadataField0) {
        return this.zzdt.zza(metadataField0);
    }
}

