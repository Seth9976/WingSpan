package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.games.Game;

public interface ExperienceEvent extends Parcelable, Freezable {
    @Deprecated
    String getIconImageUrl();

    int zza();

    int zzb();

    long zzc();

    long zzd();

    long zze();

    Uri zzf();

    Game zzg();

    String zzh();

    String zzi();

    String zzj();
}

