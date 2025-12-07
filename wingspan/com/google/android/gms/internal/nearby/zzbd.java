package com.google.android.gms.internal.nearby;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.tasks.Task;
import java.util.List;

public final class zzbd extends ConnectionsClient {
    private static final AbstractClientBuilder CLIENT_BUILDER;
    private static final ClientKey CLIENT_KEY;
    private static final Api CONNECTIONS_API;
    private final zzk zzcd;

    static {
        ClientKey api$ClientKey0 = new ClientKey();
        zzbd.CLIENT_KEY = api$ClientKey0;
        zzbm zzbm0 = new zzbm();
        zzbd.CLIENT_BUILDER = zzbm0;
        zzbd.CONNECTIONS_API = new Api("Nearby.CONNECTIONS_API", zzbm0, api$ClientKey0);
    }

    public zzbd(Activity activity0) {
        super(activity0, zzbd.CONNECTIONS_API, Settings.DEFAULT_SETTINGS);
        this.zzcd = zzk.zza();
    }

    public zzbd(Context context0) {
        super(context0, zzbd.CONNECTIONS_API, Settings.DEFAULT_SETTINGS);
        this.zzcd = zzk.zza();
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task acceptConnection(String s, PayloadCallback payloadCallback0) {
        return this.zza((zzx zzx0, ResultHolder baseImplementation$ResultHolder0) -> zzx0.zza(baseImplementation$ResultHolder0, s, this.registerListener(payloadCallback0, "com.google.android.gms.nearby.connection.PayloadCallback")));
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task cancelPayload(long v) {
        return this.zza((zzx zzx0, ResultHolder baseImplementation$ResultHolder0) -> zzx0.zza(baseImplementation$ResultHolder0, v));
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void disconnectFromEndpoint(String s) {
        this.zza((zzx zzx0) -> zzx0.disconnectFromEndpoint(s));
        this.zzc(s);
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task rejectConnection(String s) {
        return this.zza((zzx zzx0, ResultHolder baseImplementation$ResultHolder0) -> zzx0.zza(baseImplementation$ResultHolder0, s));
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task requestConnection(String s, String s1, ConnectionLifecycleCallback connectionLifecycleCallback0) {
        ListenerHolder listenerHolder0 = this.registerListener(new zzbx(this, connectionLifecycleCallback0), "com.google.android.gms.nearby.connection.ConnectionLifecycleCallback");
        this.zzb(s1);
        return this.zza((zzx zzx0, ResultHolder baseImplementation$ResultHolder0) -> zzx0.zza(baseImplementation$ResultHolder0, s, s1, listenerHolder0)).addOnFailureListener(new zzbs(this, s1));
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task sendPayload(String s, Payload payload0) {
        return this.zza((zzx zzx0, ResultHolder baseImplementation$ResultHolder0) -> zzx0.zza(baseImplementation$ResultHolder0, new String[]{s}, payload0, false));
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task sendPayload(List list0, Payload payload0) {
        return this.zza((zzx zzx0, ResultHolder baseImplementation$ResultHolder0) -> zzx0.zza(baseImplementation$ResultHolder0, ((String[])list0.toArray(new String[0])), payload0, false));
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task startAdvertising(String s, String s1, ConnectionLifecycleCallback connectionLifecycleCallback0, AdvertisingOptions advertisingOptions0) {
        ListenerHolder listenerHolder0 = this.registerListener(new zzbx(this, connectionLifecycleCallback0), "com.google.android.gms.nearby.connection.ConnectionLifecycleCallback");
        Object object0 = new Object();
        ListenerHolder listenerHolder1 = this.zzcd.zza(this, object0, "advertising");
        zzbo zzbo0 = new zzbo(this, listenerHolder1, s, s1, listenerHolder0, advertisingOptions0);
        zzbp zzbp0 = new zzbp(this, listenerHolder1.getListenerKey());
        return this.zzcd.zza(this, zzbo0, zzbp0);
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final Task startDiscovery(String s, EndpointDiscoveryCallback endpointDiscoveryCallback0, DiscoveryOptions discoveryOptions0) {
        ListenerHolder listenerHolder0 = this.zzcd.zza(this, endpointDiscoveryCallback0, "discovery");
        zzbq zzbq0 = new zzbq(this, listenerHolder0, s, listenerHolder0, discoveryOptions0);
        zzbr zzbr0 = new zzbr(this, listenerHolder0.getListenerKey());
        return this.zzcd.zza(this, zzbq0, zzbr0);
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAdvertising() {
        this.zzcd.zza(this, "advertising");
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopAllEndpoints() {
        this.stopAdvertising();
        this.stopDiscovery();
        this.zza(zzbl.zzcl);
        this.zzcd.zza(this, "connection");
    }

    @Override  // com.google.android.gms.nearby.connection.ConnectionsClient
    public final void stopDiscovery() {
        this.zzcd.zza(this, "discovery");
    }

    private final Task zza(zzbw zzbw0) {
        return this.doWrite(new zzbv(this, zzbw0));
    }

    private final Task zza(zzbz zzbz0) {
        return this.doWrite(new zzbn(this, zzbz0));
    }

    // 检测为 Lambda 实现
    static final void zza(long v, zzx zzx0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException [...]

    // 检测为 Lambda 实现
    static final void zza(String s, ListenerHolder listenerHolder0, zzx zzx0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException [...]

    // 检测为 Lambda 实现
    static final void zza(String s, zzx zzx0) throws RemoteException [...]

    // 检测为 Lambda 实现
    static final void zza(String s, zzx zzx0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException [...]

    // 检测为 Lambda 实现
    static final void zza(String s, Payload payload0, zzx zzx0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException [...]

    // 检测为 Lambda 实现
    static final void zza(String s, String s1, ListenerHolder listenerHolder0, zzx zzx0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException [...]

    // 检测为 Lambda 实现
    static final void zza(List list0, Payload payload0, zzx zzx0, ResultHolder baseImplementation$ResultHolder0) throws RemoteException [...]

    private final void zzb(String s) {
        ListenerHolder listenerHolder0 = this.zzcd.zza(this, s, "connection");
        zzbt zzbt0 = new zzbt(this, listenerHolder0);
        zzbu zzbu0 = new zzbu(this, listenerHolder0.getListenerKey());
        this.zzcd.zza(this, zzbt0, zzbu0);
    }

    private final void zzc(String s) {
        ListenerKey listenerHolder$ListenerKey0 = this.zzcd.zzb(this, s, "connection");
        this.zzcd.zza(this, listenerHolder$ListenerKey0);
    }
}

