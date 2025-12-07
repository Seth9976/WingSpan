package com.unity3d.plugin.downloader.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class b implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public long a;
    public long b;
    public long c;
    public float d;

    static {
        b.CREATOR = new c();
    }

    public b(long v, long v1, long v2, float f) {
        this.a = v;
        this.b = v1;
        this.c = v2;
        this.d = f;
    }

    public b(Parcel parcel0) {
        this.a = parcel0.readLong();
        this.b = parcel0.readLong();
        this.c = parcel0.readLong();
        this.d = parcel0.readFloat();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeLong(this.a);
        parcel0.writeLong(this.b);
        parcel0.writeLong(this.c);
        parcel0.writeFloat(this.d);
    }
}

