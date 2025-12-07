package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u001E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u000EH\u0016J\u0018\u0010\u000F\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u0011H\u0016J\u001C\u0010\u0013\u001A\u00020\n2\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0015H\u0016J\b\u0010\u0016\u001A\u00020\nH\u0016J\u0010\u0010\u0017\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\u0018\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u000EH\u0016J\u0010\u0010\u0019\u001A\u00020\n2\u0006\u0010\u0010\u001A\u00020\u0011H\u0016J\u0016\u0010\u001A\u001A\u00020\n2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00110\u001CH\u0016R\u001A\u0010\u0003\u001A\u00020\u0004X\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001D"}, d2 = {"Lcom/onesignal/inAppMessages/internal/DummyInAppMessagesManager;", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "()V", "paused", "", "getPaused", "()Z", "setPaused", "(Z)V", "addClickListener", "", "listener", "Lcom/onesignal/inAppMessages/IInAppMessageClickListener;", "addLifecycleListener", "Lcom/onesignal/inAppMessages/IInAppMessageLifecycleListener;", "addTrigger", "key", "", "value", "addTriggers", "triggers", "", "clearTriggers", "removeClickListener", "removeLifecycleListener", "removeTrigger", "removeTriggers", "keys", "", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DummyInAppMessagesManager implements IInAppMessagesManager {
    private boolean paused;

    public DummyInAppMessagesManager() {
        this.paused = true;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addClickListener(IInAppMessageClickListener iInAppMessageClickListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener0, "listener");
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener0, "listener");
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addTrigger(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "key");
        Intrinsics.checkNotNullParameter(s1, "value");
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addTriggers(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "triggers");
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void clearTriggers() {
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public boolean getPaused() {
        return this.paused;
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeClickListener(IInAppMessageClickListener iInAppMessageClickListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener0, "listener");
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener0, "listener");
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeTrigger(String s) {
        Intrinsics.checkNotNullParameter(s, "key");
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeTriggers(Collection collection0) {
        Intrinsics.checkNotNullParameter(collection0, "keys");
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void setPaused(boolean z) {
        this.paused = z;
    }
}

