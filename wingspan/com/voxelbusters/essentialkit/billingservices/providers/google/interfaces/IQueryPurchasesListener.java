package com.voxelbusters.essentialkit.billingservices.providers.google.interfaces;

import java.util.List;

public interface IQueryPurchasesListener {
    void onQueryPurchasesFailed(String arg1);

    void onQueryPurchasesSuccess(List arg1);
}

