package androidx.core.util;

import android.util.Range;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange.DefaultImpls;
import kotlin.ranges.ClosedRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000F\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A7\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\f\u001A6\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0006\u001A\u0002H\u0002H\u0087\n¢\u0006\u0002\u0010\u0007\u001A7\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\n\u001A0\u0010\b\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\t\u001A\u0002H\u0002H\u0087\f¢\u0006\u0002\u0010\n\u001A(\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\f\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001A(\u0010\r\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0007¨\u0006\u000E"}, d2 = {"and", "Landroid/util/Range;", "T", "", "other", "plus", "value", "(Landroid/util/Range;Ljava/lang/Comparable;)Landroid/util/Range;", "rangeTo", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Landroid/util/Range;", "toClosedRange", "Lkotlin/ranges/ClosedRange;", "toRange", "core-ktx_release"}, k = 2, mv = {1, 1, 15})
public final class RangeKt {
    public static final Range and(Range range0, Range range1) {
        Intrinsics.checkParameterIsNotNull(range0, "$this$and");
        Intrinsics.checkParameterIsNotNull(range1, "other");
        Range range2 = range0.intersect(range1);
        Intrinsics.checkExpressionValueIsNotNull(range2, "intersect(other)");
        return range2;
    }

    public static final Range plus(Range range0, Range range1) {
        Intrinsics.checkParameterIsNotNull(range0, "$this$plus");
        Intrinsics.checkParameterIsNotNull(range1, "other");
        Range range2 = range0.extend(range1);
        Intrinsics.checkExpressionValueIsNotNull(range2, "extend(other)");
        return range2;
    }

    public static final Range plus(Range range0, Comparable comparable0) {
        Intrinsics.checkParameterIsNotNull(range0, "$this$plus");
        Intrinsics.checkParameterIsNotNull(comparable0, "value");
        Range range1 = range0.extend(comparable0);
        Intrinsics.checkExpressionValueIsNotNull(range1, "extend(value)");
        return range1;
    }

    public static final Range rangeTo(Comparable comparable0, Comparable comparable1) {
        Intrinsics.checkParameterIsNotNull(comparable0, "$this$rangeTo");
        Intrinsics.checkParameterIsNotNull(comparable1, "that");
        return new Range(comparable0, comparable1);
    }

    public static final ClosedRange toClosedRange(Range range0) {
        Intrinsics.checkParameterIsNotNull(range0, "$this$toClosedRange");
        return new ClosedRange() {
            @Override  // kotlin.ranges.ClosedRange
            public boolean contains(Comparable comparable0) {
                Intrinsics.checkParameterIsNotNull(comparable0, "value");
                return DefaultImpls.contains(this, comparable0);
            }

            @Override  // kotlin.ranges.ClosedRange
            public Comparable getEndInclusive() {
                return range0.getUpper();
            }

            @Override  // kotlin.ranges.ClosedRange
            public Comparable getStart() {
                return range0.getLower();
            }

            @Override  // kotlin.ranges.ClosedRange
            public boolean isEmpty() {
                return DefaultImpls.isEmpty(this);
            }
        };
    }

    public static final Range toRange(ClosedRange closedRange0) {
        Intrinsics.checkParameterIsNotNull(closedRange0, "$this$toRange");
        return new Range(closedRange0.getStart(), closedRange0.getEndInclusive());
    }
}

