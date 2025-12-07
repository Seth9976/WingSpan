package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzx extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String tag;
    public static final zzx zzmq;
    public static final zzx zzmr;
    public static final zzx zzms;
    public static final zzx zzmt;
    public static final zzx zzmu;
    public static final zzx zzmv;
    public static final zzx zzmw;
    private static final zzx zzmx;
    public static final zzx zzmy;

    static {
        zzx.CREATOR = new zzy();
        zzx.zzmq = new zzx("=");
        zzx.zzmr = new zzx("<");
        zzx.zzms = new zzx("<=");
        zzx.zzmt = new zzx(">");
        zzx.zzmu = new zzx(">=");
        zzx.zzmv = new zzx("and");
        zzx.zzmw = new zzx("or");
        zzx.zzmx = new zzx("not");
        zzx.zzmy = new zzx("contains");
    }

    zzx(String s) {
        this.tag = s;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null && this.getClass() == object0.getClass()) {
            return this.tag == null ? ((zzx)object0).tag == null : this.tag.equals(((zzx)object0).tag);
        }
        return false;
    }

    public final String getTag() {
        return this.tag;
    }

    @Override
    public final int hashCode() {
        return this.tag == null ? 0x1F : this.tag.hashCode() + 0x1F;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.tag, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

