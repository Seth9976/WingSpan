// 函数: sub_47cc10
// 地址: 0x47cc10
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x28 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x28 + 0x28)
int64_t var_270
__builtin_memset(&var_270, 0, 0x1e0)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x21 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg4))
int64_t x0_6 = (*(*arg1 + 0xc8))(arg1, x0)
int64_t var_118
int64_t x2 = var_118

if (x2 != 0)
    goto label_47cd50

int64_t var_120
int64_t var_a0
int64_t var_98
int64_t var_90
int64_t var_88
int64_t x22_1
int64_t x23_2
int64_t x24_1

if ((sub_45be5c(arg1, &var_98, &var_118, 1, "androidx/loader/app/services/", 0x452396, 
        "(Ljava/lang/Object;)Landroid/content/pm/PackageManager;") & 1) == 0)
    x2 = var_118
label_47cd50:
    var_90 = x0_6
    x24_1 = (*(*arg1 + 0x3a0))(arg1, var_98, x2, &var_90)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_47cd88
    
    int64_t x2_2 = var_120
    
    if (x2_2 == 0)
        if ((sub_45be5c(arg1, &var_a0, &var_120, 1, "androidx/loader/app/services/", &data_40e3c6, 
                "(Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
            x22_1 = 0
            goto label_47ce18
        
        x2_2 = var_120
    
    var_90 = x0_6
    x22_1 = (*(*arg1 + 0x3a0))(arg1, var_a0, x2_2, &var_90)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        x22_1 = 0
        goto label_47ce18
    
    int64_t var_128
    int64_t x2_6 = var_128
    
    if (x2_6 == 0)
        if ((sub_45be5c(arg1, &var_98, &var_128, 1, "androidx/loader/app/services/", 0x452664, 
                "(Ljava/lang/Object;Ljava/lang/Object;I)Landroid/content/pm/PackageInfo;") & 1) != 0)
            goto label_47ce18
        
        x2_6 = var_128
    
    var_90 = x24_1
    var_88 = x22_1
    int32_t var_80_1 = 0
    x23_2 = (*(*arg1 + 0x3a0))(arg1, var_98, x2_6, &var_90)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_47ce18
    
    if (x24_1 != 0)
        (*(*arg1 + 0xb8))(arg1, x24_1)
    
    goto label_47d00c

label_47cd88:
x22_1 = 0
x24_1 = 0
label_47ce18:
uint64_t x0_20 = (*(*arg1 + 0x78))(arg1)
(*(*arg1 + 0x88))(arg1)
int32_t result

if ((sub_45bb84(arg1, x0_20, "android/content/pm/PackageManager$NameNotFoundException") & 1) == 0)
    (*(*arg1 + 0x68))(arg1, x0_20)
    result = (*(*arg1 + 0xb8))(arg1, x0_20)
else
    if (x24_1 != 0)
        (*(*arg1 + 0xb8))(arg1, x24_1)
    
    int64_t var_a8
    int64_t x1_11 = var_a8
    
    if (x1_11 != 0)
        goto label_47ce98
    
    result = sub_45bc9c(arg1, &var_a8, "android/content/pm/PackageInfo")
    
    if ((result & 1) == 0)
        x1_11 = var_a8
    label_47ce98:
        x23_2 = (*(*arg1 + 0xd8))(arg1, x1_11)
        result = (*(*arg1 + 0x720))(arg1)
        
        if ((result & 0xff) == 0)
            if (x23_2 == 0)
                result = sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
            else
                int64_t var_130
                int64_t x2_4 = var_130
                
                if (x2_4 != 0)
                    goto label_47cf04
                
                result = sub_45be5c(arg1, &var_a8, &var_130, 0, "android/content/pm/PackageInfo", 
                    "<init>", "()V")
                
                if ((result & 1) == 0)
                    x2_4 = var_130
                label_47cf04:
                    (*(*arg1 + 0x1f8))(arg1, x23_2, x2_4, &var_90)
                    result = (*(*arg1 + 0x720))(arg1)
                    
                    if ((result & 0xff) == 0)
                    label_47d00c:
                        int64_t var_138
                        int64_t x2_9 = var_138
                        
                        if (x2_9 != 0)
                            goto label_47d05c
                        
                        int64_t var_b0
                        
                        if ((sub_45be5c(arg1, &var_b0, &var_138, 1, 
                                "androidx/loader/app/services/l", &data_40e8e6, "()[S") & 1) != 0)
                            goto label_47d364
                        
                        x2_9 = var_138
                    label_47d05c:
                        int64_t x0_44 = (*(*arg1 + 0x3a0))(arg1, var_b0, x2_9, &var_90)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                            goto label_47d364
                        
                        int64_t var_140
                        int64_t x2_10 = var_140
                        int64_t var_b8
                        
                        if (x2_10 == 0)
                            if ((sub_45be5c(arg1, &var_b8, &var_140, 1, 
                                    "androidx/loader/app/services/", &data_40cfe9, 
                                    "([SIII)Ljava/lang/String;") & 1) != 0)
                                goto label_47d364
                            
                            x2_10 = var_140
                        
                        var_90 = x0_44
                        var_88.d = 0x98
                        int32_t var_80_2 = 7
                        int32_t var_78_1 = 0x872
                        int64_t x0_50 = (*(*arg1 + 0x3a0))(arg1, var_b8, x2_10, &var_90)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                            goto label_47d364
                        
                        if (x0_44 != 0)
                            (*(*arg1 + 0xb8))(arg1, x0_44)
                        
                        if (x22_1 != 0)
                            (*(*arg1 + 0xb8))(arg1, x22_1)
                        
                        int64_t x0_56 = (*(*arg1 + 0xc8))(arg1, x0_50)
                        int64_t var_148
                        int64_t x2_12 = var_148
                        int64_t var_c0
                        
                        if (x2_12 == 0)
                            if ((sub_45be5c(arg1, &var_c0, &var_148, 1, 
                                    "androidx/loader/app/services/", 0x452a4d, 
                                    "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                                goto label_47d364
                            
                            x2_12 = var_148
                        
                        var_90 = x21
                        int64_t var_88_1 = x0_56
                        int64_t x0_60 = (*(*arg1 + 0x3a0))(arg1, var_c0, x2_12, &var_90)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                            goto label_47d364
                        
                        if (x0_56 != 0)
                            (*(*arg1 + 0xb8))(arg1, x0_56)
                        
                        int64_t var_150
                        int64_t x2_15 = var_150
                        
                        if (x2_15 == 0)
                            if ((sub_45be5c(arg1, &var_98, &var_150, 1, 
                                    "androidx/loader/app/services/", 0x451eff, 
                                    "(Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                                goto label_47d364
                            
                            x2_15 = var_150
                        
                        var_90 = x0_60
                        int64_t x0_67 = (*(*arg1 + 0x3a0))(arg1, var_98, x2_15, &var_90)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                            goto label_47d364
                        
                        if (x0_60 != 0)
                            (*(*arg1 + 0xb8))(arg1, x0_60)
                        
                        int64_t x2_17 = var_120
                        
                        if (x2_17 == 0)
                            if ((sub_45be5c(arg1, &var_a0, &var_120, 1, 
                                    "androidx/loader/app/services/", &data_40e3c6, 
                                    "(Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                                goto label_47d364
                            
                            x2_17 = var_120
                        
                        var_90 = x0_6
                        int64_t x0_74 = (*(*arg1 + 0x3a0))(arg1, var_a0, x2_17, &var_90)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                            goto label_47d364
                        
                        int64_t var_158
                        int64_t x2_18 = var_158
                        
                        if (x2_18 == 0)
                            if ((sub_45be5c(arg1, &var_b8, &var_158, 1, 
                                    "androidx/loader/app/services/", &data_40e1e9, 
                                    "(Ljava/lang/Object;Ljava/lang/Object;)Z") & 1) != 0)
                                goto label_47d364
                            
                            x2_18 = var_158
                        
                        var_90 = x0_67
                        int64_t var_88_2 = x0_74
                        char x0_80 = (*(*arg1 + 0x3b8))(arg1, var_b8, x2_18, &var_90)
                        result = (*(*arg1 + 0x720))(arg1)
                        
                        if ((result & 0xff) != 0)
                            goto label_47d364
                        
                        if (zx.d(x0_80) != 0)
                            int64_t x2_24 = var_138
                            
                            if (x2_24 == 0)
                                if ((sub_45be5c(arg1, &var_b0, &var_138, 1, 
                                        "androidx/loader/app/services/l", &data_40e8e6, "()[S") & 1) != 0)
                                    goto label_47d364
                                
                                x2_24 = var_138
                            
                            int64_t x0_99 = (*(*arg1 + 0x3a0))(arg1, var_b0, x2_24, &var_90)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_47d364
                            
                            int64_t x2_26 = var_140
                            
                            if (x2_26 == 0)
                                if ((sub_45be5c(arg1, &var_b8, &var_140, 1, 
                                        "androidx/loader/app/services/", &data_40cfe9, 
                                        "([SIII)Ljava/lang/String;") & 1) != 0)
                                    goto label_47d364
                                
                                x2_26 = var_140
                            
                            var_90 = x0_99
                            var_88_2.d = 0x9f
                            int32_t var_80_3 = 0xd
                            int32_t var_78_2 = 0x790
                            int64_t x0_105 = (*(*arg1 + 0x3a0))(arg1, var_b8, x2_26, &var_90)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_47d364
                            
                            if (x0_99 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_99)
                            
                            if (x0_67 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_67)
                            
                            int64_t x0_111 = (*(*arg1 + 0xc8))(arg1, x0_105)
                            int64_t x2_28 = var_148
                            
                            if (x2_28 == 0)
                                if ((sub_45be5c(arg1, &var_c0, &var_148, 1, 
                                        "androidx/loader/app/services/", 0x452a4d, 
                                        "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;") & 1)
                                        != 0)
                                    goto label_47d364
                                
                                x2_28 = var_148
                            
                            var_90 = x21
                            int64_t var_88_4 = x0_111
                            int64_t x0_115 = (*(*arg1 + 0x3a0))(arg1, var_c0, x2_28, &var_90)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_47d364
                            
                            if (x0_111 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_111)
                            
                            int64_t x2_31 = var_150
                            
                            if (x2_31 == 0)
                                if ((sub_45be5c(arg1, &var_98, &var_150, 1, 
                                        "androidx/loader/app/services/", 0x451eff, 
                                        "(Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                                    goto label_47d364
                                
                                x2_31 = var_150
                            
                            var_90 = x0_115
                            int64_t x0_122 = (*(*arg1 + 0x3a0))(arg1, var_98, x2_31, &var_90)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_47d364
                            
                            if (x0_115 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_115)
                            
                            int64_t x2_33 = var_138
                            
                            if (x2_33 == 0)
                                if ((sub_45be5c(arg1, &var_b0, &var_138, 1, 
                                        "androidx/loader/app/services/l", &data_40e8e6, "()[S") & 1) != 0)
                                    goto label_47d364
                                
                                x2_33 = var_138
                            
                            int64_t x0_129 = (*(*arg1 + 0x3a0))(arg1, var_b0, x2_33, &var_90)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_47d364
                            
                            int64_t x2_34 = var_140
                            
                            if (x2_34 == 0)
                                if ((sub_45be5c(arg1, &var_b8, &var_140, 1, 
                                        "androidx/loader/app/services/", &data_40cfe9, 
                                        "([SIII)Ljava/lang/String;") & 1) != 0)
                                    goto label_47d364
                                
                                x2_34 = var_140
                            
                            var_90 = x0_129
                            var_88_4.d = 0xac
                            int32_t var_80_4 = 0xc
                            int32_t var_78_3 = 0x524
                            int64_t x0_135 = (*(*arg1 + 0x3a0))(arg1, var_b8, x2_34, &var_90)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_47d364
                            
                            if (x0_129 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_129)
                            
                            if (x0_74 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_74)
                            
                            int64_t x0_141 = (*(*arg1 + 0xc8))(arg1, x0_135)
                            int64_t x2_36 = var_148
                            
                            if (x2_36 == 0)
                                if ((sub_45be5c(arg1, &var_c0, &var_148, 1, 
                                        "androidx/loader/app/services/", 0x452a4d, 
                                        "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;") & 1)
                                        != 0)
                                    goto label_47d364
                                
                                x2_36 = var_148
                            
                            var_90 = x21
                            int64_t var_88_5 = x0_141
                            int64_t x24_5 = (*(*arg1 + 0x3a0))(arg1, var_c0, x2_36, &var_90)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_47d364
                            
                            if (x21 != 0)
                                (*(*arg1 + 0xb8))(arg1, x21)
                            
                            int64_t x2_39 = var_150
                            
                            if (x2_39 != 0)
                                goto label_47d910
                            
                            int64_t var_170
                            uint64_t x22_4
                            
                            if ((sub_45be5c(arg1, &var_98, &var_150, 1, 
                                "androidx/loader/app/services/", 0x451eff, 
                                "(Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                            label_47d948:
                                x21 = x24_5
                            label_47d364:
                                x22_4 = (*(*arg1 + 0x78))(arg1)
                                (*(*arg1 + 0x88))(arg1)
                                
                                if ((sub_45bb84(arg1, x22_4, "org/json/JSONException") & 1) == 0)
                                label_47fc88:
                                    (*(*arg1 + 0x68))(arg1, x22_4)
                                    result = (*(*arg1 + 0xb8))(arg1, x22_4)
                                else
                                    if (x21 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x21)
                                    
                                    int64_t x2_21 = var_170
                                    
                                    if (x2_21 != 0)
                                        goto label_47d3f4
                                    
                                    result = sub_45be5c(arg1, &var_98, &var_170, 1, 
                                        "androidx/loader/app/services/", &data_40f535, 
                                        "()Ljava/lang/Object;")
                                    
                                    if ((result & 1) == 0)
                                        x2_21 = var_170
                                    label_47d3f4:
                                        int64_t x0_90 =
                                            (*(*arg1 + 0x3a0))(arg1, var_98, x2_21, &var_90)
                                        result = (*(*arg1 + 0x720))(arg1)
                                        
                                        if (x0_90 != 0 && (result & 0xff) == 0)
                                            int64_t x2_22 = var_270
                                            
                                            if (x2_22 != 0)
                                                goto label_47d454
                                            
                                            result = sub_45be5c(arg1, &var_b8, &var_270, 1, 
                                                "androidx/loader/app/services/", &data_40cae0, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;)V")
                                            
                                            if ((result & 1) == 0)
                                                x2_22 = var_270
                                            label_47d454:
                                                var_90 = x0_6
                                                uint64_t var_88_3 = x22_4
                                                (*(*arg1 + 0x478))(arg1, var_b8, x2_22, &var_90)
                                                result = (*(*arg1 + 0x720))(arg1)
                            else
                                x2_39 = var_150
                            label_47d910:
                                var_90 = x24_5
                                x21 = (*(*arg1 + 0x3a0))(arg1, var_98, x2_39, &var_90)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_47d948
                                
                                if (x24_5 != 0)
                                    (*(*arg1 + 0xb8))(arg1, x24_5)
                                
                                int64_t var_160
                                int64_t x2_41 = var_160
                                
                                if (x2_41 == 0)
                                    if ((sub_45be5c(arg1, &var_b8, &var_160, 1, 
                                            "androidx/loader/app/services/", &data_40cd23, 
                                            "(Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                                        goto label_47d364
                                    
                                    x2_41 = var_160
                                
                                var_90 = x23_2
                                int64_t x0_159 = (*(*arg1 + 0x3a0))(arg1, var_b8, x2_41, &var_90)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_47d364
                                
                                if (x23_2 != 0)
                                    (*(*arg1 + 0xb8))(arg1, x23_2)
                                
                                int64_t var_168
                                int64_t x2_43 = var_168
                                
                                if (x2_43 == 0)
                                    if ((sub_45be5c(arg1, &var_98, &var_168, 1, 
                                            "androidx/loader/app/services/", &data_40dea8, 
                                            "(Ljava/lang/Object;Ljava/lang/Object;)Z") & 1) != 0)
                                        goto label_47d364
                                    
                                    x2_43 = var_168
                                
                                var_90 = x0_159
                                int64_t var_88_6 = x21
                                char x0_166 = (*(*arg1 + 0x3b8))(arg1, var_98, x2_43, &var_90)
                                result = (*(*arg1 + 0x720))(arg1)
                                
                                if ((result & 0xff) != 0)
                                    goto label_47d364
                                
                                if (zx.d(x0_166) == 0)
                                    int64_t x2_44 = var_170
                                    
                                    if (x2_44 == 0)
                                        if ((sub_45be5c(arg1, &var_98, &var_170, 1, 
                                                "androidx/loader/app/services/", &data_40f535, 
                                                "()Ljava/lang/Object;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_44 = var_170
                                    
                                    int64_t x0_171 =
                                        (*(*arg1 + 0x3a0))(arg1, var_98, x2_44, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_141 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_141)
                                    
                                    if (x0_171 != 0)
                                        int64_t x2_46 = var_138
                                        
                                        if (x2_46 == 0)
                                            if ((sub_45be5c(arg1, &var_b0, &var_138, 1, 
                                                    "androidx/loader/app/services/l", &data_40e8e6, 
                                                    "()[S") & 1) != 0)
                                                goto label_47d364
                                            
                                            x2_46 = var_138
                                        
                                        int64_t x0_178 =
                                            (*(*arg1 + 0x3a0))(arg1, var_b0, x2_46, &var_90)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            goto label_47d364
                                        
                                        int64_t x2_48 = var_140
                                        
                                        if (x2_48 == 0)
                                            if ((sub_45be5c(arg1, &var_b8, &var_140, 1, 
                                                    "androidx/loader/app/services/", &data_40cfe9, 
                                                    "([SIII)Ljava/lang/String;") & 1) != 0)
                                                goto label_47d364
                                            
                                            x2_48 = var_140
                                        
                                        var_90 = x0_178
                                        var_88_6.d = 0xb8
                                        int32_t var_80_5 = 0x14
                                        int32_t var_78_4 = 0x900
                                        int64_t x0_184 =
                                            (*(*arg1 + 0x3a0))(arg1, var_b8, x2_48, &var_90)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            goto label_47d364
                                        
                                        if (x0_178 != 0)
                                            (*(*arg1 + 0xb8))(arg1, x0_178)
                                        
                                        (*(*arg1 + 0xb8))(arg1, x0_171)
                                        int64_t x0_190 = (*(*arg1 + 0xc8))(arg1, x0_184)
                                        int64_t var_178
                                        int64_t x2_50 = var_178
                                        
                                        if (x2_50 == 0)
                                            if ((sub_45be5c(arg1, &var_98, &var_178, 1, 
                                                    "androidx/loader/app/services/", &data_40d94f, 
                                                    "(Ljava/lang/Object;Ljava/lang/Object;"
                                            "I)Landroid/widget/Toast;") & 1) != 0)
                                                goto label_47d364
                                            
                                            x2_50 = var_178
                                        
                                        var_90 = x0_6
                                        var_88_6 = x0_190
                                        int32_t var_80_6 = 0
                                        int64_t x0_194 =
                                            (*(*arg1 + 0x3a0))(arg1, var_98, x2_50, &var_90)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            goto label_47d364
                                        
                                        if (x0_190 != 0)
                                            (*(*arg1 + 0xb8))(arg1, x0_190)
                                        
                                        int64_t var_180
                                        int64_t x2_53 = var_180
                                        
                                        if (x2_53 == 0)
                                            if ((sub_45be5c(arg1, &var_c0, &var_180, 1, 
                                                    "androidx/loader/app/services/", &data_40cff4, 
                                                    "(Ljava/lang/Object;)V") & 1) != 0)
                                                goto label_47d364
                                            
                                            x2_53 = var_180
                                        
                                        var_90 = x0_194
                                        (*(*arg1 + 0x478))(arg1, var_c0, x2_53, &var_90)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            goto label_47d364
                                        
                                        if (x0_194 != 0)
                                            (*(*arg1 + 0xb8))(arg1, x0_194)
                                    
                                    int64_t var_c8
                                    int64_t x1_90 = var_c8
                                    
                                    if (x1_90 == 0)
                                        if ((sub_45bc9c(arg1, &var_c8, "java/lang/StringBuilder")
                                                & 1) != 0)
                                            goto label_47d364
                                        
                                        x1_90 = var_c8
                                    
                                    int64_t x0_207 = (*(*arg1 + 0xd8))(arg1, x1_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_207 == 0)
                                        sub_45bac8(arg1, "java/lang/NullPointerException", 
                                            "NullPointerException")
                                        goto label_47d364
                                    
                                    int64_t var_188
                                    int64_t x2_54 = var_188
                                    
                                    if (x2_54 == 0)
                                        if ((sub_45be5c(arg1, &var_c8, &var_188, 0, 
                                                "java/lang/StringBuilder", "<init>", "()V") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_54 = var_188
                                    
                                    (*(*arg1 + 0x1f8))(arg1, x0_207, x2_54, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_56 = var_138
                                    
                                    if (x2_56 == 0)
                                        if ((sub_45be5c(arg1, &var_b0, &var_138, 1, 
                                                "androidx/loader/app/services/l", &data_40e8e6, 
                                                "()[S") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_56 = var_138
                                    
                                    int64_t x0_218 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b0, x2_56, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_135 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_135)
                                    
                                    int64_t x2_59 = var_140
                                    
                                    if (x2_59 == 0)
                                        if ((sub_45be5c(arg1, &var_b8, &var_140, 1, 
                                                "androidx/loader/app/services/", &data_40cfe9, 
                                                "([SIII)Ljava/lang/String;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_59 = var_140
                                    
                                    var_90 = x0_218
                                    var_88_6.d = 0xcc
                                    int32_t var_80_7 = 0x14
                                    int32_t var_78_5 = 0x830
                                    int64_t x0_225 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b8, x2_59, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_218 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_218)
                                    
                                    int64_t x0_230 = (*(*arg1 + 0xc8))(arg1, x0_225)
                                    int64_t var_190
                                    int64_t x2_60 = var_190
                                    
                                    if (x2_60 == 0)
                                        if ((sub_45be5c(arg1, &var_98, &var_190, 1, 
                                                "androidx/loader/app/services/", 0x45256b, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;"
                                        ")Ljava/lang/StringBuilder;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_60 = var_190
                                    
                                    var_90 = x0_207
                                    int64_t var_88_7 = x0_230
                                    int64_t x0_234 =
                                        (*(*arg1 + 0x3a0))(arg1, var_98, x2_60, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_234 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_234)
                                    
                                    int64_t x2_63 = var_190
                                    
                                    if (x2_63 == 0)
                                        if ((sub_45be5c(arg1, &var_98, &var_190, 1, 
                                                "androidx/loader/app/services/", 0x45256b, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;"
                                        ")Ljava/lang/StringBuilder;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_63 = var_190
                                    
                                    var_90 = x0_207
                                    int64_t var_88_8 = x0_159
                                    int64_t x0_241 =
                                        (*(*arg1 + 0x3a0))(arg1, var_98, x2_63, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_241 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_241)
                                    
                                    int64_t x2_65 = var_138
                                    
                                    if (x2_65 == 0)
                                        if ((sub_45be5c(arg1, &var_b0, &var_138, 1, 
                                                "androidx/loader/app/services/l", &data_40e8e6, 
                                                "()[S") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_65 = var_138
                                    
                                    int64_t x0_248 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b0, x2_65, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t var_198
                                    int64_t x2_66 = var_198
                                    
                                    if (x2_66 == 0)
                                        if ((sub_45be5c(arg1, &var_98, &var_198, 1, 
                                                "androidx/loader/app/services/", &data_40f0f9, 
                                                "([SIII)Ljava/lang/String;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_66 = var_198
                                    
                                    var_90 = x0_248
                                    var_88_8.d = 0xe0
                                    int32_t var_80_8 = 0x40
                                    int32_t var_78_6 = 0xc7b
                                    int64_t x0_254 =
                                        (*(*arg1 + 0x3a0))(arg1, var_98, x2_66, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_248 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_248)
                                    
                                    if (x0_159 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_159)
                                    
                                    int64_t x0_260 = (*(*arg1 + 0xc8))(arg1, x0_254)
                                    int64_t x2_68 = var_190
                                    
                                    if (x2_68 == 0)
                                        if ((sub_45be5c(arg1, &var_98, &var_190, 1, 
                                                "androidx/loader/app/services/", 0x45256b, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;"
                                        ")Ljava/lang/StringBuilder;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_68 = var_190
                                    
                                    var_90 = x0_207
                                    int64_t var_88_9 = x0_260
                                    int64_t x0_264 =
                                        (*(*arg1 + 0x3a0))(arg1, var_98, x2_68, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_264 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_264)
                                    
                                    int64_t x2_71 = var_190
                                    
                                    if (x2_71 == 0)
                                        if ((sub_45be5c(arg1, &var_98, &var_190, 1, 
                                                "androidx/loader/app/services/", 0x45256b, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;"
                                        ")Ljava/lang/StringBuilder;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_71 = var_190
                                    
                                    var_90 = x0_207
                                    int64_t var_88_10 = x21
                                    int64_t x0_271 =
                                        (*(*arg1 + 0x3a0))(arg1, var_98, x2_71, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_271 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_271)
                                    
                                    int64_t x2_73 = var_138
                                    
                                    if (x2_73 == 0)
                                        if ((sub_45be5c(arg1, &var_b0, &var_138, 1, 
                                                "androidx/loader/app/services/l", &data_40e8e6, 
                                                "()[S") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_73 = var_138
                                    
                                    int64_t x0_278 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b0, x2_73, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_74 = var_198
                                    
                                    if (x2_74 == 0)
                                        if ((sub_45be5c(arg1, &var_98, &var_198, 1, 
                                                "androidx/loader/app/services/", &data_40f0f9, 
                                                "([SIII)Ljava/lang/String;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_74 = var_198
                                    
                                    var_90 = x0_278
                                    var_88_10.d = 0x120
                                    int32_t var_80_9 = 0x11
                                    int32_t var_78_7 = 0x951
                                    int64_t x0_284 =
                                        (*(*arg1 + 0x3a0))(arg1, var_98, x2_74, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_278 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_278)
                                    
                                    if (x21 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x21)
                                    
                                    int64_t x0_290 = (*(*arg1 + 0xc8))(arg1, x0_284)
                                    int64_t x2_76 = var_190
                                    
                                    if (x2_76 == 0)
                                        if ((sub_45be5c(arg1, &var_98, &var_190, 1, 
                                                "androidx/loader/app/services/", 0x45256b, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;"
                                        ")Ljava/lang/StringBuilder;") & 1) != 0)
                                            x21 = x0_290
                                            goto label_47d364
                                        
                                        x2_76 = var_190
                                    
                                    var_90 = x0_207
                                    int64_t var_88_11 = x0_290
                                    int64_t x0_294 =
                                        (*(*arg1 + 0x3a0))(arg1, var_98, x2_76, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        x21 = x0_290
                                        goto label_47d364
                                    
                                    if (x0_294 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_294)
                                    
                                    int64_t var_1a0
                                    int64_t x2_79 = var_1a0
                                    
                                    if (x2_79 == 0)
                                        if ((sub_45be5c(arg1, &var_c0, &var_1a0, 1, 
                                                "androidx/loader/app/services/", &data_40e3cf, 
                                                "(Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                                            x21 = x0_290
                                            goto label_47d364
                                        
                                        x2_79 = var_1a0
                                    
                                    var_90 = x0_207
                                    x21 = (*(*arg1 + 0x3a0))(arg1, var_c0, x2_79, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        x21 = x0_290
                                        goto label_47d364
                                    
                                    if (x0_290 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_290)
                                    
                                    int64_t var_1a8
                                    int64_t x2_81 = var_1a8
                                    
                                    if (x2_81 == 0)
                                        if ((sub_45be5c(arg1, &var_b8, &var_1a8, 1, 
                                                "androidx/loader/app/services/", &data_40c08f, 
                                                "(Ljava/lang/Object;)Landroid/view/View;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_81 = var_1a8
                                    
                                    var_90 = x0_6
                                    int64_t x0_308 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b8, x2_81, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_260 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_260)
                                    
                                    int64_t var_1b0
                                    int64_t x2_83 = var_1b0
                                    
                                    if (x2_83 == 0)
                                        if ((sub_45be5c(arg1, &var_c0, &var_1b0, 1, 
                                                "androidx/loader/app/services/", &data_40caf6, 
                                                "(Ljava/lang/Object;I)Landroid/view/View;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_83 = var_1b0
                                    
                                    var_90 = x0_308
                                    var_88_11.d = 0x1020016
                                    int64_t x0_315 =
                                        (*(*arg1 + 0x3a0))(arg1, var_c0, x2_83, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    (*(*arg1 + 0xb8))(arg1, x0_207)
                                    int64_t var_d0
                                    int64_t x2_84 = var_d0
                                    
                                    if (x2_84 == 0)
                                        if ((sub_45bc9c(arg1, &var_d0, "android/widget/TextView")
                                                & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_84 = var_d0
                                    
                                    if ((sub_45bc08(arg1, x0_315, x2_84, "android/widget/TextView")
                                            & 1) != 0)
                                        goto label_47d364
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_85 = var_1b0
                                    
                                    if (x2_85 == 0)
                                        if ((sub_45be5c(arg1, &var_c0, &var_1b0, 1, 
                                                "androidx/loader/app/services/", &data_40caf6, 
                                                "(Ljava/lang/Object;I)Landroid/view/View;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_85 = var_1b0
                                    
                                    var_90 = x0_308
                                    var_88_11.d = 0x102000b
                                    int64_t x0_328 =
                                        (*(*arg1 + 0x3a0))(arg1, var_c0, x2_85, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_230 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_230)
                                    
                                    int64_t x2_87 = var_d0
                                    
                                    if (x2_87 == 0)
                                        if ((sub_45bc9c(arg1, &var_d0, "android/widget/TextView")
                                                & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_87 = var_d0
                                    
                                    if ((sub_45bc08(arg1, x0_328, x2_87, "android/widget/TextView")
                                            & 1) != 0)
                                        goto label_47d364
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_88 = var_1b0
                                    
                                    if (x2_88 == 0)
                                        if ((sub_45be5c(arg1, &var_c0, &var_1b0, 1, 
                                                "androidx/loader/app/services/", &data_40caf6, 
                                                "(Ljava/lang/Object;I)Landroid/view/View;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_88 = var_1b0
                                    
                                    var_90 = x0_308
                                    var_88_11.d = 0x1020019
                                    int64_t x0_341 =
                                        (*(*arg1 + 0x3a0))(arg1, var_c0, x2_88, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_90 = var_d0
                                    
                                    if (x2_90 == 0)
                                        if ((sub_45bc9c(arg1, &var_d0, "android/widget/TextView")
                                                & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_90 = var_d0
                                    
                                    if ((sub_45bc08(arg1, x0_341, x2_90, "android/widget/TextView")
                                            & 1) != 0)
                                        goto label_47d364
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_91 = var_1b0
                                    
                                    if (x2_91 == 0)
                                        if ((sub_45be5c(arg1, &var_c0, &var_1b0, 1, 
                                                "androidx/loader/app/services/", &data_40caf6, 
                                                "(Ljava/lang/Object;I)Landroid/view/View;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_91 = var_1b0
                                    
                                    var_90 = x0_308
                                    var_88_11.d = 0x102001a
                                    int64_t x0_353 =
                                        (*(*arg1 + 0x3a0))(arg1, var_c0, x2_91, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_93 = var_d0
                                    
                                    if (x2_93 == 0)
                                        if ((sub_45bc9c(arg1, &var_d0, "android/widget/TextView")
                                                & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_93 = var_d0
                                    
                                    if ((sub_45bc08(arg1, x0_353, x2_93, "android/widget/TextView")
                                            & 1) != 0)
                                        goto label_47d364
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t var_d8
                                    int64_t x1_153 = var_d8
                                    
                                    if (x1_153 == 0)
                                        if ((sub_45bc9c(arg1, &var_d8, 
                                                "android/app/AlertDialog$Builder") & 1) != 0)
                                            goto label_47d364
                                        
                                        x1_153 = var_d8
                                    
                                    int64_t x0_365 = (*(*arg1 + 0xd8))(arg1, x1_153)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_365 == 0)
                                        sub_45bac8(arg1, "java/lang/NullPointerException", 
                                            "NullPointerException")
                                        goto label_47d364
                                    
                                    int64_t var_1b8
                                    int64_t x2_94 = var_1b8
                                    
                                    if (x2_94 == 0)
                                        if ((sub_45be5c(arg1, &var_d8, &var_1b8, 0, 
                                                "android/app/AlertDialog$Builder", "<init>", 
                                                "(Landroid/content/Context;I)V") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_94 = var_1b8
                                    
                                    var_90 = x0_6
                                    var_88_11.d = 0x1030229
                                    (*(*arg1 + 0x1f8))(arg1, x0_365, x2_94, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t var_1c0
                                    int64_t x2_96 = var_1c0
                                    
                                    if (x2_96 == 0)
                                        if ((sub_45be5c(arg1, &var_b8, &var_1c0, 1, 
                                                "androidx/loader/app/services/", &data_40dea8, 
                                                "(Ljava/lang/Object;Z)Landroid/app/AlertDialog$Builder;")
                                                & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_96 = var_1c0
                                    
                                    var_90 = x0_365
                                    var_88_11.b = 0
                                    int64_t x0_376 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b8, x2_96, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    (*(*arg1 + 0xb8))(arg1, x0_365)
                                    int64_t var_1c8
                                    int64_t x2_98 = var_1c8
                                    
                                    if (x2_98 == 0)
                                        if ((sub_45be5c(arg1, &var_b8, &var_1c8, 1, 
                                                "androidx/loader/app/services/", &data_40e1f0, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;"
                                        ")Landroid/app/AlertDialog$Builder;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_98 = var_1c8
                                    
                                    var_90 = x0_376
                                    int64_t var_88_12 = x0_308
                                    int64_t x0_383 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b8, x2_98, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_308 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_308)
                                    
                                    int64_t var_1d0
                                    int64_t x2_101 = var_1d0
                                    
                                    if (x2_101 == 0)
                                        if ((sub_45be5c(arg1, &var_a0, &var_1d0, 1, 
                                                "androidx/loader/app/services/", 0x4520fc, 
                                                "(Ljava/lang/Object;)Landroid/app/AlertDialog;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_101 = var_1d0
                                    
                                    var_90 = x0_383
                                    int64_t x0_390 =
                                        (*(*arg1 + 0x3a0))(arg1, var_a0, x2_101, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_383 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_383)
                                    
                                    int64_t x2_103 = var_138
                                    
                                    if (x2_103 == 0)
                                        if ((sub_45be5c(arg1, &var_b0, &var_138, 1, 
                                                "androidx/loader/app/services/l", &data_40e8e6, 
                                                "()[S") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_103 = var_138
                                    
                                    int64_t x0_397 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b0, x2_103, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_104 = var_198
                                    
                                    if (x2_104 == 0)
                                        if ((sub_45be5c(arg1, &var_98, &var_198, 1, 
                                                "androidx/loader/app/services/", &data_40f0f9, 
                                                "([SIII)Ljava/lang/String;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_104 = var_198
                                    
                                    var_90 = x0_397
                                    var_88_12.d = 0x131
                                    int32_t var_80_10 = 7
                                    int32_t var_78_8 = 0xb73
                                    int64_t x0_403 =
                                        (*(*arg1 + 0x3a0))(arg1, var_98, x2_104, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_397 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_397)
                                    
                                    if (x0_376 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_376)
                                    
                                    int64_t x0_409 = (*(*arg1 + 0xc8))(arg1, x0_403)
                                    int64_t var_1d8
                                    int64_t x2_106 = var_1d8
                                    
                                    if (x2_106 == 0)
                                        if ((sub_45be5c(arg1, &var_b8, &var_1d8, 1, 
                                                "androidx/loader/app/services/", 0x451c24, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;)V") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_106 = var_1d8
                                    
                                    var_90 = x0_315
                                    int64_t var_88_13 = x0_409
                                    (*(*arg1 + 0x478))(arg1, var_b8, x2_106, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t var_1e0
                                    int64_t x2_108 = var_1e0
                                    
                                    if (x2_108 == 0)
                                        if ((sub_45be5c(arg1, &var_b8, &var_1e0, 1, 
                                                "androidx/loader/app/services/", &data_40e8f1, 
                                                "(Ljava/lang/Object;)Landroid/text/Spanned;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_108 = var_1e0
                                    
                                    var_90 = x21
                                    int64_t x25_13 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b8, x2_108, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x21 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x21)
                                    
                                    int64_t x2_111 = var_1d8
                                    
                                    if (x2_111 == 0)
                                        if ((sub_45be5c(arg1, &var_b8, &var_1d8, 1, 
                                                "androidx/loader/app/services/", 0x451c24, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;)V") & 1) != 0)
                                            x21 = x25_13
                                            goto label_47d364
                                        
                                        x2_111 = var_1d8
                                    
                                    int64_t x1_179 = var_b8
                                    var_90 = x0_328
                                    int64_t var_88_14 = x25_13
                                    (*(*arg1 + 0x478))(arg1, x1_179, x2_111, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        x21 = x25_13
                                        goto label_47d364
                                    
                                    int64_t x2_112 = var_138
                                    
                                    if (x2_112 == 0)
                                        if ((sub_45be5c(arg1, &var_b0, &var_138, 1, 
                                                "androidx/loader/app/services/l", &data_40e8e6, 
                                                "()[S") & 1) != 0)
                                            x21 = x25_13
                                            goto label_47d364
                                        
                                        x2_112 = var_138
                                    
                                    int64_t x0_430 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b0, x2_112, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        x21 = x25_13
                                        goto label_47d364
                                    
                                    int64_t var_1e8
                                    int64_t x2_114 = var_1e8
                                    
                                    if (x2_114 == 0)
                                        if ((sub_45be5c(arg1, &var_a0, &var_1e8, 1, 
                                                "androidx/loader/app/services/", 0x451bf8, 
                                                "([SIII)Ljava/lang/String;") & 1) != 0)
                                            x21 = x25_13
                                            goto label_47d364
                                        
                                        x2_114 = var_1e8
                                    
                                    var_90 = x0_430
                                    var_88_14.d = 0x138
                                    int32_t var_80_11 = 6
                                    int32_t var_78_9 = 0x993
                                    int64_t x0_436 =
                                        (*(*arg1 + 0x3a0))(arg1, var_a0, x2_114, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        x21 = x25_13
                                        goto label_47d364
                                    
                                    if (x0_430 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_430)
                                    
                                    if (x25_13 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x25_13)
                                    
                                    int64_t x0_442 = (*(*arg1 + 0xc8))(arg1, x0_436)
                                    int64_t x2_116 = var_1d8
                                    x21 = x0_442
                                    
                                    if (x2_116 == 0)
                                        if ((sub_45be5c(arg1, &var_b8, &var_1d8, 1, 
                                                "androidx/loader/app/services/", 0x451c24, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;)V") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_116 = var_1d8
                                    
                                    int64_t x1_188 = var_b8
                                    var_90 = x0_341
                                    int64_t var_88_15 = x21
                                    (*(*arg1 + 0x478))(arg1, x1_188, x2_116, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_118 = var_138
                                    
                                    if (x2_118 == 0)
                                        if ((sub_45be5c(arg1, &var_b0, &var_138, 1, 
                                                "androidx/loader/app/services/l", &data_40e8e6, 
                                                "()[S") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_118 = var_138
                                    
                                    int64_t x0_451 =
                                        (*(*arg1 + 0x3a0))(arg1, var_b0, x2_118, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_120 = var_1e8
                                    
                                    if (x2_120 == 0)
                                        if ((sub_45be5c(arg1, &var_a0, &var_1e8, 1, 
                                                "androidx/loader/app/services/", 0x451bf8, 
                                                "([SIII)Ljava/lang/String;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_120 = var_1e8
                                    
                                    var_90 = x0_451
                                    var_88_15.d = 0x13e
                                    int32_t var_80_12 = 6
                                    int32_t var_78_10 = 0x6b6
                                    int64_t x0_457 =
                                        (*(*arg1 + 0x3a0))(arg1, var_a0, x2_120, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x0_451 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_451)
                                    
                                    if (x21 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x21)
                                    
                                    int64_t x0_463 = (*(*arg1 + 0xc8))(arg1, x0_457)
                                    int64_t x2_122 = var_1d8
                                    x21 = x0_463
                                    
                                    if (x2_122 == 0)
                                        if ((sub_45be5c(arg1, &var_b8, &var_1d8, 1, 
                                                "androidx/loader/app/services/", 0x451c24, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;)V") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_122 = var_1d8
                                    
                                    int64_t x1_197 = var_b8
                                    var_90 = x0_353
                                    int64_t var_88_16 = x21
                                    (*(*arg1 + 0x478))(arg1, x1_197, x2_122, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x21 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x21)
                                    
                                    int64_t var_e0
                                    int64_t x1_200 = var_e0
                                    
                                    if (x1_200 == 0)
                                        if ((sub_45bc9c(arg1, &var_e0, 
                                                "androidx/loader/app/services/g") & 1) != 0)
                                            goto label_47d364
                                        
                                        x1_200 = var_e0
                                    
                                    x21 = (*(*arg1 + 0xd8))(arg1, x1_200)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x21 == 0)
                                        sub_45bac8(arg1, "java/lang/NullPointerException", 
                                            "NullPointerException")
                                        goto label_47d364
                                    
                                    int64_t var_1f0
                                    int64_t x2_124 = var_1f0
                                    
                                    if (x2_124 == 0)
                                        if ((sub_45be5c(arg1, &var_e0, &var_1f0, 0, 
                                                "androidx/loader/app/services/g", "<init>", 
                                                "(Landroid/app/AlertDialog;)V") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_124 = var_1f0
                                    
                                    var_90 = x0_390
                                    (*(*arg1 + 0x1f8))(arg1, x21, x2_124, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t var_1f8
                                    int64_t x2_126 = var_1f8
                                    
                                    if (x2_126 == 0)
                                        if ((sub_45be5c(arg1, &var_a0, &var_1f8, 1, 
                                                "androidx/loader/app/services/", 0x452105, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;)V") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_126 = var_1f8
                                    
                                    int64_t x1_204 = var_a0
                                    var_90 = x0_353
                                    int64_t var_88_17 = x21
                                    (*(*arg1 + 0x478))(arg1, x1_204, x2_126, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    (*(*arg1 + 0xb8))(arg1, x21)
                                    int64_t var_e8
                                    int64_t x1_206 = var_e8
                                    
                                    if (x1_206 == 0)
                                        if ((sub_45bc9c(arg1, &var_e8, 
                                                "androidx/loader/app/services/h") & 1) != 0)
                                            goto label_47d364
                                        
                                        x1_206 = var_e8
                                    
                                    x21 = (*(*arg1 + 0xd8))(arg1, x1_206)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (x21 == 0)
                                        sub_45bac8(arg1, "java/lang/NullPointerException", 
                                            "NullPointerException")
                                        goto label_47d364
                                    
                                    int64_t var_200
                                    int64_t x2_128 = var_200
                                    
                                    if (x2_128 == 0)
                                        if ((sub_45be5c(arg1, &var_e8, &var_200, 0, 
                                                "androidx/loader/app/services/h", "<init>", 
                                                "(Landroid/content/Context;Ljava/lang/String;)V") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_128 = var_200
                                    
                                    var_90 = x0_6
                                    int64_t var_88_18 = x0_122
                                    (*(*arg1 + 0x1f8))(arg1, x21, x2_128, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t x2_130 = var_1f8
                                    
                                    if (x2_130 == 0)
                                        if ((sub_45be5c(arg1, &var_a0, &var_1f8, 1, 
                                                "androidx/loader/app/services/", 0x452105, 
                                                "(Ljava/lang/Object;Ljava/lang/Object;)V") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_130 = var_1f8
                                    
                                    int64_t x1_211 = var_a0
                                    var_90 = x0_341
                                    int64_t var_88_19 = x21
                                    (*(*arg1 + 0x478))(arg1, x1_211, x2_130, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    int64_t var_208
                                    int64_t x2_132 = var_208
                                    
                                    if (x2_132 == 0)
                                        if ((sub_45be5c(arg1, &var_b8, &var_208, 1, 
                                                "androidx/loader/app/services/", &data_40e8fc, 
                                                "(Ljava/lang/Object;)Z") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_132 = var_208
                                    
                                    var_90 = x0_390
                                    char x0_506 = (*(*arg1 + 0x3b8))(arg1, var_b8, x2_132, &var_90)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        goto label_47d364
                                    
                                    if (zx.d(x0_506) == 0)
                                        if (x0_122 != 0)
                                            (*(*arg1 + 0xb8))(arg1, x0_122)
                                        
                                        int64_t x0_511 = (*(*arg1 + 0x588))(arg1, 4)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                            int16_t x0_514 = sub_45bb3c(float.d(0x405dc00000000000))
                                            
                                            if (x0_511 == 0)
                                                sub_45bac8(arg1, "java/lang/NullPointerException", 
                                                    "NullPointerException")
                                            else
                                                var_90.w = x0_514
                                                (*(*arg1 + 0x688))(arg1, x0_511, 3, 1, &var_90)
                                                
                                                if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                    var_90.w = sub_45bb3c(111.11900000274181)
                                                    (*(*arg1 + 0x688))(arg1, x0_511, 2, 1, &var_90)
                                                    
                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                        var_90.w = sub_45bb3c(104.11111900000833)
                                                        (*(*arg1 + 0x688))(arg1, x0_511, 1, 1, 
                                                            &var_90)
                                                        
                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                            var_90.w =
                                                                sub_45bb3c(115.10411111900001)
                                                            (*(*arg1 + 0x688))(arg1, x0_511, 0, 1, 
                                                                &var_90)
                                                            
                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                (*(*arg1 + 0xb8))(arg1, x21)
                                                                int64_t var_f0
                                                                int64_t x1_220 = var_f0
                                                                
                                                                if (x1_220 != 0)
                                                                    goto label_47f69c
                                                                
                                                                if ((sub_45bc9c(arg1, &var_f0, 
                                                                        "java/lang/String") & 1) == 0)
                                                                    x1_220 = var_f0
                                                                label_47f69c:
                                                                    x21 = (*(*arg1 + 0xc8))(arg1, x1_220)
                                                                    
                                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                        if (x0_328 != 0)
                                                                            (*(*arg1 + 0xb8))(arg1, x0_328)
                                                                        
                                                                        int64_t var_f8
                                                                        int64_t x2_134 = var_f8
                                                                        
                                                                        if (x2_134 != 0)
                                                                            goto label_47f708
                                                                        
                                                                        if ((sub_45bc9c(arg1, &var_f8, 
                                                                                "java/lang/Class") & 1) == 0)
                                                                            x2_134 = var_f8
                                                                        label_47f708:
                                                                            int64_t x0_541 =
                                                                                (*(*arg1 + 0x560))(arg1, 1, x2_134, 0)
                                                                            
                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                if (x0_341 != 0)
                                                                                    (*(*arg1 + 0xb8))(arg1, x0_341)
                                                                                
                                                                                int64_t var_100
                                                                                int64_t x1_226 = var_100
                                                                                
                                                                                if (x1_226 != 0)
                                                                                    goto label_47f774
                                                                                
                                                                                if ((
                                                                                        sub_45bc9c(arg1, &var_100, 0x452574)
                                                                                        & 1) == 0)
                                                                                    x1_226 = var_100
                                                                                label_47f774:
                                                                                    int64_t x0_548 =
                                                                                        (*(*arg1 + 0xc8))(arg1, x1_226)
                                                                                    
                                                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                        if (x0_541 == 0)
                                                                                            sub_45bac8(arg1, 
                                                                                                "java/lang/NullPointerException", 
                                                                                                "NullPointerException")
                                                                                        else
                                                                                            (*(*arg1 + 0x570))(arg1, x0_541, 0, 
                                                                                                x0_548)
                                                                                            
                                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                int64_t var_210
                                                                                                int64_t x2_135 = var_210
                                                                                                
                                                                                                if (x2_135 != 0)
                                                                                                    goto label_47f808
                                                                                                
                                                                                                if ((sub_45be5c(arg1, &var_98, 
                                                                                                        &var_210, 1, 
                                                                                                        "androidx/loader/app/services/", 
                                                                                                        &data_40cd65, 
                                                                                                        "(Ljava/lang/Object;Ljava/lang/Object;"
                                                                                                ")Ljava/lang/reflect/Constructor;") & 1)
                                                                                                        == 0)
                                                                                                    x2_135 = var_210
                                                                                                label_47f808:
                                                                                                    var_90 = x21
                                                                                                    var_88_19 = x0_541
                                                                                                    int64_t x0_557 = (*(*arg1 + 0x3a0))(
                                                                                                        arg1, var_98, x2_135, &var_90)
                                                                                                    
                                                                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                        if (x21 != 0)
                                                                                                            (*(*arg1 + 0xb8))(arg1, x21)
                                                                                                        
                                                                                                        int64_t var_218
                                                                                                        int64_t x2_138 = var_218
                                                                                                        
                                                                                                        if (x2_138 != 0)
                                                                                                            goto label_47f898
                                                                                                        
                                                                                                        if ((sub_45be5c(arg1, &var_c0, 
                                                                                                                &var_218, 1, 
                                                                                                                "androidx/loader/app/services/", 
                                                                                                                &data_40e1f5, "(Ljava/lang/Object;Z)V")
                                                                                                                & 1) != 0)
                                                                                                            x21 = x0_557
                                                                                                        else
                                                                                                            x2_138 = var_218
                                                                                                        label_47f898:
                                                                                                            var_90 = x0_557
                                                                                                            var_88_19.b = 1
                                                                                                            (*(*arg1 + 0x478))(arg1, var_c0, 
                                                                                                                x2_138, &var_90)
                                                                                                            
                                                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                x21 = x0_557
                                                                                                            else
                                                                                                                int64_t var_220
                                                                                                                int64_t x2_139 = var_220
                                                                                                                
                                                                                                                if (x2_139 != 0)
                                                                                                                    goto label_47f90c
                                                                                                                
                                                                                                                if ((sub_45be5c(arg1, &var_a0, 
                                                                                                                        &var_220, 1, 
                                                                                                                        "androidx/loader/app/services/", 
                                                                                                                        &data_40cb64, 
                                                                                                                        "(Ljava/lang/Object;)Ljava/lang/Class;")
                                                                                                                        & 1) != 0)
                                                                                                                    x21 = x0_557
                                                                                                                else
                                                                                                                    x2_139 = var_220
                                                                                                                label_47f90c:
                                                                                                                    var_90 = x0_390
                                                                                                                    int64_t x0_569 = (*(*arg1 + 0x3a0))(
                                                                                                                        arg1, var_a0, x2_139, &var_90)
                                                                                                                    
                                                                                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                        x21 = x0_557
                                                                                                                    else
                                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_541)
                                                                                                                        
                                                                                                                        if (x0_315 != 0)
                                                                                                                            (*(*arg1 + 0xb8))(arg1, x0_315)
                                                                                                                        
                                                                                                                        int64_t var_108
                                                                                                                        int64_t x2_141 = var_108
                                                                                                                        
                                                                                                                        if (x2_141 != 0)
                                                                                                                            goto label_47f9a8
                                                                                                                        
                                                                                                                        if ((sub_45bc9c(arg1, &var_108, 
                                                                                                                                "java/lang/Object") & 1) != 0)
                                                                                                                            x21 = x0_557
                                                                                                                        else
                                                                                                                            x2_141 = var_108
                                                                                                                        label_47f9a8:
                                                                                                                            int64_t x0_577 =
                                                                                                                                (*(*arg1 + 0x560))(arg1, 1, x2_141, 0)
                                                                                                                            
                                                                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                x21 = x0_557
                                                                                                                            else if (x0_577 == 0)
                                                                                                                                sub_45bac8(arg1, 
                                                                                                                                    "java/lang/NullPointerException", 
                                                                                                                                    "NullPointerException")
                                                                                                                                x21 = x0_557
                                                                                                                            else
                                                                                                                                (*(*arg1 + 0x570))(arg1, x0_577, 0, 
                                                                                                                                    x0_511)
                                                                                                                                
                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                    x21 = x0_557
                                                                                                                                else
                                                                                                                                    int64_t var_228
                                                                                                                                    int64_t x2_142 = var_228
                                                                                                                                    
                                                                                                                                    if (x2_142 != 0)
                                                                                                                                        goto label_47fa3c
                                                                                                                                    
                                                                                                                                    if ((sub_45be5c(arg1, &var_98, 
                                                                                                                                            &var_228, 1, 
                                                                                                                                            "androidx/loader/app/services/", 
                                                                                                                                            &data_40c8c0, 
                                                                                                                                            "(Ljava/lang/Object;Ljava/lang/Object;"
                                                                                                                                    ")Ljava/lang/Object;") & 1) != 0)
                                                                                                                                        x21 = x0_557
                                                                                                                                    else
                                                                                                                                        x2_142 = var_228
                                                                                                                                    label_47fa3c:
                                                                                                                                        var_90 = x0_557
                                                                                                                                        var_88_19 = x0_577
                                                                                                                                        int64_t x0_586 = (*(*arg1 + 0x3a0))(
                                                                                                                                            arg1, var_98, x2_142, &var_90)
                                                                                                                                        
                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                            x21 = x0_557
                                                                                                                                        else
                                                                                                                                            if (x0_557 != 0)
                                                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_557)
                                                                                                                                            
                                                                                                                                            int64_t var_110
                                                                                                                                            int64_t x2_144 = var_110
                                                                                                                                            
                                                                                                                                            if (x2_144 != 0)
                                                                                                                                                goto label_47fac0
                                                                                                                                            
                                                                                                                                            if ((sub_45bc9c(arg1, &var_110, 
                                                                                                                                                    "java/lang/String") & 1) != 0)
                                                                                                                                                x21 = x0_586
                                                                                                                                            else
                                                                                                                                                x2_144 = var_110
                                                                                                                                            label_47fac0:
                                                                                                                                                
                                                                                                                                                if ((sub_45bc08(arg1, x0_586, x2_144, 
                                                                                                                                                        "java/lang/String") & 1) != 0)
                                                                                                                                                    x21 = x0_586
                                                                                                                                                else if (zx.d((*(*arg1 + 0x720))(arg1))
                                                                                                                                                        != 0)
                                                                                                                                                    x21 = x0_586
                                                                                                                                                else
                                                                                                                                                    (*(*arg1 + 0xb8))(arg1, x0_511)
                                                                                                                                                    int64_t x2_145 = var_f8
                                                                                                                                                    
                                                                                                                                                    if (x2_145 != 0)
                                                                                                                                                        goto label_47fb2c
                                                                                                                                                    
                                                                                                                                                    if ((sub_45bc9c(arg1, &var_f8, 
                                                                                                                                                            "java/lang/Class") & 1) != 0)
                                                                                                                                                        x21 = x0_586
                                                                                                                                                    else
                                                                                                                                                        x2_145 = var_f8
                                                                                                                                                    label_47fb2c:
                                                                                                                                                        int64_t x0_600 =
                                                                                                                                                            (*(*arg1 + 0x560))(arg1, 0, x2_145, 0)
                                                                                                                                                        
                                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                            x21 = x0_586
                                                                                                                                                        else
                                                                                                                                                            int64_t var_230
                                                                                                                                                            int64_t x2_146 = var_230
                                                                                                                                                            
                                                                                                                                                            if (x2_146 != 0)
                                                                                                                                                                goto label_47fb88
                                                                                                                                                            
                                                                                                                                                            if ((sub_45be5c(arg1, &var_b8, 
                                                                                                                                                                    &var_230, 1, 
                                                                                                                                                                    "androidx/loader/app/services/", 
                                                                                                                                                                    0x451c2d, 
                                                                                                                                                                    "(Ljava/lang/Object;Ljava/lang/Object;"
                                                                                                                                                            "Ljava/lang/Object;"
                                                                                                                                                            ")Ljava/lang/reflect/Method;") & 1)
                                                                                                                                                                    != 0)
                                                                                                                                                                x21 = x0_586
                                                                                                                                                            else
                                                                                                                                                                x2_146 = var_230
                                                                                                                                                            label_47fb88:
                                                                                                                                                                var_90 = x0_569
                                                                                                                                                                var_88_19 = x0_586
                                                                                                                                                                var_80_12.q = x0_600
                                                                                                                                                                x21 = (*(*arg1 + 0x3a0))(arg1, var_b8, 
                                                                                                                                                                    x2_146, &var_90)
                                                                                                                                                                
                                                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                                                                                    if (x0_586 != 0)
                                                                                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_586)
                                                                                                                                                                    
                                                                                                                                                                    if (x0_600 != 0)
                                                                                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_600)
                                                                                                                                                                    
                                                                                                                                                                    int64_t x2_150 = var_108
                                                                                                                                                                    
                                                                                                                                                                    if (x2_150 != 0)
                                                                                                                                                                        goto label_47fd5c
                                                                                                                                                                    
                                                                                                                                                                    if ((sub_45bc9c(arg1, &var_108, 
                                                                                                                                                                            "java/lang/Object") & 1) == 0)
                                                                                                                                                                        x2_150 = var_108
                                                                                                                                                                    label_47fd5c:
                                                                                                                                                                        int64_t x0_628 =
                                                                                                                                                                            (*(*arg1 + 0x560))(arg1, 0, x2_150, 0)
                                                                                                                                                                        
                                                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                                                                                            int64_t var_238
                                                                                                                                                                            int64_t x2_151 = var_238
                                                                                                                                                                            
                                                                                                                                                                            if (x2_151 != 0)
                                                                                                                                                                                goto label_47fdb8
                                                                                                                                                                            
                                                                                                                                                                            if ((sub_45be5c(arg1, &var_a0, 
                                                                                                                                                                                    &var_238, 1, 
                                                                                                                                                                                    "androidx/loader/app/services/", 
                                                                                                                                                                                    &data_40c098, 
                                                                                                                                                                                    "(Ljava/lang/Object;Ljava/lang/Object;"
                                                                                                                                                                            "Ljava/lang/Object;)Ljava/lang/Object;")
                                                                                                                                                                                    & 1) == 0)
                                                                                                                                                                                x2_151 = var_238
                                                                                                                                                                            label_47fdb8:
                                                                                                                                                                                var_90 = x21
                                                                                                                                                                                var_88_19 = x0_390
                                                                                                                                                                                var_80_12.q = x0_628
                                                                                                                                                                                int64_t x0_634 = (*(*arg1 + 0x3a0))(
                                                                                                                                                                                    arg1, var_a0, x2_151, &var_90)
                                                                                                                                                                                
                                                                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                                                                                                    if (x0_634 != 0)
                                                                                                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_634)
                                                                                                                                                                                    
                                                                                                                                                                                    goto label_47fe0c
                                                                                                                                                                else
                                                                                                                                                                    x21 = x0_586
                                        
                                        x22_4 = (*(*arg1 + 0x78))(arg1)
                                        (*(*arg1 + 0x88))(arg1)
                                        
                                        if ((sub_45bb84(arg1, x22_4, "java/lang/Exception") & 1)
                                                == 0)
                                            goto label_47fc88
                                        
                                        int64_t var_240
                                        int64_t x2_148 = var_240
                                        
                                        if (x2_148 == 0)
                                            if ((sub_45be5c(arg1, &var_98, &var_240, 1, 
                                                    "androidx/loader/app/services/", &data_40c261, 
                                                    "(Ljava/lang/Object;)V") & 1) != 0)
                                                goto label_47d364
                                            
                                            x2_148 = var_240
                                        
                                        var_90 = x0_390
                                        (*(*arg1 + 0x478))(arg1, var_98, x2_148, &var_90)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            goto label_47d364
                                        
                                        goto label_47fe0c
                                    
                                label_47fe0c:
                                    int64_t var_248
                                    int64_t x2_154 = var_248
                                    
                                    if (x2_154 == 0)
                                        if ((sub_45be5c(arg1, &var_c0, &var_248, 1, 
                                                "androidx/loader/app/services/", &data_40f10d, 
                                                "(Ljava/lang/Object;)Landroid/view/Window;") & 1) != 0)
                                            goto label_47d364
                                        
                                        x2_154 = var_248
                                    
                                    var_90 = x0_390
                                    int64_t x0_641 =
                                        (*(*arg1 + 0x3a0))(arg1, var_c0, x2_154, &var_90)
                                    result = (*(*arg1 + 0x720))(arg1)
                                    
                                    if ((result & 0xff) != 0)
                                        goto label_47d364
                                    
                                    if (x21 != 0)
                                        result = (*(*arg1 + 0xb8))(arg1, x21)
                                    
                                    if (x0_641 != 0)
                                        int64_t var_250
                                        int64_t x2_155 = var_250
                                        
                                        if (x2_155 == 0)
                                            if ((sub_45be5c(arg1, &var_b8, &var_250, 1, 
                                                    "androidx/loader/app/services/", &data_40ebcc, 
                                                    "(Ljava/lang/Object;)Landroid/view/View;") & 1) != 0)
                                                x21 = x0_641
                                                goto label_47d364
                                            
                                            x2_155 = var_250
                                        
                                        var_90 = x0_641
                                        x24_5 = (*(*arg1 + 0x3a0))(arg1, var_b8, x2_155, &var_90)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            x21 = x0_641
                                            goto label_47d364
                                        
                                        (*(*arg1 + 0xb8))(arg1, x0_641)
                                        int64_t var_258
                                        int64_t x2_157 = var_258
                                        
                                        if (x2_157 == 0)
                                            if ((sub_45be5c(arg1, &var_b8, &var_258, 1, 
                                                    "androidx/loader/app/services/", &data_40df35, 
                                                    "(Ljava/lang/Object;)Landroid/graphics/drawable/Drawable;")
                                                    & 1) != 0)
                                                goto label_47d948
                                            
                                            x2_157 = var_258
                                        
                                        var_90 = x24_5
                                        x21 = (*(*arg1 + 0x3a0))(arg1, var_b8, x2_157, &var_90)
                                        result = (*(*arg1 + 0x720))(arg1)
                                        
                                        if ((result & 0xff) != 0)
                                            goto label_47d948
                                        
                                        if (x24_5 != 0)
                                            result = (*(*arg1 + 0xb8))(arg1, x24_5)
                                        
                                        if (x21 != 0)
                                            int64_t var_260
                                            int64_t x2_159 = var_260
                                            
                                            if (x2_159 == 0)
                                                if ((sub_45be5c(arg1, &var_a0, &var_260, 1, 
                                                        "androidx/loader/app/services/", 0x452a58, 
                                                        "()Landroid/graphics/PorterDuff$Mode;") & 1) != 0)
                                                    goto label_47d364
                                                
                                                x2_159 = var_260
                                            
                                            int64_t x0_660 =
                                                (*(*arg1 + 0x3a0))(arg1, var_a0, x2_159, &var_90)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                goto label_47d364
                                            
                                            if (x0_390 != 0)
                                                (*(*arg1 + 0xb8))(arg1, x0_390)
                                            
                                            int64_t var_268
                                            int64_t x2_162 = var_268
                                            
                                            if (x2_162 == 0)
                                                if ((sub_45be5c(arg1, &var_98, &var_268, 1, 
                                                        "androidx/loader/app/services/", 
                                                        &data_40c0a1, 
                                                        "(Ljava/lang/Object;ILjava/lang/Object;)V") & 1)
                                                        != 0)
                                                    goto label_47d364
                                                
                                                x2_162 = var_268
                                            
                                            var_90 = x21
                                            var_88_19.d = 0
                                            var_80_12.q = x0_660
                                            (*(*arg1 + 0x478))(arg1, var_98, x2_162, &var_90)
                                            result = (*(*arg1 + 0x720))(arg1)
                                            
                                            if ((result & 0xff) != 0)
                                                goto label_47d364

if (*(x28 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
