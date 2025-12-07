// 函数: sub_4a91c4
// 地址: 0x4a91c4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char x19_1 = (zx.q(*(arg1 + 0x20)) u>> 3).b & 0xff
int64_t* x0_1 = sub_4a9014(x19_1, arg1)
int64_t var_10
sub_4a90d4(x19_1, x0_1, arg2 + 8, &var_10)
int64_t var_8
sub_4a90d4((zx.q(*(arg1 + 0x20)) u>> 3).b, x0_1, arg3 + 8, &var_8)
int64_t x2_2 = var_10
int64_t x1_3 = var_8
int32_t x0_5

x0_5 = x2_2 u< x1_3 ? -1 : 0

if (x2_2 u<= x1_3)
    return zx.q(x0_5)

return 1
