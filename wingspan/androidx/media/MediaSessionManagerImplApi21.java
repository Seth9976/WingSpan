package androidx.media;

import android.content.Context;

class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
    MediaSessionManagerImplApi21(Context context0) {
        super(context0);
        this.mContext = context0;
    }

    private boolean hasMediaControlPermission(RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl0) {
        return this.getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", mediaSessionManager$RemoteUserInfoImpl0.getPid(), mediaSessionManager$RemoteUserInfoImpl0.getUid()) == 0;
    }

    // 去混淆评级： 低(20)
    @Override  // androidx.media.MediaSessionManagerImplBase
    public boolean isTrustedForMediaControl(RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl0) {
        return this.hasMediaControlPermission(mediaSessionManager$RemoteUserInfoImpl0) || super.isTrustedForMediaControl(mediaSessionManager$RemoteUserInfoImpl0);
    }
}

