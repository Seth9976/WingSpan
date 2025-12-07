package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat {
    static class Api19Impl {
        static int getAlpha(Drawable drawable0) {
            return drawable0.getAlpha();
        }

        static Drawable getChild(DrawableContainer.DrawableContainerState drawableContainer$DrawableContainerState0, int v) {
            return drawableContainer$DrawableContainerState0.getChild(v);
        }

        static Drawable getDrawable(InsetDrawable insetDrawable0) {
            return insetDrawable0.getDrawable();
        }

        static boolean isAutoMirrored(Drawable drawable0) {
            return drawable0.isAutoMirrored();
        }

        static void setAutoMirrored(Drawable drawable0, boolean z) {
            drawable0.setAutoMirrored(z);
        }
    }

    static class Api21Impl {
        static void applyTheme(Drawable drawable0, Resources.Theme resources$Theme0) {
            drawable0.applyTheme(resources$Theme0);
        }

        static boolean canApplyTheme(Drawable drawable0) {
            return drawable0.canApplyTheme();
        }

        static ColorFilter getColorFilter(Drawable drawable0) {
            return drawable0.getColorFilter();
        }

        static void inflate(Drawable drawable0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) throws XmlPullParserException, IOException {
            drawable0.inflate(resources0, xmlPullParser0, attributeSet0, resources$Theme0);
        }

        static void setHotspot(Drawable drawable0, float f, float f1) {
            drawable0.setHotspot(f, f1);
        }

        static void setHotspotBounds(Drawable drawable0, int v, int v1, int v2, int v3) {
            drawable0.setHotspotBounds(v, v1, v2, v3);
        }

        static void setTint(Drawable drawable0, int v) {
            drawable0.setTint(v);
        }

        static void setTintList(Drawable drawable0, ColorStateList colorStateList0) {
            drawable0.setTintList(colorStateList0);
        }

        static void setTintMode(Drawable drawable0, PorterDuff.Mode porterDuff$Mode0) {
            drawable0.setTintMode(porterDuff$Mode0);
        }
    }

    static class Api23Impl {
        static int getLayoutDirection(Drawable drawable0) {
            return drawable0.getLayoutDirection();
        }

        static boolean setLayoutDirection(Drawable drawable0, int v) {
            return drawable0.setLayoutDirection(v);
        }
    }

    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    public static void applyTheme(Drawable drawable0, Resources.Theme resources$Theme0) {
        Api21Impl.applyTheme(drawable0, resources$Theme0);
    }

    public static boolean canApplyTheme(Drawable drawable0) {
        return Api21Impl.canApplyTheme(drawable0);
    }

    public static void clearColorFilter(Drawable drawable0) {
        drawable0.clearColorFilter();
    }

    public static int getAlpha(Drawable drawable0) {
        return Api19Impl.getAlpha(drawable0);
    }

    public static ColorFilter getColorFilter(Drawable drawable0) {
        return Api21Impl.getColorFilter(drawable0);
    }

    public static int getLayoutDirection(Drawable drawable0) {
        return Api23Impl.getLayoutDirection(drawable0);
    }

    public static void inflate(Drawable drawable0, Resources resources0, XmlPullParser xmlPullParser0, AttributeSet attributeSet0, Resources.Theme resources$Theme0) throws XmlPullParserException, IOException {
        Api21Impl.inflate(drawable0, resources0, xmlPullParser0, attributeSet0, resources$Theme0);
    }

    public static boolean isAutoMirrored(Drawable drawable0) {
        return Api19Impl.isAutoMirrored(drawable0);
    }

    @Deprecated
    public static void jumpToCurrentState(Drawable drawable0) {
        drawable0.jumpToCurrentState();
    }

    public static void setAutoMirrored(Drawable drawable0, boolean z) {
        Api19Impl.setAutoMirrored(drawable0, z);
    }

    public static void setHotspot(Drawable drawable0, float f, float f1) {
        Api21Impl.setHotspot(drawable0, f, f1);
    }

    public static void setHotspotBounds(Drawable drawable0, int v, int v1, int v2, int v3) {
        Api21Impl.setHotspotBounds(drawable0, v, v1, v2, v3);
    }

    public static boolean setLayoutDirection(Drawable drawable0, int v) {
        return Api23Impl.setLayoutDirection(drawable0, v);
    }

    public static void setTint(Drawable drawable0, int v) {
        Api21Impl.setTint(drawable0, v);
    }

    public static void setTintList(Drawable drawable0, ColorStateList colorStateList0) {
        Api21Impl.setTintList(drawable0, colorStateList0);
    }

    public static void setTintMode(Drawable drawable0, PorterDuff.Mode porterDuff$Mode0) {
        Api21Impl.setTintMode(drawable0, porterDuff$Mode0);
    }

    // 去混淆评级： 低(20)
    public static Drawable unwrap(Drawable drawable0) {
        return drawable0 instanceof WrappedDrawable ? ((WrappedDrawable)drawable0).getWrappedDrawable() : drawable0;
    }

    public static Drawable wrap(Drawable drawable0) [...] // Inlined contents
}

