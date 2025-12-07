package com.onesignal.core.internal.operations.listeners;

import com.onesignal.common.modeling.ISingletonModelStore;
import com.onesignal.common.modeling.ISingletonModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.startup.IBootstrapService;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005B\u001B\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\fH\u0016J\u0017\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0011J;\u0010\u0012\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00028\u00002\u0006\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0016\u001A\u0004\u0018\u00010\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0017H&¢\u0006\u0002\u0010\u0019J\u001D\u0010\u001A\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00028\u00002\u0006\u0010\u001B\u001A\u00020\u0014H\u0016¢\u0006\u0002\u0010\u001CJ\u0018\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010\u001B\u001A\u00020\u0014H\u0016R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/onesignal/core/internal/operations/listeners/SingletonModelStoreListener;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "Lcom/onesignal/core/internal/startup/IBootstrapService;", "Ljava/io/Closeable;", "store", "Lcom/onesignal/common/modeling/ISingletonModelStore;", "opRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "(Lcom/onesignal/common/modeling/ISingletonModelStore;Lcom/onesignal/core/internal/operations/IOperationRepo;)V", "bootstrap", "", "close", "getReplaceOperation", "Lcom/onesignal/core/internal/operations/Operation;", "model", "(Lcom/onesignal/common/modeling/Model;)Lcom/onesignal/core/internal/operations/Operation;", "getUpdateOperation", "path", "", "property", "oldValue", "", "newValue", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/onesignal/core/internal/operations/Operation;", "onModelReplaced", "tag", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class SingletonModelStoreListener implements ISingletonModelStoreChangeHandler, IBootstrapService, Closeable {
    private final IOperationRepo opRepo;
    private final ISingletonModelStore store;

    public SingletonModelStoreListener(ISingletonModelStore iSingletonModelStore0, IOperationRepo iOperationRepo0) {
        Intrinsics.checkNotNullParameter(iSingletonModelStore0, "store");
        Intrinsics.checkNotNullParameter(iOperationRepo0, "opRepo");
        super();
        this.store = iSingletonModelStore0;
        this.opRepo = iOperationRepo0;
    }

    @Override  // com.onesignal.core.internal.startup.IBootstrapService
    public void bootstrap() {
        this.store.subscribe(this);
    }

    @Override
    public void close() {
        this.store.unsubscribe(this);
    }

    public abstract Operation getReplaceOperation(Model arg1);

    public abstract Operation getUpdateOperation(Model arg1, String arg2, String arg3, Object arg4, Object arg5);

    @Override  // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelReplaced(Model model0, String s) {
        Intrinsics.checkNotNullParameter(model0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(!Intrinsics.areEqual(s, "NORMAL")) {
            return;
        }
        Operation operation0 = this.getReplaceOperation(model0);
        if(operation0 != null) {
            DefaultImpls.enqueue$default(this.opRepo, operation0, false, 2, null);
        }
    }

    @Override  // com.onesignal.common.modeling.ISingletonModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs modelChangedArgs0, String s) {
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(!Intrinsics.areEqual(s, "NORMAL")) {
            return;
        }
        Model model0 = modelChangedArgs0.getModel();
        Intrinsics.checkNotNull(model0, "null cannot be cast to non-null type TModel of com.onesignal.core.internal.operations.listeners.SingletonModelStoreListener");
        Operation operation0 = this.getUpdateOperation(model0, modelChangedArgs0.getPath(), modelChangedArgs0.getProperty(), modelChangedArgs0.getOldValue(), modelChangedArgs0.getNewValue());
        if(operation0 != null) {
            DefaultImpls.enqueue$default(this.opRepo, operation0, false, 2, null);
        }
    }
}

