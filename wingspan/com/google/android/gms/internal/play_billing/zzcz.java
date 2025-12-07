package com.google.android.gms.internal.play_billing;

public class zzcz extends zzbl {
    protected zzdd zza;
    private final zzdd zzb;

    protected zzcz(zzdd zzdd0) {
        this.zzb = zzdd0;
        if(zzdd0.zzx()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = zzdd0.zzj();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbl
    public final Object clone() throws CloneNotSupportedException {
        return this.zzb();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbl
    public final zzbl zza() {
        return this.zzb();
    }

    public final zzcz zzb() {
        zzcz zzcz0 = (zzcz)this.zzb.zzy(5, null, null);
        zzcz0.zza = this.zzd();
        return zzcz0;
    }

    public final zzdd zzc() {
        zzdd zzdd0 = this.zzd();
        if(!zzdd0.zzw()) {
            throw new zzfl(zzdd0);
        }
        return zzdd0;
    }

    public zzdd zzd() {
        if(!this.zza.zzx()) {
            return this.zza;
        }
        this.zza.zzr();
        return this.zza;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzej
    public zzek zze() {
        return this.zzd();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzel
    public final zzek zzf() {
        throw null;
    }

    protected final void zzg() {
        if(!this.zza.zzx()) {
            this.zzh();
        }
    }

    protected void zzh() {
        zzdd zzdd0 = this.zzb.zzj();
        zzdd zzdd1 = this.zza;
        zzes.zza().zzb(zzdd0.getClass()).zzg(zzdd0, zzdd1);
        this.zza = zzdd0;
    }
}

