package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IWorkManagerImplCallback extends IInterface {
    public static class Default implements IWorkManagerImplCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImplCallback
        public void onFailure(String error) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImplCallback
        public void onSuccess(byte[] response) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImplCallback {
        static class Proxy implements IWorkManagerImplCallback {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.work.multiprocess.IWorkManagerImplCallback";
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImplCallback
            public void onFailure(String error) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImplCallback");
                    parcel0.writeString(error);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImplCallback
            public void onSuccess(byte[] response) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImplCallback");
                    parcel0.writeByteArray(response);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_onFailure = 2;
        static final int TRANSACTION_onSuccess = 1;

        public Stub() {
            this.attachInterface(this, "androidx.work.multiprocess.IWorkManagerImplCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IWorkManagerImplCallback asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("androidx.work.multiprocess.IWorkManagerImplCallback");
            return iInterface0 != null && iInterface0 instanceof IWorkManagerImplCallback ? ((IWorkManagerImplCallback)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code >= 1 && code <= 0xFFFFFF) {
                data.enforceInterface("androidx.work.multiprocess.IWorkManagerImplCallback");
            }
            switch(code) {
                case 1: {
                    this.onSuccess(data.createByteArray());
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("androidx.work.multiprocess.IWorkManagerImplCallback");
                    return true;
                }
                default: {
                    if(code != 2) {
                        return super.onTransact(code, data, reply, flags);
                    }
                    this.onFailure(data.readString());
                    return true;
                }
            }
        }
    }

    public static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImplCallback";

    void onFailure(String arg1) throws RemoteException;

    void onSuccess(byte[] arg1) throws RemoteException;
}

