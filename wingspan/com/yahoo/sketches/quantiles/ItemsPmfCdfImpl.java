package com.yahoo.sketches.quantiles;

import java.util.Arrays;
import java.util.Comparator;

class ItemsPmfCdfImpl {
    static final boolean $assertionsDisabled;

    static {
    }

    static void bilinearTimeIncrementHistogramCounters(Object[] samples, int offset, int numSamples, long weight, Object[] splitPoints, long[] counters, Comparator comparator) {
        for(int v3 = 0; v3 < numSamples; ++v3) {
            Object object0 = samples[v3 + offset];
            int v4;
            for(v4 = 0; v4 < splitPoints.length && comparator.compare(object0, splitPoints[v4]) >= 0; ++v4) {
            }
            counters[v4] += weight;
        }
    }

    static double[] getPMFOrCDF(ItemsSketch sketch, Object[] splitPoints, boolean isCDF) {
        long[] arr_v = ItemsPmfCdfImpl.internalBuildHistogram(splitPoints, sketch);
        double[] arr_f = new double[arr_v.length];
        double f = (double)sketch.getN();
        int v = 0;
        if(isCDF) {
            long v1 = 0L;
            while(v < arr_v.length) {
                v1 += arr_v[v];
                arr_f[v] = ((double)v1) / f;
                ++v;
            }
            return arr_f;
        }
        while(v < arr_v.length) {
            arr_f[v] = ((double)arr_v[v]) / f;
            ++v;
        }
        return arr_f;
    }

    private static long[] internalBuildHistogram(Object[] splitPoints, ItemsSketch sketch) {
        Object[] arr_object1 = sketch.getCombinedBuffer();
        int v = sketch.getBaseBufferCount();
        ItemsUtil.validateValues(splitPoints, sketch.getComparator());
        long[] arr_v = new long[splitPoints.length + 1];
        int v1 = 0;
        if(splitPoints.length < 50) {
            ItemsPmfCdfImpl.bilinearTimeIncrementHistogramCounters(arr_object1, 0, v, 1L, splitPoints, arr_v, sketch.getComparator());
        }
        else {
            Arrays.sort(arr_object1, 0, v);
            ItemsPmfCdfImpl.linearTimeIncrementHistogramCounters(arr_object1, 0, v, 1L, splitPoints, arr_v, sketch.getComparator());
        }
        int v2 = sketch.getK();
        long v4 = sketch.getBitPattern();
        for(long v3 = 1L; v4 != 0L; v3 = v5) {
            long v5 = v3 + v3;
            if((1L & v4) > 0L) {
                ItemsPmfCdfImpl.linearTimeIncrementHistogramCounters(arr_object1, (v1 + 2) * v2, v2, v5, splitPoints, arr_v, sketch.getComparator());
            }
            ++v1;
            v4 >>>= 1;
        }
        return arr_v;
    }

    static void linearTimeIncrementHistogramCounters(Object[] samples, int offset, int numSamples, long weight, Object[] splitPoints, long[] counters, Comparator comparator) {
        int v3 = 0;
        int v4 = 0;
        while(v3 < numSamples && v4 < splitPoints.length) {
            if(comparator.compare(samples[v3 + offset], splitPoints[v4]) < 0) {
                counters[v4] += weight;
                ++v3;
            }
            else {
                ++v4;
            }
        }
        if(v4 == splitPoints.length) {
            counters[v4] += weight * ((long)(numSamples - v3));
        }
    }
}

