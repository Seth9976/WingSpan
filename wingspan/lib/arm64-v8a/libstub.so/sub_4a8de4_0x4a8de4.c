// 函数: sub_4a8de4
// 地址: 0x4a8de4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x2 = 0
uint64_t x3 = 0
uint64_t x4_1

do
    x4_1 = zx.q(*arg1)
    arg1 = &arg1[1]
    int64_t x5_2 = (x4_1 & 0x7f) << x3
    x3 = zx.q(x3.d + 7)
    x2 |= x5_2
while ((x4_1.d & 0x80) != 0)

if (x3.d u<= 0x3f && (x4_1.d & 0x40) != 0)
    x2 |= 0xffffffffffffffff << x3

*arg2 = x2
return arg1
