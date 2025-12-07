package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel0) {
        AudioAttributesImplBase audioAttributesImplBase0 = new AudioAttributesImplBase();
        audioAttributesImplBase0.mUsage = versionedParcel0.readInt(audioAttributesImplBase0.mUsage, 1);
        audioAttributesImplBase0.mContentType = versionedParcel0.readInt(audioAttributesImplBase0.mContentType, 2);
        audioAttributesImplBase0.mFlags = versionedParcel0.readInt(audioAttributesImplBase0.mFlags, 3);
        audioAttributesImplBase0.mLegacyStream = versionedParcel0.readInt(audioAttributesImplBase0.mLegacyStream, 4);
        return audioAttributesImplBase0;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase0, VersionedParcel versionedParcel0) {
        versionedParcel0.setSerializationFlags(false, false);
        versionedParcel0.writeInt(audioAttributesImplBase0.mUsage, 1);
        versionedParcel0.writeInt(audioAttributesImplBase0.mContentType, 2);
        versionedParcel0.writeInt(audioAttributesImplBase0.mFlags, 3);
        versionedParcel0.writeInt(audioAttributesImplBase0.mLegacyStream, 4);
    }
}

