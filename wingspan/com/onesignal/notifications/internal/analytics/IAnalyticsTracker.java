package com.onesignal.notifications.internal.analytics;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\u0018\u0010\u0004\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H&J\u0018\u0010\b\u001A\u00020\u00032\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H&¨\u0006\t"}, d2 = {"Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;", "", "trackInfluenceOpenEvent", "", "trackOpenedEvent", "notificationId", "", "campaign", "trackReceivedEvent", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IAnalyticsTracker {
    void trackInfluenceOpenEvent();

    void trackOpenedEvent(String arg1, String arg2);

    void trackReceivedEvent(String arg1, String arg2);
}

