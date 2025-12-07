package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IUnusedAppRestrictionsBackportCallback extends IInterface {
    public static class Default implements IUnusedAppRestrictionsBackportCallback {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
        public void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z1) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {
        static class Proxy implements IUnusedAppRestrictionsBackportCallback {
            private IBinder mRemote;
            public static IUnusedAppRestrictionsBackportCallback sDefaultImpl;

            Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback";
            }

            @Override  // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z1) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
                    int v1 = 0;
                    parcel0.writeInt((z ? 1 : 0));
                    if(z1) {
                        v1 = 1;
                    }
                    parcel0.writeInt(v1);
                    if(!this.mRemote.transact(1, parcel0, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onIsPermissionRevocationEnabledForAppResult(z, z1);
                    }
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback";
        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;

        public Stub() {
            this.attachInterface(this, "androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IUnusedAppRestrictionsBackportCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
            return iInterface0 != null && iInterface0 instanceof IUnusedAppRestrictionsBackportCallback ? ((IUnusedAppRestrictionsBackportCallback)iInterface0) : new Proxy(iBinder0);
        }

        public static IUnusedAppRestrictionsBackportCallback getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
            switch(v) {
                case 1: {
                    parcel0.enforceInterface("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
                    boolean z = false;
                    boolean z1 = parcel0.readInt() != 0;
                    if(parcel0.readInt() != 0) {
                        z = true;
                    }
                    this.onIsPermissionRevocationEnabledForAppResult(z1, z);
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback");
                    return true;
                }
                default: {
                    return super.onTransact(v, parcel0, parcel1, v1);
                }
            }
        }

        public static boolean setDefaultImpl(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback0) {
            if(Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if(iUnusedAppRestrictionsBackportCallback0 != null) {
                Proxy.sDefaultImpl = iUnusedAppRestrictionsBackportCallback0;
                return true;
            }
            return false;
        }
    }

    void onIsPermissionRevocationEnabledForAppResult(boolean arg1, boolean arg2) throws RemoteException;
}

