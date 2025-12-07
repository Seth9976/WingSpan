package androidx.media;

import android.content.Context;
import android.service.media.MediaBrowserService.Result;

class MediaBrowserServiceCompatApi23 {
    static class MediaBrowserServiceAdaptor extends androidx.media.MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context context0, ServiceCompatProxy mediaBrowserServiceCompatApi23$ServiceCompatProxy0) {
            super(context0, mediaBrowserServiceCompatApi23$ServiceCompatProxy0);
        }

        @Override  // android.service.media.MediaBrowserService
        public void onLoadItem(String s, MediaBrowserService.Result mediaBrowserService$Result0) {
            ((ServiceCompatProxy)this.mServiceProxy).onLoadItem(s, new ResultWrapper(mediaBrowserService$Result0));
        }
    }

    public interface ServiceCompatProxy extends androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(String arg1, ResultWrapper arg2);
    }

    public static Object createService(Context context0, ServiceCompatProxy mediaBrowserServiceCompatApi23$ServiceCompatProxy0) {
        return new MediaBrowserServiceAdaptor(context0, mediaBrowserServiceCompatApi23$ServiceCompatProxy0);
    }
}

