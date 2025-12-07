package com.android.billingclient.api;

public final class zzcl {
    private boolean zza;

    private zzcl() {
    }

    zzcl(zzck zzck0) {
    }

    public final zzcl zza() {
        this.zza = true;
        return this;
    }

    public final zzcn zzb() {
        if(!this.zza) {
            throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
        }
        return new zzcn(true, false, null);
    }
}

