// 函数: sub_49ad48
// 地址: 0x49ad48
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x25 = _ReadMSR(tpidr_el0)
int64_t var_68 = *(x25 + 0x28)

if (arg2 != 0)
    arg1[0x54] = arg1[0x53]

char* x10 = *arg1
void* x8_2 = arg1[1]
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ClosureTypeName::VTable
    ** result

if (x8_2 - x10 u< 2 || zx.d(*x10) != 0x55)
    result = nullptr
else if (zx.d(x10[1]) == 0x74)
    void* x9_3 = &x10[2]
    *arg1 = x9_3
    void* x20_1
    void* x21_1
    
    if (x8_2 == x9_3 || zx.d(*x9_3) - 0x30 u> 9)
        x20_1 = nullptr
        x21_1 = nullptr
    else
        void* x11_3 = &x10[3]
        
        while (true)
            void* x10_2 = x11_3
            *arg1 = x11_3
            
            if (x8_2 == x11_3)
                x20_1 = x9_3
                x9_3 = x10_2
                x21_1 = x8_2
                break
            
            x11_3 = x10_2 + 1
            
            if (zx.d(*x10_2) - 0x30 u>= 0xa)
                x20_1 = x9_3
                x21_1 = x11_3 - 1
                x9_3 = x10_2
                break
    
    if (x9_3 == x8_2 || zx.d(*x9_3) != 0x5f)
        result = nullptr
    else
        void** x22_1 = arg1[0x266]
        *arg1 = x9_3 + 1
        int64_t x8_5 = x22_1[1]
        
        if (x8_5 + 0x20 u>= 0xff0)
            void** x0 = malloc(0x1000)
            
            if (x0 == 0)
                sub_491944()
                noreturn
            
            x8_5 = 0
            *x0 = x22_1
            x0[1] = 0
            x22_1 = x0
            arg1[0x266] = x0
        
        x22_1[1] = x8_5 + 0x20
        result = x22_1 + x8_5 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::UnnamedTypeName{for `(anonymous namespace)::itanium_demangle::Node'}
        result[1].d = 0x101012c
        result[2] = x20_1
        result[3] = x21_1
else if (zx.d(*x10) != 0x55)
    result = nullptr
else if (zx.d(x10[1]) == 0x6c)
    int64_t x9_8 = arg1[0x54]
    int64_t x10_1 = arg1[0x53]
    int64_t x26_1 = arg1[0x62]
    *arg1 = &x10[2]
    int64_t x9_10 = (x9_8 - x10_1) s>> 3
    arg1[0x62] = x9_10
    int128_t var_a8
    int128_t* var_c0 = &var_a8
    int128_t* var_b8_1 = &var_a8
    int64_t* var_b0_1 = &var_68
    __builtin_memset(&var_a8, 0, 0x40)
    int128_t** var_d8 = &var_c0
    sub_496d90(&arg1[0x53], &var_d8)
    int64_t x21_2 = arg1[2]
    char* x8_7 = *arg1
    int64_t x23_1 = arg1[3]
    int64_t x2_1
    int64_t x8_8
    
    if (arg1[1] != x8_7)
        while (true)
            if (zx.d(*x8_7) == 0x54)
                size_t x0_4 = __strlen_chk("yptn", 5)
                void* x8_14 = *arg1
                uint32_t x1_1
                
                if (arg1[1] - x8_14 u< 2)
                    x1_1 = 0
                else
                    x1_1 = zx.d(*(x8_14 + 1))
                
                if (x0_4 != 0)
                    int64_t x0_5 = memchr("yptn", x1_1, x0_4)
                    
                    if (x0_5 != 0 && x0_5 != &data_40f1c8[2])
                        int128_t** x0_7 = sub_49bf80(arg1)
                        var_d8 = x0_7
                        
                        if (x0_7 == 0)
                            break
                        
                        sub_4953d4(&arg1[2], &var_d8)
                        x8_7 = *arg1
                        
                        if (arg1[1] != x8_7)
                            continue
            
            x8_8 = arg1[2]
            x2_1 = arg1[3]
            goto label_49b0dc
        
    label_49b27c:
        result = nullptr
    else
        x2_1 = x23_1
        x8_8 = x21_2
    label_49b0dc:
        int64_t x24_3 = (x23_1 - x21_2) s>> 3 << 3
        void* x0_10
        int64_t x1_4
        x0_10, x1_4 = sub_49e548(arg1, x8_8 + x24_3, x2_1)
        arg1[3] = arg1[2] + x24_3
        
        if (x1_4 == 0)
            arg1[0x54] -= 8
        
        int64_t x0_11 = __strlen_chk("vE", 3)
        void* x8_20 = *arg1
        void* x8_22
        
        if (x0_11 u<= arg1[1] - x8_20)
            if (x0_11 != 0)
                char* const x9_27 = "vE"
                int64_t x10_5 = x0_11
                void* x11_9 = x8_20
                
                while (zx.d(*x9_27) == zx.d(*x11_9))
                    x9_27 = &x9_27[1]
                    int64_t temp0_1 = x10_5
                    x10_5 -= 1
                    x11_9 += 1
                    
                    if (temp0_1 == 1)
                        goto label_49b1a0
                
                goto label_49b134
            
        label_49b1a0:
            x8_22 = x8_20 + x0_11
        else
        label_49b134:
            
            while (true)
                int128_t** x0_13 = sub_492f20(arg1)
                var_d8 = x0_13
                
                if (x0_13 == 0)
                    goto label_49b27c_1
                
                sub_4953d4(&arg1[2], &var_d8)
                char* x8_21 = *arg1
                
                if (x8_21 != arg1[1])
                    if (zx.d(*x8_21) == 0x45)
                        x8_22 = &x8_21[1]
                        break
        
        int64_t x9_28 = arg1[2]
        int64_t x2_3 = arg1[3]
        *arg1 = x8_22
        void* x0_16
        int64_t x1_7
        x0_16, x1_7 = sub_49e548(arg1, x9_28 + x24_3, x2_3)
        void* x9_29 = arg1[1]
        char* x8_23 = *arg1
        arg1[3] = arg1[2] + x24_3
        void* x22_4
        char* x28_1
        
        if (x9_29 == x8_23 || zx.d(*x8_23) - 0x30 u> 9)
            x28_1 = nullptr
            x22_4 = nullptr
        else
            void* x11_10 = &x8_23[1]
            
            while (true)
                void* x10_11 = x11_10
                *arg1 = x11_10
                
                if (x9_29 == x11_10)
                    x28_1 = x8_23
                    x8_23 = x10_11
                    x22_4 = x9_29
                    break
                
                x11_10 = x10_11 + 1
                
                if (zx.d(*x10_11) - 0x30 u>= 0xa)
                    x28_1 = x8_23
                    x22_4 = x11_10 - 1
                    x8_23 = x10_11
                    break
        
        if (x8_23 == x9_29 || zx.d(*x8_23) != 0x5f)
        label_49b27c_1:
            result = nullptr
        else
            void** x20_4 = arg1[0x266]
            *arg1 = &x8_23[1]
            int64_t x8_25 = x20_4[1]
            
            if (x8_25 + 0x40 u>= 0xff0)
                void** x0_17 = malloc(0x1000)
                
                if (x0_17 == 0)
                    sub_491944()
                    noreturn
                
                x8_25 = 0
                *x0_17 = x20_4
                x0_17[1] = 0
                arg1[0x266] = x0_17
                x20_4 = x0_17
            
            x20_4[1] = x8_25 + 0x40
            result = x20_4 + x8_25 + 0x10
            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::ClosureTypeName{for `(anonymous namespace)::itanium_demangle::Node'}
            result[1].d = 0x101012d
            result[2] = x0_10
            result[3] = x1_4
            result[4] = x0_16
            result[5] = x1_7
            result[6] = x28_1
            result[7] = x22_4
    arg1[0x54] = arg1[0x53] + (x9_10 << 3)
    int128_t* x0_18 = var_c0
    
    if (x0_18 != &var_a8)
        free(x0_18)
    
    arg1[0x62] = x26_1
else if (zx.d(*x10) != 0x55 || zx.d(x10[1]) != 0x62)
    result = nullptr
else
    void* x9_14 = &x10[2]
    *arg1 = x9_14
    
    if (x8_2 != x9_14 && zx.d(*x9_14) - 0x30 u<= 9)
        void* x10_3 = &x10[3]
        
        do
            x9_14 = x10_3
            *arg1 = x10_3
            
            if (x8_2 == x10_3)
                break
            
            x10_3 = x9_14 + 1
        while (zx.d(*x9_14) - 0x30 u< 0xa)
    
    if (x9_14 == x8_2 || zx.d(*x9_14) != 0x5f)
        result = nullptr
    else
        void** x20_2 = arg1[0x266]
        *arg1 = x9_14 + 1
        int64_t x8_11 = x20_2[1]
        
        if (x8_11 + 0x20 u>= 0xff0)
            void** x0_2 = malloc(0x1000)
            
            if (x0_2 == 0)
                sub_491944()
                noreturn
            
            x8_11 = 0
            *x0_2 = x20_2
            x0_2[1] = 0
            x20_2 = x0_2
            arg1[0x266] = x0_2
        
        x20_2[1] = x8_11 + 0x20
        result = x20_2 + x8_11 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        result[1].d = 0x1010107
        result[2] = "'block-literal'"
        result[3] = &data_451a59[0xf]

if (*(x25 + 0x28) == var_68)
    return result

__stack_chk_fail()
noreturn
