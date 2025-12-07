// 函数: sub_4a73c0
// 地址: 0x4a73c0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t __saved_fp
int64_t* sp = &__saved_fp
arg4[0xc4] = 0
int64_t* x24 = nullptr
void* x20_1

for (; arg1 u< arg2; arg1 = x20_1)
    int64_t x2 = arg4[0xc9]
    
    if (x2 u>= *(arg3 + 0x318) + (*(arg3 + 0x340) u>> 0x3f))
        break
    
    uint64_t x1_2 = zx.q(*arg1)
    x20_1 = &arg1[1]
    int32_t x3_1 = x1_2.d & 0xc0
    
    if (x3_1 == 0x40)
        arg4[0xc9] = x2 + (x1_2 & 0x3f) * arg4[0xcc]
    else
        int64_t var_18
        int64_t var_10
        void* x0_1
        int64_t x0_9
        int64_t x0_22
        int64_t x1_17
        
        if (x3_1 == 0x80)
            x0_1 = x20_1
            var_18 = x1_2 & 0x3f
        label_4a7530:
            x20_1 = sub_4a6e70(x0_1, &var_10)
            x1_17 = arg4[0xcb]
            x0_9 = var_10
        label_4a76e8:
            int64_t x0_41 = var_18
            
            if (x0_41 u<= 0x61)
                x0_22 = x0_41 << 4
                *(arg4 + x0_22 + 8) = 1
                *(arg4 + x0_22) = x0_9 * x1_17
        else
            int64_t var_8
            char* x0_36
            int64_t x0_51
            int64_t x1_33
            int64_t x1_43
            void* x2_7
            int32_t x3_9
            
            if (x3_1 != 0xc0)
                switch (x1_2.d)
                    case 0
                        nop
                    case 1
                        char x2_1 = arg4[0xce].b
                        x20_1 = sub_4a6ed8(x2_1, sub_4a7348(x2_1, arg3), x20_1, &var_8)
                        arg4[0xc9] = var_8
                    case 2
                        x20_1 = &arg1[2]
                        arg4[0xc9] = x2 + zx.q(arg1[1]) * arg4[0xcc]
                    case 3
                        x20_1 = &arg1[3]
                        arg4[0xc9] = x2 + zx.q(*(arg1 + 1)) * arg4[0xcc]
                    case 4
                        x20_1 = &arg1[5]
                        arg4[0xc9] = x2 + zx.q(*(arg1 + 1)) * arg4[0xcc]
                    case 5
                        x0_1 = sub_4a6e70(x20_1, &var_18)
                        goto label_4a7530
                    case 6, 8
                        x20_1 = sub_4a6e70(x20_1, &var_18)
                        int64_t x0_12 = var_18
                        
                        if (x0_12 u<= 0x61)
                            arg4[x0_12 * 2 + 1].d = 0
                    case 7
                        x20_1 = sub_4a6e70(x20_1, &var_18)
                        int64_t x0_16 = var_18
                        
                        if (x0_16 u<= 0x61)
                            arg4[x0_16 * 2 + 1].d = 6
                    case 9
                        x20_1 = sub_4a6e70(sub_4a6e70(x20_1, &var_18), &var_8)
                        int64_t x0_21 = var_18
                        
                        if (x0_21 u<= 0x61)
                            x0_22 = x0_21 << 4
                            *(arg4 + x0_22 + 8) = 2
                            *(arg4 + x0_22) = var_8
                    case 0xa
                        int64_t* x3_6
                        
                        if (x24 == 0)
                            sp -= 0x660
                            x3_6 = sp
                        else
                            x3_6 = x24
                            x24 = x24[0xc4]
                        
                        arg4[0xc4] = memcpy(x3_6, arg4, 0x648)
                    case 0xb
                        int64_t* x3_7 = arg4[0xc4]
                        memcpy(arg4, x3_7, 0x648)
                        x3_7[0xc4] = x24
                        x24 = x3_7
                    case 0xc
                        char* x0_27 = sub_4a6e70(x20_1, &var_10)
                        arg4[0xc6] = var_10
                        x20_1 = sub_4a6e70(x0_27, &var_10)
                        arg4[0xc5] = var_10
                        arg4[0xc8].d = 1
                    case 0xd
                        x20_1 = sub_4a6e70(x20_1, &var_10)
                        arg4[0xc6] = var_10
                        arg4[0xc8].d = 1
                    case 0xe
                        x20_1 = sub_4a6e70(x20_1, &var_10)
                        arg4[0xc5] = var_10
                    case 0xf
                        arg4[0xc7] = x20_1
                        arg4[0xc8].d = 2
                        x20_1 = &sub_4a6e70(x20_1, &var_10)[var_10]
                    case 0x10
                        x0_36 = sub_4a6e70(x20_1, &var_18)
                        int64_t x1_32 = var_18
                        
                        if (x1_32 u> 0x61)
                            x20_1 = &sub_4a6e70(x0_36, &var_10)[var_10]
                        else
                            x1_33 = x1_32 << 4
                            x3_9 = 3
                            x2_7 = arg4 + x1_33
                        label_4a77e0:
                            *(x2_7 + 8) = x3_9
                            *(arg4 + x1_33) = x0_36
                            x20_1 = &sub_4a6e70(x0_36, &var_10)[var_10]
                    case 0x11
                        x20_1 = sub_4a6e98(sub_4a6e70(x20_1, &var_18), &var_8)
                        x1_17 = arg4[0xcb]
                        x0_9 = var_8
                        goto label_4a76e8
                    case 0x12
                        char* x0_43 = sub_4a6e70(x20_1, &var_10)
                        arg4[0xc6] = var_10
                        char* x0_44 = sub_4a6e98(x0_43, &var_8)
                        arg4[0xc8].d = 1
                        x20_1 = x0_44
                        arg4[0xc5] = var_8 * arg4[0xcb]
                    case 0x13
                        x20_1 = sub_4a6e98(x20_1, &var_8)
                        arg4[0xc5] = var_8 * arg4[0xcb]
                    case 0x14
                        x20_1 = sub_4a6e70(sub_4a6e70(x20_1, &var_18), &var_10)
                        x1_43 = arg4[0xcb]
                        x0_51 = var_10
                    label_4a7798:
                        int64_t x0_55 = var_18
                        
                        if (x0_55 u<= 0x61)
                            x0_22 = x0_55 << 4
                            *(arg4 + x0_22 + 8) = 4
                            *(arg4 + x0_22) = x0_51 * x1_43
                    case 0x15
                        x20_1 = sub_4a6e98(sub_4a6e70(x20_1, &var_18), &var_8)
                        x1_43 = arg4[0xcb]
                        x0_51 = var_8
                        goto label_4a7798
                    case 0x16
                        x0_36 = sub_4a6e70(x20_1, &var_18)
                        int64_t x1_47 = var_18
                        
                        if (x1_47 u<= 0x61)
                            x1_33 = x1_47 << 4
                            x3_9 = 5
                            x2_7 = arg4 + x1_33
                            goto label_4a77e0
                        
                        x20_1 = &sub_4a6e70(x0_36, &var_10)[var_10]
                    case 0x2d
                        int64_t j = 0x10
                        void* x2_10 = &arg4[0x20]
                        var_18 = 0x10
                        int64_t x1_49 = 0
                        
                        do
                            *(x2_10 + 8) = 1
                            j += 1
                            *x2_10 = x1_49
                            x2_10 += 0x10
                            x1_49 += 8
                        while (j != 0x20)
                    case 0x2e
                        x20_1 = sub_4a6e70(x20_1, &var_10)
                        *(arg3 + 0x350) = var_10
                    case 0x2f
                        x20_1 = sub_4a6e70(sub_4a6e70(x20_1, &var_18), &var_10)
                        int64_t x0_65 = var_18
                        
                        if (x0_65 u<= 0x61)
                            x0_22 = x0_65 << 4
                            int64_t x1_23 = neg.q(arg4[0xcb] * var_10)
                            *(arg4 + x0_22 + 8) = 1
                            *(arg4 + x0_22) = x1_23
                    default
                        abort()
                        noreturn
            else
                arg4[(x1_2 & 0x3f) * 2 + 1].d = 0
