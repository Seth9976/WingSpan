package com.google.android.gms.games.multiplayer;

import android.os.Parcel;

final class zza extends zzb {
    @Override  // com.google.android.gms.games.multiplayer.zzb
    public final Object createFromParcel(Parcel parcel0) {
        return this.zza(parcel0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.multiplayer.zzb
    public final ParticipantEntity zza(Parcel parcel0) {
        return ParticipantEntity.zzp(ParticipantEntity.getUnparcelClientVersion()) || ParticipantEntity.canUnparcelSafely(ParticipantEntity.class.getCanonicalName()) ? super.zza(parcel0) : new ParticipantEntity();
    }
}

