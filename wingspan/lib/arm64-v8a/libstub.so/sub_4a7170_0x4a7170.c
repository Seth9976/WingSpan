// 函数: sub_4a7170
// 地址: 0x4a7170
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void var_8

if (((*(arg2 + 0x340) & 0x40000000) == 0 || zx.d(*(arg2 + 0x377)) == 0) && *(arg2 + 0xf8) == 0)
    sub_4a70dc(arg2, *(arg2 + 0x310), &var_8)
int64_t x20 = 0

while (true)
    int64_t* x0_4 = *(arg1 + (x20 << 3))
    int64_t x1_1 = *(arg2 + (x20 << 3))
    
    if (zx.d(*(arg1 + x20 + 0x358)) == 0)
        int32_t x2_4 = x0_4 != 0 ? 1 : 0
        
        if (zx.d(*(arg2 + x20 + 0x358)) == 0 || x2_4 == 0)
            if ((x2_4 & (x1_1 != 0 ? 1 : 0)) == 0)
                goto label_4a7224
            
            if (x1_1 != x0_4)
                memcpy(x0_4, x1_1, zx.q((&data_4b0fd0)[x20]))
            
            goto label_4a7224
        
        if (zx.d((&data_4b0fd0)[x20]) == 8)
            *x0_4 = x1_1
        label_4a7224:
            x20 += 1
            
            if (x20 == 0x61)
                break
            
            continue
    
    abort()
    noreturn

void* result

if ((*(arg1 + 0x340) & 0x40000000) != 0)
    result = nullptr

if ((*(arg1 + 0x340) & 0x40000000) == 0 || zx.d(*(arg1 + 0x377)) == 0)
    result = nullptr
    
    if (*(arg1 + 0xf8) == 0)
        return sub_4a7118(arg2, 0x1f) - *(arg1 + 0x310) + *(arg2 + 0x350)

return result
