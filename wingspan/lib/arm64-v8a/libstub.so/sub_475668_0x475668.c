// 函数: sub_475668
// 地址: 0x475668
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_c8
__builtin_memset(&var_c8, 0, 0x40)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int64_t result = 0
int64_t var_90

if ((sub_45bc9c(arg1, &var_90, "java/io/ByteArrayOutputStream") & 1) == 0)
    int64_t x0_6 = (*(*arg1 + 0xd8))(arg1, var_90)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
    labelid_3:
        result = 0
    else if (x0_6 == 0)
        sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
    labelid_3:
        result = 0
    else
        int64_t var_b0
        int64_t x2 = var_b0
        
        if (x2 != 0)
            goto label_4757ac
        
        if ((sub_45be5c(arg1, &var_90, &var_b0, 0, "java/io/ByteArrayOutputStream", "<init>", "()V")
            & 1) != 0)
        labelid_3:
            result = 0
        else
            x2 = var_b0
        label_4757ac:
            int64_t var_88
            (*(*arg1 + 0x1f8))(arg1, x0_6, x2, &var_88)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
            label_475720:
                result = 0
            else
                int64_t x0_16 = (*(*arg1 + 0x580))(arg1, 0x2000)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                label_475720_1:
                    result = 0
                else
                    bool cond:0_1
                    
                    do
                        int64_t var_b8
                        int64_t x2_4 = var_b8
                        int64_t var_98
                        
                        if (x2_4 == 0)
                            if ((sub_45be5c(arg1, &var_98, &var_b8, 1, 
                                    "androidx/loader/app/services/", &data_40e3a7, 
                                    "(Ljava/lang/Object;Ljava/lang/Object;)I") & 1) != 0)
                                goto label_475720_1
                            
                            x2_4 = var_b8
                        
                        var_88 = x0_2
                        int64_t var_80_2 = x0_16
                        int32_t x0_25 = (*(*arg1 + 0x418))(arg1, var_98, x2_4, &var_88)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                            goto label_475720_1
                        
                        if (x0_25 == 0xffffffff)
                            int64_t x2_6 = var_c8
                            int64_t var_a8
                            
                            if (x2_6 == 0)
                                if ((sub_45be5c(arg1, &var_a8, &var_c8, 1, 
                                        "androidx/loader/app/services/", &data_40bd3f, 
                                        "(Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                                    goto label_475720_1
                                
                                x2_6 = var_c8
                            
                            var_88 = x0_6
                            result = (*(*arg1 + 0x3a0))(arg1, var_a8, x2_6, &var_88)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_475720_1
                            
                            if (x0_2 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_2)
                            
                            break
                        
                        int64_t var_c0
                        int64_t x2_2 = var_c0
                        int64_t var_a0
                        
                        if (x2_2 == 0)
                            if ((sub_45be5c(arg1, &var_a0, &var_c0, 1, 
                                    "androidx/loader/app/services/", &data_40bd36, 
                                    "(Ljava/lang/Object;Ljava/lang/Object;II)V") & 1) != 0)
                                goto label_475720_1
                            
                            x2_2 = var_c0
                        
                        var_88 = x0_6
                        int64_t var_80_1 = x0_16
                        int32_t var_78_1 = 0
                        int32_t var_70_1 = x0_25
                        (*(*arg1 + 0x478))(arg1, var_a0, x2_2, &var_88)
                        cond:0_1 = zx.d((*(*arg1 + 0x720))(arg1)) != 0
                        result = 0
                    while (not(cond:0_1))

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
