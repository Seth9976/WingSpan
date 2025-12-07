package com.onesignal.inAppMessages;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0007H&J\u0010\u0010\b\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\tH&J\u0010\u0010\n\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u000BH&¨\u0006\f"}, d2 = {"Lcom/onesignal/inAppMessages/IInAppMessageLifecycleListener;", "", "onDidDismiss", "", "event", "Lcom/onesignal/inAppMessages/IInAppMessageDidDismissEvent;", "onDidDisplay", "Lcom/onesignal/inAppMessages/IInAppMessageDidDisplayEvent;", "onWillDismiss", "Lcom/onesignal/inAppMessages/IInAppMessageWillDismissEvent;", "onWillDisplay", "Lcom/onesignal/inAppMessages/IInAppMessageWillDisplayEvent;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IInAppMessageLifecycleListener {
    void onDidDismiss(IInAppMessageDidDismissEvent arg1);

    void onDidDisplay(IInAppMessageDidDisplayEvent arg1);

    void onWillDismiss(IInAppMessageWillDismissEvent arg1);

    void onWillDisplay(IInAppMessageWillDisplayEvent arg1);
}

