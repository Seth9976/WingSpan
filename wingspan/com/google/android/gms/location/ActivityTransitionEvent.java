package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zza;
    private final int zzb;
    private final long zzc;

    static {
        ActivityTransitionEvent.CREATOR = new zzm();
    }

    public ActivityTransitionEvent(int v, int v1, long v2) {
        ActivityTransition.zza(v1);
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ActivityTransitionEvent ? this.zza == ((ActivityTransitionEvent)object0).zza && this.zzb == ((ActivityTransitionEvent)object0).zzb && this.zzc == ((ActivityTransitionEvent)object0).zzc : false;
    }

    public int getActivityType() {
        return this.zza;
    }

    public long getElapsedRealTimeNanos() {
        return this.zzc;
    }

    public int getTransitionType() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    @Override
    public String toString() {
        return "ActivityType " + this.zza + " " + ("TransitionType " + this.zzb) + " " + ("ElapsedRealTimeNanos " + this.zzc);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.getActivityType());
        SafeParcelWriter.writeInt(parcel0, 2, this.getTransitionType());
        SafeParcelWriter.writeLong(parcel0, 3, this.getElapsedRealTimeNanos());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

