// 函数: sub_4a7118
// 地址: 0x4a7118
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (arg2 s<= 0x61)
    int64_t x2_1 = sx.q(arg2)
    int64_t* result = *(arg1 + (sx.q(arg2) << 3))
    
    if ((*(arg1 + 0x340) & 0x40000000) != 0 && zx.d(*(arg1 + x2_1 + 0x358)) != 0)
        return result
    
    if (zx.d((&data_4b0fd0)[x2_1]) == 8)
        return *result

abort()
noreturn
