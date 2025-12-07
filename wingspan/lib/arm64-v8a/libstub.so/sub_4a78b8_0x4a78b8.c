// 函数: sub_4a78b8
// 地址: 0x4a78b8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

memset(arg2, 0, 0x680)
int64_t x1 = *(arg1 + 0x318)
*(arg1 + 0x350) = 0
*(arg1 + 0x320) = 0

if (x1 != 0)
    int32_t* x0_5 = sub_4aa458(x1 + (*(arg1 + 0x340) u>> 0x3f) - 1, arg1 + 0x328)
    
    if (x0_5 != 0)
        void* x22_2 = &x0_5[1] - sx.q(x0_5[1])
        arg2[0xc9] = *(arg1 + 0x338)
        void* x23_1 = x22_2 + 9
        void* x0_12 = x23_1 + strlen(x23_1) + 1
        
        if (zx.d(*(x22_2 + 9)) == 0x65 && zx.d(*(x22_2 + 0xa)) == 0x68)
            int64_t x1_9 = *x0_12
            x0_12 += 8
            x23_1 = x22_2 + 0xb
            arg2[0xcf] = x1_9
        
        if (zx.d(*(x22_2 + 8)) u> 3)
            if (zx.d(*x0_12) != 8 || zx.d(*(x0_12 + 1)) != 0)
                return 3
            
            x0_12 += 2
        
        uint64_t var_18
        char* x0_13 = sub_4a6e70(x0_12, &var_18)
        arg2[0xcc] = var_18
        int64_t var_10
        char* x0_14 = sub_4a6e98(x0_13, &var_10)
        arg2[0xcb] = var_10
        void* x0_15
        uint64_t x1_17
        
        if (zx.d(*(x22_2 + 8)) != 1)
            x0_15 = sub_4a6e70(x0_14, &var_18)
            x1_17 = var_18
        else
            x0_15 = &x0_14[1]
            x1_17 = zx.q(*x0_14)
        
        arg2[0xcd] = x1_17
        *(arg2 + 0x671) = 0xff
        char* x24_1 = nullptr
        
        if (zx.d(*x23_1) == 0x7a)
            x23_1 += 1
            x0_15 = sub_4a6e70(x0_15, &var_18)
            uint64_t x24_2 = var_18
            *(arg2 + 0x672) = 1
            x24_1 = x0_15 + x24_2
        
        void* x23_2 = x23_1 + 1
        int64_t var_8
        char* x0_19
        
        while (true)
            uint32_t x1_21 = zx.d(*(x23_2 - 1))
            
            if (x1_21 == 0)
                x0_19 = x24_1 != 0 ? x24_1 : x0_15
                
                break
            
            if (x1_21 == 0x4c)
                *(arg2 + 0x671) = *x0_15
                x0_15 += 1
            else if (x1_21 == 0x52)
                arg2[0xce].b = *x0_15
                x0_15 += 1
            else if (x1_21 != 0x50)
                if (x1_21 != 0x53)
                    x0_19 = x24_1
                    break
                
                *(arg2 + 0x673) = 1
            else
                char x26_1 = *x0_15
                void* var_30_1 = x0_15 + 1
                x0_15 = sub_4a6ed8(x26_1, sub_4a7348(x26_1, arg1), x0_15 + 1, &var_8)
                arg2[0xca] = var_8
            
            x23_2 += 1
        
        if (x0_19 == 0)
            return 3
        
        sub_4a73c0(x0_19, x22_2 + zx.q(*x22_2) + 4, arg1, arg2)
        uint32_t x0_20 = zx.d(arg2[0xce].b)
        int32_t x2_11
        
        if (x0_20 == 0xff)
            x2_11 = 0
        else
            switch (x0_20 & 7)
                case 0, 4
                    x2_11 = 8
                case 2
                    x2_11 = 2
                case 3
                    x2_11 = 4
                default
                    abort()
                    noreturn
        
        void* x22_3 = nullptr
        void* x2_14 = x0_5 + zx.q(x2_11 << 1) + 8
        
        if (zx.d(*(arg2 + 0x672)) != 0)
            char* x0_26 = sub_4a6e70(x2_14, &var_8)
            x2_14 = x0_26
            x22_3 = &x0_26[var_8]
        
        uint32_t x23_3 = zx.d(*(arg2 + 0x671))
        
        if (x23_3 != 0xff)
            x2_14 = sub_4a6ed8(x23_3.b, sub_4a7348(x23_3.b, arg1), x2_14, &var_8)
            *(arg1 + 0x320) = var_8
        
        char* x0_32
        
        x0_32 = x22_3 != 0 ? x22_3 : x2_14
        
        sub_4a73c0(x0_32, x0_5 + zx.q(*x0_5) + 4, arg1, arg2)
        return 0
    
    int32_t* x1_2 = *(arg1 + 0x318)
    
    if (*x1_2 == 0xd2801168 && x1_2[1] == 0xd4000001)
        void* x20_1 = *(arg1 + 0x310)
        arg2[0xc6] = 0x1f
        arg2[0xc8].d = 1
        arg2[0xc5] = 0x130
        int64_t i = 8
        int64_t* x2_2 = arg2
        
        do
            x2_2[1].d = 1
            *x2_2 = i
            x2_2 = &x2_2[2]
            i += 8
        while (i != 0x100)
        
        void* x0_6 = x20_1 + 0x250
        
        while (true)
            int32_t x2_3 = *x0_6
            
            if (x2_3 == 0)
                break
            
            if (x2_3 == 0x46508001)
                void* i_1 = &arg2[0x80]
                
                do
                    *(i_1 + 8) = 1
                    *i_1 = x0_6 + -0x3f0 - (x20_1 + 0x130) - arg2 + i_1
                    i_1 += 0x10
                while (i_1 != &arg2[0xc0])
            
            x0_6 += zx.q(*(x0_6 + 4))
        
        *(arg2 + 0x673) = 1
        arg2[0x3e] = x20_1 + 0x230 - (x20_1 + 0x130)
        arg2[0x3f].d = 1
        arg2[0xc1].d = 4
        arg2[0xc0] = *(x20_1 + 0x238) - (x20_1 + 0x130)
        arg2[0xcd] = 0x60
        return 0

return 5
