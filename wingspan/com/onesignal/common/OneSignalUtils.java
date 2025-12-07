package com.onesignal.common;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000E\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0004J\u000E\u0010\b\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0004R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/onesignal/common/OneSignalUtils;", "", "()V", "SDK_VERSION", "", "isValidEmail", "", "email", "isValidPhoneNumber", "number", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OneSignalUtils {
    public static final OneSignalUtils INSTANCE = null;
    public static final String SDK_VERSION = "050109";

    static {
        OneSignalUtils.INSTANCE = new OneSignalUtils();
    }

    public final boolean isValidEmail(String s) {
        Intrinsics.checkNotNullParameter(s, "email");
        if(s.length() == 0) {
            return false;
        }
        Pattern pattern0 = Pattern.compile("^[a-zA-Z0-9.!#$%&\'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$");
        Intrinsics.checkNotNullExpressionValue(pattern0, "compile(emRegex)");
        return pattern0.matcher(s).matches();
    }

    public final boolean isValidPhoneNumber(String s) {
        Intrinsics.checkNotNullParameter(s, "number");
        if(s.length() == 0) {
            return false;
        }
        Pattern pattern0 = Pattern.compile("^\\+?[1-9]\\d{1,14}$");
        Intrinsics.checkNotNullExpressionValue(pattern0, "compile(emRegex)");
        return pattern0.matcher(s).matches();
    }
}

