package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class LifecycleRegistry extends Lifecycle {
    static class ObserverWithState {
        LifecycleEventObserver mLifecycleObserver;
        State mState;

        ObserverWithState(LifecycleObserver lifecycleObserver0, State lifecycle$State0) {
            this.mLifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver0);
            this.mState = lifecycle$State0;
        }

        void dispatchEvent(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
            State lifecycle$State0 = lifecycle$Event0.getTargetState();
            this.mState = LifecycleRegistry.min(this.mState, lifecycle$State0);
            this.mLifecycleObserver.onStateChanged(lifecycleOwner0, lifecycle$Event0);
            this.mState = lifecycle$State0;
        }
    }

    private int mAddingObserverCounter;
    private final boolean mEnforceMainThread;
    private boolean mHandlingEvent;
    private final WeakReference mLifecycleOwner;
    private boolean mNewEventOccurred;
    private FastSafeIterableMap mObserverMap;
    private ArrayList mParentStates;
    private State mState;

    public LifecycleRegistry(LifecycleOwner lifecycleOwner0) {
        this(lifecycleOwner0, true);
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner0, boolean z) {
        this.mObserverMap = new FastSafeIterableMap();
        this.mAddingObserverCounter = 0;
        this.mHandlingEvent = false;
        this.mNewEventOccurred = false;
        this.mParentStates = new ArrayList();
        this.mLifecycleOwner = new WeakReference(lifecycleOwner0);
        this.mState = State.INITIALIZED;
        this.mEnforceMainThread = z;
    }

    @Override  // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver lifecycleObserver0) {
        this.enforceMainThreadIfNeeded("addObserver");
        ObserverWithState lifecycleRegistry$ObserverWithState0 = new ObserverWithState(lifecycleObserver0, (this.mState == State.DESTROYED ? State.DESTROYED : State.INITIALIZED));
        if(((ObserverWithState)this.mObserverMap.putIfAbsent(lifecycleObserver0, lifecycleRegistry$ObserverWithState0)) != null) {
            return;
        }
        LifecycleOwner lifecycleOwner0 = (LifecycleOwner)this.mLifecycleOwner.get();
        if(lifecycleOwner0 == null) {
            return;
        }
        boolean z = this.mAddingObserverCounter != 0 || this.mHandlingEvent;
        State lifecycle$State0 = this.calculateTargetState(lifecycleObserver0);
        ++this.mAddingObserverCounter;
        while(lifecycleRegistry$ObserverWithState0.mState.compareTo(lifecycle$State0) < 0 && this.mObserverMap.contains(lifecycleObserver0)) {
            this.pushParentState(lifecycleRegistry$ObserverWithState0.mState);
            Event lifecycle$Event0 = Event.upFrom(lifecycleRegistry$ObserverWithState0.mState);
            if(lifecycle$Event0 == null) {
                throw new IllegalStateException("no event up from " + lifecycleRegistry$ObserverWithState0.mState);
            }
            lifecycleRegistry$ObserverWithState0.dispatchEvent(lifecycleOwner0, lifecycle$Event0);
            this.popParentState();
            lifecycle$State0 = this.calculateTargetState(lifecycleObserver0);
        }
        if(!z) {
            this.sync();
        }
        --this.mAddingObserverCounter;
    }

    private void backwardPass(LifecycleOwner lifecycleOwner0) {
        Iterator iterator0 = this.mObserverMap.descendingIterator();
        while(iterator0.hasNext() && !this.mNewEventOccurred) {
            Object object0 = iterator0.next();
            ObserverWithState lifecycleRegistry$ObserverWithState0 = (ObserverWithState)((Map.Entry)object0).getValue();
            while(lifecycleRegistry$ObserverWithState0.mState.compareTo(this.mState) > 0 && !this.mNewEventOccurred && this.mObserverMap.contains(((LifecycleObserver)((Map.Entry)object0).getKey()))) {
                Event lifecycle$Event0 = Event.downFrom(lifecycleRegistry$ObserverWithState0.mState);
                if(lifecycle$Event0 == null) {
                    throw new IllegalStateException("no event down from " + lifecycleRegistry$ObserverWithState0.mState);
                }
                this.pushParentState(lifecycle$Event0.getTargetState());
                lifecycleRegistry$ObserverWithState0.dispatchEvent(lifecycleOwner0, lifecycle$Event0);
                this.popParentState();
            }
        }
    }

    private State calculateTargetState(LifecycleObserver lifecycleObserver0) {
        Map.Entry map$Entry0 = this.mObserverMap.ceil(lifecycleObserver0);
        State lifecycle$State0 = null;
        State lifecycle$State1 = map$Entry0 == null ? null : ((ObserverWithState)map$Entry0.getValue()).mState;
        if(!this.mParentStates.isEmpty()) {
            lifecycle$State0 = (State)this.mParentStates.get(this.mParentStates.size() - 1);
        }
        return LifecycleRegistry.min(LifecycleRegistry.min(this.mState, lifecycle$State1), lifecycle$State0);
    }

    public static LifecycleRegistry createUnsafe(LifecycleOwner lifecycleOwner0) {
        return new LifecycleRegistry(lifecycleOwner0, false);
    }

    private void enforceMainThreadIfNeeded(String s) {
        if(this.mEnforceMainThread && !ArchTaskExecutor.getInstance().isMainThread()) {
            throw new IllegalStateException("Method " + s + " must be called on the main thread");
        }
    }

    private void forwardPass(LifecycleOwner lifecycleOwner0) {
        IteratorWithAdditions safeIterableMap$IteratorWithAdditions0 = this.mObserverMap.iteratorWithAdditions();
        while(safeIterableMap$IteratorWithAdditions0.hasNext() && !this.mNewEventOccurred) {
            Object object0 = safeIterableMap$IteratorWithAdditions0.next();
            ObserverWithState lifecycleRegistry$ObserverWithState0 = (ObserverWithState)((Map.Entry)object0).getValue();
            while(lifecycleRegistry$ObserverWithState0.mState.compareTo(this.mState) < 0 && !this.mNewEventOccurred && this.mObserverMap.contains(((LifecycleObserver)((Map.Entry)object0).getKey()))) {
                this.pushParentState(lifecycleRegistry$ObserverWithState0.mState);
                Event lifecycle$Event0 = Event.upFrom(lifecycleRegistry$ObserverWithState0.mState);
                if(lifecycle$Event0 == null) {
                    throw new IllegalStateException("no event up from " + lifecycleRegistry$ObserverWithState0.mState);
                }
                lifecycleRegistry$ObserverWithState0.dispatchEvent(lifecycleOwner0, lifecycle$Event0);
                this.popParentState();
            }
        }
    }

    @Override  // androidx.lifecycle.Lifecycle
    public State getCurrentState() {
        return this.mState;
    }

    public int getObserverCount() {
        this.enforceMainThreadIfNeeded("getObserverCount");
        return this.mObserverMap.size();
    }

    public void handleLifecycleEvent(Event lifecycle$Event0) {
        this.enforceMainThreadIfNeeded("handleLifecycleEvent");
        this.moveToState(lifecycle$Event0.getTargetState());
    }

    private boolean isSynced() {
        if(this.mObserverMap.size() == 0) {
            return true;
        }
        State lifecycle$State0 = ((ObserverWithState)this.mObserverMap.eldest().getValue()).mState;
        State lifecycle$State1 = ((ObserverWithState)this.mObserverMap.newest().getValue()).mState;
        return lifecycle$State0 == lifecycle$State1 && this.mState == lifecycle$State1;
    }

    @Deprecated
    public void markState(State lifecycle$State0) {
        this.enforceMainThreadIfNeeded("markState");
        this.setCurrentState(lifecycle$State0);
    }

    static State min(State lifecycle$State0, State lifecycle$State1) {
        return lifecycle$State1 == null || lifecycle$State1.compareTo(lifecycle$State0) >= 0 ? lifecycle$State0 : lifecycle$State1;
    }

    private void moveToState(State lifecycle$State0) {
        State lifecycle$State1 = this.mState;
        if(lifecycle$State1 == lifecycle$State0) {
            return;
        }
        if(lifecycle$State1 == State.INITIALIZED && lifecycle$State0 == State.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.mState);
        }
        this.mState = lifecycle$State0;
        if(!this.mHandlingEvent && this.mAddingObserverCounter == 0) {
            this.mHandlingEvent = true;
            this.sync();
            this.mHandlingEvent = false;
            if(this.mState == State.DESTROYED) {
                this.mObserverMap = new FastSafeIterableMap();
            }
            return;
        }
        this.mNewEventOccurred = true;
    }

    private void popParentState() {
        this.mParentStates.remove(this.mParentStates.size() - 1);
    }

    private void pushParentState(State lifecycle$State0) {
        this.mParentStates.add(lifecycle$State0);
    }

    @Override  // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver lifecycleObserver0) {
        this.enforceMainThreadIfNeeded("removeObserver");
        this.mObserverMap.remove(lifecycleObserver0);
    }

    public void setCurrentState(State lifecycle$State0) {
        this.enforceMainThreadIfNeeded("setCurrentState");
        this.moveToState(lifecycle$State0);
    }

    private void sync() {
        LifecycleOwner lifecycleOwner0 = (LifecycleOwner)this.mLifecycleOwner.get();
        if(lifecycleOwner0 == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while(!this.isSynced()) {
            this.mNewEventOccurred = false;
            if(this.mState.compareTo(((ObserverWithState)this.mObserverMap.eldest().getValue()).mState) < 0) {
                this.backwardPass(lifecycleOwner0);
            }
            Map.Entry map$Entry0 = this.mObserverMap.newest();
            if(!this.mNewEventOccurred && map$Entry0 != null && this.mState.compareTo(((ObserverWithState)map$Entry0.getValue()).mState) > 0) {
                this.forwardPass(lifecycleOwner0);
            }
        }
        this.mNewEventOccurred = false;
    }
}

