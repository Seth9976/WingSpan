package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

@Deprecated
public final class AppMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final List zzp;

    static {
        AppMetadata.CREATOR = new zzd();
    }

    public AppMetadata(List list0) {
        this.zzp = (List)Preconditions.checkNotNull(list0, "Must specify application identifiers");
        Preconditions.checkNotZero(list0.size(), "Application identifiers cannot be empty");
    }

    public final List getAppIdentifiers() {
        return this.zzp;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.getAppIdentifiers(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

