// 函数: sub_49d468
// 地址: 0x49d468
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t x8_1 = arg2[1]
int64_t x10 = arg2[2]
size_t bytes_36 = x8_1 + 1
char* x0

if (bytes_36 u>= x10)
    int64_t oldmem = *arg2
    size_t bytes_18 = x10 << 1
    size_t bytes
    
    bytes = bytes_18 u< bytes_36 ? bytes_36 : bytes_18
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8_1 = arg2[1]
        bytes_36 = x8_1 + 1
        goto label_49d4dc
else
    x0 = *arg2
label_49d4dc:
    arg2[1] = bytes_36
    x0[x8_1] = 0x28
    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ParameterPackExpansion::VTable
        * const var_60
    
    if (zx.d(*(arg1 + 0x30)) == 0)
        int64_t x8_8 = arg2[1]
        int64_t x10_2 = arg2[2]
        size_t bytes_38 = x8_8 + 1
        char* x0_4
        
        if (bytes_38 u>= x10_2)
            int64_t oldmem_2 = *arg2
            size_t bytes_20 = x10_2 << 1
            size_t bytes_2
            
            bytes_2 = bytes_20 u< bytes_38 ? bytes_38 : bytes_20
            
            arg2[2] = bytes_2
            x0_4 = realloc(oldmem_2, bytes_2)
            *arg2 = x0_4
            
            if (x0_4 != 0)
                x8_8 = arg2[1]
                bytes_38 = x8_8 + 1
                goto label_49d5e0
        else
            x0_4 = *arg2
        label_49d5e0:
            arg2[1] = bytes_38
            x0_4[x8_8] = 0x28
            int64_t x8_11 = *(arg1 + 0x10)
            int16_t var_58_1 = 0x122
            var_60 = &_vtable_for_(anonymous namespace)::itanium_demangle::ParameterPackExpansion{for `(anonymous namespace)::itanium_demangle::Node'}
            int64_t var_50_1 = x8_11
            sub_49dbc4(&var_60, arg2)
            
            if (zx.d(var_58_1:1.b) != 1)
                var_60->vFunc_5(&var_60, arg2)
            
            int64_t x8_15 = arg2[1]
            int64_t x10_4 = arg2[2]
            size_t bytes_40 = x8_15 + 1
            char* x0_8
            
            if (bytes_40 u>= x10_4)
                int64_t oldmem_3 = *arg2
                size_t bytes_21 = x10_4 << 1
                size_t bytes_3
                
                bytes_3 = bytes_21 u< bytes_40 ? bytes_40 : bytes_21
                
                arg2[2] = bytes_3
                x0_8 = realloc(oldmem_3, bytes_3)
                *arg2 = x0_8
                
                if (x0_8 != 0)
                    x8_15 = arg2[1]
                    bytes_40 = x8_15 + 1
                    goto label_49d678
            else
                x0_8 = *arg2
            label_49d678:
                arg2[1] = bytes_40
                x0_8[x8_15] = 0x29
                int64_t x8_16 = arg2[1]
                int64_t x10_5 = arg2[2]
                size_t bytes_41 = x8_16 + 1
                char* x0_9
                
                if (bytes_41 u>= x10_5)
                    int64_t oldmem_4 = *arg2
                    size_t bytes_22 = x10_5 << 1
                    size_t bytes_4
                    
                    bytes_4 = bytes_22 u< bytes_41 ? bytes_41 : bytes_22
                    
                    arg2[2] = bytes_4
                    x0_9 = realloc(oldmem_4, bytes_4)
                    *arg2 = x0_9
                    
                    if (x0_9 != 0)
                        x8_16 = arg2[1]
                        bytes_41 = x8_16 + 1
                        goto label_49d6c4
                else
                    x0_9 = *arg2
                label_49d6c4:
                    arg2[1] = bytes_41
                    x0_9[x8_16] = 0x20
                    int64_t x22_2 = *(arg1 + 0x20)
                    int64_t x9_1 = *(arg1 + 0x28)
                    int64_t x8_17 = arg2[1]
                    size_t x21_3 = x9_1 - x22_2
                    
                    if (x9_1 == x22_2)
                        goto label_49da20
                    
                    int64_t x10_6 = arg2[2]
                    int64_t bytes_42 = x8_17 + x21_3
                    int64_t x0_10
                    
                    if (bytes_42 u>= x10_6)
                        int64_t oldmem_13 = *arg2
                        int64_t bytes_31 = x10_6 << 1
                        int64_t bytes_13
                        
                        bytes_13 = bytes_31 u< bytes_42 ? bytes_42 : bytes_31
                        
                        arg2[2] = bytes_13
                        x0_10 = realloc(oldmem_13, bytes_13)
                        *arg2 = x0_10
                        
                        if (x0_10 != 0)
                            x8_17 = arg2[1]
                            goto label_49da10
                    else
                        x0_10 = *arg2
                    label_49da10:
                        memmove(x0_10 + x8_17, x22_2, x21_3)
                        x8_17 = arg2[1] + x21_3
                        arg2[1] = x8_17
                    label_49da20:
                        int64_t x10_14 = arg2[2]
                        int64_t x0_22
                        
                        if (x8_17 + 4 u>= x10_14)
                            int64_t oldmem_14 = *arg2
                            int64_t bytes_32 = x10_14 << 1
                            int64_t bytes_14
                            
                            if (bytes_32 u< x8_17 + 4)
                                bytes_14 = x8_17 + 4
                            else
                                bytes_14 = bytes_32
                            
                            arg2[2] = bytes_14
                            x0_22 = realloc(oldmem_14, bytes_14)
                            *arg2 = x0_22
                            
                            if (x0_22 != 0)
                                x8_17 = arg2[1]
                                goto label_49da64
                        else
                            x0_22 = *arg2
                        label_49da64:
                            __builtin_strncpy(x0_22 + x8_17, " ...", 4)
                            int64_t x9_6 = arg2[1]
                            int64_t x8_32 = x9_6 + 4
                            arg2[1] = x8_32
                            
                            if (*(arg1 + 0x18) == 0)
                                goto label_49d96c
                            
                            int64_t x10_16 = arg2[2]
                            size_t bytes_49 = x9_6 + 5
                            char* x0_23
                            
                            if (bytes_49 u>= x10_16)
                                int64_t oldmem_15 = *arg2
                                size_t bytes_33 = x10_16 << 1
                                size_t bytes_15
                                
                                bytes_15 = bytes_33 u< bytes_49 ? bytes_49 : bytes_33
                                
                                arg2[2] = bytes_15
                                x0_23 = realloc(oldmem_15, bytes_15)
                                *arg2 = x0_23
                                
                                if (x0_23 != 0)
                                    x8_32 = arg2[1]
                                    bytes_49 = x8_32 + 1
                                    goto label_49dabc
                            else
                                x0_23 = *arg2
                            label_49dabc:
                                arg2[1] = bytes_49
                                x0_23[x8_32] = 0x20
                                int64_t x22_4 = *(arg1 + 0x20)
                                int64_t x9_7 = *(arg1 + 0x28)
                                int64_t x8_33 = arg2[1]
                                size_t x21_5 = x9_7 - x22_4
                                
                                if (x9_7 == x22_4)
                                    goto label_49db30
                                
                                int64_t x10_17 = arg2[2]
                                int64_t bytes_50 = x8_33 + x21_5
                                int64_t x0_24
                                
                                if (bytes_50 u>= x10_17)
                                    int64_t oldmem_16 = *arg2
                                    int64_t bytes_34 = x10_17 << 1
                                    int64_t bytes_16
                                    
                                    bytes_16 = bytes_34 u< bytes_50 ? bytes_50 : bytes_34
                                    
                                    arg2[2] = bytes_16
                                    x0_24 = realloc(oldmem_16, bytes_16)
                                    *arg2 = x0_24
                                    
                                    if (x0_24 != 0)
                                        x8_33 = arg2[1]
                                        goto label_49db20
                                else
                                    x0_24 = *arg2
                                label_49db20:
                                    memmove(x0_24 + x8_33, x22_4, x21_5)
                                    x8_33 = arg2[1] + x21_5
                                    arg2[1] = x8_33
                                label_49db30:
                                    int64_t x10_18 = arg2[2]
                                    int64_t bytes_51 = x8_33 + 1
                                    char* x0_26
                                    
                                    if (bytes_51 u< x10_18)
                                        x0_26 = *arg2
                                    label_49db70:
                                        arg2[1] = bytes_51
                                        x0_26[x8_33] = 0x20
                                        int64_t* x20_1 = *(arg1 + 0x18)
                                        (*(*x20_1 + 0x20))(x20_1, arg2)
                                        
                                        if (zx.d(*(x20_1 + 9)) != 1)
                                            (*(*x20_1 + 0x28))(x20_1, arg2)
                                        
                                        goto label_49d96c
                                    
                                    int64_t oldmem_17 = *arg2
                                    int64_t bytes_35 = x10_18 << 1
                                    int64_t bytes_17
                                    
                                    bytes_17 = bytes_35 u< bytes_51 ? bytes_51 : bytes_35
                                    
                                    arg2[2] = bytes_17
                                    x0_26 = realloc(oldmem_17, bytes_17)
                                    *arg2 = x0_26
                                    
                                    if (x0_26 != 0)
                                        x8_33 = arg2[1]
                                        bytes_51 = x8_33 + 1
                                        goto label_49db70
    else
        int64_t* x21_1 = *(arg1 + 0x18)
        
        if (x21_1 == 0)
            goto label_49d784
        
        (*(*x21_1 + 0x20))(x21_1, arg2)
        
        if (zx.d(*(x21_1 + 9)) != 1)
            (*(*x21_1 + 0x28))(x21_1, arg2)
        
        int64_t x8_9 = arg2[1]
        int64_t x10_1 = arg2[2]
        size_t bytes_37 = x8_9 + 1
        char* x0_3
        
        if (bytes_37 u>= x10_1)
            int64_t oldmem_1 = *arg2
            size_t bytes_19 = x10_1 << 1
            size_t bytes_1
            
            bytes_1 = bytes_19 u< bytes_37 ? bytes_37 : bytes_19
            
            arg2[2] = bytes_1
            x0_3 = realloc(oldmem_1, bytes_1)
            *arg2 = x0_3
            
            if (x0_3 != 0)
                x8_9 = arg2[1]
                bytes_37 = x8_9 + 1
                goto label_49d584
        else
            x0_3 = *arg2
        label_49d584:
            arg2[1] = bytes_37
            x0_3[x8_9] = 0x20
            int64_t x22_1 = *(arg1 + 0x20)
            int64_t x9 = *(arg1 + 0x28)
            int64_t x8_10 = arg2[1]
            size_t x21_2 = x9 - x22_1
            
            if (x9 == x22_1)
                goto label_49d738
            
            int64_t x10_3 = arg2[2]
            int64_t bytes_39 = x8_10 + x21_2
            int64_t x0_5
            
            if (bytes_39 u>= x10_3)
                int64_t oldmem_5 = *arg2
                int64_t bytes_23 = x10_3 << 1
                int64_t bytes_5
                
                bytes_5 = bytes_23 u< bytes_39 ? bytes_39 : bytes_23
                
                arg2[2] = bytes_5
                x0_5 = realloc(oldmem_5, bytes_5)
                *arg2 = x0_5
                
                if (x0_5 != 0)
                    x8_10 = arg2[1]
                    goto label_49d728
            else
                x0_5 = *arg2
            label_49d728:
                memmove(x0_5 + x8_10, x22_1, x21_2)
                x8_10 = arg2[1] + x21_2
                arg2[1] = x8_10
            label_49d738:
                int64_t x10_7 = arg2[2]
                size_t bytes_43 = x8_10 + 1
                char* x0_12
                
                if (bytes_43 u>= x10_7)
                    int64_t oldmem_6 = *arg2
                    size_t bytes_24 = x10_7 << 1
                    size_t bytes_6
                    
                    bytes_6 = bytes_24 u< bytes_43 ? bytes_43 : bytes_24
                    
                    arg2[2] = bytes_6
                    x0_12 = realloc(oldmem_6, bytes_6)
                    *arg2 = x0_12
                    
                    if (x0_12 != 0)
                        x8_10 = arg2[1]
                        bytes_43 = x8_10 + 1
                        goto label_49d778
                else
                    x0_12 = *arg2
                label_49d778:
                    arg2[1] = bytes_43
                    x0_12[x8_10] = 0x20
                label_49d784:
                    int64_t x8_19 = arg2[1]
                    int64_t x10_8 = arg2[2]
                    int64_t x0_13
                    
                    if (x8_19 + 4 u>= x10_8)
                        int64_t oldmem_7 = *arg2
                        int64_t bytes_25 = x10_8 << 1
                        int64_t bytes_7
                        
                        if (bytes_25 u< x8_19 + 4)
                            bytes_7 = x8_19 + 4
                        else
                            bytes_7 = bytes_25
                        
                        arg2[2] = bytes_7
                        x0_13 = realloc(oldmem_7, bytes_7)
                        *arg2 = x0_13
                        
                        if (x0_13 != 0)
                            x8_19 = arg2[1]
                            goto label_49d7c8
                    else
                        x0_13 = *arg2
                    label_49d7c8:
                        __builtin_strncpy(x0_13 + x8_19, "... ", 4)
                        int64_t x8_21 = arg2[1] + 4
                        arg2[1] = x8_21
                        int64_t x22_3 = *(arg1 + 0x20)
                        int64_t x9_3 = *(arg1 + 0x28)
                        size_t x21_4 = x9_3 - x22_3
                        
                        if (x9_3 == x22_3)
                            goto label_49d83c
                        
                        int64_t x10_9 = arg2[2]
                        int64_t bytes_44 = x8_21 + x21_4
                        int64_t x0_14
                        
                        if (bytes_44 u>= x10_9)
                            int64_t oldmem_8 = *arg2
                            int64_t bytes_26 = x10_9 << 1
                            int64_t bytes_8
                            
                            bytes_8 = bytes_26 u< bytes_44 ? bytes_44 : bytes_26
                            
                            arg2[2] = bytes_8
                            x0_14 = realloc(oldmem_8, bytes_8)
                            *arg2 = x0_14
                            
                            if (x0_14 != 0)
                                x8_21 = arg2[1]
                                goto label_49d82c
                        else
                            x0_14 = *arg2
                        label_49d82c:
                            memmove(x0_14 + x8_21, x22_3, x21_4)
                            x8_21 = arg2[1] + x21_4
                            arg2[1] = x8_21
                        label_49d83c:
                            int64_t x10_10 = arg2[2]
                            size_t bytes_45 = x8_21 + 1
                            char* x0_16
                            
                            if (bytes_45 u>= x10_10)
                                int64_t oldmem_9 = *arg2
                                size_t bytes_27 = x10_10 << 1
                                size_t bytes_9
                                
                                bytes_9 = bytes_27 u< bytes_45 ? bytes_45 : bytes_27
                                
                                arg2[2] = bytes_9
                                x0_16 = realloc(oldmem_9, bytes_9)
                                *arg2 = x0_16
                                
                                if (x0_16 != 0)
                                    x8_21 = arg2[1]
                                    bytes_45 = x8_21 + 1
                                    goto label_49d87c
                            else
                                x0_16 = *arg2
                            label_49d87c:
                                arg2[1] = bytes_45
                                x0_16[x8_21] = 0x20
                                int64_t x8_23 = arg2[1]
                                int64_t x10_11 = arg2[2]
                                size_t bytes_46 = x8_23 + 1
                                char* x0_17
                                
                                if (bytes_46 u>= x10_11)
                                    int64_t oldmem_10 = *arg2
                                    size_t bytes_28 = x10_11 << 1
                                    size_t bytes_10
                                    
                                    bytes_10 = bytes_28 u< bytes_46 ? bytes_46 : bytes_28
                                    
                                    arg2[2] = bytes_10
                                    x0_17 = realloc(oldmem_10, bytes_10)
                                    *arg2 = x0_17
                                    
                                    if (x0_17 != 0)
                                        x8_23 = arg2[1]
                                        bytes_46 = x8_23 + 1
                                        goto label_49d8c8
                                else
                                    x0_17 = *arg2
                                label_49d8c8:
                                    arg2[1] = bytes_46
                                    x0_17[x8_23] = 0x28
                                    int64_t x8_24 = *(arg1 + 0x10)
                                    int16_t var_58_2 = 0x122
                                    var_60 = &_vtable_for_(anonymous namespace)::itanium_demangle::ParameterPackExpansion{for `(anonymous namespace)::itanium_demangle::Node'}
                                    int64_t var_50_2 = x8_24
                                    sub_49dbc4(&var_60, arg2)
                                    
                                    if (zx.d(var_58_2:1.b) != 1)
                                        var_60->vFunc_5(&var_60, arg2)
                                    
                                    int64_t x8_28 = arg2[1]
                                    int64_t x10_12 = arg2[2]
                                    size_t bytes_47 = x8_28 + 1
                                    char* x0_20
                                    
                                    if (bytes_47 u>= x10_12)
                                        int64_t oldmem_11 = *arg2
                                        size_t bytes_29 = x10_12 << 1
                                        size_t bytes_11
                                        
                                        bytes_11 = bytes_29 u< bytes_47 ? bytes_47 : bytes_29
                                        
                                        arg2[2] = bytes_11
                                        x0_20 = realloc(oldmem_11, bytes_11)
                                        *arg2 = x0_20
                                        
                                        if (x0_20 != 0)
                                            x8_28 = arg2[1]
                                            bytes_47 = x8_28 + 1
                                            goto label_49d960
                                    else
                                        x0_20 = *arg2
                                    label_49d960:
                                        arg2[1] = bytes_47
                                        x0_20[x8_28] = 0x29
                                    label_49d96c:
                                        int64_t x8_29 = arg2[1]
                                        int64_t x10_13 = arg2[2]
                                        size_t bytes_48 = x8_29 + 1
                                        char* result
                                        
                                        if (bytes_48 u< x10_13)
                                            result = *arg2
                                        label_49d9ac:
                                            arg2[1] = bytes_48
                                            result[x8_29] = 0x29
                                            
                                            if (*(x23 + 0x28) == x8)
                                                return result
                                            
                                            __stack_chk_fail()
                                            noreturn
                                        
                                        int64_t oldmem_12 = *arg2
                                        int64_t bytes_30 = x10_13 << 1
                                        size_t bytes_12
                                        
                                        bytes_12 = bytes_30 u< bytes_48 ? bytes_48 : bytes_30
                                        
                                        arg2[2] = bytes_12
                                        result = realloc(oldmem_12, bytes_12)
                                        *arg2 = result
                                        
                                        if (result != 0)
                                            x8_29 = arg2[1]
                                            bytes_48 = x8_29 + 1
                                            goto label_49d9ac
sub_491944()
noreturn
