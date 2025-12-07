package com.onesignal.notifications.internal.data.impl;

import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.data.INotificationQueryHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u0007\u001A\u00060\bj\u0002`\tH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/data/impl/NotificationQueryHelper;", "Lcom/onesignal/notifications/internal/data/INotificationQueryHelper;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/time/ITime;)V", "recentUninteractedWithNotificationsWhere", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class NotificationQueryHelper implements INotificationQueryHelper {
    private final ConfigModelStore _configModelStore;
    private final ITime _time;

    public NotificationQueryHelper(ConfigModelStore configModelStore0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._configModelStore = configModelStore0;
        this._time = iTime0;
    }

    @Override  // com.onesignal.notifications.internal.data.INotificationQueryHelper
    public StringBuilder recentUninteractedWithNotificationsWhere() {
        long v = this._time.getCurrentTimeMillis();
        StringBuilder stringBuilder0 = new StringBuilder("created_time > " + (v / 1000L - 604800L) + " AND dismissed = 0 AND opened = 0 AND is_summary = 0");
        if(((ConfigModel)this._configModelStore.getModel()).getRestoreTTLFilter()) {
            stringBuilder0.append(" AND expire_time > " + v / 1000L);
        }
        return stringBuilder0;
    }
}

