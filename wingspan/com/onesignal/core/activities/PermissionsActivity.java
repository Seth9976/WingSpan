package com.onesignal.core.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.onesignal.OneSignal;
import com.onesignal.common.AndroidSupportV4Compat.ActivityCompat;
import com.onesignal.core.R.anim;
import com.onesignal.core.internal.permissions.IRequestPermissionService.PermissionCallback;
import com.onesignal.core.internal.permissions.impl.RequestPermissionService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u000E\u001A\u00020\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u0012H\u0014J+\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u0014\u001A\u00020\u00152\f\u0010\u0016\u001A\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0018\u001A\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001AJ\u0012\u0010\u001B\u001A\u00020\u000B2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001C\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rH\u0002J\b\u0010\u001D\u001A\u00020\u001EH\u0002R\u0010\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001A\u0004\u0018\u00010\u0004X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001A\u0004\u0018\u00010\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001A\u0004\u0018\u00010\tX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/onesignal/core/activities/PermissionsActivity;", "Landroid/app/Activity;", "()V", "androidPermissionString", "", "permissionRequestType", "preferenceService", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "requestPermissionService", "Lcom/onesignal/core/internal/permissions/impl/RequestPermissionService;", "handleBundleParams", "", "extras", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "onNewIntent", "intent", "Landroid/content/Intent;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermission", "reregisterCallbackHandlers", "shouldShowSettings", "", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PermissionsActivity extends Activity {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/onesignal/core/activities/PermissionsActivity$Companion;", "", "()V", "DELAY_TIME_CALLBACK_CALL", "", "INTENT_EXTRA_ANDROID_PERMISSION_STRING", "", "INTENT_EXTRA_CALLBACK_CLASS", "INTENT_EXTRA_PERMISSION_TYPE", "ONESIGNAL_PERMISSION_REQUEST_CODE", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    public static final int DELAY_TIME_CALLBACK_CALL = 500;
    public static final String INTENT_EXTRA_ANDROID_PERMISSION_STRING = "INTENT_EXTRA_ANDROID_PERMISSION_STRING";
    public static final String INTENT_EXTRA_CALLBACK_CLASS = "INTENT_EXTRA_CALLBACK_CLASS";
    public static final String INTENT_EXTRA_PERMISSION_TYPE = "INTENT_EXTRA_PERMISSION_TYPE";
    public static final int ONESIGNAL_PERMISSION_REQUEST_CODE = 2;
    private String androidPermissionString;
    private String permissionRequestType;
    private IPreferencesService preferenceService;
    private RequestPermissionService requestPermissionService;

    // 检测为 Lambda 实现
    public static void $r8$lambda$_fGz_SOmbIhPQvxRD-41f99MrRo(int[] arr_v, PermissionsActivity permissionsActivity0) [...]

    static {
        PermissionsActivity.Companion = new Companion(null);
    }

    private final void handleBundleParams(Bundle bundle0) {
        this.reregisterCallbackHandlers(bundle0);
        Intrinsics.checkNotNull(bundle0);
        this.permissionRequestType = bundle0.getString("INTENT_EXTRA_PERMISSION_TYPE");
        String s = bundle0.getString("INTENT_EXTRA_ANDROID_PERMISSION_STRING");
        this.androidPermissionString = s;
        this.requestPermission(s);
    }

    @Override  // android.app.Activity
    protected void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        if(!OneSignal.initWithContext(this)) {
            return;
        }
        this.requestPermissionService = (RequestPermissionService)OneSignal.INSTANCE.getServices().getService(RequestPermissionService.class);
        this.preferenceService = (IPreferencesService)OneSignal.INSTANCE.getServices().getService(IPreferencesService.class);
        this.handleBundleParams(this.getIntent().getExtras());
    }

    @Override  // android.app.Activity
    protected void onNewIntent(Intent intent0) {
        Intrinsics.checkNotNullParameter(intent0, "intent");
        super.onNewIntent(intent0);
        this.handleBundleParams(intent0.getExtras());
    }

    @Override  // android.app.Activity
    public void onRequestPermissionsResult(int v, String[] arr_s, int[] arr_v) {
        Intrinsics.checkNotNullParameter(arr_s, "permissions");
        Intrinsics.checkNotNullParameter(arr_v, "grantResults");
        RequestPermissionService requestPermissionService0 = this.requestPermissionService;
        Intrinsics.checkNotNull(requestPermissionService0);
        requestPermissionService0.setWaiting(false);
        if(v == 2) {
            new Handler().postDelayed(() -> PermissionsActivity.onRequestPermissionsResult$lambda-0(arr_v, this), 500L);
        }
        this.finish();
        this.overridePendingTransition(anim.onesignal_fade_in, anim.onesignal_fade_out);
    }

    private static final void onRequestPermissionsResult$lambda-0(int[] arr_v, PermissionsActivity permissionsActivity0) {
        Intrinsics.checkNotNullParameter(arr_v, "$grantResults");
        Intrinsics.checkNotNullParameter(permissionsActivity0, "this$0");
        boolean z = arr_v.length > 0 && arr_v[0] == 0;
        RequestPermissionService requestPermissionService0 = permissionsActivity0.requestPermissionService;
        Intrinsics.checkNotNull(requestPermissionService0);
        String s = permissionsActivity0.permissionRequestType;
        Intrinsics.checkNotNull(s);
        PermissionCallback iRequestPermissionService$PermissionCallback0 = requestPermissionService0.getCallback(s);
        if(iRequestPermissionService$PermissionCallback0 == null) {
            throw new RuntimeException("Missing handler for permissionRequestType: " + permissionsActivity0.permissionRequestType);
        }
        if(z) {
            iRequestPermissionService$PermissionCallback0.onAccept();
            IPreferencesService iPreferencesService0 = permissionsActivity0.preferenceService;
            Intrinsics.checkNotNull(iPreferencesService0);
            iPreferencesService0.saveBool("OneSignal", "USER_RESOLVED_PERMISSION_" + permissionsActivity0.androidPermissionString, Boolean.TRUE);
            return;
        }
        iRequestPermissionService$PermissionCallback0.onReject(permissionsActivity0.shouldShowSettings());
    }

    private final void requestPermission(String s) {
        RequestPermissionService requestPermissionService0 = this.requestPermissionService;
        Intrinsics.checkNotNull(requestPermissionService0);
        if(!requestPermissionService0.getWaiting()) {
            RequestPermissionService requestPermissionService1 = this.requestPermissionService;
            Intrinsics.checkNotNull(requestPermissionService1);
            requestPermissionService1.setWaiting(true);
            RequestPermissionService requestPermissionService2 = this.requestPermissionService;
            Intrinsics.checkNotNull(requestPermissionService2);
            requestPermissionService2.setShouldShowRequestPermissionRationaleBeforeRequest(ActivityCompat.INSTANCE.shouldShowRequestPermissionRationale(this, s));
            ActivityCompat.INSTANCE.requestPermissions(this, new String[]{s}, 2);
        }
    }

    private final void reregisterCallbackHandlers(Bundle bundle0) {
        Intrinsics.checkNotNull(bundle0);
        String s = bundle0.getString("INTENT_EXTRA_CALLBACK_CLASS");
        try {
            Class.forName(s);
        }
        catch(ClassNotFoundException unused_ex) {
            throw new RuntimeException("Could not find callback class for PermissionActivity: " + s);
        }
    }

    private final boolean shouldShowSettings() {
        RequestPermissionService requestPermissionService0 = this.requestPermissionService;
        Intrinsics.checkNotNull(requestPermissionService0);
        if(!requestPermissionService0.getFallbackToSettings()) {
            return false;
        }
        RequestPermissionService requestPermissionService1 = this.requestPermissionService;
        Intrinsics.checkNotNull(requestPermissionService1);
        if(requestPermissionService1.getShouldShowRequestPermissionRationaleBeforeRequest() && !ActivityCompat.INSTANCE.shouldShowRequestPermissionRationale(this, this.androidPermissionString)) {
            IPreferencesService iPreferencesService0 = this.preferenceService;
            Intrinsics.checkNotNull(iPreferencesService0);
            iPreferencesService0.saveBool("OneSignal", "USER_RESOLVED_PERMISSION_" + this.androidPermissionString, Boolean.TRUE);
            return false;
        }
        IPreferencesService iPreferencesService1 = this.preferenceService;
        Intrinsics.checkNotNull(iPreferencesService1);
        Boolean boolean0 = iPreferencesService1.getBool("OneSignal", "USER_RESOLVED_PERMISSION_" + this.androidPermissionString, Boolean.FALSE);
        Intrinsics.checkNotNull(boolean0);
        return boolean0.booleanValue();
    }
}

