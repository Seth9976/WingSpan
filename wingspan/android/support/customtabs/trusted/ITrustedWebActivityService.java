package android.support.customtabs.trusted;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITrustedWebActivityService extends IInterface {
    public static class Default implements ITrustedWebActivityService {
        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle areNotificationsEnabled(Bundle args) throws RemoteException {
            return null;
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public void cancelNotification(Bundle args) throws RemoteException {
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle extraCommand(String commandName, Bundle args, IBinder callback) throws RemoteException {
            return null;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle getActiveNotifications() throws RemoteException {
            return null;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle getSmallIconBitmap() throws RemoteException {
            return null;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public int getSmallIconId() throws RemoteException {
            return 0;
        }

        @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
        public Bundle notifyNotificationWithChannel(Bundle args) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements ITrustedWebActivityService {
        static class Proxy implements ITrustedWebActivityService {
            private IBinder mRemote;
            public static ITrustedWebActivityService sDefaultImpl;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle areNotificationsEnabled(Bundle args) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if(args == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        args.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(6, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().areNotificationsEnabled(args);
                    }
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public void cancelNotification(Bundle args) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if(args == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        args.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(3, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().cancelNotification(args);
                        return;
                    }
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle extraCommand(String commandName, Bundle args, IBinder callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    parcel0.writeString(commandName);
                    if(args == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        args.writeToParcel(parcel0, 0);
                    }
                    parcel0.writeStrongBinder(callback);
                    if(!this.mRemote.transact(9, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().extraCommand(commandName, args, callback);
                    }
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle getActiveNotifications() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if(!this.mRemote.transact(5, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getActiveNotifications();
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
                return "android.support.customtabs.trusted.ITrustedWebActivityService";
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle getSmallIconBitmap() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if(!this.mRemote.transact(7, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSmallIconBitmap();
                    }
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public int getSmallIconId() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if(!this.mRemote.transact(4, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSmallIconId();
                    }
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.trusted.ITrustedWebActivityService
            public Bundle notifyNotificationWithChannel(Bundle args) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if(args == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        args.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(2, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().notifyNotificationWithChannel(args);
                    }
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.support.customtabs.trusted.ITrustedWebActivityService";
        static final int TRANSACTION_areNotificationsEnabled = 6;
        static final int TRANSACTION_cancelNotification = 3;
        static final int TRANSACTION_extraCommand = 9;
        static final int TRANSACTION_getActiveNotifications = 5;
        static final int TRANSACTION_getSmallIconBitmap = 7;
        static final int TRANSACTION_getSmallIconId = 4;
        static final int TRANSACTION_notifyNotificationWithChannel = 2;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.trusted.ITrustedWebActivityService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ITrustedWebActivityService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
            return iInterface0 != null && iInterface0 instanceof ITrustedWebActivityService ? ((ITrustedWebActivityService)iInterface0) : new Proxy(obj);
        }

        public static ITrustedWebActivityService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            Bundle bundle0 = null;
            switch(code) {
                case 2: {
                    data.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if(data.readInt() != 0) {
                        bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                    }
                    Bundle bundle1 = this.notifyNotificationWithChannel(bundle0);
                    reply.writeNoException();
                    if(bundle1 != null) {
                        reply.writeInt(1);
                        bundle1.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 3: {
                    data.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if(data.readInt() != 0) {
                        bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                    }
                    this.cancelNotification(bundle0);
                    reply.writeNoException();
                    return true;
                }
                case 4: {
                    data.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    int v2 = this.getSmallIconId();
                    reply.writeNoException();
                    reply.writeInt(v2);
                    return true;
                }
                case 5: {
                    data.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    Bundle bundle2 = this.getActiveNotifications();
                    reply.writeNoException();
                    if(bundle2 != null) {
                        reply.writeInt(1);
                        bundle2.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 6: {
                    data.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    if(data.readInt() != 0) {
                        bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                    }
                    Bundle bundle3 = this.areNotificationsEnabled(bundle0);
                    reply.writeNoException();
                    if(bundle3 != null) {
                        reply.writeInt(1);
                        bundle3.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 7: {
                    data.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    Bundle bundle4 = this.getSmallIconBitmap();
                    reply.writeNoException();
                    if(bundle4 != null) {
                        reply.writeInt(1);
                        bundle4.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 9: {
                    data.enforceInterface("android.support.customtabs.trusted.ITrustedWebActivityService");
                    String s = data.readString();
                    if(data.readInt() != 0) {
                        bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                    }
                    Bundle bundle5 = this.extraCommand(s, bundle0, data.readStrongBinder());
                    reply.writeNoException();
                    if(bundle5 != null) {
                        reply.writeInt(1);
                        bundle5.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                }
                case 0x5F4E5446: {
                    reply.writeString("android.support.customtabs.trusted.ITrustedWebActivityService");
                    return true;
                }
                default: {
                    return super.onTransact(code, data, reply, flags);
                }
            }
        }

        public static boolean setDefaultImpl(ITrustedWebActivityService impl) {
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

    Bundle areNotificationsEnabled(Bundle arg1) throws RemoteException;

    void cancelNotification(Bundle arg1) throws RemoteException;

    Bundle extraCommand(String arg1, Bundle arg2, IBinder arg3) throws RemoteException;

    Bundle getActiveNotifications() throws RemoteException;

    Bundle getSmallIconBitmap() throws RemoteException;

    int getSmallIconId() throws RemoteException;

    Bundle notifyNotificationWithChannel(Bundle arg1) throws RemoteException;
}

