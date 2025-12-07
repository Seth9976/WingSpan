package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzd implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        Uri uri0 = null;
        int v1 = 0;
        int v2 = 0;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    uri0 = (Uri)SafeParcelReader.createParcelable(parcel0, v3, Uri.CREATOR);
                    break;
                }
                case 2: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 3: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new ScreenshotEntity(uri0, v1, v2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ScreenshotEntity[v];
    }
}

