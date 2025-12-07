// 函数: sub_464708
// 地址: 0x464708
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
int64_t var_48 = 0
int64_t var_40 = 0
uint64_t result

if ((sub_45c03c(arg1, &var_40, &var_48, 1, "androidx/loader/app/services/", 0x451d81, "I") & 1)
        == 0)
    int32_t x0_2 = (*(*arg1 + 0x4b0))(arg1, var_40, var_48)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        result = zx.q(x0_2) ^ 0xfffffe80
    else
        result = 0
else
    result = 0

if (*(x21 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
