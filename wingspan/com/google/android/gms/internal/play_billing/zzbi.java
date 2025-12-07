package com.google.android.gms.internal.play_billing;

import java.security.MessageDigest;
import java.util.Arrays;

final class zzbi extends zzay {
    private final MessageDigest zza;
    private final int zzb;
    private boolean zzc;

    zzbi(MessageDigest messageDigest0, int v, zzbh zzbh0) {
        this.zza = messageDigest0;
        this.zzb = v;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzay
    protected final void zzb(byte[] arr_b, int v, int v1) {
        this.zzd();
        this.zza.update(arr_b, 0, 2);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbe
    public final zzbc zzc() {
        this.zzd();
        this.zzc = true;
        return this.zzb == this.zza.getDigestLength() ? new zzbb(this.zza.digest()) : new zzbb(Arrays.copyOf(this.zza.digest(), this.zzb));
    }

    private final void zzd() {
        if(!this.zzc == 0) {
            throw new IllegalStateException("Cannot re-use a Hasher after calling hash() on it");
        }
    }
}

