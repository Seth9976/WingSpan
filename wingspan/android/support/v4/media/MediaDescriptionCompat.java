package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }

        public Builder setDescription(CharSequence charSequence0) {
            this.mDescription = charSequence0;
            return this;
        }

        public Builder setExtras(Bundle bundle0) {
            this.mExtras = bundle0;
            return this;
        }

        public Builder setIconBitmap(Bitmap bitmap0) {
            this.mIcon = bitmap0;
            return this;
        }

        public Builder setIconUri(Uri uri0) {
            this.mIconUri = uri0;
            return this;
        }

        public Builder setMediaId(String s) {
            this.mMediaId = s;
            return this;
        }

        public Builder setMediaUri(Uri uri0) {
            this.mMediaUri = uri0;
            return this;
        }

        public Builder setSubtitle(CharSequence charSequence0) {
            this.mSubtitle = charSequence0;
            return this;
        }

        public Builder setTitle(CharSequence charSequence0) {
            this.mTitle = charSequence0;
            return this;
        }
    }

    public static final long BT_FOLDER_TYPE_ALBUMS = 2L;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3L;
    public static final long BT_FOLDER_TYPE_GENRES = 4L;
    public static final long BT_FOLDER_TYPE_MIXED = 0L;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5L;
    public static final long BT_FOLDER_TYPE_TITLES = 1L;
    public static final long BT_FOLDER_TYPE_YEARS = 6L;
    public static final Parcelable.Creator CREATOR = null;
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2L;
    public static final long STATUS_DOWNLOADING = 1L;
    public static final long STATUS_NOT_DOWNLOADED;
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    static {
        MediaDescriptionCompat.CREATOR = new Parcelable.Creator() {
            public MediaDescriptionCompat createFromParcel(Parcel parcel0) {
                return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel0));
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public MediaDescriptionCompat[] newArray(int v) {
                return new MediaDescriptionCompat[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    MediaDescriptionCompat(Parcel parcel0) {
        this.mMediaId = parcel0.readString();
        this.mTitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
        this.mSubtitle = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
        this.mDescription = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel0);
        ClassLoader classLoader0 = this.getClass().getClassLoader();
        this.mIcon = (Bitmap)parcel0.readParcelable(classLoader0);
        this.mIconUri = (Uri)parcel0.readParcelable(classLoader0);
        this.mExtras = parcel0.readBundle(classLoader0);
        this.mMediaUri = (Uri)parcel0.readParcelable(classLoader0);
    }

    MediaDescriptionCompat(String s, CharSequence charSequence0, CharSequence charSequence1, CharSequence charSequence2, Bitmap bitmap0, Uri uri0, Bundle bundle0, Uri uri1) {
        this.mMediaId = s;
        this.mTitle = charSequence0;
        this.mSubtitle = charSequence1;
        this.mDescription = charSequence2;
        this.mIcon = bitmap0;
        this.mIconUri = uri0;
        this.mExtras = bundle0;
        this.mMediaUri = uri1;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object object0) {
        Uri uri0;
        MediaDescriptionCompat mediaDescriptionCompat0 = null;
        if(object0 != null) {
            Builder mediaDescriptionCompat$Builder0 = new Builder();
            mediaDescriptionCompat$Builder0.setMediaId(MediaDescriptionCompatApi21.getMediaId(object0));
            mediaDescriptionCompat$Builder0.setTitle(MediaDescriptionCompatApi21.getTitle(object0));
            mediaDescriptionCompat$Builder0.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(object0));
            mediaDescriptionCompat$Builder0.setDescription(MediaDescriptionCompatApi21.getDescription(object0));
            mediaDescriptionCompat$Builder0.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(object0));
            mediaDescriptionCompat$Builder0.setIconUri(MediaDescriptionCompatApi21.getIconUri(object0));
            Bundle bundle0 = MediaDescriptionCompatApi21.getExtras(object0);
            if(bundle0 == null) {
                uri0 = null;
            }
            else {
                MediaSessionCompat.ensureClassLoader(bundle0);
                uri0 = (Uri)bundle0.getParcelable("android.support.v4.media.description.MEDIA_URI");
            }
            if(uri0 == null) {
                mediaDescriptionCompat0 = bundle0;
            }
            else if(!bundle0.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundle0.size() != 2) {
                bundle0.remove("android.support.v4.media.description.MEDIA_URI");
                bundle0.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                mediaDescriptionCompat0 = bundle0;
            }
            mediaDescriptionCompat$Builder0.setExtras(((Bundle)mediaDescriptionCompat0));
            if(uri0 == null) {
                mediaDescriptionCompat$Builder0.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(object0));
            }
            else {
                mediaDescriptionCompat$Builder0.setMediaUri(uri0);
            }
            mediaDescriptionCompat0 = mediaDescriptionCompat$Builder0.build();
            mediaDescriptionCompat0.mDescriptionObj = object0;
        }
        return mediaDescriptionCompat0;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Object getMediaDescription() {
        Object object0 = this.mDescriptionObj;
        if(object0 == null) {
            Object object1 = android.support.v4.media.MediaDescriptionCompatApi21.Builder.newInstance();
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.setMediaId(object1, this.mMediaId);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.setTitle(object1, this.mTitle);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.setSubtitle(object1, this.mSubtitle);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.setDescription(object1, this.mDescription);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.setIconBitmap(object1, this.mIcon);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.setIconUri(object1, this.mIconUri);
            android.support.v4.media.MediaDescriptionCompatApi21.Builder.setExtras(object1, this.mExtras);
            android.support.v4.media.MediaDescriptionCompatApi23.Builder.setMediaUri(object1, this.mMediaUri);
            object0 = android.support.v4.media.MediaDescriptionCompatApi21.Builder.build(object1);
            this.mDescriptionObj = object0;
        }
        return object0;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    @Override
    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        MediaDescriptionCompatApi21.writeToParcel(this.getMediaDescription(), parcel0, v);
    }
}

