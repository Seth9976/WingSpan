package com.google.android.gms.games;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public interface PlayerRelationshipInfo extends Parcelable, Freezable {
    int getFriendStatus();

    String zza();

    String zzb();

    String zzc();
}

