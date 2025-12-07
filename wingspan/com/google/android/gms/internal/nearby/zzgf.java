package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

public final class zzgf implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        IBinder iBinder0 = null;
        IBinder iBinder1 = null;
        String s = null;
        DiscoveryOptions discoveryOptions0 = null;
        IBinder iBinder2 = null;
        long v1 = 0L;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 1: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                case 2: {
                    iBinder1 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 4: {
                    v1 = SafeParcelReader.readLong(parcel0, v2);
                    break;
                }
                case 5: {
                    discoveryOptions0 = (DiscoveryOptions)SafeParcelReader.createParcelable(parcel0, v2, DiscoveryOptions.CREATOR);
                    break;
                }
                case 6: {
                    iBinder2 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzgc(iBinder0, iBinder1, s, v1, discoveryOptions0, iBinder2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzgc[v];
    }
}

