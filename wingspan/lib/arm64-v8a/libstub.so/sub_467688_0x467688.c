// 函数: sub_467688
// 地址: 0x467688
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_68
__builtin_memset(&var_68, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result = 0
int64_t var_60
int64_t var_48

if ((sub_45be5c(arg1, &var_48, &var_60, 1, "androidx/loader/app/services/", 0x4529be, 0x452601) & 1)
        == 0)
    result = 0
    int64_t var_40
    
    if ((*(*arg1 + 0x418))(arg1, var_48, var_60, &var_40) s>= 1
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_50
        int64_t x2_2 = var_50
        
        if (x2_2 != 0)
            goto label_467778
        
        if ((sub_45bc9c(arg1, &var_50, "java/lang/String") & 1) != 0)
            result = 0
        else
            x2_2 = var_50
        label_467778:
            
            if ((sub_45bc08(arg1, x0, x2_2, "java/lang/String") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                result = 0
            else
                int64_t x2_3 = var_68
                
                if (x2_3 != 0)
                    goto label_4677d4
                
                int64_t var_58
                
                if ((sub_45be5c(arg1, &var_58, &var_68, 1, "android/text/Html", "fromHtml", 
                        "(Ljava/lang/String;)Landroid/text/Spanned;") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_68
                label_4677d4:
                    var_40 = x0
                    result = (*(*arg1 + 0x3a0))(arg1, var_58, x2_3, &var_40)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
