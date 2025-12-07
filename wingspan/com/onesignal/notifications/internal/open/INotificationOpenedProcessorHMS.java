package com.onesignal.notifications.internal.open;

import android.app.Activity;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J#\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/onesignal/notifications/internal/open/INotificationOpenedProcessorHMS;", "", "handleHMSNotificationOpenIntent", "", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "(Landroid/app/Activity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface INotificationOpenedProcessorHMS {
    Object handleHMSNotificationOpenIntent(Activity arg1, Intent arg2, Continuation arg3);
}

