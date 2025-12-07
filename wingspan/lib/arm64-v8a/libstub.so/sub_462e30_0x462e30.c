// 函数: sub_462e30
// 地址: 0x462e30
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t var_80
__builtin_memset(&var_80, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result = 0
int64_t var_78
int64_t var_60

if ((sub_45be5c(arg1, &var_60, &var_78, 1, "androidx/loader/app/services/", 0x4529be, 0x452601) & 1)
        == 0)
    result = 0
    int64_t var_58
    
    if (((*(*arg1 + 0x418))(arg1, var_60, var_78, &var_58) & 0x80000000) == 0
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_68
        int64_t x2_2 = var_68
        
        if (x2_2 != 0)
            goto label_462f24
        
        if ((sub_45bc9c(arg1, &var_68, "java/lang/String") & 1) != 0)
            result = 0
        else
            x2_2 = var_68
        label_462f24:
            
            if ((sub_45bc08(arg1, x0, x2_2, "java/lang/String") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                result = 0
            else
                int64_t x2_3 = var_80
                
                if (x2_3 != 0)
                    goto label_462f80
                
                int64_t var_70
                
                if ((sub_45be5c(arg1, &var_70, &var_80, 1, "androidx/loader/app/services/e", "a", 
                        "(Ljava/lang/String;I)Landroid/text/Spanned;") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_80
                label_462f80:
                    var_58 = x0
                    int32_t x3
                    int32_t var_50_1 = x3
                    result = (*(*arg1 + 0x3a0))(arg1, var_70, x2_3, &var_58)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
