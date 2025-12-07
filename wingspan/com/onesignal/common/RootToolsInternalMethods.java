package com.onesignal.common;

import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001A\u00020\u00048F¢\u0006\u0006\u001A\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/onesignal/common/RootToolsInternalMethods;", "", "()V", "isRooted", "", "()Z", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class RootToolsInternalMethods {
    public static final RootToolsInternalMethods INSTANCE;

    static {
        RootToolsInternalMethods.INSTANCE = new RootToolsInternalMethods();
    }

    public final boolean isRooted() {
        int v = 0;
        while(v < 8) {
            try {
                if(new File(new String[]{"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"}[v] + "su").exists()) {
                    return true;
                }
                ++v;
                continue;
            }
            catch(Throwable unused_ex) {
            }
            break;
        }
        return false;
    }
}

