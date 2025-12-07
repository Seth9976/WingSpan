package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;

public class StockProfileImageRef extends DataBufferRef implements StockProfileImage {
    @Override  // android.os.Parcelable
    public final int describeContents() {
        throw null;
    }

    @Override  // com.google.android.gms.common.data.Freezable
    public final Object freeze() {
        throw null;
    }

    @Override  // com.google.android.gms.games.internal.player.StockProfileImage
    public String getImageUrl() {
        throw null;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        throw null;
    }

    @Override  // com.google.android.gms.games.internal.player.StockProfileImage
    public final Uri zza() {
        throw null;
    }
}

