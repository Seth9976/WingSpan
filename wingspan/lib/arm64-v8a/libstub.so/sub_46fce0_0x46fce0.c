// 函数: sub_46fce0
// 地址: 0x46fce0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x25 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x25 + 0x28)
int64_t var_90
__builtin_memset(&var_90, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg4)
int64_t result = 0
int64_t var_88
int64_t var_70

if ((sub_45be5c(arg1, &var_70, &var_88, 1, "androidx/loader/app/services/", &data_40bfc0, 0x452601)
        & 1) == 0)
    result = 0
    int64_t var_68
    
    if (((*(*arg1 + 0x418))(arg1, var_70, var_88, &var_68) & 0x80000000) == 0
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_78
        int64_t x2_2 = var_78
        
        if (x2_2 != 0)
            goto label_46fdf4
        
        if ((sub_45bc9c(arg1, &var_78, "android/content/pm/PackageManager") & 1) != 0)
            result = 0
        else
            x2_2 = var_78
        label_46fdf4:
            
            if ((sub_45bc08(arg1, x0, x2_2, "android/content/pm/PackageManager") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                int64_t var_80
                int64_t x2_3 = var_80
                
                if (x2_3 != 0)
                    goto label_46fe7c
                
                if ((sub_45bc9c(arg1, &var_80, "java/lang/String") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_80
                label_46fe7c:
                    
                    if ((sub_45bc08(arg1, x0_2, x2_3, "java/lang/String") & 1) != 0)
                        result = 0
                    else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0
                    else if (x0 == 0)
                        sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                        result = 0
                    else
                        int64_t x2_4 = var_90
                        
                        if (x2_4 != 0)
                            goto label_46fedc
                        
                        if ((sub_45be5c(arg1, &var_78, &var_90, 0, 
                                "android/content/pm/PackageManager", "getPackageInfo", 
                                "(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;") & 1) != 0)
                            result = 0
                        else
                            x2_4 = var_90
                        label_46fedc:
                            var_68 = x0_2
                            int32_t x4
                            int32_t var_60_1 = x4
                            result = (*(*arg1 + 0x120))(arg1, x0, x2_4, &var_68)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                result = 0
            else
                result = 0

if (*(x25 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
