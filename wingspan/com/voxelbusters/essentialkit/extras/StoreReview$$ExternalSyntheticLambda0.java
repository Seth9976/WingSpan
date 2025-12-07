package com.voxelbusters.essentialkit.extras;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.review.ReviewInfo;

public final class StoreReview..ExternalSyntheticLambda0 implements OnSuccessListener {
    public final IRequestReviewInfoListener f$0;

    public StoreReview..ExternalSyntheticLambda0(IRequestReviewInfoListener iStoreReview$IRequestReviewInfoListener0) {
        this.f$0 = iStoreReview$IRequestReviewInfoListener0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        StoreReview.lambda$requestReviewFlow$0(this.f$0, ((ReviewInfo)object0));
    }
}

