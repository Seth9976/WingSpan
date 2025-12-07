package com.voxelbusters.essentialkit.billingservices.providers.google.interfaces;

public interface IStartProductPurchaseListener {
    void onStartProductPurchaseFailed(String arg1, String arg2);

    void onStartProductPurchaseSuccess(String arg1);
}

