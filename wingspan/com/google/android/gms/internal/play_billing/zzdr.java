package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class zzdr extends zzbn implements zzds, RandomAccess {
    @Deprecated
    public static final zzds zza;
    private static final zzdr zzb;
    private final List zzc;

    static {
        zzdr zzdr0 = new zzdr(false);
        zzdr.zzb = zzdr0;
        zzdr.zza = zzdr0;
    }

    public zzdr() {
        this(10);
    }

    public zzdr(int v) {
        ArrayList arrayList0 = new ArrayList(v);
        super(true);
        this.zzc = arrayList0;
    }

    private zzdr(ArrayList arrayList0) {
        super(true);
        this.zzc = arrayList0;
    }

    private zzdr(boolean z) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbn
    public final void add(int v, Object object0) {
        this.zza();
        this.zzc.add(v, ((String)object0));
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbn
    public final boolean addAll(int v, Collection collection0) {
        this.zza();
        if(collection0 instanceof zzds) {
            collection0 = ((zzds)collection0).zzh();
        }
        boolean z = this.zzc.addAll(v, collection0);
        ++this.modCount;
        return z;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbn
    public final boolean addAll(Collection collection0) {
        return this.addAll(this.size(), collection0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbn
    public final void clear() {
        this.zza();
        this.zzc.clear();
        ++this.modCount;
    }

    @Override
    public final Object get(int v) {
        return this.zzg(v);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbn
    public final Object remove(int v) {
        this.zza();
        Object object0 = this.zzc.remove(v);
        ++this.modCount;
        return zzdr.zzj(object0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzbn
    public final Object set(int v, Object object0) {
        this.zza();
        return zzdr.zzj(this.zzc.set(v, ((String)object0)));
    }

    @Override
    public final int size() {
        return this.zzc.size();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzdk
    public final zzdk zzd(int v) {
        if(v < this.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList0 = new ArrayList(v);
        arrayList0.addAll(this.zzc);
        return new zzdr(arrayList0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzds
    public final zzds zze() {
        return this.zzc() ? new zzfr(this) : this;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzds
    public final Object zzf(int v) {
        return this.zzc.get(v);
    }

    public final String zzg(int v) {
        Object object0 = this.zzc.get(v);
        if(object0 instanceof String) {
            return (String)object0;
        }
        if(object0 instanceof zzcc) {
            String s = ((zzcc)object0).zzm(zzdl.zzb);
            if(((zzcc)object0).zzi()) {
                this.zzc.set(v, s);
            }
            return s;
        }
        String s1 = zzdl.zzd(((byte[])object0));
        if(zzgb.zzd(((byte[])object0))) {
            this.zzc.set(v, s1);
        }
        return s1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzds
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzds
    public final void zzi(zzcc zzcc0) {
        this.zza();
        this.zzc.add(zzcc0);
        ++this.modCount;
    }

    private static String zzj(Object object0) {
        if(object0 instanceof String) {
            return (String)object0;
        }
        return object0 instanceof zzcc ? ((zzcc)object0).zzm(zzdl.zzb) : zzdl.zzd(((byte[])object0));
    }
}

