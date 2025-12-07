package com.google.android.gms.auth.api.identity;

import android.os.Bundle;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.internal.Objects;

public final class zbc implements Optional {
    private final String zba;

    public zbc(String s) {
        this.zba = s;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof zbc;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{zbc.class});
    }

    public final Bundle zba() {
        Bundle bundle0 = new Bundle();
        bundle0.putString("session_id", this.zba);
        return bundle0;
    }

    public final String zbb() {
        return this.zba;
    }
}

