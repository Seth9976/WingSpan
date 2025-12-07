// 函数: sub_470bd0
// 地址: 0x470bd0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t var_90
__builtin_memset(&var_90, 0, 0x30)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg4)
int64_t result = 0
int64_t var_88
int64_t var_68

if ((sub_45be5c(arg1, &var_68, &var_88, 1, "androidx/loader/app/services/", 0x451d55, 0x452601) & 1)
        == 0)
    result = 0
    int64_t var_60
    
    if ((*(*arg1 + 0x418))(arg1, var_68, var_88, &var_60) s>= 1
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_70
        int64_t x2_2 = var_70
        
        if (x2_2 != 0)
            goto label_470ce4
        
        if ((sub_45bc9c(arg1, &var_70, "android/content/Context") & 1) != 0)
            result = 0
        else
            x2_2 = var_70
        label_470ce4:
            
            if ((sub_45bc08(arg1, x0, x2_2, "android/content/Context") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                int64_t var_78
                int64_t x2_3 = var_78
                
                if (x2_3 != 0)
                    goto label_470d68
                
                if ((sub_45bc9c(arg1, &var_78, "java/lang/CharSequence") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_78
                label_470d68:
                    
                    if ((sub_45bc08(arg1, x0_2, x2_3, "java/lang/CharSequence") & 1) != 0)
                        result = 0
                    else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0
                    else
                        int64_t x2_4 = var_90
                        
                        if (x2_4 != 0)
                            goto label_470dc4
                        
                        int64_t var_80
                        
                        if ((sub_45be5c(arg1, &var_80, &var_90, 1, "android/widget/Toast", 
                                "makeText", 
                                "(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;")
                                & 1) != 0)
                            result = 0
                        else
                            x2_4 = var_90
                        label_470dc4:
                            var_60 = x0
                            int64_t var_58_1 = x0_2
                            int32_t x4
                            int32_t var_50_1 = x4
                            result = (*(*arg1 + 0x3a0))(arg1, var_80, x2_4, &var_60)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                result = 0
            else
                result = 0

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
