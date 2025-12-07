package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
    static class Api19Impl {
        static void showAsDropDown(PopupWindow popupWindow0, View view0, int v, int v1, int v2) {
            popupWindow0.showAsDropDown(view0, v, v1, v2);
        }
    }

    static class Api23Impl {
        static boolean getOverlapAnchor(PopupWindow popupWindow0) {
            return popupWindow0.getOverlapAnchor();
        }

        static int getWindowLayoutType(PopupWindow popupWindow0) {
            return popupWindow0.getWindowLayoutType();
        }

        static void setOverlapAnchor(PopupWindow popupWindow0, boolean z) {
            popupWindow0.setOverlapAnchor(z);
        }

        static void setWindowLayoutType(PopupWindow popupWindow0, int v) {
            popupWindow0.setWindowLayoutType(v);
        }
    }

    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    public static boolean getOverlapAnchor(PopupWindow popupWindow0) {
        return Api23Impl.getOverlapAnchor(popupWindow0);
    }

    public static int getWindowLayoutType(PopupWindow popupWindow0) {
        return Api23Impl.getWindowLayoutType(popupWindow0);
    }

    public static void setOverlapAnchor(PopupWindow popupWindow0, boolean z) {
        Api23Impl.setOverlapAnchor(popupWindow0, z);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow0, int v) {
        Api23Impl.setWindowLayoutType(popupWindow0, v);
    }

    public static void showAsDropDown(PopupWindow popupWindow0, View view0, int v, int v1, int v2) {
        Api19Impl.showAsDropDown(popupWindow0, view0, v, v1, v2);
    }
}

