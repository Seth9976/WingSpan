// 函数: sub_4a8578
// 地址: 0x4a8578
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

sub_4a8290(arg1, arg2)
int64_t x1 = arg2[0xcd]
uint64_t result = zx.q(arg2[x1 * 2 + 1].d)

if (result.d != 6)
    result = sub_4a7118(arg1, x1.d)
    *(arg1 + 0x318) = result
else
    *(arg1 + 0x318) = 0

return result
