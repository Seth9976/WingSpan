package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@Deprecated
class BrowserActionsFallbackMenuDialog extends Dialog {
    private static final long ENTER_ANIMATION_DURATION_MS = 0xFAL;
    private static final long EXIT_ANIMATION_DURATION_MS = 150L;
    private final View mContentView;

    BrowserActionsFallbackMenuDialog(Context context, View contentView) {
        super(context);
        this.mContentView = contentView;
    }

    @Override  // android.app.Dialog
    public void dismiss() {
        this.startAnimation(false);
    }

    @Override  // android.app.Dialog
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == 0) {
            this.dismiss();
            return true;
        }
        return false;
    }

    @Override  // android.app.Dialog
    public void show() {
        this.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.startAnimation(true);
        super.show();
    }

    private void startAnimation(boolean isEnterAnimation) {
        this.mContentView.setScaleX((isEnterAnimation ? 0.0f : 1.0f));
        this.mContentView.setScaleY((isEnterAnimation ? 0.0f : 1.0f));
        this.mContentView.animate().scaleX((isEnterAnimation ? 1.0f : 0.0f)).scaleY((isEnterAnimation ? 1.0f : 0.0f)).setDuration((isEnterAnimation ? 0xFAL : 150L)).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new AnimatorListenerAdapter() {
            @Override  // android.animation.AnimatorListenerAdapter
            public void onAnimationEnd(Animator animation) {
                if(!isEnterAnimation) {
                    BrowserActionsFallbackMenuDialog.this.super.dismiss();
                }
            }
        }).start();
    }
}

