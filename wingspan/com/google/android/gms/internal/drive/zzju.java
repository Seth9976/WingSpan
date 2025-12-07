package com.google.android.gms.internal.drive;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzju extends zziw implements zzkp, zzmc, RandomAccess {
    private int size;
    private static final zzju zzoi;
    private double[] zzoj;

    static {
        zzju zzju0 = new zzju(new double[0], 0);
        zzju.zzoi = zzju0;
        zzju0.zzbp();
    }

    zzju() {
        this(new double[10], 0);
    }

    private zzju(double[] arr_f, int v) {
        this.zzoj = arr_f;
        this.size = v;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final void add(int v, Object object0) {
        this.zzc(v, ((double)(((Double)object0))));
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean addAll(Collection collection0) {
        this.zzbq();
        zzkm.checkNotNull(collection0);
        if(!(collection0 instanceof zzju)) {
            return super.addAll(collection0);
        }
        int v = ((zzju)collection0).size;
        if(v == 0) {
            return false;
        }
        int v1 = this.size;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        double[] arr_f = this.zzoj;
        if(v2 > arr_f.length) {
            this.zzoj = Arrays.copyOf(arr_f, v2);
        }
        System.arraycopy(((zzju)collection0).zzoj, 0, this.zzoj, this.size, ((zzju)collection0).size);
        this.size = v2;
        ++this.modCount;
        return true;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzju)) {
            return super.equals(object0);
        }
        if(this.size != ((zzju)object0).size) {
            return false;
        }
        double[] arr_f = ((zzju)object0).zzoj;
        for(int v = 0; v < this.size; ++v) {
            if(Double.doubleToLongBits(this.zzoj[v]) != Double.doubleToLongBits(arr_f[v])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzp(v);
        return (double)this.zzoj[v];
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final int hashCode() {
        int v = 1;
        for(int v1 = 0; v1 < this.size; ++v1) {
            v = v * 0x1F + zzkm.zzu(Double.doubleToLongBits(this.zzoj[v1]));
        }
        return v;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object remove(int v) {
        this.zzbq();
        this.zzp(v);
        double[] arr_f = this.zzoj;
        double f = arr_f[v];
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
            if(object0.equals(((double)this.zzoj[v]))) {
                System.arraycopy(this.zzoj, v + 1, this.zzoj, v, this.size - v - 1);
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
        System.arraycopy(this.zzoj, v1, this.zzoj, v, this.size - v1);
        this.size -= v1 - v;
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object set(int v, Object object0) {
        this.zzbq();
        this.zzp(v);
        double[] arr_f = this.zzoj;
        double f = arr_f[v];
        arr_f[v] = (double)(((Double)object0));
        return f;
    }

    @Override
    public final int size() {
        return this.size;
    }

    private final void zzc(int v, double f) {
        this.zzbq();
        if(v >= 0) {
            int v1 = this.size;
            if(v <= v1) {
                double[] arr_f = this.zzoj;
                if(v1 < arr_f.length) {
                    System.arraycopy(arr_f, v, arr_f, v + 1, v1 - v);
                }
                else {
                    double[] arr_f1 = new double[v1 * 3 / 2 + 1];
                    System.arraycopy(arr_f, 0, arr_f1, 0, v);
                    System.arraycopy(this.zzoj, v, arr_f1, v + 1, this.size - v);
                    this.zzoj = arr_f1;
                }
                this.zzoj[v] = f;
                ++this.size;
                ++this.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.zzq(v));
    }

    public final void zzc(double f) {
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
        return new zzju(Arrays.copyOf(this.zzoj, v), this.size);
    }
}

