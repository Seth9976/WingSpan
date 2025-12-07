package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzn extends zza {
    public static final zzo CREATOR;
    private final MetadataBundle zzma;
    private final MetadataField zzmb;

    static {
        zzn.CREATOR = new zzo();
    }

    public zzn(SearchableMetadataField searchableMetadataField0, Object object0) {
        this(MetadataBundle.zza(searchableMetadataField0, object0));
    }

    zzn(MetadataBundle metadataBundle0) {
        this.zzma = metadataBundle0;
        this.zzmb = zzi.zza(metadataBundle0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzma, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.drive.query.Filter
    public final Object zza(zzj zzj0) {
        Object object0 = this.zzma.zza(this.zzmb);
        return zzj0.zzc(this.zzmb, object0);
    }
}

