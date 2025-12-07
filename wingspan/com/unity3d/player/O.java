package com.unity3d.player;

import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraDevice;

class o extends CameraDevice.StateCallback {
    final s a;

    o(s s0) {
        this.a = s0;
        super();
    }

    @Override  // android.hardware.camera2.CameraDevice$StateCallback
    public void onClosed(CameraDevice cameraDevice0) {
        s.-$$Nest$sfgetD().release();
    }

    @Override  // android.hardware.camera2.CameraDevice$StateCallback
    public void onDisconnected(CameraDevice cameraDevice0) {
        u.Log(5, "Camera2: CameraDevice disconnected.");
        s.-$$Nest$ma(this.a, cameraDevice0);
        s.-$$Nest$sfgetD().release();
    }

    @Override  // android.hardware.camera2.CameraDevice$StateCallback
    public void onError(CameraDevice cameraDevice0, int v) {
        u.Log(6, "Camera2: Error opeining CameraDevice " + v);
        s.-$$Nest$ma(this.a, cameraDevice0);
        s.-$$Nest$sfgetD().release();
    }

    @Override  // android.hardware.camera2.CameraDevice$StateCallback
    public void onOpened(CameraDevice cameraDevice0) {
        s.-$$Nest$fputb(this.a, cameraDevice0);
        s.-$$Nest$sfgetD().release();
    }
}

