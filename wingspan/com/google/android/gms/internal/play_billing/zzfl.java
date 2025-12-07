package com.google.android.gms.internal.play_billing;

public final class zzfl extends RuntimeException {
    public zzfl(zzek zzek0) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzdn zza() {
        return new zzdn(this.getMessage());
    }
}

