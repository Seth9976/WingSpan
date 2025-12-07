package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
    static class Api16Impl {
        static ViewPropertyAnimator withEndAction(ViewPropertyAnimator viewPropertyAnimator0, Runnable runnable0) {
            return viewPropertyAnimator0.withEndAction(runnable0);
        }

        static ViewPropertyAnimator withLayer(ViewPropertyAnimator viewPropertyAnimator0) {
            return viewPropertyAnimator0.withLayer();
        }

        static ViewPropertyAnimator withStartAction(ViewPropertyAnimator viewPropertyAnimator0, Runnable runnable0) {
            return viewPropertyAnimator0.withStartAction(runnable0);
        }
    }

    static class Api18Impl {
        static Interpolator getInterpolator(ViewPropertyAnimator viewPropertyAnimator0) {
            return (Interpolator)viewPropertyAnimator0.getInterpolator();
        }
    }

    static class Api19Impl {
        static ViewPropertyAnimator setUpdateListener(ViewPropertyAnimator viewPropertyAnimator0, ValueAnimator.AnimatorUpdateListener valueAnimator$AnimatorUpdateListener0) {
            return viewPropertyAnimator0.setUpdateListener(valueAnimator$AnimatorUpdateListener0);
        }
    }

    static class Api21Impl {
        static ViewPropertyAnimator translationZ(ViewPropertyAnimator viewPropertyAnimator0, float f) {
            return viewPropertyAnimator0.translationZ(f);
        }

        static ViewPropertyAnimator translationZBy(ViewPropertyAnimator viewPropertyAnimator0, float f) {
            return viewPropertyAnimator0.translationZBy(f);
        }

        static ViewPropertyAnimator z(ViewPropertyAnimator viewPropertyAnimator0, float f) {
            return viewPropertyAnimator0.z(f);
        }

        static ViewPropertyAnimator zBy(ViewPropertyAnimator viewPropertyAnimator0, float f) {
            return viewPropertyAnimator0.zBy(f);
        }
    }

    static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
        boolean mAnimEndCalled;
        ViewPropertyAnimatorCompat mVpa;

        ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat viewPropertyAnimatorCompat0) {
            this.mVpa = viewPropertyAnimatorCompat0;
        }

        @Override  // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationCancel(View view0) {
            Object object0 = view0.getTag(0x7E000000);
            ViewPropertyAnimatorListener viewPropertyAnimatorListener0 = object0 instanceof ViewPropertyAnimatorListener ? ((ViewPropertyAnimatorListener)object0) : null;
            if(viewPropertyAnimatorListener0 != null) {
                viewPropertyAnimatorListener0.onAnimationCancel(view0);
            }
        }

        @Override  // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view0) {
            ViewPropertyAnimatorListener viewPropertyAnimatorListener0 = null;
            if(this.mVpa.mOldLayerType > -1) {
                view0.setLayerType(this.mVpa.mOldLayerType, null);
                this.mVpa.mOldLayerType = -1;
            }
            if(this.mVpa.mEndAction != null) {
                Runnable runnable0 = this.mVpa.mEndAction;
                this.mVpa.mEndAction = null;
                runnable0.run();
            }
            Object object0 = view0.getTag(0x7E000000);
            if(object0 instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener0 = (ViewPropertyAnimatorListener)object0;
            }
            if(viewPropertyAnimatorListener0 != null) {
                viewPropertyAnimatorListener0.onAnimationEnd(view0);
            }
            this.mAnimEndCalled = true;
        }

        @Override  // androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationStart(View view0) {
            this.mAnimEndCalled = false;
            ViewPropertyAnimatorListener viewPropertyAnimatorListener0 = null;
            if(this.mVpa.mOldLayerType > -1) {
                view0.setLayerType(2, null);
            }
            if(this.mVpa.mStartAction != null) {
                Runnable runnable0 = this.mVpa.mStartAction;
                this.mVpa.mStartAction = null;
                runnable0.run();
            }
            Object object0 = view0.getTag(0x7E000000);
            if(object0 instanceof ViewPropertyAnimatorListener) {
                viewPropertyAnimatorListener0 = (ViewPropertyAnimatorListener)object0;
            }
            if(viewPropertyAnimatorListener0 != null) {
                viewPropertyAnimatorListener0.onAnimationStart(view0);
            }
        }
    }

    static final int LISTENER_TAG_ID = 0x7E000000;
    Runnable mEndAction;
    int mOldLayerType;
    Runnable mStartAction;
    private final WeakReference mView;

    ViewPropertyAnimatorCompat(View view0) {
        this.mStartAction = null;
        this.mEndAction = null;
        this.mOldLayerType = -1;
        this.mView = new WeakReference(view0);
    }

    public ViewPropertyAnimatorCompat alpha(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().alpha(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat alphaBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().alphaBy(f);
        }
        return this;
    }

    public void cancel() {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().cancel();
        }
    }

    public long getDuration() {
        View view0 = (View)this.mView.get();
        return view0 == null ? 0L : view0.animate().getDuration();
    }

    public Interpolator getInterpolator() {
        View view0 = (View)this.mView.get();
        return view0 == null ? null : Api18Impl.getInterpolator(view0.animate());
    }

    public long getStartDelay() {
        View view0 = (View)this.mView.get();
        return view0 == null ? 0L : view0.animate().getStartDelay();
    }

    // 检测为 Lambda 实现
    static void lambda$setUpdateListener$0(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener0, View view0, ValueAnimator valueAnimator0) [...]

    public ViewPropertyAnimatorCompat rotation(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().rotation(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().rotationBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationX(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().rotationX(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationXBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().rotationXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationY(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().rotationY(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat rotationYBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().rotationYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleX(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().scaleX(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleXBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().scaleXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleY(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().scaleY(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat scaleYBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().scaleYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setDuration(long v) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().setDuration(v);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setInterpolator(Interpolator interpolator0) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().setInterpolator(interpolator0);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setListener(ViewPropertyAnimatorListener viewPropertyAnimatorListener0) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            this.setListenerInternal(view0, viewPropertyAnimatorListener0);
        }
        return this;
    }

    private void setListenerInternal(View view0, ViewPropertyAnimatorListener viewPropertyAnimatorListener0) {
        if(viewPropertyAnimatorListener0 != null) {
            view0.animate().setListener(new AnimatorListenerAdapter() {
                @Override  // android.animation.AnimatorListenerAdapter
                public void onAnimationCancel(Animator animator0) {
                    viewPropertyAnimatorListener0.onAnimationCancel(view0);
                }

                @Override  // android.animation.AnimatorListenerAdapter
                public void onAnimationEnd(Animator animator0) {
                    viewPropertyAnimatorListener0.onAnimationEnd(view0);
                }

                @Override  // android.animation.AnimatorListenerAdapter
                public void onAnimationStart(Animator animator0) {
                    viewPropertyAnimatorListener0.onAnimationStart(view0);
                }
            });
            return;
        }
        view0.animate().setListener(null);
    }

    public ViewPropertyAnimatorCompat setStartDelay(long v) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().setStartDelay(v);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat setUpdateListener(ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener0) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            ViewPropertyAnimatorCompat..ExternalSyntheticLambda0 viewPropertyAnimatorCompat$$ExternalSyntheticLambda00 = viewPropertyAnimatorUpdateListener0 == null ? null : (ValueAnimator valueAnimator0) -> viewPropertyAnimatorUpdateListener0.onAnimationUpdate(view0);
            Api19Impl.setUpdateListener(view0.animate(), viewPropertyAnimatorCompat$$ExternalSyntheticLambda00);
        }
        return this;
    }

    public void start() {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().start();
        }
    }

    public ViewPropertyAnimatorCompat translationX(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().translationX(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationXBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().translationXBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationY(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().translationY(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationYBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().translationYBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZ(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            Api21Impl.translationZ(view0.animate(), f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat translationZBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            Api21Impl.translationZBy(view0.animate(), f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withEndAction(Runnable runnable0) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            Api16Impl.withEndAction(view0.animate(), runnable0);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withLayer() {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            Api16Impl.withLayer(view0.animate());
        }
        return this;
    }

    public ViewPropertyAnimatorCompat withStartAction(Runnable runnable0) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            Api16Impl.withStartAction(view0.animate(), runnable0);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat x(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().x(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat xBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().xBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat y(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().y(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat yBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            view0.animate().yBy(f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat z(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            Api21Impl.z(view0.animate(), f);
        }
        return this;
    }

    public ViewPropertyAnimatorCompat zBy(float f) {
        View view0 = (View)this.mView.get();
        if(view0 != null) {
            Api21Impl.zBy(view0.animate(), f);
        }
        return this;
    }
}

