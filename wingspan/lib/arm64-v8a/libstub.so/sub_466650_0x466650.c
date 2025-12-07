// 函数: sub_466650
// 地址: 0x466650
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_70
__builtin_memset(&var_70, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result = 0
int64_t var_68
int64_t var_58

if ((sub_45be5c(arg1, &var_58, &var_68, 1, "androidx/loader/app/services/", &data_40bfc0, 0x452601)
        & 1) == 0)
    result = 0
    void var_50
    
    if (((*(*arg1 + 0x418))(arg1, var_58, var_68, &var_50) & 0x80000000) == 0
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        if (x0 == 0)
            sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
            result = 0
        else
            int64_t x2_2 = var_70
            
            if (x2_2 != 0)
                goto label_466764
            
            int64_t var_60
            
            if ((sub_45be5c(arg1, &var_60, &var_70, 0, "java/lang/Object", "getClass", 
                    "()Ljava/lang/Class;") & 1) != 0)
                result = 0
            else
                x2_2 = var_70
            label_466764:
                result = (*(*arg1 + 0x120))(arg1, x0, x2_2, &var_50)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    result = 0

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
