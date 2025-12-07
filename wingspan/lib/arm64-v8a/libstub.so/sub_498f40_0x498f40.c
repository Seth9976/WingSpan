// 函数: sub_498f40
// 地址: 0x498f40
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x8 = *arg1
int64_t x9 = arg1[1]

if (x8 != x9 && zx.d(*x8) == 0x4c)
    void* x10_2 = x9 - &x8[1]
    *arg1 = &x8[1]
    int64_t* result
    
    if (x9 == &x8[1])
    label_499028:
        result = sub_492f20(arg1)
        
        if (result == 0)
            return result
        
        char* x8_5 = *arg1
        void* x9_4 = arg1[1]
        int64_t* result_2 = result
        char* x21_2
        void* x22_1
        
        if (x9_4 == x8_5 || zx.d(*x8_5) - 0x30 u> 9)
            x21_2 = nullptr
            x22_1 = nullptr
        else
            void* x11_4 = &x8_5[1]
            
            while (true)
                void* x10_6 = x11_4
                *arg1 = x11_4
                
                if (x9_4 == x11_4)
                    x21_2 = x8_5
                    x8_5 = x10_6
                    x22_1 = x9_4
                    break
                
                x11_4 = x10_6 + 1
                
                if (zx.d(*x10_6) - 0x30 u>= 0xa)
                    x21_2 = x8_5
                    x22_1 = x11_4 - 1
                    x8_5 = x10_6
                    break
        
        if (x21_2 == x22_1 || x8_5 == x9_4)
            return nullptr
        
        if (zx.d(*x8_5) == 0x45)
            void** x23_1 = arg1[0x266]
            *arg1 = &x8_5[1]
            int64_t x8_7 = x23_1[1]
            
            if (x8_7 + 0x30 u>= 0xff0)
                void** x0_4 = malloc(0x1000)
                
                if (x0_4 == 0)
                    sub_491944()
                    noreturn
                
                x8_7 = 0
                *x0_4 = x23_1
                x0_4[1] = 0
                x23_1 = x0_4
                arg1[0x266] = x0_4
            
            x23_1[1] = x8_7 + 0x30
            result = x23_1 + x8_7 + 0x10
            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::IntegerCastExpr{for `(anonymous namespace)::itanium_demangle::Node'}
            result[1].d = 0x1010144
            result[2] = result_2
            result[3] = x21_2
            result[4] = x22_1
            return result
    else
        uint64_t x11_3 = zx.q(zx.d(x8[1]) - 0x41)
        
        if (x11_3.d u> 0x38)
            goto label_499028
        
        void* x0_2
        void* x0_7
        char* const x1
        char* const x2
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::LambdaExpr::VTable
            * const x8_4
        void* x8_8
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FloatLiteralImpl<double>::VTable
            * const x8_11
        int64_t x9_20
        int64_t x9_34
        int16_t x10_3
        int16_t x10_32
        int64_t* result_1
        void* x20_1
        void** x21_1
        void* x21_3
        void** x22_2
        
        switch (x11_3)
            case 0
                result = sub_492f20(arg1)
                
                if (result == 0)
                    return result
                
                char* x8_1 = *arg1
                
                if (x8_1 != arg1[1] && zx.d(*x8_1) == 0x45)
                    x21_1 = arg1[0x266]
                    *arg1 = &x8_1[1]
                    result_1 = result
                    int64_t x8_3 = x21_1[1]
                    
                    if (x8_3 + 0x20 u>= 0xff0)
                        void*** x0_1 = malloc(0x1000)
                        
                        if (x0_1 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_3 = 0
                        *x0_1 = x21_1
                        x0_1[1] = 0
                        x21_1 = x0_1
                        arg1[0x266] = x0_1
                    
                    x9_20 = x8_3 + 0x20
                    x0_2 = x21_1 + x8_3
                    x10_3 = 0x142
                    x8_4 = &_vtable_for_(anonymous namespace)::itanium_demangle::StringLiteral{for `(anonymous namespace)::itanium_demangle::Node'}
                label_4994b0:
                    x21_1[1] = x9_20
                    result = x0_2 + 0x10
                    *result = x8_4
                    result[1].d = zx.d(x10_3) | 0x1010000
                    result[2] = result_1
                    return result
            case 1, 2, 4, 5, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 0x15, 
                    0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1f, 0x26, 0x2a, 0x2f, 0x30, 
                    0x31, 0x34, 0x35
                goto label_499028
            case 3
                if (x10_2 u>= 3 && zx.d(x8[2]) == 0x6e && zx.d(x8[3]) == 0x45)
                    void** x20_2 = arg1[0x266]
                    *arg1 = &x8[4]
                    int64_t x8_13 = x20_2[1]
                    
                    if (x8_13 + 0x20 u> 0xfef)
                        void** x0_8 = malloc(0x1000)
                        
                        if (x0_8 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_13 = 0
                        *x0_8 = x20_2
                        x0_8[1] = 0
                        x20_2 = x0_8
                        arg1[0x266] = x0_8
                    
                    x20_2[1] = x8_13 + 0x20
                    result = x20_2 + x8_13 + 0x10
                    *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                    result[1].d = 0x1010107
                    result[2] = "nullptr"
                    result[3] = &data_451fb7[7]
                    return result
            case 0x14
                if (x10_2 u>= 2 && zx.d(x8[2]) == 0x6c)
                    result = sub_49ad48(arg1, 0)
                    
                    if (result == 0)
                        return result
                    
                    char* x8_19 = *arg1
                    
                    if (x8_19 != arg1[1] && zx.d(*x8_19) == 0x45)
                        x21_1 = arg1[0x266]
                        *arg1 = &x8_19[1]
                        result_1 = result
                        int64_t x8_21 = x21_1[1]
                        
                        if (x8_21 + 0x20 u>= 0xff0)
                            void** x0_13 = malloc(0x1000)
                            
                            if (x0_13 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_21 = 0
                            *x0_13 = x21_1
                            x0_13[1] = 0
                            x21_1 = x0_13
                            arg1[0x266] = x0_13
                        
                        x9_20 = x8_21 + 0x20
                        x0_2 = x21_1 + x8_21
                        x10_3 = 0x143
                        x8_4 = &_vtable_for_(anonymous namespace)::itanium_demangle::LambdaExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        goto label_4994b0
            case 0x1e
                if (x10_2 u>= 2 && zx.d(x8[2]) == 0x5a)
                    *arg1 = &x8[3]
                    result = sub_4922d0(arg1)
                    
                    if (result == 0)
                        return result
                    
                    char* x8_15 = *arg1
                    
                    if (x8_15 != arg1[1] && zx.d(*x8_15) == 0x45)
                        *arg1 = &x8_15[1]
                        return result
            case 0x20
                x1 = "signed char"
                x8_8 = &x8[2]
                x2 = &data_40d62c[0xb]
                goto label_49988c
            case 0x21
                if (x10_2 u>= 3)
                    if (zx.d(x8[2]) == 0x30 && zx.d(x8[3]) == 0x45)
                        void** x20_3 = arg1[0x266]
                        *arg1 = &x8[4]
                        int64_t x8_23 = x20_3[1]
                        
                        if (x8_23 + 0x10 u> 0xfef)
                            void** x0_14 = malloc(0x1000)
                            
                            if (x0_14 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_23 = 0
                            *x0_14 = x20_3
                            x0_14[1] = 0
                            x20_3 = x0_14
                            arg1[0x266] = x0_14
                        
                        x20_3[1] = x8_23 + 0x10
                        result = x20_3 + x8_23 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::BoolExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        result[1].d = 0x1010141
                        *(result + 0xc) = 0
                        return result
                    
                    if (zx.d(x8[2]) == 0x31 && zx.d(x8[3]) == 0x45)
                        void** x20_4 = arg1[0x266]
                        *arg1 = &x8[4]
                        int64_t x8_28 = x20_4[1]
                        
                        if (x8_28 + 0x10 u> 0xfef)
                            void** x0_18 = malloc(0x1000)
                            
                            if (x0_18 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_28 = 0
                            *x0_18 = x20_4
                            x0_18[1] = 0
                            x20_4 = x0_18
                            arg1[0x266] = x0_18
                        
                        x20_4[1] = x8_28 + 0x10
                        result = x20_4 + x8_28 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::BoolExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                        result[1].d = 0x1010141
                        *(result + 0xc) = 1
                        return result
            case 0x22
                x1 = "char"
                x8_8 = &x8[2]
                x2 = &data_40dfed[4]
                goto label_49988c
            case 0x23
                x20_1 = &x8[2]
                *arg1 = x20_1
                
                if (x9 - x20_1 u>= 0x11)
                    uint32_t x10_36 = zx.d(x8[2])
                    
                    if (x10_36 - 0x30 u< 0xa || (x10_36 & 0xffffffdf) - 0x41 u<= 5)
                        uint32_t x10_39 = zx.d(x8[3])
                        
                        if (x10_39 - 0x30 u< 0xa || (x10_39 & 0xffffffdf) - 0x41 u< 6)
                            uint32_t x10_42 = zx.d(x8[4])
                            
                            if (x10_42 - 0x30 u< 0xa || (x10_42 & 0xffffffdf) - 0x41 u<= 5)
                                uint32_t x10_45 = zx.d(x8[5])
                                
                                if (x10_45 - 0x30 u< 0xa || (x10_45 & 0xffffffdf) - 0x41 u<= 5)
                                    uint32_t x10_48 = zx.d(x8[6])
                                    
                                    if (x10_48 - 0x30 u< 0xa || (x10_48 & 0xffffffdf) - 0x41 u<= 5)
                                        uint32_t x10_51 = zx.d(x8[7])
                                        
                                        if (x10_51 - 0x30 u< 0xa
                                                || (x10_51 & 0xffffffdf) - 0x41 u<= 5)
                                            uint32_t x10_54 = zx.d(x8[8])
                                            
                                            if (x10_54 - 0x30 u< 0xa
                                                    || (x10_54 & 0xffffffdf) - 0x41 u<= 5)
                                                uint32_t x10_57 = zx.d(x8[9])
                                                
                                                if (x10_57 - 0x30 u< 0xa
                                                        || (x10_57 & 0xffffffdf) - 0x41 u<= 5)
                                                    uint32_t x10_60 = zx.d(x8[0xa])
                                                    
                                                    if (x10_60 - 0x30 u< 0xa
                                                            || (x10_60 & 0xffffffdf) - 0x41 u<= 5)
                                                        uint32_t x10_63 = zx.d(x8[0xb])
                                                        
                                                        if (x10_63 - 0x30 u< 0xa
                                                                || (x10_63 & 0xffffffdf) - 0x41 u<= 5)
                                                            uint32_t x10_66 = zx.d(x8[0xc])
                                                            
                                                            if (x10_66 - 0x30 u< 0xa
                                                                    || (x10_66 & 0xffffffdf) - 0x41 u<= 5)
                                                                uint32_t x10_69 = zx.d(x8[0xd])
                                                                
                                                                if (x10_69 - 0x30 u< 0xa
                                                                        || (x10_69 & 0xffffffdf) - 0x41 u<= 5)
                                                                    uint32_t x10_72 = zx.d(x8[0xe])
                                                                    
                                                                    if (x10_72 - 0x30 u< 0xa
                                                                            || (x10_72 & 0xffffffdf) - 0x41 u<= 5)
                                                                        uint32_t x10_75 = zx.d(x8[0xf])
                                                                        
                                                                        if (x10_75 - 0x30 u< 0xa
                                                                                || (x10_75 & 0xffffffdf) - 0x41 u<= 5)
                                                                            uint32_t x10_78 = zx.d(x8[0x10])
                                                                            
                                                                            if (x10_78 - 0x30 u< 0xa
                                                                                    || (x10_78 & 0xffffffdf) - 0x41 u<= 5)
                                                                                uint32_t x10_81 = zx.d(x8[0x11])
                                                                                
                                                                                if (x10_81 - 0x30 u< 0xa
                                                                                        || (x10_81 & 0xffffffdf) - 0x41 u<= 5)
                                                                                    x21_3 = &x8[0x12]
                                                                                    *arg1 = x21_3
                                                                                    
                                                                                    if (x21_3 != x9 && zx.d(*x21_3) == 0x45)
                                                                                        x22_2 = arg1[0x266]
                                                                                        *arg1 = &x8[0x13]
                                                                                        int64_t x8_25 = x22_2[1]
                                                                                        
                                                                                        if (x8_25 + 0x20 u>= 0xff0)
                                                                                            void** x0_16 = malloc(0x1000)
                                                                                            
                                                                                            if (x0_16 == 0)
                                                                                                sub_491944()
                                                                                                noreturn
                                                                                            
                                                                                            x8_25 = 0
                                                                                            *x0_16 = x22_2
                                                                                            x0_16[1] = 0
                                                                                            x22_2 = x0_16
                                                                                            arg1[0x266] = x0_16
                                                                                        
                                                                                        x9_34 = x8_25 + 0x20
                                                                                        x0_7 = x22_2 + x8_25
                                                                                        x10_32 = 0x147
                                                                                        x8_11 = &_vtable_for_(anonymous namespace)::itanium_demangle::FloatLiteralImpl<double>{for `(anonymous namespace)::itanium_demangle::Node'}
                                                                                        goto label_499990
            case 0x24
                x20_1 = &x8[2]
                *arg1 = x20_1
                
                if (x9 - x20_1 u>= 0x21)
                    int64_t i = 0
                    x21_3 = &x8[0x22]
                    
                    do
                        uint32_t x11_14 = zx.d(*(x20_1 + i))
                        
                        if (x11_14 - 0x30 u>= 0xa && (x11_14 & 0xffffffdf) - 0x41 u>= 6)
                            return nullptr
                        
                        i += 1
                    while (i != 0x20)
                    
                    *arg1 = x21_3
                    
                    if (x21_3 != x9 && zx.d(*x21_3) == 0x45)
                        x22_2 = arg1[0x266]
                        *arg1 = &x8[0x23]
                        int64_t x8_30 = x22_2[1]
                        
                        if (x8_30 + 0x20 u>= 0xff0)
                            void*** x0_20 = malloc(0x1000)
                            
                            if (x0_20 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_30 = 0
                            *x0_20 = x22_2
                            x0_20[1] = 0
                            x22_2 = x0_20
                            arg1[0x266] = x0_20
                        
                        x9_34 = x8_30 + 0x20
                        x0_7 = x22_2 + x8_30
                        x10_32 = 0x148
                        x8_11 = &_vtable_for_(anonymous namespace)::itanium_demangle::FloatLiteralImpl<long double>{for `(anonymous namespace)::itanium_demangle::Node'}
                    label_499990:
                        x22_2[1] = x9_34
                        result = x0_7 + 0x10
                        *result = x8_11
                        result[1].d = zx.d(x10_32) | 0x1010000
                        result[2] = x20_1
                        result[3] = x21_3
                        return result
            case 0x25
                x20_1 = &x8[2]
                *arg1 = x20_1
                
                if (x9 - x20_1 u>= 9)
                    uint32_t x10_8 = zx.d(x8[2])
                    
                    if (x10_8 - 0x30 u< 0xa || (x10_8 & 0xffffffdf) - 0x41 u<= 5)
                        uint32_t x10_11 = zx.d(x8[3])
                        
                        if (x10_11 - 0x30 u< 0xa || (x10_11 & 0xffffffdf) - 0x41 u< 6)
                            uint32_t x10_14 = zx.d(x8[4])
                            
                            if (x10_14 - 0x30 u< 0xa || (x10_14 & 0xffffffdf) - 0x41 u<= 5)
                                uint32_t x10_17 = zx.d(x8[5])
                                
                                if (x10_17 - 0x30 u< 0xa || (x10_17 & 0xffffffdf) - 0x41 u<= 5)
                                    uint32_t x10_20 = zx.d(x8[6])
                                    
                                    if (x10_20 - 0x30 u< 0xa || (x10_20 & 0xffffffdf) - 0x41 u<= 5)
                                        uint32_t x10_23 = zx.d(x8[7])
                                        
                                        if (x10_23 - 0x30 u< 0xa
                                                || (x10_23 & 0xffffffdf) - 0x41 u<= 5)
                                            uint32_t x10_26 = zx.d(x8[8])
                                            
                                            if (x10_26 - 0x30 u< 0xa
                                                    || (x10_26 & 0xffffffdf) - 0x41 u<= 5)
                                                uint32_t x10_29 = zx.d(x8[9])
                                                
                                                if (x10_29 - 0x30 u< 0xa
                                                        || (x10_29 & 0xffffffdf) - 0x41 u<= 5)
                                                    x21_3 = &x8[0xa]
                                                    *arg1 = x21_3
                                                    
                                                    if (x21_3 != x9 && zx.d(*x21_3) == 0x45)
                                                        x22_2 = arg1[0x266]
                                                        *arg1 = &x8[0xb]
                                                        int64_t x8_10 = x22_2[1]
                                                        
                                                        if (x8_10 + 0x20 u>= 0xff0)
                                                            void*** x0_6 = malloc(0x1000)
                                                            
                                                            if (x0_6 == 0)
                                                                sub_491944()
                                                                noreturn
                                                            
                                                            x8_10 = 0
                                                            *x0_6 = x22_2
                                                            x0_6[1] = 0
                                                            x22_2 = x0_6
                                                            arg1[0x266] = x0_6
                                                        
                                                        x9_34 = x8_10 + 0x20
                                                        x0_7 = x22_2 + x8_10
                                                        x10_32 = 0x146
                                                        x8_11 = &_vtable_for_(anonymous namespace)::itanium_demangle::FloatLiteralImpl<float>{for `(anonymous namespace)::itanium_demangle::Node'}
                                                        goto label_499990
            case 0x27
                x1 = "unsigned char"
                x8_8 = &x8[2]
                x2 = &data_40cbf9[0xd]
                goto label_49988c
            case 0x28
                *arg1 = &x8[2]
                return sub_49abf8(arg1, &data_452188, &data_452188) __tailcall
            case 0x29
                x8_8 = &x8[2]
                x1 = "u"
            label_499568:
                x2 = &x1[1]
                goto label_49988c
            case 0x2b
                x8_8 = &x8[2]
                x1 = &data_45201a
                goto label_499568
            case 0x2c
                x1 = "ul"
                goto label_499578
            case 0x2d
                x1 = "__int128"
                x8_8 = &x8[2]
                x2 = &data_40e9f7[8]
                goto label_49988c
            case 0x2e
                x1 = "unsigned __int128"
                x8_8 = &x8[2]
                x2 = &data_40c664[0x11]
                goto label_49988c
            case 0x32
                x1 = "short"
                x8_8 = &x8[2]
                x2 = &data_40e18f[5]
            label_49988c:
                *arg1 = x8_8
                return sub_49abf8(arg1, x1, x2) __tailcall
            case 0x33
                x1 = "unsigned short"
                x8_8 = &x8[2]
                x2 = &data_40d0c3[0xe]
                goto label_49988c
            case 0x36
                x1 = "wchar_t"
                x8_8 = &x8[2]
                x2 = &data_40c311[7]
                goto label_49988c
            case 0x37
                x1 = &data_45298b
            label_499578:
                x8_8 = &x8[2]
                x2 = &x1[2]
                goto label_49988c
            case 0x38
                x1 = &data_451d3d
                x8_8 = &x8[2]
                x2 = &data_451d40
                goto label_49988c

return nullptr
