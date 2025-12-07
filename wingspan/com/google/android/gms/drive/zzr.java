package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private int accountType;
    private String zzbg;
    private String zzbh;
    private String zzbi;
    private int zzbj;
    private boolean zzbk;

    static {
        zzr.CREATOR = new zzs();
    }

    public zzr(String s, int v, String s1, String s2, int v1, boolean z) {
        this.zzbg = s;
        this.accountType = v;
        this.zzbh = s1;
        this.zzbi = s2;
        this.zzbj = v1;
        this.zzbk = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0.getClass() == this.getClass()) {
            return object0 == this ? true : Objects.equal(this.zzbg, ((zzr)object0).zzbg) && this.accountType == ((zzr)object0).accountType && this.zzbj == ((zzr)object0).zzbj && this.zzbk == ((zzr)object0).zzbk;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzbg, this.accountType, this.zzbj, Boolean.valueOf(this.zzbk)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, (zzr.zzb(this.accountType) ? this.zzbg : null), false);
        int v2 = -1;
        SafeParcelWriter.writeInt(parcel0, 3, (zzr.zzb(this.accountType) ? this.accountType : -1));
        SafeParcelWriter.writeString(parcel0, 4, this.zzbh, false);
        SafeParcelWriter.writeString(parcel0, 5, this.zzbi, false);
        int v3 = this.zzbj;
        if(v3 == 0 || v3 == 1 || v3 == 2 || v3 == 3) {
            v2 = v3;
        }
        SafeParcelWriter.writeInt(parcel0, 6, v2);
        SafeParcelWriter.writeBoolean(parcel0, 7, this.zzbk);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    private static boolean zzb(int v) {
        return v == 0x100 || v == 0x101 || v == 0x102;
    }
}

