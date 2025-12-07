package com.google.android.gms.internal.play_billing;

import java.io.IOException;

final class zzeo implements zzev {
    private final zzek zza;
    private final zzfm zzb;
    private final boolean zzc;
    private final zzcq zzd;

    private zzeo(zzfm zzfm0, zzcq zzcq0, zzek zzek0) {
        this.zzb = zzfm0;
        this.zzc = zzcq0.zzc(zzek0);
        this.zzd = zzcq0;
        this.zza = zzek0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final int zza(Object object0) {
        Object object1 = this.zzb.zzd(object0);
        int v = this.zzb.zzb(object1);
        if(!this.zzc) {
            return v;
        }
        this.zzd.zza(object0);
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final int zzb(Object object0) {
        int v = this.zzb.zzd(object0).hashCode();
        if(!this.zzc) {
            return v;
        }
        this.zzd.zza(object0);
        throw null;
    }

    static zzeo zzc(zzfm zzfm0, zzcq zzcq0, zzek zzek0) {
        return new zzeo(zzfm0, zzcq0, zzek0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final Object zze() {
        zzek zzek0 = this.zza;
        return zzek0 instanceof zzdd ? ((zzdd)zzek0).zzj() : zzek0.zzo().zze();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final void zzf(Object object0) {
        this.zzb.zzg(object0);
        this.zzd.zzb(object0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final void zzg(Object object0, Object object1) {
        zzex.zzp(this.zzb, object0, object1);
        if(!this.zzc) {
            return;
        }
        this.zzd.zza(object1);
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final void zzh(Object object0, byte[] arr_b, int v, int v1, zzbp zzbp0) throws IOException {
        if(((zzdd)object0).zzc == zzfn.zzc()) {
            ((zzdd)object0).zzc = zzfn.zzf();
        }
        zzda zzda0 = (zzda)object0;
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final void zzi(Object object0, zzge zzge0) throws IOException {
        this.zzd.zza(object0);
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final boolean zzj(Object object0, Object object1) {
        if(!this.zzb.zzd(object0).equals(this.zzb.zzd(object1))) {
            return false;
        }
        if(!this.zzc) {
            return true;
        }
        this.zzd.zza(object0);
        this.zzd.zza(object1);
        throw null;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzev
    public final boolean zzk(Object object0) {
        this.zzd.zza(object0);
        throw null;
    }
}

