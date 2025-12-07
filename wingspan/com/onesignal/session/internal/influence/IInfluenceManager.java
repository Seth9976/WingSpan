package com.onesignal.session.internal.influence;

import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH&J\u0010\u0010\u000B\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\nH&J\b\u0010\r\u001A\u00020\bH&J\u0010\u0010\u000E\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\nH&J\u0010\u0010\u000F\u001A\u00020\b2\u0006\u0010\f\u001A\u00020\nH&R\u0018\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/onesignal/session/internal/influence/IInfluenceManager;", "", "influences", "", "Lcom/onesignal/session/internal/influence/Influence;", "getInfluences", "()Ljava/util/List;", "onDirectInfluenceFromIAM", "", "messageId", "", "onDirectInfluenceFromNotification", "notificationId", "onInAppMessageDismissed", "onInAppMessageDisplayed", "onNotificationReceived", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IInfluenceManager {
    List getInfluences();

    void onDirectInfluenceFromIAM(String arg1);

    void onDirectInfluenceFromNotification(String arg1);

    void onInAppMessageDismissed();

    void onInAppMessageDisplayed(String arg1);

    void onNotificationReceived(String arg1);
}

