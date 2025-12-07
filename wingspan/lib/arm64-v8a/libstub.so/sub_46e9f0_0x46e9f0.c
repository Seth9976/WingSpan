// 函数: sub_46e9f0
// 地址: 0x46e9f0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_70
__builtin_memset(&var_70, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg4)
int64_t var_68
int64_t var_58
int32_t x22_2

if ((sub_45be5c(arg1, &var_58, &var_68, 1, "androidx/loader/app/services/", 0x4529be, 0x452601) & 1)
        != 0)
    x22_2 = 0
else
    int64_t var_50
    int32_t x0_6 = (*(*arg1 + 0x418))(arg1, var_58, var_68, &var_50)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0 && (x0_6 & 0x80000000) == 0)
        int64_t var_60
        int64_t x2_2 = var_60
        
        if (x2_2 != 0)
            goto label_46eb20
        
        if ((sub_45bc9c(arg1, &var_60, "java/lang/String") & 1) != 0)
            x22_2 = 0
        else
            x2_2 = var_60
        label_46eb20:
            
            if ((sub_45bc08(arg1, x0, x2_2, "java/lang/String") & 1) != 0)
                x22_2 = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                x22_2 = 0
            else if (x0 == 0)
                sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                x22_2 = 0
            else
                int64_t x2_3 = var_70
                
                if (x2_3 != 0)
                    goto label_46eb84
                
                x22_2 = 0
                
                if ((sub_45be5c(arg1, &var_60, &var_70, 0, "java/lang/String", "equals", 
                        "(Ljava/lang/Object;)Z") & 1) == 0)
                    x2_3 = var_70
                label_46eb84:
                    var_50 = x0_2
                    x22_2 = (*(*arg1 + 0x138))(arg1, x0, x2_3, &var_50)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        x22_2 = 0
    else
        x22_2 = 0

if (*(x23 + 0x28) == x8)
    return zx.q(x22_2)

__stack_chk_fail()
noreturn
