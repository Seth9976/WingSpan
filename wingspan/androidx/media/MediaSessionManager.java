package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager.RemoteUserInfo;
import android.os.Build.VERSION;
import android.util.Log;

public final class MediaSessionManager {
    interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl arg1);
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        RemoteUserInfoImpl mImpl;

        public RemoteUserInfo(MediaSessionManager.RemoteUserInfo mediaSessionManager$RemoteUserInfo0) {
            this.mImpl = new RemoteUserInfoImplApi28(mediaSessionManager$RemoteUserInfo0);
        }

        public RemoteUserInfo(String s, int v, int v1) {
            if(Build.VERSION.SDK_INT >= 28) {
                this.mImpl = new RemoteUserInfoImplApi28(s, v, v1);
                return;
            }
            this.mImpl = new RemoteUserInfoImplBase(s, v, v1);
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof RemoteUserInfo ? this.mImpl.equals(((RemoteUserInfo)object0).mImpl) : false;
        }

        public String getPackageName() {
            return this.mImpl.getPackageName();
        }

        public int getPid() {
            return this.mImpl.getPid();
        }

        public int getUid() {
            return this.mImpl.getUid();
        }

        @Override
        public int hashCode() {
            return this.mImpl.hashCode();
        }
    }

    interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    static final boolean DEBUG = false;
    static final String TAG = "MediaSessionManager";
    MediaSessionManagerImpl mImpl;
    private static final Object sLock;
    private static volatile MediaSessionManager sSessionManager;

    static {
        MediaSessionManager.DEBUG = Log.isLoggable("MediaSessionManager", 3);
        MediaSessionManager.sLock = new Object();
    }

    private MediaSessionManager(Context context0) {
        if(Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaSessionManagerImplApi28(context0);
            return;
        }
        this.mImpl = new MediaSessionManagerImplApi21(context0);
    }

    Context getContext() {
        return this.mImpl.getContext();
    }

    public static MediaSessionManager getSessionManager(Context context0) {
        MediaSessionManager mediaSessionManager0 = MediaSessionManager.sSessionManager;
        if(mediaSessionManager0 == null) {
            synchronized(MediaSessionManager.sLock) {
                mediaSessionManager0 = MediaSessionManager.sSessionManager;
                if(mediaSessionManager0 == null) {
                    MediaSessionManager.sSessionManager = new MediaSessionManager(context0.getApplicationContext());
                    mediaSessionManager0 = MediaSessionManager.sSessionManager;
                }
                return mediaSessionManager0;
            }
        }
        return mediaSessionManager0;
    }

    public boolean isTrustedForMediaControl(RemoteUserInfo mediaSessionManager$RemoteUserInfo0) {
        if(mediaSessionManager$RemoteUserInfo0 == null) {
            throw new IllegalArgumentException("userInfo should not be null");
        }
        return this.mImpl.isTrustedForMediaControl(mediaSessionManager$RemoteUserInfo0.mImpl);
    }
}

