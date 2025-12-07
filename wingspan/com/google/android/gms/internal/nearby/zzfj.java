package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;

public final class zzfj {
    private final zzfh zzdz;

    public zzfj() {
        this.zzdz = new zzfh(null);
    }

    public final zzfj zzb(long v) {
        this.zzdz.id = v;
        return this;
    }

    public final zzfj zzb(byte[] arr_b) {
        this.zzdz.zzy = arr_b;
        return this;
    }

    public final zzfj zzc(long v) {
        this.zzdz.zzdx = v;
        return this;
    }

    public final zzfj zzc(ParcelFileDescriptor parcelFileDescriptor0) {
        this.zzdz.zzdv = parcelFileDescriptor0;
        return this;
    }

    public final zzfj zzd(int v) {
        this.zzdz.type = v;
        return this;
    }

    public final zzfj zzd(ParcelFileDescriptor parcelFileDescriptor0) {
        this.zzdz.zzdy = parcelFileDescriptor0;
        return this;
    }

    public final zzfj zze(String s) {
        this.zzdz.zzdw = s;
        return this;
    }

    public final zzfh zzr() {
        return this.zzdz;
    }
}

