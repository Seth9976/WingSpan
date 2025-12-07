package com.unity3d.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;

public class K extends View {
    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    static final class a extends Enum {
        public static final enum a a;
        private static final a[] b;

        static {
            a k$a0 = new a("Center", 0);
            a k$a1 = new a("Fit", 1);
            a.a = new a("Fill", 2);
            a.b = new a[]{k$a0, k$a1, a.a};
        }

        private a(String s, int v) {
            super(s, v);
        }

        public static a[] a() {
            return (a[])a.b.clone();
        }
    }

    final a a;
    final int b;
    int c;
    Bitmap d;
    Bitmap e;

    public K(Context context0, a k$a0) {
        super(context0);
        this.c = 0xFF000000;
        this.a = k$a0;
        int v = this.getResources().getIdentifier("unity_static_splash", "drawable", "com.MonsterCouch.Wingspan");
        this.b = v;
        if(v != 0) {
            this.forceLayout();
        }
        int v1 = this.getResources().getIdentifier("staticSplashScreenBackgroundColor", "color", "com.MonsterCouch.Wingspan");
        if(v1 != 0) {
            this.c = this.getResources().getColor(v1);
        }
        this.setBackgroundColor(this.c);
    }

    @Override  // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap0 = this.d;
        if(bitmap0 != null) {
            bitmap0.recycle();
            this.d = null;
        }
        Bitmap bitmap1 = this.e;
        if(bitmap1 != null) {
            bitmap1.recycle();
            this.e = null;
        }
    }

    @Override  // android.view.View
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        if(this.b == 0) {
            return;
        }
        if(this.d == null) {
            BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
            bitmapFactory$Options0.inScaled = false;
            this.d = BitmapFactory.decodeResource(this.getResources(), this.b, bitmapFactory$Options0);
        }
        int v4 = this.d.getWidth();
        int v5 = this.d.getHeight();
        int v6 = this.getWidth();
        int v7 = this.getHeight();
        if(v6 != 0 && v7 != 0) {
            float f = ((float)v4) / ((float)v5);
            int v8 = Float.compare(((float)v6) / ((float)v7), f) > 0 ? 0 : 1;
            switch(this.a.ordinal()) {
                case 0: {
                    if(v6 < v4) {
                        v5 = (int)(((float)v6) / f);
                        v4 = v6;
                    }
                    if(v7 < v5) {
                        v4 = (int)(((float)v7) * f);
                        v5 = v7;
                    }
                    break;
                }
                case 1: 
                case 2: {
                    if(((this.a == a.a ? 1 : 0) ^ v8) == 0) {
                        v4 = (int)(((float)v7) * f);
                        v5 = v7;
                    }
                    else {
                        v5 = (int)(((float)v6) / f);
                        v4 = v6;
                    }
                }
            }
            Bitmap bitmap0 = this.e;
            if(bitmap0 != null) {
                if(bitmap0.getWidth() == v4 && this.e.getHeight() == v5) {
                    return;
                }
                Bitmap bitmap1 = this.e;
                if(bitmap1 != this.d) {
                    bitmap1.recycle();
                    this.e = null;
                }
            }
            Bitmap bitmap2 = Bitmap.createScaledBitmap(this.d, v4, v5, true);
            this.e = bitmap2;
            bitmap2.setDensity(this.getResources().getDisplayMetrics().densityDpi);
            ColorDrawable colorDrawable0 = new ColorDrawable(this.c);
            BitmapDrawable bitmapDrawable0 = new BitmapDrawable(this.getResources(), this.e);
            bitmapDrawable0.setGravity(17);
            this.setBackground(new LayerDrawable(new Drawable[]{colorDrawable0, bitmapDrawable0}));
        }
    }
}

