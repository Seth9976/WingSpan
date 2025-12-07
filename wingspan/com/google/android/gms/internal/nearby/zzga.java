package com.google.android.gms.internal.nearby;

import com.google.android.gms.nearby.connection.AdvertisingOptions;

public final class zzga {
    private final zzfy zzek;

    public zzga() {
        this.zzek = new zzfy(null);
    }

    public final zzga zza(zzdd zzdd0) {
        this.zzek.zzei = zzdd0;
        return this;
    }

    public final zzga zza(zzec zzec0) {
        this.zzek.zzeh = zzec0;
        return this;
    }

    public final zzga zzb(zzdj zzdj0) {
        this.zzek.zzec = zzdj0;
        return this;
    }

    public final zzga zzd(long v) {
        this.zzek.durationMillis = v;
        return this;
    }

    public final zzga zzg(AdvertisingOptions advertisingOptions0) {
        this.zzek.zzej = advertisingOptions0;
        return this;
    }

    public final zzga zzi(String s) {
        this.zzek.name = s;
        return this;
    }

    public final zzga zzj(String s) {
        this.zzek.zzu = s;
        return this;
    }

    public final zzfy zzv() {
        return this.zzek;
    }
}

