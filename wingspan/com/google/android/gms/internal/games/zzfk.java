package com.google.android.gms.internal.games;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.internal.zzbz;
import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;
import com.google.android.gms.games.video.Videos;

public final class zzfk implements Videos {
    @Override  // com.google.android.gms.games.video.Videos
    public final PendingResult getCaptureCapabilities(GoogleApiClient googleApiClient0) {
        return googleApiClient0.enqueue(new zzey(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.games.video.Videos
    public final Intent getCaptureOverlayIntent(GoogleApiClient googleApiClient0) {
        return Games.zzd(googleApiClient0, true).zzw();
    }

    @Override  // com.google.android.gms.games.video.Videos
    public final PendingResult getCaptureState(GoogleApiClient googleApiClient0) {
        return googleApiClient0.enqueue(new zzez(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.games.video.Videos
    public final PendingResult isCaptureAvailable(GoogleApiClient googleApiClient0, int v) {
        return googleApiClient0.enqueue(new zzfa(this, googleApiClient0, v));
    }

    @Override  // com.google.android.gms.games.video.Videos
    public final boolean isCaptureSupported(GoogleApiClient googleApiClient0) {
        return Games.zzd(googleApiClient0, true).zzbe();
    }

    @Override  // com.google.android.gms.games.video.Videos
    public final void registerCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient0, CaptureOverlayStateListener videos$CaptureOverlayStateListener0) {
        zzbz zzbz0 = Games.zzd(googleApiClient0, false);
        if(zzbz0 != null) {
            zzbz0.zzaK(googleApiClient0.registerListener(videos$CaptureOverlayStateListener0));
        }
    }

    @Override  // com.google.android.gms.games.video.Videos
    public final void unregisterCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient0) {
        zzbz zzbz0 = Games.zzd(googleApiClient0, false);
        if(zzbz0 != null) {
            zzbz0.zzbc();
        }
    }
}

