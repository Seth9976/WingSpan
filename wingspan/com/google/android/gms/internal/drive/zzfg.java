package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.zza;
import java.util.List;

public final class zzfg implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        DataHolder dataHolder0 = null;
        zza zza0 = null;
        boolean z = false;
        List list0 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 2: {
                    dataHolder0 = (DataHolder)SafeParcelReader.createParcelable(parcel0, v1, DataHolder.CREATOR);
                    break;
                }
                case 3: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v1, DriveId.CREATOR);
                    break;
                }
                case 4: {
                    zza0 = (zza)SafeParcelReader.createParcelable(parcel0, v1, zza.CREATOR);
                    break;
                }
                case 5: {
                    z = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new zzff(dataHolder0, list0, zza0, z);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new zzff[v];
    }
}

