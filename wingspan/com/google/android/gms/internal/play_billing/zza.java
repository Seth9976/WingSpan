package com.google.android.gms.internal.play_billing;

enum zza {
    RESPONSE_CODE_UNSPECIFIED(-999),
    SERVICE_TIMEOUT(-3),
    FEATURE_NOT_SUPPORTED(-2),
    SERVICE_DISCONNECTED(-1),
    OK(0),
    USER_CANCELED(1),
    SERVICE_UNAVAILABLE(2),
    BILLING_UNAVAILABLE(3),
    ITEM_UNAVAILABLE(4),
    DEVELOPER_ERROR(5),
    ERROR(6),
    ITEM_ALREADY_OWNED(7),
    ITEM_NOT_OWNED(8),
    EXPIRED_OFFER_TOKEN(11),
    NETWORK_ERROR(12);

    private static final zzal zzp;
    private final int zzr;

    static {
        zzak zzak0 = new zzak();
        zza[] arr_zza = (zza[])zza.zzq.clone();
        for(int v = 0; v < arr_zza.length; ++v) {
            zza zza0 = arr_zza[v];
            zzak0.zza(zza0.zzr, zza0);
        }
        zza.zzp = zzak0.zzb();
    }

    private zza(int v1) {
        this.zzr = v1;
    }

    static zza zza(int v) {
        Integer integer0 = v;
        return zza.zzp.containsKey(integer0) ? ((zza)zza.zzp.get(integer0)) : zza.zza;
    }
}

