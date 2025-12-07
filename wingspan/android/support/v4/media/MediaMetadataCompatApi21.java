package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata.Builder;
import android.media.MediaMetadata;
import android.media.Rating;
import android.os.Parcel;
import java.util.Set;

class MediaMetadataCompatApi21 {
    public static class Builder {
        public static Object build(Object object0) {
            return ((MediaMetadata.Builder)object0).build();
        }

        public static Object newInstance() {
            return new MediaMetadata.Builder();
        }

        public static void putBitmap(Object object0, String s, Bitmap bitmap0) {
            ((MediaMetadata.Builder)object0).putBitmap(s, bitmap0);
        }

        public static void putLong(Object object0, String s, long v) {
            ((MediaMetadata.Builder)object0).putLong(s, v);
        }

        public static void putRating(Object object0, String s, Object object1) {
            ((MediaMetadata.Builder)object0).putRating(s, ((Rating)object1));
        }

        public static void putString(Object object0, String s, String s1) {
            ((MediaMetadata.Builder)object0).putString(s, s1);
        }

        public static void putText(Object object0, String s, CharSequence charSequence0) {
            ((MediaMetadata.Builder)object0).putText(s, charSequence0);
        }
    }

    public static Object createFromParcel(Parcel parcel0) {
        return MediaMetadata.CREATOR.createFromParcel(parcel0);
    }

    public static Bitmap getBitmap(Object object0, String s) {
        return ((MediaMetadata)object0).getBitmap(s);
    }

    public static long getLong(Object object0, String s) {
        return ((MediaMetadata)object0).getLong(s);
    }

    public static Object getRating(Object object0, String s) {
        return ((MediaMetadata)object0).getRating(s);
    }

    public static CharSequence getText(Object object0, String s) {
        return ((MediaMetadata)object0).getText(s);
    }

    public static Set keySet(Object object0) {
        return ((MediaMetadata)object0).keySet();
    }

    public static void writeToParcel(Object object0, Parcel parcel0, int v) {
        ((MediaMetadata)object0).writeToParcel(parcel0, v);
    }
}

