// 函数: sub_470980
// 地址: 0x470980
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_78
__builtin_memset(&var_78, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg4)
int64_t result = 0
int64_t var_70
int64_t var_58

if ((sub_45be5c(arg1, &var_58, &var_70, 1, "androidx/loader/app/services/", 0x451d55, 0x452601) & 1)
        == 0)
    result = 0
    int64_t var_50
    
    if ((*(*arg1 + 0x418))(arg1, var_58, var_70, &var_50) s>= 1
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_60
        int64_t x2_2 = var_60
        
        if (x2_2 != 0)
            goto label_470a90
        
        if ((sub_45bc9c(arg1, &var_60, "java/lang/StringBuilder") & 1) != 0)
            result = 0
        else
            x2_2 = var_60
        label_470a90:
            
            if ((sub_45bc08(arg1, x0, x2_2, "java/lang/StringBuilder") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                int64_t var_68
                int64_t x2_3 = var_68
                
                if (x2_3 != 0)
                    goto label_470b14
                
                if ((sub_45bc9c(arg1, &var_68, "java/lang/String") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_68
                label_470b14:
                    
                    if ((sub_45bc08(arg1, x0_2, x2_3, "java/lang/String") & 1) != 0)
                        result = 0
                    else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0
                    else if (x0 == 0)
                        sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                        result = 0
                    else
                        int64_t x2_4 = var_78
                        
                        if (x2_4 != 0)
                            goto label_470b74
                        
                        if ((sub_45be5c(arg1, &var_60, &var_78, 0, "java/lang/StringBuilder", 
                                "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;") & 1) != 0)
                            result = 0
                        else
                            x2_4 = var_78
                        label_470b74:
                            var_50 = x0_2
                            result = (*(*arg1 + 0x120))(arg1, x0, x2_4, &var_50)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                result = 0
            else
                result = 0

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
