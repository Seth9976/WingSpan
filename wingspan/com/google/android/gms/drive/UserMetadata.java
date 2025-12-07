package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class UserMetadata extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String zzbo;
    private final String zzbp;
    private final String zzbq;
    private final boolean zzbr;
    private final String zzbs;

    static {
        UserMetadata.CREATOR = new zzt();
    }

    public UserMetadata(String s, String s1, String s2, boolean z, String s3) {
        this.zzbo = s;
        this.zzbp = s1;
        this.zzbq = s2;
        this.zzbr = z;
        this.zzbs = s3;
    }

    @Override
    public String toString() {
        return String.format("Permission ID: \'%s\', Display Name: \'%s\', Picture URL: \'%s\', Authenticated User: %b, Email: \'%s\'", this.zzbo, this.zzbp, this.zzbq, Boolean.valueOf(this.zzbr), this.zzbs);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.zzbo, false);
        SafeParcelWriter.writeString(parcel0, 3, this.zzbp, false);
        SafeParcelWriter.writeString(parcel0, 4, this.zzbq, false);
        SafeParcelWriter.writeBoolean(parcel0, 5, this.zzbr);
        SafeParcelWriter.writeString(parcel0, 6, this.zzbs, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

