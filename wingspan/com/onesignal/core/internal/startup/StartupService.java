package com.onesignal.core.internal.startup;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001A\u00020\tJ\u0006\u0010\n\u001A\u00020\tR\u0014\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2 = {"Lcom/onesignal/core/internal/startup/StartupService;", "", "_bootstrapServices", "", "Lcom/onesignal/core/internal/startup/IBootstrapService;", "_startableServices", "Lcom/onesignal/core/internal/startup/IStartableService;", "(Ljava/util/List;Ljava/util/List;)V", "bootstrap", "", "start", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class StartupService {
    private final List _bootstrapServices;
    private final List _startableServices;

    public StartupService(List list0, List list1) {
        Intrinsics.checkNotNullParameter(list0, "_bootstrapServices");
        Intrinsics.checkNotNullParameter(list1, "_startableServices");
        super();
        this._bootstrapServices = list0;
        this._startableServices = list1;
    }

    public final void bootstrap() {
        for(Object object0: this._bootstrapServices) {
            ((IBootstrapService)object0).bootstrap();
        }
    }

    public final void start() {
        for(Object object0: this._startableServices) {
            ((IStartableService)object0).start();
        }
    }
}

