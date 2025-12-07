package com.google.android.gms.internal.play_billing;

public enum zzgc {
    DOUBLE(zzgd.zzd, 1),
    FLOAT(zzgd.zzc, 5),
    INT64(zzgd.zzb, 0),
    UINT64(zzgd.zzb, 0),
    INT32(zzgd.zza, 0),
    FIXED64(zzgd.zzb, 1),
    FIXED32(zzgd.zza, 5),
    BOOL(zzgd.zze, 0),
    STRING(zzgd.zzf, 2),
    GROUP(zzgd.zzi, 3),
    MESSAGE(zzgd.zzi, 2),
    BYTES(zzgd.zzg, 2),
    UINT32(zzgd.zza, 0),
    ENUM(zzgd.zzh, 0),
    SFIXED32(zzgd.zza, 5),
    SFIXED64(zzgd.zzb, 1),
    SINT32(zzgd.zza, 0),
    SINT64(zzgd.zzb, 0);

    private final zzgd zzt;

    private zzgc(zzgd zzgd0, int v1) {
        this.zzt = zzgd0;
    }

    public final zzgd zza() {
        return this.zzt;
    }
}

