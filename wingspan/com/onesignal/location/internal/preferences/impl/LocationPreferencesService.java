package com.onesignal.location.internal.preferences.impl;

import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.location.internal.preferences.ILocationPreferencesService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u00068V@VX\u0096\u000E¢\u0006\f\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/onesignal/location/internal/preferences/impl/LocationPreferencesService;", "Lcom/onesignal/location/internal/preferences/ILocationPreferencesService;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "(Lcom/onesignal/core/internal/preferences/IPreferencesService;)V", "time", "", "lastLocationTime", "getLastLocationTime", "()J", "setLastLocationTime", "(J)V", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class LocationPreferencesService implements ILocationPreferencesService {
    private final IPreferencesService _prefs;

    public LocationPreferencesService(IPreferencesService iPreferencesService0) {
        Intrinsics.checkNotNullParameter(iPreferencesService0, "_prefs");
        super();
        this._prefs = iPreferencesService0;
    }

    @Override  // com.onesignal.location.internal.preferences.ILocationPreferencesService
    public long getLastLocationTime() {
        Long long0 = this._prefs.getLong("OneSignal", "OS_LAST_LOCATION_TIME", -600000L);
        Intrinsics.checkNotNull(long0);
        return (long)long0;
    }

    @Override  // com.onesignal.location.internal.preferences.ILocationPreferencesService
    public void setLastLocationTime(long v) {
        this._prefs.saveLong("OneSignal", "OS_LAST_LOCATION_TIME", v);
    }
}

