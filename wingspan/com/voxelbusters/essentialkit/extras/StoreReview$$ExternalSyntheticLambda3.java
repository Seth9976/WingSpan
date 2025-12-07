package com.voxelbusters.essentialkit.extras;

import com.google.android.gms.tasks.OnFailureListener;

public final class StoreReview..ExternalSyntheticLambda3 implements OnFailureListener {
    public final ILaunchReviewFlowListener f$0;

    public StoreReview..ExternalSyntheticLambda3(ILaunchReviewFlowListener iStoreReview$ILaunchReviewFlowListener0) {
        this.f$0 = iStoreReview$ILaunchReviewFlowListener0;
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        StoreReview.lambda$launchReviewFlow$3(this.f$0, exception0);
    }
}

