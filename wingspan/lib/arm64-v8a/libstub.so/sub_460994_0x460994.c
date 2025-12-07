// 函数: sub_460994
// 地址: 0x460994
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_78
__builtin_memset(&var_78, 0, 0x20)
int64_t result = 0
int64_t var_70
int64_t var_60

if ((sub_45be5c(arg1, &var_60, &var_70, 1, "androidx/loader/app/services/", 0x452470, 0x452601) & 1)
        == 0)
    result = 0
    int32_t var_58
    
    if (((*(*arg1 + 0x418))(arg1, var_60, var_70, &var_58) & 0x80000000) == 0
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_68
        int32_t x0_6 = sub_45be5c(arg1, &var_68, &var_78, 1, "androidx/loader/app/services/l", "i", 
            "(IF)Landroid/widget/LinearLayout$LayoutParams;")
        char x0_10
        
        if ((x0_6 & 1) == 0)
            var_58 = arg3
            int32_t v0
            int32_t var_50_1 = v0
            result = (*(*arg1 + 0x3a0))(arg1, var_68, var_78, &var_58)
            x0_10 = (*(*arg1 + 0x720))(arg1)
        
        if ((x0_6 & 1) != 0 || zx.d(x0_10) != 0)
            result = 0

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
