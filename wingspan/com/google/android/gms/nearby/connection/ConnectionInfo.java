package com.google.android.gms.nearby.connection;

public final class ConnectionInfo {
    private final String zzq;
    private final String zzr;
    private final boolean zzs;

    @Deprecated
    public ConnectionInfo(String s, String s1, boolean z) {
        this.zzq = s;
        this.zzr = s1;
        this.zzs = z;
    }

    public final String getAuthenticationToken() {
        return this.zzr;
    }

    public final String getEndpointName() {
        return this.zzq;
    }

    public final boolean isIncomingConnection() {
        return this.zzs;
    }
}

