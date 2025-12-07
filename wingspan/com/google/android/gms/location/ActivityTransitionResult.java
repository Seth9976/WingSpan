package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.List;

public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final List zza;
    private Bundle zzb;

    static {
        ActivityTransitionResult.CREATOR = new zzp();
    }

    public ActivityTransitionResult(List list0) {
        this.zzb = null;
        Preconditions.checkNotNull(list0, "transitionEvents list can\'t be null.");
        if(!list0.isEmpty()) {
            for(int v = 1; v < list0.size(); ++v) {
                Preconditions.checkArgument(((ActivityTransitionEvent)list0.get(v)).getElapsedRealTimeNanos() >= ((ActivityTransitionEvent)list0.get(v - 1)).getElapsedRealTimeNanos());
            }
        }
        this.zza = Collections.unmodifiableList(list0);
    }

    public ActivityTransitionResult(List list0, Bundle bundle0) {
        this(list0);
        this.zzb = bundle0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 == null || this.getClass() != object0.getClass() ? false : this.zza.equals(((ActivityTransitionResult)object0).zza);
    }

    public static ActivityTransitionResult extractResult(Intent intent0) {
        return ActivityTransitionResult.hasResult(intent0) ? ((ActivityTransitionResult)SafeParcelableSerializer.deserializeFromIntentExtra(intent0, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT", ActivityTransitionResult.CREATOR)) : null;
    }

    public List getTransitionEvents() {
        return this.zza;
    }

    public static boolean hasResult(Intent intent0) {
        return intent0 == null ? false : intent0.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_RESULT");
    }

    @Override
    public int hashCode() {
        return this.zza.hashCode();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.getTransitionEvents(), false);
        SafeParcelWriter.writeBundle(parcel0, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

