package com.onesignal.user.internal.operations.impl.executors;

import com.onesignal.common.NetworkUtils.ResponseStatusType;
import com.onesignal.common.NetworkUtils;
import com.onesignal.common.exceptions.BackendException;
import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.backend.IUserBackendService;
import com.onesignal.user.internal.backend.PropertiesDeltasObject;
import com.onesignal.user.internal.backend.PropertiesObject;
import com.onesignal.user.internal.backend.PurchaseObject;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.DeleteTagOperation;
import com.onesignal.user.internal.operations.PurchaseInfo;
import com.onesignal.user.internal.operations.SetPropertyOperation;
import com.onesignal.user.internal.operations.SetTagOperation;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import com.onesignal.user.internal.operations.TrackSessionEndOperation;
import com.onesignal.user.internal.operations.TrackSessionStartOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B%\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\u001F\u0010\u0010\u001A\u00020\u00112\f\u0010\u0012\u001A\b\u0012\u0004\u0012\u00020\u00130\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\r0\f8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000F\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/UpdateUserOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_userBackend", "Lcom/onesignal/user/internal/backend/IUserBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_buildUserService", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "(Lcom/onesignal/user/internal/backend/IUserBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/user/internal/builduser/IRebuildUserService;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "execute", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "ops", "Lcom/onesignal/core/internal/operations/Operation;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class UpdateUserOperationExecutor implements IOperationExecutor {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/UpdateUserOperationExecutor$Companion;", "", "()V", "DELETE_TAG", "", "SET_PROPERTY", "SET_TAG", "TRACK_PURCHASE", "TRACK_SESSION_END", "TRACK_SESSION_START", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
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
            arr_v[ResponseStatusType.MISSING.ordinal()] = 3;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final Companion Companion = null;
    public static final String DELETE_TAG = "delete-tag";
    public static final String SET_PROPERTY = "set-property";
    public static final String SET_TAG = "set-tag";
    public static final String TRACK_PURCHASE = "track-purchase";
    public static final String TRACK_SESSION_END = "track-session-end";
    public static final String TRACK_SESSION_START = "track-session-start";
    private final IRebuildUserService _buildUserService;
    private final IdentityModelStore _identityModelStore;
    private final PropertiesModelStore _propertiesModelStore;
    private final IUserBackendService _userBackend;

    static {
        UpdateUserOperationExecutor.Companion = new Companion(null);
    }

    public UpdateUserOperationExecutor(IUserBackendService iUserBackendService0, IdentityModelStore identityModelStore0, PropertiesModelStore propertiesModelStore0, IRebuildUserService iRebuildUserService0) {
        Intrinsics.checkNotNullParameter(iUserBackendService0, "_userBackend");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(propertiesModelStore0, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(iRebuildUserService0, "_buildUserService");
        super();
        this._userBackend = iUserBackendService0;
        this._identityModelStore = identityModelStore0;
        this._propertiesModelStore = propertiesModelStore0;
        this._buildUserService = iRebuildUserService0;
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List list0, Continuation continuation0) {
        String s3;
        String s2;
        UpdateUserOperationExecutor updateUserOperationExecutor0;
        List list3;
        BigDecimal bigDecimal1;
        long v1;
        int v;
        com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor.execute.1 updateUserOperationExecutor$execute$10;
        List list1 = list0;
        if(continuation0 instanceof com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor.execute.1) {
            updateUserOperationExecutor$execute$10 = (com.onesignal.user.internal.operations.impl.executors.UpdateUserOperationExecutor.execute.1)continuation0;
            if((updateUserOperationExecutor$execute$10.label & 0x80000000) == 0) {
                updateUserOperationExecutor$execute$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.execute(null, this);
                    }
                };
            }
            else {
                updateUserOperationExecutor$execute$10.label ^= 0x80000000;
            }
        }
        else {
            updateUserOperationExecutor$execute$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.execute(null, this);
                }
            };
        }
        Object object0 = updateUserOperationExecutor$execute$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(updateUserOperationExecutor$execute$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Logging.log(LogLevel.DEBUG, "UpdateUserOperationExecutor(operation: " + list1 + ')');
                String s = null;
                String s1 = null;
                PropertiesObject propertiesObject0 = new PropertiesObject(null, null, null, null, null, null, 0x3F, null);
                PropertiesDeltasObject propertiesDeltasObject0 = new PropertiesDeltasObject(null, null, null, null, 15, null);
                boolean z = false;
                for(Object object2: list0) {
                    Operation operation0 = (Operation)object2;
                    if(operation0 instanceof SetTagOperation) {
                        if(s1 == null) {
                            s1 = ((SetTagOperation)operation0).getAppId();
                            s = ((SetTagOperation)operation0).getOnesignalId();
                        }
                        propertiesObject0 = PropertyOperationHelper.INSTANCE.createPropertiesFromOperation(((SetTagOperation)operation0), propertiesObject0);
                    }
                    else if(operation0 instanceof DeleteTagOperation) {
                        if(s1 == null) {
                            s1 = ((DeleteTagOperation)operation0).getAppId();
                            s = ((DeleteTagOperation)operation0).getOnesignalId();
                        }
                        propertiesObject0 = PropertyOperationHelper.INSTANCE.createPropertiesFromOperation(((DeleteTagOperation)operation0), propertiesObject0);
                    }
                    else if(operation0 instanceof SetPropertyOperation) {
                        if(s1 == null) {
                            s1 = ((SetPropertyOperation)operation0).getAppId();
                            s = ((SetPropertyOperation)operation0).getOnesignalId();
                        }
                        propertiesObject0 = PropertyOperationHelper.INSTANCE.createPropertiesFromOperation(((SetPropertyOperation)operation0), propertiesObject0);
                    }
                    else if(operation0 instanceof TrackSessionStartOperation) {
                        if(s1 == null) {
                            s1 = ((TrackSessionStartOperation)operation0).getAppId();
                            s = ((TrackSessionStartOperation)operation0).getOnesignalId();
                        }
                        if(propertiesDeltasObject0.getSessionCount() == null) {
                            v = 1;
                        }
                        else {
                            Integer integer0 = propertiesDeltasObject0.getSessionCount();
                            Intrinsics.checkNotNull(integer0);
                            v = ((int)integer0) + 1;
                        }
                        propertiesDeltasObject0 = new PropertiesDeltasObject(propertiesDeltasObject0.getSessionTime(), Boxing.boxInt(v), propertiesDeltasObject0.getAmountSpent(), propertiesDeltasObject0.getPurchases());
                        z = true;
                    }
                    else if(operation0 instanceof TrackSessionEndOperation) {
                        if(s1 == null) {
                            s1 = ((TrackSessionEndOperation)operation0).getAppId();
                            s = ((TrackSessionEndOperation)operation0).getOnesignalId();
                        }
                        if(propertiesDeltasObject0.getSessionTime() == null) {
                            v1 = ((TrackSessionEndOperation)operation0).getSessionTime();
                        }
                        else {
                            Long long0 = propertiesDeltasObject0.getSessionTime();
                            Intrinsics.checkNotNull(long0);
                            v1 = ((long)long0) + ((TrackSessionEndOperation)operation0).getSessionTime();
                        }
                        propertiesDeltasObject0 = new PropertiesDeltasObject(Boxing.boxLong(v1), propertiesDeltasObject0.getSessionCount(), propertiesDeltasObject0.getAmountSpent(), propertiesDeltasObject0.getPurchases());
                    }
                    else {
                        if(!(operation0 instanceof TrackPurchaseOperation)) {
                            throw new Exception("Unrecognized operation: " + operation0);
                        }
                        if(s1 == null) {
                            s1 = ((TrackPurchaseOperation)operation0).getAppId();
                            s = ((TrackPurchaseOperation)operation0).getOnesignalId();
                        }
                        if(propertiesDeltasObject0.getAmountSpent() == null) {
                            bigDecimal1 = ((TrackPurchaseOperation)operation0).getAmountSpent();
                        }
                        else {
                            BigDecimal bigDecimal0 = propertiesDeltasObject0.getAmountSpent();
                            Intrinsics.checkNotNull(bigDecimal0);
                            bigDecimal1 = bigDecimal0.add(((TrackPurchaseOperation)operation0).getAmountSpent());
                            Intrinsics.checkNotNullExpressionValue(bigDecimal1, "this.add(other)");
                        }
                        if(propertiesDeltasObject0.getPurchases() == null) {
                            list3 = new ArrayList();
                        }
                        else {
                            List list2 = propertiesDeltasObject0.getPurchases();
                            Intrinsics.checkNotNull(list2);
                            list3 = CollectionsKt.toMutableList(list2);
                        }
                        for(Object object3: ((TrackPurchaseOperation)operation0).getPurchases()) {
                            list3.add(new PurchaseObject(((PurchaseInfo)object3).getSku(), ((PurchaseInfo)object3).getIso(), ((PurchaseInfo)object3).getAmount()));
                        }
                        propertiesDeltasObject0 = new PropertiesDeltasObject(propertiesDeltasObject0.getSessionTime(), propertiesDeltasObject0.getSessionCount(), bigDecimal1, list3);
                    }
                }
                if(s1 != null && s != null) {
                    try {
                        updateUserOperationExecutor$execute$10.L$0 = this;
                        updateUserOperationExecutor$execute$10.L$1 = list1;
                        updateUserOperationExecutor$execute$10.L$2 = s1;
                        updateUserOperationExecutor$execute$10.L$3 = s;
                        updateUserOperationExecutor$execute$10.label = 1;
                        if(this._userBackend.updateUser(s1, "onesignal_id", s, propertiesObject0, z, propertiesDeltasObject0, updateUserOperationExecutor$execute$10) == object1) {
                            return object1;
                        }
                    }
                    catch(BackendException backendException0) {
                        updateUserOperationExecutor0 = this;
                        s2 = s;
                        s3 = s1;
                        goto label_130;
                    }
                    updateUserOperationExecutor0 = this;
                    s2 = s;
                    s3 = s1;
                    goto label_115;
                }
                break;
            }
            case 1: {
                s2 = (String)updateUserOperationExecutor$execute$10.L$3;
                s3 = (String)updateUserOperationExecutor$execute$10.L$2;
                list1 = (List)updateUserOperationExecutor$execute$10.L$1;
                updateUserOperationExecutor0 = (UpdateUserOperationExecutor)updateUserOperationExecutor$execute$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_115:
                    if(Intrinsics.areEqual(((IdentityModel)updateUserOperationExecutor0._identityModelStore.getModel()).getOnesignalId(), s2)) {
                        Iterator iterator2 = list1.iterator();
                        while(true) {
                            if(!iterator2.hasNext()) {
                                break;
                            }
                            Object object4 = iterator2.next();
                            Operation operation1 = (Operation)object4;
                            if(operation1 instanceof SetTagOperation) {
                                Model.setStringProperty$default(((PropertiesModel)updateUserOperationExecutor0._propertiesModelStore.getModel()).getTags(), ((SetTagOperation)operation1).getKey(), ((SetTagOperation)operation1).getValue(), "HYDRATE", false, 8, null);
                            }
                            else if(operation1 instanceof DeleteTagOperation) {
                                Model.setOptStringProperty$default(((PropertiesModel)updateUserOperationExecutor0._propertiesModelStore.getModel()).getTags(), ((DeleteTagOperation)operation1).getKey(), null, "HYDRATE", false, 8, null);
                            }
                            else {
                                if(!(operation1 instanceof SetPropertyOperation)) {
                                    continue;
                                }
                                Model.setOptAnyProperty$default(updateUserOperationExecutor0._propertiesModelStore.getModel(), ((SetPropertyOperation)operation1).getProperty(), ((SetPropertyOperation)operation1).getValue(), "HYDRATE", false, 8, null);
                            }
                        }
                    }
                    break;
                }
                catch(BackendException backendException0) {
                }
            label_130:
                switch(WhenMappings.$EnumSwitchMapping$0[NetworkUtils.INSTANCE.getResponseStatusType(backendException0.getStatusCode()).ordinal()]) {
                    case 1: {
                        return new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, null, 6, null);
                    }
                    case 2: {
                        return new ExecutionResponse(ExecutionResult.FAIL_UNAUTHORIZED, null, null, 6, null);
                    }
                    case 3: {
                        List list4 = updateUserOperationExecutor0._buildUserService.getRebuildOperationsIfCurrentUser(s3, s2);
                        return list4 == null ? new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null) : new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, list4, 2, null);
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
        return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public List getOperations() {
        return CollectionsKt.listOf(new String[]{"set-tag", "delete-tag", "set-property", "track-session-start", "track-session-end", "track-purchase"});
    }
}

