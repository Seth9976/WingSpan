package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils.ResponseStatusType;
import com.onesignal.common.NetworkUtils;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.LoginUserFromSubscriptionOperation;
import com.onesignal.user.internal.operations.RefreshUserOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u001F\u0010\u000E\u001A\u00020\u000F2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00100\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0019\u0010\u0012\u001A\u00020\u000F2\u0006\u0010\u0013\u001A\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/LoginUserFromSubscriptionOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_subscriptionBackend", "Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "(Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "execute", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "Lcom/onesignal/core/internal/operations/Operation;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUser", "loginUserOp", "Lcom/onesignal/user/internal/operations/LoginUserFromSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/LoginUserFromSubscriptionOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LoginUserFromSubscriptionOperationExecutor implements IOperationExecutor {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/LoginUserFromSubscriptionOperationExecutor$Companion;", "", "()V", "LOGIN_USER_FROM_SUBSCRIPTION_USER", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[ResponseStatusType.values().length];
            arr_v[ResponseStatusType.RETRYABLE.ordinal()] = 1;
            arr_v[ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final Companion Companion = null;
    public static final String LOGIN_USER_FROM_SUBSCRIPTION_USER = "login-user-from-subscription";
    private final IdentityModelStore _identityModelStore;
    private final PropertiesModelStore _propertiesModelStore;
    private final ISubscriptionBackendService _subscriptionBackend;

    static {
        LoginUserFromSubscriptionOperationExecutor.Companion = new Companion(null);
    }

    public LoginUserFromSubscriptionOperationExecutor(ISubscriptionBackendService iSubscriptionBackendService0, IdentityModelStore identityModelStore0, PropertiesModelStore propertiesModelStore0) {
        Intrinsics.checkNotNullParameter(iSubscriptionBackendService0, "_subscriptionBackend");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore0, "_propertiesModelStore");
        super();
        this._subscriptionBackend = iSubscriptionBackendService0;
        this._identityModelStore = identityModelStore0;
        this._propertiesModelStore = propertiesModelStore0;
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List list0, Continuation continuation0) {
        Logging.debug$default(("LoginUserFromSubscriptionOperationExecutor(operation: " + list0 + ')'), null, 2, null);
        if(list0.size() > 1) {
            throw new Exception("Only supports one operation! Attempted operations:\n" + list0);
        }
        Operation operation0 = (Operation)CollectionsKt.first(list0);
        if(!(operation0 instanceof LoginUserFromSubscriptionOperation)) {
            throw new Exception("Unrecognized operation: " + operation0);
        }
        return this.loginUser(((LoginUserFromSubscriptionOperation)operation0), continuation0);
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public List getOperations() {
        return CollectionsKt.listOf("login-user-from-subscription");
    }

    private final Object loginUser(LoginUserFromSubscriptionOperation loginUserFromSubscriptionOperation0, Continuation continuation0) {
        LoginUserFromSubscriptionOperationExecutor loginUserFromSubscriptionOperationExecutor0;
        com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor.loginUser.1 loginUserFromSubscriptionOperationExecutor$loginUser$10;
        if(continuation0 instanceof com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor.loginUser.1) {
            loginUserFromSubscriptionOperationExecutor$loginUser$10 = (com.onesignal.user.internal.operations.impl.executors.LoginUserFromSubscriptionOperationExecutor.loginUser.1)continuation0;
            if((loginUserFromSubscriptionOperationExecutor$loginUser$10.label & 0x80000000) == 0) {
                loginUserFromSubscriptionOperationExecutor$loginUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.loginUser(null, this);
                    }
                };
            }
            else {
                loginUserFromSubscriptionOperationExecutor$loginUser$10.label ^= 0x80000000;
            }
        }
        else {
            loginUserFromSubscriptionOperationExecutor$loginUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.loginUser(null, this);
                }
            };
        }
        Object object0 = loginUserFromSubscriptionOperationExecutor$loginUser$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(loginUserFromSubscriptionOperationExecutor$loginUser$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    String s = loginUserFromSubscriptionOperation0.getAppId();
                    String s1 = loginUserFromSubscriptionOperation0.getSubscriptionId();
                    loginUserFromSubscriptionOperationExecutor$loginUser$10.L$0 = this;
                    loginUserFromSubscriptionOperationExecutor$loginUser$10.L$1 = loginUserFromSubscriptionOperation0;
                    loginUserFromSubscriptionOperationExecutor$loginUser$10.label = 1;
                    object0 = this._subscriptionBackend.getIdentityFromSubscription(s, s1, loginUserFromSubscriptionOperationExecutor$loginUser$10);
                    if(object0 == object1) {
                        return object1;
                    }
                    loginUserFromSubscriptionOperationExecutor0 = this;
                    goto label_26;
                }
                catch(BackendException backendException0) {
                    break;
                }
            }
            case 1: {
                loginUserFromSubscriptionOperation0 = (LoginUserFromSubscriptionOperation)loginUserFromSubscriptionOperationExecutor$loginUser$10.L$1;
                loginUserFromSubscriptionOperationExecutor0 = (LoginUserFromSubscriptionOperationExecutor)loginUserFromSubscriptionOperationExecutor$loginUser$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_26:
                    String s2 = (String)((Map)object0).getOrDefault("onesignal_id", null);
                    if(s2 == null) {
                        Logging.warn$default(("Subscription " + loginUserFromSubscriptionOperation0.getSubscriptionId() + " has no onesignal_id!"), null, 2, null);
                        return new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null);
                    }
                    Map map0 = new LinkedHashMap();
                    map0.put(loginUserFromSubscriptionOperation0.getOnesignalId(), s2);
                    IdentityModel identityModel0 = (IdentityModel)loginUserFromSubscriptionOperationExecutor0._identityModelStore.getModel();
                    PropertiesModel propertiesModel0 = (PropertiesModel)loginUserFromSubscriptionOperationExecutor0._propertiesModelStore.getModel();
                    if(Intrinsics.areEqual(identityModel0.getOnesignalId(), loginUserFromSubscriptionOperation0.getOnesignalId())) {
                        Model.setStringProperty$default(identityModel0, "onesignal_id", s2, "HYDRATE", false, 8, null);
                    }
                    if(Intrinsics.areEqual(propertiesModel0.getOnesignalId(), loginUserFromSubscriptionOperation0.getOnesignalId())) {
                        Model.setStringProperty$default(propertiesModel0, "onesignalId", s2, "HYDRATE", false, 8, null);
                    }
                    List list0 = CollectionsKt.listOf(new RefreshUserOperation(loginUserFromSubscriptionOperation0.getAppId(), s2));
                    return new ExecutionResponse(ExecutionResult.SUCCESS, map0, list0);
                }
                catch(BackendException backendException0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        switch(WhenMappings.$EnumSwitchMapping$0[NetworkUtils.INSTANCE.getResponseStatusType(backendException0.getStatusCode()).ordinal()]) {
            case 1: {
                return new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, null, 6, null);
            }
            case 2: {
                return new ExecutionResponse(ExecutionResult.FAIL_UNAUTHORIZED, null, null, 6, null);
            }
            default: {
                return new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null);
            }
        }
    }
}

