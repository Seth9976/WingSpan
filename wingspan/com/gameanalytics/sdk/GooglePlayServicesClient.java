package com.gameanalytics.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

public class GooglePlayServicesClient {
    static final class GooglePlayServicesConnection implements ServiceConnection {
        private final LinkedBlockingQueue queue;
        boolean retrieved;

        private GooglePlayServicesConnection() {
            this.retrieved = false;
            this.queue = new LinkedBlockingQueue(1);
        }

        GooglePlayServicesConnection(com.gameanalytics.sdk.GooglePlayServicesClient.1 googlePlayServicesClient$10) {
        }

        public IBinder getBinder() throws InterruptedException {
            if(this.retrieved) {
                throw new IllegalStateException();
            }
            this.retrieved = true;
            return (IBinder)this.queue.take();
        }

        @Override  // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            try {
                this.queue.put(service);
            }
            catch(InterruptedException unused_ex) {
            }
        }

        @Override  // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
        }
    }

    public static final class GooglePlayServicesInfo {
        private final String gpsAdid;
        private final Boolean limitAdTrackingEnabled;

        GooglePlayServicesInfo(String gpdAdid, Boolean limitAdTrackingEnabled) {
            this.gpsAdid = gpdAdid;
            this.limitAdTrackingEnabled = limitAdTrackingEnabled;
        }

        public String getGpsAdid() {
            return this.gpsAdid;
        }

        public Boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }
    }

    static final class GooglePlayServicesInterface implements IInterface {
        private IBinder binder;

        public GooglePlayServicesInterface(IBinder pBinder) {
            this.binder = pBinder;
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this.binder;
        }

        public String getGpsAdid() throws RemoteException {
            Parcel parcel0 = Parcel.obtain();
            Parcel parcel1 = Parcel.obtain();
            try {
                parcel0.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, parcel0, parcel1, 0);
                parcel1.readException();
                return parcel1.readString();
            }
            finally {
                parcel1.recycle();
                parcel0.recycle();
            }
        }

        public Boolean getTrackingEnabled(boolean paramBoolean) throws RemoteException {
            Parcel parcel0 = Parcel.obtain();
            Parcel parcel1 = Parcel.obtain();
            try {
                parcel0.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z1 = true;
                parcel0.writeInt((paramBoolean ? 1 : 0));
                this.binder.transact(2, parcel0, parcel1, 0);
                parcel1.readException();
                if(parcel1.readInt() == 0) {
                    z1 = false;
                }
                Boolean boolean0 = Boolean.valueOf(z1);
                return boolean0 == null ? null : boolean0;
            }
            finally {
                parcel1.recycle();
                parcel0.recycle();
            }
        }
    }

    public static GooglePlayServicesInfo getGooglePlayServicesInfo(Context context) throws Exception {
        if(Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Google Play Services info can\'t be accessed from the main thread");
        }
        context.getPackageManager().getPackageInfo("com.android.vending", 0);
        GooglePlayServicesConnection googlePlayServicesClient$GooglePlayServicesConnection0 = new GooglePlayServicesConnection(null);
        Intent intent0 = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent0.setPackage("com.google.android.gms");
        if(context.bindService(intent0, googlePlayServicesClient$GooglePlayServicesConnection0, 1)) {
            try {
                GooglePlayServicesInterface googlePlayServicesClient$GooglePlayServicesInterface0 = new GooglePlayServicesInterface(googlePlayServicesClient$GooglePlayServicesConnection0.getBinder());
                return new GooglePlayServicesInfo(googlePlayServicesClient$GooglePlayServicesInterface0.getGpsAdid(), googlePlayServicesClient$GooglePlayServicesInterface0.getTrackingEnabled(true));
            }
            finally {
                context.unbindService(googlePlayServicesClient$GooglePlayServicesConnection0);
            }
        }
        throw new IOException("Google Play connection failed");
    }

    class com.gameanalytics.sdk.GooglePlayServicesClient.1 {
    }

}

