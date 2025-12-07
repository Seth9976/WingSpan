// 函数: sub_46bf78
// 地址: 0x46bf78
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_78
__builtin_memset(&var_78, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t var_70
int64_t var_60
int32_t result =
    sub_45be5c(arg1, &var_60, &var_70, 1, "androidx/loader/app/services/", 0x452470, 0x452601)

if ((result & 1) == 0)
    int32_t var_58
    int32_t x0_3 = (*(*arg1 + 0x418))(arg1, var_60, var_70, &var_58)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((x0_3 & 0x80000000) == 0 && (result & 0xff) == 0)
        int64_t var_68
        int64_t x2_2 = var_68
        
        if (x2_2 != 0)
            goto label_46c094
        
        result = sub_45bc9c(arg1, &var_68, "android/widget/TextView")
        
        if ((result & 1) == 0)
            x2_2 = var_68
        label_46c094:
            result = sub_45bc08(arg1, x0, x2_2, "android/widget/TextView")
            
            if ((result & 1) == 0)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    if (x0 == 0)
                        result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                            "NullPointerException")
                    else
                        int64_t x2_3 = var_78
                        
                        if (x2_3 != 0)
                            goto label_46c0f4
                        
                        result = sub_45be5c(arg1, &var_68, &var_78, 0, "android/widget/TextView", 
                            "setTextSize", "(IF)V")
                        
                        if ((result & 1) == 0)
                            x2_3 = var_78
                        label_46c0f4:
                            var_58 = arg4
                            int32_t v0
                            int32_t var_50_1 = v0
                            (*(*arg1 + 0x1f8))(arg1, x0, x2_3, &var_58)
                            result = (*(*arg1 + 0x720))(arg1)

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
