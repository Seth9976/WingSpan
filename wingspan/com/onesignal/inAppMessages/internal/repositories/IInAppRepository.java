package com.onesignal.inAppMessages.internal.repositories;

import com.onesignal.inAppMessages.internal.InAppMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001A\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\b\u001A\u00020\u00032\u0006\u0010\t\u001A\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000B"}, d2 = {"Lcom/onesignal/inAppMessages/internal/repositories/IInAppRepository;", "", "cleanCachedInAppMessages", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listInAppMessages", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "saveInAppMessage", "inAppMessage", "(Lcom/onesignal/inAppMessages/internal/InAppMessage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IInAppRepository {
    Object cleanCachedInAppMessages(Continuation arg1);

    Object listInAppMessages(Continuation arg1);

    Object saveInAppMessage(InAppMessage arg1, Continuation arg2);
}

