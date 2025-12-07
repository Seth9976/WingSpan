// 函数: sub_48ad68
// 地址: 0x48ad68
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_90
__builtin_memset(&var_90, 0, 0x38)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t var_60
int32_t result = sub_45bc9c(arg1, &var_60, "android/os/Handler")

if ((result & 1) == 0)
    int64_t x0_3 = (*(*arg1 + 0xd8))(arg1, var_60)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) == 0)
        int64_t var_78
        int64_t x2 = var_78
        
        if (x2 != 0)
            goto label_48ae4c
        
        int64_t var_68
        result = sub_45be5c(arg1, &var_68, &var_78, 1, "android/os/Looper", "getMainLooper", 
            "()Landroid/os/Looper;")
        
        if ((result & 1) == 0)
            x2 = var_78
        label_48ae4c:
            int64_t var_58
            int64_t x0_7 = (*(*arg1 + 0x3a0))(arg1, var_68, x2, &var_58)
            result = (*(*arg1 + 0x720))(arg1)
            
            if ((result & 0xff) == 0)
                if (x0_3 == 0)
                    result =
                        sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                else
                    int64_t var_80
                    int64_t x2_2 = var_80
                    
                    if (x2_2 != 0)
                        goto label_48aed4
                    
                    result = sub_45be5c(arg1, &var_60, &var_80, 0, "android/os/Handler", "<init>", 
                        "(Landroid/os/Looper;)V")
                    
                    if ((result & 1) == 0)
                        x2_2 = var_80
                    label_48aed4:
                        var_58 = x0_7
                        (*(*arg1 + 0x1f8))(arg1, x0_3, x2_2, &var_58)
                        result = (*(*arg1 + 0x720))(arg1)
                        
                        if ((result & 0xff) == 0)
                            if (x0_7 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_7)
                            
                            int64_t var_70
                            int64_t x1_9 = var_70
                            
                            if (x1_9 != 0)
                                goto label_48af50
                            
                            result = sub_45bc9c(arg1, &var_70, "apkvision/sVMbOPAtE$1")
                            
                            if ((result & 1) == 0)
                                x1_9 = var_70
                            label_48af50:
                                int64_t x0_15 = (*(*arg1 + 0xd8))(arg1, x1_9)
                                result = (*(*arg1 + 0x720))(arg1)
                                
                                if ((result & 0xff) == 0)
                                    if (x0_15 == 0)
                                        result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                                            "NullPointerException")
                                    else
                                        int64_t var_88
                                        int64_t x2_4 = var_88
                                        
                                        if (x2_4 != 0)
                                            goto label_48afb0
                                        
                                        result = sub_45be5c(arg1, &var_70, &var_88, 0, 
                                            "apkvision/sVMbOPAtE$1", "<init>", 
                                            "(Landroid/app/Activity;)V")
                                        
                                        if ((result & 1) == 0)
                                            x2_4 = var_88
                                        label_48afb0:
                                            var_58 = x0
                                            (*(*arg1 + 0x1f8))(arg1, x0_15, x2_4, &var_58)
                                            result = (*(*arg1 + 0x720))(arg1)
                                            
                                            if ((result & 0xff) == 0)
                                                int64_t x2_6 = var_90
                                                
                                                if (x2_6 != 0)
                                                    goto label_48b024
                                                
                                                result = sub_45be5c(arg1, &var_60, &var_90, 0, 
                                                    "android/os/Handler", "postDelayed", 
                                                    "(Ljava/lang/Runnable;J)Z")
                                                
                                                if ((result & 1) == 0)
                                                    x2_6 = var_90
                                                label_48b024:
                                                    var_58 = x0_15
                                                    int64_t var_50_1 = 0x3e8
                                                    (*(*arg1 + 0x138))(arg1, x0_3, x2_6, &var_58)
                                                    result = (*(*arg1 + 0x720))(arg1)

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
