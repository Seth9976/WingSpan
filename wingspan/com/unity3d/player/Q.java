package com.unity3d.player;

import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.graphics.SurfaceTexture;

class q implements SurfaceTexture.OnFrameAvailableListener {
    final s a;

    q(s s0) {
        this.a = s0;
        super();
    }

    @Override  // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture0) {
        ((Camera2Wrapper)s.-$$Nest$fgeta(this.a)).a(surfaceTexture0);
    }
}

