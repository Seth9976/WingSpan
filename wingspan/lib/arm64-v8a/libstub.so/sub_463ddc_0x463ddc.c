// 函数: sub_463ddc
// 地址: 0x463ddc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_78
__builtin_memset(&var_78, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result = 0
int64_t var_70
int64_t var_58

if ((sub_45be5c(arg1, &var_58, &var_70, 1, "androidx/loader/app/services/", 0x4529be, 0x452601) & 1)
        == 0)
    result = 0
    int64_t var_50
    
    if (((*(*arg1 + 0x418))(arg1, var_58, var_70, &var_50) & 0x80000000) == 0
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_60
        int64_t x2_2 = var_60
        
        if (x2_2 != 0)
            goto label_463ecc
        
        if ((sub_45bc9c(arg1, &var_60, "java/lang/String") & 1) != 0)
            result = 0
        else
            x2_2 = var_60
        label_463ecc:
            
            if ((sub_45bc08(arg1, x0, x2_2, "java/lang/String") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                result = 0
            else
                int64_t x2_3 = var_78
                
                if (x2_3 != 0)
                    goto label_463f28
                
                int64_t var_68
                
                if ((sub_45be5c(arg1, &var_68, &var_78, 1, "android/net/Uri", "parse", 
                        "(Ljava/lang/String;)Landroid/net/Uri;") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_78
                label_463f28:
                    var_50 = x0
                    result = (*(*arg1 + 0x3a0))(arg1, var_68, x2_3, &var_50)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
