// 函数: sub_46acac
// 地址: 0x46acac
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t var_70
__builtin_memset(&var_70, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result = 0
int64_t var_68
int64_t var_58

if ((sub_45be5c(arg1, &var_58, &var_68, 1, "androidx/loader/app/services/", 0x4529be, 0x452601) & 1)
        == 0)
    result = 0
    int32_t var_50
    
    if (((*(*arg1 + 0x418))(arg1, var_58, var_68, &var_50) & 0x80000000) == 0
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_60
        int64_t x2_2 = var_60
        
        if (x2_2 != 0)
            goto label_46ad9c
        
        if ((sub_45bc9c(arg1, &var_60, "android/view/View") & 1) != 0)
            result = 0
        else
            x2_2 = var_60
        label_46ad9c:
            
            if ((sub_45bc08(arg1, x0, x2_2, "android/view/View") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                result = 0
            else if (x0 == 0)
                sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                result = 0
            else
                int64_t x2_3 = var_70
                
                if (x2_3 != 0)
                    goto label_46ae2c
                
                if ((sub_45be5c(arg1, &var_60, &var_70, 0, "android/view/View", "findViewById", 
                        "(I)Landroid/view/View;") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_70
                label_46ae2c:
                    var_50 = arg4
                    result = (*(*arg1 + 0x120))(arg1, x0, x2_3, &var_50)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
