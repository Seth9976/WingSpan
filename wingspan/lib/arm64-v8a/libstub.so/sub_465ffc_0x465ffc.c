// 函数: sub_465ffc
// 地址: 0x465ffc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_88
__builtin_memset(&var_88, 0, 0x30)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg4)
int64_t var_80
int64_t var_60
int32_t result =
    sub_45be5c(arg1, &var_60, &var_80, 1, "androidx/loader/app/services/", &data_40bfc0, 0x452601)

if ((result & 1) == 0)
    int64_t var_58
    int32_t x0_5 = (*(*arg1 + 0x418))(arg1, var_60, var_80, &var_58)
    result = (*(*arg1 + 0x720))(arg1)
    
    if (x0_5 s>= 1 && (result & 0xff) == 0)
        int64_t var_68
        int64_t x2_2 = var_68
        
        if (x2_2 != 0)
            goto label_466130
        
        result = sub_45bc9c(arg1, &var_68, "android/app/AlertDialog")
        
        if ((result & 1) == 0)
            x2_2 = var_68
        label_466130:
            result = sub_45bc08(arg1, x0, x2_2, "android/app/AlertDialog")
            
            if ((result & 1) == 0)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    int64_t var_70
                    int64_t x2_3 = var_70
                    
                    if (x2_3 != 0)
                        goto label_466184
                    
                    result = sub_45bc9c(arg1, &var_70, "android/view/View")
                    
                    if ((result & 1) == 0)
                        x2_3 = var_70
                    label_466184:
                        result = sub_45bc08(arg1, x0_2, x2_3, "android/view/View")
                        
                        if ((result & 1) == 0)
                            result = (*(*arg1 + 0x720))(arg1)
                            
                            if ((result & 0xff) == 0)
                                int64_t x2_4 = var_88
                                
                                if (x2_4 != 0)
                                    goto label_4661e0
                                
                                int64_t var_78
                                result = sub_45be5c(arg1, &var_78, &var_88, 1, 
                                    "androidx/loader/app/services/l", "m", 
                                    "(Landroid/app/AlertDialog;Landroid/view/View;)V")
                                
                                if ((result & 1) == 0)
                                    x2_4 = var_88
                                label_4661e0:
                                    var_58 = x0
                                    int64_t var_50_1 = x0_2
                                    (*(*arg1 + 0x478))(arg1, var_78, x2_4, &var_58)
                                    result = (*(*arg1 + 0x720))(arg1)

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
