package android.support.v4.media;

import android.media.browse.MediaBrowser.ItemCallback;
import android.media.browse.MediaBrowser.MediaItem;
import android.media.browse.MediaBrowser;
import android.os.Parcel;

class MediaBrowserCompatApi23 {
    interface ItemCallback {
        void onError(String arg1);

        void onItemLoaded(Parcel arg1);
    }

    static class ItemCallbackProxy extends MediaBrowser.ItemCallback {
        protected final ItemCallback mItemCallback;

        public ItemCallbackProxy(ItemCallback mediaBrowserCompatApi23$ItemCallback0) {
            this.mItemCallback = mediaBrowserCompatApi23$ItemCallback0;
        }

        @Override  // android.media.browse.MediaBrowser$ItemCallback
        public void onError(String s) {
            this.mItemCallback.onError(s);
        }

        @Override  // android.media.browse.MediaBrowser$ItemCallback
        public void onItemLoaded(MediaBrowser.MediaItem mediaBrowser$MediaItem0) {
            if(mediaBrowser$MediaItem0 == null) {
                this.mItemCallback.onItemLoaded(null);
                return;
            }
            Parcel parcel0 = Parcel.obtain();
            mediaBrowser$MediaItem0.writeToParcel(parcel0, 0);
            this.mItemCallback.onItemLoaded(parcel0);
        }
    }

    public static Object createItemCallback(ItemCallback mediaBrowserCompatApi23$ItemCallback0) {
        return new ItemCallbackProxy(mediaBrowserCompatApi23$ItemCallback0);
    }

    public static void getItem(Object object0, String s, Object object1) {
        ((MediaBrowser)object0).getItem(s, ((MediaBrowser.ItemCallback)object1));
    }
}

