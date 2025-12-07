package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

public final class MediaMetadataCompat implements Parcelable {
    @Retention(RetentionPolicy.SOURCE)
    public @interface BitmapKey {
    }

    public static final class Builder {
        private final Bundle mBundle;

        public Builder() {
            this.mBundle = new Bundle();
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat0) {
            Bundle bundle0 = new Bundle(mediaMetadataCompat0.mBundle);
            this.mBundle = bundle0;
            MediaSessionCompat.ensureClassLoader(bundle0);
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat0, int v) {
            this(mediaMetadataCompat0);
            for(Object object0: this.mBundle.keySet()) {
                String s = (String)object0;
                Object object1 = this.mBundle.get(s);
                if(object1 instanceof Bitmap && (((Bitmap)object1).getHeight() > v || ((Bitmap)object1).getWidth() > v)) {
                    this.putBitmap(s, this.scaleBitmap(((Bitmap)object1), v));
                }
            }
        }

        public MediaMetadataCompat build() {
            return new MediaMetadataCompat(this.mBundle);
        }

        public Builder putBitmap(String s, Bitmap bitmap0) {
            if(MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && ((int)(((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s)))) != 2) {
                throw new IllegalArgumentException("The " + s + " key cannot be used to put a Bitmap");
            }
            this.mBundle.putParcelable(s, bitmap0);
            return this;
        }

        public Builder putLong(String s, long v) {
            if(MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && ((int)(((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s)))) != 0) {
                throw new IllegalArgumentException("The " + s + " key cannot be used to put a long");
            }
            this.mBundle.putLong(s, v);
            return this;
        }

        public Builder putRating(String s, RatingCompat ratingCompat0) {
            if(MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && ((int)(((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s)))) != 3) {
                throw new IllegalArgumentException("The " + s + " key cannot be used to put a Rating");
            }
            Parcelable parcelable0 = (Parcelable)ratingCompat0.getRating();
            this.mBundle.putParcelable(s, parcelable0);
            return this;
        }

        public Builder putString(String s, String s1) {
            if(MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && ((int)(((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s)))) != 1) {
                throw new IllegalArgumentException("The " + s + " key cannot be used to put a String");
            }
            this.mBundle.putCharSequence(s, s1);
            return this;
        }

        public Builder putText(String s, CharSequence charSequence0) {
            if(MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(s) && ((int)(((Integer)MediaMetadataCompat.METADATA_KEYS_TYPE.get(s)))) != 1) {
                throw new IllegalArgumentException("The " + s + " key cannot be used to put a CharSequence");
            }
            this.mBundle.putCharSequence(s, charSequence0);
            return this;
        }

        private Bitmap scaleBitmap(Bitmap bitmap0, int v) {
            float f = Math.min(((float)v) / ((float)bitmap0.getWidth()), ((float)v) / ((float)bitmap0.getHeight()));
            int v1 = (int)(((float)bitmap0.getHeight()) * f);
            return Bitmap.createScaledBitmap(bitmap0, ((int)(((float)bitmap0.getWidth()) * f)), v1, true);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LongKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RatingKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TextKey {
    }

    public static final Parcelable.Creator CREATOR = null;
    static final ArrayMap METADATA_KEYS_TYPE = null;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    private static final String[] PREFERRED_BITMAP_ORDER = null;
    private static final String[] PREFERRED_DESCRIPTION_ORDER = null;
    private static final String[] PREFERRED_URI_ORDER = null;
    private static final String TAG = "MediaMetadata";
    final Bundle mBundle;
    private MediaDescriptionCompat mDescription;
    private Object mMetadataObj;

    static {
        ArrayMap arrayMap0 = new ArrayMap();
        MediaMetadataCompat.METADATA_KEYS_TYPE = arrayMap0;
        arrayMap0.put("android.media.metadata.TITLE", 1);
        arrayMap0.put("android.media.metadata.ARTIST", 1);
        arrayMap0.put("android.media.metadata.DURATION", 0);
        arrayMap0.put("android.media.metadata.ALBUM", 1);
        arrayMap0.put("android.media.metadata.AUTHOR", 1);
        arrayMap0.put("android.media.metadata.WRITER", 1);
        arrayMap0.put("android.media.metadata.COMPOSER", 1);
        arrayMap0.put("android.media.metadata.COMPILATION", 1);
        arrayMap0.put("android.media.metadata.DATE", 1);
        arrayMap0.put("android.media.metadata.YEAR", 0);
        arrayMap0.put("android.media.metadata.GENRE", 1);
        arrayMap0.put("android.media.metadata.TRACK_NUMBER", 0);
        arrayMap0.put("android.media.metadata.NUM_TRACKS", 0);
        arrayMap0.put("android.media.metadata.DISC_NUMBER", 0);
        arrayMap0.put("android.media.metadata.ALBUM_ARTIST", 1);
        arrayMap0.put("android.media.metadata.ART", 2);
        arrayMap0.put("android.media.metadata.ART_URI", 1);
        arrayMap0.put("android.media.metadata.ALBUM_ART", 2);
        arrayMap0.put("android.media.metadata.ALBUM_ART_URI", 1);
        arrayMap0.put("android.media.metadata.USER_RATING", 3);
        arrayMap0.put("android.media.metadata.RATING", 3);
        arrayMap0.put("android.media.metadata.DISPLAY_TITLE", 1);
        arrayMap0.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        arrayMap0.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        arrayMap0.put("android.media.metadata.DISPLAY_ICON", 2);
        arrayMap0.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        arrayMap0.put("android.media.metadata.MEDIA_ID", 1);
        arrayMap0.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        arrayMap0.put("android.media.metadata.MEDIA_URI", 1);
        arrayMap0.put("android.media.metadata.ADVERTISEMENT", 0);
        arrayMap0.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        MediaMetadataCompat.PREFERRED_BITMAP_ORDER = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        MediaMetadataCompat.PREFERRED_URI_ORDER = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        MediaMetadataCompat.CREATOR = new Parcelable.Creator() {
            public MediaMetadataCompat createFromParcel(Parcel parcel0) {
                return new MediaMetadataCompat(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public MediaMetadataCompat[] newArray(int v) {
                return new MediaMetadataCompat[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    MediaMetadataCompat(Bundle bundle0) {
        Bundle bundle1 = new Bundle(bundle0);
        this.mBundle = bundle1;
        MediaSessionCompat.ensureClassLoader(bundle1);
    }

    MediaMetadataCompat(Parcel parcel0) {
        this.mBundle = parcel0.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public boolean containsKey(String s) {
        return this.mBundle.containsKey(s);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static MediaMetadataCompat fromMediaMetadata(Object object0) {
        if(object0 != null) {
            Parcel parcel0 = Parcel.obtain();
            MediaMetadataCompatApi21.writeToParcel(object0, parcel0, 0);
            parcel0.setDataPosition(0);
            MediaMetadataCompat mediaMetadataCompat0 = (MediaMetadataCompat)MediaMetadataCompat.CREATOR.createFromParcel(parcel0);
            parcel0.recycle();
            mediaMetadataCompat0.mMetadataObj = object0;
            return mediaMetadataCompat0;
        }
        return null;
    }

    public Bitmap getBitmap(String s) {
        try {
            return (Bitmap)this.mBundle.getParcelable(s);
        }
        catch(Exception exception0) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", exception0);
            return null;
        }
    }

    public Bundle getBundle() {
        return new Bundle(this.mBundle);
    }

    public MediaDescriptionCompat getDescription() {
        Uri uri1;
        Uri uri0;
        Bitmap bitmap0;
        MediaDescriptionCompat mediaDescriptionCompat0 = this.mDescription;
        if(mediaDescriptionCompat0 != null) {
            return mediaDescriptionCompat0;
        }
        String s = this.getString("android.media.metadata.MEDIA_ID");
        CharSequence[] arr_charSequence = new CharSequence[3];
        CharSequence charSequence0 = this.getText("android.media.metadata.DISPLAY_TITLE");
        if(TextUtils.isEmpty(charSequence0)) {
            int v1 = 0;
            for(int v = 0; v1 < 3; ++v) {
                String[] arr_s = MediaMetadataCompat.PREFERRED_DESCRIPTION_ORDER;
                if(v >= arr_s.length) {
                    break;
                }
                CharSequence charSequence1 = this.getText(arr_s[v]);
                if(!TextUtils.isEmpty(charSequence1)) {
                    arr_charSequence[v1] = charSequence1;
                    ++v1;
                }
            }
        }
        else {
            arr_charSequence[0] = charSequence0;
            arr_charSequence[1] = this.getText("android.media.metadata.DISPLAY_SUBTITLE");
            arr_charSequence[2] = this.getText("android.media.metadata.DISPLAY_DESCRIPTION");
        }
        for(int v2 = 0; true; ++v2) {
            bitmap0 = null;
            String[] arr_s1 = MediaMetadataCompat.PREFERRED_BITMAP_ORDER;
            uri0 = null;
            if(v2 >= arr_s1.length) {
                break;
            }
            Bitmap bitmap1 = this.getBitmap(arr_s1[v2]);
            if(bitmap1 != null) {
                bitmap0 = bitmap1;
                break;
            }
        }
        for(int v3 = 0; true; ++v3) {
            uri1 = null;
            String[] arr_s2 = MediaMetadataCompat.PREFERRED_URI_ORDER;
            if(v3 >= arr_s2.length) {
                break;
            }
            String s1 = this.getString(arr_s2[v3]);
            if(!TextUtils.isEmpty(s1)) {
                uri1 = Uri.parse(s1);
                break;
            }
        }
        String s2 = this.getString("android.media.metadata.MEDIA_URI");
        if(!TextUtils.isEmpty(s2)) {
            uri0 = Uri.parse(s2);
        }
        android.support.v4.media.MediaDescriptionCompat.Builder mediaDescriptionCompat$Builder0 = new android.support.v4.media.MediaDescriptionCompat.Builder();
        mediaDescriptionCompat$Builder0.setMediaId(s);
        mediaDescriptionCompat$Builder0.setTitle(arr_charSequence[0]);
        mediaDescriptionCompat$Builder0.setSubtitle(arr_charSequence[1]);
        mediaDescriptionCompat$Builder0.setDescription(arr_charSequence[2]);
        mediaDescriptionCompat$Builder0.setIconBitmap(bitmap0);
        mediaDescriptionCompat$Builder0.setIconUri(uri1);
        mediaDescriptionCompat$Builder0.setMediaUri(uri0);
        Bundle bundle0 = new Bundle();
        if(this.mBundle.containsKey("android.media.metadata.BT_FOLDER_TYPE")) {
            bundle0.putLong("android.media.extra.BT_FOLDER_TYPE", this.getLong("android.media.metadata.BT_FOLDER_TYPE"));
        }
        if(this.mBundle.containsKey("android.media.metadata.DOWNLOAD_STATUS")) {
            bundle0.putLong("android.media.extra.DOWNLOAD_STATUS", this.getLong("android.media.metadata.DOWNLOAD_STATUS"));
        }
        if(!bundle0.isEmpty()) {
            mediaDescriptionCompat$Builder0.setExtras(bundle0);
        }
        MediaDescriptionCompat mediaDescriptionCompat1 = mediaDescriptionCompat$Builder0.build();
        this.mDescription = mediaDescriptionCompat1;
        return mediaDescriptionCompat1;
    }

    public long getLong(String s) {
        return this.mBundle.getLong(s, 0L);
    }

    public Object getMediaMetadata() {
        if(this.mMetadataObj == null) {
            Parcel parcel0 = Parcel.obtain();
            this.writeToParcel(parcel0, 0);
            parcel0.setDataPosition(0);
            this.mMetadataObj = MediaMetadataCompatApi21.createFromParcel(parcel0);
            parcel0.recycle();
        }
        return this.mMetadataObj;
    }

    public RatingCompat getRating(String s) {
        try {
            return RatingCompat.fromRating(this.mBundle.getParcelable(s));
        }
        catch(Exception exception0) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", exception0);
            return null;
        }
    }

    public String getString(String s) {
        CharSequence charSequence0 = this.mBundle.getCharSequence(s);
        return charSequence0 == null ? null : charSequence0.toString();
    }

    public CharSequence getText(String s) {
        return this.mBundle.getCharSequence(s);
    }

    public Set keySet() {
        return this.mBundle.keySet();
    }

    public int size() {
        return this.mBundle.size();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeBundle(this.mBundle);
    }
}

