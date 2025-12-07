package com.google.android.gms.nearby.connection;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import java.util.List;

public abstract class ConnectionsClient extends GoogleApi {
    public static int MAX_BYTES_DATA_SIZE = 0x8000;

    static {
    }

    protected ConnectionsClient(Activity activity0, Api api0, Settings googleApi$Settings0) {
        super(activity0, api0, null, googleApi$Settings0);
    }

    protected ConnectionsClient(Context context0, Api api0, Settings googleApi$Settings0) {
        super(context0, api0, null, googleApi$Settings0);
    }

    public abstract Task acceptConnection(String arg1, PayloadCallback arg2);

    public abstract Task cancelPayload(long arg1);

    public abstract void disconnectFromEndpoint(String arg1);

    public abstract Task rejectConnection(String arg1);

    public abstract Task requestConnection(String arg1, String arg2, ConnectionLifecycleCallback arg3);

    public abstract Task sendPayload(String arg1, Payload arg2);

    public abstract Task sendPayload(List arg1, Payload arg2);

    public abstract Task startAdvertising(String arg1, String arg2, ConnectionLifecycleCallback arg3, AdvertisingOptions arg4);

    public abstract Task startDiscovery(String arg1, EndpointDiscoveryCallback arg2, DiscoveryOptions arg3);

    public abstract void stopAdvertising();

    public abstract void stopAllEndpoints();

    public abstract void stopDiscovery();
}

