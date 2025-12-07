// 函数: sub_49161c
// 地址: 0x49161c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (arg1 != 1)
    sub_4919ac(*(arg2 - 0x38))
    noreturn

int64_t x9_1
int32_t i

do
    x9_1 = __ldaxr(arg2 - 0x58)
    i = __stlxr(x9_1 - 1, arg2 - 0x58)
while (i != 0)

if (x9_1 != 1)
    return arg2 + 0x20

int64_t x8_1 = *(arg2 - 0x48)

if (x8_1 != 0)
    x8_1()

return sub_4a64d8(arg2 - 0x60)
