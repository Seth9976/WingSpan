package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;

public final class zzfh extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private long id;
    private int type;
    private ParcelFileDescriptor zzdv;
    private String zzdw;
    private long zzdx;
    private ParcelFileDescriptor zzdy;
    private byte[] zzy;

    static {
        zzfh.CREATOR = new zzfk();
    }

    private zzfh() {
        this.zzdx = -1L;
    }

    zzfh(long v, int v1, byte[] arr_b, ParcelFileDescriptor parcelFileDescriptor0, String s, long v2, ParcelFileDescriptor parcelFileDescriptor1) {
        this.id = v;
        this.type = v1;
        this.zzy = arr_b;
        this.zzdv = parcelFileDescriptor0;
        this.zzdw = s;
        this.zzdx = v2;
        this.zzdy = parcelFileDescriptor1;
    }

    zzfh(zzfi zzfi0) {
    }

    // 去混淆评级： 中等(90)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzfh && Objects.equal(this.id, ((zzfh)object0).id) && Objects.equal(this.type, ((zzfh)object0).type) && Arrays.equals(this.zzy, ((zzfh)object0).zzy) && Objects.equal(this.zzdv, ((zzfh)object0).zzdv) && Objects.equal(this.zzdw, ((zzfh)object0).zzdw) && Objects.equal(this.zzdx, ((zzfh)object0).zzdx) && Objects.equal(this.zzdy, ((zzfh)object0).zzdy);
    }

    public final byte[] getBytes() {
        return this.zzy;
    }

    public final long getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.id, this.type, Arrays.hashCode(this.zzy), this.zzdv, this.zzdw, this.zzdx, this.zzdy});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeLong(parcel0, 1, this.id);
        SafeParcelWriter.writeInt(parcel0, 2, this.type);
        SafeParcelWriter.writeByteArray(parcel0, 3, this.zzy, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzdv, v, false);
        SafeParcelWriter.writeString(parcel0, 5, this.zzdw, false);
        SafeParcelWriter.writeLong(parcel0, 6, this.zzdx);
        SafeParcelWriter.writeParcelable(parcel0, 7, this.zzdy, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final ParcelFileDescriptor zzo() {
        return this.zzdv;
    }

    public final String zzp() {
        return this.zzdw;
    }

    public final long zzq() {
        return this.zzdx;
    }
}

