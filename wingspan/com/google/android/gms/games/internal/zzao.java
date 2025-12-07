package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.internal.DataHolderResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;

class zzao extends DataHolderResult {
    zzao(DataHolder dataHolder0) {
        super(dataHolder0, GamesStatusCodes.zza(dataHolder0.getStatusCode()));
    }
}

