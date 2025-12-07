package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;

public class FakeReviewManager implements ReviewManager {
    private final Context zza;
    private ReviewInfo zzb;

    public FakeReviewManager(Context context0) {
        this.zza = context0;
    }

    @Override  // com.google.android.play.core.review.ReviewManager
    public Task launchReviewFlow(Activity activity0, ReviewInfo reviewInfo0) {
        return reviewInfo0 == this.zzb ? Tasks.forResult(null) : Tasks.forException(new ReviewException(-2));
    }

    @Override  // com.google.android.play.core.review.ReviewManager
    public Task requestReviewFlow() {
        Intent intent0 = new Intent();
        ReviewInfo reviewInfo0 = ReviewInfo.zzc(PendingIntent.getBroadcast(this.zza, 0, intent0, 0x4000000), false);
        this.zzb = reviewInfo0;
        return Tasks.forResult(reviewInfo0);
    }
}

