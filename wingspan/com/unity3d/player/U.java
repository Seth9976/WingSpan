package com.unity3d.player;

import android.util.Log;

abstract class u {
    protected static boolean a;

    protected static void Log(int v, String s) {
        if(u.a) {
            return;
        }
        if(v == 6) {
            Log.e("Unity", s);
        }
        if(v == 5) {
            Log.w("Unity", s);
        }
    }
}

