package com.yahoo.sketches.quantiles;

import com.yahoo.memory.Memory;
import com.yahoo.sketches.ArrayOfItemsSerDe;
import java.util.Comparator;

public final class ItemsUnion {
    static final boolean $assertionsDisabled;
    protected final Comparator comparator_;
    protected ItemsSketch gadget_;
    protected final int maxK_;

    static {
    }

    private ItemsUnion(int maxK, Comparator comparator, ItemsSketch gadget) {
        this.maxK_ = maxK;
        this.comparator_ = comparator;
        this.gadget_ = gadget;
    }

    public int getEffectiveK() {
        return this.gadget_ == null ? this.maxK_ : this.gadget_.getK();
    }

    public int getMaxK() {
        return this.maxK_;
    }

    public ItemsSketch getResult() {
        return this.gadget_ == null ? ItemsSketch.newInstance(this.maxK_, this.comparator_) : ItemsSketch.copy(this.gadget_);
    }

    public ItemsSketch getResultAndReset() {
        ItemsSketch itemsSketch0 = this.gadget_;
        if(itemsSketch0 == null) {
            return null;
        }
        this.gadget_ = null;
        return itemsSketch0;
    }

    public static ItemsUnion heapify(Memory srcMem, Comparator comparator, ArrayOfItemsSerDe serDe) {
        ItemsSketch itemsSketch0 = ItemsSketch.heapify(srcMem, comparator, serDe);
        return new ItemsUnion(itemsSketch0.getK(), itemsSketch0.getComparator(), itemsSketch0);
    }

    public boolean isDirect() {
        return false;
    }

    public boolean isEmpty() {
        return this.gadget_ == null || this.gadget_.isEmpty();
    }

    public static ItemsUnion newInstance(int maxK, Comparator comparator) {
        return new ItemsUnion(maxK, comparator, null);
    }

    public static ItemsUnion newInstance(ItemsSketch sketch) {
        return new ItemsUnion(sketch.getK(), sketch.getComparator(), ItemsSketch.copy(sketch));
    }

    public static ItemsUnion newInstance(Comparator comparator) {
        return new ItemsUnion(0x80, comparator, null);
    }

    public void reset() {
        this.gadget_ = null;
    }

    public byte[] toByteArray(ArrayOfItemsSerDe serDe) {
        return this.gadget_ == null ? ItemsSketch.newInstance(this.maxK_, this.comparator_).toByteArray(serDe) : this.gadget_.toByteArray(serDe);
    }

    @Override
    public String toString() {
        return this.toString(true, false);
    }

    public String toString(boolean sketchSummary, boolean dataDetail) {
        StringBuilder stringBuilder0 = new StringBuilder();
        String s = this.getClass().getSimpleName();
        stringBuilder0.append("\n");
        stringBuilder0.append("### Quantiles ");
        stringBuilder0.append(s);
        stringBuilder0.append("\n");
        stringBuilder0.append("   maxK                         : ");
        stringBuilder0.append(String.format("%,d", this.getMaxK()));
        ItemsSketch itemsSketch0 = this.gadget_;
        if(itemsSketch0 == null) {
            stringBuilder0.append(ItemsSketch.newInstance(this.maxK_, this.comparator_).toString());
            return stringBuilder0.toString();
        }
        stringBuilder0.append(itemsSketch0.toString(sketchSummary, dataDetail));
        return stringBuilder0.toString();
    }

    public void update(Memory srcMem, ArrayOfItemsSerDe serDe) {
        ItemsSketch itemsSketch0 = ItemsSketch.heapify(srcMem, this.comparator_, serDe);
        this.gadget_ = ItemsUnion.updateLogic(this.maxK_, this.comparator_, this.gadget_, itemsSketch0);
    }

    public void update(ItemsSketch sketchIn) {
        this.gadget_ = ItemsUnion.updateLogic(this.maxK_, this.comparator_, this.gadget_, sketchIn);
    }

    public void update(Object dataItem) {
        if(dataItem == null) {
            return;
        }
        if(this.gadget_ == null) {
            this.gadget_ = ItemsSketch.newInstance(this.maxK_, this.comparator_);
        }
        this.gadget_.update(dataItem);
    }

    static ItemsSketch updateLogic(int myMaxK, Comparator comparator, ItemsSketch myQS, ItemsSketch other) {
        int v3;
        int v2;
        int v1 = 0;
        if(myQS == null) {
            v2 = 0;
        }
        else {
            v2 = myQS.isEmpty() ? 4 : 8;
        }
        if(other == null) {
            v3 = 0;
        }
        else {
            v3 = other.isEmpty() ? 1 : 2;
        }
        switch(v2 | v3) {
            case 1: {
                return ItemsSketch.newInstance(Math.min(myMaxK, other.getK()), comparator);
            }
            case 2: {
                if(!other.isEstimationMode()) {
                    myQS = ItemsSketch.newInstance(myMaxK, comparator);
                    int v4 = other.getBaseBufferCount();
                    Object[] arr_object = other.getCombinedBuffer();
                    while(v1 < v4) {
                        myQS.update(arr_object[v1]);
                        ++v1;
                    }
                    return myQS;
                }
                return myMaxK >= other.getK() ? ItemsSketch.copy(other) : other.downSample(myMaxK);
            }
            case 4: 
            case 5: 
            case 8: 
            case 9: {
                return myQS;
            label_30:
                if(myQS.getK() <= other.getK()) {
                    ItemsMergeImpl.mergeInto(other, myQS);
                    return myQS;
                }
                ItemsSketch itemsSketch2 = ItemsSketch.copy(other);
                ItemsMergeImpl.mergeInto(myQS, itemsSketch2);
                return itemsSketch2;
            }
            case 6: 
            case 10: {
                if(!other.isEstimationMode()) {
                    int v5 = other.getBaseBufferCount();
                    Object[] arr_object1 = other.getCombinedBuffer();
                    while(true) {
                        if(v1 >= v5) {
                            return myQS;
                        }
                        myQS.update(arr_object1[v1]);
                        ++v1;
                    }
                }
                goto label_30;
            }
            default: {
                return null;
            }
        }
    }
}

