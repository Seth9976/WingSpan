package com.voxelbusters.essentialkit.billingservices.common.interfaces;

import com.voxelbusters.essentialkit.utilities.common.ArrayBuffer;
import java.util.List;

public interface IFetchBillingProductsListener {
    void onFailure(String arg1);

    void onSuccess(List arg1, ArrayBuffer arg2);
}

