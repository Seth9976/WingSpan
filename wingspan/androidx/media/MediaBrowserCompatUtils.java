package androidx.media;

import android.os.Bundle;

public class MediaBrowserCompatUtils {
    public static boolean areSameOptions(Bundle bundle0, Bundle bundle1) {
        if(bundle0 == bundle1) {
            return true;
        }
        if(bundle0 == null) {
            return bundle1.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1;
        }
        return bundle1 == null ? bundle0.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle0.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1 : bundle0.getInt("android.media.browse.extra.PAGE", -1) == bundle1.getInt("android.media.browse.extra.PAGE", -1) && bundle0.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    }

    public static boolean hasDuplicatedItems(Bundle bundle0, Bundle bundle1) {
        int v = bundle0 == null ? -1 : bundle0.getInt("android.media.browse.extra.PAGE", -1);
        int v1 = bundle1 == null ? -1 : bundle1.getInt("android.media.browse.extra.PAGE", -1);
        int v2 = bundle0 == null ? -1 : bundle0.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        int v3 = bundle1 == null ? -1 : bundle1.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        if(v != -1 && v2 != -1) {
            int v4 = v * v2;
            int v5 = v2 + v4 - 1;
            return v1 == -1 || v3 == -1 ? v5 >= 0 && 0x7FFFFFFF >= v4 : v5 >= v1 * v3 && v3 + v1 * v3 - 1 >= v4;
        }
        return v1 == -1 || v3 == -1 ? true : 0x7FFFFFFF >= v1 * v3 && v3 + v1 * v3 - 1 >= 0;
    }
}

