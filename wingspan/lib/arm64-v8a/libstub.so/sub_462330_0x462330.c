// 函数: sub_462330
// 地址: 0x462330
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x26 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x26 + 0x28)
int64_t var_b0
__builtin_memset(&var_b0, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t var_a8
int64_t var_98
int32_t result =
    sub_45be5c(arg1, &var_98, &var_a8, 1, "androidx/loader/app/services/", 0x4529be, 0x452601)

if ((result & 1) == 0)
    int32_t var_90
    int32_t x0_3 = (*(*arg1 + 0x418))(arg1, var_98, var_a8, &var_90)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((x0_3 & 0x80000000) == 0 && (result & 0xff) == 0)
        int64_t var_a0
        int64_t x2_2 = var_a0
        
        if (x2_2 != 0)
            goto label_462460
        
        result = sub_45bc9c(arg1, &var_a0, "android/graphics/Outline")
        
        if ((result & 1) == 0)
            x2_2 = var_a0
        label_462460:
            result = sub_45bc08(arg1, x0, x2_2, "android/graphics/Outline")
            
            if ((result & 1) == 0)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    if (x0 == 0)
                        result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                            "NullPointerException")
                    else
                        int64_t x2_3 = var_b0
                        
                        if (x2_3 != 0)
                            goto label_4624c0
                        
                        result = sub_45be5c(arg1, &var_a0, &var_b0, 0, "android/graphics/Outline", 
                            "setRoundRect", "(IIIIF)V")
                        
                        if ((result & 1) == 0)
                            x2_3 = var_b0
                        label_4624c0:
                            var_90 = arg4
                            int32_t x4
                            int32_t var_88_1 = x4
                            int32_t x5
                            int32_t var_80_1 = x5
                            int32_t x6
                            int32_t var_78_1 = x6
                            int32_t v0
                            int32_t var_70_1 = v0
                            (*(*arg1 + 0x1f8))(arg1, x0, x2_3, &var_90)
                            result = (*(*arg1 + 0x720))(arg1)

if (*(x26 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
