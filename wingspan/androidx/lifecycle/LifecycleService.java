package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LifecycleService extends Service implements LifecycleOwner {
    private final ServiceLifecycleDispatcher mDispatcher;

    public LifecycleService() {
        this.mDispatcher = new ServiceLifecycleDispatcher(this);
    }

    @Override  // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mDispatcher.getLifecycle();
    }

    @Override  // android.app.Service
    public IBinder onBind(Intent intent0) {
        this.mDispatcher.onServicePreSuperOnBind();
        return null;
    }

    @Override  // android.app.Service
    public void onCreate() {
        this.mDispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @Override  // android.app.Service
    public void onDestroy() {
        this.mDispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @Override  // android.app.Service
    public void onStart(Intent intent0, int v) {
        this.mDispatcher.onServicePreSuperOnStart();
        super.onStart(intent0, v);
    }

    @Override  // android.app.Service
    public int onStartCommand(Intent intent0, int v, int v1) {
        return super.onStartCommand(intent0, v, v1);
    }
}

