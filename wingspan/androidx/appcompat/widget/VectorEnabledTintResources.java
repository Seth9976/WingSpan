package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

public class VectorEnabledTintResources extends Resources {
    public static final int MAX_SDK_WHERE_REQUIRED = 20;
    private final WeakReference mContextRef;
    private static boolean sCompatVectorFromResourcesEnabled;

    static {
    }

    public VectorEnabledTintResources(Context context0, Resources resources0) {
        super(resources0.getAssets(), resources0.getDisplayMetrics(), resources0.getConfiguration());
        this.mContextRef = new WeakReference(context0);
    }

    @Override  // android.content.res.Resources
    public Drawable getDrawable(int v) throws Resources.NotFoundException {
        Context context0 = (Context)this.mContextRef.get();
        return context0 == null ? super.getDrawable(v) : ResourceManagerInternal.get().onDrawableLoadedFromResources(context0, this, v);
    }

    public static boolean isCompatVectorFromResourcesEnabled() [...] // 潜在的解密器

    public static void setCompatVectorFromResourcesEnabled(boolean z) {
        VectorEnabledTintResources.sCompatVectorFromResourcesEnabled = z;
    }

    public static boolean shouldBeUsed() [...] // 潜在的解密器

    final Drawable superGetDrawable(int v) {
        return super.getDrawable(v);
    }
}

