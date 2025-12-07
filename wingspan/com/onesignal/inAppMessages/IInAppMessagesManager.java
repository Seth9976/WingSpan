package com.onesignal.inAppMessages;

import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u001E\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH&J\u0010\u0010\f\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\rH&J\u0018\u0010\u000E\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u0010H&J\u001C\u0010\u0012\u001A\u00020\t2\u0012\u0010\u0013\u001A\u000E\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0014H&J\b\u0010\u0015\u001A\u00020\tH&J\u0010\u0010\u0016\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH&J\u0010\u0010\u0017\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\rH&J\u0010\u0010\u0018\u001A\u00020\t2\u0006\u0010\u000F\u001A\u00020\u0010H&J\u0016\u0010\u0019\u001A\u00020\t2\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00100\u001BH&R\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u001C"}, d2 = {"Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "", "paused", "", "getPaused", "()Z", "setPaused", "(Z)V", "addClickListener", "", "listener", "Lcom/onesignal/inAppMessages/IInAppMessageClickListener;", "addLifecycleListener", "Lcom/onesignal/inAppMessages/IInAppMessageLifecycleListener;", "addTrigger", "key", "", "value", "addTriggers", "triggers", "", "clearTriggers", "removeClickListener", "removeLifecycleListener", "removeTrigger", "removeTriggers", "keys", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IInAppMessagesManager {
    void addClickListener(IInAppMessageClickListener arg1);

    void addLifecycleListener(IInAppMessageLifecycleListener arg1);

    void addTrigger(String arg1, String arg2);

    void addTriggers(Map arg1);

    void clearTriggers();

    boolean getPaused();

    void removeClickListener(IInAppMessageClickListener arg1);

    void removeLifecycleListener(IInAppMessageLifecycleListener arg1);

    void removeTrigger(String arg1);

    void removeTriggers(Collection arg1);

    void setPaused(boolean arg1);
}

