package com.onesignal.inAppMessages.internal.display;

import com.onesignal.inAppMessages.internal.InAppMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001A\u00020\u0003H&J\u001B\u0010\u0004\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001A\u00020\u00052\u0006\u0010\n\u001A\u00020\u000BH¦@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/onesignal/inAppMessages/internal/display/IInAppDisplayer;", "", "dismissCurrentInAppMessage", "", "displayMessage", "", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayPreviewMessage", "previewUUID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IInAppDisplayer {
    void dismissCurrentInAppMessage();

    Object displayMessage(InAppMessage arg1, Continuation arg2);

    Object displayPreviewMessage(String arg1, Continuation arg2);
}

