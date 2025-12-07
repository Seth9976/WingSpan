package com.google.android.gms.games.snapshot;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        Long long0 = null;
        BitmapTeleporter bitmapTeleporter0 = null;
        Uri uri0 = null;
        Long long1 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 2: {
                    long0 = SafeParcelReader.readLongObject(parcel0, v1);
                    break;
                }
                case 4: {
                    uri0 = (Uri)SafeParcelReader.createParcelable(parcel0, v1, Uri.CREATOR);
                    break;
                }
                case 5: {
                    bitmapTeleporter0 = (BitmapTeleporter)SafeParcelReader.createParcelable(parcel0, v1, BitmapTeleporter.CREATOR);
                    break;
                }
                case 6: {
                    long1 = SafeParcelReader.readLongObject(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new SnapshotMetadataChangeEntity(s, long0, bitmapTeleporter0, uri0, long1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new SnapshotMetadataChangeEntity[v];
    }
}

