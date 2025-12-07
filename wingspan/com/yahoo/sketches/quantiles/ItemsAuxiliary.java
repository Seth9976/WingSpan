package com.yahoo.sketches.quantiles;

import java.util.Arrays;
import java.util.Comparator;

final class ItemsAuxiliary {
    static final boolean $assertionsDisabled;
    final long[] auxCumWtsArr_;
    final long auxN_;
    final Object[] auxSamplesArr_;

    static {
    }

    ItemsAuxiliary(ItemsSketch qs) {
        int v = qs.getK();
        long v1 = qs.getN();
        int v2 = qs.getRetainedItems();
        Object[] arr_object = new Object[v2];
        long[] arr_v = new long[v2 + 1];
        ItemsAuxiliary.populateFromItemsSketch(v, v1, qs.getBitPattern(), qs.getCombinedBuffer(), qs.getBaseBufferCount(), v2, arr_object, arr_v, qs.getComparator());
        ItemsMergeImpl.blockyTandemMergeSort(arr_object, arr_v, v2, v, qs.getComparator());
        int v4 = 0;
        for(long v3 = 0L; v4 < v2 + 1; v3 = v5) {
            long v5 = arr_v[v4] + v3;
            arr_v[v4] = v3;
            ++v4;
        }
        this.auxN_ = v1;
        this.auxSamplesArr_ = arr_object;
        this.auxCumWtsArr_ = arr_v;
    }

    private Object approximatelyAnswerPositionalQuery(long pos) {
        return this.auxSamplesArr_[ItemsAuxiliary.chunkContainingPos(this.auxCumWtsArr_, pos)];
    }

    static int chunkContainingPos(long[] arr, long pos) {
        long v1 = arr[arr.length - 1];
        return ItemsAuxiliary.searchForChunkContainingPos(arr, pos, 0, arr.length - 1);
    }

    Object getQuantile(double phi) {
        return this.auxN_ > 0L ? this.approximatelyAnswerPositionalQuery(ItemsAuxiliary.posOfPhi(phi, this.auxN_)) : null;
    }

    private static final void populateFromItemsSketch(int k, long n, long bitPattern, Object[] combinedBuffer, int baseBufferCount, int numSamples, Object[] itemsArr, long[] cumWtsArr, Comparator comparator) {
        long v6 = bitPattern;
        long v7 = 1L;
        int v8 = 0;
        int v9 = 0;
        while(Long.compare(v6, 0L) != 0) {
            v7 *= 2L;
            if((v6 & 1L) > 0L) {
                int v10 = (v9 + 2) * k;
                for(int v11 = 0; v11 < k; ++v11) {
                    itemsArr[v8] = combinedBuffer[v11 + v10];
                    cumWtsArr[v8] = v7;
                    ++v8;
                }
            }
            ++v9;
            v6 >>>= 1;
        }
        int v12 = v8;
        for(int v5 = 0; v5 < baseBufferCount; ++v5) {
            itemsArr[v12] = combinedBuffer[v5];
            cumWtsArr[v12] = 1L;
            ++v12;
        }
        Arrays.sort(itemsArr, v8, numSamples, comparator);
        cumWtsArr[numSamples] = 0L;
    }

    static long posOfPhi(double phi, long n) {
        long v1 = (long)Math.floor(phi * ((double)n));
        return v1 == n ? n - 1L : v1;
    }

    private static int searchForChunkContainingPos(long[] arr, long pos, int l, int r) {
        if(l + 1 == r) {
            return l;
        }
        int v3 = (r - l) / 2 + l;
        return arr[v3] > pos ? ItemsAuxiliary.searchForChunkContainingPos(arr, pos, l, v3) : ItemsAuxiliary.searchForChunkContainingPos(arr, pos, v3, r);
    }
}

