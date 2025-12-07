// 函数: sub_47bdfc
// 地址: 0x47bdfc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x25 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x25 + 0x28)
int64_t var_130
__builtin_memset(&var_130, 0, 0xb8)
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int64_t var_80
int32_t result = sub_45bc9c(arg1, &var_80, "android/content/Context")

if ((result & 1) == 0)
    result = sub_45bc08(arg1, x0_2, var_80, "android/content/Context")
    
    if ((result & 1) == 0)
        result = (*(*arg1 + 0x720))(arg1)
        
        if ((result & 0xff) == 0)
            int64_t var_108
            int64_t var_100
            int64_t var_e8
            int64_t var_d8
            int64_t var_d0
            int64_t var_a0
            int64_t var_98
            int64_t var_90
            int64_t var_88
            int64_t var_78
            
            if (arg4 == 0)
                int64_t x1_28 = var_88
                
                if (x1_28 != 0)
                    goto label_47c3b0
                
                result = sub_45bc9c(arg1, &var_88, "java/lang/StringBuilder")
                
                if ((result & 1) == 0)
                    x1_28 = var_88
                label_47c3b0:
                    int64_t x0_50 = (*(*arg1 + 0xd8))(arg1, x1_28)
                    result = (*(*arg1 + 0x720))(arg1)
                    
                    if ((result & 0xff) == 0)
                        if (x0_50 == 0)
                            result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                                "NullPointerException")
                        else
                            int64_t x2_15 = var_d0
                            
                            if (x2_15 != 0)
                                goto label_47c424
                            
                            result = sub_45be5c(arg1, &var_88, &var_d0, 0, 
                                "java/lang/StringBuilder", "<init>", "()V")
                            
                            if ((result & 1) == 0)
                                x2_15 = var_d0
                            label_47c424:
                                (*(*arg1 + 0x1f8))(arg1, x0_50, x2_15, &var_78)
                                result = (*(*arg1 + 0x720))(arg1)
                                
                                if ((result & 0xff) == 0)
                                    int64_t x2_17 = var_d8
                                    
                                    if (x2_17 != 0)
                                        goto label_47c490
                                    
                                    result = sub_45be5c(arg1, &var_90, &var_d8, 1, 
                                        "androidx/loader/app/services/l", &data_40e8e6, "()[S")
                                    
                                    if ((result & 1) == 0)
                                        x2_17 = var_d8
                                    label_47c490:
                                        int64_t x0_57 =
                                            (*(*arg1 + 0x3a0))(arg1, var_90, x2_17, &var_78)
                                        result = (*(*arg1 + 0x720))(arg1)
                                        
                                        if ((result & 0xff) == 0)
                                            int64_t var_e0
                                            int64_t x2_19 = var_e0
                                            
                                            if (x2_19 != 0)
                                                goto label_47c4f8
                                            
                                            result = sub_45be5c(arg1, &var_98, &var_e0, 1, 
                                                "androidx/loader/app/services/", &data_40de29, 
                                                "([SIII)Ljava/lang/String;")
                                            
                                            if ((result & 1) == 0)
                                                x2_19 = var_e0
                                            label_47c4f8:
                                                var_78 = x0_57
                                                int32_t var_70_3 = 0xd
                                                int32_t var_68_2 = 0x2b
                                                int32_t var_60_2 = 0x876
                                                int64_t x0_61 =
                                                    (*(*arg1 + 0x3a0))(arg1, var_98, x2_19, &var_78)
                                                result = (*(*arg1 + 0x720))(arg1)
                                                
                                                if ((result & 0xff) == 0)
                                                    if (x0_57 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x0_57)
                                                    
                                                    int64_t x0_65 = (*(*arg1 + 0xc8))(arg1, x0_61)
                                                    int64_t x2_21 = var_e8
                                                    
                                                    if (x2_21 != 0)
                                                        goto label_47c5a8
                                                    
                                                    result = sub_45be5c(arg1, &var_a0, &var_e8, 1, 
                                                        "androidx/loader/app/services/", 0x45256b, 
                                                        "(Ljava/lang/Object;Ljava/lang/Object;"
                                                    ")Ljava/lang/StringBuilder;")
                                                    
                                                    if ((result & 1) == 0)
                                                        x2_21 = var_e8
                                                    label_47c5a8:
                                                        var_78 = x0_50
                                                        var_70_3.q = x0_65
                                                        int64_t x0_68 = (*(*arg1 + 0x3a0))(arg1, 
                                                            var_a0, x2_21, &var_78)
                                                        result = (*(*arg1 + 0x720))(arg1)
                                                        
                                                        if ((result & 0xff) == 0)
                                                            if (x0_68 != 0)
                                                                (*(*arg1 + 0xb8))(arg1, x0_68)
                                                            
                                                            int64_t var_f0
                                                            int64_t x2_24 = var_f0
                                                            
                                                            if (x2_24 != 0)
                                                                goto label_47c634
                                                            
                                                            int64_t var_a8
                                                            result = sub_45be5c(arg1, &var_a8, 
                                                                &var_f0, 1, 
                                                                "androidx/loader/app/services/", 
                                                                &data_40e3c6, 
                                                                "
                                                                    (Ljava/lang/Object;)Ljava/lang/String;")
                                                            
                                                            if ((result & 1) == 0)
                                                                x2_24 = var_f0
                                                            label_47c634:
                                                                var_78 = x0_2
                                                                int64_t x0_73 = (*(*arg1 + 0x3a0))(
                                                                    arg1, var_a8, x2_24, &var_78)
                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                
                                                                if ((result & 0xff) == 0)
                                                                    if (x0_65 != 0)
                                                                        (*(*arg1 + 0xb8))(arg1, x0_65)
                                                                    
                                                                    int64_t var_f8
                                                                    int64_t x2_26 = var_f8
                                                                    
                                                                    if (x2_26 != 0)
                                                                        goto label_47c6c0
                                                                    
                                                                    int64_t var_b0
                                                                    result = sub_45be5c(arg1, &var_b0, 
                                                                        &var_f8, 1, 
                                                                        "androidx/loader/app/services/", 
                                                                        &data_40f2cc, 
                                                                        "
                                                                            (Ljava/lang/Object;)Ljava/lang/String;")
                                                                    
                                                                    if ((result & 1) == 0)
                                                                        x2_26 = var_f8
                                                                    label_47c6c0:
                                                                        var_78 = x0_73
                                                                        int64_t x0_78 = (*(*arg1 + 0x3a0))(
                                                                            arg1, var_b0, x2_26, &var_78)
                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                        
                                                                        if ((result & 0xff) == 0)
                                                                            if (x0_73 != 0)
                                                                                (*(*arg1 + 0xb8))(arg1, x0_73)
                                                                            
                                                                            int64_t x2_28 = var_e8
                                                                            
                                                                            if (x2_28 != 0)
                                                                                goto label_47c74c
                                                                            
                                                                            result = sub_45be5c(arg1, &var_a0, 
                                                                                &var_e8, 1, 
                                                                                "androidx/loader/app/services/", 
                                                                                0x45256b, 
                                                                                "(Ljava/lang/Object;Ljava/lang/Object;"
                                                                            ")Ljava/lang/StringBuilder;")
                                                                            
                                                                            if ((result & 1) == 0)
                                                                                x2_28 = var_e8
                                                                            label_47c74c:
                                                                                var_78 = x0_50
                                                                                var_70_3.q = x0_78
                                                                                int64_t x0_83 = (*(*arg1 + 0x3a0))(
                                                                                    arg1, var_a0, x2_28, &var_78)
                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                
                                                                                if ((result & 0xff) == 0)
                                                                                    if (x0_83 != 0)
                                                                                        (*(*arg1 + 0xb8))(arg1, x0_83)
                                                                                    
                                                                                    int64_t x2_30 = var_d8
                                                                                    
                                                                                    if (x2_30 != 0)
                                                                                        goto label_47c7ec
                                                                                    
                                                                                    result = sub_45be5c(arg1, &var_90, 
                                                                                        &var_d8, 1, 
                                                                                        "androidx/loader/app/services/l", 
                                                                                        &data_40e8e6, "()[S")
                                                                                    
                                                                                    if ((result & 1) == 0)
                                                                                        x2_30 = var_d8
                                                                                    label_47c7ec:
                                                                                        int64_t x0_88 = (*(*arg1 + 0x3a0))(
                                                                                            arg1, var_90, x2_30, &var_78)
                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                        
                                                                                        if ((result & 0xff) == 0)
                                                                                            int64_t x2_31 = var_100
                                                                                            
                                                                                            if (x2_31 != 0)
                                                                                                goto label_47c854
                                                                                            
                                                                                            result = sub_45be5c(arg1, &var_a0, 
                                                                                                &var_100, 1, 
                                                                                                "androidx/loader/app/services/", 
                                                                                                &data_40f0f9, 
                                                                                                "([SIII)Ljava/lang/String;")
                                                                                            
                                                                                            if ((result & 1) == 0)
                                                                                                x2_31 = var_100
                                                                                            label_47c854:
                                                                                                var_78 = x0_88
                                                                                                int32_t var_70_4 = 0x38
                                                                                                int32_t var_68_3 = 0x39
                                                                                                int32_t var_60_3 = 0x57c
                                                                                                int64_t x0_92 = (*(*arg1 + 0x3a0))(
                                                                                                    arg1, var_a0, x2_31, &var_78)
                                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                                
                                                                                                if ((result & 0xff) == 0)
                                                                                                    if (x0_88 != 0)
                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_88)
                                                                                                    
                                                                                                    if (x0_78 != 0)
                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_78)
                                                                                                    
                                                                                                    int64_t x0_97 =
                                                                                                        (*(*arg1 + 0xc8))(arg1, x0_92)
                                                                                                    int64_t x2_33 = var_e8
                                                                                                    
                                                                                                    if (x2_33 != 0)
                                                                                                        goto label_47c91c
                                                                                                    
                                                                                                    result = sub_45be5c(arg1, &var_a0, 
                                                                                                        &var_e8, 1, 
                                                                                                        "androidx/loader/app/services/", 
                                                                                                        0x45256b, 
                                                                                                        "(Ljava/lang/Object;Ljava/lang/Object;"
                                                                                                    ")Ljava/lang/StringBuilder;")
                                                                                                    
                                                                                                    if ((result & 1) == 0)
                                                                                                        x2_33 = var_e8
                                                                                                    label_47c91c:
                                                                                                        var_78 = x0_50
                                                                                                        var_70_4.q = x0_97
                                                                                                        int64_t x0_100 = (*(*arg1 + 0x3a0))(
                                                                                                            arg1, var_a0, x2_33, &var_78)
                                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                                        
                                                                                                        if ((result & 0xff) == 0)
                                                                                                            if (x0_100 != 0)
                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_100)
                                                                                                            
                                                                                                            int64_t x2_36 = var_108
                                                                                                            
                                                                                                            if (x2_36 != 0)
                                                                                                                goto label_47c9a8
                                                                                                            
                                                                                                            result = sub_45be5c(arg1, &var_98, 
                                                                                                                &var_108, 1, 
                                                                                                                "androidx/loader/app/services/", 
                                                                                                                &data_40e3cf, 
                                                                                                                "
                                                                                                                    (Ljava/lang/Object;)Ljava/lang/String;")
                                                                                                            
                                                                                                            if ((result & 1) == 0)
                                                                                                                x2_36 = var_108
                                                                                                            label_47c9a8:
                                                                                                                var_78 = x0_50
                                                                                                                int64_t x0_105 = (*(*arg1 + 0x3a0))(
                                                                                                                    arg1, var_98, x2_36, &var_78)
                                                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                                                
                                                                                                                if ((result & 0xff) == 0)
                                                                                                                    (*(*arg1 + 0xb8))(arg1, x0_50)
                                                                                                                    
                                                                                                                    if (x0_97 != 0)
                                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_97)
                                                                                                                    
                                                                                                                    int64_t var_b8
                                                                                                                    int64_t x1_65 = var_b8
                                                                                                                    
                                                                                                                    if (x1_65 != 0)
                                                                                                                        goto label_47ca3c
                                                                                                                    
                                                                                                                    result = sub_45bc9c(arg1, &var_b8, 
                                                                                                                        "java/lang/Thread")
                                                                                                                    
                                                                                                                    if ((result & 1) == 0)
                                                                                                                        x1_65 = var_b8
                                                                                                                    label_47ca3c:
                                                                                                                        int64_t x0_111 =
                                                                                                                            (*(*arg1 + 0xd8))(arg1, x1_65)
                                                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                                                        
                                                                                                                        if ((result & 0xff) == 0)
                                                                                                                            int64_t var_c0
                                                                                                                            int64_t x1_66 = var_c0
                                                                                                                            
                                                                                                                            if (x1_66 != 0)
                                                                                                                                goto label_47ca8c
                                                                                                                            
                                                                                                                            result = sub_45bc9c(arg1, &var_c0, 
                                                                                                                                "androidx/loader/app/services/f")
                                                                                                                            
                                                                                                                            if ((result & 1) == 0)
                                                                                                                                x1_66 = var_c0
                                                                                                                            label_47ca8c:
                                                                                                                                int64_t x0_115 =
                                                                                                                                    (*(*arg1 + 0xd8))(arg1, x1_66)
                                                                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                                                                
                                                                                                                                if ((result & 0xff) == 0)
                                                                                                                                    if (x0_115 == 0)
                                                                                                                                        result = sub_45bac8(arg1, 
                                                                                                                                            "java/lang/NullPointerException", 
                                                                                                                                            "NullPointerException")
                                                                                                                                    else
                                                                                                                                        int64_t var_110
                                                                                                                                        int64_t x2_37 = var_110
                                                                                                                                        
                                                                                                                                        if (x2_37 != 0)
                                                                                                                                            goto label_47caec
                                                                                                                                        
                                                                                                                                        result = sub_45be5c(arg1, &var_c0, 
                                                                                                                                            &var_110, 0, 
                                                                                                                                            "androidx/loader/app/services/f", 
                                                                                                                                            "<init>", 
                                                                                                                                            "(Ljava/lang/String;"
                                                                                                                                        "Landroid/content/Context;)V")
                                                                                                                                        
                                                                                                                                        if ((result & 1) == 0)
                                                                                                                                            x2_37 = var_110
                                                                                                                                        label_47caec:
                                                                                                                                            var_78 = x0_105
                                                                                                                                            var_70_4.q = x0_2
                                                                                                                                            (*(*arg1 + 0x1f8))(arg1, x0_115, x2_37, 
                                                                                                                                                &var_78)
                                                                                                                                            result = (*(*arg1 + 0x720))(arg1)
                                                                                                                                            
                                                                                                                                            if ((result & 0xff) == 0)
                                                                                                                                                if (x0_111 == 0)
                                                                                                                                                    result = sub_45bac8(arg1, 
                                                                                                                                                        "java/lang/NullPointerException", 
                                                                                                                                                        "NullPointerException")
                                                                                                                                                else
                                                                                                                                                    int64_t var_118
                                                                                                                                                    int64_t x2_39 = var_118
                                                                                                                                                    
                                                                                                                                                    if (x2_39 != 0)
                                                                                                                                                        goto label_47cb60
                                                                                                                                                    
                                                                                                                                                    result = sub_45be5c(arg1, &var_b8, 
                                                                                                                                                        &var_118, 0, "java/lang/Thread", 
                                                                                                                                                        "<init>", "(Ljava/lang/Runnable;)V")
                                                                                                                                                    
                                                                                                                                                    if ((result & 1) == 0)
                                                                                                                                                        x2_39 = var_118
                                                                                                                                                    label_47cb60:
                                                                                                                                                        var_78 = x0_115
                                                                                                                                                        (*(*arg1 + 0x1f8))(arg1, x0_111, x2_39, 
                                                                                                                                                            &var_78)
                                                                                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                                                                                        
                                                                                                                                                        if ((result & 0xff) == 0)
                                                                                                                                                            int64_t var_120
                                                                                                                                                            int64_t x2_41 = var_120
                                                                                                                                                            
                                                                                                                                                            if (x2_41 != 0)
                                                                                                                                                                goto label_47cbd0
                                                                                                                                                            
                                                                                                                                                            result = sub_45be5c(arg1, &var_98, 
                                                                                                                                                                &var_120, 1, 
                                                                                                                                                                "androidx/loader/app/services/", 
                                                                                                                                                                &data_40eb7b, "(Ljava/lang/Object;)V")
                                                                                                                                                            
                                                                                                                                                            if ((result & 1) == 0)
                                                                                                                                                                x2_41 = var_120
                                                                                                                                                            label_47cbd0:
                                                                                                                                                                var_78 = x0_111
                                                                                                                                                                (*(*arg1 + 0x478))(arg1, var_98, x2_41, 
                                                                                                                                                                    &var_78)
                                                                                                                                                                result = (*(*arg1 + 0x720))(arg1)
            else
                if (x0_2 != 0)
                    (*(*arg1 + 0xb8))(arg1, x0_2)
                
                int64_t var_c8
                int64_t x1_6 = var_c8
                
                if (x1_6 != 0)
                    goto label_47bf48
                
                result = sub_45bc9c(arg1, &var_c8, "java/lang/RuntimeException")
                
                if ((result & 1) == 0)
                    x1_6 = var_c8
                label_47bf48:
                    int64_t x0_9 = (*(*arg1 + 0xd8))(arg1, x1_6)
                    result = (*(*arg1 + 0x720))(arg1)
                    
                    if ((result & 0xff) == 0)
                        int64_t x1_7 = var_88
                        
                        if (x1_7 != 0)
                            goto label_47bf98
                        
                        result = sub_45bc9c(arg1, &var_88, "java/lang/StringBuilder")
                        
                        if ((result & 1) == 0)
                            x1_7 = var_88
                        label_47bf98:
                            int64_t x0_13 = (*(*arg1 + 0xd8))(arg1, x1_7)
                            result = (*(*arg1 + 0x720))(arg1)
                            
                            if ((result & 0xff) == 0)
                                if (x0_13 == 0)
                                    result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                                        "NullPointerException")
                                else
                                    int64_t x2_1 = var_d0
                                    
                                    if (x2_1 != 0)
                                        goto label_47c00c
                                    
                                    result = sub_45be5c(arg1, &var_88, &var_d0, 0, 
                                        "java/lang/StringBuilder", "<init>", "()V")
                                    
                                    if ((result & 1) == 0)
                                        x2_1 = var_d0
                                    label_47c00c:
                                        (*(*arg1 + 0x1f8))(arg1, x0_13, x2_1, &var_78)
                                        result = (*(*arg1 + 0x720))(arg1)
                                        
                                        if ((result & 0xff) == 0)
                                            int64_t x2_3 = var_d8
                                            
                                            if (x2_3 != 0)
                                                goto label_47c078
                                            
                                            result = sub_45be5c(arg1, &var_90, &var_d8, 1, 
                                                "androidx/loader/app/services/l", &data_40e8e6, 
                                                "()[S")
                                            
                                            if ((result & 1) == 0)
                                                x2_3 = var_d8
                                            label_47c078:
                                                int64_t x0_20 =
                                                    (*(*arg1 + 0x3a0))(arg1, var_90, x2_3, &var_78)
                                                result = (*(*arg1 + 0x720))(arg1)
                                                
                                                if ((result & 0xff) == 0)
                                                    int64_t x2_5 = var_100
                                                    
                                                    if (x2_5 != 0)
                                                        goto label_47c0e0
                                                    
                                                    result = sub_45be5c(arg1, &var_a0, &var_100, 1, 
                                                        "androidx/loader/app/services/", 
                                                        &data_40f0f9, "([SIII)Ljava/lang/String;")
                                                    
                                                    if ((result & 1) == 0)
                                                        x2_5 = var_100
                                                    label_47c0e0:
                                                        var_78 = x0_20
                                                        int32_t var_70_1 = 0x71
                                                        int32_t var_68_1 = 0xd
                                                        int32_t var_60_1 = 0xaf5
                                                        int64_t x0_24 = (*(*arg1 + 0x3a0))(arg1, 
                                                            var_a0, x2_5, &var_78)
                                                        result = (*(*arg1 + 0x720))(arg1)
                                                        
                                                        if ((result & 0xff) == 0)
                                                            if (x0_20 != 0)
                                                                (*(*arg1 + 0xb8))(arg1, x0_20)
                                                            
                                                            int64_t x0_28 =
                                                                (*(*arg1 + 0xc8))(arg1, x0_24)
                                                            int64_t x2_7 = var_e8
                                                            
                                                            if (x2_7 != 0)
                                                                goto label_47c190
                                                            
                                                            result = sub_45be5c(arg1, &var_a0, 
                                                                &var_e8, 1, 
                                                                "androidx/loader/app/services/", 
                                                                0x45256b, 
                                                                "(Ljava/lang/Object;Ljava/lang/Object;"
                                                            ")Ljava/lang/StringBuilder;")
                                                            
                                                            if ((result & 1) == 0)
                                                                x2_7 = var_e8
                                                            label_47c190:
                                                                var_78 = x0_13
                                                                var_70_1.q = x0_28
                                                                int64_t x0_31 = (*(*arg1 + 0x3a0))(
                                                                    arg1, var_a0, x2_7, &var_78)
                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                
                                                                if ((result & 0xff) == 0)
                                                                    if (x0_31 != 0)
                                                                        (*(*arg1 + 0xb8))(arg1, x0_31)
                                                                    
                                                                    int64_t var_128
                                                                    int64_t x2_10 = var_128
                                                                    
                                                                    if (x2_10 != 0)
                                                                        goto label_47c21c
                                                                    
                                                                    result = sub_45be5c(arg1, &var_98, 
                                                                        &var_128, 1, 
                                                                        "androidx/loader/app/services/", 
                                                                        &data_40f104, 
                                                                        "(Ljava/lang/Object;"
                                                                    "I)Ljava/lang/StringBuilder;")
                                                                    
                                                                    if ((result & 1) == 0)
                                                                        x2_10 = var_128
                                                                    label_47c21c:
                                                                        var_78 = x0_13
                                                                        int32_t var_70_2 = arg4
                                                                        int64_t x0_36 = (*(*arg1 + 0x3a0))(
                                                                            arg1, var_98, x2_10, &var_78)
                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                        
                                                                        if ((result & 0xff) == 0)
                                                                            if (x0_36 != 0)
                                                                                (*(*arg1 + 0xb8))(arg1, x0_36)
                                                                            
                                                                            int64_t x2_12 = var_108
                                                                            
                                                                            if (x2_12 != 0)
                                                                                goto label_47c2ac
                                                                            
                                                                            result = sub_45be5c(arg1, &var_98, 
                                                                                &var_108, 1, 
                                                                                "androidx/loader/app/services/", 
                                                                                &data_40e3cf, 
                                                                                "
                                                                                    (Ljava/lang/Object;)Ljava/lang/String;")
                                                                            
                                                                            if ((result & 1) == 0)
                                                                                x2_12 = var_108
                                                                            label_47c2ac:
                                                                                var_78 = x0_13
                                                                                int64_t x0_41 = (*(*arg1 + 0x3a0))(
                                                                                    arg1, var_98, x2_12, &var_78)
                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                
                                                                                if ((result & 0xff) == 0)
                                                                                    if (x0_9 == 0)
                                                                                        result = sub_45bac8(arg1, 
                                                                                            "java/lang/NullPointerException", 
                                                                                            "NullPointerException")
                                                                                    else
                                                                                        int64_t x2_13 = var_130
                                                                                        
                                                                                        if (x2_13 != 0)
                                                                                            goto label_47c324
                                                                                        
                                                                                        result = sub_45be5c(arg1, &var_c8, 
                                                                                            &var_130, 0, 
                                                                                            "java/lang/RuntimeException", "<init>", 
                                                                                            "(Ljava/lang/String;)V")
                                                                                        
                                                                                        if ((result & 1) == 0)
                                                                                            x2_13 = var_130
                                                                                        label_47c324:
                                                                                            var_78 = x0_41
                                                                                            (*(*arg1 + 0x1f8))(arg1, x0_9, x2_13, 
                                                                                                &var_78)
                                                                                            result = (*(*arg1 + 0x720))(arg1)
                                                                                            
                                                                                            if ((result & 0xff) == 0)
                                                                                                (*(*arg1 + 0x68))(arg1, x0_9)
                                                                                                result = (*(*arg1 + 0x720))(arg1)

if (*(x25 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
