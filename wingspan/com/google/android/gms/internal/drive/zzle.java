package com.google.android.gms.internal.drive;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzle extends zziw implements zzkp, zzmc, RandomAccess {
    private int size;
    private static final zzle zztp;
    private long[] zztq;

    static {
        zzle zzle0 = new zzle(new long[0], 0);
        zzle.zztp = zzle0;
        zzle0.zzbp();
    }

    zzle() {
        this(new long[10], 0);
    }

    private zzle(long[] arr_v, int v) {
        this.zztq = arr_v;
        this.size = v;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final void add(int v, Object object0) {
        this.zzk(v, ((long)(((Long)object0))));
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean addAll(Collection collection0) {
        this.zzbq();
        zzkm.checkNotNull(collection0);
        if(!(collection0 instanceof zzle)) {
            return super.addAll(collection0);
        }
        int v = ((zzle)collection0).size;
        if(v == 0) {
            return false;
        }
        int v1 = this.size;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        long[] arr_v = this.zztq;
        if(v2 > arr_v.length) {
            this.zztq = Arrays.copyOf(arr_v, v2);
        }
        System.arraycopy(((zzle)collection0).zztq, 0, this.zztq, this.size, ((zzle)collection0).size);
        this.size = v2;
        ++this.modCount;
        return true;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzle)) {
            return super.equals(object0);
        }
        if(this.size != ((zzle)object0).size) {
            return false;
        }
        long[] arr_v = ((zzle)object0).zztq;
        for(int v = 0; v < this.size; ++v) {
            if(this.zztq[v] != arr_v[v]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        return this.getLong(v);
    }

    public final long getLong(int v) {
        this.zzp(v);
        return this.zztq[v];
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final int hashCode() {
        int v = 1;
        for(int v1 = 0; v1 < this.size; ++v1) {
            v = v * 0x1F + zzkm.zzu(this.zztq[v1]);
        }
        return v;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object remove(int v) {
        this.zzbq();
        this.zzp(v);
        long[] arr_v = this.zztq;
        long v1 = arr_v[v];
        int v2 = this.size;
        if(v < v2 - 1) {
            System.arraycopy(arr_v, v + 1, arr_v, v, v2 - v - 1);
        }
        --this.size;
        ++this.modCount;
        return v1;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean remove(Object object0) {
        this.zzbq();
        for(int v = 0; v < this.size; ++v) {
            if(object0.equals(((long)this.zztq[v]))) {
                System.arraycopy(this.zztq, v + 1, this.zztq, v, this.size - v - 1);
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
        System.arraycopy(this.zztq, v1, this.zztq, v, this.size - v1);
        this.size -= v1 - v;
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object set(int v, Object object0) {
        this.zzbq();
        this.zzp(v);
        long[] arr_v = this.zztq;
        long v1 = arr_v[v];
        arr_v[v] = (long)(((Long)object0));
        return v1;
    }

    @Override
    public final int size() {
        return this.size;
    }

    private final void zzk(int v, long v1) {
        this.zzbq();
        if(v >= 0) {
            int v2 = this.size;
            if(v <= v2) {
                long[] arr_v = this.zztq;
                if(v2 < arr_v.length) {
                    System.arraycopy(arr_v, v, arr_v, v + 1, v2 - v);
                }
                else {
                    long[] arr_v1 = new long[v2 * 3 / 2 + 1];
                    System.arraycopy(arr_v, 0, arr_v1, 0, v);
                    System.arraycopy(this.zztq, v, arr_v1, v + 1, this.size - v);
                    this.zztq = arr_v1;
                }
                this.zztq[v] = v1;
                ++this.size;
                ++this.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.zzq(v));
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
        return new zzle(Arrays.copyOf(this.zztq, v), this.size);
    }

    public final void zzv(long v) {
        this.zzk(this.size, v);
    }
}

