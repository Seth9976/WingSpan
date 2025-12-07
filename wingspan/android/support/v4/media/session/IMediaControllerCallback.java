package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

public interface IMediaControllerCallback extends IInterface {
    public static abstract class Stub extends Binder implements IMediaControllerCallback {
        static class Proxy implements IMediaControllerCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return "android.support.v4.media.session.IMediaControllerCallback";
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean z) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeInt((z ? 1 : 0));
                    this.mRemote.transact(11, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String s, Bundle bundle0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeString(s);
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle bundle0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(7, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat mediaMetadataCompat0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(mediaMetadataCompat0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        mediaMetadataCompat0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(4, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat playbackStateCompat0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(playbackStateCompat0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        playbackStateCompat0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(3, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List list0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeTypedList(list0);
                    this.mRemote.transact(5, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence charSequence0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(charSequence0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        TextUtils.writeToParcel(charSequence0, parcel0, 0);
                    }
                    this.mRemote.transact(6, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeInt(v);
                    this.mRemote.transact(9, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.mRemote.transact(2, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.mRemote.transact(13, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeInt(v);
                    this.mRemote.transact(12, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean z) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    parcel0.writeInt((z ? 1 : 0));
                    this.mRemote.transact(10, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo parcelableVolumeInfo0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if(parcelableVolumeInfo0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        parcelableVolumeInfo0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(8, parcel0, null, 1);
                }
                finally {
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
        static final int TRANSACTION_onCaptioningEnabledChanged = 11;
        static final int TRANSACTION_onEvent = 1;
        static final int TRANSACTION_onExtrasChanged = 7;
        static final int TRANSACTION_onMetadataChanged = 4;
        static final int TRANSACTION_onPlaybackStateChanged = 3;
        static final int TRANSACTION_onQueueChanged = 5;
        static final int TRANSACTION_onQueueTitleChanged = 6;
        static final int TRANSACTION_onRepeatModeChanged = 9;
        static final int TRANSACTION_onSessionDestroyed = 2;
        static final int TRANSACTION_onSessionReady = 13;
        static final int TRANSACTION_onShuffleModeChanged = 12;
        static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
        static final int TRANSACTION_onVolumeInfoChanged = 8;

        public Stub() {
            this.attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IMediaControllerCallback asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            return iInterface0 != null && iInterface0 instanceof IMediaControllerCallback ? ((IMediaControllerCallback)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
            if(v != 0x5F4E5446) {
                boolean z = false;
                Bundle bundle0 = null;
                switch(v) {
                    case 1: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        String s = parcel0.readString();
                        if(parcel0.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                        }
                        this.onEvent(s, bundle0);
                        return true;
                    }
                    case 2: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        this.onSessionDestroyed();
                        return true;
                    }
                    case 3: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if(parcel0.readInt() != 0) {
                            bundle0 = (PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel0);
                        }
                        this.onPlaybackStateChanged(((PlaybackStateCompat)bundle0));
                        return true;
                    }
                    case 4: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if(parcel0.readInt() != 0) {
                            bundle0 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel0);
                        }
                        this.onMetadataChanged(((MediaMetadataCompat)bundle0));
                        return true;
                    }
                    case 5: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        this.onQueueChanged(parcel0.createTypedArrayList(QueueItem.CREATOR));
                        return true;
                    }
                    case 6: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if(parcel0.readInt() != 0) {
                            bundle0 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
                        }
                        this.onQueueTitleChanged(((CharSequence)bundle0));
                        return true;
                    }
                    case 7: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if(parcel0.readInt() != 0) {
                            bundle0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                        }
                        this.onExtrasChanged(bundle0);
                        return true;
                    }
                    case 8: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if(parcel0.readInt() != 0) {
                            bundle0 = (ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel0);
                        }
                        this.onVolumeInfoChanged(((ParcelableVolumeInfo)bundle0));
                        return true;
                    }
                    case 9: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        this.onRepeatModeChanged(parcel0.readInt());
                        return true;
                    }
                    case 10: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if(parcel0.readInt() != 0) {
                            z = true;
                        }
                        this.onShuffleModeChangedRemoved(z);
                        return true;
                    }
                    case 11: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if(parcel0.readInt() != 0) {
                            z = true;
                        }
                        this.onCaptioningEnabledChanged(z);
                        return true;
                    }
                    case 12: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        this.onShuffleModeChanged(parcel0.readInt());
                        return true;
                    }
                    case 13: {
                        parcel0.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        this.onSessionReady();
                        return true;
                    }
                    default: {
                        return super.onTransact(v, parcel0, parcel1, v1);
                    }
                }
            }
            parcel1.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
    }

    void onCaptioningEnabledChanged(boolean arg1) throws RemoteException;

    void onEvent(String arg1, Bundle arg2) throws RemoteException;

    void onExtrasChanged(Bundle arg1) throws RemoteException;

    void onMetadataChanged(MediaMetadataCompat arg1) throws RemoteException;

    void onPlaybackStateChanged(PlaybackStateCompat arg1) throws RemoteException;

    void onQueueChanged(List arg1) throws RemoteException;

    void onQueueTitleChanged(CharSequence arg1) throws RemoteException;

    void onRepeatModeChanged(int arg1) throws RemoteException;

    void onSessionDestroyed() throws RemoteException;

    void onSessionReady() throws RemoteException;

    void onShuffleModeChanged(int arg1) throws RemoteException;

    void onShuffleModeChangedRemoved(boolean arg1) throws RemoteException;

    void onVolumeInfoChanged(ParcelableVolumeInfo arg1) throws RemoteException;
}

