package com.onesignal.common;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0010\u0010\n\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0002J\u000E\u0010\u000B\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tJ\u000E\u0010\f\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tJ\u0010\u0010\r\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0003J\u0010\u0010\u000E\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\tH\u0002J\u0010\u0010\u000F\u001A\u00020\u00102\u0006\u0010\b\u001A\u00020\tH\u0002J\u000E\u0010\u0011\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\t¨\u0006\u0012"}, d2 = {"Lcom/onesignal/common/ViewUtils;", "", "()V", "dpToPx", "", "dp", "getCutoutAndStatusBarInsets", "", "activity", "Landroid/app/Activity;", "getDisplaySizeY", "getFullbleedWindowWidth", "getWindowHeight", "getWindowHeightAPI23Plus", "getWindowHeightLollipop", "getWindowVisibleDisplayFrame", "Landroid/graphics/Rect;", "getWindowWidth", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ViewUtils {
    public static final ViewUtils INSTANCE;

    static {
        ViewUtils.INSTANCE = new ViewUtils();
    }

    public final int dpToPx(int v) {
        return (int)(((float)v) * Resources.getSystem().getDisplayMetrics().density);
    }

    public final int[] getCutoutAndStatusBarInsets(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Rect rect0 = this.getWindowVisibleDisplayFrame(activity0);
        View view0 = activity0.getWindow().findViewById(0x1020002);
        float f = ((float)(rect0.top - view0.getTop())) / Resources.getSystem().getDisplayMetrics().density;
        float f1 = ((float)(view0.getBottom() - rect0.bottom)) / Resources.getSystem().getDisplayMetrics().density;
        if(Build.VERSION.SDK_INT == 29) {
            DisplayCutout displayCutout0 = activity0.getWindowManager().getDefaultDisplay().getCutout();
            if(displayCutout0 != null) {
                float f2 = ((float)displayCutout0.getSafeInsetRight()) / Resources.getSystem().getDisplayMetrics().density;
                float f3 = ((float)displayCutout0.getSafeInsetLeft()) / Resources.getSystem().getDisplayMetrics().density;
                return new int[]{MathKt.roundToInt(f), MathKt.roundToInt(f1), MathKt.roundToInt(f2), MathKt.roundToInt(f3)};
            }
        }
        return new int[]{MathKt.roundToInt(f), MathKt.roundToInt(f1), MathKt.roundToInt(0.0f), MathKt.roundToInt(0.0f)};
    }

    private final int getDisplaySizeY(Activity activity0) {
        Point point0 = new Point();
        activity0.getWindowManager().getDefaultDisplay().getSize(point0);
        return point0.y;
    }

    public final int getFullbleedWindowWidth(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        View view0 = activity0.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(view0, "activity.window.decorView");
        return view0.getWidth();
    }

    public final int getWindowHeight(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        return this.getWindowHeightAPI23Plus(activity0);
    }

    private final int getWindowHeightAPI23Plus(Activity activity0) {
        View view0 = activity0.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(view0, "activity.window.decorView");
        WindowInsets windowInsets0 = view0.getRootWindowInsets();
        return windowInsets0 == null ? view0.getHeight() : view0.getHeight() - windowInsets0.getStableInsetBottom() - windowInsets0.getStableInsetTop();
    }

    private final int getWindowHeightLollipop(Activity activity0) {
        return activity0.getResources().getConfiguration().orientation == 2 ? this.getWindowVisibleDisplayFrame(activity0).height() : this.getDisplaySizeY(activity0);
    }

    private final Rect getWindowVisibleDisplayFrame(Activity activity0) {
        Rect rect0 = new Rect();
        activity0.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect0);
        return rect0;
    }

    public final int getWindowWidth(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        return this.getWindowVisibleDisplayFrame(activity0).width();
    }
}

