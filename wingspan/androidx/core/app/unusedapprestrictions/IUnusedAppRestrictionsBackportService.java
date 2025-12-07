package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUnusedAppRestrictionsBackportService extends IInterface {
    public static class Default implements IUnusedAppRestrictionsBackportService {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback0) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportService {
        static class Proxy implements IUnusedAppRestrictionsBackportService {
            private IBinder mRemote;
            public static IUnusedAppRestrictionsBackportService sDefaultImpl;

            Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService";
            }

            @Override  // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
            public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
                    parcel0.writeStrongBinder((iUnusedAppRestrictionsBackportCallback0 == null ? null : iUnusedAppRestrictionsBackportCallback0.asBinder()));
                    if(!this.mRemote.transact(1, parcel0, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().isPermissionRevocationEnabledForApp(iUnusedAppRestrictionsBackportCallback0);
                    }
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService";
        static final int TRANSACTION_isPermissionRevocationEnabledForApp = 1;

        public Stub() {
            this.attachInterface(this, "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IUnusedAppRestrictionsBackportService asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
            return iInterface0 != null && iInterface0 instanceof IUnusedAppRestrictionsBackportService ? ((IUnusedAppRestrictionsBackportService)iInterface0) : new Proxy(iBinder0);
        }

        public static IUnusedAppRestrictionsBackportService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
            switch(v) {
                case 1: {
                    parcel0.enforceInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
                    this.isPermissionRevocationEnabledForApp(androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback.Stub.asInterface(parcel0.readStrongBinder()));
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService");
                    return true;
                }
                default: {
                    return super.onTransact(v, parcel0, parcel1, v1);
                }
            }
        }

        public static boolean setDefaultImpl(IUnusedAppRestrictionsBackportService iUnusedAppRestrictionsBackportService0) {
            if(Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if(iUnusedAppRestrictionsBackportService0 != null) {
                Proxy.sDefaultImpl = iUnusedAppRestrictionsBackportService0;
                return true;
            }
            return false;
        }
    }

    void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback arg1) throws RemoteException;
}

