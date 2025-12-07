// 函数: sub_462ad4
// 地址: 0x462ad4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
int64_t var_60
__builtin_memset(&var_60, 0, 0x20)
int64_t var_58
int64_t var_48
int32_t x20_1

if ((sub_45be5c(arg1, &var_48, &var_58, 1, "androidx/loader/app/services/", 0x451d55, 0x452601) & 1)
        == 0)
    x20_1 = 0
    int32_t var_40
    int64_t var_50
    
    if ((*(*arg1 + 0x418))(arg1, var_48, var_58, &var_40) s>= 1
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        if ((sub_45be5c(arg1, &var_50, &var_60, 1, "java/lang/Math", "round", "(F)I") & 1) != 0)
            x20_1 = 0
        else
            var_40 = arg2
            x20_1 = (*(*arg1 + 0x418))(arg1, var_50, var_60, &var_40)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                x20_1 = 0
else
    x20_1 = 0

if (*(x21 + 0x28) == x8)
    return zx.q(x20_1)

__stack_chk_fail()
noreturn
