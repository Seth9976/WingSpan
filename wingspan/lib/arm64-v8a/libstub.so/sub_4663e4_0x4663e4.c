// 函数: sub_4663e4
// 地址: 0x4663e4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t var_80
__builtin_memset(&var_80, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg4)
int64_t x0_4 = (*(*arg1 + 0xc8))(arg1, arg5)
int64_t result = 0
int64_t var_78
int64_t var_60

if ((sub_45be5c(arg1, &var_60, &var_78, 1, "androidx/loader/app/services/", 0x452470, 0x452601) & 1)
        == 0)
    result = 0
    int64_t var_58
    
    if ((*(*arg1 + 0x418))(arg1, var_60, var_78, &var_58) s>= 1
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_68
        int64_t x2_2 = var_68
        
        if (x2_2 != 0)
            goto label_466510
        
        if ((sub_45bc9c(arg1, &var_68, "java/lang/reflect/Method") & 1) != 0)
            result = 0
        else
            x2_2 = var_68
        label_466510:
            
            if ((sub_45bc08(arg1, x0, x2_2, "java/lang/reflect/Method") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                int64_t var_70
                int64_t x2_3 = var_70
                
                if (x2_3 != 0)
                    goto label_466594
                
                if ((sub_45bc9c(arg1, &var_70, "[Ljava/lang/Object;") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_70
                label_466594:
                    
                    if ((sub_45bc08(arg1, x0_4, x2_3, "[Ljava/lang/Object;") & 1) != 0)
                        result = 0
                    else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0
                    else if (x0 == 0)
                        sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                        result = 0
                    else
                        int64_t x2_4 = var_80
                        
                        if (x2_4 != 0)
                            goto label_4665f4
                        
                        if ((sub_45be5c(arg1, &var_68, &var_80, 0, "java/lang/reflect/Method", 
                                "invoke", 
                                "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;") & 1) != 0)
                            result = 0
                        else
                            x2_4 = var_80
                        label_4665f4:
                            var_58 = x0_2
                            int64_t var_50_1 = x0_4
                            result = (*(*arg1 + 0x120))(arg1, x0, x2_4, &var_58)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                result = 0
            else
                result = 0

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
