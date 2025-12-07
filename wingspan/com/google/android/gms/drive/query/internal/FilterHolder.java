package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final Filter zzbc;
    private final zzb zzmd;
    private final zzd zzme;
    private final zzr zzmf;
    private final zzv zzmg;
    private final zzp zzmh;
    private final zzt zzmi;
    private final zzn zzmj;
    private final zzl zzmk;
    private final zzz zzml;

    static {
        FilterHolder.CREATOR = new zzh();
    }

    public FilterHolder(Filter filter0) {
        Preconditions.checkNotNull(filter0, "Null filter.");
        zzz zzz0 = null;
        zzb zzb0 = filter0 instanceof zzb ? ((zzb)filter0) : null;
        this.zzmd = zzb0;
        zzd zzd0 = filter0 instanceof zzd ? ((zzd)filter0) : null;
        this.zzme = zzd0;
        zzr zzr0 = filter0 instanceof zzr ? ((zzr)filter0) : null;
        this.zzmf = zzr0;
        zzv zzv0 = filter0 instanceof zzv ? ((zzv)filter0) : null;
        this.zzmg = zzv0;
        zzp zzp0 = filter0 instanceof zzp ? ((zzp)filter0) : null;
        this.zzmh = zzp0;
        zzt zzt0 = filter0 instanceof zzt ? ((zzt)filter0) : null;
        this.zzmi = zzt0;
        zzn zzn0 = filter0 instanceof zzn ? ((zzn)filter0) : null;
        this.zzmj = zzn0;
        zzl zzl0 = filter0 instanceof zzl ? ((zzl)filter0) : null;
        this.zzmk = zzl0;
        if(filter0 instanceof zzz) {
            zzz0 = (zzz)filter0;
        }
        this.zzml = zzz0;
        if(zzb0 == null && zzd0 == null && zzr0 == null && zzv0 == null && zzp0 == null && zzt0 == null && zzn0 == null && zzl0 == null && zzz0 == null) {
            throw new IllegalArgumentException("Invalid filter type.");
        }
        this.zzbc = filter0;
    }

    FilterHolder(zzb zzb0, zzd zzd0, zzr zzr0, zzv zzv0, zzp zzp0, zzt zzt0, zzn zzn0, zzl zzl0, zzz zzz0) {
        this.zzmd = zzb0;
        this.zzme = zzd0;
        this.zzmf = zzr0;
        this.zzmg = zzv0;
        this.zzmh = zzp0;
        this.zzmi = zzt0;
        this.zzmj = zzn0;
        this.zzmk = zzl0;
        this.zzml = zzz0;
        if(zzb0 != null) {
            this.zzbc = zzb0;
            return;
        }
        if(zzd0 != null) {
            this.zzbc = zzd0;
            return;
        }
        if(zzr0 != null) {
            this.zzbc = zzr0;
            return;
        }
        if(zzv0 != null) {
            this.zzbc = zzv0;
            return;
        }
        if(zzp0 != null) {
            this.zzbc = zzp0;
            return;
        }
        if(zzt0 != null) {
            this.zzbc = zzt0;
            return;
        }
        if(zzn0 != null) {
            this.zzbc = zzn0;
            return;
        }
        if(zzl0 != null) {
            this.zzbc = zzl0;
            return;
        }
        if(zzz0 == null) {
            throw new IllegalArgumentException("At least one filter must be set.");
        }
        this.zzbc = zzz0;
    }

    public final Filter getFilter() {
        return this.zzbc;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 1, this.zzmd, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzme, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.zzmf, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zzmg, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.zzmh, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.zzmi, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 7, this.zzmj, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 8, this.zzmk, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 9, this.zzml, v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

