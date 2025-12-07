// 函数: sub_46d2b8
// 地址: 0x46d2b8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t var_80
__builtin_memset(&var_80, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg4)
int64_t var_78
int64_t var_60
int32_t result =
    sub_45be5c(arg1, &var_60, &var_78, 1, "androidx/loader/app/services/", &data_40bfc0, 0x452601)

if ((result & 1) == 0)
    int64_t var_58
    int32_t x0_5 = (*(*arg1 + 0x418))(arg1, var_60, var_78, &var_58)
    result = (*(*arg1 + 0x720))(arg1)
    
    if (x0_5 s>= 1 && (result & 0xff) == 0)
        int64_t var_68
        int64_t x2_2 = var_68
        
        if (x2_2 != 0)
            goto label_46d3ec
        
        result = sub_45bc9c(arg1, &var_68, "android/widget/TextView")
        
        if ((result & 1) == 0)
            x2_2 = var_68
        label_46d3ec:
            result = sub_45bc08(arg1, x0, x2_2, "android/widget/TextView")
            
            if ((result & 1) == 0)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    int64_t var_70
                    int64_t x2_3 = var_70
                    
                    if (x2_3 != 0)
                        goto label_46d440
                    
                    result = sub_45bc9c(arg1, &var_70, "android/graphics/Typeface")
                    
                    if ((result & 1) == 0)
                        x2_3 = var_70
                    label_46d440:
                        result = sub_45bc08(arg1, x0_2, x2_3, "android/graphics/Typeface")
                        
                        if ((result & 1) == 0)
                            result = (*(*arg1 + 0x720))(arg1)
                            
                            if ((result & 0xff) == 0)
                                if (x0 == 0)
                                    result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                                        "NullPointerException")
                                else
                                    int64_t x2_4 = var_80
                                    
                                    if (x2_4 != 0)
                                        goto label_46d4a0
                                    
                                    result = sub_45be5c(arg1, &var_68, &var_80, 0, 
                                        "android/widget/TextView", "setTypeface", 
                                        "(Landroid/graphics/Typeface;I)V")
                                    
                                    if ((result & 1) == 0)
                                        x2_4 = var_80
                                    label_46d4a0:
                                        var_58 = x0_2
                                        int32_t x4
                                        int32_t var_50_1 = x4
                                        (*(*arg1 + 0x1f8))(arg1, x0, x2_4, &var_58)
                                        result = (*(*arg1 + 0x720))(arg1)

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
