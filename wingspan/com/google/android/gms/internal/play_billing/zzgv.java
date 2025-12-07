package com.google.android.gms.internal.play_billing;

public enum zzgv implements zzdf {
    BROADCAST_ACTION_UNSPECIFIED(0),
    PURCHASES_UPDATED_ACTION(1),
    LOCAL_PURCHASES_UPDATED_ACTION(2),
    ALTERNATIVE_BILLING_ACTION(3);

    private static final zzdg zze;
    private final int zzg;

    static {
        zzgv.zze = new zzgt();
    }

    private zzgv(int v1) {
        this.zzg = v1;
    }

    @Override
    public final String toString() {
        return Integer.toString(this.zzg);
    }

    public final int zza() {
        return this.zzg;
    }
}

