package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription.Builder;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

class MediaDescriptionCompatApi21 {
    static class Builder {
        public static Object build(Object object0) {
            return ((MediaDescription.Builder)object0).build();
        }

        public static Object newInstance() {
            return new MediaDescription.Builder();
        }

        public static void setDescription(Object object0, CharSequence charSequence0) {
            ((MediaDescription.Builder)object0).setDescription(charSequence0);
        }

        public static void setExtras(Object object0, Bundle bundle0) {
            ((MediaDescription.Builder)object0).setExtras(bundle0);
        }

        public static void setIconBitmap(Object object0, Bitmap bitmap0) {
            ((MediaDescription.Builder)object0).setIconBitmap(bitmap0);
        }

        public static void setIconUri(Object object0, Uri uri0) {
            ((MediaDescription.Builder)object0).setIconUri(uri0);
        }

        public static void setMediaId(Object object0, String s) {
            ((MediaDescription.Builder)object0).setMediaId(s);
        }

        public static void setSubtitle(Object object0, CharSequence charSequence0) {
            ((MediaDescription.Builder)object0).setSubtitle(charSequence0);
        }

        public static void setTitle(Object object0, CharSequence charSequence0) {
            ((MediaDescription.Builder)object0).setTitle(charSequence0);
        }
    }

    public static Object fromParcel(Parcel parcel0) {
        return MediaDescription.CREATOR.createFromParcel(parcel0);
    }

    public static CharSequence getDescription(Object object0) {
        return ((MediaDescription)object0).getDescription();
    }

    public static Bundle getExtras(Object object0) {
        return ((MediaDescription)object0).getExtras();
    }

    public static Bitmap getIconBitmap(Object object0) {
        return ((MediaDescription)object0).getIconBitmap();
    }

    public static Uri getIconUri(Object object0) {
        return ((MediaDescription)object0).getIconUri();
    }

    public static String getMediaId(Object object0) {
        return ((MediaDescription)object0).getMediaId();
    }

    public static CharSequence getSubtitle(Object object0) {
        return ((MediaDescription)object0).getSubtitle();
    }

    public static CharSequence getTitle(Object object0) {
        return ((MediaDescription)object0).getTitle();
    }

    public static void writeToParcel(Object object0, Parcel parcel0, int v) {
        ((MediaDescription)object0).writeToParcel(parcel0, v);
    }
}

