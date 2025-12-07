package com.onesignal.inAppMessages;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0007X¦\u0004¢\u0006\u0006\u001A\u0004\b\b\u0010\tR\u0014\u0010\n\u001A\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u000B\u0010\u0005R\u0014\u0010\f\u001A\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/onesignal/inAppMessages/IInAppMessageClickResult;", "", "actionId", "", "getActionId", "()Ljava/lang/String;", "closingMessage", "", "getClosingMessage", "()Z", "url", "getUrl", "urlTarget", "Lcom/onesignal/inAppMessages/InAppMessageActionUrlType;", "getUrlTarget", "()Lcom/onesignal/inAppMessages/InAppMessageActionUrlType;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IInAppMessageClickResult {
    String getActionId();

    boolean getClosingMessage();

    String getUrl();

    InAppMessageActionUrlType getUrlTarget();
}

