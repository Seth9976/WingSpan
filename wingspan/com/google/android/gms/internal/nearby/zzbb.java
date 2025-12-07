package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

final class zzbb implements StartAdvertisingResult {
    private final String zzcc;
    private final Status zzt;

    zzbb(Status status0, String s) {
        this.zzt = status0;
        this.zzcc = s;
    }

    @Override  // com.google.android.gms.nearby.connection.Connections$StartAdvertisingResult
    public final String getLocalEndpointName() {
        return this.zzcc;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzt;
    }
}

