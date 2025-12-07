package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.messages.internal.zzg;
import com.google.android.gms.nearby.messages.internal.zzl;
import java.util.UUID;

public final class zzgu extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final int zzex;
    private final int zzgy;
    private final byte[] zzgz;
    private final boolean zzha;

    static {
        zzgu.CREATOR = new zzgv();
    }

    zzgu(int v, int v1, byte[] arr_b, boolean z) {
        this.zzex = v;
        this.zzgy = v1;
        this.zzgz = arr_b;
        this.zzha = z;
    }

    private zzgu(int v, byte[] arr_b) {
        this(1, v, arr_b, false);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zzgy);
        SafeParcelWriter.writeByteArray(parcel0, 2, this.zzgz, false);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzha);
        SafeParcelWriter.writeInt(parcel0, 1000, this.zzex);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static zzgu zza(UUID uUID0, Short short0, Short short1) {
        return new zzgu(3, new zzl(uUID0, short0, short1).getBytes());
    }

    public static zzgu zzb(String s, String s1) {
        String s2 = String.valueOf(s);
        if(s1 == null) {
            s1 = "";
        }
        String s3 = String.valueOf(s1);
        return s3.length() == 0 ? new zzgu(2, new zzg(new String(s2)).getBytes()) : new zzgu(2, new zzg(s2 + s3).getBytes());
    }
}

