// 函数: sub_492f20
// 地址: 0x492f20
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
void** x19 = arg1
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
    ** result_1 = nullptr
char* x8_1 = *arg1
void* result_11 = arg1[1]
int64_t x9 = result_11 - x8_1
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
    ** result_12

if (result_11 == x8_1)
label_4937c4:
    result_12 = sub_4a38b8(x19)
label_4937c8:
    result_1 = result_12
    
    if (result_12 == 0)
        goto label_493f7c
    
    goto label_4937d8

uint32_t x11_1 = zx.d(*x8_1)
uint64_t x10_1 = zx.q(x11_1 - 0x41)

if (x10_1.d u> 0x39)
    goto label_4937c4

void* x0_48
void* x8_7
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
    ** result_13
void* x8_78
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
    * x8_82
int64_t x9_5
int64_t x9_14
int64_t x9_19
char* const x9_25
int64_t x9_32
int64_t x9_36
int64_t x9_38
int64_t x9_51
int64_t x9_58
int64_t x9_60
int64_t x9_62
int64_t x9_67
int64_t x9_75
char x10_8
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
    * x10_9
int32_t x10_10
char* const x11_6
int16_t x11_8
char* const x12_2
void* result
void* x20_2
void* x20_3
void* x20_4
void* x20_5
void* x20_6
void* x20_8
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
    ** result_15
void* x20_9
void* x20_11
void* x20_13
void* x20_14
void** x21_1
void** x21_2
void** x21_3
void** x21_4
void** x21_5
void** x21_7
void** x21_8
void** x21_13
void** x21_15
void** x21_18
void* x21_19
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
    ** result_20
void** x23_3
void** x23_4

switch (x10_1)
    case 0
        if (x8_1 == result_11)
            result_12 = nullptr
            goto label_4937c8
        
        *x19 = &x8_1[1]
        void* x8_30
        void* x8_73
        
        if (result_11 != &x8_1[1] && zx.d(x8_1[1]) - 0x30 u<= 9)
            void* x8_79 = &x8_1[2]
            
            while (true)
                *x19 = x8_79
                
                if (result_11 == x8_79)
                    break
                
                uint32_t x9_68 = zx.d(*x8_79)
                x8_79 += 1
                
                if (x9_68 - 0x30 u>= 0xa)
                    result_11 = x8_79 - 1
                    break
            
            void** x24_1 = x19[0x266]
            int64_t x8_80 = x24_1[1]
            
            if (x8_80 + 0x20 u>= 0xff0)
                void** x0_45 = malloc(0x1000)
                
                if (x0_45 == 0)
                    sub_491944()
                    noreturn
                
                x8_80 = 0
                *x0_45 = x24_1
                x0_45[1] = 0
                x24_1 = x0_45
                x19[0x266] = x0_45
            
            x24_1[1] = x8_80 + 0x20
            result_15 = x24_1 + x8_80 + 0x10
            *result_15 = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
            result_15[1].d = 0x1010107
            result_15[2] = &x8_1[1]
            result_15[3] = result_11
            x8_73 = *x19
            
            if (x8_73 == x19[1] || zx.d(*x8_73) != 0x5f)
                result_12 = nullptr
                goto label_4937c8
            
            x8_30 = x8_73 + 1
        else if (&x8_1[1] == result_11 || zx.d(x8_1[1]) != 0x5f)
            result_12 = sub_49707c(x19)
            
            if (result_12 == 0)
                goto label_4937c8
            
            x8_73 = *x19
            
            if (x8_73 == x19[1] || zx.d(*x8_73) != 0x5f)
                result_12 = nullptr
                goto label_4937c8
            
            result_15 = result_12
            x8_30 = x8_73 + 1
        else
            result_15 = nullptr
            x8_30 = &x8_1[2]
        *x19 = x8_30
        result_12 = sub_492f20(x19)
        
        if (result_12 == 0)
            goto label_4937c8
        
        x23_4 = x19[0x266]
        result_20 = result_12
        int64_t x8_81 = x23_4[1]
        
        if (x8_81 + 0x20 u>= 0xff0)
            void*** x0_47 = malloc(0x1000)
            
            if (x0_47 == 0)
                sub_491944()
                noreturn
            
            x8_81 = 0
            *x0_47 = x23_4
            x0_47[1] = 0
            x23_4 = x0_47
            x19[0x266] = x0_47
        
        x9_75 = x8_81 + 0x20
        x0_48 = x23_4 + x8_81
        x8_82 = &_vtable_for_(anonymous namespace)::itanium_demangle::ArrayType{for `(anonymous namespace)::itanium_demangle::Node'}
        x10_10 = 0x100000e
    case 1, 4, 7, 8, 9, 0xb, 0xd, 0x10, 0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f, 
            0x2a, 0x2f, 0x30
        goto label_4937c4
    case 2
        *x19 = &x8_1[1]
        void* result_3 = sub_492f20(x19)
        result = result_3
        
        if (result_3 == 0)
            goto label_493f88
        
        void** x21_10 = x19[0x266]
        int64_t x8_38 = x21_10[1]
        
        if (x8_38 + 0x30 u>= 0xff0)
            void** x0_15 = malloc(0x1000)
            
            if (x0_15 == 0)
                sub_491944()
                noreturn
            
            x8_38 = 0
            *x0_15 = x21_10
            x0_15[1] = 0
            x21_10 = x0_15
            x19[0x266] = x0_15
        
        x12_2 = " complex"
        x21_10[1] = x8_38 + 0x30
        result_13 = x21_10 + x8_38 + 0x10
        *result_13 = &_vtable_for_(anonymous namespace)::itanium_demangle::PostfixQualifiedType{for `(anonymous namespace)::itanium_demangle::Node'}
        x9_25 = &data_40dcea[8]
    label_493658:
        result_13[1].d = 0x1010105
        result_13[2] = result
        result_13[3] = x12_2
        result_13[4] = x9_25
        goto label_493f64
    case 3
        if (x9 u< 2)
            goto label_493f7c
        
        result = nullptr
        uint64_t x9_34 = zx.q(zx.d(x8_1[1]) - 0x4f)
        
        if (x9_34.d u> 0x29)
            goto label_493f88
        
        switch (x9_34)
            case 0, 0x20, 0x28, 0x29
                result_12 = sub_4a2fc8(x19)
                goto label_4937c8
            case 1, 2, 3, 4, 6, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x13, 0x18, 
                    0x1b, 0x1c, 0x1d, 0x1e, 0x22, 0x23
                goto label_493f88
            case 5, 0x25
                result_12 = sub_496500(x19)
                goto label_4937c8
            case 0x12
                x21_1 = x19[0x266]
                *x19 = &x8_1[2]
                int64_t x8_87 = x21_1[1]
                
                if (x8_87 + 0x20 u>= 0xff0)
                    void** x0_52 = malloc(0x1000)
                    
                    if (x0_52 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_87 = 0
                    *x0_52 = x21_1
                    x0_52[1] = 0
                    x21_1 = x0_52
                    x19[0x266] = x0_52
                
                x9_62 = x8_87 + 0x20
                x20_2 = x21_1 + x8_87
                x11_6 = "auto"
                goto label_493d08
            case 0x14
                x21_15 = x19[0x266]
                *x19 = &x8_1[2]
                int64_t x8_89 = x21_15[1]
                
                if (x8_89 + 0x20 u>= 0xff0)
                    void*** x0_53 = malloc(0x1000)
                    
                    if (x0_53 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_89 = 0
                    *x0_53 = x21_15
                    x0_53[1] = 0
                    x21_15 = x0_53
                    x19[0x266] = x0_53
                
                x9_51 = x8_89 + 0x20
                x20_13 = x21_15 + x8_89
                x11_6 = "decltype(auto)"
                goto label_493ac8
            case 0x15
                x21_18 = x19[0x266]
                *x19 = &x8_1[2]
                int64_t x8_91 = x21_18[1]
                
                if (x8_91 + 0x20 u>= 0xff0)
                    void*** x0_54 = malloc(0x1000)
                    
                    if (x0_54 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_91 = 0
                    *x0_54 = x21_18
                    x0_54[1] = 0
                    x21_18 = x0_54
                    x19[0x266] = x0_54
                
                x9_58 = x8_91 + 0x20
                x20_14 = x21_18 + x8_91
                x11_6 = "decimal64"
                goto label_493c38
            case 0x16
                x21_8 = x19[0x266]
                *x19 = &x8_1[2]
                int64_t x8_93 = x21_8[1]
                
                if (x8_93 + 0x20 u>= 0xff0)
                    void** x0_55 = malloc(0x1000)
                    
                    if (x0_55 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_93 = 0
                    *x0_55 = x21_8
                    x0_55[1] = 0
                    x21_8 = x0_55
                    x19[0x266] = x0_55
                
                x9_19 = x8_93 + 0x20
                x20_9 = x21_8 + x8_93
                x11_6 = "decimal128"
                goto label_493498
            case 0x17
                x21_18 = x19[0x266]
                *x19 = &x8_1[2]
                int64_t x8_95 = x21_18[1]
                
                if (x8_95 + 0x20 u>= 0xff0)
                    void*** x0_56 = malloc(0x1000)
                    
                    if (x0_56 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_95 = 0
                    *x0_56 = x21_18
                    x0_56[1] = 0
                    x21_18 = x0_56
                    x19[0x266] = x0_56
                
                x9_58 = x8_95 + 0x20
                x20_14 = x21_18 + x8_95
                x11_6 = "decimal32"
                goto label_493c38
            case 0x19
                x21_18 = x19[0x266]
                *x19 = &x8_1[2]
                int64_t x8_97 = x21_18[1]
                
                if (x8_97 + 0x20 u>= 0xff0)
                    void** x0_57 = malloc(0x1000)
                    
                    if (x0_57 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_97 = 0
                    *x0_57 = x21_18
                    x0_57[1] = 0
                    x21_18 = x0_57
                    x19[0x266] = x0_57
                
                x9_58 = x8_97 + 0x20
                x20_14 = x21_18 + x8_97
                x11_6 = "decimal16"
                goto label_493c38
            case 0x1a
                x21_2 = x19[0x266]
                *x19 = &x8_1[2]
                int64_t x8_99 = x21_2[1]
                
                if (x8_99 + 0x20 u>= 0xff0)
                    void*** x0_58 = malloc(0x1000)
                    
                    if (x0_58 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_99 = 0
                    *x0_58 = x21_2
                    x0_58[1] = 0
                    x21_2 = x0_58
                    x19[0x266] = x0_58
                
                x9_5 = x8_99 + 0x20
                x20_3 = x21_2 + x8_99
                x11_6 = "char32_t"
                goto label_493140
            case 0x1f
                x21_15 = x19[0x266]
                *x19 = &x8_1[2]
                int64_t x8_101 = x21_15[1]
                
                if (x8_101 + 0x20 u>= 0xff0)
                    void** x0_59 = malloc(0x1000)
                    
                    if (x0_59 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_101 = 0
                    *x0_59 = x21_15
                    x0_59[1] = 0
                    x21_15 = x0_59
                    x19[0x266] = x0_59
                
                x9_51 = x8_101 + 0x20
                x20_13 = x21_15 + x8_101
                x11_6 = "std::nullptr_t"
                goto label_493ac8
            case 0x21
                *x19 = &x8_1[2]
                void* result_9 = sub_492f20(x19)
                result = result_9
                
                if (result_9 == 0)
                    goto label_493f88
                
                void** x21_20 = x19[0x266]
                int64_t x8_103 = x21_20[1]
                
                if (x8_103 + 0x20 u>= 0xff0)
                    void** x0_61 = malloc(0x1000)
                    
                    if (x0_61 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_103 = 0
                    *x0_61 = x21_20
                    x0_61[1] = 0
                    x21_20 = x0_61
                    x19[0x266] = x0_61
                
                x21_20[1] = x8_103 + 0x20
                result_13 = x21_20 + x8_103 + 0x10
                *result_13 = &_vtable_for_(anonymous namespace)::itanium_demangle::ParameterPackExpansion{for `(anonymous namespace)::itanium_demangle::Node'}
                result_13[1].d = 0x1010122
                result_13[2] = result
                goto label_493f64
            case 0x24
                x21_2 = x19[0x266]
                *x19 = &x8_1[2]
                int64_t x8_106 = x21_2[1]
                
                if (x8_106 + 0x20 u>= 0xff0)
                    void** x0_62 = malloc(0x1000)
                    
                    if (x0_62 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_106 = 0
                    *x0_62 = x21_2
                    x0_62[1] = 0
                    x21_2 = x0_62
                    x19[0x266] = x0_62
                
                x9_5 = x8_106 + 0x20
                x20_3 = x21_2 + x8_106
                x11_6 = "char16_t"
                goto label_493140
            case 0x26
                x21_7 = x19[0x266]
                *x19 = &x8_1[2]
                int64_t x8_108 = x21_7[1]
                
                if (x8_108 + 0x20 u>= 0xff0)
                    void** x0_63 = malloc(0x1000)
                    
                    if (x0_63 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_108 = 0
                    *x0_63 = x21_7
                    x0_63[1] = 0
                    x21_7 = x0_63
                    x19[0x266] = x0_63
                
                x9_14 = x8_108 + 0x20
                x20_8 = x21_7 + x8_108
                x11_6 = "char8_t"
                goto label_4933e8
            case 0x27
                void* x20_16 = &x8_1[2]
                *x19 = x20_16
                uint32_t x9_90
                
                if (result_11 != x20_16)
                    x9_90 = zx.d(*x20_16)
                
                if (result_11 != x20_16 && x9_90 - 0x31 u<= 8)
                    if (x9_90 - 0x30 u<= 9)
                        void* x8_114 = &x8_1[3]
                        
                        while (true)
                            *x19 = x8_114
                            
                            if (result_11 == x8_114)
                                break
                            
                            uint32_t x9_98 = zx.d(*x8_114)
                            x8_114 += 1
                            
                            if (x9_98 - 0x30 u>= 0xa)
                                result_11 = x8_114 - 1
                                break
                    else
                        x20_16 = nullptr
                        result_11 = nullptr
                    
                    int64_t* x0_70 = x19[0x266]
                    int64_t x8_115 = x0_70[1]
                    
                    if (x8_115 + 0x20 u>= 0xff0)
                        int64_t* x23_5 = x0_70
                        x0_70 = malloc(0x1000)
                        
                        if (x0_70 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_115 = 0
                        *x0_70 = x23_5
                        x0_70[1] = 0
                        x19[0x266] = x0_70
                    
                    x0_70[1] = x8_115 + 0x20
                    *(x0_70 + x8_115 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                    *(x0_70 + x8_115 + 0x18) = 0x1010107
                    *(x0_70 + x8_115 + 0x20) = x20_16
                    *(x0_70 + x8_115 + 0x28) = result_11
                    void* x8_116 = *x19
                    int64_t x9_102 = x19[1]
                    
                    if (x8_116 == x9_102 || zx.d(*x8_116) != 0x5f)
                        result_12 = nullptr
                        goto label_4937c8
                    
                    *x19 = x8_116 + 1
                    
                    if (x8_116 + 1 != x9_102 && zx.d(*(x8_116 + 1)) == 0x70)
                        void** x20_17 = x19[0x266]
                        *x19 = x8_116 + 2
                        int64_t x8_118 = x20_17[1]
                        
                        if (x8_118 + 0x20 u>= 0xff0)
                            void** x0_71 = malloc(0x1000)
                            
                            if (x0_71 == 0)
                                sub_491944()
                                noreturn
                            
                            x8_118 = 0
                            *x0_71 = x20_17
                            x0_71[1] = 0
                            x20_17 = x0_71
                            x19[0x266] = x0_71
                        
                        x20_17[1] = x8_118 + 0x20
                        result_12 = x20_17 + x8_118 + 0x10
                        *result_12 = &_vtable_for_(anonymous namespace)::itanium_demangle::PixelVectorType{for `(anonymous namespace)::itanium_demangle::Node'}
                        result_12[1].d = 0x101011a
                        result_12[2] = x0_70 + x8_115 + 0x10
                        goto label_4937c8
                    
                    result_12 = sub_492f20(x19)
                    
                    if (result_12 == 0)
                        goto label_4937c8
                    
                    void** x21_22 = x19[0x266]
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
                        ** result_18 = result_12
                    int64_t x8_119 = x21_22[1]
                    
                    if (x8_119 + 0x20 u>= 0xff0)
                        void** x0_74 = malloc(0x1000)
                        
                        if (x0_74 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_119 = 0
                        *x0_74 = x21_22
                        x0_74[1] = 0
                        x21_22 = x0_74
                        x19[0x266] = x0_74
                    
                    x21_22[1] = x8_119 + 0x20
                    result_12 = x21_22 + x8_119 + 0x10
                    *result_12 = &_vtable_for_(anonymous namespace)::itanium_demangle::VectorType{for `(anonymous namespace)::itanium_demangle::Node'}
                    result_12[1].d = 0x1010119
                    result_12[2] = result_18
                    result_12[3] = x0_70 + x8_115 + 0x10
                    goto label_4937c8
                
                if (x20_16 != result_11 && zx.d(*x20_16) == 0x5f)
                    *x19 = &x8_1[3]
                    result_12 = sub_492f20(x19)
                    
                    if (result_12 == 0)
                        goto label_4937c8
                    
                    void** x21_21 = x19[0x266]
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
                        ** result_17 = result_12
                    int64_t x8_110 = x21_21[1]
                    
                    if (x8_110 + 0x20 u>= 0xff0)
                        void** x0_65 = malloc(0x1000)
                        
                        if (x0_65 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_110 = 0
                        *x0_65 = x21_21
                        x0_65[1] = 0
                        x21_21 = x0_65
                        x19[0x266] = x0_65
                    
                    x21_21[1] = x8_110 + 0x20
                    result_12 = x21_21 + x8_110 + 0x10
                    *result_12 = &_vtable_for_(anonymous namespace)::itanium_demangle::VectorType{for `(anonymous namespace)::itanium_demangle::Node'}
                    result_12[1].d = 0x1010119
                    result_12[2] = result_17
                    result_12[3] = 0
                    goto label_4937c8
                
                result_12 = sub_49707c(x19)
                
                if (result_12 == 0)
                    goto label_4937c8
                
                char* x8_111 = *x19
                
                if (x8_111 == x19[1] || zx.d(*x8_111) != 0x5f)
                    result_12 = nullptr
                    goto label_4937c8
                
                result_15 = result_12
                *x19 = &x8_111[1]
                result_12 = sub_492f20(x19)
                
                if (result_12 == 0)
                    goto label_4937c8
                
                x23_4 = x19[0x266]
                result_20 = result_12
                int64_t x8_113 = x23_4[1]
                
                if (x8_113 + 0x20 u>= 0xff0)
                    void** x0_69 = malloc(0x1000)
                    
                    if (x0_69 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_113 = 0
                    *x0_69 = x23_4
                    x0_69[1] = 0
                    x23_4 = x0_69
                    x19[0x266] = x0_69
                
                x9_75 = x8_113 + 0x20
                x0_48 = x23_4 + x8_113
                x8_82 = &_vtable_for_(anonymous namespace)::itanium_demangle::VectorType{for `(anonymous namespace)::itanium_demangle::Node'}
                x10_10 = 0x1010119
    case 5
        result_12 = sub_4a2fc8(x19)
        goto label_4937c8
    case 6
        *x19 = &x8_1[1]
        void* result_4 = sub_492f20(x19)
        result = result_4
        
        if (result_4 == 0)
            goto label_493f88
        
        void** x21_11 = x19[0x266]
        int64_t x8_41 = x21_11[1]
        
        if (x8_41 + 0x30 u>= 0xff0)
            void** x0_17 = malloc(0x1000)
            
            if (x0_17 == 0)
                sub_491944()
                noreturn
            
            x8_41 = 0
            *x0_17 = x21_11
            x0_17[1] = 0
            x21_11 = x0_17
            x19[0x266] = x0_17
        
        x12_2 = " imaginary"
        x21_11[1] = x8_41 + 0x30
        result_13 = x21_11 + x8_41 + 0x10
        *result_13 = &_vtable_for_(anonymous namespace)::itanium_demangle::PostfixQualifiedType{for `(anonymous namespace)::itanium_demangle::Node'}
        x9_25 = &data_40ea57[0xa]
        goto label_493658
    case 0xa, 0x15, 0x31
        uint64_t x10_2 = zx.q(x11_1 == 0x72 ? 1 : 0)
        
        if (x9 u> x10_2)
            int32_t x11_2
            
            x11_2 = x11_1 == 0x72 ? 2 : 1
            
            if (zx.d(x8_1[x10_2]) == 0x56)
                x10_2 = zx.q(x11_2)
            else
                x10_2 = zx.q(x10_2.d)
        
        uint64_t x11_4 = zx.q(x10_2.d)
        
        if (x9 u> x11_4)
            if (zx.d(x8_1[x11_4]) == 0x4b)
                x11_4 = zx.q(x10_2.d + 1)
            else
                x11_4 = zx.q(x10_2.d)
            
            x10_2 = zx.q(x11_4.d)
        
        if (x9 u<= x11_4)
            result_12 = sub_4a34c8(x19)
            goto label_4937c8
        
        uint32_t x11_5 = zx.d(x8_1[x11_4])
        
        if (x11_5 == 0x46)
            result_12 = sub_4a2fc8(x19)
            goto label_4937c8
        
        if (x11_5 != 0x44 || x9 u<= zx.q(x10_2.d) + 1)
            result_12 = sub_4a34c8(x19)
            goto label_4937c8
        
        uint64_t x8_3 = zx.q(zx.d(x8_1[zx.q(x10_2.d) + 1]) - 0x4f)
        
        if (x8_3.d u> 0x29 || (1 << x8_3 & 0x30100000001) == 0)
            result_12 = sub_4a34c8(x19)
            goto label_4937c8
        
        result_12 = sub_4a2fc8(x19)
        goto label_4937c8
    case 0xc
        if (x8_1 == result_11)
            result_12 = nullptr
            goto label_4937c8
        
        *x19 = &x8_1[1]
        result_12 = sub_492f20(x19)
        
        if (result_12 == 0)
            goto label_4937c8
        
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
            ** result_16 = result_12
        result_12 = sub_492f20(x19)
        
        if (result_12 == 0)
            goto label_4937c8
        
        void** x23_2 = x19[0x266]
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
            ** result_19 = result_12
        int64_t x8_44 = x23_2[1]
        
        if (x8_44 + 0x20 u>= 0xff0)
            void** x0_20 = malloc(0x1000)
            
            if (x0_20 == 0)
                sub_491944()
                noreturn
            
            x8_44 = 0
            *x0_20 = x23_2
            x0_20[1] = 0
            x23_2 = x0_20
            x19[0x266] = x0_20
        
        x23_2[1] = x8_44 + 0x20
        char x9_30 = *(result_19 + 9)
        result_12 = x23_2 + x8_44 + 0x10
        *result_12 = &_vtable_for_(anonymous namespace)::itanium_demangle::PointerToMemberType{for `(anonymous namespace)::itanium_demangle::Node'}
        result_12[1].b = 0xd
        *(result_12 + 0xa) = 0x101
        *(result_12 + 9) = x9_30
        result_12[2] = result_16
        result_12[3] = result_19
        goto label_4937c8
    case 0xe
        *x19 = &x8_1[1]
        void* result_5 = sub_492f20(x19)
        result = result_5
        
        if (result_5 == 0)
            goto label_493f88
        
        void** x21_12 = x19[0x266]
        int64_t x8_53 = x21_12[1]
        
        if (x8_53 + 0x20 u>= 0xff0)
            void** x0_29 = malloc(0x1000)
            
            if (x0_29 == 0)
                sub_491944()
                noreturn
            
            x8_53 = 0
            *x0_29 = x21_12
            x0_29[1] = 0
            x21_12 = x0_29
            x19[0x266] = x0_29
        
        x21_12[1] = x8_53 + 0x20
        x10_8 = *(result + 9)
        result_13 = x21_12 + x8_53 + 0x10
        *result_13 = &_vtable_for_(anonymous namespace)::itanium_demangle::ReferenceType{for `(anonymous namespace)::itanium_demangle::Node'}
        result_13[1].b = 0xc
        *(result_13 + 0xa) = 0x101
        result_13[2] = result
        result_13[3].d = 1
    label_493bd4:
        *(result_13 + 0x1c) = 0
        *(result_13 + 9) = x10_8
        goto label_493f64
    case 0xf
        *x19 = &x8_1[1]
        void* result_6 = sub_492f20(x19)
        result = result_6
        
        if (result_6 == 0)
            goto label_493f88
        
        void** x21_16 = x19[0x266]
        int64_t x8_62 = x21_16[1]
        
        if (x8_62 + 0x20 u>= 0xff0)
            void** x0_34 = malloc(0x1000)
            
            if (x0_34 == 0)
                sub_491944()
                noreturn
            
            x8_62 = 0
            *x0_34 = x21_16
            x0_34[1] = 0
            x21_16 = x0_34
            x19[0x266] = x0_34
        
        x21_16[1] = x8_62 + 0x20
        char x9_54 = *(result + 9)
        result_13 = x21_16 + x8_62 + 0x10
        *result_13 = &_vtable_for_(anonymous namespace)::itanium_demangle::PointerType{for `(anonymous namespace)::itanium_demangle::Node'}
        result_13[1].b = 0xb
        *(result_13 + 0xa) = 0x101
        result_13[2] = result
        *(result_13 + 9) = x9_54
    label_493f64:
        result_1 = result_13
    label_4937d8:
        sub_4953d4(&x19[0x25], &result_1)
        result = result_1
        goto label_493f88
    case 0x11
        *x19 = &x8_1[1]
        void* result_7 = sub_492f20(x19)
        result = result_7
        
        if (result_7 == 0)
            goto label_493f88
        
        void** x21_17 = x19[0x266]
        int64_t x8_65 = x21_17[1]
        
        if (x8_65 + 0x20 u>= 0xff0)
            void** x0_36 = malloc(0x1000)
            
            if (x0_36 == 0)
                sub_491944()
                noreturn
            
            x8_65 = 0
            *x0_36 = x21_17
            x0_36[1] = 0
            x21_17 = x0_36
            x19[0x266] = x0_36
        
        x21_17[1] = x8_65 + 0x20
        x10_8 = *(result + 9)
        result_13 = x21_17 + x8_65 + 0x10
        *result_13 = &_vtable_for_(anonymous namespace)::itanium_demangle::ReferenceType{for `(anonymous namespace)::itanium_demangle::Node'}
        result_13[1].b = 0xc
        *(result_13 + 0xa) = 0x101
        result_13[2] = result
        result_13[3].d = 0
        goto label_493bd4
    case 0x12
        if (x9 u< 2)
            goto label_4937c4
        
        uint32_t x8_47 = zx.d(x8_1[1])
        
        if (x8_47 == 0 || x8_47 == 0x74)
            goto label_4937c4
        
        void* result_8 = sub_495970(x19)
        result = result_8
        
        if (result_8 == 0 || zx.d(x19[0x61].b) == 0)
            goto label_493f88
        
        void* x8_75 = *x19
        
        if (x19[1] == x8_75 || zx.d(*x8_75) != 0x49)
            goto label_493f88
        
        goto label_493d84
    case 0x13
        int32_t x8_19
        
        if (x9 u>= 2)
            x8_19 = zx.d(x8_1[1]) - 0x65
        
        if (x9 u>= 2 && x8_19 u<= 0x10 && (1 << x8_19 & 0x14001) != 0)
            goto label_4937c4
        
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
            ** result_2 = sub_49615c(x19)
        result = result_2
        result_1 = result_2
        
        if (result_2 == 0)
            goto label_493f88
        
        if (zx.d(x19[0x61].b) == 0)
            goto label_4937d8
        
        void* x8_22 = *x19
        
        if (x19[1] == x8_22 || zx.d(*x8_22) != 0x49)
            goto label_4937d8
        
    label_493d84:
        void* x0_43 = sub_495d00(x19, 0)
        
        if (x0_43 == 0)
            goto label_493f7c
        
        x23_3 = x19[0x266]
        x21_19 = x0_43
        int64_t x8_77 = x23_3[1]
        
        if (x8_77 + 0x20 u>= 0xff0)
            void** x0_44 = malloc(0x1000)
            
            if (x0_44 == 0)
                sub_491944()
                noreturn
            
            x8_77 = 0
            *x0_44 = x23_3
            x0_44[1] = 0
            x23_3 = x0_44
            x19[0x266] = x0_44
        
        x11_8 = 0x125
        x9_67 = x8_77 + 0x20
        x8_78 = x23_3 + x8_77
        x10_9 = &_vtable_for_(anonymous namespace)::itanium_demangle::NameWithTemplateArgs{for `(anonymous namespace)::itanium_demangle::Node'}
        goto label_493f54
    case 0x14
        result_12 = sub_4a34c8(x19)
        goto label_4937c8
    case 0x20
        x21_13 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_70 = x21_13[1]
        
        if (x8_70 + 0x20 u>= 0xff0)
            void** x0_38 = malloc(0x1000)
            
            if (x0_38 == 0)
                sub_491944()
                noreturn
            
            x8_70 = 0
            *x0_38 = x21_13
            x0_38[1] = 0
            x21_13 = x0_38
            x19[0x266] = x0_38
        
        x9_60 = x8_70 + 0x20
        x20_11 = x21_13 + x8_70
        x11_6 = "signed char"
        goto label_493ca0
    case 0x21
        x21_1 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_25 = x21_1[1]
        
        if (x8_25 + 0x20 u>= 0xff0)
            void*** x0_8 = malloc(0x1000)
            
            if (x0_8 == 0)
                sub_491944()
                noreturn
            
            x8_25 = 0
            *x0_8 = x21_1
            x0_8[1] = 0
            x21_1 = x0_8
            x19[0x266] = x0_8
        
        x9_62 = x8_25 + 0x20
        x20_2 = x21_1 + x8_25
        x11_6 = "bool"
        goto label_493d08
    case 0x22
        x21_1 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_72 = x21_1[1]
        
        if (x8_72 + 0x20 u>= 0xff0)
            void*** x0_39 = malloc(0x1000)
            
            if (x0_39 == 0)
                sub_491944()
                noreturn
            
            x8_72 = 0
            *x0_39 = x21_1
            x0_39[1] = 0
            x21_1 = x0_39
            x19[0x266] = x0_39
        
        x9_62 = x8_72 + 0x20
        x20_2 = x21_1 + x8_72
        x11_6 = "char"
        goto label_493d08
    case 0x23
        void** x21_6 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_27 = x21_6[1]
        
        if (x8_27 + 0x20 u>= 0xff0)
            void** x0_9 = malloc(0x1000)
            
            if (x0_9 == 0)
                sub_491944()
                noreturn
            
            x8_27 = 0
            *x0_9 = x21_6
            x0_9[1] = 0
            x21_6 = x0_9
            x19[0x266] = x0_9
        
        x11_6 = "double"
        x21_6[1] = x8_27 + 0x20
        result = x21_6 + x8_27 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &data_451a8e[6]
        goto label_493d14
    case 0x24
        x21_13 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_56 = x21_13[1]
        
        if (x8_56 + 0x20 u>= 0xff0)
            void*** x0_30 = malloc(0x1000)
            
            if (x0_30 == 0)
                sub_491944()
                noreturn
            
            x8_56 = 0
            *x0_30 = x21_13
            x0_30[1] = 0
            x21_13 = x0_30
            x19[0x266] = x0_30
        
        x9_60 = x8_56 + 0x20
        x20_11 = x21_13 + x8_56
        x11_6 = "long double"
    label_493ca0:
        x21_13[1] = x9_60
        result = x20_11 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &x11_6[0xb]
        goto label_493d14
    case 0x25
        x21_5 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_17 = x21_5[1]
        
        if (x8_17 + 0x20 u>= 0xff0)
            void*** x0_6 = malloc(0x1000)
            
            if (x0_6 == 0)
                sub_491944()
                noreturn
            
            x8_17 = 0
            *x0_6 = x21_5
            x0_6[1] = 0
            x21_5 = x0_6
            x19[0x266] = x0_6
        
        x9_38 = x8_17 + 0x20
        x20_6 = x21_5 + x8_17
        x11_6 = "float"
    label_4938a4:
        x21_5[1] = x9_38
        result = x20_6 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &x11_6[5]
        goto label_493d14
    case 0x26
        x21_8 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_32 = x21_8[1]
        
        if (x8_32 + 0x20 u>= 0xff0)
            void*** x0_11 = malloc(0x1000)
            
            if (x0_11 == 0)
                sub_491944()
                noreturn
            
            x8_32 = 0
            *x0_11 = x21_8
            x0_11[1] = 0
            x21_8 = x0_11
            x19[0x266] = x0_11
        
        x9_19 = x8_32 + 0x20
        x20_9 = x21_8 + x8_32
        x11_6 = "__float128"
    label_493498:
        x21_8[1] = x9_19
        result = x20_9 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &x11_6[0xa]
        goto label_493d14
    case 0x27
        x21_4 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_49 = x21_4[1]
        
        if (x8_49 + 0x20 u>= 0xff0)
            void** x0_26 = malloc(0x1000)
            
            if (x0_26 == 0)
                sub_491944()
                noreturn
            
            x8_49 = 0
            *x0_26 = x21_4
            x0_26[1] = 0
            x21_4 = x0_26
            x19[0x266] = x0_26
        
        x9_36 = x8_49 + 0x20
        x20_5 = x21_4 + x8_49
        x11_6 = "unsigned char"
        goto label_49383c
    case 0x28
        x21_3 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_46 = x21_3[1]
        
        if (x8_46 + 0x20 u>= 0xff0)
            void** x0_22 = malloc(0x1000)
            
            if (x0_22 == 0)
                sub_491944()
                noreturn
            
            x8_46 = 0
            *x0_22 = x21_3
            x0_22[1] = 0
            x21_3 = x0_22
            x19[0x266] = x0_22
        
        x9_32 = x8_46 + 0x20
        x20_4 = x21_3 + x8_46
        x11_6 = "int"
        goto label_493758
    case 0x29
        void** x21_14 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_58 = x21_14[1]
        
        if (x8_58 + 0x20 u>= 0xff0)
            void** x0_31 = malloc(0x1000)
            
            if (x0_31 == 0)
                sub_491944()
                noreturn
            
            x8_58 = 0
            *x0_31 = x21_14
            x0_31[1] = 0
            x21_14 = x0_31
            x19[0x266] = x0_31
        
        x11_6 = "unsigned int"
        x21_14[1] = x8_58 + 0x20
        result = x21_14 + x8_58 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &data_40e00a[0xc]
        goto label_493d14
    case 0x2b
        x21_1 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_34 = x21_1[1]
        
        if (x8_34 + 0x20 u>= 0xff0)
            void*** x0_12 = malloc(0x1000)
            
            if (x0_12 == 0)
                sub_491944()
                noreturn
            
            x8_34 = 0
            *x0_12 = x21_1
            x0_12[1] = 0
            x21_1 = x0_12
            x19[0x266] = x0_12
        
        x9_62 = x8_34 + 0x20
        x20_2 = x21_1 + x8_34
        x11_6 = "long"
        goto label_493d08
    case 0x2c
        x21_4 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_15 = x21_4[1]
        
        if (x8_15 + 0x20 u>= 0xff0)
            void*** x0_5 = malloc(0x1000)
            
            if (x0_5 == 0)
                sub_491944()
                noreturn
            
            x8_15 = 0
            *x0_5 = x21_4
            x0_5[1] = 0
            x21_4 = x0_5
            x19[0x266] = x0_5
        
        x9_36 = x8_15 + 0x20
        x20_5 = x21_4 + x8_15
        x11_6 = "unsigned long"
    label_49383c:
        x21_4[1] = x9_36
        result = x20_5 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &x11_6[0xd]
        goto label_493d14
    case 0x2d
        x21_2 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_11 = x21_2[1]
        
        if (x8_11 + 0x20 u>= 0xff0)
            void*** x0_3 = malloc(0x1000)
            
            if (x0_3 == 0)
                sub_491944()
                noreturn
            
            x8_11 = 0
            *x0_3 = x21_2
            x0_3[1] = 0
            x21_2 = x0_3
            x19[0x266] = x0_3
        
        x9_5 = x8_11 + 0x20
        x20_3 = x21_2 + x8_11
        x11_6 = "__int128"
    label_493140:
        x21_2[1] = x9_5
        result = x20_3 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &x11_6[8]
        goto label_493d14
    case 0x2e
        void** x21_9 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_36 = x21_9[1]
        
        if (x8_36 + 0x20 u>= 0xff0)
            void** x0_13 = malloc(0x1000)
            
            if (x0_13 == 0)
                sub_491944()
                noreturn
            
            x8_36 = 0
            *x0_13 = x21_9
            x0_13[1] = 0
            x21_9 = x0_13
            x19[0x266] = x0_13
        
        x11_6 = "unsigned __int128"
        x21_9[1] = x8_36 + 0x20
        result = x21_9 + x8_36 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &data_40c664[0x11]
        goto label_493d14
    case 0x32
        x21_5 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_51 = x21_5[1]
        
        if (x8_51 + 0x20 u>= 0xff0)
            void** x0_27 = malloc(0x1000)
            
            if (x0_27 == 0)
                sub_491944()
                noreturn
            
            x8_51 = 0
            *x0_27 = x21_5
            x0_27[1] = 0
            x21_5 = x0_27
            x19[0x266] = x0_27
        
        x9_38 = x8_51 + 0x20
        x20_6 = x21_5 + x8_51
        x11_6 = "short"
        goto label_4938a4
    case 0x33
        x21_15 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_60 = x21_15[1]
        
        if (x8_60 + 0x20 u>= 0xff0)
            void*** x0_32 = malloc(0x1000)
            
            if (x0_32 == 0)
                sub_491944()
                noreturn
            
            x8_60 = 0
            *x0_32 = x21_15
            x0_32[1] = 0
            x21_15 = x0_32
            x19[0x266] = x0_32
        
        x9_51 = x8_60 + 0x20
        x20_13 = x21_15 + x8_60
        x11_6 = "unsigned short"
    label_493ac8:
        x21_15[1] = x9_51
        result = x20_13 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &x11_6[0xe]
        goto label_493d14
    case 0x34
        void* result_10 = &x8_1[1]
        *x19 = result_10
        
        if (result_11 == result_10 || zx.d(*result_10) - 0x30 u> 9)
        label_493efc:
        label_493f7c:
            result = nullptr
        label_493f88:
            
            if (*(x22 + 0x28) == x8)
                return result
            
            __stack_chk_fail()
            noreturn
        
        int64_t x9_43
        
        if (result_10 == result_11)
            x9_43 = -0x30
        else
            int64_t x9_41 = 0
            
            while (true)
                void* result_14 = result_10
                result_10 += 1
                *x19 = result_10
                x9_43 = x9_41 + zx.q(*result_14) - 0x30
                
                if (result_11 == result_10 || zx.d(*result_10) - 0x30 u>= 0xa)
                    result = result_10
                    goto label_493ef4
                
                x9_41 = x9_43 * 0xa
                
                if (result_11 != result_10)
                    continue
                
                x9_43 = x9_41 - 0x30
                break
        
        result = result_11
    label_493ef4:
        
        if (result_11 - result_10 u< x9_43)
            goto label_493efc
        
        x21_19 = result + x9_43
        *x19 = x21_19
        
        if (result == x21_19)
            goto label_493f7c
        
        x23_3 = x19[0x266]
        int64_t x8_84 = x23_3[1]
        
        if (x8_84 + 0x20 u>= 0xff0)
            void*** x0_49 = malloc(0x1000)
            
            if (x0_49 == 0)
                sub_491944()
                noreturn
            
            x8_84 = 0
            *x0_49 = x23_3
            x0_49[1] = 0
            x23_3 = x0_49
            x19[0x266] = x0_49
        
        x11_8 = 0x107
        x9_67 = x8_84 + 0x20
        x8_78 = x23_3 + x8_84
        x10_9 = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
    label_493f54:
        x23_3[1] = x9_67
        result_13 = x8_78 + 0x10
        *result_13 = x10_9
        result_13[1].d = zx.d(x11_8) | 0x1010000
        result_13[2] = result
        result_13[3] = x21_19
        goto label_493f64
    case 0x35
        x21_1 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_9 = x21_1[1]
        
        if (x8_9 + 0x20 u>= 0xff0)
            void*** x0_2 = malloc(0x1000)
            
            if (x0_2 == 0)
                sub_491944()
                noreturn
            
            x8_9 = 0
            *x0_2 = x21_1
            x0_2[1] = 0
            x21_1 = x0_2
            x19[0x266] = x0_2
        
        x9_62 = x8_9 + 0x20
        x20_2 = x21_1 + x8_9
        x11_6 = "void"
    label_493d08:
        x21_1[1] = x9_62
        result = x20_2 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &x11_6[4]
        goto label_493d14
    case 0x36
        x21_7 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_29 = x21_7[1]
        
        if (x8_29 + 0x20 u>= 0xff0)
            void*** x0_10 = malloc(0x1000)
            
            if (x0_10 == 0)
                sub_491944()
                noreturn
            
            x8_29 = 0
            *x0_10 = x21_7
            x0_10[1] = 0
            x21_7 = x0_10
            x19[0x266] = x0_10
        
        x9_14 = x8_29 + 0x20
        x20_8 = x21_7 + x8_29
        x11_6 = "wchar_t"
    label_4933e8:
        x21_7[1] = x9_14
        result = x20_8 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &x11_6[7]
        goto label_493d14
    case 0x37
        x21_18 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_68 = x21_18[1]
        
        if (x8_68 + 0x20 u>= 0xff0)
            void*** x0_37 = malloc(0x1000)
            
            if (x0_37 == 0)
                sub_491944()
                noreturn
            
            x8_68 = 0
            *x0_37 = x21_18
            x0_37[1] = 0
            x21_18 = x0_37
            x19[0x266] = x0_37
        
        x9_58 = x8_68 + 0x20
        x20_14 = x21_18 + x8_68
        x11_6 = "long long"
    label_493c38:
        x21_18[1] = x9_58
        result = x20_14 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &x11_6[9]
        goto label_493d14
    case 0x38
        void** x21 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_6 = x21[1]
        
        if (x8_6 + 0x20 u>= 0xff0)
            void** x0_1 = malloc(0x1000)
            
            if (x0_1 == 0)
                sub_491944()
                noreturn
            
            x8_6 = 0
            *x0_1 = x21
            x0_1[1] = 0
            x21 = x0_1
            x19[0x266] = x0_1
        
        x11_6 = "unsigned long long"
        x21[1] = x8_6 + 0x20
        result = x21 + x8_6 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &data_40ea44[0x12]
    label_493d14:
        *(result + 8) = 0x1010107
        *(result + 0x10) = x11_6
        *(result + 0x18) = x8_7
        goto label_493f88
    case 0x39
        x21_3 = x19[0x266]
        *x19 = &x8_1[1]
        int64_t x8_13 = x21_3[1]
        
        if (x8_13 + 0x20 u>= 0xff0)
            void*** x0_4 = malloc(0x1000)
            
            if (x0_4 == 0)
                sub_491944()
                noreturn
            
            x8_13 = 0
            *x0_4 = x21_3
            x0_4[1] = 0
            x21_3 = x0_4
            x19[0x266] = x0_4
        
        x9_32 = x8_13 + 0x20
        x20_4 = x21_3 + x8_13
        x11_6 = "..."
    label_493758:
        x21_3[1] = x9_32
        result = x20_4 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        x8_7 = &x11_6[3]
        goto label_493d14

x23_4[1] = x9_75
result_12 = x0_48 + 0x10
*result_12 = x8_82
result_12[1].d = x10_10
result_12[2] = result_20
result_12[3] = result_15
goto label_4937c8
