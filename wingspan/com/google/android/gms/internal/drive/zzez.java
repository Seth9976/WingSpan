package com.google.android.gms.internal.drive;

public final class zzez extends zzkk implements zzls {
    public static final class zza extends com.google.android.gms.internal.drive.zzkk.zza implements zzls {
        private zza() {
            super(zzez.zzhj);
        }

        zza(zzfa zzfa0) {
        }

        public final zza zzc(long v) {
            this.zzdb();
            ((zzez)this.zzru).setSequenceNumber(v);
            return this;
        }

        public final zza zzd(long v) {
            this.zzdb();
            ((zzez)this.zzru).zza(v);
            return this;
        }

        public final zza zze(long v) {
            this.zzdb();
            ((zzez)this.zzru).zzb(v);
            return this;
        }

        public final zza zzk(int v) {
            this.zzdb();
            zzez.zza(((zzez)this.zzru), 1);
            return this;
        }
    }

    private int zzhd;
    private int zzhe;
    private long zzhf;
    private long zzhg;
    private long zzhh;
    private byte zzhi;
    private static final zzez zzhj;
    private static volatile zzmb zzhk;

    static {
        zzez zzez0 = new zzez();
        zzez.zzhj = zzez0;
        zzkk.zza(zzez.class, zzez0);
    }

    private zzez() {
        this.zzhi = 2;
        this.zzhe = 1;
        this.zzhf = -1L;
        this.zzhg = -1L;
        this.zzhh = -1L;
    }

    private final void setSequenceNumber(long v) {
        this.zzhd |= 2;
        this.zzhf = v;
    }

    private final void zza(long v) {
        this.zzhd |= 4;
        this.zzhg = v;
    }

    static void zza(zzez zzez0, int v) {
        zzez0.zzj(1);
    }

    @Override  // com.google.android.gms.internal.drive.zzkk
    protected final Object zza(int v, Object object0, Object object1) {
        int v1 = 1;
        switch(zzfa.zzhl[v - 1]) {
            case 1: {
                return new zzez();
            }
            case 2: {
                return new zza(null);
            }
            case 3: {
                return zzez.zza(zzez.zzhj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0004\u0001Ԅ\u0000\u0002Ԑ\u0001\u0003Ԑ\u0002\u0004Ԑ\u0003", new Object[]{"zzhd", "zzhe", "zzhf", "zzhg", "zzhh"});
            }
            case 4: {
                return zzez.zzhj;
            }
            case 5: {
                zzmb zzmb0 = zzez.zzhk;
                if(zzmb0 == null) {
                    synchronized(zzez.class) {
                        zzmb0 = zzez.zzhk;
                        if(zzmb0 == null) {
                            zzmb0 = new zzb(zzez.zzhj);
                            zzez.zzhk = zzmb0;
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

    public static zza zzaj() {
        return (zza)zzez.zzhj.zzcw();
    }

    private final void zzb(long v) {
        this.zzhd |= 8;
        this.zzhh = v;
    }

    private final void zzj(int v) {
        this.zzhd |= 1;
        this.zzhe = v;
    }
}

