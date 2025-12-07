package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import java.util.WeakHashMap;

public final class DisplayManagerCompat {
    static class Api17Impl {
        static Display getDisplay(DisplayManager displayManager0, int v) {
            return displayManager0.getDisplay(v);
        }

        static Display[] getDisplays(DisplayManager displayManager0) {
            return displayManager0.getDisplays();
        }
    }

    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
    private final Context mContext;
    private static final WeakHashMap sInstances;

    static {
        DisplayManagerCompat.sInstances = new WeakHashMap();
    }

    private DisplayManagerCompat(Context context0) {
        this.mContext = context0;
    }

    public Display getDisplay(int v) {
        return Api17Impl.getDisplay(((DisplayManager)this.mContext.getSystemService("display")), v);
    }

    public Display[] getDisplays() {
        return Api17Impl.getDisplays(((DisplayManager)this.mContext.getSystemService("display")));
    }

    public Display[] getDisplays(String s) {
        return Api17Impl.getDisplays(((DisplayManager)this.mContext.getSystemService("display")));
    }

    public static DisplayManagerCompat getInstance(Context context0) {
        WeakHashMap weakHashMap0 = DisplayManagerCompat.sInstances;
        synchronized(weakHashMap0) {
            DisplayManagerCompat displayManagerCompat0 = (DisplayManagerCompat)weakHashMap0.get(context0);
            if(displayManagerCompat0 == null) {
                displayManagerCompat0 = new DisplayManagerCompat(context0);
                weakHashMap0.put(context0, displayManagerCompat0);
            }
            return displayManagerCompat0;
        }
    }
}

