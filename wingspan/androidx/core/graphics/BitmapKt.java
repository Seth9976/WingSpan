package androidx.core.graphics;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace.Named;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001A#\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006H\u0086\b\u001A7\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u00062\b\b\u0002\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\nH\u0087\b\u001A&\u0010\u000B\u001A\u00020\u0001*\u00020\u00012\u0017\u0010\f\u001A\u0013\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000F0\r¢\u0006\u0002\b\u0010H\u0086\b\u001A\u0015\u0010\u0011\u001A\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u0013H\u0086\n\u001A\u0015\u0010\u0011\u001A\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001A\u00020\u0014H\u0086\n\u001A\u001D\u0010\u0015\u001A\u00020\u0003*\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u0003H\u0086\n\u001A\'\u0010\u0018\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0019\u001A\u00020\bH\u0086\b\u001A\'\u0010\u001A\u001A\u00020\u000F*\u00020\u00012\u0006\u0010\u0016\u001A\u00020\u00032\u0006\u0010\u0017\u001A\u00020\u00032\b\b\u0001\u0010\u001B\u001A\u00020\u0003H\u0086\n¨\u0006\u001C"}, d2 = {"createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "contains", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "get", "x", "y", "scale", "filter", "set", "color", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap0, Function1 function10) {
        Intrinsics.checkParameterIsNotNull(bitmap0, "$this$applyCanvas");
        Intrinsics.checkParameterIsNotNull(function10, "block");
        function10.invoke(new Canvas(bitmap0));
        return bitmap0;
    }

    public static final boolean contains(Bitmap bitmap0, Point point0) {
        Intrinsics.checkParameterIsNotNull(bitmap0, "$this$contains");
        Intrinsics.checkParameterIsNotNull(point0, "p");
        return point0.x >= 0 && point0.x < bitmap0.getWidth() && point0.y >= 0 && point0.y < bitmap0.getHeight();
    }

    public static final boolean contains(Bitmap bitmap0, PointF pointF0) {
        Intrinsics.checkParameterIsNotNull(bitmap0, "$this$contains");
        Intrinsics.checkParameterIsNotNull(pointF0, "p");
        return pointF0.x >= 0.0f && pointF0.x < ((float)bitmap0.getWidth()) && pointF0.y >= 0.0f && pointF0.y < ((float)bitmap0.getHeight());
    }

    public static final Bitmap createBitmap(int v, int v1, Bitmap.Config bitmap$Config0) {
        Intrinsics.checkParameterIsNotNull(bitmap$Config0, "config");
        Bitmap bitmap0 = Bitmap.createBitmap(v, v1, bitmap$Config0);
        Intrinsics.checkExpressionValueIsNotNull(bitmap0, "Bitmap.createBitmap(width, height, config)");
        return bitmap0;
    }

    public static final Bitmap createBitmap(int v, int v1, Bitmap.Config bitmap$Config0, boolean z, ColorSpace colorSpace0) {
        Intrinsics.checkParameterIsNotNull(bitmap$Config0, "config");
        Intrinsics.checkParameterIsNotNull(colorSpace0, "colorSpace");
        Bitmap bitmap0 = Bitmap.createBitmap(v, v1, bitmap$Config0, z, colorSpace0);
        Intrinsics.checkExpressionValueIsNotNull(bitmap0, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return bitmap0;
    }

    public static Bitmap createBitmap$default(int v, int v1, Bitmap.Config bitmap$Config0, int v2, Object object0) {
        if((v2 & 4) != 0) {
            bitmap$Config0 = Bitmap.Config.ARGB_8888;
        }
        Intrinsics.checkParameterIsNotNull(bitmap$Config0, "config");
        Bitmap bitmap0 = Bitmap.createBitmap(v, v1, bitmap$Config0);
        Intrinsics.checkExpressionValueIsNotNull(bitmap0, "Bitmap.createBitmap(width, height, config)");
        return bitmap0;
    }

    public static Bitmap createBitmap$default(int v, int v1, Bitmap.Config bitmap$Config0, boolean z, ColorSpace colorSpace0, int v2, Object object0) {
        if((v2 & 4) != 0) {
            bitmap$Config0 = Bitmap.Config.ARGB_8888;
        }
        if((v2 & 8) != 0) {
            z = true;
        }
        if((v2 & 16) != 0) {
            colorSpace0 = ColorSpace.get(ColorSpace.Named.SRGB);
            Intrinsics.checkExpressionValueIsNotNull(colorSpace0, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        Intrinsics.checkParameterIsNotNull(bitmap$Config0, "config");
        Intrinsics.checkParameterIsNotNull(colorSpace0, "colorSpace");
        Bitmap bitmap0 = Bitmap.createBitmap(v, v1, bitmap$Config0, z, colorSpace0);
        Intrinsics.checkExpressionValueIsNotNull(bitmap0, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return bitmap0;
    }

    public static final int get(Bitmap bitmap0, int v, int v1) {
        Intrinsics.checkParameterIsNotNull(bitmap0, "$this$get");
        return bitmap0.getPixel(v, v1);
    }

    public static final Bitmap scale(Bitmap bitmap0, int v, int v1, boolean z) {
        Intrinsics.checkParameterIsNotNull(bitmap0, "$this$scale");
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap0, v, v1, z);
        Intrinsics.checkExpressionValueIsNotNull(bitmap1, "Bitmap.createScaledBitma…s, width, height, filter)");
        return bitmap1;
    }

    public static Bitmap scale$default(Bitmap bitmap0, int v, int v1, boolean z, int v2, Object object0) {
        if((v2 & 4) != 0) {
            z = true;
        }
        Intrinsics.checkParameterIsNotNull(bitmap0, "$this$scale");
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap0, v, v1, z);
        Intrinsics.checkExpressionValueIsNotNull(bitmap1, "Bitmap.createScaledBitma…s, width, height, filter)");
        return bitmap1;
    }

    public static final void set(Bitmap bitmap0, int v, int v1, int v2) {
        Intrinsics.checkParameterIsNotNull(bitmap0, "$this$set");
        bitmap0.setPixel(v, v1, v2);
    }
}

