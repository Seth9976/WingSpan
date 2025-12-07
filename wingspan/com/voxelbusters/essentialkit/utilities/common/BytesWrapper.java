package com.voxelbusters.essentialkit.utilities.common;

import com.voxelbusters.essentialkit.utilities.Logger;
import com.voxelbusters.essentialkit.utilities.common.annotations.SkipInCodeGenerator;

@SkipInCodeGenerator
public class BytesWrapper {
    private byte[] bytes;

    public BytesWrapper(byte[] arr_b) {
        this.bytes = arr_b;
    }

    public byte[] getBytes() {
        Logger.debug(("Get bytes : " + this.bytes + " Size : " + this.size()));
        return this.bytes;
    }

    public int size() {
        return this.bytes == null ? 0 : this.bytes.length;
    }
}

