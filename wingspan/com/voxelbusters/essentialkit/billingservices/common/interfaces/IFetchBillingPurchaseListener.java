package com.voxelbusters.essentialkit.billingservices.common.interfaces;

import com.android.billingclient.api.Purchase;

public interface IFetchBillingPurchaseListener {
    void onFailure(String arg1);

    void onSuccess(Purchase arg1);
}

