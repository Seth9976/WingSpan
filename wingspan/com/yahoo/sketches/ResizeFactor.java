package com.yahoo.sketches;

public enum ResizeFactor {
    X1(0),
    X2(1),
    X4(2),
    X8(3);

    private int lg_;

    private static ResizeFactor[] $values() [...] // Inlined contents

    private ResizeFactor(int lg) {
        this.lg_ = lg;
    }

    public static ResizeFactor getRF(int lg) {
        ResizeFactor resizeFactor0 = ResizeFactor.X1;
        if(resizeFactor0.lg() == lg) {
            return resizeFactor0;
        }
        ResizeFactor resizeFactor1 = ResizeFactor.X2;
        if(resizeFactor1.lg() == lg) {
            return resizeFactor1;
        }
        return ResizeFactor.X4.lg() == lg ? ResizeFactor.X4 : ResizeFactor.X8;
    }

    public int getValue() {
        return 1 << this.lg_;
    }

    public int lg() {
        return this.lg_;
    }
}

