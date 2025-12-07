// 函数: sub_46e49c
// 地址: 0x46e49c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_70
__builtin_memset(&var_70, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t var_68
int64_t var_58
int32_t x21_1

if ((sub_45be5c(arg1, &var_58, &var_68, 1, "androidx/loader/app/services/", 0x4529be, 0x452601) & 1)
        == 0)
    x21_1 = 0
    void var_50
    
    if (((*(*arg1 + 0x418))(arg1, var_58, var_68, &var_50) & 0x80000000) == 0
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_60
        int64_t x2_2 = var_60
        
        if (x2_2 != 0)
            goto label_46e5b4
        
        if ((sub_45bc9c(arg1, &var_60, "java/net/HttpURLConnection") & 1) != 0)
            x21_1 = 0
        else
            x2_2 = var_60
        label_46e5b4:
            
            if ((sub_45bc08(arg1, x0, x2_2, "java/net/HttpURLConnection") & 1) != 0)
                x21_1 = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                x21_1 = 0
            else if (x0 == 0)
                sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                x21_1 = 0
            else
                int64_t x2_3 = var_70
                
                if (x2_3 != 0)
                    goto label_46e630
                
                if ((sub_45be5c(arg1, &var_60, &var_70, 0, "java/net/HttpURLConnection", 
                        "getResponseCode", 0x452601) & 1) != 0)
                    x21_1 = 0
                else
                    x2_3 = var_70
                label_46e630:
                    x21_1 = (*(*arg1 + 0x198))(arg1, x0, x2_3, &var_50)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        x21_1 = 0
else
    x21_1 = 0

if (*(x23 + 0x28) == x8)
    return zx.q(x21_1)

__stack_chk_fail()
noreturn
