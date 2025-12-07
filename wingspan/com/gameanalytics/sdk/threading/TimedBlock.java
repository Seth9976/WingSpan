package com.gameanalytics.sdk.threading;

import java.util.Date;

class TimedBlock implements Comparable {
    public final IBlock block;
    public final Date deadLine;

    public TimedBlock(Date deadLine, IBlock block) {
        this.deadLine = deadLine;
        this.block = block;
    }

    public int compareTo(TimedBlock other) {
        return this.deadLine.compareTo(other.deadLine);
    }

    @Override
    public int compareTo(Object other) {
        return this.compareTo(((TimedBlock)other));
    }

    @Override
    public String toString() {
        return "{TimedBlock: deadLine=" + this.deadLine.getTime() + ", block=" + this.block.getName() + "}";
    }
}

