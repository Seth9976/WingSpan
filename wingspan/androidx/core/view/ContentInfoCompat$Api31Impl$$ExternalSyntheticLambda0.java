package androidx.core.view;

import android.content.ClipData.Item;
import androidx.core.util.Predicate;

public final class ContentInfoCompat.Api31Impl..ExternalSyntheticLambda0 implements Predicate {
    public final java.util.function.Predicate f$0;

    public ContentInfoCompat.Api31Impl..ExternalSyntheticLambda0(java.util.function.Predicate predicate0) {
        this.f$0 = predicate0;
    }

    @Override  // androidx.core.util.Predicate
    public final boolean test(Object object0) {
        return this.f$0.test(((ClipData.Item)object0));
    }
}

