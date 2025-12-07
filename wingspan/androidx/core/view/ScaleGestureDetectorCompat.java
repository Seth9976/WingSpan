package androidx.core.view;

import android.view.ScaleGestureDetector;

public final class ScaleGestureDetectorCompat {
    static class Api19Impl {
        static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector0) {
            return scaleGestureDetector0.isQuickScaleEnabled();
        }

        static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector0, boolean z) {
            scaleGestureDetector0.setQuickScaleEnabled(z);
        }
    }

    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector0) {
        return Api19Impl.isQuickScaleEnabled(scaleGestureDetector0);
    }

    @Deprecated
    public static boolean isQuickScaleEnabled(Object object0) {
        return ScaleGestureDetectorCompat.isQuickScaleEnabled(((ScaleGestureDetector)object0));
    }

    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector0, boolean z) {
        Api19Impl.setQuickScaleEnabled(scaleGestureDetector0, z);
    }

    @Deprecated
    public static void setQuickScaleEnabled(Object object0, boolean z) {
        ScaleGestureDetectorCompat.setQuickScaleEnabled(((ScaleGestureDetector)object0), z);
    }
}

