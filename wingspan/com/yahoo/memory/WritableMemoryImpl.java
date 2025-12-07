package com.yahoo.memory;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class WritableMemoryImpl extends WritableMemory {
    static final boolean $assertionsDisabled;
    static final WritableMemoryImpl ZERO_SIZE_MEMORY;
    private final ByteBuffer byteBuf;
    private final int capacity;
    private final int offset;

    static {
        WritableMemoryImpl.ZERO_SIZE_MEMORY = new WritableMemoryImpl(ByteBuffer.wrap(new byte[0]), ByteOrder.nativeOrder());
    }

    private WritableMemoryImpl(ByteBuffer bb, int offsetBytes, int capacityBytes, ByteOrder byteOrder) {
        this.byteBuf = bb;
        this.capacity = capacityBytes;
        this.offset = offsetBytes;
        bb.order(byteOrder);
    }

    WritableMemoryImpl(ByteBuffer bb, ByteOrder byteOrder) {
        this.byteBuf = bb;
        this.capacity = bb.capacity();
        this.offset = 0;
        bb.order(byteOrder);
    }

    @Override  // com.yahoo.memory.Memory
    public void checkBounds(long offsetBytes, long length) {
        Util.checkBounds(offsetBytes, length, this.capacity);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void clear() {
        this.fill(0L, ((long)this.capacity), 0);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void clear(long offsetBytes, long lengthBytes) {
        this.fill(offsetBytes, lengthBytes, 0);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void clearBits(long offsetBytes, byte bitMask) {
        int v1 = (int)(((long)this.offset) + offsetBytes);
        int v2 = this.byteBuf.get(v1);
        this.byteBuf.put(v1, ((byte)(v2 & 0xFF & ~bitMask)));
    }

    @Override  // com.yahoo.memory.Memory
    public int compareTo(long thisOffsetBytes, long thisLengthBytes, Memory that, long thatOffsetBytes, long thatLengthBytes) {
        Util.checkBounds(thisOffsetBytes, thisLengthBytes, this.capacity);
        Util.checkBounds(thatOffsetBytes, thatLengthBytes, that.getCapacity());
        int v4 = Long.compare(thisLengthBytes, thatLengthBytes);
        if(v4 < 0) {
            return -1;
        }
        if(v4 > 0) {
            return 1;
        }
        int v5 = (int)this.getRegionOffset(thisOffsetBytes);
        int v6 = (int)((WritableMemoryImpl)that).getRegionOffset(thatOffsetBytes);
        int v7 = ((int)thisLengthBytes) + v5;
        while(v5 < v7) {
            int v8 = this.byteBuf.get(v5);
            int v9 = ((WritableMemoryImpl)that).byteBuf.get(v6);
            if(v8 < v9) {
                return -1;
            }
            if(v8 > v9) {
                return 1;
            }
            ++v5;
            ++v6;
        }
        return 0;
    }

    @Override  // com.yahoo.memory.Memory
    public void copyTo(long srcOffsetBytes, WritableMemory destination, long dstOffsetBytes, long lengthBytes) {
        Util.checkBounds(srcOffsetBytes, lengthBytes, this.capacity);
        Util.checkBounds(dstOffsetBytes, lengthBytes, destination.getCapacity());
        if(this.isSameResource(destination) && srcOffsetBytes == dstOffsetBytes) {
            return;
        }
        byte[] arr_b = new byte[((int)lengthBytes)];
        this.getByteArray(srcOffsetBytes, arr_b, 0, ((int)lengthBytes));
        destination.putByteArray(dstOffsetBytes, arr_b, 0, ((int)lengthBytes));
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void fill(byte value) {
        this.fill(0L, ((long)this.capacity), value);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void fill(long offsetBytes, long lengthBytes, byte value) {
        Util.checkBounds(((int)offsetBytes), ((int)lengthBytes), this.capacity);
        int v2 = this.offset + ((int)offsetBytes);
        int v3 = ((int)lengthBytes) + v2;
        while(v2 < v3) {
            this.byteBuf.put(v2, value);
            ++v2;
        }
    }

    @Override  // com.yahoo.memory.WritableMemory
    public Object getArray() {
        return this.byteBuf.array();
    }

    @Override  // com.yahoo.memory.Memory
    public boolean getBoolean(long offsetBytes) {
        return this.byteBuf.get(this.offset + ((int)offsetBytes)) != 0;
    }

    @Override  // com.yahoo.memory.Memory
    public void getBooleanArray(long offsetBytes, boolean[] dstArray, int dstOffset, int lengthBooleans) {
        Util.checkBounds(offsetBytes, lengthBooleans, this.capacity);
        Util.checkBounds(dstOffset, lengthBooleans, dstArray.length);
        int v3 = (int)(((long)this.offset) + offsetBytes);
        int v4 = dstOffset;
        while(v4 < dstOffset + lengthBooleans) {
            dstArray[v4] = this.byteBuf.get(v3) != 0;
            ++v4;
            ++v3;
        }
    }

    @Override  // com.yahoo.memory.Memory
    public byte getByte(long offsetBytes) {
        return this.byteBuf.get(this.offset + ((int)offsetBytes));
    }

    @Override  // com.yahoo.memory.Memory
    public void getByteArray(long offsetBytes, byte[] dstArray, int dstOffset, int lengthBytes) {
        Util.checkBounds(offsetBytes, lengthBytes, this.capacity);
        Util.checkBounds(dstOffset, lengthBytes, dstArray.length);
        if(this.byteBuf.hasArray()) {
            System.arraycopy(this.byteBuf.array(), this.offset + ((int)offsetBytes), dstArray, dstOffset, lengthBytes);
            return;
        }
        int v3 = (int)(((long)this.offset) + offsetBytes);
        int v4 = dstOffset;
        while(v4 < dstOffset + lengthBytes) {
            dstArray[v4] = this.byteBuf.get(v3);
            ++v4;
            ++v3;
        }
    }

    @Override  // com.yahoo.memory.WritableMemory
    public ByteBuffer getByteBuffer() {
        return this.byteBuf;
    }

    @Override  // com.yahoo.memory.Memory
    public long getCapacity() {
        return (long)this.capacity;
    }

    @Override  // com.yahoo.memory.Memory
    public char getChar(long offsetBytes) {
        return this.byteBuf.getChar(this.offset + ((int)offsetBytes));
    }

    @Override  // com.yahoo.memory.Memory
    public void getCharArray(long offsetBytes, char[] dstArray, int dstOffset, int lengthChars) {
        Util.checkBounds(offsetBytes, lengthChars << 1, this.capacity);
        Util.checkBounds(dstOffset, lengthChars, dstArray.length);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = dstOffset;
        while(v4 < dstOffset + lengthChars) {
            dstArray[v4] = this.byteBuf.getChar(v3);
            ++v4;
            v3 += 2;
        }
    }

    @Override  // com.yahoo.memory.Memory
    public double getDouble(long offsetBytes) {
        return this.byteBuf.getDouble(this.offset + ((int)offsetBytes));
    }

    @Override  // com.yahoo.memory.Memory
    public void getDoubleArray(long offsetBytes, double[] dstArray, int dstOffset, int lengthDoubles) {
        Util.checkBounds(offsetBytes, lengthDoubles << 3, this.capacity);
        Util.checkBounds(dstOffset, lengthDoubles, dstArray.length);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = dstOffset;
        while(v4 < dstOffset + lengthDoubles) {
            dstArray[v4] = this.byteBuf.getDouble(v3);
            ++v4;
            v3 += 8;
        }
    }

    @Override  // com.yahoo.memory.Memory
    public float getFloat(long offsetBytes) {
        return this.byteBuf.getFloat(this.offset + ((int)offsetBytes));
    }

    @Override  // com.yahoo.memory.Memory
    public void getFloatArray(long offsetBytes, float[] dstArray, int dstOffset, int lengthFloats) {
        Util.checkBounds(offsetBytes, lengthFloats << 2, this.capacity);
        Util.checkBounds(dstOffset, lengthFloats, dstArray.length);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = dstOffset;
        while(v4 < dstOffset + lengthFloats) {
            dstArray[v4] = this.byteBuf.getFloat(v3);
            ++v4;
            v3 += 4;
        }
    }

    @Override  // com.yahoo.memory.Memory
    public int getInt(long offsetBytes) {
        return this.byteBuf.getInt(this.offset + ((int)offsetBytes));
    }

    @Override  // com.yahoo.memory.Memory
    public void getIntArray(long offsetBytes, int[] dstArray, int dstOffset, int lengthInts) {
        Util.checkBounds(offsetBytes, lengthInts << 2, this.capacity);
        Util.checkBounds(dstOffset, lengthInts, dstArray.length);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = dstOffset;
        while(v4 < dstOffset + lengthInts) {
            dstArray[v4] = this.byteBuf.getInt(v3);
            ++v4;
            v3 += 4;
        }
    }

    @Override  // com.yahoo.memory.Memory
    public long getLong(long offsetBytes) {
        return this.byteBuf.getLong(this.offset + ((int)offsetBytes));
    }

    @Override  // com.yahoo.memory.Memory
    public void getLongArray(long offsetBytes, long[] dstArray, int dstOffset, int lengthLongs) {
        Util.checkBounds(offsetBytes, lengthLongs << 3, this.capacity);
        Util.checkBounds(dstOffset, lengthLongs, dstArray.length);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = dstOffset;
        while(v4 < dstOffset + lengthLongs) {
            dstArray[v4] = this.byteBuf.getLong(v3);
            ++v4;
            v3 += 8;
        }
    }

    @Override  // com.yahoo.memory.WritableMemory
    public MemoryRequestServer getMemoryRequestServer() {
        return DefaultMemoryManager.getInstance();
    }

    @Override  // com.yahoo.memory.WritableMemory
    public long getRegionOffset(long offsetBytes) {
        return ((long)this.offset) + offsetBytes;
    }

    @Override  // com.yahoo.memory.Memory
    public ByteOrder getResourceOrder() {
        return this.byteBuf.order();
    }

    @Override  // com.yahoo.memory.Memory
    public short getShort(long offsetBytes) {
        return this.byteBuf.getShort(this.offset + ((int)offsetBytes));
    }

    @Override  // com.yahoo.memory.Memory
    public void getShortArray(long offsetBytes, short[] dstArray, int dstOffset, int lengthShorts) {
        Util.checkBounds(offsetBytes, lengthShorts << 1, this.capacity);
        Util.checkBounds(dstOffset, lengthShorts, dstArray.length);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = dstOffset;
        while(v4 < dstOffset + lengthShorts) {
            dstArray[v4] = this.byteBuf.getShort(v3);
            ++v4;
            v3 += 2;
        }
    }

    @Override  // com.yahoo.memory.Memory
    public boolean hasArray() {
        return this.byteBuf.hasArray();
    }

    @Override  // com.yahoo.memory.Memory
    public boolean hasByteBuffer() {
        return true;
    }

    @Override  // com.yahoo.memory.Memory
    public boolean isDirect() {
        return this.byteBuf.isDirect();
    }

    @Override  // com.yahoo.memory.Memory
    public boolean isResourceReadOnly() {
        return this.byteBuf.isReadOnly();
    }

    // 去混淆评级： 中等(50)
    @Override  // com.yahoo.memory.Memory
    public boolean isSameResource(Memory that) {
        return that != null && !this.isDirect() && !that.isDirect() && this.hasArray() && that.hasArray() && ((this.byteBuf == ((WritableMemoryImpl)that).byteBuf || this.byteBuf.array() == ((WritableMemoryImpl)that).byteBuf.array()) && this.capacity == ((WritableMemoryImpl)that).capacity && this.offset == ((WritableMemoryImpl)that).offset);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putBoolean(long offsetBytes, boolean value) {
        this.byteBuf.put(this.offset + ((int)offsetBytes), ((byte)value));
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putBooleanArray(long offsetBytes, boolean[] srcArray, int srcOffset, int length) {
        Util.checkBounds(srcOffset, length, srcArray.length);
        Util.checkBounds(offsetBytes, length, this.capacity);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = srcOffset;
        while(v4 < srcOffset + length) {
            this.byteBuf.put(v3, ((byte)srcArray[v4]));
            ++v4;
            ++v3;
        }
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putByte(long offsetBytes, byte value) {
        this.byteBuf.put(this.offset + ((int)offsetBytes), value);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putByteArray(long offsetBytes, byte[] srcArray, int srcOffset, int length) {
        Util.checkBounds(srcOffset, length, srcArray.length);
        Util.checkBounds(offsetBytes, length, this.capacity);
        if(this.byteBuf.hasArray()) {
            System.arraycopy(srcArray, srcOffset, this.byteBuf.array(), this.offset + ((int)offsetBytes), length);
            return;
        }
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = srcOffset;
        while(v4 < srcOffset + length) {
            this.byteBuf.put(v3, srcArray[v4]);
            ++v4;
            ++v3;
        }
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putChar(long offsetBytes, char value) {
        this.byteBuf.putChar(this.offset + ((int)offsetBytes), value);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putCharArray(long offsetBytes, char[] srcArray, int srcOffset, int length) {
        Util.checkBounds(srcOffset, length, srcArray.length);
        Util.checkBounds(offsetBytes, length << 1, this.capacity);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = srcOffset;
        while(v4 < srcOffset + length) {
            this.byteBuf.putChar(v3, srcArray[v4]);
            ++v4;
            v3 += 2;
        }
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putDouble(long offsetBytes, double value) {
        this.byteBuf.putDouble(this.offset + ((int)offsetBytes), value);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putDoubleArray(long offsetBytes, double[] srcArray, int srcOffset, int length) {
        Util.checkBounds(srcOffset, length, srcArray.length);
        Util.checkBounds(offsetBytes, length << 3, this.capacity);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = srcOffset;
        while(v4 < srcOffset + length) {
            this.byteBuf.putDouble(v3, srcArray[v4]);
            ++v4;
            v3 += 8;
        }
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putFloat(long offsetBytes, float value) {
        this.byteBuf.putFloat(this.offset + ((int)offsetBytes), value);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putFloatArray(long offsetBytes, float[] srcArray, int srcOffset, int length) {
        Util.checkBounds(srcOffset, length, srcArray.length);
        Util.checkBounds(offsetBytes, length << 2, this.capacity);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = srcOffset;
        while(v4 < srcOffset + length) {
            this.byteBuf.putFloat(v3, srcArray[v4]);
            ++v4;
            v3 += 4;
        }
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putInt(long offsetBytes, int value) {
        this.byteBuf.putInt(this.offset + ((int)offsetBytes), value);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putIntArray(long offsetBytes, int[] srcArray, int srcOffset, int length) {
        Util.checkBounds(srcOffset, length, srcArray.length);
        Util.checkBounds(offsetBytes, length << 2, this.capacity);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = srcOffset;
        while(v4 < srcOffset + length) {
            this.byteBuf.putInt(v3, srcArray[v4]);
            ++v4;
            v3 += 4;
        }
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putLong(long offsetBytes, long value) {
        this.byteBuf.putLong(this.offset + ((int)offsetBytes), value);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putLongArray(long offsetBytes, long[] srcArray, int srcOffset, int length) {
        Util.checkBounds(srcOffset, length, srcArray.length);
        Util.checkBounds(offsetBytes, length << 3, this.capacity);
        int v3 = this.offset + ((int)offsetBytes);
        int v4 = srcOffset;
        while(v4 < srcOffset + length) {
            this.byteBuf.putLong(v3, srcArray[v4]);
            ++v4;
            v3 += 8;
        }
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putShort(long offsetBytes, short value) {
        this.byteBuf.putShort(this.offset + ((int)offsetBytes), value);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void putShortArray(long offsetBytes, short[] srcArray, int srcOffset, int length) {
        Util.checkBounds(srcOffset, length, srcArray.length);
        Util.checkBounds(offsetBytes, length << 1, this.capacity);
        for(int v3 = srcOffset; v3 < srcOffset + length; ++v3) {
            this.byteBuf.putShort(srcArray[v3]);
        }
    }

    @Override  // com.yahoo.memory.Memory
    public Memory region(long offsetBytes, long capacityBytes) {
        return this.writableRegion(offsetBytes, capacityBytes);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void setBits(long offsetBytes, byte bitMask) {
        int v1 = this.offset + ((int)offsetBytes);
        int v2 = this.byteBuf.get(v1);
        this.byteBuf.put(v1, ((byte)(v2 | bitMask)));
    }

    @Override  // com.yahoo.memory.WritableMemory
    public void setMemoryRequest(MemoryRequestServer memReqSvr) {
    }

    @Override  // com.yahoo.memory.Memory
    public boolean swapBytes() {
        return this.byteBuf.order() != ByteOrder.nativeOrder();
    }

    @Override  // com.yahoo.memory.Memory
    static String toHex(String preamble, long offsetBytes, int lengthBytes, Memory mem) {
        Util.checkBounds(offsetBytes, lengthBytes, mem.getCapacity());
        StringBuilder stringBuilder0 = new StringBuilder();
        String s1 = "null";
        String s2 = ((WritableMemoryImpl)mem).byteBuf == null ? "null" : ((WritableMemoryImpl)mem).byteBuf.getClass().getSimpleName() + ", " + (((long)((WritableMemoryImpl)mem).byteBuf.hashCode()) & 0xFFFFFFFFL);
        MemoryRequestServer memoryRequestServer0 = ((WritableMemoryImpl)mem).getMemoryRequestServer();
        if(memoryRequestServer0 != null) {
            s1 = memoryRequestServer0.getClass().getSimpleName() + ", " + (0xFFFFFFFFL & ((long)memoryRequestServer0.hashCode()));
        }
        stringBuilder0.append(preamble);
        stringBuilder0.append("\n");
        stringBuilder0.append("ByteBuf, hashCode   : ");
        stringBuilder0.append(s2);
        stringBuilder0.append("\n");
        stringBuilder0.append("RegionOffset        : ");
        stringBuilder0.append(((WritableMemoryImpl)mem).getRegionOffset(0L));
        stringBuilder0.append("\n");
        stringBuilder0.append("Capacity            : ");
        stringBuilder0.append(mem.getCapacity());
        stringBuilder0.append("\n");
        stringBuilder0.append("MemReq, hashCode    : ");
        stringBuilder0.append(s1);
        stringBuilder0.append("\n");
        stringBuilder0.append("Resource Read Only  : ");
        stringBuilder0.append(mem.isResourceReadOnly());
        stringBuilder0.append("\n");
        stringBuilder0.append("Resource Endianness : ");
        stringBuilder0.append(((WritableMemoryImpl)mem).byteBuf.order().toString());
        stringBuilder0.append("\n");
        stringBuilder0.append("Data, littleEndian  :  0  1  2  3  4  5  6  7");
        for(long v2 = 0L; v2 < ((long)lengthBytes); ++v2) {
            long v3 = offsetBytes + v2;
            int v4 = mem.getByte(v3);
            if(Long.compare(v2 % 8L, 0L) == 0) {
                stringBuilder0.append(String.format("%n%20s: ", v3));
            }
            stringBuilder0.append(String.format("%02x ", ((int)(v4 & 0xFF))));
        }
        stringBuilder0.append("\n");
        return stringBuilder0.toString();
    }

    @Override  // com.yahoo.memory.Memory
    public String toHexString(String header, long offsetBytes, int lengthBytes) {
        return WritableMemoryImpl.toHex(("### " + this.getClass().getSimpleName() + " SUMMARY ###" + "\n" + "Header Comment      : " + header + "\n" + "Call Params         : " + (".toHexString" + String.format("(..., %d, %d)", offsetBytes, lengthBytes) + ", hashCode: " + (((long)this.hashCode()) & 0xFFFFFFFFL))), offsetBytes, lengthBytes, this);
    }

    @Override  // com.yahoo.memory.WritableMemory
    public WritableMemory writableDuplicate() {
        return this.writableRegion(0L, ((long)this.capacity));
    }

    @Override  // com.yahoo.memory.WritableMemory
    public WritableMemory writableRegion(long offsetBytes, long capacityBytes) {
        Util.checkBounds(offsetBytes, capacityBytes, this.capacity);
        ByteOrder byteOrder0 = this.byteBuf.order();
        return new WritableMemoryImpl(this.byteBuf, this.offset + ((int)offsetBytes), ((int)capacityBytes), byteOrder0);
    }
}

