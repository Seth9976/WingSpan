package com.google.android.gms.internal.drive;

public class zzkx {
    private static final zzjx zzng;
    private zzjc zzth;
    private volatile zzlq zzti;
    private volatile zzjc zztj;

    static {
        zzkx.zzng = zzjx.zzci();
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzkx)) {
            return false;
        }
        zzlq zzlq0 = this.zzti;
        zzlq zzlq1 = ((zzkx)object0).zzti;
        if(zzlq0 == null && zzlq1 == null) {
            return this.zzbl().equals(((zzkx)object0).zzbl());
        }
        if(zzlq0 != null && zzlq1 != null) {
            return zzlq0.equals(zzlq1);
        }
        return zzlq0 == null ? this.zzh(zzlq1.zzda()).equals(zzlq1) : zzlq0.equals(((zzkx)object0).zzh(zzlq0.zzda()));
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public final zzjc zzbl() {
        if(this.zztj != null) {
            return this.zztj;
        }
        synchronized(this) {
            if(this.zztj != null) {
                return this.zztj;
            }
            this.zztj = this.zzti == null ? zzjc.zznq : this.zzti.zzbl();
            return this.zztj;
        }
    }

    public final int zzcx() {
        if(this.zztj != null) {
            return this.zztj.size();
        }
        return this.zzti == null ? 0 : this.zzti.zzcx();
    }

    private final zzlq zzh(zzlq zzlq0) {
        if(this.zzti == null) {
            synchronized(this) {
                if(this.zzti != null) {
                    return this.zzti;
                }
                this.zzti = zzlq0;
                this.zztj = zzjc.zznq;
            }
        }
        return this.zzti;
    }

    public final zzlq zzi(zzlq zzlq0) {
        zzlq zzlq1 = this.zzti;
        this.zzth = null;
        this.zztj = null;
        this.zzti = zzlq0;
        return zzlq1;
    }
}

