package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzjr extends zzjb {
    static final class zza extends zzjr {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zza(byte[] arr_b, int v, int v1) {
            super(null);
            if(arr_b == null) {
                throw new NullPointerException("buffer");
            }
            if((v1 | arr_b.length - v1) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", ((int)arr_b.length), 0, v1));
            }
            this.buffer = arr_b;
            this.offset = 0;
            this.position = 0;
            this.limit = v1;
        }

        private final void write(byte[] arr_b, int v, int v1) throws IOException {
            try {
                System.arraycopy(arr_b, v, this.buffer, this.position, v1);
                this.position += v1;
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", this.position, this.limit, v1), indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zza(int v, long v1) throws IOException {
            this.zzb(v, 0);
            this.zzl(v1);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zza(int v, zzjc zzjc0) throws IOException {
            this.zzb(v, 2);
            this.zza(zzjc0);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zza(int v, zzlq zzlq0) throws IOException {
            this.zzb(1, 3);
            this.zzd(2, v);
            this.zzb(3, 2);
            this.zzb(zzlq0);
            this.zzb(1, 4);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        final void zza(int v, zzlq zzlq0, zzmf zzmf0) throws IOException {
            this.zzb(v, 2);
            int v1 = ((zzit)zzlq0).zzbm();
            if(v1 == -1) {
                v1 = zzmf0.zzn(((zzit)zzlq0));
                ((zzit)zzlq0).zzo(v1);
            }
            this.zzy(v1);
            zzmf0.zza(zzlq0, this.zzoh);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zza(int v, String s) throws IOException {
            this.zzb(v, 2);
            this.zzl(s);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zza(zzjc zzjc0) throws IOException {
            this.zzy(zzjc0.size());
            zzjc0.zza(this);
        }

        @Override  // com.google.android.gms.internal.drive.zzjb
        public final void zza(byte[] arr_b, int v, int v1) throws IOException {
            this.write(arr_b, v, v1);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzaa(int v) throws IOException {
            try {
                int v1 = this.position + 1;
                this.buffer[this.position] = (byte)v;
                this.buffer[v1] = (byte)(v >> 8);
                this.buffer[v1 + 1] = (byte)(v >> 16);
                this.position = v1 + 3;
                this.buffer[v1 + 2] = (byte)(v >>> 24);
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", this.position, this.limit, 1), indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzb(int v, int v1) throws IOException {
            this.zzy(v << 3 | v1);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzb(int v, zzjc zzjc0) throws IOException {
            this.zzb(1, 3);
            this.zzd(2, v);
            this.zza(3, zzjc0);
            this.zzb(1, 4);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzb(int v, boolean z) throws IOException {
            this.zzb(v, 0);
            this.zzc(((byte)z));
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzb(zzlq zzlq0) throws IOException {
            this.zzy(zzlq0.zzcx());
            zzlq0.zzb(this);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzc(byte b) throws IOException {
            try {
                int v = this.position;
                this.position = v + 1;
                this.buffer[v] = b;
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", this.position, this.limit, 1), indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzc(int v, int v1) throws IOException {
            this.zzb(v, 0);
            this.zzx(v1);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzc(int v, long v1) throws IOException {
            this.zzb(v, 1);
            this.zzn(v1);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final int zzca() {
            return this.limit - this.position;
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzd(int v, int v1) throws IOException {
            this.zzb(v, 0);
            this.zzy(v1);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzd(byte[] arr_b, int v, int v1) throws IOException {
            this.zzy(v1);
            this.write(arr_b, 0, v1);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzf(int v, int v1) throws IOException {
            this.zzb(v, 5);
            this.zzaa(v1);
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzl(long v) throws IOException {
            if(this.zzca() >= 10) {
                while((v & 0xFFFFFFFFFFFFFF80L) != 0L) {
                    int v1 = this.position;
                    this.position = v1 + 1;
                    zznd.zza(this.buffer, ((long)v1), ((byte)(((int)v) & 0x7F | 0x80)));
                    v >>>= 7;
                }
                int v2 = this.position;
                this.position = v2 + 1;
                zznd.zza(this.buffer, ((long)v2), ((byte)(((int)v))));
                return;
            }
            try {
                while(true) {
                    if((v & 0xFFFFFFFFFFFFFF80L) == 0L) {
                        int v3 = this.position;
                        this.position = v3 + 1;
                        this.buffer[v3] = (byte)(((int)v));
                        return;
                    }
                    int v4 = this.position;
                    this.position = v4 + 1;
                    this.buffer[v4] = (byte)(((int)v) & 0x7F | 0x80);
                    v >>>= 7;
                }
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", this.position, this.limit, 1), indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzl(String s) throws IOException {
            int v;
            try {
                v = this.position;
                int v1 = zza.zzad(s.length() * 3);
                int v2 = zza.zzad(s.length());
                if(v2 == v1) {
                    int v3 = v + v2;
                    this.position = v3;
                    int v4 = this.zzca();
                    int v5 = zznf.zza(s, this.buffer, v3, v4);
                    this.position = v;
                    this.zzy(v5 - v - v2);
                    this.position = v5;
                    return;
                }
                this.zzy(zznf.zza(s));
                int v6 = this.position;
                int v7 = this.zzca();
                this.position = zznf.zza(s, this.buffer, v6, v7);
            }
            catch(zznj zznj0) {
                this.position = v;
                this.zza(s, zznj0);
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new zzb(indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzn(long v) throws IOException {
            try {
                int v1 = this.position + 1;
                this.buffer[this.position] = (byte)(((int)v));
                this.buffer[v1] = (byte)(((int)(v >> 8)));
                this.buffer[v1 + 1] = (byte)(((int)(v >> 16)));
                this.buffer[v1 + 2] = (byte)(((int)(v >> 24)));
                this.buffer[v1 + 3] = (byte)(((int)(v >> 0x20)));
                this.buffer[v1 + 4] = (byte)(((int)(v >> 40)));
                this.buffer[v1 + 5] = (byte)(((int)(v >> 0x30)));
                this.position = v1 + 7;
                this.buffer[v1 + 6] = (byte)(((int)(v >> 56)));
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", this.position, this.limit, 1), indexOutOfBoundsException0);
            }
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzx(int v) throws IOException {
            if(v >= 0) {
                this.zzy(v);
                return;
            }
            this.zzl(((long)v));
        }

        @Override  // com.google.android.gms.internal.drive.zzjr
        public final void zzy(int v) throws IOException {
            if(this.zzca() >= 5) {
                if((v & 0xFFFFFF80) == 0) {
                    int v1 = this.position;
                    this.position = v1 + 1;
                    zznd.zza(this.buffer, ((long)v1), ((byte)v));
                    return;
                }
                int v2 = this.position;
                this.position = v2 + 1;
                zznd.zza(this.buffer, ((long)v2), ((byte)(v | 0x80)));
                if((v >>> 7 & 0xFFFFFF80) == 0) {
                    int v3 = this.position;
                    this.position = v3 + 1;
                    zznd.zza(this.buffer, ((long)v3), ((byte)(v >>> 7)));
                    return;
                }
                int v4 = this.position;
                this.position = v4 + 1;
                zznd.zza(this.buffer, ((long)v4), ((byte)(v >>> 7 | 0x80)));
                int v5 = v >>> 7 >>> 7;
                if((v5 & 0xFFFFFF80) == 0) {
                    int v6 = this.position;
                    this.position = v6 + 1;
                    zznd.zza(this.buffer, ((long)v6), ((byte)v5));
                    return;
                }
                int v7 = this.position;
                this.position = v7 + 1;
                zznd.zza(this.buffer, ((long)v7), ((byte)(v5 | 0x80)));
                if((v5 >>> 7 & 0xFFFFFF80) == 0) {
                    int v8 = this.position;
                    this.position = v8 + 1;
                    zznd.zza(this.buffer, ((long)v8), ((byte)(v5 >>> 7)));
                    return;
                }
                int v9 = this.position;
                this.position = v9 + 1;
                zznd.zza(this.buffer, ((long)v9), ((byte)(v5 >>> 7 | 0x80)));
                int v10 = this.position;
                this.position = v10 + 1;
                zznd.zza(this.buffer, ((long)v10), ((byte)(v5 >>> 7 >>> 7)));
                return;
            }
            try {
                while(true) {
                    if((v & 0xFFFFFF80) == 0) {
                        int v11 = this.position;
                        this.position = v11 + 1;
                        this.buffer[v11] = (byte)v;
                        return;
                    }
                    int v12 = this.position;
                    this.position = v12 + 1;
                    this.buffer[v12] = (byte)(v & 0x7F | 0x80);
                    v >>>= 7;
                }
            }
            catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
                throw new zzb(String.format("Pos: %d, limit: %d, len: %d", this.position, this.limit, 1), indexOutOfBoundsException0);
            }
        }
    }

    public static final class zzb extends IOException {
        zzb() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zzb(String s, Throwable throwable0) {
            String s1 = String.valueOf(s);
            super((s1.length() == 0 ? new String("CodedOutputStream was writing to a flat byte array and ran out of space.: ") : "CodedOutputStream was writing to a flat byte array and ran out of space.: " + s1), throwable0);
        }

        zzb(Throwable throwable0) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable0);
        }
    }

    private static final Logger logger;
    private static final boolean zzog;
    zzjt zzoh;

    static {
        zzjr.logger = Logger.getLogger("com.google.android.gms.internal.drive.zzjr");
        zzjr.zzog = true;
    }

    private zzjr() {
    }

    zzjr(zzjs zzjs0) {
    }

    public static int zza(int v, zzkx zzkx0) {
        int v1 = zzkx0.zzcx();
        return zzjr.zzab(v) + (zzjr.zzad(v1) + v1);
    }

    public static int zza(zzkx zzkx0) {
        int v = zzkx0.zzcx();
        return zzjr.zzad(v) + v;
    }

    static int zza(zzlq zzlq0, zzmf zzmf0) {
        int v = ((zzit)zzlq0).zzbm();
        if(v == -1) {
            v = zzmf0.zzn(((zzit)zzlq0));
            ((zzit)zzlq0).zzo(v);
        }
        return zzjr.zzad(v) + v;
    }

    public final void zza(double f) throws IOException {
        this.zzn(Double.doubleToRawLongBits(f));
    }

    public final void zza(float f) throws IOException {
        this.zzaa(Float.floatToRawIntBits(f));
    }

    public final void zza(int v, double f) throws IOException {
        this.zzc(v, Double.doubleToRawLongBits(f));
    }

    public final void zza(int v, float f) throws IOException {
        this.zzf(v, Float.floatToRawIntBits(f));
    }

    public abstract void zza(int arg1, long arg2) throws IOException;

    public abstract void zza(int arg1, zzjc arg2) throws IOException;

    public abstract void zza(int arg1, zzlq arg2) throws IOException;

    abstract void zza(int arg1, zzlq arg2, zzmf arg3) throws IOException;

    public abstract void zza(int arg1, String arg2) throws IOException;

    public abstract void zza(zzjc arg1) throws IOException;

    final void zza(String s, zznj zznj0) throws IOException {
        zzjr.logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zznj0);
        byte[] arr_b = s.getBytes(zzkm.UTF_8);
        try {
            this.zzy(arr_b.length);
            this.zza(arr_b, 0, arr_b.length);
        }
        catch(IndexOutOfBoundsException indexOutOfBoundsException0) {
            throw new zzb(indexOutOfBoundsException0);
        }
    }

    public abstract void zzaa(int arg1) throws IOException;

    public static int zzab(int v) [...] // 潜在的解密器

    public static int zzac(int v) {
        return v < 0 ? 10 : zzjr.zzad(v);
    }

    public static int zzad(int v) {
        if((v & 0xFFFFFF80) == 0) {
            return 1;
        }
        if((v & 0xFFFFC000) == 0) {
            return 2;
        }
        if((0xFFE00000 & v) == 0) {
            return 3;
        }
        return (v & 0xF0000000) == 0 ? 4 : 5;
    }

    public static int zzae(int v) {
        return zzjr.zzad(v >> 0x1F ^ v << 1);
    }

    public static int zzaf(int v) {
        return 4;
    }

    public static int zzag(int v) {
        return 4;
    }

    public static int zzah(int v) {
        return zzjr.zzac(v);
    }

    private static int zzai(int v) [...] // Inlined contents

    @Deprecated
    public static int zzaj(int v) {
        return zzjr.zzad(v);
    }

    public static int zzb(double f) {
        return 8;
    }

    public static int zzb(float f) {
        return 4;
    }

    public static int zzb(int v, double f) {
        return zzjr.zzab(v) + 8;
    }

    public static int zzb(int v, float f) {
        return zzjr.zzab(v) + 4;
    }

    // 去混淆评级： 低(20)
    public static int zzb(int v, zzkx zzkx0) {
        return zzjr.zzh(2, v) + 2 + zzjr.zza(3, zzkx0);
    }

    // 去混淆评级： 低(40)
    public static int zzb(int v, zzlq zzlq0) {
        return zzjr.zzh(2, v) + 2 + (zzjr.zzc(zzlq0) + 1);
    }

    static int zzb(int v, zzlq zzlq0, zzmf zzmf0) {
        return zzjr.zzab(v) + zzjr.zza(zzlq0, zzmf0);
    }

    public static int zzb(int v, String s) {
        return zzjr.zzab(v) + zzjr.zzm(s);
    }

    public static int zzb(zzjc zzjc0) {
        int v = zzjc0.size();
        return zzjr.zzad(v) + v;
    }

    public static zzjr zzb(byte[] arr_b) {
        return new zza(arr_b, 0, arr_b.length);
    }

    public abstract void zzb(int arg1, int arg2) throws IOException;

    public final void zzb(int v, long v1) throws IOException {
        this.zza(v, v1 >> 0x3F ^ v1 << 1);
    }

    public abstract void zzb(int arg1, zzjc arg2) throws IOException;

    public abstract void zzb(int arg1, boolean arg2) throws IOException;

    public abstract void zzb(zzlq arg1) throws IOException;

    public static int zzc(int v, zzjc zzjc0) {
        int v1 = zzjc0.size();
        return zzjr.zzab(v) + (zzjr.zzad(v1) + v1);
    }

    @Deprecated
    static int zzc(int v, zzlq zzlq0, zzmf zzmf0) {
        int v1 = zzjr.zzab(v);
        int v2 = ((zzit)zzlq0).zzbm();
        if(v2 == -1) {
            v2 = zzmf0.zzn(((zzit)zzlq0));
            ((zzit)zzlq0).zzo(v2);
        }
        return (v1 << 1) + v2;
    }

    public static int zzc(int v, boolean z) {
        return zzjr.zzab(v) + 1;
    }

    public static int zzc(zzlq zzlq0) {
        int v = zzlq0.zzcx();
        return zzjr.zzad(v) + v;
    }

    public static int zzc(byte[] arr_b) {
        return zzjr.zzad(arr_b.length) + arr_b.length;
    }

    public abstract void zzc(byte arg1) throws IOException;

    public abstract void zzc(int arg1, int arg2) throws IOException;

    public abstract void zzc(int arg1, long arg2) throws IOException;

    public final void zzc(boolean z) throws IOException {
        this.zzc(((byte)z));
    }

    public abstract int zzca();

    public final void zzcb() {
        if(this.zzca() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    static boolean zzcc() [...] // 潜在的解密器

    public static int zzd(int v, long v1) {
        return zzjr.zzab(v) + zzjr.zzp(v1);
    }

    // 去混淆评级： 低(20)
    public static int zzd(int v, zzjc zzjc0) {
        return zzjr.zzh(2, v) + 2 + zzjr.zzc(3, zzjc0);
    }

    @Deprecated
    public static int zzd(zzlq zzlq0) {
        return zzlq0.zzcx();
    }

    public static int zzd(boolean z) {
        return 1;
    }

    public abstract void zzd(int arg1, int arg2) throws IOException;

    abstract void zzd(byte[] arg1, int arg2, int arg3) throws IOException;

    public static int zze(int v, long v1) {
        return zzjr.zzab(v) + zzjr.zzp(v1);
    }

    public final void zze(int v, int v1) throws IOException {
        this.zzd(v, v1 >> 0x1F ^ v1 << 1);
    }

    public static int zzf(int v, long v1) {
        return zzjr.zzab(v) + zzjr.zzp(v1 >> 0x3F ^ v1 << 1);
    }

    public abstract void zzf(int arg1, int arg2) throws IOException;

    public static int zzg(int v, int v1) {
        return zzjr.zzab(v) + zzjr.zzac(v1);
    }

    public static int zzg(int v, long v1) {
        return zzjr.zzab(v) + 8;
    }

    public static int zzh(int v, int v1) {
        return zzjr.zzab(v) + zzjr.zzad(v1);
    }

    public static int zzh(int v, long v1) {
        return zzjr.zzab(v) + 8;
    }

    public static int zzi(int v, int v1) {
        return zzjr.zzab(v) + zzjr.zzad(v1 >> 0x1F ^ v1 << 1);
    }

    public static int zzj(int v, int v1) {
        return zzjr.zzab(v) + 4;
    }

    public static int zzk(int v, int v1) {
        return zzjr.zzab(v) + 4;
    }

    public static int zzl(int v, int v1) {
        return zzjr.zzab(v) + zzjr.zzac(v1);
    }

    public abstract void zzl(long arg1) throws IOException;

    public abstract void zzl(String arg1) throws IOException;

    public static int zzm(String s) {
        int v;
        try {
            v = zznf.zza(s);
            return zzjr.zzad(v) + v;
        }
        catch(zznj unused_ex) {
            v = s.getBytes(zzkm.UTF_8).length;
            return zzjr.zzad(v) + v;
        }
    }

    public final void zzm(long v) throws IOException {
        this.zzl(v >> 0x3F ^ v << 1);
    }

    public abstract void zzn(long arg1) throws IOException;

    public static int zzo(long v) {
        return zzjr.zzp(v);
    }

    public static int zzp(long v) {
        int v1;
        if((0xFFFFFFFFFFFFFF80L & v) == 0L) {
            return 1;
        }
        if(v < 0L) {
            return 10;
        }
        if((0xFFFFFFF800000000L & v) == 0L) {
            v1 = 2;
        }
        else {
            v >>>= 28;
            v1 = 6;
        }
        if((0xFFFFFFFFFFE00000L & v) != 0L) {
            v1 += 2;
            v >>>= 14;
        }
        return (v & 0xFFFFFFFFFFFFC000L) == 0L ? v1 : v1 + 1;
    }

    public static int zzq(long v) {
        return zzjr.zzp(v >> 0x3F ^ v << 1);
    }

    public static int zzr(long v) {
        return 8;
    }

    public static int zzs(long v) {
        return 8;
    }

    private static long zzt(long v) [...] // Inlined contents

    public abstract void zzx(int arg1) throws IOException;

    public abstract void zzy(int arg1) throws IOException;

    public final void zzz(int v) throws IOException {
        this.zzy(v >> 0x1F ^ v << 1);
    }
}

