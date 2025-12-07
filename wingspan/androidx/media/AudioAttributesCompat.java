package androidx.media;

import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class AudioAttributesCompat implements VersionedParcelable {
    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttributeUsage {
    }

    static abstract class AudioManagerHidden {
        public static final int STREAM_ACCESSIBILITY = 10;
        public static final int STREAM_BLUETOOTH_SCO = 6;
        public static final int STREAM_SYSTEM_ENFORCED = 7;
        public static final int STREAM_TTS = 9;

    }

    public static class Builder {
        private int mContentType;
        private int mFlags;
        private int mLegacyStream;
        private int mUsage;

        public Builder() {
            this.mUsage = 0;
            this.mContentType = 0;
            this.mFlags = 0;
            this.mLegacyStream = -1;
        }

        public Builder(AudioAttributesCompat audioAttributesCompat0) {
            this.mContentType = 0;
            this.mFlags = 0;
            this.mLegacyStream = -1;
            this.mUsage = audioAttributesCompat0.getUsage();
            this.mContentType = audioAttributesCompat0.getContentType();
            this.mFlags = audioAttributesCompat0.getFlags();
            this.mLegacyStream = audioAttributesCompat0.getRawLegacyStreamType();
        }

        public AudioAttributesCompat build() {
            if(!AudioAttributesCompat.sForceLegacyBehavior) {
                AudioAttributes.Builder audioAttributes$Builder0 = new AudioAttributes.Builder().setContentType(this.mContentType).setFlags(this.mFlags).setUsage(this.mUsage);
                int v = this.mLegacyStream;
                if(v != -1) {
                    audioAttributes$Builder0.setLegacyStreamType(v);
                }
                return new AudioAttributesCompat(new AudioAttributesImplApi21(audioAttributes$Builder0.build(), this.mLegacyStream));
            }
            return new AudioAttributesCompat(new AudioAttributesImplBase(this.mContentType, this.mFlags, this.mUsage, this.mLegacyStream));
        }

        public Builder setContentType(int v) {
            if(v != 0 && v != 1 && v != 2 && v != 3 && v != 4) {
                this.mUsage = 0;
                return this;
            }
            this.mContentType = v;
            return this;
        }

        public Builder setFlags(int v) {
            this.mFlags |= v & 0x3FF;
            return this;
        }

        Builder setInternalLegacyStreamType(int v) {
            switch(v) {
                case 0: {
                    this.mContentType = 1;
                    break;
                }
                case 1: {
                    this.mContentType = 4;
                    break;
                }
                case 2: {
                    this.mContentType = 4;
                    break;
                }
                case 3: {
                    this.mContentType = 2;
                    break;
                }
                case 4: {
                    this.mContentType = 4;
                    break;
                }
                case 5: {
                    this.mContentType = 4;
                    break;
                }
                case 6: {
                    this.mContentType = 1;
                    this.mFlags |= 4;
                    break;
                }
                case 7: {
                    this.mFlags |= 1;
                    this.mContentType = 4;
                    break;
                }
                case 8: {
                    this.mContentType = 4;
                    break;
                }
                case 9: {
                    this.mContentType = 4;
                    break;
                }
                case 10: {
                    this.mContentType = 1;
                    break;
                }
                default: {
                    Log.e("AudioAttributesCompat", "Invalid stream type " + v + " for AudioAttributesCompat");
                }
            }
            this.mUsage = AudioAttributesCompat.usageForStreamType(v);
            return this;
        }

        public Builder setLegacyStreamType(int v) {
            if(v == 10) {
                throw new IllegalArgumentException("STREAM_ACCESSIBILITY is not a legacy stream type that was used for audio playback");
            }
            this.mLegacyStream = v;
            return this.setInternalLegacyStreamType(v);
        }

        public Builder setUsage(int v) {
            switch(v) {
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: {
                    this.mUsage = v;
                    return this;
                }
                case 16: {
                    if(!AudioAttributesCompat.sForceLegacyBehavior && Build.VERSION.SDK_INT > 25) {
                        this.mUsage = 16;
                        return this;
                    }
                    this.mUsage = 12;
                    return this;
                }
                default: {
                    this.mUsage = 0;
                    return this;
                }
            }
        }
    }

    static final String AUDIO_ATTRIBUTES_CONTENT_TYPE = "androidx.media.audio_attrs.CONTENT_TYPE";
    static final String AUDIO_ATTRIBUTES_FLAGS = "androidx.media.audio_attrs.FLAGS";
    static final String AUDIO_ATTRIBUTES_FRAMEWORKS = "androidx.media.audio_attrs.FRAMEWORKS";
    static final String AUDIO_ATTRIBUTES_LEGACY_STREAM_TYPE = "androidx.media.audio_attrs.LEGACY_STREAM_TYPE";
    static final String AUDIO_ATTRIBUTES_USAGE = "androidx.media.audio_attrs.USAGE";
    public static final int CONTENT_TYPE_MOVIE = 3;
    public static final int CONTENT_TYPE_MUSIC = 2;
    public static final int CONTENT_TYPE_SONIFICATION = 4;
    public static final int CONTENT_TYPE_SPEECH = 1;
    public static final int CONTENT_TYPE_UNKNOWN = 0;
    static final int FLAG_ALL = 0x3FF;
    static final int FLAG_ALL_PUBLIC = 273;
    public static final int FLAG_AUDIBILITY_ENFORCED = 1;
    static final int FLAG_BEACON = 8;
    static final int FLAG_BYPASS_INTERRUPTION_POLICY = 0x40;
    static final int FLAG_BYPASS_MUTE = 0x80;
    static final int FLAG_DEEP_BUFFER = 0x200;
    public static final int FLAG_HW_AV_SYNC = 16;
    static final int FLAG_HW_HOTWORD = 0x20;
    static final int FLAG_LOW_LATENCY = 0x100;
    static final int FLAG_SCO = 4;
    static final int FLAG_SECURE = 2;
    static final int INVALID_STREAM_TYPE = -1;
    private static final int[] SDK_USAGES = null;
    private static final int SUPPRESSIBLE_CALL = 2;
    private static final int SUPPRESSIBLE_NOTIFICATION = 1;
    private static final SparseIntArray SUPPRESSIBLE_USAGES = null;
    private static final String TAG = "AudioAttributesCompat";
    public static final int USAGE_ALARM = 4;
    public static final int USAGE_ASSISTANCE_ACCESSIBILITY = 11;
    public static final int USAGE_ASSISTANCE_NAVIGATION_GUIDANCE = 12;
    public static final int USAGE_ASSISTANCE_SONIFICATION = 13;
    public static final int USAGE_ASSISTANT = 16;
    public static final int USAGE_GAME = 14;
    public static final int USAGE_MEDIA = 1;
    public static final int USAGE_NOTIFICATION = 5;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_DELAYED = 9;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_INSTANT = 8;
    public static final int USAGE_NOTIFICATION_COMMUNICATION_REQUEST = 7;
    public static final int USAGE_NOTIFICATION_EVENT = 10;
    public static final int USAGE_NOTIFICATION_RINGTONE = 6;
    public static final int USAGE_UNKNOWN = 0;
    private static final int USAGE_VIRTUAL_SOURCE = 15;
    public static final int USAGE_VOICE_COMMUNICATION = 2;
    public static final int USAGE_VOICE_COMMUNICATION_SIGNALLING = 3;
    AudioAttributesImpl mImpl;
    static boolean sForceLegacyBehavior;

    static {
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        AudioAttributesCompat.SUPPRESSIBLE_USAGES = sparseIntArray0;
        sparseIntArray0.put(5, 1);
        sparseIntArray0.put(6, 2);
        sparseIntArray0.put(7, 2);
        sparseIntArray0.put(8, 1);
        sparseIntArray0.put(9, 1);
        sparseIntArray0.put(10, 1);
        AudioAttributesCompat.SDK_USAGES = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    AudioAttributesCompat() {
    }

    AudioAttributesCompat(AudioAttributesImpl audioAttributesImpl0) {
        this.mImpl = audioAttributesImpl0;
    }

    @Override
    public boolean equals(Object object0) {
        if(!(object0 instanceof AudioAttributesCompat)) {
            return false;
        }
        return this.mImpl == null ? ((AudioAttributesCompat)object0).mImpl == null : this.mImpl.equals(((AudioAttributesCompat)object0).mImpl);
    }

    public static AudioAttributesCompat fromBundle(Bundle bundle0) {
        AudioAttributesImpl audioAttributesImpl0 = AudioAttributesImplApi21.fromBundle(bundle0);
        return audioAttributesImpl0 == null ? null : new AudioAttributesCompat(audioAttributesImpl0);
    }

    public int getContentType() {
        return this.mImpl.getContentType();
    }

    public int getFlags() {
        return this.mImpl.getFlags();
    }

    public int getLegacyStreamType() {
        return this.mImpl.getLegacyStreamType();
    }

    int getRawLegacyStreamType() {
        return this.mImpl.getRawLegacyStreamType();
    }

    public int getUsage() {
        return this.mImpl.getUsage();
    }

    public int getVolumeControlStream() {
        return this.mImpl.getVolumeControlStream();
    }

    @Override
    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public static void setForceLegacyBehavior(boolean z) {
        AudioAttributesCompat.sForceLegacyBehavior = z;
    }

    public Bundle toBundle() {
        return this.mImpl.toBundle();
    }

    @Override
    public String toString() {
        return this.mImpl.toString();
    }

    static int toVolumeStreamType(boolean z, int v, int v1) {
        if((v & 1) == 1) {
            return z ? 1 : 7;
        }
        if((v & 4) == 4) {
            return z ? 0 : 6;
        }
        switch(v1) {
            case 0: {
                return z ? 0x80000000 : 3;
            }
            case 2: {
                return 0;
            }
            case 3: {
                return z ? 0 : 8;
            }
            case 4: {
                return 4;
            }
            case 6: {
                return 2;
            }
            case 5: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return 5;
            }
            case 11: {
                return 10;
            }
            case 13: {
                return 1;
            }
            case 1: 
            case 12: 
            case 14: 
            case 16: {
                return 3;
            }
            default: {
                if(z) {
                    throw new IllegalArgumentException("Unknown usage value " + v1 + " in audio attributes");
                }
                return 3;
            }
        }
    }

    static int toVolumeStreamType(boolean z, AudioAttributesCompat audioAttributesCompat0) {
        return AudioAttributesCompat.toVolumeStreamType(z, audioAttributesCompat0.getFlags(), audioAttributesCompat0.getUsage());
    }

    public Object unwrap() {
        return this.mImpl.getAudioAttributes();
    }

    static int usageForStreamType(int v) {
        switch(v) {
            case 0: {
                return 2;
            }
            case 2: {
                return 6;
            }
            case 3: {
                return 1;
            }
            case 4: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 6: {
                return 2;
            }
            case 1: 
            case 7: {
                return 13;
            }
            case 8: {
                return 3;
            }
            case 10: {
                return 11;
            }
            default: {
                return 0;
            }
        }
    }

    static String usageToString(int v) {
        switch(v) {
            case 0: {
                return "USAGE_UNKNOWN";
            }
            case 1: {
                return "USAGE_MEDIA";
            }
            case 2: {
                return "USAGE_VOICE_COMMUNICATION";
            }
            case 3: {
                return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
            }
            case 4: {
                return "USAGE_ALARM";
            }
            case 5: {
                return "USAGE_NOTIFICATION";
            }
            case 6: {
                return "USAGE_NOTIFICATION_RINGTONE";
            }
            case 7: {
                return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
            }
            case 8: {
                return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
            }
            case 9: {
                return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
            }
            case 10: {
                return "USAGE_NOTIFICATION_EVENT";
            }
            case 11: {
                return "USAGE_ASSISTANCE_ACCESSIBILITY";
            }
            case 12: {
                return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
            }
            case 13: {
                return "USAGE_ASSISTANCE_SONIFICATION";
            }
            case 14: {
                return "USAGE_GAME";
            }
            case 16: {
                return "USAGE_ASSISTANT";
            }
            default: {
                return "unknown usage " + v;
            }
        }
    }

    public static AudioAttributesCompat wrap(Object object0) {
        if(!AudioAttributesCompat.sForceLegacyBehavior) {
            AudioAttributesImplApi21 audioAttributesImplApi210 = new AudioAttributesImplApi21(((AudioAttributes)object0));
            AudioAttributesCompat audioAttributesCompat0 = new AudioAttributesCompat();
            audioAttributesCompat0.mImpl = audioAttributesImplApi210;
            return audioAttributesCompat0;
        }
        return null;
    }
}

