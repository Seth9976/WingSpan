package com.unity3d.player;

import android.content.Context;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

public class NetworkConnectivityNougat extends NetworkConnectivity {
    class a extends ConnectivityManager.NetworkCallback {
        final NetworkConnectivityNougat a;

        @Override  // android.net.ConnectivityManager$NetworkCallback
        public void onAvailable(Network network0) {
            super.onAvailable(network0);
        }

        @Override  // android.net.ConnectivityManager$NetworkCallback
        public void onCapabilitiesChanged(Network network0, NetworkCapabilities networkCapabilities0) {
            int v;
            NetworkConnectivityNougat networkConnectivityNougat0;
            super.onCapabilitiesChanged(network0, networkCapabilities0);
            if(networkCapabilities0.hasTransport(0)) {
                networkConnectivityNougat0 = NetworkConnectivityNougat.this;
                v = 1;
            }
            else {
                networkConnectivityNougat0 = NetworkConnectivityNougat.this;
                v = 2;
            }
            networkConnectivityNougat0.b = v;
        }

        @Override  // android.net.ConnectivityManager$NetworkCallback
        public void onLost(Network network0) {
            super.onLost(network0);
            NetworkConnectivityNougat.this.b = 0;
        }

        @Override  // android.net.ConnectivityManager$NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            NetworkConnectivityNougat.this.b = 0;
        }
    }

    private int b;
    private final ConnectivityManager.NetworkCallback c;

    public NetworkConnectivityNougat(Context context0) {
        super(context0);
        this.b = 0;
        a networkConnectivityNougat$a0 = new a(this);
        this.c = networkConnectivityNougat$a0;
        if(this.a == null) {
            return;
        }
        this.b = super.b();
        this.a.registerDefaultNetworkCallback(networkConnectivityNougat$a0);
    }

    @Override  // com.unity3d.player.NetworkConnectivity
    public void a() {
        ConnectivityManager connectivityManager0 = this.a;
        if(connectivityManager0 == null) {
            return;
        }
        connectivityManager0.unregisterNetworkCallback(this.c);
    }

    @Override  // com.unity3d.player.NetworkConnectivity
    public int b() {
        return this.b;
    }
}

