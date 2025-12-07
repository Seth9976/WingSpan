// 函数: sub_46367c
// 地址: 0x46367c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_68
__builtin_memset(&var_68, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result = 0
int64_t var_60
int64_t var_48

if ((sub_45be5c(arg1, &var_48, &var_60, 1, "androidx/loader/app/services/", 0x451d55, 0x452601) & 1)
        == 0)
    int64_t var_40
    int32_t x0_4 = (*(*arg1 + 0x418))(arg1, var_48, var_60, &var_40)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0 && (x0_4 & 0x80000000) == 0)
        int64_t var_50
        int64_t x2_2 = var_50
        
        if (x2_2 != 0)
            goto label_463790
        
        if ((sub_45bc9c(arg1, &var_50, "java/lang/String") & 1) != 0)
            result = 0
        else
            x2_2 = var_50
        label_463790:
            
            if ((sub_45bc08(arg1, x0, x2_2, "java/lang/String") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                result = 0
            else
                int64_t x2_3 = var_68
                
                if (x2_3 != 0)
                    goto label_4637ec
                
                int64_t var_58
                
                if ((sub_45be5c(arg1, &var_58, &var_68, 1, "androidx/loader/app/services/l", "e", 
                        "(Ljava/lang/String;)Ljava/lang/String;") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_68
                label_4637ec:
                    var_40 = x0
                    result = (*(*arg1 + 0x3a0))(arg1, var_58, x2_3, &var_40)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0
    else
        result = 0

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
