package com.google.android.gms.internal.play_billing;

import java.io.Serializable;

final class zzbb extends zzbc implements Serializable {
    final byte[] zza;

    zzbb(byte[] arr_b) {
        arr_b.getClass();
        this.zza = arr_b;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbc
    public final int zza() {
        byte[] arr_b = this.zza;
        if(arr_b.length < 4) {
            throw new IllegalStateException(zzab.zza("HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", new Object[]{((int)arr_b.length)}));
        }
        return (arr_b[3] & 0xFF) << 24 | (arr_b[0] & 0xFF | (arr_b[1] & 0xFF) << 8 | (arr_b[2] & 0xFF) << 16);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbc
    public final int zzb() {
        return this.zza.length * 8;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbc
    final boolean zzc(zzbc zzbc0) {
        byte[] arr_b = zzbc0.zzd();
        if(this.zza.length == arr_b.length) {
            boolean z = true;
            for(int v = 0; true; ++v) {
                byte[] arr_b1 = this.zza;
                if(v >= arr_b1.length) {
                    break;
                }
                z &= arr_b1[v] == zzbc0.zzd()[v];
            }
            return z;
        }
        return false;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbc
    final byte[] zzd() {
        return this.zza;
    }
}

