package com.onesignal.notifications.internal.summary;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001A\u00020\u00032\u0006\u0010\b\u001A\u00020\tH¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ!\u0010\u000B\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000F"}, d2 = {"Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "", "clearNotificationOnSummaryClick", "", "group", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePossibleDependentSummaryOnDismiss", "androidNotificationId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSummaryNotificationAfterChildRemoved", "dismissed", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationSummaryManager {
    Object clearNotificationOnSummaryClick(String arg1, Continuation arg2);

    Object updatePossibleDependentSummaryOnDismiss(int arg1, Continuation arg2);

    Object updateSummaryNotificationAfterChildRemoved(String arg1, boolean arg2, Continuation arg3);
}

