package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder.ImageInfo;
import android.graphics.ImageDecoder.OnHeaderDecodedListener;
import android.graphics.ImageDecoder.Source;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001AR\u0010\u0000\u001A\u00020\u0001*\u00020\u00022C\b\u0004\u0010\u0003\u001A=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B0\u0004¢\u0006\u0002\b\fH\u0087\b\u001AR\u0010\r\u001A\u00020\u000E*\u00020\u00022C\b\u0004\u0010\u0003\u001A=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000B0\u0004¢\u0006\u0002\b\fH\u0087\b¨\u0006\u000F"}, d2 = {"decodeBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/ImageDecoder$Source;", "action", "Lkotlin/Function3;", "Landroid/graphics/ImageDecoder;", "Landroid/graphics/ImageDecoder$ImageInfo;", "Lkotlin/ParameterName;", "name", "info", "source", "", "Lkotlin/ExtensionFunctionType;", "decodeDrawable", "Landroid/graphics/drawable/Drawable;", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class ImageDecoderKt {
    public static final Bitmap decodeBitmap(ImageDecoder.Source imageDecoder$Source0, Function3 function30) {
        Intrinsics.checkParameterIsNotNull(imageDecoder$Source0, "$this$decodeBitmap");
        Intrinsics.checkParameterIsNotNull(function30, "action");
        Bitmap bitmap0 = ImageDecoder.decodeBitmap(imageDecoder$Source0, new ImageDecoder.OnHeaderDecodedListener() {
            @Override  // android.graphics.ImageDecoder$OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder0, ImageDecoder.ImageInfo imageDecoder$ImageInfo0, ImageDecoder.Source imageDecoder$Source0) {
                Intrinsics.checkParameterIsNotNull(imageDecoder0, "decoder");
                Intrinsics.checkParameterIsNotNull(imageDecoder$ImageInfo0, "info");
                Intrinsics.checkParameterIsNotNull(imageDecoder$Source0, "source");
                function30.invoke(imageDecoder0, imageDecoder$ImageInfo0, imageDecoder$Source0);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(bitmap0, "ImageDecoder.decodeBitma…ction(info, source)\n    }");
        return bitmap0;
    }

    public static final Drawable decodeDrawable(ImageDecoder.Source imageDecoder$Source0, Function3 function30) {
        Intrinsics.checkParameterIsNotNull(imageDecoder$Source0, "$this$decodeDrawable");
        Intrinsics.checkParameterIsNotNull(function30, "action");
        Drawable drawable0 = ImageDecoder.decodeDrawable(imageDecoder$Source0, new ImageDecoder.OnHeaderDecodedListener() {
            @Override  // android.graphics.ImageDecoder$OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder imageDecoder0, ImageDecoder.ImageInfo imageDecoder$ImageInfo0, ImageDecoder.Source imageDecoder$Source0) {
                Intrinsics.checkParameterIsNotNull(imageDecoder0, "decoder");
                Intrinsics.checkParameterIsNotNull(imageDecoder$ImageInfo0, "info");
                Intrinsics.checkParameterIsNotNull(imageDecoder$Source0, "source");
                function30.invoke(imageDecoder0, imageDecoder$ImageInfo0, imageDecoder$Source0);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(drawable0, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
        return drawable0;
    }
}

