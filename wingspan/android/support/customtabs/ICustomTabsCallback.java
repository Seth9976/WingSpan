package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ICustomTabsCallback extends IInterface {
    public static class Default implements ICustomTabsCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void extraCallback(String callbackName, Bundle args) throws RemoteException {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public Bundle extraCallbackWithResult(String callbackName, Bundle args) throws RemoteException {
            return null;
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onMessageChannelReady(Bundle extras) throws RemoteException {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onNavigationEvent(int navigationEvent, Bundle extras) throws RemoteException {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onPostMessage(String message, Bundle extras) throws RemoteException {
        }

        @Override  // android.support.customtabs.ICustomTabsCallback
        public void onRelationshipValidationResult(int relation, Uri origin, boolean result, Bundle extras) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ICustomTabsCallback {
        static class Proxy implements ICustomTabsCallback {
            private IBinder mRemote;
            public static ICustomTabsCallback sDefaultImpl;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void extraCallback(String callbackName, Bundle args) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeString(callbackName);
                    if(args == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        args.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(3, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().extraCallback(callbackName, args);
                        return;
                    }
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public Bundle extraCallbackWithResult(String callbackName, Bundle args) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeString(callbackName);
                    if(args == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        args.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(7, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().extraCallbackWithResult(callbackName, args);
                    }
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.ICustomTabsCallback";
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onMessageChannelReady(Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(4, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMessageChannelReady(extras);
                        return;
                    }
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onNavigationEvent(int navigationEvent, Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeInt(navigationEvent);
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(2, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onNavigationEvent(navigationEvent, extras);
                        return;
                    }
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onPostMessage(String message, Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeString(message);
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(5, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPostMessage(message, extras);
                        return;
                    }
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsCallback
            public void onRelationshipValidationResult(int relation, Uri origin, boolean result, Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsCallback");
                    parcel0.writeInt(relation);
                    if(origin == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        origin.writeToParcel(parcel0, 0);
                    }
                    parcel0.writeInt((result ? 1 : 0));
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(6, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRelationshipValidationResult(relation, origin, result, extras);
                        return;
                    }
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsCallback";
        static final int TRANSACTION_extraCallback = 3;
        static final int TRANSACTION_extraCallbackWithResult = 7;
        static final int TRANSACTION_onMessageChannelReady = 4;
        static final int TRANSACTION_onNavigationEvent = 2;
        static final int TRANSACTION_onPostMessage = 5;
        static final int TRANSACTION_onRelationshipValidationResult = 6;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.ICustomTabsCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICustomTabsCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.support.customtabs.ICustomTabsCallback");
            return iInterface0 != null && iInterface0 instanceof ICustomTabsCallback ? ((ICustomTabsCallback)iInterface0) : new Proxy(obj);
        }

        public static ICustomTabsCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                boolean z = false;
                Bundle bundle0 = null;
                switch(code) {
                    case 2: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        int v2 = data.readInt();
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        this.onNavigationEvent(v2, bundle0);
                        reply.writeNoException();
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        String s = data.readString();
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        this.extraCallback(s, bundle0);
                        reply.writeNoException();
                        return true;
                    }
                    case 4: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        this.onMessageChannelReady(bundle0);
                        reply.writeNoException();
                        return true;
                    }
                    case 5: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        String s1 = data.readString();
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        this.onPostMessage(s1, bundle0);
                        reply.writeNoException();
                        return true;
                    }
                    case 6: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        int v3 = data.readInt();
                        Uri uri0 = data.readInt() == 0 ? null : ((Uri)Uri.CREATOR.createFromParcel(data));
                        if(data.readInt() != 0) {
                            z = true;
                        }
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        this.onRelationshipValidationResult(v3, uri0, z, bundle0);
                        reply.writeNoException();
                        return true;
                    }
                    case 7: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsCallback");
                        String s2 = data.readString();
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        Bundle bundle1 = this.extraCallbackWithResult(s2, bundle0);
                        reply.writeNoException();
                        if(bundle1 != null) {
                            reply.writeInt(1);
                            bundle1.writeToParcel(reply, 1);
                            return true;
                        }
                        reply.writeInt(0);
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.support.customtabs.ICustomTabsCallback");
            return true;
        }

        public static boolean setDefaultImpl(ICustomTabsCallback impl) {
            if(Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if(impl != null) {
                Proxy.sDefaultImpl = impl;
                return true;
            }
            return false;
        }
    }

    void extraCallback(String arg1, Bundle arg2) throws RemoteException;

    Bundle extraCallbackWithResult(String arg1, Bundle arg2) throws RemoteException;

    void onMessageChannelReady(Bundle arg1) throws RemoteException;

    void onNavigationEvent(int arg1, Bundle arg2) throws RemoteException;

    void onPostMessage(String arg1, Bundle arg2) throws RemoteException;

    void onRelationshipValidationResult(int arg1, Uri arg2, boolean arg3, Bundle arg4) throws RemoteException;
}

