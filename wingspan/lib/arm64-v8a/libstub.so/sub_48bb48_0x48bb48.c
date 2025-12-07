// 函数: sub_48bb48
// 地址: 0x48bb48
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_88
__builtin_memset(&var_88, 0, 0x38)
int64_t x0 = (*(*arg1 + 0x538))(arg1, "1C05")
int64_t var_70
int64_t var_58
uint64_t result

if ((sub_45be5c(arg1, &var_58, &var_70, 1, "apkvision/NPStringFog", "decode", 
        "(Ljava/lang/String;)Ljava/lang/String;") & 1) != 0)
    result = 0
else
    int64_t var_50 = x0
    int64_t x0_4 = (*(*arg1 + 0x3a0))(arg1, var_58, var_70, &var_50)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        result = 0
    else
        if (x0 != 0)
            (*(*arg1 + 0xb8))(arg1, x0)
        
        int64_t var_78
        int64_t x2_3 = var_78
        
        if (x2_3 != 0)
            goto label_48bc6c
        
        int64_t var_60
        
        if ((sub_45be5c(arg1, &var_60, &var_78, 1, "java/util/Locale", "getDefault", 
                "()Ljava/util/Locale;") & 1) != 0)
            result = 0
        else
            x2_3 = var_78
        label_48bc6c:
            int64_t x0_11 = (*(*arg1 + 0x3a0))(arg1, var_60, x2_3, &var_50)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                result = 0
            else if (x0_11 == 0)
                sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                result = 0
            else
                int64_t var_80
                int64_t x2_4 = var_80
                
                if (x2_4 != 0)
                    goto label_48bce8
                
                result = 0
                
                if ((sub_45be5c(arg1, &var_60, &var_80, 0, "java/util/Locale", "getLanguage", 
                        "()Ljava/lang/String;") & 1) == 0)
                    x2_4 = var_80
                label_48bce8:
                    int64_t x0_17 = (*(*arg1 + 0x120))(arg1, x0_11, x2_4, &var_50)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0
                    else
                        (*(*arg1 + 0xb8))(arg1, x0_11)
                        
                        if (x0_4 == 0)
                            sub_45bac8(arg1, "java/lang/NullPointerException", 
                                "NullPointerException")
                            result = 0
                        else
                            int64_t x2_6 = var_88
                            
                            if (x2_6 != 0)
                                goto label_48bd64
                            
                            result = 0
                            int64_t var_68
                            
                            if ((sub_45be5c(arg1, &var_68, &var_88, 0, "java/lang/String", 
                                    "equalsIgnoreCase", "(Ljava/lang/String;)Z") & 1) == 0)
                                x2_6 = var_88
                            label_48bd64:
                                var_50 = x0_17
                                char x0_24 = (*(*arg1 + 0x138))(arg1, x0_4, x2_6, &var_50)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    result = 0
                                else if (zx.d(x0_24) == 0)
                                    (*(*arg1 + 0xb8))(arg1, x0_4)
                                    int64_t x0_29 = (*(*arg1 + 0x538))(arg1, "1B11")
                                    int64_t x2_8 = var_70
                                    
                                    if (x2_8 != 0)
                                        goto label_48be18
                                    
                                    if ((sub_45be5c(arg1, &var_58, &var_70, 1, 
                                            "apkvision/NPStringFog", "decode", 
                                            "(Ljava/lang/String;)Ljava/lang/String;") & 1) != 0)
                                        result = 0
                                    else
                                        x2_8 = var_70
                                    label_48be18:
                                        var_50 = x0_29
                                        int64_t x0_33 =
                                            (*(*arg1 + 0x3a0))(arg1, var_58, x2_8, &var_50)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            result = 0
                                        else
                                            if (x0_29 != 0)
                                                (*(*arg1 + 0xb8))(arg1, x0_29)
                                            
                                            if (x0_33 == 0)
                                                sub_45bac8(arg1, "java/lang/NullPointerException", 
                                                    "NullPointerException")
                                                result = 0
                                            else
                                                int64_t x2_10 = var_88
                                                
                                                if (x2_10 != 0)
                                                    goto label_48beb0
                                                
                                                result = 0
                                                
                                                if ((sub_45be5c(arg1, &var_68, &var_88, 0, 
                                                        "java/lang/String", "equalsIgnoreCase", 
                                                        "(Ljava/lang/String;)Z") & 1) == 0)
                                                    x2_10 = var_88
                                                label_48beb0:
                                                    var_50 = x0_17
                                                    char x0_40 = (*(*arg1 + 0x138))(arg1, x0_33, 
                                                        x2_10, &var_50)
                                                    
                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                        result = 0
                                                    else
                                                        result = zx.q(zx.d(x0_40) != 0 ? 1 : 0)
                                else
                                    result = 1

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
