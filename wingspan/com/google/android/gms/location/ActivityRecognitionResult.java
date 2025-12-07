package com.google.android.gms.location;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;

public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    List zza;
    long zzb;
    long zzc;
    int zzd;
    Bundle zze;

    static {
        ActivityRecognitionResult.CREATOR = new zzk();
    }

    public ActivityRecognitionResult(DetectedActivity detectedActivity0, long v, long v1) {
        this(Collections.singletonList(detectedActivity0), v, v1, 0, null);
    }

    public ActivityRecognitionResult(List list0, long v, long v1) {
        this(list0, v, v1, 0, null);
    }

    public ActivityRecognitionResult(List list0, long v, long v1, int v2, Bundle bundle0) {
        boolean z = true;
        Preconditions.checkArgument(list0 != null && list0.size() > 0, "Must have at least 1 detected activity");
        if(v <= 0L || v1 <= 0L) {
            z = false;
        }
        Preconditions.checkArgument(z, "Must set times");
        this.zza = list0;
        this.zzb = v;
        this.zzc = v1;
        this.zzd = v2;
        this.zze = bundle0;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 != null && this.getClass() == object0.getClass() && this.zzb == ((ActivityRecognitionResult)object0).zzb && this.zzc == ((ActivityRecognitionResult)object0).zzc && this.zzd == ((ActivityRecognitionResult)object0).zzd && Objects.equal(this.zza, ((ActivityRecognitionResult)object0).zza) && ActivityRecognitionResult.zzb(this.zze, ((ActivityRecognitionResult)object0).zze);
    }

    public static ActivityRecognitionResult extractResult(Intent intent0) {
        ActivityRecognitionResult activityRecognitionResult0;
        if(ActivityRecognitionResult.hasResult(intent0)) {
            Bundle bundle0 = intent0.getExtras();
            if(bundle0 == null) {
                activityRecognitionResult0 = null;
            }
            else {
                Object object0 = bundle0.get("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT");
                if(object0 instanceof byte[]) {
                    activityRecognitionResult0 = (ActivityRecognitionResult)SafeParcelableSerializer.deserializeFromBytes(((byte[])object0), ActivityRecognitionResult.CREATOR);
                }
                else if(object0 instanceof ActivityRecognitionResult) {
                    activityRecognitionResult0 = (ActivityRecognitionResult)object0;
                }
                else {
                    activityRecognitionResult0 = null;
                }
            }
        }
        else {
            activityRecognitionResult0 = null;
        }
        if(activityRecognitionResult0 != null) {
            return activityRecognitionResult0;
        }
        List list0 = ActivityRecognitionResult.zza(intent0);
        return list0 == null || list0.isEmpty() ? null : ((ActivityRecognitionResult)list0.get(list0.size() - 1));
    }

    public int getActivityConfidence(int v) {
        for(Object object0: this.zza) {
            DetectedActivity detectedActivity0 = (DetectedActivity)object0;
            if(detectedActivity0.getType() == v) {
                return detectedActivity0.getConfidence();
            }
            if(false) {
                break;
            }
        }
        return 0;
    }

    public long getElapsedRealtimeMillis() {
        return this.zzc;
    }

    public DetectedActivity getMostProbableActivity() {
        return (DetectedActivity)this.zza.get(0);
    }

    public List getProbableActivities() {
        return this.zza;
    }

    public long getTime() {
        return this.zzb;
    }

    public static boolean hasResult(Intent intent0) {
        if(intent0 == null) {
            return false;
        }
        if(intent0.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT")) {
            return true;
        }
        List list0 = ActivityRecognitionResult.zza(intent0);
        return list0 != null && !list0.isEmpty();
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zzc, this.zzd, this.zza, this.zze});
    }

    @Override
    public String toString() {
        return "ActivityRecognitionResult [probableActivities=" + this.zza + ", timeMillis=" + this.zzb + ", elapsedRealtimeMillis=" + this.zzc + "]";
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeTypedList(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzd);
        SafeParcelWriter.writeBundle(parcel0, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static List zza(Intent intent0) {
        return intent0 != null && intent0.hasExtra("com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST") ? SafeParcelableSerializer.deserializeIterableFromIntentExtra(intent0, "com.google.android.location.internal.EXTRA_ACTIVITY_RESULT_LIST", ActivityRecognitionResult.CREATOR) : null;
    }

    private static boolean zzb(Bundle bundle0, Bundle bundle1) {
        if(bundle0 == null) {
            return bundle1 == null;
        }
        if(bundle1 == null) {
            return false;
        }
        if(bundle0.size() != bundle1.size()) {
            return false;
        }
        for(Object object0: bundle0.keySet()) {
            String s = (String)object0;
            if(!bundle1.containsKey(s)) {
                return false;
            }
            Object object1 = bundle0.get(s);
            Object object2 = bundle1.get(s);
            if(object1 == null) {
                if(object2 == null) {
                    continue;
                }
                return false;
            }
            if(object1 instanceof Bundle) {
                if(ActivityRecognitionResult.zzb(bundle0.getBundle(s), bundle1.getBundle(s))) {
                    continue;
                }
                return false;
            }
            if(object1.getClass().isArray()) {
                if(object2 != null && object2.getClass().isArray()) {
                    int v = Array.getLength(object1);
                    if(v == Array.getLength(object2)) {
                        for(int v1 = 0; v1 < v; ++v1) {
                            if(!Objects.equal(Array.get(object1, v1), Array.get(object2, v1))) {
                                return false;
                            }
                        }
                        continue;
                    }
                }
                return false;
            }
            if(!object1.equals(object2)) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }
}

