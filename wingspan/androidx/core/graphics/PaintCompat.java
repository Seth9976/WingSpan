package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build.VERSION;
import androidx.core.util.Pair;

public final class PaintCompat {
    static class Api23Impl {
        static boolean hasGlyph(Paint paint0, String s) {
            return paint0.hasGlyph(s);
        }
    }

    static class Api29Impl {
        static void setBlendMode(Paint paint0, Object object0) {
            paint0.setBlendMode(((BlendMode)object0));
        }
    }

    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\uDB3F\uDFFD";
    private static final ThreadLocal sRectThreadLocal;

    static {
        PaintCompat.sRectThreadLocal = new ThreadLocal();
    }

    public static boolean hasGlyph(Paint paint0, String s) {
        return Api23Impl.hasGlyph(paint0, s);
    }

    private static Pair obtainEmptyRects() {
        ThreadLocal threadLocal0 = PaintCompat.sRectThreadLocal;
        Pair pair0 = (Pair)threadLocal0.get();
        if(pair0 == null) {
            pair0 = new Pair(new Rect(), new Rect());
            threadLocal0.set(pair0);
            return pair0;
        }
        ((Rect)pair0.first).setEmpty();
        ((Rect)pair0.second).setEmpty();
        return pair0;
    }

    public static boolean setBlendMode(Paint paint0, BlendModeCompat blendModeCompat0) {
        PorterDuffXfermode porterDuffXfermode0 = null;
        if(Build.VERSION.SDK_INT >= 29) {
            if(blendModeCompat0 != null) {
                porterDuffXfermode0 = androidx.core.graphics.BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(blendModeCompat0);
            }
            Api29Impl.setBlendMode(paint0, porterDuffXfermode0);
            return true;
        }
        if(blendModeCompat0 != null) {
            PorterDuff.Mode porterDuff$Mode0 = BlendModeUtils.obtainPorterDuffFromCompat(blendModeCompat0);
            if(porterDuff$Mode0 != null) {
                porterDuffXfermode0 = new PorterDuffXfermode(porterDuff$Mode0);
            }
            paint0.setXfermode(porterDuffXfermode0);
            return porterDuff$Mode0 != null;
        }
        paint0.setXfermode(null);
        return true;
    }
}

