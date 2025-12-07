// 函数: sub_47b8c4
// 地址: 0x47b8c4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_78
__builtin_memset(&var_78, 0, 0x30)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int64_t result = 0
int64_t var_68
int64_t var_50

if ((sub_45be5c(arg1, &var_50, &var_68, 1, "androidx/loader/app/services/", &data_40ef14, 0x452601)
        & 1) == 0)
    int64_t var_48
    int32_t x0_6 = (*(*arg1 + 0x418))(arg1, var_50, var_68, &var_48)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        result = 0
    else
        int64_t x1_5
        int64_t x2_2
        void* x8_9
        
        if (x0_6 s>= 0x18)
            int64_t var_70
            x2_2 = var_70
            
            if (x2_2 != 0)
                goto label_47ba1c
            
            int64_t var_58
            
            if ((sub_45be5c(arg1, &var_58, &var_70, 1, "androidx/loader/app/services/", 
                    &data_40c82b, "(Ljava/lang/Object;I)Landroid/text/Spanned;") & 1) != 0)
                result = 0
            else
                x2_2 = var_70
            label_47ba1c:
                var_48 = x0_2
                int32_t var_40_1 = 0
                x8_9 = *arg1
                x1_5 = var_58
            label_47ba40:
                result = (*(x8_9 + 0x3a0))(arg1, x1_5, x2_2, &var_48)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    result = 0
                else if (x0_2 != 0)
                    (*(*arg1 + 0xb8))(arg1, x0_2)
        else
            x2_2 = var_78
            
            if (x2_2 != 0)
                goto label_47b9d0
            
            int64_t var_60
            
            if ((sub_45be5c(arg1, &var_60, &var_78, 1, "androidx/loader/app/services/", 
                    &data_40dc23, "(Ljava/lang/Object;)Landroid/text/Spanned;") & 1) == 0)
                x2_2 = var_78
            label_47b9d0:
                var_48 = x0_2
                x8_9 = *arg1
                x1_5 = var_60
                goto label_47ba40
            
            result = 0

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
