package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.LocaleList;
import java.util.Locale;

public final class ConfigurationCompat {
    static class Api24Impl {
        static LocaleList getLocales(Configuration configuration0) {
            return configuration0.getLocales();
        }
    }

    public static LocaleListCompat getLocales(Configuration configuration0) {
        return Build.VERSION.SDK_INT < 24 ? LocaleListCompat.create(new Locale[]{configuration0.locale}) : LocaleListCompat.wrap(Api24Impl.getLocales(configuration0));
    }
}

