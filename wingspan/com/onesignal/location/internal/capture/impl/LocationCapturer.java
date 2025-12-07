package com.onesignal.location.internal.capture.impl;

import android.location.Location;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.capture.ILocationCapturer;
import com.onesignal.location.internal.common.LocationPoint;
import com.onesignal.location.internal.controller.ILocationController;
import com.onesignal.location.internal.controller.ILocationUpdatedHandler;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b\u0012\u0006\u0010\t\u001A\u00020\n\u0012\u0006\u0010\u000B\u001A\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0002J\b\u0010\u0018\u001A\u00020\u0015H\u0016J\u0010\u0010\u0019\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u0017H\u0016R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001A\u0010\u000E\u001A\u00020\u000FX\u0096\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001A"}, d2 = {"Lcom/onesignal/location/internal/capture/impl/LocationCapturer;", "Lcom/onesignal/location/internal/controller/ILocationUpdatedHandler;", "Lcom/onesignal/location/internal/capture/ILocationCapturer;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "_prefs", "Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;", "_propertiesModelStore", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "_controller", "Lcom/onesignal/location/internal/controller/ILocationController;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/time/ITime;Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/location/internal/controller/ILocationController;)V", "locationCoarse", "", "getLocationCoarse", "()Z", "setLocationCoarse", "(Z)V", "capture", "", "location", "Landroid/location/Location;", "captureLastLocation", "onLocationChanged", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LocationCapturer implements ILocationCapturer, ILocationUpdatedHandler {
    private final IApplicationService _applicationService;
    private final ILocationController _controller;
    private final ILocationPreferencesService _prefs;
    private final PropertiesModelStore _propertiesModelStore;
    private final ITime _time;
    private boolean locationCoarse;

    public LocationCapturer(IApplicationService iApplicationService0, ITime iTime0, ILocationPreferencesService iLocationPreferencesService0, PropertiesModelStore propertiesModelStore0, ILocationController iLocationController0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_applicationService");
        Intrinsics.checkNotNullParameter(iTime0, "_time");
        Intrinsics.checkNotNullParameter(iLocationPreferencesService0, "_prefs");
        Intrinsics.checkNotNullParameter(propertiesModelStore0, "_propertiesModelStore");
        Intrinsics.checkNotNullParameter(iLocationController0, "_controller");
        super();
        this._applicationService = iApplicationService0;
        this._time = iTime0;
        this._prefs = iLocationPreferencesService0;
        this._propertiesModelStore = propertiesModelStore0;
        this._controller = iLocationController0;
        iLocationController0.subscribe(this);
    }

    private final void capture(Location location0) {
        LocationPoint locationPoint0 = new LocationPoint();
        locationPoint0.setAccuracy(location0.getAccuracy());
        locationPoint0.setBg(Boolean.valueOf(!this._applicationService.isInForeground()));
        locationPoint0.setType((this.getLocationCoarse() ? 0 : 1));
        locationPoint0.setTimeStamp(location0.getTime());
        if(this.getLocationCoarse()) {
            locationPoint0.setLat(new BigDecimal(location0.getLatitude()).setScale(7, RoundingMode.HALF_UP).doubleValue());
            locationPoint0.setLog(new BigDecimal(location0.getLongitude()).setScale(7, RoundingMode.HALF_UP).doubleValue());
        }
        else {
            locationPoint0.setLat(location0.getLatitude());
            locationPoint0.setLog(location0.getLongitude());
        }
        PropertiesModel propertiesModel0 = (PropertiesModel)this._propertiesModelStore.getModel();
        propertiesModel0.setLocationLongitude(locationPoint0.getLog());
        propertiesModel0.setLocationLatitude(locationPoint0.getLat());
        propertiesModel0.setLocationAccuracy(locationPoint0.getAccuracy());
        propertiesModel0.setLocationBackground(locationPoint0.getBg());
        propertiesModel0.setLocationType(locationPoint0.getType());
        propertiesModel0.setLocationTimestamp(locationPoint0.getTimeStamp());
        long v = this._time.getCurrentTimeMillis();
        this._prefs.setLastLocationTime(v);
    }

    @Override  // com.onesignal.location.internal.capture.ILocationCapturer
    public void captureLastLocation() {
        Location location0 = this._controller.getLastLocation();
        if(location0 != null) {
            this.capture(location0);
            return;
        }
        long v = this._time.getCurrentTimeMillis();
        this._prefs.setLastLocationTime(v);
    }

    @Override  // com.onesignal.location.internal.capture.ILocationCapturer
    public boolean getLocationCoarse() {
        return this.locationCoarse;
    }

    @Override  // com.onesignal.location.internal.controller.ILocationUpdatedHandler
    public void onLocationChanged(Location location0) {
        Intrinsics.checkNotNullParameter(location0, "location");
        Logging.debug$default(("LocationController fireCompleteForLocation with location: " + location0), null, 2, null);
        this.capture(location0);
    }

    @Override  // com.onesignal.location.internal.capture.ILocationCapturer
    public void setLocationCoarse(boolean z) {
        this.locationCoarse = z;
    }
}

