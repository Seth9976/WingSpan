// 函数: sub_475b7c
// 地址: 0x475b7c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_68
__builtin_memset(&var_68, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))()
int64_t x0_4 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int64_t x0_6 = (*(*arg1 + 0xc8))(arg1, x0)
int64_t var_60
int64_t var_50
int32_t result = sub_45be5c(arg1, &var_50, &var_60, 1, "androidx/loader/app/services/", 
    &data_40eb67, "(Ljava/lang/Object;)Landroid/app/AlertDialog;")

if ((result & 1) == 0)
    int64_t var_48 = x0_6
    int64_t x0_9 = (*(*arg1 + 0x3a0))(arg1, var_50, var_60, &var_48)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) == 0)
        int64_t x2_2 = var_68
        
        if (x2_2 != 0)
            goto label_475ca8
        
        int64_t var_58
        result = sub_45be5c(arg1, &var_58, &var_68, 1, "androidx/loader/app/services/", 
            &data_40f0a1, "(Ljava/lang/Object;Ljava/lang/Object;)V")
        
        if ((result & 1) == 0)
            x2_2 = var_68
        label_475ca8:
            var_48 = x0_9
            int64_t var_40_1 = x0_4
            (*(*arg1 + 0x478))(arg1, var_58, x2_2, &var_48)
            result = (*(*arg1 + 0x720))(arg1)

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
