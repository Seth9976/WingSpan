package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int zza;
    long zzb;
    long zzc;
    boolean zzd;
    long zze;
    int zzf;
    float zzg;
    long zzh;
    boolean zzi;

    static {
        LocationRequest.CREATOR = new zzbf();
    }

    @Deprecated
    public LocationRequest() {
        this.zza = 102;
        this.zzb = 3600000L;
        this.zzc = 600000L;
        this.zzd = false;
        this.zze = 0x7FFFFFFFFFFFFFFFL;
        this.zzf = 0x7FFFFFFF;
        this.zzg = 0.0f;
        this.zzh = 0L;
        this.zzi = false;
    }

    LocationRequest(int v, long v1, long v2, boolean z, long v3, int v4, float f, long v5, boolean z1) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = v2;
        this.zzd = z;
        this.zze = v3;
        this.zzf = v4;
        this.zzg = f;
        this.zzh = v5;
        this.zzi = z1;
    }

    public static LocationRequest create() {
        LocationRequest locationRequest0 = new LocationRequest();
        locationRequest0.setWaitForAccurateLocation(true);
        return locationRequest0;
    }

    @Override
    public boolean equals(Object object0) {
        return object0 instanceof LocationRequest && this.zza == ((LocationRequest)object0).zza && this.zzb == ((LocationRequest)object0).zzb && this.zzc == ((LocationRequest)object0).zzc && this.zzd == ((LocationRequest)object0).zzd && this.zze == ((LocationRequest)object0).zze && this.zzf == ((LocationRequest)object0).zzf && this.zzg == ((LocationRequest)object0).zzg && this.getMaxWaitTime() == ((LocationRequest)object0).getMaxWaitTime() && this.zzi == ((LocationRequest)object0).zzi;
    }

    public long getExpirationTime() {
        return this.zze;
    }

    public long getFastestInterval() {
        return this.zzc;
    }

    public long getInterval() {
        return this.zzb;
    }

    public long getMaxWaitTime() {
        return this.zzh >= this.zzb ? this.zzh : this.zzb;
    }

    public int getNumUpdates() {
        return this.zzf;
    }

    public int getPriority() {
        return this.zza;
    }

    public float getSmallestDisplacement() {
        return this.zzg;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzg, this.zzh});
    }

    public boolean isFastestIntervalExplicitlySet() {
        return this.zzd;
    }

    public boolean isWaitForAccurateLocation() {
        return this.zzi;
    }

    public LocationRequest setExpirationDuration(long v) {
        long v1 = SystemClock.elapsedRealtime();
        long v2 = v > 0x7FFFFFFFFFFFFFFFL - v1 ? 0x7FFFFFFFFFFFFFFFL : v + v1;
        this.zze = v2;
        if(v2 < 0L) {
            this.zze = 0L;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long v) {
        this.zze = v;
        if(v < 0L) {
            this.zze = 0L;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long v) {
        LocationRequest.zza(v);
        this.zzd = true;
        this.zzc = v;
        return this;
    }

    public LocationRequest setInterval(long v) {
        LocationRequest.zza(v);
        this.zzb = v;
        if(!this.zzd) {
            this.zzc = (long)(((double)v) / 6.0);
        }
        return this;
    }

    public LocationRequest setMaxWaitTime(long v) {
        LocationRequest.zza(v);
        this.zzh = v;
        return this;
    }

    public LocationRequest setNumUpdates(int v) {
        if(v <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + v);
        }
        this.zzf = v;
        return this;
    }

    public LocationRequest setPriority(int v) {
        if(v != 100 && v != 102 && v != 104 && v != 105) {
            throw new IllegalArgumentException("invalid quality: " + v);
        }
        this.zza = v;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float f) {
        if(f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
        this.zzg = f;
        return this;
    }

    public LocationRequest setWaitForAccurateLocation(boolean z) {
        this.zzi = z;
        return this;
    }

    @Override
    public String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("Request[");
        switch(this.zza) {
            case 100: {
                s = "PRIORITY_HIGH_ACCURACY";
                break;
            }
            case 102: {
                s = "PRIORITY_BALANCED_POWER_ACCURACY";
                break;
            }
            case 104: {
                s = "PRIORITY_LOW_POWER";
                break;
            }
            case 105: {
                s = "PRIORITY_NO_POWER";
                break;
            }
            default: {
                s = "???";
            }
        }
        stringBuilder0.append(s);
        if(this.zza != 105) {
            stringBuilder0.append(" requested=");
            stringBuilder0.append(this.zzb);
            stringBuilder0.append("ms");
        }
        stringBuilder0.append(" fastest=");
        stringBuilder0.append(this.zzc);
        stringBuilder0.append("ms");
        if(this.zzh > this.zzb) {
            stringBuilder0.append(" maxWait=");
            stringBuilder0.append(this.zzh);
            stringBuilder0.append("ms");
        }
        if(this.zzg > 0.0f) {
            stringBuilder0.append(" smallestDisplacement=");
            stringBuilder0.append(this.zzg);
            stringBuilder0.append("m");
        }
        long v = this.zze;
        if(v != 0x7FFFFFFFFFFFFFFFL) {
            long v1 = SystemClock.elapsedRealtime();
            stringBuilder0.append(" expireIn=");
            stringBuilder0.append(v - v1);
            stringBuilder0.append("ms");
        }
        if(this.zzf != 0x7FFFFFFF) {
            stringBuilder0.append(" num=");
            stringBuilder0.append(this.zzf);
        }
        stringBuilder0.append(']');
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzd);
        SafeParcelWriter.writeLong(parcel0, 5, this.zze);
        SafeParcelWriter.writeInt(parcel0, 6, this.zzf);
        SafeParcelWriter.writeFloat(parcel0, 7, this.zzg);
        SafeParcelWriter.writeLong(parcel0, 8, this.zzh);
        SafeParcelWriter.writeBoolean(parcel0, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    private static void zza(long v) {
        if(v < 0L) {
            throw new IllegalArgumentException("invalid interval: " + v);
        }
    }
}

