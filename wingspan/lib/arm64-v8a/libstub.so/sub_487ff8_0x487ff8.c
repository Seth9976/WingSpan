// 函数: sub_487ff8
// 地址: 0x487ff8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x25 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x25 + 0x28)
int64_t var_f8
__builtin_memset(&var_f8, 0, 0x90)
int64_t x0 = (*(*arg1 + 0xc8))()
(*(*arg1 + 0xc8))(arg1, arg3)
int64_t var_c0
int64_t var_70
int32_t result =
    sub_45be5c(arg1, &var_70, &var_c0, 1, "java/util/Locale", "getDefault", "()Ljava/util/Locale;")

if ((result & 1) == 0)
    int64_t var_68
    int64_t x0_4 = (*(*arg1 + 0x3a0))(arg1, var_70, var_c0, &var_68)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) == 0)
        if (x0_4 == 0)
            result = sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
        else
            int64_t var_c8
            int64_t x2_2 = var_c8
            
            if (x2_2 != 0)
                goto label_48815c
            
            result = sub_45be5c(arg1, &var_70, &var_c8, 0, "java/util/Locale", "getLanguage", 
                "()Ljava/lang/String;")
            
            if ((result & 1) == 0)
                x2_2 = var_c8
            label_48815c:
                int64_t x0_8 = (*(*arg1 + 0x120))(arg1, x0_4, x2_2, &var_68)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    (*(*arg1 + 0xb8))(arg1, x0_4)
                    int64_t x0_12 = (*(*arg1 + 0x538))(arg1, &data_452188)
                    int64_t var_d0
                    int64_t x2_4 = var_d0
                    
                    if (x2_4 != 0)
                        goto label_4881e8
                    
                    int64_t var_78
                    result = sub_45be5c(arg1, &var_78, &var_d0, 1, "apkvision/NPStringFog", 
                        "decode", "(Ljava/lang/String;)Ljava/lang/String;")
                    
                    if ((result & 1) == 0)
                        x2_4 = var_d0
                    label_4881e8:
                        var_68 = x0_12
                        int64_t x0_15 = (*(*arg1 + 0x3a0))(arg1, var_78, x2_4, &var_68)
                        result = (*(*arg1 + 0x720))(arg1)
                        
                        if ((result & 0xff) == 0)
                            if (x0_12 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_12)
                            
                            if (x0_8 == 0)
                                result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                                    "NullPointerException")
                            else
                                int64_t var_d8
                                int64_t x2_6 = var_d8
                                
                                if (x2_6 != 0)
                                    goto label_48828c
                                
                                int64_t var_80
                                result = sub_45be5c(arg1, &var_80, &var_d8, 0, "java/lang/String", 
                                    "hashCode", 0x452601)
                                
                                if ((result & 1) == 0)
                                    x2_6 = var_d8
                                label_48828c:
                                    int32_t x0_20 = (*(*arg1 + 0x198))(arg1, x0_8, x2_6, &var_68)
                                    result = (*(*arg1 + 0x720))(arg1)
                                    
                                    if ((result & 0xff) == 0)
                                        int64_t x23_2 = 0
                                        char* const x1_11
                                        void* x8_28
                                        
                                        if (x0_20 s<= 0xe95)
                                            if (x0_20 == 0xc43)
                                                x8_28 = *arg1
                                                x1_11 = "0C15"
                                                goto label_488430
                                            
                                            if (x0_20 != 0xe43)
                                                goto label_488568
                                            
                                            x8_28 = *arg1
                                            x1_11 = "1C05"
                                            goto label_488430
                                        
                                        int64_t var_e0
                                        char* const x1_23
                                        void* x8_56
                                        
                                        if (x0_20 == 0xe96)
                                            x8_28 = *arg1
                                            x1_11 = "1B1B"
                                        label_488430:
                                            int64_t x0_33 = (*(x8_28 + 0x538))(arg1, x1_11)
                                            int64_t x2_12 = var_d0
                                            
                                            if (x2_12 != 0)
                                                goto label_488474
                                            
                                            result = sub_45be5c(arg1, &var_78, &var_d0, 1, 
                                                "apkvision/NPStringFog", "decode", 
                                                "(Ljava/lang/String;)Ljava/lang/String;")
                                            
                                            if ((result & 1) == 0)
                                                x2_12 = var_d0
                                            label_488474:
                                                var_68 = x0_33
                                                x23_2 =
                                                    (*(*arg1 + 0x3a0))(arg1, var_78, x2_12, &var_68)
                                                result = (*(*arg1 + 0x720))(arg1)
                                                
                                                if ((result & 0xff) == 0)
                                                    if (x0_33 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x0_33)
                                                    
                                                    int64_t x2_15 = var_e0
                                                    
                                                    if (x2_15 != 0)
                                                        goto label_488500
                                                    
                                                    result = sub_45be5c(arg1, &var_80, &var_e0, 0, 
                                                        "java/lang/String", "equals", 
                                                        "(Ljava/lang/Object;)Z")
                                                    
                                                    if ((result & 1) == 0)
                                                        x2_15 = var_e0
                                                    label_488500:
                                                        var_68 = x23_2
                                                        char x0_41 = (*(*arg1 + 0x138))(arg1, x0_8, 
                                                            x2_15, &var_68)
                                                        result = (*(*arg1 + 0x720))(arg1)
                                                        
                                                        if ((result & 0xff) == 0)
                                                            if (zx.d(x0_41) == 0)
                                                                goto label_488568
                                                            
                                                            if (x0_15 != 0)
                                                                (*(*arg1 + 0xb8))(arg1, x0_15)
                                                            
                                                            x8_56 = *arg1
                                                            x1_23 = "060419111D5B484A131E1B1B081D08080B5C1C0542"
                                                            goto label_488594
                                        else if (x0_20 != 0xf2e)
                                        label_488568:
                                            
                                            if (x0_15 != 0)
                                                (*(*arg1 + 0xb8))(arg1, x0_15)
                                            
                                            x8_56 = *arg1
                                            x1_23 = "060419111D5B484A131E1B1B081D08080B5C01020A4E"
                                        label_488594:
                                            int64_t x0_46 = (*(x8_56 + 0x538))(arg1, x1_23)
                                            int64_t x2_16 = var_d0
                                            
                                            if (x2_16 != 0)
                                                goto label_4885d8
                                            
                                            result = sub_45be5c(arg1, &var_78, &var_d0, 1, 
                                                "apkvision/NPStringFog", "decode", 
                                                "(Ljava/lang/String;)Ljava/lang/String;")
                                            
                                            if ((result & 1) == 0)
                                                x2_16 = var_d0
                                            label_4885d8:
                                                var_68 = x0_46
                                                int64_t x0_49 =
                                                    (*(*arg1 + 0x3a0))(arg1, var_78, x2_16, &var_68)
                                                result = (*(*arg1 + 0x720))(arg1)
                                                
                                                if ((result & 0xff) == 0)
                                                    if (x0_46 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x0_46)
                                                    
                                                    if (x23_2 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x23_2)
                                                    
                                                    int64_t var_88
                                                    int64_t x1_30 = var_88
                                                    
                                                    if (x1_30 != 0)
                                                        goto label_488670
                                                    
                                                    result = sub_45bc9c(arg1, &var_88, 
                                                        "android/content/Intent")
                                                    
                                                    if ((result & 1) == 0)
                                                        x1_30 = var_88
                                                    label_488670:
                                                        int64_t x0_55 =
                                                            (*(*arg1 + 0xd8))(arg1, x1_30)
                                                        result = (*(*arg1 + 0x720))(arg1)
                                                        
                                                        if ((result & 0xff) == 0)
                                                            int64_t var_e8
                                                            int64_t x2_18 = var_e8
                                                            
                                                            if (x2_18 != 0)
                                                                goto label_4886cc
                                                            
                                                            int64_t var_90
                                                            result = sub_45be5c(arg1, &var_90, 
                                                                &var_e8, 1, "android/net/Uri", "parse", 
                                                                "(Ljava/lang/String;)Landroid/net/Uri;")
                                                            
                                                            if ((result & 1) == 0)
                                                                x2_18 = var_e8
                                                            label_4886cc:
                                                                var_68 = x0_49
                                                                int64_t x0_59 = (*(*arg1 + 0x3a0))(
                                                                    arg1, var_90, x2_18, &var_68)
                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                
                                                                if ((result & 0xff) == 0)
                                                                    int64_t x0_62 = (*(*arg1 + 0x538))(
                                                                        arg1, 
                                                                        "0F1E09130108034B1B0004080F1A4F060606071F034F38282232")
                                                                    int64_t x2_20 = var_d0
                                                                    
                                                                    if (x2_20 != 0)
                                                                        goto label_48875c
                                                                    
                                                                    result = sub_45be5c(arg1, &var_78, 
                                                                        &var_d0, 1, "apkvision/NPStringFog", 
                                                                        "decode", 
                                                                        "
                                                                            (Ljava/lang/String;)Ljava/lang/String;")
                                                                    
                                                                    if ((result & 1) == 0)
                                                                        x2_20 = var_d0
                                                                    label_48875c:
                                                                        var_68 = x0_62
                                                                        int64_t x0_65 = (*(*arg1 + 0x3a0))(
                                                                            arg1, var_78, x2_20, &var_68)
                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                        
                                                                        if ((result & 0xff) == 0)
                                                                            if (x0_62 != 0)
                                                                                (*(*arg1 + 0xb8))(arg1, x0_62)
                                                                            
                                                                            if (x0_55 == 0)
                                                                                result = sub_45bac8(arg1, 
                                                                                    "java/lang/NullPointerException", 
                                                                                    "NullPointerException")
                                                                            else
                                                                                int64_t var_f0
                                                                                int64_t x2_22 = var_f0
                                                                                
                                                                                if (x2_22 != 0)
                                                                                    goto label_4887ec
                                                                                
                                                                                result = sub_45be5c(arg1, &var_88, 
                                                                                    &var_f0, 0, "android/content/Intent", 
                                                                                    "<init>", 
                                                                                    "
                                                                                        (Ljava/lang/String;Landroid/net/Uri;)V")
                                                                                
                                                                                if ((result & 1) == 0)
                                                                                    x2_22 = var_f0
                                                                                label_4887ec:
                                                                                    var_68 = x0_65
                                                                                    int64_t var_60_1 = x0_59
                                                                                    (*(*arg1 + 0x1f8))(arg1, x0_55, x2_22, 
                                                                                        &var_68)
                                                                                    result = (*(*arg1 + 0x720))(arg1)
                                                                                    
                                                                                    if ((result & 0xff) == 0)
                                                                                        if (x0 == 0)
                                                                                            result = sub_45bac8(arg1, 
                                                                                                "java/lang/NullPointerException", 
                                                                                                "NullPointerException")
                                                                                        else
                                                                                            int64_t var_b0
                                                                                            int64_t x2_24 = var_b0
                                                                                            
                                                                                            if (x2_24 != 0)
                                                                                                goto label_488870
                                                                                            
                                                                                            int64_t var_98
                                                                                            result = sub_45c03c(arg1, &var_98, 
                                                                                                &var_b0, 0, "apkvision/sVMbOPAtE$1$1", 
                                                                                                "this$0", "Lapkvision/sVMbOPAtE$1;")
                                                                                            
                                                                                            if ((result & 1) == 0)
                                                                                                x2_24 = var_b0
                                                                                            label_488870:
                                                                                                int64_t x0_73 =
                                                                                                    (*(*arg1 + 0x2f8))(arg1, x0, x2_24)
                                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                                
                                                                                                if ((result & 0xff) == 0)
                                                                                                    if (x0_59 != 0)
                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_59)
                                                                                                    
                                                                                                    if (x0_73 == 0)
                                                                                                        result = sub_45bac8(arg1, 
                                                                                                            "java/lang/NullPointerException", 
                                                                                                            "NullPointerException")
                                                                                                    else
                                                                                                        int64_t var_b8
                                                                                                        int64_t x2_26 = var_b8
                                                                                                        
                                                                                                        if (x2_26 != 0)
                                                                                                            goto label_4888f8
                                                                                                        
                                                                                                        int64_t var_a0
                                                                                                        result = sub_45c03c(arg1, &var_a0, 
                                                                                                            &var_b8, 0, "apkvision/sVMbOPAtE$1", 
                                                                                                            "val$activity", 
                                                                                                            "Landroid/app/Activity;")
                                                                                                        
                                                                                                        if ((result & 1) == 0)
                                                                                                            x2_26 = var_b8
                                                                                                        label_4888f8:
                                                                                                            int64_t x0_78 =
                                                                                                                (*(*arg1 + 0x2f8))(arg1, x0_73, x2_26)
                                                                                                            result = (*(*arg1 + 0x720))(arg1)
                                                                                                            
                                                                                                            if ((result & 0xff) == 0)
                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_73)
                                                                                                                
                                                                                                                if (x0_78 == 0)
                                                                                                                    result = sub_45bac8(arg1, 
                                                                                                                        "java/lang/NullPointerException", 
                                                                                                                        "NullPointerException")
                                                                                                                else
                                                                                                                    int64_t x2_28 = var_f8
                                                                                                                    
                                                                                                                    if (x2_28 != 0)
                                                                                                                        goto label_48896c
                                                                                                                    
                                                                                                                    int64_t var_a8
                                                                                                                    result = sub_45be5c(arg1, &var_a8, 
                                                                                                                        &var_f8, 0, "android/app/Activity", 
                                                                                                                        "startActivity", 
                                                                                                                        "(Landroid/content/Intent;)V")
                                                                                                                    
                                                                                                                    if ((result & 1) == 0)
                                                                                                                        x2_28 = var_f8
                                                                                                                    label_48896c:
                                                                                                                        var_68 = x0_55
                                                                                                                        (*(*arg1 + 0x1f8))(arg1, x0_78, x2_28, 
                                                                                                                            &var_68)
                                                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                        else
                                            int64_t x0_23 = (*(*arg1 + 0x538))(arg1, "1418")
                                            int64_t x2_8 = var_d0
                                            
                                            if (x2_8 != 0)
                                                goto label_488340
                                            
                                            result = sub_45be5c(arg1, &var_78, &var_d0, 1, 
                                                "apkvision/NPStringFog", "decode", 
                                                "(Ljava/lang/String;)Ljava/lang/String;")
                                            
                                            if ((result & 1) == 0)
                                                x2_8 = var_d0
                                            label_488340:
                                                var_68 = x0_23
                                                x23_2 =
                                                    (*(*arg1 + 0x3a0))(arg1, var_78, x2_8, &var_68)
                                                result = (*(*arg1 + 0x720))(arg1)
                                                
                                                if ((result & 0xff) == 0)
                                                    if (x0_23 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x0_23)
                                                    
                                                    int64_t x2_11 = var_e0
                                                    
                                                    if (x2_11 != 0)
                                                        goto label_4883cc
                                                    
                                                    result = sub_45be5c(arg1, &var_80, &var_e0, 0, 
                                                        "java/lang/String", "equals", 
                                                        "(Ljava/lang/Object;)Z")
                                                    
                                                    if ((result & 1) == 0)
                                                        x2_11 = var_e0
                                                    label_4883cc:
                                                        var_68 = x23_2
                                                        (*(*arg1 + 0x138))(arg1, x0_8, x2_11, 
                                                            &var_68)
                                                        result = (*(*arg1 + 0x720))(arg1)
                                                        
                                                        if ((result & 0xff) == 0)
                                                            goto label_488568

if (*(x25 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
