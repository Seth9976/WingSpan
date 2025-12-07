// 函数: sub_4a2538
// 地址: 0x4a2538
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x8

if (*(arg2 + 0x1c) == 0xffffffff)
    int64_t x9_2 = *(arg1 + 0x18)
    x8 = 0
    *(arg2 + 0x18) = 0
    *(arg2 + 0x1c) = x9_2.d
    
    if (x9_2 u<= 0)
        return 0
else
    x8 = zx.q(*(arg2 + 0x18))
    
    if (*(arg1 + 0x18) u<= x8)
        return 0

int64_t* x0 = *(*(arg1 + 0x10) + (x8 << 3))
uint32_t x8_1 = zx.d(*(x0 + 0xb))

if (x8_1 != 2)
    return zx.q(x8_1 == 0 ? 1 : 0)

jump(*(*x0 + 0x10))
