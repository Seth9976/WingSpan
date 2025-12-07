// 函数: sub_48bf3c
// 地址: 0x48bf3c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t var_e0
__builtin_memset(&var_e0, 0, 0x80)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_2 = (*(*arg1 + 0x538))(arg1, "0D18080205")
int64_t var_98
int64_t var_68
int32_t result = sub_45be5c(arg1, &var_68, &var_98, 1, "apkvision/NPStringFog", "decode", 
    "(Ljava/lang/String;)Ljava/lang/String;")

if ((result & 1) == 0)
    int64_t var_60 = x0_2
    int64_t x0_5 = (*(*arg1 + 0x3a0))(arg1, var_68, var_98, &var_60)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) == 0)
        if (x0_2 != 0)
            (*(*arg1 + 0xb8))(arg1, x0_2)
        
        if (x0 == 0)
            result = sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
        else
            int64_t var_a0
            int64_t x2_2 = var_a0
            
            if (x2_2 != 0)
                goto label_48c0a4
            
            int64_t var_70
            result = sub_45be5c(arg1, &var_70, &var_a0, 0, "android/content/Context", 
                "getSharedPreferences", "(Ljava/lang/String;I)Landroid/content/SharedPreferences;")
            
            if ((result & 1) == 0)
                x2_2 = var_a0
            label_48c0a4:
                var_60 = x0_5
                int32_t var_58_1 = 0
                int64_t x0_10 = (*(*arg1 + 0x120))(arg1, x0, x2_2, &var_60)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    if (x0_5 != 0)
                        (*(*arg1 + 0xb8))(arg1, x0_5)
                    
                    int64_t x0_14 = (*(*arg1 + 0x538))(arg1, "0D180802050438132201252C17380E3754")
                    int64_t x2_4 = var_98
                    
                    if (x2_4 != 0)
                        goto label_48c150
                    
                    result = sub_45be5c(arg1, &var_68, &var_98, 1, "apkvision/NPStringFog", 
                        "decode", "(Ljava/lang/String;)Ljava/lang/String;")
                    
                    if ((result & 1) == 0)
                        x2_4 = var_98
                    label_48c150:
                        var_60 = x0_14
                        int64_t x0_17 = (*(*arg1 + 0x3a0))(arg1, var_68, x2_4, &var_60)
                        result = (*(*arg1 + 0x720))(arg1)
                        
                        if ((result & 0xff) == 0)
                            if (x0_14 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_14)
                            
                            if (x0_10 == 0)
                                result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                                    "NullPointerException")
                            else
                                int64_t var_a8
                                int64_t x2_6 = var_a8
                                
                                if (x2_6 != 0)
                                    goto label_48c1e0
                                
                                int64_t var_78
                                result = sub_45be5c(arg1, &var_78, &var_a8, 0, 
                                    "android/content/SharedPreferences", "getBoolean", 
                                    "(Ljava/lang/String;Z)Z")
                                
                                if ((result & 1) == 0)
                                    x2_6 = var_a8
                                label_48c1e0:
                                    var_60 = x0_17
                                    var_58_1.b = 0
                                    char x0_22 = (*(*arg1 + 0x138))(arg1, x0_10, x2_6, &var_60)
                                    result = (*(*arg1 + 0x720))(arg1)
                                    
                                    if ((result & 0xff) == 0)
                                        int64_t var_d0
                                        int32_t var_58_3
                                        int64_t x2_28
                                        int64_t x20_1
                                        int64_t x22_7
                                        
                                        if (zx.d(x0_22) == 0)
                                            if (x0_17 != 0)
                                                (*(*arg1 + 0xb8))(arg1, x0_17)
                                            
                                            int64_t x0_56 = (*(*arg1 + 0x538))(arg1, "0D18080205")
                                            int64_t x2_18 = var_98
                                            
                                            if (x2_18 != 0)
                                                goto label_48c5c4
                                            
                                            result = sub_45be5c(arg1, &var_68, &var_98, 1, 
                                                "apkvision/NPStringFog", "decode", 
                                                "(Ljava/lang/String;)Ljava/lang/String;")
                                            
                                            if ((result & 1) == 0)
                                                x2_18 = var_98
                                            label_48c5c4:
                                                var_60 = x0_56
                                                int64_t x0_59 =
                                                    (*(*arg1 + 0x3a0))(arg1, var_68, x2_18, &var_60)
                                                result = (*(*arg1 + 0x720))(arg1)
                                                
                                                if ((result & 0xff) == 0)
                                                    if (x0_56 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x0_56)
                                                    
                                                    int64_t x2_21 = var_a0
                                                    
                                                    if (x2_21 != 0)
                                                        goto label_48c650
                                                    
                                                    result = sub_45be5c(arg1, &var_70, &var_a0, 0, 
                                                        "android/content/Context", 
                                                        "getSharedPreferences", 
                                                        "(Ljava/lang/String;"
                                                    "I)Landroid/content/SharedPreferences;")
                                                    
                                                    if ((result & 1) == 0)
                                                        x2_21 = var_a0
                                                    label_48c650:
                                                        var_60 = x0_59
                                                        var_58_3 = 0
                                                        int64_t x0_64 = (*(*arg1 + 0x120))(arg1, 
                                                            x0, x2_21, &var_60)
                                                        result = (*(*arg1 + 0x720))(arg1)
                                                        
                                                        if ((result & 0xff) == 0)
                                                            (*(*arg1 + 0xb8))(arg1, x0_10)
                                                            
                                                            if (x0_64 == 0)
                                                                result = sub_45bac8(arg1, 
                                                                    "java/lang/NullPointerException", 
                                                                    "NullPointerException")
                                                            else
                                                                int64_t x2_22 = var_d0
                                                                
                                                                if (x2_22 != 0)
                                                                    goto label_48c6fc
                                                                
                                                                result = sub_45be5c(arg1, &var_78, 
                                                                    &var_d0, 0, 
                                                                    "android/content/SharedPreferences", 
                                                                    "edit", 
                                                                    "
                                                                "()Landroid/content/SharedPreferences$Editor;")
                                                                
                                                                if ((result & 1) == 0)
                                                                    x2_22 = var_d0
                                                                label_48c6fc:
                                                                    x20_1 = (*(*arg1 + 0x120))(arg1, x0_64, 
                                                                        x2_22, &var_60)
                                                                    result = (*(*arg1 + 0x720))(arg1)
                                                                    
                                                                    if ((result & 0xff) == 0)
                                                                        (*(*arg1 + 0xb8))(arg1, x0_64)
                                                                        
                                                                        if (x0_59 != 0)
                                                                            (*(*arg1 + 0xb8))(arg1, x0_59)
                                                                        
                                                                        int64_t x0_74 = (*(*arg1 + 0x538))(
                                                                            arg1, 
                                                                            "0D180802050438132201252C17380E3754")
                                                                        int64_t x2_24 = var_98
                                                                        
                                                                        if (x2_24 != 0)
                                                                            goto label_48c798
                                                                        
                                                                        result = sub_45be5c(arg1, &var_68, 
                                                                            &var_98, 1, "apkvision/NPStringFog", 
                                                                            "decode", 
                                                                            "
                                                                                (Ljava/lang/String;)Ljava/lang/String;")
                                                                        
                                                                        if ((result & 1) == 0)
                                                                            x2_24 = var_98
                                                                        label_48c798:
                                                                            var_60 = x0_74
                                                                            x22_7 = (*(*arg1 + 0x3a0))(arg1, 
                                                                                var_68, x2_24, &var_60)
                                                                            result = (*(*arg1 + 0x720))(arg1)
                                                                            
                                                                            if ((result & 0xff) == 0)
                                                                                if (x0_74 != 0)
                                                                                    (*(*arg1 + 0xb8))(arg1, x0_74)
                                                                                
                                                                                if (x20_1 == 0)
                                                                                    result = sub_45bac8(arg1, 
                                                                                        "java/lang/NullPointerException", 
                                                                                        "NullPointerException")
                                                                                else
                                                                                label_48c7ec:
                                                                                    int64_t var_d8
                                                                                    int64_t x2_27 = var_d8
                                                                                    
                                                                                    if (x2_27 != 0)
                                                                                        goto label_48c82c
                                                                                    
                                                                                    int64_t var_90
                                                                                    result = sub_45be5c(arg1, &var_90, 
                                                                                        &var_d8, 0, 
                                                                                        "android/content/SharedPreferences$Editor", 
                                                                                        "putBoolean", 
                                                                                        "(Ljava/lang/String;"
                                                                                    "Z)Landroid/content/SharedPreferences$Editor;")
                                                                                    
                                                                                    if ((result & 1) == 0)
                                                                                        x2_27 = var_d8
                                                                                    label_48c82c:
                                                                                        var_60 = x22_7
                                                                                        var_58_3.b = 1
                                                                                        int64_t x0_82 = (*(*arg1 + 0x120))(
                                                                                            arg1, x20_1, x2_27, &var_60)
                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                        
                                                                                        if ((result & 0xff) == 0)
                                                                                            (*(*arg1 + 0xb8))(arg1, x20_1)
                                                                                            
                                                                                            if (x0_82 == 0)
                                                                                                result = sub_45bac8(arg1, 
                                                                                                    "java/lang/NullPointerException", 
                                                                                                    "NullPointerException")
                                                                                            else
                                                                                                x2_28 = var_e0
                                                                                                
                                                                                                if (x2_28 != 0)
                                                                                                    goto label_48c8bc
                                                                                                
                                                                                                result = sub_45be5c(arg1, &var_90, 
                                                                                                    &var_e0, 0, 
                                                                                                    "android/content/SharedPreferences$Editor", 
                                                                                                    "apply", "()V")
                                                                                                
                                                                                                if ((result & 1) == 0)
                                                                                                    x2_28 = var_e0
                                                                                                label_48c8bc:
                                                                                                    (*(*arg1 + 0x1f8))(arg1, x0_82, x2_28, 
                                                                                                        &var_60)
                                                                                                    result = (*(*arg1 + 0x720))(arg1)
                                        else
                                            (*(*arg1 + 0xb8))(arg1, x0_10)
                                            int64_t x0_26 = (*(*arg1 + 0x538))(arg1, "0D18080205")
                                            int64_t x2_8 = var_98
                                            
                                            if (x2_8 != 0)
                                                goto label_48c290
                                            
                                            result = sub_45be5c(arg1, &var_68, &var_98, 1, 
                                                "apkvision/NPStringFog", "decode", 
                                                "(Ljava/lang/String;)Ljava/lang/String;")
                                            
                                            if ((result & 1) == 0)
                                                x2_8 = var_98
                                            label_48c290:
                                                var_60 = x0_26
                                                int64_t x0_29 =
                                                    (*(*arg1 + 0x3a0))(arg1, var_68, x2_8, &var_60)
                                                result = (*(*arg1 + 0x720))(arg1)
                                                
                                                if ((result & 0xff) == 0)
                                                    if (x0_26 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x0_26)
                                                    
                                                    int64_t x2_11 = var_a0
                                                    
                                                    if (x2_11 != 0)
                                                        goto label_48c31c
                                                    
                                                    result = sub_45be5c(arg1, &var_70, &var_a0, 0, 
                                                        "android/content/Context", 
                                                        "getSharedPreferences", 
                                                        "(Ljava/lang/String;"
                                                    "I)Landroid/content/SharedPreferences;")
                                                    
                                                    if ((result & 1) == 0)
                                                        x2_11 = var_a0
                                                    label_48c31c:
                                                        var_60 = x0_29
                                                        int32_t var_58_2 = 0
                                                        int64_t x0_34 = (*(*arg1 + 0x120))(arg1, 
                                                            x0, x2_11, &var_60)
                                                        result = (*(*arg1 + 0x720))(arg1)
                                                        
                                                        if ((result & 0xff) == 0)
                                                            if (x0_29 != 0)
                                                                (*(*arg1 + 0xb8))(arg1, x0_29)
                                                            
                                                            if (x0_17 != 0)
                                                                (*(*arg1 + 0xb8))(arg1, x0_17)
                                                            
                                                            int64_t x0_39 = (*(*arg1 + 0x538))(
                                                                arg1, 
                                                                "0D180802050438132201252C17380E3757")
                                                            int64_t x2_12 = var_98
                                                            
                                                            if (x2_12 != 0)
                                                                goto label_48c3e0
                                                            
                                                            result = sub_45be5c(arg1, &var_68, 
                                                                &var_98, 1, "apkvision/NPStringFog", 
                                                                "decode", 
                                                                "
                                                                    (Ljava/lang/String;)Ljava/lang/String;")
                                                            
                                                            if ((result & 1) == 0)
                                                                x2_12 = var_98
                                                            label_48c3e0:
                                                                var_60 = x0_39
                                                                int64_t x0_42 = (*(*arg1 + 0x3a0))(
                                                                    arg1, var_68, x2_12, &var_60)
                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                
                                                                if ((result & 0xff) == 0)
                                                                    if (x0_39 != 0)
                                                                        (*(*arg1 + 0xb8))(arg1, x0_39)
                                                                    
                                                                    if (x0_34 == 0)
                                                                        result = sub_45bac8(arg1, 
                                                                            "java/lang/NullPointerException", 
                                                                            "NullPointerException")
                                                                    else
                                                                        int64_t x2_14 = var_a8
                                                                        
                                                                        if (x2_14 != 0)
                                                                            goto label_48c470
                                                                        
                                                                        result = sub_45be5c(arg1, &var_78, 
                                                                            &var_a8, 0, 
                                                                            "android/content/SharedPreferences", 
                                                                            "getBoolean", "(Ljava/lang/String;Z)Z")
                                                                        
                                                                        if ((result & 1) == 0)
                                                                            x2_14 = var_a8
                                                                        label_48c470:
                                                                            var_60 = x0_42
                                                                            var_58_2.b = 0
                                                                            char x0_47 = (*(*arg1 + 0x138))(arg1, 
                                                                                x0_34, x2_14, &var_60)
                                                                            result = (*(*arg1 + 0x720))(arg1)
                                                                            
                                                                            if ((result & 0xff) == 0)
                                                                                if (zx.d(x0_47) == 0)
                                                                                    if (x0_42 != 0)
                                                                                        (*(*arg1 + 0xb8))(arg1, x0_42)
                                                                                    
                                                                                    int64_t x0_90 =
                                                                                        (*(*arg1 + 0x538))(arg1, "0D18080205")
                                                                                    int64_t x2_30 = var_98
                                                                                    
                                                                                    if (x2_30 != 0)
                                                                                        goto label_48c958
                                                                                    
                                                                                    result = sub_45be5c(arg1, &var_68, 
                                                                                        &var_98, 1, "apkvision/NPStringFog", 
                                                                                        "decode", 
                                                                                        "
                                                                                            (Ljava/lang/String;)Ljava/lang/String;")
                                                                                    
                                                                                    if ((result & 1) == 0)
                                                                                        x2_30 = var_98
                                                                                    label_48c958:
                                                                                        var_60 = x0_90
                                                                                        int64_t x0_93 = (*(*arg1 + 0x3a0))(
                                                                                            arg1, var_68, x2_30, &var_60)
                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                        
                                                                                        if ((result & 0xff) == 0)
                                                                                            if (x0_90 != 0)
                                                                                                (*(*arg1 + 0xb8))(arg1, x0_90)
                                                                                            
                                                                                            int64_t x2_33 = var_a0
                                                                                            
                                                                                            if (x2_33 != 0)
                                                                                                goto label_48c9e4
                                                                                            
                                                                                            result = sub_45be5c(arg1, &var_70, 
                                                                                                &var_a0, 0, "android/content/Context", 
                                                                                                "getSharedPreferences", 
                                                                                                "(Ljava/lang/String;"
                                                                                            "I)Landroid/content/SharedPreferences;")
                                                                                            
                                                                                            if ((result & 1) == 0)
                                                                                                x2_33 = var_a0
                                                                                            label_48c9e4:
                                                                                                var_60 = x0_93
                                                                                                var_58_3 = 0
                                                                                                int64_t x0_98 = (*(*arg1 + 0x120))(
                                                                                                    arg1, x0, x2_33, &var_60)
                                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                                
                                                                                                if ((result & 0xff) == 0)
                                                                                                    (*(*arg1 + 0xb8))(arg1, x0_34)
                                                                                                    
                                                                                                    if (x0_98 == 0)
                                                                                                        result = sub_45bac8(arg1, 
                                                                                                            "java/lang/NullPointerException", 
                                                                                                            "NullPointerException")
                                                                                                    else
                                                                                                        int64_t x2_34 = var_d0
                                                                                                        
                                                                                                        if (x2_34 != 0)
                                                                                                            goto label_48ca90
                                                                                                        
                                                                                                        result = sub_45be5c(arg1, &var_78, 
                                                                                                            &var_d0, 0, 
                                                                                                            "android/content/SharedPreferences", 
                                                                                                            "edit", 
                                                                                                            "
                                                                                                        "()Landroid/content/SharedPreferences$Editor;")
                                                                                                        
                                                                                                        if ((result & 1) == 0)
                                                                                                            x2_34 = var_d0
                                                                                                        label_48ca90:
                                                                                                            x20_1 = (*(*arg1 + 0x120))(arg1, x0_98, 
                                                                                                                x2_34, &var_60)
                                                                                                            result = (*(*arg1 + 0x720))(arg1)
                                                                                                            
                                                                                                            if ((result & 0xff) == 0)
                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_98)
                                                                                                                
                                                                                                                if (x0_93 != 0)
                                                                                                                    (*(*arg1 + 0xb8))(arg1, x0_93)
                                                                                                                
                                                                                                                int64_t x0_108 = (*(*arg1 + 0x538))(
                                                                                                                    arg1, 
                                                                                                                    "0D180802050438132201252C17380E3757")
                                                                                                                int64_t x2_36 = var_98
                                                                                                                
                                                                                                                if (x2_36 != 0)
                                                                                                                    goto label_48cb2c
                                                                                                                
                                                                                                                result = sub_45be5c(arg1, &var_68, 
                                                                                                                    &var_98, 1, "apkvision/NPStringFog", 
                                                                                                                    "decode", 
                                                                                                                    "
                                                                                                                        (Ljava/lang/String;)Ljava/lang/String;")
                                                                                                                
                                                                                                                if ((result & 1) == 0)
                                                                                                                    x2_36 = var_98
                                                                                                                label_48cb2c:
                                                                                                                    var_60 = x0_108
                                                                                                                    x22_7 = (*(*arg1 + 0x3a0))(arg1, 
                                                                                                                        var_68, x2_36, &var_60)
                                                                                                                    result = (*(*arg1 + 0x720))(arg1)
                                                                                                                    
                                                                                                                    if ((result & 0xff) == 0)
                                                                                                                        if (x0_108 != 0)
                                                                                                                            (*(*arg1 + 0xb8))(arg1, x0_108)
                                                                                                                        
                                                                                                                        if (x20_1 != 0)
                                                                                                                            goto label_48c7ec
                                                                                                                        
                                                                                                                        result = sub_45bac8(arg1, 
                                                                                                                            "java/lang/NullPointerException", 
                                                                                                                            "NullPointerException")
                                                                                else
                                                                                    int64_t var_b0
                                                                                    int64_t x2_16 = var_b0
                                                                                    
                                                                                    if (x2_16 != 0)
                                                                                        goto label_48c504
                                                                                    
                                                                                    int64_t var_80
                                                                                    result = sub_45be5c(arg1, &var_80, 
                                                                                        &var_b0, 1, "apkvision/YnLbgyrEk", 
                                                                                        "vPoUAvVoP", "()Z")
                                                                                    
                                                                                    if ((result & 1) == 0)
                                                                                        x2_16 = var_b0
                                                                                    label_48c504:
                                                                                        char x0_51 = (*(*arg1 + 0x3b8))(arg1, 
                                                                                            var_80, x2_16, &var_60)
                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                        
                                                                                        if ((result & 0xff) == 0)
                                                                                            (*(*arg1 + 0xb8))(arg1, x0_34)
                                                                                            char* const x1_28
                                                                                            
                                                                                            if (zx.d(x0_51) == 0)
                                                                                                x1_28 = "3C3754520C0C1F132B3922013B2D230A061F57042424283034542824255D0D3E350E50223B1B0E5C"
                                                                                            else
                                                                                                x1_28 = "5E3B25301B0C2F371A57331A51225236131B2A220A322C2332200639233B2F24355751073B1C385C"
                                                                                            
                                                                                            int64_t x0_115 =
                                                                                                (*(*arg1 + 0x538))(arg1, x1_28)
                                                                                            int64_t x2_38 = var_98
                                                                                            
                                                                                            if (x2_38 != 0)
                                                                                                goto label_48cbd4
                                                                                            
                                                                                            result = sub_45be5c(arg1, &var_68, 
                                                                                                &var_98, 1, "apkvision/NPStringFog", 
                                                                                                "decode", 
                                                                                                "
                                                                                                    (Ljava/lang/String;)Ljava/lang/String;")
                                                                                            
                                                                                            if ((result & 1) == 0)
                                                                                                x2_38 = var_98
                                                                                            label_48cbd4:
                                                                                                var_60 = x0_115
                                                                                                int64_t x0_118 = (*(*arg1 + 0x3a0))(
                                                                                                    arg1, var_68, x2_38, &var_60)
                                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                                
                                                                                                if ((result & 0xff) == 0)
                                                                                                    if (x0_115 != 0)
                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_115)
                                                                                                    
                                                                                                    int64_t var_b8
                                                                                                    int64_t x2_41 = var_b8
                                                                                                    
                                                                                                    if (x2_41 != 0)
                                                                                                        goto label_48cc60
                                                                                                    
                                                                                                    result = sub_45be5c(arg1, &var_80, 
                                                                                                        &var_b8, 1, "apkvision/YnLbgyrEk", 
                                                                                                        "vPoUAvVoP", 
                                                                                                        "
                                                                                                            (Ljava/lang/String;)Ljava/lang/String;")
                                                                                                    
                                                                                                    if ((result & 1) == 0)
                                                                                                        x2_41 = var_b8
                                                                                                    label_48cc60:
                                                                                                        var_60 = x0_118
                                                                                                        int64_t x0_123 = (*(*arg1 + 0x3a0))(
                                                                                                            arg1, var_80, x2_41, &var_60)
                                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                                        
                                                                                                        if ((result & 0xff) == 0)
                                                                                                            if (x0_118 != 0)
                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_118)
                                                                                                            
                                                                                                            int64_t var_c0
                                                                                                            int64_t x2_43 = var_c0
                                                                                                            
                                                                                                            if (x2_43 != 0)
                                                                                                                goto label_48ccf0
                                                                                                            
                                                                                                            int64_t var_88
                                                                                                            result = sub_45be5c(arg1, &var_88, 
                                                                                                                &var_c0, 1, "android/widget/Toast", 
                                                                                                                "makeText", 
                                                                                                                "(Landroid/content/Context;"
                                                                                                            "Ljava/lang/CharSequence;"
                                                                                                            "I)Landroid/widget/Toast;")
                                                                                                            
                                                                                                            if ((result & 1) == 0)
                                                                                                                x2_43 = var_c0
                                                                                                            label_48ccf0:
                                                                                                                var_60 = x0
                                                                                                                var_58_2.q = x0_123
                                                                                                                int32_t var_50_1 = 1
                                                                                                                int64_t x0_128 = (*(*arg1 + 0x3a0))(
                                                                                                                    arg1, var_88, x2_43, &var_60)
                                                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                                                
                                                                                                                if ((result & 0xff) == 0)
                                                                                                                    if (x0_128 == 0)
                                                                                                                        result = sub_45bac8(arg1, 
                                                                                                                            "java/lang/NullPointerException", 
                                                                                                                            "NullPointerException")
                                                                                                                    else
                                                                                                                        int64_t var_c8
                                                                                                                        x2_28 = var_c8
                                                                                                                        
                                                                                                                        if (x2_28 != 0)
                                                                                                                            goto label_48cd6c
                                                                                                                        
                                                                                                                        result = sub_45be5c(arg1, &var_88, 
                                                                                                                            &var_c8, 0, "android/widget/Toast", 
                                                                                                                            "show", "()V")
                                                                                                                        
                                                                                                                        if ((result & 1) == 0)
                                                                                                                            x2_28 = var_c8
                                                                                                                        label_48cd6c:
                                                                                                                            (*(*arg1 + 0x1f8))(arg1, x0_128, x2_28, 
                                                                                                                                &var_60)
                                                                                                                            result = (*(*arg1 + 0x720))(arg1)

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
