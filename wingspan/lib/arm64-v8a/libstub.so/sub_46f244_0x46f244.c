// 函数: sub_46f244
// 地址: 0x46f244
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
    sub_45be5c(arg1, &var_60, &var_80, 1, "androidx/loader/app/services/", 0x4529be, 0x452601)

if ((result & 1) == 0)
    int64_t var_58
    int32_t x0_5 = (*(*arg1 + 0x418))(arg1, var_60, var_80, &var_58)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((x0_5 & 0x80000000) == 0 && (result & 0xff) == 0)
        int64_t var_68
        int64_t x2_2 = var_68
        
        if (x2_2 != 0)
            goto label_46f374
        
        result = sub_45bc9c(arg1, &var_68, "android/content/Context")
        
        if ((result & 1) == 0)
            x2_2 = var_68
        label_46f374:
            result = sub_45bc08(arg1, x0, x2_2, "android/content/Context")
            
            if ((result & 1) == 0)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    int64_t var_70
                    int64_t x2_3 = var_70
                    
                    if (x2_3 != 0)
                        goto label_46f3c8
                    
                    result = sub_45bc9c(arg1, &var_70, "org/json/JSONObject")
                    
                    if ((result & 1) == 0)
                        x2_3 = var_70
                    label_46f3c8:
                        result = sub_45bc08(arg1, x0_2, x2_3, "org/json/JSONObject")
                        
                        if ((result & 1) == 0)
                            result = (*(*arg1 + 0x720))(arg1)
                            
                            if ((result & 0xff) == 0)
                                int64_t x2_4 = var_88
                                
                                if (x2_4 != 0)
                                    goto label_46f424
                                
                                int64_t var_78
                                result = sub_45be5c(arg1, &var_78, &var_88, 1, 
                                    "androidx/loader/app/services/l$a", 0x451fe3, 
                                    "(Landroid/content/Context;Lorg/json/JSONObject;)V")
                                
                                if ((result & 1) == 0)
                                    x2_4 = var_88
                                label_46f424:
                                    var_58 = x0
                                    int64_t var_50_1 = x0_2
                                    (*(*arg1 + 0x478))(arg1, var_78, x2_4, &var_58)
                                    result = (*(*arg1 + 0x720))(arg1)

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
