package com.gameanalytics.sdk.threading;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

class FIFOPriorityQueue {
    static class FIFOEntry implements Comparable {
        private final Comparable entry;
        private static final AtomicLong seq;
        private final long seqNum;

        static {
            FIFOEntry.seq = new AtomicLong();
        }

        private FIFOEntry(Comparable entry) {
            this.seqNum = FIFOEntry.seq.getAndIncrement();
            this.entry = entry;
        }

        FIFOEntry(Comparable comparable0, com.gameanalytics.sdk.threading.FIFOPriorityQueue.1 fIFOPriorityQueue$10) {
            this(comparable0);
        }

        public int compareTo(FIFOEntry other) {
            int v = this.entry.compareTo(other.entry);
            if(v == 0 && other.entry != this.entry) {
                return this.seqNum >= other.seqNum ? 1 : -1;
            }
            return v;
        }

        @Override
        public int compareTo(Object other) {
            return this.compareTo(((FIFOEntry)other));
        }

        public Comparable getEntry() {
            return this.entry;
        }
    }

    private final PriorityBlockingQueue _queue;

    public FIFOPriorityQueue() {
        this._queue = new PriorityBlockingQueue();
    }

    public void add(Comparable value) {
        FIFOEntry fIFOPriorityQueue$FIFOEntry0 = new FIFOEntry(value, null);
        this._queue.add(fIFOPriorityQueue$FIFOEntry0);
    }

    public boolean isEmpty() {
        return this._queue.isEmpty();
    }

    public Comparable peek() {
        FIFOEntry fIFOPriorityQueue$FIFOEntry0 = (FIFOEntry)this._queue.peek();
        return fIFOPriorityQueue$FIFOEntry0 == null ? null : fIFOPriorityQueue$FIFOEntry0.getEntry();
    }

    public Comparable poll() {
        FIFOEntry fIFOPriorityQueue$FIFOEntry0 = (FIFOEntry)this._queue.poll();
        return fIFOPriorityQueue$FIFOEntry0 == null ? null : fIFOPriorityQueue$FIFOEntry0.getEntry();
    }

    class com.gameanalytics.sdk.threading.FIFOPriorityQueue.1 {
    }

}

