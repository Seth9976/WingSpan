package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;

final class zbb implements ResultConverter {
    private zbb() {
        throw null;
    }

    zbb(zba zba0) {
    }

    @Override  // com.google.android.gms.common.internal.PendingResultUtil$ResultConverter
    public final Object convert(Result result0) {
        return ((GoogleSignInResult)result0).getSignInAccount();
    }
}

