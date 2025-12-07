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
import com.onesignal.user.internal.backend.IIdentityBackendService;
import com.onesignal.user.internal.builduser.IRebuildUserService;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.DeleteAliasOperation;
import com.onesignal.user.internal.operations.SetAliasOperation;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001D\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0002\u0010\bJ\u001F\u0010\u000E\u001A\u00020\u000F2\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00100\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u000B0\n8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/IdentityOperationExecutor;", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_identityBackend", "Lcom/onesignal/user/internal/backend/IIdentityBackendService;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "_buildUserService", "Lcom/onesignal/user/internal/builduser/IRebuildUserService;", "(Lcom/onesignal/user/internal/backend/IIdentityBackendService;Lcom/onesignal/user/internal/identity/IdentityModelStore;Lcom/onesignal/user/internal/builduser/IRebuildUserService;)V", "operations", "", "", "getOperations", "()Ljava/util/List;", "execute", "Lcom/onesignal/core/internal/operations/ExecutionResponse;", "Lcom/onesignal/core/internal/operations/Operation;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class IdentityOperationExecutor implements IOperationExecutor {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/executors/IdentityOperationExecutor$Companion;", "", "()V", "DELETE_ALIAS", "", "SET_ALIAS", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
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
            arr_v[ResponseStatusType.INVALID.ordinal()] = 2;
            arr_v[ResponseStatusType.CONFLICT.ordinal()] = 3;
            arr_v[ResponseStatusType.UNAUTHORIZED.ordinal()] = 4;
            arr_v[ResponseStatusType.MISSING.ordinal()] = 5;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final Companion Companion = null;
    public static final String DELETE_ALIAS = "delete-alias";
    public static final String SET_ALIAS = "set-alias";
    private final IRebuildUserService _buildUserService;
    private final IIdentityBackendService _identityBackend;
    private final IdentityModelStore _identityModelStore;

    static {
        IdentityOperationExecutor.Companion = new Companion(null);
    }

    public IdentityOperationExecutor(IIdentityBackendService iIdentityBackendService0, IdentityModelStore identityModelStore0, IRebuildUserService iRebuildUserService0) {
        Intrinsics.checkNotNullParameter(iIdentityBackendService0, "_identityBackend");
        Intrinsics.checkNotNullParameter(identityModelStore0, "_identityModelStore");
        Intrinsics.checkNotNullParameter(iRebuildUserService0, "_buildUserService");
        super();
        this._identityBackend = iIdentityBackendService0;
        this._identityModelStore = identityModelStore0;
        this._buildUserService = iRebuildUserService0;
    }

    @Override  // com.onesignal.core.internal.operations.IOperationExecutor
    public Object execute(List list0, Continuation continuation0) {
        Operation operation2;
        IdentityOperationExecutor identityOperationExecutor1;
        Operation operation1;
        IdentityOperationExecutor identityOperationExecutor0;
        com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor.execute.1 identityOperationExecutor$execute$10;
        if(continuation0 instanceof com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor.execute.1) {
            identityOperationExecutor$execute$10 = (com.onesignal.user.internal.operations.impl.executors.IdentityOperationExecutor.execute.1)continuation0;
            if((identityOperationExecutor$execute$10.label & 0x80000000) == 0) {
                identityOperationExecutor$execute$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
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
                identityOperationExecutor$execute$10.label ^= 0x80000000;
            }
        }
        else {
            identityOperationExecutor$execute$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
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
        Object object0 = identityOperationExecutor$execute$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(identityOperationExecutor$execute$10.label) {
            case 0: {
                boolean z = false;
                ResultKt.throwOnFailure(object0);
                Logging.debug$default(("IdentityOperationExecutor(operations: " + list0 + ')'), null, 2, null);
                boolean z1 = false;
                if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                    for(Object object2: list0) {
                        if(!(((Operation)object2) instanceof SetAliasOperation) && !(((Operation)object2) instanceof DeleteAliasOperation)) {
                            z = true;
                            break;
                        }
                    }
                }
                boolean z2 = false;
                if(z) {
                    throw new Exception("Unrecognized operation(s)! Attempted operations:\n" + list0);
                }
                if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                    for(Object object3: list0) {
                        if(((Operation)object3) instanceof SetAliasOperation) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if(z2) {
                    if(!(list0 instanceof Collection) || !list0.isEmpty()) {
                        for(Object object4: list0) {
                            if(((Operation)object4) instanceof DeleteAliasOperation) {
                                z1 = true;
                                break;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                    if(z1) {
                        throw new Exception("Can\'t process SetAliasOperation and DeleteAliasOperation at the same time.");
                    }
                }
                Operation operation0 = (Operation)CollectionsKt.last(list0);
                if(operation0 instanceof SetAliasOperation) {
                    try {
                        String s = ((SetAliasOperation)operation0).getAppId();
                        String s1 = ((SetAliasOperation)operation0).getOnesignalId();
                        Map map0 = MapsKt.mapOf(TuplesKt.to(((SetAliasOperation)operation0).getLabel(), ((SetAliasOperation)operation0).getValue()));
                        identityOperationExecutor$execute$10.L$0 = this;
                        identityOperationExecutor$execute$10.L$1 = operation0;
                        identityOperationExecutor$execute$10.label = 1;
                        if(this._identityBackend.setAlias(s, "onesignal_id", s1, map0, identityOperationExecutor$execute$10) == object1) {
                            return object1;
                        }
                    }
                    catch(BackendException backendException0) {
                        identityOperationExecutor0 = this;
                        operation1 = operation0;
                        goto label_79;
                    }
                    identityOperationExecutor0 = this;
                    operation1 = operation0;
                    goto label_75;
                }
                else if(operation0 instanceof DeleteAliasOperation) {
                    try {
                        String s2 = ((DeleteAliasOperation)operation0).getAppId();
                        String s3 = ((DeleteAliasOperation)operation0).getOnesignalId();
                        String s4 = ((DeleteAliasOperation)operation0).getLabel();
                        identityOperationExecutor$execute$10.L$0 = this;
                        identityOperationExecutor$execute$10.L$1 = operation0;
                        identityOperationExecutor$execute$10.label = 2;
                        if(this._identityBackend.deleteAlias(s2, "onesignal_id", s3, s4, identityOperationExecutor$execute$10) == object1) {
                            return object1;
                        }
                        identityOperationExecutor1 = this;
                        operation2 = operation0;
                        goto label_92;
                    }
                    catch(BackendException backendException1) {
                        goto label_96;
                    }
                    throw new Exception("Unrecognized operation(s)! Attempted operations:\n" + list0);
                }
                break;
            }
            case 1: {
                operation1 = (Operation)identityOperationExecutor$execute$10.L$1;
                identityOperationExecutor0 = (IdentityOperationExecutor)identityOperationExecutor$execute$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_75:
                    if(Intrinsics.areEqual(((IdentityModel)identityOperationExecutor0._identityModelStore.getModel()).getOnesignalId(), ((SetAliasOperation)operation1).getOnesignalId())) {
                        Model.setStringProperty$default(identityOperationExecutor0._identityModelStore.getModel(), ((SetAliasOperation)operation1).getLabel(), ((SetAliasOperation)operation1).getValue(), "HYDRATE", false, 8, null);
                        return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
                    }
                    break;
                }
                catch(BackendException backendException0) {
                }
            label_79:
                switch(WhenMappings.$EnumSwitchMapping$0[NetworkUtils.INSTANCE.getResponseStatusType(backendException0.getStatusCode()).ordinal()]) {
                    case 1: {
                        return new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, null, 6, null);
                    }
                    case 2: {
                        return new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null);
                    }
                    case 3: {
                        return new ExecutionResponse(ExecutionResult.FAIL_CONFLICT, null, null, 6, null);
                    }
                    case 4: {
                        return new ExecutionResponse(ExecutionResult.FAIL_UNAUTHORIZED, null, null, 6, null);
                    }
                    case 5: {
                        String s5 = ((SetAliasOperation)operation1).getAppId();
                        String s6 = ((SetAliasOperation)operation1).getOnesignalId();
                        List list1 = identityOperationExecutor0._buildUserService.getRebuildOperationsIfCurrentUser(s5, s6);
                        return list1 == null ? new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null) : new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, list1, 2, null);
                    }
                    default: {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            case 2: {
                operation2 = (Operation)identityOperationExecutor$execute$10.L$1;
                identityOperationExecutor1 = (IdentityOperationExecutor)identityOperationExecutor$execute$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                label_92:
                    if(Intrinsics.areEqual(((IdentityModel)identityOperationExecutor1._identityModelStore.getModel()).getOnesignalId(), ((DeleteAliasOperation)operation2).getOnesignalId())) {
                        Model.setOptStringProperty$default(identityOperationExecutor1._identityModelStore.getModel(), ((DeleteAliasOperation)operation2).getLabel(), null, "HYDRATE", false, 8, null);
                        return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
                    }
                    break;
                }
                catch(BackendException backendException1) {
                label_96:
                    switch(WhenMappings.$EnumSwitchMapping$0[NetworkUtils.INSTANCE.getResponseStatusType(backendException1.getStatusCode()).ordinal()]) {
                        case 1: {
                            return new ExecutionResponse(ExecutionResult.FAIL_RETRY, null, null, 6, null);
                        }
                        case 2: {
                            return new ExecutionResponse(ExecutionResult.FAIL_NORETRY, null, null, 6, null);
                        }
                        case 3: {
                            return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
                        }
                        case 4: {
                            return new ExecutionResponse(ExecutionResult.FAIL_UNAUTHORIZED, null, null, 6, null);
                        }
                        case 5: {
                            return new ExecutionResponse(ExecutionResult.SUCCESS, null, null, 6, null);
                        }
                        default: {
                            throw new NoWhenBranchMatchedException();
                        }
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
        return CollectionsKt.listOf(new String[]{"set-alias", "delete-alias"});
    }
}

