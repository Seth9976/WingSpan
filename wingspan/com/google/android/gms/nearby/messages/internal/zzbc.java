package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.Log;

final class zzbc implements Application.ActivityLifecycleCallbacks {
    private final Activity zzhm;
    private final zzak zzig;

    private zzbc(Activity activity0, zzak zzak0) {
        this.zzhm = activity0;
        this.zzig = zzak0;
    }

    zzbc(Activity activity0, zzak zzak0, zzau zzau0) {
        this(activity0, zzak0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity0, Bundle bundle0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity0) {
        if(activity0 == this.zzhm) {
            Log.v("NearbyMessages", "Unregistering ClientLifecycleSafetyNet\'s ActivityLifecycleCallbacks for com.MonsterCouch.Wingspan");
            activity0.getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity0, Bundle bundle0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity0) {
        if(activity0 == this.zzhm) {
            zzak.zza(this.zzig, 1);
        }
    }
}

