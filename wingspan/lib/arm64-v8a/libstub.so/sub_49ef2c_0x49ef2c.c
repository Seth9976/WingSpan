// 函数: sub_49ef2c
// 地址: 0x49ef2c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x8 = *arg1
int64_t x9 = arg1[1]
void* x9_1 = x9 - x8

if (x9 != x8)
    void* result = nullptr
    uint64_t x10_2 = zx.q(zx.d(*x8) - 0x61)
    
    if (x10_2.d u> 0x15)
        return result
    
    void* x0_1
    void* x0_3
    void* x0_6
    void* x0_15
    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ConversionOperatorType::VTable
        * const x8_23
    void* x8_32
    int64_t x9_65
    int64_t x9_74
    int64_t x9_80
    int64_t x9_82
    int16_t x10_3
    char* const x11_2
    void** x20_1
    void** x20_2
    void** x20_3
    void* result_1
    void** x21_1
    
    switch (x10_2)
        case 0
            if (x9_1 u>= 2)
                result = nullptr
                uint64_t x9_3 = zx.q(zx.d(x8[1]) - 0x4e)
                
                if (x9_3.d u> 0x20)
                    return result
                
                switch (x9_3)
                    case 0
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_78 = x20_3[1]
                        
                        if (x8_78 + 0x20 u>= 0xff0)
                            void*** x0_48 = malloc(0x1000)
                            
                            if (x0_48 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_78 = 0
                            *x0_48 = x20_3
                            x0_48[1] = 0
                            x20_3 = x0_48
                            arg1[0x266] = x0_48
                        
                        x9_82 = x8_78 + 0x20
                        x0_6 = x20_3 + x8_78
                        x11_2 = "operator&="
                        goto label_4a036c
                    case 1, 2, 3, 4, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 
                            0x14, 0x15, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f
                        return result
                    case 5
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_80 = x20_1[1]
                        
                        if (x8_80 + 0x20 u>= 0xff0)
                            void*** x0_49 = malloc(0x1000)
                            
                            if (x0_49 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_80 = 0
                            *x0_49 = x20_1
                            x0_49[1] = 0
                            x20_1 = x0_49
                            arg1[0x266] = x0_49
                        
                        x9_74 = x8_80 + 0x20
                        x0_1 = x20_1 + x8_80
                        x11_2 = "operator="
                        goto label_4a017c
                    case 0x13
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_62 = x20_3[1]
                        
                        if (x8_62 + 0x20 u>= 0xff0)
                            void*** x0_37 = malloc(0x1000)
                            
                            if (x0_37 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_62 = 0
                            *x0_37 = x20_3
                            x0_37[1] = 0
                            x20_3 = x0_37
                            arg1[0x266] = x0_37
                        
                        x9_82 = x8_62 + 0x20
                        x0_6 = x20_3 + x8_62
                        x11_2 = "operator&&"
                        goto label_4a036c
                    case 0x16, 0x20
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_2 = x20_1[1]
                        
                        if (x8_2 + 0x20 u>= 0xff0)
                            void*** x0 = malloc(0x1000)
                            
                            if (x0 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_2 = 0
                            *x0 = x20_1
                            x0[1] = 0
                            x20_1 = x0
                            arg1[0x266] = x0
                        
                        x9_74 = x8_2 + 0x20
                        x0_1 = x20_1 + x8_2
                        x11_2 = "operator&"
                        goto label_4a017c
        case 1, 5, 7, 9, 0xa, 0x13, 0x14
            return result
        case 2
            if (x9_1 u>= 2)
                result = nullptr
                uint64_t x9_21 = zx.q(zx.d(x8[1]) - 0x6c)
                
                if (x9_21.d u> 0xa)
                    return result
                
                switch (x9_21)
                    case 0
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_16 = x20_3[1]
                        
                        if (x8_16 + 0x20 u>= 0xff0)
                            void*** x0_10 = malloc(0x1000)
                            
                            if (x0_10 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_16 = 0
                            *x0_10 = x20_3
                            x0_10[1] = 0
                            x20_3 = x0_10
                            arg1[0x266] = x0_10
                        
                        x9_82 = x8_16 + 0x20
                        x0_6 = x20_3 + x8_16
                        x11_2 = "operator()"
                        goto label_4a036c
                    case 1
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_56 = x20_1[1]
                        
                        if (x8_56 + 0x20 u>= 0xff0)
                            void*** x0_32 = malloc(0x1000)
                            
                            if (x0_32 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_56 = 0
                            *x0_32 = x20_1
                            x0_32[1] = 0
                            x20_1 = x0_32
                            arg1[0x266] = x0_32
                        
                        x9_74 = x8_56 + 0x20
                        x0_1 = x20_1 + x8_56
                        x11_2 = "operator,"
                        goto label_4a017c
                    case 2, 4, 5, 6, 7, 8, 9
                        return result
                    case 3
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_54 = x20_1[1]
                        
                        if (x8_54 + 0x20 u>= 0xff0)
                            void*** x0_31 = malloc(0x1000)
                            
                            if (x0_31 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_54 = 0
                            *x0_31 = x20_1
                            x0_31[1] = 0
                            x20_1 = x0_31
                            arg1[0x266] = x0_31
                        
                        x9_74 = x8_54 + 0x20
                        x0_1 = x20_1 + x8_54
                        x11_2 = "operator~"
                        goto label_4a017c
                    case 0xa
                        uint32_t x23_1 = zx.d(*(arg1 + 0x309))
                        char x22_1 = arg1[0x61].b
                        *arg1 = &x8[2]
                        arg1[0x61].b = 0
                        *(arg1 + 0x309) = (arg2 != 0 ? 1 : 0).b | (x23_1 != 0 ? 1 : 0).b
                        void* x0_34 = sub_492f20(arg1)
                        
                        if (x0_34 == 0)
                            result = nullptr
                        else
                            if (arg2 != 0)
                                *arg2 = 1
                            
                            void** x20_6 = arg1[0x266]
                            int64_t x8_60 = x20_6[1]
                            
                            if (x8_60 + 0x20 u>= 0xff0)
                                void** x0_35 = malloc(0x1000)
                                
                                if (x0_35 == 0)
                                    sub_491944()
                                    noreturn
                                
                                x8_60 = 0
                                *x0_35 = x20_6
                                x0_35[1] = 0
                                x20_6 = x0_35
                                arg1[0x266] = x0_35
                            
                            x20_6[1] = x8_60 + 0x20
                            result = x20_6 + x8_60 + 0x10
                            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::ConversionOperatorType{for `(anonymous namespace)::itanium_demangle::Node'}
                            *(result + 8) = 0x1010104
                            *(result + 0x10) = x0_34
                        
                        *(arg1 + 0x309) = x23_1.b
                        arg1[0x61].b = x22_1
                        return result
        case 3
            if (x9_1 u>= 2)
                result = nullptr
                uint64_t x9_14 = zx.q(zx.d(x8[1]) - 0x56)
                
                if (x9_14.d u> 0x20)
                    return result
                
                switch (x9_14)
                    case 0
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_10 = x20_3[1]
                        
                        if (x8_10 + 0x20 u>= 0xff0)
                            void*** x0_7 = malloc(0x1000)
                            
                            if (x0_7 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_10 = 0
                            *x0_7 = x20_3
                            x0_7[1] = 0
                            x20_3 = x0_7
                            arg1[0x266] = x0_7
                        
                        x9_82 = x8_10 + 0x20
                        x0_6 = x20_3 + x8_10
                        x11_2 = "operator/="
                        goto label_4a036c
                    case 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xa, 0xc, 0xd, 0xe, 0x10, 0x11, 0x12, 0x13, 
                            0x14, 0x15, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f
                        return result
                    case 0xb
                        void** x20_7 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_64 = x20_7[1]
                        
                        if (x8_64 + 0x20 u>= 0xff0)
                            void** x0_38 = malloc(0x1000)
                            
                            if (x0_38 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_64 = 0
                            *x0_38 = x20_7
                            x0_38[1] = 0
                            x20_7 = x0_38
                            arg1[0x266] = x0_38
                        
                        x11_2 = "operator delete[]"
                        x20_7[1] = x8_64 + 0x20
                        result = x20_7 + x8_64 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_32 = &data_40ce6d[0x11]
                        goto label_4a0378
                    case 0xf
                    label_49f750:
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_34 = x20_1[1]
                        
                        if (x8_34 + 0x20 u>= 0xff0)
                            void*** x0_21 = malloc(0x1000)
                            
                            if (x0_21 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_34 = 0
                            *x0_21 = x20_1
                            x0_21[1] = 0
                            x20_1 = x0_21
                            arg1[0x266] = x0_21
                        
                        x9_74 = x8_34 + 0x20
                        x0_1 = x20_1 + x8_34
                        x11_2 = "operator*"
                        goto label_4a017c
                    case 0x16
                        void** x20_8 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_66 = x20_8[1]
                        
                        if (x8_66 + 0x20 u>= 0xff0)
                            void** x0_40 = malloc(0x1000)
                            
                            if (x0_40 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_66 = 0
                            *x0_40 = x20_8
                            x0_40[1] = 0
                            x20_8 = x0_40
                            arg1[0x266] = x0_40
                        
                        x11_2 = "operator delete"
                        x20_8[1] = x8_66 + 0x20
                        result = x20_8 + x8_66 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_32 = &data_40c676[0xf]
                        goto label_4a0378
                    case 0x20
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_68 = x20_1[1]
                        
                        if (x8_68 + 0x20 u>= 0xff0)
                            void*** x0_42 = malloc(0x1000)
                            
                            if (x0_42 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_68 = 0
                            *x0_42 = x20_1
                            x0_42[1] = 0
                            x20_1 = x0_42
                            arg1[0x266] = x0_42
                        
                        x9_74 = x8_68 + 0x20
                        x0_1 = x20_1 + x8_68
                        x11_2 = "operator/"
                        goto label_4a017c
        case 4
            if (x9_1 u>= 2)
                uint32_t x9_32 = zx.d(x8[1])
                
                if (x9_32 == 0x4f)
                    x20_3 = arg1[0x266]
                    *arg1 = &x8[2]
                    int64_t x8_40 = x20_3[1]
                    
                    if (x8_40 + 0x20 u>= 0xff0)
                        void*** x0_24 = malloc(0x1000)
                        
                        if (x0_24 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_40 = 0
                        *x0_24 = x20_3
                        x0_24[1] = 0
                        x20_3 = x0_24
                        arg1[0x266] = x0_24
                    
                    x9_82 = x8_40 + 0x20
                    x0_6 = x20_3 + x8_40
                    x11_2 = "operator^="
                    goto label_4a036c
                
                if (x9_32 == 0x71)
                    x20_3 = arg1[0x266]
                    *arg1 = &x8[2]
                    int64_t x8_42 = x20_3[1]
                    
                    if (x8_42 + 0x20 u>= 0xff0)
                        void*** x0_25 = malloc(0x1000)
                        
                        if (x0_25 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_42 = 0
                        *x0_25 = x20_3
                        x0_25[1] = 0
                        x20_3 = x0_25
                        arg1[0x266] = x0_25
                    
                    x9_82 = x8_42 + 0x20
                    x0_6 = x20_3 + x8_42
                    x11_2 = "operator=="
                    goto label_4a036c
                
                if (x9_32 == 0x6f)
                    x20_1 = arg1[0x266]
                    *arg1 = &x8[2]
                    int64_t x8_25 = x20_1[1]
                    
                    if (x8_25 + 0x20 u>= 0xff0)
                        void** x0_16 = malloc(0x1000)
                        
                        if (x0_16 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_25 = 0
                        *x0_16 = x20_1
                        x0_16[1] = 0
                        x20_1 = x0_16
                        arg1[0x266] = x0_16
                    
                    x9_74 = x8_25 + 0x20
                    x0_1 = x20_1 + x8_25
                    x11_2 = "operator^"
                    goto label_4a017c
        case 6
            if (x9_1 u>= 2)
                uint32_t x9_34 = zx.d(x8[1])
                
                if (x9_34 == 0x74)
                    x20_1 = arg1[0x266]
                    *arg1 = &x8[2]
                    int64_t x8_36 = x20_1[1]
                    
                    if (x8_36 + 0x20 u>= 0xff0)
                        void*** x0_22 = malloc(0x1000)
                        
                        if (x0_22 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_36 = 0
                        *x0_22 = x20_1
                        x0_22[1] = 0
                        x20_1 = x0_22
                        arg1[0x266] = x0_22
                    
                    x9_74 = x8_36 + 0x20
                    x0_1 = x20_1 + x8_36
                    x11_2 = "operator>"
                    goto label_4a017c
                
                if (x9_34 == 0x65)
                    x20_3 = arg1[0x266]
                    *arg1 = &x8[2]
                    int64_t x8_27 = x20_3[1]
                    
                    if (x8_27 + 0x20 u>= 0xff0)
                        void*** x0_17 = malloc(0x1000)
                        
                        if (x0_17 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_27 = 0
                        *x0_17 = x20_3
                        x0_17[1] = 0
                        x20_3 = x0_17
                        arg1[0x266] = x0_17
                    
                    x9_82 = x8_27 + 0x20
                    x0_6 = x20_3 + x8_27
                    x11_2 = "operator>="
                    goto label_4a036c
        case 8
            if (x9_1 u>= 2 && zx.d(x8[1]) == 0x78)
                x20_3 = arg1[0x266]
                *arg1 = &x8[2]
                int64_t x8_12 = x20_3[1]
                
                if (x8_12 + 0x20 u>= 0xff0)
                    void*** x0_8 = malloc(0x1000)
                    
                    if (x0_8 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_12 = 0
                    *x0_8 = x20_3
                    x0_8[1] = 0
                    x20_3 = x0_8
                    arg1[0x266] = x0_8
                
                x9_82 = x8_12 + 0x20
                x0_6 = x20_3 + x8_12
                x11_2 = "operator[]"
            label_4a036c:
                x20_3[1] = x9_82
                result = x0_6 + 0x10
                *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                x8_32 = &x11_2[0xa]
                goto label_4a0378
        case 0xb
            if (x9_1 u>= 2)
                result = nullptr
                uint64_t x9_24 = zx.q(zx.d(x8[1]) - 0x53)
                
                if (x9_24.d u> 0x21)
                    return result
                
                switch (x9_24)
                    case 0
                        x20_2 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_18 = x20_2[1]
                        
                        if (x8_18 + 0x20 u>= 0xff0)
                            void** x0_11 = malloc(0x1000)
                            
                            if (x0_11 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_18 = 0
                            *x0_11 = x20_2
                            x0_11[1] = 0
                            x20_2 = x0_11
                            arg1[0x266] = x0_11
                        
                        x9_80 = x8_18 + 0x20
                        x0_3 = x20_2 + x8_18
                        x11_2 = "operator<<="
                        goto label_4a0304
                    case 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x13, 
                            0x14, 0x15, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f
                        return result
                    case 0x12
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_70 = x20_3[1]
                        
                        if (x8_70 + 0x20 u>= 0xff0)
                            void*** x0_43 = malloc(0x1000)
                            
                            if (x0_43 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_70 = 0
                            *x0_43 = x20_3
                            x0_43[1] = 0
                            x20_3 = x0_43
                            arg1[0x266] = x0_43
                        
                        x9_82 = x8_70 + 0x20
                        x0_6 = x20_3 + x8_70
                        x11_2 = "operator<="
                        goto label_4a036c
                    case 0x16
                        *arg1 = &x8[2]
                        result = sub_49ec1c(arg1)
                        
                        if (result == 0)
                            return result
                        
                        x21_1 = arg1[0x266]
                        result_1 = result
                        int64_t x8_72 = x21_1[1]
                        
                        if (x8_72 + 0x20 u>= 0xff0)
                            void** x0_45 = malloc(0x1000)
                            
                            if (x0_45 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_72 = 0
                            *x0_45 = x21_1
                            x0_45[1] = 0
                            x21_1 = x0_45
                            arg1[0x266] = x0_45
                        
                        x9_65 = x8_72 + 0x20
                        x0_15 = x21_1 + x8_72
                        x10_3 = 0x113
                        x8_23 = &_vtable_for_(anonymous namespace)::itanium_demangle::LiteralOperator{for `(anonymous namespace)::itanium_demangle::Node'}
                        goto label_49fe8c
                    case 0x20
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_82 = x20_3[1]
                        
                        if (x8_82 + 0x20 u>= 0xff0)
                            void*** x0_50 = malloc(0x1000)
                            
                            if (x0_50 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_82 = 0
                            *x0_50 = x20_3
                            x0_50[1] = 0
                            x20_3 = x0_50
                            arg1[0x266] = x0_50
                        
                        x9_82 = x8_82 + 0x20
                        x0_6 = x20_3 + x8_82
                        x11_2 = "operator<<"
                        goto label_4a036c
                    case 0x21
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_84 = x20_1[1]
                        
                        if (x8_84 + 0x20 u>= 0xff0)
                            void*** x0_51 = malloc(0x1000)
                            
                            if (x0_51 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_84 = 0
                            *x0_51 = x20_1
                            x0_51[1] = 0
                            x20_1 = x0_51
                            arg1[0x266] = x0_51
                        
                        x9_74 = x8_84 + 0x20
                        x0_1 = x20_1 + x8_84
                        x11_2 = "operator<"
                        goto label_4a017c
        case 0xc
            if (x9_1 u>= 2)
                result = nullptr
                uint64_t x9_27 = zx.q(zx.d(x8[1]) - 0x49)
                
                if (x9_27.d u> 0x24)
                    return result
                
                switch (x9_27)
                    case 0
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_20 = x20_3[1]
                        
                        if (x8_20 + 0x20 u>= 0xff0)
                            void*** x0_12 = malloc(0x1000)
                            
                            if (x0_12 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_20 = 0
                            *x0_12 = x20_3
                            x0_12[1] = 0
                            x20_3 = x0_12
                            arg1[0x266] = x0_12
                        
                        x9_82 = x8_20 + 0x20
                        x0_6 = x20_3 + x8_20
                        x11_2 = "operator-="
                        goto label_4a036c
                    case 1, 2, 4, 5, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 
                            0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 
                            0x1f, 0x21, 0x22
                        return result
                    case 3
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_74 = x20_3[1]
                        
                        if (x8_74 + 0x20 u>= 0xff0)
                            void*** x0_46 = malloc(0x1000)
                            
                            if (x0_46 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_74 = 0
                            *x0_46 = x20_3
                            x0_46[1] = 0
                            x20_3 = x0_46
                            arg1[0x266] = x0_46
                        
                        x9_82 = x8_74 + 0x20
                        x0_6 = x20_3 + x8_74
                        x11_2 = "operator*="
                        goto label_4a036c
                    case 0x20
                    label_49f808:
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_38 = x20_1[1]
                        
                        if (x8_38 + 0x20 u>= 0xff0)
                            void*** x0_23 = malloc(0x1000)
                            
                            if (x0_23 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_38 = 0
                            *x0_23 = x20_1
                            x0_23[1] = 0
                            x20_1 = x0_23
                            arg1[0x266] = x0_23
                        
                        x9_74 = x8_38 + 0x20
                        x0_1 = x20_1 + x8_38
                        x11_2 = "operator-"
                        goto label_4a017c
                    case 0x23
                        goto label_49f750
                    case 0x24
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_86 = x20_3[1]
                        
                        if (x8_86 + 0x20 u>= 0xff0)
                            void*** x0_52 = malloc(0x1000)
                            
                            if (x0_52 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_86 = 0
                            *x0_52 = x20_3
                            x0_52[1] = 0
                            x20_3 = x0_52
                            arg1[0x266] = x0_52
                        
                        x9_82 = x8_86 + 0x20
                        x0_6 = x20_3 + x8_86
                        x11_2 = "operator--"
                        goto label_4a036c
        case 0xd
            if (x9_1 u>= 2)
                result = nullptr
                uint64_t x9_39 = zx.q(zx.d(x8[1]) - 0x61)
                
                if (x9_39.d u> 0x16)
                    return result
                
                switch (x9_39)
                    case 0
                        void** x20_4 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_31 = x20_4[1]
                        
                        if (x8_31 + 0x20 u>= 0xff0)
                            void** x0_19 = malloc(0x1000)
                            
                            if (x0_19 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_31 = 0
                            *x0_19 = x20_4
                            x0_19[1] = 0
                            x20_4 = x0_19
                            arg1[0x266] = x0_19
                        
                        x11_2 = "operator new[]"
                        x20_4[1] = x8_31 + 0x20
                        result = x20_4 + x8_31 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_32 = &data_40d82f[0xe]
                        goto label_4a0378
                    case 1, 2, 3, 5, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 0x14, 
                            0x15
                        return result
                    case 4
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_76 = x20_3[1]
                        
                        if (x8_76 + 0x20 u>= 0xff0)
                            void*** x0_47 = malloc(0x1000)
                            
                            if (x0_47 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_76 = 0
                            *x0_47 = x20_3
                            x0_47[1] = 0
                            x20_3 = x0_47
                            arg1[0x266] = x0_47
                        
                        x9_82 = x8_76 + 0x20
                        x0_6 = x20_3 + x8_76
                        x11_2 = "operator!="
                        goto label_4a036c
                    case 6
                        goto label_49f808
                    case 0x13
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_88 = x20_1[1]
                        
                        if (x8_88 + 0x20 u>= 0xff0)
                            void*** x0_53 = malloc(0x1000)
                            
                            if (x0_53 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_88 = 0
                            *x0_53 = x20_1
                            x0_53[1] = 0
                            x20_1 = x0_53
                            arg1[0x266] = x0_53
                        
                        x9_74 = x8_88 + 0x20
                        x0_1 = x20_1 + x8_88
                        x11_2 = "operator!"
                        goto label_4a017c
                    case 0x16
                        void** x20_9 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_90 = x20_9[1]
                        
                        if (x8_90 + 0x20 u>= 0xff0)
                            void** x0_54 = malloc(0x1000)
                            
                            if (x0_54 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_90 = 0
                            *x0_54 = x20_9
                            x0_54[1] = 0
                            x20_9 = x0_54
                            arg1[0x266] = x0_54
                        
                        x11_2 = "operator new"
                        x20_9[1] = x8_90 + 0x20
                        result = x20_9 + x8_90 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_32 = &data_40c973[0xc]
                        goto label_4a0378
        case 0xe
            if (x9_1 u>= 2)
                uint32_t x9_36 = zx.d(x8[1])
                
                if (x9_36 == 0x52)
                    x20_3 = arg1[0x266]
                    *arg1 = &x8[2]
                    int64_t x8_46 = x20_3[1]
                    
                    if (x8_46 + 0x20 u>= 0xff0)
                        void*** x0_27 = malloc(0x1000)
                        
                        if (x0_27 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_46 = 0
                        *x0_27 = x20_3
                        x0_27[1] = 0
                        x20_3 = x0_27
                        arg1[0x266] = x0_27
                    
                    x9_82 = x8_46 + 0x20
                    x0_6 = x20_3 + x8_46
                    x11_2 = "operator|="
                    goto label_4a036c
                
                if (x9_36 == 0x72)
                    x20_1 = arg1[0x266]
                    *arg1 = &x8[2]
                    int64_t x8_44 = x20_1[1]
                    
                    if (x8_44 + 0x20 u>= 0xff0)
                        void*** x0_26 = malloc(0x1000)
                        
                        if (x0_26 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_44 = 0
                        *x0_26 = x20_1
                        x0_26[1] = 0
                        x20_1 = x0_26
                        arg1[0x266] = x0_26
                    
                    x9_74 = x8_44 + 0x20
                    x0_1 = x20_1 + x8_44
                    x11_2 = "operator|"
                    goto label_4a017c
                
                if (x9_36 == 0x6f)
                    x20_3 = arg1[0x266]
                    *arg1 = &x8[2]
                    int64_t x8_29 = x20_3[1]
                    
                    if (x8_29 + 0x20 u>= 0xff0)
                        void** x0_18 = malloc(0x1000)
                        
                        if (x0_18 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_29 = 0
                        *x0_18 = x20_3
                        x0_18[1] = 0
                        x20_3 = x0_18
                        arg1[0x266] = x0_18
                    
                    x9_82 = x8_29 + 0x20
                    x0_6 = x20_3 + x8_29
                    x11_2 = "operator||"
                    goto label_4a036c
        case 0xf
            if (x9_1 u>= 2)
                result = nullptr
                uint64_t x9_8 = zx.q(zx.d(x8[1]) - 0x4c)
                
                if (x9_8.d u> 0x28)
                    return result
                
                switch (x9_8)
                    case 0
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_92 = x20_3[1]
                        
                        if (x8_92 + 0x20 u>= 0xff0)
                            void*** x0_56 = malloc(0x1000)
                            
                            if (x0_56 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_92 = 0
                            *x0_56 = x20_3
                            x0_56[1] = 0
                            x20_3 = x0_56
                            arg1[0x266] = x0_56
                        
                        x9_82 = x8_92 + 0x20
                        x0_6 = x20_3 + x8_92
                        x11_2 = "operator+="
                        goto label_4a036c
                    case 1, 2, 3, 4, 5, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 
                            0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 
                            0x1f, 0x22, 0x23, 0x25, 0x26
                        return result
                    case 0x20, 0x27
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_6 = x20_1[1]
                        
                        if (x8_6 + 0x20 u>= 0xff0)
                            void*** x0_4 = malloc(0x1000)
                            
                            if (x0_4 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_6 = 0
                            *x0_4 = x20_1
                            x0_4[1] = 0
                            x20_1 = x0_4
                            arg1[0x266] = x0_4
                        
                        x9_74 = x8_6 + 0x20
                        x0_1 = x20_1 + x8_6
                        x11_2 = "operator+"
                        goto label_4a017c
                    case 0x21
                        x20_2 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_96 = x20_2[1]
                        
                        if (x8_96 + 0x20 u>= 0xff0)
                            void*** x0_58 = malloc(0x1000)
                            
                            if (x0_58 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_96 = 0
                            *x0_58 = x20_2
                            x0_58[1] = 0
                            x20_2 = x0_58
                            arg1[0x266] = x0_58
                        
                        x9_80 = x8_96 + 0x20
                        x0_3 = x20_2 + x8_96
                        x11_2 = "operator->*"
                        goto label_4a0304
                    case 0x24
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_98 = x20_3[1]
                        
                        if (x8_98 + 0x20 u>= 0xff0)
                            void*** x0_59 = malloc(0x1000)
                            
                            if (x0_59 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_98 = 0
                            *x0_59 = x20_3
                            x0_59[1] = 0
                            x20_3 = x0_59
                            arg1[0x266] = x0_59
                        
                        x9_82 = x8_98 + 0x20
                        x0_6 = x20_3 + x8_98
                        x11_2 = "operator++"
                        goto label_4a036c
                    case 0x28
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_94 = x20_3[1]
                        
                        if (x8_94 + 0x20 u>= 0xff0)
                            void*** x0_57 = malloc(0x1000)
                            
                            if (x0_57 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_94 = 0
                            *x0_57 = x20_3
                            x0_57[1] = 0
                            x20_3 = x0_57
                            arg1[0x266] = x0_57
                        
                        x9_82 = x8_94 + 0x20
                        x0_6 = x20_3 + x8_94
                        x11_2 = "operator->"
                        goto label_4a036c
        case 0x10
            if (x9_1 u>= 2 && zx.d(x8[1]) == 0x75)
                x20_1 = arg1[0x266]
                *arg1 = &x8[2]
                int64_t x8_14 = x20_1[1]
                
                if (x8_14 + 0x20 u>= 0xff0)
                    void*** x0_9 = malloc(0x1000)
                    
                    if (x0_9 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_14 = 0
                    *x0_9 = x20_1
                    x0_9[1] = 0
                    x20_1 = x0_9
                    arg1[0x266] = x0_9
                
                x9_74 = x8_14 + 0x20
                x0_1 = x20_1 + x8_14
                x11_2 = "operator?"
            label_4a017c:
                x20_1[1] = x9_74
                result = x0_1 + 0x10
                *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                x8_32 = &x11_2[9]
                goto label_4a0378
        case 0x11
            if (x9_1 u>= 2)
                result = nullptr
                uint64_t x9_11 = zx.q(zx.d(x8[1]) - 0x4d)
                
                if (x9_11.d u> 0x26)
                    return result
                
                switch (x9_11)
                    case 0
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_8 = x20_3[1]
                        
                        if (x8_8 + 0x20 u>= 0xff0)
                            void*** x0_5 = malloc(0x1000)
                            
                            if (x0_5 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_8 = 0
                            *x0_5 = x20_3
                            x0_5[1] = 0
                            x20_3 = x0_5
                            arg1[0x266] = x0_5
                        
                        x9_82 = x8_8 + 0x20
                        x0_6 = x20_3 + x8_8
                        x11_2 = "operator%="
                        goto label_4a036c
                    case 1, 2, 3, 4, 5, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 
                            0x13, 0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 
                            0x1f, 0x21, 0x22, 0x23, 0x24, 0x25
                        return result
                    case 6
                        x20_2 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_50 = x20_2[1]
                        
                        if (x8_50 + 0x20 u>= 0xff0)
                            void*** x0_29 = malloc(0x1000)
                            
                            if (x0_29 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_50 = 0
                            *x0_29 = x20_2
                            x0_29[1] = 0
                            x20_2 = x0_29
                            arg1[0x266] = x0_29
                        
                        x9_80 = x8_50 + 0x20
                        x0_3 = x20_2 + x8_50
                        x11_2 = "operator>>="
                        goto label_4a0304
                    case 0x20
                        x20_1 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_48 = x20_1[1]
                        
                        if (x8_48 + 0x20 u>= 0xff0)
                            void*** x0_28 = malloc(0x1000)
                            
                            if (x0_28 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_48 = 0
                            *x0_28 = x20_1
                            x0_28[1] = 0
                            x20_1 = x0_28
                            arg1[0x266] = x0_28
                        
                        x9_74 = x8_48 + 0x20
                        x0_1 = x20_1 + x8_48
                        x11_2 = "operator%"
                        goto label_4a017c
                    case 0x26
                        x20_3 = arg1[0x266]
                        *arg1 = &x8[2]
                        int64_t x8_52 = x20_3[1]
                        
                        if (x8_52 + 0x20 u>= 0xff0)
                            void*** x0_30 = malloc(0x1000)
                            
                            if (x0_30 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_52 = 0
                            *x0_30 = x20_3
                            x0_30[1] = 0
                            x20_3 = x0_30
                            arg1[0x266] = x0_30
                        
                        x9_82 = x8_52 + 0x20
                        x0_6 = x20_3 + x8_52
                        x11_2 = "operator>>"
                        goto label_4a036c
        case 0x12
            if (x9_1 u>= 2 && zx.d(x8[1]) == 0x73)
                x20_2 = arg1[0x266]
                *arg1 = &x8[2]
                int64_t x8_4 = x20_2[1]
                
                if (x8_4 + 0x20 u>= 0xff0)
                    void*** x0_2 = malloc(0x1000)
                    
                    if (x0_2 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_4 = 0
                    *x0_2 = x20_2
                    x0_2[1] = 0
                    x20_2 = x0_2
                    arg1[0x266] = x0_2
                
                x9_80 = x8_4 + 0x20
                x0_3 = x20_2 + x8_4
                x11_2 = "operator<=>"
            label_4a0304:
                x20_2[1] = x9_80
                result = x0_3 + 0x10
                *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                x8_32 = &x11_2[0xb]
            label_4a0378:
                *(result + 8) = 0x1010107
                *(result + 0x10) = x11_2
                *(result + 0x18) = x8_32
                return result
        case 0x15
            if (x9_1 u>= 2 && zx.d(x8[1]) - 0x30 u<= 9)
                *arg1 = &x8[2]
                result = sub_49ec1c(arg1)
                
                if (result == 0)
                    return result
                
                x21_1 = arg1[0x266]
                result_1 = result
                int64_t x8_22 = x21_1[1]
                
                if (x8_22 + 0x20 u>= 0xff0)
                    void*** x0_14 = malloc(0x1000)
                    
                    if (x0_14 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_22 = 0
                    *x0_14 = x21_1
                    x0_14[1] = 0
                    x21_1 = x0_14
                    arg1[0x266] = x0_14
                
                x9_65 = x8_22 + 0x20
                x0_15 = x21_1 + x8_22
                x10_3 = 0x104
                x8_23 = &_vtable_for_(anonymous namespace)::itanium_demangle::ConversionOperatorType{for `(anonymous namespace)::itanium_demangle::Node'}
            label_49fe8c:
                x21_1[1] = x9_65
                result = x0_15 + 0x10
                *result = x8_23
                *(result + 8) = zx.d(x10_3) | 0x1010000
                *(result + 0x10) = result_1
                return result

return nullptr
