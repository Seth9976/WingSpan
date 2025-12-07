package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public class MessagesOptions implements Optional {
    public static class Builder {
        private int zzfh;

        public Builder() {
            this.zzfh = -1;
        }

        public MessagesOptions build() {
            return new MessagesOptions(this, null);
        }

        public Builder setPermissions(int v) {
            this.zzfh = v;
            return this;
        }

        static int zza(Builder messagesOptions$Builder0) {
            return messagesOptions$Builder0.zzfh;
        }
    }

    public final String zzff;
    public final boolean zzfg;
    public final int zzfh;
    public final String zzfi;
    public final String zzfj;

    private MessagesOptions(Builder messagesOptions$Builder0) {
        this.zzff = null;
        this.zzfg = false;
        this.zzfh = Builder.zza(messagesOptions$Builder0);
        this.zzfi = null;
        this.zzfj = null;
    }

    MessagesOptions(Builder messagesOptions$Builder0, zze zze0) {
        this(messagesOptions$Builder0);
    }
}

