package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.session.MediaSession.Token;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService.BrowserRoot;
import android.service.media.MediaBrowserService.Result;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserServiceCompatApi21 {
    static class BrowserRoot {
        final Bundle mExtras;
        final String mRootId;

        BrowserRoot(String s, Bundle bundle0) {
            this.mRootId = s;
            this.mExtras = bundle0;
        }
    }

    static class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final ServiceCompatProxy mServiceProxy;

        MediaBrowserServiceAdaptor(Context context0, ServiceCompatProxy mediaBrowserServiceCompatApi21$ServiceCompatProxy0) {
            this.attachBaseContext(context0);
            this.mServiceProxy = mediaBrowserServiceCompatApi21$ServiceCompatProxy0;
        }

        @Override  // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String s, int v, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            Bundle bundle1 = bundle0 == null ? null : new Bundle(bundle0);
            BrowserRoot mediaBrowserServiceCompatApi21$BrowserRoot0 = this.mServiceProxy.onGetRoot(s, v, bundle1);
            return mediaBrowserServiceCompatApi21$BrowserRoot0 == null ? null : new MediaBrowserService.BrowserRoot(mediaBrowserServiceCompatApi21$BrowserRoot0.mRootId, mediaBrowserServiceCompatApi21$BrowserRoot0.mExtras);
        }

        @Override  // android.service.media.MediaBrowserService
        public void onLoadChildren(String s, MediaBrowserService.Result mediaBrowserService$Result0) {
            ResultWrapper mediaBrowserServiceCompatApi21$ResultWrapper0 = new ResultWrapper(mediaBrowserService$Result0);
            this.mServiceProxy.onLoadChildren(s, mediaBrowserServiceCompatApi21$ResultWrapper0);
        }
    }

    static class ResultWrapper {
        MediaBrowserService.Result mResultObj;

        ResultWrapper(MediaBrowserService.Result mediaBrowserService$Result0) {
            this.mResultObj = mediaBrowserService$Result0;
        }

        public void detach() {
            this.mResultObj.detach();
        }

        List parcelListToItemList(List list0) {
            if(list0 == null) {
                return null;
            }
            List list1 = new ArrayList();
            for(Object object0: list0) {
                ((Parcel)object0).setDataPosition(0);
                list1.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(((Parcel)object0)));
                ((Parcel)object0).recycle();
            }
            return list1;
        }

        public void sendResult(Object object0) {
            if(object0 instanceof List) {
                this.mResultObj.sendResult(this.parcelListToItemList(((List)object0)));
                return;
            }
            if(object0 instanceof Parcel) {
                ((Parcel)object0).setDataPosition(0);
                this.mResultObj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(((Parcel)object0)));
                ((Parcel)object0).recycle();
                return;
            }
            this.mResultObj.sendResult(null);
        }
    }

    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String arg1, int arg2, Bundle arg3);

        void onLoadChildren(String arg1, ResultWrapper arg2);
    }

    public static Object createService(Context context0, ServiceCompatProxy mediaBrowserServiceCompatApi21$ServiceCompatProxy0) {
        return new MediaBrowserServiceAdaptor(context0, mediaBrowserServiceCompatApi21$ServiceCompatProxy0);
    }

    public static void notifyChildrenChanged(Object object0, String s) {
        ((MediaBrowserService)object0).notifyChildrenChanged(s);
    }

    public static IBinder onBind(Object object0, Intent intent0) {
        return ((MediaBrowserService)object0).onBind(intent0);
    }

    public static void onCreate(Object object0) {
        ((MediaBrowserService)object0).onCreate();
    }

    public static void setSessionToken(Object object0, Object object1) {
        ((MediaBrowserService)object0).setSessionToken(((MediaSession.Token)object1));
    }
}

