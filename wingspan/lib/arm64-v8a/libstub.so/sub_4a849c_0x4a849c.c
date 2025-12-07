// 函数: sub_4a849c
// 地址: 0x4a849c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

memset(arg1, 0, 0x3c0)
int64_t lr
*(arg1 + 0x318) = lr
*(arg1 + 0x340) = 0x4000000000000000
void var_680

if (sub_4a78b8(arg1, &var_680) != 0)
    abort()
    noreturn

int32_t x0_3

if (pthread_create != 0)
    x0_3 = pthread_once(0x4b1034, sub_4a6fc8)

if ((pthread_create == 0 || x0_3 != 0) && zx.d(data_4b0fd0) == 0)
    sub_4a6fc8()

void var_688
sub_4a70dc(arg1, arg2, &var_688)
int64_t var_58 = 0
int32_t var_40 = 1
int64_t var_50 = 0x1f
int64_t result = sub_4a8290(arg1, &var_680)
*(arg1 + 0x318) = arg3
return result
