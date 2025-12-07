package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

public class SleepSegmentRequest extends AbstractSafeParcelable {
    public static final int CLASSIFY_EVENTS_ONLY = 2;
    public static final Parcelable.Creator CREATOR = null;
    public static final int SEGMENT_AND_CLASSIFY_EVENTS = 0;
    public static final int SEGMENT_EVENTS_ONLY = 1;
    private final List zza;
    private final int zzb;

    static {
        SleepSegmentRequest.CREATOR = new zzbw();
    }

    public SleepSegmentRequest(int v) {
        this(null, v);
    }

    public SleepSegmentRequest(List list0, int v) {
        this.zza = list0;
        this.zzb = v;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof SleepSegmentRequest ? Objects.equal(this.zza, ((SleepSegmentRequest)object0).zza) && this.zzb == ((SleepSegmentRequest)object0).zzb : false;
    }

    public static SleepSegmentRequest getDefaultSleepSegmentRequest() {
        return new SleepSegmentRequest(null, 0);
    }

    public int getRequestedDataType() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        Preconditions.checkNotNull(parcel0);
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel0, 2, this.getRequestedDataType());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

