package com.yahoo.sketches.quantiles;

import com.yahoo.sketches.SketchesArgumentException;
import java.util.Arrays;
import java.util.Comparator;

final class ItemsUtil {
    static final boolean $assertionsDisabled = false;
    static final int ITEMS_SER_VER = 3;
    static final int PRIOR_ITEMS_SER_VER = 2;

    static {
    }

    static void checkItemsSerVer(int serVer) {
        if(serVer != 2 && serVer != 3) {
            throw new SketchesArgumentException("Possible corruption: Invalid Serialization Version: " + serVer);
        }
    }

    static void processFullBaseBuffer(ItemsSketch sketch) {
        ItemsUpdateImpl.maybeGrowLevels(sketch, sketch.getN());
        Object[] arr_object = sketch.getCombinedBuffer();
        Arrays.sort(arr_object, 0, sketch.getBaseBufferCount());
        ItemsUpdateImpl.inPlacePropagateCarry(0, null, 0, arr_object, 0, true, sketch);
        sketch.baseBufferCount_ = 0;
        Arrays.fill(arr_object, 0, sketch.getK() * 2, null);
    }

    static String toString(boolean sketchSummary, boolean dataDetail, ItemsSketch sketch) {
        StringBuilder stringBuilder0 = new StringBuilder();
        String s = sketch.getClass().getSimpleName();
        int v = sketch.getBaseBufferCount();
        int v1 = sketch.getCombinedBufferAllocatedCount();
        int v2 = sketch.getK();
        long v3 = sketch.getBitPattern();
        if(dataDetail) {
            stringBuilder0.append("\n");
            stringBuilder0.append("### ");
            stringBuilder0.append(s);
            stringBuilder0.append(" DATA DETAIL: ");
            stringBuilder0.append("\n");
            Object[] arr_object = sketch.getCombinedBuffer();
            stringBuilder0.append("   BaseBuffer   :");
            if(v > 0) {
                for(int v4 = 0; v4 < v; ++v4) {
                    stringBuilder0.append(' ');
                    stringBuilder0.append(arr_object[v4]);
                }
            }
            stringBuilder0.append("\n");
            if(v1 > v2 * 2) {
                stringBuilder0.append("   Valid | Level");
                for(int v5 = v2 * 2; v5 < v1; ++v5) {
                    if(v5 % v2 == 0) {
                        int v6 = v5 <= v2 * 2 ? 0 : (v5 - v2 * 2) / v2;
                        stringBuilder0.append("\n");
                        stringBuilder0.append("   ");
                        stringBuilder0.append(((1L << v6 & v3) <= 0L ? "    F  " : "    T  "));
                        stringBuilder0.append(" ");
                        stringBuilder0.append(String.format("%5d", v6));
                        stringBuilder0.append(":");
                    }
                    stringBuilder0.append(' ');
                    stringBuilder0.append(arr_object[v5]);
                }
                stringBuilder0.append("\n");
            }
            stringBuilder0.append("### END DATA DETAIL");
            stringBuilder0.append("\n");
        }
        if(sketchSummary) {
            long v7 = sketch.getN();
            int v8 = Util.computeNumLevelsNeeded(v2, v7);
            Object[] arr_object1 = {((double)(EpsilonFromK.getAdjustedEpsilon(v2) * 100.0))};
            Object[] arr_object2 = {sketch.getRetainedItems()};
            stringBuilder0.append("\n");
            stringBuilder0.append("### ");
            stringBuilder0.append(s);
            stringBuilder0.append(" SUMMARY: ");
            stringBuilder0.append("\n");
            stringBuilder0.append("   K                            : ");
            stringBuilder0.append(v2);
            stringBuilder0.append("\n");
            stringBuilder0.append("   N                            : ");
            stringBuilder0.append(String.format("%,d", v7));
            stringBuilder0.append("\n");
            stringBuilder0.append("   BaseBufferCount              : ");
            stringBuilder0.append(v);
            stringBuilder0.append("\n");
            stringBuilder0.append("   CombinedBufferAllocatedCount : ");
            stringBuilder0.append(String.format("%,d", v1));
            stringBuilder0.append("\n");
            stringBuilder0.append("   Total Levels                 : ");
            stringBuilder0.append(v8);
            stringBuilder0.append("\n");
            stringBuilder0.append("   Valid Levels                 : ");
            stringBuilder0.append(Util.computeValidLevels(v3));
            stringBuilder0.append("\n");
            stringBuilder0.append("   Level Bit Pattern            : ");
            stringBuilder0.append(Long.toBinaryString(v3));
            stringBuilder0.append("\n");
            stringBuilder0.append("   Valid Samples                : ");
            stringBuilder0.append(String.format("%,d", arr_object2));
            stringBuilder0.append("\n");
            stringBuilder0.append("   Preamble Bytes               : ");
            stringBuilder0.append((sketch.isEmpty() ? 8 : 16));
            stringBuilder0.append("\n");
            stringBuilder0.append("   Normalized Rank Error        : ");
            stringBuilder0.append(String.format("%.3f%%", arr_object1));
            stringBuilder0.append("\n");
            stringBuilder0.append("   Min Value                    : ");
            stringBuilder0.append(sketch.getMinValue());
            stringBuilder0.append("\n");
            stringBuilder0.append("   Max Value                    : ");
            stringBuilder0.append(sketch.getMaxValue());
            stringBuilder0.append("\n");
            stringBuilder0.append("### END SKETCH SUMMARY");
            stringBuilder0.append("\n");
        }
        return stringBuilder0.toString();
    }

    static final void validateValues(Object[] values, Comparator comparator) {
        int v = values.length - 1;
        int v1 = 0;
        while(v1 < v) {
            Object object0 = values[v1];
            if(object0 == null) {
                throw new SketchesArgumentException("Values must be unique, monotonically increasing and not null.");
            }
            ++v1;
            Object object1 = values[v1];
            if(object1 == null || comparator.compare(object0, object1) >= 0) {
                throw new SketchesArgumentException("Values must be unique, monotonically increasing and not null.");
            }
        }
    }
}

