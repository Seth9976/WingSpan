package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.internal.Objects;

final class zzaz {
    private final long zzaf;
    private final String zzca;

    zzaz(String s, long v) {
        this.zzca = s;
        this.zzaf = v;
    }

    // 去混淆评级： 低(40)
    @Override
    public final boolean equals(Object object0) {
        return this == object0 ? true : object0 instanceof zzaz && Objects.equal(this.zzca, ((zzaz)object0).zzca) && Objects.equal(this.zzaf, ((zzaz)object0).zzaf);
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzca, this.zzaf});
    }

    public final String zze() {
        return this.zzca;
    }
}

