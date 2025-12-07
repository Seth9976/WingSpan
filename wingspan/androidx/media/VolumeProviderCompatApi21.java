package androidx.media;

import android.media.VolumeProvider;

class VolumeProviderCompatApi21 {
    public interface Delegate {
        void onAdjustVolume(int arg1);

        void onSetVolumeTo(int arg1);
    }

    public static Object createVolumeProvider(int v, int v1, int v2, Delegate volumeProviderCompatApi21$Delegate0) {
        return new VolumeProvider(v, v1, v2) {
            @Override  // android.media.VolumeProvider
            public void onAdjustVolume(int v) {
                volumeProviderCompatApi21$Delegate0.onAdjustVolume(v);
            }

            @Override  // android.media.VolumeProvider
            public void onSetVolumeTo(int v) {
                volumeProviderCompatApi21$Delegate0.onSetVolumeTo(v);
            }
        };
    }

    public static void setCurrentVolume(Object object0, int v) {
        ((VolumeProvider)object0).setCurrentVolume(v);
    }
}

