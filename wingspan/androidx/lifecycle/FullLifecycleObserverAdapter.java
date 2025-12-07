package androidx.lifecycle;

class FullLifecycleObserverAdapter implements LifecycleEventObserver {
    private final FullLifecycleObserver mFullLifecycleObserver;
    private final LifecycleEventObserver mLifecycleEventObserver;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver0, LifecycleEventObserver lifecycleEventObserver0) {
        this.mFullLifecycleObserver = fullLifecycleObserver0;
        this.mLifecycleEventObserver = lifecycleEventObserver0;
    }

    @Override  // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
        switch(lifecycle$Event0) {
            case 1: {
                this.mFullLifecycleObserver.onCreate(lifecycleOwner0);
                break;
            }
            case 2: {
                this.mFullLifecycleObserver.onStart(lifecycleOwner0);
                break;
            }
            case 3: {
                this.mFullLifecycleObserver.onResume(lifecycleOwner0);
                break;
            }
            case 4: {
                this.mFullLifecycleObserver.onPause(lifecycleOwner0);
                break;
            }
            case 5: {
                this.mFullLifecycleObserver.onStop(lifecycleOwner0);
                break;
            }
            case 6: {
                this.mFullLifecycleObserver.onDestroy(lifecycleOwner0);
                break;
            }
            case 7: {
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            }
        }
        LifecycleEventObserver lifecycleEventObserver0 = this.mLifecycleEventObserver;
        if(lifecycleEventObserver0 != null) {
            lifecycleEventObserver0.onStateChanged(lifecycleOwner0, lifecycle$Event0);
        }
    }
}

