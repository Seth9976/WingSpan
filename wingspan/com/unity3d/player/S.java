package com.unity3d.player;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader.OnImageAvailableListener;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Range;
import android.util.Size;
import android.util.SizeF;
import android.view.Surface;
import com.unity3d.player.a.a;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class s {
    private final SurfaceTexture.OnFrameAvailableListener A;
    private static CameraManager B;
    private static String[] C;
    private static Semaphore D;
    private a a;
    private CameraDevice b;
    private HandlerThread c;
    private Handler d;
    private Rect e;
    private Rect f;
    private int g;
    private int h;
    private float i;
    private float j;
    private int k;
    private int l;
    private boolean m;
    private Range n;
    private ImageReader o;
    private Image p;
    private CaptureRequest.Builder q;
    private CameraCaptureSession r;
    private Object s;
    private int t;
    private SurfaceTexture u;
    private Surface v;
    private r w;
    private CameraCaptureSession.CaptureCallback x;
    private final CameraDevice.StateCallback y;
    private final ImageReader.OnImageAvailableListener z;

    static a -$$Nest$fgeta(s s0) {
        return s0.a;
    }

    static CameraDevice -$$Nest$fgetb(s s0) {
        return s0.b;
    }

    static Range -$$Nest$fgetn(s s0) {
        return s0.n;
    }

    static Image -$$Nest$fgetp(s s0) {
        return s0.p;
    }

    static CaptureRequest.Builder -$$Nest$fgetq(s s0) {
        return s0.q;
    }

    static Object -$$Nest$fgets(s s0) {
        return s0.s;
    }

    static Surface -$$Nest$fgetv(s s0) {
        return s0.v;
    }

    static void -$$Nest$fputb(s s0, CameraDevice cameraDevice0) {
        s0.b = cameraDevice0;
    }

    static void -$$Nest$fputp(s s0, Image image0) {
        s0.p = image0;
    }

    static void -$$Nest$fputq(s s0, CaptureRequest.Builder captureRequest$Builder0) {
        s0.q = captureRequest$Builder0;
    }

    static void -$$Nest$fputr(s s0, CameraCaptureSession cameraCaptureSession0) {
        s0.r = cameraCaptureSession0;
    }

    static void -$$Nest$ma(s s0, CameraDevice cameraDevice0) {
        s0.a(cameraDevice0);
    }

    static void -$$Nest$ma(s s0, Object object0) {
        s0.a(object0);
    }

    static void -$$Nest$mf(s s0) {
        s0.f();
    }

    static Semaphore -$$Nest$sfgetD() {
        return s.D;
    }

    static {
        s.D = new Semaphore(1);
    }

    protected s(a a0) {
        this.a = null;
        this.i = -1.0f;
        this.j = -1.0f;
        this.m = false;
        this.o = null;
        this.r = null;
        this.s = new Object();
        this.v = null;
        this.w = r.c;
        this.x = new m(this);
        this.y = new o(this);
        this.z = new p(this);
        this.A = new q(this);
        this.a = a0;
        this.d();
    }

    public static int a(Context context0) {
        return s.b(context0).length;
    }

    public static int a(Context context0, int v) {
        try {
            CameraCharacteristics cameraCharacteristics0 = s.c(context0).getCameraCharacteristics(s.b(context0)[v]);
            float[] arr_f = (float[])cameraCharacteristics0.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);
            SizeF sizeF0 = (SizeF)cameraCharacteristics0.get(CameraCharacteristics.SENSOR_INFO_PHYSICAL_SIZE);
            if(arr_f.length > 0) {
                return (int)(arr_f[0] * 36.0f / sizeF0.getWidth());
            }
        }
        catch(CameraAccessException cameraAccessException0) {
            u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
        }
        return 0;
    }

    private void a(CameraDevice cameraDevice0) {
        synchronized(this.s) {
            this.r = null;
        }
        cameraDevice0.close();
        this.b = null;
    }

    private void a(Object object0) {
        switch(object0) {
            case 0x20C8: {
                Object object1 = this.s;
                synchronized(object1) {
                    if(this.r != null) {
                        this.f();
                    }
                }
                return;
            }
            case 11205: {
                this.m = false;
                Object object2 = this.s;
                synchronized(object2) {
                    if(this.r != null) {
                        try {
                            this.q.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                            this.q.setTag("Regular");
                            this.r.setRepeatingRequest(this.q.build(), this.x, this.d);
                        }
                        catch(CameraAccessException cameraAccessException0) {
                            u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
                        }
                    }
                }
            }
        }
    }

    private static Size[] a(CameraCharacteristics cameraCharacteristics0) {
        StreamConfigurationMap streamConfigurationMap0 = (StreamConfigurationMap)cameraCharacteristics0.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if(streamConfigurationMap0 == null) {
            u.Log(6, "Camera2: configuration map is not available.");
            return null;
        }
        Size[] arr_size = streamConfigurationMap0.getOutputSizes(35);
        return arr_size == null || arr_size.length == 0 ? null : arr_size;
    }

    public void a() {
        if(this.b != null) {
            this.h();
            try {
                TimeUnit timeUnit0 = TimeUnit.SECONDS;
                if(s.D.tryAcquire(4L, timeUnit0)) {
                    goto label_9;
                }
                else {
                    u.Log(5, "Camera2: Timeout waiting to lock camera for closing.");
                }
            }
            catch(InterruptedException interruptedException0) {
                u.Log(6, "Camera2: Interrupted while trying to lock camera for closing " + interruptedException0);
            }
            goto label_17;
        label_9:
            this.b.close();
            try {
                if(!s.D.tryAcquire(4L, timeUnit0)) {
                    u.Log(5, "Camera2: Timeout waiting to close camera.");
                }
            }
            catch(InterruptedException interruptedException1) {
                u.Log(6, "Camera2: Interrupted while waiting to close camera " + interruptedException1);
            }
            this.b = null;
            s.D.release();
        label_17:
            this.x = null;
            this.v = null;
            this.u = null;
            Image image0 = this.p;
            if(image0 != null) {
                image0.close();
                this.p = null;
            }
            ImageReader imageReader0 = this.o;
            if(imageReader0 != null) {
                imageReader0.close();
                this.o = null;
            }
        }
        this.c.quit();
        try {
            this.c.join(4000L);
            this.c = null;
            this.d = null;
        }
        catch(InterruptedException interruptedException2) {
            this.c.interrupt();
            u.Log(6, "Camera2: Interrupted while waiting for the background thread to finish " + interruptedException2);
        }
    }

    public boolean a(float f, float f1) {
        if(this.h > 0) {
            if(!this.m) {
                this.i = f;
                this.j = f1;
                Object object0 = this.s;
                synchronized(object0) {
                    if(this.r != null && this.w != r.b) {
                        this.e();
                    }
                    return true;
                }
            }
            u.Log(5, "Camera2: Setting manual focus point already started.");
        }
        return false;
    }

    public boolean a(Context context0, int v, int v1, int v2, int v3, int v4, Surface surface0) {
        CameraCharacteristics cameraCharacteristics0;
        try {
            cameraCharacteristics0 = s.B.getCameraCharacteristics(s.b(context0)[v]);
        }
        catch(CameraAccessException cameraAccessException0) {
            u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
            return false;
        }
        if(((int)(((Integer)cameraCharacteristics0.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)))) == 2) {
            u.Log(5, "Camera2: only LEGACY hardware level is supported.");
        }
        Size[] arr_size = s.a(cameraCharacteristics0);
        if(arr_size != null && arr_size.length != 0) {
            int v6 = 0;
            int v7 = 0;
            double f = 1.797693E+308;
            for(int v5 = 0; v5 < arr_size.length; ++v5) {
                int v8 = arr_size[v5].getWidth();
                int v9 = arr_size[v5].getHeight();
                double f1 = Math.abs(Math.log(((double)v1) / ((double)v8))) + Math.abs(Math.log(((double)v2) / ((double)v9)));
                if(f1 < f) {
                    v6 = v9;
                    f = f1;
                    v7 = v8;
                }
            }
            this.e = new Rect(0, 0, v7, v6);
            Range[] arr_range = (Range[])cameraCharacteristics0.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            if(arr_range != null && arr_range.length != 0) {
                int v10 = -1;
                double f2 = 1.797693E+308;
                for(int v11 = 0; true; ++v11) {
                    if(v11 >= arr_range.length) {
                        v3 = (int)(((Integer)(v3 <= ((int)(((Integer)arr_range[v10].getUpper()))) ? arr_range[v10].getLower() : arr_range[v10].getUpper())));
                        break;
                    }
                    int v12 = (int)(((Integer)arr_range[v11].getLower()));
                    int v13 = (int)(((Integer)arr_range[v11].getUpper()));
                    if(((float)v3) + 0.1f > ((float)v12) && ((float)v3) - 0.1f < ((float)v13)) {
                        break;
                    }
                    double f3 = (double)(((float)Math.min(Math.abs(v3 - v12), Math.abs(v3 - v13))));
                    if(f3 < f2) {
                        v10 = v11;
                        f2 = f3;
                    }
                }
                this.n = new Range(v3, v3);
                try {
                    TimeUnit timeUnit0 = TimeUnit.SECONDS;
                    if(!s.D.tryAcquire(4L, timeUnit0)) {
                        u.Log(5, "Camera2: Timeout waiting to lock camera for opening.");
                        return false;
                    }
                }
                catch(InterruptedException interruptedException0) {
                    u.Log(6, "Camera2: Interrupted while trying to lock camera for opening " + interruptedException0);
                    return false;
                }
                try {
                    s.B.openCamera(s.b(context0)[v], this.y, this.d);
                }
                catch(CameraAccessException cameraAccessException1) {
                    u.Log(6, "Camera2: CameraAccessException " + cameraAccessException1);
                    s.D.release();
                    return false;
                }
                try {
                    if(!s.D.tryAcquire(4L, timeUnit0)) {
                        u.Log(5, "Camera2: Timeout waiting to open camera.");
                        return false;
                    }
                    s.D.release();
                }
                catch(InterruptedException interruptedException1) {
                    u.Log(6, "Camera2: Interrupted while waiting to open camera " + interruptedException1);
                }
                this.t = v4;
                this.v = surface0;
                int v14 = (int)(((Integer)cameraCharacteristics0.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)));
                this.h = v14;
                if(v14 > 0) {
                    Rect rect0 = (Rect)cameraCharacteristics0.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                    this.f = rect0;
                    float f4 = ((float)rect0.width()) / ((float)this.f.height());
                    float f5 = ((float)this.e.width()) / ((float)this.e.height());
                    if(Float.compare(f5, f4) > 0) {
                        this.k = 0;
                        this.l = (int)((((float)this.f.height()) - ((float)this.f.width()) / f5) / 2.0f);
                    }
                    else {
                        this.l = 0;
                        this.k = (int)((((float)this.f.width()) - ((float)this.f.height()) * f5) / 2.0f);
                    }
                    this.g = Math.min(this.f.width(), this.f.height()) / 20;
                }
                return this.b != null;
            }
            u.Log(6, "Camera2: target FPS ranges are not avialable.");
            return false;
        }
        return false;
    }

    public static int[] b(Context context0, int v) {
        CameraCharacteristics cameraCharacteristics0;
        try {
            cameraCharacteristics0 = s.c(context0).getCameraCharacteristics(s.b(context0)[v]);
        }
        catch(CameraAccessException cameraAccessException0) {
            u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
            return null;
        }
        Size[] arr_size = s.a(cameraCharacteristics0);
        if(arr_size != null) {
            int[] arr_v = new int[arr_size.length * 2];
            for(int v1 = 0; v1 < arr_size.length; ++v1) {
                arr_v[v1 * 2] = arr_size[v1].getWidth();
                arr_v[v1 * 2 + 1] = arr_size[v1].getHeight();
            }
            return arr_v;
        }
        return null;
    }

    private static String[] b(Context context0) {
        if(s.C == null) {
            try {
                s.C = s.c(context0).getCameraIdList();
                return s.C;
            }
            catch(CameraAccessException cameraAccessException0) {
                u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
                s.C = new String[0];
            }
        }
        return s.C;
    }

    public Rect b() {
        return this.e;
    }

    public static int c(Context context0, int v) {
        try {
            return (int)(((Integer)s.c(context0).getCameraCharacteristics(s.b(context0)[v]).get(CameraCharacteristics.SENSOR_ORIENTATION)));
        }
        catch(CameraAccessException cameraAccessException0) {
            u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
            return 0;
        }
    }

    private static CameraManager c(Context context0) {
        if(s.B == null) {
            s.B = (CameraManager)context0.getSystemService("camera");
        }
        return s.B;
    }

    public void c() {
        synchronized(this.s) {
            CameraCaptureSession cameraCaptureSession0 = this.r;
            if(cameraCaptureSession0 != null) {
                try {
                    cameraCaptureSession0.stopRepeating();
                    this.w = r.b;
                }
                catch(CameraAccessException cameraAccessException0) {
                    u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
                }
            }
        }
    }

    private void d() {
        HandlerThread handlerThread0 = new HandlerThread("CameraBackground");
        this.c = handlerThread0;
        handlerThread0.start();
        this.d = new Handler(this.c.getLooper());
    }

    public static boolean d(Context context0, int v) {
        try {
            if(((int)(((Integer)s.c(context0).getCameraCharacteristics(s.b(context0)[v]).get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)))) > 0) {
                return true;
            }
        }
        catch(CameraAccessException cameraAccessException0) {
            u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
        }
        return false;
    }

    private void e() {
        CameraCaptureSession cameraCaptureSession0 = this.r;
        if(cameraCaptureSession0 != null) {
            try {
                cameraCaptureSession0.stopRepeating();
                this.q.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
                this.q.set(CaptureRequest.CONTROL_AF_MODE, 0);
                this.q.setTag("Cancel focus");
                this.r.capture(this.q.build(), this.x, this.d);
            }
            catch(CameraAccessException cameraAccessException0) {
                u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
            }
        }
    }

    public static boolean e(Context context0, int v) {
        try {
            if(((int)(((Integer)s.c(context0).getCameraCharacteristics(s.b(context0)[v]).get(CameraCharacteristics.LENS_FACING)))) == 0) {
                return true;
            }
        }
        catch(CameraAccessException cameraAccessException0) {
            u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
        }
        return false;
    }

    private void f() {
        try {
            if(this.h != 0 && (this.i >= 0.0f && this.i <= 1.0f) && (this.j >= 0.0f && this.j <= 1.0f)) {
                this.m = true;
                int v = (int)(((float)(this.f.width() - this.k * 2)) * this.i + ((float)this.k));
                int v1 = (int)(((double)(this.f.height() - this.l * 2)) * (1.0 - ((double)this.j)) + ((double)this.l));
                int v2 = Math.max(this.g + 1, Math.min(v, this.f.width() - this.g - 1));
                int v3 = Math.max(this.g + 1, Math.min(v1, this.f.height() - this.g - 1));
                this.q.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(v2 - this.g, v3 - this.g, this.g * 2, this.g * 2, 999)});
                this.q.set(CaptureRequest.CONTROL_AF_MODE, 1);
                this.q.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
                this.q.setTag("Focus");
                this.r.capture(this.q.build(), this.x, this.d);
                return;
            }
            this.q.set(CaptureRequest.CONTROL_AF_MODE, 4);
            this.q.setTag("Regular");
            CameraCaptureSession cameraCaptureSession0 = this.r;
            if(cameraCaptureSession0 != null) {
                cameraCaptureSession0.setRepeatingRequest(this.q.build(), this.x, this.d);
            }
        }
        catch(CameraAccessException cameraAccessException0) {
            u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
        }
    }

    public void g() {
        if(this.t == 0) {
            if(this.v == null && this.o == null) {
                ImageReader imageReader0 = ImageReader.newInstance(this.e.width(), this.e.height(), 35, 2);
                this.o = imageReader0;
                imageReader0.setOnImageAvailableListener(this.z, this.d);
                this.p = null;
                this.v = this.o.getSurface();
            }
        }
        else if(this.v == null) {
            SurfaceTexture surfaceTexture0 = new SurfaceTexture(this.t);
            this.u = surfaceTexture0;
            surfaceTexture0.setDefaultBufferSize(this.e.width(), this.e.height());
            this.u.setOnFrameAvailableListener(this.A, this.d);
            this.v = new Surface(this.u);
        }
        try {
            CameraCaptureSession cameraCaptureSession0 = this.r;
            if(cameraCaptureSession0 == null) {
                this.b.createCaptureSession(Arrays.asList(new Surface[]{this.v}), new n(this), this.d);
            }
            else if(this.w == r.b) {
                cameraCaptureSession0.setRepeatingRequest(this.q.build(), this.x, this.d);
            }
            this.w = r.a;
        }
        catch(CameraAccessException cameraAccessException0) {
            u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
        }
    }

    public void h() {
        synchronized(this.s) {
            CameraCaptureSession cameraCaptureSession0 = this.r;
            if(cameraCaptureSession0 != null) {
                try {
                    cameraCaptureSession0.abortCaptures();
                }
                catch(CameraAccessException cameraAccessException0) {
                    u.Log(6, "Camera2: CameraAccessException " + cameraAccessException0);
                }
                this.r.close();
                this.r = null;
                this.w = r.c;
            }
        }
    }
}

