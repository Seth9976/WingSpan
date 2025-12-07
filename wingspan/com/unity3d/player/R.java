package com.unity3d.player;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
final class r extends Enum {
    public static final enum r a;
    public static final enum r b;
    public static final enum r c;

    static {
        r.a = new r("STARTED", 0);
        r.b = new r("PAUSED", 1);
        r.c = new r("STOPPED", 2);
    }

    private r(String s, int v) {
        super(s, v);
    }
}

