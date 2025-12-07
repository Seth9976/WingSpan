package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final Intent mData;
    private final int mResultCode;

    static {
        ActivityResult.CREATOR = new Parcelable.Creator() {
            public ActivityResult createFromParcel(Parcel parcel0) {
                return new ActivityResult(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public ActivityResult[] newArray(int v) {
                return new ActivityResult[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public ActivityResult(int v, Intent intent0) {
        this.mResultCode = v;
        this.mData = intent0;
    }

    ActivityResult(Parcel parcel0) {
        this.mResultCode = parcel0.readInt();
        this.mData = parcel0.readInt() == 0 ? null : ((Intent)Intent.CREATOR.createFromParcel(parcel0));
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public static String resultCodeToString(int v) {
        switch(v) {
            case -1: {
                return "RESULT_OK";
            }
            case 0: {
                return "RESULT_CANCELED";
            }
            default: {
                return String.valueOf(v);
            }
        }
    }

    @Override
    public String toString() {
        return "ActivityResult{resultCode=" + ActivityResult.resultCodeToString(this.mResultCode) + ", data=" + this.mData + '}';
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeInt(this.mResultCode);
        parcel0.writeInt((this.mData == null ? 0 : 1));
        Intent intent0 = this.mData;
        if(intent0 != null) {
            intent0.writeToParcel(parcel0, v);
        }
    }
}

