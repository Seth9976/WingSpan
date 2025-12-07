// 函数: sub_4922d0
// 地址: 0x4922d0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
void** x19 = arg1
char* x8_1 = *arg1
int64_t x9 = arg1[1]
uint32_t x10_1

if (x9 != x8_1)
    x10_1 = zx.d(*x8_1)

void* result

if (x9 != x8_1 && (x10_1 == 0x54 || x10_1 == 0x47))
    void* x11_1 = x9 - x8_1
    
    if (x9 == x8_1)
    labelid_b:
        result = nullptr
    else
        char* const x8_15
        char* const x11_6
        void* x21_4
        
        if (x10_1 == 0x47)
            if (x11_1 u< 2)
            labelid_b:
                result = nullptr
            else
                uint32_t x9_7 = zx.d(x8_1[1])
                
                if (x9_7 == 0x52)
                    *x19 = &x8_1[2]
                    void* x0_24 = sub_4946a0(x19, nullptr)
                    
                    if (x0_24 == 0)
                    labelid_b:
                        result = nullptr
                    else
                        void* x9_21 = *x19
                        int64_t x8_37 = x19[1]
                        x21_4 = x0_24
                        uint32_t x10_22
                        
                        if (x8_37 != x9_21)
                            x10_22 = zx.d(*x9_21)
                        
                        int32_t x10_23
                        
                        if (x8_37 == x9_21 || x10_22 u< 0x30
                                || (x10_22 u>= 0x3a && zx.d(x10_22.b - 0x41) u> 0x19))
                            x10_23 = 1
                        else
                            void* x11_10 = x9_21 + 1
                            
                            while (true)
                                x9_21 = x11_10
                                
                                if ((x10_22 & 0xff) u>= 0x3a && zx.d(x10_22.b - 0x41) u> 0x19)
                                    x10_23 = 0
                                    x9_21 -= 1
                                    break
                                
                                *x19 = x9_21
                                
                                if (x8_37 != x9_21)
                                    x10_22 = zx.d(*x9_21)
                                    x11_10 = x9_21 + 1
                                    
                                    if (x10_22 u> 0x2f)
                                        continue
                                
                                x10_23 = 0
                                break
                        
                        if (x9_21 != x8_37 && zx.d(*x9_21) == 0x5f)
                            *x19 = x9_21 + 1
                        label_49293c:
                            void** x22_8 = x19[0x266]
                            int64_t x8_40 = x22_8[1]
                            
                            if (x8_40 + 0x30 u>= 0xff0)
                                void** x0_26 = malloc(0x1000)
                                
                                if (x0_26 == 0)
                                    goto label_492f1c
                                
                                x8_40 = 0
                                *x0_26 = x22_8
                                x0_26[1] = 0
                                x22_8 = x0_26
                                x19[0x266] = x0_26
                            
                            x11_6 = "reference temporary for "
                            x22_8[1] = x8_40 + 0x30
                            result = x22_8 + x8_40 + 0x10
                            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                            x8_15 = &data_40cbe0[0x18]
                            goto label_492d00
                        
                        if (x10_23 != 0)
                            goto label_49293c
                        
                    labelid_b:
                        result = nullptr
                else if (x9_7 != 0x56)
                labelid_b:
                    result = nullptr
                else
                    *x19 = &x8_1[2]
                    void* x0_7 = sub_4946a0(x19, nullptr)
                    
                    if (x0_7 == 0)
                    labelid_b:
                        result = nullptr
                    else
                        void** x22_2 = x19[0x266]
                        x21_4 = x0_7
                        int64_t x8_14 = x22_2[1]
                        
                        if (x8_14 + 0x30 u< 0xff0)
                            goto label_492604
                        
                        void** x0_8 = malloc(0x1000)
                        
                        if (x0_8 == 0)
                        label_492f1c:
                            sub_491944()
                            noreturn
                        
                        x8_14 = 0
                        *x0_8 = x22_2
                        x0_8[1] = 0
                        x22_2 = x0_8
                        x19[0x266] = x0_8
                    label_492604:
                        x11_6 = "guard variable for "
                        x22_2[1] = x8_14 + 0x30
                        result = x22_2 + x8_14 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_15 = &data_40e43c[0x13]
                    label_492d00:
                        *(result + 8) = 0x1010114
                        *(result + 0x10) = x11_6
                        *(result + 0x18) = x8_15
                        *(result + 0x20) = x21_4
        else if (x10_1 != 0x54)
        labelid_b:
            result = nullptr
        else if (x11_1 u< 2)
        label_492624:
            *x19 = &x8_1[1]
            int32_t x20_2
            
            if (x9 != &x8_1[1])
                x20_2 = zx.d(x8_1[1]) == 0x76 ? 1 : 0
            else
                x20_2 = 0
            
            if ((sub_49548c(x19) & 1) != 0)
            labelid_b:
                result = nullptr
            else
                void* x0_12 = sub_4922d0(x19)
                
                if (x0_12 != 0)
                    void** x22_3 = x19[0x266]
                    x21_4 = x0_12
                    int64_t x8_18 = x22_3[1]
                    
                    if (x20_2 == 0)
                        if (x8_18 + 0x30 u>= 0xff0)
                            void*** x0_25 = malloc(0x1000)
                            
                            if (x0_25 == 0)
                                goto label_492f1c
                            
                            x8_18 = 0
                            *x0_25 = x22_3
                            x0_25[1] = 0
                            x22_3 = x0_25
                            x19[0x266] = x0_25
                        
                        x11_6 = "non-virtual thunk to "
                        x22_3[1] = x8_18 + 0x30
                        result = x22_3 + x8_18 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_15 = &data_40efb4[0x15]
                        goto label_492d00
                    
                    if (x8_18 + 0x30 u>= 0xff0)
                        void** x0_13 = malloc(0x1000)
                        
                        if (x0_13 == 0)
                            goto label_492f1c
                        
                        x8_18 = 0
                        *x0_13 = x22_3
                        x0_13[1] = 0
                        x22_3 = x0_13
                        x19[0x266] = x0_13
                    
                    x11_6 = "virtual thunk to "
                    x22_3[1] = x8_18 + 0x30
                    result = x22_3 + x8_18 + 0x10
                    *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                    x8_15 = &data_40e6a4[0x11]
                    goto label_492d00
                
            labelid_b:
                result = nullptr
        else
            uint64_t x10_3 = zx.q(zx.d(x8_1[1]) - 0x43)
            
            if (x10_3.d u> 0x20)
                goto label_492624
            
            switch (x10_3)
                case 0
                    *x19 = &x8_1[2]
                    void* x0_1 = sub_492f20(x19)
                    
                    if (x0_1 == 0)
                    labelid_b:
                        result = nullptr
                    else
                        void* x9_1 = *x19
                        void* x8_3 = x19[1]
                        void* x10_5
                        
                        if (x9_1 == x8_3)
                            x10_5 = x9_1
                        else
                            x10_5 = x9_1
                            
                            if (zx.d(*x9_1) == 0x6e)
                                x10_5 = x9_1 + 1
                                *x19 = x10_5
                        
                        void* x11_14
                        
                        if (x10_5 == x8_3 || zx.d(*x10_5) - 0x30 u> 9)
                            x9_1 = nullptr
                            x11_14 = nullptr
                        else
                            void* x10_26 = x10_5 + 1
                            
                            while (true)
                                *x19 = x10_26
                                
                                if (x8_3 == x10_26)
                                    x10_5 = x8_3
                                    x11_14 = x8_3
                                    break
                                
                                uint32_t x11_15 = zx.d(*x10_26)
                                x10_26 += 1
                                
                                if (x11_15 - 0x30 u>= 0xa)
                                    x10_5 = x10_26 - 1
                                    x11_14 = x10_5
                                    break
                        
                        result = nullptr
                        
                        if (x9_1 != x11_14 && x10_5 != x8_3)
                            if (zx.d(*x10_5) != 0x5f)
                            labelid_b:
                                result = nullptr
                            else
                                *x19 = x10_5 + 1
                                void* x0_53 = sub_492f20(x19)
                                
                                if (x0_53 == 0)
                                labelid_b:
                                    result = nullptr
                                else
                                    void** x23_4 = x19[0x266]
                                    int64_t x8_57 = x23_4[1]
                                    
                                    if (x8_57 + 0x20 u>= 0xff0)
                                        void** x0_54 = malloc(0x1000)
                                        
                                        if (x0_54 == 0)
                                            goto label_492f1c
                                        
                                        x8_57 = 0
                                        *x0_54 = x23_4
                                        x0_54[1] = 0
                                        x23_4 = x0_54
                                        x19[0x266] = x0_54
                                    
                                    x23_4[1] = x8_57 + 0x20
                                    result = x23_4 + x8_57 + 0x10
                                    *result = &_vtable_for_(anonymous namespace)::itanium_demangle::CtorVtableSpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                                    *(result + 8) = 0x1010115
                                    *(result + 0x10) = x0_53
                                    *(result + 0x18) = x0_1
                case 1, 2, 3, 4, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x12, 0x15, 0x16, 0x17, 
                        0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f
                    goto label_492624
                case 5
                    *x19 = &x8_1[2]
                    void* x0_31 = sub_4946a0(x19, nullptr)
                    
                    if (x0_31 != 0)
                        void** x22_10 = x19[0x266]
                        x21_4 = x0_31
                        int64_t x8_44 = x22_10[1]
                        
                        if (x8_44 + 0x30 u>= 0xff0)
                            void** x0_32 = malloc(0x1000)
                            
                            if (x0_32 == 0)
                                goto label_492f1c
                            
                            x8_44 = 0
                            *x0_32 = x22_10
                            x0_32[1] = 0
                            x22_10 = x0_32
                            x19[0x266] = x0_32
                        
                        x11_6 = "thread-local initialization routine for "
                        x22_10[1] = x8_44 + 0x30
                        result = x22_10 + x8_44 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_15 = &data_45278d[0x28]
                        goto label_492d00
                    
                labelid_b:
                    result = nullptr
                case 6
                    *x19 = &x8_1[2]
                    void* x0_44 = sub_492f20(x19)
                    
                    if (x0_44 != 0)
                        void** x22_13 = x19[0x266]
                        x21_4 = x0_44
                        int64_t x8_50 = x22_13[1]
                        
                        if (x8_50 + 0x30 u>= 0xff0)
                            void** x0_45 = malloc(0x1000)
                            
                            if (x0_45 == 0)
                                goto label_492f1c
                            
                            x8_50 = 0
                            *x0_45 = x22_13
                            x0_45[1] = 0
                            x22_13 = x0_45
                            x19[0x266] = x0_45
                        
                        x11_6 = "typeinfo for "
                        x22_13[1] = x8_50 + 0x30
                        result = x22_13 + x8_50 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_15 = &data_40cbd2[0xd]
                        goto label_492d00
                    
                labelid_b:
                    result = nullptr
                case 0x10
                    *x19 = &x8_1[2]
                    void* x0_47 = sub_492f20(x19)
                    
                    if (x0_47 != 0)
                        void** x22_14 = x19[0x266]
                        x21_4 = x0_47
                        int64_t x8_52 = x22_14[1]
                        
                        if (x8_52 + 0x30 u>= 0xff0)
                            void** x0_48 = malloc(0x1000)
                            
                            if (x0_48 == 0)
                                goto label_492f1c
                            
                            x8_52 = 0
                            *x0_48 = x22_14
                            x0_48[1] = 0
                            x22_14 = x0_48
                            x19[0x266] = x0_48
                        
                        x11_6 = "typeinfo name for "
                        x22_14[1] = x8_52 + 0x30
                        result = x22_14 + x8_52 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_15 = &data_40c960[0x12]
                        goto label_492d00
                    
                labelid_b:
                    result = nullptr
                case 0x11
                    *x19 = &x8_1[2]
                    void* x0_50 = sub_492f20(x19)
                    
                    if (x0_50 != 0)
                        void** x22_15 = x19[0x266]
                        x21_4 = x0_50
                        int64_t x8_54 = x22_15[1]
                        
                        if (x8_54 + 0x30 u>= 0xff0)
                            void** x0_51 = malloc(0x1000)
                            
                            if (x0_51 == 0)
                                goto label_492f1c
                            
                            x8_54 = 0
                            *x0_51 = x22_15
                            x0_51[1] = 0
                            x22_15 = x0_51
                            x19[0x266] = x0_51
                        
                        x11_6 = "VTT for "
                        x22_15[1] = x8_54 + 0x30
                        result = x22_15 + x8_54 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_15 = &data_40dfcd[8]
                        goto label_492d00
                    
                labelid_b:
                    result = nullptr
                case 0x13
                    *x19 = &x8_1[2]
                    void* x0_28 = sub_492f20(x19)
                    
                    if (x0_28 != 0)
                        void** x22_9 = x19[0x266]
                        x21_4 = x0_28
                        int64_t x8_42 = x22_9[1]
                        
                        if (x8_42 + 0x30 u>= 0xff0)
                            void** x0_29 = malloc(0x1000)
                            
                            if (x0_29 == 0)
                                goto label_492f1c
                            
                            x8_42 = 0
                            *x0_29 = x22_9
                            x0_29[1] = 0
                            x22_9 = x0_29
                            x19[0x266] = x0_29
                        
                        x11_6 = "vtable for "
                        x22_9[1] = x8_42 + 0x30
                        result = x22_9 + x8_42 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_15 = &data_40dfc1[0xb]
                        goto label_492d00
                    
                labelid_b:
                    result = nullptr
                case 0x14
                    *x19 = &x8_1[2]
                    void* x0_34 = sub_4946a0(x19, nullptr)
                    
                    if (x0_34 != 0)
                        void** x22_11 = x19[0x266]
                        x21_4 = x0_34
                        int64_t x8_46 = x22_11[1]
                        
                        if (x8_46 + 0x30 u>= 0xff0)
                            void** x0_35 = malloc(0x1000)
                            
                            if (x0_35 == 0)
                                goto label_492f1c
                            
                            x8_46 = 0
                            *x0_35 = x22_11
                            x0_35[1] = 0
                            x22_11 = x0_35
                            x19[0x266] = x0_35
                        
                        x11_6 = "thread-local wrapper routine for "
                        x22_11[1] = x8_46 + 0x30
                        result = x22_11 + x8_46 + 0x10
                        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_15 = &data_45276b[0x21]
                        goto label_492d00
                    
                labelid_b:
                    result = nullptr
                case 0x20
                    *x19 = &x8_1[2]
                    
                    if ((sub_49548c(x19) & 1) != 0)
                    labelid_b:
                        result = nullptr
                    else if ((sub_49548c(x19) & 1) != 0)
                    labelid_b:
                        result = nullptr
                    else
                        void* x0_41 = sub_4922d0(x19)
                        
                        if (x0_41 != 0)
                            void** x22_12 = x19[0x266]
                            x21_4 = x0_41
                            int64_t x8_48 = x22_12[1]
                            
                            if (x8_48 + 0x30 u>= 0xff0)
                                void** x0_42 = malloc(0x1000)
                                
                                if (x0_42 == 0)
                                    goto label_492f1c
                                
                                x8_48 = 0
                                *x0_42 = x22_12
                                x0_42[1] = 0
                                x22_12 = x0_42
                                x19[0x266] = x0_42
                            
                            x11_6 = "covariant return thunk to "
                            x22_12[1] = x8_48 + 0x30
                            result = x22_12 + x8_48 + 0x10
                            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                            x8_15 = &data_40bf22[0x1a]
                            goto label_492d00
                        
                    label_492e10:
                        result = nullptr
else
    int16_t var_80 = 0
    int32_t var_7c_1 = 0
    char var_78_1 = 0
    int64_t x8_6 = (x19[0x5b] - x19[0x5a]) s>> 3
    void* result_1 = sub_4946a0(x19, &var_80)
    result = result_1
    
    if (result_1 != 0)
        int64_t x10_6 = x19[0x5a]
        int64_t x9_3 = (x19[0x5b] - x10_6) s>> 3
        
        if (x8_6 u>= x9_3)
        label_492444:
            char* x9_5 = *x19
            int64_t x8_10 = x19[1]
            x19[0x5b] = x10_6 + (x8_6 << 3)
            
            if (x8_10 != x9_5)
                uint32_t x11_4 = zx.d(*x9_5)
                uint64_t x12_4 = zx.q(x11_4 - 0x2e)
                
                if (x12_4.d u> 0x31 || (1 << x12_4 & 0x2000000800001) == 0)
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::EnableIfAttr::VTable
                        ** x25_1 = nullptr
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                        ** var_88
                    
                    if (x8_10 - x9_5 u>= 0xd && x11_4 == 0x55)
                        if (zx.d(x9_5[1]) != 0x61 || zx.d(x9_5[2]) != 0x39 || zx.d(x9_5[3]) != 0x65
                                || zx.d(x9_5[4]) != 0x6e || zx.d(x9_5[5]) != 0x61
                                || zx.d(x9_5[6]) != 0x62 || zx.d(x9_5[7]) != 0x6c
                                || zx.d(x9_5[8]) != 0x65 || zx.d(x9_5[9]) != 0x5f
                                || zx.d(x9_5[0xa]) != 0x69 || zx.d(x9_5[0xb]) != 0x66
                                || zx.d(x9_5[0xc]) != 0x49)
                            x25_1 = nullptr
                        else
                            char* x9_6 = &x9_5[0xd]
                            *x19 = x9_6
                            int64_t x22_1 = (x19[3] - x19[2]) s>> 3
                            
                            if (x9_6 == x8_10)
                                goto label_49255c
                            
                            while (true)
                                if (zx.d(*x9_6) == 0x45)
                                    int64_t x9_43 = x19[2]
                                    int64_t x2_2 = x19[3]
                                    int64_t x22_17 = x22_1 << 3
                                    *x19 = &x9_6[1]
                                    void* x0_57
                                    int64_t x1_7
                                    x0_57, x1_7 = sub_49e548(x19, x9_43 + x22_17, x2_2)
                                    void** x23_5 = x19[0x266]
                                    x19[3] = x19[2] + x22_17
                                    int64_t x8_62 = x23_5[1]
                                    
                                    if (x8_62 + 0x20 u>= 0xff0)
                                        void** x0_58 = malloc(0x1000)
                                        
                                        if (x0_58 == 0)
                                            goto label_492f1c
                                        
                                        x8_62 = 0
                                        *x0_58 = x23_5
                                        x0_58[1] = 0
                                        x23_5 = x0_58
                                        x19[0x266] = x0_58
                                    
                                    x23_5[1] = x8_62 + 0x20
                                    x25_1 = x23_5 + x8_62 + 0x10
                                    *x25_1 = &_vtable_for_(anonymous namespace)::itanium_demangle::EnableIfAttr{for `(anonymous namespace)::itanium_demangle::Node'}
                                    x25_1[1].d = 0x1010109
                                    x25_1[2] = x0_57
                                    x25_1[3] = x1_7
                                    break
                                
                            label_49255c:
                                struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                                    ** x0_4 = sub_4951ec(x19)
                                var_88 = x0_4
                                
                                if (x0_4 == 0)
                                    goto label_492e10_2
                                
                                sub_4953d4(&x19[2], &var_88)
                                x9_6 = *x19
                                
                                if (x9_6 == x19[1])
                                    goto label_49255c
                    
                    void* x21_5 = nullptr
                    
                    if (zx.d(var_80.b) != 0 || zx.d(var_80:1.b) == 0)
                    label_4926e8:
                        char* x8_21 = *x19
                        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FunctionEncoding::VTable
                            ** result_2
                        int32_t x9_16
                        char x11_7
                        
                        if (x8_21 == x19[1] || zx.d(*x8_21) != 0x76)
                            int64_t x23_1 = (x19[3] - x19[2]) s>> 3
                            
                            while (true)
                                struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                                    ** x0_18 = sub_492f20(x19)
                                var_88 = x0_18
                                
                                if (x0_18 == 0)
                                    goto label_492e10_2
                                
                                sub_4953d4(&x19[2], &var_88)
                                void* x8_27 = *x19
                                
                                if (x19[1] == x8_27)
                                    break
                                
                                uint64_t x8_29 = zx.q(zx.d(*x8_27) - 0x2e)
                                
                                if (x8_29.d u<= 0x31)
                                    if ((1 << x8_29 & 0x2000000800001) != 0)
                                        break
                            
                            int64_t x23_2 = x23_1 << 3
                            void* x0_21
                            int64_t x1_5
                            x0_21, x1_5 = sub_49e548(x19, x19[2] + x23_2, x19[3])
                            void** x26_1 = x19[0x266]
                            x19[3] = x19[2] + x23_2
                            int64_t x8_34 = x26_1[1]
                            
                            if (x8_34 + 0x40 u>= 0xff0)
                                void** x0_22 = malloc(0x1000)
                                
                                if (x0_22 == 0)
                                    goto label_492f1c
                                
                                x8_34 = 0
                                *x0_22 = x26_1
                                x0_22[1] = 0
                                x26_1 = x0_22
                                x19[0x266] = x0_22
                            
                            x26_1[1] = x8_34 + 0x40
                            x9_16 = var_7c_1
                            x11_7 = var_78_1
                            result_2 = x26_1 + x8_34 + 0x10
                            *result_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::FunctionEncoding{for `(anonymous namespace)::itanium_demangle::Node'}
                            result_2[1].d = 0x10012
                            result_2[2] = x21_5
                            result_2[3] = result
                            result_2[4] = x0_21
                            result_2[5] = x1_5
                        else
                            void** x22_4 = x19[0x266]
                            *x19 = &x8_21[1]
                            int64_t x8_23 = x22_4[1]
                            
                            if (x8_23 + 0x40 u>= 0xff0)
                                void** x0_16 = malloc(0x1000)
                                
                                if (x0_16 == 0)
                                    goto label_492f1c
                                
                                x8_23 = 0
                                *x0_16 = x22_4
                                x0_16[1] = 0
                                x22_4 = x0_16
                                x19[0x266] = x0_16
                            
                            x22_4[1] = x8_23 + 0x40
                            x9_16 = var_7c_1
                            x11_7 = var_78_1
                            result_2 = x22_4 + x8_23 + 0x10
                            *result_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::FunctionEncoding{for `(anonymous namespace)::itanium_demangle::Node'}
                            result_2[1].d = 0x10012
                            result_2[2] = x21_5
                            result_2[3] = result
                            result_2[4] = 0
                            result_2[5] = 0
                        
                        result = result_2
                        result_2[6] = x25_1
                        result_2[7].d = x9_16
                        *(result_2 + 0x3c) = x11_7
                    else
                        void* x0_15 = sub_492f20(x19)
                        x21_5 = x0_15
                        
                        if (x0_15 != 0)
                            goto label_4926e8
                        
                    label_492e10_1:
                        result = nullptr
        else
            int64_t* x8_9 = x19[0x53]
            
            if (x8_9 != x19[0x54])
                int64_t x9_4 = x9_3 - x8_6
                int64_t* x12_3 = x10_6 + (x8_6 << 3)
                
                while (true)
                    int64_t* x14_1 = *x8_9
                    
                    if (x14_1 == 0)
                        break
                    
                    void* x13_2 = *x12_3
                    int64_t x14_2 = *x14_1
                    int64_t x15_1 = *(x13_2 + 0x10)
                    
                    if (x15_1 u>= (x14_1[1] - x14_2) s>> 3)
                        break
                    
                    int64_t temp1_1 = x9_4
                    x9_4 -= 1
                    x12_3 = &x12_3[1]
                    *(x13_2 + 0x18) = *(x14_2 + (x15_1 << 3))
                    
                    if (temp1_1 == 1)
                        goto label_492444
            
        label_492e10_2:
            result = nullptr

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
