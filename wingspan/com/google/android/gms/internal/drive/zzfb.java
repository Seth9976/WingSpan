package com.google.android.gms.internal.drive;

public final class zzfb extends zzkk implements zzls {
    public static final class zza extends com.google.android.gms.internal.drive.zzkk.zza implements zzls {
        private zza() {
            super(zzfb.zzhp);
        }

        zza(zzfc zzfc0) {
        }

        public final zza zze(String s) {
            this.zzdb();
            ((zzfb)this.zzru).zzd(s);
            return this;
        }

        public final zza zzg(long v) {
            this.zzdb();
            ((zzfb)this.zzru).zzf(v);
            return this;
        }

        public final zza zzh(long v) {
            this.zzdb();
            ((zzfb)this.zzru).zza(v);
            return this;
        }

        public final zza zzm(int v) {
            this.zzdb();
            zzfb.zza(((zzfb)this.zzru), 1);
            return this;
        }

        public final zza zzn(int v) {
            this.zzdb();
            ((zzfb)this.zzru).zzl(v);
            return this;
        }
    }

    private int zzhd;
    private int zzhe;
    private long zzhg;
    private byte zzhi;
    private static volatile zzmb zzhk;
    private String zzhm;
    private long zzhn;
    private int zzho;
    private static final zzfb zzhp;

    static {
        zzfb zzfb0 = new zzfb();
        zzfb.zzhp = zzfb0;
        zzkk.zza(zzfb.class, zzfb0);
    }

    private zzfb() {
        this.zzhi = 2;
        this.zzhe = 1;
        this.zzhm = "";
        this.zzhn = -1L;
        this.zzhg = -1L;
        this.zzho = -1;
    }

    public final String getResourceId() [...] // 潜在的解密器

    public final int getResourceType() {
        return this.zzho;
    }

    public static zzfb zza(byte[] arr_b, zzjx zzjx0) throws zzkq {
        return (zzfb)zzkk.zza(zzfb.zzhp, arr_b, zzjx0);
    }

    private final void zza(long v) {
        this.zzhd |= 8;
        this.zzhg = v;
    }

    static void zza(zzfb zzfb0, int v) {
        zzfb0.zzj(1);
    }

    @Override  // com.google.android.gms.internal.drive.zzkk
    protected final Object zza(int v, Object object0, Object object1) {
        int v1 = 1;
        switch(zzfc.zzhl[v - 1]) {
            case 1: {
                return new zzfb();
            }
            case 2: {
                return new zza(null);
            }
            case 3: {
                return zzfb.zza(zzfb.zzhp, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0004\u0001Ԅ\u0000\u0002Ԉ\u0001\u0003Ԑ\u0002\u0004Ԑ\u0003\u0005\u0004\u0004", new Object[]{"zzhd", "zzhe", "zzhm", "zzhn", "zzhg", "zzho"});
            }
            case 4: {
                return zzfb.zzhp;
            }
            case 5: {
                zzmb zzmb0 = zzfb.zzhk;
                if(zzmb0 == null) {
                    synchronized(zzfb.class) {
                        zzmb0 = zzfb.zzhk;
                        if(zzmb0 == null) {
                            zzmb0 = new zzb(zzfb.zzhp);
                            zzfb.zzhk = zzmb0;
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

    public final long zzal() {
        return this.zzhn;
    }

    public final long zzam() {
        return this.zzhg;
    }

    public static zza zzan() {
        return (zza)zzfb.zzhp.zzcw();
    }

    private final void zzd(String s) {
        s.getClass();
        this.zzhd |= 2;
        this.zzhm = s;
    }

    private final void zzf(long v) {
        this.zzhd |= 4;
        this.zzhn = v;
    }

    private final void zzj(int v) {
        this.zzhd |= 1;
        this.zzhe = v;
    }

    private final void zzl(int v) {
        this.zzhd |= 16;
        this.zzho = v;
    }
}

