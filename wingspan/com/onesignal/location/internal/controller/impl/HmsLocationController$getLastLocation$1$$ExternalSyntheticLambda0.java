package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.huawei.hmf.tasks.OnSuccessListener;
import kotlin.jvm.internal.Ref.ObjectRef;

public final class HmsLocationController.getLastLocation.1..ExternalSyntheticLambda0 implements OnSuccessListener {
    public final ObjectRef f$0;
    public final ObjectRef f$1;

    public HmsLocationController.getLastLocation.1..ExternalSyntheticLambda0(ObjectRef ref$ObjectRef0, ObjectRef ref$ObjectRef1) {
        this.f$0 = ref$ObjectRef0;
        this.f$1 = ref$ObjectRef1;
    }

    public final void onSuccess(Object object0) {
        com.onesignal.location.internal.controller.impl.HmsLocationController.getLastLocation.1.$r8$lambda$JaO3AQXpIVKGWpWcJkUEDdPtq0g(this.f$0, this.f$1, ((Location)object0));
    }
}

