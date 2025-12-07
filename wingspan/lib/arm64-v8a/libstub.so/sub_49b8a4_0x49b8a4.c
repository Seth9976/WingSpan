// 函数: sub_49b8a4
// 地址: 0x49b8a4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t var_90 = arg5
int64_t x5
int64_t var_88 = x5
int64_t x6
int64_t var_80 = x6
int64_t x7
int64_t var_78 = x7
int128_t var_110 = arg6
int128_t var_100 = arg7
int128_t var_f0 = arg8
int128_t var_e0 = arg9
int128_t var_d0 = arg10
int128_t var_c0 = arg11
int128_t var_b0 = arg12
int128_t var_a0 = arg13
uint64_t x19 = _ReadMSR(tpidr_el0)
int64_t x10 = *(x19 + 0x28)
int128_t var_70
int128_t* var_40 = &var_70
int64_t var_30 = -0x7f00000020
void arg_0
var_70 = (&arg_0).o
int128_t var_60 = (&var_90).o
int64_t result = __vsnprintf_chk(arg1, arg3, 0, arg2, arg4)

if (*(x19 + 0x28) == x10)
    return result

__stack_chk_fail()
noreturn
