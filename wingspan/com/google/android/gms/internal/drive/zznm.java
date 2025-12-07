package com.google.android.gms.internal.drive;

// 部分失败：枚举糖化
// 枚举按原样呈现，而不是糖化为Java 5枚举。
public class zznm extends Enum {
    public static final enum zznm zzwu;
    public static final enum zznm zzwv;
    public static final enum zznm zzww;
    public static final enum zznm zzwx;
    public static final enum zznm zzwy;
    public static final enum zznm zzwz;
    public static final enum zznm zzxa;
    public static final enum zznm zzxb;
    public static final enum zznm zzxc;
    public static final enum zznm zzxd;
    public static final enum zznm zzxe;
    public static final enum zznm zzxf;
    public static final enum zznm zzxg;
    public static final enum zznm zzxh;
    public static final enum zznm zzxi;
    public static final enum zznm zzxj;
    public static final enum zznm zzxk;
    public static final enum zznm zzxl;
    private final zznr zzxm;
    private final int zzxn;
    private static final zznm[] zzxo;

    static {
        zznm.zzwu = new zznm("DOUBLE", 0, zznr.zzxs, 1);
        zznm.zzwv = new zznm("FLOAT", 1, zznr.zzxr, 5);
        zznm.zzww = new zznm("INT64", 2, zznr.zzxq, 0);
        zznm.zzwx = new zznm("UINT64", 3, zznr.zzxq, 0);
        zznm.zzwy = new zznm("INT32", 4, zznr.zzxp, 0);
        zznm.zzwz = new zznm("FIXED64", 5, zznr.zzxq, 1);
        zznm.zzxa = new zznm("FIXED32", 6, zznr.zzxp, 5);
        zznm.zzxb = new zznm("BOOL", 7, zznr.zzxt, 0);
        com.google.android.gms.internal.drive.zznm.zznn zznn0 = new zznm("STRING", zznr.zzxu) {
        };
        zznm.zzxc = zznn0;
        com.google.android.gms.internal.drive.zznm.zzno zzno0 = new zznm("GROUP", zznr.zzxx) {
        };
        zznm.zzxd = zzno0;
        com.google.android.gms.internal.drive.zznm.zznp zznp0 = new zznm("MESSAGE", zznr.zzxx) {
        };
        zznm.zzxe = zznp0;
        com.google.android.gms.internal.drive.zznm.zznq zznq0 = new zznm("BYTES", zznr.zzxv) {
        };
        zznm.zzxf = zznq0;
        zznm.zzxg = new zznm("UINT32", 12, zznr.zzxp, 0);
        zznm.zzxh = new zznm("ENUM", 13, zznr.zzxw, 0);
        zznm.zzxi = new zznm("SFIXED32", 14, zznr.zzxp, 5);
        zznm.zzxj = new zznm("SFIXED64", 15, zznr.zzxq, 1);
        zznm.zzxk = new zznm("SINT32", 16, zznr.zzxp, 0);
        zznm.zzxl = new zznm("SINT64", 17, zznr.zzxq, 0);
        zznm.zzxo = new zznm[]{zznm.zzwu, zznm.zzwv, zznm.zzww, zznm.zzwx, zznm.zzwy, zznm.zzwz, zznm.zzxa, zznm.zzxb, zznn0, zzno0, zznp0, zznq0, zznm.zzxg, zznm.zzxh, zznm.zzxi, zznm.zzxj, zznm.zzxk, zznm.zzxl};
    }

    private zznm(String s, int v, zznr zznr0, int v1) {
        super(s, v);
        this.zzxm = zznr0;
        this.zzxn = v1;
    }

    zznm(String s, int v, zznr zznr0, int v1, zznl zznl0) {
        this(s, v, zznr0, v1);
    }

    public static zznm[] values() {
        return (zznm[])zznm.zzxo.clone();
    }

    public final zznr zzfj() {
        return this.zzxm;
    }

    public final int zzfk() {
        return this.zzxn;
    }
}

