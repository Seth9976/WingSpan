package com.onesignal.user.internal.operations.impl.listeners;

import com.onesignal.common.modeling.Model;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener;
import com.onesignal.user.internal.operations.DeleteTagOperation;
import com.onesignal.user.internal.operations.SetPropertyOperation;
import com.onesignal.user.internal.operations.SetTagOperation;
import com.onesignal.user.internal.properties.PropertiesModel;
import com.onesignal.user.internal.properties.PropertiesModelStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001D\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\u0006\u0010\u0005\u001A\u00020\u0006\u0012\u0006\u0010\u0007\u001A\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\n\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\u0002H\u0016J6\u0010\r\u001A\u0004\u0018\u00010\u000B2\u0006\u0010\f\u001A\u00020\u00022\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00122\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012H\u0016R\u000E\u0010\u0007\u001A\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/onesignal/user/internal/operations/impl/listeners/PropertiesModelStoreListener;", "Lcom/onesignal/core/internal/operations/listeners/SingletonModelStoreListener;", "Lcom/onesignal/user/internal/properties/PropertiesModel;", "store", "Lcom/onesignal/user/internal/properties/PropertiesModelStore;", "opRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/user/internal/properties/PropertiesModelStore;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "getReplaceOperation", "Lcom/onesignal/core/internal/operations/Operation;", "model", "getUpdateOperation", "path", "", "property", "oldValue", "", "newValue", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class PropertiesModelStoreListener extends SingletonModelStoreListener {
    private final ConfigModelStore _configModelStore;

    public PropertiesModelStoreListener(PropertiesModelStore propertiesModelStore0, IOperationRepo iOperationRepo0, ConfigModelStore configModelStore0) {
        Intrinsics.checkNotNullParameter(propertiesModelStore0, "store");
        Intrinsics.checkNotNullParameter(iOperationRepo0, "opRepo");
        Intrinsics.checkNotNullParameter(configModelStore0, "_configModelStore");
        super(propertiesModelStore0, iOperationRepo0);
        this._configModelStore = configModelStore0;
    }

    @Override  // com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener
    public Operation getReplaceOperation(Model model0) {
        return this.getReplaceOperation(((PropertiesModel)model0));
    }

    public Operation getReplaceOperation(PropertiesModel propertiesModel0) {
        Intrinsics.checkNotNullParameter(propertiesModel0, "model");
        return null;
    }

    @Override  // com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener
    public Operation getUpdateOperation(Model model0, String s, String s1, Object object0, Object object1) {
        return this.getUpdateOperation(((PropertiesModel)model0), s, s1, object0, object1);
    }

    public Operation getUpdateOperation(PropertiesModel propertiesModel0, String s, String s1, Object object0, Object object1) {
        Intrinsics.checkNotNullParameter(propertiesModel0, "model");
        Intrinsics.checkNotNullParameter(s, "path");
        Intrinsics.checkNotNullParameter(s1, "property");
        if(!StringsKt.startsWith$default(s, "locationTimestamp", false, 2, null) && !StringsKt.startsWith$default(s, "locationBackground", false, 2, null) && !StringsKt.startsWith$default(s, "locationType", false, 2, null) && !StringsKt.startsWith$default(s, "locationAccuracy", false, 2, null)) {
            if(StringsKt.startsWith$default(s, "tags", false, 2, null)) {
                return object1 != null && object1 instanceof String ? new SetTagOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), propertiesModel0.getOnesignalId(), s1, ((String)object1)) : new DeleteTagOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), propertiesModel0.getOnesignalId(), s1);
            }
            return new SetPropertyOperation(((ConfigModel)this._configModelStore.getModel()).getAppId(), propertiesModel0.getOnesignalId(), s1, object1);
        }
        return null;
    }
}

