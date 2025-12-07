package android.support.v4.media;

import android.media.Rating;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class RatingCompat implements Parcelable {
    @Retention(RetentionPolicy.SOURCE)
    public @interface StarStyle {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Style {
    }

    public static final Parcelable.Creator CREATOR = null;
    public static final int RATING_3_STARS = 3;
    public static final int RATING_4_STARS = 4;
    public static final int RATING_5_STARS = 5;
    public static final int RATING_HEART = 1;
    public static final int RATING_NONE = 0;
    private static final float RATING_NOT_RATED = -1.0f;
    public static final int RATING_PERCENTAGE = 6;
    public static final int RATING_THUMB_UP_DOWN = 2;
    private static final String TAG = "Rating";
    private Object mRatingObj;
    private final int mRatingStyle;
    private final float mRatingValue;

    static {
        RatingCompat.CREATOR = new Parcelable.Creator() {
            public RatingCompat createFromParcel(Parcel parcel0) {
                return new RatingCompat(parcel0.readInt(), parcel0.readFloat());
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public RatingCompat[] newArray(int v) {
                return new RatingCompat[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    RatingCompat(int v, float f) {
        this.mRatingStyle = v;
        this.mRatingValue = f;
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return this.mRatingStyle;
    }

    public static RatingCompat fromRating(Object object0) {
        RatingCompat ratingCompat0 = null;
        if(object0 != null) {
            int v = ((Rating)object0).getRatingStyle();
            if(((Rating)object0).isRated()) {
                switch(v) {
                    case 1: {
                        ratingCompat0 = RatingCompat.newHeartRating(((Rating)object0).hasHeart());
                        break;
                    }
                    case 2: {
                        ratingCompat0 = RatingCompat.newThumbRating(((Rating)object0).isThumbUp());
                        break;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        ratingCompat0 = RatingCompat.newStarRating(v, ((Rating)object0).getStarRating());
                        break;
                    }
                    case 6: {
                        ratingCompat0 = RatingCompat.newPercentageRating(((Rating)object0).getPercentRating());
                        break;
                    }
                    default: {
                        return null;
                    }
                }
            }
            else {
                ratingCompat0 = RatingCompat.newUnratedRating(v);
            }
            ratingCompat0.mRatingObj = object0;
        }
        return ratingCompat0;
    }

    public float getPercentRating() {
        return this.mRatingStyle != 6 || !this.isRated() ? -1.0f : this.mRatingValue;
    }

    public Object getRating() {
        if(this.mRatingObj == null) {
            if(this.isRated()) {
                int v = this.mRatingStyle;
                switch(v) {
                    case 1: {
                        this.mRatingObj = Rating.newHeartRating(this.hasHeart());
                        return this.mRatingObj;
                    }
                    case 2: {
                        this.mRatingObj = Rating.newThumbRating(this.isThumbUp());
                        return this.mRatingObj;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        this.mRatingObj = Rating.newStarRating(v, this.getStarRating());
                        return this.mRatingObj;
                    }
                    case 6: {
                        this.mRatingObj = Rating.newPercentageRating(this.getPercentRating());
                        return this.mRatingObj;
                    }
                    default: {
                        return null;
                    }
                }
            }
            this.mRatingObj = Rating.newUnratedRating(this.mRatingStyle);
        }
        return this.mRatingObj;
    }

    public int getRatingStyle() {
        return this.mRatingStyle;
    }

    public float getStarRating() {
        return this.mRatingStyle != 3 && this.mRatingStyle != 4 && this.mRatingStyle != 5 || !this.isRated() ? -1.0f : this.mRatingValue;
    }

    public boolean hasHeart() {
        return this.mRatingStyle == 1 ? this.mRatingValue == 1.0f : false;
    }

    public boolean isRated() {
        return this.mRatingValue >= 0.0f;
    }

    public boolean isThumbUp() {
        return this.mRatingStyle == 2 ? this.mRatingValue == 1.0f : false;
    }

    // 去混淆评级： 低(20)
    public static RatingCompat newHeartRating(boolean z) {
        return z ? new RatingCompat(1, 1.0f) : new RatingCompat(1, 0.0f);
    }

    public static RatingCompat newPercentageRating(float f) {
        if(f >= 0.0f && f <= 100.0f) {
            return new RatingCompat(6, f);
        }
        Log.e("Rating", "Invalid percentage-based rating value");
        return null;
    }

    public static RatingCompat newStarRating(int v, float f) {
        float f1;
        switch(v) {
            case 3: {
                f1 = 3.0f;
                break;
            }
            case 4: {
                f1 = 4.0f;
                break;
            }
            case 5: {
                f1 = 5.0f;
                break;
            }
            default: {
                Log.e("Rating", "Invalid rating style (" + v + ") for a star rating");
                return null;
            }
        }
        if(f >= 0.0f && f <= f1) {
            return new RatingCompat(v, f);
        }
        Log.e("Rating", "Trying to set out of range star-based rating");
        return null;
    }

    // 去混淆评级： 低(20)
    public static RatingCompat newThumbRating(boolean z) {
        return z ? new RatingCompat(2, 1.0f) : new RatingCompat(2, 0.0f);
    }

    public static RatingCompat newUnratedRating(int v) {
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                return new RatingCompat(v, -1.0f);
            }
            default: {
                return null;
            }
        }
    }

    @Override
    public String toString() {
        return "Rating:style=" + this.mRatingStyle + " rating=" + (this.mRatingValue < 0.0f ? "unrated" : String.valueOf(this.mRatingValue));
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.mRatingStyle);
        parcel0.writeFloat(this.mRatingValue);
    }
}

