package com.yahoo.sketches.quantiles;

import com.yahoo.memory.Memory;
import com.yahoo.memory.WritableMemory;
import com.yahoo.sketches.ArrayOfItemsSerDe;
import com.yahoo.sketches.SketchesArgumentException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public final class ItemsSketch {
    static final boolean $assertionsDisabled = false;
    static final int MIN_K = 2;
    static final int SER_VER = 3;
    int baseBufferCount_;
    long bitPattern_;
    int combinedBufferItemCapacity_;
    Object[] combinedBuffer_;
    private final Comparator comparator_;
    final int k_;
    Object maxValue_;
    Object minValue_;
    long n_;
    public static final Random rand;

    static {
        ItemsSketch.rand = new Random();
    }

    private ItemsSketch(int k, Comparator comparator) {
        Util.checkK(k);
        this.k_ = k;
        this.comparator_ = comparator;
    }

    private ItemsAuxiliary constructAuxiliary() {
        return new ItemsAuxiliary(this);
    }

    static ItemsSketch copy(ItemsSketch sketch) {
        ItemsSketch itemsSketch1 = ItemsSketch.newInstance(sketch.k_, sketch.comparator_);
        itemsSketch1.n_ = sketch.n_;
        itemsSketch1.minValue_ = sketch.getMinValue();
        itemsSketch1.maxValue_ = sketch.getMaxValue();
        itemsSketch1.combinedBufferItemCapacity_ = sketch.getCombinedBufferAllocatedCount();
        itemsSketch1.baseBufferCount_ = sketch.getBaseBufferCount();
        itemsSketch1.bitPattern_ = sketch.getBitPattern();
        Object[] arr_object = sketch.getCombinedBuffer();
        itemsSketch1.combinedBuffer_ = Arrays.copyOf(arr_object, arr_object.length);
        return itemsSketch1;
    }

    public ItemsSketch downSample(int newK) {
        ItemsSketch itemsSketch0 = ItemsSketch.newInstance(newK, this.comparator_);
        ItemsMergeImpl.downSamplingMergeInto(this, itemsSketch0);
        return itemsSketch0;
    }

    int getBaseBufferCount() {
        return this.baseBufferCount_;
    }

    long getBitPattern() {
        return this.bitPattern_;
    }

    // 去混淆评级： 低(20)
    public double[] getCDF(Object[] splitPoints) {
        return this.isEmpty() ? null : ItemsPmfCdfImpl.getPMFOrCDF(this, splitPoints, true);
    }

    Object[] getCombinedBuffer() {
        return this.combinedBuffer_;
    }

    int getCombinedBufferAllocatedCount() {
        return this.combinedBufferItemCapacity_;
    }

    Comparator getComparator() {
        return this.comparator_;
    }

    private static double[] getEvenlySpaced(int n) {
        if(n <= 0) {
            throw new SketchesArgumentException("n must be > zero.");
        }
        double[] arr_f = new double[n];
        arr_f[0] = 0.0;
        for(int v1 = 1; v1 < n; ++v1) {
            arr_f[v1] = ((double)v1) / ((double)(n - 1));
        }
        if(n > 1) {
            arr_f[n - 1] = 1.0;
        }
        return arr_f;
    }

    public int getK() {
        return this.k_;
    }

    public Object getMaxValue() {
        return this.maxValue_;
    }

    public Object getMinValue() {
        return this.minValue_;
    }

    public long getN() {
        return this.n_;
    }

    public static double getNormalizedRankError(int k) {
        return EpsilonFromK.getAdjustedEpsilon(k);
    }

    public double getNormalizedRankError() {
        return ItemsSketch.getNormalizedRankError(this.getK());
    }

    // 去混淆评级： 低(20)
    public double[] getPMF(Object[] splitPoints) {
        return this.isEmpty() ? null : ItemsPmfCdfImpl.getPMFOrCDF(this, splitPoints, false);
    }

    public Object getQuantile(double fraction) {
        if(fraction >= 0.0) {
            int v = Double.compare(fraction, 1.0);
            if(v <= 0) {
                if(fraction == 0.0) {
                    return this.minValue_;
                }
                return v == 0 ? this.maxValue_ : this.constructAuxiliary().getQuantile(fraction);
            }
        }
        throw new SketchesArgumentException("Fraction cannot be less than zero or greater than 1.0");
    }

    // 去混淆评级： 低(20)
    public Object[] getQuantiles(int evenlySpaced) {
        return this.isEmpty() ? null : this.getQuantiles(ItemsSketch.getEvenlySpaced(evenlySpaced));
    }

    public Object[] getQuantiles(double[] fractions) {
        ItemsAuxiliary itemsAuxiliary0 = null;
        if(this.isEmpty()) {
            return null;
        }
        Util.validateFractions(fractions);
        Object[] arr_object = (Object[])Array.newInstance(this.minValue_.getClass(), fractions.length);
        for(int v = 0; v < fractions.length; ++v) {
            double f = fractions[v];
            if(f == 0.0) {
                arr_object[v] = this.minValue_;
            }
            else if(f == 1.0) {
                arr_object[v] = this.maxValue_;
            }
            else {
                if(itemsAuxiliary0 == null) {
                    itemsAuxiliary0 = this.constructAuxiliary();
                }
                arr_object[v] = itemsAuxiliary0.getQuantile(f);
            }
        }
        return arr_object;
    }

    // 去混淆评级： 低(20)
    public double getRank(Object value) {
        return this.isEmpty() ? NaN : this.getCDF(new Object[]{value})[0];
    }

    public int getRetainedItems() {
        return Util.computeRetainedItems(this.getK(), this.getN());
    }

    private static void growBaseBuffer(ItemsSketch sketch) {
        int v = Math.max(Math.min(sketch.getK() * 2, sketch.getCombinedBufferAllocatedCount() * 2), 1);
        sketch.combinedBufferItemCapacity_ = v;
        sketch.combinedBuffer_ = Arrays.copyOf(sketch.getCombinedBuffer(), v);
    }

    public static ItemsSketch heapify(Memory srcMem, Comparator comparator, ArrayOfItemsSerDe serDe) {
        long v = srcMem.getCapacity();
        if(v < 8L) {
            throw new SketchesArgumentException("Memory too small: " + v);
        }
        int v1 = PreambleUtil.extractPreLongs(srcMem);
        int v2 = PreambleUtil.extractSerVer(srcMem);
        int v3 = PreambleUtil.extractFamilyID(srcMem);
        int v4 = PreambleUtil.extractFlags(srcMem);
        int v5 = PreambleUtil.extractK(srcMem);
        ItemsUtil.checkItemsSerVer(v2);
        if(v2 != 3) {
            throw new SketchesArgumentException("Possible corruption: Invalid serialization version: " + v2);
        }
        if((v4 & 8) == 0) {
            throw new SketchesArgumentException("Non-compact Memory images are not supported.");
        }
        boolean z = Util.checkPreLongsFlagsCap(v1, v4, v);
        Util.checkFamilyID(v3);
        ItemsSketch itemsSketch0 = ItemsSketch.newInstance(v5, comparator);
        if(z) {
            return itemsSketch0;
        }
        long v6 = PreambleUtil.extractN(srcMem);
        int v7 = Util.computeRetainedItems(v5, v6);
        itemsSketch0.n_ = v6;
        itemsSketch0.combinedBufferItemCapacity_ = Util.computeCombinedBufferItemCapacity(v5, v6);
        itemsSketch0.baseBufferCount_ = (int)(v6 % (((long)v5) * 2L));
        itemsSketch0.bitPattern_ = v6 / (((long)v5) * 2L);
        itemsSketch0.combinedBuffer_ = new Object[itemsSketch0.combinedBufferItemCapacity_];
        itemsSketch0.itemsArrayToCombinedBuffer(serDe.deserializeFromMemory(srcMem.region(((long)(v1 * 8)), srcMem.getCapacity() - ((long)(v1 * 8))), v7 + 2));
        return itemsSketch0;
    }

    public boolean isDirect() [...] // Inlined contents

    public boolean isEmpty() {
        return this.getN() == 0L;
    }

    public boolean isEstimationMode() {
        return this.getN() >= ((long)this.k_) * 2L;
    }

    private void itemsArrayToCombinedBuffer(Object[] itemsArray) {
        int v = 0;
        this.minValue_ = itemsArray[0];
        this.maxValue_ = itemsArray[1];
        System.arraycopy(itemsArray, 2, this.combinedBuffer_, 0, this.baseBufferCount_);
        long v1 = this.bitPattern_;
        if(v1 > 0L) {
            int v2 = this.baseBufferCount_ + 2;
            while(v1 != 0L) {
                if((1L & v1) > 0L) {
                    System.arraycopy(itemsArray, v2, this.combinedBuffer_, (v + 2) * this.k_, this.k_);
                    v2 += this.k_;
                }
                ++v;
                v1 >>>= 1;
            }
        }
    }

    public static ItemsSketch newInstance(int k, Comparator comparator) {
        ItemsSketch itemsSketch0 = new ItemsSketch(k, comparator);
        int v1 = Math.min(2, k);
        itemsSketch0.n_ = 0L;
        itemsSketch0.combinedBufferItemCapacity_ = v1 * 2;
        itemsSketch0.combinedBuffer_ = new Object[v1 * 2];
        itemsSketch0.baseBufferCount_ = 0;
        itemsSketch0.bitPattern_ = 0L;
        itemsSketch0.minValue_ = null;
        itemsSketch0.maxValue_ = null;
        return itemsSketch0;
    }

    public static ItemsSketch newInstance(Comparator comparator) {
        return ItemsSketch.newInstance(0x80, comparator);
    }

    public void putMemory(WritableMemory dstMem, ArrayOfItemsSerDe serDe) {
        byte[] arr_b = this.toByteArray(serDe);
        long v = dstMem.getCapacity();
        if(v < ((long)arr_b.length)) {
            throw new SketchesArgumentException("Destination Memory not large enough: " + v + " < " + arr_b.length);
        }
        dstMem.putByteArray(0L, arr_b, 0, arr_b.length);
    }

    public void reset() {
        this.n_ = 0L;
        int v = Math.min(2, this.k_);
        this.combinedBufferItemCapacity_ = v * 2;
        this.combinedBuffer_ = new Object[v * 2];
        this.baseBufferCount_ = 0;
        this.bitPattern_ = 0L;
        this.minValue_ = null;
        this.maxValue_ = null;
    }

    public byte[] toByteArray(ArrayOfItemsSerDe serDe) {
        return this.toByteArray(false, serDe);
    }

    public byte[] toByteArray(boolean ordered, ArrayOfItemsSerDe serDe) {
        return ItemsByteArrayImpl.toByteArray(this, ordered, serDe);
    }

    @Override
    public String toString() {
        return this.toString(true, false);
    }

    public String toString(boolean sketchSummary, boolean dataDetail) {
        return ItemsUtil.toString(sketchSummary, dataDetail, this);
    }

    public void update(Object dataItem) {
        if(dataItem == null) {
            return;
        }
        if(this.maxValue_ == null || this.comparator_.compare(dataItem, this.maxValue_) > 0) {
            this.maxValue_ = dataItem;
        }
        if(this.minValue_ == null || this.comparator_.compare(dataItem, this.minValue_) < 0) {
            this.minValue_ = dataItem;
        }
        if(this.baseBufferCount_ + 1 > this.combinedBufferItemCapacity_) {
            ItemsSketch.growBaseBuffer(this);
        }
        int v = this.baseBufferCount_;
        this.baseBufferCount_ = v + 1;
        this.combinedBuffer_[v] = dataItem;
        ++this.n_;
        if(v + 1 == this.k_ * 2) {
            ItemsUtil.processFullBaseBuffer(this);
        }
    }
}

