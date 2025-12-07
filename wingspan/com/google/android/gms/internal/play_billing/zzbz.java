package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.nio.charset.Charset;

class zzbz extends zzby {
    protected final byte[] zza;

    zzbz(byte[] arr_b) {
        arr_b.getClass();
        this.zza = arr_b;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcc
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof zzcc)) {
            return false;
        }
        if(this.zzd() != ((zzcc)object0).zzd()) {
            return false;
        }
        if(this.zzd() == 0) {
            return true;
        }
        if(object0 instanceof zzbz) {
            int v = this.zzk();
            int v1 = ((zzbz)object0).zzk();
            if(v != 0 && v1 != 0 && v != v1) {
                return false;
            }
            int v2 = this.zzd();
            if(v2 > ((zzbz)object0).zzd()) {
                throw new IllegalArgumentException("Length too large: " + v2 + this.zzd());
            }
            if(v2 > ((zzbz)object0).zzd()) {
                throw new IllegalArgumentException("Ran off end of other: 0, " + v2 + ", " + ((zzbz)object0).zzd());
            }
            if(((zzbz)object0) instanceof zzbz) {
                byte[] arr_b = this.zza;
                byte[] arr_b1 = ((zzbz)object0).zza;
                ((zzbz)object0).zzc();
                int v3 = 0;
                for(int v4 = 0; v3 < v2; ++v4) {
                    if(arr_b[v3] != arr_b1[v4]) {
                        return false;
                    }
                    ++v3;
                }
                return true;
            }
            return ((zzbz)object0).zzf(0, v2).equals(this.zzf(0, v2));
        }
        return object0.equals(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcc
    public byte zza(int v) {
        return this.zza[v];
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcc
    byte zzb(int v) {
        return this.zza[v];
    }

    protected int zzc() {
        return 0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcc
    public int zzd() {
        return this.zza.length;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcc
    protected final int zze(int v, int v1, int v2) {
        return zzdl.zzb(v, this.zza, 0, v2);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcc
    public final zzcc zzf(int v, int v1) {
        int v2 = zzbz.zzj(0, v1, this.zzd());
        return v2 == 0 ? zzcc.zzb : new zzbw(this.zza, 0, v2);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcc
    protected final String zzg(Charset charset0) {
        int v = this.zzd();
        return new String(this.zza, 0, v, charset0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcc
    final void zzh(zzbs zzbs0) throws IOException {
        int v = this.zzd();
        ((zzch)zzbs0).zzc(this.zza, 0, v);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcc
    public final boolean zzi() {
        int v = this.zzd();
        return zzgb.zze(this.zza, 0, v);
    }
}

