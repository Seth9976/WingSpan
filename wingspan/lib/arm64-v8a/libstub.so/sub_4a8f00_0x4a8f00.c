// 函数: sub_4a8f00
// 地址: 0x4a8f00
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x19 = *(arg3 + 8)
uint32_t x20 = (x19 u>> 1).d

while (true)
    x20 -= 1
    
    if ((x20 & 0x80000000) != 0)
        break
    
    sub_4a8e40(arg1, arg2, arg3 + 0x10, zx.q(x20), x19.d)

int64_t x20_1 = 0
int32_t i = x19.d - 1
void* x23 = arg3 + 0x10 + (sx.q(i) << 3)

while (i s> 0)
    int32_t i_1 = i
    int64_t x0_1 = *(arg3 + 0x10)
    *(arg3 + 0x10) = *(x23 + x20_1)
    *(x23 + x20_1) = x0_1
    i -= 1
    x20_1 -= 8
    sub_4a8e40(arg1, arg2, arg3 + 0x10, 0, i_1)
