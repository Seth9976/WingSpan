package com.onesignal.session.internal.influence.impl;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u000F\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u000E\u0010\t\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000B\u001A\u00020\u0004¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\bR\u000E\u0010\r\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/onesignal/session/internal/influence/impl/InfluenceConstants;", "", "()V", "DIRECT_TAG", "", "IAM_ID_TAG", "IAM_TAG", "getIAM_TAG", "()Ljava/lang/String;", "NOTIFICATIONS_IDS", "NOTIFICATION_ID_TAG", "NOTIFICATION_TAG", "getNOTIFICATION_TAG", "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN", "PREFS_OS_LAST_IAMS_RECEIVED", "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED", "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE", "PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE", "TIME", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InfluenceConstants {
    public static final String DIRECT_TAG = "direct";
    public static final String IAM_ID_TAG = "iam_id";
    private static final String IAM_TAG = null;
    public static final InfluenceConstants INSTANCE = null;
    public static final String NOTIFICATIONS_IDS = "notification_ids";
    public static final String NOTIFICATION_ID_TAG = "notification_id";
    private static final String NOTIFICATION_TAG = null;
    public static final String PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN = "PREFS_OS_LAST_ATTRIBUTED_NOTIFICATION_OPEN";
    public static final String PREFS_OS_LAST_IAMS_RECEIVED = "PREFS_OS_LAST_IAMS_RECEIVED";
    public static final String PREFS_OS_LAST_NOTIFICATIONS_RECEIVED = "PREFS_OS_LAST_NOTIFICATIONS_RECEIVED";
    public static final String PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE = "PREFS_OS_OUTCOMES_CURRENT_IAM_INFLUENCE";
    public static final String PREFS_OS_OUTCOMES_CURRENT_NOTIFICATION_INFLUENCE = "PREFS_OS_OUTCOMES_CURRENT_SESSION";
    public static final String TIME = "time";

    static {
        InfluenceConstants.INSTANCE = new InfluenceConstants();
        String s = InAppMessageTracker.class.getCanonicalName();
        Intrinsics.checkNotNull(s, "null cannot be cast to non-null type kotlin.String");
        InfluenceConstants.IAM_TAG = s;
        String s1 = NotificationTracker.class.getCanonicalName();
        Intrinsics.checkNotNull(s1, "null cannot be cast to non-null type kotlin.String");
        InfluenceConstants.NOTIFICATION_TAG = s1;
    }

    public final String getIAM_TAG() {
        return InfluenceConstants.IAM_TAG;
    }

    public final String getNOTIFICATION_TAG() {
        return InfluenceConstants.NOTIFICATION_TAG;
    }
}

