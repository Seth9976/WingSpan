// 函数: sub_4a9c0c
// 地址: 0x4a9c0c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint32_t x1 = zx.d(arg1[4].b)
int64_t* var_10

if ((x1 & 1) == 0)
    uint64_t x20_2 = zx.q(arg1[4].d) u>> 0xb & 0x1fffff
    
    if (x20_2 != 0)
    label_4a9cdc:
        size_t bytes = (x20_2 + 2) << 3
        int64_t* x0_8 = malloc(bytes)
        var_10 = x0_8
        
        if (x0_8 != 0)
            x0_8[1] = 0
            void* x0_10 = malloc(bytes)
            
            if (x0_10 != 0)
                *(x0_10 + 8) = 0
            
            if ((zx.d(arg1[4].b) & 2) == 0)
                sub_4a9ad8(arg1, &var_10, arg1[3])
            else
                void** x21_6 = arg1[3]
                
                while (true)
                    void* x2_12 = *x21_6
                    
                    if (x2_12 == 0)
                        break
                    
                    x21_6 = &x21_6[1]
                    sub_4a9ad8(arg1, &var_10, x2_12)
            
            int64_t* x24_3 = var_10
            
            if (x24_3 != 0 && x24_3[1] != x20_2)
                abort()
                noreturn
            
            uint64_t (* x23_2)(void* arg1, void* arg2, void* arg3)
            
            if ((zx.d(arg1[4].b) & 4) != 0)
                x23_2 = sub_4a98dc
            else if ((zx.d(arg1[4].w) & 0x7f8) == 0)
                x23_2 = sub_4a8e24
            else
                x23_2 = sub_4a91c4
            
            if (x0_10 == 0)
                sub_4a8f00(arg1, x23_2, x24_3)
            else
                void* i_5 = &x24_3[2]
                int64_t x3_7 = x24_3[1]
                void* i = &data_4b11c8
                void* i_4 = i_5
                int64_t x27_3 = 0
                
                while (x27_3 != x3_7)
                    while (i != &data_4b11c8)
                        if ((x23_2(arg1, *i_4, *i) & 0x80000000) == 0)
                            break
                        
                        void* x0_58 = x0_10 + i - i_5
                        i = *(x0_58 + 0x10)
                        *(x0_58 + 0x10) = 0
                    
                    void* x0_59 = x0_10 + (x27_3 << 3)
                    x27_3 += 1
                    *(x0_59 + 0x10) = i
                    i = i_4
                    i_4 += 8
                
                int64_t x0_11 = 0
                int64_t x1_4 = 0
                int64_t x2_1 = 0
                
                while (x2_1 != x3_7)
                    int64_t x5_1 = *i_5
                    
                    if (*(x0_10 + (x2_1 << 3) + 0x10) == 0)
                        int64_t x4_6 = x0_11 + 2
                        x0_11 += 1
                        *(x0_10 + (x4_6 << 3)) = x5_1
                    else
                        int64_t x4_3 = x1_4 + 2
                        x1_4 += 1
                        x24_3[x4_3] = x5_1
                    
                    x2_1 += 1
                    i_5 += 8
                
                x24_3[1] = x1_4
                *(x0_10 + 8) = x0_11
                
                if (*(x0_10 + 8) + var_10[1] != x20_2)
                    abort()
                    noreturn
                
                sub_4a8f00(arg1, x23_2, x0_10)
                int64_t* x21_3 = var_10
                int64_t i_1 = *(x0_10 + 8)
                
                if (i_1 != 0)
                    int64_t j = x21_3[1]
                    int64_t x26_1 = i_1 << 3
                    
                    do
                        i_1 -= 1
                        void* x25_1 = &x21_3[j]
                        int64_t x28_1 = *(x0_10 + x26_1 + 8)
                        
                        while (j != 0)
                            int64_t x1_22 = *(x25_1 + 8)
                            x25_1 -= 8
                            
                            if (x23_2(arg1, x1_22, x28_1) s<= 0)
                                break
                            
                            j -= 1
                            *(x25_1 + x26_1 + 0x10) = *(x25_1 + 0x10)
                        
                        x26_1 -= 8
                        x21_3[i_1 + j + 2] = x28_1
                    while (i_1 != 0)
                    
                    x21_3[1] += *(x0_10 + 8)
                
                free(x0_10)
            
            int64_t* x0_22 = var_10
            *x0_22 = arg1[3]
            arg1[3] = x0_22
            arg1[4].b |= 1
    else
        if ((x1 & 2) != 0)
            int64_t* x21_1 = arg1[3]
            
            while (true)
                int32_t* x1_1 = *x21_1
                
                if (x1_1 == 0)
                    break
                
                int64_t x0_2 = sub_4a9978(arg1, x1_1)
                
                if (x0_2 == -1)
                    goto label_4a9c74
                
                x20_2 += x0_2
                x21_1 = &x21_1[1]
            
            goto label_4a9cb0
        
        uint64_t x0_3 = sub_4a9978(arg1, arg1[3])
        x20_2 = x0_3
        
        if (x0_3 == -1)
        label_4a9c74:
            arg1[4] = 0
            arg1[4].w = 0x7f8
            arg1[3] = &data_4b11d0
        else
        label_4a9cb0:
            uint64_t x0_4 = zx.q(x20_2.d) & 0x1fffff
            int32_t x0_5 = arg1[4].d
            int32_t x0_6
            
            if (x0_4 != x20_2)
                x0_6 = x0_5 & 0x7ff
            else
                x0_6 = (0x7ff & x0_5) | (0x1fffff & x0_4.d) << 0xb
            
            arg1[4].d = x0_6
            
            if (x20_2 != 0)
                goto label_4a9cdc
    
    if (arg2 u>= *arg1)
        goto label_4a9c38
else
label_4a9c38:
    uint32_t x0 = zx.d(arg1[4].b)
    int32_t* x0_38
    
    if ((x0 & 1) == 0)
        if ((x0 & 2) == 0)
            return sub_4a9350(arg1, arg1[3], arg2)
        
        int64_t* x20_4 = arg1[3]
        
        while (true)
            int32_t* x1_17 = *x20_4
            
            if (x1_17 == 0)
                break
            
            x0_38 = sub_4a9350(arg1, x1_17, arg2)
            
            if (x0_38 != 0)
                return x0_38
            
            x20_4 = &x20_4[1]
    else
        void* var_18
        int32_t* x20_3
        
        if ((x0 & 4) == 0)
            uint64_t x0_36 = zx.q(arg1[4].w)
            
            if ((x0_36.d & 0x7f8) != 0)
                char x0_39 = (x0_36 u>> 3).b & 0xff
                void* x24_2 = arg1[3]
                int64_t x23_1 = 0
                int64_t* x0_40 = sub_4a9014(x0_39, arg1)
                uint64_t x21_5 = *(x24_2 + 8)
                
                while (true)
                    if (x23_1 u>= x21_5)
                        return nullptr
                    
                    uint64_t x19_2 = (x21_5 + x23_1) u>> 1
                    x20_3 = *(x24_2 + ((x19_2 + 2) << 3))
                    sub_4a90d4(x0_39 & 0xf, nullptr, sub_4a90d4(x0_39, x0_40, &x20_3[2], &var_18), 
                        &var_10)
                    void* x1_16 = var_18
                    
                    if (arg2 u>= x1_16)
                        if (arg2 u< x1_16 + var_10)
                            return x20_3
                        
                        x23_1 = x19_2 + 1
                        x19_2 = x21_5
                    
                    x21_5 = x19_2
            else
                void* x5_2 = arg1[3]
                int64_t x3_3 = 0
                uint64_t x2_7 = *(x5_2 + 8)
                
                while (true)
                    if (x3_3 u>= x2_7)
                        return nullptr
                    
                    uint64_t x1_13 = (x2_7 + x3_3) u>> 1
                    x0_38 = *(x5_2 + ((x1_13 + 2) << 3))
                    int64_t x6_1 = *(x0_38 + 8)
                    
                    if (arg2 u< x6_1)
                        x2_7 = x1_13
                    else
                        if (arg2 u< x6_1 + *(x0_38 + 0x10))
                            return x0_38
                        
                        x3_3 = x1_13 + 1
        else
            void* x27_2 = arg1[3]
            int64_t x24_1 = 0
            uint64_t i_3
            
            for (uint64_t i_2 = *(x27_2 + 8); x24_1 u< i_2; i_2 = i_3)
                i_3 = (i_2 + x24_1) u>> 1
                x20_3 = *(x27_2 + ((i_3 + 2) << 3))
                char x0_28 = sub_4a94b0(x20_3)
                sub_4a90d4(x0_28 & 0xf, nullptr, 
                    sub_4a90d4(x0_28, sub_4a9014(x0_28, arg1), &x20_3[2], &var_18), &var_10)
                void* x1_11 = var_18
                
                if (arg2 u>= x1_11)
                    if (arg2 u< x1_11 + var_10)
                        return x20_3
                    
                    x24_1 = i_3 + 1
                    i_3 = i_2
return nullptr
