package com.unity3d.plugin.downloader;

import com.unity3d.plugin.downloader.c.j;

public class UnityDownloaderService extends j {
    static String BASE64_PUBLIC_KEY = "REPLACE THIS WITH YOUR PUBLIC KEY - DONE FROM C#";
    static byte[] SALT;

    static {
        UnityDownloaderService.SALT = new byte[]{1, 43, -12, -1, 54, 98, -100, -12, 43, 2, -8, -4, 9, 5, -106, -108, -33, 45, -1, 84};
    }

    // 去混淆评级： 低(20)
    @Override  // com.unity3d.plugin.downloader.c.j
    public final String g() {
        return "REPLACE THIS WITH YOUR PUBLIC KEY - DONE FROM C#";
    }

    @Override  // com.unity3d.plugin.downloader.c.j
    public final byte[] h() {
        return UnityDownloaderService.SALT;
    }

    // 去混淆评级： 低(20)
    @Override  // com.unity3d.plugin.downloader.c.j
    public final String i() {
        return "com.unity3d.plugin.downloader.UnityAlarmReceiver";
    }
}

