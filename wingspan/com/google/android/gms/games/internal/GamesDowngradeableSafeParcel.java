package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.common.util.GmsVersion;

public abstract class GamesDowngradeableSafeParcel extends DowngradeableSafeParcel {
    @Override  // com.google.android.gms.common.internal.DowngradeableSafeParcel
    public final boolean prepareForClientVersion(int v) {
        this.setShouldDowngrade(!GamesDowngradeableSafeParcel.zzp(v));
        return true;
    }

    protected static boolean zzp(Integer integer0) {
        return integer0 == null ? false : GmsVersion.isAtLeastFenacho(((int)integer0));
    }
}

