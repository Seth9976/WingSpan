package kotlinx.coroutines.debug.internal;

class DebugProbesImpl.SequenceNumberRefVolatile {
    volatile long sequenceNumber;

    public DebugProbesImpl.SequenceNumberRefVolatile(long v) {
        this.sequenceNumber = v;
    }
}

