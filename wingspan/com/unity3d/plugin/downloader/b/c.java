package com.unity3d.plugin.downloader.b;

import android.os.Parcel;
import android.os.Parcelable.Creator;

final class c implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        return new b(parcel0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new b[v];
    }
}

