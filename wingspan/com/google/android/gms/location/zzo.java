package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.List;

public final class zzo implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = SafeParcelReader.validateObjectHeader(parcel0);
        List list0 = null;
        String s = null;
        List list1 = null;
        String s1 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = SafeParcelReader.readHeader(parcel0);
            switch(((char)v1)) {
                case 1: {
                    list0 = SafeParcelReader.createTypedList(parcel0, v1, ActivityTransition.CREATOR);
                    break;
                }
                case 2: {
                    s = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                case 3: {
                    list1 = SafeParcelReader.createTypedList(parcel0, v1, ClientIdentity.CREATOR);
                    break;
                }
                case 4: {
                    s1 = SafeParcelReader.createString(parcel0, v1);
                    break;
                }
                default: {
                    SafeParcelReader.skipUnknownField(parcel0, v1);
                }
            }
        }
        SafeParcelReader.ensureAtEnd(parcel0, v);
        return new ActivityTransitionRequest(list0, s, list1, s1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new ActivityTransitionRequest[v];
    }
}

