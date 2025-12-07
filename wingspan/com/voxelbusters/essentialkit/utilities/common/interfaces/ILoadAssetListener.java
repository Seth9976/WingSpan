package com.voxelbusters.essentialkit.utilities.common.interfaces;

import com.voxelbusters.essentialkit.utilities.common.BytesWrapper;

public interface ILoadAssetListener {
    void onFailure(String arg1);

    void onSuccess(BytesWrapper arg1);
}

