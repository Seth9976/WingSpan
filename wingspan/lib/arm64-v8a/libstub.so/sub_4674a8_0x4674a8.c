// 函数: sub_4674a8
// 地址: 0x4674a8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x26 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x26 + 0x28)
int64_t var_98
__builtin_memset(&var_98, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t var_90
int64_t var_80
int32_t result =
    sub_45be5c(arg1, &var_80, &var_90, 1, "androidx/loader/app/services/", 0x4529be, 0x452601)

if ((result & 1) == 0)
    int32_t var_78
    int32_t x0_3 = (*(*arg1 + 0x418))(arg1, var_80, var_90, &var_78)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((x0_3 & 0x80000000) == 0 && (result & 0xff) == 0)
        int64_t var_88
        int64_t x2_2 = var_88
        
        if (x2_2 != 0)
            goto label_4675cc
        
        result = sub_45bc9c(arg1, &var_88, "android/widget/TextView")
        
        if ((result & 1) == 0)
            x2_2 = var_88
        label_4675cc:
            result = sub_45bc08(arg1, x0, x2_2, "android/widget/TextView")
            
            if ((result & 1) == 0)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    if (x0 == 0)
                        result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                            "NullPointerException")
                    else
                        int64_t x2_3 = var_98
                        
                        if (x2_3 != 0)
                            goto label_46762c
                        
                        result = sub_45be5c(arg1, &var_88, &var_98, 0, "android/widget/TextView", 
                            "setPadding", "(IIII)V")
                        
                        if ((result & 1) == 0)
                            x2_3 = var_98
                        label_46762c:
                            var_78 = arg4
                            int32_t x4
                            int32_t var_70_1 = x4
                            int32_t x5
                            int32_t var_68_1 = x5
                            int32_t x6
                            int32_t var_60_1 = x6
                            (*(*arg1 + 0x1f8))(arg1, x0, x2_3, &var_78)
                            result = (*(*arg1 + 0x720))(arg1)

if (*(x26 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
