package com.voxelbusters.essentialkit.extras;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.voxelbusters.essentialkit.utilities.common.annotations.RunOnUiThread;
import com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature;

public class StoreReview implements IFeature {
    private Activity context;
    private ReviewManager manager;

    public StoreReview(Activity activity0) {
        this.context = activity0;
        this.manager = ReviewManagerFactory.create(activity0);
    }

    public static boolean canRequestStoreReview() {
        return true;
    }

    @Override  // com.voxelbusters.essentialkit.utilities.common.interfaces.IFeature
    public String getFeatureName() {
        return "Store Review";
    }

    // 检测为 Lambda 实现
    static void lambda$launchReviewFlow$2(ILaunchReviewFlowListener iStoreReview$ILaunchReviewFlowListener0, Void void0) [...]

    // 检测为 Lambda 实现
    static void lambda$launchReviewFlow$3(ILaunchReviewFlowListener iStoreReview$ILaunchReviewFlowListener0, Exception exception0) [...]

    // 检测为 Lambda 实现
    static void lambda$requestReviewFlow$0(IRequestReviewInfoListener iStoreReview$IRequestReviewInfoListener0, ReviewInfo reviewInfo0) [...]

    // 检测为 Lambda 实现
    static void lambda$requestReviewFlow$1(IRequestReviewInfoListener iStoreReview$IRequestReviewInfoListener0, Exception exception0) [...]

    private void launchReviewFlow(ReviewInfo reviewInfo0, ILaunchReviewFlowListener iStoreReview$ILaunchReviewFlowListener0) {
        Task task0 = this.manager.launchReviewFlow(this.context, reviewInfo0);
        task0.addOnSuccessListener((Void void0) -> iStoreReview$ILaunchReviewFlowListener0.onSuccess());
        task0.addOnFailureListener((Exception exception0) -> iStoreReview$ILaunchReviewFlowListener0.onFailure(exception0.getMessage()));
    }

    private void requestReviewFlow(IRequestReviewInfoListener iStoreReview$IRequestReviewInfoListener0) {
        Task task0 = this.manager.requestReviewFlow();
        task0.addOnSuccessListener((ReviewInfo reviewInfo0) -> iStoreReview$IRequestReviewInfoListener0.onSuccess(reviewInfo0));
        task0.addOnFailureListener((Exception exception0) -> iStoreReview$IRequestReviewInfoListener0.onFailure(exception0.getMessage()));
    }

    @RunOnUiThread
    public void requestStoreReview(IRequestStoreReviewListener iStoreReview$IRequestStoreReviewListener0) {
        public final class a implements IRequestReviewInfoListener {
            public final IRequestStoreReviewListener a;
            public final StoreReview b;

            public a(IRequestStoreReviewListener iStoreReview$IRequestStoreReviewListener0) {
                this.a = iStoreReview$IRequestStoreReviewListener0;
                super();
            }

            @Override  // com.voxelbusters.essentialkit.extras.IStoreReview$IRequestReviewInfoListener
            public final void onFailure(String s) {
                IRequestStoreReviewListener iStoreReview$IRequestStoreReviewListener0 = this.a;
                if(iStoreReview$IRequestStoreReviewListener0 != null) {
                    iStoreReview$IRequestStoreReviewListener0.onFailure(s);
                }
            }

            @Override  // com.voxelbusters.essentialkit.extras.IStoreReview$IRequestReviewInfoListener
            public final void onSuccess(ReviewInfo reviewInfo0) {
                public final class com.voxelbusters.essentialkit.extras.StoreReview.a.a implements ILaunchReviewFlowListener {
                    public final a a;

                    @Override  // com.voxelbusters.essentialkit.extras.IStoreReview$ILaunchReviewFlowListener
                    public final void onFailure(String s) {
                        IRequestStoreReviewListener iStoreReview$IRequestStoreReviewListener0 = a.this.a;
                        if(iStoreReview$IRequestStoreReviewListener0 != null) {
                            iStoreReview$IRequestStoreReviewListener0.onFailure(s);
                        }
                    }

                    @Override  // com.voxelbusters.essentialkit.extras.IStoreReview$ILaunchReviewFlowListener
                    public final void onSuccess() {
                        IRequestStoreReviewListener iStoreReview$IRequestStoreReviewListener0 = a.this.a;
                        if(iStoreReview$IRequestStoreReviewListener0 != null) {
                            iStoreReview$IRequestStoreReviewListener0.onSuccess();
                        }
                    }
                }

                com.voxelbusters.essentialkit.extras.StoreReview.a.a storeReview$a$a0 = new com.voxelbusters.essentialkit.extras.StoreReview.a.a(this);
                StoreReview.this.launchReviewFlow(reviewInfo0, storeReview$a$a0);
            }
        }

        this.requestReviewFlow(new a(this, iStoreReview$IRequestStoreReviewListener0));
    }
}

