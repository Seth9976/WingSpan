package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int audioStream;
    public int controlType;
    public int currentVolume;
    public int maxVolume;
    public int volumeType;

    static {
        ParcelableVolumeInfo.CREATOR = new Parcelable.Creator() {
            public ParcelableVolumeInfo createFromParcel(Parcel parcel0) {
                return new ParcelableVolumeInfo(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public ParcelableVolumeInfo[] newArray(int v) {
                return new ParcelableVolumeInfo[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public ParcelableVolumeInfo(int v, int v1, int v2, int v3, int v4) {
        this.volumeType = v;
        this.audioStream = v1;
        this.controlType = v2;
        this.maxVolume = v3;
        this.currentVolume = v4;
    }

    public ParcelableVolumeInfo(Parcel parcel0) {
        this.volumeType = parcel0.readInt();
        this.controlType = parcel0.readInt();
        this.maxVolume = parcel0.readInt();
        this.currentVolume = parcel0.readInt();
        this.audioStream = parcel0.readInt();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.volumeType);
        parcel0.writeInt(this.controlType);
        parcel0.writeInt(this.maxVolume);
        parcel0.writeInt(this.currentVolume);
        parcel0.writeInt(this.audioStream);
    }
}

