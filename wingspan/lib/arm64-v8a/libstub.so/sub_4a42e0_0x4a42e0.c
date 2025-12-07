// 函数: sub_4a42e0
// 地址: 0x4a42e0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t* x0_1 = *(arg1 + 0x10)
uint32_t x8 = zx.d(*(x0_1 + 0xb))

if (x8 != 2)
    return zx.q(x8 == 0 ? 1 : 0)

jump(*(*x0_1 + 0x10))
