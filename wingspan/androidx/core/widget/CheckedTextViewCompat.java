package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CheckedTextView;
import java.lang.reflect.Field;

public final class CheckedTextViewCompat {
    static class Api14Impl {
        private static Field sCheckMarkDrawableField;
        private static boolean sResolved;

        static Drawable getCheckMarkDrawable(CheckedTextView checkedTextView0) {
            if(!Api14Impl.sResolved) {
                try {
                    Field field0 = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                    Api14Impl.sCheckMarkDrawableField = field0;
                    field0.setAccessible(true);
                }
                catch(NoSuchFieldException noSuchFieldException0) {
                    Log.i("CheckedTextViewCompat", "Failed to retrieve mCheckMarkDrawable field", noSuchFieldException0);
                }
                Api14Impl.sResolved = true;
            }
            Field field1 = Api14Impl.sCheckMarkDrawableField;
            if(field1 != null) {
                try {
                    return (Drawable)field1.get(checkedTextView0);
                }
                catch(IllegalAccessException illegalAccessException0) {
                    Log.i("CheckedTextViewCompat", "Failed to get check mark drawable via reflection", illegalAccessException0);
                    Api14Impl.sCheckMarkDrawableField = null;
                }
            }
            return null;
        }
    }

    static class Api16Impl {
        static Drawable getCheckMarkDrawable(CheckedTextView checkedTextView0) {
            return checkedTextView0.getCheckMarkDrawable();
        }
    }

    static class Api21Impl {
        static ColorStateList getCheckMarkTintList(CheckedTextView checkedTextView0) {
            return checkedTextView0.getCheckMarkTintList();
        }

        static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView checkedTextView0) {
            return checkedTextView0.getCheckMarkTintMode();
        }

        static void setCheckMarkTintList(CheckedTextView checkedTextView0, ColorStateList colorStateList0) {
            checkedTextView0.setCheckMarkTintList(colorStateList0);
        }

        static void setCheckMarkTintMode(CheckedTextView checkedTextView0, PorterDuff.Mode porterDuff$Mode0) {
            checkedTextView0.setCheckMarkTintMode(porterDuff$Mode0);
        }
    }

    private static final String TAG = "CheckedTextViewCompat";

    public static Drawable getCheckMarkDrawable(CheckedTextView checkedTextView0) {
        return Api16Impl.getCheckMarkDrawable(checkedTextView0);
    }

    public static ColorStateList getCheckMarkTintList(CheckedTextView checkedTextView0) {
        return Api21Impl.getCheckMarkTintList(checkedTextView0);
    }

    public static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView checkedTextView0) {
        return Api21Impl.getCheckMarkTintMode(checkedTextView0);
    }

    public static void setCheckMarkTintList(CheckedTextView checkedTextView0, ColorStateList colorStateList0) {
        Api21Impl.setCheckMarkTintList(checkedTextView0, colorStateList0);
    }

    public static void setCheckMarkTintMode(CheckedTextView checkedTextView0, PorterDuff.Mode porterDuff$Mode0) {
        Api21Impl.setCheckMarkTintMode(checkedTextView0, porterDuff$Mode0);
    }
}

