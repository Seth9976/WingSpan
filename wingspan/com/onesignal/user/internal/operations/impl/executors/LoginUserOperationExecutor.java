package com.onesignal.user.internal.operations.impl.executors;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.DeviceUtils;
import com.onesignal.common.NetworkUtils.ResponseStatusType;
import com.onesignal.common.NetworkUtils;
import com.onesignal.common.RootToolsInternalMethods;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService.DeviceType;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.core.internal.language.ILanguageContext;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.CreateUserResponse;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.LoginUserOperation;
import com.onesignal.user.internal.operations.SetAliasOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-BM\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u0012\u0006\u0010\u000E\u001A\u00020\u000F\u0012\u0006\u0010\u0010\u001A\u00020\u0011\u0012\u0006\u0010\u0012\u001A\u00020\u0013\u00A2\u0006\u0002\u0010\u0014J0\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001C0\u001B2\u0006\u0010\u001D\u001A\u00020\u001E2\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001C0\u001BH\u0002J0\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001C0\u001B2\u0006\u0010\u001D\u001A\u00020 2\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001C0\u001BH\u0002J0\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001C0\u001B2\u0006\u0010\u001D\u001A\u00020!2\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001C0\u001BH\u0002J0\u0010\u001A\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001C0\u001B2\u0006\u0010\u001D\u001A\u00020\"2\u0012\u0010\u001F\u001A\u000E\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001C0\u001BH\u0002J\'\u0010#\u001A\u00020$2\u0006\u0010%\u001A\u00020&2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\'0\u0016H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010(J\u001F\u0010)\u001A\u00020$2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\'0\u0016H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010*J\'\u0010+\u001A\u00020$2\u0006\u0010,\u001A\u00020&2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\'0\u0016H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010(R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u000FX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u001A\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00170\u00168VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006."}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/LoginUserOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_identityOperationExecutor", "Lcom/onesignal/user/internal/operations/impl/executors/IdentityOperationExecutor;", "_application", "Lcom/onesignal/core/internal/application/IApplicationService;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_userBackend", "Lcom/onesignal/user/internal/backend/IUserBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_subscriptionsModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_languageContext", "Lcom/onesignal/core/internal/language/ILanguageContext;", "(Lcom/onesignal/user/internal/operations/impl/executors/IdentityOperationExecutor;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/user/internal/backend/IUserBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/language/ILanguageContext;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "createSubscriptionsFromOperation", "", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "operation", "Lcom/onesignal/user/internal/operations/CreateSubscriptionOperation;", "subscriptions", "Lcom/onesignal/user/internal/operations/DeleteSubscriptionOperation;", "Lcom/onesignal/user/internal/operations/TransferSubscriptionOperation;", "Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;", "createUser", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "createUserOperation", "Lcom/onesignal/user/internal/operations/LoginUserOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "(Lcom/onesignal/user/internal/operations/LoginUserOperation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUser", "loginUserOp", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LoginUserOperationExecutor implements IOperationExecutor {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/LoginUserOperationExecutor$Companion;", "", "()V", "LOGIN_USER", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
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
        public static final int[] $EnumSwitchMapping$2;

        static {
            int[] arr_v = new int[ExecutionResult.values().length];
            arr_v[ExecutionResult.SUCCESS.ordinal()] = 1;
            arr_v[ExecutionResult.FAIL_CONFLICT.ordinal()] = 2;
            arr_v[ExecutionResult.FAIL_NORETRY.ordinal()] = 3;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[ResponseStatusType.values().length];
            arr_v1[ResponseStatusType.RETRYABLE.ordinal()] = 1;
            arr_v1[ResponseStatusType.UNAUTHORIZED.ordinal()] = 2;
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
            int[] arr_v2 = new int[SubscriptionType.values().length];
            arr_v2[SubscriptionType.SMS.ordinal()] = 1;
            arr_v2[SubscriptionType.EMAIL.ordinal()] = 2;
            WhenMappings.$EnumSwitchMapping$2 = arr_v2;
        }
    }

    public static final Companion Companion = null;
    public static final String LOGIN_USER = "login-user";
    private final IApplicationService _application;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final IdentityModelStore _identityModelStore;
    private final IdentityOperationExecutor _identityOperationExecutor;
    private final ILanguageContext _languageContext;
    private final PropertiesModelStore _propertiesModelStore;
    private final SubscriptionModelStore _subscriptionsModelStore;
    private final IUserBackendService _userBackend;

    static {
        LoginUserOperationExecutor.Companion = new Companion(null);
    }

    public LoginUserOperationExecutor(IdentityOperationExecutor identityOperationExecutor0, IApplicationService iApplicationService0, IDeviceService iDeviceService0, IUserBackendService iUserBackendService0, IdentityModelStore identityModelStore0, PropertiesModelStore propertiesModelStore0, SubscriptionModelStore subscriptionModelStore0, ConfigModelStore configModelStore0, ILanguageContext iLanguageContext0) {
        Intrinsics.checkNotNullParameter(identityOperationExecutor0, "_identityOperationExecutor");
        Intrinsics.checkNotNullParameter(iApplicationService0, "_application");
        Intrinsics.checkNotNullParameter(iDeviceService0, "_deviceService");
        Intrinsics.checkNotNullParameter(iUserBackendService0, "_userBackend");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore0, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(subscriptionModelStore0, "_subscriptionsModelStore");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iLanguageContext0, "_languageContext");
        super();
        this._identityOperationExecutor = identityOperationExecutor0;
        this._application = iApplicationService0;
        this._deviceService = iDeviceService0;
        this._userBackend = iUserBackendService0;
        this._identityModelStore = identityModelStore0;
        this._propertiesModelStore = propertiesModelStore0;
        this._subscriptionsModelStore = subscriptionModelStore0;
        this._configModelStore = configModelStore0;
        this._languageContext = iLanguageContext0;
    }

    private final Map createSubscriptionsFromOperation(CreateSubscriptionOperation createSubscriptionOperation0, Map map0) {
        SubscriptionObjectType subscriptionObjectType0;
        Map map1 = MapsKt.toMutableMap(map0);
        switch(WhenMappings.$EnumSwitchMapping$2[createSubscriptionOperation0.getType().ordinal()]) {
            case 1: {
                subscriptionObjectType0 = SubscriptionObjectType.SMS;
                break;
            }
            case 2: {
                subscriptionObjectType0 = SubscriptionObjectType.EMAIL;
                break;
            }
            default: {
                DeviceType iDeviceService$DeviceType0 = this._deviceService.getDeviceType();
                subscriptionObjectType0 = SubscriptionObjectType.Companion.fromDeviceType(iDeviceService$DeviceType0);
            }
        }
        String s = createSubscriptionOperation0.getSubscriptionId();
        String s1 = createSubscriptionOperation0.getAddress();
        Boolean boolean0 = Boolean.valueOf(createSubscriptionOperation0.getEnabled());
        Integer integer0 = createSubscriptionOperation0.getStatus().getValue();
        String s2 = Build.MODEL;
        String s3 = Build.VERSION.RELEASE;
        Boolean boolean1 = Boolean.valueOf(RootToolsInternalMethods.INSTANCE.isRooted());
        Context context0 = this._application.getAppContext();
        Integer integer1 = DeviceUtils.INSTANCE.getNetType(context0);
        Context context1 = this._application.getAppContext();
        String s4 = DeviceUtils.INSTANCE.getCarrierName(context1);
        Context context2 = this._application.getAppContext();
        map1.put(s, new SubscriptionObject(null, subscriptionObjectType0, s1, boolean0, integer0, "050109", s2, s3, boolean1, integer1, s4, AndroidUtils.INSTANCE.getAppVersion(context2)));
        return map1;
    }

    private final Map createSubscriptionsFromOperation(DeleteSubscriptionOperation deleteSubscriptionOperation0, Map map0) {
        Map map1 = MapsKt.toMutableMap(map0);
        map1.remove(deleteSubscriptionOperation0.getSubscriptionId());
        return map1;
    }

    private final Map createSubscriptionsFromOperation(TransferSubscriptionOperation transferSubscriptionOperation0, Map map0) {
        Map map1 = MapsKt.toMutableMap(map0);
        if(map1.containsKey(transferSubscriptionOperation0.getSubscriptionId())) {
            String s = transferSubscriptionOperation0.getSubscriptionId();
            String s1 = transferSubscriptionOperation0.getSubscriptionId();
            Object object0 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object0);
            Object object1 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object1);
            Object object2 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object2);
            Object object3 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object3);
            Object object4 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object4);
            Object object5 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object5);
            Object object6 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object6);
            Object object7 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object7);
            Object object8 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object8);
            Object object9 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object9);
            Object object10 = map0.get(transferSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object10);
            map1.put(s, new SubscriptionObject(s1, ((SubscriptionObject)object0).getType(), ((SubscriptionObject)object1).getToken(), ((SubscriptionObject)object2).getEnabled(), ((SubscriptionObject)object3).getNotificationTypes(), ((SubscriptionObject)object4).getSdk(), ((SubscriptionObject)object5).getDeviceModel(), ((SubscriptionObject)object6).getDeviceOS(), ((SubscriptionObject)object7).getRooted(), ((SubscriptionObject)object8).getNetType(), ((SubscriptionObject)object9).getCarrier(), ((SubscriptionObject)object10).getAppVersion()));
            return map1;
        }
        map1.put(transferSubscriptionOperation0.getSubscriptionId(), new SubscriptionObject(transferSubscriptionOperation0.getSubscriptionId(), null, null, null, null, null, null, null, null, null, null, null, 0xFFE, null));
        return map1;
    }

    private final Map createSubscriptionsFromOperation(UpdateSubscriptionOperation updateSubscriptionOperation0, Map map0) {
        Map map1 = MapsKt.toMutableMap(map0);
        if(map1.containsKey(updateSubscriptionOperation0.getSubscriptionId())) {
            String s = updateSubscriptionOperation0.getSubscriptionId();
            Object object0 = map0.get(updateSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object0);
            Object object1 = map0.get(updateSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object1);
            String s1 = updateSubscriptionOperation0.getAddress();
            Boolean boolean0 = Boolean.valueOf(updateSubscriptionOperation0.getEnabled());
            Integer integer0 = updateSubscriptionOperation0.getStatus().getValue();
            Object object2 = map0.get(updateSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object2);
            Object object3 = map0.get(updateSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object3);
            Object object4 = map0.get(updateSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object4);
            Object object5 = map0.get(updateSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object5);
            Object object6 = map0.get(updateSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object6);
            Object object7 = map0.get(updateSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object7);
            Object object8 = map0.get(updateSubscriptionOperation0.getSubscriptionId());
            Intrinsics.checkNotNull(object8);
            map1.put(s, new SubscriptionObject(((SubscriptionObject)object0).getId(), ((SubscriptionObject)object1).getType(), s1, boolean0, integer0, ((SubscriptionObject)object2).getSdk(), ((SubscriptionObject)object3).getDeviceModel(), ((SubscriptionObject)object4).getDeviceOS(), ((SubscriptionObject)object5).getRooted(), ((SubscriptionObject)object6).getNetType(), ((SubscriptionObject)object7).getCarrier(), ((SubscriptionObject)object8).getAppVersion()));
        }
        return map1;
    }

    private final Object createUser(LoginUserOperation loginUserOperation0, List list0, Continuation continuation0) {
        LoginUserOperation loginUserOperation1;
        LoginUserOperationExecutor loginUserOperationExecutor0;
        List list2;
        com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.createUser.1 loginUserOperationExecutor$createUser$10;
        if(continuation0 instanceof com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.createUser.1) {
            loginUserOperationExecutor$createUser$10 = (com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.createUser.1)continuation0;
            if((loginUserOperationExecutor$createUser$10.label & 0x80000000) == 0) {
                loginUserOperationExecutor$createUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.createUser(null, null, this);
                    }
                };
            }
            else {
                loginUserOperationExecutor$createUser$10.label ^= 0x80000000;
            }
        }
        else {
            loginUserOperationExecutor$createUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.createUser(null, null, this);
                }
            };
        }
        Object object0 = loginUserOperationExecutor$createUser$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(loginUserOperationExecutor$createUser$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Map map0 = MapsKt.emptyMap();
                Map map1 = MapsKt.emptyMap();
                Map map2 = new LinkedHashMap();
                Intrinsics.checkNotNull("Asia/Shanghai");
                map2.put("timezone_id", "Asia/Shanghai");
                map2.put("language", this._languageContext.getLanguage());
                if(loginUserOperation0.getExternalId() != null) {
                    map0 = MapsKt.toMutableMap(map0);
                    String s = loginUserOperation0.getExternalId();
                    Intrinsics.checkNotNull(s);
                    map0.put("external_id", s);
                }
                for(Object object2: list0) {
                    Operation operation0 = (Operation)object2;
                    if(operation0 instanceof CreateSubscriptionOperation) {
                        map1 = this.createSubscriptionsFromOperation(((CreateSubscriptionOperation)operation0), map1);
                    }
                    else if(operation0 instanceof TransferSubscriptionOperation) {
                        map1 = this.createSubscriptionsFromOperation(((TransferSubscriptionOperation)operation0), map1);
                    }
                    else if(operation0 instanceof UpdateSubscriptionOperation) {
                        map1 = this.createSubscriptionsFromOperation(((UpdateSubscriptionOperation)operation0), map1);
                    }
                    else {
                        if(!(operation0 instanceof DeleteSubscriptionOperation)) {
                            throw new Exception("Unrecognized operation: " + operation0);
                        }
                        map1 = this.createSubscriptionsFromOperation(((DeleteSubscriptionOperation)operation0), map1);
                    }
                }
                try {
                    List list1 = MapsKt.toList(map1);
                    IUserBackendService iUserBackendService0 = this._userBackend;
                    String s1 = loginUserOperation0.getAppId();
                    ArrayList arrayList0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list1, 10));
                    for(Object object3: list1) {
                        arrayList0.add(((SubscriptionObject)((Pair)object3).getSecond()));
                    }
                    loginUserOperationExecutor$createUser$10.L$0 = this;
                    loginUserOperationExecutor$createUser$10.L$1 = loginUserOperation0;
                    loginUserOperationExecutor$createUser$10.L$2 = list1;
                    loginUserOperationExecutor$createUser$10.label = 1;
                    Object object4 = iUserBackendService0.createUser(s1, map0, arrayList0, map2, loginUserOperationExecutor$createUser$10);
                    if(object4 == object1) {
                        return object1;
                    }
                    list2 = list1;
                    loginUserOperationExecutor0 = this;
                    object0 = object4;
                    loginUserOperation1 = loginUserOperation0;
                    goto label_66;
                }
                catch(BackendException backendException0) {
                    break;
                }
            }
            case 1: {
                list2 = (List)loginUserOperationExecutor$createUser$10.L$2;
                loginUserOperation1 = (LoginUserOperation)loginUserOperationExecutor$createUser$10.L$1;
                loginUserOperationExecutor0 = (LoginUserOperationExecutor)loginUserOperationExecutor$createUser$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_66:
                    LinkedHashMap linkedHashMap0 = new LinkedHashMap();
                    Object object5 = ((CreateUserResponse)object0).getIdentities().get("onesignal_id");
                    Intrinsics.checkNotNull(object5);
                    linkedHashMap0.put(loginUserOperation1.getOnesignalId(), ((String)object5));
                    IdentityModel identityModel0 = (IdentityModel)loginUserOperationExecutor0._identityModelStore.getModel();
                    PropertiesModel propertiesModel0 = (PropertiesModel)loginUserOperationExecutor0._propertiesModelStore.getModel();
                    if(Intrinsics.areEqual(identityModel0.getOnesignalId(), loginUserOperation1.getOnesignalId())) {
                        Model.setStringProperty$default(identityModel0, "onesignal_id", ((String)object5), "HYDRATE", false, 8, null);
                    }
                    if(Intrinsics.areEqual(propertiesModel0.getOnesignalId(), loginUserOperation1.getOnesignalId())) {
                        Model.setStringProperty$default(propertiesModel0, "onesignalId", ((String)object5), "HYDRATE", false, 8, null);
                    }
                    int v = list2.size();
                    for(int v1 = 0; v1 < v && v1 < ((CreateUserResponse)object0).getSubscriptions().size(); ++v1) {
                        SubscriptionObject subscriptionObject0 = (SubscriptionObject)((CreateUserResponse)object0).getSubscriptions().get(v1);
                        Object object6 = ((Pair)list2.get(v1)).getFirst();
                        String s2 = subscriptionObject0.getId();
                        Intrinsics.checkNotNull(s2);
                        linkedHashMap0.put(object6, s2);
                        if(Intrinsics.areEqual(((ConfigModel)loginUserOperationExecutor0._configModelStore.getModel()).getPushSubscriptionId(), ((Pair)list2.get(v1)).getFirst())) {
                            ((ConfigModel)loginUserOperationExecutor0._configModelStore.getModel()).setPushSubscriptionId(subscriptionObject0.getId());
                        }
                        String s3 = (String)((Pair)list2.get(v1)).getFirst();
                        SubscriptionModel subscriptionModel0 = (SubscriptionModel)loginUserOperationExecutor0._subscriptionsModelStore.get(s3);
                        if(subscriptionModel0 != null) {
                            Model.setStringProperty$default(subscriptionModel0, "id", subscriptionObject0.getId(), "HYDRATE", false, 8, null);
                        }
                    }
                    return new ExecutionResponse(ExecutionResult.SUCCESS, linkedHashMap0, null, 4, null);
                }
                catch(BackendException backendException0) {
                    break;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        switch(WhenMappings.$EnumSwitchMapping$1[NetworkUtils.INSTANCE.getResponseStatusType(backendException0.getStatusCode()).ordinal()]) {
            case 1: {
                return new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, null, 6, null);
            }
            case 2: {
                return new ExecutionResponse(ExecutionResult.FAIL_UNAUTHORIZED, null, null, 6, null);
            }
            default: {
                return new ExecutionResponse(ExecutionResult.FAIL_PAUSE_OPREPO, null, null, 6, null);
            }
        }
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List list0, Continuation continuation0) {
        Logging.debug$default(("LoginUserOperationExecutor(operation: " + list0 + ')'), null, 2, null);
        Operation operation0 = (Operation)CollectionsKt.first(list0);
        if(!(operation0 instanceof LoginUserOperation)) {
            throw new Exception("Unrecognized operation: " + operation0);
        }
        return this.loginUser(((LoginUserOperation)operation0), CollectionsKt.drop(list0, 1), continuation0);
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public List getOperations() {
        return CollectionsKt.listOf("login-user");
    }

    private final Object loginUser(LoginUserOperation loginUserOperation0, List list0, Continuation continuation0) {
        LoginUserOperationExecutor loginUserOperationExecutor0;
        com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.loginUser.1 loginUserOperationExecutor$loginUser$10;
        LoginUserOperation loginUserOperation1 = loginUserOperation0;
        List list1 = list0;
        if(continuation0 instanceof com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.loginUser.1) {
            loginUserOperationExecutor$loginUser$10 = (com.onesignal.user.internal.operations.impl.executors.LoginUserOperationExecutor.loginUser.1)continuation0;
            if((loginUserOperationExecutor$loginUser$10.label & 0x80000000) == 0) {
                loginUserOperationExecutor$loginUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.loginUser(null, null, this);
                    }
                };
            }
            else {
                loginUserOperationExecutor$loginUser$10.label ^= 0x80000000;
            }
        }
        else {
            loginUserOperationExecutor$loginUser$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.loginUser(null, null, this);
                }
            };
        }
        Object object0 = loginUserOperationExecutor$loginUser$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(loginUserOperationExecutor$loginUser$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(loginUserOperation0.getExistingOnesignalId() != null && loginUserOperation0.getExternalId() != null) {
                    String s = loginUserOperation0.getAppId();
                    String s1 = loginUserOperation0.getExistingOnesignalId();
                    Intrinsics.checkNotNull(s1);
                    String s2 = loginUserOperation0.getExternalId();
                    Intrinsics.checkNotNull(s2);
                    List list3 = CollectionsKt.listOf(new SetAliasOperation(s, s1, "external_id", s2));
                    loginUserOperationExecutor$loginUser$10.L$0 = this;
                    loginUserOperationExecutor$loginUser$10.L$1 = loginUserOperation1;
                    loginUserOperationExecutor$loginUser$10.L$2 = list1;
                    loginUserOperationExecutor$loginUser$10.label = 2;
                    object0 = this._identityOperationExecutor.execute(list3, loginUserOperationExecutor$loginUser$10);
                    if(object0 == object1) {
                        return object1;
                    }
                    loginUserOperationExecutor0 = this;
                label_43:
                    int v = WhenMappings.$EnumSwitchMapping$0[((ExecutionResponse)object0).getResult().ordinal()];
                    if(v != 1) {
                        switch(v) {
                            case 2: {
                                Logging.debug$default(("LoginUserOperationExecutor now handling 409 response with \"code\": \"user-2\" by switching to user with \"external_id\": \"" + loginUserOperation1.getExternalId() + '\"'), null, 2, null);
                                loginUserOperationExecutor$loginUser$10.L$0 = null;
                                loginUserOperationExecutor$loginUser$10.L$1 = null;
                                loginUserOperationExecutor$loginUser$10.L$2 = null;
                                loginUserOperationExecutor$loginUser$10.label = 3;
                                object0 = loginUserOperationExecutor0.createUser(loginUserOperation1, list1, loginUserOperationExecutor$loginUser$10);
                                return object0 == object1 ? object1 : object0;
                            }
                            case 3: {
                                Logging.error$default(("LoginUserOperationExecutor encountered error. Attempt to recover by switching to user with \"external_id\": \"" + loginUserOperation1.getExternalId() + '\"'), null, 2, null);
                                loginUserOperationExecutor$loginUser$10.L$0 = null;
                                loginUserOperationExecutor$loginUser$10.L$1 = null;
                                loginUserOperationExecutor$loginUser$10.L$2 = null;
                                loginUserOperationExecutor$loginUser$10.label = 4;
                                object0 = loginUserOperationExecutor0.createUser(loginUserOperation1, list1, loginUserOperationExecutor$loginUser$10);
                                return object0 == object1 ? object1 : object0;
                            }
                            default: {
                                return new ExecutionResponse(((ExecutionResponse)object0).getResult(), null, null, 6, null);
                            }
                        }
                    }
                    String s3 = loginUserOperation1.getExistingOnesignalId();
                    Intrinsics.checkNotNull(s3);
                    if(Intrinsics.areEqual(((IdentityModel)loginUserOperationExecutor0._identityModelStore.getModel()).getOnesignalId(), loginUserOperation1.getOnesignalId())) {
                        Model.setStringProperty$default(loginUserOperationExecutor0._identityModelStore.getModel(), "onesignal_id", s3, "HYDRATE", false, 8, null);
                    }
                    if(Intrinsics.areEqual(((PropertiesModel)loginUserOperationExecutor0._propertiesModelStore.getModel()).getOnesignalId(), loginUserOperation1.getOnesignalId())) {
                        Model.setStringProperty$default(loginUserOperationExecutor0._propertiesModelStore.getModel(), "onesignalId", s3, "HYDRATE", false, 8, null);
                    }
                    Map map0 = MapsKt.mapOf(TuplesKt.to(loginUserOperation1.getOnesignalId(), s3));
                    return new ExecutionResponse(ExecutionResult.SUCCESS_STARTING_ONLY, map0, null, 4, null);
                }
                loginUserOperationExecutor$loginUser$10.label = 1;
                object0 = this.createUser(loginUserOperation1, list1, loginUserOperationExecutor$loginUser$10);
                return object0 == object1 ? object1 : object0;
            }
            case 1: {
                ResultKt.throwOnFailure(object0);
                return object0;
            }
            case 2: {
                List list2 = (List)loginUserOperationExecutor$loginUser$10.L$2;
                LoginUserOperation loginUserOperation2 = (LoginUserOperation)loginUserOperationExecutor$loginUser$10.L$1;
                loginUserOperationExecutor0 = (LoginUserOperationExecutor)loginUserOperationExecutor$loginUser$10.L$0;
                ResultKt.throwOnFailure(object0);
                list1 = list2;
                loginUserOperation1 = loginUserOperation2;
                goto label_43;
            }
            case 3: {
                ResultKt.throwOnFailure(object0);
                return object0;
            }
            case 4: {
                ResultKt.throwOnFailure(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

