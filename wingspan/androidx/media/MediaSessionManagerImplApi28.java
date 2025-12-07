package androidx.media;

import android.content.Context;
import android.media.session.MediaSessionManager.RemoteUserInfo;
import android.media.session.MediaSessionManager;
import androidx.core.util.ObjectsCompat;

class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    static final class RemoteUserInfoImplApi28 implements RemoteUserInfoImpl {
        final MediaSessionManager.RemoteUserInfo mObject;

        RemoteUserInfoImplApi28(MediaSessionManager.RemoteUserInfo mediaSessionManager$RemoteUserInfo0) {
            this.mObject = mediaSessionManager$RemoteUserInfo0;
        }

        RemoteUserInfoImplApi28(String s, int v, int v1) {
            this.mObject = new MediaSessionManager.RemoteUserInfo(s, v, v1);
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof RemoteUserInfoImplApi28 ? this.mObject.equals(((RemoteUserInfoImplApi28)object0).mObject) : false;
        }

        @Override  // androidx.media.MediaSessionManager$RemoteUserInfoImpl
        public String getPackageName() {
            return this.mObject.getPackageName();
        }

        @Override  // androidx.media.MediaSessionManager$RemoteUserInfoImpl
        public int getPid() {
            return this.mObject.getPid();
        }

        @Override  // androidx.media.MediaSessionManager$RemoteUserInfoImpl
        public int getUid() {
            return this.mObject.getUid();
        }

        @Override
        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mObject});
        }
    }

    MediaSessionManager mObject;

    MediaSessionManagerImplApi28(Context context0) {
        super(context0);
        this.mObject = (MediaSessionManager)context0.getSystemService("media_session");
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.media.MediaSessionManagerImplApi21
    public boolean isTrustedForMediaControl(RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl0) {
        return mediaSessionManager$RemoteUserInfoImpl0 instanceof RemoteUserInfoImplApi28 ? this.mObject.isTrustedForMediaControl(((RemoteUserInfoImplApi28)mediaSessionManager$RemoteUserInfoImpl0).mObject) : false;
    }
}

