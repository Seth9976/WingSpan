package com.voxelbusters.essentialkit.gameservices;

import android.app.Activity;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.images.ImageManager;
import com.voxelbusters.essentialkit.utilities.common.BytesWrapper;
import com.voxelbusters.essentialkit.utilities.common.interfaces.ILoadAssetListener;
import java.io.ByteArrayOutputStream;

public class ImageManagerUtility {
    // 检测为 Lambda 实现
    static void lambda$loadImage$0(Activity activity0, ILoadAssetListener iLoadAssetListener0, Uri uri0) [...]

    public static void loadImage(Activity activity0, Uri uri0, ILoadAssetListener iLoadAssetListener0) {
        activity0.runOnUiThread(() -> {
            public final class a implements OnImageLoadedListener {
                public final ILoadAssetListener a;

                public a(ILoadAssetListener iLoadAssetListener0) {
                }

                @Override  // com.google.android.gms.common.images.ImageManager$OnImageLoadedListener
                public final void onImageLoaded(Uri uri0, Drawable drawable0, boolean z) {
                    if(z) {
                        Bitmap bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
                        ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
                        bitmap0.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream0);
                        BytesWrapper bytesWrapper0 = new BytesWrapper(byteArrayOutputStream0.toByteArray());
                        this.a.onSuccess(bytesWrapper0);
                        return;
                    }
                    this.a.onFailure("Unable to load image");
                }
            }

            ImageManager.create(activity0).loadImage(new a(iLoadAssetListener0), uri0);
        });
    }
}

