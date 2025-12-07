package com.google.android.gms.internal.location;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class zzbp extends AbstractCollection implements Serializable {
    private static final Object[] zza;

    static {
        zzbp.zza = new Object[0];
    }

    @Override
    @Deprecated
    public final boolean add(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean addAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        return this.zza();
    }

    @Override
    @Deprecated
    public final boolean remove(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean removeAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public final boolean retainAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object[] toArray() {
        return this.toArray(zzbp.zza);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        arr_object.getClass();
        int v = this.size();
        if(arr_object.length < v) {
            Object[] arr_object1 = this.zzb();
            if(arr_object1 == null) {
                arr_object = (Object[])Array.newInstance(arr_object.getClass().getComponentType(), v);
                this.zzg(arr_object, 0);
                return arr_object;
            }
            return Arrays.copyOfRange(arr_object1, this.zzc(), this.zzd(), arr_object.getClass());
        }
        else if(arr_object.length > v) {
            arr_object[v] = null;
        }
        this.zzg(arr_object, 0);
        return arr_object;
    }

    public abstract zzbu zza();

    @NullableDecl
    Object[] zzb() {
        throw null;
    }

    int zzc() {
        throw null;
    }

    int zzd() {
        throw null;
    }

    public zzbs zze() {
        throw null;
    }

    abstract boolean zzf();

    int zzg(Object[] arr_object, int v) {
        throw null;
    }
}

