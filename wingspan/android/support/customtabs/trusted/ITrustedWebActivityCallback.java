package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITrustedWebActivityCallback extends IInterface {
    public static class Default implements ITrustedWebActivityCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityCallback
        public void onExtraCallback(String callbackName, Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements ITrustedWebActivityCallback {
        static class Proxy implements ITrustedWebActivityCallback {
            private IBinder mRemote;
            public static ITrustedWebActivityCallback sDefaultImpl;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.support.customtabs.trusted.ITrustedWebActivityCallback";
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityCallback
            public void onExtraCallback(String callbackName, Bundle bundle) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityCallback");
                    parcel0.writeString(callbackName);
                    if(bundle == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(2, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onExtraCallback(callbackName, bundle);
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

        private static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityCallback";
        static final int TRANSACTION_onExtraCallback = 2;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.trusted.ITrustedWebActivityCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ITrustedWebActivityCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.support.customtabs.trusted.ITrustedWebActivityCallback");
            return iInterface0 != null && iInterface0 instanceof ITrustedWebActivityCallback ? ((ITrustedWebActivityCallback)iInterface0) : new Proxy(obj);
        }

        public static ITrustedWebActivityCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch(code) {
                case 2: {
                    data.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityCallback");
                    this.onExtraCallback(data.readString(), (data.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(data))));
                    reply.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.support.customtabs.trusted.ITrustedWebActivityCallback");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        public static boolean setDefaultImpl(ITrustedWebActivityCallback impl) {
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

    void onExtraCallback(String arg1, Bundle arg2) throws RemoteException;
}

