package com.google.android.gms.internal.drive;

public final class zzfd extends zzkk implements zzls {
    public static final class zza extends com.google.android.gms.internal.drive.zzkk.zza implements zzls {
        private zza() {
            super(zzfd.zzhq);
        }

        zza(zzfe zzfe0) {
        }

        public final zza zzi(long v) {
            this.zzdb();
            ((zzfd)this.zzru).zzf(v);
            return this;
        }

        public final zza zzj(long v) {
            this.zzdb();
            ((zzfd)this.zzru).zza(v);
            return this;
        }
    }

    private int zzhd;
    private long zzhg;
    private byte zzhi;
    private static volatile zzmb zzhk;
    private long zzhn;
    private static final zzfd zzhq;

    static {
        zzfd zzfd0 = new zzfd();
        zzfd.zzhq = zzfd0;
        zzkk.zza(zzfd.class, zzfd0);
    }

    private zzfd() {
        this.zzhi = 2;
        this.zzhn = -1L;
        this.zzhg = -1L;
    }

    private final void zza(long v) {
        this.zzhd |= 2;
        this.zzhg = v;
    }

    @Override  // com.google.android.gms.internal.drive.zzkk
    protected final Object zza(int v, Object object0, Object object1) {
        int v1 = 1;
        switch(zzfe.zzhl[v - 1]) {
            case 1: {
                return new zzfd();
            }
            case 2: {
                return new zza(null);
            }
            case 3: {
                return zzfd.zza(zzfd.zzhq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԑ\u0000\u0002Ԑ\u0001", new Object[]{"zzhd", "zzhn", "zzhg"});
            }
            case 4: {
                return zzfd.zzhq;
            }
            case 5: {
                zzmb zzmb0 = zzfd.zzhk;
                if(zzmb0 == null) {
                    synchronized(zzfd.class) {
                        zzmb0 = zzfd.zzhk;
                        if(zzmb0 == null) {
                            zzmb0 = new zzb(zzfd.zzhq);
                            zzfd.zzhk = zzmb0;
                        }
                        return zzmb0;
                    }
                }
                return zzmb0;
            }
            case 6: {
                return this.zzhi;
            }
            case 7: {
                if(object0 == null) {
                    v1 = 0;
                }
                this.zzhi = (byte)v1;
                return null;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
    }

    public static zza zzap() {
        return (zza)zzfd.zzhq.zzcw();
    }

    private final void zzf(long v) {
        this.zzhd |= 1;
        this.zzhn = v;
    }
}

