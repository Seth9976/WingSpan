package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.view.Surface;
import com.unity3d.player.a.a;

public class Camera2Wrapper implements a {
    private Context a;
    private s b;

    public Camera2Wrapper(Context context0) {
        this.b = null;
        this.a = context0;
        this.initCamera2Jni();
    }

    public void a() {
        this.deinitCamera2Jni();
        this.closeCamera2();
    }

    public void a(Object object0) {
        this.nativeSurfaceTextureReady(object0);
    }

    public void a(Object object0, Object object1, Object object2, int v, int v1, int v2) {
        this.nativeFrameReady(object0, object1, object2, v, v1, v2);
    }

    protected void closeCamera2() {
        s s0 = this.b;
        if(s0 != null) {
            s0.a();
        }
        this.b = null;
    }

    private final native void deinitCamera2Jni() {
    }

    protected int getCamera2Count() {
        return s.a(this.a);
    }

    protected int getCamera2FocalLengthEquivalent(int v) {
        return s.a(this.a, v);
    }

    protected int[] getCamera2Resolutions(int v) {
        return s.b(this.a, v);
    }

    protected int getCamera2SensorOrientation(int v) {
        return s.c(this.a, v);
    }

    protected Rect getFrameSizeCamera2() {
        s s0 = this.b;
        return s0 == null ? new Rect() : s0.b();
    }

    private final native void initCamera2Jni() {
    }

    protected boolean initializeCamera2(int v, int v1, int v2, int v3, int v4, Surface surface0) {
        if(this.b == null && UnityPlayer.currentActivity != null) {
            s s0 = new s(this);
            this.b = s0;
            return s0.a(this.a, v, v1, v2, v3, v4, surface0);
        }
        return false;
    }

    protected boolean isCamera2AutoFocusPointSupported(int v) {
        return s.d(this.a, v);
    }

    protected boolean isCamera2FrontFacing(int v) {
        return s.e(this.a, v);
    }

    private final native void nativeFrameReady(Object arg1, Object arg2, Object arg3, int arg4, int arg5, int arg6) {
    }

    private final native void nativeSurfaceTextureReady(Object arg1) {
    }

    protected void pauseCamera2() {
        s s0 = this.b;
        if(s0 != null) {
            s0.c();
        }
    }

    protected boolean setAutoFocusPoint(float f, float f1) {
        return this.b == null ? false : this.b.a(f, f1);
    }

    protected void startCamera2() {
        s s0 = this.b;
        if(s0 != null) {
            s0.g();
        }
    }

    protected void stopCamera2() {
        s s0 = this.b;
        if(s0 != null) {
            s0.h();
        }
    }
}

