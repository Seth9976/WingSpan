package com.google.android.gms.internal.drive;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzkl extends zziw implements zzkp, zzmc, RandomAccess {
    private int size;
    private static final zzkl zzsl;
    private int[] zzsm;

    static {
        zzkl zzkl0 = new zzkl(new int[0], 0);
        zzkl.zzsl = zzkl0;
        zzkl0.zzbp();
    }

    zzkl() {
        this(new int[10], 0);
    }

    private zzkl(int[] arr_v, int v) {
        this.zzsm = arr_v;
        this.size = v;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final void add(int v, Object object0) {
        this.zzo(v, ((int)(((Integer)object0))));
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean addAll(Collection collection0) {
        this.zzbq();
        zzkm.checkNotNull(collection0);
        if(!(collection0 instanceof zzkl)) {
            return super.addAll(collection0);
        }
        int v = ((zzkl)collection0).size;
        if(v == 0) {
            return false;
        }
        int v1 = this.size;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        int[] arr_v = this.zzsm;
        if(v2 > arr_v.length) {
            this.zzsm = Arrays.copyOf(arr_v, v2);
        }
        System.arraycopy(((zzkl)collection0).zzsm, 0, this.zzsm, this.size, ((zzkl)collection0).size);
        this.size = v2;
        ++this.modCount;
        return true;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzkl)) {
            return super.equals(object0);
        }
        if(this.size != ((zzkl)object0).size) {
            return false;
        }
        int[] arr_v = ((zzkl)object0).zzsm;
        for(int v = 0; v < this.size; ++v) {
            if(this.zzsm[v] != arr_v[v]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        return this.getInt(v);
    }

    public final int getInt(int v) {
        this.zzp(v);
        return this.zzsm[v];
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final int hashCode() {
        int v = 1;
        for(int v1 = 0; v1 < this.size; ++v1) {
            v = v * 0x1F + this.zzsm[v1];
        }
        return v;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object remove(int v) {
        this.zzbq();
        this.zzp(v);
        int[] arr_v = this.zzsm;
        int v1 = arr_v[v];
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
            if(object0.equals(((int)this.zzsm[v]))) {
                System.arraycopy(this.zzsm, v + 1, this.zzsm, v, this.size - v - 1);
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
        System.arraycopy(this.zzsm, v1, this.zzsm, v, this.size - v1);
        this.size -= v1 - v;
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object set(int v, Object object0) {
        this.zzbq();
        this.zzp(v);
        int[] arr_v = this.zzsm;
        int v1 = arr_v[v];
        arr_v[v] = (int)(((Integer)object0));
        return v1;
    }

    @Override
    public final int size() {
        return this.size;
    }

    public final void zzam(int v) {
        this.zzo(this.size, v);
    }

    private final void zzo(int v, int v1) {
        this.zzbq();
        if(v >= 0) {
            int v2 = this.size;
            if(v <= v2) {
                int[] arr_v = this.zzsm;
                if(v2 < arr_v.length) {
                    System.arraycopy(arr_v, v, arr_v, v + 1, v2 - v);
                }
                else {
                    int[] arr_v1 = new int[v2 * 3 / 2 + 1];
                    System.arraycopy(arr_v, 0, arr_v1, 0, v);
                    System.arraycopy(this.zzsm, v, arr_v1, v + 1, this.size - v);
                    this.zzsm = arr_v1;
                }
                this.zzsm[v] = v1;
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
        return new zzkl(Arrays.copyOf(this.zzsm, v), this.size);
    }
}

