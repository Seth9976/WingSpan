package com.google.android.gms.internal.drive;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzkh extends zziw implements zzkp, zzmc, RandomAccess {
    private int size;
    private static final zzkh zzrm;
    private float[] zzrn;

    static {
        zzkh zzkh0 = new zzkh(new float[0], 0);
        zzkh.zzrm = zzkh0;
        zzkh0.zzbp();
    }

    zzkh() {
        this(new float[10], 0);
    }

    private zzkh(float[] arr_f, int v) {
        this.zzrn = arr_f;
        this.size = v;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final void add(int v, Object object0) {
        this.zzc(v, ((float)(((Float)object0))));
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean addAll(Collection collection0) {
        this.zzbq();
        zzkm.checkNotNull(collection0);
        if(!(collection0 instanceof zzkh)) {
            return super.addAll(collection0);
        }
        int v = ((zzkh)collection0).size;
        if(v == 0) {
            return false;
        }
        int v1 = this.size;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        float[] arr_f = this.zzrn;
        if(v2 > arr_f.length) {
            this.zzrn = Arrays.copyOf(arr_f, v2);
        }
        System.arraycopy(((zzkh)collection0).zzrn, 0, this.zzrn, this.size, ((zzkh)collection0).size);
        this.size = v2;
        ++this.modCount;
        return true;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzkh)) {
            return super.equals(object0);
        }
        if(this.size != ((zzkh)object0).size) {
            return false;
        }
        float[] arr_f = ((zzkh)object0).zzrn;
        for(int v = 0; v < this.size; ++v) {
            if(Float.floatToIntBits(this.zzrn[v]) != Float.floatToIntBits(arr_f[v])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzp(v);
        return (float)this.zzrn[v];
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final int hashCode() {
        int v = 1;
        for(int v1 = 0; v1 < this.size; ++v1) {
            v = v * 0x1F + Float.floatToIntBits(this.zzrn[v1]);
        }
        return v;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object remove(int v) {
        this.zzbq();
        this.zzp(v);
        float[] arr_f = this.zzrn;
        float f = arr_f[v];
        int v1 = this.size;
        if(v < v1 - 1) {
            System.arraycopy(arr_f, v + 1, arr_f, v, v1 - v - 1);
        }
        --this.size;
        ++this.modCount;
        return f;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean remove(Object object0) {
        this.zzbq();
        for(int v = 0; v < this.size; ++v) {
            if(object0.equals(((float)this.zzrn[v]))) {
                System.arraycopy(this.zzrn, v + 1, this.zzrn, v, this.size - v - 1);
                --this.size;
                ++this.modCount;
                return true;
            }
        }
        return false;
    }

    @Override
    protected final void removeRange(int v, int v1) {
        this.zzbq();
        if(v1 < v) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzrn, v1, this.zzrn, v, this.size - v1);
        this.size -= v1 - v;
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object set(int v, Object object0) {
        this.zzbq();
        this.zzp(v);
        float[] arr_f = this.zzrn;
        float f = arr_f[v];
        arr_f[v] = (float)(((Float)object0));
        return f;
    }

    @Override
    public final int size() {
        return this.size;
    }

    private final void zzc(int v, float f) {
        this.zzbq();
        if(v >= 0) {
            int v1 = this.size;
            if(v <= v1) {
                float[] arr_f = this.zzrn;
                if(v1 < arr_f.length) {
                    System.arraycopy(arr_f, v, arr_f, v + 1, v1 - v);
                }
                else {
                    float[] arr_f1 = new float[v1 * 3 / 2 + 1];
                    System.arraycopy(arr_f, 0, arr_f1, 0, v);
                    System.arraycopy(this.zzrn, v, arr_f1, v + 1, this.size - v);
                    this.zzrn = arr_f1;
                }
                this.zzrn[v] = f;
                ++this.size;
                ++this.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.zzq(v));
    }

    public final void zzc(float f) {
        this.zzc(this.size, f);
    }

    private final void zzp(int v) {
        if(v < 0 || v >= this.size) {
            throw new IndexOutOfBoundsException(this.zzq(v));
        }
    }

    private final String zzq(int v) {
        return "Index:" + v + ", Size:" + this.size;
    }

    @Override  // com.google.android.gms.internal.drive.zzkp
    public final zzkp zzr(int v) {
        if(v < this.size) {
            throw new IllegalArgumentException();
        }
        return new zzkh(Arrays.copyOf(this.zzrn, v), this.size);
    }
}

