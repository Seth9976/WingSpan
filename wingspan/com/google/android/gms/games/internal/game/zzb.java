package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;

final class zzb extends zzc {
    @Override  // com.google.android.gms.games.internal.game.zzc
    public final Object createFromParcel(Parcel parcel0) {
        return this.zza(parcel0);
    }

    @Override  // com.google.android.gms.games.internal.game.zzc
    public final GameBadgeEntity zza(Parcel parcel0) {
        if(!GameBadgeEntity.zzp(GameBadgeEntity.getUnparcelClientVersion()) && !GameBadgeEntity.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName())) {
            int v = parcel0.readInt();
            String s = parcel0.readString();
            String s1 = parcel0.readString();
            String s2 = parcel0.readString();
            return s2 == null ? new GameBadgeEntity(v, s, s1, null) : new GameBadgeEntity(v, s, s1, Uri.parse(s2));
        }
        return super.zza(parcel0);
    }
}

