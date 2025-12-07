package com.onesignal.inAppMessages.internal.lifecycle;

import com.onesignal.common.events.IEventNotifier;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageClickResult;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH&J\u0018\u0010\t\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\bH&J\u0018\u0010\n\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u000B\u001A\u00020\fH&J\u0010\u0010\r\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H&J\u0010\u0010\u000E\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H&J\u0010\u0010\u000F\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H&J\u0010\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H&¨\u0006\u0011"}, d2 = {"Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleEventHandler;", "messageActionOccurredOnMessage", "", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "action", "Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "messageActionOccurredOnPreview", "messagePageChanged", "page", "Lcom/onesignal/inAppMessages/internal/InAppMessagePage;", "messageWasDismissed", "messageWasDisplayed", "messageWillDismiss", "messageWillDisplay", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IInAppLifecycleService extends IEventNotifier {
    void messageActionOccurredOnMessage(InAppMessage arg1, InAppMessageClickResult arg2);

    void messageActionOccurredOnPreview(InAppMessage arg1, InAppMessageClickResult arg2);

    void messagePageChanged(InAppMessage arg1, InAppMessagePage arg2);

    void messageWasDismissed(InAppMessage arg1);

    void messageWasDisplayed(InAppMessage arg1);

    void messageWillDismiss(InAppMessage arg1);

    void messageWillDisplay(InAppMessage arg1);
}

