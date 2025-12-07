package com.google.android.gms.nearby.connection;

public abstract class ConnectionLifecycleCallback {
    public abstract void onConnectionInitiated(String arg1, ConnectionInfo arg2);

    public abstract void onConnectionResult(String arg1, ConnectionResolution arg2);

    public abstract void onDisconnected(String arg1);
}

