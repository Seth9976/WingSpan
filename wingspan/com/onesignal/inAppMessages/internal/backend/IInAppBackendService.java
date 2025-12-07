package com.onesignal.inAppMessages.internal.backend;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J+\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ#\u0010\t\u001A\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u000B\u001A\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ)\u0010\r\u001A\n\u0012\u0004\u0012\u00020\u000F\u0018\u00010\u000E2\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJE\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\u0013\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001A\u00020\u0015H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J3\u0010\u0017\u001A\u00020\u00122\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J=\u0010\u0019\u001A\u00020\u00122\u0006\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u00052\b\u0010\u0007\u001A\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001A\u00020\u00052\b\u0010\u001A\u001A\u0004\u0018\u00010\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001B\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001C"}, d2 = {"Lcom/onesignal/inAppMessages/internal/backend/IInAppBackendService;", "", "getIAMData", "Lcom/onesignal/inAppMessages/internal/backend/GetIAMDataResponse;", "appId", "", "messageId", "variantId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIAMPreviewData", "Lcom/onesignal/inAppMessages/internal/InAppMessageContent;", "previewUUID", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listInAppMessages", "", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "subscriptionId", "sendIAMClick", "", "clickId", "isFirstClick", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendIAMImpression", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendIAMPageImpression", "pageId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IInAppBackendService {
    Object getIAMData(String arg1, String arg2, String arg3, Continuation arg4);

    Object getIAMPreviewData(String arg1, String arg2, Continuation arg3);

    Object listInAppMessages(String arg1, String arg2, Continuation arg3);

    Object sendIAMClick(String arg1, String arg2, String arg3, String arg4, String arg5, boolean arg6, Continuation arg7);

    Object sendIAMImpression(String arg1, String arg2, String arg3, String arg4, Continuation arg5);

    Object sendIAMPageImpression(String arg1, String arg2, String arg3, String arg4, String arg5, Continuation arg6);
}

