// 函数: sub_47bbdc
// 地址: 0x47bbdc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_70 = 0
int64_t var_68 = 0
int64_t result = 0

if ((sub_45bc9c(arg1, &var_68, "android/widget/LinearLayout$LayoutParams") & 1) == 0)
    result = (*(*arg1 + 0xd8))(arg1, var_68)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        result = 0
    else if (result == 0)
        sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
    else if ((sub_45be5c(arg1, &var_68, &var_70, 0, "android/widget/LinearLayout$LayoutParams", 
            "<init>", "(IIF)V") & 1) != 0)
        result = 0
    else
        int32_t var_60 = arg3
        int32_t var_58_1 = 0xfffffffe
        int32_t v0
        int32_t var_50_1 = v0
        (*(*arg1 + 0x1f8))(arg1, result, var_70, &var_60)
        
        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
            result = 0

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
