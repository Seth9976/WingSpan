// 函数: sub_45ff48
// 地址: 0x45ff48
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_88
__builtin_memset(&var_88, 0, 0x30)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg4)
int64_t result = 0
int64_t var_80
int64_t var_60

if ((sub_45be5c(arg1, &var_60, &var_80, 1, "androidx/loader/app/services/", 0x451d55, 0x452601) & 1)
        == 0)
    result = 0
    int64_t var_58
    
    if ((*(*arg1 + 0x418))(arg1, var_60, var_80, &var_58) s>= 1
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_68
        int64_t x2_2 = var_68
        
        if (x2_2 != 0)
            goto label_46005c
        
        if ((sub_45bc9c(arg1, &var_68, "android/content/res/AssetManager") & 1) != 0)
            result = 0
        else
            x2_2 = var_68
        label_46005c:
            
            if ((sub_45bc08(arg1, x0, x2_2, "android/content/res/AssetManager") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                int64_t var_70
                int64_t x2_3 = var_70
                
                if (x2_3 != 0)
                    goto label_4600e0
                
                if ((sub_45bc9c(arg1, &var_70, "java/lang/String") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_70
                label_4600e0:
                    
                    if ((sub_45bc08(arg1, x0_2, x2_3, "java/lang/String") & 1) != 0)
                        result = 0
                    else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0
                    else
                        int64_t x2_4 = var_88
                        
                        if (x2_4 != 0)
                            goto label_46013c
                        
                        int64_t var_78
                        
                        if ((sub_45be5c(arg1, &var_78, &var_88, 1, "android/graphics/Typeface", 
                                "createFromAsset", 
                                "(Landroid/content/res/AssetManager;Ljava/lang/String;"
                        ")Landroid/graphics/Typeface;") & 1) != 0)
                            result = 0
                        else
                            x2_4 = var_88
                        label_46013c:
                            var_58 = x0
                            int64_t var_50_1 = x0_2
                            result = (*(*arg1 + 0x3a0))(arg1, var_78, x2_4, &var_58)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                result = 0
            else
                result = 0

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
