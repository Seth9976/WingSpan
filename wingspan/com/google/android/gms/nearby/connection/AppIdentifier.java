package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

@Deprecated
public final class AppIdentifier extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String zzo;

    static {
        AppIdentifier.CREATOR = new zzc();
    }

    public AppIdentifier(String s) {
        this.zzo = Preconditions.checkNotEmpty(s, "Missing application identifier value");
    }

    public final String getIdentifier() {
        return this.zzo;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getIdentifier(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

