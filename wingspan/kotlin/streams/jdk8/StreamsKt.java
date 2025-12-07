package kotlin.streams.jdk8;

import com.unity3d.player.UnityPlayerActivity;
import java.util.Iterator;
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;
import java.util.PrimitiveIterator.OfInt;
import java.util.PrimitiveIterator.OfLong;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001A\u0012\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001A\u0012\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00040\u0001*\u00020\u0005H\u0007\u001A\u0012\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u00060\u0001*\u00020\u0007H\u0007\u001A\u001E\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007\u001A\u001E\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\b0\t\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0001H\u0007\u001A\u0012\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00020\f*\u00020\u0003H\u0007\u001A\u0012\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00040\f*\u00020\u0005H\u0007\u001A\u0012\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00060\f*\u00020\u0007H\u0007\u001A\u001E\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\b0\f\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\tH\u0007¨\u0006\r"}, d2 = {"asSequence", "Lkotlin/sequences/Sequence;", "", "Ljava/util/stream/DoubleStream;", "", "Ljava/util/stream/IntStream;", "", "Ljava/util/stream/LongStream;", "T", "Ljava/util/stream/Stream;", "asStream", "toList", "", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 7, 1}, pn = "kotlin.streams", xi = 0x30)
public final class StreamsKt {
    // 检测为 Lambda 实现
    public static Spliterator $r8$lambda$D6rJ2g9z2pCQAEMFkqgtKPOz0JA(Sequence sequence0) [...]

    public static final Sequence asSequence(DoubleStream doubleStream0) {
        Intrinsics.checkNotNullParameter(doubleStream0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return new Sequence() {
            @Override  // kotlin.sequences.Sequence
            public Iterator iterator() {
                PrimitiveIterator.OfDouble primitiveIterator$OfDouble0 = doubleStream0.iterator();
                Intrinsics.checkNotNullExpressionValue(primitiveIterator$OfDouble0, UnityPlayerActivity.adjustValue("070408130F1508175A47"));
                return primitiveIterator$OfDouble0;
            }
        };
    }

    public static final Sequence asSequence(IntStream intStream0) {
        Intrinsics.checkNotNullParameter(intStream0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return new Sequence() {
            @Override  // kotlin.sequences.Sequence
            public Iterator iterator() {
                PrimitiveIterator.OfInt primitiveIterator$OfInt0 = intStream0.iterator();
                Intrinsics.checkNotNullExpressionValue(primitiveIterator$OfInt0, UnityPlayerActivity.adjustValue("070408130F1508175A47"));
                return primitiveIterator$OfInt0;
            }
        };
    }

    public static final Sequence asSequence(LongStream longStream0) {
        Intrinsics.checkNotNullParameter(longStream0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return new Sequence() {
            @Override  // kotlin.sequences.Sequence
            public Iterator iterator() {
                PrimitiveIterator.OfLong primitiveIterator$OfLong0 = longStream0.iterator();
                Intrinsics.checkNotNullExpressionValue(primitiveIterator$OfLong0, UnityPlayerActivity.adjustValue("070408130F1508175A47"));
                return primitiveIterator$OfLong0;
            }
        };
    }

    public static final Sequence asSequence(Stream stream0) {
        Intrinsics.checkNotNullParameter(stream0, UnityPlayerActivity.adjustValue("520405081D5F"));
        return new Sequence() {
            @Override  // kotlin.sequences.Sequence
            public Iterator iterator() {
                Iterator iterator0 = stream0.iterator();
                Intrinsics.checkNotNullExpressionValue(iterator0, UnityPlayerActivity.adjustValue("070408130F1508175A47"));
                return iterator0;
            }
        };
    }

    public static final Stream asStream(Sequence sequence0) {
        Intrinsics.checkNotNullParameter(sequence0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Stream stream0 = StreamSupport.stream(() -> StreamsKt.asStream$lambda$4(sequence0), 16, false);
        Intrinsics.checkNotNullExpressionValue(stream0, UnityPlayerActivity.adjustValue("1D041F040F0C4F1E523D0001081A0415040601021E4F1D1185E5D4021919041C00130A00403F3F252B3322215E4E160C0D1D044E"));
        return stream0;
    }

    private static final Spliterator asStream$lambda$4(Sequence sequence0) {
        Intrinsics.checkNotNullParameter(sequence0, UnityPlayerActivity.adjustValue("4A0405081D3E0616211A02080003"));
        return Spliterators.spliteratorUnknownSize(sequence0.iterator(), 16);
    }

    public static final List toList(DoubleStream doubleStream0) {
        Intrinsics.checkNotNullParameter(doubleStream0, UnityPlayerActivity.adjustValue("520405081D5F"));
        double[] arr_f = doubleStream0.toArray();
        Intrinsics.checkNotNullExpressionValue(arr_f, UnityPlayerActivity.adjustValue("1A1F2C131C001E4D5B"));
        return ArraysKt.asList(arr_f);
    }

    public static final List toList(IntStream intStream0) {
        Intrinsics.checkNotNullParameter(intStream0, UnityPlayerActivity.adjustValue("520405081D5F"));
        int[] arr_v = intStream0.toArray();
        Intrinsics.checkNotNullExpressionValue(arr_v, UnityPlayerActivity.adjustValue("1A1F2C131C001E4D5B"));
        return ArraysKt.asList(arr_v);
    }

    public static final List toList(LongStream longStream0) {
        Intrinsics.checkNotNullParameter(longStream0, UnityPlayerActivity.adjustValue("520405081D5F"));
        long[] arr_v = longStream0.toArray();
        Intrinsics.checkNotNullExpressionValue(arr_v, UnityPlayerActivity.adjustValue("1A1F2C131C001E4D5B"));
        return ArraysKt.asList(arr_v);
    }

    public static final List toList(Stream stream0) {
        Intrinsics.checkNotNullParameter(stream0, UnityPlayerActivity.adjustValue("520405081D5F"));
        Object object0 = stream0.collect(Collectors.toList());
        Intrinsics.checkNotNullExpressionValue(object0, UnityPlayerActivity.adjustValue("0D1F010D0B02134D31011C01040D150817014004022D071213592650584448"));
        return (List)object0;
    }
}

