package com.onesignal.notifications.internal.registration.impl;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.PendingIntent.CanceledException;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0002J\u0011\u0010\u0010\u001A\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001A\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\u000B\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;", "", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "isGooglePlayStoreInstalled", "", "()Z", "openPlayStoreToApp", "", "activity", "Landroid/app/Activity;", "showUpdateGPSDialog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class GooglePlayServicesUpgradePrompt {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt$Companion;", "", "()V", "PLAY_SERVICES_RESOLUTION_REQUEST", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;

    static {
        GooglePlayServicesUpgradePrompt.Companion = new Companion(null);
    }

    public GooglePlayServicesUpgradePrompt(IApplicationService iApplicationService0, IDeviceService iDeviceService0, ConfigModelStore configModelStore0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iDeviceService0, "_deviceService");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        super();
        this._applicationService = iApplicationService0;
        this._deviceService = iDeviceService0;
        this._configModelStore = configModelStore0;
    }

    private final boolean isGooglePlayStoreInstalled() {
        try {
            PackageManager packageManager0 = this._applicationService.getAppContext().getPackageManager();
            CharSequence charSequence0 = packageManager0.getPackageInfo("com.google.android.gms", 0x80).applicationInfo.loadLabel(packageManager0);
            Intrinsics.checkNotNull(charSequence0, "null cannot be cast to non-null type kotlin.String");
            return !Intrinsics.areEqual(((String)charSequence0), "Market");
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            return false;
        }
    }

    private final void openPlayStoreToApp(Activity activity0) {
        try {
            GoogleApiAvailability googleApiAvailability0 = GoogleApiAvailability.getInstance();
            Intrinsics.checkNotNullExpressionValue(googleApiAvailability0, "getInstance()");
            PendingIntent pendingIntent0 = googleApiAvailability0.getErrorResolutionPendingIntent(activity0, googleApiAvailability0.isGooglePlayServicesAvailable(this._applicationService.getAppContext()), 9000);
            if(pendingIntent0 != null) {
                pendingIntent0.send();
            }
        }
        catch(PendingIntent.CanceledException pendingIntent$CanceledException0) {
            pendingIntent$CanceledException0.printStackTrace();
        }
    }

    public final Object showUpdateGPSDialog(Continuation continuation0) {
        if(!this._deviceService.isAndroidDeviceType()) {
            return Unit.INSTANCE;
        }
        if(this.isGooglePlayStoreInstalled() && !((ConfigModel)this._configModelStore.getModel()).getDisableGMSMissingPrompt() && !((ConfigModel)this._configModelStore.getModel()).getUserRejectedGMSUpdate()) {
            Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new Function2(null) {
                int label;

                // 检测为 Lambda 实现
                public static void $r8$lambda$Ipg_1OlCzEhtI3LvW15LkTPWrb0(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt0, DialogInterface dialogInterface0, int v) [...]

                // 检测为 Lambda 实现
                public static void $r8$lambda$rJN2_nmUxGS2RNaawUP6qyPMYl0(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt0, Activity activity0, DialogInterface dialogInterface0, int v) [...]

                {
                    GooglePlayServicesUpgradePrompt.this = googlePlayServicesUpgradePrompt0;
                    super(2, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt.showUpdateGPSDialog.2(GooglePlayServicesUpgradePrompt.this, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function2
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt.showUpdateGPSDialog.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    if(this.label != 0) {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                    ResultKt.throwOnFailure(object0);
                    Activity activity0 = GooglePlayServicesUpgradePrompt.this._applicationService.getCurrent();
                    if(activity0 == null) {
                        return Unit.INSTANCE;
                    }
                    String s = AndroidUtils.INSTANCE.getResourceString(activity0, "onesignal_gms_missing_alert_text", "To receive push notifications please press \'Update\' to enable \'Google Play services\'.");
                    String s1 = AndroidUtils.INSTANCE.getResourceString(activity0, "onesignal_gms_missing_alert_button_update", "Update");
                    String s2 = AndroidUtils.INSTANCE.getResourceString(activity0, "onesignal_gms_missing_alert_button_skip", "Skip");
                    String s3 = AndroidUtils.INSTANCE.getResourceString(activity0, "onesignal_gms_missing_alert_button_close", "Close");
                    new AlertDialog.Builder(activity0).setMessage(s).setPositiveButton(s1, (DialogInterface dialogInterface0, int v) -> com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt.showUpdateGPSDialog.2.invokeSuspend$lambda-0(GooglePlayServicesUpgradePrompt.this, activity0, dialogInterface0, v)).setNegativeButton(s2, (DialogInterface dialogInterface0, int v) -> com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt.showUpdateGPSDialog.2.invokeSuspend$lambda-1(GooglePlayServicesUpgradePrompt.this, dialogInterface0, v)).setNeutralButton(s3, null).create().show();
                    return Unit.INSTANCE;
                }

                private static final void invokeSuspend$lambda-0(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt0, Activity activity0, DialogInterface dialogInterface0, int v) {
                    googlePlayServicesUpgradePrompt0.openPlayStoreToApp(activity0);
                }

                private static final void invokeSuspend$lambda-1(GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt0, DialogInterface dialogInterface0, int v) {
                    ((ConfigModel)googlePlayServicesUpgradePrompt0._configModelStore.getModel()).setUserRejectedGMSUpdate(true);
                }
            }, continuation0);
            return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}

