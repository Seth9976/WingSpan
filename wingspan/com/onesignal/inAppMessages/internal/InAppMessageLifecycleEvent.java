package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessage;
import com.onesignal.inAppMessages.IInAppMessageDidDismissEvent;
import com.onesignal.inAppMessages.IInAppMessageDidDisplayEvent;
import com.onesignal.inAppMessages.IInAppMessageWillDismissEvent;
import com.onesignal.inAppMessages.IInAppMessageWillDisplayEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001A\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001A\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageLifecycleEvent;", "Lcom/onesignal/inAppMessages/IInAppMessageWillDisplayEvent;", "Lcom/onesignal/inAppMessages/IInAppMessageWillDismissEvent;", "Lcom/onesignal/inAppMessages/IInAppMessageDidDisplayEvent;", "Lcom/onesignal/inAppMessages/IInAppMessageDidDismissEvent;", "message", "Lcom/onesignal/inAppMessages/IInAppMessage;", "(Lcom/onesignal/inAppMessages/IInAppMessage;)V", "getMessage", "()Lcom/onesignal/inAppMessages/IInAppMessage;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class InAppMessageLifecycleEvent implements IInAppMessageDidDismissEvent, IInAppMessageDidDisplayEvent, IInAppMessageWillDismissEvent, IInAppMessageWillDisplayEvent {
    private final IInAppMessage message;

    public InAppMessageLifecycleEvent(IInAppMessage iInAppMessage0) {
        Intrinsics.checkNotNullParameter(iInAppMessage0, "message");
        super();
        this.message = iInAppMessage0;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessageWillDisplayEvent, com.onesignal.inAppMessages.IInAppMessageWillDismissEvent, com.onesignal.inAppMessages.IInAppMessageDidDisplayEvent, com.onesignal.inAppMessages.IInAppMessageDidDismissEvent
    public IInAppMessage getMessage() {
        return this.message;
    }
}

