package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel0) {
        AudioAttributesCompat audioAttributesCompat0 = new AudioAttributesCompat();
        audioAttributesCompat0.mImpl = (AudioAttributesImpl)versionedParcel0.readVersionedParcelable(audioAttributesCompat0.mImpl, 1);
        return audioAttributesCompat0;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat0, VersionedParcel versionedParcel0) {
        versionedParcel0.setSerializationFlags(false, false);
        versionedParcel0.writeVersionedParcelable(audioAttributesCompat0.mImpl, 1);
    }
}

