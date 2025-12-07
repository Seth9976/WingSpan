package com.onesignal.core.internal.database.impl;

import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.database.IDatabase;
import com.onesignal.core.internal.database.IDatabaseProvider;
import com.onesignal.session.internal.outcomes.impl.OutcomeTableProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001A\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\nR\u0010\u0010\u000B\u001A\u0004\u0018\u00010\fX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/onesignal/core/internal/database/impl/DatabaseProvider;", "Lcom/onesignal/core/internal/database/IDatabaseProvider;", "_application", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "lock", "", "os", "Lcom/onesignal/core/internal/database/IDatabase;", "getOs", "()Lcom/onesignal/core/internal/database/IDatabase;", "osDatabase", "Lcom/onesignal/core/internal/database/impl/OSDatabase;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class DatabaseProvider implements IDatabaseProvider {
    private final IApplicationService _application;
    private final Object lock;
    private OSDatabase osDatabase;

    public DatabaseProvider(IApplicationService iApplicationService0) {
        Intrinsics.checkNotNullParameter(iApplicationService0, "_application");
        super();
        this._application = iApplicationService0;
        this.lock = new Object();
    }

    @Override  // com.onesignal.core.internal.database.IDatabaseProvider
    public IDatabase getOs() {
        if(this.osDatabase == null) {
            Object object0 = this.lock;
            synchronized(object0) {
                if(this.osDatabase == null) {
                    this.osDatabase = new OSDatabase(new OutcomeTableProvider(), this._application.getAppContext(), 0, 4, null);
                }
            }
        }
        OSDatabase oSDatabase0 = this.osDatabase;
        Intrinsics.checkNotNull(oSDatabase0);
        return oSDatabase0;
    }
}

