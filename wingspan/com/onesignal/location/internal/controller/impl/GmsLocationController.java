package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.onesignal.common.events.EventProducer;
import com.onesignal.common.threading.ThreadUtilsKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0004\"#$%B\u0015\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0018\u001A\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0019\u001A\u00020\u001A2\u0006\u0010\u001B\u001A\u00020\u0011H\u0002J\u0011\u0010\u001C\u001A\u00020\rH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001DJ\u0011\u0010\u001E\u001A\u00020\u001AH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001DJ\u0010\u0010\u001F\u001A\u00020\u001A2\u0006\u0010 \u001A\u00020\tH\u0016J\u0010\u0010!\u001A\u00020\u001A2\u0006\u0010 \u001A\u00020\tH\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001A\u0004\u0018\u00010\u000BX\u0082\u000E¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001A\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000E\u0010\u000FR\u0010\u0010\u0010\u001A\u0004\u0018\u00010\u0011X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001A\u0004\u0018\u00010\u0015X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0016\u001A\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/GmsLocationController;", "Lcom/onesignal/location/internal/controller/ILocationController;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_fusedLocationApiWrapper", "Lcom/onesignal/location/internal/controller/impl/IFusedLocationApiWrapper;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/location/internal/controller/impl/IFusedLocationApiWrapper;)V", "event", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/location/internal/controller/ILocationUpdatedHandler;", "googleApiClient", "Lcom/onesignal/location/internal/controller/impl/GoogleApiClientCompatProxy;", "hasSubscribers", "", "getHasSubscribers", "()Z", "lastLocation", "Landroid/location/Location;", "locationHandlerThread", "Lcom/onesignal/location/internal/controller/impl/GmsLocationController$LocationHandlerThread;", "locationUpdateListener", "Lcom/onesignal/location/internal/controller/impl/GmsLocationController$LocationUpdateListener;", "startStopMutex", "Lkotlinx/coroutines/sync/Mutex;", "getLastLocation", "setLocationAndFire", "", "location", "start", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "subscribe", "handler", "unsubscribe", "Companion", "GoogleApiClientListener", "LocationHandlerThread", "LocationUpdateListener", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class GmsLocationController implements ILocationController {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001A\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/GmsLocationController$Companion;", "", "()V", "API_FALLBACK_TIME", "", "getAPI_FALLBACK_TIME", "()I", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        // 去混淆评级： 低(20)
        public final int getAPI_FALLBACK_TIME() [...] // 潜在的解密器
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001A\u00020\u00072\b\u0010\b\u001A\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fH\u0016J\u0010\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u000FH\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/GmsLocationController$GoogleApiClientListener;", "Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;", "Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;", "_parent", "Lcom/onesignal/location/internal/controller/impl/GmsLocationController;", "(Lcom/onesignal/location/internal/controller/impl/GmsLocationController;)V", "onConnected", "", "bundle", "Landroid/os/Bundle;", "onConnectionFailed", "connectionResult", "Lcom/google/android/gms/common/ConnectionResult;", "onConnectionSuspended", "i", "", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    static final class GoogleApiClientListener implements ConnectionCallbacks, OnConnectionFailedListener {
        private final GmsLocationController _parent;

        public GoogleApiClientListener(GmsLocationController gmsLocationController0) {
            Intrinsics.checkNotNullParameter(gmsLocationController0, "_parent");
            super();
            this._parent = gmsLocationController0;
        }

        @Override  // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public void onConnected(Bundle bundle0) {
            Logging.debug$default("GMSLocationController GoogleApiClientListener onConnected", null, 2, null);
        }

        @Override  // com.google.android.gms.common.api.internal.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult connectionResult0) {
            Intrinsics.checkNotNullParameter(connectionResult0, "connectionResult");
            Logging.debug$default(("GMSLocationController GoogleApiClientListener onConnectionSuspended connectionResult: " + connectionResult0), null, 2, null);
            ThreadUtilsKt.suspendifyOnThread$default(0, new Function1(null) {
                int label;

                {
                    GoogleApiClientListener.this = gmsLocationController$GoogleApiClientListener0;
                    super(1, continuation0);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Continuation continuation0) {
                    return new com.onesignal.location.internal.controller.impl.GmsLocationController.GoogleApiClientListener.onConnectionFailed.1(GoogleApiClientListener.this, continuation0);
                }

                @Override  // kotlin.jvm.functions.Function1
                public Object invoke(Object object0) {
                    return this.invoke(((Continuation)object0));
                }

                public final Object invoke(Continuation continuation0) {
                    return ((com.onesignal.location.internal.controller.impl.GmsLocationController.GoogleApiClientListener.onConnectionFailed.1)this.create(continuation0)).invokeSuspend(Unit.INSTANCE);
                }

                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object object0) {
                    Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch(this.label) {
                        case 0: {
                            ResultKt.throwOnFailure(object0);
                            this.label = 1;
                            return GoogleApiClientListener.this._parent.stop(this) == object1 ? object1 : Unit.INSTANCE;
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

        @Override  // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public void onConnectionSuspended(int v) {
            Logging.debug$default(("GMSLocationController GoogleApiClientListener onConnectionSuspended i: " + v), null, 2, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002R\u001A\u0010\u0003\u001A\u00020\u0004X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/GmsLocationController$LocationHandlerThread;", "Landroid/os/HandlerThread;", "()V", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
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

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0002\u0010\fJ\b\u0010\u000F\u001A\u00020\u0010H\u0016J\b\u0010\u0011\u001A\u00020\u0010H\u0016J\u0010\u0010\u0012\u001A\u00020\u00102\u0006\u0010\u0013\u001A\u00020\u0014H\u0016J\b\u0010\u0015\u001A\u00020\u0010H\u0016J\b\u0010\u0016\u001A\u00020\u0010H\u0002R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u000EX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/onesignal/location/internal/controller/impl/GmsLocationController$LocationUpdateListener;", "Lcom/google/android/gms/location/LocationListener;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "Ljava/io/Closeable;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_parent", "Lcom/onesignal/location/internal/controller/impl/GmsLocationController;", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "_fusedLocationApiWrapper", "Lcom/onesignal/location/internal/controller/impl/IFusedLocationApiWrapper;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/location/internal/controller/impl/GmsLocationController;Lcom/google/android/gms/common/api/GoogleApiClient;Lcom/onesignal/location/internal/controller/impl/IFusedLocationApiWrapper;)V", "hasExistingRequest", "", "close", "", "onFocus", "onLocationChanged", "location", "Landroid/location/Location;", "onUnfocused", "refreshRequest", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
    public static final class LocationUpdateListener implements LocationListener, IApplicationLifecycleHandler, Closeable {
        private final IApplicationService _applicationService;
        private final IFusedLocationApiWrapper _fusedLocationApiWrapper;
        private final GmsLocationController _parent;
        private final GoogleApiClient googleApiClient;
        private boolean hasExistingRequest;

        public LocationUpdateListener(IApplicationService iApplicationService0, GmsLocationController gmsLocationController0, GoogleApiClient googleApiClient0, IFusedLocationApiWrapper iFusedLocationApiWrapper0) {
            Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
            Intrinsics.checkNotNullParameter(gmsLocationController0, "_parent");
            Intrinsics.checkNotNullParameter(googleApiClient0, "googleApiClient");
            Intrinsics.checkNotNullParameter(iFusedLocationApiWrapper0, "_fusedLocationApiWrapper");
            super();
            this._applicationService = iApplicationService0;
            this._parent = gmsLocationController0;
            this.googleApiClient = googleApiClient0;
            this._fusedLocationApiWrapper = iFusedLocationApiWrapper0;
            if(!googleApiClient0.isConnected()) {
                throw new Exception("googleApiClient not connected, cannot listen!");
            }
            iApplicationService0.addApplicationLifecycleHandler(this);
            this.refreshRequest();
        }

        @Override
        public void close() {
            this._applicationService.removeApplicationLifecycleHandler(this);
            if(this.hasExistingRequest) {
                this._fusedLocationApiWrapper.cancelLocationUpdates(this.googleApiClient, this);
            }
        }

        @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
        public void onFocus() {
            Logging.log(LogLevel.DEBUG, "LocationUpdateListener.onFocus()");
            this.refreshRequest();
        }

        @Override  // com.google.android.gms.location.LocationListener
        public void onLocationChanged(Location location0) {
            Intrinsics.checkNotNullParameter(location0, "location");
            Logging.debug$default(("GMSLocationController onLocationChanged: " + location0), null, 2, null);
            this._parent.setLocationAndFire(location0);
        }

        @Override  // com.onesignal.core.internal.application.IApplicationLifecycleHandler
        public void onUnfocused() {
            Logging.log(LogLevel.DEBUG, "LocationUpdateListener.onUnfocused()");
            this.refreshRequest();
        }

        private final void refreshRequest() {
            if(!this.googleApiClient.isConnected()) {
                Logging.warn$default("Attempt to refresh location request but not currently connected!", null, 2, null);
                return;
            }
            if(this.hasExistingRequest) {
                this._fusedLocationApiWrapper.cancelLocationUpdates(this.googleApiClient, this);
            }
            long v = this._applicationService.isInForeground() ? 270000L : 570000L;
            LocationRequest locationRequest0 = LocationRequest.create().setFastestInterval(v).setInterval(v).setMaxWaitTime(((long)(((double)v) * 1.5))).setPriority(102);
            Logging.debug$default("GMSLocationController GoogleApiClient requestLocationUpdates!", null, 2, null);
            Intrinsics.checkNotNullExpressionValue(locationRequest0, "locationRequest");
            this._fusedLocationApiWrapper.requestLocationUpdates(this.googleApiClient, locationRequest0, this);
            this.hasExistingRequest = true;
        }
    }

    private static final int API_FALLBACK_TIME;
    public static final Companion Companion;
    private final IApplicationService _applicationService;
    private final IFusedLocationApiWrapper _fusedLocationApiWrapper;
    private final EventProducer event;
    private GoogleApiClientCompatProxy googleApiClient;
    private Location lastLocation;
    private final LocationHandlerThread locationHandlerThread;
    private LocationUpdateListener locationUpdateListener;
    private final Mutex startStopMutex;

    static {
        GmsLocationController.Companion = new Companion(null);
        GmsLocationController.API_FALLBACK_TIME = 30000;
    }

    public GmsLocationController(IApplicationService iApplicationService0, IFusedLocationApiWrapper iFusedLocationApiWrapper0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iFusedLocationApiWrapper0, "_fusedLocationApiWrapper");
        super();
        this._applicationService = iApplicationService0;
        this._fusedLocationApiWrapper = iFusedLocationApiWrapper0;
        this.locationHandlerThread = new LocationHandlerThread();
        this.startStopMutex = MutexKt.Mutex$default(false, 1, null);
        this.event = new EventProducer();
    }

    public static final int access$getAPI_FALLBACK_TIME$cp() [...] // 潜在的解密器

    @Override  // com.onesignal.common.events.IEventNotifier
    public boolean getHasSubscribers() {
        return this.event.getHasSubscribers();
    }

    @Override  // com.onesignal.location.internal.controller.ILocationController
    public Location getLastLocation() {
        GoogleApiClientCompatProxy googleApiClientCompatProxy0 = this.googleApiClient;
        if(googleApiClientCompatProxy0 != null) {
            GoogleApiClient googleApiClient0 = googleApiClientCompatProxy0.getRealInstance();
            return googleApiClient0 == null ? null : this._fusedLocationApiWrapper.getLastLocation(googleApiClient0);
        }
        return null;
    }

    private final void setLocationAndFire(Location location0) {
        Logging.debug$default(("GMSLocationController lastLocation: " + this.lastLocation), null, 2, null);
        this.lastLocation = location0;
        Function1 function10 = new Function1() {
            final Location $location;

            {
                this.$location = location0;
                super(1);
            }

            @Override  // kotlin.jvm.functions.Function1
            public Object invoke(Object object0) {
                this.invoke(((ILocationUpdatedHandler)object0));
                return Unit.INSTANCE;
            }

            public final void invoke(ILocationUpdatedHandler iLocationUpdatedHandler0) {
                Intrinsics.checkNotNullParameter(iLocationUpdatedHandler0, "it");
                iLocationUpdatedHandler0.onLocationChanged(this.$location);
            }
        };
        this.event.fire(function10);
    }

    @Override  // com.onesignal.location.internal.controller.ILocationController
    public Object start(Continuation continuation0) {
        com.onesignal.location.internal.controller.impl.GmsLocationController.start.1 gmsLocationController$start$10;
        if(continuation0 instanceof com.onesignal.location.internal.controller.impl.GmsLocationController.start.1) {
            gmsLocationController$start$10 = (com.onesignal.location.internal.controller.impl.GmsLocationController.start.1)continuation0;
            if((gmsLocationController$start$10.label & 0x80000000) == 0) {
                gmsLocationController$start$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
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
                gmsLocationController$start$10.label ^= 0x80000000;
            }
        }
        else {
            gmsLocationController$start$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = gmsLocationController$start$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(gmsLocationController$start$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                ObjectRef ref$ObjectRef0 = new ObjectRef();
                ref$ObjectRef0.element = this;
                BooleanRef ref$BooleanRef0 = new BooleanRef();
                com.onesignal.location.internal.controller.impl.GmsLocationController.start.2 gmsLocationController$start$20 = new Function2(ref$BooleanRef0, ref$ObjectRef0, null) {
                    final ObjectRef $self;
                    final BooleanRef $wasSuccessful;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;

                    {
                        GmsLocationController.this = gmsLocationController0;
                        this.$wasSuccessful = ref$BooleanRef0;
                        this.$self = ref$ObjectRef0;
                        super(2, continuation0);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.onesignal.location.internal.controller.impl.GmsLocationController.start.2(GmsLocationController.this, this.$wasSuccessful, this.$self, continuation0);
                    }

                    @Override  // kotlin.jvm.functions.Function2
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.onesignal.location.internal.controller.impl.GmsLocationController.start.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object object0) {
                        Throwable throwable1;
                        Mutex mutex2;
                        ObjectRef ref$ObjectRef0;
                        BooleanRef ref$BooleanRef0;
                        GmsLocationController gmsLocationController0;
                        Mutex mutex0;
                        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch(this.label) {
                            case 0: {
                                ResultKt.throwOnFailure(object0);
                                mutex0 = GmsLocationController.this.startStopMutex;
                                gmsLocationController0 = GmsLocationController.this;
                                ref$BooleanRef0 = this.$wasSuccessful;
                                ref$ObjectRef0 = this.$self;
                                this.L$0 = mutex0;
                                this.L$1 = gmsLocationController0;
                                this.L$2 = ref$BooleanRef0;
                                this.L$3 = ref$ObjectRef0;
                                this.label = 1;
                                if(mutex0.lock(null, this) == object1) {
                                    return object1;
                                }
                                goto label_21;
                            }
                            case 1: {
                                ref$ObjectRef0 = (ObjectRef)this.L$3;
                                ref$BooleanRef0 = (BooleanRef)this.L$2;
                                gmsLocationController0 = (GmsLocationController)this.L$1;
                                Mutex mutex1 = (Mutex)this.L$0;
                                ResultKt.throwOnFailure(object0);
                                mutex0 = mutex1;
                                try {
                                label_21:
                                    if(gmsLocationController0.googleApiClient == null) {
                                        try {
                                            Function2 function20 = new Function2(gmsLocationController0, ref$BooleanRef0, null) {
                                                final ObjectRef $self;
                                                final BooleanRef $wasSuccessful;
                                                int label;

                                                {
                                                    this.$self = ref$ObjectRef0;
                                                    GmsLocationController.this = gmsLocationController0;
                                                    this.$wasSuccessful = ref$BooleanRef0;
                                                    super(2, continuation0);
                                                }

                                                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    return new com.onesignal.location.internal.controller.impl.GmsLocationController.start.2.1.2(this.$self, GmsLocationController.this, this.$wasSuccessful, continuation0);
                                                }

                                                @Override  // kotlin.jvm.functions.Function2
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.onesignal.location.internal.controller.impl.GmsLocationController.start.2.1.2)this.create(coroutineScope0, continuation0)).invokeSuspend(Unit.INSTANCE);
                                                }

                                                @Override  // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object object0) {
                                                    if(this.label != 0) {
                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                    }
                                                    ResultKt.throwOnFailure(object0);
                                                    GoogleApiClientListener gmsLocationController$GoogleApiClientListener0 = new GoogleApiClientListener(((GmsLocationController)this.$self.element));
                                                    GoogleApiClient googleApiClient0 = new Builder(GmsLocationController.this._applicationService.getAppContext()).addApi(LocationServices.API).addConnectionCallbacks(gmsLocationController$GoogleApiClientListener0).addOnConnectionFailedListener(gmsLocationController$GoogleApiClientListener0).setHandler(GmsLocationController.this.locationHandlerThread.getMHandler()).build();
                                                    Intrinsics.checkNotNullExpressionValue(googleApiClient0, "googleApiClient");
                                                    GoogleApiClientCompatProxy googleApiClientCompatProxy0 = new GoogleApiClientCompatProxy(googleApiClient0);
                                                    ConnectionResult connectionResult0 = googleApiClientCompatProxy0.blockingConnect();
                                                    if(connectionResult0 != null && connectionResult0.isSuccess()) {
                                                        if(GmsLocationController.this.lastLocation == null) {
                                                            Location location0 = GmsLocationController.this._fusedLocationApiWrapper.getLastLocation(googleApiClient0);
                                                            if(location0 != null) {
                                                                GmsLocationController.this.setLocationAndFire(location0);
                                                            }
                                                        }
                                                        ((GmsLocationController)this.$self.element).locationUpdateListener = new LocationUpdateListener(GmsLocationController.this._applicationService, ((GmsLocationController)this.$self.element), googleApiClientCompatProxy0.getRealInstance(), GmsLocationController.this._fusedLocationApiWrapper);
                                                        ((GmsLocationController)this.$self.element).googleApiClient = googleApiClientCompatProxy0;
                                                        this.$wasSuccessful.element = true;
                                                        return Unit.INSTANCE;
                                                    }
                                                    Logging.debug$default(("GMSLocationController connection to GoogleApiService failed: (" + (connectionResult0 == null ? null : Boxing.boxInt(connectionResult0.getErrorCode())) + ") " + (connectionResult0 == null ? null : connectionResult0.getErrorMessage())), null, 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            this.L$0 = mutex0;
                                            this.L$1 = null;
                                            this.L$2 = null;
                                            this.L$3 = null;
                                            this.label = 2;
                                            if(TimeoutKt.withTimeout(30000L, function20, this) == object1) {
                                                return object1;
                                            }
                                        }
                                        catch(TimeoutCancellationException unused_ex) {
                                            mutex2 = mutex0;
                                            goto label_50;
                                        }
                                    }
                                    else {
                                        if(gmsLocationController0.lastLocation == null) {
                                            Location location0 = gmsLocationController0.getLastLocation();
                                            if(location0 != null) {
                                                gmsLocationController0.setLocationAndFire(location0);
                                            }
                                        }
                                        else {
                                            gmsLocationController0.event.fire(new Function1() {
                                                {
                                                    GmsLocationController.this = gmsLocationController0;
                                                    super(1);
                                                }

                                                @Override  // kotlin.jvm.functions.Function1
                                                public Object invoke(Object object0) {
                                                    this.invoke(((ILocationUpdatedHandler)object0));
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(ILocationUpdatedHandler iLocationUpdatedHandler0) {
                                                    Intrinsics.checkNotNullParameter(iLocationUpdatedHandler0, "it");
                                                    Location location0 = GmsLocationController.this.lastLocation;
                                                    Intrinsics.checkNotNull(location0);
                                                    iLocationUpdatedHandler0.onLocationChanged(location0);
                                                }
                                            });
                                        }
                                        ref$BooleanRef0.element = true;
                                    }
                                }
                                catch(Throwable throwable0) {
                                    mutex2 = mutex0;
                                    throwable1 = throwable0;
                                    mutex2.unlock(null);
                                    throw throwable1;
                                }
                                mutex2 = mutex0;
                                break;
                            }
                            case 2: {
                                mutex2 = (Mutex)this.L$0;
                                try {
                                    try {
                                        ResultKt.throwOnFailure(object0);
                                        break;
                                    }
                                    catch(TimeoutCancellationException unused_ex) {
                                    }
                                label_50:
                                    Logging.warn$default("Location permission exists but GoogleApiClient timed out. Maybe related to mismatch google-play aar versions.", null, 2, null);
                                    break;
                                }
                                catch(Throwable throwable1) {
                                }
                                mutex2.unlock(null);
                                throw throwable1;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        mutex2.unlock(null);
                        return Unit.INSTANCE;
                    }
                };
                gmsLocationController$start$10.L$0 = ref$BooleanRef0;
                gmsLocationController$start$10.label = 1;
                return BuildersKt.withContext(Dispatchers.getIO(), gmsLocationController$start$20, gmsLocationController$start$10) == object1 ? object1 : Boxing.boxBoolean(ref$BooleanRef0.element);
            }
            case 1: {
                BooleanRef ref$BooleanRef1 = (BooleanRef)gmsLocationController$start$10.L$0;
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
        GmsLocationController gmsLocationController0;
        com.onesignal.location.internal.controller.impl.GmsLocationController.stop.1 gmsLocationController$stop$10;
        if(continuation0 instanceof com.onesignal.location.internal.controller.impl.GmsLocationController.stop.1) {
            gmsLocationController$stop$10 = (com.onesignal.location.internal.controller.impl.GmsLocationController.stop.1)continuation0;
            if((gmsLocationController$stop$10.label & 0x80000000) == 0) {
                gmsLocationController$stop$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
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
                gmsLocationController$stop$10.label ^= 0x80000000;
            }
        }
        else {
            gmsLocationController$stop$10 = new ContinuationImpl(/*ERROR_MISSING_ARG_1/*) {
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
        Object object0 = gmsLocationController$stop$10.result;
        Object object1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(gmsLocationController$stop$10.label) {
            case 0: {
                ResultKt.throwOnFailure(object0);
                Mutex mutex0 = this.startStopMutex;
                gmsLocationController$stop$10.L$0 = this;
                gmsLocationController$stop$10.L$1 = mutex0;
                gmsLocationController$stop$10.label = 1;
                if(mutex0.lock(null, gmsLocationController$stop$10) == object1) {
                    return object1;
                }
                gmsLocationController0 = this;
                mutex1 = mutex0;
                break;
            }
            case 1: {
                mutex1 = (Mutex)gmsLocationController$stop$10.L$1;
                gmsLocationController0 = (GmsLocationController)gmsLocationController$stop$10.L$0;
                ResultKt.throwOnFailure(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        try {
            LocationUpdateListener gmsLocationController$LocationUpdateListener0 = gmsLocationController0.locationUpdateListener;
            if(gmsLocationController$LocationUpdateListener0 != null) {
                Intrinsics.checkNotNull(gmsLocationController$LocationUpdateListener0);
                gmsLocationController$LocationUpdateListener0.close();
                gmsLocationController0.locationUpdateListener = null;
            }
            GoogleApiClientCompatProxy googleApiClientCompatProxy0 = gmsLocationController0.googleApiClient;
            if(googleApiClientCompatProxy0 != null) {
                Intrinsics.checkNotNull(googleApiClientCompatProxy0);
                googleApiClientCompatProxy0.disconnect();
                gmsLocationController0.googleApiClient = null;
            }
            gmsLocationController0.lastLocation = null;
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

