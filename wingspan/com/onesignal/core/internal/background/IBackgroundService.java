package com.onesignal.core.internal.background;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0006\u001A\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bR\u0014\u0010\u0002\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/onesignal/core/internal/background/IBackgroundService;", "", "scheduleBackgroundRunIn", "", "getScheduleBackgroundRunIn", "()Ljava/lang/Long;", "backgroundRun", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IBackgroundService {
    Object backgroundRun(Continuation arg1);

    Long getScheduleBackgroundRunIn();
}

