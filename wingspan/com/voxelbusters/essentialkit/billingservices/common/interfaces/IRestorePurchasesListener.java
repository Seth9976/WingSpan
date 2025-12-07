package com.voxelbusters.essentialkit.billingservices.common.interfaces;

import java.util.List;

public interface IRestorePurchasesListener {
    void onFailure(String arg1);

    void onSuccess(List arg1);
}

