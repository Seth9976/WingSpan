package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ActivityTransition extends AbstractSafeParcelable {
    public static class Builder {
        private int zza;
        private int zzb;

        public Builder() {
            this.zza = -1;
            this.zzb = -1;
        }

        public ActivityTransition build() {
            boolean z = true;
            Preconditions.checkState(this.zza != -1, "Activity type not set.");
            if(this.zzb == -1) {
                z = false;
            }
            Preconditions.checkState(z, "Activity transition type not set.");
            return new ActivityTransition(this.zza, this.zzb);
        }

        public Builder setActivityTransition(int v) {
            ActivityTransition.zza(v);
            this.zzb = v;
            return this;
        }

        public Builder setActivityType(int v) {
            this.zza = v;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SupportedActivityTransition {
    }

    public static final int ACTIVITY_TRANSITION_ENTER = 0;
    public static final int ACTIVITY_TRANSITION_EXIT = 1;
    public static final Parcelable.Creator CREATOR;
    private final int zza;
    private final int zzb;

    static {
        ActivityTransition.CREATOR = new zzl();
    }

    ActivityTransition(int v, int v1) {
        this.zza = v;
        this.zzb = v1;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof ActivityTransition ? this.zza == ((ActivityTransition)object0).zza && this.zzb == ((ActivityTransition)object0).zzb : false;
    }

    public int getActivityType() {
        return this.zza;
    }

    public int getTransitionType() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override
    public String toString() {
        return "ActivityTransition [mActivityType=" + this.zza + ", mTransitionType=" + this.zzb + ']';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.getActivityType());
        SafeParcelWriter.writeInt(parcel0, 2, this.getTransitionType());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static void zza(int v) {
        Preconditions.checkArgument(v >= 0 && v <= 1, "Transition type " + v + " is not valid.");
    }
}

