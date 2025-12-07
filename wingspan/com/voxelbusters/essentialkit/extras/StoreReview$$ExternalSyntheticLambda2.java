package com.voxelbusters.essentialkit.extras;

import com.google.android.gms.tasks.OnSuccessListener;

public final class StoreReview..ExternalSyntheticLambda2 implements OnSuccessListener {
    public final ILaunchReviewFlowListener f$0;

    public StoreReview..ExternalSyntheticLambda2(ILaunchReviewFlowListener iStoreReview$ILaunchReviewFlowListener0) {
        this.f$0 = iStoreReview$ILaunchReviewFlowListener0;
    }

    @Override  // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object object0) {
        StoreReview.lambda$launchReviewFlow$2(this.f$0, ((Void)object0));
    }
}

