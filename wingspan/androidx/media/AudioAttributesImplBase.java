package androidx.media;

import android.os.Bundle;
import java.util.Arrays;

class AudioAttributesImplBase implements AudioAttributesImpl {
    int mContentType;
    int mFlags;
    int mLegacyStream;
    int mUsage;

    AudioAttributesImplBase() {
        this.mUsage = 0;
        this.mContentType = 0;
        this.mFlags = 0;
        this.mLegacyStream = -1;
    }

    AudioAttributesImplBase(int v, int v1, int v2, int v3) {
        this.mContentType = v;
        this.mFlags = v1;
        this.mUsage = v2;
        this.mLegacyStream = v3;
    }

    @Override
    public boolean equals(Object object0) {
        return object0 instanceof AudioAttributesImplBase ? this.mContentType == ((AudioAttributesImplBase)object0).getContentType() && this.mFlags == ((AudioAttributesImplBase)object0).getFlags() && this.mUsage == ((AudioAttributesImplBase)object0).getUsage() && this.mLegacyStream == ((AudioAttributesImplBase)object0).mLegacyStream : false;
    }

    public static AudioAttributesImpl fromBundle(Bundle bundle0) {
        if(bundle0 == null) {
            return null;
        }
        int v = bundle0.getInt("androidx.media.audio_attrs.USAGE", 0);
        return new AudioAttributesImplBase(bundle0.getInt("androidx.media.audio_attrs.CONTENT_TYPE", 0), bundle0.getInt("androidx.media.audio_attrs.FLAGS", 0), v, bundle0.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    @Override  // androidx.media.AudioAttributesImpl
    public Object getAudioAttributes() {
        return null;
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.mContentType;
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getFlags() {
        int v = this.mFlags;
        int v1 = this.getLegacyStreamType();
        if(v1 == 6) {
            return (v | 4) & 273;
        }
        if(v1 == 7) {
            v |= 1;
        }
        return v & 273;
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int v = this.mLegacyStream;
        return v == -1 ? AudioAttributesCompat.toVolumeStreamType(false, this.mFlags, this.mUsage) : v;
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.mLegacyStream;
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.mUsage;
    }

    @Override  // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        return AudioAttributesCompat.toVolumeStreamType(true, this.mFlags, this.mUsage);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream});
    }

    @Override  // androidx.media.AudioAttributesImpl
    public Bundle toBundle() {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("androidx.media.audio_attrs.USAGE", this.mUsage);
        bundle0.putInt("androidx.media.audio_attrs.CONTENT_TYPE", this.mContentType);
        bundle0.putInt("androidx.media.audio_attrs.FLAGS", this.mFlags);
        int v = this.mLegacyStream;
        if(v != -1) {
            bundle0.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", v);
        }
        return bundle0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("AudioAttributesCompat:");
        if(this.mLegacyStream != -1) {
            stringBuilder0.append(" stream=");
            stringBuilder0.append(this.mLegacyStream);
            stringBuilder0.append(" derived");
        }
        stringBuilder0.append(" usage=");
        stringBuilder0.append(AudioAttributesCompat.usageToString(this.mUsage));
        stringBuilder0.append(" content=");
        stringBuilder0.append(this.mContentType);
        stringBuilder0.append(" flags=0x");
        stringBuilder0.append(Integer.toHexString(this.mFlags).toUpperCase());
        return stringBuilder0.toString();
    }
}

