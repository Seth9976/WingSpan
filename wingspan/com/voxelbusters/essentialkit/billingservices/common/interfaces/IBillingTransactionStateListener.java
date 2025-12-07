package com.voxelbusters.essentialkit.billingservices.common.interfaces;

import com.voxelbusters.essentialkit.billingservices.common.BillingTransaction;

public interface IBillingTransactionStateListener {
    void onFailed(BillingTransaction arg1, String arg2);

    void onStarted(BillingTransaction arg1);

    void onUpdated(BillingTransaction arg1);
}

