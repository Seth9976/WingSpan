// 函数: sub_46917c
// 地址: 0x46917c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_78
__builtin_memset(&var_78, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t var_70
int64_t var_60
int32_t result =
    sub_45be5c(arg1, &var_60, &var_70, 1, "androidx/loader/app/services/", 0x451d55, 0x452601)

if ((result & 1) == 0)
    int64_t var_58
    int32_t x0_3 = (*(*arg1 + 0x418))(arg1, var_60, var_70, &var_58)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((x0_3 & 0x80000000) == 0 && (result & 0xff) == 0)
        int64_t x2_2 = var_78
        
        if (x2_2 != 0)
            goto label_46926c
        
        int64_t var_68
        result = sub_45be5c(arg1, &var_68, &var_78, 1, "androidx/loader/app/services/l", "k", 
            "(Ljava/lang/Object;I)V")
        
        if ((result & 1) == 0)
            x2_2 = var_78
        label_46926c:
            var_58 = x0
            int32_t x3
            int32_t var_50_1 = x3
            (*(*arg1 + 0x478))(arg1, var_68, x2_2, &var_58)
            result = (*(*arg1 + 0x720))(arg1)

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
