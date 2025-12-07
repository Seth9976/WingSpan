package com.google.android.gms.internal.drive;

import java.lang.reflect.Type;

public enum zzke {
    DOUBLE(0, zzkg.zzrg, zzks.zzsv),
    FLOAT(1, zzkg.zzrg, zzks.zzsu),
    INT64(2, zzkg.zzrg, zzks.zzst),
    UINT64(3, zzkg.zzrg, zzks.zzst),
    INT32(4, zzkg.zzrg, zzks.zzss),
    FIXED64(5, zzkg.zzrg, zzks.zzst),
    FIXED32(6, zzkg.zzrg, zzks.zzss),
    BOOL(7, zzkg.zzrg, zzks.zzsw),
    STRING(8, zzkg.zzrg, zzks.zzsx),
    MESSAGE(9, zzkg.zzrg, zzks.zzta),
    BYTES(10, zzkg.zzrg, zzks.zzsy),
    UINT32(11, zzkg.zzrg, zzks.zzss),
    ENUM(12, zzkg.zzrg, zzks.zzsz),
    SFIXED32(13, zzkg.zzrg, zzks.zzss),
    SFIXED64(14, zzkg.zzrg, zzks.zzst),
    SINT32(15, zzkg.zzrg, zzks.zzss),
    SINT64(16, zzkg.zzrg, zzks.zzst),
    GROUP(17, zzkg.zzrg, zzks.zzta),
    DOUBLE_LIST(18, zzkg.zzrh, zzks.zzsv),
    FLOAT_LIST(19, zzkg.zzrh, zzks.zzsu),
    INT64_LIST(20, zzkg.zzrh, zzks.zzst),
    UINT64_LIST(21, zzkg.zzrh, zzks.zzst),
    INT32_LIST(22, zzkg.zzrh, zzks.zzss),
    FIXED64_LIST(23, zzkg.zzrh, zzks.zzst),
    FIXED32_LIST(24, zzkg.zzrh, zzks.zzss),
    BOOL_LIST(25, zzkg.zzrh, zzks.zzsw),
    STRING_LIST(26, zzkg.zzrh, zzks.zzsx),
    MESSAGE_LIST(27, zzkg.zzrh, zzks.zzta),
    BYTES_LIST(28, zzkg.zzrh, zzks.zzsy),
    UINT32_LIST(29, zzkg.zzrh, zzks.zzss),
    ENUM_LIST(30, zzkg.zzrh, zzks.zzsz),
    SFIXED32_LIST(0x1F, zzkg.zzrh, zzks.zzss),
    SFIXED64_LIST(0x20, zzkg.zzrh, zzks.zzst),
    SINT32_LIST(33, zzkg.zzrh, zzks.zzss),
    SINT64_LIST(34, zzkg.zzrh, zzks.zzst),
    DOUBLE_LIST_PACKED(35, zzkg.zzri, zzks.zzsv),
    FLOAT_LIST_PACKED(36, zzkg.zzri, zzks.zzsu),
    INT64_LIST_PACKED(37, zzkg.zzri, zzks.zzst),
    UINT64_LIST_PACKED(38, zzkg.zzri, zzks.zzst),
    INT32_LIST_PACKED(39, zzkg.zzri, zzks.zzss),
    FIXED64_LIST_PACKED(40, zzkg.zzri, zzks.zzst),
    FIXED32_LIST_PACKED(41, zzkg.zzri, zzks.zzss),
    BOOL_LIST_PACKED(42, zzkg.zzri, zzks.zzsw),
    UINT32_LIST_PACKED(43, zzkg.zzri, zzks.zzss),
    ENUM_LIST_PACKED(44, zzkg.zzri, zzks.zzsz),
    SFIXED32_LIST_PACKED(45, zzkg.zzri, zzks.zzss),
    SFIXED64_LIST_PACKED(46, zzkg.zzri, zzks.zzst),
    SINT32_LIST_PACKED(0x2F, zzkg.zzri, zzks.zzss),
    SINT64_LIST_PACKED(0x30, zzkg.zzri, zzks.zzst),
    GROUP_LIST(49, zzkg.zzrh, zzks.zzta),
    MAP(50, zzkg.zzrj, zzks.zzsr);

    private final int id;
    private final zzks zzqx;
    private final zzkg zzqy;
    private final Class zzqz;
    private final boolean zzra;
    private static final zzke[] zzrb;
    private static final Type[] zzrc;
    private static final zzke[] zzrd;

    static {
        arr_zzke[0] = zzke.zzoy;
        arr_zzke[1] = zzke.zzoz;
        arr_zzke[2] = zzke.zzpa;
        arr_zzke[3] = zzke.zzpb;
        arr_zzke[4] = zzke.zzpc;
        arr_zzke[5] = zzke.zzpd;
        arr_zzke[6] = zzke.zzpe;
        arr_zzke[7] = zzke.zzpf;
        arr_zzke[8] = zzke.zzpg;
        arr_zzke[9] = zzke.zzph;
        arr_zzke[10] = zzke.zzpi;
        arr_zzke[11] = zzke.zzpj;
        arr_zzke[12] = zzke.zzpk;
        arr_zzke[13] = zzke.zzpl;
        arr_zzke[14] = zzke.zzpm;
        arr_zzke[15] = zzke.zzpn;
        arr_zzke[16] = zzke.zzpo;
        arr_zzke[17] = zzke.zzpp;
        arr_zzke[18] = zzke.zzpq;
        arr_zzke[19] = zzke.zzpr;
        arr_zzke[20] = zzke.zzps;
        arr_zzke[21] = zzke.zzpt;
        arr_zzke[22] = zzke.zzpu;
        arr_zzke[23] = zzke.zzpv;
        arr_zzke[24] = zzke.zzpw;
        arr_zzke[25] = zzke.zzpx;
        arr_zzke[26] = zzke.zzpy;
        arr_zzke[27] = zzke.zzpz;
        arr_zzke[28] = zzke.zzqa;
        arr_zzke[29] = zzke.zzqb;
        arr_zzke[30] = zzke.zzqc;
        arr_zzke[0x1F] = zzke.zzqd;
        arr_zzke[0x20] = zzke.zzqe;
        arr_zzke[33] = zzke.zzqf;
        arr_zzke[34] = zzke.zzqg;
        arr_zzke[35] = zzke.zzqh;
        arr_zzke[36] = zzke.zzqi;
        arr_zzke[37] = zzke.zzqj;
        arr_zzke[38] = zzke.zzqk;
        arr_zzke[39] = zzke.zzql;
        arr_zzke[40] = zzke.zzqm;
        arr_zzke[41] = zzke.zzqn;
        arr_zzke[42] = zzke.zzqo;
        arr_zzke[43] = zzke.zzqp;
        arr_zzke[44] = zzke.zzqq;
        arr_zzke[45] = zzke.zzqr;
        arr_zzke[46] = zzke.zzqs;
        arr_zzke[0x2F] = zzke.zzqt;
        arr_zzke[0x30] = zzke.zzqu;
        arr_zzke[49] = zzke.zzqv;
        arr_zzke[50] = zzke.zzqw;
        zzke.zzrd = arr_zzke;
        zzke.zzrc = new Type[0];
        zzke[] arr_zzke1 = (zzke[])zzke.zzrd.clone();
        zzke.zzrb = new zzke[arr_zzke1.length];
        for(int v = 0; v < arr_zzke1.length; ++v) {
            zzke zzke0 = arr_zzke1[v];
            zzke.zzrb[zzke0.id] = zzke0;
        }
    }

    private zzke(int v1, zzkg zzkg0, zzks zzks0) {
        this.id = v1;
        this.zzqy = zzkg0;
        this.zzqx = zzks0;
        boolean z = true;
        switch(zzkf.zzre[zzkg0.ordinal()]) {
            case 1: {
                this.zzqz = zzks0.zzdo();
                break;
            }
            case 2: {
                this.zzqz = zzks0.zzdo();
                break;
            }
            default: {
                this.zzqz = null;
            }
        }
        if(zzkg0 == zzkg.zzrg) {
            int v2 = zzkf.zzrf[zzks0.ordinal()];
            if(v2 == 1 || v2 == 2 || v2 == 3) {
                z = false;
            }
        }
        else {
            z = false;
        }
        this.zzra = z;
    }

    public final int id() {
        return this.id;
    }
}

