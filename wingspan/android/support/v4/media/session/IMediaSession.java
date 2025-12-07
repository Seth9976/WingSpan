package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;

public interface IMediaSession extends IInterface {
    public static abstract class Stub extends Binder implements IMediaSession {
        static class Proxy implements IMediaSession {
            private IBinder mRemote;

            Proxy(IBinder iBinder0) {
                this.mRemote = iBinder0;
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(mediaDescriptionCompat0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        mediaDescriptionCompat0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(41, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat0, int v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(mediaDescriptionCompat0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        mediaDescriptionCompat0.writeToParcel(parcel0, 0);
                    }
                    parcel0.writeInt(v);
                    this.mRemote.transact(42, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int v, int v1, String s) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(v);
                    parcel0.writeInt(v1);
                    parcel0.writeString(s);
                    this.mRemote.transact(11, parcel0, parcel1, 0);
                    parcel1.readException();
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

            @Override  // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(22, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(0x1F, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public long getFlags() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(9, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readLong();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return "android.support.v4.media.session.IMediaSession";
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(8, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((PendingIntent)PendingIntent.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(27, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getPackageName() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(6, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(28, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((PlaybackStateCompat)PlaybackStateCompat.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public List getQueue() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(29, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.createTypedArrayList(QueueItem.CREATOR);
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(30, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRatingType() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(0x20, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(37, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(0x2F, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public String getTag() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(7, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readString();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(10, parcel0, parcel1, 0);
                    parcel1.readException();
                    return parcel1.readInt() == 0 ? null : ((ParcelableVolumeInfo)ParcelableVolumeInfo.CREATOR.createFromParcel(parcel1));
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = false;
                    this.mRemote.transact(45, parcel0, parcel1, 0);
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

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = false;
                    this.mRemote.transact(38, parcel0, parcel1, 0);
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

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = false;
                    this.mRemote.transact(5, parcel0, parcel1, 0);
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

            @Override  // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(20, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(18, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(13, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String s, Bundle bundle0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(14, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String s, Bundle bundle0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(15, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri uri0, Bundle bundle0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(uri0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        uri0.writeToParcel(parcel0, 0);
                    }
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(16, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(33, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String s, Bundle bundle0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(34, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String s, Bundle bundle0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(35, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri uri0, Bundle bundle0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(uri0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        uri0.writeToParcel(parcel0, 0);
                    }
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(36, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(21, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat ratingCompat0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(ratingCompat0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        ratingCompat0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(25, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat0, Bundle bundle0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(ratingCompat0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        ratingCompat0.writeToParcel(parcel0, 0);
                    }
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(51, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeStrongBinder((iMediaControllerCallback0 == null ? null : iMediaControllerCallback0.asBinder()));
                    this.mRemote.transact(3, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if(mediaDescriptionCompat0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        mediaDescriptionCompat0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(43, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(v);
                    this.mRemote.transact(44, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(23, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void seekTo(long v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeLong(v);
                    this.mRemote.transact(24, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCommand(String s, Bundle bundle0, ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    if(mediaSessionCompat$ResultReceiverWrapper0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        mediaSessionCompat$ResultReceiverWrapper0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(1, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String s, Bundle bundle0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeString(s);
                    if(bundle0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        bundle0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(26, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z = true;
                    if(keyEvent0 == null) {
                        parcel0.writeInt(0);
                    }
                    else {
                        parcel0.writeInt(1);
                        keyEvent0.writeToParcel(parcel0, 0);
                    }
                    this.mRemote.transact(2, parcel0, parcel1, 0);
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

            @Override  // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt((z ? 1 : 0));
                    this.mRemote.transact(46, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(v);
                    this.mRemote.transact(39, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(v);
                    this.mRemote.transact(0x30, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt((z ? 1 : 0));
                    this.mRemote.transact(40, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int v, int v1, String s) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeInt(v);
                    parcel0.writeInt(v1);
                    parcel0.writeString(s);
                    this.mRemote.transact(12, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long v) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeLong(v);
                    this.mRemote.transact(17, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    this.mRemote.transact(19, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }

            @Override  // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback0) throws RemoteException {
                Parcel parcel0 = Parcel.obtain();
                Parcel parcel1 = Parcel.obtain();
                try {
                    parcel0.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    parcel0.writeStrongBinder((iMediaControllerCallback0 == null ? null : iMediaControllerCallback0.asBinder()));
                    this.mRemote.transact(4, parcel0, parcel1, 0);
                    parcel1.readException();
                }
                finally {
                    parcel1.recycle();
                    parcel0.recycle();
                }
            }
        }

        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaSession";
        static final int TRANSACTION_addQueueItem = 41;
        static final int TRANSACTION_addQueueItemAt = 42;
        static final int TRANSACTION_adjustVolume = 11;
        static final int TRANSACTION_fastForward = 22;
        static final int TRANSACTION_getExtras = 0x1F;
        static final int TRANSACTION_getFlags = 9;
        static final int TRANSACTION_getLaunchPendingIntent = 8;
        static final int TRANSACTION_getMetadata = 27;
        static final int TRANSACTION_getPackageName = 6;
        static final int TRANSACTION_getPlaybackState = 28;
        static final int TRANSACTION_getQueue = 29;
        static final int TRANSACTION_getQueueTitle = 30;
        static final int TRANSACTION_getRatingType = 0x20;
        static final int TRANSACTION_getRepeatMode = 37;
        static final int TRANSACTION_getShuffleMode = 0x2F;
        static final int TRANSACTION_getTag = 7;
        static final int TRANSACTION_getVolumeAttributes = 10;
        static final int TRANSACTION_isCaptioningEnabled = 45;
        static final int TRANSACTION_isShuffleModeEnabledRemoved = 38;
        static final int TRANSACTION_isTransportControlEnabled = 5;
        static final int TRANSACTION_next = 20;
        static final int TRANSACTION_pause = 18;
        static final int TRANSACTION_play = 13;
        static final int TRANSACTION_playFromMediaId = 14;
        static final int TRANSACTION_playFromSearch = 15;
        static final int TRANSACTION_playFromUri = 16;
        static final int TRANSACTION_prepare = 33;
        static final int TRANSACTION_prepareFromMediaId = 34;
        static final int TRANSACTION_prepareFromSearch = 35;
        static final int TRANSACTION_prepareFromUri = 36;
        static final int TRANSACTION_previous = 21;
        static final int TRANSACTION_rate = 25;
        static final int TRANSACTION_rateWithExtras = 51;
        static final int TRANSACTION_registerCallbackListener = 3;
        static final int TRANSACTION_removeQueueItem = 43;
        static final int TRANSACTION_removeQueueItemAt = 44;
        static final int TRANSACTION_rewind = 23;
        static final int TRANSACTION_seekTo = 24;
        static final int TRANSACTION_sendCommand = 1;
        static final int TRANSACTION_sendCustomAction = 26;
        static final int TRANSACTION_sendMediaButton = 2;
        static final int TRANSACTION_setCaptioningEnabled = 46;
        static final int TRANSACTION_setRepeatMode = 39;
        static final int TRANSACTION_setShuffleMode = 0x30;
        static final int TRANSACTION_setShuffleModeEnabledRemoved = 40;
        static final int TRANSACTION_setVolumeTo = 12;
        static final int TRANSACTION_skipToQueueItem = 17;
        static final int TRANSACTION_stop = 19;
        static final int TRANSACTION_unregisterCallbackListener = 4;

        public Stub() {
            this.attachInterface(this, "android.support.v4.media.session.IMediaSession");
        }

        @Override  // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static IMediaSession asInterface(IBinder iBinder0) {
            if(iBinder0 == null) {
                return null;
            }
            IInterface iInterface0 = iBinder0.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            return iInterface0 != null && iInterface0 instanceof IMediaSession ? ((IMediaSession)iInterface0) : new Proxy(iBinder0);
        }

        @Override  // android.os.Binder
        public boolean onTransact(int v, Parcel parcel0, Parcel parcel1, int v1) throws RemoteException {
            KeyEvent keyEvent0 = null;
            switch(v) {
                case 51: {
                    parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                    RatingCompat ratingCompat0 = parcel0.readInt() == 0 ? null : ((RatingCompat)RatingCompat.CREATOR.createFromParcel(parcel0));
                    if(parcel0.readInt() != 0) {
                        keyEvent0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                    }
                    this.rateWithExtras(ratingCompat0, ((Bundle)keyEvent0));
                    parcel1.writeNoException();
                    return true;
                }
                case 0x5F4E5446: {
                    parcel1.writeString("android.support.v4.media.session.IMediaSession");
                    return true;
                }
                default: {
                    boolean z = false;
                    switch(v) {
                        case 1: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String s = parcel0.readString();
                            Bundle bundle0 = parcel0.readInt() == 0 ? null : ((Bundle)Bundle.CREATOR.createFromParcel(parcel0));
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (ResultReceiverWrapper)ResultReceiverWrapper.CREATOR.createFromParcel(parcel0);
                            }
                            this.sendCommand(s, bundle0, ((ResultReceiverWrapper)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 2: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (KeyEvent)KeyEvent.CREATOR.createFromParcel(parcel0);
                            }
                            boolean z1 = this.sendMediaButton(keyEvent0);
                            parcel1.writeNoException();
                            parcel1.writeInt(((int)z1));
                            return true;
                        }
                        case 3: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback.Stub.asInterface(parcel0.readStrongBinder()));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 4: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.unregisterCallbackListener(android.support.v4.media.session.IMediaControllerCallback.Stub.asInterface(parcel0.readStrongBinder()));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 5: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            boolean z2 = this.isTransportControlEnabled();
                            parcel1.writeNoException();
                            parcel1.writeInt(((int)z2));
                            return true;
                        }
                        case 6: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String s1 = this.getPackageName();
                            parcel1.writeNoException();
                            parcel1.writeString(s1);
                            return true;
                        }
                        case 7: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String s2 = this.getTag();
                            parcel1.writeNoException();
                            parcel1.writeString(s2);
                            return true;
                        }
                        case 8: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            PendingIntent pendingIntent0 = this.getLaunchPendingIntent();
                            parcel1.writeNoException();
                            if(pendingIntent0 != null) {
                                parcel1.writeInt(1);
                                pendingIntent0.writeToParcel(parcel1, 1);
                                return true;
                            }
                            parcel1.writeInt(0);
                            return true;
                        }
                        case 9: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            long v2 = this.getFlags();
                            parcel1.writeNoException();
                            parcel1.writeLong(v2);
                            return true;
                        }
                        case 10: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            ParcelableVolumeInfo parcelableVolumeInfo0 = this.getVolumeAttributes();
                            parcel1.writeNoException();
                            if(parcelableVolumeInfo0 != null) {
                                parcel1.writeInt(1);
                                parcelableVolumeInfo0.writeToParcel(parcel1, 1);
                                return true;
                            }
                            parcel1.writeInt(0);
                            return true;
                        }
                        case 11: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.adjustVolume(parcel0.readInt(), parcel0.readInt(), parcel0.readString());
                            parcel1.writeNoException();
                            return true;
                        }
                        case 12: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.setVolumeTo(parcel0.readInt(), parcel0.readInt(), parcel0.readString());
                            parcel1.writeNoException();
                            return true;
                        }
                        case 13: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.play();
                            parcel1.writeNoException();
                            return true;
                        }
                        case 14: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String s3 = parcel0.readString();
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                            }
                            this.playFromMediaId(s3, ((Bundle)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 15: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String s4 = parcel0.readString();
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                            }
                            this.playFromSearch(s4, ((Bundle)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 16: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            Uri uri0 = parcel0.readInt() == 0 ? null : ((Uri)Uri.CREATOR.createFromParcel(parcel0));
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                            }
                            this.playFromUri(uri0, ((Bundle)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 17: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.skipToQueueItem(parcel0.readLong());
                            parcel1.writeNoException();
                            return true;
                        }
                        case 18: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.pause();
                            parcel1.writeNoException();
                            return true;
                        }
                        case 19: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.stop();
                            parcel1.writeNoException();
                            return true;
                        }
                        case 20: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.next();
                            parcel1.writeNoException();
                            return true;
                        }
                        case 21: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.previous();
                            parcel1.writeNoException();
                            return true;
                        }
                        case 22: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.fastForward();
                            parcel1.writeNoException();
                            return true;
                        }
                        case 23: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.rewind();
                            parcel1.writeNoException();
                            return true;
                        }
                        case 24: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.seekTo(parcel0.readLong());
                            parcel1.writeNoException();
                            return true;
                        }
                        case 25: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (RatingCompat)RatingCompat.CREATOR.createFromParcel(parcel0);
                            }
                            this.rate(((RatingCompat)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 26: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String s5 = parcel0.readString();
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                            }
                            this.sendCustomAction(s5, ((Bundle)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 27: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            MediaMetadataCompat mediaMetadataCompat0 = this.getMetadata();
                            parcel1.writeNoException();
                            if(mediaMetadataCompat0 != null) {
                                parcel1.writeInt(1);
                                mediaMetadataCompat0.writeToParcel(parcel1, 1);
                                return true;
                            }
                            parcel1.writeInt(0);
                            return true;
                        }
                        case 28: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            PlaybackStateCompat playbackStateCompat0 = this.getPlaybackState();
                            parcel1.writeNoException();
                            if(playbackStateCompat0 != null) {
                                parcel1.writeInt(1);
                                playbackStateCompat0.writeToParcel(parcel1, 1);
                                return true;
                            }
                            parcel1.writeInt(0);
                            return true;
                        }
                        case 29: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            List list0 = this.getQueue();
                            parcel1.writeNoException();
                            parcel1.writeTypedList(list0);
                            return true;
                        }
                        case 30: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            CharSequence charSequence0 = this.getQueueTitle();
                            parcel1.writeNoException();
                            if(charSequence0 != null) {
                                parcel1.writeInt(1);
                                TextUtils.writeToParcel(charSequence0, parcel1, 1);
                                return true;
                            }
                            parcel1.writeInt(0);
                            return true;
                        }
                        case 0x1F: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            Bundle bundle1 = this.getExtras();
                            parcel1.writeNoException();
                            if(bundle1 != null) {
                                parcel1.writeInt(1);
                                bundle1.writeToParcel(parcel1, 1);
                                return true;
                            }
                            parcel1.writeInt(0);
                            return true;
                        }
                        case 0x20: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            int v3 = this.getRatingType();
                            parcel1.writeNoException();
                            parcel1.writeInt(v3);
                            return true;
                        }
                        case 33: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.prepare();
                            parcel1.writeNoException();
                            return true;
                        }
                        case 34: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String s6 = parcel0.readString();
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                            }
                            this.prepareFromMediaId(s6, ((Bundle)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 35: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            String s7 = parcel0.readString();
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                            }
                            this.prepareFromSearch(s7, ((Bundle)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 36: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            Uri uri1 = parcel0.readInt() == 0 ? null : ((Uri)Uri.CREATOR.createFromParcel(parcel0));
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (Bundle)Bundle.CREATOR.createFromParcel(parcel0);
                            }
                            this.prepareFromUri(uri1, ((Bundle)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 37: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            int v4 = this.getRepeatMode();
                            parcel1.writeNoException();
                            parcel1.writeInt(v4);
                            return true;
                        }
                        case 38: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            boolean z3 = this.isShuffleModeEnabledRemoved();
                            parcel1.writeNoException();
                            parcel1.writeInt(((int)z3));
                            return true;
                        }
                        case 39: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.setRepeatMode(parcel0.readInt());
                            parcel1.writeNoException();
                            return true;
                        }
                        case 40: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if(parcel0.readInt() != 0) {
                                z = true;
                            }
                            this.setShuffleModeEnabledRemoved(z);
                            parcel1.writeNoException();
                            return true;
                        }
                        case 41: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel0);
                            }
                            this.addQueueItem(((MediaDescriptionCompat)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 42: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel0);
                            }
                            this.addQueueItemAt(((MediaDescriptionCompat)keyEvent0), parcel0.readInt());
                            parcel1.writeNoException();
                            return true;
                        }
                        case 43: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if(parcel0.readInt() != 0) {
                                keyEvent0 = (MediaDescriptionCompat)MediaDescriptionCompat.CREATOR.createFromParcel(parcel0);
                            }
                            this.removeQueueItem(((MediaDescriptionCompat)keyEvent0));
                            parcel1.writeNoException();
                            return true;
                        }
                        case 44: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.removeQueueItemAt(parcel0.readInt());
                            parcel1.writeNoException();
                            return true;
                        }
                        case 45: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            boolean z4 = this.isCaptioningEnabled();
                            parcel1.writeNoException();
                            parcel1.writeInt(((int)z4));
                            return true;
                        }
                        case 46: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            if(parcel0.readInt() != 0) {
                                z = true;
                            }
                            this.setCaptioningEnabled(z);
                            parcel1.writeNoException();
                            return true;
                        }
                        case 0x2F: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            int v5 = this.getShuffleMode();
                            parcel1.writeNoException();
                            parcel1.writeInt(v5);
                            return true;
                        }
                        case 0x30: {
                            parcel0.enforceInterface("android.support.v4.media.session.IMediaSession");
                            this.setShuffleMode(parcel0.readInt());
                            parcel1.writeNoException();
                            return true;
                        }
                        default: {
                            return super.onTransact(v, parcel0, parcel1, v1);
                        }
                    }
                }
            }
        }
    }

    void addQueueItem(MediaDescriptionCompat arg1) throws RemoteException;

    void addQueueItemAt(MediaDescriptionCompat arg1, int arg2) throws RemoteException;

    void adjustVolume(int arg1, int arg2, String arg3) throws RemoteException;

    void fastForward() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    long getFlags() throws RemoteException;

    PendingIntent getLaunchPendingIntent() throws RemoteException;

    MediaMetadataCompat getMetadata() throws RemoteException;

    String getPackageName() throws RemoteException;

    PlaybackStateCompat getPlaybackState() throws RemoteException;

    List getQueue() throws RemoteException;

    CharSequence getQueueTitle() throws RemoteException;

    int getRatingType() throws RemoteException;

    int getRepeatMode() throws RemoteException;

    int getShuffleMode() throws RemoteException;

    String getTag() throws RemoteException;

    ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

    boolean isCaptioningEnabled() throws RemoteException;

    boolean isShuffleModeEnabledRemoved() throws RemoteException;

    boolean isTransportControlEnabled() throws RemoteException;

    void next() throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void playFromMediaId(String arg1, Bundle arg2) throws RemoteException;

    void playFromSearch(String arg1, Bundle arg2) throws RemoteException;

    void playFromUri(Uri arg1, Bundle arg2) throws RemoteException;

    void prepare() throws RemoteException;

    void prepareFromMediaId(String arg1, Bundle arg2) throws RemoteException;

    void prepareFromSearch(String arg1, Bundle arg2) throws RemoteException;

    void prepareFromUri(Uri arg1, Bundle arg2) throws RemoteException;

    void previous() throws RemoteException;

    void rate(RatingCompat arg1) throws RemoteException;

    void rateWithExtras(RatingCompat arg1, Bundle arg2) throws RemoteException;

    void registerCallbackListener(IMediaControllerCallback arg1) throws RemoteException;

    void removeQueueItem(MediaDescriptionCompat arg1) throws RemoteException;

    void removeQueueItemAt(int arg1) throws RemoteException;

    void rewind() throws RemoteException;

    void seekTo(long arg1) throws RemoteException;

    void sendCommand(String arg1, Bundle arg2, ResultReceiverWrapper arg3) throws RemoteException;

    void sendCustomAction(String arg1, Bundle arg2) throws RemoteException;

    boolean sendMediaButton(KeyEvent arg1) throws RemoteException;

    void setCaptioningEnabled(boolean arg1) throws RemoteException;

    void setRepeatMode(int arg1) throws RemoteException;

    void setShuffleMode(int arg1) throws RemoteException;

    void setShuffleModeEnabledRemoved(boolean arg1) throws RemoteException;

    void setVolumeTo(int arg1, int arg2, String arg3) throws RemoteException;

    void skipToQueueItem(long arg1) throws RemoteException;

    void stop() throws RemoteException;

    void unregisterCallbackListener(IMediaControllerCallback arg1) throws RemoteException;
}

