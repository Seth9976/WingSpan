package com.voxelbusters.essentialkit.utilities;

import android.content.Context;
import android.util.Log;

public class Logger {
    public static String TAG = "[Voxel Busters : Essential Kit]";

    public static void debug(String s) {
        if(Logger.isDebugEnabled()) {
            Log.d("[Voxel Busters : Essential Kit]", String.format("%s %s", "[Voxel Busters : Essential Kit]", s));
        }
    }

    // 去混淆评级： 低(20)
    public static void error(String s) {
        Log.e("[Voxel Busters : Essential Kit]", String.format("%s %s", "[Voxel Busters : Essential Kit]", s));
    }

    private static String getTag() [...] // 潜在的解密器

    private static boolean isDebugEnabled() {
        Context context0 = NativePluginHelper.getUnityContext();
        return context0 == null ? false : ApplicationUtil.isDebugBuild(context0);
    }

    // 去混淆评级： 低(20)
    public static void warning(String s) {
        Log.w("[Voxel Busters : Essential Kit]", String.format("%s %s", "[Voxel Busters : Essential Kit]", s));
    }
}

