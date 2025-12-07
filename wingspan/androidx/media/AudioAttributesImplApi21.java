package androidx.media;

import android.media.AudioAttributes;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class AudioAttributesImplApi21 implements AudioAttributesImpl {
    private static final String TAG = "AudioAttributesCompat21";
    AudioAttributes mAudioAttributes;
    int mLegacyStreamType;
    static Method sAudioAttributesToLegacyStreamType;

    AudioAttributesImplApi21() {
        this.mLegacyStreamType = -1;
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes0) {
        this(audioAttributes0, -1);
    }

    AudioAttributesImplApi21(AudioAttributes audioAttributes0, int v) {
        this.mAudioAttributes = audioAttributes0;
        this.mLegacyStreamType = v;
    }

    @Override
    public boolean equals(Object object0) {
        return object0 instanceof AudioAttributesImplApi21 ? this.mAudioAttributes.equals(((AudioAttributesImplApi21)object0).mAudioAttributes) : false;
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle0) {
        if(bundle0 == null) {
            return null;
        }
        AudioAttributes audioAttributes0 = (AudioAttributes)bundle0.getParcelable("androidx.media.audio_attrs.FRAMEWORKS");
        return audioAttributes0 == null ? null : new AudioAttributesImplApi21(audioAttributes0, bundle0.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    @Override  // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return this.mAudioAttributes;
    }

    static Method getAudioAttributesToLegacyStreamTypeMethod() {
        try {
            if(AudioAttributesImplApi21.sAudioAttributesToLegacyStreamType == null) {
                AudioAttributesImplApi21.sAudioAttributesToLegacyStreamType = AudioAttributes.class.getMethod("toLegacyStreamType", AudioAttributes.class);
            }
            return AudioAttributesImplApi21.sAudioAttributesToLegacyStreamType;
        }
        catch(NoSuchMethodException unused_ex) {
            return null;
        }
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.mAudioAttributes.getContentType();
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getFlags() {
        return this.mAudioAttributes.getFlags();
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int v = this.mLegacyStreamType;
        if(v != -1) {
            return v;
        }
        Method method0 = AudioAttributesImplApi21.getAudioAttributesToLegacyStreamTypeMethod();
        if(method0 == null) {
            Log.w("AudioAttributesCompat21", "No AudioAttributes#toLegacyStreamType() on API: " + Build.VERSION.SDK_INT);
            return -1;
        }
        try {
            return (int)(((Integer)method0.invoke(null, this.mAudioAttributes)));
        }
        catch(InvocationTargetException | IllegalAccessException invocationTargetException0) {
            Log.w("AudioAttributesCompat21", "getLegacyStreamType() failed on API: " + Build.VERSION.SDK_INT, invocationTargetException0);
            return -1;
        }
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.mLegacyStreamType;
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.mAudioAttributes.getUsage();
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return Build.VERSION.SDK_INT < 26 ? AudioAttributesCompat.toVolumeStreamType(true, this.getFlags(), this.getUsage()) : this.mAudioAttributes.getVolumeControlStream();
    }

    @Override
    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    @Override  // androidx.media.AudioAttributesImpl
    public Bundle toBundle() {
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.mAudioAttributes);
        int v = this.mLegacyStreamType;
        if(v != -1) {
            bundle0.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", v);
        }
        return bundle0;
    }

    @Override
    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
    }
}

