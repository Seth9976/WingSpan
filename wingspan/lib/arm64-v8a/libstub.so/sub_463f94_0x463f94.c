// 函数: sub_463f94
// 地址: 0x463f94
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_60
__builtin_memset(&var_60, 0, 0x20)
int64_t result = 0
int64_t var_48

if ((sub_45be5c(arg1, &var_48, &var_60, 1, "androidx/loader/app/services/", 0x4529be, 0x452601) & 1)
        == 0)
    result = 0
    void var_40
    
    if (((*(*arg1 + 0x418))(arg1, var_48, var_60, &var_40) & 0x80000000) == 0
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_58
        int64_t var_50
        int32_t x0_6 = sub_45c03c(arg1, &var_50, &var_58, 1, "android/graphics/Typeface", 
            "SANS_SERIF", "Landroid/graphics/Typeface;")
        char x0_10
        
        if ((x0_6 & 1) == 0)
            result = (*(*arg1 + 0x488))(arg1, var_50, var_58)
            x0_10 = (*(*arg1 + 0x720))(arg1)
        
        if ((x0_6 & 1) != 0 || zx.d(x0_10) != 0)
            result = 0

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
