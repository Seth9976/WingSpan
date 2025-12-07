package com.yahoo.sketches.quantiles;

import com.yahoo.sketches.SketchesArgumentException;
import com.yahoo.sketches.Util;
import java.util.Arrays;
import java.util.Comparator;

final class ItemsMergeImpl {
    static final boolean $assertionsDisabled;

    static {
    }

    static void blockyTandemMergeSort(Object[] keyArr, long[] valArr, int arrLen, int blkSize, Comparator comparator) {
        if(arrLen <= blkSize) {
            return;
        }
        int v2 = arrLen / blkSize;
        if(v2 * blkSize < arrLen) {
            ++v2;
        }
        ItemsMergeImpl.blockyTandemMergeSortRecursion(Arrays.copyOf(keyArr, arrLen), Arrays.copyOf(valArr, arrLen), keyArr, valArr, 0, v2, blkSize, arrLen, comparator);
    }

    private static void blockyTandemMergeSortRecursion(Object[] keySrc, long[] valSrc, Object[] keyDst, long[] valDst, int grpStart, int grpLen, int blkSize, int arrLim, Comparator comparator) {
        if(grpLen == 1) {
            return;
        }
        int v4 = grpLen - grpLen / 2;
        int v5 = grpStart + grpLen / 2;
        ItemsMergeImpl.blockyTandemMergeSortRecursion(keyDst, valDst, keySrc, valSrc, grpStart, grpLen / 2, blkSize, arrLim, comparator);
        ItemsMergeImpl.blockyTandemMergeSortRecursion(keyDst, valDst, keySrc, valSrc, v5, v4, blkSize, arrLim, comparator);
        int v6 = v5 * blkSize;
        int v7 = v4 * blkSize;
        ItemsMergeImpl.tandemMerge(keySrc, valSrc, grpStart * blkSize, grpLen / 2 * blkSize, v6, (v6 + v7 <= arrLim ? v7 : arrLim - v6), keyDst, valDst, grpStart * blkSize, comparator);
    }

    static void downSamplingMergeInto(ItemsSketch src, ItemsSketch tgt) {
        Object[] arr_object4;
        int v = tgt.getK();
        int v1 = src.getK();
        if(v1 % v != 0) {
            throw new SketchesArgumentException("source.getK() must equal target.getK() * 2^(nonnegative integer).");
        }
        int v2 = v1 / v;
        Util.checkIfPowerOf2(v2, "source.getK()/target.getK() ratio");
        int v3 = Integer.numberOfTrailingZeros(v2);
        Object[] arr_object = src.getCombinedBuffer();
        Object[] arr_object1 = src.getCombinedBuffer();
        long v4 = tgt.getN() + src.getN();
        for(int v5 = 0; v5 < src.getBaseBufferCount(); ++v5) {
            tgt.update(arr_object1[v5]);
        }
        ItemsUpdateImpl.maybeGrowLevels(tgt, v4);
        Object[] arr_object2 = new Object[v * 2];
        Object[] arr_object3 = new Object[v];
        int v6 = 0;
        long v7 = src.getBitPattern();
        while(v7 != 0L) {
            if((v7 & 1L) > 0L) {
                ItemsMergeImpl.justZipWithStride(arr_object, (v6 + 2) * v1, arr_object3, 0, v, v2);
                arr_object4 = arr_object3;
                ItemsUpdateImpl.inPlacePropagateCarry(v6 + v3, arr_object3, 0, arr_object2, 0, false, tgt);
            }
            else {
                arr_object4 = arr_object3;
            }
            ++v6;
            v7 >>>= 1;
            arr_object3 = arr_object4;
        }
        tgt.n_ = v4;
        Object object0 = src.getMaxValue();
        Object object1 = src.getMinValue();
        Object object2 = tgt.getMaxValue();
        Object object3 = tgt.getMinValue();
        if(object0 != null && object2 != null) {
            if(src.getComparator().compare(object0, object2) <= 0) {
                object0 = object2;
            }
            tgt.maxValue_ = object0;
        }
        else if(object2 == null) {
            tgt.maxValue_ = object0;
        }
        if(object1 != null && object3 != null) {
            if(src.getComparator().compare(object1, object3) > 0) {
                object1 = object3;
            }
            tgt.minValue_ = object1;
            return;
        }
        if(object3 == null) {
            tgt.minValue_ = object1;
        }
    }

    private static void justZipWithStride(Object[] bufSrc, int startSrc, Object[] bufC, int startC, int kC, int stride) {
        int v4 = kC + startC;
        int v5 = startSrc + ItemsSketch.rand.nextInt(stride);
        while(startC < v4) {
            bufC[startC] = bufSrc[v5];
            v5 += stride;
            ++startC;
        }
    }

    static void mergeInto(ItemsSketch src, ItemsSketch tgt) {
        int v = tgt.getK();
        long v1 = src.getN();
        long v2 = tgt.getN();
        if(src.getK() != v) {
            ItemsMergeImpl.downSamplingMergeInto(src, tgt);
            return;
        }
        Object[] arr_object = src.getCombinedBuffer();
        long v3 = v2 + v1;
        for(int v4 = 0; v4 < src.getBaseBufferCount(); ++v4) {
            tgt.update(arr_object[v4]);
        }
        ItemsUpdateImpl.maybeGrowLevels(tgt, v3);
        Object[] arr_object1 = new Object[v * 2];
        int v5 = 0;
        for(long v6 = src.getBitPattern(); v6 != 0L; v6 >>>= 1) {
            if((1L & v6) > 0L) {
                ItemsUpdateImpl.inPlacePropagateCarry(v5, arr_object, (v5 + 2) * v, arr_object1, 0, false, tgt);
            }
            ++v5;
        }
        tgt.n_ = v3;
        Object object0 = src.getMaxValue();
        Object object1 = src.getMinValue();
        Object object2 = tgt.getMaxValue();
        Object object3 = tgt.getMinValue();
        if(object0 != null && object2 != null) {
            if(src.getComparator().compare(object0, object2) <= 0) {
                object0 = object2;
            }
            tgt.maxValue_ = object0;
        }
        else if(object2 == null) {
            tgt.maxValue_ = object0;
        }
        if(object1 != null && object3 != null) {
            if(src.getComparator().compare(object1, object3) > 0) {
                object1 = object3;
            }
            tgt.minValue_ = object1;
            return;
        }
        if(object3 == null) {
            tgt.minValue_ = object1;
        }
    }

    private static void tandemMerge(Object[] keySrc, long[] valSrc, int arrStart1, int arrLen1, int arrStart2, int arrLen2, Object[] keyDst, long[] valDst, int arrStart3, Comparator comparator) {
        int v5 = arrLen1 + arrStart1;
        int v6 = arrLen2 + arrStart2;
        while(arrStart1 < v5 && arrStart2 < v6) {
            if(comparator.compare(keySrc[arrStart2], keySrc[arrStart1]) < 0) {
                keyDst[arrStart3] = keySrc[arrStart2];
                valDst[arrStart3] = valSrc[arrStart2];
                ++arrStart3;
                ++arrStart2;
            }
            else {
                keyDst[arrStart3] = keySrc[arrStart1];
                valDst[arrStart3] = valSrc[arrStart1];
                ++arrStart3;
                ++arrStart1;
            }
        }
        if(arrStart1 < v5) {
            int v7 = v5 - arrStart1;
            System.arraycopy(keySrc, arrStart1, keyDst, arrStart3, v7);
            System.arraycopy(valSrc, arrStart1, valDst, arrStart3, v7);
            return;
        }
        int v8 = v6 - arrStart2;
        System.arraycopy(keySrc, arrStart2, keyDst, arrStart3, v8);
        System.arraycopy(valSrc, arrStart2, valDst, arrStart3, v8);
    }
}

