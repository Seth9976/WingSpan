package com.onesignal.inAppMessages.internal.triggers;

import com.onesignal.common.events.IEventNotifier;
import com.onesignal.inAppMessages.internal.InAppMessage;
import java.util.Collection;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001E\n\u0002\u0010\u000E\n\u0002\b\u0002\b`\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H&J\u001E\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\f\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tH&J\u0010\u0010\u000B\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H&¨\u0006\f"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/ITriggerController;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "evaluateMessageTriggers", "", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "isTriggerOnMessage", "triggersKeys", "", "", "messageHasOnlyDynamicTriggers", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ITriggerController extends IEventNotifier {
    boolean evaluateMessageTriggers(InAppMessage arg1);

    boolean isTriggerOnMessage(InAppMessage arg1, Collection arg2);

    boolean messageHasOnlyDynamicTriggers(InAppMessage arg1);
}

