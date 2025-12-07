package com.google.android.gms.nearby.connection;

public abstract class EndpointDiscoveryCallback {
    public abstract void onEndpointFound(String arg1, DiscoveredEndpointInfo arg2);

    public abstract void onEndpointLost(String arg1);
}

