package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;

public final class TextUtilsCompat {
    static class Api17Impl {
        static int getLayoutDirectionFromLocale(Locale locale0) {
            return TextUtils.getLayoutDirectionFromLocale(locale0);
        }
    }

    private static final String ARAB_SCRIPT_SUBTAG = "Arab";
    private static final String HEBR_SCRIPT_SUBTAG = "Hebr";
    private static final Locale ROOT;

    static {
        TextUtilsCompat.ROOT = new Locale("", "");
    }

    private static int getLayoutDirectionFromFirstChar(Locale locale0) {
        switch(Character.getDirectionality(locale0.getDisplayName(locale0).charAt(0))) {
            case 1: 
            case 2: {
                return 1;
            }
            default: {
                return 0;
            }
        }
    }

    public static int getLayoutDirectionFromLocale(Locale locale0) {
        return Api17Impl.getLayoutDirectionFromLocale(locale0);
    }

    public static String htmlEncode(String s) {
        return TextUtils.htmlEncode(s);
    }
}

