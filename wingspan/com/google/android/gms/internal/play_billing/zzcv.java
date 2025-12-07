package com.google.android.gms.internal.play_billing;

public enum zzcv {
    DOUBLE(0, 1, zzdo.zze),
    FLOAT(1, 1, zzdo.zzd),
    INT64(2, 1, zzdo.zzc),
    UINT64(3, 1, zzdo.zzc),
    INT32(4, 1, zzdo.zzb),
    FIXED64(5, 1, zzdo.zzc),
    FIXED32(6, 1, zzdo.zzb),
    BOOL(7, 1, zzdo.zzf),
    STRING(8, 1, zzdo.zzg),
    MESSAGE(9, 1, zzdo.zzj),
    BYTES(10, 1, zzdo.zzh),
    UINT32(11, 1, zzdo.zzb),
    ENUM(12, 1, zzdo.zzi),
    SFIXED32(13, 1, zzdo.zzb),
    SFIXED64(14, 1, zzdo.zzc),
    SINT32(15, 1, zzdo.zzb),
    SINT64(16, 1, zzdo.zzc),
    GROUP(17, 1, zzdo.zzj),
    DOUBLE_LIST(18, 2, zzdo.zze),
    FLOAT_LIST(19, 2, zzdo.zzd),
    INT64_LIST(20, 2, zzdo.zzc),
    UINT64_LIST(21, 2, zzdo.zzc),
    INT32_LIST(22, 2, zzdo.zzb),
    FIXED64_LIST(23, 2, zzdo.zzc),
    FIXED32_LIST(24, 2, zzdo.zzb),
    BOOL_LIST(25, 2, zzdo.zzf),
    STRING_LIST(26, 2, zzdo.zzg),
    MESSAGE_LIST(27, 2, zzdo.zzj),
    BYTES_LIST(28, 2, zzdo.zzh),
    UINT32_LIST(29, 2, zzdo.zzb),
    ENUM_LIST(30, 2, zzdo.zzi),
    SFIXED32_LIST(0x1F, 2, zzdo.zzb),
    SFIXED64_LIST(0x20, 2, zzdo.zzc),
    SINT32_LIST(33, 2, zzdo.zzb),
    SINT64_LIST(34, 2, zzdo.zzc),
    DOUBLE_LIST_PACKED(35, 3, zzdo.zze),
    FLOAT_LIST_PACKED(36, 3, zzdo.zzd),
    INT64_LIST_PACKED(37, 3, zzdo.zzc),
    UINT64_LIST_PACKED(38, 3, zzdo.zzc),
    INT32_LIST_PACKED(39, 3, zzdo.zzb),
    FIXED64_LIST_PACKED(40, 3, zzdo.zzc),
    FIXED32_LIST_PACKED(41, 3, zzdo.zzb),
    BOOL_LIST_PACKED(42, 3, zzdo.zzf),
    UINT32_LIST_PACKED(43, 3, zzdo.zzb),
    ENUM_LIST_PACKED(44, 3, zzdo.zzi),
    SFIXED32_LIST_PACKED(45, 3, zzdo.zzb),
    SFIXED64_LIST_PACKED(46, 3, zzdo.zzc),
    SINT32_LIST_PACKED(0x2F, 3, zzdo.zzb),
    SINT64_LIST_PACKED(0x30, 3, zzdo.zzc),
    GROUP_LIST(49, 2, zzdo.zzj),
    MAP(50, 4, zzdo.zza);

    private static final zzcv[] zzZ;
    private final zzdo zzab;
    private final int zzac;
    private final Class zzad;

    static {
        zzcv[] arr_zzcv = (zzcv[])zzcv.zzaa.clone();
        zzcv.zzZ = new zzcv[arr_zzcv.length];
        for(int v = 0; v < arr_zzcv.length; ++v) {
            zzcv zzcv0 = arr_zzcv[v];
            zzcv.zzZ[zzcv0.zzac] = zzcv0;
        }
    }

    private zzcv(int v1, int v2, zzdo zzdo0) {
        this.zzac = v1;
        this.zzab = zzdo0;
        switch(v2 - 1) {
            case 1: {
                this.zzad = zzdo0.zza();
                break;
            }
            case 3: {
                this.zzad = zzdo0.zza();
                break;
            }
            default: {
                this.zzad = null;
            }
        }
        if(v2 == 1) {
            zzdo0.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}

