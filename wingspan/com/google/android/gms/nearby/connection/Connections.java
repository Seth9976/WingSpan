package com.google.android.gms.nearby.connection;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

@Deprecated
public interface Connections {
    @Deprecated
    public static class ConnectionRequestListener {
        public void onConnectionRequest(String s, String s1, byte[] arr_b) {
        }
    }

    @Deprecated
    public interface ConnectionResponseCallback {
        void onConnectionResponse(String arg1, Status arg2, byte[] arg3);
    }

    @Deprecated
    public static abstract class EndpointDiscoveryListener {
        public void onEndpointFound(String s, String s1, String s2) {
        }

        public abstract void onEndpointLost(String arg1);
    }

    @Deprecated
    public interface MessageListener {
        @Deprecated
        void onDisconnected(String arg1);

        @Deprecated
        void onMessageReceived(String arg1, byte[] arg2, boolean arg3);
    }

    public interface StartAdvertisingResult extends Result {
        String getLocalEndpointName();
    }

    @Deprecated
    public static final long DURATION_INDEFINITE = 0L;
    public static final int MAX_BYTES_DATA_SIZE = 0x8000;
    @Deprecated
    public static final int MAX_RELIABLE_MESSAGE_LEN = 0x1000;
    @Deprecated
    public static final int MAX_UNRELIABLE_MESSAGE_LEN = 0x490;

    PendingResult acceptConnection(GoogleApiClient arg1, String arg2, PayloadCallback arg3);

    @Deprecated
    PendingResult acceptConnectionRequest(GoogleApiClient arg1, String arg2, byte[] arg3, MessageListener arg4);

    PendingResult cancelPayload(GoogleApiClient arg1, long arg2);

    void disconnectFromEndpoint(GoogleApiClient arg1, String arg2);

    PendingResult rejectConnection(GoogleApiClient arg1, String arg2);

    @Deprecated
    PendingResult rejectConnectionRequest(GoogleApiClient arg1, String arg2);

    PendingResult requestConnection(GoogleApiClient arg1, String arg2, String arg3, ConnectionLifecycleCallback arg4);

    @Deprecated
    PendingResult sendConnectionRequest(GoogleApiClient arg1, String arg2, String arg3, byte[] arg4, ConnectionResponseCallback arg5, MessageListener arg6);

    PendingResult sendPayload(GoogleApiClient arg1, String arg2, Payload arg3);

    PendingResult sendPayload(GoogleApiClient arg1, List arg2, Payload arg3);

    @Deprecated
    void sendReliableMessage(GoogleApiClient arg1, String arg2, byte[] arg3);

    @Deprecated
    void sendReliableMessage(GoogleApiClient arg1, List arg2, byte[] arg3);

    @Deprecated
    void sendUnreliableMessage(GoogleApiClient arg1, String arg2, byte[] arg3);

    @Deprecated
    void sendUnreliableMessage(GoogleApiClient arg1, List arg2, byte[] arg3);

    @Deprecated
    PendingResult startAdvertising(GoogleApiClient arg1, String arg2, AppMetadata arg3, long arg4, ConnectionRequestListener arg5);

    PendingResult startAdvertising(GoogleApiClient arg1, String arg2, String arg3, ConnectionLifecycleCallback arg4, AdvertisingOptions arg5);

    @Deprecated
    PendingResult startDiscovery(GoogleApiClient arg1, String arg2, long arg3, EndpointDiscoveryListener arg4);

    PendingResult startDiscovery(GoogleApiClient arg1, String arg2, EndpointDiscoveryCallback arg3, DiscoveryOptions arg4);

    void stopAdvertising(GoogleApiClient arg1);

    void stopAllEndpoints(GoogleApiClient arg1);

    void stopDiscovery(GoogleApiClient arg1);

    @Deprecated
    void stopDiscovery(GoogleApiClient arg1, String arg2);
}

