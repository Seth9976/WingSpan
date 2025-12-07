package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final Comparator IS_SAME_TRANSITION;
    private final List zza;
    private final String zzb;
    private final List zzc;
    private String zzd;

    static {
        ActivityTransitionRequest.CREATOR = new zzo();
        ActivityTransitionRequest.IS_SAME_TRANSITION = new zzn();
    }

    public ActivityTransitionRequest(List list0) {
        this(list0, null, null, null);
    }

    public ActivityTransitionRequest(List list0, String s, List list1, String s1) {
        Preconditions.checkNotNull(list0, "transitions can\'t be null");
        Preconditions.checkArgument(list0.size() > 0, "transitions can\'t be empty.");
        Preconditions.checkNotNull(list0);
        TreeSet treeSet0 = new TreeSet(ActivityTransitionRequest.IS_SAME_TRANSITION);
        for(Object object0: list0) {
            Preconditions.checkArgument(treeSet0.add(((ActivityTransition)object0)), String.format("Found duplicated transition: %s.", ((ActivityTransition)object0)));
        }
        this.zza = Collections.unmodifiableList(list0);
        this.zzb = s;
        this.zzc = list1 == null ? Collections.emptyList() : Collections.unmodifiableList(list1);
        this.zzd = s1;
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && Objects.equal(this.zza, ((ActivityTransitionRequest)object0).zza) && Objects.equal(this.zzb, ((ActivityTransitionRequest)object0).zzb) && Objects.equal(this.zzd, ((ActivityTransitionRequest)object0).zzd) && Objects.equal(this.zzc, ((ActivityTransitionRequest)object0).zzc);
    }

    @Override
    public int hashCode() {
        int v = this.zza.hashCode();
        int v1 = 0;
        int v2 = this.zzb == null ? 0 : this.zzb.hashCode();
        int v3 = this.zzc == null ? 0 : this.zzc.hashCode();
        String s = this.zzd;
        if(s != null) {
            v1 = s.hashCode();
        }
        return ((v * 0x1F + v2) * 0x1F + v3) * 0x1F + v1;
    }

    public void serializeToIntentExtra(Intent intent0) {
        Preconditions.checkNotNull(intent0);
        SafeParcelableSerializer.serializeToIntentExtra(this, intent0, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_REQUEST");
    }

    @Override
    public String toString() {
        return "ActivityTransitionRequest [mTransitions=" + this.zza + ", mTag=\'" + this.zzb + "\', mClients=" + this.zzc + ", mAttributionTag=" + this.zzd + ']';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel0, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel0, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final ActivityTransitionRequest zza(String s) {
        this.zzd = s;
        return this;
    }
}

