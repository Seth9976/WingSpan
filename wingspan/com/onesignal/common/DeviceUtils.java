package com.onesignal.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001A\u00020\bJ\u0015\u0010\t\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0002\u0010\nJ\u0016\u0010\u000B\u001A\u00020\f2\u000E\u0010\r\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u000F0\u000ER\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/onesignal/common/DeviceUtils;", "", "()V", "MARGIN_ERROR_PX_SIZE", "", "getCarrierName", "", "appContext", "Landroid/content/Context;", "getNetType", "(Landroid/content/Context;)Ljava/lang/Integer;", "isKeyboardUp", "", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE;
    private static final int MARGIN_ERROR_PX_SIZE;

    static {
        DeviceUtils.INSTANCE = new DeviceUtils();
        DeviceUtils.MARGIN_ERROR_PX_SIZE = ViewUtils.INSTANCE.dpToPx(24);
    }

    public final String getCarrierName(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "appContext");
        try {
            Object object0 = context0.getSystemService("phone");
            Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            String s = ((TelephonyManager)object0).getNetworkOperatorName();
            if(!Intrinsics.areEqual("", s)) {
                return s;
            }
        }
        catch(Throwable throwable0) {
            throwable0.printStackTrace();
        }
        return null;
    }

    public final Integer getNetType(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "appContext");
        Object object0 = context0.getSystemService("connectivity");
        Intrinsics.checkNotNull(object0, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo networkInfo0 = ((ConnectivityManager)object0).getActiveNetworkInfo();
        if(networkInfo0 != null) {
            switch(networkInfo0.getType()) {
                case 1: 
                case 9: {
                    return 0;
                }
                default: {
                    return 1;
                }
            }
        }
        return null;
    }

    public final boolean isKeyboardUp(WeakReference weakReference0) {
        Intrinsics.checkNotNullParameter(weakReference0, "activityWeakReference");
        DisplayMetrics displayMetrics0 = new DisplayMetrics();
        Rect rect0 = new Rect();
        if(weakReference0.get() != null) {
            Object object0 = weakReference0.get();
            Intrinsics.checkNotNull(object0);
            Window window0 = ((Activity)object0).getWindow();
            View view0 = window0.getDecorView();
            view0.getWindowVisibleDisplayFrame(rect0);
            window0.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics0);
            return view0 != null && displayMetrics0.heightPixels - rect0.bottom > DeviceUtils.MARGIN_ERROR_PX_SIZE;
        }
        return false;
    }
}

