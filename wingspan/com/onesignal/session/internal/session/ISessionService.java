package com.onesignal.session.internal.session;

import com.onesignal.common.events.IEventNotifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0012\u0010\u0003\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/session/internal/session/ISessionService;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/session/internal/session/ISessionLifecycleHandler;", "startTime", "", "getStartTime", "()J", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ISessionService extends IEventNotifier {
    long getStartTime();
}

