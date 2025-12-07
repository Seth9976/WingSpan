package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        SnapshotMetadata snapshotMetadata0 = null;
        SnapshotContentsEntity snapshotContentsEntity0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    snapshotMetadata0 = (SnapshotMetadataEntity)SafeParcelReader.createParcelable(parcel0, v1, SnapshotMetadataEntity.CREATOR);
                    break;
                }
                case 3: {
                    snapshotContentsEntity0 = (SnapshotContentsEntity)SafeParcelReader.createParcelable(parcel0, v1, SnapshotContentsEntity.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new SnapshotEntity(snapshotMetadata0, snapshotContentsEntity0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SnapshotEntity[v];
    }
}

