package com.unity3d.player;

import android.app.Activity;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.InputFilter.LengthFilter;
import android.text.InputFilter;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.view.inputmethod.InputMethodSubtype;
import android.widget.EditText;
import android.widget.FrameLayout;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class UnityPlayer extends FrameLayout implements IUnityPlayerLifecycleEvents {
    class B implements SensorEventListener {
        @Override  // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor0, int v) {
        }

        @Override  // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent0) {
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    static final class C extends Enum {
        public static final enum C a;
        public static final enum C b;
        public static final enum C c;

        static {
            C.a = new C("GAINED", 0);
            C.b = new C("LOST", 1);
            C.c = new C("DEFERRED", 2);
        }

        private C(String s, int v) {
            super(s, v);
        }
    }

    class D extends PhoneStateListener {
        final UnityPlayer a;

        private D() {
        }

        D(UnityPlayer.D-IA unityPlayer$D-IA0) {
        }

        @Override  // android.telephony.PhoneStateListener
        public void onCallStateChanged(int v, String s) {
            UnityPlayer.this.nativeMuteMasterAudio(v == 1);
        }
    }

    // 部分失败：枚举糖化
    // 枚举按原样呈现，而不是糖化为Java 5枚举。
    static final class E extends Enum {
        public static final enum E a;
        public static final enum E b;
        public static final enum E c;
        public static final enum E d;
        public static final enum E e;
        public static final enum E f;
        public static final enum E g;
        public static final enum E h;
        public static final enum E i;
        public static final enum E j;

        static {
            E.a = new E("PAUSE", 0);
            E.b = new E("RESUME", 1);
            E.c = new E("QUIT", 2);
            E.d = new E("SURFACE_LOST", 3);
            E.e = new E("SURFACE_ACQUIRED", 4);
            E.f = new E("FOCUS_LOST", 5);
            E.g = new E("FOCUS_GAINED", 6);
            E.h = new E("NEXT_FRAME", 7);
            E.i = new E("URL_ACTIVATED", 8);
            E.j = new E("ORIENTATION_ANGLE_CHANGE", 9);
        }

        private E(String s, int v) {
            super(s, v);
        }
    }

    class F extends Thread {
        Handler a;
        boolean b;
        boolean c;
        C d;
        int e;
        int f;
        int g;
        int h;
        final UnityPlayer i;

        private F() {
            this.b = false;
            this.c = false;
            this.d = C.b;
            this.e = 0;
            this.h = 5;
        }

        F(UnityPlayer.F-IA unityPlayer$F-IA0) {
        }

        @Override
        public void run() {
            class a implements Handler.Callback {
                final F a;

                private void a() {
                    F unityPlayer$F0 = F.this;
                    if(unityPlayer$F0.d == C.c && unityPlayer$F0.c) {
                        UnityPlayer.this.nativeFocusChanged(true);
                        F.this.d = C.a;
                    }
                }

                @Override  // android.os.Handler$Callback
                public boolean handleMessage(Message message0) {
                    if(message0.what != 0x8DD) {
                        return false;
                    }
                    E unityPlayer$E0 = (E)message0.obj;
                    E unityPlayer$E1 = E.h;
                    if(unityPlayer$E0 == unityPlayer$E1) {
                        --F.this.e;
                        UnityPlayer.this.executeGLThreadJobs();
                        F unityPlayer$F0 = F.this;
                        if(!unityPlayer$F0.b) {
                            return true;
                        }
                        if(UnityPlayer.this.getHaveAndroidWindowSupport() && !F.this.c) {
                            return true;
                        }
                        F unityPlayer$F1 = F.this;
                        int v = unityPlayer$F1.h;
                        if(v >= 0) {
                            if(v == 0) {
                                if(UnityPlayer.this.getSplashEnabled()) {
                                    UnityPlayer.this.DisableStaticSplashScreen();
                                }
                                UnityPlayer unityPlayer0 = UnityPlayer.this;
                                if(unityPlayer0.mActivity != null && unityPlayer0.getAutoReportFullyDrawnEnabled()) {
                                    UnityPlayer.this.mActivity.reportFullyDrawn();
                                }
                            }
                            --F.this.h;
                        }
                        if(!UnityPlayer.this.isFinishing() && !UnityPlayer.this.nativeRender()) {
                            UnityPlayer.this.finish();
                        }
                    }
                    else if(unityPlayer$E0 == E.c) {
                        Looper.myLooper().quit();
                    }
                    else if(unityPlayer$E0 == E.b) {
                        F.this.b = true;
                    }
                    else if(unityPlayer$E0 == E.a) {
                        F.this.b = false;
                    }
                    else if(unityPlayer$E0 == E.d) {
                        F.this.c = false;
                    }
                    else if(unityPlayer$E0 == E.e) {
                        F.this.c = true;
                        this.a();
                    }
                    else if(unityPlayer$E0 == E.f) {
                        F unityPlayer$F2 = F.this;
                        if(unityPlayer$F2.d == C.a) {
                            UnityPlayer.this.nativeFocusChanged(false);
                        }
                        F.this.d = C.b;
                    }
                    else if(unityPlayer$E0 == E.g) {
                        F.this.d = C.c;
                        this.a();
                    }
                    else if(unityPlayer$E0 == E.i) {
                        String s = UnityPlayer.this.getLaunchURL();
                        UnityPlayer.this.nativeSetLaunchURL(s);
                    }
                    else if(unityPlayer$E0 == E.j) {
                        UnityPlayer.this.nativeOrientationChanged(F.this.f, F.this.g);
                    }
                    F unityPlayer$F3 = F.this;
                    if(unityPlayer$F3.b && unityPlayer$F3.e <= 0) {
                        Message.obtain(unityPlayer$F3.a, 0x8DD, unityPlayer$E1).sendToTarget();
                        ++F.this.e;
                    }
                    return true;
                }
            }

            this.setName("UnityMain");
            Looper.prepare();
            this.a = new Handler(Looper.myLooper(), new a(this));
            Looper.loop();
        }
    }

    abstract class G implements Runnable {
        final UnityPlayer a;

        private G() {
        }

        G(UnityPlayer.G-IA unityPlayer$G-IA0) {
        }

        public abstract void a();

        @Override
        public final void run() {
            if(!UnityPlayer.this.isFinishing()) {
                this.a();
            }
        }
    }

    public static enum SynchronizationTimeout {
        Pause(0),
        SurfaceDetach(1),
        Destroy(2);

        private int m_TimeoutMilliseconds;
        final int value;

        private SynchronizationTimeout(int v1) {
            this.value = v1;
            this.m_TimeoutMilliseconds = 2000;
        }

        public int getTimeout() {
            return this.m_TimeoutMilliseconds;
        }

        public void setTimeout(int v) {
            this.m_TimeoutMilliseconds = v;
        }

        public static void setTimeoutForAll(int v) {
            SynchronizationTimeout[] arr_unityPlayer$SynchronizationTimeout = (SynchronizationTimeout[])SynchronizationTimeout.class.getEnumConstants();
            for(int v1 = 0; v1 < arr_unityPlayer$SynchronizationTimeout.length; ++v1) {
                arr_unityPlayer$SynchronizationTimeout[v1].setTimeout(v);
            }
        }
    }

    private static final String ARCORE_ENABLE_METADATA_NAME = "unity.arcore-enable";
    private static final String AUTO_REPORT_FULLY_DRAWN_ENABLE_METADATA_NAME = "unity.auto-report-fully-drawn";
    private static final String LAUNCH_FULLSCREEN = "unity.launch-fullscreen";
    private static final int RUN_STATE_CHANGED_MSG_CODE = 0x8DD;
    private static final String SPLASH_ENABLE_METADATA_NAME = "unity.splash-enable";
    private static final String SPLASH_MODE_METADATA_NAME = "unity.splash-mode";
    public static Activity currentActivity;
    public static Context currentContext;
    private Activity mActivity;
    private Context mContext;
    private Q mGlView;
    Handler mHandler;
    private int mInitialScreenOrientation;
    private boolean mIsFullscreen;
    private boolean mMainDisplayOverride;
    private int mNaturalOrientation;
    private OrientationEventListener mOrientationListener;
    private boolean mProcessKillRequested;
    private boolean mQuitting;
    z mSoftInput;
    private S mState;
    private c0 mVideoPlayerProxy;
    private GoogleARCoreApi m_ARCoreApi;
    private boolean m_AddPhoneCallListener;
    private AudioVolumeHandler m_AudioVolumeHandler;
    private Camera2Wrapper m_Camera2Wrapper;
    private ClipboardManager m_ClipboardManager;
    private final ConcurrentLinkedQueue m_Events;
    private B m_FakeListener;
    private HFPStatus m_HFPStatus;
    private int m_IsNoWindowMode;
    F m_MainThread;
    private NetworkConnectivity m_NetworkConnectivity;
    private OrientationLockListener m_OrientationLockListener;
    private D m_PhoneCallListener;
    private K m_SplashScreen;
    private TelephonyManager m_TelephonyManager;
    private IUnityPlayerLifecycleEvents m_UnityPlayerLifecycleEvents;
    Window m_Window;
    private Uri m_launchUri;
    private Configuration prevConfig;

    static {
        new O().a();
    }

    public UnityPlayer(Context context0) {
        this(context0, null);
    }

    public UnityPlayer(Context context0, IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents0) {
        class k implements DialogInterface.OnClickListener {
            final UnityPlayer a;

            @Override  // android.content.DialogInterface$OnClickListener
            public void onClick(DialogInterface dialogInterface0, int v) {
                UnityPlayer.this.finish();
            }
        }

        super(context0);
        this.mHandler = new Handler();
        this.mInitialScreenOrientation = -1;
        this.mMainDisplayOverride = false;
        this.mIsFullscreen = true;
        this.mState = new S();
        this.m_Events = new ConcurrentLinkedQueue();
        this.mOrientationListener = null;
        this.m_MainThread = new F(this, null);
        this.m_AddPhoneCallListener = false;
        this.m_PhoneCallListener = new D(this, null);
        this.m_ARCoreApi = null;
        this.m_FakeListener = new B(this);
        this.m_Camera2Wrapper = null;
        this.m_HFPStatus = null;
        this.m_AudioVolumeHandler = null;
        this.m_OrientationLockListener = null;
        this.m_launchUri = null;
        this.m_NetworkConnectivity = null;
        this.m_UnityPlayerLifecycleEvents = null;
        this.m_IsNoWindowMode = -1;
        this.mProcessKillRequested = true;
        this.mSoftInput = null;
        if(iUnityPlayerLifecycleEvents0 == null) {
            iUnityPlayerLifecycleEvents0 = this;
        }
        this.m_UnityPlayerLifecycleEvents = iUnityPlayerLifecycleEvents0;
        O.a(UnityPlayer.getUnityNativeLibraryPath(context0));
        UnityPlayer.currentContext = context0;
        if(context0 instanceof Activity) {
            this.mActivity = (Activity)context0;
            UnityPlayer.currentActivity = (Activity)context0;
            this.mInitialScreenOrientation = ((Activity)context0).getRequestedOrientation();
            this.m_launchUri = this.mActivity.getIntent().getData();
        }
        this.mContext = context0;
        this.EarlyEnableFullScreenIfEnabled();
        Configuration configuration0 = this.getResources().getConfiguration();
        this.prevConfig = configuration0;
        this.mNaturalOrientation = this.getNaturalOrientation(configuration0.orientation);
        if(this.mActivity != null && this.getSplashEnabled()) {
            Context context1 = this.mContext;
            com.unity3d.player.K.a[] arr_k$a = com.unity3d.player.K.a.a();
            K k0 = new K(context1, arr_k$a[this.getSplashMode()]);
            this.m_SplashScreen = k0;
            this.addView(k0);
        }
        UnityPlayer.preloadJavaPlugins();
        String s = UnityPlayer.loadNative(UnityPlayer.getUnityNativeLibraryPath(this.mContext));
        u.Log(6, "Your hardware does not support this application.");
        AlertDialog alertDialog0 = new AlertDialog.Builder(this.mContext).setTitle("Failure to initialize!").setPositiveButton("OK", (/* 缺少LAMBDA参数 */, /* 缺少LAMBDA参数 */) -> if(UnityPlayer.this.mActivity != null && !UnityPlayer.this.mActivity.isFinishing()) {
            UnityPlayer.this.mActivity.finish();
        }).setMessage("Your hardware does not support this application.\n\n" + s + "\n\n Press OK to quit.").create();
        alertDialog0.setCancelable(false);
        alertDialog0.show();
    }

    private void DisableStaticSplashScreen() {
        class t implements Runnable {
            final UnityPlayer a;

            @Override
            public void run() {
                K k0 = UnityPlayer.this.m_SplashScreen;
                UnityPlayer.this.removeView(k0);
                UnityPlayer.this.m_SplashScreen = null;
            }
        }

        this.runOnUiThread(new t(this));
    }

    private void EarlyEnableFullScreenIfEnabled() {
        boolean z = false;
        if(this.mActivity != null && this.mActivity.getWindow() != null && (this.getLaunchFullscreen() || this.mActivity.getIntent().getBooleanExtra("android.intent.extra.VR_LAUNCH", false))) {
            View view0 = this.mActivity.getWindow().getDecorView();
            if(view0 != null) {
                view0.setSystemUiVisibility(7);
            }
        }
        Activity activity0 = this.mActivity;
        if(activity0 != null && activity0.getWindow() != null && PlatformSupport.PIE_SUPPORT) {
            WindowManager.LayoutParams windowManager$LayoutParams0 = activity0.getWindow().getAttributes();
            try {
                ApplicationInfo applicationInfo0 = activity0.getPackageManager().getApplicationInfo("com.MonsterCouch.Wingspan", 0x80);
                if(applicationInfo0 != null) {
                    z = applicationInfo0.metaData.getBoolean("unity.render-outside-safearea");
                }
            }
            catch(Exception unused_ex) {
            }
            windowManager$LayoutParams0.layoutInDisplayCutoutMode = z;
        }
    }

    private String GetGlViewContentDescription(Context context0) {
        return context0.getResources().getString(context0.getResources().getIdentifier("game_view_content_description", "string", "com.MonsterCouch.Wingspan"));
    }

    private boolean IsWindowTranslucent() {
        Activity activity0 = this.mActivity;
        if(activity0 == null) {
            return false;
        }
        TypedArray typedArray0 = activity0.getTheme().obtainStyledAttributes(new int[]{0x1010058});
        boolean z = typedArray0.getBoolean(0, false);
        typedArray0.recycle();
        return z;
    }

    public static void UnitySendMessage(String s, String s1, String s2) {
        u.Log(5, "Native libraries not loaded - dropping message for " + s + "." + s1);
    }

    protected void addPhoneCallListener() {
        this.m_AddPhoneCallListener = true;
        this.m_TelephonyManager.listen(this.m_PhoneCallListener, 0x20);
    }

    public boolean addViewToPlayer(View view0, boolean z) {
        this.swapViews(view0, (z ? this.mGlView : null));
        boolean z1 = view0.getParent() == this;
        boolean z2 = z && this.mGlView.getParent() == null;
        boolean z3 = this.mGlView.getParent() == this;
        if(!z1 || !z2 && !z3) {
            if(!z1) {
                u.Log(6, "addViewToPlayer: Failure adding view to hierarchy");
            }
            if(!z2 && !z3) {
                u.Log(6, "addViewToPlayer: Failure removing old view from hierarchy");
            }
        }
        return true;
    }

    private void checkResumePlayer() {
        class com.unity3d.player.UnityPlayer.a implements Runnable {
            final UnityPlayer a;

            @Override
            public void run() {
                UnityPlayer.this.nativeResume();
            }
        }

        boolean z = this.mActivity == null ? false : MultiWindowSupport.isInMultiWindowMode(this.mActivity);
        if(!this.mState.a(z)) {
            return;
        }
        this.mState.c(true);
        this.queueGLThreadEvent(() -> {
        });
        E unityPlayer$E0 = E.b;
        Handler handler0 = this.m_MainThread.a;
        if(handler0 != null) {
            Message.obtain(handler0, 0x8DD, unityPlayer$E0).sendToTarget();
        }
    }

    public void configurationChanged(Configuration configuration0) {
        int v = this.prevConfig.diff(configuration0);
        if((v & 0x100) != 0 || (v & 0x400) != 0 || (v & 0x800) != 0 || (v & 0x80) != 0) {
            this.nativeHidePreservedContent();
        }
        this.prevConfig = new Configuration(configuration0);
        c0 c00 = this.mVideoPlayerProxy;
        if(c00 != null) {
            c00.b();
        }
    }

    // 检测为 Lambda 实现
    public void destroy() [...]

    protected void disableLogger() {
        u.a = true;
    }

    public boolean displayChanged(int v, Surface surface0) {
        class w implements Runnable {
            final UnityPlayer a;

            @Override
            public void run() {
                UnityPlayer unityPlayer0 = UnityPlayer.this;
                if(unityPlayer0.mMainDisplayOverride) {
                    unityPlayer0.removeView(unityPlayer0.mGlView);
                    return;
                }
                if(unityPlayer0.mGlView.getParent() == null) {
                    UnityPlayer.this.addView(UnityPlayer.this.mGlView);
                    return;
                }
                u.Log(5, "Couldn\'t add view, because it\'s already assigned to another parent");
            }
        }

        if(v == 0) {
            this.mMainDisplayOverride = surface0 != null;
            this.runOnUiThread(new w(this));
        }
        return this.updateDisplayInternal(v, surface0);
    }

    protected void executeGLThreadJobs() {
        Runnable runnable0;
        while((runnable0 = (Runnable)this.m_Events.poll()) != null) {
            runnable0.run();
        }
    }

    // 检测为 Lambda 实现
    private void finish() [...]

    private boolean getARCoreEnabled() {
        try {
            return this.getApplicationInfo().metaData.getBoolean("unity.arcore-enable");
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    private ActivityInfo getActivityInfo() {
        return this.mActivity.getPackageManager().getActivityInfo(this.mActivity.getComponentName(), 0x80);
    }

    private ApplicationInfo getApplicationInfo() {
        return this.mContext.getPackageManager().getApplicationInfo("com.MonsterCouch.Wingspan", 0x80);
    }

    private boolean getAutoReportFullyDrawnEnabled() {
        try {
            return this.getApplicationInfo().metaData.getBoolean("unity.auto-report-fully-drawn");
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    protected String getClipboardText() {
        ClipData clipData0 = this.m_ClipboardManager.getPrimaryClip();
        return clipData0 == null ? "" : clipData0.getItemAt(0).coerceToText(this.mContext).toString();
    }

    private boolean getHaveAndroidWindowSupport() {
        if(this.m_IsNoWindowMode == -1) {
            this.m_IsNoWindowMode = this.nativeGetNoWindowMode();
        }
        return this.m_IsNoWindowMode == 1;
    }

    protected String getKeyboardLayout() {
        z z0 = this.mSoftInput;
        if(z0 == null) {
            return null;
        }
        InputMethodSubtype inputMethodSubtype0 = ((InputMethodManager)z0.a.getSystemService("input_method")).getCurrentInputMethodSubtype();
        if(inputMethodSubtype0 != null) {
            String s = inputMethodSubtype0.getLocale();
            return s != null && !s.equals("") ? s : inputMethodSubtype0.getMode() + " " + inputMethodSubtype0.getExtraValue();
        }
        return null;
    }

    private boolean getLaunchFullscreen() {
        try {
            return this.getApplicationInfo().metaData.getBoolean("unity.launch-fullscreen");
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    protected String getLaunchURL() {
        return this.m_launchUri == null ? null : this.m_launchUri.toString();
    }

    private int getNaturalOrientation(int v) {
        int v1 = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getRotation();
        return (v1 == 0 || v1 == 2) && v == 2 || (v1 == 1 || v1 == 3) && v == 1 ? 0 : 1;
    }

    protected int getNetworkConnectivity() {
        NetworkConnectivity networkConnectivity0 = this.m_NetworkConnectivity;
        if(networkConnectivity0 != null) {
            return networkConnectivity0.b();
        }
        NetworkConnectivity networkConnectivity1 = PlatformSupport.NOUGAT_SUPPORT ? new NetworkConnectivityNougat(this.mContext) : new NetworkConnectivity(this.mContext);
        this.m_NetworkConnectivity = networkConnectivity1;
        return this.m_NetworkConnectivity.b();
    }

    public String getNetworkProxySettings(String s) {
        String s2;
        String s1;
        if(s.startsWith("http:")) {
            s1 = "http.proxyHost";
            s2 = "http.proxyPort";
            goto label_7;
        }
        else if(s.startsWith("https:")) {
            s1 = "https.proxyHost";
            s2 = "https.proxyPort";
        label_7:
            String s3 = System.getProperties().getProperty(s1);
            if(s3 != null && !"".equals(s3)) {
                StringBuilder stringBuilder0 = new StringBuilder(s3);
                String s4 = System.getProperties().getProperty(s2);
                if(s4 != null && !"".equals(s4)) {
                    stringBuilder0.append(":");
                    stringBuilder0.append(s4);
                }
                String s5 = System.getProperties().getProperty("http.nonProxyHosts");
                if(s5 != null && !"".equals(s5)) {
                    stringBuilder0.append('\n');
                    stringBuilder0.append(s5);
                }
                return stringBuilder0.toString();
            }
        }
        return null;
    }

    private String getProcessName() {
        int v = Process.myPid();
        List list0 = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if(list0 == null) {
            return null;
        }
        for(Object object0: list0) {
            ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo0 = (ActivityManager.RunningAppProcessInfo)object0;
            if(activityManager$RunningAppProcessInfo0.pid == v) {
                return activityManager$RunningAppProcessInfo0.processName;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public float getScreenBrightness() {
        Window window0 = this.m_Window;
        if(window0 == null) {
            return 1.0f;
        }
        float f = window0.getAttributes().screenBrightness;
        if(f < 0.0f) {
            int v = Settings.System.getInt(this.getContext().getContentResolver(), "screen_brightness", 0xFF);
            return PlatformSupport.PIE_SUPPORT ? ((float)Math.max(0.0, Math.min(1.0, (Math.log(v) * 19.811 - 9.411) / 100.0))) : ((float)v) / 255.0f;
        }
        return f;
    }

    public Bundle getSettings() {
        return Bundle.EMPTY;
    }

    private boolean getSplashEnabled() {
        try {
            return this.getApplicationInfo().metaData.getBoolean("unity.splash-enable");
        }
        catch(Exception unused_ex) {
            return false;
        }
    }

    protected int getSplashMode() {
        try {
            return this.getApplicationInfo().metaData.getInt("unity.splash-mode");
        }
        catch(Exception unused_ex) {
            return 0;
        }
    }

    protected int getUaaLLaunchProcessType() {
        String s = this.getProcessName();
        return s == null || s.equals("com.MonsterCouch.Wingspan") ? 0 : 1;
    }

    private static String getUnityNativeLibraryPath(Context context0) {
        return context0.getApplicationInfo().nativeLibraryDir;
    }

    public View getView() {
        return this;
    }

    private void hidePreservedContent() {
        class c implements Runnable {
            final UnityPlayer a;

            @Override
            public void run() {
                Q q0 = UnityPlayer.this.mGlView;
                if(q0 != null) {
                    q0.b();
                }
            }
        }

        this.runOnUiThread(new c(this));
    }

    protected void hideSoftInput() {
        class d implements Runnable {
            final UnityPlayer a;

            @Override
            public void run() {
                Rect rect0 = new Rect();
                UnityPlayer.this.reportSoftInputArea(rect0);
                UnityPlayer.this.reportSoftInputIsVisible(false);
                z z0 = UnityPlayer.this.mSoftInput;
                if(z0 != null) {
                    z0.b();
                    UnityPlayer.this.mSoftInput = null;
                    UnityPlayer.this.nativeReportKeyboardConfigChanged();
                }
            }
        }

        this.postOnUiThread(new d(this));
    }

    private void hideStatusBar() {
        Activity activity0 = this.mActivity;
        if(activity0 != null) {
            activity0.getWindow().setFlags(0x400, 0x400);
        }
    }

    public void init(int v, boolean z) {
    }

    private final native void initJni(Context arg1) {
    }

    protected boolean initializeGoogleAr() {
        if(this.m_ARCoreApi == null && this.mActivity != null && this.getARCoreEnabled()) {
            GoogleARCoreApi googleARCoreApi0 = new GoogleARCoreApi();
            this.m_ARCoreApi = googleARCoreApi0;
            googleARCoreApi0.initializeARCore(this.mActivity);
            if(!this.mState.b()) {
                this.m_ARCoreApi.resumeARCore();
            }
        }
        return false;
    }

    // 去混淆评级： 低(30)
    public boolean injectEvent(InputEvent inputEvent0) {
        return false;
    }

    protected boolean isFinishing() {
        if(this.mQuitting) {
            return true;
        }
        Activity activity0 = this.mActivity;
        if(activity0 != null) {
            this.mQuitting = activity0.isFinishing();
        }
        return this.mQuitting;
    }

    protected boolean isUaaLUseCase() {
        Activity activity0 = this.mActivity;
        if(activity0 != null) {
            String s = activity0.getCallingPackage();
            return s != null && s.equals("com.MonsterCouch.Wingspan");
        }
        return false;
    }

    protected void kill() {
        Process.killProcess(Process.myPid());
    }

    protected boolean loadLibrary(String s) {
        try {
            System.loadLibrary(s);
            return true;
        }
        catch(UnsatisfiedLinkError | Exception unused_ex) {
            return false;
        }
    }

    private static String loadNative(String s) {
        try {
            try {
                System.load((s + "/libmain.so"));
                goto label_8;
            }
            catch(UnsatisfiedLinkError unused_ex) {
            }
            try {
                System.loadLibrary("main");
                goto label_8;
            }
            catch(UnsatisfiedLinkError unsatisfiedLinkError0) {
            }
        }
        catch(SecurityException securityException0) {
            return UnityPlayer.logLoadLibMainError((s + "/libmain.so"), securityException0.toString());
        }
        return UnityPlayer.logLoadLibMainError((s + "/libmain.so"), unsatisfiedLinkError0.toString());
    label_8:
        if(NativeLoader.load(s)) {
            S.e();
            return "";
        }
        u.Log(6, "NativeLoader.load failure, Unity libraries were not loaded.");
        return "NativeLoader.load failure, Unity libraries were not loaded.";
    }

    private static String logLoadLibMainError(String s, String s1) {
        u.Log(6, "Failed to load \'libmain.so\'\n\n" + s1);
        return "Failed to load \'libmain.so\'\n\n" + s1;
    }

    // 去混淆评级： 低(30)
    public void lowMemory() {
        class A implements Runnable {
            final UnityPlayer a;

            @Override
            public void run() {
                UnityPlayer.this.nativeLowMemory();
            }
        }

    }

    private final native void nativeApplicationUnload() {
    }

    private final native boolean nativeDone() {
    }

    private final native void nativeFocusChanged(boolean arg1) {
    }

    private final native boolean nativeGetNoWindowMode() {
    }

    private final native void nativeHidePreservedContent() {
    }

    private final native boolean nativeInjectEvent(InputEvent arg1) {
    }

    private final native boolean nativeIsAutorotationOn() {
    }

    private final native void nativeLowMemory() {
    }

    private final native void nativeMuteMasterAudio(boolean arg1) {
    }

    private final native void nativeOrientationChanged(int arg1, int arg2) {
    }

    private final native boolean nativePause() {
    }

    private final native void nativeRecreateGfxState(int arg1, Surface arg2) {
    }

    private final native boolean nativeRender() {
    }

    private final native void nativeReportKeyboardConfigChanged() {
    }

    private final native void nativeRestartActivityIndicator() {
    }

    // 检测为 Lambda 实现
    private final native void nativeResume() [...]

    private final native void nativeSendSurfaceChangedEvent() {
    }

    private final native void nativeSetInputArea(int arg1, int arg2, int arg3, int arg4) {
    }

    private final native void nativeSetInputSelection(int arg1, int arg2) {
    }

    private final native void nativeSetInputString(String arg1) {
    }

    private final native void nativeSetKeyboardIsVisible(boolean arg1) {
    }

    private final native void nativeSetLaunchURL(String arg1) {
    }

    private final native void nativeSoftInputCanceled() {
    }

    private final native void nativeSoftInputClosed() {
    }

    private final native void nativeSoftInputLostFocus() {
    }

    private static native void nativeUnitySendMessage(String arg0, String arg1, byte[] arg2) {
    }

    public void newIntent(Intent intent0) {
        this.m_launchUri = intent0.getData();
        E unityPlayer$E0 = E.i;
        Handler handler0 = this.m_MainThread.a;
        if(handler0 != null) {
            Message.obtain(handler0, 0x8DD, unityPlayer$E0).sendToTarget();
        }
    }

    @Override  // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent0) {
        return this.mGlView.c() ? false : this.injectEvent(motionEvent0);
    }

    @Override  // android.view.View
    public boolean onKeyDown(int v, KeyEvent keyEvent0) {
        return this.injectEvent(keyEvent0);
    }

    @Override  // android.view.View
    public boolean onKeyLongPress(int v, KeyEvent keyEvent0) {
        return this.injectEvent(keyEvent0);
    }

    @Override  // android.view.View
    public boolean onKeyMultiple(int v, int v1, KeyEvent keyEvent0) {
        return this.injectEvent(keyEvent0);
    }

    @Override  // android.view.View
    public boolean onKeyUp(int v, KeyEvent keyEvent0) {
        return this.injectEvent(keyEvent0);
    }

    public void onPause() {
        MultiWindowSupport.saveMultiWindowMode(this.mActivity);
        if(MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            return;
        }
        this.setupUnityToBePaused();
    }

    public void onResume() {
        if(MultiWindowSupport.isInMultiWindowMode(this.mActivity) && !MultiWindowSupport.isMultiWindowModeChangedToTrue(this.mActivity)) {
            return;
        }
        this.setupUnityToBeResumed();
    }

    public void onStart() {
        if(!MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            return;
        }
        this.setupUnityToBeResumed();
    }

    public void onStop() {
        if(!MultiWindowSupport.isInMultiWindowMode(this.mActivity)) {
            return;
        }
        this.setupUnityToBePaused();
    }

    @Override  // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent0) {
        return this.mGlView.c() ? false : this.injectEvent(motionEvent0);
    }

    @Override  // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerQuitted() {
    }

    @Override  // com.unity3d.player.IUnityPlayerLifecycleEvents
    public void onUnityPlayerUnloaded() {
    }

    public void pause() {
        this.setupUnityToBePaused();
    }

    protected void pauseJavaAndCallUnloadCallback() {
        class p implements Runnable {
            final UnityPlayer a;

            @Override
            public void run() {
                UnityPlayer.this.setupUnityToBePaused();
                UnityPlayer.this.windowFocusChanged(false);
                UnityPlayer.this.m_UnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
            }
        }

        this.runOnUiThread(new p(this));
    }

    private void pauseUnity() {
        class y implements Runnable {
            final Semaphore a;
            final UnityPlayer b;

            y(Semaphore semaphore0) {
                this.a = semaphore0;
                super();
            }

            @Override
            public void run() {
                UnityPlayer.this.shutdown();
                this.a.release();
            }
        }


        class com.unity3d.player.UnityPlayer.z implements Runnable {
            final Semaphore a;
            final UnityPlayer b;

            com.unity3d.player.UnityPlayer.z(Semaphore semaphore0) {
                this.a = semaphore0;
                super();
            }

            @Override
            public void run() {
                if(UnityPlayer.this.nativePause()) {
                    UnityPlayer.this.mQuitting = true;
                    UnityPlayer.this.shutdown();
                    UnityPlayer.this.queueDestroy();
                }
                this.a.release();
            }
        }

        this.reportSoftInputStr(null, 1, true);
        if(this.mState.c() && !this.mState.b()) {
            this.mState.c(false);
            this.mState.e(true);
            if(this.m_AddPhoneCallListener) {
                this.m_TelephonyManager.listen(this.m_PhoneCallListener, 0);
            }
        }
    }

    void postOnUiThread(Runnable runnable0) {
        new Handler(Looper.getMainLooper()).post(runnable0);
    }

    private static void preloadJavaPlugins() {
        try {
            Class.forName("com.unity3d.JavaPluginPreloader");
        }
        catch(ClassNotFoundException linkageError0) {
            u.Log(6, "Java class preloading failed: " + linkageError0.getMessage());
        }
        catch(LinkageError unused_ex) {
        }
    }

    private void queueDestroy() {
        class x implements Runnable {
            final UnityPlayer a;

            @Override
            public void run() {
                UnityPlayer.this.destroy();
            }
        }

        u.Log(4, "Queue Destroy");
        this.runOnUiThread(() -> {
            Camera2Wrapper camera2Wrapper0 = UnityPlayer.this.m_Camera2Wrapper;
            if(camera2Wrapper0 != null) {
                camera2Wrapper0.a();
                UnityPlayer.this.m_Camera2Wrapper = null;
            }
            HFPStatus hFPStatus0 = UnityPlayer.this.m_HFPStatus;
            if(hFPStatus0 != null) {
                hFPStatus0.a();
                UnityPlayer.this.m_HFPStatus = null;
            }
            NetworkConnectivity networkConnectivity0 = UnityPlayer.this.m_NetworkConnectivity;
            if(networkConnectivity0 != null) {
                networkConnectivity0.a();
                UnityPlayer.this.m_NetworkConnectivity = null;
            }
            UnityPlayer.this.mQuitting = true;
            if(!UnityPlayer.this.mState.b()) {
                UnityPlayer.this.setupUnityToBePaused();
            }
            E unityPlayer$E0 = E.c;
            Handler handler0 = UnityPlayer.this.m_MainThread.a;
            if(handler0 != null) {
                Message.obtain(handler0, 0x8DD, unityPlayer$E0).sendToTarget();
            }
            try {
                UnityPlayer.this.m_MainThread.join(((long)SynchronizationTimeout.Destroy.getTimeout()));
            }
            catch(InterruptedException unused_ex) {
                UnityPlayer.this.m_MainThread.interrupt();
            }
            if(UnityPlayer.this.mProcessKillRequested) {
                UnityPlayer.this.m_UnityPlayerLifecycleEvents.onUnityPlayerQuitted();
                UnityPlayer.this.kill();
            }
            UnityPlayer.unloadNative();
        });
    }

    private void queueGLThreadEvent(G unityPlayer$G0) {
        if(this.isFinishing()) {
            return;
        }
        this.queueGLThreadEvent(unityPlayer$G0);
    }

    // 去混淆评级： 低(30)
    void queueGLThreadEvent(Runnable runnable0) {
    }

    public void quit() {
        this.destroy();
    }

    public void removeViewFromPlayer(View view0) {
        this.swapViews(this.mGlView, view0);
        boolean z = view0.getParent() == null;
        boolean z1 = this.mGlView.getParent() == this;
        if(!z || !z1) {
            if(!z) {
                u.Log(6, "removeViewFromPlayer: Failure removing view from hierarchy");
            }
            if(!z1) {
                u.Log(6, "removeVireFromPlayer: Failure agging old view to hierarchy");
            }
        }
    }

    public void reportError(String s, String s1) {
        u.Log(6, s + ": " + s1);
    }

    protected void reportSoftInputArea(Rect rect0) {
        class l extends G {
            final Rect b;
            final UnityPlayer c;

            l(Rect rect0) {
                this.b = rect0;
                super(null);
            }

            @Override  // com.unity3d.player.UnityPlayer$G
            public void a() {
                UnityPlayer.this.nativeSetInputArea(this.b.left, this.b.top, this.b.right, this.b.bottom);
            }
        }

        this.queueGLThreadEvent(new l(this, rect0));
    }

    protected void reportSoftInputIsVisible(boolean z) {
        class m extends G {
            final boolean b;
            final UnityPlayer c;

            m(boolean z) {
                this.b = z;
                super(null);
            }

            @Override  // com.unity3d.player.UnityPlayer$G
            public void a() {
                UnityPlayer.this.nativeSetKeyboardIsVisible(this.b);
            }
        }

        this.queueGLThreadEvent(new m(this, z));
    }

    protected void reportSoftInputSelection(int v, int v1) {
        class j extends G {
            final int b;
            final int c;
            final UnityPlayer d;

            j(int v, int v1) {
                this.b = v;
                this.c = v1;
                super(null);
            }

            @Override  // com.unity3d.player.UnityPlayer$G
            public void a() {
                UnityPlayer.this.nativeSetInputSelection(this.b, this.c);
            }
        }

        this.queueGLThreadEvent(new j(this, v, v1));
    }

    protected void reportSoftInputStr(String s, int v, boolean z) {
        class i extends G {
            final boolean b;
            final String c;
            final int d;
            final UnityPlayer e;

            i(boolean z, String s, int v) {
                this.b = z;
                this.c = s;
                this.d = v;
                super(null);
            }

            @Override  // com.unity3d.player.UnityPlayer$G
            public void a() {
                if(this.b) {
                    UnityPlayer.this.nativeSoftInputCanceled();
                }
                else {
                    String s = this.c;
                    if(s != null) {
                        UnityPlayer.this.nativeSetInputString(s);
                    }
                }
                if(this.d == 1) {
                    UnityPlayer.this.nativeSoftInputClosed();
                }
            }
        }

        if(v == 1) {
            this.hideSoftInput();
        }
        this.queueGLThreadEvent(new i(this, z, s, v));
    }

    protected void requestUserAuthorization(String s) {
        if(s != null && !s.isEmpty() && this.mActivity != null) {
            ModalWaitForPermissionResponse unityPermissions$ModalWaitForPermissionResponse0 = new ModalWaitForPermissionResponse();
            UnityPermissions.requestUserPermissions(this.mActivity, new String[]{s}, unityPermissions$ModalWaitForPermissionResponse0);
            unityPermissions$ModalWaitForPermissionResponse0.waitForResponse();
        }
    }

    public void resume() {
        this.setupUnityToBeResumed();
    }

    void runOnAnonymousThread(Runnable runnable0) {
        new Thread(runnable0).start();
    }

    void runOnUiThread(Runnable runnable0) {
        Activity activity0 = this.mActivity;
        if(activity0 != null) {
            activity0.runOnUiThread(runnable0);
            return;
        }
        if(Thread.currentThread() != Looper.getMainLooper().getThread()) {
            this.mHandler.post(runnable0);
            return;
        }
        runnable0.run();
    }

    // 去混淆评级： 低(40)
    void sendSurfaceChangedEvent() {
        class com.unity3d.player.UnityPlayer.u implements Runnable {
            final UnityPlayer a;

            @Override
            public void run() {
                UnityPlayer.this.nativeSendSurfaceChangedEvent();
            }
        }

    }

    protected void setCharacterLimit(int v) {
        class f implements Runnable {
            final int a;
            final UnityPlayer b;

            f(int v) {
                this.a = v;
                super();
            }

            @Override
            public void run() {
                z z0 = UnityPlayer.this.mSoftInput;
                if(z0 != null) {
                    int v = this.a;
                    EditText editText0 = z0.c;
                    if(editText0 != null) {
                        if(v > 0) {
                            editText0.setFilters(new InputFilter[]{new InputFilter.LengthFilter(v)});
                            return;
                        }
                        editText0.setFilters(new InputFilter[0]);
                    }
                }
            }
        }

        this.runOnUiThread(new f(this, v));
    }

    protected void setClipboardText(String s) {
        ClipData clipData0 = ClipData.newPlainText("Text", s);
        this.m_ClipboardManager.setPrimaryClip(clipData0);
    }

    protected void setHideInputField(boolean z) {
        class g implements Runnable {
            final boolean a;
            final UnityPlayer b;

            g(boolean z) {
                this.a = z;
                super();
            }

            @Override
            public void run() {
                z z0 = UnityPlayer.this.mSoftInput;
                if(z0 != null) {
                    z0.a(this.a);
                }
            }
        }

        this.runOnUiThread(new g(this, z));
    }

    public void setMainSurfaceViewAspectRatio(float f) {
        class r implements Runnable {
            final float a;
            final UnityPlayer b;

            r(float f) {
                this.a = f;
                super();
            }

            @Override
            public void run() {
                UnityPlayer.this.mGlView.a(this.a);
            }
        }

        if(this.mGlView != null) {
            this.runOnUiThread(new r(this, f));
        }
    }

    public void setScreenBrightness(float f) {
        class s implements Runnable {
            final float a;
            final UnityPlayer b;

            s(float f) {
                this.a = f;
                super();
            }

            @Override
            public void run() {
                WindowManager.LayoutParams windowManager$LayoutParams0 = UnityPlayer.this.m_Window.getAttributes();
                windowManager$LayoutParams0.screenBrightness = this.a;
                UnityPlayer.this.m_Window.setAttributes(windowManager$LayoutParams0);
            }
        }

        float f1 = Math.max(0.04f, f);
        if(this.m_Window != null && this.getScreenBrightness() != f1) {
            this.runOnUiThread(new s(this, f1));
        }
    }

    protected void setSelection(int v, int v1) {
        class h implements Runnable {
            final int a;
            final int b;
            final UnityPlayer c;

            h(int v, int v1) {
                this.a = v;
                this.b = v1;
                super();
            }

            @Override
            public void run() {
                z z0 = UnityPlayer.this.mSoftInput;
                if(z0 != null) {
                    int v = this.a;
                    int v1 = this.b;
                    EditText editText0 = z0.c;
                    if(editText0 != null) {
                        int v2 = v1 + v;
                        if(editText0.getText().length() >= v2) {
                            z0.c.setSelection(v, v2);
                        }
                    }
                }
            }
        }

        this.runOnUiThread(new h(this, v, v1));
    }

    protected void setSoftInputStr(String s) {
        class e implements Runnable {
            final String a;
            final UnityPlayer b;

            e(String s) {
                this.a = s;
                super();
            }

            @Override
            public void run() {
                z z0 = UnityPlayer.this.mSoftInput;
                if(z0 != null) {
                    String s = this.a;
                    if(s != null) {
                        EditText editText0 = z0.c;
                        if(editText0 != null) {
                            editText0.setText(s);
                            z0.c.setSelection(s.length());
                        }
                    }
                }
            }
        }

        this.runOnUiThread(new e(this, s));
    }

    protected void setupUnityToBePaused() {
        GoogleARCoreApi googleARCoreApi0 = this.m_ARCoreApi;
        if(googleARCoreApi0 != null) {
            googleARCoreApi0.pauseARCore();
        }
        c0 c00 = this.mVideoPlayerProxy;
        if(c00 != null) {
            c00.c();
        }
        AudioVolumeHandler audioVolumeHandler0 = this.m_AudioVolumeHandler;
        if(audioVolumeHandler0 != null) {
            audioVolumeHandler0.a();
            this.m_AudioVolumeHandler = null;
        }
        OrientationLockListener orientationLockListener0 = this.m_OrientationLockListener;
        if(orientationLockListener0 != null) {
            orientationLockListener0.a();
            this.m_OrientationLockListener = null;
        }
        this.pauseUnity();
    }

    protected void setupUnityToBeResumed() {
        GoogleARCoreApi googleARCoreApi0 = this.m_ARCoreApi;
        if(googleARCoreApi0 != null) {
            googleARCoreApi0.resumeARCore();
        }
        this.mState.e(false);
        c0 c00 = this.mVideoPlayerProxy;
        if(c00 != null) {
            c00.d();
        }
        this.checkResumePlayer();
        if(this.m_AudioVolumeHandler == null) {
            this.m_AudioVolumeHandler = new AudioVolumeHandler(this.mContext);
        }
        this.prevConfig = this.getResources().getConfiguration();
    }

    protected void showSoftInput(String s, int v, boolean z, boolean z1, boolean z2, boolean z3, String s1, int v1, boolean z4, boolean z5) {
        class b implements Runnable {
            final UnityPlayer a;
            final String b;
            final int c;
            final boolean d;
            final boolean e;
            final boolean f;
            final boolean g;
            final String h;
            final int i;
            final boolean j;
            final boolean k;
            final UnityPlayer l;

            b(UnityPlayer unityPlayer1, String s, int v, boolean z, boolean z1, boolean z2, boolean z3, String s1, int v1, boolean z4, boolean z5) {
                this.a = unityPlayer1;
                this.b = s;
                this.c = v;
                this.d = z;
                this.e = z1;
                this.f = z2;
                this.g = z3;
                this.h = s1;
                this.i = v1;
                this.j = z4;
                this.k = z5;
                super();
            }

            @Override
            public void run() {
                class com.unity3d.player.UnityPlayer.b.a extends com.unity3d.player.A {
                    final b a;

                    @Override  // com.unity3d.player.A
                    public void a() {
                        UnityPlayer.this.nativeSoftInputLostFocus();
                        UnityPlayer.this.reportSoftInputStr(null, 1, false);
                    }
                }

                UnityPlayer unityPlayer0 = UnityPlayer.this;
                com.unity3d.player.F f0 = SoftInputProvider.a();
                Context context0 = UnityPlayer.this.mContext;
                UnityPlayer unityPlayer1 = this.a;
                String s = this.b;
                int v = this.c;
                boolean z = this.d;
                boolean z1 = this.e;
                boolean z2 = this.f;
                boolean z3 = this.g;
                String s1 = this.h;
                int v1 = this.i;
                boolean z4 = this.j;
                boolean z5 = this.k;
                J j0 = f0.ordinal() == 2 ? new com.unity3d.player.E(context0, unityPlayer1) : new J(context0, unityPlayer1);
                j0.a(s, v, z, z1, z2, z3, s1, v1, z4, z5);
                unityPlayer0.mSoftInput = j0;
                z z6 = UnityPlayer.this.mSoftInput;
                z6.f = new com.unity3d.player.UnityPlayer.b.a(this);
                z6.d();
                UnityPlayer.this.nativeReportKeyboardConfigChanged();
            }
        }

        this.postOnUiThread(new b(this, this, s, v, z, z1, z2, z3, s1, v1, z4, z5));
    }

    protected boolean showVideoPlayer(String s, int v, int v1, int v2, boolean z, int v3, int v4) {
        class n implements com.unity3d.player.c0.a {
            final UnityPlayer a;

            public void a() {
                UnityPlayer.this.mVideoPlayerProxy = null;
            }
        }


        class o implements Runnable {
            final UnityPlayer a;

            @Override
            public void run() {
                if(UnityPlayer.this.nativeIsAutorotationOn()) {
                    UnityPlayer unityPlayer0 = UnityPlayer.this;
                    Activity activity0 = unityPlayer0.mActivity;
                    if(activity0 != null) {
                        activity0.setRequestedOrientation(unityPlayer0.mInitialScreenOrientation);
                    }
                }
            }
        }

        if(this.mVideoPlayerProxy == null) {
            this.mVideoPlayerProxy = new c0(this);
        }
        boolean z1 = this.mVideoPlayerProxy.a(this.mContext, s, v, v1, v2, z, ((long)v3), ((long)v4), new n(this));
        if(z1) {
            this.runOnUiThread(new o(this));
        }
        return z1;
    }

    private void shutdown() {
        this.mProcessKillRequested = this.nativeDone();
        this.mState.d(false);
    }

    protected boolean skipPermissionsDialog() {
        return this.mActivity == null ? false : UnityPermissions.skipPermissionsDialog(this.mActivity);
    }

    public boolean startOrientationListener(int v) {
        class q extends OrientationEventListener {
            final UnityPlayer a;

            q(Context context0, int v) {
                super(context0, v);
            }

            @Override  // android.view.OrientationEventListener
            public void onOrientationChanged(int v) {
                F unityPlayer$F0 = UnityPlayer.this.m_MainThread;
                unityPlayer$F0.f = UnityPlayer.this.mNaturalOrientation;
                unityPlayer$F0.g = v;
                E unityPlayer$E0 = E.j;
                Handler handler0 = unityPlayer$F0.a;
                if(handler0 != null) {
                    Message.obtain(handler0, 0x8DD, unityPlayer$E0).sendToTarget();
                }
            }
        }

        String s;
        if(this.mOrientationListener == null) {
            q unityPlayer$q0 = new q(this, this.mContext, v);
            this.mOrientationListener = unityPlayer$q0;
            if(unityPlayer$q0.canDetectOrientation()) {
                this.mOrientationListener.enable();
                return true;
            }
            s = "Orientation Listener cannot detect orientation.";
        }
        else {
            s = "Orientation Listener already started.";
        }
        u.Log(5, s);
        return false;
    }

    public boolean stopOrientationListener() {
        OrientationEventListener orientationEventListener0 = this.mOrientationListener;
        if(orientationEventListener0 == null) {
            u.Log(5, "Orientation Listener was not started.");
            return false;
        }
        orientationEventListener0.disable();
        this.mOrientationListener = null;
        return true;
    }

    private void swapViews(View view0, View view1) {
        boolean z;
        if(this.mState.b()) {
            z = false;
        }
        else {
            this.setupUnityToBePaused();
            z = true;
        }
        if(view0 != null) {
            ViewParent viewParent0 = view0.getParent();
            if(!(viewParent0 instanceof UnityPlayer) || ((UnityPlayer)viewParent0) != this) {
                if(viewParent0 instanceof ViewGroup) {
                    ((ViewGroup)viewParent0).removeView(view0);
                }
                this.addView(view0);
                this.bringChildToFront(view0);
                view0.setVisibility(0);
            }
        }
        if(view1 != null && view1.getParent() == this) {
            view1.setVisibility(8);
            this.removeView(view1);
        }
        if(z) {
            this.setupUnityToBeResumed();
        }
    }

    protected void toggleGyroscopeSensor(boolean z) {
        SensorManager sensorManager0 = (SensorManager)this.mContext.getSystemService("sensor");
        Sensor sensor0 = sensorManager0.getDefaultSensor(11);
        if(z) {
            sensorManager0.registerListener(this.m_FakeListener, sensor0, 1);
            return;
        }
        sensorManager0.unregisterListener(this.m_FakeListener);
    }

    public void unload() {
        this.nativeApplicationUnload();
    }

    // 去混淆评级： 低(40)
    private static void unloadNative() {
    }

    // 去混淆评级： 中等(50)
    private boolean updateDisplayInternal(int v, Surface surface0) {
        class v implements Runnable {
            final int a;
            final Surface b;
            final Semaphore c;
            final UnityPlayer d;

            v(int v, Surface surface0, Semaphore semaphore0) {
                this.a = v;
                this.b = surface0;
                this.c = semaphore0;
                super();
            }

            @Override
            public void run() {
                UnityPlayer.this.nativeRecreateGfxState(this.a, this.b);
                this.c.release();
            }
        }

        return false;
    }

    void updateGLDisplay(int v, Surface surface0) {
        if(this.mMainDisplayOverride) {
            return;
        }
        this.updateDisplayInternal(v, surface0);
    }

    public void windowFocusChanged(boolean z) {
        this.mState.b(z);
        if(this.mState.a() && (this.mSoftInput == null || this.mSoftInput.c())) {
            if(z) {
                E unityPlayer$E0 = E.g;
                Handler handler0 = this.m_MainThread.a;
                if(handler0 != null) {
                    Message.obtain(handler0, 0x8DD, unityPlayer$E0).sendToTarget();
                }
            }
            else {
                E unityPlayer$E1 = E.f;
                Handler handler1 = this.m_MainThread.a;
                if(handler1 != null) {
                    Message.obtain(handler1, 0x8DD, unityPlayer$E1).sendToTarget();
                }
            }
            this.checkResumePlayer();
        }
    }
}

