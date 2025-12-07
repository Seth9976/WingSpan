package com.yahoo.memory;

public interface MemoryRequestServer {
    WritableMemory request(long arg1);

    void requestClose(WritableMemory arg1, WritableMemory arg2);
}

