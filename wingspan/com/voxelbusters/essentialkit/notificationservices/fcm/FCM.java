package com.voxelbusters.essentialkit.notificationservices.fcm;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.voxelbusters.essentialkit.notificationservices.INotificationServices.IRegisterRemoteNotificationsListener;
import com.voxelbusters.essentialkit.notificationservices.INotificationServices.IUnregisterRemoteNotificationServiceListener;
import com.voxelbusters.essentialkit.utilities.ApplicationUtil;
import com.voxelbusters.essentialkit.utilities.Logger;

public class FCM {
    private final String TAG;
    public String cachedToken;
    private Context context;
    public FirebaseMessaging service;

    public FCM(Context context0) {
        this.TAG = "[Native Plugins : FCM]";
        this.context = context0;
        try {
            FirebaseMessaging.getInstance().setAutoInitEnabled(false);
        }
        catch(Exception unused_ex) {
            Logger.error("Error when initialising Firebase cloud messaging. This can be due to not having proper google-service.json file");
        }
    }

    public void Unregister(IUnregisterRemoteNotificationServiceListener iNotificationServices$IUnregisterRemoteNotificationServiceListener0) {
        if(this.service != null) {
            this.unRegisterInBackground(iNotificationServices$IUnregisterRemoteNotificationServiceListener0);
        }
    }

    private void fetchToken(IRegisterRemoteNotificationsListener iNotificationServices$IRegisterRemoteNotificationsListener0) {
        public final class a implements OnCompleteListener {
            public final IRegisterRemoteNotificationsListener a;
            public final FCM b;

            public a(IRegisterRemoteNotificationsListener iNotificationServices$IRegisterRemoteNotificationsListener0) {
                this.a = iNotificationServices$IRegisterRemoteNotificationsListener0;
                super();
            }

            @Override  // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task0) {
                if(!task0.isSuccessful()) {
                    Logger.error(("getInstanceId failed : " + task0.getException()));
                    IRegisterRemoteNotificationsListener iNotificationServices$IRegisterRemoteNotificationsListener0 = this.a;
                    if(iNotificationServices$IRegisterRemoteNotificationsListener0 != null) {
                        iNotificationServices$IRegisterRemoteNotificationsListener0.onFailure(task0.getException().getMessage());
                    }
                    return;
                }
                String s = (String)task0.getResult();
                FCM.this.cachedToken = s;
                Logger.debug(("Token : " + s));
                IRegisterRemoteNotificationsListener iNotificationServices$IRegisterRemoteNotificationsListener1 = this.a;
                if(iNotificationServices$IRegisterRemoteNotificationsListener1 != null) {
                    iNotificationServices$IRegisterRemoteNotificationsListener1.onSuccess(s);
                }
            }
        }

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new a(this, iNotificationServices$IRegisterRemoteNotificationsListener0));
    }

    public boolean isAvailable() {
        return ApplicationUtil.isGooglePlayServicesAvailable(this.context);
    }

    public boolean isRegistered() {
        return this.cachedToken != null;
    }

    public void register(IRegisterRemoteNotificationsListener iNotificationServices$IRegisterRemoteNotificationsListener0) {
        this.service = FirebaseMessaging.getInstance();
        this.fetchToken(iNotificationServices$IRegisterRemoteNotificationsListener0);
    }

    private void unRegisterInBackground(IUnregisterRemoteNotificationServiceListener iNotificationServices$IUnregisterRemoteNotificationServiceListener0) {
        public final class b extends AsyncTask {
            public final IUnregisterRemoteNotificationServiceListener a;
            public final FCM b;

            public b(IUnregisterRemoteNotificationServiceListener iNotificationServices$IUnregisterRemoteNotificationServiceListener0) {
                this.a = iNotificationServices$IUnregisterRemoteNotificationServiceListener0;
                super();
            }

            @Override  // android.os.AsyncTask
            public final Object doInBackground(Object[] arr_object) {
                Void[] arr_void = (Void[])arr_object;
                FirebaseMessaging.getInstance().deleteToken();
                IUnregisterRemoteNotificationServiceListener iNotificationServices$IUnregisterRemoteNotificationServiceListener0 = this.a;
                if(iNotificationServices$IUnregisterRemoteNotificationServiceListener0 != null) {
                    iNotificationServices$IUnregisterRemoteNotificationServiceListener0.onSuccess();
                }
                FCM.this.cachedToken = null;
                return "SUCCESS";
            }
        }

        new b(this, iNotificationServices$IUnregisterRemoteNotificationServiceListener0).execute(new Void[]{null, null, null});
    }
}

