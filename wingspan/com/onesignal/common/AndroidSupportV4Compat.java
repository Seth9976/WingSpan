package com.onesignal.common;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0007"}, d2 = {"Lcom/onesignal/common/AndroidSupportV4Compat;", "", "()V", "ActivityCompat", "ActivityCompatApi23", "ContextCompat", "RequestPermissionsRequestCodeValidator", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class AndroidSupportV4Compat {
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u000E\u0010\u0007\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0002\u0010\fJ\u001A\u0010\r\u001A\u00020\u000E2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\t¨\u0006\u0010"}, d2 = {"Lcom/onesignal/common/AndroidSupportV4Compat$ActivityCompat;", "", "()V", "requestPermissions", "", "activity", "Landroid/app/Activity;", "permissions", "", "", "requestCode", "", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "shouldShowRequestPermissionRationale", "", "permission", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class ActivityCompat {
        public static final ActivityCompat INSTANCE;

        static {
            ActivityCompat.INSTANCE = new ActivityCompat();
        }

        public final void requestPermissions(Activity activity0, String[] arr_s, int v) {
            Intrinsics.checkNotNullParameter(activity0, "activity");
            Intrinsics.checkNotNullParameter(arr_s, "permissions");
            ActivityCompatApi23.INSTANCE.requestPermissions(activity0, arr_s, v);
        }

        public final boolean shouldShowRequestPermissionRationale(Activity activity0, String s) {
            return ActivityCompatApi23.INSTANCE.shouldShowRequestPermissionRationale(activity0, s);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\b2\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0002\u0010\fJ\u001A\u0010\r\u001A\u00020\u000E2\b\u0010\u0005\u001A\u0004\u0018\u00010\u00062\b\u0010\u000F\u001A\u0004\u0018\u00010\t¨\u0006\u0010"}, d2 = {"Lcom/onesignal/common/AndroidSupportV4Compat$ActivityCompatApi23;", "", "()V", "requestPermissions", "", "activity", "Landroid/app/Activity;", "permissions", "", "", "requestCode", "", "(Landroid/app/Activity;[Ljava/lang/String;I)V", "shouldShowRequestPermissionRationale", "", "permission", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class ActivityCompatApi23 {
        public static final ActivityCompatApi23 INSTANCE;

        static {
            ActivityCompatApi23.INSTANCE = new ActivityCompatApi23();
        }

        public final void requestPermissions(Activity activity0, String[] arr_s, int v) {
            Intrinsics.checkNotNullParameter(activity0, "activity");
            if(activity0 instanceof RequestPermissionsRequestCodeValidator) {
                ((RequestPermissionsRequestCodeValidator)activity0).validateRequestPermissionsRequestCode(v);
            }
            Intrinsics.checkNotNull(arr_s);
            activity0.requestPermissions(arr_s, v);
        }

        public final boolean shouldShowRequestPermissionRationale(Activity activity0, String s) {
            Intrinsics.checkNotNull(activity0);
            Intrinsics.checkNotNull(s);
            return androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale(activity0, s);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bJ\u0016\u0010\t\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u0004¨\u0006\u000B"}, d2 = {"Lcom/onesignal/common/AndroidSupportV4Compat$ContextCompat;", "", "()V", "checkSelfPermission", "", "context", "Landroid/content/Context;", "permission", "", "getColor", "id", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class ContextCompat {
        public static final ContextCompat INSTANCE;

        static {
            ContextCompat.INSTANCE = new ContextCompat();
        }

        public final int checkSelfPermission(Context context0, String s) {
            Intrinsics.checkNotNullParameter(context0, "context");
            Intrinsics.checkNotNullParameter(s, "permission");
            try {
                return context0.checkPermission(s, Process.myPid(), Process.myUid());
            }
            catch(Throwable unused_ex) {
                Log.e("OneSignal", "checkSelfPermission failed, returning PERMISSION_DENIED");
                return -1;
            }
        }

        public final int getColor(Context context0, int v) {
            Intrinsics.checkNotNullParameter(context0, "context");
            return context0.getColor(v);
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/onesignal/common/AndroidSupportV4Compat$RequestPermissionsRequestCodeValidator;", "", "validateRequestPermissionsRequestCode", "", "requestCode", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int arg1);
    }

}

