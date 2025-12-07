// 函数: sub_49bf80
// 地址: 0x49bf80
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t var_58 = *(x22 + 0x28)
char* x8_1 = *arg1
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::TemplateTemplateParamDecl::VTable
    ** result

if (arg1[1] - x8_1 u< 2 || zx.d(*x8_1) != 0x54)
    result = nullptr
else
    void* var_c0
    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::TemplateTemplateParamDecl::VTable
        * x8_7
    int64_t x9_7
    int16_t x10_1
    void* x19_2
    void* x20_2
    void** x21_2
    
    if (zx.d(x8_1[1]) == 0x79)
        int32_t x21_1 = arg1[0x63].d
        void** x23_1 = arg1[0x266]
        *arg1 = &x8_1[2]
        arg1[0x63].d = x21_1 + 1
        int64_t x8_4 = x23_1[1]
        
        if (x8_4 + 0x20 u> 0xfef)
            void** x0 = malloc(0x1000)
            
            if (x0 == 0)
                sub_491944()
                noreturn
            
            x8_4 = 0
            *x0 = x23_1
            x0[1] = 0
            x23_1 = x0
            arg1[0x266] = x0
        
        x23_1[1] = x8_4 + 0x20
        x20_2 = x23_1 + x8_4 + 0x10
        *x20_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::SyntheticTemplateParamName{for `(anonymous namespace)::itanium_demangle::Node'}
        *(x20_2 + 8) = 0x101011b
        *(x20_2 + 0x10) = x21_1
        var_c0 = x20_2
        sub_49c60c(*(arg1[0x54] - 8), &var_c0)
        x21_2 = arg1[0x266]
        int64_t x8_6 = x21_2[1]
        
        if (x8_6 + 0x20 u>= 0xff0)
            void*** x0_2 = malloc(0x1000)
            
            if (x0_2 == 0)
                sub_491944()
                noreturn
            
            x8_6 = 0
            *x0_2 = x21_2
            x0_2[1] = 0
            x21_2 = x0_2
            arg1[0x266] = x0_2
        
        x9_7 = x8_6 + 0x20
        x19_2 = x21_2 + x8_6
        x10_1 = 0x1c
        x8_7 = &_vtable_for_(anonymous namespace)::itanium_demangle::TypeTemplateParamDecl{for `(anonymous namespace)::itanium_demangle::Node'}
    label_49c09c:
        x21_2[1] = x9_7
        result = x19_2 + 0x10
        *result = x8_7
        result[1].d = zx.d(x10_1) | 0x1010000
        result[2] = x20_2
    else if (zx.d(*x8_1) != 0x54)
        result = nullptr
    else if (zx.d(x8_1[1]) == 0x6e)
        int32_t x20_3 = *(arg1 + 0x31c)
        void** x23_2 = arg1[0x266]
        *arg1 = &x8_1[2]
        *(arg1 + 0x31c) = x20_3 + 1
        int64_t x8_10 = x23_2[1]
        
        if (x8_10 + 0x20 u> 0xfef)
            void** x0_3 = malloc(0x1000)
            
            if (x0_3 == 0)
                sub_491944()
                noreturn
            
            x8_10 = 0
            *x0_3 = x23_2
            x0_3[1] = 0
            x23_2 = x0_3
            arg1[0x266] = x0_3
        
        x23_2[1] = x8_10 + 0x20
        *(x23_2 + x8_10 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::SyntheticTemplateParamName{for `(anonymous namespace)::itanium_demangle::Node'}
        *(x23_2 + x8_10 + 0x18) = 0x10101011b
        *(x23_2 + x8_10 + 0x20) = x20_3
        var_c0 = x23_2 + x8_10 + 0x10
        sub_49c60c(*(arg1[0x54] - 8), &var_c0)
        void* x0_6 = sub_492f20(arg1)
        
        if (x0_6 == 0)
            result = nullptr
        else
            void** x23_3 = arg1[0x266]
            int64_t x8_12 = x23_3[1]
            
            if (x8_12 + 0x20 u>= 0xff0)
                void** x0_7 = malloc(0x1000)
                
                if (x0_7 == 0)
                    sub_491944()
                    noreturn
                
                x8_12 = 0
                *x0_7 = x23_3
                x0_7[1] = 0
                x23_3 = x0_7
                arg1[0x266] = x0_7
            
            x23_3[1] = x8_12 + 0x20
            result = x23_3 + x8_12 + 0x10
            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NonTypeTemplateParamDecl{for `(anonymous namespace)::itanium_demangle::Node'}
            result[1].d = 0x101001d
            result[2] = x23_2 + x8_10 + 0x10
            result[3] = x0_6
    else if (zx.d(*x8_1) != 0x54)
        result = nullptr
    else if (zx.d(x8_1[1]) == 0x74)
        int32_t x20_5 = arg1[0x64].d
        void** x21_5 = arg1[0x266]
        *arg1 = &x8_1[2]
        arg1[0x64].d = x20_5 + 1
        int64_t x8_15 = x21_5[1]
        
        if (x8_15 + 0x20 u> 0xfef)
            void** x0_8 = malloc(0x1000)
            
            if (x0_8 == 0)
                sub_491944()
                noreturn
            
            x8_15 = 0
            *x0_8 = x21_5
            x0_8[1] = 0
            x21_5 = x0_8
            arg1[0x266] = x0_8
        
        x21_5[1] = x8_15 + 0x20
        *(x21_5 + x8_15 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::SyntheticTemplateParamName{for `(anonymous namespace)::itanium_demangle::Node'}
        *(x21_5 + x8_15 + 0x18) = 0x20101011b
        *(x21_5 + x8_15 + 0x20) = x20_5
        var_c0 = x21_5 + x8_15 + 0x10
        sub_49c60c(*(arg1[0x54] - 8), &var_c0)
        int128_t var_98
        int128_t* var_a8_1 = &var_98
        int64_t* var_a0_1 = &var_58
        int64_t x25_1 = (arg1[3] - arg1[2]) s>> 3
        int64_t x8_18 = (arg1[0x54] - arg1[0x53]) s>> 3
        __builtin_memset(&var_98, 0, 0x40)
        var_c0 = arg1
        int128_t* var_b0 = &var_98
        int128_t** var_c8 = &var_b0
        sub_496d90(&arg1[0x53], &var_c8)
        int64_t i_2
        char* x8_19
        
        while (true)
            i_2 = __strlen_chk(&data_4525ea, 2)
            x8_19 = *arg1
            
            if (i_2 u<= arg1[1] - x8_19)
                break
            
        label_49c2e4:
            int128_t** x0_12 = sub_49bf80(arg1)
            var_c8 = x0_12
            
            if (x0_12 == 0)
                result = nullptr
                goto label_49c3bc
            
            sub_4953d4(&arg1[2], &var_c8)
        
        if (i_2 != 0)
            int64_t i_1 = i_2
            char* x10_4 = x8_19
            void* const x11_2 = &data_4525ea
            int64_t i
            
            do
                if (zx.d(*x11_2) != zx.d(*x10_4))
                    goto label_49c2e4
                
                x11_2 += 1
                i = i_1
                i_1 -= 1
                x10_4 = &x10_4[1]
            while (i != 1)
        
        int64_t x2_1 = arg1[3]
        int64_t x21_7 = x25_1 << 3
        int64_t x1_6 = arg1[2] + x21_7
        *arg1 = &x8_19[i_2]
        void* x0_15
        int64_t x1_7
        x0_15, x1_7 = sub_49e548(arg1, x1_6, x2_1)
        void** x25_2 = arg1[0x266]
        arg1[3] = arg1[2] + x21_7
        int64_t x8_23 = x25_2[1]
        
        if (x8_23 + 0x30 u>= 0xff0)
            void** x0_16 = malloc(0x1000)
            
            if (x0_16 == 0)
                sub_491944()
                noreturn
            
            x8_23 = 0
            *x0_16 = x25_2
            x0_16[1] = 0
            x25_2 = x0_16
            arg1[0x266] = x0_16
        
        x25_2[1] = x8_23 + 0x30
        result = x25_2 + x8_23 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::TemplateTemplateParamDecl{for `(anonymous namespace)::itanium_demangle::Node'}
        result[1].d = 0x101001e
        result[2] = x21_5 + x8_15 + 0x10
        result[3] = x0_15
        result[4] = x1_7
    label_49c3bc:
        void* x8_24 = var_c0
        *(x8_24 + 0x2a0) = *(x8_24 + 0x298) + (x8_18 << 3)
        int128_t* x0_17 = var_b0
        
        if (x0_17 != &var_98)
            free(x0_17)
    else if (zx.d(*x8_1) != 0x54 || zx.d(x8_1[1]) != 0x70)
        result = nullptr
    else
        *arg1 = &x8_1[2]
        void* x0_19 = sub_49bf80(arg1)
        
        if (x0_19 != 0)
            x21_2 = arg1[0x266]
            x20_2 = x0_19
            int64_t x8_26 = x21_2[1]
            
            if (x8_26 + 0x20 u>= 0xff0)
                void** x0_20 = malloc(0x1000)
                
                if (x0_20 == 0)
                    sub_491944()
                    noreturn
                
                x8_26 = 0
                *x0_20 = x21_2
                x0_20[1] = 0
                x21_2 = x0_20
                arg1[0x266] = x0_20
            
            x9_7 = x8_26 + 0x20
            x19_2 = x21_2 + x8_26
            x10_1 = 0x1f
            x8_7 = &_vtable_for_(anonymous namespace)::itanium_demangle::TemplateParamPackDecl{for `(anonymous namespace)::itanium_demangle::Node'}
            goto label_49c09c
        
        result = nullptr

if (*(x22 + 0x28) == var_58)
    return result

__stack_chk_fail()
noreturn
