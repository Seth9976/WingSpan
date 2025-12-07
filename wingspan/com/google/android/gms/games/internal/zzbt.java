package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;

final class zzbt extends zzbr {
    zzbt(ResultHolder baseImplementation$ResultHolder0) {
        super(baseImplementation$ResultHolder0);
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzq(DataHolder dataHolder0, String s, Contents contents0, Contents contents1, Contents contents2) {
        this.zzw(new zzbl(dataHolder0, s, contents0, contents1, contents2));
    }

    @Override  // com.google.android.gms.games.internal.zza
    public final void zzs(DataHolder dataHolder0, Contents contents0) {
        this.zzw(new zzbl(dataHolder0, null, contents0, null, null));
    }
}

