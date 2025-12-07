package com.onesignal.core.internal.permissions;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000FJ\u0018\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007H&J0\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\n2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00052\b\u0010\f\u001A\u0004\u0018\u00010\u00052\n\u0010\r\u001A\u0006\u0012\u0002\b\u00030\u000EH&¨\u0006\u0010"}, d2 = {"Lcom/onesignal/core/internal/permissions/IRequestPermissionService;", "", "registerAsCallback", "", "permissionType", "", "callback", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "startPrompt", "fallbackCondition", "", "permissionRequestType", "androidPermissionString", "callbackClass", "Ljava/lang/Class;", "PermissionCallback", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IRequestPermissionService {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\u0010\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "", "onAccept", "", "onReject", "fallbackToSettings", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface PermissionCallback {
        void onAccept();

        void onReject(boolean arg1);
    }

    void registerAsCallback(String arg1, PermissionCallback arg2);

    void startPrompt(boolean arg1, String arg2, String arg3, Class arg4);
}

