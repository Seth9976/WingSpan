package androidx.media;

import android.media.AudioAttributes;
import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(VersionedParcel versionedParcel0) {
        AudioAttributesImplApi21 audioAttributesImplApi210 = new AudioAttributesImplApi21();
        audioAttributesImplApi210.mAudioAttributes = (AudioAttributes)versionedParcel0.readParcelable(audioAttributesImplApi210.mAudioAttributes, 1);
        audioAttributesImplApi210.mLegacyStreamType = versionedParcel0.readInt(audioAttributesImplApi210.mLegacyStreamType, 2);
        return audioAttributesImplApi210;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi210, VersionedParcel versionedParcel0) {
        versionedParcel0.setSerializationFlags(false, false);
        versionedParcel0.writeParcelable(audioAttributesImplApi210.mAudioAttributes, 1);
        versionedParcel0.writeInt(audioAttributesImplApi210.mLegacyStreamType, 2);
    }
}

