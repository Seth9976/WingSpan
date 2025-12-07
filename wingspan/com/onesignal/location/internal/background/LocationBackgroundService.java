package com.onesignal.location.internal.background;

import android.content.Context;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.background.IBackgroundService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.ILocationManager;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.common.LocationUtils;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0007\u0012\u0006\u0010\b\u001A\u00020\t\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0002\u0010\fJ\u0011\u0010\u0011\u001A\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u000BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001A\u0004\u0018\u00010\u000E8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\u000F\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/onesignal/location/internal/background/LocationBackgroundService;", "Lcom/onesignal/core/internal/background/IBackgroundService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_locationManager", "Lcom/onesignal/location/ILocationManager;", "_prefs", "Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;", "_capturer", "Lcom/onesignal/location/internal/capture/ILocationCapturer;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/location/ILocationManager;Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;Lcom/onesignal/location/internal/capture/ILocationCapturer;Lcom/onesignal/core/internal/time/ITime;)V", "scheduleBackgroundRunIn", "", "getScheduleBackgroundRunIn", "()Ljava/lang/Long;", "backgroundRun", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LocationBackgroundService implements IBackgroundService {
    private final IApplicationService _applicationService;
    private final ILocationCapturer _capturer;
    private final ILocationManager _locationManager;
    private final ILocationPreferencesService _prefs;
    private final ITime _time;

    public LocationBackgroundService(IApplicationService iApplicationService0, ILocationManager iLocationManager0, ILocationPreferencesService iLocationPreferencesService0, ILocationCapturer iLocationCapturer0, ITime iTime0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iLocationManager0, "_locationManager");
        Intrinsics.checkNotNullParameter(iLocationPreferencesService0, "_prefs");
        Intrinsics.checkNotNullParameter(iLocationCapturer0, "_capturer");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        super();
        this._applicationService = iApplicationService0;
        this._locationManager = iLocationManager0;
        this._prefs = iLocationPreferencesService0;
        this._capturer = iLocationCapturer0;
        this._time = iTime0;
    }

    @Override  // com.onesignal.core.internal.background.IBackgroundService
    public Object backgroundRun(Continuation continuation0) {
        this._capturer.captureLastLocation();
        return Unit.INSTANCE;
    }

    @Override  // com.onesignal.core.internal.background.IBackgroundService
    public Long getScheduleBackgroundRunIn() {
        if(!this._locationManager.isShared()) {
            Logging.debug$default("LocationController scheduleUpdate not possible, location shared not enabled", null, 2, null);
            return null;
        }
        Context context0 = this._applicationService.getAppContext();
        if(!LocationUtils.INSTANCE.hasLocationPermission(context0)) {
            Logging.debug$default("LocationController scheduleUpdate not possible, location permission not enabled", null, 2, null);
            return null;
        }
        return (long)(600000L - (this._time.getCurrentTimeMillis() - this._prefs.getLastLocationTime()));
    }
}

