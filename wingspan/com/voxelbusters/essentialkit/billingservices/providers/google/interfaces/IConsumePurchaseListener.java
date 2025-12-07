package com.voxelbusters.essentialkit.billingservices.providers.google.interfaces;

public interface IConsumePurchaseListener {
    void onConsumePurchaseFailed(String arg1);

    void onConsumePurchaseSuccess();
}

