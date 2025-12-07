package com.voxelbusters.essentialkit.utilities;

import android.content.Context;
import com.unity3d.player.UnityPlayer;

public class NativePluginHelper {
    public static Context getUnityContext() {
        try {
            Class.forName("com.unity3d.player.UnityPlayer");
            return UnityPlayer.currentActivity;
        }
        catch(ClassNotFoundException unused_ex) {
            System.out.println("Unable to get unity context!");
            return null;
        }
    }
}

