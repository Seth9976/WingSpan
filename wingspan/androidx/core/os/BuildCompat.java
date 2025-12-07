package androidx.core.os;

import android.os.Build.VERSION;
import java.util.Locale;

public class BuildCompat {
    public @interface PrereleaseSdkCheck {
    }

    @Deprecated
    public static boolean isAtLeastN() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Deprecated
    public static boolean isAtLeastNMR1() {
        return Build.VERSION.SDK_INT >= 25;
    }

    @Deprecated
    public static boolean isAtLeastO() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @Deprecated
    public static boolean isAtLeastOMR1() {
        return Build.VERSION.SDK_INT >= 27;
    }

    @Deprecated
    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    // 去混淆评级： 低(20)
    protected static boolean isAtLeastPreReleaseCodename(String s, String s1) {
        return "REL".equals(s1) ? false : s1.toUpperCase(Locale.ROOT).compareTo(s.toUpperCase(Locale.ROOT)) >= 0;
    }

    @Deprecated
    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @Deprecated
    public static boolean isAtLeastR() [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    @Deprecated
    public static boolean isAtLeastS() {
        return Build.VERSION.SDK_INT >= 0x1F || Build.VERSION.SDK_INT >= 30 && BuildCompat.isAtLeastPreReleaseCodename("S", Build.VERSION.CODENAME);
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public static boolean isAtLeastSv2() {
        return Build.VERSION.SDK_INT >= 0x20 || Build.VERSION.SDK_INT >= 0x1F && BuildCompat.isAtLeastPreReleaseCodename("Sv2", Build.VERSION.CODENAME);
    }

    // 去混淆评级： 低(20)
    public static boolean isAtLeastT() {
        return Build.VERSION.SDK_INT >= 33 || Build.VERSION.SDK_INT >= 0x20 && BuildCompat.isAtLeastPreReleaseCodename("Tiramisu", Build.VERSION.CODENAME);
    }

    public static boolean isAtLeastU() {
        return Build.VERSION.SDK_INT >= 33 && BuildCompat.isAtLeastPreReleaseCodename("UpsideDownCake", Build.VERSION.CODENAME);
    }
}

