package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

final class zzr extends zzs {
    @Override  // com.google.android.gms.games.zzs
    public final Object createFromParcel(Parcel parcel0) {
        return this.zza(parcel0);
    }

    @Override  // com.google.android.gms.games.zzs
    public final PlayerEntity zza(Parcel parcel0) {
        if(!PlayerEntity.zzp(PlayerEntity.getUnparcelClientVersion()) && !PlayerEntity.canUnparcelSafely(PlayerEntity.class.getCanonicalName())) {
            String s = parcel0.readString();
            String s1 = parcel0.readString();
            String s2 = parcel0.readString();
            String s3 = parcel0.readString();
            long v = parcel0.readLong();
            String s4 = parcel0.readString();
            String s5 = parcel0.readString();
            Uri uri0 = s2 == null ? null : Uri.parse(s2);
            return s3 == null ? new PlayerEntity(s, s1, uri0, null, v, -1, -1L, null, null, null, null, null, true, false, s4, s5, null, null, null, null, -1L, null, null, false, null) : new PlayerEntity(s, s1, uri0, Uri.parse(s3), v, -1, -1L, null, null, null, null, null, true, false, s4, s5, null, null, null, null, -1L, null, null, false, null);
        }
        return super.zza(parcel0);
    }
}

