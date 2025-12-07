// 函数: sub_4a259c
// 地址: 0x4a259c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x8

if (*(arg2 + 0x1c) == 0xffffffff)
    int64_t x9_2 = *(arg1 + 0x18)
    x8 = 0
    *(arg2 + 0x18) = 0
    *(arg2 + 0x1c) = x9_2.d
    
    if (x9_2 u<= 0)
        return 
else
    x8 = zx.q(*(arg2 + 0x18))
    
    if (*(arg1 + 0x18) u<= x8)
        return 

jump(*(**(*(arg1 + 0x10) + (x8 << 3)) + 0x18))
