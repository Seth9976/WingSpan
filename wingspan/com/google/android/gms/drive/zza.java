package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.drive.zzez;
import com.google.android.gms.internal.drive.zzkk;

public class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final long zze;
    private final long zzf;
    private final long zzg;
    private volatile String zzh;

    static {
        zza.CREATOR = new zzb();
    }

    public zza(long v, long v1, long v2) {
        this.zzh = null;
        boolean z = true;
        Preconditions.checkArgument(Long.compare(v, -1L) != 0);
        Preconditions.checkArgument(v1 != -1L);
        if(v2 == -1L) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.zze = v;
        this.zzf = v1;
        this.zzg = v2;
    }

    @Override
    public boolean equals(Object object0) {
        return object0 != null && object0.getClass() == zza.class && ((zza)object0).zzf == this.zzf && ((zza)object0).zzg == this.zzg && ((zza)object0).zze == this.zze;
    }

    @Override
    public int hashCode() {
        return (this.zze + String.valueOf(this.zzf) + this.zzg).hashCode();
    }

    @Override
    public String toString() {
        if(this.zzh == null) {
            String s = Base64.encodeToString(((zzez)(((zzkk)zzez.zzaj().zzk(1).zzc(this.zze).zzd(this.zzf).zze(this.zzg).zzdf()))).toByteArray(), 10);
            this.zzh = s.length() == 0 ? new String("ChangeSequenceNumber:") : "ChangeSequenceNumber:" + s;
        }
        return this.zzh;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 2, this.zze);
        SafeParcelWriter.writeLong(parcel0, 3, this.zzf);
        SafeParcelWriter.writeLong(parcel0, 4, this.zzg);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

