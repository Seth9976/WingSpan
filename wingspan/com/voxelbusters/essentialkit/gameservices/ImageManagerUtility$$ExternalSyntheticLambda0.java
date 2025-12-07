package com.voxelbusters.essentialkit.gameservices;

import android.app.Activity;
import android.net.Uri;
import com.voxelbusters.essentialkit.utilities.common.interfaces.ILoadAssetListener;

public final class ImageManagerUtility..ExternalSyntheticLambda0 implements Runnable {
    public final Activity f$0;
    public final ILoadAssetListener f$1;
    public final Uri f$2;

    public ImageManagerUtility..ExternalSyntheticLambda0(Activity activity0, ILoadAssetListener iLoadAssetListener0, Uri uri0) {
        this.f$0 = activity0;
        this.f$1 = iLoadAssetListener0;
        this.f$2 = uri0;
    }

    @Override
    public final void run() {
        ImageManagerUtility.lambda$loadImage$0(this.f$0, this.f$1, this.f$2);
    }
}

