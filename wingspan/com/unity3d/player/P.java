package com.unity3d.player;

import android.media.Image.Plane;
import android.media.Image;
import android.media.ImageReader.OnImageAvailableListener;
import android.media.ImageReader;
import java.nio.ByteBuffer;

class p implements ImageReader.OnImageAvailableListener {
    final s a;

    p(s s0) {
        this.a = s0;
        super();
    }

    @Override  // android.media.ImageReader$OnImageAvailableListener
    public void onImageAvailable(ImageReader imageReader0) {
        if(s.-$$Nest$sfgetD().tryAcquire()) {
            Image image0 = imageReader0.acquireNextImage();
            if(image0 != null) {
                Image.Plane[] arr_image$Plane = image0.getPlanes();
                if(image0.getFormat() != 35 || arr_image$Plane == null || arr_image$Plane.length != 3) {
                    u.Log(6, "Camera2: Wrong image format.");
                }
                else {
                    ByteBuffer byteBuffer0 = arr_image$Plane[0].getBuffer();
                    ByteBuffer byteBuffer1 = arr_image$Plane[1].getBuffer();
                    ByteBuffer byteBuffer2 = arr_image$Plane[2].getBuffer();
                    int v = arr_image$Plane[0].getRowStride();
                    int v1 = arr_image$Plane[1].getRowStride();
                    int v2 = arr_image$Plane[1].getPixelStride();
                    ((Camera2Wrapper)s.-$$Nest$fgeta(this.a)).a(byteBuffer0, byteBuffer1, byteBuffer2, v, v1, v2);
                }
                Image image1 = s.-$$Nest$fgetp(this.a);
                if(image1 != null) {
                    image1.close();
                }
                s.-$$Nest$fputp(this.a, image0);
            }
            s.-$$Nest$sfgetD().release();
        }
    }
}

