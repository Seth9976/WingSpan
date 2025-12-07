package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import java.util.List;

public final class zzca implements Connections {
    public static final AbstractClientBuilder CLIENT_BUILDER;
    public static final ClientKey CLIENT_KEY;

    static {
        zzca.CLIENT_KEY = new ClientKey();
        zzca.CLIENT_BUILDER = new zzcb();
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final PendingResult acceptConnection(GoogleApiClient googleApiClient0, String s, PayloadCallback payloadCallback0) {
        return googleApiClient0.execute(new zzct(this, googleApiClient0, s, googleApiClient0.registerListener(payloadCallback0)));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult acceptConnectionRequest(GoogleApiClient googleApiClient0, String s, byte[] arr_b, MessageListener connections$MessageListener0) {
        return googleApiClient0.execute(new zzck(this, googleApiClient0, s, arr_b, googleApiClient0.registerListener(connections$MessageListener0)));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final PendingResult cancelPayload(GoogleApiClient googleApiClient0, long v) {
        return googleApiClient0.execute(new zzce(this, googleApiClient0, v));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final void disconnectFromEndpoint(GoogleApiClient googleApiClient0, String s) {
        googleApiClient0.execute(new zzcf(this, googleApiClient0, s));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final PendingResult rejectConnection(GoogleApiClient googleApiClient0, String s) {
        return googleApiClient0.execute(new zzcu(this, googleApiClient0, s));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult rejectConnectionRequest(GoogleApiClient googleApiClient0, String s) {
        return googleApiClient0.execute(new zzcl(this, googleApiClient0, s));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final PendingResult requestConnection(GoogleApiClient googleApiClient0, String s, String s1, ConnectionLifecycleCallback connectionLifecycleCallback0) {
        return googleApiClient0.execute(new zzcs(this, googleApiClient0, s, s1, googleApiClient0.registerListener(connectionLifecycleCallback0)));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult sendConnectionRequest(GoogleApiClient googleApiClient0, String s, String s1, byte[] arr_b, ConnectionResponseCallback connections$ConnectionResponseCallback0, MessageListener connections$MessageListener0) {
        return googleApiClient0.execute(new zzcj(this, googleApiClient0, s, s1, arr_b, googleApiClient0.registerListener(connections$ConnectionResponseCallback0), googleApiClient0.registerListener(connections$MessageListener0)));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final PendingResult sendPayload(GoogleApiClient googleApiClient0, String s, Payload payload0) {
        return googleApiClient0.execute(new zzcc(this, googleApiClient0, s, payload0));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final PendingResult sendPayload(GoogleApiClient googleApiClient0, List list0, Payload payload0) {
        return googleApiClient0.execute(new zzcd(this, googleApiClient0, list0, payload0));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendReliableMessage(GoogleApiClient googleApiClient0, String s, byte[] arr_b) {
        googleApiClient0.execute(new zzcm(this, googleApiClient0, s, arr_b));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendReliableMessage(GoogleApiClient googleApiClient0, List list0, byte[] arr_b) {
        googleApiClient0.execute(new zzcn(this, googleApiClient0, list0, arr_b));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendUnreliableMessage(GoogleApiClient googleApiClient0, String s, byte[] arr_b) {
        this.sendPayload(googleApiClient0, s, Payload.fromBytes(arr_b));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void sendUnreliableMessage(GoogleApiClient googleApiClient0, List list0, byte[] arr_b) {
        this.sendPayload(googleApiClient0, list0, Payload.fromBytes(arr_b));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult startAdvertising(GoogleApiClient googleApiClient0, String s, AppMetadata appMetadata0, long v, ConnectionRequestListener connections$ConnectionRequestListener0) {
        return googleApiClient0.execute(new zzch(this, googleApiClient0, s, v, googleApiClient0.registerListener(connections$ConnectionRequestListener0)));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final PendingResult startAdvertising(GoogleApiClient googleApiClient0, String s, String s1, ConnectionLifecycleCallback connectionLifecycleCallback0, AdvertisingOptions advertisingOptions0) {
        return googleApiClient0.execute(new zzco(this, googleApiClient0, s, s1, googleApiClient0.registerListener(connectionLifecycleCallback0), advertisingOptions0));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final PendingResult startDiscovery(GoogleApiClient googleApiClient0, String s, long v, EndpointDiscoveryListener connections$EndpointDiscoveryListener0) {
        return googleApiClient0.execute(new zzci(this, googleApiClient0, s, v, googleApiClient0.registerListener(connections$EndpointDiscoveryListener0)));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final PendingResult startDiscovery(GoogleApiClient googleApiClient0, String s, EndpointDiscoveryCallback endpointDiscoveryCallback0, DiscoveryOptions discoveryOptions0) {
        return googleApiClient0.execute(new zzcq(this, googleApiClient0, s, googleApiClient0.registerListener(endpointDiscoveryCallback0), discoveryOptions0));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final void stopAdvertising(GoogleApiClient googleApiClient0) {
        googleApiClient0.execute(new zzcp(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final void stopAllEndpoints(GoogleApiClient googleApiClient0) {
        googleApiClient0.execute(new zzcg(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    public final void stopDiscovery(GoogleApiClient googleApiClient0) {
        googleApiClient0.execute(new zzcr(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.nearby.connection.Connections
    @Deprecated
    public final void stopDiscovery(GoogleApiClient googleApiClient0, String s) {
        this.stopDiscovery(googleApiClient0);
    }
}

