// 函数: sub_496f28
// 地址: 0x496f28
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int32_t x8_1

if (zx.d(*(arg1 + 0x20)) == 0)
    int64_t* x0 = *(arg1 + 0x18)
    *(arg1 + 0x20) = 1
    uint32_t x8_2 = zx.d(*(x0 + 0xb))
    
    if (x8_2 != 2)
        x8_1 = x8_2 == 0 ? 1 : 0
    else
        x8_1 = (*(*x0 + 0x10))()
    
    *(arg1 + 0x20) = 0
else
    x8_1 = 0

return zx.q(x8_1) & 1
