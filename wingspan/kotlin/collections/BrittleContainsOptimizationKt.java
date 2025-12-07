package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\u001A#\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001A\u001E\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0000\u001A\u001E\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000\u001A,\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0000\u001A\u0018\u0010\t\u001A\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0002¨\u0006\u000B"}, d2 = {"convertToSetForSetOperation", "", "T", "", "([Ljava/lang/Object;)Ljava/util/Collection;", "", "Lkotlin/sequences/Sequence;", "convertToSetForSetOperationWith", "source", "safeToConvertToSet", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 0x30)
public final class BrittleContainsOptimizationKt {
    public static final Collection convertToSetForSetOperation(Iterable iterable0) {
        Intrinsics.checkNotNullParameter(iterable0, "<this>");
        if(iterable0 instanceof Set) {
            return (Collection)iterable0;
        }
        if(iterable0 instanceof Collection) {
            return BrittleContainsOptimizationKt.safeToConvertToSet(((Collection)iterable0)) ? CollectionsKt.toHashSet(iterable0) : ((Collection)iterable0);
        }
        return CollectionSystemProperties.brittleContainsOptimizationEnabled ? CollectionsKt.toHashSet(iterable0) : CollectionsKt.toList(iterable0);
    }

    public static final Collection convertToSetForSetOperation(Sequence sequence0) {
        Intrinsics.checkNotNullParameter(sequence0, "<this>");
        return CollectionSystemProperties.brittleContainsOptimizationEnabled ? SequencesKt.toHashSet(sequence0) : SequencesKt.toList(sequence0);
    }

    public static final Collection convertToSetForSetOperation(Object[] arr_object) {
        Intrinsics.checkNotNullParameter(arr_object, "<this>");
        return CollectionSystemProperties.brittleContainsOptimizationEnabled ? ArraysKt.toHashSet(arr_object) : ArraysKt.asList(arr_object);
    }

    public static final Collection convertToSetForSetOperationWith(Iterable iterable0, Iterable iterable1) {
        Intrinsics.checkNotNullParameter(iterable0, "<this>");
        Intrinsics.checkNotNullParameter(iterable1, "source");
        if(iterable0 instanceof Set) {
            return (Collection)iterable0;
        }
        if(iterable0 instanceof Collection) {
            if(iterable1 instanceof Collection && ((Collection)iterable1).size() < 2) {
                return (Collection)iterable0;
            }
            return BrittleContainsOptimizationKt.safeToConvertToSet(((Collection)iterable0)) ? CollectionsKt.toHashSet(iterable0) : ((Collection)iterable0);
        }
        return CollectionSystemProperties.brittleContainsOptimizationEnabled ? CollectionsKt.toHashSet(iterable0) : CollectionsKt.toList(iterable0);
    }

    // 去混淆评级： 低(20)
    private static final boolean safeToConvertToSet(Collection collection0) {
        return CollectionSystemProperties.brittleContainsOptimizationEnabled && collection0.size() > 2 && collection0 instanceof ArrayList;
    }
}

