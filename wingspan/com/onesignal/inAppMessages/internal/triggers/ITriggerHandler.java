package com.onesignal.inAppMessages.internal.triggers;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H&J\u0010\u0010\u0006\u001A\u00020\u00032\u0006\u0010\u0007\u001A\u00020\u0005H&J\b\u0010\b\u001A\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "", "onTriggerChanged", "", "newTriggerKey", "", "onTriggerCompleted", "triggerId", "onTriggerConditionChanged", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ITriggerHandler {
    void onTriggerChanged(String arg1);

    void onTriggerCompleted(String arg1);

    void onTriggerConditionChanged();
}

