package com.google.android.gms.internal.play_billing;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class zzay extends zzba {
    private final ByteBuffer zza;

    zzay() {
        this.zza = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final zzbe zza(char c) {
        this.zza.putChar(c);
        try {
            this.zzb(this.zza.array(), 0, 2);
            return this;
        }
        finally {
            this.zza.clear();
        }
    }

    protected void zzb(byte[] arr_b, int v, int v1) {
        throw null;
    }
}

