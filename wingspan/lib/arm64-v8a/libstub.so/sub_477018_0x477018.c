// 函数: sub_477018
// 地址: 0x477018
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t var_a8
__builtin_memset(&var_a8, 0, 0x30)
int64_t x0 = (*(*arg1 + 0xc8))()
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_6 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg4))
int64_t x0_8 = (*(*arg1 + 0xc8))(arg1, x0_2)
(*(*arg1 + 0xc8))(arg1, x0)
int64_t var_90
int64_t var_80
int32_t result = sub_45be5c(arg1, &var_80, &var_90, 1, "androidx/loader/app/services/", 0x4528c1, 
    "(Ljava/lang/Object;)I")

if ((result & 1) == 0)
    int64_t var_78 = x0_8
    int32_t x0_12 = (*(*arg1 + 0x418))(arg1, var_80, var_90, &var_78)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) == 0)
        int64_t var_98
        int64_t x2_2 = var_98
        
        if (x2_2 != 0)
            goto label_47717c
        
        result = sub_45be5c(arg1, &var_80, &var_98, 1, "androidx/loader/app/services/", 
            &data_40e8d2, "(Ljava/lang/Object;)I")
        
        if ((result & 1) == 0)
            x2_2 = var_98
        label_47717c:
            var_78 = x0_8
            int32_t x0_16 = (*(*arg1 + 0x418))(arg1, var_80, x2_2, &var_78)
            result = (*(*arg1 + 0x720))(arg1)
            
            if ((result & 0xff) == 0)
                int64_t var_a0
                int64_t x2_4 = var_a0
                
                if (x2_4 != 0)
                    goto label_4771f4
                
                int64_t var_88
                result = sub_45be5c(arg1, &var_88, &var_a0, 1, "androidx/loader/app/services/", 
                    &data_40e1a0, "(F)I")
                
                if ((result & 1) == 0)
                    x2_4 = var_a0
                label_4771f4:
                    var_78.d = 0x41f00000
                    int32_t x0_20 = (*(*arg1 + 0x418))(arg1, var_88, x2_4, &var_78)
                    result = (*(*arg1 + 0x720))(arg1)
                    
                    if ((result & 0xff) == 0)
                        int64_t x0_23 = (*(*arg1 + 0xc8))(arg1, x0_6)
                        int64_t x2_6 = var_a8
                        
                        if (x2_6 != 0)
                            goto label_477288
                        
                        result = sub_45be5c(arg1, &var_88, &var_a8, 1, 
                            "androidx/loader/app/services/", &data_40eda9, 
                            "(Ljava/lang/Object;IIIIF)V")
                        
                        if ((result & 1) == 0)
                            x2_6 = var_a8
                        label_477288:
                            var_78 = x0_23
                            int32_t var_70_1 = 0
                            int32_t var_68_1 = 0
                            int32_t var_60_1 = x0_12
                            int32_t var_58_1 = x0_20 + x0_16
                            int32_t var_50_1 = 0x41f00000
                            (*(*arg1 + 0x478))(arg1, var_88, x2_6, &var_78)
                            result = (*(*arg1 + 0x720))(arg1)

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
