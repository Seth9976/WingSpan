// 函数: sub_4759b8
// 地址: 0x4759b8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_70
__builtin_memset(&var_70, 0, 0x28)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))())
int64_t var_60
int64_t var_50
int32_t result = sub_45be5c(arg1, &var_50, &var_60, 1, "androidx/loader/app/services/", 0x451e00, 
    "(Ljava/lang/Object;)Ljava/lang/String;")

if ((result & 1) == 0)
    int64_t var_48 = x0_2
    int64_t x0_5 = (*(*arg1 + 0x3a0))(arg1, var_50, var_60, &var_48)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) == 0)
        int64_t var_68
        int64_t x2_2 = var_68
        
        if (x2_2 != 0)
            goto label_475ab4
        
        result = sub_45be5c(arg1, &var_50, &var_68, 1, "androidx/loader/app/services/", 
            &data_40c050, "(Ljava/lang/Object;)Landroid/content/Context;")
        
        if ((result & 1) == 0)
            x2_2 = var_68
        label_475ab4:
            var_48 = x0_2
            int64_t x0_9 = (*(*arg1 + 0x3a0))(arg1, var_50, x2_2, &var_48)
            result = (*(*arg1 + 0x720))(arg1)
            
            if ((result & 0xff) == 0)
                int64_t x2_4 = var_70
                
                if (x2_4 != 0)
                    goto label_475b28
                
                int64_t var_58
                result = sub_45be5c(arg1, &var_58, &var_70, 1, "androidx/loader/app/services/", 
                    0x451be2, "(Ljava/lang/Object;Ljava/lang/Object;)V")
                
                if ((result & 1) == 0)
                    x2_4 = var_70
                label_475b28:
                    var_48 = x0_5
                    int64_t var_40_1 = x0_9
                    (*(*arg1 + 0x478))(arg1, var_58, x2_4, &var_48)
                    result = (*(*arg1 + 0x720))(arg1)

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
