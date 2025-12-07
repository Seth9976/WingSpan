package com.onesignal.user;

import com.onesignal.user.state.IUserStateObserver;
import com.onesignal.user.subscriptions.IPushSubscription;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u001E\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0018\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0003H&J\u001C\u0010\u0010\u001A\u00020\r2\u0012\u0010\u0011\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H&J\u0010\u0010\u0013\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\u0003H&J\u0010\u0010\u0015\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u0017H&J\u0010\u0010\u0018\u001A\u00020\r2\u0006\u0010\u0019\u001A\u00020\u0003H&J\u0018\u0010\u001A\u001A\u00020\r2\u0006\u0010\u001B\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u0003H&J\u001C\u0010\u001D\u001A\u00020\r2\u0012\u0010\u001E\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H&J\u0014\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0012H&J\u0010\u0010 \u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u0003H&J\u0016\u0010!\u001A\u00020\r2\f\u0010\"\u001A\b\u0012\u0004\u0012\u00020\u00030#H&J\u0010\u0010$\u001A\u00020\r2\u0006\u0010\u0014\u001A\u00020\u0003H&J\u0010\u0010%\u001A\u00020\r2\u0006\u0010\u0016\u001A\u00020\u0017H&J\u0010\u0010&\u001A\u00020\r2\u0006\u0010\u0019\u001A\u00020\u0003H&J\u0010\u0010\'\u001A\u00020\r2\u0006\u0010\u001B\u001A\u00020\u0003H&J\u0016\u0010(\u001A\u00020\r2\f\u0010)\u001A\b\u0012\u0004\u0012\u00020\u00030#H&J\u0010\u0010*\u001A\u00020\r2\u0006\u0010\u001C\u001A\u00020\u0003H&R\u0012\u0010\u0002\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001A\u00020\u0003X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000B¨\u0006+"}, d2 = {"Lcom/onesignal/user/IUserManager;", "", "externalId", "", "getExternalId", "()Ljava/lang/String;", "onesignalId", "getOnesignalId", "pushSubscription", "Lcom/onesignal/user/subscriptions/IPushSubscription;", "getPushSubscription", "()Lcom/onesignal/user/subscriptions/IPushSubscription;", "addAlias", "", "label", "id", "addAliases", "aliases", "", "addEmail", "email", "addObserver", "observer", "Lcom/onesignal/user/state/IUserStateObserver;", "addSms", "sms", "addTag", "key", "value", "addTags", "tags", "getTags", "removeAlias", "removeAliases", "labels", "", "removeEmail", "removeObserver", "removeSms", "removeTag", "removeTags", "keys", "setLanguage", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IUserManager {
    void addAlias(String arg1, String arg2);

    void addAliases(Map arg1);

    void addEmail(String arg1);

    void addObserver(IUserStateObserver arg1);

    void addSms(String arg1);

    void addTag(String arg1, String arg2);

    void addTags(Map arg1);

    String getExternalId();

    String getOnesignalId();

    IPushSubscription getPushSubscription();

    Map getTags();

    void removeAlias(String arg1);

    void removeAliases(Collection arg1);

    void removeEmail(String arg1);

    void removeObserver(IUserStateObserver arg1);

    void removeSms(String arg1);

    void removeTag(String arg1);

    void removeTags(Collection arg1);

    void setLanguage(String arg1);
}

