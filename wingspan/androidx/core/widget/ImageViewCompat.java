package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

public class ImageViewCompat {
    static class Api21Impl {
        static ColorStateList getImageTintList(ImageView imageView0) {
            return imageView0.getImageTintList();
        }

        static PorterDuff.Mode getImageTintMode(ImageView imageView0) {
            return imageView0.getImageTintMode();
        }

        static void setImageTintList(ImageView imageView0, ColorStateList colorStateList0) {
            imageView0.setImageTintList(colorStateList0);
        }

        static void setImageTintMode(ImageView imageView0, PorterDuff.Mode porterDuff$Mode0) {
            imageView0.setImageTintMode(porterDuff$Mode0);
        }
    }

    public static ColorStateList getImageTintList(ImageView imageView0) {
        return Api21Impl.getImageTintList(imageView0);
    }

    public static PorterDuff.Mode getImageTintMode(ImageView imageView0) {
        return Api21Impl.getImageTintMode(imageView0);
    }

    public static void setImageTintList(ImageView imageView0, ColorStateList colorStateList0) {
        Api21Impl.setImageTintList(imageView0, colorStateList0);
    }

    public static void setImageTintMode(ImageView imageView0, PorterDuff.Mode porterDuff$Mode0) {
        Api21Impl.setImageTintMode(imageView0, porterDuff$Mode0);
    }
}

