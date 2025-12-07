package androidx.work;

import java.util.HashMap;
import java.util.List;

public final class OverwritingInputMerger extends InputMerger {
    @Override  // androidx.work.InputMerger
    public Data merge(List inputs) {
        Builder data$Builder0 = new Builder();
        HashMap hashMap0 = new HashMap();
        for(Object object0: inputs) {
            hashMap0.putAll(((Data)object0).getKeyValueMap());
        }
        data$Builder0.putAll(hashMap0);
        return data$Builder0.build();
    }
}

