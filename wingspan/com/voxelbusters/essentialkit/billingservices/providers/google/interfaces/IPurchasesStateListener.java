package com.voxelbusters.essentialkit.billingservices.providers.google.interfaces;

import com.android.billingclient.api.Purchase;

public interface IPurchasesStateListener {
    void onPurchaseFailed(String arg1, String arg2);

    void onPurchaseStarted(String arg1);

    void onPurchaseUpdated(Purchase arg1);
}

