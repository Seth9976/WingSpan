// 函数: sub_4a7cdc
// 地址: 0x4a7cdc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x4 = arg1
int64_t var_200[0x40]
var_200[0] = arg4
int32_t x25 = 1

while (true)
    if (x4 u>= arg2)
        if (x25 != 0)
            return var_200[sx.q(x25 - 1)]
        
        break
    
    uint32_t x26_1 = zx.d(*x4)
    void* x27_1 = &x4[1]
    uint64_t var_210
    int64_t var_208
    int64_t x0
    char* x0_11
    
    if (x26_1 u<= 0x20)
        int64_t var_218
        
        if (x26_1 u>= 0x1f)
        label_4a8074:
            
            if (x25 == 0)
                break
            
            x25 -= 1
            int64_t* x2_6 = var_200[sx.q(x25)]
            
            if (x26_1 == 0x1f)
                x0 = neg.q(x2_6)
            else if (x26_1 u> 0x1f)
                if (x26_1 == 0x23)
                    x27_1 = sub_4a6e70(x27_1, &var_218)
                    x0 = x2_6 + var_218
                else if (x26_1 == 0x94)
                    x27_1 = &x4[2]
                    int32_t x0_25 = zx.d(x4[1]) - 1
                    
                    if (x0_25 u> 7)
                        break
                    
                    switch (x0_25)
                        case 0
                            x0 = zx.q(*x2_6)
                        case 1
                            x0 = zx.q(*x2_6)
                        case 2, 4, 5, 6
                            break
                        case 3
                            x0 = zx.q(*x2_6)
                        case 7
                            x0 = *x2_6
                else
                    if (x26_1 != 0x20)
                        break
                    
                    x0 = not.q(x2_6)
            else if (x26_1 == 6)
                x0 = *x2_6
            else
                if (x26_1 != 0x19)
                    break
                
                x0 = (x2_6 ^ x2_6 s>> 0x3f) + (x2_6 u>> 0x3f)
            
            goto label_4a824c
        
        if (x26_1 == 0x10)
            x27_1 = sub_4a6e70(x27_1, &var_218)
            x0 = var_218
            goto label_4a824c
        
        if (x26_1 u<= 0x10)
            if (x26_1 == 0xa)
                x0 = zx.q(*(x4 + 1))
            label_4a7f38:
                x27_1 = &x4[3]
                goto label_4a824c
            
            if (x26_1 u<= 0xa)
                if (x26_1 == 6)
                    goto label_4a8074
                
                if (x26_1 u> 6)
                    x27_1 = &x4[2]
                    
                    if (x26_1 == 8)
                        x0 = zx.q(x4[1])
                    else
                        if (x26_1 != 9)
                            break
                        
                        x0 = sx.q(x4[1])
                else
                    if (x26_1 != 3)
                        break
                    
                    x0 = *(x4 + 1)
                    x27_1 = &x4[9]
                
                goto label_4a824c
            
            if (x26_1 == 0xd)
                x0 = sx.q(*(x4 + 1))
            label_4a7f44:
                x27_1 = &x4[5]
                goto label_4a824c
            
            if (x26_1 u> 0xd)
                x27_1 = &x4[9]
                
                if (x26_1 != 0xe && x26_1 != 0xf)
                    break
                
                x0 = *(x4 + 1)
                goto label_4a824c
            
            if (x26_1 == 0xb)
                x0 = sx.q(*(x4 + 1))
                goto label_4a7f38
            
            if (x26_1 != 0xc)
                break
            
            x0 = zx.q(*(x4 + 1))
            goto label_4a7f44
        
        if (x26_1 == 0x15)
            uint64_t x1_13 = zx.q(x4[1])
            var_210 = x1_13
            x27_1 = &x4[2]
            int64_t x0_22 = sx.q(x25 - 1)
            
            if (x1_13 s>= x0_22)
                break
            
            x0 = var_200[x0_22 - x1_13]
            goto label_4a824c
        
        if (x26_1 u> 0x15)
            if (x26_1 == 0x19)
                goto label_4a8074
            
            if (x26_1 u> 0x19)
                goto label_4a8138
            
            if (x26_1 == 0x16)
                if (x25 s<= 1)
                    break
                
                int64_t x2_4 = var_200[sx.q(x25 - 1)]
                var_200[sx.q(x25 - 1)] = var_200[sx.q(x25 - 2)]
                var_200[sx.q(x25 - 2)] = x2_4
            else
                if (x26_1 != 0x17)
                    break
                
                if (x25 s<= 2)
                    break
                
                int64_t x3_2 = var_200[sx.q(x25 - 1)]
                int64_t x4_1 = var_200[sx.q(x25 - 3)]
                var_200[sx.q(x25 - 1)] = var_200[sx.q(x25 - 2)]
                var_200[sx.q(x25 - 2)] = x4_1
                var_200[sx.q(x25 - 3)] = x3_2
        else
            int32_t x0_20
            
            if (x26_1 == 0x12)
                if (x25 == 0)
                    break
                
                x0_20 = x25 - 1
            label_4a8028:
                x0 = var_200[sx.q(x0_20)]
                goto label_4a824c
            
            if (x26_1 u< 0x12)
                x0_11 = sub_4a6e98(x27_1, &var_208)
            label_4a7f7c:
                x27_1 = x0_11
                x0 = var_208
                goto label_4a824c
            
            if (x26_1 != 0x13)
                if (x26_1 != 0x14)
                    break
                
                if (x25 s<= 1)
                    break
                
                x0_20 = x25 - 2
                goto label_4a8028
            
            if (x25 == 0)
                break
            
            x25 -= 1
    else if (x26_1 u> 0x4f)
        int32_t var_220
        void* x0_2
        int32_t x1_1
        
        if (x26_1 == 0x90)
            x27_1 = sub_4a6e70(x27_1, &var_220)
            x1_1 = var_220
            x0_2 = arg3
        label_4a7fa0:
            x0 = sub_4a7118(x0_2, x1_1)
            goto label_4a824c
        
        int64_t* x0_7
        uint64_t x1_5
        
        if (x26_1 u<= 0x90)
            if (x26_1 u<= 0x6f)
                x0_2 = arg3
                x1_1 = x26_1 - 0x50
                goto label_4a7fa0
            
            x27_1 = sub_4a6e98(x27_1, &var_210)
            x0_7 = sub_4a7118(arg3, x26_1 - 0x70)
            x1_5 = var_210
        label_4a7fd4:
            x0 = x0_7 + x1_5
            goto label_4a824c
        
        if (x26_1 == 0x94)
            goto label_4a8074
        
        if (x26_1 u<= 0x94)
            if (x26_1 != 0x92)
                break
            
            x27_1 = sub_4a6e98(sub_4a6e70(x27_1, &var_220), &var_210)
            x0_7 = sub_4a7118(arg3, var_220)
            x1_5 = var_210
            goto label_4a7fd4
        
        if (x26_1 != 0x96)
            if (x26_1 != 0xf1)
                break
            
            char x2 = x4[1]
            x0_11 = sub_4a6ed8(x2, sub_4a7348(x2, arg3), &x4[2], &var_208)
            goto label_4a7f7c
    else if (x26_1 u>= 0x30)
        x0 = zx.q(x26_1 - 0x30)
    label_4a824c:
        
        if (x25 u> 0x3f)
            break
        
        var_200[sx.q(x25)] = x0
        x25 += 1
    else
        if (x26_1 u<= 0x27)
            if (x26_1 u< 0x24 && x26_1 u> 0x22)
                goto label_4a8074
            
        label_4a8138:
            
            if (x25 s<= 1)
                break
            
            int64_t x1_17 = var_200[sx.q(x25 - 2)]
            int64_t x0_30 = var_200[sx.q(x25 - 1)]
            
            if (x26_1 - 0x1a u> 0x14)
                break
            
            switch (x26_1)
                case 0x1a
                    x0 = x0_30 & x1_17
                case 0x1b
                    x0 = x1_17 s/ x0_30
                case 0x1c
                    x0 = x1_17 - x0_30
                case 0x1d
                    x0 = x1_17 u% x0_30
                case 0x1e
                    x0 = x0_30 * x1_17
                case 0x1f, 0x20, 0x23, 0x28
                    break
                case 0x21
                    x0 = x0_30 | x1_17
                case 0x22
                    x0 = x0_30 + x1_17
                case 0x24
                    x0 = x1_17 << x0_30
                case 0x25
                    x0 = x1_17 u>> x0_30
                case 0x26
                    x0 = x1_17 s>> x0_30
                case 0x27
                    x0 = x0_30 ^ x1_17
                case 0x29
                    x0 = x1_17 == x0_30 ? 1 : 0
                case 0x2a
                    x0 = x1_17 s>= x0_30 ? 1 : 0
                case 0x2b
                    x0 = x1_17 s> x0_30 ? 1 : 0
                case 0x2c
                    x0 = x1_17 s<= x0_30 ? 1 : 0
                case 0x2d
                    x0 = x1_17 s< x0_30 ? 1 : 0
                case 0x2e
                    x0 = x1_17 != x0_30 ? 1 : 0
            
            x25 -= 2
            goto label_4a824c
        
        if (x26_1 u> 0x2e)
            x27_1 = &x4[3 + sx.q(*(x4 + 1))]
        else
            if (x26_1 u>= 0x29)
                goto label_4a8138
            
            if (x25 == 0)
                break
            
            x25 -= 1
            
            if (var_200[sx.q(x25)] == 0)
                x27_1 = &x4[3]
            else
                x27_1 = &x4[3 + sx.q(*(x4 + 1))]
    x4 = x27_1

abort()
noreturn
