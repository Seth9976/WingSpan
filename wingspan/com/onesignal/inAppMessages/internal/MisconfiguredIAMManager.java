package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u001E\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0010\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000FH\u0016J\u0018\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0003\u001A\u00020\u0012H\u0016J\u001C\u0010\u0013\u001A\u00020\u000B2\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0015H\u0016J\b\u0010\u0016\u001A\u00020\u000BH\u0016J\u0010\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0016J\u0010\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000FH\u0016J\u0010\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u0011\u001A\u00020\u0012H\u0016J\u0016\u0010\u001A\u001A\u00020\u000B2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00120\u001CH\u0016R$\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00048V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001E"}, d2 = {"Lcom/onesignal/inAppMessages/internal/MisconfiguredIAMManager;", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "()V", "value", "", "paused", "getPaused", "()Z", "setPaused", "(Z)V", "addClickListener", "", "listener", "Lcom/onesignal/inAppMessages/IInAppMessageClickListener;", "addLifecycleListener", "Lcom/onesignal/inAppMessages/IInAppMessageLifecycleListener;", "addTrigger", "key", "", "addTriggers", "triggers", "", "clearTriggers", "removeClickListener", "removeLifecycleListener", "removeTrigger", "removeTriggers", "keys", "", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MisconfiguredIAMManager implements IInAppMessagesManager {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001A\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/inAppMessages/internal/MisconfiguredIAMManager$Companion;", "", "()V", "EXCEPTION", "", "getEXCEPTION", "()Ljava/lang/Throwable;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Throwable access$getEXCEPTION(Companion misconfiguredIAMManager$Companion0) {
            return misconfiguredIAMManager$Companion0.getEXCEPTION();
        }

        private final Throwable getEXCEPTION() {
            return new Exception("Must include gradle module com.onesignal:InAppMessages in order to use this functionality!");
        }
    }

    public static final Companion Companion;

    static {
        MisconfiguredIAMManager.Companion = new Companion(null);
    }

    public Void addClickListener(IInAppMessageClickListener iInAppMessageClickListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener0, "listener");
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addClickListener(IInAppMessageClickListener iInAppMessageClickListener0) {
        this.addClickListener(iInAppMessageClickListener0);
    }

    public Void addLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener0, "listener");
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
        this.addLifecycleListener(iInAppMessageLifecycleListener0);
    }

    public Void addTrigger(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "key");
        Intrinsics.checkNotNullParameter(s1, "value");
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addTrigger(String s, String s1) {
        this.addTrigger(s, s1);
    }

    public Void addTriggers(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "triggers");
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void addTriggers(Map map0) {
        this.addTriggers(map0);
    }

    public Void clearTriggers() {
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void clearTriggers() {
        this.clearTriggers();
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public boolean getPaused() {
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }

    public Void removeClickListener(IInAppMessageClickListener iInAppMessageClickListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageClickListener0, "listener");
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeClickListener(IInAppMessageClickListener iInAppMessageClickListener0) {
        this.removeClickListener(iInAppMessageClickListener0);
    }

    public Void removeLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener0, "listener");
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeLifecycleListener(IInAppMessageLifecycleListener iInAppMessageLifecycleListener0) {
        this.removeLifecycleListener(iInAppMessageLifecycleListener0);
    }

    public Void removeTrigger(String s) {
        Intrinsics.checkNotNullParameter(s, "key");
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeTrigger(String s) {
        this.removeTrigger(s);
    }

    public Void removeTriggers(Collection collection0) {
        Intrinsics.checkNotNullParameter(collection0, "keys");
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void removeTriggers(Collection collection0) {
        this.removeTriggers(collection0);
    }

    @Override  // com.onesignal.inAppMessages.IInAppMessagesManager
    public void setPaused(boolean z) {
        throw Companion.access$getEXCEPTION(MisconfiguredIAMManager.Companion);
    }
}

