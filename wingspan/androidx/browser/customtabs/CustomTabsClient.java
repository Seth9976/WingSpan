package androidx.browser.customtabs;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback.Stub;
import android.support.customtabs.ICustomTabsService;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class CustomTabsClient {
    private static final String TAG = "CustomTabsClient";
    private final Context mApplicationContext;
    private final ICustomTabsService mService;
    private final ComponentName mServiceComponentName;

    CustomTabsClient(ICustomTabsService service, ComponentName componentName, Context applicationContext) {
        this.mService = service;
        this.mServiceComponentName = componentName;
        this.mApplicationContext = applicationContext;
    }

    public CustomTabsSession attachSession(PendingSession session) {
        return this.newSessionInternal(session.getCallback(), session.getId());
    }

    public static boolean bindCustomTabsService(Context context, String packageName, CustomTabsServiceConnection connection) {
        connection.setApplicationContext(context.getApplicationContext());
        Intent intent0 = new Intent("android.support.customtabs.action.CustomTabsService");
        if(!TextUtils.isEmpty(packageName)) {
            intent0.setPackage(packageName);
        }
        return context.bindService(intent0, connection, 33);
    }

    public static boolean bindCustomTabsServicePreservePriority(Context context, String packageName, CustomTabsServiceConnection connection) {
        connection.setApplicationContext(context.getApplicationContext());
        Intent intent0 = new Intent("android.support.customtabs.action.CustomTabsService");
        if(!TextUtils.isEmpty(packageName)) {
            intent0.setPackage(packageName);
        }
        return context.bindService(intent0, connection, 1);
    }

    public static boolean connectAndInitialize(Context context, String packageName) {
        if(packageName == null) {
            return false;
        }
        Context context1 = context.getApplicationContext();
        androidx.browser.customtabs.CustomTabsClient.1 customTabsClient$10 = new CustomTabsServiceConnection() {
            @Override  // androidx.browser.customtabs.CustomTabsServiceConnection
            public final void onCustomTabsServiceConnected(ComponentName name, CustomTabsClient client) {
                client.warmup(0L);
                context1.unbindService(this);
            }

            @Override  // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        };
        try {
            return CustomTabsClient.bindCustomTabsService(context1, packageName, customTabsClient$10);
        }
        catch(SecurityException unused_ex) {
            return false;
        }
    }

    private Stub createCallbackWrapper(CustomTabsCallback callback) {
        return new Stub() {
            private Handler mHandler;

            {
                CustomTabsCallback val$callback = callback;  // 捕获的参数 （可能与外部方法变量命名冲突；考虑手动重命名）
                this.mHandler = new Handler(Looper.getMainLooper());
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void extraCallback(String callbackName, Bundle args) throws RemoteException {
                if(callback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        androidx.browser.customtabs.CustomTabsClient.2.this.val$callback.extraCallback(callbackName, args);
                    }
                });
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public Bundle extraCallbackWithResult(String callbackName, Bundle args) throws RemoteException {
                return callback == null ? null : callback.extraCallbackWithResult(callbackName, args);
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onMessageChannelReady(Bundle extras) throws RemoteException {
                if(callback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        androidx.browser.customtabs.CustomTabsClient.2.this.val$callback.onMessageChannelReady(extras);
                    }
                });
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onNavigationEvent(int navigationEvent, Bundle extras) {
                if(callback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        androidx.browser.customtabs.CustomTabsClient.2.this.val$callback.onNavigationEvent(navigationEvent, extras);
                    }
                });
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onPostMessage(String message, Bundle extras) throws RemoteException {
                if(callback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        androidx.browser.customtabs.CustomTabsClient.2.this.val$callback.onPostMessage(message, extras);
                    }
                });
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onRelationshipValidationResult(int relation, Uri requestedOrigin, boolean result, Bundle extras) throws RemoteException {
                if(callback == null) {
                    return;
                }
                this.mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        androidx.browser.customtabs.CustomTabsClient.2.this.val$callback.onRelationshipValidationResult(relation, requestedOrigin, result, extras);
                    }
                });
            }
        };
    }

    private static PendingIntent createSessionId(Context context, int sessionId) {
        return PendingIntent.getActivity(context, sessionId, new Intent(), 0);
    }

    public Bundle extraCommand(String commandName, Bundle args) {
        try {
            return this.mService.extraCommand(commandName, args);
        }
        catch(RemoteException unused_ex) {
            return null;
        }
    }

    public static String getPackageName(Context context, List packages) {
        return CustomTabsClient.getPackageName(context, packages, false);
    }

    public static String getPackageName(Context context, List packages, boolean ignoreDefault) {
        PackageManager packageManager0 = context.getPackageManager();
        List list1 = packages == null ? new ArrayList() : packages;
        Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse("http://"));
        if(!ignoreDefault) {
            ResolveInfo resolveInfo0 = packageManager0.resolveActivity(intent0, 0);
            if(resolveInfo0 != null) {
                String s = resolveInfo0.activityInfo.packageName;
                ArrayList arrayList0 = new ArrayList(list1.size() + 1);
                arrayList0.add(s);
                if(packages != null) {
                    arrayList0.addAll(packages);
                }
                list1 = arrayList0;
            }
        }
        Intent intent1 = new Intent("android.support.customtabs.action.CustomTabsService");
        for(Object object0: list1) {
            String s1 = (String)object0;
            intent1.setPackage(s1);
            if(packageManager0.resolveService(intent1, 0) != null) {
                return s1;
            }
            if(false) {
                break;
            }
        }
        if(Build.VERSION.SDK_INT >= 30) {
            Log.w("CustomTabsClient", "Unable to find any Custom Tabs packages, you may need to add a <queries> element to your manifest. See the docs for CustomTabsClient#getPackageName.");
        }
        return null;
    }

    public static PendingSession newPendingSession(Context context, CustomTabsCallback callback, int id) {
        return new PendingSession(callback, CustomTabsClient.createSessionId(context, id));
    }

    public CustomTabsSession newSession(CustomTabsCallback callback) {
        return this.newSessionInternal(callback, null);
    }

    public CustomTabsSession newSession(CustomTabsCallback callback, int id) {
        return this.newSessionInternal(callback, CustomTabsClient.createSessionId(this.mApplicationContext, id));
    }

    private CustomTabsSession newSessionInternal(CustomTabsCallback callback, PendingIntent sessionId) {
        Stub iCustomTabsCallback$Stub0 = this.createCallbackWrapper(callback);
        try {
            if(sessionId != null) {
                Bundle bundle0 = new Bundle();
                bundle0.putParcelable("android.support.customtabs.extra.SESSION_ID", sessionId);
                return this.mService.newSessionWithExtras(iCustomTabsCallback$Stub0, bundle0) ? new CustomTabsSession(this.mService, iCustomTabsCallback$Stub0, this.mServiceComponentName, sessionId) : null;
            }
            return this.mService.newSession(iCustomTabsCallback$Stub0) ? new CustomTabsSession(this.mService, iCustomTabsCallback$Stub0, this.mServiceComponentName, null) : null;
        }
        catch(RemoteException unused_ex) {
            return null;
        }
    }

    public boolean warmup(long flags) {
        try {
            return this.mService.warmup(flags);
        }
        catch(RemoteException unused_ex) {
            return false;
        }
    }
}

