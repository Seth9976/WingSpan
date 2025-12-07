package androidx.work.multiprocess;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IWorkManagerImpl extends IInterface {
    public static class Default implements IWorkManagerImpl {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelAllWork(IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelAllWorkByTag(String tag, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelUniqueWork(String name, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImpl
        public void cancelWorkById(String id, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImpl
        public void enqueueContinuation(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImpl
        public void enqueueWorkRequests(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImpl
        public void queryWorkInfo(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImpl
        public void setForegroundAsync(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImpl
        public void setProgress(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }

        @Override  // androidx.work.multiprocess.IWorkManagerImpl
        public void updateUniquePeriodicWorkRequest(String name, byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IWorkManagerImpl {
        static class Proxy implements IWorkManagerImpl {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelAllWork(IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(7, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelAllWorkByTag(String tag, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
                    parcel0.writeString(tag);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelUniqueWork(String name, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
                    parcel0.writeString(name);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(6, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImpl
            public void cancelWorkById(String id, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
                    parcel0.writeString(id);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImpl
            public void enqueueContinuation(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
                    parcel0.writeByteArray(request);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImpl
            public void enqueueWorkRequests(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
                    parcel0.writeByteArray(request);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "androidx.work.multiprocess.IWorkManagerImpl";
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImpl
            public void queryWorkInfo(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
                    parcel0.writeByteArray(request);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(8, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImpl
            public void setForegroundAsync(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
                    parcel0.writeByteArray(request);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(10, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImpl
            public void setProgress(byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
                    parcel0.writeByteArray(request);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(9, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // androidx.work.multiprocess.IWorkManagerImpl
            public void updateUniquePeriodicWorkRequest(String name, byte[] request, IWorkManagerImplCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.work.multiprocess.IWorkManagerImpl");
                    parcel0.writeString(name);
                    parcel0.writeByteArray(request);
                    parcel0.writeStrongInterface(callback);
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        static final int TRANSACTION_cancelAllWork = 7;
        static final int TRANSACTION_cancelAllWorkByTag = 5;
        static final int TRANSACTION_cancelUniqueWork = 6;
        static final int TRANSACTION_cancelWorkById = 4;
        static final int TRANSACTION_enqueueContinuation = 3;
        static final int TRANSACTION_enqueueWorkRequests = 1;
        static final int TRANSACTION_queryWorkInfo = 8;
        static final int TRANSACTION_setForegroundAsync = 10;
        static final int TRANSACTION_setProgress = 9;
        static final int TRANSACTION_updateUniquePeriodicWorkRequest = 2;

        public Stub() {
            this.attachInterface(this, "androidx.work.multiprocess.IWorkManagerImpl");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IWorkManagerImpl asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("androidx.work.multiprocess.IWorkManagerImpl");
            return iInterface0 != null && iInterface0 instanceof IWorkManagerImpl ? ((IWorkManagerImpl)iInterface0) : new Proxy(obj);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code >= 1 && code <= 0xFFFFFF) {
                data.enforceInterface("androidx.work.multiprocess.IWorkManagerImpl");
            }
            if(code != 0x5F4E5446) {
                switch(code) {
                    case 1: {
                        this.enqueueWorkRequests(data.createByteArray(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    }
                    case 2: {
                        this.updateUniquePeriodicWorkRequest(data.readString(), data.createByteArray(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    }
                    case 3: {
                        this.enqueueContinuation(data.createByteArray(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    }
                    case 4: {
                        this.cancelWorkById(data.readString(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    }
                    case 5: {
                        this.cancelAllWorkByTag(data.readString(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    }
                    case 6: {
                        this.cancelUniqueWork(data.readString(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    }
                    case 7: {
                        this.cancelAllWork(androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    }
                    case 8: {
                        this.queryWorkInfo(data.createByteArray(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    }
                    case 9: {
                        this.setProgress(data.createByteArray(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    }
                    case 10: {
                        this.setForegroundAsync(data.createByteArray(), androidx.work.multiprocess.IWorkManagerImplCallback.Stub.asInterface(data.readStrongBinder()));
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("androidx.work.multiprocess.IWorkManagerImpl");
            return true;
        }
    }

    public static final String DESCRIPTOR = "androidx.work.multiprocess.IWorkManagerImpl";

    void cancelAllWork(IWorkManagerImplCallback arg1) throws RemoteException;

    void cancelAllWorkByTag(String arg1, IWorkManagerImplCallback arg2) throws RemoteException;

    void cancelUniqueWork(String arg1, IWorkManagerImplCallback arg2) throws RemoteException;

    void cancelWorkById(String arg1, IWorkManagerImplCallback arg2) throws RemoteException;

    void enqueueContinuation(byte[] arg1, IWorkManagerImplCallback arg2) throws RemoteException;

    void enqueueWorkRequests(byte[] arg1, IWorkManagerImplCallback arg2) throws RemoteException;

    void queryWorkInfo(byte[] arg1, IWorkManagerImplCallback arg2) throws RemoteException;

    void setForegroundAsync(byte[] arg1, IWorkManagerImplCallback arg2) throws RemoteException;

    void setProgress(byte[] arg1, IWorkManagerImplCallback arg2) throws RemoteException;

    void updateUniquePeriodicWorkRequest(String arg1, byte[] arg2, IWorkManagerImplCallback arg3) throws RemoteException;
}

