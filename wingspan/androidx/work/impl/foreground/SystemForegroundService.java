package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;

public class SystemForegroundService extends LifecycleService implements Callback {
    static class Api29Impl {
        static void startForeground(Service service, int id, Notification notification, int foregroundServiceType) {
            service.startForeground(id, notification, foregroundServiceType);
        }
    }

    static class Api31Impl {
        static void startForeground(Service service, int id, Notification notification, int foregroundServiceType) {
            try {
                service.startForeground(id, notification, foregroundServiceType);
            }
            catch(ForegroundServiceStartNotAllowedException foregroundServiceStartNotAllowedException0) {
                Logger.get().warning("WM-SystemFgService", "Unable to start foreground service", foregroundServiceStartNotAllowedException0);
            }
        }
    }

    private static final String TAG;
    SystemForegroundDispatcher mDispatcher;
    private Handler mHandler;
    private boolean mIsShutdown;
    NotificationManager mNotificationManager;
    private static SystemForegroundService sForegroundService;

    static {
        SystemForegroundService.TAG = "WM-SystemFgService";
        SystemForegroundService.sForegroundService = null;
    }

    // 去混淆评级： 低(20)
    static String access$000() [...] // 潜在的解密器

    @Override  // androidx.work.impl.foreground.SystemForegroundDispatcher$Callback
    public void cancelNotification(int notificationId) {
        this.mHandler.post(new Runnable() {
            @Override
            public void run() {
                SystemForegroundService.this.mNotificationManager.cancel(notificationId);
            }
        });
    }

    public static SystemForegroundService getInstance() {
        return SystemForegroundService.sForegroundService;
    }

    private void initializeDispatcher() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationManager = (NotificationManager)this.getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher0 = new SystemForegroundDispatcher(this.getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher0;
        systemForegroundDispatcher0.setCallback(this);
    }

    @Override  // androidx.work.impl.foreground.SystemForegroundDispatcher$Callback
    public void notify(int notificationId, Notification notification) {
        this.mHandler.post(new Runnable() {
            @Override
            public void run() {
                SystemForegroundService.this.mNotificationManager.notify(notificationId, notification);
            }
        });
    }

    @Override  // androidx.lifecycle.LifecycleService
    public void onCreate() {
        super.onCreate();
        SystemForegroundService.sForegroundService = this;
        this.initializeDispatcher();
    }

    @Override  // androidx.lifecycle.LifecycleService
    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    @Override  // androidx.lifecycle.LifecycleService
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if(this.mIsShutdown) {
            Logger.get().info("WM-SystemFgService", "Re-initializing SystemForegroundService after a request to shut-down.");
            this.mDispatcher.onDestroy();
            this.initializeDispatcher();
            this.mIsShutdown = false;
        }
        if(intent != null) {
            this.mDispatcher.onStartCommand(intent);
        }
        return 3;
    }

    @Override  // androidx.work.impl.foreground.SystemForegroundDispatcher$Callback
    public void startForeground(int notificationId, int notificationType, Notification notification) {
        this.mHandler.post(new Runnable() {
            @Override
            public void run() {
                if(Build.VERSION.SDK_INT >= 0x1F) {
                    Api31Impl.startForeground(SystemForegroundService.this, notificationId, notification, notificationType);
                    return;
                }
                if(Build.VERSION.SDK_INT >= 29) {
                    Api29Impl.startForeground(SystemForegroundService.this, notificationId, notification, notificationType);
                    return;
                }
                SystemForegroundService.this.startForeground(notificationId, notification);
            }
        });
    }

    @Override  // androidx.work.impl.foreground.SystemForegroundDispatcher$Callback
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug("WM-SystemFgService", "All commands completed.");
        if(Build.VERSION.SDK_INT >= 26) {
            this.stopForeground(true);
        }
        SystemForegroundService.sForegroundService = null;
        this.stopSelf();
    }
}

