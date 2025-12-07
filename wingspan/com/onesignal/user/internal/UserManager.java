package com.onesignal.user.internal;

import com.onesignal.common.IDManager;
import com.onesignal.common.OneSignalUtils;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.IUserManager;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import com.onesignal.user.internal.subscriptions.SubscriptionList;
import com.onesignal.user.state.IUserStateObserver;
import com.onesignal.user.state.UserChangedState;
import com.onesignal.user.state.UserState;
import com.onesignal.user.subscriptions.IPushSubscription;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001E\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u00A2\u0006\u0002\u0010\fJ\u0018\u0010+\u001A\u00020,2\u0006\u0010-\u001A\u00020\u00162\u0006\u0010.\u001A\u00020\u0016H\u0016J\u001C\u0010/\u001A\u00020,2\u0012\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0010\u00100\u001A\u00020,2\u0006\u00101\u001A\u00020\u0016H\u0016J\u0010\u00102\u001A\u00020,2\u0006\u00103\u001A\u00020\u001BH\u0016J\u0010\u00104\u001A\u00020,2\u0006\u00105\u001A\u00020\u0016H\u0016J\u0018\u00106\u001A\u00020,2\u0006\u00107\u001A\u00020\u00162\u0006\u00108\u001A\u00020\u0016H\u0016J\u001C\u00109\u001A\u00020,2\u0012\u0010:\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0014\u0010;\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\u0018\u0010<\u001A\u00020,2\u0006\u0010=\u001A\u00020\u00032\u0006\u0010>\u001A\u00020\u0016H\u0016J\u0018\u0010?\u001A\u00020,2\u0006\u0010@\u001A\u00020A2\u0006\u0010>\u001A\u00020\u0016H\u0016J\u0010\u0010B\u001A\u00020,2\u0006\u0010-\u001A\u00020\u0016H\u0016J\u0016\u0010C\u001A\u00020,2\f\u0010D\u001A\b\u0012\u0004\u0012\u00020\u00160EH\u0016J\u0010\u0010F\u001A\u00020,2\u0006\u00101\u001A\u00020\u0016H\u0016J\u0010\u0010G\u001A\u00020,2\u0006\u00103\u001A\u00020\u001BH\u0016J\u0010\u0010H\u001A\u00020,2\u0006\u00105\u001A\u00020\u0016H\u0016J\u0010\u0010I\u001A\u00020,2\u0006\u00107\u001A\u00020\u0016H\u0016J\u0016\u0010J\u001A\u00020,2\f\u0010K\u001A\b\u0012\u0004\u0012\u00020\u00160EH\u0016J\u0010\u0010L\u001A\u00020,2\u0006\u00108\u001A\u00020\u0016H\u0016R\u0014\u0010\r\u001A\u00020\u00038BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001A\u00020\u00118BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u001D\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u00158F\u00A2\u0006\u0006\u001A\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001A\b\u0012\u0004\u0012\u00020\u001B0\u001A\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001C\u0010\u001DR\u0014\u0010\u001E\u001A\u00020\u00168VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u001F\u0010 R\u0014\u0010!\u001A\u00020\u00168VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\"\u0010 R\u0014\u0010#\u001A\u00020$8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b%\u0010&R\u0011\u0010\'\u001A\u00020(8F\u00A2\u0006\u0006\u001A\u0004\b)\u0010*\u00A8\u0006M"}, d2 = {"Lcom/onesignal/user/internal/UserManager;", "Lcom/onesignal/user/IUserManager;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/user/internal/identity/IdentityModel;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "(Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/core/internal/language/ILanguageContext;)V", "_identityModel", "get_identityModel", "()Lcom/onesignal/user/internal/identity/IdentityModel;", "_propertiesModel", "Lcom/onesignal/user/internal/properties/PropertiesModel;", "get_propertiesModel", "()Lcom/onesignal/user/internal/properties/PropertiesModel;", "aliases", "", "", "getAliases", "()Ljava/util/Map;", "changeHandlersNotifier", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/user/state/IUserStateObserver;", "getChangeHandlersNotifier", "()Lcom/onesignal/common/events/EventProducer;", "externalId", "getExternalId", "()Ljava/lang/String;", "onesignalId", "getOnesignalId", "pushSubscription", "Lcom/onesignal/user/subscriptions/IPushSubscription;", "getPushSubscription", "()Lcom/onesignal/user/subscriptions/IPushSubscription;", "subscriptions", "Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "getSubscriptions", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionList;", "addAlias", "", "label", "id", "addAliases", "addEmail", "email", "addObserver", "observer", "addSms", "sms", "addTag", "key", "value", "addTags", "tags", "getTags", "onModelReplaced", "model", "tag", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "removeAlias", "removeAliases", "labels", "", "removeEmail", "removeObserver", "removeSms", "removeTag", "removeTags", "keys", "setLanguage", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public class UserManager implements ISingletonModelStoreChangeHandler, IUserManager {
    private final IdentityModelStore _identityModelStore;
    private final ILanguageContext _languageContext;
    private final PropertiesModelStore _propertiesModelStore;
    private final ISubscriptionManager _subscriptionManager;
    private final EventProducer changeHandlersNotifier;

    public UserManager(ISubscriptionManager iSubscriptionManager0, IdentityModelStore identityModelStore0, PropertiesModelStore propertiesModelStore0, ILanguageContext iLanguageContext0) {
        Intrinsics.checkNotNullParameter(iSubscriptionManager0, "_subscriptionManager");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore0, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(iLanguageContext0, "_languageContext");
        super();
        this._subscriptionManager = iSubscriptionManager0;
        this._identityModelStore = identityModelStore0;
        this._propertiesModelStore = propertiesModelStore0;
        this._languageContext = iLanguageContext0;
        this.changeHandlersNotifier = new EventProducer();
        identityModelStore0.subscribe(this);
    }

    @Override  // com.onesignal.user.IUserManager
    public void addAlias(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "label");
        Intrinsics.checkNotNullParameter(s1, "id");
        Logging.log(LogLevel.DEBUG, "setAlias(label: " + s + ", id: " + s1 + ')');
        if(s.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot add empty alias");
            return;
        }
        if(Intrinsics.areEqual(s, "onesignal_id")) {
            Logging.log(LogLevel.ERROR, "Cannot add \'onesignal_id\' alias");
            return;
        }
        this.get_identityModel().put(s, s1);
    }

    @Override  // com.onesignal.user.IUserManager
    public void addAliases(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "aliases");
        Logging.log(LogLevel.DEBUG, "addAliases(aliases: " + map0);
        for(Object object0: map0.entrySet()) {
            if(((CharSequence)((Map.Entry)object0).getKey()).length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot add empty alias");
                return;
            }
            if(Intrinsics.areEqual(((Map.Entry)object0).getKey(), "onesignal_id")) {
                Logging.log(LogLevel.ERROR, "Cannot add \'onesignal_id\' alias");
                return;
            }
            if(false) {
                break;
            }
        }
        for(Object object1: map0.entrySet()) {
            this.get_identityModel().put(((Map.Entry)object1).getKey(), ((Map.Entry)object1).getValue());
        }
    }

    @Override  // com.onesignal.user.IUserManager
    public void addEmail(String s) {
        Intrinsics.checkNotNullParameter(s, "email");
        Logging.log(LogLevel.DEBUG, "addEmail(email: " + s + ')');
        if(!OneSignalUtils.INSTANCE.isValidEmail(s)) {
            Logging.log(LogLevel.ERROR, "Cannot add invalid email address as subscription: " + s);
            return;
        }
        this._subscriptionManager.addEmailSubscription(s);
    }

    @Override  // com.onesignal.user.IUserManager
    public void addObserver(IUserStateObserver iUserStateObserver0) {
        Intrinsics.checkNotNullParameter(iUserStateObserver0, "observer");
        this.changeHandlersNotifier.subscribe(iUserStateObserver0);
    }

    @Override  // com.onesignal.user.IUserManager
    public void addSms(String s) {
        Intrinsics.checkNotNullParameter(s, "sms");
        Logging.log(LogLevel.DEBUG, "addSms(sms: " + s + ')');
        if(!OneSignalUtils.INSTANCE.isValidPhoneNumber(s)) {
            Logging.log(LogLevel.ERROR, "Cannot add invalid sms number as subscription: " + s);
            return;
        }
        this._subscriptionManager.addSmsSubscription(s);
    }

    @Override  // com.onesignal.user.IUserManager
    public void addTag(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "key");
        Intrinsics.checkNotNullParameter(s1, "value");
        Logging.log(LogLevel.DEBUG, "setTag(key: " + s + ", value: " + s1 + ')');
        if(s.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot add tag with empty key");
            return;
        }
        this.get_propertiesModel().getTags().put(s, s1);
    }

    @Override  // com.onesignal.user.IUserManager
    public void addTags(Map map0) {
        Intrinsics.checkNotNullParameter(map0, "tags");
        Logging.log(LogLevel.DEBUG, "setTags(tags: " + map0 + ')');
        for(Object object0: map0.entrySet()) {
            if(((CharSequence)((Map.Entry)object0).getKey()).length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot add tag with empty key");
                return;
            }
            if(false) {
                break;
            }
        }
        for(Object object1: map0.entrySet()) {
            this.get_propertiesModel().getTags().put(((Map.Entry)object1).getKey(), ((Map.Entry)object1).getValue());
        }
    }

    public final Map getAliases() {
        Map map0 = this.get_identityModel();
        Map map1 = new LinkedHashMap();
        for(Object object0: map0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(!Intrinsics.areEqual(map$Entry0.getKey(), "id") != 0) {
                map1.put(map$Entry0.getKey(), map$Entry0.getValue());
            }
        }
        return MapsKt.toMap(map1);
    }

    public final EventProducer getChangeHandlersNotifier() {
        return this.changeHandlersNotifier;
    }

    @Override  // com.onesignal.user.IUserManager
    public String getExternalId() {
        String s = this.get_identityModel().getExternalId();
        return s == null ? "" : s;
    }

    @Override  // com.onesignal.user.IUserManager
    public String getOnesignalId() {
        String s = this.get_identityModel().getOnesignalId();
        return IDManager.INSTANCE.isLocalId(s) ? "" : this.get_identityModel().getOnesignalId();
    }

    @Override  // com.onesignal.user.IUserManager
    public IPushSubscription getPushSubscription() {
        return this._subscriptionManager.getSubscriptions().getPush();
    }

    public final SubscriptionList getSubscriptions() {
        return this._subscriptionManager.getSubscriptions();
    }

    @Override  // com.onesignal.user.IUserManager
    public Map getTags() {
        return MapsKt.toMap(this.get_propertiesModel().getTags());
    }

    private final IdentityModel get_identityModel() {
        return (IdentityModel)this._identityModelStore.getModel();
    }

    private final PropertiesModel get_propertiesModel() {
        return (PropertiesModel)this._propertiesModelStore.getModel();
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelReplaced(Model model0, String s) {
        this.onModelReplaced(((IdentityModel)model0), s);
    }

    public void onModelReplaced(IdentityModel identityModel0, String s) {
        Intrinsics.checkNotNullParameter(identityModel0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs modelChangedArgs0, String s) {
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(Intrinsics.areEqual(modelChangedArgs0.getProperty(), "onesignal_id")) {
            Function1 function10 = new Function1() {
                final UserState $newUserState;

                {
                    this.$newUserState = userState0;
                    super(1);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    this.invoke(((IUserStateObserver)object0));
                    return Unit.INSTANCE;
                }

                public final void invoke(IUserStateObserver iUserStateObserver0) {
                    Intrinsics.checkNotNullParameter(iUserStateObserver0, "it");
                    iUserStateObserver0.onUserStateChange(new UserChangedState(this.$newUserState));
                }
            };
            this.changeHandlersNotifier.fire(function10);
        }
    }

    @Override  // com.onesignal.user.IUserManager
    public void removeAlias(String s) {
        Intrinsics.checkNotNullParameter(s, "label");
        Logging.log(LogLevel.DEBUG, "removeAlias(label: " + s + ')');
        if(s.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot remove empty alias");
            return;
        }
        if(Intrinsics.areEqual(s, "onesignal_id")) {
            Logging.log(LogLevel.ERROR, "Cannot remove \'onesignal_id\' alias");
            return;
        }
        this.get_identityModel().remove(s);
    }

    @Override  // com.onesignal.user.IUserManager
    public void removeAliases(Collection collection0) {
        Intrinsics.checkNotNullParameter(collection0, "labels");
        Logging.log(LogLevel.DEBUG, "removeAliases(labels: " + collection0 + ')');
        for(Object object0: collection0) {
            if(((String)object0).length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot remove empty alias");
                return;
            }
            if(Intrinsics.areEqual(((String)object0), "onesignal_id")) {
                Logging.log(LogLevel.ERROR, "Cannot remove \'onesignal_id\' alias");
                return;
            }
            if(false) {
                break;
            }
        }
        for(Object object1: collection0) {
            this.get_identityModel().remove(((String)object1));
        }
    }

    @Override  // com.onesignal.user.IUserManager
    public void removeEmail(String s) {
        Intrinsics.checkNotNullParameter(s, "email");
        Logging.log(LogLevel.DEBUG, "removeEmail(email: " + s + ')');
        if(!OneSignalUtils.INSTANCE.isValidEmail(s)) {
            Logging.log(LogLevel.ERROR, "Cannot remove invalid email address as subscription: " + s);
            return;
        }
        this._subscriptionManager.removeEmailSubscription(s);
    }

    @Override  // com.onesignal.user.IUserManager
    public void removeObserver(IUserStateObserver iUserStateObserver0) {
        Intrinsics.checkNotNullParameter(iUserStateObserver0, "observer");
        this.changeHandlersNotifier.unsubscribe(iUserStateObserver0);
    }

    @Override  // com.onesignal.user.IUserManager
    public void removeSms(String s) {
        Intrinsics.checkNotNullParameter(s, "sms");
        Logging.log(LogLevel.DEBUG, "removeSms(sms: " + s + ')');
        if(!OneSignalUtils.INSTANCE.isValidPhoneNumber(s)) {
            Logging.log(LogLevel.ERROR, "Cannot remove invalid sms number as subscription: " + s);
            return;
        }
        this._subscriptionManager.removeSmsSubscription(s);
    }

    @Override  // com.onesignal.user.IUserManager
    public void removeTag(String s) {
        Intrinsics.checkNotNullParameter(s, "key");
        Logging.log(LogLevel.DEBUG, "removeTag(key: " + s + ')');
        if(s.length() == 0) {
            Logging.log(LogLevel.ERROR, "Cannot remove tag with empty key");
            return;
        }
        this.get_propertiesModel().getTags().remove(s);
    }

    @Override  // com.onesignal.user.IUserManager
    public void removeTags(Collection collection0) {
        Intrinsics.checkNotNullParameter(collection0, "keys");
        Logging.log(LogLevel.DEBUG, "removeTags(keys: " + collection0 + ')');
        for(Object object0: collection0) {
            if(((String)object0).length() == 0) {
                Logging.log(LogLevel.ERROR, "Cannot remove tag with empty key");
                return;
            }
            if(false) {
                break;
            }
        }
        for(Object object1: collection0) {
            this.get_propertiesModel().getTags().remove(((String)object1));
        }
    }

    @Override  // com.onesignal.user.IUserManager
    public void setLanguage(String s) {
        Intrinsics.checkNotNullParameter(s, "value");
        this._languageContext.setLanguage(s);
    }
}

