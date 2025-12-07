package com.onesignal.common.modeling;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\r\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001A\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0013\u0010\b\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001A\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\rR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/onesignal/common/modeling/ModelChangedArgs;", "", "model", "Lcom/onesignal/common/modeling/Model;", "path", "", "property", "oldValue", "newValue", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "getModel", "()Lcom/onesignal/common/modeling/Model;", "getNewValue", "()Ljava/lang/Object;", "getOldValue", "getPath", "()Ljava/lang/String;", "getProperty", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class ModelChangedArgs {
    private final Model model;
    private final Object newValue;
    private final Object oldValue;
    private final String path;
    private final String property;

    public ModelChangedArgs(Model model0, String s, String s1, Object object0, Object object1) {
        Intrinsics.checkNotNullParameter(model0, "model");
        Intrinsics.checkNotNullParameter(s, "path");
        Intrinsics.checkNotNullParameter(s1, "property");
        super();
        this.model = model0;
        this.path = s;
        this.property = s1;
        this.oldValue = object0;
        this.newValue = object1;
    }

    public final Model getModel() {
        return this.model;
    }

    public final Object getNewValue() {
        return this.newValue;
    }

    public final Object getOldValue() {
        return this.oldValue;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getProperty() {
        return this.property;
    }
}

