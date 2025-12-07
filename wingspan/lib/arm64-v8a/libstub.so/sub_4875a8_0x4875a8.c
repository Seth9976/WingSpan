// 函数: sub_4875a8
// 地址: 0x4875a8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x26 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x26 + 0x28)
int64_t var_e8
__builtin_memset(&var_e8, 0, 0x70)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int64_t result = 0
int64_t var_80

if ((sub_45bc9c(arg1, &var_80, "java/io/ByteArrayOutputStream") & 1) == 0)
    int64_t x0_6 = (*(*arg1 + 0xd8))(arg1, var_80)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
    labelid_3:
        result = 0
    else
        int64_t var_a8
        int64_t x2 = var_a8
        
        if (x2 != 0)
            goto label_4876ac
        
        int64_t var_88
        
        if ((sub_45be5c(arg1, &var_88, &var_a8, 1, "apkvision/", &data_40ef33, 
            "(Ljava/lang/Object;)I") & 1) != 0)
        labelid_3:
            result = 0
        else
            x2 = var_a8
        label_4876ac:
            int64_t var_78 = x0_2
            int32_t x0_12 = (*(*arg1 + 0x418))(arg1, var_88, x2, &var_78)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                int32_t x22_2
                
                if (x0_12 s< 0)
                    x22_2 = x0_12 + 1
                else
                    x22_2 = x0_12
                
                char* const x1_45
                char* const x2_34
                
                if (x0_6 == 0)
                label_487fcc:
                    x1_45 = "java/lang/NullPointerException"
                    x2_34 = "NullPointerException"
                label_487fd8:
                    sub_45bac8(arg1, x1_45, x2_34)
                labelid_3:
                    result = 0
                else
                    int64_t var_b0
                    int64_t x2_2 = var_b0
                    
                    if (x2_2 != 0)
                        goto label_487764
                    
                    if ((sub_45be5c(arg1, &var_80, &var_b0, 0, "java/io/ByteArrayOutputStream", 
                        "<init>", "(I)V") & 1) != 0)
                    labelid_3:
                        result = 0
                    else
                        x2_2 = var_b0
                    label_487764:
                        var_78.d = x22_2 s>> 1
                        (*(*arg1 + 0x1f8))(arg1, x0_6, x2_2, &var_78)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        label_4876e4:
                            result = 0
                        else
                            int64_t x25_1 = 0
                            int64_t x23_1 = 0
                            int32_t x22_3 = 0
                            bool cond:0_1
                            
                            do
                                int64_t x2_6 = var_a8
                                
                                if (x2_6 == 0)
                                    if ((sub_45be5c(arg1, &var_88, &var_a8, 1, "apkvision/", 
                                            &data_40ef33, "(Ljava/lang/Object;)I") & 1) != 0)
                                        goto label_4876e4_1
                                    
                                    x2_6 = var_a8
                                
                                var_78 = x0_2
                                int32_t x0_26 = (*(*arg1 + 0x418))(arg1, var_88, x2_6, &var_78)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_4876e4_1
                                
                                int64_t var_c0
                                int64_t var_98
                                int64_t var_90
                                
                                if (x22_3 s>= x0_26)
                                    int64_t var_d8
                                    int64_t x2_20 = var_d8
                                    
                                    if (x2_20 == 0)
                                        if ((sub_45be5c(arg1, &var_88, &var_d8, 1, "apkvision/", 
                                                &data_40dc35, "(Ljava/lang/Object;)[B") & 1) != 0)
                                            goto label_4876e4_1
                                        
                                        x2_20 = var_d8
                                    
                                    var_78 = x0_6
                                    int64_t x0_72 = (*(*arg1 + 0x3a0))(arg1, var_88, x2_20, &var_78)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_4876e4_1
                                    
                                    if (x0_72 == 0)
                                        goto label_487fcc
                                    
                                    int32_t x0_76 = (*(*arg1 + 0x558))(arg1, x0_72)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_4876e4_1
                                    
                                    int64_t var_e0
                                    int64_t x2_22 = var_e0
                                    
                                    if (x2_22 == 0)
                                        if ((sub_45be5c(arg1, &var_98, &var_e0, 1, "apkvision/", 
                                                &data_40d518, "()Ljava/lang/String;") & 1) != 0)
                                            goto label_4876e4_1
                                        
                                        x2_22 = var_e0
                                    
                                    int64_t x0_82 = (*(*arg1 + 0x3a0))(arg1, var_98, x2_22, &var_78)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_4876e4_1
                                    
                                    if (x25_1 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x25_1)
                                    
                                    int64_t x2_25 = var_a8
                                    
                                    if (x2_25 == 0)
                                        if ((sub_45be5c(arg1, &var_88, &var_a8, 1, "apkvision/", 
                                                &data_40ef33, "(Ljava/lang/Object;)I") & 1) != 0)
                                            goto label_4876e4_1
                                        
                                        x2_25 = var_a8
                                    
                                    var_78 = x0_82
                                    int32_t x0_89 = (*(*arg1 + 0x418))(arg1, var_88, x2_25, &var_78)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_4876e4_1
                                    
                                    if (x0_76 s>= 1)
                                        int32_t x23_4 = 0
                                        int64_t x27_1 = 0
                                        
                                        do
                                            (*(*arg1 + 0x640))(arg1, x0_72, zx.q(x23_4), 1, &var_78)
                                            char x25_4 = var_78.b
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                goto label_4876e4_1
                                            
                                            int64_t x2_27 = var_e0
                                            
                                            if (x2_27 == 0)
                                                if ((sub_45be5c(arg1, &var_98, &var_e0, 1, 
                                                        "apkvision/", &data_40d518, 
                                                        "()Ljava/lang/String;") & 1) != 0)
                                                    goto label_4876e4_1
                                                
                                                x2_27 = var_e0
                                            
                                            int64_t x0_98 =
                                                (*(*arg1 + 0x3a0))(arg1, var_98, x2_27, &var_78)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                goto label_4876e4_1
                                            
                                            if (x27_1 != 0)
                                                (*(*arg1 + 0xb8))(arg1, x27_1)
                                            
                                            if (x0_89 == 0)
                                                x1_45 = "java/lang/ArithmeticException"
                                                x2_34 = "divide by zero"
                                                goto label_487fd8
                                            
                                            int64_t x2_29 = var_c0
                                            
                                            if (x2_29 == 0)
                                                if ((sub_45be5c(arg1, &var_90, &var_c0, 1, 
                                                        "apkvision/", &data_40e3d8, 
                                                        "(Ljava/lang/Object;I)C") & 1) != 0)
                                                    goto label_4876e4_1
                                                
                                                x2_29 = var_c0
                                            
                                            var_78 = x0_98
                                            int32_t var_70_6 = x23_4 s% x0_89
                                            char x0_105 =
                                                (*(*arg1 + 0x3e8))(arg1, var_90, x2_29, &var_78)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                goto label_4876e4_1
                                            
                                            var_78.b = x25_4 ^ x0_105
                                            (*(*arg1 + 0x680))(arg1, x0_72, zx.q(x23_4), 1, &var_78)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                goto label_4876e4_1
                                            
                                            x23_4 += 1
                                            x27_1 = x0_98
                                        while (x0_76 != x23_4)
                                    
                                    int64_t var_a0
                                    int64_t x1_42 = var_a0
                                    
                                    if (x1_42 == 0)
                                        if ((sub_45bc9c(arg1, &var_a0, "java/lang/String") & 1)
                                                != 0)
                                            goto label_4876e4_1
                                        
                                        x1_42 = var_a0
                                    
                                    int64_t result_1 = (*(*arg1 + 0xd8))(arg1, x1_42)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_4876e4_1
                                    
                                    if (result_1 == 0)
                                        goto label_487fcc
                                    
                                    int64_t x2_32 = var_e8
                                    
                                    if (x2_32 == 0)
                                        if ((sub_45be5c(arg1, &var_a0, &var_e8, 0, 
                                                "java/lang/String", "<init>", "([B)V") & 1) != 0)
                                            goto label_4876e4_1
                                        
                                        x2_32 = var_e8
                                    
                                    var_78 = x0_72
                                    (*(*arg1 + 0x1f8))(arg1, result_1, x2_32, &var_78)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                        result = result_1
                                    else
                                        result = 0
                                    
                                    break
                                
                                int64_t var_b8
                                int64_t x2_7 = var_b8
                                
                                if (x2_7 == 0)
                                    if ((sub_45be5c(arg1, &var_88, &var_b8, 1, "apkvision/", 
                                            &data_40d73f, "()Ljava/lang/String;") & 1) != 0)
                                        goto label_4876e4_1
                                    
                                    x2_7 = var_b8
                                
                                int64_t x0_32 = (*(*arg1 + 0x3a0))(arg1, var_88, x2_7, &var_78)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_4876e4_1
                                
                                if (x23_1 != 0)
                                    (*(*arg1 + 0xb8))(arg1, x23_1)
                                
                                int64_t x2_10 = var_c0
                                
                                if (x2_10 == 0)
                                    if ((sub_45be5c(arg1, &var_90, &var_c0, 1, "apkvision/", 
                                            &data_40e3d8, "(Ljava/lang/Object;I)C") & 1) != 0)
                                        goto label_4876e4_1
                                    
                                    x2_10 = var_c0
                                
                                var_78 = x0_2
                                int32_t var_70_2 = x22_3
                                int16_t x0_39 = (*(*arg1 + 0x3e8))(arg1, var_90, x2_10, &var_78)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_4876e4_1
                                
                                int64_t var_c8
                                int64_t x2_11 = var_c8
                                
                                if (x2_11 == 0)
                                    if ((sub_45be5c(arg1, &var_90, &var_c8, 1, "apkvision/", 
                                            &data_40c8c9, "(Ljava/lang/Object;I)I") & 1) != 0)
                                        goto label_4876e4_1
                                    
                                    x2_11 = var_c8
                                
                                var_78 = x0_32
                                uint32_t var_70_3 = zx.d(x0_39)
                                int32_t x0_45 = (*(*arg1 + 0x418))(arg1, var_90, x2_11, &var_78)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_4876e4_1
                                
                                int64_t x2_13 = var_b8
                                
                                if (x2_13 == 0)
                                    if ((sub_45be5c(arg1, &var_88, &var_b8, 1, "apkvision/", 
                                            &data_40d73f, "()Ljava/lang/String;") & 1) != 0)
                                        goto label_4876e4_1
                                    
                                    x2_13 = var_b8
                                
                                int64_t x0_51 = (*(*arg1 + 0x3a0))(arg1, var_88, x2_13, &var_78)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_4876e4_1
                                
                                if (x25_1 != 0)
                                    (*(*arg1 + 0xb8))(arg1, x25_1)
                                
                                int64_t x2_16 = var_c0
                                
                                if (x2_16 == 0)
                                    if ((sub_45be5c(arg1, &var_90, &var_c0, 1, "apkvision/", 
                                            &data_40e3d8, "(Ljava/lang/Object;I)C") & 1) != 0)
                                        goto label_4876e4_1
                                    
                                    x2_16 = var_c0
                                
                                var_78 = x0_2
                                int32_t var_70_4 = x22_3 + 1
                                int16_t x0_58 = (*(*arg1 + 0x3e8))(arg1, var_90, x2_16, &var_78)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_4876e4_1
                                
                                int64_t x2_17 = var_c8
                                
                                if (x2_17 == 0)
                                    if ((sub_45be5c(arg1, &var_90, &var_c8, 1, "apkvision/", 
                                            &data_40c8c9, "(Ljava/lang/Object;I)I") & 1) != 0)
                                        goto label_4876e4_1
                                    
                                    x2_17 = var_c8
                                
                                var_78 = x0_51
                                uint32_t var_70_5 = zx.d(x0_58)
                                int32_t x0_64 = (*(*arg1 + 0x418))(arg1, var_90, x2_17, &var_78)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_4876e4_1
                                
                                int64_t var_d0
                                int64_t x2_4 = var_d0
                                
                                if (x2_4 == 0)
                                    if ((sub_45be5c(arg1, &var_98, &var_d0, 1, "apkvision/", 
                                            &data_40f570, "(Ljava/lang/Object;I)V") & 1) != 0)
                                        goto label_4876e4_1
                                    
                                    x2_4 = var_d0
                                
                                var_78 = x0_6
                                int32_t var_70_1 = x0_64 | x0_45 << 4
                                (*(*arg1 + 0x478))(arg1, var_98, x2_4, &var_78)
                                result = 0
                                cond:0_1 = zx.d((*(*arg1 + 0x720))(arg1)) != 0
                                x22_3 += 2
                                x25_1 = x0_51
                                x23_1 = x0_32
                            while (not(cond:0_1))
            else
            label_4876e4_1:
                result = 0

if (*(x26 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
