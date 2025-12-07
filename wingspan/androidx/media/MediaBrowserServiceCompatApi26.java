package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser.MediaItem;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService.Result;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class MediaBrowserServiceCompatApi26 {
    static class MediaBrowserServiceAdaptor extends androidx.media.MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context context0, ServiceCompatProxy mediaBrowserServiceCompatApi26$ServiceCompatProxy0) {
            super(context0, mediaBrowserServiceCompatApi26$ServiceCompatProxy0);
        }

        @Override  // android.service.media.MediaBrowserService
        public void onLoadChildren(String s, MediaBrowserService.Result mediaBrowserService$Result0, Bundle bundle0) {
            MediaSessionCompat.ensureClassLoader(bundle0);
            ((ServiceCompatProxy)this.mServiceProxy).onLoadChildren(s, new ResultWrapper(mediaBrowserService$Result0), bundle0);
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

        public void sendResult(List list0, int v) {
            try {
                MediaBrowserServiceCompatApi26.sResultFlags.setInt(this.mResultObj, v);
            }
            catch(IllegalAccessException illegalAccessException0) {
                Log.w("MBSCompatApi26", illegalAccessException0);
            }
            this.mResultObj.sendResult(this.parcelListToItemList(list0));
        }
    }

    public interface ServiceCompatProxy extends androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String arg1, ResultWrapper arg2, Bundle arg3);
    }

    private static final String TAG = "MBSCompatApi26";
    static Field sResultFlags;

    static {
        try {
            Field field0 = MediaBrowserService.Result.class.getDeclaredField("mFlags");
            MediaBrowserServiceCompatApi26.sResultFlags = field0;
            field0.setAccessible(true);
        }
        catch(NoSuchFieldException noSuchFieldException0) {
            Log.w("MBSCompatApi26", noSuchFieldException0);
        }
    }

    public static Object createService(Context context0, ServiceCompatProxy mediaBrowserServiceCompatApi26$ServiceCompatProxy0) {
        return new MediaBrowserServiceAdaptor(context0, mediaBrowserServiceCompatApi26$ServiceCompatProxy0);
    }

    public static Bundle getBrowserRootHints(Object object0) {
        return ((MediaBrowserService)object0).getBrowserRootHints();
    }

    public static void notifyChildrenChanged(Object object0, String s, Bundle bundle0) {
        ((MediaBrowserService)object0).notifyChildrenChanged(s, bundle0);
    }
}

