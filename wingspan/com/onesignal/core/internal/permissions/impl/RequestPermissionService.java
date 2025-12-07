package com.onesignal.core.internal.permissions.impl;

import android.app.Activity;
import android.content.Intent;
import com.onesignal.core.R.anim;
import com.onesignal.core.activities.PermissionsActivity;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.permissions.IRequestPermissionService.PermissionCallback;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001A\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001A\u00020\bJ\u0018\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u0018\u001A\u00020\b2\u0006\u0010\u001B\u001A\u00020\tH\u0016J0\u0010\u001C\u001A\u00020\u001A2\u0006\u0010\u001D\u001A\u00020\f2\b\u0010\u001E\u001A\u0004\u0018\u00010\b2\b\u0010\u001F\u001A\u0004\u0018\u00010\b2\n\u0010 \u001A\u0006\u0012\u0002\b\u00030!H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u0006\u001A\"\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010R\u001A\u0010\u0011\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u000E\"\u0004\b\u0013\u0010\u0010R\u001A\u0010\u0014\u001A\u00020\fX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0015\u0010\u000E\"\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/onesignal/core/internal/permissions/impl/RequestPermissionService;", "Landroid/app/Activity;", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService;", "_application", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "callbackMap", "Ljava/util/HashMap;", "", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "Lkotlin/collections/HashMap;", "fallbackToSettings", "", "getFallbackToSettings", "()Z", "setFallbackToSettings", "(Z)V", "shouldShowRequestPermissionRationaleBeforeRequest", "getShouldShowRequestPermissionRationaleBeforeRequest", "setShouldShowRequestPermissionRationaleBeforeRequest", "waiting", "getWaiting", "setWaiting", "getCallback", "permissionType", "registerAsCallback", "", "callback", "startPrompt", "fallbackCondition", "permissionRequestType", "androidPermissionString", "callbackClass", "Ljava/lang/Class;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class RequestPermissionService extends Activity implements IRequestPermissionService {
    private final IApplicationService _application;
    private final HashMap callbackMap;
    private boolean fallbackToSettings;
    private boolean shouldShowRequestPermissionRationaleBeforeRequest;
    private boolean waiting;

    public RequestPermissionService(IApplicationService iApplicationService0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_application");
        super();
        this._application = iApplicationService0;
        this.callbackMap = new HashMap();
    }

    public final PermissionCallback getCallback(String s) {
        Intrinsics.checkNotNullParameter(s, "permissionType");
        return (PermissionCallback)this.callbackMap.get(s);
    }

    public final boolean getFallbackToSettings() {
        return this.fallbackToSettings;
    }

    public final boolean getShouldShowRequestPermissionRationaleBeforeRequest() {
        return this.shouldShowRequestPermissionRationaleBeforeRequest;
    }

    public final boolean getWaiting() {
        return this.waiting;
    }

    @Override  // com.onesignal.core.internal.permissions.IRequestPermissionService
    public void registerAsCallback(String s, PermissionCallback iRequestPermissionService$PermissionCallback0) {
        Intrinsics.checkNotNullParameter(s, "permissionType");
        Intrinsics.checkNotNullParameter(iRequestPermissionService$PermissionCallback0, "callback");
        this.callbackMap.put(s, iRequestPermissionService$PermissionCallback0);
    }

    public final void setFallbackToSettings(boolean z) {
        this.fallbackToSettings = z;
    }

    public final void setShouldShowRequestPermissionRationaleBeforeRequest(boolean z) {
        this.shouldShowRequestPermissionRationaleBeforeRequest = z;
    }

    public final void setWaiting(boolean z) {
        this.waiting = z;
    }

    @Override  // com.onesignal.core.internal.permissions.IRequestPermissionService
    public void startPrompt(boolean z, String s, String s1, Class class0) {
        Intrinsics.checkNotNullParameter(class0, "callbackClass");
        if(this.waiting) {
            return;
        }
        this.fallbackToSettings = z;
        IActivityLifecycleHandler iActivityLifecycleHandler0 = new IActivityLifecycleHandler() {
            @Override  // com.onesignal.core.internal.application.IActivityLifecycleHandler
            public void onActivityAvailable(Activity activity0) {
                Intrinsics.checkNotNullParameter(activity0, "activity");
                if(Intrinsics.areEqual(activity0.getClass(), PermissionsActivity.class)) {
                    s._application.removeActivityLifecycleHandler(this);
                    return;
                }
                Intent intent0 = new Intent(activity0, PermissionsActivity.class);
                intent0.setFlags(0x20000);
                intent0.putExtra("INTENT_EXTRA_PERMISSION_TYPE", s1).putExtra("INTENT_EXTRA_ANDROID_PERMISSION_STRING", class0).putExtra("INTENT_EXTRA_CALLBACK_CLASS", this.$callbackClass.getName());
                activity0.startActivity(intent0);
                activity0.overridePendingTransition(anim.onesignal_fade_in, anim.onesignal_fade_out);
            }

            @Override  // com.onesignal.core.internal.application.IActivityLifecycleHandler
            public void onActivityStopped(Activity activity0) {
                Intrinsics.checkNotNullParameter(activity0, "activity");
            }
        };
        this._application.addActivityLifecycleHandler(iActivityLifecycleHandler0);
    }
}

