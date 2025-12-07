package com.yahoo.memory;

final class DefaultMemoryManager implements MemoryRequestServer {
    private static final DefaultMemoryManager memMgr;

    static {
        DefaultMemoryManager.memMgr = new DefaultMemoryManager();
    }

    static DefaultMemoryManager getInstance() {
        return DefaultMemoryManager.memMgr;
    }

    @Override  // com.yahoo.memory.MemoryRequestServer
    public WritableMemory request(long capacityBytes) {
        WritableMemory writableMemory0 = WritableMemory.allocate(((int)capacityBytes));
        writableMemory0.setMemoryRequest(this);
        return writableMemory0;
    }

    @Override  // com.yahoo.memory.MemoryRequestServer
    public void requestClose(WritableMemory memoryToClose, WritableMemory newMemory) {
    }
}

