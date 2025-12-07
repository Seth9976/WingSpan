package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.ObjectsCompat;

class MediaSessionManagerImplBase implements MediaSessionManagerImpl {
    static class RemoteUserInfoImplBase implements RemoteUserInfoImpl {
        private String mPackageName;
        private int mPid;
        private int mUid;

        RemoteUserInfoImplBase(String s, int v, int v1) {
            this.mPackageName = s;
            this.mPid = v;
            this.mUid = v1;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof RemoteUserInfoImplBase ? TextUtils.equals(this.mPackageName, ((RemoteUserInfoImplBase)object0).mPackageName) && this.mPid == ((RemoteUserInfoImplBase)object0).mPid && this.mUid == ((RemoteUserInfoImplBase)object0).mUid : false;
        }

        @Override  // androidx.media.MediaSessionManager$RemoteUserInfoImpl
        public String getPackageName() {
            return this.mPackageName;
        }

        @Override  // androidx.media.MediaSessionManager$RemoteUserInfoImpl
        public int getPid() {
            return this.mPid;
        }

        @Override  // androidx.media.MediaSessionManager$RemoteUserInfoImpl
        public int getUid() {
            return this.mUid;
        }

        @Override
        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mPackageName, this.mPid, this.mUid});
        }
    }

    private static final boolean DEBUG = false;
    private static final String ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
    private static final String PERMISSION_MEDIA_CONTENT_CONTROL = "android.permission.MEDIA_CONTENT_CONTROL";
    private static final String PERMISSION_STATUS_BAR_SERVICE = "android.permission.STATUS_BAR_SERVICE";
    private static final String TAG = "MediaSessionManager";
    ContentResolver mContentResolver;
    Context mContext;

    static {
        MediaSessionManagerImplBase.DEBUG = MediaSessionManager.DEBUG;
    }

    MediaSessionManagerImplBase(Context context0) {
        this.mContext = context0;
        this.mContentResolver = context0.getContentResolver();
    }

    @Override  // androidx.media.MediaSessionManager$MediaSessionManagerImpl
    public Context getContext() {
        return this.mContext;
    }

    boolean isEnabledNotificationListener(RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl0) {
        String s = Settings.Secure.getString(this.mContentResolver, "enabled_notification_listeners");
        if(s != null) {
            String[] arr_s = s.split(":");
            for(int v = 0; v < arr_s.length; ++v) {
                ComponentName componentName0 = ComponentName.unflattenFromString(arr_s[v]);
                if(componentName0 != null && componentName0.getPackageName().equals(mediaSessionManager$RemoteUserInfoImpl0.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPermissionGranted(RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl0, String s) {
        return mediaSessionManager$RemoteUserInfoImpl0.getPid() >= 0 ? this.mContext.checkPermission(s, mediaSessionManager$RemoteUserInfoImpl0.getPid(), mediaSessionManager$RemoteUserInfoImpl0.getUid()) == 0 : this.mContext.getPackageManager().checkPermission(s, mediaSessionManager$RemoteUserInfoImpl0.getPackageName()) == 0;
    }

    @Override  // androidx.media.MediaSessionManager$MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(RemoteUserInfoImpl mediaSessionManager$RemoteUserInfoImpl0) {
        try {
            ApplicationInfo applicationInfo0 = this.mContext.getPackageManager().getApplicationInfo(mediaSessionManager$RemoteUserInfoImpl0.getPackageName(), 0);
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            if(MediaSessionManagerImplBase.DEBUG) {
                Log.d("MediaSessionManager", "Package " + mediaSessionManager$RemoteUserInfoImpl0.getPackageName() + " doesn\'t exist");
            }
            return false;
        }
        if(applicationInfo0.uid != mediaSessionManager$RemoteUserInfoImpl0.getUid()) {
            if(MediaSessionManagerImplBase.DEBUG) {
                Log.d("MediaSessionManager", "Package name " + mediaSessionManager$RemoteUserInfoImpl0.getPackageName() + " doesn\'t match with the uid " + mediaSessionManager$RemoteUserInfoImpl0.getUid());
            }
            return false;
        }
        return this.isPermissionGranted(mediaSessionManager$RemoteUserInfoImpl0, "android.permission.STATUS_BAR_SERVICE") || this.isPermissionGranted(mediaSessionManager$RemoteUserInfoImpl0, "android.permission.MEDIA_CONTENT_CONTROL") || mediaSessionManager$RemoteUserInfoImpl0.getUid() == 1000 || this.isEnabledNotificationListener(mediaSessionManager$RemoteUserInfoImpl0);
    }
}

