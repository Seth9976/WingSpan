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
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.ISubscriptionBackendService;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.operations.CreateSubscriptionOperation;
import com.onesignal.user.internal.operations.DeleteSubscriptionOperation;
import com.onesignal.user.internal.operations.TransferSubscriptionOperation;
import com.onesignal.user.internal.operations.UpdateSubscriptionOperation;
import com.onesignal.user.internal.subscriptions.SubscriptionModel;
import com.onesignal.user.internal.subscriptions.SubscriptionModelStore;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import com.onesignal.user.internal.subscriptions.SubscriptionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B5\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r\u00A2\u0006\u0002\u0010\u000EJ\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\'\u0010\u0018\u001A\u00020\u00192\u0006\u0010\u001A\u001A\u00020\u001B2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u001C0\u0010H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\u001DJ\u0019\u0010\u001E\u001A\u00020\u00192\u0006\u0010\u001F\u001A\u00020 H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010!J\u001F\u0010\"\u001A\u00020\u00192\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u001C0\u0010H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010#J\u0019\u0010$\u001A\u00020\u00192\u0006\u0010%\u001A\u00020&H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010\'J\'\u0010(\u001A\u00020\u00192\u0006\u0010%\u001A\u00020)2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u001C0\u0010H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010*R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u001A\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00110\u00108VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006,"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/SubscriptionOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_subscriptionBackend", "Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_subscriptionModelStore", "Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_buildUserService", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "(Lcom/onesignal/user/internal/backend/ISubscriptionBackendService;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/user/internal/subscriptions/SubscriptionModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/builduser/IRebuildUserService;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "convert", "Lcom/onesignal/user/internal/backend/SubscriptionObjectType;", "subscriptionType", "Lcom/onesignal/user/internal/subscriptions/SubscriptionType;", "createSubscription", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "createOperation", "Lcom/onesignal/user/internal/operations/CreateSubscriptionOperation;", "Lcom/onesignal/core/internal/operations/Operation;", "(Lcom/onesignal/user/internal/operations/CreateSubscriptionOperation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSubscription", "op", "Lcom/onesignal/user/internal/operations/DeleteSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/DeleteSubscriptionOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "execute", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transferSubscription", "startingOperation", "Lcom/onesignal/user/internal/operations/TransferSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/TransferSubscriptionOperation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSubscription", "Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;", "(Lcom/onesignal/user/internal/operations/UpdateSubscriptionOperation;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class SubscriptionOperationExecutor implements IOperationExecutor {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/SubscriptionOperationExecutor$Companion;", "", "()V", "CREATE_SUBSCRIPTION", "", "DELETE_SUBSCRIPTION", "TRANSFER_SUBSCRIPTION", "UPDATE_SUBSCRIPTION", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
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
            int[] arr_v = new int[ResponseStatusType.values().length];
            arr_v[ResponseStatusType.RETRYABLE.ordinal()] = 1;
            arr_v[ResponseStatusType.CONFLICT.ordinal()] = 2;
            arr_v[ResponseStatusType.INVALID.ordinal()] = 3;
            arr_v[ResponseStatusType.UNAUTHORIZED.ordinal()] = 4;
            arr_v[ResponseStatusType.MISSING.ordinal()] = 5;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
            int[] arr_v1 = new int[SubscriptionType.values().length];
            arr_v1[SubscriptionType.SMS.ordinal()] = 1;
            arr_v1[SubscriptionType.EMAIL.ordinal()] = 2;
            WhenMappings.$EnumSwitchMapping$1 = arr_v1;
        }
    }

    public static final String CREATE_SUBSCRIPTION = "create-subscription";
    public static final Companion Companion = null;
    public static final String DELETE_SUBSCRIPTION = "delete-subscription";
    public static final String TRANSFER_SUBSCRIPTION = "transfer-subscription";
    public static final String UPDATE_SUBSCRIPTION = "update-subscription";
    private final IApplicationService _applicationService;
    private final IRebuildUserService _buildUserService;
    private final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final ISubscriptionBackendService _subscriptionBackend;
    private final SubscriptionModelStore _subscriptionModelStore;

    static {
        SubscriptionOperationExecutor.Companion = new Companion(null);
    }

    public SubscriptionOperationExecutor(ISubscriptionBackendService iSubscriptionBackendService0, IDeviceService iDeviceService0, IApplicationService iApplicationService0, SubscriptionModelStore subscriptionModelStore0, ConfigModelStore configModelStore0, IRebuildUserService iRebuildUserService0) {
        Intrinsics.checkNotNullParameter(iSubscriptionBackendService0, "_subscriptionBackend");
        Intrinsics.checkNotNullParameter(iDeviceService0, "_deviceService");
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(subscriptionModelStore0, "_subscriptionModelStore");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iRebuildUserService0, "_buildUserService");
        super();
        this._subscriptionBackend = iSubscriptionBackendService0;
        this._deviceService = iDeviceService0;
        this._applicationService = iApplicationService0;
        this._subscriptionModelStore = subscriptionModelStore0;
        this._configModelStore = configModelStore0;
        this._buildUserService = iRebuildUserService0;
    }

    private final SubscriptionObjectType convert(SubscriptionType subscriptionType0) {
        switch(WhenMappings.$EnumSwitchMapping$1[subscriptionType0.ordinal()]) {
            case 1: {
                return SubscriptionObjectType.SMS;
            }
            case 2: {
                return SubscriptionObjectType.EMAIL;
            }
            default: {
                DeviceType iDeviceService$DeviceType0 = this._deviceService.getDeviceType();
                return SubscriptionObjectType.Companion.fromDeviceType(iDeviceService$DeviceType0);
            }
        }
    }

    private final Object createSubscription(CreateSubscriptionOperation createSubscriptionOperation0, List list0, Continuation continuation0) {
        SubscriptionOperationExecutor subscriptionOperationExecutor0;
        Object object5;
        CreateSubscriptionOperation createSubscriptionOperation1;
        String s5;
        String s4;
        SubscriptionObject subscriptionObject0;
        SubscriptionStatus subscriptionStatus0;
        String s;
        com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.createSubscription.1 subscriptionOperationExecutor$createSubscription$10;
        if(continuation0 instanceof com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.createSubscription.1) {
            subscriptionOperationExecutor$createSubscription$10 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.createSubscription.1)continuation0;
            if((subscriptionOperationExecutor$createSubscription$10.label & 0x80000000) == 0) {
                subscriptionOperationExecutor$createSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.createSubscription(null, null, this);
                    }
                };
            }
            else {
                subscriptionOperationExecutor$createSubscription$10.label ^= 0x80000000;
            }
        }
        else {
            subscriptionOperationExecutor$createSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.createSubscription(null, null, this);
                }
            };
        }
        Object object0 = subscriptionOperationExecutor$createSubscription$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(subscriptionOperationExecutor$createSubscription$10.label) {
            case 0: {
                boolean z = false;
                ResultKt.throwOnFailure(object0);
                boolean z1 = false;
                if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                    for(Object object2: list0) {
                        if(((Operation)object2) instanceof DeleteSubscriptionOperation) {
                            z = true;
                            break;
                        }
                    }
                }
                if(z) {
                    return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
                }
                Object object3 = null;
                ListIterator listIterator0 = list0.listIterator(list0.size());
                while(listIterator0.hasPrevious()) {
                    Object object4 = listIterator0.previous();
                    if(((Operation)object4) instanceof UpdateSubscriptionOperation) {
                        object3 = object4;
                        break;
                    }
                }
                boolean z2 = ((UpdateSubscriptionOperation)object3) == null ? createSubscriptionOperation0.getEnabled() : ((UpdateSubscriptionOperation)object3).getEnabled();
                if(((UpdateSubscriptionOperation)object3) == null) {
                    s = createSubscriptionOperation0.getAddress();
                }
                else {
                    s = ((UpdateSubscriptionOperation)object3).getAddress();
                    if(s == null) {
                        s = createSubscriptionOperation0.getAddress();
                    }
                }
                if(((UpdateSubscriptionOperation)object3) == null) {
                    subscriptionStatus0 = createSubscriptionOperation0.getStatus();
                }
                else {
                    subscriptionStatus0 = ((UpdateSubscriptionOperation)object3).getStatus();
                    if(subscriptionStatus0 == null) {
                        subscriptionStatus0 = createSubscriptionOperation0.getStatus();
                    }
                }
                try {
                    SubscriptionObjectType subscriptionObjectType0 = this.convert(createSubscriptionOperation0.getType());
                    if(z2) {
                        z1 = true;
                    }
                    String s1 = Build.MODEL;
                    String s2 = Build.VERSION.RELEASE;
                    Boolean boolean0 = Boxing.boxBoolean(RootToolsInternalMethods.INSTANCE.isRooted());
                    Context context0 = this._applicationService.getAppContext();
                    Integer integer0 = DeviceUtils.INSTANCE.getNetType(context0);
                    Context context1 = this._applicationService.getAppContext();
                    String s3 = DeviceUtils.INSTANCE.getCarrierName(context1);
                    Context context2 = this._applicationService.getAppContext();
                    subscriptionObject0 = new SubscriptionObject(null, subscriptionObjectType0, s, Boxing.boxBoolean(z1), Boxing.boxInt(subscriptionStatus0.getValue()), "050109", s1, s2, boolean0, integer0, s3, AndroidUtils.INSTANCE.getAppVersion(context2));
                    s4 = createSubscriptionOperation0.getAppId();
                    s5 = createSubscriptionOperation0.getOnesignalId();
                    subscriptionOperationExecutor$createSubscription$10.L$0 = this;
                    createSubscriptionOperation1 = createSubscriptionOperation0;
                }
                catch(BackendException backendException0) {
                    createSubscriptionOperation1 = createSubscriptionOperation0;
                    subscriptionOperationExecutor0 = this;
                    break;
                }
                try {
                    subscriptionOperationExecutor$createSubscription$10.L$1 = createSubscriptionOperation1;
                    subscriptionOperationExecutor$createSubscription$10.label = 1;
                    object5 = this._subscriptionBackend.createSubscription(s4, "onesignal_id", s5, subscriptionObject0, subscriptionOperationExecutor$createSubscription$10);
                }
                catch(BackendException backendException0) {
                    subscriptionOperationExecutor0 = this;
                    break;
                }
                if(object5 == object1) {
                    return object1;
                }
                subscriptionOperationExecutor0 = this;
                goto label_79;
            }
            case 1: {
                CreateSubscriptionOperation createSubscriptionOperation2 = (CreateSubscriptionOperation)subscriptionOperationExecutor$createSubscription$10.L$1;
                subscriptionOperationExecutor0 = (SubscriptionOperationExecutor)subscriptionOperationExecutor$createSubscription$10.L$0;
                try {
                    createSubscriptionOperation1 = createSubscriptionOperation2;
                    ResultKt.throwOnFailure(object0);
                    object5 = object0;
                    createSubscriptionOperation1 = createSubscriptionOperation2;
                label_79:
                    if(((String)object5) == null) {
                        return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
                    }
                    String s6 = createSubscriptionOperation1.getSubscriptionId();
                    SubscriptionModel subscriptionModel0 = (SubscriptionModel)subscriptionOperationExecutor0._subscriptionModelStore.get(s6);
                    if(subscriptionModel0 != null) {
                        Model.setStringProperty$default(subscriptionModel0, "id", ((String)object5), "HYDRATE", false, 8, null);
                    }
                    if(Intrinsics.areEqual(((ConfigModel)subscriptionOperationExecutor0._configModelStore.getModel()).getPushSubscriptionId(), createSubscriptionOperation1.getSubscriptionId())) {
                        ((ConfigModel)subscriptionOperationExecutor0._configModelStore.getModel()).setPushSubscriptionId(((String)object5));
                    }
                    Map map0 = MapsKt.mapOf(TuplesKt.to(createSubscriptionOperation1.getSubscriptionId(), ((String)object5)));
                    return new ExecutionResponse(ExecutionResult.SUCCESS, map0, null, 4, null);
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
            case 2: 
            case 3: {
                return new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null);
            }
            case 4: {
                return new ExecutionResponse(ExecutionResult.FAIL_UNAUTHORIZED, null, null, 6, null);
            }
            case 5: {
                String s7 = createSubscriptionOperation1.getAppId();
                String s8 = createSubscriptionOperation1.getOnesignalId();
                List list1 = subscriptionOperationExecutor0._buildUserService.getRebuildOperationsIfCurrentUser(s7, s8);
                return list1 == null ? new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null) : new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, list1, 2, null);
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    private final Object deleteSubscription(DeleteSubscriptionOperation deleteSubscriptionOperation0, Continuation continuation0) {
        SubscriptionOperationExecutor subscriptionOperationExecutor0;
        com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.deleteSubscription.1 subscriptionOperationExecutor$deleteSubscription$10;
        if(continuation0 instanceof com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.deleteSubscription.1) {
            subscriptionOperationExecutor$deleteSubscription$10 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.deleteSubscription.1)continuation0;
            if((subscriptionOperationExecutor$deleteSubscription$10.label & 0x80000000) == 0) {
                subscriptionOperationExecutor$deleteSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.deleteSubscription(null, this);
                    }
                };
            }
            else {
                subscriptionOperationExecutor$deleteSubscription$10.label ^= 0x80000000;
            }
        }
        else {
            subscriptionOperationExecutor$deleteSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.deleteSubscription(null, this);
                }
            };
        }
        Object object0 = subscriptionOperationExecutor$deleteSubscription$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(subscriptionOperationExecutor$deleteSubscription$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    String s = deleteSubscriptionOperation0.getAppId();
                    String s1 = deleteSubscriptionOperation0.getSubscriptionId();
                    subscriptionOperationExecutor$deleteSubscription$10.L$0 = this;
                    subscriptionOperationExecutor$deleteSubscription$10.L$1 = deleteSubscriptionOperation0;
                    subscriptionOperationExecutor$deleteSubscription$10.label = 1;
                    if(this._subscriptionBackend.deleteSubscription(s, s1, subscriptionOperationExecutor$deleteSubscription$10) == object1) {
                        return object1;
                    }
                    subscriptionOperationExecutor0 = this;
                    goto label_25;
                }
                catch(BackendException backendException0) {
                    break;
                }
            }
            case 1: {
                deleteSubscriptionOperation0 = (DeleteSubscriptionOperation)subscriptionOperationExecutor$deleteSubscription$10.L$1;
                subscriptionOperationExecutor0 = (SubscriptionOperationExecutor)subscriptionOperationExecutor$deleteSubscription$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_25:
                    String s2 = deleteSubscriptionOperation0.getSubscriptionId();
                    subscriptionOperationExecutor0._subscriptionModelStore.remove(s2, "HYDRATE");
                    return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
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
            case 5: {
                return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
            }
            default: {
                return new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null);
            }
        }
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List list0, Continuation continuation0) {
        boolean z = false;
        Logging.log(LogLevel.DEBUG, "SubscriptionOperationExecutor(operations: " + list0 + ')');
        Operation operation0 = (Operation)CollectionsKt.first(list0);
        if(operation0 instanceof CreateSubscriptionOperation) {
            return this.createSubscription(((CreateSubscriptionOperation)operation0), list0, continuation0);
        }
        if(!(list0 instanceof Collection) || !list0.isEmpty()) {
            for(Object object0: list0) {
                if(((Operation)object0) instanceof DeleteSubscriptionOperation) {
                    z = true;
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        if(z) {
            if(list0.size() > 1) {
                throw new Exception("Only supports one operation! Attempted operations:\n" + list0);
            }
            Collection collection0 = new ArrayList();
            for(Object object1: list0) {
                if(object1 instanceof DeleteSubscriptionOperation) {
                    collection0.add(object1);
                }
            }
            return this.deleteSubscription(((DeleteSubscriptionOperation)CollectionsKt.first(((List)collection0))), continuation0);
        }
        if(operation0 instanceof UpdateSubscriptionOperation) {
            return this.updateSubscription(((UpdateSubscriptionOperation)operation0), list0, continuation0);
        }
        if(!(operation0 instanceof TransferSubscriptionOperation)) {
            throw new Exception("Unrecognized operation: " + operation0);
        }
        if(list0.size() > 1) {
            throw new Exception("TransferSubscriptionOperation only supports one operation! Attempted operations:\n" + list0);
        }
        return this.transferSubscription(((TransferSubscriptionOperation)operation0), continuation0);
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public List getOperations() {
        return CollectionsKt.listOf(new String[]{"create-subscription", "update-subscription", "delete-subscription", "transfer-subscription"});
    }

    private final Object transferSubscription(TransferSubscriptionOperation transferSubscriptionOperation0, Continuation continuation0) {
        com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.transferSubscription.1 subscriptionOperationExecutor$transferSubscription$10;
        if(continuation0 instanceof com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.transferSubscription.1) {
            subscriptionOperationExecutor$transferSubscription$10 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.transferSubscription.1)continuation0;
            if((subscriptionOperationExecutor$transferSubscription$10.label & 0x80000000) == 0) {
                subscriptionOperationExecutor$transferSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.transferSubscription(null, this);
                    }
                };
            }
            else {
                subscriptionOperationExecutor$transferSubscription$10.label ^= 0x80000000;
            }
        }
        else {
            subscriptionOperationExecutor$transferSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.transferSubscription(null, this);
                }
            };
        }
        Object object0 = subscriptionOperationExecutor$transferSubscription$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(subscriptionOperationExecutor$transferSubscription$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    String s = transferSubscriptionOperation0.getAppId();
                    String s1 = transferSubscriptionOperation0.getSubscriptionId();
                    String s2 = transferSubscriptionOperation0.getOnesignalId();
                    subscriptionOperationExecutor$transferSubscription$10.label = 1;
                    if(this._subscriptionBackend.transferSubscription(s, s1, "onesignal_id", s2, subscriptionOperationExecutor$transferSubscription$10) == object1) {
                        return object1;
                    }
                }
                catch(BackendException backendException0) {
                    return WhenMappings.$EnumSwitchMapping$0[NetworkUtils.INSTANCE.getResponseStatusType(backendException0.getStatusCode()).ordinal()] == 1 ? new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, null, 6, null) : new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null);
                }
                return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
            }
            case 1: {
                try {
                    ResultKt.throwOnFailure(object0);
                    return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
                }
                catch(BackendException backendException0) {
                    return WhenMappings.$EnumSwitchMapping$0[NetworkUtils.INSTANCE.getResponseStatusType(backendException0.getStatusCode()).ordinal()] == 1 ? new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, null, 6, null) : new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null);
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    private final Object updateSubscription(UpdateSubscriptionOperation updateSubscriptionOperation0, List list0, Continuation continuation0) {
        UpdateSubscriptionOperation updateSubscriptionOperation2;
        com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.updateSubscription.1 subscriptionOperationExecutor$updateSubscription$10;
        if(continuation0 instanceof com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.updateSubscription.1) {
            subscriptionOperationExecutor$updateSubscription$10 = (com.onesignal.user.internal.operations.impl.executors.SubscriptionOperationExecutor.updateSubscription.1)continuation0;
            if((subscriptionOperationExecutor$updateSubscription$10.label & 0x80000000) == 0) {
                subscriptionOperationExecutor$updateSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.updateSubscription(null, null, this);
                    }
                };
            }
            else {
                subscriptionOperationExecutor$updateSubscription$10.label ^= 0x80000000;
            }
        }
        else {
            subscriptionOperationExecutor$updateSubscription$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.updateSubscription(null, null, this);
                }
            };
        }
        Object object0 = subscriptionOperationExecutor$updateSubscription$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(subscriptionOperationExecutor$updateSubscription$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Object object2 = CollectionsKt.last(list0);
                Intrinsics.checkNotNull(object2, "null cannot be cast to non-null type com.onesignal.user.internal.operations.UpdateSubscriptionOperation");
                UpdateSubscriptionOperation updateSubscriptionOperation1 = (UpdateSubscriptionOperation)object2;
                try {
                    SubscriptionObjectType subscriptionObjectType0 = this.convert(updateSubscriptionOperation1.getType());
                    String s = updateSubscriptionOperation1.getAddress();
                    Boolean boolean0 = Boxing.boxBoolean(updateSubscriptionOperation1.getEnabled());
                    Integer integer0 = Boxing.boxInt(updateSubscriptionOperation1.getStatus().getValue());
                    String s1 = Build.MODEL;
                    String s2 = Build.VERSION.RELEASE;
                    Boolean boolean1 = Boxing.boxBoolean(RootToolsInternalMethods.INSTANCE.isRooted());
                    Context context0 = this._applicationService.getAppContext();
                    Integer integer1 = DeviceUtils.INSTANCE.getNetType(context0);
                    Context context1 = this._applicationService.getAppContext();
                    String s3 = DeviceUtils.INSTANCE.getCarrierName(context1);
                    Context context2 = this._applicationService.getAppContext();
                    SubscriptionObject subscriptionObject0 = new SubscriptionObject(null, subscriptionObjectType0, s, boolean0, integer0, "050109", s1, s2, boolean1, integer1, s3, AndroidUtils.INSTANCE.getAppVersion(context2));
                    String s4 = updateSubscriptionOperation1.getAppId();
                    String s5 = updateSubscriptionOperation1.getSubscriptionId();
                    subscriptionOperationExecutor$updateSubscription$10.L$0 = updateSubscriptionOperation1;
                    subscriptionOperationExecutor$updateSubscription$10.label = 1;
                    if(this._subscriptionBackend.updateSubscription(s4, s5, subscriptionObject0, subscriptionOperationExecutor$updateSubscription$10) == object1) {
                        return object1;
                    }
                }
                catch(BackendException backendException0) {
                    updateSubscriptionOperation2 = updateSubscriptionOperation1;
                    goto label_44;
                }
                return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
            }
            case 1: {
                updateSubscriptionOperation2 = (UpdateSubscriptionOperation)subscriptionOperationExecutor$updateSubscription$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
                }
                catch(BackendException backendException0) {
                }
            label_44:
                switch(WhenMappings.$EnumSwitchMapping$0[NetworkUtils.INSTANCE.getResponseStatusType(backendException0.getStatusCode()).ordinal()]) {
                    case 1: {
                        return new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, null, 6, null);
                    }
                    case 5: {
                        List list1 = CollectionsKt.listOf(new CreateSubscriptionOperation(updateSubscriptionOperation2.getAppId(), updateSubscriptionOperation2.getOnesignalId(), updateSubscriptionOperation2.getSubscriptionId(), updateSubscriptionOperation2.getType(), updateSubscriptionOperation2.getEnabled(), updateSubscriptionOperation2.getAddress(), updateSubscriptionOperation2.getStatus()));
                        return new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, list1, 2, null);
                    }
                    default: {
                        return new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null);
                    }
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

