// 函数: sub_46b918
// 地址: 0x46b918
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_80
__builtin_memset(&var_80, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t var_78
int64_t var_60
int32_t x22_1

if ((sub_45be5c(arg1, &var_60, &var_78, 1, "androidx/loader/app/services/", 0x452470, 0x452601) & 1)
        == 0)
    x22_1 = 0
    int64_t var_58
    
    if ((*(*arg1 + 0x418))(arg1, var_60, var_78, &var_58) s>= 1
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_68
        int64_t x2_2 = var_68
        
        if (x2_2 != 0)
            goto label_46ba3c
        
        if ((sub_45bc9c(arg1, &var_68, "android/content/res/Resources") & 1) != 0)
            x22_1 = 0
        else
            x2_2 = var_68
        label_46ba3c:
            
            if ((sub_45bc08(arg1, x0, x2_2, "android/content/res/Resources") & 1) != 0)
                x22_1 = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                x22_1 = 0
            else
                int64_t x2_3 = var_80
                
                if (x2_3 != 0)
                    goto label_46ba98
                
                int64_t var_70
                
                if ((sub_45be5c(arg1, &var_70, &var_80, 1, "androidx/loader/app/services/l", 
                        0x451dea, "(Landroid/content/res/Resources;I)I") & 1) != 0)
                    x22_1 = 0
                else
                    x2_3 = var_80
                label_46ba98:
                    var_58 = x0
                    int32_t x3
                    int32_t var_50_1 = x3
                    x22_1 = (*(*arg1 + 0x418))(arg1, var_70, x2_3, &var_58)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        x22_1 = 0
else
    x22_1 = 0

if (*(x23 + 0x28) == x8)
    return zx.q(x22_1)

__stack_chk_fail()
noreturn
