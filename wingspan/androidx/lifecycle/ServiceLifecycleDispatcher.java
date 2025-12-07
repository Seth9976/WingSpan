package androidx.lifecycle;

import android.os.Handler;

public class ServiceLifecycleDispatcher {
    static class DispatchRunnable implements Runnable {
        final Event mEvent;
        private final LifecycleRegistry mRegistry;
        private boolean mWasExecuted;

        DispatchRunnable(LifecycleRegistry lifecycleRegistry0, Event lifecycle$Event0) {
            this.mWasExecuted = false;
            this.mRegistry = lifecycleRegistry0;
            this.mEvent = lifecycle$Event0;
        }

        @Override
        public void run() {
            if(!this.mWasExecuted) {
                this.mRegistry.handleLifecycleEvent(this.mEvent);
                this.mWasExecuted = true;
            }
        }
    }

    private final Handler mHandler;
    private DispatchRunnable mLastDispatchRunnable;
    private final LifecycleRegistry mRegistry;

    public ServiceLifecycleDispatcher(LifecycleOwner lifecycleOwner0) {
        this.mRegistry = new LifecycleRegistry(lifecycleOwner0);
        this.mHandler = new Handler();
    }

    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }

    public void onServicePreSuperOnBind() {
        this.postDispatchRunnable(Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        this.postDispatchRunnable(Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        this.postDispatchRunnable(Event.ON_STOP);
        this.postDispatchRunnable(Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        this.postDispatchRunnable(Event.ON_START);
    }

    private void postDispatchRunnable(Event lifecycle$Event0) {
        DispatchRunnable serviceLifecycleDispatcher$DispatchRunnable0 = this.mLastDispatchRunnable;
        if(serviceLifecycleDispatcher$DispatchRunnable0 != null) {
            serviceLifecycleDispatcher$DispatchRunnable0.run();
        }
        DispatchRunnable serviceLifecycleDispatcher$DispatchRunnable1 = new DispatchRunnable(this.mRegistry, lifecycle$Event0);
        this.mLastDispatchRunnable = serviceLifecycleDispatcher$DispatchRunnable1;
        this.mHandler.postAtFrontOfQueue(serviceLifecycleDispatcher$DispatchRunnable1);
    }
}

