package androidx.core.graphics.drawable;

import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u001A*\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\b\b\u0003\u0010\u0003\u001A\u00020\u00042\b\b\u0003\u0010\u0005\u001A\u00020\u00042\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0007\u001A2\u0010\b\u001A\u00020\t*\u00020\u00022\b\b\u0003\u0010\n\u001A\u00020\u00042\b\b\u0003\u0010\u000B\u001A\u00020\u00042\b\b\u0003\u0010\f\u001A\u00020\u00042\b\b\u0003\u0010\r\u001A\u00020\u0004¨\u0006\u000E"}, d2 = {"toBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "updateBounds", "", "left", "top", "right", "bottom", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable drawable0, int v, int v1, Bitmap.Config bitmap$Config0) {
        Intrinsics.checkParameterIsNotNull(drawable0, "$this$toBitmap");
        if(drawable0 instanceof BitmapDrawable) {
            if(bitmap$Config0 == null) {
                goto label_6;
            }
            Bitmap bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
            Intrinsics.checkExpressionValueIsNotNull(bitmap0, "bitmap");
            if(bitmap0.getConfig() == bitmap$Config0) {
            label_6:
                if(v == ((BitmapDrawable)drawable0).getIntrinsicWidth() && v1 == ((BitmapDrawable)drawable0).getIntrinsicHeight()) {
                    Bitmap bitmap1 = ((BitmapDrawable)drawable0).getBitmap();
                    Intrinsics.checkExpressionValueIsNotNull(bitmap1, "bitmap");
                    return bitmap1;
                }
                Bitmap bitmap2 = Bitmap.createScaledBitmap(((BitmapDrawable)drawable0).getBitmap(), v, v1, true);
                Intrinsics.checkExpressionValueIsNotNull(bitmap2, "Bitmap.createScaledBitma…map, width, height, true)");
                return bitmap2;
            }
        }
        Rect rect0 = drawable0.getBounds();
        int v2 = rect0.left;
        int v3 = rect0.top;
        int v4 = rect0.right;
        int v5 = rect0.bottom;
        if(bitmap$Config0 == null) {
            bitmap$Config0 = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmap3 = Bitmap.createBitmap(v, v1, bitmap$Config0);
        drawable0.setBounds(0, 0, v, v1);
        drawable0.draw(new Canvas(bitmap3));
        drawable0.setBounds(v2, v3, v4, v5);
        Intrinsics.checkExpressionValueIsNotNull(bitmap3, "bitmap");
        return bitmap3;
    }

    public static Bitmap toBitmap$default(Drawable drawable0, int v, int v1, Bitmap.Config bitmap$Config0, int v2, Object object0) {
        if((v2 & 1) != 0) {
            v = drawable0.getIntrinsicWidth();
        }
        if((v2 & 2) != 0) {
            v1 = drawable0.getIntrinsicHeight();
        }
        if((v2 & 4) != 0) {
            bitmap$Config0 = null;
        }
        return DrawableKt.toBitmap(drawable0, v, v1, bitmap$Config0);
    }

    public static final void updateBounds(Drawable drawable0, int v, int v1, int v2, int v3) {
        Intrinsics.checkParameterIsNotNull(drawable0, "$this$updateBounds");
        drawable0.setBounds(v, v1, v2, v3);
    }

    public static void updateBounds$default(Drawable drawable0, int v, int v1, int v2, int v3, int v4, Object object0) {
        if((v4 & 1) != 0) {
            v = drawable0.getBounds().left;
        }
        if((v4 & 2) != 0) {
            v1 = drawable0.getBounds().top;
        }
        if((v4 & 4) != 0) {
            v2 = drawable0.getBounds().right;
        }
        if((v4 & 8) != 0) {
            v3 = drawable0.getBounds().bottom;
        }
        DrawableKt.updateBounds(drawable0, v, v1, v2, v3);
    }
}

