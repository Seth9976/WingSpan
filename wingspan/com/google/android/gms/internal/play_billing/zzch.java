package com.google.android.gms.internal.play_billing;

import java.io.IOException;

final class zzch extends zzck {
    private final byte[] zzb;
    private final int zzc;
    private int zzd;

    zzch(byte[] arr_b, int v, int v1) {
        super(null);
        if((arr_b.length - v1 | v1) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", ((int)arr_b.length), 0, v1));
        }
        this.zzb = arr_b;
        this.zzd = 0;
        this.zzc = v1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final int zza() {
        return this.zzc - this.zzd;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzb(byte b) throws IOException {
        try {
            int v = this.zzd;
            this.zzd = v + 1;
            this.zzb[v] = b;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzci(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), indexOutOfBoundsException0);
        }
    }

    public final void zzc(byte[] arr_b, int v, int v1) throws IOException {
        try {
            System.arraycopy(arr_b, 0, this.zzb, this.zzd, v1);
            this.zzd += v1;
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzci(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, v1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzd(int v, boolean z) throws IOException {
        this.zzq(v << 3);
        this.zzb(((byte)z));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zze(int v, zzcc zzcc0) throws IOException {
        this.zzq(v << 3 | 2);
        this.zzq(zzcc0.zzd());
        zzcc0.zzh(this);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzf(int v, int v1) throws IOException {
        this.zzq(v << 3 | 5);
        this.zzg(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzg(int v) throws IOException {
        try {
            int v1 = this.zzd + 1;
            this.zzb[this.zzd] = (byte)(v & 0xFF);
            this.zzb[v1] = (byte)(v >> 8 & 0xFF);
            this.zzb[v1 + 1] = (byte)(v >> 16 & 0xFF);
            this.zzd = v1 + 3;
            this.zzb[v1 + 2] = (byte)(v >> 24 & 0xFF);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzci(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzh(int v, long v1) throws IOException {
        this.zzq(v << 3 | 1);
        this.zzi(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzi(long v) throws IOException {
        try {
            int v1 = this.zzd + 1;
            this.zzb[this.zzd] = (byte)(((int)v) & 0xFF);
            this.zzb[v1] = (byte)(((int)(v >> 8)) & 0xFF);
            this.zzb[v1 + 1] = (byte)(((int)(v >> 16)) & 0xFF);
            this.zzb[v1 + 2] = (byte)(((int)(v >> 24)) & 0xFF);
            this.zzb[v1 + 3] = (byte)(((int)(v >> 0x20)) & 0xFF);
            this.zzb[v1 + 4] = (byte)(((int)(v >> 40)) & 0xFF);
            this.zzb[v1 + 5] = (byte)(((int)(v >> 0x30)) & 0xFF);
            this.zzd = v1 + 7;
            this.zzb[v1 + 6] = (byte)(((int)(v >> 56)) & 0xFF);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzci(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzj(int v, int v1) throws IOException {
        this.zzq(v << 3);
        this.zzk(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzk(int v) throws IOException {
        if(v >= 0) {
            this.zzq(v);
            return;
        }
        this.zzs(((long)v));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzl(byte[] arr_b, int v, int v1) throws IOException {
        this.zzc(arr_b, 0, v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzm(int v, String s) throws IOException {
        this.zzq(v << 3 | 2);
        this.zzn(s);
    }

    public final void zzn(String s) throws IOException {
        int v;
        try {
            v = this.zzd;
            int v1 = zzch.zzw(s.length() * 3);
            int v2 = zzch.zzw(s.length());
            if(v2 == v1) {
                int v3 = v + v2;
                this.zzd = v3;
                int v4 = zzgb.zzb(s, this.zzb, v3, this.zzc - v3);
                this.zzd = v;
                this.zzq(v4 - v - v2);
                this.zzd = v4;
                return;
            }
            this.zzq(zzgb.zzc(s));
            this.zzd = zzgb.zzb(s, this.zzb, this.zzd, this.zzc - this.zzd);
        }
        catch(zzga zzga0) {
            this.zzd = v;
            this.zzA(s, zzga0);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzci(indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzo(int v, int v1) throws IOException {
        this.zzq(v << 3 | v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzp(int v, int v1) throws IOException {
        this.zzq(v << 3);
        this.zzq(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzq(int v) throws IOException {
        try {
            while(true) {
                if((v & 0xFFFFFF80) == 0) {
                    int v1 = this.zzd;
                    this.zzd = v1 + 1;
                    this.zzb[v1] = (byte)v;
                    return;
                }
                int v2 = this.zzd;
                this.zzd = v2 + 1;
                this.zzb[v2] = (byte)((v | 0x80) & 0xFF);
                v >>>= 7;
            }
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzci(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), indexOutOfBoundsException0);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzr(int v, long v1) throws IOException {
        this.zzq(v << 3);
        this.zzs(v1);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzck
    public final void zzs(long v) throws IOException {
        try {
            while(true) {
                if((v & 0xFFFFFFFFFFFFFF80L) == 0L) {
                    int v1 = this.zzd;
                    this.zzd = v1 + 1;
                    this.zzb[v1] = (byte)(((int)v));
                    return;
                }
                int v2 = this.zzd;
                this.zzd = v2 + 1;
                this.zzb[v2] = (byte)((((int)v) | 0x80) & 0xFF);
                v >>>= 7;
            }
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzci(String.format("Pos: %d, limit: %d, len: %d", this.zzd, this.zzc, 1), indexOutOfBoundsException0);
        }
    }
}

