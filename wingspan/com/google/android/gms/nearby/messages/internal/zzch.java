package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzch implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        int v1 = 0;
        int v2 = 0;
        boolean z = false;
        IBinder iBinder0 = null;
        IBinder iBinder1 = null;
        PendingIntent pendingIntent0 = null;
        String s = null;
        String s1 = null;
        ClientAppContext clientAppContext0 = null;
        while(parcel0.dataPosition() < v) {
            int v3 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 2: {
                    iBinder0 = SafeParcelReader.readIBinder(parcel0, v3);
                    break;
                }
                case 3: {
                    iBinder1 = SafeParcelReader.readIBinder(parcel0, v3);
                    break;
                }
                case 4: {
                    pendingIntent0 = (PendingIntent)SafeParcelReader.createParcelable(parcel0, v3, PendingIntent.CREATOR);
                    break;
                }
                case 5: {
                    v2 = SafeParcelReader.readInt(parcel0, v3);
                    break;
                }
                case 6: {
                    s = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 7: {
                    s1 = SafeParcelReader.createString(parcel0, v3);
                    break;
                }
                case 8: {
                    z = SafeParcelReader.readBoolean(parcel0, v3);
                    break;
                }
                case 9: {
                    clientAppContext0 = (ClientAppContext)SafeParcelReader.createParcelable(parcel0, v3, ClientAppContext.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v3);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzcg(v1, iBinder0, iBinder1, pendingIntent0, v2, s, s1, z, clientAppContext0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzcg[v];
    }
}

