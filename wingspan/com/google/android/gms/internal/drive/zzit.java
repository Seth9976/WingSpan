package com.google.android.gms.internal.drive;

import java.io.IOException;

public abstract class zzit implements zzlq {
    protected int zzne;
    private static boolean zznf;

    static {
    }

    public zzit() {
        this.zzne = 0;
    }

    public final byte[] toByteArray() {
        try {
            byte[] arr_b = new byte[this.zzcx()];
            zzjr zzjr0 = zzjr.zzb(arr_b);
            this.zzb(zzjr0);
            zzjr0.zzcb();
            return arr_b;
        }
        catch(IOException iOException0) {
            throw new RuntimeException("Serializing " + this.getClass().getName() + " to a byte array threw an IOException (should never happen).", iOException0);
        }
    }

    @Override  // com.google.android.gms.internal.drive.zzlq
    public final zzjc zzbl() {
        try {
            zzjk zzjk0 = zzjc.zzu(this.zzcx());
            this.zzb(zzjk0.zzby());
            return zzjk0.zzbx();
        }
        catch(IOException iOException0) {
            throw new RuntimeException("Serializing " + this.getClass().getName() + " to a ByteString threw an IOException (should never happen).", iOException0);
        }
    }

    int zzbm() {
        throw new UnsupportedOperationException();
    }

    void zzo(int v) {
        throw new UnsupportedOperationException();
    }
}

