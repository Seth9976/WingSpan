package androidx.core.location;

import androidx.core.os.CancellationSignal.OnCancelListener;

public final class LocationManagerCompat..ExternalSyntheticLambda2 implements OnCancelListener {
    public final CancellableLocationListener f$0;

    public LocationManagerCompat..ExternalSyntheticLambda2(CancellableLocationListener locationManagerCompat$CancellableLocationListener0) {
        this.f$0 = locationManagerCompat$CancellableLocationListener0;
    }

    @Override  // androidx.core.os.CancellationSignal$OnCancelListener
    public final void onCancel() {
        this.f$0.cancel();
    }
}

