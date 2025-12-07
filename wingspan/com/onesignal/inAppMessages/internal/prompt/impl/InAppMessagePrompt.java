package com.onesignal.inAppMessages.internal.prompt.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\t\u001A\u0004\u0018\u00010\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000BJ\u0006\u0010\f\u001A\u00020\bJ\u000E\u0010\r\u001A\u00020\u000E2\u0006\u0010\u0007\u001A\u00020\bJ\b\u0010\u000F\u001A\u00020\u0004H\u0016R\u0012\u0010\u0003\u001A\u00020\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u000E¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt;", "", "()V", "promptKey", "", "getPromptKey", "()Ljava/lang/String;", "prompted", "", "handlePrompt", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt$PromptActionResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasPrompted", "setPrompted", "", "toString", "OSPromptActionCompletionCallback", "PromptActionResult", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class InAppMessagePrompt {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001A\u00020\u00032\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt$OSPromptActionCompletionCallback;", "", "onCompleted", "", "result", "Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt$PromptActionResult;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public interface OSPromptActionCompletionCallback {
        void onCompleted(PromptActionResult arg1);
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/inAppMessages/internal/prompt/impl/InAppMessagePrompt$PromptActionResult;", "", "(Ljava/lang/String;I)V", "PERMISSION_GRANTED", "PERMISSION_DENIED", "LOCATION_PERMISSIONS_MISSING_MANIFEST", "ERROR", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static enum PromptActionResult {
        PERMISSION_GRANTED,
        PERMISSION_DENIED,
        LOCATION_PERMISSIONS_MISSING_MANIFEST,
        ERROR;

        private static final PromptActionResult[] $values() [...] // Inlined contents
    }

    private boolean prompted;

    public abstract String getPromptKey();

    public abstract Object handlePrompt(Continuation arg1);

    public final boolean hasPrompted() {
        return this.prompted;
    }

    public final void setPrompted(boolean z) {
        this.prompted = z;
    }

    @Override
    public String toString() {
        return "OSInAppMessagePrompt{key=" + this.getPromptKey() + " prompted=" + this.prompted + '}';
    }
}

