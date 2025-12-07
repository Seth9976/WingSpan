// 函数: sub_476454
// 地址: 0x476454
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t var_98
__builtin_memset(&var_98, 0, 0x40)
int64_t x0 = (*(*arg1 + 0xc8))()
int64_t x0_4 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int64_t x0_6 = (*(*arg1 + 0xc8))(arg1, x0)
int64_t var_78
int64_t var_60
int32_t result = sub_45be5c(arg1, &var_60, &var_78, 1, "androidx/loader/app/services/", 
    &data_40f535, "()Ljava/lang/Object;")

if ((result & 1) == 0)
    int64_t var_58
    int64_t x0_9 = (*(*arg1 + 0x3a0))(arg1, var_60, var_78, &var_58)
    result = (*(*arg1 + 0x720))(arg1)
    
    if (x0_9 != 0 && (result & 0xff) == 0)
        int64_t var_80
        int64_t x2_2 = var_80
        
        if (x2_2 != 0)
            goto label_4765a0
        
        result = sub_45be5c(arg1, &var_60, &var_80, 1, "androidx/loader/app/services/", 
            &data_40e5c9, "()Landroid/os/Handler;")
        
        if ((result & 1) == 0)
            x2_2 = var_80
        label_4765a0:
            int64_t x0_13 = (*(*arg1 + 0x3a0))(arg1, var_60, x2_2, &var_58)
            result = (*(*arg1 + 0x720))(arg1)
            
            if ((result & 0xff) == 0)
                (*(*arg1 + 0xb8))(arg1, x0_9)
                int64_t var_88
                int64_t x2_4 = var_88
                
                if (x2_4 != 0)
                    goto label_476610
                
                int64_t var_68
                result = sub_45be5c(arg1, &var_68, &var_88, 1, "androidx/loader/app/services/", 
                    &data_40e3b2, "(Ljava/lang/Object;)Landroid/content/Context;")
                
                if ((result & 1) == 0)
                    x2_4 = var_88
                label_476610:
                    var_58 = x0_6
                    int64_t x0_18 = (*(*arg1 + 0x3a0))(arg1, var_68, x2_4, &var_58)
                    result = (*(*arg1 + 0x720))(arg1)
                    
                    if ((result & 0xff) == 0)
                        int64_t var_70
                        int64_t x1_10 = var_70
                        
                        if (x1_10 != 0)
                            goto label_476678
                        
                        result = sub_45bc9c(arg1, &var_70, "androidx/loader/app/services/i")
                        
                        if ((result & 1) == 0)
                            x1_10 = var_70
                        label_476678:
                            int64_t x0_22 = (*(*arg1 + 0xd8))(arg1, x1_10)
                            result = (*(*arg1 + 0x720))(arg1)
                            
                            if ((result & 0xff) == 0)
                                if (x0_22 == 0)
                                    result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                                        "NullPointerException")
                                else
                                    int64_t var_90
                                    int64_t x2_6 = var_90
                                    
                                    if (x2_6 != 0)
                                        goto label_476700
                                    
                                    result = sub_45be5c(arg1, &var_70, &var_90, 0, 
                                        "androidx/loader/app/services/i", "<init>", 
                                        "(Landroid/content/Context;Ljava/lang/Throwable;)V")
                                    
                                    if ((result & 1) == 0)
                                        x2_6 = var_90
                                    label_476700:
                                        var_58 = x0_18
                                        int64_t var_50_1 = x0_4
                                        (*(*arg1 + 0x1f8))(arg1, x0_22, x2_6, &var_58)
                                        result = (*(*arg1 + 0x720))(arg1)
                                        
                                        if ((result & 0xff) == 0)
                                            int64_t x2_8 = var_98
                                            
                                            if (x2_8 != 0)
                                                goto label_476770
                                            
                                            result = sub_45be5c(arg1, &var_68, &var_98, 1, 
                                                "androidx/loader/app/services/", 0x45250c, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;)Z")
                                            
                                            if ((result & 1) == 0)
                                                x2_8 = var_98
                                            label_476770:
                                                var_58 = x0_13
                                                int64_t var_50_2 = x0_22
                                                (*(*arg1 + 0x3b8))(arg1, var_68, x2_8, &var_58)
                                                result = (*(*arg1 + 0x720))(arg1)

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
