// 函数: sub_462180
// 地址: 0x462180
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_60
__builtin_memset(&var_60, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t var_58
int64_t var_48
int32_t result =
    sub_45be5c(arg1, &var_48, &var_58, 1, "androidx/loader/app/services/", 0x451d55, 0x452601)

if ((result & 1) == 0)
    void var_40
    int32_t x0_3 = (*(*arg1 + 0x418))(arg1, var_48, var_58, &var_40)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((x0_3 & 0x80000000) == 0 && (result & 0xff) == 0)
        int64_t var_50
        int64_t x2_2 = var_50
        
        if (x2_2 != 0)
            goto label_462284
        
        result = sub_45bc9c(arg1, &var_50, "android/app/Dialog")
        
        if ((result & 1) == 0)
            x2_2 = var_50
        label_462284:
            result = sub_45bc08(arg1, x0, x2_2, "android/app/Dialog")
            
            if ((result & 1) == 0)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    if (x0 == 0)
                        result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                            "NullPointerException")
                    else
                        int64_t x2_3 = var_60
                        
                        if (x2_3 != 0)
                            (*(*arg1 + 0x1f8))(arg1, x0, x2_3, &var_40)
                            result = (*(*arg1 + 0x720))(arg1)
                        else
                            result = sub_45be5c(arg1, &var_50, &var_60, 0, "android/app/Dialog", 
                                "dismiss", "()V")
                            
                            if ((result & 1) == 0)
                                (*(*arg1 + 0x1f8))(arg1, x0, var_60, &var_40)
                                result = (*(*arg1 + 0x720))(arg1)

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
