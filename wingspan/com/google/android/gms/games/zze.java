package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

final class zze extends zzf {
    @Override  // com.google.android.gms.games.zzf
    public final Object createFromParcel(Parcel parcel0) {
        return this.zza(parcel0);
    }

    @Override  // com.google.android.gms.games.zzf
    public final GameEntity zza(Parcel parcel0) {
        if(!GameEntity.zzp(GameEntity.getUnparcelClientVersion()) && !GameEntity.canUnparcelSafely(GameEntity.class.getCanonicalName())) {
            String s = parcel0.readString();
            String s1 = parcel0.readString();
            String s2 = parcel0.readString();
            String s3 = parcel0.readString();
            String s4 = parcel0.readString();
            String s5 = parcel0.readString();
            String s6 = parcel0.readString();
            Uri uri0 = s6 == null ? null : Uri.parse(s6);
            String s7 = parcel0.readString();
            Uri uri1 = s7 == null ? null : Uri.parse(s7);
            String s8 = parcel0.readString();
            Uri uri2 = s8 == null ? null : Uri.parse(s8);
            boolean z = parcel0.readInt() > 0;
            return parcel0.readInt() <= 0 ? new GameEntity(s, s1, s2, s3, s4, s5, uri0, uri1, uri2, z, false, parcel0.readString(), parcel0.readInt(), parcel0.readInt(), parcel0.readInt(), false, false, null, null, null, false, false, false, null, false) : new GameEntity(s, s1, s2, s3, s4, s5, uri0, uri1, uri2, z, true, parcel0.readString(), parcel0.readInt(), parcel0.readInt(), parcel0.readInt(), false, false, null, null, null, false, false, false, null, false);
        }
        return super.zza(parcel0);
    }
}

