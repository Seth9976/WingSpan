package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public final class zzbe extends AbstractSafeParcelable implements Geofence {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final long zzb;
    private final short zzc;
    private final double zzd;
    private final double zze;
    private final float zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;

    static {
        zzbe.CREATOR = new zzbf();
    }

    public zzbe(String s, int v, short v1, double f, double f1, float f2, long v2, int v3, int v4) {
        if(s != null && s.length() <= 100) {
            if(f2 <= 0.0f) {
                throw new IllegalArgumentException("invalid radius: " + f2);
            }
            if(f > 90.0 || f < -90.0) {
                throw new IllegalArgumentException("invalid latitude: " + f);
            }
            if(f1 > 180.0 || f1 < -180.0) {
                throw new IllegalArgumentException("invalid longitude: " + f1);
            }
            if((v & 7) == 0) {
                throw new IllegalArgumentException("No supported transition specified: " + v);
            }
            this.zzc = v1;
            this.zza = s;
            this.zzd = f;
            this.zze = f1;
            this.zzf = f2;
            this.zzb = v2;
            this.zzg = v & 7;
            this.zzh = v3;
            this.zzi = v4;
            return;
        }
        String s1 = String.valueOf(s);
        throw new IllegalArgumentException((s1.length() == 0 ? new String("requestId is null or too long: ") : "requestId is null or too long: " + s1));
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzbe && this.zzf == ((zzbe)object0).zzf && this.zzd == ((zzbe)object0).zzd && this.zze == ((zzbe)object0).zze && this.zzc == ((zzbe)object0).zzc;
    }

    @Override  // com.google.android.gms.location.Geofence
    public final String getRequestId() {
        return this.zza;
    }

    @Override
    public final int hashCode() {
        long v = Double.doubleToLongBits(this.zzd);
        long v1 = Double.doubleToLongBits(this.zze);
        return ((((((int)(v ^ v >>> 0x20)) + 0x1F) * 0x1F + ((int)(v1 ^ v1 >>> 0x20))) * 0x1F + Float.floatToIntBits(this.zzf)) * 0x1F + this.zzc) * 0x1F + this.zzg;
    }

    @Override
    public final String toString() {
        String s;
        Locale locale0 = Locale.US;
        Object[] arr_object = new Object[9];
        switch(this.zzc) {
            case -1: {
                s = "INVALID";
                break;
            }
            case 1: {
                s = "CIRCLE";
                break;
            }
            default: {
                s = "UNKNOWN";
            }
        }
        arr_object[0] = s;
        arr_object[1] = this.zza.replaceAll("\\p{C}", "?");
        arr_object[2] = this.zzg;
        arr_object[3] = this.zzd;
        arr_object[4] = this.zze;
        arr_object[5] = this.zzf;
        arr_object[6] = (int)(this.zzh / 1000);
        arr_object[7] = this.zzi;
        arr_object[8] = this.zzb;
        return String.format(locale0, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", arr_object);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeLong(parcel0, 2, this.zzb);
        SafeParcelWriter.writeShort(parcel0, 3, this.zzc);
        SafeParcelWriter.writeDouble(parcel0, 4, this.zzd);
        SafeParcelWriter.writeDouble(parcel0, 5, this.zze);
        SafeParcelWriter.writeFloat(parcel0, 6, this.zzf);
        SafeParcelWriter.writeInt(parcel0, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel0, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel0, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

