package com.gameanalytics.sdk.state;

import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;

public final class GAState..ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final GAState f$0;

    public GAState..ExternalSyntheticLambda0(GAState gAState0) {
        this.f$0 = gAState0;
    }

    @Override  // android.animation.ValueAnimator$AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator0) {
        this.f$0.lambda$logFPS$0$com-gameanalytics-sdk-state-GAState(valueAnimator0);
    }
}

