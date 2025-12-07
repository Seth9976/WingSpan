// 函数: sub_49615c
// 地址: 0x49615c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
char* x9 = *arg1
int64_t x8_1 = arg1[1]
void* result

if (x9 == x8_1 || zx.d(*x9) != 0x54)
    result = nullptr
else
    void* x10_2 = &x9[1]
    *arg1 = x10_2
    
    if (x10_2 == x8_1)
        result = nullptr
    else
        int64_t x9_1
        
        if (zx.d(*x10_2) != 0x4c)
            x9_1 = 0
            int64_t x21_1
            
            if (x10_2 == x8_1 || zx.d(*x10_2) != 0x5f)
            label_4963f4:
                
                if (x8_1 == x10_2 || zx.d(*x10_2) - 0x30 u> 9)
                    result = nullptr
                else
                    int64_t x11_8 = 0
                    
                    while (true)
                        int64_t x11_10 = x11_8 * 0xa
                        
                        if (x8_1 == x10_2)
                            x11_8 = x11_10 - 0x30
                            break
                        
                        void* x13_2 = x10_2 + 1
                        *arg1 = x13_2
                        x11_8 = x11_10 + zx.q(*x10_2) - 0x30
                        
                        if (x8_1 - 1 != x10_2)
                            x10_2 = x13_2
                            
                            if (zx.d(*x13_2) - 0x30 u< 0xa)
                                continue
                        
                        x10_2 = x13_2
                        break
                    
                    if (x10_2 != x8_1 && zx.d(*x10_2) == 0x5f)
                        x21_1 = x11_8 + 1
                        goto label_496248
                    
                    result = nullptr
            else
            label_496240:
                x21_1 = 0
            label_496248:
                *arg1 = x10_2 + 1
                
                if (x9_1 != 0 || zx.d(*(arg1 + 0x309)) == 0)
                    int64_t x10_10 = arg1[0x53]
                    int64_t x8_8 = (arg1[0x54] - x10_10) s>> 3
                    
                    if (x9_1 u>= x8_8)
                    label_496330:
                        result = nullptr
                        
                        if (x9_1 u<= x8_8 && arg1[0x62] == x9_1)
                            if (x9_1 == x8_8)
                                int64_t var_50 = 0
                                sub_496d90(&arg1[0x53], &var_50)
                            
                            void** x21_3 = arg1[0x266]
                            int64_t x8_9 = x21_3[1]
                            
                            if (x8_9 + 0x20 u>= 0xff0)
                                void** x0_4 = malloc(0x1000)
                                
                                if (x0_4 == 0)
                                    sub_491944()
                                    noreturn
                                
                                x8_9 = 0
                                *x0_4 = x21_3
                                x0_4[1] = 0
                                x21_3 = x0_4
                                arg1[0x266] = x0_4
                            
                            x21_3[1] = x8_9 + 0x20
                            result = x21_3 + x8_9 + 0x10
                            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
                            *(result + 8) = 0x1010107
                            *(result + 0x10) = "auto"
                            *(result + 0x18) = &data_40d0bc[4]
                    else
                        int64_t* x10_11 = *(x10_10 + (x9_1 << 3))
                        
                        if (x10_11 == 0)
                            goto label_496330
                        
                        int64_t x10_12 = *x10_11
                        
                        if (x21_1 u>= (x10_11[1] - x10_12) s>> 3)
                            goto label_496330
                        
                        result = *(x10_12 + (x21_1 << 3))
                else
                    void** x22_1 = arg1[0x266]
                    int64_t x8_4 = x22_1[1]
                    
                    if (x8_4 + 0x30 u>= 0xff0)
                        void** x0 = malloc(0x1000)
                        
                        if (x0 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_4 = 0
                        *x0 = x22_1
                        x0[1] = 0
                        x22_1 = x0
                        arg1[0x266] = x0
                    
                    x22_1[1] = x8_4 + 0x30
                    result = x22_1 + x8_4 + 0x10
                    *result = &_vtable_for_(anonymous namespace)::itanium_demangle::ForwardTemplateReference{for `(anonymous namespace)::itanium_demangle::Node'}
                    *(result + 8) = 0x2020224
                    *(result + 0x10) = x21_1
                    *(result + 0x18) = 0
                    *(result + 0x20) = 0
                    void** x8_5 = arg1[0x5b]
                    
                    if (x8_5 != arg1[0x5c])
                        arg1[0x5b] = &x8_5[1]
                        *x8_5 = result
                    else
                        int64_t oldmem = arg1[0x5a]
                        void* x21_2 = x8_5 - oldmem
                        void* x22_2
                        
                        if (&arg1[0x5d] == oldmem)
                            void* x0_7 = malloc(x21_2 << 1)
                            
                            if (x0_7 == 0)
                                sub_491944()
                                noreturn
                            
                            x22_2 = x0_7
                            
                            if (x21_2 != 0)
                                memmove(x22_2, oldmem, x21_2)
                            
                            arg1[0x5a] = x22_2
                        else
                            void* x0_2 = realloc(oldmem, x21_2 << 1)
                            x22_2 = x0_2
                            arg1[0x5a] = x0_2
                            
                            if (x0_2 == 0)
                                sub_491944()
                                noreturn
                        
                        x8_5 = x22_2 + x21_2
                        arg1[0x5b] = x8_5
                        arg1[0x5c] = x22_2 + (x21_2 s>> 2 << 3)
                        arg1[0x5b] = &x8_5[1]
                        *x8_5 = result
        else
            *arg1 = &x9[2]
            
            if (x8_1 == &x9[2] || zx.d(x9[2]) - 0x30 u> 9)
                result = nullptr
            else
                int64_t x10_6 = 0
                void* x11_2
                uint32_t x14_2
                
                do
                    int64_t x10_8 = x10_6 * 0xa
                    
                    if (x8_1 - 2 == x9)
                        x10_6 = x10_8 - 0x30
                        x11_2 = &x9[2]
                        break
                    
                    x11_2 = &x9[3]
                    *arg1 = x11_2
                    x10_6 = x10_8 + zx.q(x9[2]) - 0x30
                    
                    if (x8_1 - 3 == x9)
                        break
                    
                    x14_2 = zx.d(x9[3])
                    x9 = &x9[1]
                while (x14_2 - 0x30 u< 0xa)
                
                if (x11_2 != x8_1 && zx.d(*x11_2) == 0x5f)
                    x9_1 = x10_6 + 1
                    x10_2 = x11_2 + 1
                    *arg1 = x10_2
                    
                    if (x10_2 != x8_1 && zx.d(*x10_2) == 0x5f)
                        goto label_496240
                    
                    goto label_4963f4
                
                result = nullptr

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
