package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String tag;
    private final int versionCode;
    private final String zza;
    private final String zzb;

    static {
        PlaceReport.CREATOR = new zza();
    }

    PlaceReport(int v, String s, String s1, String s2) {
        this.versionCode = v;
        this.zza = s;
        this.tag = s1;
        this.zzb = s2;
    }

    public static PlaceReport create(String s, String s1) {
        Preconditions.checkNotNull(s);
        Preconditions.checkNotEmpty(s1);
        new String("unknown");
        Preconditions.checkArgument(true, "Invalid source");
        return new PlaceReport(1, s, s1, "unknown");
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof PlaceReport ? Objects.equal(this.zza, ((PlaceReport)object0).zza) && Objects.equal(this.tag, ((PlaceReport)object0).tag) && Objects.equal(this.zzb, ((PlaceReport)object0).zzb) : false;
    }

    public String getPlaceId() {
        return this.zza;
    }

    public String getTag() {
        return this.tag;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.tag, this.zzb});
    }

    @Override
    public String toString() {
        ToStringHelper objects$ToStringHelper0 = Objects.toStringHelper(this);
        objects$ToStringHelper0.add("placeId", this.zza);
        objects$ToStringHelper0.add("tag", this.tag);
        if(!"unknown".equals(this.zzb)) {
            objects$ToStringHelper0.add("source", this.zzb);
        }
        return objects$ToStringHelper0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel0, 2, this.getPlaceId(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getTag(), false);
        SafeParcelWriter.writeString(parcel0, 4, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

