package com.unity3d.player;

import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;

class m extends CameraCaptureSession.CaptureCallback {
    final s a;

    m(s s0) {
        this.a = s0;
        super();
    }

    @Override  // android.hardware.camera2.CameraCaptureSession$CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession0, CaptureRequest captureRequest0, TotalCaptureResult totalCaptureResult0) {
        Object object0 = captureRequest0.getTag();
        s.-$$Nest$ma(this.a, object0);
    }

    @Override  // android.hardware.camera2.CameraCaptureSession$CaptureCallback
    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession0, CaptureRequest captureRequest0, CaptureFailure captureFailure0) {
        u.Log(5, "Camera2: Capture session failed " + captureRequest0.getTag() + " reason " + captureFailure0.getReason());
        Object object0 = captureRequest0.getTag();
        s.-$$Nest$ma(this.a, object0);
    }

    @Override  // android.hardware.camera2.CameraCaptureSession$CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession0, int v) {
    }

    @Override  // android.hardware.camera2.CameraCaptureSession$CaptureCallback
    public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession0, int v, long v1) {
    }
}

