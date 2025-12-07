package com.onesignal.common.modeling;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001D\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00028\u00002\u0006\u0010\u0007\u001A\u00020\bH&¢\u0006\u0002\u0010\tJ\u001D\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00028\u00002\u0006\u0010\u0007\u001A\u00020\bH&¢\u0006\u0002\u0010\tJ\u0018\u0010\u000B\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\bH&¨\u0006\u000E"}, d2 = {"Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "TModel", "Lcom/onesignal/common/modeling/Model;", "", "onModelAdded", "", "model", "tag", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "onModelRemoved", "onModelUpdated", "args", "Lcom/onesignal/common/modeling/ModelChangedArgs;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface IModelStoreChangeHandler {
    void onModelAdded(Model arg1, String arg2);

    void onModelRemoved(Model arg1, String arg2);

    void onModelUpdated(ModelChangedArgs arg1, String arg2);
}

