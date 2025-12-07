package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001A\r\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\b\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0002H\u0087\b\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0004H\u0087\b\u001A\r\u0010\u0003\u001A\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class IconKt {
    public static final Icon toAdaptiveIcon(Bitmap bitmap0) {
        Intrinsics.checkParameterIsNotNull(bitmap0, "$this$toAdaptiveIcon");
        Icon icon0 = Icon.createWithAdaptiveBitmap(bitmap0);
        Intrinsics.checkExpressionValueIsNotNull(icon0, "Icon.createWithAdaptiveBitmap(this)");
        return icon0;
    }

    public static final Icon toIcon(Bitmap bitmap0) {
        Intrinsics.checkParameterIsNotNull(bitmap0, "$this$toIcon");
        Icon icon0 = Icon.createWithBitmap(bitmap0);
        Intrinsics.checkExpressionValueIsNotNull(icon0, "Icon.createWithBitmap(this)");
        return icon0;
    }

    public static final Icon toIcon(Uri uri0) {
        Intrinsics.checkParameterIsNotNull(uri0, "$this$toIcon");
        Icon icon0 = Icon.createWithContentUri(uri0);
        Intrinsics.checkExpressionValueIsNotNull(icon0, "Icon.createWithContentUri(this)");
        return icon0;
    }

    public static final Icon toIcon(byte[] arr_b) {
        Intrinsics.checkParameterIsNotNull(arr_b, "$this$toIcon");
        Icon icon0 = Icon.createWithData(arr_b, 0, arr_b.length);
        Intrinsics.checkExpressionValueIsNotNull(icon0, "Icon.createWithData(this, 0, size)");
        return icon0;
    }
}

