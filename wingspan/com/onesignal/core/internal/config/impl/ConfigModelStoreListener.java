package com.onesignal.core.internal.config.impl;

import com.onesignal.common.exceptions.BackendException;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.backend.IParamsBackendService;
import com.onesignal.core.internal.backend.ParamsObject;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u001D\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000B\u001A\u00020\fH\u0002J\u0018\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\u00032\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\u0018\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0014\u001A\u00020\fH\u0016R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/onesignal/core/internal/config/impl/ConfigModelStoreListener;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/core/internal/config/ConfigModel;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_paramsBackendService", "Lcom/onesignal/core/internal/backend/IParamsBackendService;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "(Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/backend/IParamsBackendService;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;)V", "fetchParams", "", "onModelReplaced", "model", "tag", "", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "start", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ConfigModelStoreListener implements ISingletonModelStoreChangeHandler, IStartableService {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/core/internal/config/impl/ConfigModelStoreListener$Companion;", "", "()V", "INCREASE_BETWEEN_RETRIES", "", "MAX_WAIT_BETWEEN_RETRIES", "MIN_WAIT_BETWEEN_RETRIES", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final Companion Companion = null;
    private static final int INCREASE_BETWEEN_RETRIES = 10000;
    private static final int MAX_WAIT_BETWEEN_RETRIES = 90000;
    private static final int MIN_WAIT_BETWEEN_RETRIES = 30000;
    private final ConfigModelStore _configModelStore;
    private final IParamsBackendService _paramsBackendService;
    private final ISubscriptionManager _subscriptionManager;

    static {
        ConfigModelStoreListener.Companion = new Companion(null);
    }

    public ConfigModelStoreListener(ConfigModelStore configModelStore0, IParamsBackendService iParamsBackendService0, ISubscriptionManager iSubscriptionManager0) {
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iParamsBackendService0, "_paramsBackendService");
        Intrinsics.checkNotNullParameter(iSubscriptionManager0, "_subscriptionManager");
        super();
        this._configModelStore = configModelStore0;
        this._paramsBackendService = iParamsBackendService0;
        this._subscriptionManager = iSubscriptionManager0;
    }

    private final void fetchParams() {
        String s = ((ConfigModel)this._configModelStore.getModel()).getAppId();
        if(s.length() == 0) {
            return;
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(this, null) {
            final String $appId;
            int I$0;
            int I$1;
            int label;

            {
                this.$appId = s;
                ConfigModelStoreListener.this = configModelStoreListener0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.core.internal.config.impl.ConfigModelStoreListener.fetchParams.1(this.$appId, ConfigModelStoreListener.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.core.internal.config.impl.ConfigModelStoreListener.fetchParams.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object2;
                com.onesignal.core.internal.config.impl.ConfigModelStoreListener.fetchParams.1 configModelStoreListener$fetchParams$11;
                int v4;
                int v3;
                int v;
                com.onesignal.core.internal.config.impl.ConfigModelStoreListener.fetchParams.1 configModelStoreListener$fetchParams$10;
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        Logging.debug$default(("ConfigModelListener: fetching parameters for appId: " + this.$appId), null, 2, null);
                        configModelStoreListener$fetchParams$10 = this;
                        v = 0;
                        goto label_30;
                    }
                    case 1: {
                        try {
                            int v1 = this.I$1;
                            int v2 = this.I$0;
                            v3 = v2;
                            v4 = v1;
                            configModelStoreListener$fetchParams$11 = this;
                            ResultKt.throwOnFailure(object0);
                            v3 = v2;
                            v4 = v1;
                            configModelStoreListener$fetchParams$11 = this;
                            goto label_52;
                        }
                        catch(BackendException backendException0) {
                            goto label_121;
                        }
                    }
                    case 2: {
                        int v5 = this.I$1;
                        int v6 = this.I$0;
                        ResultKt.throwOnFailure(object0);
                        v3 = v6;
                        v4 = v5;
                        configModelStoreListener$fetchParams$11 = this;
                        do {
                            ++v3;
                            configModelStoreListener$fetchParams$10 = configModelStoreListener$fetchParams$11;
                            for(int v7 = v4; true; v7 = 1) {
                                v = v3;
                                if(v7 != 0) {
                                    return Unit.INSTANCE;
                                }
                                try {
                                label_30:
                                    IParamsBackendService iParamsBackendService0 = ConfigModelStoreListener.this._paramsBackendService;
                                    String s = configModelStoreListener$fetchParams$10.$appId;
                                    CharSequence charSequence0 = ConfigModelStoreListener.this._subscriptionManager.getSubscriptions().getPush().getId();
                                    if(charSequence0.length() == 0) {
                                        charSequence0 = null;
                                    }
                                    configModelStoreListener$fetchParams$10.I$0 = v;
                                    configModelStoreListener$fetchParams$10.I$1 = 0;
                                    configModelStoreListener$fetchParams$10.label = 1;
                                    object2 = iParamsBackendService0.fetchParams(s, ((String)charSequence0), configModelStoreListener$fetchParams$10);
                                }
                                catch(BackendException backendException1) {
                                    configModelStoreListener$fetchParams$11 = configModelStoreListener$fetchParams$10;
                                    backendException0 = backendException1;
                                    v3 = v;
                                    v4 = 0;
                                    break;
                                }
                                if(object2 == object1) {
                                    return object1;
                                }
                                configModelStoreListener$fetchParams$11 = configModelStoreListener$fetchParams$10;
                                object0 = object2;
                                v3 = v;
                                v4 = 0;
                                try {
                                label_52:
                                    ParamsObject paramsObject0 = (ParamsObject)object0;
                                    ConfigModel configModel0 = new ConfigModel();
                                    configModel0.initializeFromModel(null, ConfigModelStoreListener.this._configModelStore.getModel());
                                    configModel0.setInitializedWithRemote(true);
                                    configModel0.setAppId(configModelStoreListener$fetchParams$11.$appId);
                                    configModel0.setNotificationChannels(paramsObject0.getNotificationChannels());
                                    configModel0.setGoogleProjectNumber(paramsObject0.getGoogleProjectNumber());
                                    configModel0.getFcmParams().setProjectId(paramsObject0.getFcmParams().getProjectId());
                                    configModel0.getFcmParams().setAppId(paramsObject0.getFcmParams().getAppId());
                                    configModel0.getFcmParams().setApiKey(paramsObject0.getFcmParams().getApiKey());
                                    Boolean boolean0 = paramsObject0.getEnterprise();
                                    if(boolean0 != null) {
                                        configModel0.setEnterprise(boolean0.booleanValue());
                                    }
                                    Boolean boolean1 = paramsObject0.getUseIdentityVerification();
                                    if(boolean1 != null) {
                                        configModel0.setUseIdentityVerification(boolean1.booleanValue());
                                    }
                                    Boolean boolean2 = paramsObject0.getFirebaseAnalytics();
                                    if(boolean2 != null) {
                                        configModel0.setFirebaseAnalytics(boolean2.booleanValue());
                                    }
                                    Boolean boolean3 = paramsObject0.getRestoreTTLFilter();
                                    if(boolean3 != null) {
                                        configModel0.setRestoreTTLFilter(boolean3.booleanValue());
                                    }
                                    Boolean boolean4 = paramsObject0.getClearGroupOnSummaryClick();
                                    if(boolean4 != null) {
                                        configModel0.setClearGroupOnSummaryClick(boolean4.booleanValue());
                                    }
                                    Boolean boolean5 = paramsObject0.getReceiveReceiptEnabled();
                                    if(boolean5 != null) {
                                        configModel0.setReceiveReceiptEnabled(boolean5.booleanValue());
                                    }
                                    Boolean boolean6 = paramsObject0.getDisableGMSMissingPrompt();
                                    if(boolean6 != null) {
                                        configModel0.setDisableGMSMissingPrompt(boolean6.booleanValue());
                                    }
                                    Boolean boolean7 = paramsObject0.getUnsubscribeWhenNotificationsDisabled();
                                    if(boolean7 != null) {
                                        configModel0.setUnsubscribeWhenNotificationsDisabled(boolean7.booleanValue());
                                    }
                                    Boolean boolean8 = paramsObject0.getLocationShared();
                                    if(boolean8 != null) {
                                        configModel0.setLocationShared(boolean8.booleanValue());
                                    }
                                    Boolean boolean9 = paramsObject0.getRequiresUserPrivacyConsent();
                                    if(boolean9 != null) {
                                        configModel0.setConsentRequired(Boxing.boxBoolean(boolean9.booleanValue()));
                                    }
                                    Long long0 = paramsObject0.getOpRepoExecutionInterval();
                                    if(long0 != null) {
                                        configModel0.setOpRepoExecutionInterval(long0.longValue());
                                    }
                                    Integer integer0 = paramsObject0.getInfluenceParams().getNotificationLimit();
                                    if(integer0 != null) {
                                        configModel0.getInfluenceParams().setNotificationLimit(integer0.intValue());
                                    }
                                    Integer integer1 = paramsObject0.getInfluenceParams().getIndirectNotificationAttributionWindow();
                                    if(integer1 != null) {
                                        configModel0.getInfluenceParams().setIndirectNotificationAttributionWindow(integer1.intValue());
                                    }
                                    Integer integer2 = paramsObject0.getInfluenceParams().getIamLimit();
                                    if(integer2 != null) {
                                        configModel0.getInfluenceParams().setIamLimit(integer2.intValue());
                                    }
                                    Integer integer3 = paramsObject0.getInfluenceParams().getIndirectIAMAttributionWindow();
                                    if(integer3 != null) {
                                        configModel0.getInfluenceParams().setIndirectIAMAttributionWindow(integer3.intValue());
                                    }
                                    Boolean boolean10 = paramsObject0.getInfluenceParams().isDirectEnabled();
                                    if(boolean10 != null) {
                                        configModel0.getInfluenceParams().setDirectEnabled(boolean10.booleanValue());
                                    }
                                    Boolean boolean11 = paramsObject0.getInfluenceParams().isIndirectEnabled();
                                    if(boolean11 != null) {
                                        configModel0.getInfluenceParams().setIndirectEnabled(boolean11.booleanValue());
                                    }
                                    Boolean boolean12 = paramsObject0.getInfluenceParams().isUnattributedEnabled();
                                    if(boolean12 != null) {
                                        configModel0.getInfluenceParams().setUnattributedEnabled(boolean12.booleanValue());
                                    }
                                    ConfigModelStoreListener.this._configModelStore.replace(configModel0, "HYDRATE");
                                    configModelStoreListener$fetchParams$10 = configModelStoreListener$fetchParams$11;
                                }
                                catch(BackendException backendException0) {
                                    break;
                                }
                            }
                        label_121:
                            if(backendException0.getStatusCode() == 403) {
                                Logging.fatal$default("403 error getting OneSignal params, omitting further retries!", null, 2, null);
                                return Unit.INSTANCE;
                            }
                            int v8 = v3 * 10000 + 30000 <= 90000 ? v3 * 10000 + 30000 : 90000;
                            Logging.info$default(("Failed to get Android parameters, trying again in " + v8 / 1000 + " seconds."), null, 2, null);
                            configModelStoreListener$fetchParams$11.I$0 = v3;
                            configModelStoreListener$fetchParams$11.I$1 = v4;
                            configModelStoreListener$fetchParams$11.label = 2;
                        }
                        while(DelayKt.delay(v8, configModelStoreListener$fetchParams$11) != object1);
                        return object1;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 1, null);
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelReplaced(Model model0, String s) {
        this.onModelReplaced(((ConfigModel)model0), s);
    }

    public void onModelReplaced(ConfigModel configModel0, String s) {
        Intrinsics.checkNotNullParameter(configModel0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(!Intrinsics.areEqual(s, "NORMAL")) {
            return;
        }
        this.fetchParams();
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs modelChangedArgs0, String s) {
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(!Intrinsics.areEqual(modelChangedArgs0.getProperty(), "appId")) {
            return;
        }
        this.fetchParams();
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._configModelStore.subscribe(this);
        this.fetchParams();
    }
}

