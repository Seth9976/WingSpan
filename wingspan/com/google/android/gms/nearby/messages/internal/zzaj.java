package com.google.android.gms.nearby.messages.internal;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

final class zzaj implements Application.ActivityLifecycleCallbacks {
    private final Activity zzhm;
    private final zzah zzhn;

    private zzaj(Activity activity0, zzah zzah0) {
        this.zzhm = activity0;
        this.zzhn = zzah0;
    }

    zzaj(Activity activity0, zzah zzah0, zzai zzai0) {
        this(activity0, zzah0);
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity0, Bundle bundle0) {
    }

    @Override  // android.app.Application$ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity0) {
        if(activity0 == this.zzhm) {
            if(Log.isLoggable("NearbyMessagesClient", 2)) {
                Log.v("NearbyMessagesClient", "Unregistering ClientLifecycleSafetyNet\'s ActivityLifecycleCallbacks for com.MonsterCouch.Wingspan");
            }
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
            try {
                this.zzhn.zzf(1);
            }
            catch(RemoteException remoteException0) {
                if(Log.isLoggable("NearbyMessagesClient", 2)) {
                    Log.v("NearbyMessagesClient", String.format("Failed to emit ACTIVITY_STOPPED from ClientLifecycleSafetyNet for Activity %s: %s", "com.MonsterCouch.Wingspan", remoteException0));
                }
            }
        }
    }
}

