// 函数: sub_475cfc
// 地址: 0x475cfc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_88
__builtin_memset(&var_88, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))()
int64_t x0_4 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int64_t x0_6 = (*(*arg1 + 0xc8))(arg1, x0)
int64_t var_78
int64_t var_68
int32_t result = sub_45be5c(arg1, &var_68, &var_78, 1, "androidx/loader/app/services/", 
    &data_40d432, "(Ljava/lang/Object;)Landroid/content/Context;")

if ((result & 1) == 0)
    int64_t var_60 = x0_6
    int64_t x0_9 = (*(*arg1 + 0x3a0))(arg1, var_68, var_78, &var_60)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) == 0)
        int64_t var_80
        int64_t x2_2 = var_80
        
        if (x2_2 != 0)
            goto label_475e30
        
        result = sub_45be5c(arg1, &var_68, &var_80, 1, "androidx/loader/app/services/", 
            &data_40c042, "(Ljava/lang/Object;)Ljava/lang/String;")
        
        if ((result & 1) == 0)
            x2_2 = var_80
        label_475e30:
            var_60 = x0_6
            int64_t x0_13 = (*(*arg1 + 0x3a0))(arg1, var_68, x2_2, &var_60)
            result = (*(*arg1 + 0x720))(arg1)
            
            if ((result & 0xff) == 0)
                int64_t x2_4 = var_88
                
                if (x2_4 != 0)
                    goto label_475ea4
                
                int64_t var_70
                result = sub_45be5c(arg1, &var_70, &var_88, 1, "androidx/loader/app/services/", 
                    &data_40d6f8, "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V")
                
                if ((result & 1) == 0)
                    x2_4 = var_88
                label_475ea4:
                    var_60 = x0_9
                    int64_t var_58_1 = x0_13
                    int64_t var_50_1 = x0_4
                    (*(*arg1 + 0x478))(arg1, var_70, x2_4, &var_60)
                    result = (*(*arg1 + 0x720))(arg1)

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
