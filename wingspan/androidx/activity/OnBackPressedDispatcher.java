package androidx.activity;

import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

public final class OnBackPressedDispatcher {
    class LifecycleOnBackPressedCancellable implements Cancellable, LifecycleEventObserver {
        private Cancellable mCurrentCancellable;
        private final Lifecycle mLifecycle;
        private final OnBackPressedCallback mOnBackPressedCallback;

        LifecycleOnBackPressedCancellable(Lifecycle lifecycle0, OnBackPressedCallback onBackPressedCallback0) {
            this.mLifecycle = lifecycle0;
            this.mOnBackPressedCallback = onBackPressedCallback0;
            lifecycle0.addObserver(this);
        }

        @Override  // androidx.activity.Cancellable
        public void cancel() {
            this.mLifecycle.removeObserver(this);
            this.mOnBackPressedCallback.removeCancellable(this);
            Cancellable cancellable0 = this.mCurrentCancellable;
            if(cancellable0 != null) {
                cancellable0.cancel();
                this.mCurrentCancellable = null;
            }
        }

        @Override  // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
            if(lifecycle$Event0 == Event.ON_START) {
                this.mCurrentCancellable = OnBackPressedDispatcher.this.addCancellableCallback(this.mOnBackPressedCallback);
                return;
            }
            if(lifecycle$Event0 == Event.ON_STOP) {
                Cancellable cancellable0 = this.mCurrentCancellable;
                if(cancellable0 != null) {
                    cancellable0.cancel();
                }
            }
            else if(lifecycle$Event0 == Event.ON_DESTROY) {
                this.cancel();
            }
        }
    }

    class OnBackPressedCancellable implements Cancellable {
        private final OnBackPressedCallback mOnBackPressedCallback;

        OnBackPressedCancellable(OnBackPressedCallback onBackPressedCallback0) {
            this.mOnBackPressedCallback = onBackPressedCallback0;
        }

        @Override  // androidx.activity.Cancellable
        public void cancel() {
            OnBackPressedDispatcher.this.mOnBackPressedCallbacks.remove(this.mOnBackPressedCallback);
            this.mOnBackPressedCallback.removeCancellable(this);
        }
    }

    private final Runnable mFallbackOnBackPressed;
    final ArrayDeque mOnBackPressedCallbacks;

    public OnBackPressedDispatcher() {
        this(null);
    }

    public OnBackPressedDispatcher(Runnable runnable0) {
        this.mOnBackPressedCallbacks = new ArrayDeque();
        this.mFallbackOnBackPressed = runnable0;
    }

    public void addCallback(OnBackPressedCallback onBackPressedCallback0) {
        this.addCancellableCallback(onBackPressedCallback0);
    }

    public void addCallback(LifecycleOwner lifecycleOwner0, OnBackPressedCallback onBackPressedCallback0) {
        Lifecycle lifecycle0 = lifecycleOwner0.getLifecycle();
        if(lifecycle0.getCurrentState() == State.DESTROYED) {
            return;
        }
        onBackPressedCallback0.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle0, onBackPressedCallback0));
    }

    Cancellable addCancellableCallback(OnBackPressedCallback onBackPressedCallback0) {
        this.mOnBackPressedCallbacks.add(onBackPressedCallback0);
        Cancellable cancellable0 = new OnBackPressedCancellable(this, onBackPressedCallback0);
        onBackPressedCallback0.addCancellable(cancellable0);
        return cancellable0;
    }

    public boolean hasEnabledCallbacks() {
        Iterator iterator0 = this.mOnBackPressedCallbacks.descendingIterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            if(((OnBackPressedCallback)object0).isEnabled()) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public void onBackPressed() {
        Iterator iterator0 = this.mOnBackPressedCallbacks.descendingIterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            OnBackPressedCallback onBackPressedCallback0 = (OnBackPressedCallback)object0;
            if(onBackPressedCallback0.isEnabled()) {
                onBackPressedCallback0.handleOnBackPressed();
                return;
            }
            if(false) {
                break;
            }
        }
        Runnable runnable0 = this.mFallbackOnBackPressed;
        if(runnable0 != null) {
            runnable0.run();
        }
    }
}

