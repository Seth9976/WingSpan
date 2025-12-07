// 函数: sub_4a98dc
// 地址: 0x4a98dc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char x0_1 = sub_4a94b0(arg2)
int64_t var_10
sub_4a90d4(x0_1, sub_4a9014(x0_1, arg1), arg2 + 8, &var_10)
char x0_6 = sub_4a94b0(arg3)
int64_t var_8
sub_4a90d4(x0_6, sub_4a9014(x0_6, arg1), arg3 + 8, &var_8)
int64_t x2_2 = var_10
int64_t x1_4 = var_8
int32_t x0_10

x0_10 = x2_2 u< x1_4 ? -1 : 0

if (x2_2 u<= x1_4)
    return zx.q(x0_10)

return 1
