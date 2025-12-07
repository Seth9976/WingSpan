package androidx.core.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat {
    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent arg1);

        void setIsLongpressEnabled(boolean arg1);

        void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener arg1);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler0) {
                super(handler0.getLooper());
            }

            @Override  // android.os.Handler
            public void handleMessage(Message message0) {
                switch(message0.what) {
                    case 1: {
                        GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                        return;
                    }
                    case 2: {
                        GestureDetectorCompatImplBase.this.dispatchLongPress();
                        return;
                    }
                    case 3: {
                        if(GestureDetectorCompatImplBase.this.mDoubleTapListener != null) {
                            if(!GestureDetectorCompatImplBase.this.mStillDown) {
                                GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                                return;
                            }
                            GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
                            return;
                        }
                        return;
                    }
                    default: {
                        throw new RuntimeException("Unknown message " + message0);
                    }
                }
            }
        }

        private static final int DOUBLE_TAP_TIMEOUT = 0;
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT;
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        MotionEvent mCurrentDownEvent;
        boolean mDeferConfirmSingleTap;
        GestureDetector.OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        final GestureDetector.OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        static {
            GestureDetectorCompatImplBase.TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
            GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        }

        GestureDetectorCompatImplBase(Context context0, GestureDetector.OnGestureListener gestureDetector$OnGestureListener0, Handler handler0) {
            this.mHandler = handler0 == null ? new GestureHandler(this) : new GestureHandler(this, handler0);
            this.mListener = gestureDetector$OnGestureListener0;
            if(gestureDetector$OnGestureListener0 instanceof GestureDetector.OnDoubleTapListener) {
                this.setOnDoubleTapListener(((GestureDetector.OnDoubleTapListener)gestureDetector$OnGestureListener0));
            }
            this.init(context0);
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if(this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if(this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }

        private void init(Context context0) {
            if(context0 == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if(this.mListener == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.mIsLongpressEnabled = true;
            ViewConfiguration viewConfiguration0 = ViewConfiguration.get(context0);
            int v = viewConfiguration0.getScaledTouchSlop();
            int v1 = viewConfiguration0.getScaledDoubleTapSlop();
            this.mMinimumFlingVelocity = viewConfiguration0.getScaledMinimumFlingVelocity();
            this.mMaximumFlingVelocity = viewConfiguration0.getScaledMaximumFlingVelocity();
            this.mTouchSlopSquare = v * v;
            this.mDoubleTapSlopSquare = v1 * v1;
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent0, MotionEvent motionEvent1, MotionEvent motionEvent2) {
            if(!this.mAlwaysInBiggerTapRegion) {
                return false;
            }
            if(motionEvent2.getEventTime() - motionEvent1.getEventTime() > ((long)GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT)) {
                return false;
            }
            int v = ((int)motionEvent0.getX()) - ((int)motionEvent2.getX());
            int v1 = ((int)motionEvent0.getY()) - ((int)motionEvent2.getY());
            return v * v + v1 * v1 < this.mDoubleTapSlopSquare;
        }

        @Override  // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        @Override  // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent motionEvent0) {
            boolean z4;
            int v9;
            int v = motionEvent0.getAction();
            if(this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent0);
            boolean z = (v & 0xFF) == 6;
            int v1 = z ? motionEvent0.getActionIndex() : -1;
            int v2 = motionEvent0.getPointerCount();
            float f = 0.0f;
            float f1 = 0.0f;
            for(int v3 = 0; v3 < v2; ++v3) {
                if(v1 != v3) {
                    f += motionEvent0.getX(v3);
                    f1 += motionEvent0.getY(v3);
                }
            }
            int v4 = z ? v2 - 1 : v2;
            float f2 = f / ((float)v4);
            float f3 = f1 / ((float)v4);
            if((v & 0xFF) != 0) {
                switch(v & 0xFF) {
                    case 1: {
                        this.mStillDown = false;
                        MotionEvent motionEvent1 = MotionEvent.obtain(motionEvent0);
                        if(this.mIsDoubleTapping) {
                            v9 = this.mDoubleTapListener.onDoubleTapEvent(motionEvent0);
                        }
                        else if(this.mInLongPress) {
                            this.mHandler.removeMessages(3);
                            this.mInLongPress = false;
                            v9 = 0;
                        }
                        else if(this.mAlwaysInTapRegion) {
                            boolean z1 = this.mListener.onSingleTapUp(motionEvent0);
                            if(this.mDeferConfirmSingleTap) {
                                GestureDetector.OnDoubleTapListener gestureDetector$OnDoubleTapListener0 = this.mDoubleTapListener;
                                if(gestureDetector$OnDoubleTapListener0 != null) {
                                    gestureDetector$OnDoubleTapListener0.onSingleTapConfirmed(motionEvent0);
                                }
                            }
                            v9 = z1;
                        }
                        else {
                            VelocityTracker velocityTracker0 = this.mVelocityTracker;
                            int v10 = motionEvent0.getPointerId(0);
                            velocityTracker0.computeCurrentVelocity(1000, ((float)this.mMaximumFlingVelocity));
                            float f6 = velocityTracker0.getYVelocity(v10);
                            float f7 = velocityTracker0.getXVelocity(v10);
                            v9 = Math.abs(f6) > ((float)this.mMinimumFlingVelocity) || Math.abs(f7) > ((float)this.mMinimumFlingVelocity) ? this.mListener.onFling(this.mCurrentDownEvent, motionEvent0, f7, f6) : 0;
                        }
                        MotionEvent motionEvent2 = this.mPreviousUpEvent;
                        if(motionEvent2 != null) {
                            motionEvent2.recycle();
                        }
                        this.mPreviousUpEvent = motionEvent1;
                        VelocityTracker velocityTracker1 = this.mVelocityTracker;
                        if(velocityTracker1 != null) {
                            velocityTracker1.recycle();
                            this.mVelocityTracker = null;
                        }
                        this.mIsDoubleTapping = false;
                        this.mDeferConfirmSingleTap = false;
                        this.mHandler.removeMessages(1);
                        this.mHandler.removeMessages(2);
                        return v9;
                    }
                    case 2: {
                        if(!this.mInLongPress) {
                            float f8 = this.mLastFocusX - f2;
                            float f9 = this.mLastFocusY - f3;
                            if(this.mIsDoubleTapping) {
                                return this.mDoubleTapListener.onDoubleTapEvent(motionEvent0);
                            }
                            if(this.mAlwaysInTapRegion) {
                                int v11 = (int)(f2 - this.mDownFocusX);
                                int v12 = (int)(f3 - this.mDownFocusY);
                                int v13 = v11 * v11 + v12 * v12;
                                if(v13 > this.mTouchSlopSquare) {
                                    v9 = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent0, f8, f9);
                                    this.mLastFocusX = f2;
                                    this.mLastFocusY = f3;
                                    this.mAlwaysInTapRegion = false;
                                    this.mHandler.removeMessages(3);
                                    this.mHandler.removeMessages(1);
                                    this.mHandler.removeMessages(2);
                                }
                                else {
                                    v9 = 0;
                                }
                                if(v13 > this.mTouchSlopSquare) {
                                    this.mAlwaysInBiggerTapRegion = false;
                                    return v9;
                                }
                                return v9;
                            }
                            if(Math.abs(f8) >= 1.0f || Math.abs(f9) >= 1.0f) {
                                boolean z2 = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent0, f8, f9);
                                this.mLastFocusX = f2;
                                this.mLastFocusY = f3;
                                return z2;
                            }
                        }
                        return false;
                    }
                    case 3: {
                        this.cancel();
                        return false;
                    }
                    default: {
                        switch(v & 0xFF) {
                            case 5: {
                                this.mLastFocusX = f2;
                                this.mDownFocusX = f2;
                                this.mLastFocusY = f3;
                                this.mDownFocusY = f3;
                                this.cancelTaps();
                                return false;
                            }
                            case 6: {
                                this.mLastFocusX = f2;
                                this.mDownFocusX = f2;
                                this.mLastFocusY = f3;
                                this.mDownFocusY = f3;
                                this.mVelocityTracker.computeCurrentVelocity(1000, ((float)this.mMaximumFlingVelocity));
                                int v5 = motionEvent0.getActionIndex();
                                int v6 = motionEvent0.getPointerId(v5);
                                float f4 = this.mVelocityTracker.getXVelocity(v6);
                                float f5 = this.mVelocityTracker.getYVelocity(v6);
                                for(int v7 = 0; v7 < v2; ++v7) {
                                    if(v7 != v5) {
                                        int v8 = motionEvent0.getPointerId(v7);
                                        if(this.mVelocityTracker.getXVelocity(v8) * f4 + this.mVelocityTracker.getYVelocity(v8) * f5 < 0.0f) {
                                            this.mVelocityTracker.clear();
                                            return false;
                                        }
                                    }
                                }
                                return false;
                            }
                            default: {
                                return false;
                            }
                        }
                    }
                }
            }
            if(this.mDoubleTapListener == null) {
                z4 = false;
            }
            else {
                boolean z3 = this.mHandler.hasMessages(3);
                if(z3) {
                    this.mHandler.removeMessages(3);
                }
                if(this.mCurrentDownEvent == null || (this.mPreviousUpEvent == null || !z3 || !this.isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, motionEvent0))) {
                    this.mHandler.sendEmptyMessageDelayed(3, ((long)GestureDetectorCompatImplBase.DOUBLE_TAP_TIMEOUT));
                    z4 = false;
                }
                else {
                    this.mIsDoubleTapping = true;
                    z4 = this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | this.mDoubleTapListener.onDoubleTapEvent(motionEvent0);
                }
            }
            this.mLastFocusX = f2;
            this.mDownFocusX = f2;
            this.mLastFocusY = f3;
            this.mDownFocusY = f3;
            MotionEvent motionEvent3 = this.mCurrentDownEvent;
            if(motionEvent3 != null) {
                motionEvent3.recycle();
            }
            this.mCurrentDownEvent = MotionEvent.obtain(motionEvent0);
            this.mAlwaysInTapRegion = true;
            this.mAlwaysInBiggerTapRegion = true;
            this.mStillDown = true;
            this.mInLongPress = false;
            this.mDeferConfirmSingleTap = false;
            if(this.mIsLongpressEnabled) {
                this.mHandler.removeMessages(2);
                long v14 = this.mCurrentDownEvent.getDownTime();
                long v15 = (long)ViewConfiguration.getLongPressTimeout();
                this.mHandler.sendEmptyMessageAtTime(2, v14 + ((long)GestureDetectorCompatImplBase.TAP_TIMEOUT) + v15);
            }
            long v16 = this.mCurrentDownEvent.getDownTime();
            this.mHandler.sendEmptyMessageAtTime(1, v16 + ((long)GestureDetectorCompatImplBase.TAP_TIMEOUT));
            return z4 | this.mListener.onDown(motionEvent0);
        }

        @Override  // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.mIsLongpressEnabled = z;
        }

        @Override  // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener gestureDetector$OnDoubleTapListener0) {
            this.mDoubleTapListener = gestureDetector$OnDoubleTapListener0;
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        GestureDetectorCompatImplJellybeanMr2(Context context0, GestureDetector.OnGestureListener gestureDetector$OnGestureListener0, Handler handler0) {
            this.mDetector = new GestureDetector(context0, gestureDetector$OnGestureListener0, handler0);
        }

        @Override  // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        @Override  // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
        public boolean onTouchEvent(MotionEvent motionEvent0) {
            return this.mDetector.onTouchEvent(motionEvent0);
        }

        @Override  // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
        public void setIsLongpressEnabled(boolean z) {
            this.mDetector.setIsLongpressEnabled(z);
        }

        @Override  // androidx.core.view.GestureDetectorCompat$GestureDetectorCompatImpl
        public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener gestureDetector$OnDoubleTapListener0) {
            this.mDetector.setOnDoubleTapListener(gestureDetector$OnDoubleTapListener0);
        }
    }

    private final GestureDetectorCompatImpl mImpl;

    public GestureDetectorCompat(Context context0, GestureDetector.OnGestureListener gestureDetector$OnGestureListener0) {
        this(context0, gestureDetector$OnGestureListener0, null);
    }

    public GestureDetectorCompat(Context context0, GestureDetector.OnGestureListener gestureDetector$OnGestureListener0, Handler handler0) {
        this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context0, gestureDetector$OnGestureListener0, handler0);
    }

    public boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public boolean onTouchEvent(MotionEvent motionEvent0) {
        return this.mImpl.onTouchEvent(motionEvent0);
    }

    public void setIsLongpressEnabled(boolean z) {
        this.mImpl.setIsLongpressEnabled(z);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener gestureDetector$OnDoubleTapListener0) {
        this.mImpl.setOnDoubleTapListener(gestureDetector$OnDoubleTapListener0);
    }
}

