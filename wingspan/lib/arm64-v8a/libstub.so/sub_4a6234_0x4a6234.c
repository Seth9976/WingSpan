// 函数: sub_4a6234
// 地址: 0x4a6234
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint32_t x9 = zx.d(arg2)

if (x9 == 0xff)
    return 0

uint64_t x8 = zx.q(x9) & 0xf

if (x8.d u<= 0xc)
    int16_t* x11_1 = *arg1
    int64_t result
    void* x10_2
    int32_t x12_2
    
    switch (x8)
        case 0, 4, 0xc
            result = *x11_1
            x10_2 = &x11_1[4]
            x12_2 = x9 u>> 4 & 7
            
            if (x12_2 == 0)
                goto label_4a634c
            
        label_4a633c:
            
            if (x12_2 == 1)
                if (result == 0)
                    *arg1 = x10_2
                    return result
                
                result += x11_1
            label_4a634c:
                
                if (result == 0)
                    *arg1 = x10_2
                    return result
                
                if ((x9 & 0x80) != 0)
                    result = *result
                
                *arg1 = x10_2
                return result
        case 1
            int64_t x12_3 = 0
            result = 0
            x10_2 = x11_1
            uint64_t x13_2
            
            do
                x13_2 = zx.q(*x10_2)
                x10_2 += 1
                result |= (x13_2 & 0x7f) << x12_3
                x12_3 += 7
            while ((x13_2.d & 0x80) != 0)
            goto label_4a6334
        case 2
            result = zx.q(*x11_1)
            x10_2 = &x11_1[1]
            x12_2 = x9 u>> 4 & 7
            
            if (x12_2 != 0)
                goto label_4a633c
            
            goto label_4a634c
        case 3
            result = zx.q(*x11_1)
            x10_2 = &x11_1[2]
            x12_2 = x9 u>> 4 & 7
            
            if (x12_2 != 0)
                goto label_4a633c
            
            goto label_4a634c
        case 9
            int64_t x12_4 = 0
            int64_t x8_1 = 0
            x10_2 = x11_1
            uint64_t x13_3
            
            do
                x13_3 = zx.q(*x10_2)
                x10_2 += 1
                x8_1 |= (x13_3 & 0x7f) << x12_4
                x12_4 += 7
            while ((x13_3.d & 0x80) != 0)
            
            int64_t x12_6
            
            if (((x12_4 u< 0x40 ? 1 : 0) & (x13_3.d & 0x40) u>> 6) != 0)
                x12_6 = -1 << x12_4
            else
                x12_6 = 0
            
            result = x8_1 | x12_6
            x12_2 = x9 u>> 4 & 7
            
            if (x12_2 != 0)
                goto label_4a633c
            
            goto label_4a634c
        case 0xa
            result = sx.q(*x11_1)
            x10_2 = &x11_1[1]
        label_4a6334:
            x12_2 = x9 u>> 4 & 7
            
            if (x12_2 == 0)
                goto label_4a634c
            
            goto label_4a633c
        case 0xb
            int32_t* x10_6 = x11_1
            result = sx.q(*x10_6)
            x10_2 = &x10_6[1]
            x12_2 = x9 u>> 4 & 7
            
            if (x12_2 != 0)
                goto label_4a633c
            
            goto label_4a634c

abort()
noreturn
