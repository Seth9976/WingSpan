package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils.ResponseStatusType;
import com.onesignal.common.NetworkUtils;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.CreateUserResponse;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001C2\u00020\u0001:\u0001\u001CB5\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r¢\u0006\u0002\u0010\u000EJ\u001F\u0010\u0014\u001A\u00020\u00152\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00160\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u001AH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001BR\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001D"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/RefreshUserOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_userBackend", "Lcom/onesignal/user/internal/backend/IUserBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_subscriptionsModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_buildUserService", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "(Lcom/onesignal/user/internal/backend/IUserBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/builduser/IRebuildUserService;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "execute", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "Lcom/onesignal/core/internal/operations/Operation;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "op", "Lcom/onesignal/user/internal/operations/RefreshUserOperation;", "(Lcom/onesignal/user/internal/operations/RefreshUserOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class RefreshUserOperationExecutor implements IOperationExecutor {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/RefreshUserOperationExecutor$Companion;", "", "()V", "REFRESH_USER", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;
        public static final int[] $EnumSwitchMapping$1;

        static {
            int[] arr_v = new int[SubscriptionObjectType.values().length];
            arr_v[SubscriptionObjectType.EMAIL.ordinal()] = 1;
            arr_v[SubscriptionObjectType.SMS.ordinal()] = 2;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[ResponseStatusType.values().length];
            arr_v1[ResponseStatusType.RETRYABLE.ordinal()] = 1;
            arr_v1[ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            arr_v1[ResponseStatusType.MISSING.ordinal()] = 3;
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
        }
    }

    public static final Companion Companion = null;
    public static final String REFRESH_USER = "refresh-user";
    private final IRebuildUserService _buildUserService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final PropertiesModelStore _propertiesModelStore;
    private final SubscriptionModelStore _subscriptionsModelStore;
    private final IUserBackendService _userBackend;

    static {
        RefreshUserOperationExecutor.Companion = new Companion(null);
    }

    public RefreshUserOperationExecutor(IUserBackendService iUserBackendService0, IdentityModelStore identityModelStore0, PropertiesModelStore propertiesModelStore0, SubscriptionModelStore subscriptionModelStore0, ConfigModelStore configModelStore0, IRebuildUserService iRebuildUserService0) {
        Intrinsics.checkNotNullParameter(iUserBackendService0, "_userBackend");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore0, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(subscriptionModelStore0, "_subscriptionsModelStore");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iRebuildUserService0, "_buildUserService");
        super();
        this._userBackend = iUserBackendService0;
        this._identityModelStore = identityModelStore0;
        this._propertiesModelStore = propertiesModelStore0;
        this._subscriptionsModelStore = subscriptionModelStore0;
        this._configModelStore = configModelStore0;
        this._buildUserService = iRebuildUserService0;
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List list0, Continuation continuation0) {
        Logging.log(LogLevel.DEBUG, "RefreshUserOperationExecutor(operation: " + list0 + ')');
        boolean z = false;
        if(!(list0 instanceof Collection) || !list0.isEmpty()) {
            for(Object object0: list0) {
                if(!(((Operation)object0) instanceof RefreshUserOperation) != 0) {
                    z = true;
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        if(z) {
            throw new Exception("Unrecognized operation(s)! Attempted operations:\n" + list0);
        }
        Operation operation0 = (Operation)CollectionsKt.first(list0);
        if(!(operation0 instanceof RefreshUserOperation)) {
            throw new Exception("Unrecognized operation: " + operation0);
        }
        return this.getUser(((RefreshUserOperation)operation0), continuation0);
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public List getOperations() {
        return CollectionsKt.listOf("refresh-user");
    }

    private final Object getUser(RefreshUserOperation refreshUserOperation0, Continuation continuation0) {
        SubscriptionType subscriptionType0;
        RefreshUserOperationExecutor refreshUserOperationExecutor0;
        com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor.getUser.1 refreshUserOperationExecutor$getUser$10;
        if(continuation0 instanceof com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor.getUser.1) {
            refreshUserOperationExecutor$getUser$10 = (com.onesignal.user.internal.operations.impl.executors.RefreshUserOperationExecutor.getUser.1)continuation0;
            if((refreshUserOperationExecutor$getUser$10.label & 0x80000000) == 0) {
                refreshUserOperationExecutor$getUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getUser(null, this);
                    }
                };
            }
            else {
                refreshUserOperationExecutor$getUser$10.label ^= 0x80000000;
            }
        }
        else {
            refreshUserOperationExecutor$getUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getUser(null, this);
                }
            };
        }
        Object object0 = refreshUserOperationExecutor$getUser$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(refreshUserOperationExecutor$getUser$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    String s = refreshUserOperation0.getAppId();
                    String s1 = refreshUserOperation0.getOnesignalId();
                    refreshUserOperationExecutor$getUser$10.L$0 = this;
                    refreshUserOperationExecutor$getUser$10.L$1 = refreshUserOperation0;
                    refreshUserOperationExecutor$getUser$10.label = 1;
                    object0 = this._userBackend.getUser(s, "onesignal_id", s1, refreshUserOperationExecutor$getUser$10);
                }
                catch(BackendException backendException0) {
                    refreshUserOperationExecutor0 = this;
                    break;
                }
                if(object0 == object1) {
                    return object1;
                }
                refreshUserOperationExecutor0 = this;
                goto label_30;
            }
            case 1: {
                refreshUserOperation0 = (RefreshUserOperation)refreshUserOperationExecutor$getUser$10.L$1;
                refreshUserOperationExecutor0 = (RefreshUserOperationExecutor)refreshUserOperationExecutor$getUser$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_30:
                    if(!Intrinsics.areEqual(refreshUserOperation0.getOnesignalId(), ((IdentityModel)refreshUserOperationExecutor0._identityModelStore.getModel()).getOnesignalId())) {
                        return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
                    }
                    IdentityModel identityModel0 = new IdentityModel();
                    for(Object object2: ((CreateUserResponse)object0).getIdentities().entrySet()) {
                        identityModel0.put(((Map.Entry)object2).getKey(), ((Map.Entry)object2).getValue());
                    }
                    PropertiesModel propertiesModel0 = new PropertiesModel();
                    propertiesModel0.setOnesignalId(refreshUserOperation0.getOnesignalId());
                    if(((CreateUserResponse)object0).getProperties().getCountry() != null) {
                        propertiesModel0.setCountry(((CreateUserResponse)object0).getProperties().getCountry());
                    }
                    if(((CreateUserResponse)object0).getProperties().getLanguage() != null) {
                        propertiesModel0.setLanguage(((CreateUserResponse)object0).getProperties().getLanguage());
                    }
                    if(((CreateUserResponse)object0).getProperties().getTags() != null) {
                        for(Object object3: ((CreateUserResponse)object0).getProperties().getTags().entrySet()) {
                            Map.Entry map$Entry0 = (Map.Entry)object3;
                            if(map$Entry0.getValue() != null) {
                                Map map0 = propertiesModel0.getTags();
                                Object object4 = map$Entry0.getKey();
                                Object object5 = map$Entry0.getValue();
                                Intrinsics.checkNotNull(object5);
                                map0.put(object4, object5);
                            }
                        }
                    }
                    if(((CreateUserResponse)object0).getProperties().getTimezoneId() != null) {
                        propertiesModel0.setTimezone(((CreateUserResponse)object0).getProperties().getTimezoneId());
                    }
                    List list0 = new ArrayList();
                    Iterator iterator2 = ((CreateUserResponse)object0).getSubscriptions().iterator();
                    while(true) {
                        if(!iterator2.hasNext()) {
                            refreshUserOperationExecutor0._identityModelStore.replace(identityModel0, "HYDRATE");
                            refreshUserOperationExecutor0._propertiesModelStore.replace(propertiesModel0, "HYDRATE");
                            refreshUserOperationExecutor0._subscriptionsModelStore.replaceAll(list0, "HYDRATE");
                            return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
                        }
                        String s2 = "";
                        Object object6 = iterator2.next();
                        SubscriptionModel subscriptionModel0 = new SubscriptionModel();
                        String s3 = ((SubscriptionObject)object6).getId();
                        Intrinsics.checkNotNull(s3);
                        subscriptionModel0.setId(s3);
                        String s4 = ((SubscriptionObject)object6).getToken();
                        if(s4 == null) {
                            s4 = "";
                        }
                        subscriptionModel0.setAddress(s4);
                        Integer integer0 = ((SubscriptionObject)object6).getNotificationTypes();
                        SubscriptionStatus subscriptionStatus0 = SubscriptionStatus.Companion.fromInt((integer0 == null ? SubscriptionStatus.SUBSCRIBED.getValue() : ((int)integer0)));
                        if(subscriptionStatus0 == null) {
                            subscriptionStatus0 = SubscriptionStatus.SUBSCRIBED;
                        }
                        subscriptionModel0.setStatus(subscriptionStatus0);
                        SubscriptionObjectType subscriptionObjectType0 = ((SubscriptionObject)object6).getType();
                        Intrinsics.checkNotNull(subscriptionObjectType0);
                        switch(WhenMappings.$EnumSwitchMapping$0[subscriptionObjectType0.ordinal()]) {
                            case 1: {
                                subscriptionType0 = SubscriptionType.EMAIL;
                                goto label_88;
                            }
                            case 2: {
                                goto label_87;
                            }
                        }
                        subscriptionType0 = SubscriptionType.PUSH;
                        goto label_88;
                    label_87:
                        subscriptionType0 = SubscriptionType.SMS;
                    label_88:
                        subscriptionModel0.setType(subscriptionType0);
                        subscriptionModel0.setOptedIn(subscriptionModel0.getStatus() != SubscriptionStatus.UNSUBSCRIBE && subscriptionModel0.getStatus() != SubscriptionStatus.DISABLED_FROM_REST_API_DEFAULT_REASON);
                        String s5 = ((SubscriptionObject)object6).getSdk();
                        if(s5 == null) {
                            s5 = "";
                        }
                        subscriptionModel0.setSdk(s5);
                        String s6 = ((SubscriptionObject)object6).getDeviceOS();
                        if(s6 == null) {
                            s6 = "";
                        }
                        subscriptionModel0.setDeviceOS(s6);
                        String s7 = ((SubscriptionObject)object6).getCarrier();
                        if(s7 == null) {
                            s7 = "";
                        }
                        subscriptionModel0.setCarrier(s7);
                        String s8 = ((SubscriptionObject)object6).getAppVersion();
                        if(s8 != null) {
                            s2 = s8;
                        }
                        subscriptionModel0.setAppVersion(s2);
                        if(subscriptionModel0.getType() != SubscriptionType.PUSH || Intrinsics.areEqual(subscriptionModel0.getId(), ((ConfigModel)refreshUserOperationExecutor0._configModelStore.getModel()).getPushSubscriptionId())) {
                            list0.add(subscriptionModel0);
                        }
                    }
                }
                catch(BackendException backendException0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        int v = WhenMappings.$EnumSwitchMapping$1[NetworkUtils.INSTANCE.getResponseStatusType(backendException0.getStatusCode()).ordinal()];
        switch(v) {
            case 1: {
                return new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, null, 6, null);
            }
            case 2: {
                return new ExecutionResponse(ExecutionResult.FAIL_UNAUTHORIZED, null, null, 6, null);
            }
            default: {
                if(v != 3) {
                    return new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null);
                }
                String s9 = refreshUserOperation0.getAppId();
                String s10 = refreshUserOperation0.getOnesignalId();
                List list1 = refreshUserOperationExecutor0._buildUserService.getRebuildOperationsIfCurrentUser(s9, s10);
                return list1 == null ? new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null) : new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, list1, 2, null);
            }
        }
    }
}

