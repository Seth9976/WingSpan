package com.onesignal.session.internal.outcomes;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001B\u0010\u0002\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J#\u0010\u0007\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u001B\u0010\u000B\u001A\u0004\u0018\u00010\u00032\u0006\u0010\f\u001A\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000EJ\u001B\u0010\u000F\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001A\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/onesignal/session/internal/outcomes/IOutcomeEventsController;", "", "sendOutcomeEvent", "Lcom/onesignal/session/internal/outcomes/IOutcomeEvent;", "name", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOutcomeEventWithValue", "weight", "", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSessionEndOutcomeEvent", "duration", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUniqueOutcomeEvent", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IOutcomeEventsController {
    Object sendOutcomeEvent(String arg1, Continuation arg2);

    Object sendOutcomeEventWithValue(String arg1, float arg2, Continuation arg3);

    Object sendSessionEndOutcomeEvent(long arg1, Continuation arg2);

    Object sendUniqueOutcomeEvent(String arg1, Continuation arg2);
}

