package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

public class ParentDriveIdSet extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    final List zzjj;

    static {
        ParentDriveIdSet.CREATOR = new zzn();
    }

    public ParentDriveIdSet() {
        this(new ArrayList());
    }

    ParentDriveIdSet(List list0) {
        this.zzjj = list0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 2, this.zzjj, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

