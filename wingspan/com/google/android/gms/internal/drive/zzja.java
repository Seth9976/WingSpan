package com.google.android.gms.internal.drive;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzja extends zziw implements zzkp, zzmc, RandomAccess {
    private int size;
    private static final zzja zzno;
    private boolean[] zznp;

    static {
        zzja zzja0 = new zzja(new boolean[0], 0);
        zzja.zzno = zzja0;
        zzja0.zzbp();
    }

    zzja() {
        this(new boolean[10], 0);
    }

    private zzja(boolean[] arr_z, int v) {
        this.zznp = arr_z;
        this.size = v;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final void add(int v, Object object0) {
        this.zza(v, ((Boolean)object0).booleanValue());
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean addAll(Collection collection0) {
        this.zzbq();
        zzkm.checkNotNull(collection0);
        if(!(collection0 instanceof zzja)) {
            return super.addAll(collection0);
        }
        int v = ((zzja)collection0).size;
        if(v == 0) {
            return false;
        }
        int v1 = this.size;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        boolean[] arr_z = this.zznp;
        if(v2 > arr_z.length) {
            this.zznp = Arrays.copyOf(arr_z, v2);
        }
        System.arraycopy(((zzja)collection0).zznp, 0, this.zznp, this.size, ((zzja)collection0).size);
        this.size = v2;
        ++this.modCount;
        return true;
    }

    public final void addBoolean(boolean z) {
        this.zza(this.size, z);
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzja)) {
            return super.equals(object0);
        }
        if(this.size != ((zzja)object0).size) {
            return false;
        }
        boolean[] arr_z = ((zzja)object0).zznp;
        for(int v = 0; v < this.size; ++v) {
            if(this.zznp[v] != arr_z[v]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzp(v);
        return Boolean.valueOf(this.zznp[v]);
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final int hashCode() {
        int v = 1;
        for(int v1 = 0; v1 < this.size; ++v1) {
            v = v * 0x1F + zzkm.zze(this.zznp[v1]);
        }
        return v;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object remove(int v) {
        this.zzbq();
        this.zzp(v);
        boolean[] arr_z = this.zznp;
        boolean z = arr_z[v];
        int v1 = this.size;
        if(v < v1 - 1) {
            System.arraycopy(arr_z, v + 1, arr_z, v, v1 - v - 1);
        }
        --this.size;
        ++this.modCount;
        return Boolean.valueOf(z);
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final boolean remove(Object object0) {
        this.zzbq();
        for(int v = 0; v < this.size; ++v) {
            if(object0.equals(Boolean.valueOf(this.zznp[v]))) {
                System.arraycopy(this.zznp, v + 1, this.zznp, v, this.size - v - 1);
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
        System.arraycopy(this.zznp, v1, this.zznp, v, this.size - v1);
        this.size -= v1 - v;
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.drive.zziw
    public final Object set(int v, Object object0) {
        this.zzbq();
        this.zzp(v);
        boolean[] arr_z = this.zznp;
        boolean z = arr_z[v];
        arr_z[v] = ((Boolean)object0).booleanValue();
        return Boolean.valueOf(z);
    }

    @Override
    public final int size() {
        return this.size;
    }

    private final void zza(int v, boolean z) {
        this.zzbq();
        if(v >= 0) {
            int v1 = this.size;
            if(v <= v1) {
                boolean[] arr_z = this.zznp;
                if(v1 < arr_z.length) {
                    System.arraycopy(arr_z, v, arr_z, v + 1, v1 - v);
                }
                else {
                    boolean[] arr_z1 = new boolean[v1 * 3 / 2 + 1];
                    System.arraycopy(arr_z, 0, arr_z1, 0, v);
                    System.arraycopy(this.zznp, v, arr_z1, v + 1, this.size - v);
                    this.zznp = arr_z1;
                }
                this.zznp[v] = z;
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
        return new zzja(Arrays.copyOf(this.zznp, v), this.size);
    }
}

