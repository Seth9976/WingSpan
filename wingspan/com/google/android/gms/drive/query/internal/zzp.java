package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;
import java.util.Collections;

public final class zzp extends zza {
    public static final zzq CREATOR;
    private final MetadataBundle zzma;
    private final zzb zzmn;

    static {
        zzp.CREATOR = new zzq();
    }

    public zzp(SearchableCollectionMetadataField searchableCollectionMetadataField0, Object object0) {
        this(MetadataBundle.zza(searchableCollectionMetadataField0, Collections.singleton(object0)));
    }

    zzp(MetadataBundle metadataBundle0) {
        this.zzma = metadataBundle0;
        this.zzmn = (zzb)zzi.zza(metadataBundle0);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzma, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @Override  // com.google.android.gms.drive.query.Filter
    public final Object zza(zzj zzj0) {
        Object object0 = ((Collection)this.zzma.zza(this.zzmn)).iterator().next();
        return zzj0.zza(this.zzmn, object0);
    }
}

