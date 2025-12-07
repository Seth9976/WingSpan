package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

final class zzcx implements StartAdvertisingResult {
    private final Status zzbj;

    zzcx(zzcw zzcw0, Status status0) {
        this.zzbj = status0;
        super();
    }

    @Override  // com.google.android.gms.nearby.connection.Connections$StartAdvertisingResult
    public final String getLocalEndpointName() {
        return null;
    }

    @Override  // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzbj;
    }
}

