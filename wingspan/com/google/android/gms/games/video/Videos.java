package com.google.android.gms.games.video;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

@Deprecated
public interface Videos {
    @Deprecated
    public interface CaptureAvailableResult extends Result {
        boolean isAvailable();
    }

    @Deprecated
    public interface CaptureCapabilitiesResult extends Result {
        VideoCapabilities getCapabilities();
    }

    @Deprecated
    public interface CaptureOverlayStateListener {
        void onCaptureOverlayStateChanged(int arg1);
    }

    @Deprecated
    public interface CaptureStateResult extends Result {
        CaptureState getCaptureState();
    }

    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STARTED = 2;
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STOPPED = 3;
    public static final int CAPTURE_OVERLAY_STATE_DISMISSED = 4;
    public static final int CAPTURE_OVERLAY_STATE_SHOWN = 1;

    PendingResult getCaptureCapabilities(GoogleApiClient arg1);

    Intent getCaptureOverlayIntent(GoogleApiClient arg1);

    PendingResult getCaptureState(GoogleApiClient arg1);

    PendingResult isCaptureAvailable(GoogleApiClient arg1, int arg2);

    boolean isCaptureSupported(GoogleApiClient arg1);

    void registerCaptureOverlayStateChangedListener(GoogleApiClient arg1, CaptureOverlayStateListener arg2);

    void unregisterCaptureOverlayStateChangedListener(GoogleApiClient arg1);
}

