package com.onesignal.inAppMessages.internal.state;

import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001C\u0010\u0003\u001A\u0004\u0018\u00010\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001C\u0010\t\u001A\u0004\u0018\u00010\nX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER\u001E\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0086\u000E¢\u0006\u0010\n\u0002\u0010\u0015\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0016\u001A\u00020\u0017X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0018\u0010\u0019\"\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lcom/onesignal/inAppMessages/internal/state/InAppStateService;", "", "()V", "currentPrompt", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "getCurrentPrompt", "()Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "setCurrentPrompt", "(Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;)V", "inAppMessageIdShowing", "", "getInAppMessageIdShowing", "()Ljava/lang/String;", "setInAppMessageIdShowing", "(Ljava/lang/String;)V", "lastTimeInAppDismissed", "", "getLastTimeInAppDismissed", "()Ljava/lang/Long;", "setLastTimeInAppDismissed", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "paused", "", "getPaused", "()Z", "setPaused", "(Z)V", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class InAppStateService {
    private InAppMessagePrompt currentPrompt;
    private String inAppMessageIdShowing;
    private Long lastTimeInAppDismissed;
    private boolean paused;

    public final InAppMessagePrompt getCurrentPrompt() {
        return this.currentPrompt;
    }

    public final String getInAppMessageIdShowing() {
        return this.inAppMessageIdShowing;
    }

    public final Long getLastTimeInAppDismissed() {
        return this.lastTimeInAppDismissed;
    }

    public final boolean getPaused() {
        return this.paused;
    }

    public final void setCurrentPrompt(InAppMessagePrompt inAppMessagePrompt0) {
        this.currentPrompt = inAppMessagePrompt0;
    }

    public final void setInAppMessageIdShowing(String s) {
        this.inAppMessageIdShowing = s;
    }

    public final void setLastTimeInAppDismissed(Long long0) {
        this.lastTimeInAppDismissed = long0;
    }

    public final void setPaused(boolean z) {
        this.paused = z;
    }
}

