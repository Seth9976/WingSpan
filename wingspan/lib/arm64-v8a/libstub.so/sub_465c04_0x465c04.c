// 函数: sub_465c04
// 地址: 0x465c04
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_60
__builtin_memset(&var_60, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result = 0
int64_t var_48

if ((sub_45be5c(arg1, &var_48, &var_60, 1, "androidx/loader/app/services/", &data_40bfc0, 0x452601)
        & 1) == 0)
    void var_40
    int32_t x0_4 = (*(*arg1 + 0x418))(arg1, var_48, var_60, &var_40)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0 && (x0_4 & 0x80000000) == 0)
        int64_t var_50
        int64_t x2_2 = var_50
        
        if (x2_2 != 0)
            goto label_465d14
        
        if ((sub_45bc9c(arg1, &var_50, "androidx/loader/app/services/h") & 1) != 0)
            result = 0
        else
            x2_2 = var_50
        label_465d14:
            
            if ((sub_45bc08(arg1, x0, x2_2, "androidx/loader/app/services/h") & 1) != 0)
                result = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                result = 0
            else if (x0 == 0)
                sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                result = 0
            else
                int64_t var_58
                int64_t x2_3 = var_58
                
                if (x2_3 != 0)
                    goto label_465d8c
                
                if ((sub_45c03c(arg1, &var_50, &var_58, 0, "androidx/loader/app/services/h", "b", 
                        "Ljava/lang/String;") & 1) != 0)
                    result = 0
                else
                    x2_3 = var_58
                label_465d8c:
                    result = (*(*arg1 + 0x2f8))(arg1, x0, x2_3)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0
    else
        result = 0

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
