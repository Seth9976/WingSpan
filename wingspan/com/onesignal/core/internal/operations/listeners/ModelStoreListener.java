package com.onesignal.core.internal.operations.listeners;

import com.onesignal.common.modeling.IModelStore;
import com.onesignal.common.modeling.IModelStoreChangeHandler;
import com.onesignal.common.modeling.Model;
import com.onesignal.common.modeling.ModelChangedArgs;
import com.onesignal.core.internal.operations.IOperationRepo.DefaultImpls;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.operations.Operation;
import com.onesignal.core.internal.startup.IBootstrapService;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005B\u001B\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001A\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000B\u001A\u00020\fH\u0016J\b\u0010\r\u001A\u00020\fH\u0016J\u0017\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\u0017\u0010\u0012\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0011J;\u0010\u0013\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0010\u001A\u00028\u00002\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00152\b\u0010\u0017\u001A\u0004\u0018\u00010\u00182\b\u0010\u0019\u001A\u0004\u0018\u00010\u0018H&¢\u0006\u0002\u0010\u001AJ\u001D\u0010\u001B\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00028\u00002\u0006\u0010\u001C\u001A\u00020\u0015H\u0016¢\u0006\u0002\u0010\u001DJ\u001D\u0010\u001E\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00028\u00002\u0006\u0010\u001C\u001A\u00020\u0015H\u0016¢\u0006\u0002\u0010\u001DJ\u0018\u0010\u001F\u001A\u00020\f2\u0006\u0010 \u001A\u00020!2\u0006\u0010\u001C\u001A\u00020\u0015H\u0016R\u000E\u0010\b\u001A\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001A\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/onesignal/core/internal/operations/listeners/ModelStoreListener;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "Lcom/onesignal/core/internal/startup/IBootstrapService;", "Ljava/io/Closeable;", "store", "Lcom/onesignal/common/modeling/IModelStore;", "opRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "(Lcom/onesignal/common/modeling/IModelStore;Lcom/onesignal/core/internal/operations/IOperationRepo;)V", "bootstrap", "", "close", "getAddOperation", "Lcom/onesignal/core/internal/operations/Operation;", "model", "(Lcom/onesignal/common/modeling/Model;)Lcom/onesignal/core/internal/operations/Operation;", "getRemoveOperation", "getUpdateOperation", "path", "", "property", "oldValue", "", "newValue", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/onesignal/core/internal/operations/Operation;", "onModelAdded", "tag", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "onModelRemoved", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public abstract class ModelStoreListener implements IModelStoreChangeHandler, IBootstrapService, Closeable {
    private final IOperationRepo opRepo;
    private final IModelStore store;

    public ModelStoreListener(IModelStore iModelStore0, IOperationRepo iOperationRepo0) {
        Intrinsics.checkNotNullParameter(iModelStore0, "store");
        Intrinsics.checkNotNullParameter(iOperationRepo0, "opRepo");
        super();
        this.store = iModelStore0;
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

    public abstract Operation getAddOperation(Model arg1);

    public abstract Operation getRemoveOperation(Model arg1);

    public abstract Operation getUpdateOperation(Model arg1, String arg2, String arg3, Object arg4, Object arg5);

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelAdded(Model model0, String s) {
        Intrinsics.checkNotNullParameter(model0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(!Intrinsics.areEqual(s, "NORMAL")) {
            return;
        }
        Operation operation0 = this.getAddOperation(model0);
        if(operation0 != null) {
            DefaultImpls.enqueue$default(this.opRepo, operation0, false, 2, null);
        }
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelRemoved(Model model0, String s) {
        Intrinsics.checkNotNullParameter(model0, "model");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(!Intrinsics.areEqual(s, "NORMAL")) {
            return;
        }
        Operation operation0 = this.getRemoveOperation(model0);
        if(operation0 != null) {
            DefaultImpls.enqueue$default(this.opRepo, operation0, false, 2, null);
        }
    }

    @Override  // com.onesignal.common.modeling.IModelStoreChangeHandler
    public void onModelUpdated(ModelChangedArgs modelChangedArgs0, String s) {
        Intrinsics.checkNotNullParameter(modelChangedArgs0, "args");
        Intrinsics.checkNotNullParameter(s, "tag");
        if(!Intrinsics.areEqual(s, "NORMAL")) {
            return;
        }
        Model model0 = modelChangedArgs0.getModel();
        Intrinsics.checkNotNull(model0, "null cannot be cast to non-null type TModel of com.onesignal.core.internal.operations.listeners.ModelStoreListener");
        Operation operation0 = this.getUpdateOperation(model0, modelChangedArgs0.getPath(), modelChangedArgs0.getProperty(), modelChangedArgs0.getOldValue(), modelChangedArgs0.getNewValue());
        if(operation0 != null) {
            DefaultImpls.enqueue$default(this.opRepo, operation0, false, 2, null);
        }
    }
}

