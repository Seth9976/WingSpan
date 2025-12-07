package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final class DefaultHeartBeatController..ExternalSyntheticLambda4 implements Provider {
    public final Context f$0;
    public final String f$1;

    public DefaultHeartBeatController..ExternalSyntheticLambda4(Context context0, String s) {
        this.f$0 = context0;
        this.f$1 = s;
    }

    @Override  // com.google.firebase.inject.Provider
    public final Object get() {
        return DefaultHeartBeatController.lambda$new$3(this.f$0, this.f$1);
    }
}

