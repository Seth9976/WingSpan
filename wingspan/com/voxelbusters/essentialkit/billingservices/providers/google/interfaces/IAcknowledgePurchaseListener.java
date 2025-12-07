package com.voxelbusters.essentialkit.billingservices.providers.google.interfaces;

public interface IAcknowledgePurchaseListener {
    void onAcknowledgePurchaseFailed(String arg1);

    void onAcknowlegePurchaseSuccess();
}

