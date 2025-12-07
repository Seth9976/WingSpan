// 函数: sub_4745a0
// 地址: 0x4745a0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
int64_t var_50 = 0
int64_t var_48 = 0
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))())
int32_t x0_4 = sub_45be5c(arg1, &var_48, &var_50, 1, "androidx/loader/app/services/", &data_40de20, 
    "(Ljava/lang/Object;)Ljava/net/HttpURLConnection;")
int64_t x0_6
char x0_8

if ((x0_4 & 1) == 0)
    int64_t var_40 = x0_2
    x0_6 = (*(*arg1 + 0x3a0))(arg1, var_48, var_50, &var_40)
    x0_8 = (*(*arg1 + 0x720))(arg1)

uint64_t result

if ((x0_4 & 1) == 0 && zx.d(x0_8) == 0)
    result = zx.q(x0_6 != 0 ? 1 : 0)
else
    result = 0

if (*(x21 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
