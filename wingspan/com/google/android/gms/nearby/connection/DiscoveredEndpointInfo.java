package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;

public final class DiscoveredEndpointInfo {
    private final String zzq;
    private final String zzu;
    private final BluetoothDevice zzv;

    public DiscoveredEndpointInfo(String s, BluetoothDevice bluetoothDevice0) {
        this.zzu = s;
        this.zzq = "__UNRECOGNIZED_BLUETOOTH_DEVICE__";
        this.zzv = bluetoothDevice0;
    }

    @Deprecated
    public DiscoveredEndpointInfo(String s, String s1) {
        this.zzu = s;
        this.zzq = s1;
        this.zzv = null;
    }

    public final String getEndpointName() {
        return this.zzq;
    }

    public final String getServiceId() {
        return this.zzu;
    }
}

