package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;

class TooltipCompatHandler implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {
    private static final long HOVER_HIDE_TIMEOUT_MS = 15000L;
    private static final long HOVER_HIDE_TIMEOUT_SHORT_MS = 3000L;
    private static final long LONG_CLICK_HIDE_TIMEOUT_MS = 2500L;
    private static final String TAG = "TooltipCompatHandler";
    private final View mAnchor;
    private int mAnchorX;
    private int mAnchorY;
    private boolean mFromTouch;
    private final Runnable mHideRunnable;
    private final int mHoverSlop;
    private TooltipPopup mPopup;
    private final Runnable mShowRunnable;
    private final CharSequence mTooltipText;
    private static TooltipCompatHandler sActiveHandler;
    private static TooltipCompatHandler sPendingHandler;

    private TooltipCompatHandler(View view0, CharSequence charSequence0) {
        this.mShowRunnable = () -> {
            long v2;
            long v1;
            long v;
            if(!ViewCompat.isAttachedToWindow(TooltipCompatHandler.this.mAnchor)) {
                return;
            }
            TooltipCompatHandler.setPendingHandler(null);
            TooltipCompatHandler tooltipCompatHandler0 = TooltipCompatHandler.sActiveHandler;
            if(tooltipCompatHandler0 != null) {
                tooltipCompatHandler0.hide();
            }
            TooltipCompatHandler.sActiveHandler = TooltipCompatHandler.this;
            TooltipCompatHandler.this.mFromTouch = false;
            TooltipPopup tooltipPopup0 = new TooltipPopup(TooltipCompatHandler.this.mAnchor.getContext());
            TooltipCompatHandler.this.mPopup = tooltipPopup0;
            tooltipPopup0.show(TooltipCompatHandler.this.mAnchor, TooltipCompatHandler.this.mAnchorX, TooltipCompatHandler.this.mAnchorY, TooltipCompatHandler.this.mFromTouch, TooltipCompatHandler.this.mTooltipText);
            TooltipCompatHandler.this.mAnchor.addOnAttachStateChangeListener(TooltipCompatHandler.this);
            if(TooltipCompatHandler.this.mFromTouch) {
                v = 2500L;
            }
            else {
                if((ViewCompat.getWindowSystemUiVisibility(TooltipCompatHandler.this.mAnchor) & 1) == 1) {
                    v1 = (long)ViewConfiguration.getLongPressTimeout();
                    v2 = 3000L;
                }
                else {
                    v1 = (long)ViewConfiguration.getLongPressTimeout();
                    v2 = 15000L;
                }
                v = v2 - v1;
            }
            TooltipCompatHandler.this.mAnchor.removeCallbacks(TooltipCompatHandler.this.mHideRunnable);
            TooltipCompatHandler.this.mAnchor.postDelayed(TooltipCompatHandler.this.mHideRunnable, v);
        };
        this.mHideRunnable = () -> {
            if(TooltipCompatHandler.sActiveHandler == TooltipCompatHandler.this) {
                TooltipCompatHandler.sActiveHandler = null;
                TooltipPopup tooltipPopup0 = TooltipCompatHandler.this.mPopup;
                if(tooltipPopup0 == null) {
                    Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
                }
                else {
                    tooltipPopup0.hide();
                    TooltipCompatHandler.this.mPopup = null;
                    TooltipCompatHandler.this.clearAnchorPos();
                    TooltipCompatHandler.this.mAnchor.removeOnAttachStateChangeListener(TooltipCompatHandler.this);
                }
            }
            if(TooltipCompatHandler.sPendingHandler == TooltipCompatHandler.this) {
                TooltipCompatHandler.setPendingHandler(null);
            }
            TooltipCompatHandler.this.mAnchor.removeCallbacks(TooltipCompatHandler.this.mHideRunnable);
        };
        this.mAnchor = view0;
        this.mTooltipText = charSequence0;
        this.mHoverSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(view0.getContext()));
        this.clearAnchorPos();
        view0.setOnLongClickListener(this);
        view0.setOnHoverListener(this);
    }

    private void cancelPendingShow() {
        this.mAnchor.removeCallbacks(this.mShowRunnable);
    }

    private void clearAnchorPos() {
        this.mAnchorX = 0x7FFFFFFF;
        this.mAnchorY = 0x7FFFFFFF;
    }

    // 检测为 Lambda 实现
    void hide() [...]

    @Override  // android.view.View$OnHoverListener
    public boolean onHover(View view0, MotionEvent motionEvent0) {
        if(this.mPopup != null && this.mFromTouch) {
            return false;
        }
        AccessibilityManager accessibilityManager0 = (AccessibilityManager)this.mAnchor.getContext().getSystemService("accessibility");
        if(accessibilityManager0.isEnabled() && accessibilityManager0.isTouchExplorationEnabled()) {
            return false;
        }
        switch(motionEvent0.getAction()) {
            case 7: {
                if(this.mAnchor.isEnabled() && this.mPopup == null && this.updateAnchorPos(motionEvent0)) {
                    TooltipCompatHandler.setPendingHandler(this);
                }
                return false;
            }
            case 10: {
                this.clearAnchorPos();
                this.hide();
                return false;
            }
            default: {
                return false;
            }
        }
    }

    @Override  // android.view.View$OnLongClickListener
    public boolean onLongClick(View view0) {
        this.mAnchorX = view0.getWidth() / 2;
        this.mAnchorY = view0.getHeight() / 2;
        this.show(true);
        return true;
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view0) {
    }

    @Override  // android.view.View$OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view0) {
        this.hide();
    }

    private void scheduleShow() {
        long v = (long)ViewConfiguration.getLongPressTimeout();
        this.mAnchor.postDelayed(this.mShowRunnable, v);
    }

    private static void setPendingHandler(TooltipCompatHandler tooltipCompatHandler0) {
        TooltipCompatHandler tooltipCompatHandler1 = TooltipCompatHandler.sPendingHandler;
        if(tooltipCompatHandler1 != null) {
            tooltipCompatHandler1.cancelPendingShow();
        }
        TooltipCompatHandler.sPendingHandler = tooltipCompatHandler0;
        if(tooltipCompatHandler0 != null) {
            tooltipCompatHandler0.scheduleShow();
        }
    }

    public static void setTooltipText(View view0, CharSequence charSequence0) {
        if(TooltipCompatHandler.sPendingHandler != null && TooltipCompatHandler.sPendingHandler.mAnchor == view0) {
            TooltipCompatHandler.setPendingHandler(null);
        }
        if(TextUtils.isEmpty(charSequence0)) {
            TooltipCompatHandler tooltipCompatHandler0 = TooltipCompatHandler.sActiveHandler;
            if(tooltipCompatHandler0 != null && tooltipCompatHandler0.mAnchor == view0) {
                tooltipCompatHandler0.hide();
            }
            view0.setOnLongClickListener(null);
            view0.setLongClickable(false);
            view0.setOnHoverListener(null);
            return;
        }
        new TooltipCompatHandler(view0, charSequence0);
    }

    // 检测为 Lambda 实现
    void show(boolean z) [...]

    private boolean updateAnchorPos(MotionEvent motionEvent0) {
        int v = (int)motionEvent0.getX();
        int v1 = (int)motionEvent0.getY();
        if(Math.abs(v - this.mAnchorX) <= this.mHoverSlop && Math.abs(v1 - this.mAnchorY) <= this.mHoverSlop) {
            return false;
        }
        this.mAnchorX = v;
        this.mAnchorY = v1;
        return true;
    }

    class androidx.appcompat.widget.TooltipCompatHandler.1 implements Runnable {
        @Override
        public void run() {
            TooltipCompatHandler.this.show(false);
        }
    }


    class androidx.appcompat.widget.TooltipCompatHandler.2 implements Runnable {
        @Override
        public void run() {
            TooltipCompatHandler.this.hide();
        }
    }

}

