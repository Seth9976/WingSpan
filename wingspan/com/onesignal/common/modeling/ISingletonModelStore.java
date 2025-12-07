package com.onesignal.common.modeling;

import com.onesignal.common.events.IEventNotifier;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00040\u0003J\u001F\u0010\b\u001A\u00020\t2\u0006\u0010\u0005\u001A\u00028\u00002\b\b\u0002\u0010\n\u001A\u00020\u000BH&¢\u0006\u0002\u0010\fR\u0012\u0010\u0005\u001A\u00028\u0000X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/onesignal/common/modeling/ISingletonModelStore;", "TModel", "Lcom/onesignal/common/modeling/Model;", "Lcom/onesignal/common/events/IEventNotifier;", "Lcom/onesignal/common/modeling/ISingletonModelStoreChangeHandler;", "model", "getModel", "()Lcom/onesignal/common/modeling/Model;", "replace", "", "tag", "", "(Lcom/onesignal/common/modeling/Model;Ljava/lang/String;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public interface ISingletonModelStore extends IEventNotifier {
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 0x30)
    public static final class DefaultImpls {
        public static void replace$default(ISingletonModelStore iSingletonModelStore0, Model model0, String s, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replace");
            }
            if((v & 2) != 0) {
                s = "NORMAL";
            }
            iSingletonModelStore0.replace(model0, s);
        }
    }

    Model getModel();

    void replace(Model arg1, String arg2);
}

