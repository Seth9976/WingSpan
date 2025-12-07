package com.google.android.gms.internal.nearby;

import android.bluetooth.BluetoothDevice;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzes implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        String s = null;
        String s1 = null;
        String s2 = null;
        BluetoothDevice bluetoothDevice0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 2: {
                    s1 = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 3: {
                    s2 = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 4: {
                    bluetoothDevice0 = (BluetoothDevice)SafeParcelReader.createParcelable(parcel0, v1, BluetoothDevice.CREATOR);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzer(s, s1, s2, bluetoothDevice0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzer[v];
    }
}

