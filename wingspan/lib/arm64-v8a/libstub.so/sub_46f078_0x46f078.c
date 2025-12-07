// 函数: sub_46f078
// 地址: 0x46f078
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_60
__builtin_memset(&var_60, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t var_58
int64_t var_48
int32_t x21_1

if ((sub_45be5c(arg1, &var_48, &var_58, 1, "androidx/loader/app/services/", 0x452470, 0x452601) & 1)
        == 0)
    x21_1 = 0
    void var_40
    
    if ((*(*arg1 + 0x418))(arg1, var_48, var_58, &var_40) s>= 1
            && zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_50
        int64_t x2_2 = var_50
        
        if (x2_2 != 0)
            goto label_46f18c
        
        if ((sub_45bc9c(arg1, &var_50, "android/view/View") & 1) != 0)
            x21_1 = 0
        else
            x2_2 = var_50
        label_46f18c:
            
            if ((sub_45bc08(arg1, x0, x2_2, "android/view/View") & 1) != 0)
                x21_1 = 0
            else if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                x21_1 = 0
            else if (x0 == 0)
                sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                x21_1 = 0
            else
                int64_t x2_3 = var_60
                
                if (x2_3 != 0)
                    goto label_46f208
                
                if ((sub_45be5c(arg1, &var_50, &var_60, 0, "android/view/View", "getWidth", 
                        0x452601) & 1) != 0)
                    x21_1 = 0
                else
                    x2_3 = var_60
                label_46f208:
                    x21_1 = (*(*arg1 + 0x198))(arg1, x0, x2_3, &var_40)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        x21_1 = 0
else
    x21_1 = 0

if (*(x22 + 0x28) == x8)
    return zx.q(x21_1)

__stack_chk_fail()
noreturn
