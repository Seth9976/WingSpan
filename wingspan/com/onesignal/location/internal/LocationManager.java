package com.onesignal.location.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.onesignal.common.AndroidUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.LogLevel;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.ILocationManager;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.common.LocationUtils;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.permissions.ILocationPermissionChangedHandler;
import com.onesignal.location.internal.permissions.LocationPermissionController;
import java.util.List;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B-\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B\u0012\u0006\u0010\f\u001A\u00020\r¢\u0006\u0002\u0010\u000EJ\u0019\u0010\u0016\u001A\u00020\u00102\u0006\u0010\u0017\u001A\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0010H\u0016J\u0011\u0010\u001C\u001A\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001DJ\b\u0010\u001E\u001A\u00020\u001AH\u0016J\u0011\u0010\u001F\u001A\u00020\u001AH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001DR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0010X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00108V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/onesignal/location/internal/LocationManager;", "Lcom/onesignal/location/ILocationManager;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/location/internal/permissions/ILocationPermissionChangedHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_capturer", "Lcom/onesignal/location/internal/capture/ILocationCapturer;", "_locationController", "Lcom/onesignal/location/internal/controller/ILocationController;", "_locationPermissionController", "Lcom/onesignal/location/internal/permissions/LocationPermissionController;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/location/internal/capture/ILocationCapturer;Lcom/onesignal/location/internal/controller/ILocationController;Lcom/onesignal/location/internal/permissions/LocationPermissionController;Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "_isShared", "", "value", "isShared", "()Z", "setShared", "(Z)V", "backgroundLocationPermissionLogic", "fallbackToSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLocationPermissionChanged", "", "enabled", "requestPermission", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "startGetLocation", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LocationManager implements IStartableService, ILocationManager, ILocationPermissionChangedHandler {
    private final IApplicationService _applicationService;
    private final ILocationCapturer _capturer;
    private boolean _isShared;
    private final ILocationController _locationController;
    private final LocationPermissionController _locationPermissionController;
    private final IPreferencesService _prefs;

    public LocationManager(IApplicationService iApplicationService0, ILocationCapturer iLocationCapturer0, ILocationController iLocationController0, LocationPermissionController locationPermissionController0, IPreferencesService iPreferencesService0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iLocationCapturer0, "_capturer");
        Intrinsics.checkNotNullParameter(iLocationController0, "_locationController");
        Intrinsics.checkNotNullParameter(locationPermissionController0, "_locationPermissionController");
        Intrinsics.checkNotNullParameter(iPreferencesService0, "_prefs");
        super();
        this._applicationService = iApplicationService0;
        this._capturer = iLocationCapturer0;
        this._locationController = iLocationController0;
        this._locationPermissionController = locationPermissionController0;
        this._prefs = iPreferencesService0;
        Boolean boolean0 = iPreferencesService0.getBool("OneSignal", "OS_LOCATION_SHARED", Boolean.FALSE);
        Intrinsics.checkNotNull(boolean0);
        this._isShared = boolean0.booleanValue();
    }

    private final Object backgroundLocationPermissionLogic(boolean z, Continuation continuation0) {
        return AndroidUtils.INSTANCE.hasPermission("android.permission.ACCESS_BACKGROUND_LOCATION", false, this._applicationService) ? this._locationPermissionController.prompt(z, "android.permission.ACCESS_BACKGROUND_LOCATION", continuation0) : Boxing.boxBoolean(true);
    }

    @Override  // com.onesignal.location.ILocationManager
    public boolean isShared() {
        return this._isShared;
    }

    @Override  // com.onesignal.location.internal.permissions.ILocationPermissionChangedHandler
    public void onLocationPermissionChanged(boolean z) {
        if(z) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
                int label;

                {
                    LocationManager.this = locationManager0;
                    super(1, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation0) {
                    return new com.onesignal.location.internal.LocationManager.onLocationPermissionChanged.1(LocationManager.this, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.onesignal.location.internal.LocationManager.onLocationPermissionChanged.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(object0);
                            this.label = 1;
                            return LocationManager.this.startGetLocation(this) == object1 ? object1 : Unit.INSTANCE;
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
            }, 1, null);
        }
    }

    @Override  // com.onesignal.location.ILocationManager
    public Object requestPermission(Continuation continuation0) {
        com.onesignal.location.internal.LocationManager.requestPermission.1 locationManager$requestPermission$10;
        if(continuation0 instanceof com.onesignal.location.internal.LocationManager.requestPermission.1) {
            locationManager$requestPermission$10 = (com.onesignal.location.internal.LocationManager.requestPermission.1)continuation0;
            if((locationManager$requestPermission$10.label & 0x80000000) == 0) {
                locationManager$requestPermission$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.requestPermission(this);
                    }
                };
            }
            else {
                locationManager$requestPermission$10.label ^= 0x80000000;
            }
        }
        else {
            locationManager$requestPermission$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.requestPermission(this);
                }
            };
        }
        Object object0 = locationManager$requestPermission$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(locationManager$requestPermission$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Logging.log(LogLevel.DEBUG, "LocationManager.requestPermission()");
                BooleanRef ref$BooleanRef0 = new BooleanRef();
                com.onesignal.location.internal.LocationManager.requestPermission.2 locationManager$requestPermission$20 = new Function2(ref$BooleanRef0, null) {
                    final BooleanRef $result;
                    Object L$0;
                    int label;

                    {
                        LocationManager.this = locationManager0;
                        this.$result = ref$BooleanRef0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.location.internal.LocationManager.requestPermission.2(LocationManager.this, this.$result, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.location.internal.LocationManager.requestPermission.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        BooleanRef ref$BooleanRef0;
                        BooleanRef ref$BooleanRef2;
                        boolean z2;
                        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        boolean z = true;
                        switch(this.label) {
                            case 0: {
                                ResultKt.throwOnFailure(object0);
                                String s = null;
                                if(!LocationManager.this.isShared()) {
                                    Logging.warn$default("Requesting location permission, but location sharing must also be enabled by setting isShared to true", null, 2, null);
                                }
                                boolean z1 = AndroidUtils.INSTANCE.hasPermission("android.permission.ACCESS_FINE_LOCATION", true, LocationManager.this._applicationService);
                                if(z1) {
                                    z2 = false;
                                }
                                else {
                                    z2 = AndroidUtils.INSTANCE.hasPermission("android.permission.ACCESS_COARSE_LOCATION", true, LocationManager.this._applicationService);
                                    LocationManager.this._capturer.setLocationCoarse(true);
                                }
                                boolean z3 = Build.VERSION.SDK_INT < 29 ? false : AndroidUtils.INSTANCE.hasPermission("android.permission.ACCESS_BACKGROUND_LOCATION", true, LocationManager.this._applicationService);
                                if(!z1) {
                                    List list0 = CollectionsKt.listOf(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_BACKGROUND_LOCATION"});
                                    List list1 = AndroidUtils.INSTANCE.filterManifestPermissions(list0, LocationManager.this._applicationService);
                                    if(list1.contains("android.permission.ACCESS_FINE_LOCATION")) {
                                        s = "android.permission.ACCESS_FINE_LOCATION";
                                    }
                                    else if(!list1.contains("android.permission.ACCESS_COARSE_LOCATION")) {
                                        Logging.info$default("Location permissions not added on AndroidManifest file >= M", null, 2, null);
                                    }
                                    else if(!z2) {
                                        s = "android.permission.ACCESS_COARSE_LOCATION";
                                    }
                                    else if(Build.VERSION.SDK_INT >= 29 && list1.contains("android.permission.ACCESS_BACKGROUND_LOCATION")) {
                                        s = "android.permission.ACCESS_BACKGROUND_LOCATION";
                                    }
                                    ref$BooleanRef2 = this.$result;
                                    if(s != null) {
                                        this.L$0 = ref$BooleanRef2;
                                        this.label = 2;
                                        Object object2 = LocationManager.this._locationPermissionController.prompt(true, s, this);
                                        if(object2 == object1) {
                                            return object1;
                                        }
                                        z = ((Boolean)object2).booleanValue();
                                    }
                                    else if(!z2) {
                                        z = false;
                                    }
                                    ref$BooleanRef2.element = z;
                                    return Unit.INSTANCE;
                                }
                                if(Build.VERSION.SDK_INT >= 29 && !z3) {
                                    BooleanRef ref$BooleanRef3 = this.$result;
                                    this.L$0 = ref$BooleanRef3;
                                    this.label = 3;
                                    Object object3 = LocationManager.this.backgroundLocationPermissionLogic(true, this);
                                    if(object3 == object1) {
                                        return object1;
                                    }
                                    ref$BooleanRef0 = ref$BooleanRef3;
                                    object0 = object3;
                                    ref$BooleanRef0.element = ((Boolean)object0).booleanValue();
                                    return Unit.INSTANCE;
                                }
                                this.$result.element = true;
                                this.label = 4;
                                return LocationManager.this.startGetLocation(this) == object1 ? object1 : Unit.INSTANCE;
                            }
                            case 1: {
                                ResultKt.throwOnFailure(object0);
                                this.$result.element = true;
                                return Unit.INSTANCE;
                            }
                            case 2: {
                                BooleanRef ref$BooleanRef1 = (BooleanRef)this.L$0;
                                ResultKt.throwOnFailure(object0);
                                z = ((Boolean)object0).booleanValue();
                                ref$BooleanRef2 = ref$BooleanRef1;
                                ref$BooleanRef2.element = z;
                                return Unit.INSTANCE;
                            }
                            case 3: {
                                ref$BooleanRef0 = (BooleanRef)this.L$0;
                                ResultKt.throwOnFailure(object0);
                                ref$BooleanRef0.element = ((Boolean)object0).booleanValue();
                                return Unit.INSTANCE;
                            }
                            case 4: {
                                ResultKt.throwOnFailure(object0);
                                return Unit.INSTANCE;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                locationManager$requestPermission$10.L$0 = ref$BooleanRef0;
                locationManager$requestPermission$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getMain(), locationManager$requestPermission$20, locationManager$requestPermission$10) == object1 ? object1 : Boxing.boxBoolean(ref$BooleanRef0.element);
            }
            case 1: {
                BooleanRef ref$BooleanRef1 = (BooleanRef)locationManager$requestPermission$10.L$0;
                ResultKt.throwOnFailure(object0);
                return Boxing.boxBoolean(ref$BooleanRef1.element);
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }

    @Override  // com.onesignal.location.ILocationManager
    public void setShared(boolean z) {
        Logging.debug$default(("LocationManager.setIsShared(value: " + z + ')'), null, 2, null);
        this._prefs.saveBool("OneSignal", "OS_LOCATION_SHARED", Boolean.valueOf(z));
        this._isShared = z;
        this.onLocationPermissionChanged(z);
    }

    @Override  // com.onesignal.core.internal.startup.IStartableService
    public void start() {
        this._locationPermissionController.subscribe(this);
        Context context0 = this._applicationService.getAppContext();
        if(LocationUtils.INSTANCE.hasLocationPermission(context0)) {
            ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
                int label;

                {
                    LocationManager.this = locationManager0;
                    super(1, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation0) {
                    return new com.onesignal.location.internal.LocationManager.start.1(LocationManager.this, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.onesignal.location.internal.LocationManager.start.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(object0);
                            this.label = 1;
                            return LocationManager.this.startGetLocation(this) == object1 ? object1 : Unit.INSTANCE;
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
            }, 1, null);
        }
    }

    private final Object startGetLocation(Continuation continuation0) {
        com.onesignal.location.internal.LocationManager.startGetLocation.1 locationManager$startGetLocation$10;
        if(continuation0 instanceof com.onesignal.location.internal.LocationManager.startGetLocation.1) {
            locationManager$startGetLocation$10 = (com.onesignal.location.internal.LocationManager.startGetLocation.1)continuation0;
            if((locationManager$startGetLocation$10.label & 0x80000000) == 0) {
                locationManager$startGetLocation$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                    int label;
                    Object result;

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.startGetLocation(this);
                    }
                };
            }
            else {
                locationManager$startGetLocation$10.label ^= 0x80000000;
            }
        }
        else {
            locationManager$startGetLocation$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
                int label;
                Object result;

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.startGetLocation(this);
                }
            };
        }
        Object object0 = locationManager$startGetLocation$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(locationManager$startGetLocation$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                if(!this.isShared()) {
                    return Unit.INSTANCE;
                }
                Logging.debug$default("LocationManager.startGetLocation()", null, 2, null);
                try {
                    locationManager$startGetLocation$10.label = 1;
                    object0 = this._locationController.start(locationManager$startGetLocation$10);
                    if(object0 == object1) {
                        return object1;
                    label_20:
                        ResultKt.throwOnFailure(object0);
                    }
                    if(!((Boolean)object0).booleanValue()) {
                        Logging.warn$default("LocationManager.startGetLocation: not possible, no location dependency found", null, 2, null);
                        return Unit.INSTANCE;
                    }
                    return Unit.INSTANCE;
                }
                catch(Throwable throwable0) {
                    break;
                }
            }
            case 1: {
                goto label_20;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Logging.warn("LocationManager.startGetLocation: Location permission exists but there was an error initializing: ", throwable0);
        return Unit.INSTANCE;
    }
}

