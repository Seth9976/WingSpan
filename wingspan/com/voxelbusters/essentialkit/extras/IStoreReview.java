package com.voxelbusters.essentialkit.extras;

import com.google.android.play.core.review.ReviewInfo;

public class IStoreReview {
    public interface ILaunchReviewFlowListener {
        void onFailure(String arg1);

        void onSuccess();
    }

    public interface IRequestReviewInfoListener {
        void onFailure(String arg1);

        void onSuccess(ReviewInfo arg1);
    }

    public interface IRequestStoreReviewListener {
        void onFailure(String arg1);

        void onSuccess();
    }

}

