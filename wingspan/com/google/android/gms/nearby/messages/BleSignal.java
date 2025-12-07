package com.google.android.gms.nearby.messages;

public interface BleSignal {
    public static final int UNKNOWN_TX_POWER = 0x80000000;

    int getRssi();

    int getTxPower();
}

