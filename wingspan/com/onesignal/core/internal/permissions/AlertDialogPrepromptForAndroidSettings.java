package com.onesignal.core.internal.permissions;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import com.onesignal.core.R.string;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\u000B¨\u0006\r"}, d2 = {"Lcom/onesignal/core/internal/permissions/AlertDialogPrepromptForAndroidSettings;", "", "()V", "show", "", "activity", "Landroid/app/Activity;", "titlePrefix", "", "previouslyDeniedPostfix", "callback", "Lcom/onesignal/core/internal/permissions/AlertDialogPrepromptForAndroidSettings$Callback;", "Callback", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class AlertDialogPrepromptForAndroidSettings {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\b\u0010\u0004\u001A\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/onesignal/core/internal/permissions/AlertDialogPrepromptForAndroidSettings$Callback;", "", "onAccept", "", "onDecline", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface Callback {
        void onAccept();

        void onDecline();
    }

    public static final AlertDialogPrepromptForAndroidSettings INSTANCE;

    // 检测为 Lambda 实现
    public static void $r8$lambda$3u6uWFcdhzJzKHcLK6lm0HYP16k(Callback alertDialogPrepromptForAndroidSettings$Callback0, DialogInterface dialogInterface0, int v) [...]

    // 检测为 Lambda 实现
    public static void $r8$lambda$YPx4_NCfAIYMKFr9LfCr4BN_RbE(Callback alertDialogPrepromptForAndroidSettings$Callback0, DialogInterface dialogInterface0, int v) [...]

    static {
        AlertDialogPrepromptForAndroidSettings.INSTANCE = new AlertDialogPrepromptForAndroidSettings();
    }

    public final void show(Activity activity0, String s, String s1, Callback alertDialogPrepromptForAndroidSettings$Callback0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        Intrinsics.checkNotNullParameter(s, "titlePrefix");
        Intrinsics.checkNotNullParameter(s1, "previouslyDeniedPostfix");
        Intrinsics.checkNotNullParameter(alertDialogPrepromptForAndroidSettings$Callback0, "callback");
        String s2 = activity0.getString(string.permission_not_available_title);
        Intrinsics.checkNotNullExpressionValue(s2, "activity.getString(R.str…sion_not_available_title)");
        String s3 = String.format(s2, Arrays.copyOf(new Object[]{s}, 1));
        Intrinsics.checkNotNullExpressionValue(s3, "format(this, *args)");
        String s4 = activity0.getString(string.permission_not_available_message);
        Intrinsics.checkNotNullExpressionValue(s4, "activity.getString(R.str…on_not_available_message)");
        String s5 = String.format(s4, Arrays.copyOf(new Object[]{s1}, 1));
        Intrinsics.checkNotNullExpressionValue(s5, "format(this, *args)");
        AlertDialog.Builder alertDialog$Builder0 = new AlertDialog.Builder(activity0).setTitle(s3).setMessage(s5);
        AlertDialogPrepromptForAndroidSettings..ExternalSyntheticLambda0 alertDialogPrepromptForAndroidSettings$$ExternalSyntheticLambda00 = (DialogInterface dialogInterface0, int v) -> AlertDialogPrepromptForAndroidSettings.show$lambda-0(alertDialogPrepromptForAndroidSettings$Callback0, dialogInterface0, v);
        alertDialog$Builder0.setPositiveButton(string.permission_not_available_open_settings_option, alertDialogPrepromptForAndroidSettings$$ExternalSyntheticLambda00).setNegativeButton(0x1040009, (DialogInterface dialogInterface0, int v) -> AlertDialogPrepromptForAndroidSettings.show$lambda-1(alertDialogPrepromptForAndroidSettings$Callback0, dialogInterface0, v)).show();
    }

    private static final void show$lambda-0(Callback alertDialogPrepromptForAndroidSettings$Callback0, DialogInterface dialogInterface0, int v) {
        Intrinsics.checkNotNullParameter(alertDialogPrepromptForAndroidSettings$Callback0, "$callback");
        alertDialogPrepromptForAndroidSettings$Callback0.onAccept();
    }

    private static final void show$lambda-1(Callback alertDialogPrepromptForAndroidSettings$Callback0, DialogInterface dialogInterface0, int v) {
        Intrinsics.checkNotNullParameter(alertDialogPrepromptForAndroidSettings$Callback0, "$callback");
        alertDialogPrepromptForAndroidSettings$Callback0.onDecline();
    }
}

