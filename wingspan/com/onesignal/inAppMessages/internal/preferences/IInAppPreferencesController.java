package com.onesignal.inAppMessages.internal.preferences;

import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000E\n\u0002\b\u000B\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u001D\u001A\u00020\u001E2\u000E\u0010\u001F\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\u0018\u0010 \u001A\u00020\u001E2\u000E\u0010!\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&R \u0010\u0002\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\n\u0010\u0006\"\u0004\b\u000B\u0010\bR \u0010\f\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\r\u0010\u0006\"\u0004\b\u000E\u0010\bR\u001A\u0010\u000F\u001A\u0004\u0018\u00010\u0010X¦\u000E¢\u0006\f\u001A\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001A\u0010\u0015\u001A\u0004\u0018\u00010\u0004X¦\u000E¢\u0006\f\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001A\u001A\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u001B\u0010\u0006\"\u0004\b\u001C\u0010\b¨\u0006\""}, d2 = {"Lcom/onesignal/inAppMessages/internal/preferences/IInAppPreferencesController;", "", "clickedMessagesId", "", "", "getClickedMessagesId", "()Ljava/util/Set;", "setClickedMessagesId", "(Ljava/util/Set;)V", "dismissedMessagesId", "getDismissedMessagesId", "setDismissedMessagesId", "impressionesMessagesId", "getImpressionesMessagesId", "setImpressionesMessagesId", "lastTimeInAppDismissed", "", "getLastTimeInAppDismissed", "()Ljava/lang/Long;", "setLastTimeInAppDismissed", "(Ljava/lang/Long;)V", "savedIAMs", "getSavedIAMs", "()Ljava/lang/String;", "setSavedIAMs", "(Ljava/lang/String;)V", "viewPageImpressionedIds", "getViewPageImpressionedIds", "setViewPageImpressionedIds", "cleanInAppMessageClickedClickIds", "", "oldClickedClickIds", "cleanInAppMessageIds", "oldMessageIds", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IInAppPreferencesController {
    void cleanInAppMessageClickedClickIds(Set arg1);

    void cleanInAppMessageIds(Set arg1);

    Set getClickedMessagesId();

    Set getDismissedMessagesId();

    Set getImpressionesMessagesId();

    Long getLastTimeInAppDismissed();

    String getSavedIAMs();

    Set getViewPageImpressionedIds();

    void setClickedMessagesId(Set arg1);

    void setDismissedMessagesId(Set arg1);

    void setImpressionesMessagesId(Set arg1);

    void setLastTimeInAppDismissed(Long arg1);

    void setSavedIAMs(String arg1);

    void setViewPageImpressionedIds(Set arg1);
}

