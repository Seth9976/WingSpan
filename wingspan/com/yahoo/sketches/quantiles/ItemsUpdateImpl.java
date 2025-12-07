package com.yahoo.sketches.quantiles;

import java.util.Arrays;
import java.util.Comparator;

final class ItemsUpdateImpl {
    static final boolean $assertionsDisabled;

    static {
    }

    static void inPlacePropagateCarry(int startingLevel, Object[] sizeKBuf, int sizeKStart, Object[] size2KBuf, int size2KStart, boolean doUpdateVersion, ItemsSketch sketch) {
        Object[] arr_object2 = sketch.getCombinedBuffer();
        long v3 = sketch.getBitPattern();
        int v4 = sketch.getK();
        int v5 = Util.lowestZeroBitStartingAt(v3, startingLevel);
        if(doUpdateVersion) {
            ItemsUpdateImpl.zipSize2KBuffer(size2KBuf, size2KStart, arr_object2, (v5 + 2) * v4, v4);
        }
        else {
            System.arraycopy(sizeKBuf, sizeKStart, arr_object2, (v5 + 2) * v4, v4);
        }
        for(int v6 = startingLevel; v6 < v5; ++v6) {
            int v7 = (v6 + 2) * v4;
            int v8 = (v5 + 2) * v4;
            ItemsUpdateImpl.mergeTwoSizeKBuffers(arr_object2, v7, arr_object2, v8, size2KBuf, size2KStart, v4, sketch.getComparator());
            ItemsUpdateImpl.zipSize2KBuffer(size2KBuf, size2KStart, arr_object2, v8, v4);
            Arrays.fill(arr_object2, v7, (v6 + 3) * v4, null);
        }
        sketch.bitPattern_ = v3 + (1L << startingLevel);
    }

    static void maybeGrowLevels(ItemsSketch sketch, long newN) {
        int v1 = sketch.getK();
        int v2 = Util.computeNumLevelsNeeded(v1, newN);
        if(v2 == 0) {
            return;
        }
        int v3 = (v2 + 2) * v1;
        if(v3 <= sketch.getCombinedBufferAllocatedCount()) {
            return;
        }
        sketch.combinedBuffer_ = Arrays.copyOf(sketch.getCombinedBuffer(), v3);
        sketch.combinedBufferItemCapacity_ = v3;
    }

    private static void mergeTwoSizeKBuffers(Object[] keySrc1, int arrStart1, Object[] keySrc2, int arrStart2, Object[] keyDst, int arrStart3, int k, Comparator comparator) {
        int v4 = arrStart1 + k;
        int v5 = k + arrStart2;
        while(arrStart1 < v4 && arrStart2 < v5) {
            if(comparator.compare(keySrc2[arrStart2], keySrc1[arrStart1]) < 0) {
                keyDst[arrStart3] = keySrc2[arrStart2];
                ++arrStart3;
                ++arrStart2;
            }
            else {
                keyDst[arrStart3] = keySrc1[arrStart1];
                ++arrStart3;
                ++arrStart1;
            }
        }
        if(arrStart1 < v4) {
            System.arraycopy(keySrc1, arrStart1, keyDst, arrStart3, v4 - arrStart1);
            return;
        }
        System.arraycopy(keySrc1, arrStart2, keyDst, arrStart3, v5 - arrStart2);
    }

    private static void zipSize2KBuffer(Object[] bufA, int startA, Object[] bufC, int startC, int k) {
        int v3 = k + startC;
        int v4 = startA + ItemsSketch.rand.nextBoolean();
        while(startC < v3) {
            bufC[startC] = bufA[v4];
            v4 += 2;
            ++startC;
        }
    }
}

