package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

public class NetworkConnectivity extends Activity {
    protected ConnectivityManager a;

    public NetworkConnectivity(Context context0) {
        ConnectivityManager connectivityManager0 = (ConnectivityManager)context0.getSystemService("connectivity");
        this.a = connectivityManager0;
        if(connectivityManager0 == null) {
            u.Log(6, "NetworkConnectivity: ConnectivityManager not found");
        }
    }

    public void a() {
    }

    public int b() {
        ConnectivityManager connectivityManager0 = this.a;
        if(connectivityManager0 == null) {
            return 0;
        }
        if(PlatformSupport.MARSHMALLOW_SUPPORT) {
            Network network0 = connectivityManager0.getActiveNetwork();
            if(network0 == null) {
                return 0;
            }
            NetworkCapabilities networkCapabilities0 = this.a.getNetworkCapabilities(network0);
            if(networkCapabilities0 != null) {
                return networkCapabilities0.hasTransport(0) ? 1 : 2;
            }
        }
        else {
            NetworkInfo networkInfo0 = connectivityManager0.getActiveNetworkInfo();
            if(networkInfo0 != null && networkInfo0.isConnected()) {
                return networkInfo0.getType() == 0 ? 1 : 2;
            }
        }
        return 0;
    }
}

