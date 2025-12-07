// 函数: sub_4a8e40
// 地址: 0x4a8e40
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

for (int32_t i = (arg4.d << 1) + 1; i s< arg5; i = (i << 1) + 1)
    if (i + 1 s< arg5)
        int64_t x1 = zx.q(i) << 0x20 s>> 0x1d
        
        if (arg2(arg1, *(arg3 + x1), *(arg3 + x1 + 8)) s< 0)
            i += 1
    
    int64_t x21_2 = (arg4 & 0xffffffff) << 0x20 s>> 0x1d
    int64_t x22_1 = zx.q(i) << 0x20 s>> 0x1d
    
    if ((arg2(arg1, *(arg3 + x21_2), *(arg3 + x22_1)).d & 0x80000000) == 0)
        break
    
    arg4 = zx.q(i)
    int64_t x0_3 = *(arg3 + x21_2)
    *(arg3 + x21_2) = *(arg3 + x22_1)
    *(arg3 + x22_1) = x0_3
