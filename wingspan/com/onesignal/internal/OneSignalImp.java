package com.onesignal.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.onesignal.IOneSignal;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.common.modeling.ISingletonModelStore.DefaultImpls;
import com.onesignal.common.modules.IModule;
import com.onesignal.common.services.IServiceProvider;
import com.onesignal.common.services.ServiceBuilder;
import com.onesignal.common.services.ServiceProvider;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.CoreModule;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.application.impl.ApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceStoreFix;
import com.onesignal.core.internal.startup.StartupService;
import com.onesignal.debug.IDebugManager;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.DebugManager;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.IInAppMessagesManager;
import com.onesignal.location.ILocationManager;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.session.ISessionManager;
import com.onesignal.session.SessionModule;
import com.onesignal.session.internal.session.SessionModel;
import com.onesignal.session.internal.session.SessionModelStore;
import com.onesignal.user.IUserManager;
import com.onesignal.user.UserModule;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u00C2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00A2\u0006\u0002\u0010\u0003JN\u0010O\u001A\u00020P2\b\b\u0002\u0010Q\u001A\u00020\u00052:\b\u0002\u0010R\u001A4\u0012\u0013\u0012\u00110T\u00A2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(W\u0012\u0013\u0012\u00110X\u00A2\u0006\f\bU\u0012\b\bV\u0012\u0004\b\b(Y\u0012\u0004\u0012\u00020P\u0018\u00010SH\u0002J\"\u0010Z\u001A\b\u0012\u0004\u0012\u0002H[0/\"\u0004\b\u0000\u0010[2\f\u0010\\\u001A\b\u0012\u0004\u0012\u0002H[0]H\u0016J!\u0010^\u001A\u0002H[\"\u0004\b\u0000\u0010[2\f\u0010\\\u001A\b\u0012\u0004\u0012\u0002H[0]H\u0016\u00A2\u0006\u0002\u0010_J#\u0010`\u001A\u0004\u0018\u0001H[\"\u0004\b\u0000\u0010[2\f\u0010\\\u001A\b\u0012\u0004\u0012\u0002H[0]H\u0016\u00A2\u0006\u0002\u0010_J\u001C\u0010a\u001A\u00020\u0005\"\u0004\b\u0000\u0010[2\f\u0010\\\u001A\b\u0012\u0004\u0012\u0002H[0]H\u0016J\u001A\u0010b\u001A\u00020\u00052\u0006\u0010c\u001A\u00020d2\b\u0010e\u001A\u0004\u0018\u000100H\u0016J\u001A\u0010f\u001A\u00020P2\u0006\u0010g\u001A\u0002002\b\u0010h\u001A\u0004\u0018\u000100H\u0016J\b\u0010i\u001A\u00020PH\u0016R\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E\u00A2\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001A\u0004\u0018\u00010\u0005X\u0082\u000E\u00A2\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\b\u001A\u0004\u0018\u00010\u0005X\u0082\u000E\u00A2\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001A\u0004\u0018\u00010\nX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010\r\u001A\u0004\u0018\u00010\u000EX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u000F\u001A\u0004\u0018\u00010\u0010X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0082\u000E\u00A2\u0006\u0002\n\u0000R$\u0010\u0014\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00058V@VX\u0096\u000E\u00A2\u0006\f\u001A\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00058V@VX\u0096\u000E\u00A2\u0006\f\u001A\u0004\b\u001A\u0010\u0016\"\u0004\b\u001B\u0010\u0018R\u0014\u0010\u001C\u001A\u00020\u001DX\u0096\u0004\u00A2\u0006\b\n\u0000\u001A\u0004\b\u001E\u0010\u001FR$\u0010 \u001A\u00020\u00052\u0006\u0010\u0013\u001A\u00020\u00058V@VX\u0096\u000E\u00A2\u0006\f\u001A\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u0010\u0010#\u001A\u0004\u0018\u00010$X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010%\u001A\u0004\u0018\u00010&X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\'\u001A\u00020$8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b(\u0010)R\u000E\u0010*\u001A\u00020+X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u001A\u0010,\u001A\u00020\u0005X\u0096\u000E\u00A2\u0006\u000E\n\u0000\u001A\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R\u0014\u0010.\u001A\b\u0012\u0004\u0012\u0002000/X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u00101\u001A\u00020\n8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b2\u00103R\u000E\u00104\u001A\u00020+X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u00105\u001A\u00020\f8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b6\u00107R\u0010\u00108\u001A\u0004\u0018\u000109X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010:\u001A\u0004\u0018\u00010;X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010<\u001A\u0004\u0018\u00010=X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010>\u001A\u000200X\u0096D\u00A2\u0006\b\n\u0000\u001A\u0004\b?\u0010@R\u000E\u0010A\u001A\u00020BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010C\u001A\u00020\u000E8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bD\u0010ER\u0010\u0010F\u001A\u0004\u0018\u00010GX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010H\u001A\u0004\u0018\u00010IX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0010\u0010J\u001A\u0004\u0018\u00010KX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010L\u001A\u00020\u00108VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\bM\u0010N\u00A8\u0006j"}, d2 = {"Lcom/onesignal/internal/OneSignalImp;", "Lcom/onesignal/IOneSignal;", "Lcom/onesignal/common/services/IServiceProvider;", "()V", "_consentGiven", "", "Ljava/lang/Boolean;", "_consentRequired", "_disableGMSMissingPrompt", "_location", "Lcom/onesignal/location/ILocationManager;", "_notifications", "Lcom/onesignal/notifications/INotificationsManager;", "_session", "Lcom/onesignal/session/ISessionManager;", "_user", "Lcom/onesignal/user/IUserManager;", "configModel", "Lcom/onesignal/core/internal/config/ConfigModel;", "value", "consentGiven", "getConsentGiven", "()Z", "setConsentGiven", "(Z)V", "consentRequired", "getConsentRequired", "setConsentRequired", "debug", "Lcom/onesignal/debug/IDebugManager;", "getDebug", "()Lcom/onesignal/debug/IDebugManager;", "disableGMSMissingPrompt", "getDisableGMSMissingPrompt", "setDisableGMSMissingPrompt", "iam", "Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "inAppMessages", "getInAppMessages", "()Lcom/onesignal/inAppMessages/IInAppMessagesManager;", "initLock", "", "isInitialized", "setInitialized", "listOfModules", "", "", "location", "getLocation", "()Lcom/onesignal/location/ILocationManager;", "loginLock", "notifications", "getNotifications", "()Lcom/onesignal/notifications/INotificationsManager;", "operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "preferencesService", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "sdkVersion", "getSdkVersion", "()Ljava/lang/String;", "services", "Lcom/onesignal/common/services/ServiceProvider;", "session", "getSession", "()Lcom/onesignal/session/ISessionManager;", "sessionModel", "Lcom/onesignal/session/internal/session/SessionModel;", "startupService", "Lcom/onesignal/core/internal/startup/StartupService;", "subscriptionModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "user", "getUser", "()Lcom/onesignal/user/IUserManager;", "createAndSwitchToNewUser", "", "suppressBackendOperation", "modify", "Lkotlin/Function2;", "Lcom/onesignal/user/internal/identity/IdentityModel;", "Lkotlin/ParameterName;", "name", "identityModel", "Lcom/onesignal/user/internal/properties/PropertiesModel;", "propertiesModel", "getAllServices", "T", "c", "Ljava/lang/Class;", "getService", "(Ljava/lang/Class;)Ljava/lang/Object;", "getServiceOrNull", "hasService", "initWithContext", "context", "Landroid/content/Context;", "appId", "login", "externalId", "jwtBearerToken", "logout", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OneSignalImp implements IOneSignal, IServiceProvider {
    private Boolean _consentGiven;
    private Boolean _consentRequired;
    private Boolean _disableGMSMissingPrompt;
    private ILocationManager _location;
    private INotificationsManager _notifications;
    private ISessionManager _session;
    private IUserManager _user;
    private ConfigModel configModel;
    private final IDebugManager debug;
    private IInAppMessagesManager iam;
    private IdentityModelStore identityModelStore;
    private final Object initLock;
    private boolean isInitialized;
    private final List listOfModules;
    private final Object loginLock;
    private IOperationRepo operationRepo;
    private IPreferencesService preferencesService;
    private PropertiesModelStore propertiesModelStore;
    private final String sdkVersion;
    private final ServiceProvider services;
    private SessionModel sessionModel;
    private StartupService startupService;
    private SubscriptionModelStore subscriptionModelStore;

    public OneSignalImp() {
        this.sdkVersion = "050109";
        this.debug = new DebugManager();
        this.initLock = new Object();
        this.loginLock = new Object();
        List list0 = CollectionsKt.listOf(new String[]{"com.onesignal.notifications.NotificationsModule", "com.onesignal.inAppMessages.InAppMessagesModule", "com.onesignal.location.LocationModule"});
        this.listOfModules = list0;
        ServiceBuilder serviceBuilder0 = new ServiceBuilder();
        List list1 = new ArrayList();
        list1.add(new CoreModule());
        list1.add(new SessionModule());
        list1.add(new UserModule());
        for(Object object0: list0) {
            String s = (String)object0;
            try {
                Object object1 = Class.forName(s).newInstance();
                Intrinsics.checkNotNull(object1, "null cannot be cast to non-null type com.onesignal.common.modules.IModule");
                list1.add(((IModule)object1));
            }
            catch(ClassNotFoundException classNotFoundException0) {
                classNotFoundException0.printStackTrace();
            }
        }
        for(Object object2: list1) {
            ((IModule)object2).register(serviceBuilder0);
        }
        this.services = serviceBuilder0.build();
    }

    private final void createAndSwitchToNewUser(boolean z, Function2 function20) {
        SubscriptionStatus subscriptionStatus0;
        String s3;
        String s1;
        Logging.debug$default("createAndSwitchToNewUser()", null, 2, null);
        IdentityModel identityModel0 = new IdentityModel();
        identityModel0.setOnesignalId("local-9ddb7b0e-f139-4661-a8f2-3bb45960d94d");
        PropertiesModel propertiesModel0 = new PropertiesModel();
        propertiesModel0.setOnesignalId("local-9ddb7b0e-f139-4661-a8f2-3bb45960d94d");
        if(function20 != null) {
            function20.invoke(identityModel0, propertiesModel0);
        }
        List list0 = new ArrayList();
        SubscriptionModelStore subscriptionModelStore0 = this.subscriptionModelStore;
        Intrinsics.checkNotNull(subscriptionModelStore0);
        for(Object object0: subscriptionModelStore0.list()) {
            String s = ((SubscriptionModel)object0).getId();
            ConfigModel configModel0 = this.configModel;
            Intrinsics.checkNotNull(configModel0);
            if(!Intrinsics.areEqual(s, configModel0.getPushSubscriptionId())) {
                continue;
            }
            goto label_19;
        }
        object0 = null;
    label_19:
        SubscriptionModel subscriptionModel0 = new SubscriptionModel();
        if(((SubscriptionModel)object0) == null) {
            s1 = "local-9ddb7b0e-f139-4661-a8f2-3bb45960d94d";
        }
        else {
            s1 = ((SubscriptionModel)object0).getId();
            if(s1 == null) {
                s1 = "local-9ddb7b0e-f139-4661-a8f2-3bb45960d94d";
            }
        }
        subscriptionModel0.setId(s1);
        subscriptionModel0.setType(SubscriptionType.PUSH);
        subscriptionModel0.setOptedIn((((SubscriptionModel)object0) == null ? true : ((SubscriptionModel)object0).getOptedIn()));
        String s2 = "";
        if(((SubscriptionModel)object0) == null) {
            s3 = "";
        }
        else {
            s3 = ((SubscriptionModel)object0).getAddress();
            if(s3 == null) {
                s3 = "";
            }
        }
        subscriptionModel0.setAddress(s3);
        if(((SubscriptionModel)object0) == null) {
            subscriptionStatus0 = SubscriptionStatus.NO_PERMISSION;
        }
        else {
            subscriptionStatus0 = ((SubscriptionModel)object0).getStatus();
            if(subscriptionStatus0 == null) {
                subscriptionStatus0 = SubscriptionStatus.NO_PERMISSION;
            }
        }
        subscriptionModel0.setStatus(subscriptionStatus0);
        subscriptionModel0.setSdk("050109");
        String s4 = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(s4, "RELEASE");
        subscriptionModel0.setDeviceOS(s4);
        Context context0 = ((IApplicationService)this.services.getService(IApplicationService.class)).getAppContext();
        String s5 = DeviceUtils.INSTANCE.getCarrierName(context0);
        if(s5 == null) {
            s5 = "";
        }
        subscriptionModel0.setCarrier(s5);
        Context context1 = ((IApplicationService)this.services.getService(IApplicationService.class)).getAppContext();
        String s6 = AndroidUtils.INSTANCE.getAppVersion(context1);
        if(s6 != null) {
            s2 = s6;
        }
        subscriptionModel0.setAppVersion(s2);
        ConfigModel configModel1 = this.configModel;
        Intrinsics.checkNotNull(configModel1);
        configModel1.setPushSubscriptionId(subscriptionModel0.getId());
        list0.add(subscriptionModel0);
        SubscriptionModelStore subscriptionModelStore1 = this.subscriptionModelStore;
        Intrinsics.checkNotNull(subscriptionModelStore1);
        subscriptionModelStore1.clear("NO_PROPOGATE");
        IdentityModelStore identityModelStore0 = this.identityModelStore;
        Intrinsics.checkNotNull(identityModelStore0);
        DefaultImpls.replace$default(identityModelStore0, identityModel0, null, 2, null);
        PropertiesModelStore propertiesModelStore0 = this.propertiesModelStore;
        Intrinsics.checkNotNull(propertiesModelStore0);
        DefaultImpls.replace$default(propertiesModelStore0, propertiesModel0, null, 2, null);
        if(z) {
            SubscriptionModelStore subscriptionModelStore2 = this.subscriptionModelStore;
            Intrinsics.checkNotNull(subscriptionModelStore2);
            subscriptionModelStore2.replaceAll(list0, "NO_PROPOGATE");
            return;
        }
        if(((SubscriptionModel)object0) != null) {
            IOperationRepo iOperationRepo0 = this.operationRepo;
            Intrinsics.checkNotNull(iOperationRepo0);
            ConfigModel configModel2 = this.configModel;
            Intrinsics.checkNotNull(configModel2);
            com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls.enqueue$default(iOperationRepo0, new TransferSubscriptionOperation(configModel2.getAppId(), ((SubscriptionModel)object0).getId(), "local-9ddb7b0e-f139-4661-a8f2-3bb45960d94d"), false, 2, null);
            SubscriptionModelStore subscriptionModelStore3 = this.subscriptionModelStore;
            Intrinsics.checkNotNull(subscriptionModelStore3);
            subscriptionModelStore3.replaceAll(list0, "NO_PROPOGATE");
            return;
        }
        SubscriptionModelStore subscriptionModelStore4 = this.subscriptionModelStore;
        Intrinsics.checkNotNull(subscriptionModelStore4);
        com.onesignal.common.modeling.IModelStore.DefaultImpls.replaceAll$default(subscriptionModelStore4, list0, null, 2, null);
    }

    static void createAndSwitchToNewUser$default(OneSignalImp oneSignalImp0, boolean z, Function2 function20, int v, Object object0) {
        if((v & 1) != 0) {
            z = false;
        }
        if((v & 2) != 0) {
            function20 = null;
        }
        oneSignalImp0.createAndSwitchToNewUser(z, function20);
    }

    @Override  // com.onesignal.common.services.IServiceProvider
    public List getAllServices(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "c");
        return this.services.getAllServices(class0);
    }

    @Override  // com.onesignal.IOneSignal
    public boolean getConsentGiven() {
        ConfigModel configModel0 = this.configModel;
        if(configModel0 != null) {
            Boolean boolean0 = configModel0.getConsentGiven();
            return boolean0 == null ? Intrinsics.areEqual(this._consentGiven, Boolean.TRUE) : boolean0.booleanValue();
        }
        return Intrinsics.areEqual(this._consentGiven, Boolean.TRUE);
    }

    @Override  // com.onesignal.IOneSignal
    public boolean getConsentRequired() {
        ConfigModel configModel0 = this.configModel;
        if(configModel0 != null) {
            Boolean boolean0 = configModel0.getConsentRequired();
            return boolean0 == null ? Intrinsics.areEqual(this._consentRequired, Boolean.TRUE) : boolean0.booleanValue();
        }
        return Intrinsics.areEqual(this._consentRequired, Boolean.TRUE);
    }

    @Override  // com.onesignal.IOneSignal
    public IDebugManager getDebug() {
        return this.debug;
    }

    @Override  // com.onesignal.IOneSignal
    public boolean getDisableGMSMissingPrompt() {
        ConfigModel configModel0 = this.configModel;
        return configModel0 == null ? Intrinsics.areEqual(this._disableGMSMissingPrompt, Boolean.TRUE) : configModel0.getDisableGMSMissingPrompt();
    }

    @Override  // com.onesignal.IOneSignal
    public IInAppMessagesManager getInAppMessages() {
        if(!this.isInitialized()) {
            throw new Exception("Must call \'initWithContext\' before use");
        }
        IInAppMessagesManager iInAppMessagesManager0 = this.iam;
        Intrinsics.checkNotNull(iInAppMessagesManager0);
        return iInAppMessagesManager0;
    }

    @Override  // com.onesignal.IOneSignal
    public ILocationManager getLocation() {
        if(!this.isInitialized()) {
            throw new Exception("Must call \'initWithContext\' before use");
        }
        ILocationManager iLocationManager0 = this._location;
        Intrinsics.checkNotNull(iLocationManager0);
        return iLocationManager0;
    }

    @Override  // com.onesignal.IOneSignal
    public INotificationsManager getNotifications() {
        if(!this.isInitialized()) {
            throw new Exception("Must call \'initWithContext\' before use");
        }
        INotificationsManager iNotificationsManager0 = this._notifications;
        Intrinsics.checkNotNull(iNotificationsManager0);
        return iNotificationsManager0;
    }

    @Override  // com.onesignal.IOneSignal
    public String getSdkVersion() {
        return this.sdkVersion;
    }

    @Override  // com.onesignal.common.services.IServiceProvider
    public Object getService(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "c");
        return this.services.getService(class0);
    }

    @Override  // com.onesignal.common.services.IServiceProvider
    public Object getServiceOrNull(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "c");
        return this.services.getServiceOrNull(class0);
    }

    @Override  // com.onesignal.IOneSignal
    public ISessionManager getSession() {
        if(!this.isInitialized()) {
            throw new Exception("Must call \'initWithContext\' before use");
        }
        ISessionManager iSessionManager0 = this._session;
        Intrinsics.checkNotNull(iSessionManager0);
        return iSessionManager0;
    }

    @Override  // com.onesignal.IOneSignal
    public IUserManager getUser() {
        if(!this.isInitialized()) {
            throw new Exception("Must call \'initWithContext\' before use");
        }
        IUserManager iUserManager0 = this._user;
        Intrinsics.checkNotNull(iUserManager0);
        return iUserManager0;
    }

    @Override  // com.onesignal.common.services.IServiceProvider
    public boolean hasService(Class class0) {
        Intrinsics.checkNotNullParameter(class0, "c");
        return this.services.hasService(class0);
    }

    @Override  // com.onesignal.IOneSignal
    public boolean initWithContext(Context context0, String s) {
        boolean z1;
        boolean z;
        Intrinsics.checkNotNullParameter(context0, "context");
        Logging.log(LogLevel.DEBUG, "initWithContext(context: " + context0 + ", appId: " + s + ')');
        synchronized(this.initLock) {
            if(this.isInitialized()) {
                Logging.log(LogLevel.DEBUG, "initWithContext: SDK already initialized");
                return true;
            }
            Logging.log(LogLevel.DEBUG, "initWithContext: SDK initializing");
            PreferenceStoreFix.INSTANCE.ensureNoObfuscatedPrefStore(context0);
            IApplicationService iApplicationService0 = (IApplicationService)this.services.getService(IApplicationService.class);
            Intrinsics.checkNotNull(iApplicationService0, "null cannot be cast to non-null type com.onesignal.core.internal.application.impl.ApplicationService");
            ((ApplicationService)iApplicationService0).start(context0);
            Logging.INSTANCE.setApplicationService(iApplicationService0);
            this.configModel = (ConfigModel)((ConfigModelStore)this.services.getService(ConfigModelStore.class)).getModel();
            this.sessionModel = (SessionModel)((SessionModelStore)this.services.getService(SessionModelStore.class)).getModel();
            if(s == null) {
                ConfigModel configModel0 = this.configModel;
                Intrinsics.checkNotNull(configModel0);
                if(!configModel0.hasProperty("appId")) {
                    Logging.warn$default("initWithContext called without providing appId, and no appId has been established!", null, 2, null);
                    return false;
                }
            }
            if(s == null) {
                z = false;
            }
            else {
                ConfigModel configModel1 = this.configModel;
                Intrinsics.checkNotNull(configModel1);
                if(configModel1.hasProperty("appId")) {
                    ConfigModel configModel2 = this.configModel;
                    Intrinsics.checkNotNull(configModel2);
                    z = Intrinsics.areEqual(configModel2.getAppId(), s) ? false : true;
                }
                else {
                    z = true;
                }
                ConfigModel configModel3 = this.configModel;
                Intrinsics.checkNotNull(configModel3);
                configModel3.setAppId(s);
            }
            if(this._consentRequired != null) {
                ConfigModel configModel4 = this.configModel;
                Intrinsics.checkNotNull(configModel4);
                Boolean boolean0 = this._consentRequired;
                Intrinsics.checkNotNull(boolean0);
                configModel4.setConsentRequired(boolean0);
            }
            if(this._consentGiven != null) {
                ConfigModel configModel5 = this.configModel;
                Intrinsics.checkNotNull(configModel5);
                Boolean boolean1 = this._consentGiven;
                Intrinsics.checkNotNull(boolean1);
                configModel5.setConsentGiven(boolean1);
            }
            if(this._disableGMSMissingPrompt != null) {
                ConfigModel configModel6 = this.configModel;
                Intrinsics.checkNotNull(configModel6);
                Boolean boolean2 = this._disableGMSMissingPrompt;
                Intrinsics.checkNotNull(boolean2);
                configModel6.setDisableGMSMissingPrompt(boolean2.booleanValue());
            }
            this._location = (ILocationManager)this.services.getService(ILocationManager.class);
            this._user = (IUserManager)this.services.getService(IUserManager.class);
            this._session = (ISessionManager)this.services.getService(ISessionManager.class);
            this.iam = (IInAppMessagesManager)this.services.getService(IInAppMessagesManager.class);
            this._notifications = (INotificationsManager)this.services.getService(INotificationsManager.class);
            this.operationRepo = (IOperationRepo)this.services.getService(IOperationRepo.class);
            this.propertiesModelStore = (PropertiesModelStore)this.services.getService(PropertiesModelStore.class);
            this.identityModelStore = (IdentityModelStore)this.services.getService(IdentityModelStore.class);
            this.subscriptionModelStore = (SubscriptionModelStore)this.services.getService(SubscriptionModelStore.class);
            this.preferencesService = (IPreferencesService)this.services.getService(IPreferencesService.class);
            StartupService startupService0 = (StartupService)this.services.getService(StartupService.class);
            this.startupService = startupService0;
            Intrinsics.checkNotNull(startupService0);
            startupService0.bootstrap();
            if(z) {
            label_83:
                IPreferencesService iPreferencesService0 = this.preferencesService;
                Intrinsics.checkNotNull(iPreferencesService0);
                String s1 = com.onesignal.core.internal.preferences.IPreferencesService.DefaultImpls.getString$default(iPreferencesService0, "OneSignal", "GT_PLAYER_ID", null, 4, null);
                if(s1 == null) {
                    Logging.debug$default("initWithContext: creating new device-scoped user", null, 2, null);
                    OneSignalImp.createAndSwitchToNewUser$default(this, false, null, 3, null);
                    IOperationRepo iOperationRepo0 = this.operationRepo;
                    Intrinsics.checkNotNull(iOperationRepo0);
                    ConfigModel configModel7 = this.configModel;
                    Intrinsics.checkNotNull(configModel7);
                    String s2 = configModel7.getAppId();
                    IdentityModelStore identityModelStore2 = this.identityModelStore;
                    Intrinsics.checkNotNull(identityModelStore2);
                    String s3 = ((IdentityModel)identityModelStore2.getModel()).getOnesignalId();
                    IdentityModelStore identityModelStore3 = this.identityModelStore;
                    Intrinsics.checkNotNull(identityModelStore3);
                    com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls.enqueue$default(iOperationRepo0, new LoginUserOperation(s2, s3, ((IdentityModel)identityModelStore3.getModel()).getExternalId(), null, 8, null), false, 2, null);
                }
                else {
                    Logging.debug$default(("initWithContext: creating user linked to subscription " + s1), null, 2, null);
                    IPreferencesService iPreferencesService1 = this.preferencesService;
                    Intrinsics.checkNotNull(iPreferencesService1);
                    String s4 = com.onesignal.core.internal.preferences.IPreferencesService.DefaultImpls.getString$default(iPreferencesService1, "OneSignal", "ONESIGNAL_USERSTATE_SYNCVALYES_CURRENT_STATE", null, 4, null);
                    if(s4 == null) {
                        z1 = false;
                    }
                    else {
                        JSONObject jSONObject0 = new JSONObject(s4);
                        Integer integer0 = JSONObjectExtensionsKt.safeInt(jSONObject0, "notification_types");
                        SubscriptionModel subscriptionModel0 = new SubscriptionModel();
                        subscriptionModel0.setId(s1);
                        subscriptionModel0.setType(SubscriptionType.PUSH);
                        subscriptionModel0.setOptedIn((integer0 == null || ((int)integer0) != SubscriptionStatus.NO_PERMISSION.getValue()) && (integer0 == null || ((int)integer0) != SubscriptionStatus.UNSUBSCRIBE.getValue()));
                        String s5 = JSONObjectExtensionsKt.safeString(jSONObject0, "identifier");
                        if(s5 == null) {
                            s5 = "";
                        }
                        subscriptionModel0.setAddress(s5);
                        if(integer0 == null) {
                            subscriptionModel0.setStatus(SubscriptionStatus.SUBSCRIBED);
                        }
                        else {
                            SubscriptionStatus subscriptionStatus0 = SubscriptionStatus.Companion.fromInt(((int)integer0));
                            if(subscriptionStatus0 == null) {
                                subscriptionStatus0 = SubscriptionStatus.NO_PERMISSION;
                            }
                            subscriptionModel0.setStatus(subscriptionStatus0);
                        }
                        subscriptionModel0.setSdk("050109");
                        String s6 = Build.VERSION.RELEASE;
                        Intrinsics.checkNotNullExpressionValue(s6, "RELEASE");
                        subscriptionModel0.setDeviceOS(s6);
                        Context context1 = ((IApplicationService)this.services.getService(IApplicationService.class)).getAppContext();
                        String s7 = DeviceUtils.INSTANCE.getCarrierName(context1);
                        if(s7 == null) {
                            s7 = "";
                        }
                        subscriptionModel0.setCarrier(s7);
                        Context context2 = ((IApplicationService)this.services.getService(IApplicationService.class)).getAppContext();
                        String s8 = AndroidUtils.INSTANCE.getAppVersion(context2);
                        if(s8 == null) {
                            s8 = "";
                        }
                        subscriptionModel0.setAppVersion(s8);
                        ConfigModel configModel8 = this.configModel;
                        Intrinsics.checkNotNull(configModel8);
                        configModel8.setPushSubscriptionId(s1);
                        SubscriptionModelStore subscriptionModelStore0 = this.subscriptionModelStore;
                        Intrinsics.checkNotNull(subscriptionModelStore0);
                        subscriptionModelStore0.add(subscriptionModel0, "NO_PROPOGATE");
                        z1 = true;
                    }
                    OneSignalImp.createAndSwitchToNewUser$default(this, z1, null, 2, null);
                    IOperationRepo iOperationRepo1 = this.operationRepo;
                    Intrinsics.checkNotNull(iOperationRepo1);
                    ConfigModel configModel9 = this.configModel;
                    Intrinsics.checkNotNull(configModel9);
                    String s9 = configModel9.getAppId();
                    IdentityModelStore identityModelStore4 = this.identityModelStore;
                    Intrinsics.checkNotNull(identityModelStore4);
                    com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls.enqueue$default(iOperationRepo1, new LoginUserFromSubscriptionOperation(s9, ((IdentityModel)identityModelStore4.getModel()).getOnesignalId(), s1), false, 2, null);
                    IPreferencesService iPreferencesService2 = this.preferencesService;
                    Intrinsics.checkNotNull(iPreferencesService2);
                    iPreferencesService2.saveString("OneSignal", "GT_PLAYER_ID", null);
                }
            }
            else {
                IdentityModelStore identityModelStore0 = this.identityModelStore;
                Intrinsics.checkNotNull(identityModelStore0);
                if(((IdentityModel)identityModelStore0.getModel()).hasProperty("onesignal_id")) {
                    IdentityModelStore identityModelStore1 = this.identityModelStore;
                    Intrinsics.checkNotNull(identityModelStore1);
                    Logging.debug$default(("initWithContext: using cached user " + ((IdentityModel)identityModelStore1.getModel()).getOnesignalId()), null, 2, null);
                    goto label_158;
                }
                goto label_83;
            }
        label_158:
            StartupService startupService1 = this.startupService;
            Intrinsics.checkNotNull(startupService1);
            startupService1.start();
            this.setInitialized(true);
            return true;
        }
    }

    @Override  // com.onesignal.IOneSignal
    public boolean isInitialized() {
        return this.isInitialized;
    }

    @Override  // com.onesignal.IOneSignal
    public void login(String s) {
        com.onesignal.IOneSignal.DefaultImpls.login(this, s);
    }

    @Override  // com.onesignal.IOneSignal
    public void login(String s, String s1) {
        Intrinsics.checkNotNullParameter(s, "externalId");
        Logging.log(LogLevel.DEBUG, "login(externalId: " + s + ", jwtBearerToken: " + s1 + ')');
        if(!this.isInitialized()) {
            throw new Exception("Must call \'initWithContext\' before \'login\'");
        }
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        ObjectRef ref$ObjectRef1 = new ObjectRef();
        ObjectRef ref$ObjectRef2 = new ObjectRef();
        ref$ObjectRef2.element = "";
        synchronized(this.loginLock) {
            IdentityModelStore identityModelStore0 = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore0);
            ref$ObjectRef0.element = ((IdentityModel)identityModelStore0.getModel()).getExternalId();
            IdentityModelStore identityModelStore1 = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore1);
            ref$ObjectRef1.element = ((IdentityModel)identityModelStore1.getModel()).getOnesignalId();
            if(Intrinsics.areEqual(ref$ObjectRef0.element, s)) {
                return;
            }
            OneSignalImp.createAndSwitchToNewUser$default(this, false, new Function2() {
                final String $externalId;

                {
                    this.$externalId = s;
                    super(2);
                }

                @Override  // kotlin.jvm.functions.Function2
                public Object invoke(Object object0, Object object1) {
                    this.invoke(((IdentityModel)object0), ((PropertiesModel)object1));
                    return Unit.INSTANCE;
                }

                public final void invoke(IdentityModel identityModel0, PropertiesModel propertiesModel0) {
                    Intrinsics.checkNotNullParameter(identityModel0, "identityModel");
                    Intrinsics.checkNotNullParameter(propertiesModel0, "<anonymous parameter 1>");
                    identityModel0.setExternalId(this.$externalId);
                }
            }, 1, null);
            IdentityModelStore identityModelStore2 = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore2);
            ref$ObjectRef2.element = ((IdentityModel)identityModelStore2.getModel()).getOnesignalId();
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(ref$ObjectRef2, s, ref$ObjectRef0, ref$ObjectRef1, null) {
            final ObjectRef $currentIdentityExternalId;
            final ObjectRef $currentIdentityOneSignalId;
            final String $externalId;
            final ObjectRef $newIdentityOneSignalId;
            int label;

            {
                OneSignalImp.this = oneSignalImp0;
                this.$newIdentityOneSignalId = ref$ObjectRef0;
                this.$externalId = s;
                this.$currentIdentityExternalId = ref$ObjectRef1;
                this.$currentIdentityOneSignalId = ref$ObjectRef2;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.internal.OneSignalImp.login.2(OneSignalImp.this, this.$newIdentityOneSignalId, this.$externalId, this.$currentIdentityExternalId, this.$currentIdentityOneSignalId, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.internal.OneSignalImp.login.2)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        IOperationRepo iOperationRepo0 = OneSignalImp.this.operationRepo;
                        Intrinsics.checkNotNull(iOperationRepo0);
                        ConfigModel configModel0 = OneSignalImp.this.configModel;
                        Intrinsics.checkNotNull(configModel0);
                        LoginUserOperation loginUserOperation0 = new LoginUserOperation(configModel0.getAppId(), ((String)this.$newIdentityOneSignalId.element), this.$externalId, (this.$currentIdentityExternalId.element == null ? ((String)this.$currentIdentityOneSignalId.element) : null));
                        this.label = 1;
                        object0 = com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls.enqueueAndWait$default(iOperationRepo0, loginUserOperation0, false, this, 2, null);
                        if(object0 == object1) {
                            return object1;
                        }
                        break;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        break;
                    }
                    case 2: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(!((Boolean)object0).booleanValue()) {
                    Logging.log(LogLevel.ERROR, "Could not login user");
                    return Unit.INSTANCE;
                }
                IOperationRepo iOperationRepo1 = OneSignalImp.this.operationRepo;
                Intrinsics.checkNotNull(iOperationRepo1);
                ConfigModel configModel1 = OneSignalImp.this.configModel;
                Intrinsics.checkNotNull(configModel1);
                String s = configModel1.getAppId();
                IdentityModelStore identityModelStore0 = OneSignalImp.this.identityModelStore;
                Intrinsics.checkNotNull(identityModelStore0);
                RefreshUserOperation refreshUserOperation0 = new RefreshUserOperation(s, ((IdentityModel)identityModelStore0.getModel()).getOnesignalId());
                this.label = 2;
                return com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls.enqueueAndWait$default(iOperationRepo1, refreshUserOperation0, false, this, 2, null) == object1 ? object1 : Unit.INSTANCE;
            }
        }, 1, null);
    }

    @Override  // com.onesignal.IOneSignal
    public void logout() {
        Logging.log(LogLevel.DEBUG, "logout()");
        if(!this.isInitialized()) {
            throw new Exception("Must call \'initWithContext\' before \'logout\'");
        }
        synchronized(this.loginLock) {
            IdentityModelStore identityModelStore0 = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore0);
            if(((IdentityModel)identityModelStore0.getModel()).getExternalId() == null) {
                return;
            }
            OneSignalImp.createAndSwitchToNewUser$default(this, false, null, 3, null);
            IOperationRepo iOperationRepo0 = this.operationRepo;
            Intrinsics.checkNotNull(iOperationRepo0);
            ConfigModel configModel0 = this.configModel;
            Intrinsics.checkNotNull(configModel0);
            String s = configModel0.getAppId();
            IdentityModelStore identityModelStore1 = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore1);
            String s1 = ((IdentityModel)identityModelStore1.getModel()).getOnesignalId();
            IdentityModelStore identityModelStore2 = this.identityModelStore;
            Intrinsics.checkNotNull(identityModelStore2);
            com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls.enqueue$default(iOperationRepo0, new LoginUserOperation(s, s1, ((IdentityModel)identityModelStore2.getModel()).getExternalId(), null, 8, null), false, 2, null);
        }
    }

    @Override  // com.onesignal.IOneSignal
    public void setConsentGiven(boolean z) {
        this._consentGiven = Boolean.valueOf(z);
        ConfigModel configModel0 = this.configModel;
        if(configModel0 != null) {
            configModel0.setConsentGiven(Boolean.valueOf(z));
        }
    }

    @Override  // com.onesignal.IOneSignal
    public void setConsentRequired(boolean z) {
        this._consentRequired = Boolean.valueOf(z);
        ConfigModel configModel0 = this.configModel;
        if(configModel0 != null) {
            configModel0.setConsentRequired(Boolean.valueOf(z));
        }
    }

    @Override  // com.onesignal.IOneSignal
    public void setDisableGMSMissingPrompt(boolean z) {
        this._disableGMSMissingPrompt = Boolean.valueOf(z);
        ConfigModel configModel0 = this.configModel;
        if(configModel0 != null) {
            configModel0.setDisableGMSMissingPrompt(z);
        }
    }

    public void setInitialized(boolean z) {
        this.isInitialized = z;
    }
}

