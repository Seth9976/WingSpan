package com.voxelbusters.essentialkit.extras;

import com.google.android.gms.tasks.OnFailureListener;

public final class StoreReview..ExternalSyntheticLambda1 implements OnFailureListener {
    public final IRequestReviewInfoListener f$0;

    public StoreReview..ExternalSyntheticLambda1(IRequestReviewInfoListener iStoreReview$IRequestReviewInfoListener0) {
        this.f$0 = iStoreReview$IRequestReviewInfoListener0;
    }

    @Override  // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exception0) {
        StoreReview.lambda$requestReviewFlow$1(this.f$0, exception0);
    }
}

