package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.PixelCopy.OnPixelCopyFinishedListener;
import android.view.View;

class v extends View implements PixelCopy.OnPixelCopyFinishedListener {
    Bitmap a;

    v(w w0, Context context0) {
        super(context0);
    }

    @Override  // android.view.PixelCopy$OnPixelCopyFinishedListener
    public void onPixelCopyFinished(int v) {
        if(v == 0) {
            this.setBackground(new LayerDrawable(new Drawable[]{new ColorDrawable(0xFF000000), new BitmapDrawable(this.getResources(), this.a)}));
        }
    }
}

