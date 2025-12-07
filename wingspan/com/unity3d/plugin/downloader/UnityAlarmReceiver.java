package com.unity3d.plugin.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import com.unity3d.plugin.downloader.c.j;

public class UnityAlarmReceiver extends BroadcastReceiver {
    @Override  // android.content.BroadcastReceiver
    public void onReceive(Context context0, Intent intent0) {
        try {
            j.a(context0, intent0, UnityDownloaderService.class);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
        }
    }
}

