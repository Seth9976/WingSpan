package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.messages.Strategy;

public final class zzca implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        boolean z = false;
        boolean z1 = false;
        int v2 = 0;
        zzaf zzaf0 = null;
        Strategy strategy0 = null;
        IBinder iBinder0 = null;
        String s = null;
        String s1 = null;
        IBinder iBinder1 = null;
        ClientAppContext clientAppContext0 = null;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 2: {
                    zzaf0 = (zzaf)SafeParcelReader.createParcelable(parcel0, v3, zzaf.CREATOR);
                    break;
                }
                case 3: {
                    strategy0 = (Strategy)SafeParcelReader.createParcelable(parcel0, v3, Strategy.CREATOR);
                    break;
                }
                case 4: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v3);
                    break;
                }
                case 5: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 6: {
                    s1 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 7: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 8: {
                    iBinder1 = SafeParcelReader.readIBinder(parcel0, v3);
                    break;
                }
                case 9: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 10: {
                    clientAppContext0 = (ClientAppContext)SafeParcelReader.createParcelable(parcel0, v3, ClientAppContext.CREATOR);
                    break;
                }
                case 11: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzbz(v1, zzaf0, strategy0, iBinder0, s, s1, z, iBinder1, z1, clientAppContext0, v2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzbz[v];
    }
}

