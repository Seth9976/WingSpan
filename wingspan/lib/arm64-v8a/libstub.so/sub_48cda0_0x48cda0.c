// 函数: sub_48cda0
// 地址: 0x48cda0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_80
__builtin_memset(&var_80, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result = 0
int64_t var_60

if ((sub_45bc9c(arg1, &var_60, "java/lang/String") & 1) == 0)
    int64_t result_1 = (*(*arg1 + 0xd8))(arg1, var_60)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        result = 0
    else if (x0 == 0)
        sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
        result = 0
    else
        int64_t var_70
        int64_t x2 = var_70
        
        if (x2 != 0)
            goto label_48ceb8
        
        if ((sub_45be5c(arg1, &var_60, &var_70, 0, "java/lang/String", "getBytes", "()[B") & 1)
                != 0)
            result = 0
        else
            x2 = var_70
        label_48ceb8:
            int64_t var_58
            int64_t x0_9 = (*(*arg1 + 0x120))(arg1, x0, x2, &var_58)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                result = 0
            else
                int64_t var_78
                int64_t x2_2 = var_78
                
                if (x2_2 != 0)
                    goto label_48cf14
                
                int64_t var_68
                
                if ((sub_45be5c(arg1, &var_68, &var_78, 1, "android/util/Base64", "decode", 
                        "([BI)[B") & 1) != 0)
                    result = 0
                else
                    x2_2 = var_78
                label_48cf14:
                    var_58 = x0_9
                    int32_t var_50_1 = 0
                    int64_t x0_15 = (*(*arg1 + 0x3a0))(arg1, var_68, x2_2, &var_58)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0
                    else
                        if (x0_9 != 0)
                            (*(*arg1 + 0xb8))(arg1, x0_9)
                        
                        if (result_1 == 0)
                            sub_45bac8(arg1, "java/lang/NullPointerException", 
                                "NullPointerException")
                            result = 0
                        else
                            int64_t x2_4 = var_80
                            
                            if (x2_4 != 0)
                                goto label_48cfa8
                            
                            if ((sub_45be5c(arg1, &var_60, &var_80, 0, "java/lang/String", 
                                    "<init>", "([B)V") & 1) != 0)
                                result = 0
                            else
                                x2_4 = var_80
                            label_48cfa8:
                                var_58 = x0_15
                                (*(*arg1 + 0x1f8))(arg1, result_1, x2_4, &var_58)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                    result = result_1
                                else
                                    result = 0

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
