package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;

public final class AppCompatResources {
    static class ColorStateListCacheEntry {
        final Configuration configuration;
        final ColorStateList value;

        ColorStateListCacheEntry(ColorStateList colorStateList0, Configuration configuration0) {
            this.value = colorStateList0;
            this.configuration = configuration0;
        }
    }

    private static final String LOG_TAG = "AppCompatResources";
    private static final ThreadLocal TL_TYPED_VALUE;
    private static final Object sColorStateCacheLock;
    private static final WeakHashMap sColorStateCaches;

    static {
        AppCompatResources.TL_TYPED_VALUE = new ThreadLocal();
        AppCompatResources.sColorStateCaches = new WeakHashMap(0);
        AppCompatResources.sColorStateCacheLock = new Object();
    }

    private static void addColorStateListToCache(Context context0, int v, ColorStateList colorStateList0) {
        synchronized(AppCompatResources.sColorStateCacheLock) {
            WeakHashMap weakHashMap0 = AppCompatResources.sColorStateCaches;
            SparseArray sparseArray0 = (SparseArray)weakHashMap0.get(context0);
            if(sparseArray0 == null) {
                sparseArray0 = new SparseArray();
                weakHashMap0.put(context0, sparseArray0);
            }
            sparseArray0.append(v, new ColorStateListCacheEntry(colorStateList0, context0.getResources().getConfiguration()));
        }
    }

    private static ColorStateList getCachedColorStateList(Context context0, int v) {
        synchronized(AppCompatResources.sColorStateCacheLock) {
            SparseArray sparseArray0 = (SparseArray)AppCompatResources.sColorStateCaches.get(context0);
            if(sparseArray0 != null && sparseArray0.size() > 0) {
                ColorStateListCacheEntry appCompatResources$ColorStateListCacheEntry0 = (ColorStateListCacheEntry)sparseArray0.get(v);
                if(appCompatResources$ColorStateListCacheEntry0 != null) {
                    Configuration configuration0 = context0.getResources().getConfiguration();
                    if(appCompatResources$ColorStateListCacheEntry0.configuration.equals(configuration0)) {
                        return appCompatResources$ColorStateListCacheEntry0.value;
                    }
                    sparseArray0.remove(v);
                }
            }
            return null;
        }
    }

    public static ColorStateList getColorStateList(Context context0, int v) {
        return context0.getColorStateList(v);
    }

    public static Drawable getDrawable(Context context0, int v) {
        return ResourceManagerInternal.get().getDrawable(context0, v);
    }

    private static TypedValue getTypedValue() {
        ThreadLocal threadLocal0 = AppCompatResources.TL_TYPED_VALUE;
        TypedValue typedValue0 = (TypedValue)threadLocal0.get();
        if(typedValue0 == null) {
            typedValue0 = new TypedValue();
            threadLocal0.set(typedValue0);
        }
        return typedValue0;
    }

    private static ColorStateList inflateColorStateList(Context context0, int v) {
        if(AppCompatResources.isColorInt(context0, v)) {
            return null;
        }
        Resources resources0 = context0.getResources();
        XmlResourceParser xmlResourceParser0 = resources0.getXml(v);
        try {
            return ColorStateListInflaterCompat.createFromXml(resources0, xmlResourceParser0, context0.getTheme());
        }
        catch(Exception exception0) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", exception0);
            return null;
        }
    }

    private static boolean isColorInt(Context context0, int v) {
        Resources resources0 = context0.getResources();
        TypedValue typedValue0 = AppCompatResources.getTypedValue();
        resources0.getValue(v, typedValue0, true);
        return typedValue0.type >= 28 && typedValue0.type <= 0x1F;
    }
}

