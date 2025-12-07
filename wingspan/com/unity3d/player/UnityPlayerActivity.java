package com.unity3d.player;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import np.dcc.protect.EntryPoint;

public class UnityPlayerActivity extends Activity implements IUnityPlayerLifecycleEvents {
    public static String KEY = null;
    private static final String hexString = "0123456789ABCDEF";
    protected UnityPlayer mUnityPlayer;

    static {
        EntryPoint.stub(8);
    }

    public static native String adjustValue(String arg0) {
    }

    @Override  // android.app.Activity
    public native boolean dispatchKeyEvent(KeyEvent arg1) {
    }

    @Override  // android.app.Activity
    public native void onConfigurationChanged(Configuration arg1) {
    }

    @Override  // android.app.Activity
    protected native void onCreate(Bundle arg1) {
    }

    @Override  // android.app.Activity
    protected native void onDestroy() {
    }

    @Override  // android.app.Activity
    public native boolean onGenericMotionEvent(MotionEvent arg1) {
    }

    @Override  // android.app.Activity
    public native boolean onKeyDown(int arg1, KeyEvent arg2) {
    }

    @Override  // android.app.Activity
    public native boolean onKeyUp(int arg1, KeyEvent arg2) {
    }

    @Override  // android.app.Activity
    public native void onLowMemory() {
    }

    @Override  // android.app.Activity
    protected native void onNewIntent(Intent arg1) {
    }

    @Override  // android.app.Activity
    protected native void onPause() {
    }

    @Override  // android.app.Activity
    protected native void onResume() {
    }

    @Override  // android.app.Activity
    protected native void onStart() {
    }

    @Override  // android.app.Activity
    protected native void onStop() {
    }

    @Override  // android.app.Activity
    public native boolean onTouchEvent(MotionEvent arg1) {
    }

    @Override  // android.app.Activity
    public native void onTrimMemory(int arg1) {
    }

    @Override  // com.unity3d.player.IUnityPlayerLifecycleEvents
    public native void onUnityPlayerQuitted() {
    }

    @Override  // com.unity3d.player.IUnityPlayerLifecycleEvents
    public native void onUnityPlayerUnloaded() {
    }

    @Override  // android.app.Activity
    public native void onWindowFocusChanged(boolean arg1) {
    }

    protected native String updateUnityCommandLineArguments(String arg1) {
    }
}

