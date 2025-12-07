package com.unity3d.player;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;

class a extends SurfaceView {
    private float a;
    private UnityPlayer b;

    public a(Context context0, UnityPlayer unityPlayer0) {
        super(context0);
        this.b = unityPlayer0;
    }

    public void a(float f) {
        this.a = f;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getLayoutParams();
        int v = f <= 0.0f ? -1 : -2;
        viewGroup$LayoutParams0.width = v;
        viewGroup$LayoutParams0.height = v;
        this.setLayoutParams(viewGroup$LayoutParams0);
    }

    public boolean a() {
        return this.a > 0.0f;
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent0) {
        return this.a() ? this.b.injectEvent(motionEvent0) : false;
    }

    @Override  // android.view.SurfaceView
    protected void onMeasure(int v, int v1) {
        if(this.a <= 0.0f) {
            super.onMeasure(v, v1);
            return;
        }
        int v2 = View.MeasureSpec.getSize(v);
        int v3 = View.MeasureSpec.getSize(v1);
        if(v2 > 0 && v3 > 0 && View.MeasureSpec.getMode(v) == 0x80000000 && View.MeasureSpec.getMode(v1) == 0x80000000) {
            float f = this.a;
            if(((float)v2) / ((float)v3) < f) {
                v3 = (int)(((float)v2) / f);
            }
            else {
                v2 = (int)(((float)v3) * f);
            }
            this.setMeasuredDimension(v2, v3);
            return;
        }
        super.onMeasure(v, v1);
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        return this.a() ? this.b.injectEvent(motionEvent0) : false;
    }
}

