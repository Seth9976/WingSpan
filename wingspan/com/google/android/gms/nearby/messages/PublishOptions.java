package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Preconditions;

public final class PublishOptions {
    public static class Builder {
        private Strategy zzfk;
        private PublishCallback zzfl;

        public Builder() {
            this.zzfk = Strategy.DEFAULT;
        }

        public PublishOptions build() {
            return new PublishOptions(this.zzfk, this.zzfl, null);
        }

        public Builder setCallback(PublishCallback publishCallback0) {
            this.zzfl = (PublishCallback)Preconditions.checkNotNull(publishCallback0);
            return this;
        }

        public Builder setStrategy(Strategy strategy0) {
            this.zzfk = (Strategy)Preconditions.checkNotNull(strategy0);
            return this;
        }
    }

    public static final PublishOptions DEFAULT;
    private final Strategy zzfk;
    private final PublishCallback zzfl;

    static {
        PublishOptions.DEFAULT = new Builder().build();
    }

    private PublishOptions(Strategy strategy0, PublishCallback publishCallback0) {
        this.zzfk = strategy0;
        this.zzfl = publishCallback0;
    }

    PublishOptions(Strategy strategy0, PublishCallback publishCallback0, zzf zzf0) {
        this(strategy0, publishCallback0);
    }

    public final PublishCallback getCallback() {
        return this.zzfl;
    }

    public final Strategy getStrategy() {
        return this.zzfk;
    }
}

