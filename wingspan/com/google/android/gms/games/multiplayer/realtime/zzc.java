package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;

final class zzc extends zzd {
    @Override  // com.google.android.gms.games.multiplayer.realtime.zzd
    public final Object createFromParcel(Parcel parcel0) {
        return this.zza(parcel0);
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.games.multiplayer.realtime.zzd
    public final RoomEntity zza(Parcel parcel0) {
        return RoomEntity.zzp(RoomEntity.getUnparcelClientVersion()) || RoomEntity.canUnparcelSafely(RoomEntity.class.getCanonicalName()) ? super.zza(parcel0) : new RoomEntity();
    }
}

