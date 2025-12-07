package com.onesignal.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.internal.logging.Logging;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0001<B\u0007\b\u0002\u00A2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001A\u00020\bJ\u0010\u0010\t\u001A\u0004\u0018\u00010\u00052\u0006\u0010\n\u001A\u00020\u000BJ\u001A\u0010\f\u001A\u0004\u0018\u00010\u00052\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u0005J\u0018\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\r\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u00112\u0006\u0010\n\u001A\u00020\u000BJ\u0016\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013J$\u0010\u0016\u001A\u0004\u0018\u00010\u00052\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\u0017\u001A\u0004\u0018\u00010\u00052\b\u0010\u0018\u001A\u0004\u0018\u00010\u0005J\u0010\u0010\u0019\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u001A\u001A\u00020\u001BJ\u000E\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u001BJ\u000E\u0010\u001E\u001A\u00020\u00132\u0006\u0010\n\u001A\u00020\u000BJ\u0016\u0010\u001F\u001A\u00020\u000F2\u0006\u0010 \u001A\u00020!2\u0006\u0010\"\u001A\u00020\u0013J\u0006\u0010#\u001A\u00020\u000FJ\u0006\u0010$\u001A\u00020\u000FJ\u001E\u0010%\u001A\u00020\u000F2\u0006\u0010&\u001A\u00020\u00052\u0006\u0010\'\u001A\u00020\u000F2\u0006\u0010\u0007\u001A\u00020\bJ\u0006\u0010(\u001A\u00020\u000FJ\u000E\u0010)\u001A\u00020\u000F2\u0006\u0010 \u001A\u00020!J\u0006\u0010*\u001A\u00020\u000FJ\u0010\u0010+\u001A\u00020\u000F2\b\u0010,\u001A\u0004\u0018\u00010\u0005J\u0010\u0010-\u001A\u00020\u000F2\b\u0010.\u001A\u0004\u0018\u00010\u0005J\u0014\u0010/\u001A\u00020\u000F2\n\u00100\u001A\u0006\u0012\u0002\b\u000301H\u0007J\u0016\u00102\u001A\u0002032\u0006\u00104\u001A\u00020\u000B2\u0006\u00105\u001A\u000206J\u0016\u00102\u001A\u0002032\u0006\u00104\u001A\u00020\u000B2\u0006\u00107\u001A\u00020\u0005J\u000E\u00108\u001A\u0002092\u0006\u00105\u001A\u000206J\u000E\u0010:\u001A\u0002032\u0006\u0010;\u001A\u00020\u0013\u00A8\u0006="}, d2 = {"Lcom/onesignal/common/AndroidUtils;", "", "()V", "filterManifestPermissions", "", "", "permissions", "applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "getAppVersion", "context", "Landroid/content/Context;", "getManifestMeta", "metaName", "getManifestMetaBoolean", "", "getManifestMetaBundle", "Landroid/os/Bundle;", "getRandomDelay", "", "minDelay", "maxDelay", "getResourceString", "key", "defaultStr", "getRootCauseMessage", "throwable", "", "getRootCauseThrowable", "subjectThrowable", "getTargetSdkVersion", "hasConfigChangeFlag", "activity", "Landroid/app/Activity;", "configChangeFlag", "hasJobIntentService", "hasNotificationManagerCompat", "hasPermission", "permission", "isUserGranted", "hasWakefulBroadcastReceiver", "isActivityFullyReady", "isRunningOnMainThread", "isStringNotEmpty", "body", "isValidResourceName", "name", "opaqueHasClass", "_class", "Ljava/lang/Class;", "openURLInBrowser", "", "appContext", "uri", "Landroid/net/Uri;", "url", "openURLInBrowserIntent", "Landroid/content/Intent;", "sleep", "ms", "SchemaType", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class AndroidUtils {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/onesignal/common/AndroidUtils$SchemaType;", "", "text", "", "(Ljava/lang/String;ILjava/lang/String;)V", "DATA", "HTTPS", "HTTP", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static enum SchemaType {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/common/AndroidUtils$SchemaType$Companion;", "", "()V", "fromString", "Lcom/onesignal/common/AndroidUtils$SchemaType;", "text", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            public final SchemaType fromString(String s) {
                SchemaType[] arr_androidUtils$SchemaType = SchemaType.values();
                for(int v = 0; v < arr_androidUtils$SchemaType.length; ++v) {
                    SchemaType androidUtils$SchemaType0 = arr_androidUtils$SchemaType[v];
                    if(StringsKt.equals(androidUtils$SchemaType0.text, s, true)) {
                        return androidUtils$SchemaType0;
                    }
                }
                return null;
            }
        }

        DATA("data"),
        HTTPS("https"),
        HTTP("http");

        public static final Companion Companion;
        private final String text;

        private static final SchemaType[] $values() [...] // Inlined contents

        static {
            SchemaType.Companion = new Companion(null);
        }

        private SchemaType(String s1) {
            this.text = s1;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[SchemaType.values().length];
            arr_v[SchemaType.DATA.ordinal()] = 1;
            arr_v[SchemaType.HTTPS.ordinal()] = 2;
            arr_v[SchemaType.HTTP.ordinal()] = 3;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final AndroidUtils INSTANCE;

    static {
        AndroidUtils.INSTANCE = new AndroidUtils();
    }

    public final List filterManifestPermissions(List list0, IApplicationService iApplicationService0) {
        Intrinsics.checkNotNullParameter(list0, "permissions");
        Intrinsics.checkNotNullParameter(iApplicationService0, "applicationService");
        PackageInfo packageInfo0 = iApplicationService0.getAppContext().getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0x1000);
        Intrinsics.checkNotNullExpressionValue(packageInfo0, "applicationService.appCo…eManager.GET_PERMISSIONS)");
        String[] arr_s = packageInfo0.requestedPermissions;
        Intrinsics.checkNotNullExpressionValue(arr_s, "packageInfo.requestedPermissions");
        List list1 = CollectionsKt.listOf(Arrays.copyOf(arr_s, arr_s.length));
        Collection collection0 = new ArrayList();
        for(Object object0: list0) {
            if(list1.contains(((String)object0))) {
                collection0.add(object0);
            }
        }
        return (List)collection0;
    }

    public final String getAppVersion(Context context0) {
        Integer integer0;
        Intrinsics.checkNotNullParameter(context0, "context");
        try {
            integer0 = null;
            integer0 = context0.getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0).versionCode;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
        }
        return integer0 == null ? null : integer0.toString();
    }

    public final String getManifestMeta(Context context0, String s) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Bundle bundle0 = this.getManifestMetaBundle(context0);
        return bundle0 == null ? null : bundle0.getString(s);
    }

    public final boolean getManifestMetaBoolean(Context context0, String s) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Bundle bundle0 = this.getManifestMetaBundle(context0);
        return bundle0 == null ? false : bundle0.getBoolean(s);
    }

    public final Bundle getManifestMetaBundle(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        try {
            ApplicationInfo applicationInfo0 = context0.getPackageManager().getApplicationInfo("com.MonsterCouch.Wingspan", 0x80);
            Intrinsics.checkNotNullExpressionValue(applicationInfo0, "context.packageManager.g…A_DATA,\n                )");
            return applicationInfo0.metaData;
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            Logging.error("Manifest application info not found", packageManager$NameNotFoundException0);
            return null;
        }
    }

    public final int getRandomDelay(int v, int v1) {
        return new Random().nextInt(v1 + 1 - v) + v;
    }

    public final String getResourceString(Context context0, String s, String s1) {
        Intrinsics.checkNotNullParameter(context0, "context");
        Resources resources0 = context0.getResources();
        int v = resources0.getIdentifier(s, "string", "com.MonsterCouch.Wingspan");
        return v == 0 ? s1 : resources0.getString(v);
    }

    public final String getRootCauseMessage(Throwable throwable0) {
        Intrinsics.checkNotNullParameter(throwable0, "throwable");
        return this.getRootCauseThrowable(throwable0).getMessage();
    }

    public final Throwable getRootCauseThrowable(Throwable throwable0) {
        Intrinsics.checkNotNullParameter(throwable0, "subjectThrowable");
        while(throwable0.getCause() != null && throwable0.getCause() != throwable0) {
            throwable0 = throwable0.getCause();
            Intrinsics.checkNotNull(throwable0);
        }
        return throwable0;
    }

    public final int getTargetSdkVersion(Context context0) {
        Intrinsics.checkNotNullParameter(context0, "context");
        PackageManager packageManager0 = context0.getPackageManager();
        try {
            Intrinsics.checkNotNullExpressionValue(packageManager0.getApplicationInfo("com.MonsterCouch.Wingspan", 0), "packageManager.getApplicationInfo(packageName, 0)");
            return 34;
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
            return 15;
        }
    }

    public final boolean hasConfigChangeFlag(Activity activity0, int v) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        try {
            if((activity0.getPackageManager().getActivityInfo(activity0.getComponentName(), 0).configChanges & v) != 0) {
                return true;
            }
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
        }
        return false;
    }

    public final boolean hasJobIntentService() [...] // Inlined contents

    public final boolean hasNotificationManagerCompat() [...] // Inlined contents

    public final boolean hasPermission(String s, boolean z, IApplicationService iApplicationService0) {
        Intrinsics.checkNotNullParameter(s, "permission");
        Intrinsics.checkNotNullParameter(iApplicationService0, "applicationService");
        try {
            PackageInfo packageInfo0 = iApplicationService0.getAppContext().getPackageManager().getPackageInfo("com.MonsterCouch.Wingspan", 0x1000);
            Intrinsics.checkNotNullExpressionValue(packageInfo0, "applicationService.appCo…NS,\n                    )");
            String[] arr_s = packageInfo0.requestedPermissions;
            Intrinsics.checkNotNullExpressionValue(arr_s, "packageInfo.requestedPermissions");
            if(CollectionsKt.listOf(Arrays.copyOf(arr_s, arr_s.length)).contains(s)) {
                if(z) {
                    Context context0 = iApplicationService0.getAppContext();
                    return ContextCompat.INSTANCE.checkSelfPermission(context0, s) != -1;
                }
                return true;
            }
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            packageManager$NameNotFoundException0.printStackTrace();
        }
        return false;
    }

    public final boolean hasWakefulBroadcastReceiver() [...] // Inlined contents

    public final boolean isActivityFullyReady(Activity activity0) {
        Intrinsics.checkNotNullParameter(activity0, "activity");
        boolean z = activity0.getWindow().getDecorView().getApplicationWindowToken() != null;
        View view0 = activity0.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(view0, "activity.window.decorView");
        return z && view0.getRootWindowInsets() != null;
    }

    public final boolean isRunningOnMainThread() {
        return Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread());
    }

    public final boolean isStringNotEmpty(String s) {
        return !TextUtils.isEmpty(s);
    }

    public final boolean isValidResourceName(String s) {
        return s != null && !new Regex("^[0-9]").matches(s);
    }

    public final boolean opaqueHasClass(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "_class");
        return true;
    }

    public final void openURLInBrowser(Context context0, Uri uri0) {
        Intrinsics.checkNotNullParameter(context0, "appContext");
        Intrinsics.checkNotNullParameter(uri0, "uri");
        context0.startActivity(this.openURLInBrowserIntent(uri0));
    }

    public final void openURLInBrowser(Context context0, String s) {
        Intrinsics.checkNotNullParameter(context0, "appContext");
        Intrinsics.checkNotNullParameter(s, "url");
        int v = s.length() - 1;
        int v1 = 0;
        boolean z = false;
        while(v1 <= v) {
            boolean z1 = Intrinsics.compare(s.charAt((z ? v : v1)), 0x20) <= 0;
            if(z) {
                if(!z1) {
                    break;
                }
                --v;
            }
            else if(z1) {
                ++v1;
            }
            else {
                z = true;
            }
        }
        Uri uri0 = Uri.parse(s.subSequence(v1, v + 1).toString());
        Intrinsics.checkNotNullExpressionValue(uri0, "parse(url.trim { it <= \' \' })");
        this.openURLInBrowser(context0, uri0);
    }

    public final Intent openURLInBrowserIntent(Uri uri0) {
        Intent intent0;
        SchemaType androidUtils$SchemaType0;
        Intrinsics.checkNotNullParameter(uri0, "uri");
        if(uri0.getScheme() == null) {
            androidUtils$SchemaType0 = null;
        }
        else {
            String s = uri0.getScheme();
            androidUtils$SchemaType0 = SchemaType.Companion.fromString(s);
        }
        if(androidUtils$SchemaType0 == null) {
            androidUtils$SchemaType0 = SchemaType.HTTP;
            String s1 = uri0.toString();
            Intrinsics.checkNotNullExpressionValue(s1, "uri.toString()");
            if(!StringsKt.contains$default(s1, "://", false, 2, null)) {
                uri0 = Uri.parse(("http://" + uri0));
                Intrinsics.checkNotNullExpressionValue(uri0, "parse(\"http://$uri\")");
            }
        }
        switch(WhenMappings.$EnumSwitchMapping$0[androidUtils$SchemaType0.ordinal()]) {
            case 1: {
                intent0 = Intent.makeMainSelectorActivity("android.intent.action.MAIN", "android.intent.category.APP_BROWSER");
                Intrinsics.checkNotNullExpressionValue(intent0, "makeMainSelectorActivity…ent.CATEGORY_APP_BROWSER)");
                intent0.setData(uri0);
                break;
            }
            case 2: 
            case 3: {
                intent0 = new Intent("android.intent.action.VIEW", uri0);
                break;
            }
            default: {
                intent0 = new Intent("android.intent.action.VIEW", uri0);
            }
        }
        intent0.addFlags(0x10000000);
        return intent0;
    }

    public final void sleep(int v) {
        try {
            Thread.sleep(v);
        }
        catch(InterruptedException interruptedException0) {
            interruptedException0.printStackTrace();
        }
    }
}

