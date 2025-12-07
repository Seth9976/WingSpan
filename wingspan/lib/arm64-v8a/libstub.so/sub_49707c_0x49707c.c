// 函数: sub_49707c
// 地址: 0x49707c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
char* x9 = *arg1
int64_t x10 = arg1[1]
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
    ** x8_2

if (x10 - x9 u< 2)
label_4970b4:
    x8_2 = nullptr
label_4970c0:
    
    if (*(x24 + 0x28) == x8)
        return x8_2
    
    __stack_chk_fail()
    noreturn

uint32_t x11_1 = zx.d(*x9)
char x21_1

if (x11_1 != 0x67)
    x21_1 = 0
else
    if (zx.d(x9[1]) != 0x73)
        x21_1 = 0
    else
        x9 = &x9[2]
        *arg1 = x9
        
        if (x10 - x9 u< 2)
            goto label_4970b4
        
        x21_1 = 1
    
    x11_1 = zx.d(*x9)

uint64_t x8_5 = zx.q(x11_1 - 0x31)
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
    ** var_60
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
    ** x0
char* const x1_1
void* x2_1
void* x8_24
void* x8_26
void* x8_36
void* x8_82
void* x8_94
void* x8_108
void* x8_120
void* x8_147
char const* const x9_9
int64_t x9_14
void* x9_39
int64_t x9_44
void* x9_45
int64_t x9_65
int64_t x9_70
int64_t x9_73
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
    * x10_10
int16_t x11_7
char const* const x11_12
char const* const x12_5
void* const x12_10
char* const x12_11
void* const x12_12
void* x20_3
void* x20_6
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FunctionParam::VTable
    ** x20_10
int64_t x20_12
int64_t x20_13
int64_t x20_15
int64_t x21_3
void* x21_5
void** x21_13
void** x21_17
int64_t x21_19
void** x21_23
int64_t x22_5
void** x22_10
void** x23_2
void* x8_67
int64_t x9_16
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
    * x10_12
int16_t x11_10
void* x20_7
void** x21_6

if (x8_5.d u> 0x43)
label_4976f8:
    x8_2 = nullptr
    
    if (x10 - x9 u< 0xb || x11_1 != 0x75)
        goto label_4970c0
    
    void* x0_31
    
    if (zx.d(x9[1]) != 0x38 || zx.d(x9[2]) != 0x5f || zx.d(x9[3]) != 0x5f || zx.d(x9[4]) != 0x75
            || zx.d(x9[5]) != 0x75 || zx.d(x9[6]) != 0x69 || zx.d(x9[7]) != 0x64
            || zx.d(x9[8]) != 0x6f || zx.d(x9[9]) != 0x66 || zx.d(x9[0xa]) != 0x74)
        if (zx.d(x9[1]) != 0x38 || zx.d(x9[2]) != 0x5f || zx.d(x9[3]) != 0x5f || zx.d(x9[4]) != 0x75
                || zx.d(x9[5]) != 0x75 || zx.d(x9[6]) != 0x69 || zx.d(x9[7]) != 0x64
                || zx.d(x9[8]) != 0x6f || zx.d(x9[9]) != 0x66 || zx.d(x9[0xa]) != 0x7a)
            goto label_4970b4
        
        *arg1 = &x9[0xb]
        x0_31 = sub_49707c(arg1)
        
        if (x0_31 == 0)
            goto label_4970b4
    else
        *arg1 = &x9[0xb]
        x0_31 = sub_492f20(arg1)
        
        if (x0_31 == 0)
            goto label_4970b4
    
    x21_6 = arg1[0x266]
    x20_7 = x0_31
    int64_t x8_66 = x21_6[1]
    
    if (x8_66 + 0x20 u< 0xff0)
        goto label_49785c
    
    void** x0_33 = malloc(0x1000)
    
    if (x0_33 != 0)
        x8_66 = 0
        *x0_33 = x21_6
        x0_33[1] = 0
        x21_6 = x0_33
        arg1[0x266] = x0_33
    label_49785c:
        x11_10 = 0x140
        x9_16 = x8_66 + 0x20
        x8_67 = x21_6 + x8_66
        x10_12 = &_vtable_for_(anonymous namespace)::itanium_demangle::UUIDOfExpr{for `(anonymous namespace)::itanium_demangle::Node'}
        goto label_498520
else
    switch (x8_5)
        case 0, 1, 2, 3, 4, 5, 6, 7, 8
        label_497140:
            x0 = sub_49a398(arg1)
        label_4988ec:
            
            if (*(x24 + 0x28) == x8)
                return x0
            
            __stack_chk_fail()
            noreturn
        case 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 
                0x19, 0x1a, 0x1c, 0x1d, 0x1e, 0x1f, 0x20, 0x21, 0x22, 0x24, 0x25, 0x26, 0x27, 0x28, 
                0x29, 0x2a, 0x2b, 0x2c, 0x2d, 0x2e, 0x2f, 0x31, 0x37, 0x39, 0x3a
            goto label_4976f8
        case 0x1b
            x0 = sub_498f40(arg1)
            goto label_4988ec
        case 0x23
            x0 = sub_49615c(arg1)
            goto label_4988ec
        case 0x30
            uint64_t x10_8 = zx.q(zx.d(x9[1]) - 0x4e)
            x8_2 = nullptr
            
            if (x10_8.d u> 0x2c)
                goto label_4970c0
            
            switch (x10_8)
                case 0
                    *arg1 = &x9[2]
                    x1_1 = "&="
                    goto label_498220
                case 1, 2, 3, 4, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 0x14, 
                        0x15, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f, 0x21, 0x22, 
                        0x23, 0x24
                    goto label_4970c0
                case 5
                    x8_24 = &x9[2]
                    x1_1 = "="
                    goto label_4988d4
                case 0x13
                    x1_1 = &data_451fb2
                    *arg1 = &x9[2]
                    goto label_498220
                case 0x16
                    *arg1 = &x9[2]
                    int64_t x0_98 = sub_49707c(arg1)
                    
                    if (x0_98 == 0)
                        goto label_4970b4
                    
                    x21_13 = arg1[0x266]
                    x20_12 = x0_98
                    int64_t x8_137 = x21_13[1]
                    
                    if (x8_137 + 0x30 u< 0xff0)
                        goto label_498394
                    
                    void*** x0_99 = malloc(0x1000)
                    
                    if (x0_99 != 0)
                        x8_137 = 0
                        *x0_99 = x21_13
                        x0_99[1] = 0
                        x21_13 = x0_99
                        arg1[0x266] = x0_99
                    label_498394:
                        x9_70 = x8_137 + 0x30
                        x8_94 = x21_13 + x8_137
                        x12_10 = &data_452170
                        goto label_4988ac
                case 0x20
                    x8_24 = &x9[2]
                    x1_1 = &data_452170
                    goto label_4988d4
        case 0x32
            uint64_t x11_4 = zx.q(zx.d(x9[1]) - 0x63)
            x8_2 = nullptr
            
            if (x11_4.d u> 0x13)
                goto label_4970c0
            
            switch (x11_4)
                case 0
                    *arg1 = &x9[2]
                    void* x0_14 = sub_492f20(arg1)
                    
                    if (x0_14 == 0)
                        goto label_4970b4
                    
                    x20_3 = x0_14
                    int64_t x0_16 = sub_49707c(arg1)
                    
                    if (x0_16 == 0)
                        goto label_4970b4
                    
                    void** x22_4 = arg1[0x266]
                    x21_3 = x0_16
                    int64_t x8_21 = x22_4[1]
                    
                    if (x8_21 + 0x30 u< 0xff0)
                        goto label_497404
                    
                    void** x0_17 = malloc(0x1000)
                    
                    if (x0_17 != 0)
                        x8_21 = 0
                        *x0_17 = x22_4
                        x0_17[1] = 0
                        x22_4 = x0_17
                        arg1[0x266] = x0_17
                    label_497404:
                        x12_5 = "const_cast"
                        x22_4[1] = x8_21 + 0x30
                        x8_2 = x22_4 + x8_21 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::CastExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x9_9 = &data_40c656[0xa]
                        goto label_498718
                case 1, 2, 3, 4, 5, 6, 7, 8, 0xb, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12
                    goto label_4970c0
                case 9
                    *arg1 = &x9[2]
                    void* x0_50 = sub_49707c(arg1)
                    
                    if (x0_50 == 0)
                        goto label_4970b4
                    
                    x20_6 = x0_50
                    int64_t x22_7 = (arg1[3] - arg1[2]) s>> 3
                    char* x8_91
                    
                    while (true)
                        x8_91 = *arg1
                        
                        if (x8_91 != arg1[1] && zx.d(*x8_91) == 0x45)
                            break
                        
                        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                            ** x0_52 = sub_49707c(arg1)
                        var_60 = x0_52
                        
                        if (x0_52 == 0)
                            goto label_4970b4
                        
                        sub_4953d4(&arg1[2], &var_60)
                    
                    int64_t x2_5 = arg1[3]
                    int64_t x22_20 = x22_7 << 3
                    int64_t x1_14 = arg1[2] + x22_20
                    *arg1 = &x8_91[1]
                    void* x0_150
                    int64_t x1_15
                    x0_150, x1_15 = sub_49e548(arg1, x1_14, x2_5)
                    x23_2 = arg1[0x266]
                    x21_5 = x0_150
                    arg1[3] = arg1[2] + x22_20
                    int64_t x8_179 = x23_2[1]
                    x22_5 = x1_15
                    
                    if (x8_179 + 0x30 u< 0xff0)
                        goto label_498b68
                    
                    void*** x0_151 = malloc(0x1000)
                    
                    if (x0_151 != 0)
                        x8_179 = 0
                        *x0_151 = x23_2
                        x0_151[1] = 0
                        x23_2 = x0_151
                        arg1[0x266] = x0_151
                    label_498b68:
                        x11_7 = 0x137
                        x9_14 = x8_179 + 0x30
                        x8_36 = x23_2 + x8_179
                        x10_10 = &_vtable_for_(anonymous namespace)::itanium_demangle::CallExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        goto label_498b7c
                case 0xa
                    x8_24 = &x9[2]
                    x1_1 = ","
                    goto label_4988d4
                case 0xc
                    *arg1 = &x9[2]
                    int64_t x0_55 = sub_49707c(arg1)
                    
                    if (x0_55 == 0)
                        goto label_4970b4
                    
                    x21_13 = arg1[0x266]
                    x20_12 = x0_55
                    int64_t x8_93 = x21_13[1]
                    
                    if (x8_93 + 0x30 u< 0xff0)
                        goto label_497bf8
                    
                    void*** x0_56 = malloc(0x1000)
                    
                    if (x0_56 != 0)
                        x8_93 = 0
                        *x0_56 = x21_13
                        x0_56[1] = 0
                        x21_13 = x0_56
                        arg1[0x266] = x0_56
                    label_497bf8:
                        x9_70 = x8_93 + 0x30
                        x8_94 = x21_13 + x8_93
                        x12_10 = &data_452172
                        goto label_4988ac
                case 0x13
                    if (x10 - x9 u< 2)
                        goto label_4970b4
                    
                    char x21_14 = arg1[0x61].b
                    *arg1 = &x9[2]
                    arg1[0x61].b = 0
                    void* x0_58 = sub_492f20(arg1)
                    x20_6 = x0_58
                    arg1[0x61].b = x21_14
                    
                    if (x0_58 == 0)
                        goto label_4970b4
                    
                    char* x9_32 = *arg1
                    int64_t x8_97 = arg1[1]
                    
                    if (x9_32 != x8_97 && zx.d(*x9_32) == 0x5f)
                        void* x9_33 = &x9_32[1]
                        *arg1 = x9_33
                        int64_t x22_8 = (arg1[3] - arg1[2]) s>> 3
                        
                        if (x9_33 == x8_97)
                            goto label_497c8c
                        
                        while (true)
                            if (zx.d(*x9_33) == 0x45)
                                int64_t x9_96 = arg1[2]
                                int64_t x2_7 = arg1[3]
                                int64_t x22_23 = x22_8 << 3
                                *arg1 = x9_33 + 1
                                void* x0_168
                                int64_t x1_20
                                x0_168, x1_20 = sub_49e548(arg1, x9_96 + x22_23, x2_7)
                                x23_2 = arg1[0x266]
                                x21_5 = x0_168
                                arg1[3] = arg1[2] + x22_23
                                int64_t x8_198 = x23_2[1]
                                x22_5 = x1_20
                                
                                if (x8_198 + 0x30 u>= 0xff0)
                                    void** x0_169 = malloc(0x1000)
                                    
                                    if (x0_169 == 0)
                                        goto label_498f34
                                    
                                    x8_198 = 0
                                    *x0_169 = x23_2
                                    x0_169[1] = 0
                                    x23_2 = x0_169
                                    arg1[0x266] = x0_169
                                
                                x11_7 = 0x13c
                                x9_14 = x8_198 + 0x30
                                x8_36 = x23_2 + x8_198
                                x10_10 = &_vtable_for_(anonymous namespace)::itanium_demangle::ConversionExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                                break
                            
                        label_497c8c:
                            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                                ** x0_60 = sub_49707c(arg1)
                            var_60 = x0_60
                            
                            if (x0_60 == 0)
                                goto label_4970b4
                            
                            sub_4953d4(&arg1[2], &var_60)
                            x9_33 = *arg1
                            
                            if (x9_33 == arg1[1])
                                goto label_497c8c
                        
                        goto label_498b7c
                    
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                        ** x0_160 = sub_49707c(arg1)
                    var_60 = x0_160
                    
                    if (x0_160 == 0)
                        goto label_4970b4
                    
                    void** x21_27 = arg1[0x266]
                    int64_t x8_186 = x21_27[1]
                    
                    if (x8_186 + 0x10 u< 0xff0)
                        goto label_498c98
                    
                    void** x0_161 = malloc(0x1000)
                    
                    if (x0_161 != 0)
                        x8_186 = 0
                        *x0_161 = x21_27
                        x0_161[1] = 0
                        x21_27 = x0_161
                        arg1[0x266] = x0_161
                    label_498c98:
                        x21_27[1] = x8_186 + 0x10
                        *(x21_27 + x8_186 + 0x10) = var_60
                        void** x22_21 = arg1[0x266]
                        int64_t x8_187 = x22_21[1]
                        
                        if (x8_187 + 0x30 u< 0xff0)
                            goto label_498cf4
                        
                        void** x0_162 = malloc(0x1000)
                        
                        if (x0_162 != 0)
                            x8_187 = 0
                            *x0_162 = x22_21
                            x0_162[1] = 0
                            x22_21 = x0_162
                            arg1[0x266] = x0_162
                        label_498cf4:
                            x22_21[1] = x8_187 + 0x30
                            x8_2 = x22_21 + x8_187 + 0x10
                            *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::ConversionExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                            x8_2[1].d = 0x101013c
                            x8_2[2] = x20_6
                            x8_2[3] = x21_27 + x8_186 + 0x10
                            x8_2[4] = 1
                            goto label_4970c0
        case 0x33
            uint64_t x10_2 = zx.q(zx.d(x9[1]) - 0x56)
            x8_2 = nullptr
            
            if (x10_2.d u> 0x20)
                goto label_4970c0
            
            void* x9_66
            
            switch (x10_2)
                case 0
                    *arg1 = &x9[2]
                    x1_1 = "/="
                    goto label_498220
                case 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xa, 0xc, 0xe, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 
                        0x17, 0x19, 0x1a, 0x1b, 0x1c, 0x1f
                    goto label_4970c0
                case 0xb
                    *arg1 = &x9[2]
                    int64_t x0_115 = sub_49707c(arg1)
                    
                    if (x0_115 == 0)
                        goto label_4970b4
                    
                    void** x22_13 = arg1[0x266]
                    int64_t x8_149 = x22_13[1]
                    
                    if (x8_149 + 0x20 u< 0xff0)
                        goto label_4985fc
                    
                    void** x0_116 = malloc(0x1000)
                    
                    if (x0_116 != 0)
                        x8_149 = 0
                        *x0_116 = x22_13
                        x0_116[1] = 0
                        x22_13 = x0_116
                        arg1[0x266] = x0_116
                    label_4985fc:
                        x22_13[1] = x8_149 + 0x20
                        x8_2 = x22_13 + x8_149 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::DeleteExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_2[1].d = 0x1010139
                        x8_2[2] = x0_115
                        x8_2[3].b = x21_1
                        *(x8_2 + 0x19) = 1
                        goto label_4970c0
                case 0xd
                    *arg1 = &x9[2]
                    void* x0_121 = sub_492f20(arg1)
                    
                    if (x0_121 == 0)
                        goto label_4970b4
                    
                    x20_3 = x0_121
                    int64_t x0_123 = sub_49707c(arg1)
                    
                    if (x0_123 == 0)
                        goto label_4970b4
                    
                    void** x22_15 = arg1[0x266]
                    x21_3 = x0_123
                    int64_t x8_155 = x22_15[1]
                    
                    if (x8_155 + 0x30 u< 0xff0)
                        goto label_498704
                    
                    void** x0_124 = malloc(0x1000)
                    
                    if (x0_124 != 0)
                        x8_155 = 0
                        *x0_124 = x22_15
                        x0_124[1] = 0
                        x22_15 = x0_124
                        arg1[0x266] = x0_124
                    label_498704:
                        x12_5 = "dynamic_cast"
                        x22_15[1] = x8_155 + 0x30
                        x8_2 = x22_15 + x8_155 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::CastExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x9_9 = &data_40e249[0xc]
                    label_498718:
                        x8_2[1].d = 0x1010135
                        x8_2[2] = x12_5
                        x8_2[3] = x9_9
                        x8_2[4] = x20_3
                        x8_2[5] = x21_3
                        goto label_4970c0
                case 0xf
                    *arg1 = &x9[2]
                    int64_t x0_136 = sub_49707c(arg1)
                    
                    if (x0_136 == 0)
                        goto label_4970b4
                    
                    x21_13 = arg1[0x266]
                    x20_12 = x0_136
                    int64_t x8_163 = x21_13[1]
                    
                    if (x8_163 + 0x30 u< 0xff0)
                        goto label_498898
                    
                    void*** x0_137 = malloc(0x1000)
                    
                    if (x0_137 != 0)
                        x8_163 = 0
                        *x0_137 = x21_13
                        x0_137[1] = 0
                        x21_13 = x0_137
                        arg1[0x266] = x0_137
                    label_498898:
                        x9_70 = x8_163 + 0x30
                        x8_94 = x21_13 + x8_163
                        x12_10 = "*"
                    label_4988ac:
                        x21_13[1] = x9_70
                        x8_2 = x8_94 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::PrefixExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x9_45 = x12_10 + 1
                    label_4988b8:
                        x8_2[1].d = 0x101013a
                        x8_2[2] = x12_10
                        x8_2[3] = x9_45
                        x8_2[4] = x20_12
                        goto label_4970c0
                case 0x16
                    *arg1 = &x9[2]
                    int64_t x0_118 = sub_49707c(arg1)
                    
                    if (x0_118 == 0)
                        goto label_4970b4
                    
                    void** x22_14 = arg1[0x266]
                    int64_t x8_152 = x22_14[1]
                    
                    if (x8_152 + 0x20 u< 0xff0)
                        goto label_498678
                    
                    void** x0_119 = malloc(0x1000)
                    
                    if (x0_119 != 0)
                        x8_152 = 0
                        *x0_119 = x22_14
                        x0_119[1] = 0
                        x22_14 = x0_119
                        arg1[0x266] = x0_119
                    label_498678:
                        x22_14[1] = x8_152 + 0x20
                        x8_2 = x22_14 + x8_152 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::DeleteExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_2[1].d = 0x1010139
                        x8_2[2] = x0_118
                        x8_2[3].b = x21_1
                        *(x8_2 + 0x19) = 0
                        goto label_4970c0
                case 0x18
                    goto label_497140
                case 0x1d
                    *arg1 = &x9[2]
                    int64_t x0_126 = sub_49707c(arg1)
                    
                    if (x0_126 == 0)
                        goto label_4970b4
                    
                    x20_13 = x0_126
                    int64_t x0_128 = sub_49707c(arg1)
                    
                    if (x0_128 == 0)
                        goto label_4970b4
                    
                    x22_10 = arg1[0x266]
                    x21_19 = x0_128
                    int64_t x8_158 = x22_10[1]
                    
                    if (x8_158 + 0x30 u< 0xff0)
                        goto label_49878c
                    
                    void*** x0_129 = malloc(0x1000)
                    
                    if (x0_129 != 0)
                        x8_158 = 0
                        *x0_129 = x22_10
                        x0_129[1] = 0
                        x22_10 = x0_129
                        arg1[0x266] = x0_129
                    label_49878c:
                        x9_65 = x8_158 + 0x30
                        x8_120 = x22_10 + x8_158
                        x12_11 = ".*"
                    label_4987a0:
                        x22_10[1] = x9_65
                        x8_2 = x8_120 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::MemberExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x9_66 = &x12_11[2]
                        goto label_498834
                case 0x1e
                    *arg1 = &x9[2]
                    int64_t x0_131 = sub_49707c(arg1)
                    
                    if (x0_131 == 0)
                        goto label_4970b4
                    
                    x20_13 = x0_131
                    int64_t x0_133 = sub_49707c(arg1)
                    
                    if (x0_133 == 0)
                        goto label_4970b4
                    
                    void** x22_16 = arg1[0x266]
                    x21_19 = x0_133
                    int64_t x8_160 = x22_16[1]
                    
                    if (x8_160 + 0x30 u< 0xff0)
                        goto label_498820
                    
                    void** x0_134 = malloc(0x1000)
                    
                    if (x0_134 != 0)
                        x8_160 = 0
                        *x0_134 = x22_16
                        x0_134[1] = 0
                        x22_16 = x0_134
                        arg1[0x266] = x0_134
                    label_498820:
                        x12_11 = "."
                        x22_16[1] = x8_160 + 0x30
                        x8_2 = x22_16 + x8_160 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::MemberExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x9_66 = &data_40c307[1]
                    label_498834:
                        x8_2[1].d = 0x1010133
                        x8_2[2] = x20_13
                        x8_2[3] = x12_11
                        x8_2[4] = x9_66
                        x8_2[5] = x21_19
                        goto label_4970c0
                case 0x20
                    x8_24 = &x9[2]
                    x1_1 = "/"
                    goto label_4988d4
        case 0x34
            uint32_t x8_23 = zx.d(x9[1])
            
            if (x8_23 == 0x4f)
                *arg1 = &x9[2]
                x1_1 = "^="
            label_498220:
                x2_1 = &x1_1[2]
                goto label_4988e0
            
            if (x8_23 == 0x71)
                *arg1 = &x9[2]
                x1_1 = "=="
                goto label_498220
            
            if (x8_23 != 0x6f)
                goto label_4970b4
            
            x8_24 = &x9[2]
            x1_1 = "^"
            goto label_4988d4
        case 0x35
            void* x8_16 = x10 - x9
            uint32_t x10_5
            
            if (x8_16 u>= 2)
                x10_5 = zx.d(x9[1])
            
            if (x8_16 u< 2
                    || (x10_5 != 0x70 && (x8_16 u< 3 || x10_5 != 0x4c || zx.d(x9[2]) - 0x30 u> 9)))
                x0 = sub_499cfc(arg1)
            else
                x0 = sub_4999c0(arg1)
            
            goto label_4988ec
        case 0x36
            uint32_t x8_17 = zx.d(x9[1])
            
            if (x8_17 != 0x74)
                if (x8_17 != 0x65)
                    goto label_4970b4
                
                *arg1 = &x9[2]
                x1_1 = ">="
                goto label_498220
            
            x8_24 = &x9[2]
            x1_1 = ">"
        label_4988d4:
            *arg1 = x8_24
            x2_1 = &x1_1[1]
        label_4988e0:
            x0 = sub_49a2e8(arg1, x1_1, x2_1)
            goto label_4988ec
        case 0x38
            uint32_t x8_10 = zx.d(x9[1])
            
            if (x8_10 == 0x6c)
                void* x8_68 = &x9[2]
                *arg1 = x8_68
                int64_t x21_7 = (arg1[3] - arg1[2]) s>> 3
                
                if (x8_68 == x10)
                    goto label_4978a4
                
                while (true)
                    if (zx.d(*x8_68) == 0x45)
                        int64_t x2_2 = arg1[3]
                        int64_t x21_20 = x21_7 << 3
                        int64_t x1_8 = arg1[2] + x21_20
                        *arg1 = x8_68 + 1
                        void* x0_91
                        int64_t x1_9
                        x0_91, x1_9 = sub_49e548(arg1, x1_8, x2_2)
                        void** x22_11 = arg1[0x266]
                        arg1[3] = arg1[2] + x21_20
                        int64_t x8_130 = x22_11[1]
                        
                        if (x8_130 + 0x30 u>= 0xff0)
                            void** x0_92 = malloc(0x1000)
                            
                            if (x0_92 == 0)
                                goto label_498f34
                            
                            x8_130 = 0
                            *x0_92 = x22_11
                            x0_92[1] = 0
                            x22_11 = x0_92
                            arg1[0x266] = x0_92
                        
                        x22_11[1] = x8_130 + 0x30
                        x8_2 = x22_11 + x8_130 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::InitListExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_2[1].d = 0x101013d
                        x8_2[2] = 0
                        x8_2[3] = x0_91
                        x8_2[4] = x1_9
                        break
                    
                label_4978a4:
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                        ** x0_35 = sub_49a9cc(arg1)
                    var_60 = x0_35
                    
                    if (x0_35 == 0)
                        goto label_4970b4
                    
                    sub_4953d4(&arg1[2], &var_60)
                    x8_68 = *arg1
                    
                    if (x8_68 == arg1[1])
                        goto label_4978a4
                
                goto label_4970c0
            
            if (x8_10 != 0x78)
                goto label_4970b4
            
            *arg1 = &x9[2]
            int64_t x0_5 = sub_49707c(arg1)
            
            if (x0_5 == 0)
                goto label_4970b4
            
            int64_t x0_7 = sub_49707c(arg1)
            
            if (x0_7 == 0)
                goto label_4970b4
            
            void** x22_1 = arg1[0x266]
            int64_t x8_12 = x22_1[1]
            
            if (x8_12 + 0x20 u< 0xff0)
                goto label_497250
            
            void** x0_8 = malloc(0x1000)
            
            if (x0_8 != 0)
                x8_12 = 0
                *x0_8 = x22_1
                x0_8[1] = 0
                x22_1 = x0_8
                arg1[0x266] = x0_8
            label_497250:
                x22_1[1] = x8_12 + 0x20
                x8_2 = x22_1 + x8_12 + 0x10
                *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::ArraySubscriptExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                x8_2[1].d = 0x1010130
                x8_2[2] = x0_5
                x8_2[3] = x0_7
                goto label_4970c0
        case 0x3b
            uint64_t x10_6 = zx.q(zx.d(x9[1]) - 0x53)
            x8_2 = nullptr
            
            if (x10_6.d u> 0x21)
                goto label_4970c0
            
            switch (x10_6)
                case 0
                    x8_26 = &x9[2]
                    x1_1 = "<<="
                label_497fa8:
                    *arg1 = x8_26
                    x2_1 = &x1_1[3]
                    goto label_4988e0
                case 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x13, 
                        0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f
                    goto label_4970c0
                case 0x12
                    *arg1 = &x9[2]
                    x1_1 = &data_451a53
                    goto label_498220
                case 0x20
                    *arg1 = &x9[2]
                    x1_1 = "<<"
                    goto label_498220
                case 0x21
                    x8_24 = &x9[2]
                    x1_1 = "<"
                    goto label_4988d4
        case 0x3c
            uint64_t x11_9 = zx.q(zx.d(x9[1]) - 0x49)
            x8_2 = nullptr
            
            if (x11_9.d u> 0x24)
                goto label_4970c0
            
            switch (x11_9)
                case 0
                    *arg1 = &x9[2]
                    x1_1 = "-="
                    goto label_498220
                case 1, 2, 4, 5, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 0x13, 
                        0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f, 
                        0x21, 0x22
                    goto label_4970c0
                case 3
                    *arg1 = &x9[2]
                    x1_1 = "*="
                    goto label_498220
                case 0x20
                    x8_24 = &x9[2]
                    x1_1 = "-"
                    goto label_4988d4
                case 0x23
                    x8_24 = &x9[2]
                    x1_1 = "*"
                    goto label_4988d4
                case 0x24
                    *arg1 = &x9[2]
                    
                    if (&x9[2] == x10 || zx.d(x9[2]) != 0x5f)
                        int64_t x0_112 = sub_49707c(arg1)
                        
                        if (x0_112 == 0)
                            goto label_4970b4
                        
                        x21_23 = arg1[0x266]
                        x20_15 = x0_112
                        int64_t x8_146 = x21_23[1]
                        
                        if (x8_146 + 0x30 u< 0xff0)
                            goto label_498580
                        
                        void** x0_113 = malloc(0x1000)
                        
                        if (x0_113 != 0)
                            x8_146 = 0
                            *x0_113 = x21_23
                            x0_113[1] = 0
                            x21_23 = x0_113
                            arg1[0x266] = x0_113
                        label_498580:
                            x9_73 = x8_146 + 0x30
                            x8_147 = x21_23 + x8_146
                            x12_12 = &data_4525e7
                            goto label_498970
                    else
                        *arg1 = &x9[3]
                        int64_t x0_68 = sub_49707c(arg1)
                        
                        if (x0_68 == 0)
                            goto label_4970b4
                        
                        x21_17 = arg1[0x266]
                        x20_12 = x0_68
                        int64_t x8_107 = x21_17[1]
                        
                        if (x8_107 + 0x30 u< 0xff0)
                            goto label_497df0
                        
                        void** x0_69 = malloc(0x1000)
                        
                        if (x0_69 != 0)
                            x8_107 = 0
                            *x0_69 = x21_17
                            x0_69[1] = 0
                            x21_17 = x0_69
                            arg1[0x266] = x0_69
                        label_497df0:
                            x9_44 = x8_107 + 0x30
                            x8_108 = x21_17 + x8_107
                            x12_10 = &data_4525e7
                            goto label_4980c4
        case 0x3d
            uint32_t x11_2 = zx.d(x9[1])
            x8_2 = nullptr
            uint64_t x12_3 = zx.q(x11_2 - 0x61)
            
            if (x12_3.d u> 0x17)
                goto label_4970c0
            
            switch (x12_3)
                case 0, 0x16
                    void* x8_14 = x10 - x9
                    
                    if (x8_14 u< 2 || (x11_2 != 0x77 && x11_2 != 0x61))
                        goto label_4970b4
                    
                    void* x8_15 = &x9[2]
                    *arg1 = x8_15
                    char x23_1 = (x8_14 u> 1 ? 1 : 0).b & (x11_2 == 0x61 ? 1 : 0).b
                    int64_t x20_2 = (arg1[3] - arg1[2]) s>> 3
                    
                    if (x8_15 == x10)
                        goto label_4972f4
                    
                    while (zx.d(*x8_15) != 0x5f)
                    label_4972f4:
                        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                            ** x0_10 = sub_49707c(arg1)
                        var_60 = x0_10
                        
                        if (x0_10 == 0)
                            goto label_4970b4
                        
                        sub_4953d4(&arg1[2], &var_60)
                        x8_15 = *arg1
                        
                        if (x8_15 == arg1[1])
                            goto label_4972f4
                    
                    int64_t x2_6 = arg1[3]
                    int64_t x25_1 = x20_2 << 3
                    int64_t x1_16 = arg1[2] + x25_1
                    *arg1 = x8_15 + 1
                    void* x0_153
                    int64_t x1_17
                    x0_153, x1_17 = sub_49e548(arg1, x1_16, x2_6)
                    arg1[3] = arg1[2] + x25_1
                    void* x0_155 = sub_492f20(arg1)
                    
                    if (x0_155 == 0)
                        goto label_4970b4
                    
                    char* x9_85 = *arg1
                    int64_t x8_183 = arg1[1]
                    
                    if (x8_183 - x9_85 u>= 2 && zx.d(*x9_85) == 0x70 && zx.d(x9_85[1]) == 0x69)
                        int64_t x11_16 = arg1[2]
                        int64_t x10_20 = arg1[3]
                        void* x9_86 = &x9_85[2]
                        *arg1 = x9_86
                        
                        if (x9_86 == x8_183)
                            goto label_498c2c
                        
                        while (true)
                            if (zx.d(*x9_86) == 0x45)
                                int64_t x9_98 = arg1[2]
                                int64_t x2_8 = arg1[3]
                                int64_t x23_5 = (x10_20 - x11_16) s>> 3 << 3
                                *arg1 = x9_86 + 1
                                void* x0_171
                                int64_t x1_22
                                x0_171, x1_22 = sub_49e548(arg1, x9_98 + x23_5, x2_8)
                                void** x25_3 = arg1[0x266]
                                arg1[3] = arg1[2] + x23_5
                                int64_t x8_202 = x25_3[1]
                                
                                if (x8_202 + 0x40 u>= 0xff0)
                                    void** x0_172 = malloc(0x1000)
                                    
                                    if (x0_172 == 0)
                                        goto label_498f34
                                    
                                    x8_202 = 0
                                    *x0_172 = x25_3
                                    x0_172[1] = 0
                                    x25_3 = x0_172
                                    arg1[0x266] = x0_172
                                
                                x25_3[1] = x8_202 + 0x40
                                x8_2 = x25_3 + x8_202 + 0x10
                                *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::NewExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                                x8_2[2] = x0_153
                                x8_2[3] = x1_17
                                x8_2[1].d = 0x1010138
                                x8_2[4] = x0_155
                                x8_2[5] = x0_171
                                x8_2[6] = x1_22
                                x8_2[7].b = 0
                                *(x8_2 + 0x39) = x23_1
                                break
                            
                        label_498c2c:
                            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                                ** x0_157 = sub_49707c(arg1)
                            var_60 = x0_157
                            
                            if (x0_157 == 0)
                                goto label_4970b4
                            
                            sub_4953d4(&arg1[2], &var_60)
                            x9_86 = *arg1
                            
                            if (x9_86 == arg1[1])
                                goto label_498c2c
                        
                        goto label_4970c0
                    
                    if (x9_85 == x8_183 || zx.d(*x9_85) != 0x45)
                        goto label_4970b4
                    
                    void** x25_2 = arg1[0x266]
                    *arg1 = &x9_85[1]
                    int64_t x8_193 = x25_2[1]
                    
                    if (x8_193 + 0x40 u< 0xff0)
                        goto label_498df0
                    
                    void** x0_166 = malloc(0x1000)
                    
                    if (x0_166 != 0)
                        x8_193 = 0
                        *x0_166 = x25_2
                        x0_166[1] = 0
                        x25_2 = x0_166
                        arg1[0x266] = x0_166
                    label_498df0:
                        x25_2[1] = x8_193 + 0x40
                        x8_2 = x25_2 + x8_193 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::NewExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_2[1].d = 0x1010138
                        x8_2[2] = x0_153
                        x8_2[3] = x1_17
                        x8_2[5] = 0
                        x8_2[6] = 0
                        x8_2[4] = x0_155
                        x8_2[7].b = 0
                        *(x8_2 + 0x39) = x23_1
                        goto label_4970c0
                case 1, 2, 3, 5, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 0x14, 0x15
                    goto label_4970c0
                case 4
                    *arg1 = &x9[2]
                    x1_1 = "!="
                    goto label_498220
                case 6
                    *arg1 = &x9[2]
                    int64_t x0_74 = sub_49707c(arg1)
                    
                    if (x0_74 == 0)
                        goto label_4970b4
                    
                    x21_13 = arg1[0x266]
                    x20_12 = x0_74
                    int64_t x8_115 = x21_13[1]
                    
                    if (x8_115 + 0x30 u< 0xff0)
                        goto label_497f18
                    
                    void*** x0_75 = malloc(0x1000)
                    
                    if (x0_75 != 0)
                        x8_115 = 0
                        *x0_75 = x21_13
                        x0_75[1] = 0
                        x21_13 = x0_75
                        arg1[0x266] = x0_75
                    label_497f18:
                        x9_70 = x8_115 + 0x30
                        x8_94 = x21_13 + x8_115
                        x12_10 = "-"
                        goto label_4988ac
                case 0x13
                    *arg1 = &x9[2]
                    int64_t x0_77 = sub_49707c(arg1)
                    
                    if (x0_77 == 0)
                        goto label_4970b4
                    
                    x21_13 = arg1[0x266]
                    x20_12 = x0_77
                    int64_t x8_117 = x21_13[1]
                    
                    if (x8_117 + 0x30 u< 0xff0)
                        goto label_497f84
                    
                    void*** x0_78 = malloc(0x1000)
                    
                    if (x0_78 != 0)
                        x8_117 = 0
                        *x0_78 = x21_13
                        x0_78[1] = 0
                        x21_13 = x0_78
                        arg1[0x266] = x0_78
                    label_497f84:
                        x9_70 = x8_117 + 0x30
                        x8_94 = x21_13 + x8_117
                        x12_10 = "!"
                        goto label_4988ac
                case 0x17
                    *arg1 = &x9[2]
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FunctionParam::VTable
                        ** x0_71 = sub_49707c(arg1)
                    
                    if (x0_71 == 0)
                        goto label_4970b4
                    
                    void** x21_18 = arg1[0x266]
                    x20_10 = x0_71
                    int64_t x8_112 = x21_18[1]
                    
                    if (x8_112 + 0x40 u< 0xff0)
                        goto label_497e98
                    
                    void** x0_72 = malloc(0x1000)
                    
                    if (x0_72 != 0)
                        x8_112 = 0
                        *x0_72 = x21_18
                        x0_72[1] = 0
                        x21_18 = x0_72
                        arg1[0x266] = x0_72
                    label_497e98:
                        x21_18[1] = x8_112 + 0x40
                        x11_12 = "noexcept ("
                        x8_2 = x21_18 + x8_112 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::EnclosingExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_2[1].d = 0x1010134
                        x9_39 = &data_40dfe2[0xa]
                    label_49832c:
                        x8_2[2] = x11_12
                        x8_2[3] = x9_39
                        x8_2[4] = x20_10
                    label_498338:
                        x8_2[5] = &data_4525e5
                        x8_2[6] = &data_4525e6
                        goto label_4970c0
        case 0x3e
            uint64_t x10_7 = zx.q(zx.d(x9[1]) - 0x52)
            x8_2 = nullptr
            
            if (x10_7.d u> 0x20)
                goto label_4970c0
            
            switch (x10_7)
                case 0
                    *arg1 = &x9[2]
                    x1_1 = "|="
                    goto label_498220
                case 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 
                        0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1e, 0x1f
                    goto label_4970c0
                case 0x1c
                    goto label_497140
                case 0x1d
                    *arg1 = &x9[2]
                    x1_1 = "||"
                    goto label_498220
                case 0x20
                    x8_24 = &x9[2]
                    x1_1 = &data_451fb5
                    goto label_4988d4
        case 0x3f
            uint64_t x11_8 = zx.q(zx.d(x9[1]) - 0x4c)
            x8_2 = nullptr
            
            if (x11_8.d u> 0x28)
                goto label_4970c0
            
            switch (x11_8)
                case 0
                    *arg1 = &x9[2]
                    x1_1 = "+="
                    goto label_498220
                case 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 
                        0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 
                        0x1f, 0x22, 0x23, 0x25, 0x26
                    goto label_4970c0
                case 0x20
                    x8_24 = &x9[2]
                    x1_1 = "+"
                    goto label_4988d4
                case 0x21
                    x8_26 = &x9[2]
                    x1_1 = "->*"
                    goto label_497fa8
                case 0x24
                    *arg1 = &x9[2]
                    
                    if (&x9[2] == x10 || zx.d(x9[2]) != 0x5f)
                        int64_t x0_140 = sub_49707c(arg1)
                        
                        if (x0_140 == 0)
                            goto label_4970b4
                        
                        x21_23 = arg1[0x266]
                        x20_15 = x0_140
                        int64_t x8_165 = x21_23[1]
                        
                        if (x8_165 + 0x30 u< 0xff0)
                            goto label_49895c
                        
                        void*** x0_141 = malloc(0x1000)
                        
                        if (x0_141 != 0)
                            x8_165 = 0
                            *x0_141 = x21_23
                            x0_141[1] = 0
                            x21_23 = x0_141
                            arg1[0x266] = x0_141
                        label_49895c:
                            x9_73 = x8_165 + 0x30
                            x8_147 = x21_23 + x8_165
                            x12_12 = "++"
                        label_498970:
                            x21_23[1] = x9_73
                            x8_2 = x8_147 + 0x10
                            *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::PostfixExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                            x8_2[1].d = 0x1010131
                            x8_2[2] = x20_15
                            x8_2[3] = x12_12
                            x8_2[4] = x12_12 + 2
                            goto label_4970c0
                    else
                        *arg1 = &x9[3]
                        int64_t x0_85 = sub_49707c(arg1)
                        
                        if (x0_85 == 0)
                            goto label_4970b4
                        
                        x21_17 = arg1[0x266]
                        x20_12 = x0_85
                        int64_t x8_124 = x21_17[1]
                        
                        if (x8_124 + 0x30 u< 0xff0)
                            goto label_4980b0
                        
                        void*** x0_86 = malloc(0x1000)
                        
                        if (x0_86 != 0)
                            x8_124 = 0
                            *x0_86 = x21_17
                            x0_86[1] = 0
                            x21_17 = x0_86
                            arg1[0x266] = x0_86
                        label_4980b0:
                            x9_44 = x8_124 + 0x30
                            x8_108 = x21_17 + x8_124
                            x12_10 = "++"
                        label_4980c4:
                            x21_17[1] = x9_44
                            x8_2 = x8_108 + 0x10
                            *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::PrefixExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                            x9_45 = x12_10 + 2
                            goto label_4988b8
                case 0x27
                    *arg1 = &x9[2]
                    int64_t x0_88 = sub_49707c(arg1)
                    
                    if (x0_88 == 0)
                        goto label_4970b4
                    
                    x21_13 = arg1[0x266]
                    x20_12 = x0_88
                    int64_t x8_126 = x21_13[1]
                    
                    if (x8_126 + 0x30 u< 0xff0)
                        goto label_498128
                    
                    void** x0_89 = malloc(0x1000)
                    
                    if (x0_89 != 0)
                        x8_126 = 0
                        *x0_89 = x21_13
                        x0_89[1] = 0
                        x21_13 = x0_89
                        arg1[0x266] = x0_89
                    label_498128:
                        x9_70 = x8_126 + 0x30
                        x8_94 = x21_13 + x8_126
                        x12_10 = "+"
                        goto label_4988ac
                case 0x28
                    *arg1 = &x9[2]
                    int64_t x0_80 = sub_49707c(arg1)
                    
                    if (x0_80 == 0)
                        goto label_4970b4
                    
                    x20_13 = x0_80
                    int64_t x0_82 = sub_49707c(arg1)
                    
                    if (x0_82 == 0)
                        goto label_4970b4
                    
                    x22_10 = arg1[0x266]
                    x21_19 = x0_82
                    int64_t x8_119 = x22_10[1]
                    
                    if (x8_119 + 0x30 u< 0xff0)
                        goto label_498018
                    
                    void** x0_83 = malloc(0x1000)
                    
                    if (x0_83 != 0)
                        x8_119 = 0
                        *x0_83 = x22_10
                        x0_83[1] = 0
                        x22_10 = x0_83
                        arg1[0x266] = x0_83
                    label_498018:
                        x9_65 = x8_119 + 0x30
                        x8_120 = x22_10 + x8_119
                        x12_11 = "->"
                        goto label_4987a0
        case 0x40
            if (zx.d(x9[1]) != 0x75)
                goto label_4970b4
            
            *arg1 = &x9[2]
            void* x0_24 = sub_49707c(arg1)
            
            if (x0_24 == 0)
                goto label_4970b4
            
            x20_6 = x0_24
            void* x0_26 = sub_49707c(arg1)
            
            if (x0_26 == 0)
                goto label_4970b4
            
            x21_5 = x0_26
            int64_t x0_28 = sub_49707c(arg1)
            
            if (x0_28 == 0)
                goto label_4970b4
            
            x23_2 = arg1[0x266]
            x22_5 = x0_28
            int64_t x8_35 = x23_2[1]
            
            if (x8_35 + 0x30 u< 0xff0)
                goto label_49761c
            
            void*** x0_29 = malloc(0x1000)
            
            if (x0_29 != 0)
                x8_35 = 0
                *x0_29 = x23_2
                x0_29[1] = 0
                x23_2 = x0_29
                arg1[0x266] = x0_29
            label_49761c:
                x11_7 = 0x132
                x9_14 = x8_35 + 0x30
                x8_36 = x23_2 + x8_35
                x10_10 = &_vtable_for_(anonymous namespace)::itanium_demangle::ConditionalExpr{for `(anonymous namespace)::itanium_demangle::Node'}
            label_498b7c:
                x23_2[1] = x9_14
                x8_2 = x8_36 + 0x10
                *x8_2 = x10_10
                x8_2[1].d = zx.d(x11_7) | 0x1010000
                x8_2[2] = x20_6
                x8_2[3] = x21_5
                x8_2[4] = x22_5
                goto label_4970c0
        case 0x41
            uint64_t x10_11 = zx.q(zx.d(x9[1]) - 0x4d)
            x8_2 = nullptr
            
            if (x10_11.d u> 0x26)
                goto label_4970c0
            
            switch (x10_11)
                case 0
                    *arg1 = &x9[2]
                    x1_1 = &data_451a56
                    goto label_498220
                case 1, 2, 3, 4, 5, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 0x13, 
                        0x14, 0x15, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f, 0x21, 
                        0x22, 0x23, 0x24, 0x25
                    goto label_4970c0
                case 6
                    x8_26 = &x9[2]
                    x1_1 = ">>="
                    goto label_497fa8
                case 0x16
                    *arg1 = &x9[2]
                    void* x0_63 = sub_492f20(arg1)
                    
                    if (x0_63 == 0)
                        goto label_4970b4
                    
                    x20_3 = x0_63
                    int64_t x0_65 = sub_49707c(arg1)
                    
                    if (x0_65 == 0)
                        goto label_4970b4
                    
                    void** x22_9 = arg1[0x266]
                    x21_3 = x0_65
                    int64_t x8_101 = x22_9[1]
                    
                    if (x8_101 + 0x30 u< 0xff0)
                        goto label_497d34
                    
                    void** x0_66 = malloc(0x1000)
                    
                    if (x0_66 != 0)
                        x8_101 = 0
                        *x0_66 = x22_9
                        x0_66[1] = 0
                        x22_9 = x0_66
                        arg1[0x266] = x0_66
                    label_497d34:
                        x12_5 = "reinterpret_cast"
                        x22_9[1] = x8_101 + 0x30
                        x8_2 = x22_9 + x8_101 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::CastExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x9_9 = &data_452174[0x10]
                        goto label_498718
                case 0x20
                    x8_24 = &x9[2]
                    x1_1 = &data_452ae1
                    goto label_4988d4
                case 0x26
                    *arg1 = &x9[2]
                    x1_1 = ">>"
                    goto label_498220
        case 0x42
            uint64_t x11_5 = zx.q(zx.d(x9[1]) - 0x50)
            x8_2 = nullptr
            
            if (x11_5.d u> 0x2a)
                goto label_4970c0
            
            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FunctionParam::VTable
                ** x0_94
            
            switch (x11_5)
                case 0
                    void* x8_32 = &x9[2]
                    *arg1 = x8_32
                    int64_t x21_4 = (arg1[3] - arg1[2]) s>> 3
                    
                    if (x8_32 == x10)
                        goto label_49757c
                    
                    while (true)
                        if (zx.d(*x8_32) == 0x45)
                            int64_t x2_3 = arg1[3]
                            int64_t x21_24 = x21_4 << 3
                            int64_t x1_10 = arg1[2] + x21_24
                            *arg1 = x8_32 + 1
                            void* x0_143
                            int64_t x1_11
                            x0_143, x1_11 = sub_49e548(arg1, x1_10, x2_3)
                            void** x23_3 = arg1[0x266]
                            arg1[3] = arg1[2] + x21_24
                            int64_t x8_169 = x23_3[1]
                            
                            if (x8_169 + 0x20 u>= 0xff0)
                                void** x0_144 = malloc(0x1000)
                                
                                if (x0_144 == 0)
                                    goto label_498f34
                                
                                x8_169 = 0
                                *x0_144 = x23_3
                                x0_144[1] = 0
                                x23_3 = x0_144
                                arg1[0x266] = x0_144
                            
                            x23_3[1] = x8_169 + 0x20
                            *(x23_3 + x8_169 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::NodeArrayNode{for `(anonymous namespace)::itanium_demangle::Node'}
                            *(x23_3 + x8_169 + 0x18) = 0x1010100
                            *(x23_3 + x8_169 + 0x20) = x0_143
                            *(x23_3 + x8_169 + 0x28) = x1_11
                            void** x20_19 = arg1[0x266]
                            int64_t x8_170 = x20_19[1]
                            
                            if (x8_170 + 0x40 u>= 0xff0)
                                void** x0_145 = malloc(0x1000)
                                
                                if (x0_145 == 0)
                                    goto label_498f34
                                
                                x8_170 = 0
                                *x0_145 = x20_19
                                x0_145[1] = 0
                                x20_19 = x0_145
                                arg1[0x266] = x0_145
                            
                            x20_19[1] = x8_170 + 0x40
                            x8_2 = x20_19 + x8_170 + 0x10
                            *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::EnclosingExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                            x8_2[1].d = 0x1010134
                            x8_2[2] = "sizeof... ("
                            x8_2[3] = &data_451d31[0xb]
                            x8_2[4] = x23_3 + x8_169 + 0x10
                            break
                        
                    label_49757c:
                        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                            ** x0_21 = sub_4951ec(arg1)
                        var_60 = x0_21
                        
                        if (x0_21 == 0)
                            goto label_4970b4
                        
                        sub_4953d4(&arg1[2], &var_60)
                        x8_32 = *arg1
                        
                        if (x8_32 == arg1[1])
                            goto label_49757c
                    
                    goto label_498338
                case 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 0x14, 
                        0x15, 0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f, 0x21, 
                        0x23, 0x25, 0x26, 0x27, 0x28, 0x29
                    goto label_4970c0
                case 0xa
                    *arg1 = &x9[2]
                    
                    if (x10 == &x9[2])
                        goto label_4970b4
                    
                    uint32_t x8_139 = zx.d(x9[2])
                    
                    if (x8_139 == 0x66)
                        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FunctionParam::VTable
                            ** x0_164 = sub_4999c0(arg1)
                        
                        if (x0_164 == 0)
                            goto label_4970b4
                        
                        void** x21_30 = arg1[0x266]
                        x20_10 = x0_164
                        int64_t x8_189 = x21_30[1]
                        
                        if (x8_189 + 0x40 u< 0xff0)
                            goto label_498d5c
                        
                        void** x0_165 = malloc(0x1000)
                        
                        if (x0_165 != 0)
                            x8_189 = 0
                            *x0_165 = x21_30
                            x0_165[1] = 0
                            x21_30 = x0_165
                            arg1[0x266] = x0_165
                        label_498d5c:
                            x21_30[1] = x8_189 + 0x40
                            x11_12 = "sizeof... ("
                            x8_2 = x21_30 + x8_189 + 0x10
                            *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::EnclosingExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                            x8_2[1].d = 0x1010134
                            x9_39 = &data_451d31[0xb]
                            goto label_49832c
                    else
                        if (x8_139 != 0x54)
                            goto label_4970b4
                        
                        void* x0_101 = sub_49615c(arg1)
                        
                        if (x0_101 == 0)
                            goto label_4970b4
                        
                        x21_6 = arg1[0x266]
                        x20_7 = x0_101
                        int64_t x8_140 = x21_6[1]
                        
                        if (x8_140 + 0x20 u< 0xff0)
                            goto label_498424
                        
                        void*** x0_102 = malloc(0x1000)
                        
                        if (x0_102 != 0)
                            x8_140 = 0
                            *x0_102 = x21_6
                            x0_102[1] = 0
                            x21_6 = x0_102
                            arg1[0x266] = x0_102
                        label_498424:
                            x11_10 = 0x136
                            x9_16 = x8_140 + 0x20
                            x8_67 = x21_6 + x8_140
                            x10_12 = &_vtable_for_(anonymous namespace)::itanium_demangle::SizeofParamPackExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                            goto label_498520
                case 0x13
                    *arg1 = &x9[2]
                    void* x0_104 = sub_492f20(arg1)
                    
                    if (x0_104 == 0)
                        goto label_4970b4
                    
                    x20_3 = x0_104
                    int64_t x0_106 = sub_49707c(arg1)
                    
                    if (x0_106 == 0)
                        goto label_4970b4
                    
                    void** x22_12 = arg1[0x266]
                    x21_3 = x0_106
                    int64_t x8_142 = x22_12[1]
                    
                    if (x8_142 + 0x30 u< 0xff0)
                        goto label_4984a8
                    
                    void** x0_107 = malloc(0x1000)
                    
                    if (x0_107 != 0)
                        x8_142 = 0
                        *x0_107 = x22_12
                        x0_107[1] = 0
                        x22_12 = x0_107
                        arg1[0x266] = x0_107
                    label_4984a8:
                        x12_5 = "static_cast"
                        x22_12[1] = x8_142 + 0x30
                        x8_2 = x22_12 + x8_142 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::CastExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x9_9 = &data_451d25[0xb]
                        goto label_498718
                case 0x20
                    *arg1 = &x9[2]
                    void* x0_109 = sub_49707c(arg1)
                    
                    if (x0_109 == 0)
                        goto label_4970b4
                    
                    x21_6 = arg1[0x266]
                    x20_7 = x0_109
                    int64_t x8_145 = x21_6[1]
                    
                    if (x8_145 + 0x20 u< 0xff0)
                        goto label_49850c
                    
                    void*** x0_110 = malloc(0x1000)
                    
                    if (x0_110 != 0)
                        x8_145 = 0
                        *x0_110 = x21_6
                        x0_110[1] = 0
                        x21_6 = x0_110
                        arg1[0x266] = x0_110
                    label_49850c:
                        x11_10 = 0x122
                        x9_16 = x8_145 + 0x20
                        x8_67 = x21_6 + x8_145
                        x10_12 = &_vtable_for_(anonymous namespace)::itanium_demangle::ParameterPackExpansion{for `(anonymous namespace)::itanium_demangle::Node'}
                        goto label_498520
                case 0x22
                    goto label_497140
                case 0x24
                    *arg1 = &x9[2]
                    x0_94 = sub_492f20(arg1)
                    
                    if (x0_94 == 0)
                        goto label_4970b4
                    
                label_4982c0:
                    void** x21_22 = arg1[0x266]
                    x20_10 = x0_94
                    int64_t x8_135 = x21_22[1]
                    
                    if (x8_135 + 0x40 u< 0xff0)
                        goto label_4982fc
                    
                    void** x0_96 = malloc(0x1000)
                    
                    if (x0_96 != 0)
                        x8_135 = 0
                        *x0_96 = x21_22
                        x0_96[1] = 0
                        x21_22 = x0_96
                        arg1[0x266] = x0_96
                    label_4982fc:
                        x21_22[1] = x8_135 + 0x40
                        x8_82 = x21_22 + x8_135
                        x11_12 = "sizeof ("
                        goto label_498318
                case 0x2a
                    *arg1 = &x9[2]
                    x0_94 = sub_49707c(arg1)
                    
                    if (x0_94 == 0)
                        goto label_4970b4
                    
                    goto label_4982c0
        case 0x43
            uint64_t x10_3 = zx.q(zx.d(x9[1]) - 0x65)
            x8_2 = nullptr
            
            if (x10_3.d u> 0x12)
                goto label_4970c0
            
            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FunctionParam::VTable
                ** x0_3
            
            switch (x10_3)
                case 0
                    *arg1 = &x9[2]
                    x0_3 = sub_49707c(arg1)
                    
                    if (x0_3 == 0)
                        goto label_4970b4
                    
                label_497a04:
                    void** x21_10 = arg1[0x266]
                    x20_10 = x0_3
                    int64_t x8_81 = x21_10[1]
                    
                    if (x8_81 + 0x40 u< 0xff0)
                        goto label_497a40
                    
                    void** x0_44 = malloc(0x1000)
                    
                    if (x0_44 != 0)
                        x8_81 = 0
                        *x0_44 = x21_10
                        x0_44[1] = 0
                        x21_10 = x0_44
                        arg1[0x266] = x0_44
                    label_497a40:
                        x21_10[1] = x8_81 + 0x40
                        x8_82 = x21_10 + x8_81
                        x11_12 = "typeid ("
                    label_498318:
                        x8_2 = x8_82 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::EnclosingExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_2[1].d = 0x1010134
                        x9_39 = &x11_12[8]
                        goto label_49832c
                case 1, 2, 3, 5, 6, 8, 9, 0xa, 0xb, 0xc, 0xe, 0xf, 0x10, 0x11
                    goto label_4970c0
                case 4
                    *arg1 = &x9[2]
                    x0_3 = sub_492f20(arg1)
                    
                    if (x0_3 == 0)
                        goto label_4970b4
                    
                    goto label_497a04
                case 7
                    *arg1 = &x9[2]
                    void* x0_39 = sub_492f20(arg1)
                    
                    if (x0_39 == 0)
                        goto label_4970b4
                    
                    x20_6 = x0_39
                    int64_t x22_6 = (arg1[3] - arg1[2]) s>> 3
                    char* x8_79
                    
                    while (true)
                        x8_79 = *arg1
                        
                        if (x8_79 != arg1[1] && zx.d(*x8_79) == 0x45)
                            break
                        
                        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                            ** x0_41 = sub_49a9cc(arg1)
                        var_60 = x0_41
                        
                        if (x0_41 == 0)
                            goto label_4970b4
                        
                        sub_4953d4(&arg1[2], &var_60)
                    
                    int64_t x2_4 = arg1[3]
                    int64_t x22_19 = x22_6 << 3
                    int64_t x1_12 = arg1[2] + x22_19
                    *arg1 = &x8_79[1]
                    void* x0_147
                    int64_t x1_13
                    x0_147, x1_13 = sub_49e548(arg1, x1_12, x2_4)
                    x23_2 = arg1[0x266]
                    x21_5 = x0_147
                    arg1[3] = arg1[2] + x22_19
                    int64_t x8_175 = x23_2[1]
                    x22_5 = x1_13
                    
                    if (x8_175 + 0x30 u< 0xff0)
                        goto label_498af0
                    
                    void*** x0_148 = malloc(0x1000)
                    
                    if (x0_148 != 0)
                        x8_175 = 0
                        *x0_148 = x23_2
                        x0_148[1] = 0
                        x23_2 = x0_148
                        arg1[0x266] = x0_148
                    label_498af0:
                        x11_7 = 0x13d
                        x9_14 = x8_175 + 0x30
                        x8_36 = x23_2 + x8_175
                        x10_10 = &_vtable_for_(anonymous namespace)::itanium_demangle::InitListExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        goto label_498b7c
                case 0xd
                    void** x20_11 = arg1[0x266]
                    *arg1 = &x9[2]
                    int64_t x8_84 = x20_11[1]
                    
                    if (x8_84 + 0x20 u< 0xff0)
                        goto label_497ab8
                    
                    void** x0_45 = malloc(0x1000)
                    
                    if (x0_45 != 0)
                        x8_84 = 0
                        *x0_45 = x20_11
                        x0_45[1] = 0
                        x20_11 = x0_45
                        arg1[0x266] = x0_45
                    label_497ab8:
                        x20_11[1] = x8_84 + 0x20
                        x8_2 = x20_11 + x8_84 + 0x10
                        *x8_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_2[1].d = 0x1010107
                        x8_2[2] = "throw"
                        x8_2[3] = &data_40c30b[5]
                        goto label_4970c0
                case 0x12
                    *arg1 = &x9[2]
                    void* x0_47 = sub_49707c(arg1)
                    
                    if (x0_47 == 0)
                        goto label_4970b4
                    
                    x21_6 = arg1[0x266]
                    x20_7 = x0_47
                    int64_t x8_87 = x21_6[1]
                    
                    if (x8_87 + 0x20 u< 0xff0)
                        goto label_497b1c
                    
                    void*** x0_48 = malloc(0x1000)
                    
                    if (x0_48 != 0)
                        x8_87 = 0
                        *x0_48 = x21_6
                        x0_48[1] = 0
                        x21_6 = x0_48
                        arg1[0x266] = x0_48
                    label_497b1c:
                        x11_10 = 0x13f
                        x9_16 = x8_87 + 0x20
                        x8_67 = x21_6 + x8_87
                        x10_12 = &_vtable_for_(anonymous namespace)::itanium_demangle::ThrowExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                    label_498520:
                        x21_6[1] = x9_16
                        x8_2 = x8_67 + 0x10
                        *x8_2 = x10_12
                        x8_2[1].d = zx.d(x11_10) | 0x1010000
                        x8_2[2] = x20_7
                        goto label_4970c0
label_498f34:
sub_491944()
noreturn
