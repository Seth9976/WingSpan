package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;

public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    final int status;
    final int zzct;
    final long zzcw;
    final long zzcx;
    final DriveId zzk;

    static {
        zzh.CREATOR = new zzi();
    }

    public zzh(int v, DriveId driveId0, int v1, long v2, long v3) {
        this.zzct = v;
        this.zzk = driveId0;
        this.status = v1;
        this.zzcw = v2;
        this.zzcx = v3;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == this.getClass()) {
            return object0 == this ? true : this.zzct == ((zzh)object0).zzct && Objects.equal(this.zzk, ((zzh)object0).zzk) && this.status == ((zzh)object0).status && this.zzcw == ((zzh)object0).zzcw && this.zzcx == ((zzh)object0).zzcx;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzct, this.zzk, this.status, this.zzcw, this.zzcx});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.zzct);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzk, v, false);
        SafeParcelWriter.writeInt(parcel0, 4, this.status);
        SafeParcelWriter.writeLong(parcel0, 5, this.zzcw);
        SafeParcelWriter.writeLong(parcel0, 6, this.zzcx);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

