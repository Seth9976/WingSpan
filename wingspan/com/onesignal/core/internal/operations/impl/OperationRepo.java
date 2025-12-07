package com.onesignal.core.internal.operations.impl;

import com.onesignal.common.modeling.IModelStore.DefaultImpls;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.ExecutionResponse;
import com.onesignal.core.internal.operations.ExecutionResult;
import com.onesignal.core.internal.operations.GroupComparisonType;
import com.onesignal.core.internal.operations.IOperationExecutor;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0019\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001:B+\u0012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u00A2\u0006\u0002\u0010\fJ \u0010\u001C\u001A\u00020\u0016\"\b\b\u0000\u0010\u001D*\u00020\u001E2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u001D0 H\u0016J\u0019\u0010!\u001A\u00020\"2\u0006\u0010#\u001A\u00020\u000EH\u0086@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010$J\u0018\u0010%\u001A\u00020\"2\u0006\u0010&\u001A\u00020\u001E2\u0006\u0010\'\u001A\u00020\u0016H\u0016J!\u0010(\u001A\u00020\u00162\u0006\u0010&\u001A\u00020\u001E2\u0006\u0010\'\u001A\u00020\u0016H\u0096@\u00F8\u0001\u0000\u00A2\u0006\u0002\u0010)J!\u0010*\u001A\u00020\"2\f\u0010+\u001A\b\u0012\u0004\u0012\u00020\u00190\u0004H\u0080@\u00F8\u0001\u0000\u00A2\u0006\u0004\b,\u0010-J\u0016\u0010.\u001A\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010/\u001A\u00020\u0019H\u0002J\u001D\u00100\u001A\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00042\u0006\u00101\u001A\u00020\u000EH\u0000\u00A2\u0006\u0002\b2J \u00103\u001A\u00020\"2\u0006\u00104\u001A\u00020\u00192\u0006\u0010\'\u001A\u00020\u00162\u0006\u00105\u001A\u00020\u0016H\u0002J\u0011\u00106\u001A\u00020\"H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00107J\b\u00108\u001A\u00020\"H\u0016J\u0011\u00109\u001A\u00020\"H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0002\u00107R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u000F\u001A\u00020\u000E8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b\u0010\u0010\u0011R\u001A\u0010\u0012\u001A\u000E\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0013X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0016X\u0082\u000E\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001A\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004\u00A2\u0006\u0002\n\u0000R\u0014\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00160\u001BX\u0082\u0004\u00A2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006;"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationRepo;", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "Lcom/onesignal/core/internal/startup/IStartableService;", "executors", "", "Lcom/onesignal/core/internal/operations/IOperationExecutor;", "_operationModelStore", "Lcom/onesignal/core/internal/operations/impl/OperationModelStore;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Ljava/util/List;Lcom/onesignal/core/internal/operations/impl/OperationModelStore;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/time/ITime;)V", "enqueueIntoBucket", "", "executeBucket", "getExecuteBucket", "()I", "executorsMap", "", "", "paused", "", "queue", "", "Lcom/onesignal/core/internal/operations/impl/OperationRepo$OperationQueueItem;", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "containsInstanceOf", "T", "Lcom/onesignal/core/internal/operations/Operation;", "type", "Lkotlin/reflect/KClass;", "delayBeforeRetry", "", "retries", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enqueue", "operation", "flush", "enqueueAndWait", "(Lcom/onesignal/core/internal/operations/Operation;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeOperations", "ops", "executeOperations$com_onesignal_core", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroupableOperations", "startingOp", "getNextOps", "bucketFilter", "getNextOps$com_onesignal_core", "internalEnqueue", "queueItem", "addToStore", "processQueueForever", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "waitForNewOperationAndExecutionInterval", "OperationQueueItem", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class OperationRepo implements IOperationRepo, IStartableService {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000E\n\u0000\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\b\b\u0002\u0010\t\u001A\u00020\b¢\u0006\u0002\u0010\nJ\b\u0010\u0014\u001A\u00020\u0015H\u0016R\u0011\u0010\u0007\u001A\u00020\b¢\u0006\b\n\u0000\u001A\u0004\b\u000B\u0010\fR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u001A\u0010\t\u001A\u00020\bX\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000F\u0010\f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001A\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/onesignal/core/internal/operations/impl/OperationRepo$OperationQueueItem;", "", "operation", "Lcom/onesignal/core/internal/operations/Operation;", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "", "bucket", "", "retries", "(Lcom/onesignal/core/internal/operations/Operation;Lcom/onesignal/common/threading/WaiterWithValue;II)V", "getBucket", "()I", "getOperation", "()Lcom/onesignal/core/internal/operations/Operation;", "getRetries", "setRetries", "(I)V", "getWaiter", "()Lcom/onesignal/common/threading/WaiterWithValue;", "toString", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class OperationQueueItem {
        private final int bucket;
        private final Operation operation;
        private int retries;
        private final WaiterWithValue waiter;

        public OperationQueueItem(Operation operation0, WaiterWithValue waiterWithValue0, int v, int v1) {
            Intrinsics.checkNotNullParameter(operation0, "operation");
            super();
            this.operation = operation0;
            this.waiter = waiterWithValue0;
            this.bucket = v;
            this.retries = v1;
        }

        public OperationQueueItem(Operation operation0, WaiterWithValue waiterWithValue0, int v, int v1, int v2, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v2 & 2) != 0) {
                waiterWithValue0 = null;
            }
            if((v2 & 8) != 0) {
                v1 = 0;
            }
            this(operation0, waiterWithValue0, v, v1);
        }

        public final int getBucket() {
            return this.bucket;
        }

        public final Operation getOperation() {
            return this.operation;
        }

        public final int getRetries() {
            return this.retries;
        }

        public final WaiterWithValue getWaiter() {
            return this.waiter;
        }

        public final void setRetries(int v) {
            this.retries = v;
        }

        @Override
        public String toString() {
            return "bucket:" + this.bucket + ", retries:" + this.retries + ", operation:" + this.operation + '\n';
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[ExecutionResult.values().length];
            arr_v[ExecutionResult.SUCCESS.ordinal()] = 1;
            arr_v[ExecutionResult.FAIL_UNAUTHORIZED.ordinal()] = 2;
            arr_v[ExecutionResult.FAIL_NORETRY.ordinal()] = 3;
            arr_v[ExecutionResult.FAIL_CONFLICT.ordinal()] = 4;
            arr_v[ExecutionResult.SUCCESS_STARTING_ONLY.ordinal()] = 5;
            arr_v[ExecutionResult.FAIL_RETRY.ordinal()] = 6;
            arr_v[ExecutionResult.FAIL_PAUSE_OPREPO.ordinal()] = 7;
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    private final ConfigModelStore _configModelStore;
    private final OperationModelStore _operationModelStore;
    private final ITime _time;
    private int enqueueIntoBucket;
    private final Map executorsMap;
    private boolean paused;
    private final List queue;
    private final WaiterWithValue waiter;

    public OperationRepo(List list0, OperationModelStore operationModelStore0, ConfigModelStore configModelStore0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(list0, "executors");
        Intrinsics.checkNotNullParameter(operationModelStore0, "_operationModelStore");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._operationModelStore = operationModelStore0;
        this._configModelStore = configModelStore0;
        this._time = iTime0;
        this.queue = new ArrayList();
        this.waiter = new WaiterWithValue();
        Map map0 = new LinkedHashMap();
        for(Object object0: list0) {
            IOperationExecutor iOperationExecutor0 = (IOperationExecutor)object0;
            for(Object object1: iOperationExecutor0.getOperations()) {
                map0.put(((String)object1), iOperationExecutor0);
            }
        }
        this.executorsMap = map0;
        for(Object object2: this._operationModelStore.list()) {
            this.internalEnqueue(new OperationQueueItem(((Operation)object2), null, this.enqueueIntoBucket, 0, 10, null), false, false);
        }
    }

    @Override  // com.onesignal.core.internal.operations.IOperationRepo
    public boolean containsInstanceOf(KClass kClass0) {
        Intrinsics.checkNotNullParameter(kClass0, "type");
        synchronized(this.queue) {
            Iterable iterable0 = this.queue;
            boolean z = false;
            if(!(iterable0 instanceof Collection) || !((Collection)iterable0).isEmpty()) {
                for(Object object0: iterable0) {
                    if(kClass0.isInstance(((OperationQueueItem)object0).getOperation())) {
                        z = true;
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            return z;
        }
    }

    public final Object delayBeforeRetry(int v, Continuation continuation0) {
        if(((long)v) * 15000L < 1L) {
            return Unit.INSTANCE;
        }
        Logging.error$default(("Operations being delay for: " + ((long)v) * 15000L + " ms"), null, 2, null);
        Object object0 = DelayKt.delay(((long)v) * 15000L, continuation0);
        return object0 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? object0 : Unit.INSTANCE;
    }

    @Override  // com.onesignal.core.internal.operations.IOperationRepo
    public void enqueue(Operation operation0, boolean z) {
        Intrinsics.checkNotNullParameter(operation0, "operation");
        Logging.log(LogLevel.DEBUG, "OperationRepo.enqueue(operation: " + operation0 + ", flush: " + z + ')');
        Intrinsics.checkNotNullExpressionValue("c190bbc9-3a58-4c80-a6bf-2e11bac339ac", "randomUUID().toString()");
        operation0.setId("c190bbc9-3a58-4c80-a6bf-2e11bac339ac");
        this.internalEnqueue(new OperationQueueItem(operation0, null, this.enqueueIntoBucket, 0, 10, null), z, true);
    }

    @Override  // com.onesignal.core.internal.operations.IOperationRepo
    public Object enqueueAndWait(Operation operation0, boolean z, Continuation continuation0) {
        Logging.log(LogLevel.DEBUG, "OperationRepo.enqueueAndWait(operation: " + operation0 + ", force: " + z + ')');
        Intrinsics.checkNotNullExpressionValue("05e8842f-687b-47ab-a372-e15dd4208a63", "randomUUID().toString()");
        operation0.setId("05e8842f-687b-47ab-a372-e15dd4208a63");
        WaiterWithValue waiterWithValue0 = new WaiterWithValue();
        this.internalEnqueue(new OperationQueueItem(operation0, waiterWithValue0, this.enqueueIntoBucket, 0, 8, null), z, true);
        return waiterWithValue0.waitForWake(continuation0);
    }

    public final Object executeOperations$com_onesignal_core(List list0, Continuation continuation0) {
        ExecutionResponse executionResponse1;
        List list8;
        ExecutionResponse executionResponse0;
        OperationQueueItem operationRepo$OperationQueueItem1;
        OperationRepo operationRepo1;
        OperationRepo operationRepo0;
        Object object3;
        List list2;
        OperationQueueItem operationRepo$OperationQueueItem0;
        com.onesignal.core.internal.operations.impl.OperationRepo.executeOperations.1 operationRepo$executeOperations$10;
        List list1 = list0;
        if(continuation0 instanceof com.onesignal.core.internal.operations.impl.OperationRepo.executeOperations.1) {
            operationRepo$executeOperations$10 = (com.onesignal.core.internal.operations.impl.OperationRepo.executeOperations.1)continuation0;
            if((operationRepo$executeOperations$10.label & 0x80000000) == 0) {
                operationRepo$executeOperations$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
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
                        return continuation0.executeOperations$com_onesignal_core(null, this);
                    }
                };
            }
            else {
                operationRepo$executeOperations$10.label ^= 0x80000000;
            }
        }
        else {
            operationRepo$executeOperations$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
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
                    return continuation0.executeOperations$com_onesignal_core(null, this);
                }
            };
        }
        Object object0 = operationRepo$executeOperations$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    alab1:
        switch(operationRepo$executeOperations$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                try {
                    operationRepo$OperationQueueItem0 = (OperationQueueItem)CollectionsKt.first(list0);
                    String s = operationRepo$OperationQueueItem0.getOperation().getName();
                    IOperationExecutor iOperationExecutor0 = (IOperationExecutor)this.executorsMap.get(s);
                    if(iOperationExecutor0 == null) {
                        throw new Exception("Could not find executor for operation " + operationRepo$OperationQueueItem0.getOperation().getName());
                    }
                    ArrayList arrayList0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list1, 10));
                    for(Object object2: list1) {
                        arrayList0.add(((OperationQueueItem)object2).getOperation());
                    }
                    list2 = arrayList0;
                    operationRepo$executeOperations$10.L$0 = this;
                    operationRepo$executeOperations$10.L$1 = list1;
                    operationRepo$executeOperations$10.L$2 = operationRepo$OperationQueueItem0;
                    operationRepo$executeOperations$10.L$3 = list2;
                    operationRepo$executeOperations$10.label = 1;
                    object3 = iOperationExecutor0.execute(list2, operationRepo$executeOperations$10);
                }
                catch(Throwable throwable0) {
                    operationRepo0 = this;
                    goto label_200;
                }
                if(object3 == object1) {
                    return object1;
                }
                operationRepo1 = this;
                operationRepo$OperationQueueItem1 = operationRepo$OperationQueueItem0;
                object0 = object3;
                goto label_51;
            }
            case 1: {
                List list3 = (List)operationRepo$executeOperations$10.L$3;
                OperationQueueItem operationRepo$OperationQueueItem2 = (OperationQueueItem)operationRepo$executeOperations$10.L$2;
                List list4 = (List)operationRepo$executeOperations$10.L$1;
                operationRepo1 = (OperationRepo)operationRepo$executeOperations$10.L$0;
                try {
                    list1 = list4;
                    ResultKt.throwOnFailure(object0);
                    list2 = list3;
                    list1 = list4;
                    operationRepo$OperationQueueItem1 = operationRepo$OperationQueueItem2;
                label_51:
                    executionResponse0 = (ExecutionResponse)object0;
                    Logging.debug$default(("OperationRepo: execute response = " + executionResponse0.getResult()), null, 2, null);
                    if(executionResponse0.getIdTranslations() != null) {
                        for(Object object4: list1) {
                            ((OperationQueueItem)object4).getOperation().translateIds(executionResponse0.getIdTranslations());
                        }
                        synchronized(operationRepo1.queue) {
                            for(Object object5: operationRepo1.queue) {
                                ((OperationQueueItem)object5).getOperation().translateIds(executionResponse0.getIdTranslations());
                            }
                        }
                    }
                    switch(WhenMappings.$EnumSwitchMapping$0[executionResponse0.getResult().ordinal()]) {
                        case 1: {
                            for(Object object6: list1) {
                                String s1 = ((OperationQueueItem)object6).getOperation().getId();
                                DefaultImpls.remove$default(operationRepo1._operationModelStore, s1, null, 2, null);
                            }
                            for(Object object7: list1) {
                                WaiterWithValue waiterWithValue0 = ((OperationQueueItem)object7).getWaiter();
                                if(waiterWithValue0 != null) {
                                    waiterWithValue0.wake(Boxing.boxBoolean(true));
                                }
                            }
                            break;
                        }
                        case 2: 
                        case 3: 
                        case 4: {
                            Logging.error$default(("Operation execution failed without retry: " + list2), null, 2, null);
                            for(Object object8: list1) {
                                String s2 = ((OperationQueueItem)object8).getOperation().getId();
                                DefaultImpls.remove$default(operationRepo1._operationModelStore, s2, null, 2, null);
                            }
                            for(Object object9: list1) {
                                WaiterWithValue waiterWithValue1 = ((OperationQueueItem)object9).getWaiter();
                                if(waiterWithValue1 != null) {
                                    waiterWithValue1.wake(Boxing.boxBoolean(false));
                                }
                            }
                            break;
                        }
                        case 5: {
                            String s3 = operationRepo$OperationQueueItem1.getOperation().getId();
                            DefaultImpls.remove$default(operationRepo1._operationModelStore, s3, null, 2, null);
                            WaiterWithValue waiterWithValue2 = operationRepo$OperationQueueItem1.getWaiter();
                            if(waiterWithValue2 != null) {
                                waiterWithValue2.wake(Boxing.boxBoolean(true));
                            }
                            synchronized(operationRepo1.queue) {
                                Collection collection0 = new ArrayList();
                                for(Object object10: list1) {
                                    if(!Intrinsics.areEqual(((OperationQueueItem)object10), operationRepo$OperationQueueItem1) != 0) {
                                        collection0.add(object10);
                                    }
                                }
                                for(Object object11: CollectionsKt.reversed(((List)collection0))) {
                                    operationRepo1.queue.add(0, ((OperationQueueItem)object11));
                                }
                            }
                            break;
                        }
                        case 6: {
                            Logging.error$default(("Operation execution failed, retrying: " + list2), null, 2, null);
                            IntRef ref$IntRef0 = new IntRef();
                            synchronized(operationRepo1.queue) {
                                for(Object object12: CollectionsKt.reversed(list1)) {
                                    OperationQueueItem operationRepo$OperationQueueItem3 = (OperationQueueItem)object12;
                                    operationRepo$OperationQueueItem3.setRetries(operationRepo$OperationQueueItem3.getRetries() + 1);
                                    if(operationRepo$OperationQueueItem3.getRetries() > ref$IntRef0.element) {
                                        ref$IntRef0.element = operationRepo$OperationQueueItem3.getRetries();
                                    }
                                    operationRepo1.queue.add(0, operationRepo$OperationQueueItem3);
                                }
                            }
                            operationRepo$executeOperations$10.L$0 = operationRepo1;
                            operationRepo$executeOperations$10.L$1 = list1;
                            operationRepo$executeOperations$10.L$2 = executionResponse0;
                            operationRepo$executeOperations$10.L$3 = null;
                            operationRepo$executeOperations$10.label = 2;
                            if(operationRepo1.delayBeforeRetry(ref$IntRef0.element, operationRepo$executeOperations$10) == object1) {
                                return object1;
                            }
                            list8 = list1;
                            operationRepo0 = operationRepo1;
                            executionResponse1 = executionResponse0;
                            break alab1;
                        }
                        case 7: {
                            Logging.error$default(("Operation execution failed with eventual retry, pausing the operation repo: " + list2), null, 2, null);
                            operationRepo1.paused = true;
                            synchronized(operationRepo1.queue) {
                                for(Object object13: CollectionsKt.reversed(list1)) {
                                    operationRepo1.queue.add(0, ((OperationQueueItem)object13));
                                }
                            }
                        }
                    }
                    operationRepo0 = operationRepo1;
                    goto label_182;
                }
                catch(Throwable throwable0) {
                    operationRepo0 = operationRepo1;
                    goto label_200;
                }
            }
            case 2: {
                executionResponse1 = (ExecutionResponse)operationRepo$executeOperations$10.L$2;
                list8 = (List)operationRepo$executeOperations$10.L$1;
                operationRepo0 = (OperationRepo)operationRepo$executeOperations$10.L$0;
                try {
                    ResultKt.throwOnFailure(object0);
                    break;
                }
                catch(Throwable throwable0) {
                    list1 = list8;
                    goto label_200;
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            executionResponse0 = executionResponse1;
            list1 = list8;
        }
        catch(Throwable throwable0) {
            operationRepo0 = operationRepo1;
            goto label_200;
        }
        try {
        label_182:
            if(executionResponse0.getOperations() != null) {
                synchronized(operationRepo0.queue) {
                    for(Object object14: CollectionsKt.reversed(executionResponse0.getOperations())) {
                        Intrinsics.checkNotNullExpressionValue("63794e3b-3b61-48e5-a1cf-2a2e4f20cc53", "randomUUID().toString()");
                        ((Operation)object14).setId("63794e3b-3b61-48e5-a1cf-2a2e4f20cc53");
                        OperationQueueItem operationRepo$OperationQueueItem4 = new OperationQueueItem(((Operation)object14), null, 0, 0, 10, null);
                        operationRepo0.queue.add(0, operationRepo$OperationQueueItem4);
                        DefaultImpls.add$default(operationRepo0._operationModelStore, 0, operationRepo$OperationQueueItem4.getOperation(), null, 4, null);
                    }
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
        catch(Throwable throwable0) {
        }
    label_200:
        Logging.log(LogLevel.ERROR, "Error attempting to execute operation: " + list1, throwable0);
        for(Object object15: list1) {
            String s4 = ((OperationQueueItem)object15).getOperation().getId();
            DefaultImpls.remove$default(operationRepo0._operationModelStore, s4, null, 2, null);
        }
        for(Object object16: list1) {
            WaiterWithValue waiterWithValue3 = ((OperationQueueItem)object16).getWaiter();
            if(waiterWithValue3 != null) {
                waiterWithValue3.wake(Boxing.boxBoolean(false));
            }
        }
        return Unit.INSTANCE;
    }

    private final int getExecuteBucket() {
        return this.enqueueIntoBucket == 0 ? 0 : this.enqueueIntoBucket - 1;
    }

    private final List getGroupableOperations(OperationQueueItem operationRepo$OperationQueueItem0) {
        List list0 = new ArrayList();
        list0.add(operationRepo$OperationQueueItem0);
        if(operationRepo$OperationQueueItem0.getOperation().getGroupComparisonType() == GroupComparisonType.NONE) {
            return list0;
        }
        String s = operationRepo$OperationQueueItem0.getOperation().getGroupComparisonType() == GroupComparisonType.CREATE ? operationRepo$OperationQueueItem0.getOperation().getCreateComparisonKey() : operationRepo$OperationQueueItem0.getOperation().getModifyComparisonKey();
        if(!this.queue.isEmpty() != 0) {
            for(Object object0: CollectionsKt.toList(this.queue)) {
                OperationQueueItem operationRepo$OperationQueueItem1 = (OperationQueueItem)object0;
                String s1 = operationRepo$OperationQueueItem0.getOperation().getGroupComparisonType() == GroupComparisonType.CREATE ? operationRepo$OperationQueueItem1.getOperation().getCreateComparisonKey() : operationRepo$OperationQueueItem1.getOperation().getModifyComparisonKey();
                if(Intrinsics.areEqual(s1, "") && Intrinsics.areEqual(s, "")) {
                    throw new Exception("Both comparison keys can not be blank!");
                }
                if(Intrinsics.areEqual(s1, s)) {
                    this.queue.remove(operationRepo$OperationQueueItem1);
                    list0.add(operationRepo$OperationQueueItem1);
                }
            }
        }
        return list0;
    }

    public final List getNextOps$com_onesignal_core(int v) {
        List list1;
        Object object0 = null;
        synchronized(this.queue) {
            Iterator iterator0 = this.queue.iterator();
            while(true) {
                list1 = null;
                if(!iterator0.hasNext()) {
                    break;
                }
                Object object1 = iterator0.next();
                if(((OperationQueueItem)object1).getOperation().getCanStartExecute() && ((OperationQueueItem)object1).getBucket() <= v) {
                    object0 = object1;
                    break;
                }
            }
            if(((OperationQueueItem)object0) != null) {
                this.queue.remove(((OperationQueueItem)object0));
                list1 = this.getGroupableOperations(((OperationQueueItem)object0));
            }
            return list1;
        }
    }

    private final void internalEnqueue(OperationQueueItem operationRepo$OperationQueueItem0, boolean z, boolean z1) {
        synchronized(this.queue) {
            this.queue.add(operationRepo$OperationQueueItem0);
            if(z1) {
                DefaultImpls.add$default(this._operationModelStore, operationRepo$OperationQueueItem0.getOperation(), null, 2, null);
            }
        }
        this.waiter.wake(Boolean.valueOf(z));
    }

    private final Object processQueueForever(Continuation continuation0) {
        OperationRepo operationRepo0;
        com.onesignal.core.internal.operations.impl.OperationRepo.processQueueForever.1 operationRepo$processQueueForever$10;
        if(continuation0 instanceof com.onesignal.core.internal.operations.impl.OperationRepo.processQueueForever.1) {
            operationRepo$processQueueForever$10 = (com.onesignal.core.internal.operations.impl.OperationRepo.processQueueForever.1)continuation0;
            if((operationRepo$processQueueForever$10.label & 0x80000000) == 0) {
                operationRepo$processQueueForever$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.processQueueForever(this);
                    }
                };
            }
            else {
                operationRepo$processQueueForever$10.label ^= 0x80000000;
            }
        }
        else {
            operationRepo$processQueueForever$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.processQueueForever(this);
                }
            };
        }
        Object object0 = operationRepo$processQueueForever$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(operationRepo$processQueueForever$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                operationRepo$processQueueForever$10.L$0 = this;
                operationRepo$processQueueForever$10.label = 1;
                if(this.waitForNewOperationAndExecutionInterval(operationRepo$processQueueForever$10) == object1) {
                    return object1;
                }
                operationRepo0 = this;
                break;
            }
            case 1: {
                operationRepo0 = (OperationRepo)operationRepo$processQueueForever$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            case 2: {
                operationRepo0 = (OperationRepo)operationRepo$processQueueForever$10.L$0;
                ResultKt.throwOnFailure(object0);
                goto label_41;
            }
            case 3: {
                operationRepo0 = (OperationRepo)operationRepo$processQueueForever$10.L$0;
                ResultKt.throwOnFailure(object0);
                goto label_31;
            }
            case 4: {
                operationRepo0 = (OperationRepo)operationRepo$processQueueForever$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        do {
            ++operationRepo0.enqueueIntoBucket;
            while(true) {
            label_31:
                if(operationRepo0.paused) {
                    Logging.debug$default("OperationRepo is paused", null, 2, null);
                    return Unit.INSTANCE;
                }
                List list0 = operationRepo0.getNextOps$com_onesignal_core(operationRepo0.getExecuteBucket());
                Logging.debug$default(("processQueueForever:ops:\n" + list0), null, 2, null);
                if(list0 == null) {
                    break;
                }
                operationRepo$processQueueForever$10.L$0 = operationRepo0;
                operationRepo$processQueueForever$10.label = 2;
                if(operationRepo0.executeOperations$com_onesignal_core(list0, operationRepo$processQueueForever$10) == object1) {
                    return object1;
                }
            label_41:
                long v = ((ConfigModel)operationRepo0._configModelStore.getModel()).getOpRepoPostWakeDelay();
                operationRepo$processQueueForever$10.L$0 = operationRepo0;
                operationRepo$processQueueForever$10.label = 3;
                if(DelayKt.delay(v, operationRepo$processQueueForever$10) != object1) {
                    continue;
                }
                return object1;
            }
            operationRepo$processQueueForever$10.L$0 = operationRepo0;
            operationRepo$processQueueForever$10.label = 4;
        }
        while(operationRepo0.waitForNewOperationAndExecutionInterval(operationRepo$processQueueForever$10) != object1);
        return object1;
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this.paused = false;
        ThreadUtilsKt.suspendifyOnThread$default("OpRepo", 0, new Function1(null) {
            int label;

            {
                OperationRepo.this = operationRepo0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.core.internal.operations.impl.OperationRepo.start.1(OperationRepo.this, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.core.internal.operations.impl.OperationRepo.start.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        this.label = 1;
                        return OperationRepo.this.processQueueForever(this) == object1 ? object1 : Unit.INSTANCE;
                    }
                    case 1: {
                        ResultKt.throwOnFailure(object0);
                        return Unit.INSTANCE;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 2, null);
    }

    private final Object waitForNewOperationAndExecutionInterval(Continuation continuation0) {
        long v1;
        OperationRepo operationRepo1;
        BooleanRef ref$BooleanRef2;
        long v;
        BooleanRef ref$BooleanRef1;
        OperationRepo operationRepo0;
        BooleanRef ref$BooleanRef0;
        com.onesignal.core.internal.operations.impl.OperationRepo.waitForNewOperationAndExecutionInterval.1 operationRepo$waitForNewOperationAndExecutionInterval$10;
        if(continuation0 instanceof com.onesignal.core.internal.operations.impl.OperationRepo.waitForNewOperationAndExecutionInterval.1) {
            operationRepo$waitForNewOperationAndExecutionInterval$10 = (com.onesignal.core.internal.operations.impl.OperationRepo.waitForNewOperationAndExecutionInterval.1)continuation0;
            if((operationRepo$waitForNewOperationAndExecutionInterval$10.label & 0x80000000) == 0) {
                operationRepo$waitForNewOperationAndExecutionInterval$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    long J$0;
                    long J$1;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.waitForNewOperationAndExecutionInterval(this);
                    }
                };
            }
            else {
                operationRepo$waitForNewOperationAndExecutionInterval$10.label ^= 0x80000000;
            }
        }
        else {
            operationRepo$waitForNewOperationAndExecutionInterval$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                long J$0;
                long J$1;
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.waitForNewOperationAndExecutionInterval(this);
                }
            };
        }
        Object object0 = operationRepo$waitForNewOperationAndExecutionInterval$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(operationRepo$waitForNewOperationAndExecutionInterval$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                ref$BooleanRef0 = new BooleanRef();
                operationRepo$waitForNewOperationAndExecutionInterval$10.L$0 = this;
                operationRepo$waitForNewOperationAndExecutionInterval$10.L$1 = ref$BooleanRef0;
                operationRepo$waitForNewOperationAndExecutionInterval$10.L$2 = ref$BooleanRef0;
                operationRepo$waitForNewOperationAndExecutionInterval$10.label = 1;
                object0 = this.waiter.waitForWake(operationRepo$waitForNewOperationAndExecutionInterval$10);
                if(object0 == object1) {
                    return object1;
                }
                operationRepo0 = this;
                ref$BooleanRef1 = ref$BooleanRef0;
                goto label_28;
            }
            case 1: {
                ref$BooleanRef0 = (BooleanRef)operationRepo$waitForNewOperationAndExecutionInterval$10.L$2;
                ref$BooleanRef1 = (BooleanRef)operationRepo$waitForNewOperationAndExecutionInterval$10.L$1;
                operationRepo0 = (OperationRepo)operationRepo$waitForNewOperationAndExecutionInterval$10.L$0;
                ResultKt.throwOnFailure(object0);
            label_28:
                ref$BooleanRef0.element = ((Boolean)object0).booleanValue();
                v = operationRepo0._time.getCurrentTimeMillis();
                ref$BooleanRef2 = ref$BooleanRef1;
                operationRepo1 = operationRepo0;
                v1 = ((ConfigModel)operationRepo0._configModelStore.getModel()).getOpRepoExecutionInterval();
                goto label_41;
            }
            case 2: {
                v1 = operationRepo$waitForNewOperationAndExecutionInterval$10.J$1;
                v = operationRepo$waitForNewOperationAndExecutionInterval$10.J$0;
                ref$BooleanRef2 = (BooleanRef)operationRepo$waitForNewOperationAndExecutionInterval$10.L$1;
                operationRepo1 = (OperationRepo)operationRepo$waitForNewOperationAndExecutionInterval$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            v1 -= operationRepo1._time.getCurrentTimeMillis() - v;
            v = operationRepo1._time.getCurrentTimeMillis();
        label_41:
            if(ref$BooleanRef2.element || v1 <= 0L) {
                break;
            }
            com.onesignal.core.internal.operations.impl.OperationRepo.waitForNewOperationAndExecutionInterval.2 operationRepo$waitForNewOperationAndExecutionInterval$20 = new Function2(operationRepo1, null) {
                final BooleanRef $force;
                Object L$0;
                int label;

                {
                    this.$force = ref$BooleanRef0;
                    OperationRepo.this = operationRepo0;
                    super(2, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object object0, Continuation continuation0) {
                    return new com.onesignal.core.internal.operations.impl.OperationRepo.waitForNewOperationAndExecutionInterval.2(this.$force, OperationRepo.this, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function2
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.onesignal.core.internal.operations.impl.OperationRepo.waitForNewOperationAndExecutionInterval.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    BooleanRef ref$BooleanRef1;
                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(object0);
                            BooleanRef ref$BooleanRef0 = this.$force;
                            this.L$0 = ref$BooleanRef0;
                            this.label = 1;
                            Object object2 = OperationRepo.this.waiter.waitForWake(this);
                            if(object2 == object1) {
                                return object1;
                            }
                            ref$BooleanRef1 = ref$BooleanRef0;
                            object0 = object2;
                            break;
                        }
                        case 1: {
                            ref$BooleanRef1 = (BooleanRef)this.L$0;
                            ResultKt.throwOnFailure(object0);
                            break;
                        }
                        default: {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                    }
                    ref$BooleanRef1.element = ((Boolean)object0).booleanValue();
                    return Unit.INSTANCE;
                }
            };
            operationRepo$waitForNewOperationAndExecutionInterval$10.L$0 = operationRepo1;
            operationRepo$waitForNewOperationAndExecutionInterval$10.L$1 = ref$BooleanRef2;
            operationRepo$waitForNewOperationAndExecutionInterval$10.L$2 = null;
            operationRepo$waitForNewOperationAndExecutionInterval$10.J$0 = v;
            operationRepo$waitForNewOperationAndExecutionInterval$10.J$1 = v1;
            operationRepo$waitForNewOperationAndExecutionInterval$10.label = 2;
            if(TimeoutKt.withTimeoutOrNull(v1, operationRepo$waitForNewOperationAndExecutionInterval$20, operationRepo$waitForNewOperationAndExecutionInterval$10) != object1) {
                continue;
            }
            return object1;
        }
        return Unit.INSTANCE;
    }
}

