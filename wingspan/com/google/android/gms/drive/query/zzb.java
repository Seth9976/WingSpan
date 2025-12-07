package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.zzr;
import java.util.List;

public final class zzb implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        zzr zzr0 = null;
        String s = null;
        SortOrder sortOrder0 = null;
        List list0 = null;
        List list1 = null;
        boolean z = false;
        boolean z1 = false;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    zzr0 = (zzr)SafeParcelReader.createParcelable(parcel0, v1, zzr.CREATOR);
                    break;
                }
                case 3: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 4: {
                    sortOrder0 = (SortOrder)SafeParcelReader.createParcelable(parcel0, v1, SortOrder.CREATOR);
                    break;
                }
                case 5: {
                    list0 = SafeParcelReader.createStringList(parcel0, v1);
                    break;
                }
                case 6: {
                    z = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                case 7: {
                    list1 = SafeParcelReader.createTypedList(parcel0, v1, DriveSpace.CREATOR);
                    break;
                }
                case 8: {
                    z1 = SafeParcelReader.readBoolean(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new Query(zzr0, s, sortOrder0, list0, z, list1, z1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Query[v];
    }
}

