// 函数: sub_47bd24
// 地址: 0x47bd24
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
int64_t var_58 = 0
int64_t var_50 = 0
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int32_t result = sub_45be5c(arg1, &var_50, &var_58, 1, "androidx/loader/app/services/", 0x45238b, 
    "(Ljava/lang/Object;I)V")

if ((result & 1) == 0)
    int64_t var_48 = x0_2
    int32_t var_40_1 = 0
    (*(*arg1 + 0x478))(arg1, var_50, var_58, &var_48)
    result = (*(*arg1 + 0x720))(arg1)

if (*(x21 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
