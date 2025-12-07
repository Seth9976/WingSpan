package com.onesignal.inAppMessages.internal.display.impl;

import android.animation.Animator.AnimatorListener;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FJ0\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\u0012\u001A\u00020\u000B2\u0006\u0010\u0013\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\u0014J*\u0010\u0015\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F¨\u0006\u0016"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/OneSignalAnimate;", "", "()V", "animateViewByTranslation", "Landroid/view/animation/Animation;", "view", "Landroid/view/View;", "deltaFromY", "", "deltaToY", "duration", "", "interpolator", "Landroid/view/animation/Interpolator;", "animCallback", "Landroid/view/animation/Animation$AnimationListener;", "animateViewColor", "Landroid/animation/ValueAnimator;", "colorStart", "colorEnd", "Landroid/animation/Animator$AnimatorListener;", "animateViewSmallToLarge", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OneSignalAnimate {
    public static final OneSignalAnimate INSTANCE;

    // 检测为 Lambda 实现
    public static void $r8$lambda$O7iBY5ySDgx8HSW3A8Zo09iAk5g(View view0, ValueAnimator valueAnimator0) [...]

    static {
        OneSignalAnimate.INSTANCE = new OneSignalAnimate();
    }

    public final Animation animateViewByTranslation(View view0, float f, float f1, int v, Interpolator interpolator0, Animation.AnimationListener animation$AnimationListener0) {
        Intrinsics.checkNotNullParameter(view0, "view");
        TranslateAnimation translateAnimation0 = new TranslateAnimation(0.0f, 0.0f, f, f1);
        translateAnimation0.setDuration(((long)v));
        translateAnimation0.setInterpolator(interpolator0);
        if(animation$AnimationListener0 != null) {
            translateAnimation0.setAnimationListener(animation$AnimationListener0);
        }
        view0.setAnimation(translateAnimation0);
        return translateAnimation0;
    }

    public final ValueAnimator animateViewColor(View view0, int v, int v1, int v2, Animator.AnimatorListener animator$AnimatorListener0) {
        Intrinsics.checkNotNullParameter(view0, "view");
        ValueAnimator valueAnimator0 = new ValueAnimator();
        valueAnimator0.setDuration(((long)v));
        valueAnimator0.setIntValues(new int[]{v1, v2});
        valueAnimator0.setEvaluator(new ArgbEvaluator());
        valueAnimator0.addUpdateListener((ValueAnimator valueAnimator0) -> OneSignalAnimate.animateViewColor$lambda-0(view0, valueAnimator0));
        if(animator$AnimatorListener0 != null) {
            valueAnimator0.addListener(animator$AnimatorListener0);
        }
        return valueAnimator0;
    }

    private static final void animateViewColor$lambda-0(View view0, ValueAnimator valueAnimator0) {
        Intrinsics.checkNotNullParameter(view0, "$view");
        Intrinsics.checkNotNullParameter(valueAnimator0, "valueAnimator");
        Object object0 = valueAnimator0.getAnimatedValue();
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type kotlin.Int");
        view0.setBackgroundColor(((int)(((Integer)object0))));
    }

    public final Animation animateViewSmallToLarge(View view0, int v, Interpolator interpolator0, Animation.AnimationListener animation$AnimationListener0) {
        Intrinsics.checkNotNullParameter(view0, "view");
        ScaleAnimation scaleAnimation0 = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation0.setDuration(((long)v));
        scaleAnimation0.setInterpolator(interpolator0);
        if(animation$AnimationListener0 != null) {
            scaleAnimation0.setAnimationListener(animation$AnimationListener0);
        }
        view0.setAnimation(scaleAnimation0);
        return scaleAnimation0;
    }
}

