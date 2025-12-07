package com.google.android.gms.games;

import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;
import com.google.android.gms.tasks.Task;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
public interface VideosClient {
    @Retention(RetentionPolicy.SOURCE)
    public @interface CaptureOverlayState {
    }

    @Deprecated
    public interface OnCaptureOverlayStateListener extends CaptureOverlayStateListener {
        @Override  // com.google.android.gms.games.video.Videos$CaptureOverlayStateListener
        @Deprecated
        void onCaptureOverlayStateChanged(int arg1);
    }

    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STARTED = 2;
    public static final int CAPTURE_OVERLAY_STATE_CAPTURE_STOPPED = 3;
    public static final int CAPTURE_OVERLAY_STATE_DISMISSED = 4;
    public static final int CAPTURE_OVERLAY_STATE_SHOWN = 1;

    @Deprecated
    Task getCaptureCapabilities();

    @Deprecated
    Task getCaptureOverlayIntent();

    @Deprecated
    Task getCaptureState();

    @Deprecated
    Task isCaptureAvailable(int arg1);

    @Deprecated
    Task isCaptureSupported();

    @Deprecated
    Task registerOnCaptureOverlayStateChangedListener(OnCaptureOverlayStateListener arg1);

    @Deprecated
    Task unregisterOnCaptureOverlayStateChangedListener(OnCaptureOverlayStateListener arg1);
}

