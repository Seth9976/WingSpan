// 函数: sub_47763c
// 地址: 0x47763c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_a8
__builtin_memset(&var_a8, 0, 0x50)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int64_t result = 0
int64_t var_80
int64_t var_60

if ((sub_45be5c(arg1, &var_60, &var_80, 1, "androidx/loader/app/services/", &data_40ef14, 0x452601)
        & 1) == 0)
    int64_t var_58
    int32_t x0_6 = (*(*arg1 + 0x418))(arg1, var_60, var_80, &var_58)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
        int64_t var_88
        int64_t x2_2 = var_88
        int64_t var_68
        int64_t x1_13
        int64_t x2_8
        void* x8_28
        
        if (x0_6 s>= 0x22)
            if (x2_2 != 0)
                goto label_47798c
            
            if ((sub_45be5c(arg1, &var_68, &var_88, 1, "androidx/loader/app/services/", 
                    &data_40e5d2, "()Ljava/nio/charset/Charset;") & 1) != 0)
                result = 0
            else
                x2_2 = var_88
            label_47798c:
                int64_t x0_39 = (*(*arg1 + 0x3a0))(arg1, var_68, x2_2, &var_58)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    result = 0
                else
                    int64_t var_90
                    x2_8 = var_90
                    
                    if (x2_8 != 0)
                        goto label_4779e8
                    
                    int64_t var_70
                    
                    if ((sub_45be5c(arg1, &var_70, &var_90, 1, "androidx/loader/app/services/", 
                            &data_40f53e, 
                            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                        result = 0
                    else
                        x2_8 = var_90
                    label_4779e8:
                        var_58 = x0_2
                        int64_t var_50_2 = x0_39
                        x8_28 = *arg1
                        x1_13 = var_70
                    label_477a08:
                        result = (*(x8_28 + 0x3a0))(arg1, x1_13, x2_8, &var_58)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                            result = 0
                        else
                        label_477a20:
                            
                            if (x0_2 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_2)
        else
            if (x2_2 != 0)
                goto label_477798
            
            int64_t var_78
            
            if ((sub_45be5c(arg1, &var_68, &var_88, 1, "androidx/loader/app/services/", 
                    &data_40e5d2, "()Ljava/nio/charset/Charset;") & 1) == 0)
                x2_2 = var_88
            label_477798:
                int64_t x0_13 = (*(*arg1 + 0x3a0))(arg1, var_68, x2_2, &var_58)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_4778c4
                
                int64_t var_98
                int64_t x2_4 = var_98
                
                if (x2_4 == 0)
                    if ((sub_45be5c(arg1, &var_78, &var_98, 1, "androidx/loader/app/services/", 
                            &data_40cfce, "(Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                        goto label_4778c4
                    
                    x2_4 = var_98
                
                var_58 = x0_13
                int64_t x0_19 = (*(*arg1 + 0x3a0))(arg1, var_78, x2_4, &var_58)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_4778c4
                
                if (x0_13 != 0)
                    (*(*arg1 + 0xb8))(arg1, x0_13)
                
                int64_t var_a0
                int64_t x2_7 = var_a0
                
                if (x2_7 == 0)
                    if ((sub_45be5c(arg1, &var_68, &var_a0, 1, "androidx/loader/app/services/", 
                            &data_40cad7, 
                            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                        goto label_4778c4
                    
                    x2_7 = var_a0
                
                var_58 = x0_2
                int64_t var_50_1 = x0_19
                result = (*(*arg1 + 0x3a0))(arg1, var_68, x2_7, &var_58)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                    goto label_477a20
                
                goto label_4778c4
            
        label_4778c4:
            uint64_t x0_30 = (*(*arg1 + 0x78))(arg1)
            (*(*arg1 + 0x88))(arg1)
            
            if ((sub_45bb84(arg1, x0_30, "java/io/UnsupportedEncodingException") & 1) == 0)
                (*(*arg1 + 0x68))(arg1, x0_30)
                (*(*arg1 + 0xb8))(arg1, x0_30)
                result = 0
            else
                x2_8 = var_a8
                
                if (x2_8 != 0)
                    goto label_477930
                
                if ((sub_45be5c(arg1, &var_78, &var_a8, 1, "androidx/loader/app/services/", 
                        &data_40bd67, "(Ljava/lang/Object;)Ljava/lang/String;") & 1) == 0)
                    x2_8 = var_a8
                label_477930:
                    var_58 = x0_2
                    x8_28 = *arg1
                    x1_13 = var_78
                    goto label_477a08
                
                result = 0
    else
        result = 0

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
