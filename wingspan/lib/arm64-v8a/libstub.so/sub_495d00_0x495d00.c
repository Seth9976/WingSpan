// 函数: sub_495d00
// 地址: 0x495d00
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x10 = _ReadMSR(tpidr_el0)
int64_t var_68 = *(x10 + 0x28)
char* x8_1 = *arg1
void* result

if (x8_1 == arg1[1] || zx.d(*x8_1) != 0x49)
    result = nullptr
else
    *arg1 = &x8_1[1]
    void* result_1
    
    if ((arg2 & 1) != 0)
        arg1[0x54] = arg1[0x53]
        result_1 = &arg1[0x48]
        sub_496d90(&arg1[0x53], &result_1)
        arg1[0x49] = arg1[0x48]
    
    int64_t x8_6 = (arg1[3] - arg1[2]) s>> 3
    
    while (true)
        char* x8_7 = *arg1
        
        if (x8_7 != arg1[1] && zx.d(*x8_7) == 0x45)
            *arg1 = &x8_7[1]
            int64_t x21_3 = x8_6 << 3
            void* x0_11
            int64_t x1_7
            x0_11, x1_7 = sub_49e548(arg1, arg1[2] + x21_3, arg1[3])
            void** x22_1 = arg1[0x266]
            arg1[3] = arg1[2] + x21_3
            int64_t x8_17 = x22_1[1]
            
            if (x8_17 + 0x20 u< 0xff0)
                goto label_4960e8
            
            void** x0_12 = malloc(0x1000)
            
            if (x0_12 != 0)
                x8_17 = 0
                *x0_12 = x22_1
                x0_12[1] = 0
                x22_1 = x0_12
                arg1[0x266] = x0_12
            label_4960e8:
                x22_1[1] = x8_17 + 0x20
                result = x22_1 + x8_17 + 0x10
                *result = &_vtable_for_(anonymous namespace)::itanium_demangle::TemplateArgs{for `(anonymous namespace)::itanium_demangle::Node'}
                *(result + 8) = 0x1010123
                *(result + 0x10) = x0_11
                *(result + 0x18) = x1_7
                break
        else if ((arg2 & 1) == 0)
            result = sub_4951ec(arg1)
            result_1 = result
            
            if (result == 0)
                break
            
            sub_4953d4(&arg1[2], &result_1)
            continue
        else
            int128_t v0
            v0.q = 0
            v0:8.q = 0
            int128_t var_88
            result_1 = &var_88
            int128_t* var_98_1 = &var_88
            int64_t* var_90_1 = &var_68
            __builtin_memset(&var_88, 0, 0x20)
            void* result_2 = arg1[0x53]
            
            if (result_2 == &arg1[0x56])
                int64_t x9_6 = arg1[0x54]
                void* result_4
                int64_t x10_4
                
                if (x9_6 == result_2)
                    x10_4 = 0
                    result_4 = &var_88
                else
                    __memmove_chk(&var_88, &arg1[0x56], x9_6 - result_2, 0x20)
                    result_2 = arg1[0x53]
                    result_4 = result_1
                    x10_4 = (arg1[0x54] - result_2) s>> 3
                
                var_98_1 = result_4 + (x10_4 << 3)
                arg1[0x54] = result_2
            else
                result_1 = result_2
                var_98_1.o = *(arg1 + 0x2a0)
                arg1[0x53] = &arg1[0x56]
                arg1[0x54] = &arg1[0x56]
                arg1[0x55] = &arg1[0x5a]
            
            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                ** x0_5
            x0_5, v0 = sub_4951ec(arg1)
            void* result_5 = result_1
            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                ** var_a8 = x0_5
            void* result_3 = arg1[0x53]
            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                ** x24_1 = x0_5
            
            if (result_5 == &var_88)
                void* result_8 = result_3
                
                if (result_3 == &arg1[0x56])
                    result_3 = &var_88
                else
                    free(result_8)
                    arg1[0x53] = &arg1[0x56]
                    arg1[0x54] = &arg1[0x56]
                    arg1[0x55] = &arg1[0x5a]
                    result_3 = result_1
                    result_8 = &arg1[0x56]
                    result_5 = result_3
                
                void* x10_6
                void* x11_1
                
                if (var_98_1 == result_5)
                    x10_6 = nullptr
                    x11_1 = &arg1[0x56]
                else
                    memmove(result_8, result_3, var_98_1 - result_5)
                    result_3 = result_1
                    x11_1 = arg1[0x53]
                    x10_6 = var_98_1 - result_3
                    result_5 = result_3
                
                arg1[0x54] = x11_1 + x10_6
                void* result_7 = result_5
                
                if (x24_1 == 0)
                    goto label_496054
                
                goto label_495f4c
            
            arg1[0x53] = result_5
            
            if (result_3 != &arg1[0x56])
                int64_t x9_8 = arg1[0x55]
                *(arg1 + 0x2a0) = var_98_1.o
                int64_t var_90_2 = x9_8
                result_1 = result_3
                void* result_6 = result_3
                
                if (x24_1 != 0)
                    goto label_495f4c
                
                goto label_496054
            
            result_3 = &var_88
            *(arg1 + 0x2a0) = var_98_1.o
            result_1 = &var_88
            int128_t* var_98_2 = &var_88
            int64_t* var_90_3 = &var_68
            
            if (x24_1 == 0)
                goto label_496054
            
        label_495f4c:
            sub_4953d4(&arg1[2], &var_a8)
            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                ** var_b0 = x24_1
            
            if (zx.d(x24_1[1].b) != 0x21)
            label_496044:
                sub_49c60c(*(arg1[0x54] - 8), &var_b0)
                result_3 = result_1
                x24_1 = 1
            label_496054:
                
                if (result_3 != &var_88)
                    free(result_3)
                
                if ((x24_1.d & 1) != 0)
                    continue
                
                result = nullptr
                break
            else
                void** x25_1 = arg1[0x266]
                int64_t* x28_1 = x24_1[2]
                int64_t x24_2 = x24_1[3]
                int64_t x8_9 = x25_1[1]
                
                if (x8_9 + 0x20 u< 0xff0)
                    goto label_495f98
                
                void** x0_7 = malloc(0x1000)
                
                if (x0_7 != 0)
                    x8_9 = 0
                    *x0_7 = x25_1
                    x0_7[1] = 0
                    x25_1 = x0_7
                    arg1[0x266] = x0_7
                label_495f98:
                    x25_1[1] = x8_9 + 0x20
                    *(x25_1 + x8_9 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::ParameterPack{for `(anonymous namespace)::itanium_demangle::Node'}
                    *(x25_1 + x8_9 + 0x18) = 0x2020220
                    int64_t x9_12 = x24_2 << 3
                    *(x25_1 + x8_9 + 0x20) = x28_1
                    *(x25_1 + x8_9 + 0x28) = x24_2
                    
                    if (x24_2 == 0)
                    label_495fe8:
                        *(x25_1 + x8_9 + 0x1a) = 1
                    else
                        int64_t x10_8 = x9_12
                        int64_t* x11_2 = x28_1
                        
                        while (true)
                            void* x12_1 = *x11_2
                            x11_2 = &x11_2[1]
                            
                            if (zx.d(*(x12_1 + 0xa)) != 1)
                                break
                            
                            int64_t temp0_1 = x10_8
                            x10_8 -= 8
                            
                            if (temp0_1 == 8)
                                goto label_495fe8
                    
                    if (x24_2 == 0)
                    label_496010:
                        *(x25_1 + x8_9 + 0x1b) = 1
                    else
                        int64_t x10_9 = x9_12
                        int64_t* x11_3 = x28_1
                        
                        while (true)
                            void* x12_3 = *x11_3
                            x11_3 = &x11_3[1]
                            
                            if (zx.d(*(x12_3 + 0xb)) != 1)
                                break
                            
                            int64_t temp1_1 = x10_9
                            x10_9 -= 8
                            
                            if (temp1_1 == 8)
                                goto label_496010
                    
                    if (x24_2 == 0)
                    label_496030:
                        *(x25_1 + x8_9 + 0x19) = 1
                    else
                        while (true)
                            void* x10_10 = *x28_1
                            x28_1 = &x28_1[1]
                            
                            if (zx.d(*(x10_10 + 9)) != 1)
                                break
                            
                            int64_t temp2_1 = x9_12
                            x9_12 -= 8
                            
                            if (temp2_1 == 8)
                                goto label_496030
                    
                    var_b0 = x25_1 + x8_9 + 0x10
                    goto label_496044
        
        sub_491944()
        noreturn

if (*(x10 + 0x28) == var_68)
    return result

__stack_chk_fail()
noreturn
