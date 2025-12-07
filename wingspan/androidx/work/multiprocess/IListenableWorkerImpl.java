package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IListenableWorkerImpl extends IInterface {
    public static class Default implements IListenableWorkerImpl {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.work.multiprocess.IListenableWorkerImpl
        public void interrupt(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IListenableWorkerImpl
        public void startWork(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IListenableWorkerImpl {
        static class Proxy implements IListenableWorkerImpl {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.work.multiprocess.IListenableWorkerImpl";
            }

            @Override  // androidx.work.multiprocess.IListenableWorkerImpl
            public void interrupt(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IListenableWorkerImpl");
                    parcel0.writeByteArray(request);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.work.multiprocess.IListenableWorkerImpl
            public void startWork(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IListenableWorkerImpl");
                    parcel0.writeByteArray(request);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_interrupt = 2;
        static final int TRANSACTION_startWork = 1;

        public Stub() {
            this.attachInterface(this, "androidx.work.multiprocess.IListenableWorkerImpl");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IListenableWorkerImpl asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("androidx.work.multiprocess.IListenableWorkerImpl");
            return iInterface0 != null && iInterface0 instanceof IListenableWorkerImpl ? ((IListenableWorkerImpl)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code >= 1 && code <= 0xFFFFFF) {
                data.enforceInterface("androidx.work.multiprocess.IListenableWorkerImpl");
            }
            switch(code) {
                case 1: {
                    this.startWork(data.createByteArray(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("androidx.work.multiprocess.IListenableWorkerImpl");
                    return true;
                }
                default: {
                    if(code != 2) {
                        return super.onTransact(code, data, reply, flags);
                    }
                    this.interrupt(data.createByteArray(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                    return true;
                }
            }
        }
    }

    public static final String DESCRIPTOR = "androidx.work.multiprocess.IListenableWorkerImpl";

    void interrupt(byte[] arg1, IWorkManagerImplCallback arg2) throws RemoteException;

    void startWork(byte[] arg1, IWorkManagerImplCallback arg2) throws RemoteException;
}

