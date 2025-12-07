package com.onesignal.inAppMessages.internal.prompt.impl;

import com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory;
import com.onesignal.location.ILocationManager;
import com.onesignal.notifications.INotificationsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001A\u0004\u0018\u00010\b2\u0006\u0010\t\u001A\u00020\nH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePromptFactory;", "Lcom/onesignal/inAppMessages/internal/prompt/IInAppMessagePromptFactory;", "_notificationsManager", "Lcom/onesignal/notifications/INotificationsManager;", "_locationManager", "Lcom/onesignal/location/ILocationManager;", "(Lcom/onesignal/notifications/INotificationsManager;Lcom/onesignal/location/ILocationManager;)V", "createPrompt", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "promptType", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppMessagePromptFactory implements IInAppMessagePromptFactory {
    private final ILocationManager _locationManager;
    private final INotificationsManager _notificationsManager;

    public InAppMessagePromptFactory(INotificationsManager iNotificationsManager0, ILocationManager iLocationManager0) {
        Intrinsics.checkNotNullParameter(iNotificationsManager0, "_notificationsManager");
        Intrinsics.checkNotNullParameter(iLocationManager0, "_locationManager");
        super();
        this._notificationsManager = iNotificationsManager0;
        this._locationManager = iLocationManager0;
    }

    @Override  // com.onesignal.inAppMessages.internal.prompt.IInAppMessagePromptFactory
    public InAppMessagePrompt createPrompt(String s) {
        Intrinsics.checkNotNullParameter(s, "promptType");
        if(Intrinsics.areEqual(s, "push")) {
            return new InAppMessagePushPrompt(this._notificationsManager);
        }
        return Intrinsics.areEqual(s, "location") ? new InAppMessageLocationPrompt(this._locationManager) : null;
    }
}

