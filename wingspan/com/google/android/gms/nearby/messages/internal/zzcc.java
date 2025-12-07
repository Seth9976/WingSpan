package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzcc implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        boolean z = false;
        IBinder iBinder0 = null;
        IBinder iBinder1 = null;
        String s = null;
        ClientAppContext clientAppContext0 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v2);
                    break;
                }
                case 2: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                case 3: {
                    iBinder1 = SafeParcelReader.readIBinder(parcel0, v2);
                    break;
                }
                case 4: {
                    z = SafeParcelReader.readBoolean(parcel0, v2);
                    break;
                }
                case 5: {
                    s = SafeParcelReader.createString(parcel0, v2);
                    break;
                }
                case 6: {
                    clientAppContext0 = (ClientAppContext)SafeParcelReader.createParcelable(parcel0, v2, ClientAppContext.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v2);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzcb(v1, iBinder0, iBinder1, z, s, clientAppContext0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzcb[v];
    }
}

