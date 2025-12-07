// 函数: sub_4800c0
// 地址: 0x4800c0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x25 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x25 + 0x28)
int64_t var_f8
__builtin_memset(&var_f8, 0, 0x80)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_4 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg4))
int64_t x0_6 = (*(*arg1 + 0xc8))(arg1, x0)
int64_t var_80
int32_t result = sub_45bc9c(arg1, &var_80, "android/app/AlertDialog$Builder")

if ((result & 1) == 0)
    int64_t x0_9 = (*(*arg1 + 0xd8))(arg1, var_80)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) == 0)
        if (x0_9 == 0)
            result = sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
        else
            int64_t var_b0
            int64_t x2 = var_b0
            
            if (x2 != 0)
                goto label_480228
            
            result = sub_45be5c(arg1, &var_80, &var_b0, 0, "android/app/AlertDialog$Builder", 
                "<init>", "(Landroid/content/Context;I)V")
            
            if ((result & 1) == 0)
                x2 = var_b0
            label_480228:
                int64_t var_78 = x0_6
                int32_t var_70_1 = 0x1030227
                (*(*arg1 + 0x1f8))(arg1, x0_9, x2, &var_78)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    int64_t var_b8
                    int64_t x2_2 = var_b8
                    
                    if (x2_2 != 0)
                        goto label_4802b0
                    
                    int64_t var_88
                    result = sub_45be5c(arg1, &var_88, &var_b8, 1, 
                        "androidx/loader/app/services/l", &data_40e8e6, "()[S")
                    
                    if ((result & 1) == 0)
                        x2_2 = var_b8
                    label_4802b0:
                        int64_t x0_16 = (*(*arg1 + 0x3a0))(arg1, var_88, x2_2, &var_78)
                        result = (*(*arg1 + 0x720))(arg1)
                        
                        if ((result & 0xff) == 0)
                            int64_t var_c0
                            int64_t x2_4 = var_c0
                            
                            if (x2_4 != 0)
                                goto label_480318
                            
                            int64_t var_90
                            result = sub_45be5c(arg1, &var_90, &var_c0, 1, 
                                "androidx/loader/app/services/", &data_40cfe9, 
                                "([SIII)Ljava/lang/String;")
                            
                            if ((result & 1) == 0)
                                x2_4 = var_c0
                            label_480318:
                                var_78 = x0_16
                                int32_t var_70_2 = 0x144
                                int32_t var_68_1 = 5
                                int32_t var_60_1 = 0xb48
                                int64_t x0_20 = (*(*arg1 + 0x3a0))(arg1, var_90, x2_4, &var_78)
                                result = (*(*arg1 + 0x720))(arg1)
                                
                                if ((result & 0xff) == 0)
                                    if (x0_16 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_16)
                                    
                                    if (x0_6 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_6)
                                    
                                    int64_t x0_25 = (*(*arg1 + 0xc8))(arg1, x0_20)
                                    int64_t var_c8
                                    int64_t x2_6 = var_c8
                                    
                                    if (x2_6 != 0)
                                        goto label_4803e0
                                    
                                    int64_t var_98
                                    result = sub_45be5c(arg1, &var_98, &var_c8, 1, 
                                        "androidx/loader/app/services/", &data_40cffd, 
                                        "(Ljava/lang/Object;Ljava/lang/Object;"
                                    ")Landroid/app/AlertDialog$Builder;")
                                    
                                    if ((result & 1) == 0)
                                        x2_6 = var_c8
                                    label_4803e0:
                                        var_78 = x0_9
                                        var_70_2.q = x0_25
                                        int64_t x0_28 =
                                            (*(*arg1 + 0x3a0))(arg1, var_98, x2_6, &var_78)
                                        result = (*(*arg1 + 0x720))(arg1)
                                        
                                        if ((result & 0xff) == 0)
                                            if (x0_25 != 0)
                                                (*(*arg1 + 0xb8))(arg1, x0_25)
                                            
                                            int64_t var_d0
                                            int64_t x2_9 = var_d0
                                            
                                            if (x2_9 != 0)
                                                goto label_48046c
                                            
                                            int64_t var_a0
                                            result = sub_45be5c(arg1, &var_a0, &var_d0, 1, 
                                                "androidx/loader/app/services/", &data_40c541, 
                                                "(Ljava/lang/Object;)Ljava/lang/String;")
                                            
                                            if ((result & 1) == 0)
                                                x2_9 = var_d0
                                            label_48046c:
                                                var_78 = x0_4
                                                int64_t x0_33 =
                                                    (*(*arg1 + 0x3a0))(arg1, var_a0, x2_9, &var_78)
                                                result = (*(*arg1 + 0x720))(arg1)
                                                
                                                if ((result & 0xff) == 0)
                                                    if (x0_4 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x0_4)
                                                    
                                                    int64_t var_d8
                                                    int64_t x2_11 = var_d8
                                                    
                                                    if (x2_11 != 0)
                                                        goto label_4804f8
                                                    
                                                    result = sub_45be5c(arg1, &var_a0, &var_d8, 1, 
                                                        "androidx/loader/app/services/", 
                                                        &data_40dc2c, 
                                                        "(Ljava/lang/Object;Ljava/lang/Object;"
                                                    ")Landroid/app/AlertDialog$Builder;")
                                                    
                                                    if ((result & 1) == 0)
                                                        x2_11 = var_d8
                                                    label_4804f8:
                                                        var_78 = x0_28
                                                        var_70_2.q = x0_33
                                                        int64_t x0_38 = (*(*arg1 + 0x3a0))(arg1, 
                                                            var_a0, x2_11, &var_78)
                                                        result = (*(*arg1 + 0x720))(arg1)
                                                        
                                                        if ((result & 0xff) == 0)
                                                            if (x0_28 != 0)
                                                                (*(*arg1 + 0xb8))(arg1, x0_28)
                                                            
                                                            int64_t x2_13 = var_b8
                                                            
                                                            if (x2_13 != 0)
                                                                goto label_480598
                                                            
                                                            result = sub_45be5c(arg1, &var_88, 
                                                                &var_b8, 1, 
                                                                "androidx/loader/app/services/l", 
                                                                &data_40e8e6, "()[S")
                                                            
                                                            if ((result & 1) == 0)
                                                                x2_13 = var_b8
                                                            label_480598:
                                                                int64_t x0_43 = (*(*arg1 + 0x3a0))(
                                                                    arg1, var_88, x2_13, &var_78)
                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                
                                                                if ((result & 0xff) == 0)
                                                                    int64_t var_e0
                                                                    int64_t x2_14 = var_e0
                                                                    
                                                                    if (x2_14 != 0)
                                                                        goto label_480600
                                                                    
                                                                    int64_t var_a8
                                                                    result = sub_45be5c(arg1, &var_a8, 
                                                                        &var_e0, 1, 
                                                                        "androidx/loader/app/services/", 
                                                                        &data_40de29, 
                                                                        "([SIII)Ljava/lang/String;")
                                                                    
                                                                    if ((result & 1) == 0)
                                                                        x2_14 = var_e0
                                                                    label_480600:
                                                                        var_78 = x0_43
                                                                        int32_t var_70_3 = 0x149
                                                                        int32_t var_68_2 = 5
                                                                        int32_t var_60_2 = 0x2d4
                                                                        int64_t x0_47 = (*(*arg1 + 0x3a0))(
                                                                            arg1, var_a8, x2_14, &var_78)
                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                        
                                                                        if ((result & 0xff) == 0)
                                                                            if (x0_43 != 0)
                                                                                (*(*arg1 + 0xb8))(arg1, x0_43)
                                                                            
                                                                            if (x0_33 != 0)
                                                                                (*(*arg1 + 0xb8))(arg1, x0_33)
                                                                            
                                                                            int64_t x0_52 =
                                                                                (*(*arg1 + 0xc8))(arg1, x0_47)
                                                                            (*(*arg1 + 0xb8))(arg1, x0_9)
                                                                            int64_t var_e8
                                                                            int64_t x2_16 = var_e8
                                                                            
                                                                            if (x2_16 != 0)
                                                                                goto label_4806dc
                                                                            
                                                                            result = sub_45be5c(arg1, &var_a0, 
                                                                                &var_e8, 1, 
                                                                                "androidx/loader/app/services/", 
                                                                                0x4528d7, 
                                                                                "(Ljava/lang/Object;Ljava/lang/Object;"
                                                                            "Ljava/lang/Object;"
                                                                            ")Landroid/app/AlertDialog$Builder;")
                                                                            
                                                                            if ((result & 1) == 0)
                                                                                x2_16 = var_e8
                                                                            label_4806dc:
                                                                                var_78 = x0_38
                                                                                var_70_3.q = x0_52
                                                                                var_68_2.q = 0
                                                                                int64_t x0_56 = (*(*arg1 + 0x3a0))(
                                                                                    arg1, var_a0, x2_16, &var_78)
                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                
                                                                                if ((result & 0xff) == 0)
                                                                                    if (x0_38 != 0)
                                                                                        (*(*arg1 + 0xb8))(arg1, x0_38)
                                                                                    
                                                                                    int64_t var_f0
                                                                                    int64_t x2_19 = var_f0
                                                                                    
                                                                                    if (x2_19 != 0)
                                                                                        goto label_48076c
                                                                                    
                                                                                    result = sub_45be5c(arg1, &var_90, 
                                                                                        &var_f0, 1, 
                                                                                        "androidx/loader/app/services/", 
                                                                                        &data_40dea8, 
                                                                                        "(Ljava/lang/Object;"
                                                                                    "Z)Landroid/app/AlertDialog$Builder;")
                                                                                    
                                                                                    if ((result & 1) == 0)
                                                                                        x2_19 = var_f0
                                                                                    label_48076c:
                                                                                        var_78 = x0_56
                                                                                        var_70_3.b = 0
                                                                                        int64_t x0_61 = (*(*arg1 + 0x3a0))(
                                                                                            arg1, var_90, x2_19, &var_78)
                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                        
                                                                                        if ((result & 0xff) == 0)
                                                                                            if (x0_56 != 0)
                                                                                                (*(*arg1 + 0xb8))(arg1, x0_56)
                                                                                            
                                                                                            int64_t x2_21 = var_f8
                                                                                            
                                                                                            if (x2_21 != 0)
                                                                                                goto label_4807fc
                                                                                            
                                                                                            result = sub_45be5c(arg1, &var_a8, 
                                                                                                &var_f8, 1, 
                                                                                                "androidx/loader/app/services/", 
                                                                                                &data_40cd70, 
                                                                                                "(Ljava/lang/Object;"
                                                                                            ")Landroid/app/AlertDialog;")
                                                                                            
                                                                                            if ((result & 1) == 0)
                                                                                                x2_21 = var_f8
                                                                                            label_4807fc:
                                                                                                var_78 = x0_61
                                                                                                int64_t x0_66 = (*(*arg1 + 0x3a0))(
                                                                                                    arg1, var_a8, x2_21, &var_78)
                                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                                
                                                                                                if (x0_66 != 0 && (result & 0xff) == 0)
                                                                                                    result = (*(*arg1 + 0xb8))(arg1, x0_66)

if (*(x25 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
