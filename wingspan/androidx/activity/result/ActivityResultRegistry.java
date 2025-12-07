package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class ActivityResultRegistry {
    static class CallbackAndContract {
        final ActivityResultCallback mCallback;
        final ActivityResultContract mContract;

        CallbackAndContract(ActivityResultCallback activityResultCallback0, ActivityResultContract activityResultContract0) {
            this.mCallback = activityResultCallback0;
            this.mContract = activityResultContract0;
        }
    }

    static class LifecycleContainer {
        final Lifecycle mLifecycle;
        private final ArrayList mObservers;

        LifecycleContainer(Lifecycle lifecycle0) {
            this.mLifecycle = lifecycle0;
            this.mObservers = new ArrayList();
        }

        void addObserver(LifecycleEventObserver lifecycleEventObserver0) {
            this.mLifecycle.addObserver(lifecycleEventObserver0);
            this.mObservers.add(lifecycleEventObserver0);
        }

        void clearObservers() {
            for(Object object0: this.mObservers) {
                this.mLifecycle.removeObserver(((LifecycleEventObserver)object0));
            }
            this.mObservers.clear();
        }
    }

    private static final int INITIAL_REQUEST_CODE_VALUE = 0x10000;
    private static final String KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS = "KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_PENDING_RESULTS = "KEY_COMPONENT_ACTIVITY_PENDING_RESULT";
    private static final String KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT = "KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS = "KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS";
    private static final String KEY_COMPONENT_ACTIVITY_REGISTERED_RCS = "KEY_COMPONENT_ACTIVITY_REGISTERED_RCS";
    private static final String LOG_TAG = "ActivityResultRegistry";
    final transient Map mKeyToCallback;
    private final Map mKeyToLifecycleContainers;
    final Map mKeyToRc;
    ArrayList mLaunchedKeys;
    final Map mParsedPendingResults;
    final Bundle mPendingResults;
    private Random mRandom;
    private final Map mRcToKey;

    public ActivityResultRegistry() {
        this.mRandom = new Random();
        this.mRcToKey = new HashMap();
        this.mKeyToRc = new HashMap();
        this.mKeyToLifecycleContainers = new HashMap();
        this.mLaunchedKeys = new ArrayList();
        this.mKeyToCallback = new HashMap();
        this.mParsedPendingResults = new HashMap();
        this.mPendingResults = new Bundle();
    }

    private void bindRcKey(int v, String s) {
        this.mRcToKey.put(v, s);
        this.mKeyToRc.put(s, v);
    }

    public final boolean dispatchResult(int v, int v1, Intent intent0) {
        String s = (String)this.mRcToKey.get(v);
        if(s == null) {
            return false;
        }
        this.doDispatch(s, v1, intent0, ((CallbackAndContract)this.mKeyToCallback.get(s)));
        return true;
    }

    public final boolean dispatchResult(int v, Object object0) {
        String s = (String)this.mRcToKey.get(v);
        if(s == null) {
            return false;
        }
        CallbackAndContract activityResultRegistry$CallbackAndContract0 = (CallbackAndContract)this.mKeyToCallback.get(s);
        if(activityResultRegistry$CallbackAndContract0 == null || activityResultRegistry$CallbackAndContract0.mCallback == null) {
            this.mPendingResults.remove(s);
            this.mParsedPendingResults.put(s, object0);
        }
        else {
            ActivityResultCallback activityResultCallback0 = activityResultRegistry$CallbackAndContract0.mCallback;
            if(this.mLaunchedKeys.remove(s)) {
                activityResultCallback0.onActivityResult(object0);
                return true;
            }
        }
        return true;
    }

    private void doDispatch(String s, int v, Intent intent0, CallbackAndContract activityResultRegistry$CallbackAndContract0) {
        if(activityResultRegistry$CallbackAndContract0 != null && activityResultRegistry$CallbackAndContract0.mCallback != null && this.mLaunchedKeys.contains(s)) {
            Object object0 = activityResultRegistry$CallbackAndContract0.mContract.parseResult(v, intent0);
            activityResultRegistry$CallbackAndContract0.mCallback.onActivityResult(object0);
            this.mLaunchedKeys.remove(s);
            return;
        }
        this.mParsedPendingResults.remove(s);
        ActivityResult activityResult0 = new ActivityResult(v, intent0);
        this.mPendingResults.putParcelable(s, activityResult0);
    }

    private int generateRandomNumber() {
        int v;
        for(v = this.mRandom.nextInt(0x7FFF0000); this.mRcToKey.containsKey(((int)(v + 0x10000))); v = this.mRandom.nextInt(0x7FFF0000)) {
        }
        return v + 0x10000;
    }

    public abstract void onLaunch(int arg1, ActivityResultContract arg2, Object arg3, ActivityOptionsCompat arg4);

    public final void onRestoreInstanceState(Bundle bundle0) {
        if(bundle0 == null) {
            return;
        }
        ArrayList arrayList0 = bundle0.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList arrayList1 = bundle0.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if(arrayList1 != null && arrayList0 != null) {
            this.mLaunchedKeys = bundle0.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            this.mRandom = (Random)bundle0.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
            Bundle bundle1 = bundle0.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            this.mPendingResults.putAll(bundle1);
            for(int v = 0; v < arrayList1.size(); ++v) {
                String s = (String)arrayList1.get(v);
                if(this.mKeyToRc.containsKey(s)) {
                    Integer integer0 = (Integer)this.mKeyToRc.remove(s);
                    if(!this.mPendingResults.containsKey(s)) {
                        this.mRcToKey.remove(integer0);
                    }
                }
                this.bindRcKey(((int)(((Integer)arrayList0.get(v)))), ((String)arrayList1.get(v)));
            }
        }
    }

    public final void onSaveInstanceState(Bundle bundle0) {
        bundle0.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList(this.mKeyToRc.values()));
        bundle0.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList(this.mKeyToRc.keySet()));
        bundle0.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList(this.mLaunchedKeys));
        bundle0.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", ((Bundle)this.mPendingResults.clone()));
        bundle0.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.mRandom);
    }

    public final ActivityResultLauncher register(String s, ActivityResultContract activityResultContract0, ActivityResultCallback activityResultCallback0) {
        this.registerKey(s);
        CallbackAndContract activityResultRegistry$CallbackAndContract0 = new CallbackAndContract(activityResultCallback0, activityResultContract0);
        this.mKeyToCallback.put(s, activityResultRegistry$CallbackAndContract0);
        if(this.mParsedPendingResults.containsKey(s)) {
            Object object0 = this.mParsedPendingResults.get(s);
            this.mParsedPendingResults.remove(s);
            activityResultCallback0.onActivityResult(object0);
        }
        ActivityResult activityResult0 = (ActivityResult)this.mPendingResults.getParcelable(s);
        if(activityResult0 != null) {
            this.mPendingResults.remove(s);
            activityResultCallback0.onActivityResult(activityResultContract0.parseResult(activityResult0.getResultCode(), activityResult0.getData()));
        }
        return new ActivityResultLauncher() {
            @Override  // androidx.activity.result.ActivityResultLauncher
            public ActivityResultContract getContract() {
                return activityResultContract0;
            }

            @Override  // androidx.activity.result.ActivityResultLauncher
            public void launch(Object object0, ActivityOptionsCompat activityOptionsCompat0) {
                Integer integer0 = (Integer)ActivityResultRegistry.this.mKeyToRc.get(s);
                if(integer0 != null) {
                    ActivityResultRegistry.this.mLaunchedKeys.add(s);
                    try {
                        ActivityResultRegistry.this.onLaunch(((int)integer0), activityResultContract0, object0, activityOptionsCompat0);
                        return;
                    }
                    catch(Exception exception0) {
                        ActivityResultRegistry.this.mLaunchedKeys.remove(s);
                        throw exception0;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract0 + " and input " + object0 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }

            @Override  // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                ActivityResultRegistry.this.unregister(s);
            }
        };
    }

    public final ActivityResultLauncher register(String s, LifecycleOwner lifecycleOwner0, ActivityResultContract activityResultContract0, ActivityResultCallback activityResultCallback0) {
        Lifecycle lifecycle0 = lifecycleOwner0.getLifecycle();
        if(lifecycle0.getCurrentState().isAtLeast(State.STARTED)) {
            throw new IllegalStateException("LifecycleOwner " + lifecycleOwner0 + " is attempting to register while current state is " + lifecycle0.getCurrentState() + ". LifecycleOwners must call register before they are STARTED.");
        }
        this.registerKey(s);
        LifecycleContainer activityResultRegistry$LifecycleContainer0 = (LifecycleContainer)this.mKeyToLifecycleContainers.get(s);
        if(activityResultRegistry$LifecycleContainer0 == null) {
            activityResultRegistry$LifecycleContainer0 = new LifecycleContainer(lifecycle0);
        }
        activityResultRegistry$LifecycleContainer0.addObserver(new LifecycleEventObserver() {
            @Override  // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner0, Event lifecycle$Event0) {
                if(Event.ON_START.equals(lifecycle$Event0)) {
                    CallbackAndContract activityResultRegistry$CallbackAndContract0 = new CallbackAndContract(activityResultCallback0, activityResultContract0);
                    ActivityResultRegistry.this.mKeyToCallback.put(s, activityResultRegistry$CallbackAndContract0);
                    if(ActivityResultRegistry.this.mParsedPendingResults.containsKey(s)) {
                        Object object0 = ActivityResultRegistry.this.mParsedPendingResults.get(s);
                        ActivityResultRegistry.this.mParsedPendingResults.remove(s);
                        activityResultCallback0.onActivityResult(object0);
                    }
                    ActivityResult activityResult0 = (ActivityResult)ActivityResultRegistry.this.mPendingResults.getParcelable(s);
                    if(activityResult0 != null) {
                        ActivityResultRegistry.this.mPendingResults.remove(s);
                        Object object1 = activityResultContract0.parseResult(activityResult0.getResultCode(), activityResult0.getData());
                        activityResultCallback0.onActivityResult(object1);
                    }
                }
                else {
                    if(Event.ON_STOP.equals(lifecycle$Event0)) {
                        ActivityResultRegistry.this.mKeyToCallback.remove(s);
                        return;
                    }
                    if(Event.ON_DESTROY.equals(lifecycle$Event0)) {
                        ActivityResultRegistry.this.unregister(s);
                    }
                }
            }
        });
        this.mKeyToLifecycleContainers.put(s, activityResultRegistry$LifecycleContainer0);
        return new ActivityResultLauncher() {
            @Override  // androidx.activity.result.ActivityResultLauncher
            public ActivityResultContract getContract() {
                return activityResultContract0;
            }

            @Override  // androidx.activity.result.ActivityResultLauncher
            public void launch(Object object0, ActivityOptionsCompat activityOptionsCompat0) {
                Integer integer0 = (Integer)ActivityResultRegistry.this.mKeyToRc.get(s);
                if(integer0 != null) {
                    ActivityResultRegistry.this.mLaunchedKeys.add(s);
                    try {
                        ActivityResultRegistry.this.onLaunch(((int)integer0), activityResultContract0, object0, activityOptionsCompat0);
                        return;
                    }
                    catch(Exception exception0) {
                        ActivityResultRegistry.this.mLaunchedKeys.remove(s);
                        throw exception0;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + activityResultContract0 + " and input " + object0 + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            }

            @Override  // androidx.activity.result.ActivityResultLauncher
            public void unregister() {
                ActivityResultRegistry.this.unregister(s);
            }
        };
    }

    private void registerKey(String s) {
        if(((Integer)this.mKeyToRc.get(s)) != null) {
            return;
        }
        this.bindRcKey(this.generateRandomNumber(), s);
    }

    final void unregister(String s) {
        if(!this.mLaunchedKeys.contains(s)) {
            Integer integer0 = (Integer)this.mKeyToRc.remove(s);
            if(integer0 != null) {
                this.mRcToKey.remove(integer0);
            }
        }
        this.mKeyToCallback.remove(s);
        if(this.mParsedPendingResults.containsKey(s)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + s + ": " + this.mParsedPendingResults.get(s));
            this.mParsedPendingResults.remove(s);
        }
        if(this.mPendingResults.containsKey(s)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + s + ": " + this.mPendingResults.getParcelable(s));
            this.mPendingResults.remove(s);
        }
        LifecycleContainer activityResultRegistry$LifecycleContainer0 = (LifecycleContainer)this.mKeyToLifecycleContainers.get(s);
        if(activityResultRegistry$LifecycleContainer0 != null) {
            activityResultRegistry$LifecycleContainer0.clearObservers();
            this.mKeyToLifecycleContainers.remove(s);
        }
    }
}

