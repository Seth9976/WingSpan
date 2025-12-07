package com.onesignal.inAppMessages.internal.display.impl;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper.Callback;
import androidx.customview.widget.ViewDragHelper;
import com.onesignal.common.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00182\u00020\u0001:\u0003\u0018\u0019\u001AB\u000F\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000E\u001A\u00020\u000FH\u0016J\b\u0010\u0010\u001A\u00020\u000FH\u0002J\u0006\u0010\u0011\u001A\u00020\u000FJ\u0010\u0010\u0012\u001A\u00020\u00062\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\u0010\u0010\u0015\u001A\u00020\u000F2\b\u0010\u0016\u001A\u0004\u0018\u00010\u000BJ\u000E\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\f\u001A\u00020\rR\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u001B"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dismissing", "", "draggingDisabled", "mDragHelper", "Landroidx/customview/widget/ViewDragHelper;", "mListener", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$DraggableListener;", "params", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params;", "computeScroll", "", "createDragHelper", "dismiss", "onInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "setListener", "listener", "setParams", "Companion", "DraggableListener", "Params", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DraggableRelativeLayout extends RelativeLayout {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Companion;", "", "()V", "EXTRA_PX_DISMISS", "", "MARGIN_PX_SIZE", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\b\u0010\u0004\u001A\u00020\u0003H&J\b\u0010\u0005\u001A\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$DraggableListener;", "", "onDismiss", "", "onDragEnd", "onDragStart", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface DraggableListener {
        void onDismiss();

        void onDragEnd();

        void onDragStart();
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0010\u000B\n\u0002\b\u0018\b\u0000\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001A\u0010\t\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\n\u0010\u0006\"\u0004\b\u000B\u0010\bR\u001A\u0010\f\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u0006\"\u0004\b\u000E\u0010\bR\u001A\u0010\u000F\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001A\u0010\u0012\u001A\u00020\u0013X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0018\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0019\u0010\u0006\"\u0004\b\u001A\u0010\bR\u001A\u0010\u001B\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001C\u0010\u0006\"\u0004\b\u001D\u0010\bR\u001A\u0010\u001E\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u001F\u0010\u0006\"\u0004\b \u0010\bR\u001A\u0010!\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\u001A\u0010$\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001A\u0010\'\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b(\u0010\u0006\"\u0004\b)\u0010\b¨\u0006+"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params;", "", "()V", "dismissingYPos", "", "getDismissingYPos", "()I", "setDismissingYPos", "(I)V", "dismissingYVelocity", "getDismissingYVelocity", "setDismissingYVelocity", "dragDirection", "getDragDirection", "setDragDirection", "dragThresholdY", "getDragThresholdY", "setDragThresholdY", "draggingDisabled", "", "getDraggingDisabled", "()Z", "setDraggingDisabled", "(Z)V", "height", "getHeight", "setHeight", "maxXPos", "getMaxXPos", "setMaxXPos", "maxYPos", "getMaxYPos", "setMaxYPos", "messageHeight", "getMessageHeight", "setMessageHeight", "offScreenYPos", "getOffScreenYPos", "setOffScreenYPos", "posY", "getPosY", "setPosY", "Companion", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Params {
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$Params$Companion;", "", "()V", "DRAGGABLE_DIRECTION_DOWN", "", "DRAGGABLE_DIRECTION_UP", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
        public static final class com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.Params.Companion {
            private com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.Params.Companion() {
            }

            public com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.Params.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }
        }

        public static final com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.Params.Companion Companion = null;
        public static final int DRAGGABLE_DIRECTION_DOWN = 1;
        public static final int DRAGGABLE_DIRECTION_UP;
        private int dismissingYPos;
        private int dismissingYVelocity;
        private int dragDirection;
        private int dragThresholdY;
        private boolean draggingDisabled;
        private int height;
        private int maxXPos;
        private int maxYPos;
        private int messageHeight;
        private int offScreenYPos;
        private int posY;

        static {
            Params.Companion = new com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout.Params.Companion(null);
        }

        public final int getDismissingYPos() {
            return this.dismissingYPos;
        }

        public final int getDismissingYVelocity() {
            return this.dismissingYVelocity;
        }

        public final int getDragDirection() {
            return this.dragDirection;
        }

        public final int getDragThresholdY() {
            return this.dragThresholdY;
        }

        public final boolean getDraggingDisabled() {
            return this.draggingDisabled;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getMaxXPos() {
            return this.maxXPos;
        }

        public final int getMaxYPos() {
            return this.maxYPos;
        }

        public final int getMessageHeight() {
            return this.messageHeight;
        }

        public final int getOffScreenYPos() {
            return this.offScreenYPos;
        }

        public final int getPosY() {
            return this.posY;
        }

        public final void setDismissingYPos(int v) {
            this.dismissingYPos = v;
        }

        public final void setDismissingYVelocity(int v) {
            this.dismissingYVelocity = v;
        }

        public final void setDragDirection(int v) {
            this.dragDirection = v;
        }

        public final void setDragThresholdY(int v) {
            this.dragThresholdY = v;
        }

        public final void setDraggingDisabled(boolean z) {
            this.draggingDisabled = z;
        }

        public final void setHeight(int v) {
            this.height = v;
        }

        public final void setMaxXPos(int v) {
            this.maxXPos = v;
        }

        public final void setMaxYPos(int v) {
            this.maxYPos = v;
        }

        public final void setMessageHeight(int v) {
            this.messageHeight = v;
        }

        public final void setOffScreenYPos(int v) {
            this.offScreenYPos = v;
        }

        public final void setPosY(int v) {
            this.posY = v;
        }
    }

    public static final Companion Companion;
    private static final int EXTRA_PX_DISMISS;
    private static final int MARGIN_PX_SIZE;
    private boolean dismissing;
    private final boolean draggingDisabled;
    private ViewDragHelper mDragHelper;
    private DraggableListener mListener;
    private Params params;

    static {
        DraggableRelativeLayout.Companion = new Companion(null);
        DraggableRelativeLayout.MARGIN_PX_SIZE = ViewUtils.INSTANCE.dpToPx(28);
        DraggableRelativeLayout.EXTRA_PX_DISMISS = ViewUtils.INSTANCE.dpToPx(0x40);
    }

    public DraggableRelativeLayout(Context context0) {
        super(context0);
        this.setClipChildren(false);
        this.createDragHelper();
    }

    @Override  // android.view.View
    public void computeScroll() {
        super.computeScroll();
        ViewDragHelper viewDragHelper0 = this.mDragHelper;
        Intrinsics.checkNotNull(viewDragHelper0);
        if(viewDragHelper0.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private final void createDragHelper() {
        this.mDragHelper = ViewDragHelper.create(this, 1.0f, new Callback() {
            private int lastYPos;

            @Override  // androidx.customview.widget.ViewDragHelper$Callback
            public int clampViewPositionHorizontal(View view0, int v, int v1) {
                Intrinsics.checkNotNullParameter(view0, "child");
                Params draggableRelativeLayout$Params0 = DraggableRelativeLayout.this.params;
                Intrinsics.checkNotNull(draggableRelativeLayout$Params0);
                return draggableRelativeLayout$Params0.getMaxXPos();
            }

            @Override  // androidx.customview.widget.ViewDragHelper$Callback
            public int clampViewPositionVertical(View view0, int v, int v1) {
                Intrinsics.checkNotNullParameter(view0, "child");
                Params draggableRelativeLayout$Params0 = DraggableRelativeLayout.this.params;
                Intrinsics.checkNotNull(draggableRelativeLayout$Params0);
                if(draggableRelativeLayout$Params0.getDraggingDisabled()) {
                    Params draggableRelativeLayout$Params1 = DraggableRelativeLayout.this.params;
                    Intrinsics.checkNotNull(draggableRelativeLayout$Params1);
                    return draggableRelativeLayout$Params1.getMaxYPos();
                }
                this.lastYPos = v;
                Params draggableRelativeLayout$Params2 = DraggableRelativeLayout.this.params;
                Intrinsics.checkNotNull(draggableRelativeLayout$Params2);
                if(draggableRelativeLayout$Params2.getDragDirection() == 1) {
                    Params draggableRelativeLayout$Params3 = DraggableRelativeLayout.this.params;
                    Intrinsics.checkNotNull(draggableRelativeLayout$Params3);
                    if(v >= draggableRelativeLayout$Params3.getDragThresholdY() && DraggableRelativeLayout.this.mListener != null) {
                        DraggableListener draggableRelativeLayout$DraggableListener0 = DraggableRelativeLayout.this.mListener;
                        Intrinsics.checkNotNull(draggableRelativeLayout$DraggableListener0);
                        draggableRelativeLayout$DraggableListener0.onDragStart();
                    }
                    Params draggableRelativeLayout$Params4 = DraggableRelativeLayout.this.params;
                    Intrinsics.checkNotNull(draggableRelativeLayout$Params4);
                    if(v < draggableRelativeLayout$Params4.getMaxYPos()) {
                        Params draggableRelativeLayout$Params5 = DraggableRelativeLayout.this.params;
                        Intrinsics.checkNotNull(draggableRelativeLayout$Params5);
                        return draggableRelativeLayout$Params5.getMaxYPos();
                    }
                }
                else {
                    Params draggableRelativeLayout$Params6 = DraggableRelativeLayout.this.params;
                    Intrinsics.checkNotNull(draggableRelativeLayout$Params6);
                    if(v <= draggableRelativeLayout$Params6.getDragThresholdY() && DraggableRelativeLayout.this.mListener != null) {
                        DraggableListener draggableRelativeLayout$DraggableListener1 = DraggableRelativeLayout.this.mListener;
                        Intrinsics.checkNotNull(draggableRelativeLayout$DraggableListener1);
                        draggableRelativeLayout$DraggableListener1.onDragStart();
                    }
                    Params draggableRelativeLayout$Params7 = DraggableRelativeLayout.this.params;
                    Intrinsics.checkNotNull(draggableRelativeLayout$Params7);
                    if(v > draggableRelativeLayout$Params7.getMaxYPos()) {
                        Params draggableRelativeLayout$Params8 = DraggableRelativeLayout.this.params;
                        Intrinsics.checkNotNull(draggableRelativeLayout$Params8);
                        return draggableRelativeLayout$Params8.getMaxYPos();
                    }
                }
                return v;
            }

            @Override  // androidx.customview.widget.ViewDragHelper$Callback
            public void onViewReleased(View view0, float f, float f1) {
                Intrinsics.checkNotNullParameter(view0, "releasedChild");
                Params draggableRelativeLayout$Params0 = DraggableRelativeLayout.this.params;
                Intrinsics.checkNotNull(draggableRelativeLayout$Params0);
                int v = draggableRelativeLayout$Params0.getMaxYPos();
                if(!DraggableRelativeLayout.this.dismissing) {
                    Params draggableRelativeLayout$Params1 = DraggableRelativeLayout.this.params;
                    Intrinsics.checkNotNull(draggableRelativeLayout$Params1);
                    if(draggableRelativeLayout$Params1.getDragDirection() == 1) {
                        int v1 = this.lastYPos;
                        Params draggableRelativeLayout$Params2 = DraggableRelativeLayout.this.params;
                        Intrinsics.checkNotNull(draggableRelativeLayout$Params2);
                        if(v1 <= draggableRelativeLayout$Params2.getDismissingYPos()) {
                            Params draggableRelativeLayout$Params3 = DraggableRelativeLayout.this.params;
                            Intrinsics.checkNotNull(draggableRelativeLayout$Params3);
                            if(f1 > ((float)draggableRelativeLayout$Params3.getDismissingYVelocity())) {
                                goto label_15;
                            }
                        }
                        else {
                        label_15:
                            Params draggableRelativeLayout$Params4 = DraggableRelativeLayout.this.params;
                            Intrinsics.checkNotNull(draggableRelativeLayout$Params4);
                            v = draggableRelativeLayout$Params4.getOffScreenYPos();
                            DraggableRelativeLayout.this.dismissing = true;
                            if(DraggableRelativeLayout.this.mListener != null) {
                                DraggableListener draggableRelativeLayout$DraggableListener0 = DraggableRelativeLayout.this.mListener;
                                Intrinsics.checkNotNull(draggableRelativeLayout$DraggableListener0);
                                draggableRelativeLayout$DraggableListener0.onDismiss();
                            }
                        }
                    }
                    else {
                        int v2 = this.lastYPos;
                        Params draggableRelativeLayout$Params5 = DraggableRelativeLayout.this.params;
                        Intrinsics.checkNotNull(draggableRelativeLayout$Params5);
                        if(v2 >= draggableRelativeLayout$Params5.getDismissingYPos()) {
                            Params draggableRelativeLayout$Params6 = DraggableRelativeLayout.this.params;
                            Intrinsics.checkNotNull(draggableRelativeLayout$Params6);
                            if(f1 < ((float)draggableRelativeLayout$Params6.getDismissingYVelocity())) {
                                goto label_31;
                            }
                        }
                        else {
                        label_31:
                            Params draggableRelativeLayout$Params7 = DraggableRelativeLayout.this.params;
                            Intrinsics.checkNotNull(draggableRelativeLayout$Params7);
                            v = draggableRelativeLayout$Params7.getOffScreenYPos();
                            DraggableRelativeLayout.this.dismissing = true;
                            if(DraggableRelativeLayout.this.mListener != null) {
                                DraggableListener draggableRelativeLayout$DraggableListener1 = DraggableRelativeLayout.this.mListener;
                                Intrinsics.checkNotNull(draggableRelativeLayout$DraggableListener1);
                                draggableRelativeLayout$DraggableListener1.onDismiss();
                            }
                        }
                    }
                }
                ViewDragHelper viewDragHelper0 = DraggableRelativeLayout.this.mDragHelper;
                Intrinsics.checkNotNull(viewDragHelper0);
                Params draggableRelativeLayout$Params8 = DraggableRelativeLayout.this.params;
                Intrinsics.checkNotNull(draggableRelativeLayout$Params8);
                if(viewDragHelper0.settleCapturedViewAt(draggableRelativeLayout$Params8.getMaxXPos(), v)) {
                    ViewCompat.postInvalidateOnAnimation(DraggableRelativeLayout.this);
                }
            }

            @Override  // androidx.customview.widget.ViewDragHelper$Callback
            public boolean tryCaptureView(View view0, int v) {
                Intrinsics.checkNotNullParameter(view0, "child");
                return true;
            }
        });
    }

    public final void dismiss() {
        this.dismissing = true;
        ViewDragHelper viewDragHelper0 = this.mDragHelper;
        Intrinsics.checkNotNull(viewDragHelper0);
        int v = this.getLeft();
        Params draggableRelativeLayout$Params0 = this.params;
        Intrinsics.checkNotNull(draggableRelativeLayout$Params0);
        viewDragHelper0.smoothSlideViewTo(this, v, draggableRelativeLayout$Params0.getOffScreenYPos());
        ViewCompat.postInvalidateOnAnimation(this);
    }

    @Override  // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent0) {
        Intrinsics.checkNotNullParameter(motionEvent0, "event");
        if(this.dismissing) {
            return true;
        }
        switch(motionEvent0.getAction()) {
            case 0: 
            case 5: {
                DraggableListener draggableRelativeLayout$DraggableListener0 = this.mListener;
                if(draggableRelativeLayout$DraggableListener0 != null) {
                    Intrinsics.checkNotNull(draggableRelativeLayout$DraggableListener0);
                    draggableRelativeLayout$DraggableListener0.onDragEnd();
                }
            }
        }
        ViewDragHelper viewDragHelper0 = this.mDragHelper;
        Intrinsics.checkNotNull(viewDragHelper0);
        viewDragHelper0.processTouchEvent(motionEvent0);
        return false;
    }

    public final void setListener(DraggableListener draggableRelativeLayout$DraggableListener0) {
        this.mListener = draggableRelativeLayout$DraggableListener0;
    }

    public final void setParams(Params draggableRelativeLayout$Params0) {
        Intrinsics.checkNotNullParameter(draggableRelativeLayout$Params0, "params");
        this.params = draggableRelativeLayout$Params0;
        draggableRelativeLayout$Params0.setOffScreenYPos(draggableRelativeLayout$Params0.getMessageHeight() + draggableRelativeLayout$Params0.getPosY() + (Resources.getSystem().getDisplayMetrics().heightPixels - draggableRelativeLayout$Params0.getMessageHeight() - draggableRelativeLayout$Params0.getPosY()) + DraggableRelativeLayout.EXTRA_PX_DISMISS);
        draggableRelativeLayout$Params0.setDismissingYVelocity(ViewUtils.INSTANCE.dpToPx(3000));
        if(draggableRelativeLayout$Params0.getDragDirection() == 0) {
            draggableRelativeLayout$Params0.setOffScreenYPos(-draggableRelativeLayout$Params0.getMessageHeight() - DraggableRelativeLayout.MARGIN_PX_SIZE);
            draggableRelativeLayout$Params0.setDismissingYVelocity(-draggableRelativeLayout$Params0.getDismissingYVelocity());
            draggableRelativeLayout$Params0.setDismissingYPos(draggableRelativeLayout$Params0.getOffScreenYPos() / 3);
            return;
        }
        draggableRelativeLayout$Params0.setDismissingYPos(draggableRelativeLayout$Params0.getMessageHeight() / 3 + draggableRelativeLayout$Params0.getMaxYPos() * 2);
    }
}

