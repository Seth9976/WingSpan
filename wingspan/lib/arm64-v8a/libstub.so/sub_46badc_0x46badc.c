// 函数: sub_46badc
// 地址: 0x46badc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t var_98
__builtin_memset(&var_98, 0, 0x38)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg4)
int64_t x0_4 = (*(*arg1 + 0xc8))(arg1, arg5)
int64_t var_90
int64_t var_68
int32_t result =
    sub_45be5c(arg1, &var_68, &var_90, 1, "androidx/loader/app/services/", 0x4529be, 0x452601)

if ((result & 1) == 0)
    int64_t var_60
    int32_t x0_7 = (*(*arg1 + 0x418))(arg1, var_68, var_90, &var_60)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((x0_7 & 0x80000000) == 0 && (result & 0xff) == 0)
        int64_t var_70
        int64_t x2_2 = var_70
        
        if (x2_2 != 0)
            goto label_46bc28
        
        result = sub_45bc9c(arg1, &var_70, "android/content/Context")
        
        if ((result & 1) == 0)
            x2_2 = var_70
        label_46bc28:
            result = sub_45bc08(arg1, x0, x2_2, "android/content/Context")
            
            if ((result & 1) == 0)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    int64_t var_78
                    int64_t x2_3 = var_78
                    
                    if (x2_3 != 0)
                        goto label_46bc7c
                    
                    result = sub_45bc9c(arg1, &var_78, "java/lang/String")
                    
                    if ((result & 1) == 0)
                        x2_3 = var_78
                    label_46bc7c:
                        result = sub_45bc08(arg1, x0_2, x2_3, "java/lang/String")
                        
                        if ((result & 1) == 0)
                            result = (*(*arg1 + 0x720))(arg1)
                            
                            if ((result & 0xff) == 0)
                                int64_t var_80
                                int64_t x2_4 = var_80
                                
                                if (x2_4 != 0)
                                    goto label_46bcd0
                                
                                result = sub_45bc9c(arg1, &var_80, "android/view/View")
                                
                                if ((result & 1) == 0)
                                    x2_4 = var_80
                                label_46bcd0:
                                    result = sub_45bc08(arg1, x0_4, x2_4, "android/view/View")
                                    
                                    if ((result & 1) == 0)
                                        result = (*(*arg1 + 0x720))(arg1)
                                        
                                        if ((result & 0xff) == 0)
                                            int64_t x2_5 = var_98
                                            
                                            if (x2_5 != 0)
                                                goto label_46bd2c
                                            
                                            int64_t var_88
                                            result = sub_45be5c(arg1, &var_88, &var_98, 1, 
                                                "androidx/loader/app/services/l", "a", 
                                                "(Landroid/content/Context;Ljava/lang/String;"
                                            "Landroid/view/View;)V")
                                            
                                            if ((result & 1) == 0)
                                                x2_5 = var_98
                                            label_46bd2c:
                                                var_60 = x0
                                                int64_t var_58_1 = x0_2
                                                int64_t var_50_1 = x0_4
                                                (*(*arg1 + 0x478))(arg1, var_88, x2_5, &var_60)
                                                result = (*(*arg1 + 0x720))(arg1)

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
