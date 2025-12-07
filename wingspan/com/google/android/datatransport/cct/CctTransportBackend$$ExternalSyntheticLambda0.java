package com.google.android.datatransport.cct;

import com.google.android.datatransport.runtime.retries.Function;

public final class CctTransportBackend..ExternalSyntheticLambda0 implements Function {
    public final CctTransportBackend f$0;

    public CctTransportBackend..ExternalSyntheticLambda0(CctTransportBackend cctTransportBackend0) {
        this.f$0 = cctTransportBackend0;
    }

    @Override  // com.google.android.datatransport.runtime.retries.Function
    public final Object apply(Object object0) {
        return this.f$0.doSend(((HttpRequest)object0));
    }
}

