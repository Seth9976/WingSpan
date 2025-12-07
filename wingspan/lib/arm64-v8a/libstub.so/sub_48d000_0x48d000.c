// 函数: sub_48d000
// 地址: 0x48d000
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t var_100
__builtin_memset(&var_100, 0, 0x88)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result = 0
int64_t var_a8
int64_t var_80

if ((sub_45c03c(arg1, &var_80, &var_a8, 1, "com/unity3d/player/UnityPlayerActivity", 0x452119, 
        "Ljava/lang/String;") & 1) == 0)
    int64_t x22_1 = (*(*arg1 + 0x488))(arg1, var_80, var_a8)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
    labelid_3:
        result = 0
    else
        int64_t var_d0
        int64_t var_98
        int64_t var_78
        char* const x1_108
        char* const x2_66
        int64_t x21_1
        
        if (x22_1 == 0)
            int64_t var_88
            int64_t x1_10 = var_88
            
            if (x1_10 != 0)
                goto label_48d2a8
            
            if ((sub_45bc9c(arg1, &var_88, "java/lang/StringBuilder") & 1) != 0)
            labelid_3:
                result = 0
            else
                x1_10 = var_88
            label_48d2a8:
                int64_t x0_28 = (*(*arg1 + 0xd8))(arg1, x1_10)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                labelid_3:
                    result = 0
                else if (x0_28 == 0)
                label_48e5f4:
                    x1_108 = "java/lang/NullPointerException"
                    x2_66 = "NullPointerException"
                label_48e600:
                    sub_45bac8(arg1, x1_108, x2_66)
                labelid_3:
                    result = 0
                else
                    int64_t var_b0
                    int64_t x2_6 = var_b0
                    
                    if (x2_6 != 0)
                        goto label_48d31c
                    
                    if ((sub_45be5c(arg1, &var_88, &var_b0, 0, "java/lang/StringBuilder", "<init>", 
                        "()V") & 1) != 0)
                    labelid_3:
                        result = 0
                    else
                        x2_6 = var_b0
                    label_48d31c:
                        (*(*arg1 + 0x1f8))(arg1, x0_28, x2_6, &var_78)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        labelid_3:
                            result = 0
                        else
                            int64_t x0_37 = (*(*arg1 + 0x538))(arg1, "b")
                            int64_t var_b8
                            int64_t x2_8 = var_b8
                            
                            if (x2_8 != 0)
                                goto label_48d390
                            
                            if ((sub_45be5c(arg1, &var_88, &var_b8, 0, "java/lang/StringBuilder", 
                                "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;") & 1) != 0)
                            labelid_3:
                                result = 0
                            else
                                x2_8 = var_b8
                            label_48d390:
                                var_78 = x0_37
                                int64_t x0_41 = (*(*arg1 + 0x120))(arg1, x0_28, x2_8, &var_78)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                labelid_3:
                                    result = 0
                                else
                                    if (x0_41 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_41)
                                    
                                    if (x0_37 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_37)
                                    
                                    int64_t x0_47 = (*(*arg1 + 0x538))(arg1, "n")
                                    int64_t x2_10 = var_b8
                                    
                                    if (x2_10 != 0)
                                        goto label_48d450
                                    
                                    if ((sub_45be5c(arg1, &var_88, &var_b8, 0, 
                                        "java/lang/StringBuilder", "append", 
                                        "(Ljava/lang/String;)Ljava/lang/StringBuilder;") & 1) != 0)
                                    labelid_3:
                                        result = 0
                                    else
                                        x2_10 = var_b8
                                    label_48d450:
                                        var_78 = x0_47
                                        int64_t x0_51 =
                                            (*(*arg1 + 0x120))(arg1, x0_28, x2_10, &var_78)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        labelid_3:
                                            result = 0
                                        else
                                            if (x0_51 != 0)
                                                (*(*arg1 + 0xb8))(arg1, x0_51)
                                            
                                            if (x0_47 != 0)
                                                (*(*arg1 + 0xb8))(arg1, x0_47)
                                            
                                            int64_t x0_57 = (*(*arg1 + 0x538))(arg1, "B")
                                            int64_t x2_12 = var_b8
                                            
                                            if (x2_12 != 0)
                                                goto label_48d510
                                            
                                            if ((sub_45be5c(arg1, &var_88, &var_b8, 0, 
                                                "java/lang/StringBuilder", "append", 
                                                "(Ljava/lang/String;)Ljava/lang/StringBuilder;") & 1)
                                                != 0)
                                            labelid_3:
                                                result = 0
                                            else
                                                x2_12 = var_b8
                                            label_48d510:
                                                var_78 = x0_57
                                                int64_t x0_61 =
                                                    (*(*arg1 + 0x120))(arg1, x0_28, x2_12, &var_78)
                                                
                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                labelid_3:
                                                    result = 0
                                                else
                                                    if (x0_61 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x0_61)
                                                    
                                                    if (x0_57 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x0_57)
                                                    
                                                    int64_t x0_67 = (*(*arg1 + 0x538))(arg1, "t")
                                                    int64_t x2_14 = var_b8
                                                    
                                                    if (x2_14 != 0)
                                                        goto label_48d5d0
                                                    
                                                    if ((sub_45be5c(arg1, &var_88, &var_b8, 0, 
                                                        "java/lang/StringBuilder", "append", 
                                                        "(Ljava/lang/String;)Ljava/lang/StringBuilder;")
                                                        & 1) != 0)
                                                    labelid_3:
                                                        result = 0
                                                    else
                                                        x2_14 = var_b8
                                                    label_48d5d0:
                                                        var_78 = x0_67
                                                        int64_t x0_71 = (*(*arg1 + 0x120))(arg1, 
                                                            x0_28, x2_14, &var_78)
                                                        
                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                        labelid_3:
                                                            result = 0
                                                        else
                                                            if (x0_71 != 0)
                                                                (*(*arg1 + 0xb8))(arg1, x0_71)
                                                            
                                                            if (x0_67 != 0)
                                                                (*(*arg1 + 0xb8))(arg1, x0_67)
                                                            
                                                            int64_t x0_77 =
                                                                (*(*arg1 + 0x538))(arg1, &data_4519bc)
                                                            int64_t x2_16 = var_b8
                                                            
                                                            if (x2_16 != 0)
                                                                goto label_48d690
                                                            
                                                            if ((sub_45be5c(arg1, &var_88, &var_b8, 
                                                                0, "java/lang/StringBuilder", "append", 
                                                                "(Ljava/lang/String;"
                                                            ")Ljava/lang/StringBuilder;") & 1) != 0)
                                                            labelid_3:
                                                                result = 0
                                                            else
                                                                x2_16 = var_b8
                                                            label_48d690:
                                                                var_78 = x0_77
                                                                int64_t x0_81 = (*(*arg1 + 0x120))(
                                                                    arg1, x0_28, x2_16, &var_78)
                                                                
                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                labelid_3:
                                                                    result = 0
                                                                else
                                                                    if (x0_81 != 0)
                                                                        (*(*arg1 + 0xb8))(arg1, x0_81)
                                                                    
                                                                    if (x0_77 != 0)
                                                                        (*(*arg1 + 0xb8))(arg1, x0_77)
                                                                    
                                                                    int64_t x0_87 =
                                                                        (*(*arg1 + 0x538))(arg1, "W")
                                                                    int64_t x2_18 = var_b8
                                                                    
                                                                    if (x2_18 != 0)
                                                                        goto label_48d750
                                                                    
                                                                    if ((sub_45be5c(arg1, &var_88, &var_b8, 
                                                                        0, "java/lang/StringBuilder", "append", 
                                                                        "(Ljava/lang/String;"
                                                                    ")Ljava/lang/StringBuilder;") & 1) != 0)
                                                                    labelid_3:
                                                                        result = 0
                                                                    else
                                                                        x2_18 = var_b8
                                                                    label_48d750:
                                                                        var_78 = x0_87
                                                                        int64_t x0_91 = (*(*arg1 + 0x120))(
                                                                            arg1, x0_28, x2_18, &var_78)
                                                                        
                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                        labelid_3:
                                                                            result = 0
                                                                        else
                                                                            if (x0_91 != 0)
                                                                                (*(*arg1 + 0xb8))(arg1, x0_91)
                                                                            
                                                                            if (x0_87 != 0)
                                                                                (*(*arg1 + 0xb8))(arg1, x0_87)
                                                                            
                                                                            int64_t x0_97 =
                                                                                (*(*arg1 + 0x538))(arg1, "5")
                                                                            int64_t x2_20 = var_b8
                                                                            
                                                                            if (x2_20 != 0)
                                                                                goto label_48d810
                                                                            
                                                                            if ((sub_45be5c(arg1, &var_88, &var_b8, 
                                                                                0, "java/lang/StringBuilder", "append", 
                                                                                "(Ljava/lang/String;"
                                                                            ")Ljava/lang/StringBuilder;") & 1) != 0)
                                                                            labelid_3:
                                                                                result = 0
                                                                            else
                                                                                x2_20 = var_b8
                                                                            label_48d810:
                                                                                var_78 = x0_97
                                                                                int64_t x0_101 = (*(*arg1 + 0x120))(
                                                                                    arg1, x0_28, x2_20, &var_78)
                                                                                
                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                labelid_3:
                                                                                    result = 0
                                                                                else
                                                                                    if (x0_101 != 0)
                                                                                        (*(*arg1 + 0xb8))(arg1, x0_101)
                                                                                    
                                                                                    if (x0_97 != 0)
                                                                                        (*(*arg1 + 0xb8))(arg1, x0_97)
                                                                                    
                                                                                    int64_t x0_107 =
                                                                                        (*(*arg1 + 0x538))(arg1, &data_451b1d)
                                                                                    int64_t x2_22 = var_b8
                                                                                    
                                                                                    if (x2_22 != 0)
                                                                                        goto label_48d8d0
                                                                                    
                                                                                    if ((sub_45be5c(arg1, &var_88, &var_b8, 
                                                                                        0, "java/lang/StringBuilder", "append", 
                                                                                        "(Ljava/lang/String;"
                                                                                    ")Ljava/lang/StringBuilder;") & 1) != 0)
                                                                                    labelid_3:
                                                                                        result = 0
                                                                                    else
                                                                                        x2_22 = var_b8
                                                                                    label_48d8d0:
                                                                                        var_78 = x0_107
                                                                                        int64_t x0_111 = (*(*arg1 + 0x120))(
                                                                                            arg1, x0_28, x2_22, &var_78)
                                                                                        
                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                        labelid_3:
                                                                                            result = 0
                                                                                        else
                                                                                            if (x0_111 != 0)
                                                                                                (*(*arg1 + 0xb8))(arg1, x0_111)
                                                                                            
                                                                                            if (x0_107 != 0)
                                                                                                (*(*arg1 + 0xb8))(arg1, x0_107)
                                                                                            
                                                                                            int64_t x0_117 =
                                                                                                (*(*arg1 + 0x538))(arg1, "Z")
                                                                                            int64_t x2_24 = var_b8
                                                                                            
                                                                                            if (x2_24 != 0)
                                                                                                goto label_48d990
                                                                                            
                                                                                            if ((sub_45be5c(arg1, &var_88, &var_b8, 
                                                                                                0, "java/lang/StringBuilder", "append", 
                                                                                                "(Ljava/lang/String;"
                                                                                            ")Ljava/lang/StringBuilder;") & 1) != 0)
                                                                                            labelid_3:
                                                                                                result = 0
                                                                                            else
                                                                                                x2_24 = var_b8
                                                                                            label_48d990:
                                                                                                var_78 = x0_117
                                                                                                int64_t x0_121 = (*(*arg1 + 0x120))(
                                                                                                    arg1, x0_28, x2_24, &var_78)
                                                                                                
                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                labelid_3:
                                                                                                    result = 0
                                                                                                else
                                                                                                    if (x0_121 != 0)
                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_121)
                                                                                                    
                                                                                                    if (x0_117 != 0)
                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_117)
                                                                                                    
                                                                                                    int64_t x0_127 =
                                                                                                        (*(*arg1 + 0x538))(arg1, "2")
                                                                                                    int64_t x2_26 = var_b8
                                                                                                    
                                                                                                    if (x2_26 != 0)
                                                                                                        goto label_48da50
                                                                                                    
                                                                                                    if ((sub_45be5c(arg1, &var_88, &var_b8, 
                                                                                                        0, "java/lang/StringBuilder", "append", 
                                                                                                        "(Ljava/lang/String;"
                                                                                                    ")Ljava/lang/StringBuilder;") & 1) != 0)
                                                                                                    labelid_3:
                                                                                                        result = 0
                                                                                                    else
                                                                                                        x2_26 = var_b8
                                                                                                    label_48da50:
                                                                                                        var_78 = x0_127
                                                                                                        int64_t x0_131 = (*(*arg1 + 0x120))(
                                                                                                            arg1, x0_28, x2_26, &var_78)
                                                                                                        
                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                        labelid_3:
                                                                                                            result = 0
                                                                                                        else
                                                                                                            if (x0_131 != 0)
                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_131)
                                                                                                            
                                                                                                            if (x0_127 != 0)
                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_127)
                                                                                                            
                                                                                                            int64_t x0_137 =
                                                                                                                (*(*arg1 + 0x538))(arg1, "V")
                                                                                                            int64_t x2_28 = var_b8
                                                                                                            
                                                                                                            if (x2_28 != 0)
                                                                                                                goto label_48db10
                                                                                                            
                                                                                                            if ((sub_45be5c(arg1, &var_88, &var_b8, 
                                                                                                                0, "java/lang/StringBuilder", "append", 
                                                                                                                "(Ljava/lang/String;"
                                                                                                            ")Ljava/lang/StringBuilder;") & 1) != 0)
                                                                                                            labelid_3:
                                                                                                                result = 0
                                                                                                            else
                                                                                                                x2_28 = var_b8
                                                                                                            label_48db10:
                                                                                                                var_78 = x0_137
                                                                                                                int64_t x0_141 = (*(*arg1 + 0x120))(
                                                                                                                    arg1, x0_28, x2_28, &var_78)
                                                                                                                
                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                labelid_3:
                                                                                                                    result = 0
                                                                                                                else
                                                                                                                    if (x0_141 != 0)
                                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_141)
                                                                                                                    
                                                                                                                    if (x0_137 != 0)
                                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_137)
                                                                                                                    
                                                                                                                    int64_t x0_147 =
                                                                                                                        (*(*arg1 + 0x538))(arg1, "y")
                                                                                                                    int64_t x2_30 = var_b8
                                                                                                                    
                                                                                                                    if (x2_30 != 0)
                                                                                                                        goto label_48dbd0
                                                                                                                    
                                                                                                                    if ((sub_45be5c(arg1, &var_88, &var_b8, 
                                                                                                                        0, "java/lang/StringBuilder", "append", 
                                                                                                                        "(Ljava/lang/String;"
                                                                                                                    ")Ljava/lang/StringBuilder;") & 1) != 0)
                                                                                                                    labelid_3:
                                                                                                                        result = 0
                                                                                                                    else
                                                                                                                        x2_30 = var_b8
                                                                                                                    label_48dbd0:
                                                                                                                        var_78 = x0_147
                                                                                                                        int64_t x0_151 = (*(*arg1 + 0x120))(
                                                                                                                            arg1, x0_28, x2_30, &var_78)
                                                                                                                        
                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                        labelid_3:
                                                                                                                            result = 0
                                                                                                                        else
                                                                                                                            if (x0_151 != 0)
                                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_151)
                                                                                                                            
                                                                                                                            int64_t var_c0
                                                                                                                            int64_t x2_33 = var_c0
                                                                                                                            
                                                                                                                            if (x2_33 != 0)
                                                                                                                                goto label_48dc70
                                                                                                                            
                                                                                                                            if ((sub_45be5c(arg1, &var_88, &var_c0, 
                                                                                                                                0, "java/lang/StringBuilder", 
                                                                                                                                "toString", "()Ljava/lang/String;") & 1)
                                                                                                                                != 0)
                                                                                                                            labelid_3:
                                                                                                                                result = 0
                                                                                                                            else
                                                                                                                                x2_33 = var_c0
                                                                                                                            label_48dc70:
                                                                                                                                int64_t x0_158 = (*(*arg1 + 0x120))(
                                                                                                                                    arg1, x0_28, x2_33, &var_78)
                                                                                                                                
                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                labelid_3:
                                                                                                                                    result = 0
                                                                                                                                else
                                                                                                                                    (*(*arg1 + 0xb8))(arg1, x0_28)
                                                                                                                                    int64_t var_c8
                                                                                                                                    int64_t x2_34 = var_c8
                                                                                                                                    
                                                                                                                                    if (x2_34 != 0)
                                                                                                                                        goto label_48dce0
                                                                                                                                    
                                                                                                                                    int64_t var_90
                                                                                                                                    
                                                                                                                                    if ((sub_45be5c(arg1, &var_90, &var_c8, 
                                                                                                                                        1, "android/util/Base64", "decode", 
                                                                                                                                        "(Ljava/lang/String;I)[B") & 1) != 0)
                                                                                                                                    labelid_3:
                                                                                                                                        result = 0
                                                                                                                                    else
                                                                                                                                        x2_34 = var_c8
                                                                                                                                    label_48dce0:
                                                                                                                                        var_78 = x0_158
                                                                                                                                        int32_t var_70_1 = 0
                                                                                                                                        x22_1 = (*(*arg1 + 0x3a0))(arg1, 
                                                                                                                                            var_90, x2_34, &var_78)
                                                                                                                                        
                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                        labelid_3:
                                                                                                                                            result = 0
                                                                                                                                        else
                                                                                                                                            if (x0_158 != 0)
                                                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_158)
                                                                                                                                            
                                                                                                                                            if (x0_147 != 0)
                                                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_147)
                                                                                                                                            
                                                                                                                                            int64_t x1_69 = var_98
                                                                                                                                            
                                                                                                                                            if (x1_69 != 0)
                                                                                                                                                goto label_48dd84
                                                                                                                                            
                                                                                                                                            if ((sub_45bc9c(arg1, &var_98, 
                                                                                                                                                "java/lang/String") & 1) != 0)
                                                                                                                                            labelid_3:
                                                                                                                                                result = 0
                                                                                                                                            else
                                                                                                                                                x1_69 = var_98
                                                                                                                                            label_48dd84:
                                                                                                                                                x21_1 = (*(*arg1 + 0xd8))(arg1, x1_69)
                                                                                                                                                
                                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                labelid_3:
                                                                                                                                                    result = 0
                                                                                                                                                else
                                                                                                                                                    if (x21_1 == 0)
                                                                                                                                                        goto label_48e5f4
                                                                                                                                                    
                                                                                                                                                    int64_t x2_36 = var_d0
                                                                                                                                                    
                                                                                                                                                    if (x2_36 != 0)
                                                                                                                                                        goto label_48dddc
                                                                                                                                                    
                                                                                                                                                    if ((sub_45be5c(arg1, &var_98, &var_d0, 
                                                                                                                                                        0, "java/lang/String", "<init>", 
                                                                                                                                                        "([B)V") & 1) != 0)
                                                                                                                                                    labelid_3:
                                                                                                                                                        result = 0
                                                                                                                                                    else
                                                                                                                                                        x2_36 = var_d0
                                                                                                                                                    label_48dddc:
                                                                                                                                                        var_78 = x22_1
                                                                                                                                                        (*(*arg1 + 0x1f8))(arg1, x21_1, x2_36, 
                                                                                                                                                            &var_78)
                                                                                                                                                        
                                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                        labelid_3:
                                                                                                                                                            result = 0
                                                                                                                                                        else
                                                                                                                                                            int64_t x2_38 = var_a8
                                                                                                                                                            
                                                                                                                                                            if (x2_38 != 0)
                                                                                                                                                                goto label_48de60
                                                                                                                                                            
                                                                                                                                                            if ((sub_45c03c(arg1, &var_80, &var_a8, 
                                                                                                                                                                1, 
                                                                                                                                                                "com/unity3d/player/UnityPlayerActivity", 
                                                                                                                                                                0x452119, "Ljava/lang/String;") & 1)
                                                                                                                                                                != 0)
                                                                                                                                                            labelid_3:
                                                                                                                                                                result = 0
                                                                                                                                                            else
                                                                                                                                                                x2_38 = var_a8
                                                                                                                                                            label_48de60:
                                                                                                                                                                (*(*arg1 + 0x4d0))(arg1, var_80, x2_38, 
                                                                                                                                                                    x21_1)
                                                                                                                                                                
                                                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                                                                                    if (x22_1 != 0)
                                                                                                                                                                        goto label_48d120
                                                                                                                                                                    
                                                                                                                                                                    goto label_48d124
                                                                                                                                                                
                                                                                                                                                            labelid_3:
                                                                                                                                                                result = 0
        else
            x21_1 = 0
        label_48d120:
            (*(*arg1 + 0xb8))(arg1, x22_1)
        label_48d124:
            int64_t var_a0
            int64_t x1_5 = var_a0
            
            if (x1_5 != 0)
                goto label_48d154
            
            if ((sub_45bc9c(arg1, &var_a0, "java/io/ByteArrayOutputStream") & 1) != 0)
            labelid_3:
                result = 0
            else
                x1_5 = var_a0
            label_48d154:
                int64_t x0_11 = (*(*arg1 + 0xd8))(arg1, x1_5)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                labelid_3:
                    result = 0
                else
                    if (x0 == 0)
                        goto label_48e5f4
                    
                    int64_t var_d8
                    int64_t x2_2 = var_d8
                    
                    if (x2_2 != 0)
                        goto label_48d1c8
                    
                    if ((sub_45be5c(arg1, &var_98, &var_d8, 0, "java/lang/String", "length", 
                        0x452601) & 1) != 0)
                    labelid_3:
                        result = 0
                    else
                        x2_2 = var_d8
                    label_48d1c8:
                        int32_t x0_17 = (*(*arg1 + 0x198))(arg1, x0, x2_2, &var_78)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        labelid_3:
                            result = 0
                        else
                            int32_t x23_2
                            
                            if (x0_17 s< 0)
                                x23_2 = x0_17 + 1
                            else
                                x23_2 = x0_17
                            
                            if (x0_11 == 0)
                                goto label_48e5f4
                            
                            int64_t var_e0
                            int64_t x2_4 = var_e0
                            
                            if (x2_4 != 0)
                                goto label_48d234
                            
                            if ((sub_45be5c(arg1, &var_a0, &var_e0, 0, 
                                "java/io/ByteArrayOutputStream", "<init>", "(I)V") & 1) != 0)
                            label_48d0d4:
                                result = 0
                            else
                                x2_4 = var_e0
                            label_48d234:
                                var_78.d = x23_2 s>> 1
                                (*(*arg1 + 0x1f8))(arg1, x0_11, x2_4, &var_78)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                label_48d0d4_1:
                                    result = 0
                                else
                                    int64_t x23_3 = 0
                                    int64_t x26_1 = 0
                                    int32_t x27_1 = 0
                                    bool cond:0_1
                                    
                                    do
                                        int64_t x2_42 = var_d8
                                        
                                        if (x2_42 == 0)
                                            if ((sub_45be5c(arg1, &var_98, &var_d8, 0, 
                                                    "java/lang/String", "length", 0x452601) & 1) != 0)
                                                goto label_48d0d4_1
                                            
                                            x2_42 = var_d8
                                        
                                        int32_t x0_192 =
                                            (*(*arg1 + 0x198))(arg1, x0, x2_42, &var_78)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            goto label_48d0d4_1
                                        
                                        int64_t var_e8
                                        
                                        if (x27_1 s>= x0_192)
                                            int64_t x2_52 = var_100
                                            
                                            if (x2_52 == 0)
                                                if ((sub_45be5c(arg1, &var_a0, &var_100, 0, 
                                                        "java/io/ByteArrayOutputStream", 
                                                        "toByteArray", "()[B") & 1) != 0)
                                                    goto label_48d0d4_1
                                                
                                                x2_52 = var_100
                                            
                                            int64_t x0_230 =
                                                (*(*arg1 + 0x120))(arg1, x0_11, x2_52, &var_78)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                goto label_48d0d4_1
                                            
                                            if (x0_230 == 0)
                                                goto label_48e5f4
                                            
                                            int32_t x0_234 = (*(*arg1 + 0x558))(arg1, x0_230)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                goto label_48d0d4_1
                                            
                                            if (x23_3 != 0)
                                                (*(*arg1 + 0xb8))(arg1, x23_3)
                                            
                                            int64_t x2_55 = var_a8
                                            
                                            if (x2_55 == 0)
                                                if ((sub_45c03c(arg1, &var_80, &var_a8, 1, 
                                                        "com/unity3d/player/UnityPlayerActivity", 
                                                        0x452119, "Ljava/lang/String;") & 1) != 0)
                                                    goto label_48d0d4_1
                                                
                                                x2_55 = var_a8
                                            
                                            int64_t x0_241 = (*(*arg1 + 0x488))(arg1, var_80, x2_55)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                goto label_48d0d4_1
                                            
                                            if (x0_241 == 0)
                                                goto label_48e5f4
                                            
                                            int64_t x2_56 = var_d8
                                            
                                            if (x2_56 == 0)
                                                if ((sub_45be5c(arg1, &var_98, &var_d8, 0, 
                                                        "java/lang/String", "length", 0x452601) & 1) != 0)
                                                    goto label_48d0d4_1
                                                
                                                x2_56 = var_d8
                                            
                                            int32_t x0_247 =
                                                (*(*arg1 + 0x198))(arg1, x0_241, x2_56, &var_78)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                goto label_48d0d4_1
                                            
                                            if (x0_234 s>= 1)
                                                int32_t x26_2 = 0
                                                int64_t x28_3 = 0
                                                
                                                do
                                                    (*(*arg1 + 0x640))(arg1, x0_230, zx.q(x26_2), 
                                                        1, &var_78)
                                                    char x27_3 = var_78.b
                                                    
                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                        goto label_48d0d4_1
                                                    
                                                    if (x28_3 != 0)
                                                        (*(*arg1 + 0xb8))(arg1, x28_3)
                                                    
                                                    int64_t x2_60 = var_a8
                                                    
                                                    if (x2_60 == 0)
                                                        if ((sub_45c03c(arg1, &var_80, &var_a8, 1, 
                                                                "com/unity3d/player/UnityPlayerActivity", 
                                                                0x452119, "Ljava/lang/String;") & 1) != 0)
                                                            goto label_48d0d4_1
                                                        
                                                        x2_60 = var_a8
                                                    
                                                    x28_3 = (*(*arg1 + 0x488))(arg1, var_80, x2_60)
                                                    
                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                        goto label_48d0d4_1
                                                    
                                                    if (x0_247 == 0)
                                                        x1_108 = "java/lang/ArithmeticException"
                                                        x2_66 = "divide by zero"
                                                        goto label_48e600
                                                    
                                                    if (x28_3 == 0)
                                                        goto label_48e5f4
                                                    
                                                    int64_t x2_61 = var_e8
                                                    
                                                    if (x2_61 == 0)
                                                        if ((sub_45be5c(arg1, &var_98, &var_e8, 0, 
                                                                "java/lang/String", "charAt", "(I)C") & 1)
                                                                != 0)
                                                            goto label_48d0d4_1
                                                        
                                                        x2_61 = var_e8
                                                    
                                                    var_78.d = x26_2 s% x0_247
                                                    char x0_263 = (*(*arg1 + 0x168))(arg1, x28_3, 
                                                        x2_61, &var_78)
                                                    
                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                        goto label_48d0d4_1
                                                    
                                                    var_78.b = x27_3 ^ x0_263
                                                    (*(*arg1 + 0x680))(arg1, x0_230, zx.q(x26_2), 
                                                        1, &var_78)
                                                    
                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                        goto label_48d0d4_1
                                                    
                                                    x26_2 += 1
                                                while (x0_234 != x26_2)
                                            
                                            if (x21_1 != 0)
                                                (*(*arg1 + 0xb8))(arg1, x21_1)
                                            
                                            int64_t x1_105 = var_98
                                            
                                            if (x1_105 == 0)
                                                if ((sub_45bc9c(arg1, &var_98, "java/lang/String")
                                                        & 1) != 0)
                                                    goto label_48d0d4_1
                                                
                                                x1_105 = var_98
                                            
                                            int64_t result_1 = (*(*arg1 + 0xd8))(arg1, x1_105)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                goto label_48d0d4_1
                                            
                                            if (result_1 == 0)
                                                goto label_48e5f4
                                            
                                            int64_t x2_64 = var_d0
                                            
                                            if (x2_64 == 0)
                                                if ((sub_45be5c(arg1, &var_98, &var_d0, 0, 
                                                        "java/lang/String", "<init>", "([B)V") & 1) != 0)
                                                    goto label_48d0d4_1
                                                
                                                x2_64 = var_d0
                                            
                                            var_78 = x0_230
                                            (*(*arg1 + 0x1f8))(arg1, result_1, x2_64, &var_78)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                result = result_1
                                            else
                                                result = 0
                                            
                                            break
                                        
                                        if (x26_1 != 0)
                                            (*(*arg1 + 0xb8))(arg1, x26_1)
                                        
                                        int64_t x0_197 =
                                            (*(*arg1 + 0x538))(arg1, "0123456789ABCDEF")
                                        int64_t x2_43 = var_e8
                                        x26_1 = x0_197
                                        
                                        if (x2_43 == 0)
                                            if ((sub_45be5c(arg1, &var_98, &var_e8, 0, 
                                                    "java/lang/String", "charAt", "(I)C") & 1) != 0)
                                                goto label_48d0d4_1
                                            
                                            x2_43 = var_e8
                                        
                                        var_78.d = x27_1
                                        int16_t x0_201 =
                                            (*(*arg1 + 0x168))(arg1, x0, x2_43, &var_78)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            goto label_48d0d4_1
                                        
                                        if (x26_1 == 0)
                                            goto label_48e5f4
                                        
                                        int64_t var_f0
                                        int64_t x2_45 = var_f0
                                        
                                        if (x2_45 == 0)
                                            if ((sub_45be5c(arg1, &var_98, &var_f0, 0, 
                                                    "java/lang/String", "indexOf", "(I)I") & 1) != 0)
                                                goto label_48d0d4_1
                                            
                                            x2_45 = var_f0
                                        
                                        var_78.d = zx.d(x0_201)
                                        int32_t x0_207 =
                                            (*(*arg1 + 0x198))(arg1, x26_1, x2_45, &var_78)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            goto label_48d0d4_1
                                        
                                        if (x23_3 != 0)
                                            (*(*arg1 + 0xb8))(arg1, x23_3)
                                        
                                        int64_t x0_212 =
                                            (*(*arg1 + 0x538))(arg1, "0123456789ABCDEF")
                                        int64_t x2_47 = var_e8
                                        x23_3 = x0_212
                                        
                                        if (x2_47 == 0)
                                            if ((sub_45be5c(arg1, &var_98, &var_e8, 0, 
                                                    "java/lang/String", "charAt", "(I)C") & 1) != 0)
                                                goto label_48d0d4_1
                                            
                                            x2_47 = var_e8
                                        
                                        var_78.d = x27_1 + 1
                                        int16_t x0_216 =
                                            (*(*arg1 + 0x168))(arg1, x0, x2_47, &var_78)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            goto label_48d0d4_1
                                        
                                        if (x23_3 == 0)
                                            goto label_48e5f4
                                        
                                        int64_t x2_49 = var_f0
                                        
                                        if (x2_49 == 0)
                                            if ((sub_45be5c(arg1, &var_98, &var_f0, 0, 
                                                    "java/lang/String", "indexOf", "(I)I") & 1) != 0)
                                                goto label_48d0d4_1
                                            
                                            x2_49 = var_f0
                                        
                                        var_78.d = zx.d(x0_216)
                                        int32_t x0_222 =
                                            (*(*arg1 + 0x198))(arg1, x23_3, x2_49, &var_78)
                                        
                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                            goto label_48d0d4_1
                                        
                                        int64_t var_f8
                                        int64_t x2_40 = var_f8
                                        
                                        if (x2_40 == 0)
                                            if ((sub_45be5c(arg1, &var_a0, &var_f8, 0, 
                                                    "java/io/ByteArrayOutputStream", "write", 
                                                    "(I)V") & 1) != 0)
                                                goto label_48d0d4_1
                                            
                                            x2_40 = var_f8
                                        
                                        var_78.d = x0_222 | x0_207 << 4
                                        (*(*arg1 + 0x1f8))(arg1, x0_11, x2_40, &var_78)
                                        result = 0
                                        cond:0_1 = zx.d((*(*arg1 + 0x720))(arg1)) != 0
                                        x27_1 += 2
                                    while (not(cond:0_1))

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
