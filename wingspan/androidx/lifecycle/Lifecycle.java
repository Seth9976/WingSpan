package androidx.lifecycle;

import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle {
    public static enum Event {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static Event downFrom(State lifecycle$State0) {
            switch(lifecycle$State0) {
                case 1: {
                    return Event.ON_DESTROY;
                }
                case 2: {
                    return Event.ON_STOP;
                }
                case 3: {
                    return Event.ON_PAUSE;
                }
                default: {
                    return null;
                }
            }
        }

        public static Event downTo(State lifecycle$State0) {
            switch(androidx.lifecycle.Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[lifecycle$State0.ordinal()]) {
                case 1: {
                    return Event.ON_STOP;
                }
                case 2: {
                    return Event.ON_PAUSE;
                }
                case 4: {
                    return Event.ON_DESTROY;
                }
                default: {
                    return null;
                }
            }
        }

        public State getTargetState() {
            switch(androidx.lifecycle.Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$Event[this.ordinal()]) {
                case 1: 
                case 2: {
                    return State.CREATED;
                }
                case 3: 
                case 4: {
                    return State.STARTED;
                }
                case 5: {
                    return State.RESUMED;
                }
                case 6: {
                    return State.DESTROYED;
                }
                default: {
                    throw new IllegalArgumentException(this + " has no target state");
                }
            }
        }

        public static Event upFrom(State lifecycle$State0) {
            switch(androidx.lifecycle.Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[lifecycle$State0.ordinal()]) {
                case 1: {
                    return Event.ON_START;
                }
                case 2: {
                    return Event.ON_RESUME;
                }
                case 5: {
                    return Event.ON_CREATE;
                }
                default: {
                    return null;
                }
            }
        }

        public static Event upTo(State lifecycle$State0) {
            switch(androidx.lifecycle.Lifecycle.1.$SwitchMap$androidx$lifecycle$Lifecycle$State[lifecycle$State0.ordinal()]) {
                case 1: {
                    return Event.ON_CREATE;
                }
                case 2: {
                    return Event.ON_START;
                }
                case 3: {
                    return Event.ON_RESUME;
                }
                default: {
                    return null;
                }
            }
        }
    }

    public static enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(State lifecycle$State0) {
            return this.compareTo(lifecycle$State0) >= 0;
        }
    }

    AtomicReference mInternalScopeRef;

    public Lifecycle() {
        this.mInternalScopeRef = new AtomicReference();
    }

    public abstract void addObserver(LifecycleObserver arg1);

    public abstract State getCurrentState();

    public abstract void removeObserver(LifecycleObserver arg1);
}

