package androidx.core.widget;

import android.widget.ListView;

public final class ListViewCompat {
    static class Api19Impl {
        static boolean canScrollList(ListView listView0, int v) {
            return listView0.canScrollList(v);
        }

        static void scrollListBy(ListView listView0, int v) {
            listView0.scrollListBy(v);
        }
    }

    public static boolean canScrollList(ListView listView0, int v) {
        return Api19Impl.canScrollList(listView0, v);
    }

    public static void scrollListBy(ListView listView0, int v) {
        Api19Impl.scrollListBy(listView0, v);
    }
}

