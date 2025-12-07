package com.google.android.gms.internal.play_billing;

public class zzdq {
    protected volatile zzek zza;
    private static final zzcp zzb;
    private volatile zzcc zzc;

    static {
        zzdq.zzb = zzcp.zza;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzdq)) {
            return false;
        }
        zzek zzek0 = this.zza;
        zzek zzek1 = ((zzdq)object0).zza;
        if(zzek0 == null && zzek1 == null) {
            return this.zzb().equals(((zzdq)object0).zzb());
        }
        if(zzek0 != null && zzek1 != null) {
            return zzek0.equals(zzek1);
        }
        if(zzek0 != null) {
            ((zzdq)object0).zzc(zzek0.zzf());
            return zzek0.equals(((zzdq)object0).zza);
        }
        this.zzc(zzek1.zzf());
        return this.zza.equals(zzek1);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if(this.zzc != null) {
            return ((zzbz)this.zzc).zza.length;
        }
        return this.zza == null ? 0 : this.zza.zzg();
    }

    public final zzcc zzb() {
        if(this.zzc != null) {
            return this.zzc;
        }
        synchronized(this) {
            if(this.zzc != null) {
                return this.zzc;
            }
            this.zzc = this.zza == null ? zzcc.zzb : this.zza.zzb();
            return this.zzc;
        }
    }

    protected final void zzc(zzek zzek0) {
        if(this.zza != null) {
            return;
        }
        synchronized(this) {
            if(this.zza != null) {
                return;
            }
            this.zza = zzek0;
            this.zzc = zzcc.zzb;
        }
    }
}

