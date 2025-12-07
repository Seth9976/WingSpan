package androidx.browser.customtabs;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.customtabs.ICustomTabsCallback;
import android.support.customtabs.IPostMessageService.Stub;

public class PostMessageService extends Service {
    private Stub mBinder;

    public PostMessageService() {
        this.mBinder = new Stub() {
            @Override  // android.support.customtabs.IPostMessageService
            public void onMessageChannelReady(ICustomTabsCallback callback, Bundle extras) throws RemoteException {
                callback.onMessageChannelReady(extras);
            }

            @Override  // android.support.customtabs.IPostMessageService
            public void onPostMessage(ICustomTabsCallback callback, String message, Bundle extras) throws RemoteException {
                callback.onPostMessage(message, extras);
            }
        };
    }

    @Override  // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}

