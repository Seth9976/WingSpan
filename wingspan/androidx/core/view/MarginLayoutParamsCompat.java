package androidx.core.view;

import android.view.ViewGroup.MarginLayoutParams;

public final class MarginLayoutParamsCompat {
    static class Api17Impl {
        static int getLayoutDirection(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            return viewGroup$MarginLayoutParams0.getLayoutDirection();
        }

        static int getMarginEnd(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            return viewGroup$MarginLayoutParams0.getMarginEnd();
        }

        static int getMarginStart(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            return viewGroup$MarginLayoutParams0.getMarginStart();
        }

        static boolean isMarginRelative(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
            return viewGroup$MarginLayoutParams0.isMarginRelative();
        }

        static void resolveLayoutDirection(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
            viewGroup$MarginLayoutParams0.resolveLayoutDirection(v);
        }

        static void setLayoutDirection(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
            viewGroup$MarginLayoutParams0.setLayoutDirection(v);
        }

        static void setMarginEnd(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
            viewGroup$MarginLayoutParams0.setMarginEnd(v);
        }

        static void setMarginStart(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
            viewGroup$MarginLayoutParams0.setMarginStart(v);
        }
    }

    public static int getLayoutDirection(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
        int v = Api17Impl.getLayoutDirection(viewGroup$MarginLayoutParams0);
        return v == 0 || v == 1 ? v : 0;
    }

    public static int getMarginEnd(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
        return Api17Impl.getMarginEnd(viewGroup$MarginLayoutParams0);
    }

    public static int getMarginStart(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
        return Api17Impl.getMarginStart(viewGroup$MarginLayoutParams0);
    }

    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0) {
        return Api17Impl.isMarginRelative(viewGroup$MarginLayoutParams0);
    }

    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
        Api17Impl.resolveLayoutDirection(viewGroup$MarginLayoutParams0, v);
    }

    public static void setLayoutDirection(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
        Api17Impl.setLayoutDirection(viewGroup$MarginLayoutParams0, v);
    }

    public static void setMarginEnd(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
        Api17Impl.setMarginEnd(viewGroup$MarginLayoutParams0, v);
    }

    public static void setMarginStart(ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0, int v) {
        Api17Impl.setMarginStart(viewGroup$MarginLayoutParams0, v);
    }
}

