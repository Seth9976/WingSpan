package android.support.customtabs;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface ICustomTabsService extends IInterface {
    public static class Default implements ICustomTabsService {
        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public Bundle extraCommand(String commandName, Bundle args) throws RemoteException {
            return null;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean mayLaunchUrl(ICustomTabsCallback callback, Uri url, Bundle extras, List otherLikelyBundles) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean newSession(ICustomTabsCallback callback) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean newSessionWithExtras(ICustomTabsCallback callback, Bundle extras) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public int postMessage(ICustomTabsCallback callback, String message, Bundle extras) throws RemoteException {
            return 0;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean receiveFile(ICustomTabsCallback callback, Uri uri, int purpose, Bundle extras) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannel(ICustomTabsCallback callback, Uri postMessageOrigin) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback callback, Uri postMessageOrigin, Bundle extras) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean updateVisuals(ICustomTabsCallback callback, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean validateRelationship(ICustomTabsCallback callback, int relation, Uri origin, Bundle extras) throws RemoteException {
            return false;
        }

        @Override  // android.support.customtabs.ICustomTabsService
        public boolean warmup(long flags) throws RemoteException {
            return false;
        }
    }

    public static abstract class Stub extends Binder implements ICustomTabsService {
        static class Proxy implements ICustomTabsService {
            private IBinder mRemote;
            public static ICustomTabsService sDefaultImpl;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public Bundle extraCommand(String commandName, Bundle args) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeString(commandName);
                    if(args == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        args.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(5, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().extraCommand(commandName, args);
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
                return "android.support.customtabs.ICustomTabsService";
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean mayLaunchUrl(ICustomTabsCallback callback, Uri url, Bundle extras, List otherLikelyBundles) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    boolean z = true;
                    if(url == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        url.writeToParcel(parcel0, 0);
                    }
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    parcel0.writeTypedList(otherLikelyBundles);
                    if(!this.mRemote.transact(4, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().mayLaunchUrl(callback, url, extras, otherLikelyBundles);
                    }
                    parcel1.readException();
                    if(parcel1.readInt() == 0) {
                        z = false;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean newSession(ICustomTabsCallback callback) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    boolean z = false;
                    if(!this.mRemote.transact(3, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newSession(callback);
                    }
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean newSessionWithExtras(ICustomTabsCallback callback, Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    boolean z = true;
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(10, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().newSessionWithExtras(callback, extras);
                    }
                    parcel1.readException();
                    if(parcel1.readInt() == 0) {
                        z = false;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public int postMessage(ICustomTabsCallback callback, String message, Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    parcel0.writeString(message);
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(8, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().postMessage(callback, message, extras);
                    }
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean receiveFile(ICustomTabsCallback callback, Uri uri, int purpose, Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    boolean z = true;
                    if(uri == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        uri.writeToParcel(parcel0, 0);
                    }
                    parcel0.writeInt(purpose);
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(12, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().receiveFile(callback, uri, purpose, extras);
                    }
                    parcel1.readException();
                    if(parcel1.readInt() == 0) {
                        z = false;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean requestPostMessageChannel(ICustomTabsCallback callback, Uri postMessageOrigin) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    boolean z = true;
                    if(postMessageOrigin == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        postMessageOrigin.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(7, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestPostMessageChannel(callback, postMessageOrigin);
                    }
                    parcel1.readException();
                    if(parcel1.readInt() == 0) {
                        z = false;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean requestPostMessageChannelWithExtras(ICustomTabsCallback callback, Uri postMessageOrigin, Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    boolean z = true;
                    if(postMessageOrigin == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        postMessageOrigin.writeToParcel(parcel0, 0);
                    }
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(11, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().requestPostMessageChannelWithExtras(callback, postMessageOrigin, extras);
                    }
                    parcel1.readException();
                    if(parcel1.readInt() == 0) {
                        z = false;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean updateVisuals(ICustomTabsCallback callback, Bundle bundle) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    boolean z = true;
                    if(bundle == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(6, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().updateVisuals(callback, bundle);
                    }
                    parcel1.readException();
                    if(parcel1.readInt() == 0) {
                        z = false;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean validateRelationship(ICustomTabsCallback callback, int relation, Uri origin, Bundle extras) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeStrongBinder((callback == null ? null : callback.asBinder()));
                    parcel0.writeInt(relation);
                    boolean z = true;
                    if(origin == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        origin.writeToParcel(parcel0, 0);
                    }
                    if(extras == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        extras.writeToParcel(parcel0, 0);
                    }
                    if(!this.mRemote.transact(9, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().validateRelationship(callback, relation, origin, extras);
                    }
                    parcel1.readException();
                    if(parcel1.readInt() == 0) {
                        z = false;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.customtabs.ICustomTabsService
            public boolean warmup(long flags) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.customtabs.ICustomTabsService");
                    parcel0.writeLong(flags);
                    boolean z = false;
                    if(!this.mRemote.transact(2, parcel0, parcel1, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().warmup(flags);
                    }
                    parcel1.readException();
                    if(parcel1.readInt() != 0) {
                        z = true;
                    }
                    return z;
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.support.customtabs.ICustomTabsService";
        static final int TRANSACTION_extraCommand = 5;
        static final int TRANSACTION_mayLaunchUrl = 4;
        static final int TRANSACTION_newSession = 3;
        static final int TRANSACTION_newSessionWithExtras = 10;
        static final int TRANSACTION_postMessage = 8;
        static final int TRANSACTION_receiveFile = 12;
        static final int TRANSACTION_requestPostMessageChannel = 7;
        static final int TRANSACTION_requestPostMessageChannelWithExtras = 11;
        static final int TRANSACTION_updateVisuals = 6;
        static final int TRANSACTION_validateRelationship = 9;
        static final int TRANSACTION_warmup = 2;

        public Stub() {
            this.attachInterface(this, "android.support.customtabs.ICustomTabsService");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static ICustomTabsService asInterface(IBinder obj) {
            if(obj == null) {
                return null;
            }
            IInterface iInterface0 = obj.queryLocalInterface("android.support.customtabs.ICustomTabsService");
            return iInterface0 != null && iInterface0 instanceof ICustomTabsService ? ((ICustomTabsService)iInterface0) : new Proxy(obj);
        }

        public static ICustomTabsService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        @Override  // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if(code != 0x5F4E5446) {
                Bundle bundle0 = null;
                switch(code) {
                    case 2: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        boolean z = this.warmup(data.readLong());
                        reply.writeNoException();
                        reply.writeInt(((int)z));
                        return true;
                    }
                    case 3: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        boolean z1 = this.newSession(android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder()));
                        reply.writeNoException();
                        reply.writeInt(((int)z1));
                        return true;
                    }
                    case 4: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback iCustomTabsCallback0 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                        Uri uri0 = data.readInt() == 0 ? null : ((Uri)Uri.CREATOR.createFromParcel(data));
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        boolean z2 = this.mayLaunchUrl(iCustomTabsCallback0, uri0, bundle0, data.createTypedArrayList(Bundle.CREATOR));
                        reply.writeNoException();
                        reply.writeInt(((int)z2));
                        return true;
                    }
                    case 5: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        String s = data.readString();
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        Bundle bundle1 = this.extraCommand(s, bundle0);
                        reply.writeNoException();
                        if(bundle1 != null) {
                            reply.writeInt(1);
                            bundle1.writeToParcel(reply, 1);
                            return true;
                        }
                        reply.writeInt(0);
                        return true;
                    }
                    case 6: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback iCustomTabsCallback1 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        boolean z3 = this.updateVisuals(iCustomTabsCallback1, bundle0);
                        reply.writeNoException();
                        reply.writeInt(((int)z3));
                        return true;
                    }
                    case 7: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback iCustomTabsCallback2 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                        if(data.readInt() != 0) {
                            bundle0 = (Uri)Uri.CREATOR.createFromParcel(data);
                        }
                        boolean z4 = this.requestPostMessageChannel(iCustomTabsCallback2, ((Uri)bundle0));
                        reply.writeNoException();
                        reply.writeInt(((int)z4));
                        return true;
                    }
                    case 8: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback iCustomTabsCallback3 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                        String s1 = data.readString();
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        int v2 = this.postMessage(iCustomTabsCallback3, s1, bundle0);
                        reply.writeNoException();
                        reply.writeInt(v2);
                        return true;
                    }
                    case 9: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback iCustomTabsCallback4 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                        int v3 = data.readInt();
                        Uri uri1 = data.readInt() == 0 ? null : ((Uri)Uri.CREATOR.createFromParcel(data));
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        boolean z5 = this.validateRelationship(iCustomTabsCallback4, v3, uri1, bundle0);
                        reply.writeNoException();
                        reply.writeInt(((int)z5));
                        return true;
                    }
                    case 10: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback iCustomTabsCallback5 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        boolean z6 = this.newSessionWithExtras(iCustomTabsCallback5, bundle0);
                        reply.writeNoException();
                        reply.writeInt(((int)z6));
                        return true;
                    }
                    case 11: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback iCustomTabsCallback6 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                        Uri uri2 = data.readInt() == 0 ? null : ((Uri)Uri.CREATOR.createFromParcel(data));
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        boolean z7 = this.requestPostMessageChannelWithExtras(iCustomTabsCallback6, uri2, bundle0);
                        reply.writeNoException();
                        reply.writeInt(((int)z7));
                        return true;
                    }
                    case 12: {
                        data.enforceInterface("android.support.customtabs.ICustomTabsService");
                        ICustomTabsCallback iCustomTabsCallback7 = android.support.customtabs.ICustomTabsCallback.Stub.asInterface(data.readStrongBinder());
                        Uri uri3 = data.readInt() == 0 ? null : ((Uri)Uri.CREATOR.createFromParcel(data));
                        int v4 = data.readInt();
                        if(data.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(data);
                        }
                        boolean z8 = this.receiveFile(iCustomTabsCallback7, uri3, v4, bundle0);
                        reply.writeNoException();
                        reply.writeInt(((int)z8));
                        return true;
                    }
                    default: {
                        return super.onTransact(code, data, reply, flags);
                    }
                }
            }
            reply.writeString("android.support.customtabs.ICustomTabsService");
            return true;
        }

        public static boolean setDefaultImpl(ICustomTabsService impl) {
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

    Bundle extraCommand(String arg1, Bundle arg2) throws RemoteException;

    boolean mayLaunchUrl(ICustomTabsCallback arg1, Uri arg2, Bundle arg3, List arg4) throws RemoteException;

    boolean newSession(ICustomTabsCallback arg1) throws RemoteException;

    boolean newSessionWithExtras(ICustomTabsCallback arg1, Bundle arg2) throws RemoteException;

    int postMessage(ICustomTabsCallback arg1, String arg2, Bundle arg3) throws RemoteException;

    boolean receiveFile(ICustomTabsCallback arg1, Uri arg2, int arg3, Bundle arg4) throws RemoteException;

    boolean requestPostMessageChannel(ICustomTabsCallback arg1, Uri arg2) throws RemoteException;

    boolean requestPostMessageChannelWithExtras(ICustomTabsCallback arg1, Uri arg2, Bundle arg3) throws RemoteException;

    boolean updateVisuals(ICustomTabsCallback arg1, Bundle arg2) throws RemoteException;

    boolean validateRelationship(ICustomTabsCallback arg1, int arg2, Uri arg3, Bundle arg4) throws RemoteException;

    boolean warmup(long arg1) throws RemoteException;
}

