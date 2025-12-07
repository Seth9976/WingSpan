package com.yahoo.sketches;

import com.yahoo.memory.Memory;

public abstract class ArrayOfItemsSerDe {
    public abstract Object[] deserializeFromMemory(Memory arg1, int arg2);

    public abstract byte[] serializeToByteArray(Object[] arg1);
}

