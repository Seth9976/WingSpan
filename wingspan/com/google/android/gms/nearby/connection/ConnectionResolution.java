package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.Status;

public final class ConnectionResolution {
    private final Status zzt;

    @Deprecated
    public ConnectionResolution(Status status0) {
        this.zzt = status0;
    }

    public final Status getStatus() {
        return this.zzt;
    }
}

