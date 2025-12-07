package com.onesignal.location.internal.capture;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\b\u001A\u00020\tH&R\u0018\u0010\u0002\u001A\u00020\u0003X¦\u000E¢\u0006\f\u001A\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/onesignal/location/internal/capture/ILocationCapturer;", "", "locationCoarse", "", "getLocationCoarse", "()Z", "setLocationCoarse", "(Z)V", "captureLastLocation", "", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ILocationCapturer {
    void captureLastLocation();

    boolean getLocationCoarse();

    void setLocationCoarse(boolean arg1);
}

