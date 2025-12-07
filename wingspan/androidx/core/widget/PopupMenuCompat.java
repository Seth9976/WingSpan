package androidx.core.widget;

import android.view.View.OnTouchListener;
import android.widget.PopupMenu;

public final class PopupMenuCompat {
    static class Api19Impl {
        static View.OnTouchListener getDragToOpenListener(PopupMenu popupMenu0) {
            return popupMenu0.getDragToOpenListener();
        }
    }

    public static View.OnTouchListener getDragToOpenListener(Object object0) {
        return Api19Impl.getDragToOpenListener(((PopupMenu)object0));
    }
}

