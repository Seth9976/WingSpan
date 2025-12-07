package androidx.browser.trusted;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class TrustedWebActivityServiceConnectionPool {
    static class BindToServiceAsyncTask extends AsyncTask {
        private final Context mAppContext;
        private final ConnectionHolder mConnection;
        private final Intent mIntent;

        BindToServiceAsyncTask(Context context, Intent intent, ConnectionHolder connection) {
            this.mAppContext = context.getApplicationContext();
            this.mIntent = intent;
            this.mConnection = connection;
        }

        protected Exception doInBackground(Void[] voids) {
            try {
                if(this.mAppContext.bindService(this.mIntent, this.mConnection, 0x1001)) {
                    return null;
                }
                this.mAppContext.unbindService(this.mConnection);
                return new IllegalStateException("Could not bind to the service");
            }
            catch(SecurityException exception0) {
                Log.w("TWAConnectionPool", "SecurityException while binding.", exception0);
                return exception0;
            }
        }

        @Override  // android.os.AsyncTask
        protected Object doInBackground(Object[] voids) {
            return this.doInBackground(((Void[])voids));
        }

        protected void onPostExecute(Exception bindingException) {
            if(bindingException != null) {
                this.mConnection.cancel(bindingException);
            }
        }

        @Override  // android.os.AsyncTask
        protected void onPostExecute(Object bindingException) {
            this.onPostExecute(((Exception)bindingException));
        }
    }

    private static final String TAG = "TWAConnectionPool";
    private final Map mConnections;
    private final Context mContext;

    private TrustedWebActivityServiceConnectionPool(Context context) {
        this.mConnections = new HashMap();
        this.mContext = context.getApplicationContext();
    }

    public ListenableFuture connect(Uri scope, Set possiblePackages, Executor executor) {
        ConnectionHolder connectionHolder0 = (ConnectionHolder)this.mConnections.get(scope);
        if(connectionHolder0 != null) {
            return connectionHolder0.getServiceWrapper();
        }
        Intent intent0 = this.createServiceIntent(this.mContext, scope, possiblePackages, true);
        if(intent0 == null) {
            return FutureUtils.immediateFailedFuture(new IllegalArgumentException("No service exists for scope"));
        }
        ConnectionHolder connectionHolder1 = new ConnectionHolder(() -> this.mConnections.remove(scope));
        this.mConnections.put(scope, connectionHolder1);
        new BindToServiceAsyncTask(this.mContext, intent0, connectionHolder1).executeOnExecutor(executor, new Void[0]);
        return connectionHolder1.getServiceWrapper();
    }

    public static TrustedWebActivityServiceConnectionPool create(Context context) {
        return new TrustedWebActivityServiceConnectionPool(context);
    }

    private Intent createServiceIntent(Context appContext, Uri scope, Set possiblePackages, boolean shouldLog) {
        if(possiblePackages != null && possiblePackages.size() != 0) {
            Intent intent0 = new Intent();
            intent0.setData(scope);
            intent0.setAction("android.intent.action.VIEW");
            String s = null;
            Iterator iterator0 = appContext.getPackageManager().queryIntentActivities(intent0, 0x10000).iterator();
        label_6:
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                String s1 = ((ResolveInfo)object0).activityInfo.packageName;
                Iterator iterator1 = possiblePackages.iterator();
                do {
                    if(!iterator1.hasNext()) {
                        continue label_6;
                    }
                    Object object1 = iterator1.next();
                }
                while(!((Token)object1).matches(s1, appContext.getPackageManager()));
                s = s1;
            }
            if(s == null) {
                if(shouldLog) {
                    Log.w("TWAConnectionPool", "No TWA candidates for " + scope + " have been registered.");
                }
                return null;
            }
            Intent intent1 = new Intent();
            intent1.setPackage(s);
            intent1.setAction("android.support.customtabs.trusted.TRUSTED_WEB_ACTIVITY_SERVICE");
            ResolveInfo resolveInfo0 = appContext.getPackageManager().resolveService(intent1, 0x20000);
            if(resolveInfo0 == null) {
                if(shouldLog) {
                    Log.w("TWAConnectionPool", "Could not find TWAService for " + s);
                }
                return null;
            }
            if(shouldLog) {
                Log.i("TWAConnectionPool", "Found " + resolveInfo0.serviceInfo.name + " to handle request for " + scope);
            }
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(s, resolveInfo0.serviceInfo.name));
            return intent2;
        }
        return null;
    }

    // 检测为 Lambda 实现
    void lambda$connect$0$androidx-browser-trusted-TrustedWebActivityServiceConnectionPool(Uri uri0) [...]

    public boolean serviceExistsForScope(Uri scope, Set possiblePackages) {
        return this.mConnections.get(scope) == null ? this.createServiceIntent(this.mContext, scope, possiblePackages, false) != null : true;
    }

    void unbindAllConnections() {
        for(Object object0: this.mConnections.values()) {
            this.mContext.unbindService(((ConnectionHolder)object0));
        }
        this.mConnections.clear();
    }
}

