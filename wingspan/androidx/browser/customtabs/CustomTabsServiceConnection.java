package androidx.browser.customtabs;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.customtabs.ICustomTabsService.Stub;

public abstract class CustomTabsServiceConnection implements ServiceConnection {
    private Context mApplicationContext;

    Context getApplicationContext() {
        return this.mApplicationContext;
    }

    public abstract void onCustomTabsServiceConnected(ComponentName arg1, CustomTabsClient arg2);

    @Override  // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        if(this.mApplicationContext == null) {
            throw new IllegalStateException("Custom Tabs Service connected before an applicationcontext has been provided.");
        }
        this.onCustomTabsServiceConnected(name, new CustomTabsClient(Stub.asInterface(service), name, this.mApplicationContext) {
        });
    }

    void setApplicationContext(Context context) {
        this.mApplicationContext = context;
    }
}

