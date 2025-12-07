package com.google.android.gms.nearby.connection;

public abstract class PayloadCallback {
    public abstract void onPayloadReceived(String arg1, Payload arg2);

    public abstract void onPayloadTransferUpdate(String arg1, PayloadTransferUpdate arg2);
}

