package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationServices;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.common.threading.Waiter;
import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0002\u001E\u001FB\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0016\u001A\u0004\u0018\u00010\u000FH\u0016J\u0011\u0010\u0017\u001A\u00020\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001A\u00020\u001AH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u0007H\u0016J\u0010\u0010\u001D\u001A\u00020\u001A2\u0006\u0010\u001C\u001A\u00020\u0007H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001A\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0010\u0010\f\u001A\u0004\u0018\u00010\rX\u0082\u000E¢\u0006\u0002\n\u0000R\u0010\u0010\u000E\u001A\u0004\u0018\u00010\u000FX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001A\u0004\u0018\u00010\u0013X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/onesignal/location/internal/controller/impl/HmsLocationController;", "Lcom/onesignal/location/internal/controller/ILocationController;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "event", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/location/internal/controller/ILocationUpdatedHandler;", "hasSubscribers", "", "getHasSubscribers", "()Z", "hmsFusedLocationClient", "Lcom/huawei/hms/location/FusedLocationProviderClient;", "lastLocation", "Landroid/location/Location;", "locationHandlerThread", "Lcom/onesignal/location/internal/controller/impl/HmsLocationController$LocationHandlerThread;", "locationUpdateListener", "Lcom/onesignal/location/internal/controller/impl/HmsLocationController$LocationUpdateListener;", "startStopMutex", "Lkotlinx/coroutines/sync/Mutex;", "getLastLocation", "start", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "", "subscribe", "handler", "unsubscribe", "LocationHandlerThread", "LocationUpdateListener", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class HmsLocationController implements ILocationController {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/HmsLocationController$LocationHandlerThread;", "Landroid/os/HandlerThread;", "()V", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class LocationHandlerThread extends HandlerThread {
        private Handler mHandler;

        public LocationHandlerThread() {
            super("OSH_LocationHandlerThread");
            this.start();
            this.mHandler = new Handler(this.getLooper());
        }

        public final Handler getMHandler() {
            return this.mHandler;
        }

        public final void setMHandler(Handler handler0) {
            Intrinsics.checkNotNullParameter(handler0, "<set-?>");
            this.mHandler = handler0;
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001D\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\r\u001A\u00020\u000EH\u0016J\b\u0010\u000F\u001A\u00020\u000EH\u0016J\u0010\u0010\u0010\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0012H\u0016J\b\u0010\u0013\u001A\u00020\u000EH\u0016J\b\u0010\u0014\u001A\u00020\u000EH\u0002R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/HmsLocationController$LocationUpdateListener;", "Lcom/huawei/hms/location/LocationCallback;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "Ljava/io/Closeable;", "_parent", "Lcom/onesignal/location/internal/controller/impl/HmsLocationController;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "huaweiFusedLocationProviderClient", "Lcom/huawei/hms/location/FusedLocationProviderClient;", "(Lcom/onesignal/location/internal/controller/impl/HmsLocationController;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/huawei/hms/location/FusedLocationProviderClient;)V", "hasExistingRequest", "", "close", "", "onFocus", "onLocationResult", "locationResult", "Lcom/huawei/hms/location/LocationResult;", "onUnfocused", "refreshRequest", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class LocationUpdateListener extends LocationCallback implements IApplicationLifecycleHandler, Closeable {
        private final IApplicationService _applicationService;
        private final HmsLocationController _parent;
        private boolean hasExistingRequest;
        private final FusedLocationProviderClient huaweiFusedLocationProviderClient;

        public LocationUpdateListener(HmsLocationController hmsLocationController0, IApplicationService iApplicationService0, FusedLocationProviderClient fusedLocationProviderClient0) {
            Intrinsics.checkNotNullParameter(hmsLocationController0, "_parent");
            Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
            Intrinsics.checkNotNullParameter(fusedLocationProviderClient0, "huaweiFusedLocationProviderClient");
            super();
            this._parent = hmsLocationController0;
            this._applicationService = iApplicationService0;
            this.huaweiFusedLocationProviderClient = fusedLocationProviderClient0;
            iApplicationService0.addApplicationLifecycleHandler(this);
            this.refreshRequest();
        }

        @Override
        public void close() {
            this._applicationService.removeApplicationLifecycleHandler(this);
            if(this.hasExistingRequest) {
                this.huaweiFusedLocationProviderClient.removeLocationUpdates(this);
            }
        }

        @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
        public void onFocus() {
            Logging.log(LogLevel.DEBUG, "LocationUpdateListener.onFocus()");
            this.refreshRequest();
        }

        public void onLocationResult(LocationResult locationResult0) {
            Intrinsics.checkNotNullParameter(locationResult0, "locationResult");
            Logging.debug$default(("HMSLocationController onLocationResult: " + locationResult0), null, 2, null);
            Location location0 = locationResult0.getLastLocation();
            this._parent.lastLocation = location0;
        }

        @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
        public void onUnfocused() {
            Logging.log(LogLevel.DEBUG, "LocationUpdateListener.onUnfocused()");
            this.refreshRequest();
        }

        private final void refreshRequest() {
            if(this.hasExistingRequest) {
                this.huaweiFusedLocationProviderClient.removeLocationUpdates(this);
            }
            long v = this._applicationService.isInForeground() ? 270000L : 570000L;
            LocationRequest locationRequest0 = LocationRequest.create().setFastestInterval(v).setInterval(v).setMaxWaitTime(((long)(((double)v) * 1.5))).setPriority(102);
            Logging.debug$default("HMSLocationController Huawei LocationServices requestLocationUpdates!", null, 2, null);
            Looper looper0 = this._parent.locationHandlerThread.getLooper();
            this.huaweiFusedLocationProviderClient.requestLocationUpdates(locationRequest0, this, looper0);
            this.hasExistingRequest = true;
        }
    }

    private final IApplicationService _applicationService;
    private final EventProducer event;
    private FusedLocationProviderClient hmsFusedLocationClient;
    private Location lastLocation;
    private final LocationHandlerThread locationHandlerThread;
    private LocationUpdateListener locationUpdateListener;
    private final Mutex startStopMutex;

    public HmsLocationController(IApplicationService iApplicationService0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        super();
        this._applicationService = iApplicationService0;
        this.locationHandlerThread = new LocationHandlerThread();
        this.startStopMutex = MutexKt.Mutex$default(false, 1, null);
        this.event = new EventProducer();
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.event.getHasSubscribers();
    }

    @Override  // com.onesignal.location.internal.controller.ILocationController
    public Location getLastLocation() {
        FusedLocationProviderClient fusedLocationProviderClient0 = this.hmsFusedLocationClient;
        if(fusedLocationProviderClient0 == null) {
            return null;
        }
        ObjectRef ref$ObjectRef0 = new ObjectRef();
        ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(ref$ObjectRef0, null) {
            final FusedLocationProviderClient $locationClient;
            final ObjectRef $retVal;
            int label;

            public static void $r8$lambda$JaO3AQXpIVKGWpWcJkUEDdPtq0g(ObjectRef ref$ObjectRef0, ObjectRef ref$ObjectRef1, Location location0) {
                com.onesignal.location.internal.controller.impl.HmsLocationController.getLastLocation.1.invokeSuspend$lambda-0(ref$ObjectRef0, ref$ObjectRef1, location0);
            }

            public static void $r8$lambda$c8sOnZNQs8AIMKD74xjynyC0vjE(ObjectRef ref$ObjectRef0, Exception exception0) {
                com.onesignal.location.internal.controller.impl.HmsLocationController.getLastLocation.1.invokeSuspend$lambda-1(ref$ObjectRef0, exception0);
            }

            {
                this.$locationClient = fusedLocationProviderClient0;
                this.$retVal = ref$ObjectRef0;
                super(1, continuation0);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation create(Continuation continuation0) {
                return new com.onesignal.location.internal.controller.impl.HmsLocationController.getLastLocation.1(this.$locationClient, this.$retVal, continuation0);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                return this.invoke(((Continuation)object0));
            }

            public final Object invoke(Continuation continuation0) {
                return ((com.onesignal.location.internal.controller.impl.HmsLocationController.getLastLocation.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
            }

            @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object object0) {
                Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch(this.label) {
                    case 0: {
                        ResultKt.throwOnFailure(object0);
                        ObjectRef ref$ObjectRef0 = new ObjectRef();
                        ref$ObjectRef0.element = new Waiter();
                        this.$locationClient.getLastLocation().addOnSuccessListener(new HmsLocationController.getLastLocation.1..ExternalSyntheticLambda0(ref$ObjectRef0, this.$retVal)).addOnFailureListener(new HmsLocationController.getLastLocation.1..ExternalSyntheticLambda1(ref$ObjectRef0));
                        this.label = 1;
                        return ((Waiter)ref$ObjectRef0.element).waitForWake(this) == object1 ? object1 : Unit.INSTANCE;
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

            private static final void invokeSuspend$lambda-0(ObjectRef ref$ObjectRef0, ObjectRef ref$ObjectRef1, Location location0) {
                Logging.warn$default(("Huawei LocationServices getLastLocation returned location: " + location0), null, 2, null);
                if(location0 == null) {
                    ((Waiter)ref$ObjectRef0.element).wake();
                    return;
                }
                ref$ObjectRef1.element = location0;
                ((Waiter)ref$ObjectRef0.element).wake();
            }

            private static final void invokeSuspend$lambda-1(ObjectRef ref$ObjectRef0, Exception exception0) {
                Logging.error("Huawei LocationServices getLastLocation failed!", exception0);
                ((Waiter)ref$ObjectRef0.element).wake();
            }
        }, 1, null);
        return (Location)ref$ObjectRef0.element;
    }

    @Override  // com.onesignal.location.internal.controller.ILocationController
    public Object start(Continuation continuation0) {
        com.onesignal.location.internal.controller.impl.HmsLocationController.start.1 hmsLocationController$start$10;
        if(continuation0 instanceof com.onesignal.location.internal.controller.impl.HmsLocationController.start.1) {
            hmsLocationController$start$10 = (com.onesignal.location.internal.controller.impl.HmsLocationController.start.1)continuation0;
            if((hmsLocationController$start$10.label & 0x80000000) == 0) {
                hmsLocationController$start$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.start(this);
                    }
                };
            }
            else {
                hmsLocationController$start$10.label ^= 0x80000000;
            }
        }
        else {
            hmsLocationController$start$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.start(this);
                }
            };
        }
        Object object0 = hmsLocationController$start$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(hmsLocationController$start$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                ObjectRef ref$ObjectRef0 = new ObjectRef();
                ref$ObjectRef0.element = this;
                BooleanRef ref$BooleanRef0 = new BooleanRef();
                com.onesignal.location.internal.controller.impl.HmsLocationController.start.2 hmsLocationController$start$20 = new Function2(ref$BooleanRef0, ref$ObjectRef0, null) {
                    final ObjectRef $self;
                    final BooleanRef $wasSuccessful;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    int label;

                    public static void $r8$lambda$9DV1FMM1G9A5DhFJn7rtZhvC1AI(ObjectRef ref$ObjectRef0, HmsLocationController hmsLocationController0, Location location0) {
                        com.onesignal.location.internal.controller.impl.HmsLocationController.start.2.invokeSuspend$lambda-2$lambda-0(ref$ObjectRef0, hmsLocationController0, location0);
                    }

                    public static void $r8$lambda$lb6mudckZX3WjMlIYcESt_YcLG8(ObjectRef ref$ObjectRef0, Exception exception0) {
                        com.onesignal.location.internal.controller.impl.HmsLocationController.start.2.invokeSuspend$lambda-2$lambda-1(ref$ObjectRef0, exception0);
                    }

                    {
                        HmsLocationController.this = hmsLocationController0;
                        this.$wasSuccessful = ref$BooleanRef0;
                        this.$self = ref$ObjectRef0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.location.internal.controller.impl.HmsLocationController.start.2(HmsLocationController.this, this.$wasSuccessful, this.$self, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.location.internal.controller.impl.HmsLocationController.start.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        HmsLocationController hmsLocationController2;
                        BooleanRef ref$BooleanRef3;
                        BooleanRef ref$BooleanRef2;
                        ObjectRef ref$ObjectRef3;
                        Throwable throwable1;
                        Mutex mutex2;
                        Object object2;
                        ObjectRef ref$ObjectRef1;
                        HmsLocationController hmsLocationController1;
                        BooleanRef ref$BooleanRef1;
                        Mutex mutex0;
                        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch(this.label) {
                            case 0: {
                                ResultKt.throwOnFailure(object0);
                                mutex0 = HmsLocationController.this.startStopMutex;
                                HmsLocationController hmsLocationController0 = HmsLocationController.this;
                                BooleanRef ref$BooleanRef0 = this.$wasSuccessful;
                                ObjectRef ref$ObjectRef0 = this.$self;
                                this.L$0 = mutex0;
                                this.L$1 = hmsLocationController0;
                                this.L$2 = ref$BooleanRef0;
                                this.L$3 = ref$ObjectRef0;
                                this.label = 1;
                                if(mutex0.lock(null, this) == object1) {
                                    return object1;
                                }
                                ref$BooleanRef1 = ref$BooleanRef0;
                                hmsLocationController1 = hmsLocationController0;
                                ref$ObjectRef1 = ref$ObjectRef0;
                                goto label_25;
                            }
                            case 1: {
                                ref$ObjectRef1 = (ObjectRef)this.L$3;
                                ref$BooleanRef1 = (BooleanRef)this.L$2;
                                hmsLocationController1 = (HmsLocationController)this.L$1;
                                Mutex mutex1 = (Mutex)this.L$0;
                                ResultKt.throwOnFailure(object0);
                                mutex0 = mutex1;
                            label_25:
                                if(hmsLocationController1.hmsFusedLocationClient == null) {
                                    try {
                                        try {
                                            hmsLocationController1.hmsFusedLocationClient = LocationServices.getFusedLocationProviderClient(hmsLocationController1._applicationService.getAppContext());
                                        }
                                        catch(Exception exception0) {
                                            Logging.error$default(("Huawei LocationServices getFusedLocationProviderClient failed! " + exception0), null, 2, null);
                                            ref$BooleanRef1.element = false;
                                            goto label_79;
                                        }
                                    label_32:
                                        if(hmsLocationController1.lastLocation == null) {
                                            ObjectRef ref$ObjectRef2 = new ObjectRef();
                                            ref$ObjectRef2.element = new WaiterWithValue();
                                            FusedLocationProviderClient fusedLocationProviderClient0 = hmsLocationController1.hmsFusedLocationClient;
                                            Intrinsics.checkNotNull(fusedLocationProviderClient0);
                                            fusedLocationProviderClient0.getLastLocation().addOnSuccessListener(new HmsLocationController.start.2..ExternalSyntheticLambda0(ref$ObjectRef2, hmsLocationController1)).addOnFailureListener(new HmsLocationController.start.2..ExternalSyntheticLambda1(ref$ObjectRef2));
                                            this.L$0 = mutex0;
                                            this.L$1 = hmsLocationController1;
                                            this.L$2 = ref$BooleanRef1;
                                            this.L$3 = ref$ObjectRef1;
                                            this.L$4 = ref$BooleanRef1;
                                            this.label = 2;
                                            object2 = ((WaiterWithValue)ref$ObjectRef2.element).waitForWake(this);
                                            goto label_52;
                                        }
                                        else {
                                            hmsLocationController1.event.fire(new Function1() {
                                                {
                                                    HmsLocationController.this = hmsLocationController0;
                                                    super(1);
                                                }

                                                @Override  // kotlin.jvm.functions.Function1
                                                public Object invoke(Object object0) {
                                                    this.invoke(((ILocationUpdatedHandler)object0));
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(ILocationUpdatedHandler iLocationUpdatedHandler0) {
                                                    Intrinsics.checkNotNullParameter(iLocationUpdatedHandler0, "it");
                                                    Location location0 = HmsLocationController.this.lastLocation;
                                                    Intrinsics.checkNotNull(location0);
                                                    iLocationUpdatedHandler0.onLocationChanged(location0);
                                                }
                                            });
                                        }
                                        goto label_79;
                                    }
                                    catch(Throwable throwable0) {
                                    }
                                }
                                else {
                                    goto label_32;
                                }
                                mutex2 = mutex0;
                                throwable1 = throwable0;
                                mutex2.unlock(null);
                                throw throwable1;
                            label_52:
                                if(object2 == object1) {
                                    return object1;
                                }
                                mutex2 = mutex0;
                                object0 = object2;
                                ref$ObjectRef3 = ref$ObjectRef1;
                                ref$BooleanRef2 = ref$BooleanRef1;
                                ref$BooleanRef3 = ref$BooleanRef2;
                                hmsLocationController2 = hmsLocationController1;
                                goto label_67;
                            }
                            case 2: {
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        ref$BooleanRef2 = (BooleanRef)this.L$4;
                        ref$ObjectRef3 = (ObjectRef)this.L$3;
                        ref$BooleanRef3 = (BooleanRef)this.L$2;
                        hmsLocationController2 = (HmsLocationController)this.L$1;
                        mutex2 = (Mutex)this.L$0;
                        try {
                            ResultKt.throwOnFailure(object0);
                        label_67:
                            ref$BooleanRef2.element = ((Boolean)object0).booleanValue();
                            if(ref$BooleanRef3.element) {
                                hmsLocationController2.event.fire(new Function1() {
                                    {
                                        HmsLocationController.this = hmsLocationController0;
                                        super(1);
                                    }

                                    @Override  // kotlin.jvm.functions.Function1
                                    public Object invoke(Object object0) {
                                        this.invoke(((ILocationUpdatedHandler)object0));
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(ILocationUpdatedHandler iLocationUpdatedHandler0) {
                                        Intrinsics.checkNotNullParameter(iLocationUpdatedHandler0, "it");
                                        Location location0 = HmsLocationController.this.lastLocation;
                                        Intrinsics.checkNotNull(location0);
                                        iLocationUpdatedHandler0.onLocationChanged(location0);
                                    }
                                });
                                HmsLocationController hmsLocationController3 = (HmsLocationController)ref$ObjectRef3.element;
                                FusedLocationProviderClient fusedLocationProviderClient1 = hmsLocationController2.hmsFusedLocationClient;
                                Intrinsics.checkNotNull(fusedLocationProviderClient1);
                                hmsLocationController2.locationUpdateListener = new LocationUpdateListener(hmsLocationController3, hmsLocationController2._applicationService, fusedLocationProviderClient1);
                            }
                            mutex0 = mutex2;
                        }
                        catch(Throwable throwable1) {
                            mutex2.unlock(null);
                            throw throwable1;
                        }
                    label_79:
                        mutex0.unlock(null);
                        return Unit.INSTANCE;
                    }

                    private static final void invokeSuspend$lambda-2$lambda-0(ObjectRef ref$ObjectRef0, HmsLocationController hmsLocationController0, Location location0) {
                        Logging.warn$default(("Huawei LocationServices getLastLocation returned location: " + location0), null, 2, null);
                        if(location0 == null) {
                            ((WaiterWithValue)ref$ObjectRef0.element).wake(Boolean.FALSE);
                            return;
                        }
                        hmsLocationController0.lastLocation = location0;
                        ((WaiterWithValue)ref$ObjectRef0.element).wake(Boolean.TRUE);
                    }

                    private static final void invokeSuspend$lambda-2$lambda-1(ObjectRef ref$ObjectRef0, Exception exception0) {
                        Logging.error("Huawei LocationServices getLastLocation failed!", exception0);
                        ((WaiterWithValue)ref$ObjectRef0.element).wake(Boolean.FALSE);
                    }
                };
                hmsLocationController$start$10.L$0 = ref$BooleanRef0;
                hmsLocationController$start$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), hmsLocationController$start$20, hmsLocationController$start$10) == object1 ? object1 : Boxing.boxBoolean(ref$BooleanRef0.element);
            }
            case 1: {
                BooleanRef ref$BooleanRef1 = (BooleanRef)hmsLocationController$start$10.L$0;
                ResultKt.throwOnFailure(object0);
                return Boxing.boxBoolean(ref$BooleanRef1.element);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.location.internal.controller.ILocationController
    public Object stop(Continuation continuation0) {
        Mutex mutex1;
        HmsLocationController hmsLocationController0;
        com.onesignal.location.internal.controller.impl.HmsLocationController.stop.1 hmsLocationController$stop$10;
        if(continuation0 instanceof com.onesignal.location.internal.controller.impl.HmsLocationController.stop.1) {
            hmsLocationController$stop$10 = (com.onesignal.location.internal.controller.impl.HmsLocationController.stop.1)continuation0;
            if((hmsLocationController$stop$10.label & 0x80000000) == 0) {
                hmsLocationController$stop$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.stop(this);
                    }
                };
            }
            else {
                hmsLocationController$stop$10.label ^= 0x80000000;
            }
        }
        else {
            hmsLocationController$stop$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.stop(this);
                }
            };
        }
        Object object0 = hmsLocationController$stop$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(hmsLocationController$stop$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Mutex mutex0 = this.startStopMutex;
                hmsLocationController$stop$10.L$0 = this;
                hmsLocationController$stop$10.L$1 = mutex0;
                hmsLocationController$stop$10.label = 1;
                if(mutex0.lock(null, hmsLocationController$stop$10) == object1) {
                    return object1;
                }
                hmsLocationController0 = this;
                mutex1 = mutex0;
                break;
            }
            case 1: {
                mutex1 = (Mutex)hmsLocationController$stop$10.L$1;
                hmsLocationController0 = (HmsLocationController)hmsLocationController$stop$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            LocationUpdateListener hmsLocationController$LocationUpdateListener0 = hmsLocationController0.locationUpdateListener;
            if(hmsLocationController$LocationUpdateListener0 != null) {
                Intrinsics.checkNotNull(hmsLocationController$LocationUpdateListener0);
                hmsLocationController$LocationUpdateListener0.close();
                hmsLocationController0.locationUpdateListener = null;
            }
            if(hmsLocationController0.hmsFusedLocationClient != null) {
                hmsLocationController0.hmsFusedLocationClient = null;
            }
            hmsLocationController0.lastLocation = null;
            return Unit.INSTANCE;
        }
        finally {
            mutex1.unlock(null);
        }
    }

    public void subscribe(ILocationUpdatedHandler iLocationUpdatedHandler0) {
        Intrinsics.checkNotNullParameter(iLocationUpdatedHandler0, "handler");
        this.event.subscribe(iLocationUpdatedHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void subscribe(Object object0) {
        this.subscribe(((ILocationUpdatedHandler)object0));
    }

    public void unsubscribe(ILocationUpdatedHandler iLocationUpdatedHandler0) {
        Intrinsics.checkNotNullParameter(iLocationUpdatedHandler0, "handler");
        this.event.unsubscribe(iLocationUpdatedHandler0);
    }

    @Override  // com.onesignal.common.events.IEventNotifier
    public void unsubscribe(Object object0) {
        this.unsubscribe(((ILocationUpdatedHandler)object0));
    }
}

