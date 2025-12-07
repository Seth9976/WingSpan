package com.google.android.gms.games;

import java.util.Collections;
import java.util.List;

final class zzh extends zzl {
    zzh() {
        super(null);
    }

    @Override  // com.google.android.gms.common.api.Api$BaseClientBuilder
    public final List getImpliedScopes(Object object0) {
        GamesOptions games$GamesOptions0 = (GamesOptions)object0;
        return Collections.singletonList(Games.zzb);
    }
}

