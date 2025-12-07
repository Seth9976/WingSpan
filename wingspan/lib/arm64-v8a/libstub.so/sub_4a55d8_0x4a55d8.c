// 函数: sub_4a55d8
// 地址: 0x4a55d8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t var_58 = -0x7f00000038
int128_t var_e0
int128_t* var_68 = &var_e0
int128_t var_1a0 = arg2
int128_t var_190 = arg3
int64_t x1
int64_t var_118 = x1
int64_t x2
int64_t var_110 = x2
int64_t x3
int64_t var_108 = x3
int64_t x4
int64_t var_100 = x4
int64_t x5
int64_t var_f8 = x5
int64_t x6
int64_t var_f0 = x6
int64_t x7
int64_t var_e8 = x7
int128_t var_180 = arg4
int128_t var_170 = arg5
int128_t var_160 = arg6
int128_t var_150 = arg7
int128_t var_140 = arg8
int128_t var_130 = arg9
void arg_0
int128_t var_90 = (&arg_0).o
void var_120
int128_t var_80 = (&var_120).o
vfprintf(__sF + 0x130, arg1)
int128_t v0
int128_t v1
v0, v1 = fputc(0xa, __sF + 0x130)
int64_t var_a0 = -0x7f00000038
int128_t* var_b0 = &var_e0
var_e0 = (&arg_0).o
int128_t var_d0 = (&var_120).o
char* result_ptr
vasprintf(&result_ptr, arg1)
android_set_abort_message(result_ptr)
openlog("libc++abi", 0, 0)
syslog(2, "%s", result_ptr)
closelog()
abort()
noreturn
