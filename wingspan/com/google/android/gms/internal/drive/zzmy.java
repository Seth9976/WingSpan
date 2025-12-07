package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.Arrays;

public final class zzmy {
    private int count;
    private boolean zznh;
    private int zzrr;
    private Object[] zzue;
    private static final zzmy zzvr;
    private int[] zzvs;

    static {
        zzmy.zzvr = new zzmy(0, new int[0], new Object[0], false);
    }

    private zzmy() {
        this(0, new int[8], new Object[8], true);
    }

    private zzmy(int v, int[] arr_v, Object[] arr_object, boolean z) {
        this.zzrr = -1;
        this.count = v;
        this.zzvs = arr_v;
        this.zzue = arr_object;
        this.zznh = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzmy)) {
            return false;
        }
        int v = this.count;
        if(v == ((zzmy)object0).count) {
            int[] arr_v = this.zzvs;
            int[] arr_v1 = ((zzmy)object0).zzvs;
            for(int v1 = 0; true; ++v1) {
                boolean z = true;
                if(v1 >= v) {
                    break;
                }
                if(arr_v[v1] != arr_v1[v1]) {
                    z = false;
                    break;
                }
            }
            if(z) {
                Object[] arr_object = this.zzue;
                Object[] arr_object1 = ((zzmy)object0).zzue;
                int v2 = this.count;
                for(int v3 = 0; v3 < v2; ++v3) {
                    if(!arr_object[v3].equals(arr_object1[v3])) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = this.count;
        int[] arr_v = this.zzvs;
        int v1 = 17;
        int v3 = 17;
        for(int v4 = 0; v4 < v; ++v4) {
            v3 = v3 * 0x1F + arr_v[v4];
        }
        Object[] arr_object = this.zzue;
        int v5 = this.count;
        for(int v2 = 0; v2 < v5; ++v2) {
            v1 = v1 * 0x1F + arr_object[v2].hashCode();
        }
        return ((v + 0x20F) * 0x1F + v3) * 0x1F + v1;
    }

    static zzmy zza(zzmy zzmy0, zzmy zzmy1) {
        int v = zzmy0.count + zzmy1.count;
        int[] arr_v = Arrays.copyOf(zzmy0.zzvs, v);
        System.arraycopy(zzmy1.zzvs, 0, arr_v, zzmy0.count, zzmy1.count);
        Object[] arr_object = Arrays.copyOf(zzmy0.zzue, v);
        System.arraycopy(zzmy1.zzue, 0, arr_object, zzmy0.count, zzmy1.count);
        return new zzmy(v, arr_v, arr_object, true);
    }

    final void zza(zzns zzns0) throws IOException {
        if(zzns0.zzcd() == zze.zzsj) {
            for(int v = this.count - 1; v >= 0; --v) {
                zzns0.zza(this.zzvs[v] >>> 3, this.zzue[v]);
            }
            return;
        }
        for(int v1 = 0; v1 < this.count; ++v1) {
            zzns0.zza(this.zzvs[v1] >>> 3, this.zzue[v1]);
        }
    }

    final void zza(StringBuilder stringBuilder0, int v) {
        for(int v1 = 0; v1 < this.count; ++v1) {
            zzlt.zza(stringBuilder0, v, String.valueOf(this.zzvs[v1] >>> 3), this.zzue[v1]);
        }
    }

    private static void zzb(int v, Object object0, zzns zzns0) throws IOException {
        switch(v & 7) {
            case 0: {
                zzns0.zzi(v >>> 3, ((long)(((Long)object0))));
                return;
            }
            case 1: {
                zzns0.zzc(v >>> 3, ((long)(((Long)object0))));
                return;
            }
            case 2: {
                zzns0.zza(v >>> 3, ((zzjc)object0));
                return;
            }
            case 3: {
                if(zzns0.zzcd() == zze.zzsi) {
                    zzns0.zzak(v >>> 3);
                    ((zzmy)object0).zzb(zzns0);
                    zzns0.zzal(v >>> 3);
                    return;
                }
                zzns0.zzal(v >>> 3);
                ((zzmy)object0).zzb(zzns0);
                zzns0.zzak(v >>> 3);
                return;
            }
            case 5: {
                zzns0.zzf(v >>> 3, ((int)(((Integer)object0))));
                return;
            }
            default: {
                throw new RuntimeException(zzkq.zzdl());
            }
        }
    }

    final void zzb(int v, Object object0) {
        if(!this.zznh) {
            throw new UnsupportedOperationException();
        }
        int v1 = this.count;
        int[] arr_v = this.zzvs;
        if(v1 == arr_v.length) {
            int v2 = v1 + (v1 >= 4 ? v1 >> 1 : 8);
            this.zzvs = Arrays.copyOf(arr_v, v2);
            this.zzue = Arrays.copyOf(this.zzue, v2);
        }
        int v3 = this.count;
        this.zzvs[v3] = v;
        this.zzue[v3] = object0;
        this.count = v3 + 1;
    }

    public final void zzb(zzns zzns0) throws IOException {
        if(this.count == 0) {
            return;
        }
        if(zzns0.zzcd() == zze.zzsi) {
            for(int v = 0; v < this.count; ++v) {
                zzmy.zzb(this.zzvs[v], this.zzue[v], zzns0);
            }
            return;
        }
        for(int v1 = this.count - 1; v1 >= 0; --v1) {
            zzmy.zzb(this.zzvs[v1], this.zzue[v1], zzns0);
        }
    }

    public final void zzbp() {
        this.zznh = false;
    }

    public final int zzcx() {
        int v5;
        int v = this.zzrr;
        if(v != -1) {
            return v;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < this.count; ++v1) {
            int v3 = this.zzvs[v1];
            int v4 = v3 >>> 3;
            switch(v3 & 7) {
                case 0: {
                    v5 = zzjr.zze(v4, ((long)(((Long)this.zzue[v1]))));
                    break;
                }
                case 1: {
                    v5 = zzjr.zzg(v4, ((long)(((Long)this.zzue[v1]))));
                    break;
                }
                case 2: {
                    v5 = zzjr.zzc(v4, ((zzjc)this.zzue[v1]));
                    break;
                }
                case 3: {
                    v5 = (zzjr.zzab(v4) << 1) + ((zzmy)this.zzue[v1]).zzcx();
                    break;
                }
                case 5: {
                    v5 = zzjr.zzj(v4, ((int)(((Integer)this.zzue[v1]))));
                    break;
                }
                default: {
                    throw new IllegalStateException(zzkq.zzdl());
                }
            }
            v2 += v5;
        }
        this.zzrr = v2;
        return v2;
    }

    public static zzmy zzfa() {
        return zzmy.zzvr;
    }

    static zzmy zzfb() {
        return new zzmy();
    }

    public final int zzfc() {
        int v = this.zzrr;
        if(v != -1) {
            return v;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < this.count; ++v1) {
            v2 += zzjr.zzd(this.zzvs[v1] >>> 3, ((zzjc)this.zzue[v1]));
        }
        this.zzrr = v2;
        return v2;
    }
}

