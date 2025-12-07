package android.support.v4.media;

import android.media.MediaDescription.Builder;
import android.media.MediaDescription;
import android.net.Uri;

class MediaDescriptionCompatApi23 {
    static class Builder {
        public static void setMediaUri(Object object0, Uri uri0) {
            ((MediaDescription.Builder)object0).setMediaUri(uri0);
        }
    }

    public static Uri getMediaUri(Object object0) {
        return ((MediaDescription)object0).getMediaUri();
    }
}

