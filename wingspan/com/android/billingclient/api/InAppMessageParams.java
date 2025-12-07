package com.android.billingclient.api;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class InAppMessageParams {
    public static final class Builder {
        private final Set zza;

        public Builder() {
            this.zza = new HashSet();
        }

        public Builder addAllInAppMessageCategoriesToShow() {
            this.zza.add(2);
            return this;
        }

        public Builder addInAppMessageCategoryToShow(int v) {
            this.zza.add(v);
            return this;
        }

        public InAppMessageParams build() {
            return new InAppMessageParams(this.zza, null);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InAppMessageCategoryId {
        public static final int TRANSACTIONAL = 2;
        public static final int UNKNOWN_IN_APP_MESSAGE_CATEGORY_ID;

    }

    private final ArrayList zza;

    InAppMessageParams(Set set0, zzcj zzcj0) {
        this.zza = new ArrayList(Collections.unmodifiableList(new ArrayList(set0)));
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    final ArrayList zza() {
        return this.zza;
    }
}

