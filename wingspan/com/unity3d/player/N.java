package com.unity3d.player;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest;

class n extends CameraCaptureSession.StateCallback {
    final s a;

    n(s s0) {
        this.a = s0;
        super();
    }

    @Override  // android.hardware.camera2.CameraCaptureSession$StateCallback
    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession0) {
        u.Log(6, "Camera2: CaptureSession configuration failed.");
    }

    @Override  // android.hardware.camera2.CameraCaptureSession$StateCallback
    public void onConfigured(CameraCaptureSession cameraCaptureSession0) {
        String s1;
        s s0 = this.a;
        if(s.-$$Nest$fgetb(s0) == null) {
            return;
        }
        synchronized(s.-$$Nest$fgets(s0)) {
            s.-$$Nest$fputr(this.a, cameraCaptureSession0);
            try {
                CaptureRequest.Builder captureRequest$Builder0 = s.-$$Nest$fgetb(this.a).createCaptureRequest(1);
                s.-$$Nest$fputq(this.a, captureRequest$Builder0);
                s.-$$Nest$fgetq(this.a).addTarget(s.-$$Nest$fgetv(this.a));
                s.-$$Nest$fgetq(this.a).set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, s.-$$Nest$fgetn(this.a));
                s.-$$Nest$mf(this.a);
                return;
            }
            catch(CameraAccessException cameraAccessException0) {
                s1 = "Camera2: CameraAccessException " + cameraAccessException0;
            }
            catch(IllegalStateException illegalStateException0) {
                s1 = "Camera2: IllegalStateException " + illegalStateException0;
            }
            u.Log(6, s1);
        }
    }
}

