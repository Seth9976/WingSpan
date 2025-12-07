package com.voxelbusters.essentialkit.billingservices.providers.google.interfaces;

import java.util.List;

public interface IQuerySkuDetailsListener {
    void onQuerySkuDetailsFailed(String arg1);

    void onQuerySkuDetailsSuccess(List arg1);
}

