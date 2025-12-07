package android.support.customtabs;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IPostMessageService extends IInterface {
    public static class Default implements IPostMessageService {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.IPostMessageService
        public void onMessageChannelReady(ICustomTabsCallback callback, Bundle extras) throws RemoteException {
        }

        @Override  // android.support.customtabs.IPostMessageService
        public void onPostMessage(ICustomTabsCallback callback, String message, Bundle extras) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IPostMessageService {
        static class Proxy implements IPostMessageService {
            private IBinder mRemote;
            public static IPostMessageService sDefaultImpl;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.IPostMessageService";
            }

            @Override  // android.support.customtabs.IPostMessageService
            public void onMessageChannelReady(ICustomTabsCallback callback, Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.IPostMessageService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(2, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onMessageChannelReady(callback, extras);
                        return;
                    }
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.IPostMessageService
            public void onPostMessage(ICustomTabsCallback callback, String message, Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.IPostMessageService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    parcel0.writeString(message);
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(3, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPostMessage(callback, message, extras);
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

        private static final String DESCRIPTOR = "android.support.customtabs.IPostMessageService";
        static final int TRANSACTION_onMessageChannelReady = 2;
        static final int TRANSACTION_onPostMessage = 3;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.IPostMessageService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IPostMessageService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.support.customtabs.IPostMessageService");
            return iInterface0 != null && iInterface0 instanceof IPostMessageService ? ((IPostMessageService)iInterface0) : new Proxy(obj);
        }

        public static IPostMessageService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Bundle bundle0 = null;
            switch(code) {
                case 2: {
                    data.enforceInterface("android.support.customtabs.IPostMessageService");
                    ICustomTabsCallback iCustomTabsCallback0 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                    if(data.readInt() != 0) {
                        bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                    }
                    this.onMessageChannelReady(iCustomTabsCallback0, bundle0);
                    reply.writeNoException();
                    return true;
                }
                case 3: {
                    data.enforceInterface("android.support.customtabs.IPostMessageService");
                    ICustomTabsCallback iCustomTabsCallback1 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                    String s = data.readString();
                    if(data.readInt() != 0) {
                        bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                    }
                    this.onPostMessage(iCustomTabsCallback1, s, bundle0);
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.support.customtabs.IPostMessageService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        public static boolean setDefaultImpl(IPostMessageService impl) {
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

    void onMessageChannelReady(ICustomTabsCallback arg1, Bundle arg2) throws RemoteException;

    void onPostMessage(ICustomTabsCallback arg1, String arg2, Bundle arg3) throws RemoteException;
}

