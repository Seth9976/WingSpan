package com.voxelbusters.essentialkit.billingservices.providers.google.interfaces;

import java.util.List;

public interface IQueryUnacknowledgedPurchasesListener {
    void onQueryUnacknowledgedPurchasesFailed(String arg1);

    void onQueryUnacknowledgedPurchasesSuccess(List arg1);
}

