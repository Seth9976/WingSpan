package androidx.activity.result;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public final class IntentSenderRequest implements Parcelable {
    public static final class Builder {
        private Intent mFillInIntent;
        private int mFlagsMask;
        private int mFlagsValues;
        private IntentSender mIntentSender;

        public Builder(PendingIntent pendingIntent0) {
            this(pendingIntent0.getIntentSender());
        }

        public Builder(IntentSender intentSender0) {
            this.mIntentSender = intentSender0;
        }

        public IntentSenderRequest build() {
            return new IntentSenderRequest(this.mIntentSender, this.mFillInIntent, this.mFlagsMask, this.mFlagsValues);
        }

        public Builder setFillInIntent(Intent intent0) {
            this.mFillInIntent = intent0;
            return this;
        }

        public Builder setFlags(int v, int v1) {
            this.mFlagsValues = v;
            this.mFlagsMask = v1;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;
    private final IntentSender mIntentSender;

    static {
        IntentSenderRequest.CREATOR = new Parcelable.Creator() {
            public IntentSenderRequest createFromParcel(Parcel parcel0) {
                return new IntentSenderRequest(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public IntentSenderRequest[] newArray(int v) {
                return new IntentSenderRequest[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    IntentSenderRequest(IntentSender intentSender0, Intent intent0, int v, int v1) {
        this.mIntentSender = intentSender0;
        this.mFillInIntent = intent0;
        this.mFlagsMask = v;
        this.mFlagsValues = v1;
    }

    IntentSenderRequest(Parcel parcel0) {
        this.mIntentSender = (IntentSender)parcel0.readParcelable(IntentSender.class.getClassLoader());
        this.mFillInIntent = (Intent)parcel0.readParcelable(Intent.class.getClassLoader());
        this.mFlagsMask = parcel0.readInt();
        this.mFlagsValues = parcel0.readInt();
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    public IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeParcelable(this.mIntentSender, v);
        parcel0.writeParcelable(this.mFillInIntent, v);
        parcel0.writeInt(this.mFlagsMask);
        parcel0.writeInt(this.mFlagsValues);
    }
}

