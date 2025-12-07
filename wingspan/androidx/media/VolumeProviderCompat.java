package androidx.media;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class VolumeProviderCompat {
    public static abstract class Callback {
        public abstract void onVolumeChanged(VolumeProviderCompat arg1);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ControlType {
    }

    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;

    public VolumeProviderCompat(int v, int v1, int v2) {
        this.mControlType = v;
        this.mMaxVolume = v1;
        this.mCurrentVolume = v2;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public Object getVolumeProvider() {
        if(this.mVolumeProviderObj == null) {
            int v = this.mCurrentVolume;
            androidx.media.VolumeProviderCompat.1 volumeProviderCompat$10 = new Delegate() {
                @Override  // androidx.media.VolumeProviderCompatApi21$Delegate
                public void onAdjustVolume(int v) {
                }

                @Override  // androidx.media.VolumeProviderCompatApi21$Delegate
                public void onSetVolumeTo(int v) {
                }
            };
            this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider(this.mControlType, this.mMaxVolume, v, volumeProviderCompat$10);
        }
        return this.mVolumeProviderObj;
    }

    public void onAdjustVolume(int v) {
    }

    public void onSetVolumeTo(int v) {
    }

    public void setCallback(Callback volumeProviderCompat$Callback0) {
        this.mCallback = volumeProviderCompat$Callback0;
    }

    public final void setCurrentVolume(int v) {
        this.mCurrentVolume = v;
        Object object0 = this.getVolumeProvider();
        if(object0 != null) {
            VolumeProviderCompatApi21.setCurrentVolume(object0, v);
        }
        Callback volumeProviderCompat$Callback0 = this.mCallback;
        if(volumeProviderCompat$Callback0 != null) {
            volumeProviderCompat$Callback0.onVolumeChanged(this);
        }
    }
}

