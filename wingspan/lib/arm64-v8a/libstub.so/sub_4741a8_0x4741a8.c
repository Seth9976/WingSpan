// 函数: sub_4741a8
// 地址: 0x4741a8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_80
__builtin_memset(&var_80, 0, 0x38)
int64_t result = 0
int64_t var_68
int64_t var_50

if ((sub_45be5c(arg1, &var_50, &var_68, 1, "androidx/loader/app/services/", 0x452a16, 
        "()Ljava/lang/String;") & 1) == 0)
    int64_t result_1
    int64_t result_2 = (*(*arg1 + 0x3a0))(arg1, var_50, var_68, &result_1)
    int64_t var_70
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        result = 0
    else if ((sub_45be5c(arg1, &var_50, &var_70, 1, "androidx/loader/app/services/", 0x452316, 
            "(Ljava/lang/Object;I)[B") & 1) != 0)
        result = 0
    else
        result_1 = result_2
        int32_t var_40_1 = 2
        int64_t result_3 = (*(*arg1 + 0x3a0))(arg1, var_50, var_70, &result_1)
        
        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
            result = 0
        else
            if (result_2 != 0)
                (*(*arg1 + 0xb8))(arg1, result_2)
            
            int64_t var_58
            int64_t x1_6 = var_58
            
            if (x1_6 != 0)
                goto label_474308
            
            if ((sub_45bc9c(arg1, &var_58, "java/io/ByteArrayInputStream") & 1) != 0)
                result = 0
            else
                x1_6 = var_58
            label_474308:
                result = (*(*arg1 + 0xd8))(arg1, x1_6)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    result = 0
                else if (result == 0)
                    sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                else
                    int64_t var_78
                    int64_t x2_4 = var_78
                    
                    if (x2_4 != 0)
                        goto label_47438c
                    
                    if ((sub_45be5c(arg1, &var_58, &var_78, 0, "java/io/ByteArrayInputStream", 
                            "<init>", "([B)V") & 1) != 0)
                        result = 0
                    else
                        x2_4 = var_78
                    label_47438c:
                        result_1 = result_3
                        (*(*arg1 + 0x1f8))(arg1, result, x2_4, &result_1)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                            result = 0
                        else
                            int64_t x2_6 = var_80
                            
                            if (x2_6 != 0)
                                goto label_4743fc
                            
                            int64_t var_60
                            
                            if ((sub_45be5c(arg1, &var_60, &var_80, 1, 
                                    "androidx/loader/app/services/", 0x451df5, 
                                    "(Ljava/lang/Object;)Landroid/graphics/Bitmap;") & 1) != 0)
                                result = 0
                            else
                                x2_6 = var_80
                            label_4743fc:
                                result_1 = result
                                result = (*(*arg1 + 0x3a0))(arg1, var_60, x2_6, &result_1)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    result = 0
                                else if (result_3 != 0)
                                    (*(*arg1 + 0xb8))(arg1, result_3)

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
