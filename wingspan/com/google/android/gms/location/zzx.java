package com.google.android.gms.location;

final class zzx implements zzan {
    private final FusedLocationProviderClient zza;
    private final zzap zzb;
    private final LocationCallback zzc;
    private final zzan zzd;

    zzx(FusedLocationProviderClient fusedLocationProviderClient0, zzap zzap0, LocationCallback locationCallback0, zzan zzan0) {
        this.zza = fusedLocationProviderClient0;
        this.zzb = zzap0;
        this.zzc = locationCallback0;
        this.zzd = zzan0;
    }

    @Override  // com.google.android.gms.location.zzan
    public final void zza() {
        zzan zzan0 = this.zzd;
        this.zzb.zzb(false);
        this.zza.removeLocationUpdates(this.zzc);
        if(zzan0 != null) {
            zzan0.zza();
        }
    }
}

