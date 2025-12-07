package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Preconditions;

public final class SubscribeOptions {
    public static class Builder {
        private Strategy zzfk;
        private MessageFilter zzfz;
        private SubscribeCallback zzga;

        public Builder() {
            this.zzfk = Strategy.DEFAULT;
            this.zzfz = MessageFilter.INCLUDE_ALL_MY_TYPES;
        }

        public SubscribeOptions build() {
            return new SubscribeOptions(this.zzfk, this.zzfz, this.zzga, false, 0, null);
        }

        public Builder setCallback(SubscribeCallback subscribeCallback0) {
            this.zzga = (SubscribeCallback)Preconditions.checkNotNull(subscribeCallback0);
            return this;
        }

        public Builder setFilter(MessageFilter messageFilter0) {
            this.zzfz = messageFilter0;
            return this;
        }

        public Builder setStrategy(Strategy strategy0) {
            this.zzfk = strategy0;
            return this;
        }
    }

    public static final SubscribeOptions DEFAULT;
    private final Strategy zzfk;
    private final MessageFilter zzfz;
    private final SubscribeCallback zzga;
    public final boolean zzgb;
    public final int zzgc;

    static {
        SubscribeOptions.DEFAULT = new Builder().build();
    }

    private SubscribeOptions(Strategy strategy0, MessageFilter messageFilter0, SubscribeCallback subscribeCallback0, boolean z, int v) {
        this.zzfk = strategy0;
        this.zzfz = messageFilter0;
        this.zzga = subscribeCallback0;
        this.zzgb = z;
        this.zzgc = v;
    }

    SubscribeOptions(Strategy strategy0, MessageFilter messageFilter0, SubscribeCallback subscribeCallback0, boolean z, int v, zzh zzh0) {
        this(strategy0, messageFilter0, subscribeCallback0, false, 0);
    }

    public final SubscribeCallback getCallback() {
        return this.zzga;
    }

    public final MessageFilter getFilter() {
        return this.zzfz;
    }

    public final Strategy getStrategy() {
        return this.zzfk;
    }

    @Override
    public final String toString() {
        return "SubscribeOptions{strategy=" + this.zzfk + ", filter=" + this.zzfz + '}';
    }
}

