// 函数: sub_45cf3c
// 地址: 0x45cf3c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

double v8
double var_68 = v8
uint64_t x8 = _ReadMSR(tpidr_el0)
int64_t x8_1 = *(x8 + 0x28)
int64_t var_118
__builtin_memset(&var_118, 0, 0x90)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x22 = (*(*arg1 + 0x538))(arg1, &data_452188)
int64_t x20 = (*(*arg1 + 0x538))(arg1, &data_452188)
int32_t x25 = 0
int64_t x21 = 0
int64_t result

while (true)
    if (x21 != 0)
        (*(*arg1 + 0xb8))(arg1, x21)
    
    int64_t var_a0
    int64_t x1_3 = var_a0
    
    if (x1_3 != 0)
        goto label_45d04c
    
    if ((sub_45bc9c(arg1, &var_a0, "java/lang/StringBuffer") & 1) == 0)
        x1_3 = var_a0
    label_45d04c:
        int64_t x0_9 = (*(*arg1 + 0xd8))(arg1, x1_3)
        
        if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
            char* const x1_68
            char* const x2_48
            
            if (x0_9 == 0)
            label_45dd94:
                x1_68 = "java/lang/NullPointerException"
                x2_48 = "NullPointerException"
            label_45dda0:
                sub_45bac8(arg1, x1_68, x2_48)
            else
                int64_t var_d8
                int64_t x2 = var_d8
                
                if (x2 != 0)
                    goto label_45d0bc
                
                if ((sub_45be5c(arg1, &var_a0, &var_d8, 0, "java/lang/StringBuffer", "<init>", 
                        "()V") & 1) == 0)
                    x2 = var_d8
                label_45d0bc:
                    int64_t var_88
                    (*(*arg1 + 0x1f8))(arg1, x0_9, x2, &var_88)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                        int64_t var_e0
                        int64_t x2_2 = var_e0
                        
                        if (x2_2 != 0)
                            goto label_45d108
                        
                        if ((sub_45be5c(arg1, &var_a0, &var_e0, 0, "java/lang/StringBuffer", 
                                "append", "(Ljava/lang/String;)Ljava/lang/StringBuffer;") & 1) == 0)
                            x2_2 = var_e0
                        label_45d108:
                            var_88 = x22
                            int64_t x0_20 = (*(*arg1 + 0x120))(arg1, x0_9, x2_2, &var_88)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                if (x22 != 0)
                                    (*(*arg1 + 0xb8))(arg1, x22)
                                
                                int64_t var_e8
                                int64_t x2_5 = var_e8
                                
                                if (x2_5 != 0)
                                    goto label_45d194
                                
                                int64_t var_a8
                                
                                if ((sub_45be5c(arg1, &var_a8, &var_e8, 1, "java/lang/Integer", 
                                        "toHexString", "(I)Ljava/lang/String;") & 1) == 0)
                                    x2_5 = var_e8
                                label_45d194:
                                    var_88.d = x25
                                    int64_t x0_27 = (*(*arg1 + 0x3a0))(arg1, var_a8, x2_5, &var_88)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                        (*(*arg1 + 0xb8))(arg1, x0_9)
                                        
                                        if (x0_20 == 0)
                                            goto label_45dd94
                                        
                                        int64_t x2_6 = var_e0
                                        
                                        if (x2_6 != 0)
                                            goto label_45d214
                                        
                                        if ((sub_45be5c(arg1, &var_a0, &var_e0, 0, 
                                                "java/lang/StringBuffer", "append", 
                                                "(Ljava/lang/String;)Ljava/lang/StringBuffer;") & 1) == 0)
                                            x2_6 = var_e0
                                        label_45d214:
                                            var_88 = x0_27
                                            int64_t x0_34 =
                                                (*(*arg1 + 0x120))(arg1, x0_20, x2_6, &var_88)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                (*(*arg1 + 0xb8))(arg1, x0_20)
                                                
                                                if (x0_34 == 0)
                                                    goto label_45dd94
                                                
                                                int64_t var_f0
                                                int64_t x2_8 = var_f0
                                                
                                                if (x2_8 != 0)
                                                    goto label_45d2b8
                                                
                                                if ((sub_45be5c(arg1, &var_a0, &var_f0, 0, 
                                                        "java/lang/StringBuffer", "toString", 
                                                        "()Ljava/lang/String;") & 1) == 0)
                                                    x2_8 = var_f0
                                                label_45d2b8:
                                                    x22 = (*(*arg1 + 0x120))(arg1, x0_34, x2_8, 
                                                        &var_88)
                                                    
                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                        (*(*arg1 + 0xb8))(arg1, x0_34)
                                                        
                                                        if (x0_27 != 0)
                                                            (*(*arg1 + 0xb8))(arg1, x0_27)
                                                        
                                                        int64_t x1_20 = var_a0
                                                        
                                                        if (x1_20 != 0)
                                                            goto label_45d330
                                                        
                                                        if ((sub_45bc9c(arg1, &var_a0, 
                                                                "java/lang/StringBuffer") & 1) == 0)
                                                            x1_20 = var_a0
                                                        label_45d330:
                                                            x21 = (*(*arg1 + 0xd8))(arg1, x1_20)
                                                            
                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                if (x21 == 0)
                                                                    goto label_45dd94
                                                                
                                                                int64_t x2_10 = var_d8
                                                                
                                                                if (x2_10 != 0)
                                                                    goto label_45d398
                                                                
                                                                if ((sub_45be5c(arg1, &var_a0, &var_d8, 
                                                                        0, "java/lang/StringBuffer", "<init>", 
                                                                        "()V") & 1) == 0)
                                                                    x2_10 = var_d8
                                                                label_45d398:
                                                                    (*(*arg1 + 0x1f8))(arg1, x21, x2_10, 
                                                                        &var_88)
                                                                    
                                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                        int64_t x2_12 = var_e0
                                                                        
                                                                        if (x2_12 != 0)
                                                                            goto label_45d3e4
                                                                        
                                                                        if ((sub_45be5c(arg1, &var_a0, &var_e0, 
                                                                                0, "java/lang/StringBuffer", "append", 
                                                                                "(Ljava/lang/String;"
                                                                        ")Ljava/lang/StringBuffer;") & 1) == 0)
                                                                            x2_12 = var_e0
                                                                        label_45d3e4:
                                                                            var_88 = x20
                                                                            int64_t x0_60 = (*(*arg1 + 0x120))(
                                                                                arg1, x21, x2_12, &var_88)
                                                                            
                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                if (x20 != 0)
                                                                                    (*(*arg1 + 0xb8))(arg1, x20)
                                                                                
                                                                                int64_t var_f8
                                                                                int64_t x2_15 = var_f8
                                                                                
                                                                                if (x2_15 != 0)
                                                                                    goto label_45d484
                                                                                
                                                                                int64_t var_b0
                                                                                
                                                                                if ((sub_45be5c(arg1, &var_b0, &var_f8, 
                                                                                        1, "java/lang/Math", "random", "()D")
                                                                                        & 1) == 0)
                                                                                    x2_15 = var_f8
                                                                                label_45d484:
                                                                                    double v0_1 = (*(*arg1 + 0x460))(arg1, 
                                                                                        var_b0, x2_15, &var_88)
                                                                                    
                                                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                        int32_t x0_69 =
                                                                                            sub_45bb3c(v0_1 * fconvert.d(10.0))
                                                                                        
                                                                                        if (x0_60 == 0)
                                                                                            goto label_45dd94
                                                                                        
                                                                                        int64_t var_100
                                                                                        int64_t x2_16 = var_100
                                                                                        
                                                                                        if (x2_16 != 0)
                                                                                            goto label_45d4ec
                                                                                        
                                                                                        if ((sub_45be5c(arg1, &var_a0, 
                                                                                                &var_100, 0, "java/lang/StringBuffer", 
                                                                                                "append", "(I)Ljava/lang/StringBuffer;")
                                                                                                & 1) == 0)
                                                                                            x2_16 = var_100
                                                                                        label_45d4ec:
                                                                                            var_88.d = x0_69 ^ x25
                                                                                            int64_t x0_73 = (*(*arg1 + 0x120))(
                                                                                                arg1, x0_60, x2_16, &var_88)
                                                                                            
                                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                (*(*arg1 + 0xb8))(arg1, x0_60)
                                                                                                
                                                                                                if (x0_73 == 0)
                                                                                                    goto label_45dd94
                                                                                                
                                                                                                int64_t x2_18 = var_f0
                                                                                                
                                                                                                if (x2_18 != 0)
                                                                                                    goto label_45d590
                                                                                                
                                                                                                if ((sub_45be5c(arg1, &var_a0, &var_f0, 
                                                                                                        0, "java/lang/StringBuffer", 
                                                                                                        "toString", "()Ljava/lang/String;") & 1)
                                                                                                        == 0)
                                                                                                    x2_18 = var_f0
                                                                                                label_45d590:
                                                                                                    x20 = (*(*arg1 + 0x120))(arg1, x0_73, 
                                                                                                        x2_18, &var_88)
                                                                                                    
                                                                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_73)
                                                                                                        x25 += 1
                                                                                                        
                                                                                                        if (x25 != 0xf)
                                                                                                            continue
                                                                                                        else
                                                                                                            if (x22 == 0)
                                                                                                                goto label_45dd94
                                                                                                            
                                                                                                            int64_t var_b8
                                                                                                            int64_t var_90
                                                                                                            int32_t i
                                                                                                            
                                                                                                            do
                                                                                                                int64_t x2_21 = var_b8
                                                                                                                
                                                                                                                if (x2_21 == 0)
                                                                                                                    if ((sub_45be5c(arg1, &var_90, &var_b8, 
                                                                                                                            0, "java/lang/String", "length", 
                                                                                                                            0x452601) & 1) != 0)
                                                                                                                        goto label_45dda4
                                                                                                                    
                                                                                                                    x2_21 = var_b8
                                                                                                                
                                                                                                                i = (*(*arg1 + 0x198))(arg1, x22, 
                                                                                                                    x2_21, &var_88)
                                                                                                                
                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                    goto label_45dda4
                                                                                                            while (i s> 0)
                                                                                                            (*(*arg1 + 0xb8))(arg1, x21)
                                                                                                            int64_t var_98
                                                                                                            int64_t x1_37 = var_98
                                                                                                            
                                                                                                            if (x1_37 != 0)
                                                                                                                goto label_45d694
                                                                                                            
                                                                                                            if ((sub_45bc9c(arg1, &var_98, 
                                                                                                                    "java/io/ByteArrayOutputStream") & 1)
                                                                                                                    == 0)
                                                                                                                x1_37 = var_98
                                                                                                            label_45d694:
                                                                                                                int64_t x0_93 =
                                                                                                                    (*(*arg1 + 0xd8))(arg1, x1_37)
                                                                                                                
                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                                    int64_t x1_39 = x0
                                                                                                                    
                                                                                                                    if (x1_39 == 0)
                                                                                                                        goto label_45dd94
                                                                                                                    
                                                                                                                    int64_t x2_22 = var_b8
                                                                                                                    
                                                                                                                    if (x2_22 != 0)
                                                                                                                        goto label_45d70c
                                                                                                                    
                                                                                                                    if ((sub_45be5c(arg1, &var_90, &var_b8, 
                                                                                                                            0, "java/lang/String", "length", 
                                                                                                                            0x452601) & 1) == 0)
                                                                                                                        x2_22 = var_b8
                                                                                                                        x1_39 = x0
                                                                                                                    label_45d70c:
                                                                                                                        int32_t x0_99 = (*(*arg1 + 0x198))(
                                                                                                                            arg1, x1_39, x2_22, &var_88)
                                                                                                                        
                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                                            int32_t x23_2
                                                                                                                            
                                                                                                                            if (x0_99 s< 0)
                                                                                                                                x23_2 = x0_99 + 1
                                                                                                                            else
                                                                                                                                x23_2 = x0_99
                                                                                                                            
                                                                                                                            if (x0_93 == 0)
                                                                                                                                goto label_45dd94
                                                                                                                            
                                                                                                                            int64_t var_c0
                                                                                                                            int64_t x2_24 = var_c0
                                                                                                                            
                                                                                                                            if (x2_24 != 0)
                                                                                                                                goto label_45d778
                                                                                                                            
                                                                                                                            if ((sub_45be5c(arg1, &var_98, &var_c0, 
                                                                                                                                    0, "java/io/ByteArrayOutputStream", 
                                                                                                                                    "<init>", "(I)V") & 1) == 0)
                                                                                                                                x2_24 = var_c0
                                                                                                                            label_45d778:
                                                                                                                                var_88.d = x23_2 s>> 1
                                                                                                                                (*(*arg1 + 0x1f8))(arg1, x0_93, x2_24, 
                                                                                                                                    &var_88)
                                                                                                                                
                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                                                    int32_t x28_3 = 0
                                                                                                                                    bool cond:0_1
                                                                                                                                    
                                                                                                                                    do
                                                                                                                                        int64_t x2_28 = var_b8
                                                                                                                                        int64_t x1_44 = x0
                                                                                                                                        
                                                                                                                                        if (x2_28 == 0)
                                                                                                                                            if ((sub_45be5c(arg1, &var_90, &var_b8, 
                                                                                                                                                    0, "java/lang/String", "length", 
                                                                                                                                                    0x452601) & 1) != 0)
                                                                                                                                                goto label_45dda4
                                                                                                                                            
                                                                                                                                            x2_28 = var_b8
                                                                                                                                            x1_44 = x0
                                                                                                                                        
                                                                                                                                        int32_t x0_113 = (*(*arg1 + 0x198))(
                                                                                                                                            arg1, x1_44, x2_28, &var_88)
                                                                                                                                        
                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                            goto label_45dda4
                                                                                                                                        
                                                                                                                                        int64_t var_108
                                                                                                                                        
                                                                                                                                        if (x28_3 s>= x0_113)
                                                                                                                                            int64_t var_c8
                                                                                                                                            int64_t x2_38 = var_c8
                                                                                                                                            
                                                                                                                                            if (x2_38 == 0)
                                                                                                                                                if ((sub_45be5c(arg1, &var_98, &var_c8, 
                                                                                                                                                        0, "java/io/ByteArrayOutputStream", 
                                                                                                                                                        "toByteArray", "()[B") & 1) != 0)
                                                                                                                                                    goto label_45dda4
                                                                                                                                                
                                                                                                                                                x2_38 = var_c8
                                                                                                                                            
                                                                                                                                            int64_t x0_145 = (*(*arg1 + 0x120))(
                                                                                                                                                arg1, x0_93, x2_38, &var_88)
                                                                                                                                            
                                                                                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                goto label_45dda4
                                                                                                                                            
                                                                                                                                            if (x0_145 == 0)
                                                                                                                                                goto label_45dd94
                                                                                                                                            
                                                                                                                                            int32_t x0_149 =
                                                                                                                                                (*(*arg1 + 0x558))(arg1, x0_145)
                                                                                                                                            
                                                                                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                goto label_45dda4
                                                                                                                                            
                                                                                                                                            if (x20 == 0)
                                                                                                                                                goto label_45dd94
                                                                                                                                            
                                                                                                                                            int64_t x2_40 = var_b8
                                                                                                                                            
                                                                                                                                            if (x2_40 == 0)
                                                                                                                                                if ((sub_45be5c(arg1, &var_90, &var_b8, 
                                                                                                                                                        0, "java/lang/String", "length", 
                                                                                                                                                        0x452601) & 1) != 0)
                                                                                                                                                    goto label_45dda4
                                                                                                                                                
                                                                                                                                                x2_40 = var_b8
                                                                                                                                            
                                                                                                                                            int32_t x0_155 = (*(*arg1 + 0x198))(
                                                                                                                                                arg1, x20, x2_40, &var_88)
                                                                                                                                            
                                                                                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                goto label_45dda4
                                                                                                                                            
                                                                                                                                            if (x0_149 s>= 1)
                                                                                                                                                int32_t x24_4 = 0
                                                                                                                                                
                                                                                                                                                do
                                                                                                                                                    (*(*arg1 + 0x640))(arg1, x0_145, 
                                                                                                                                                        zx.q(x24_4), 1, &var_88)
                                                                                                                                                    char x25_4 = var_88.b
                                                                                                                                                    
                                                                                                                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                        goto label_45dda4
                                                                                                                                                    
                                                                                                                                                    if (x0_155 == 0)
                                                                                                                                                        x1_68 = "java/lang/ArithmeticException"
                                                                                                                                                        x2_48 = "divide by zero"
                                                                                                                                                        goto label_45dda0
                                                                                                                                                    
                                                                                                                                                    int64_t x2_43 = var_108
                                                                                                                                                    
                                                                                                                                                    if (x2_43 == 0)
                                                                                                                                                        if ((sub_45be5c(arg1, &var_90, 
                                                                                                                                                                &var_108, 0, "java/lang/String", 
                                                                                                                                                                "charAt", "(I)C") & 1) != 0)
                                                                                                                                                            goto label_45dda4
                                                                                                                                                        
                                                                                                                                                        x2_43 = var_108
                                                                                                                                                    
                                                                                                                                                    var_88.d = x24_4 s% x0_155
                                                                                                                                                    char x0_164 = (*(*arg1 + 0x168))(arg1, 
                                                                                                                                                        x20, x2_43, &var_88)
                                                                                                                                                    
                                                                                                                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                        goto label_45dda4
                                                                                                                                                    
                                                                                                                                                    var_88.b = x25_4 ^ x0_164
                                                                                                                                                    (*(*arg1 + 0x680))(arg1, x0_145, 
                                                                                                                                                        zx.q(x24_4), 1, &var_88)
                                                                                                                                                    
                                                                                                                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                        goto label_45dda4
                                                                                                                                                    
                                                                                                                                                    x24_4 += 1
                                                                                                                                                while (x0_149 != x24_4)
                                                                                                                                            
                                                                                                                                            int64_t x1_65 = var_90
                                                                                                                                            
                                                                                                                                            if (x1_65 == 0)
                                                                                                                                                if ((sub_45bc9c(arg1, &var_90, 
                                                                                                                                                        "java/lang/String") & 1) != 0)
                                                                                                                                                    goto label_45dda4
                                                                                                                                                
                                                                                                                                                x1_65 = var_90
                                                                                                                                            
                                                                                                                                            int64_t result_1 =
                                                                                                                                                (*(*arg1 + 0xd8))(arg1, x1_65)
                                                                                                                                            
                                                                                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                goto label_45dda4
                                                                                                                                            
                                                                                                                                            if (result_1 == 0)
                                                                                                                                                goto label_45dd94
                                                                                                                                            
                                                                                                                                            int64_t var_d0
                                                                                                                                            int64_t x2_46 = var_d0
                                                                                                                                            
                                                                                                                                            if (x2_46 == 0)
                                                                                                                                                if ((sub_45be5c(arg1, &var_90, &var_d0, 
                                                                                                                                                        0, "java/lang/String", "<init>", 
                                                                                                                                                        "([B)V") & 1) != 0)
                                                                                                                                                    goto label_45dda4
                                                                                                                                                
                                                                                                                                                x2_46 = var_d0
                                                                                                                                            
                                                                                                                                            var_88 = x0_145
                                                                                                                                            (*(*arg1 + 0x1f8))(arg1, result_1, 
                                                                                                                                                x2_46, &var_88)
                                                                                                                                            
                                                                                                                                            if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                                                                                                                                                result = result_1
                                                                                                                                            else
                                                                                                                                                result = 0
                                                                                                                                            
                                                                                                                                            break
                                                                                                                                        
                                                                                                                                        int64_t x2_29 = var_108
                                                                                                                                        int64_t x1_46 = x0
                                                                                                                                        
                                                                                                                                        if (x2_29 == 0)
                                                                                                                                            if ((sub_45be5c(arg1, &var_90, 
                                                                                                                                                    &var_108, 0, "java/lang/String", 
                                                                                                                                                    "charAt", "(I)C") & 1) != 0)
                                                                                                                                                goto label_45dda4
                                                                                                                                            
                                                                                                                                            x2_29 = var_108
                                                                                                                                            x1_46 = x0
                                                                                                                                        
                                                                                                                                        var_88.d = x28_3
                                                                                                                                        int16_t x0_119 = (*(*arg1 + 0x168))(
                                                                                                                                            arg1, x1_46, x2_29, &var_88)
                                                                                                                                        
                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                            goto label_45dda4
                                                                                                                                        
                                                                                                                                        int64_t var_110
                                                                                                                                        int64_t x2_31 = var_110
                                                                                                                                        
                                                                                                                                        if (x2_31 == 0)
                                                                                                                                            if ((sub_45be5c(arg1, &var_90, 
                                                                                                                                                    &var_110, 0, "java/lang/String", 
                                                                                                                                                    "indexOf", "(I)I") & 1) != 0)
                                                                                                                                                goto label_45dda4
                                                                                                                                            
                                                                                                                                            x2_31 = var_110
                                                                                                                                        
                                                                                                                                        var_88.d = zx.d(x0_119)
                                                                                                                                        int32_t x0_125 = (*(*arg1 + 0x198))(
                                                                                                                                            arg1, x22, x2_31, &var_88)
                                                                                                                                        
                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                            goto label_45dda4
                                                                                                                                        
                                                                                                                                        int64_t x2_33 = var_108
                                                                                                                                        int64_t x1_50 = x0
                                                                                                                                        
                                                                                                                                        if (x2_33 == 0)
                                                                                                                                            if ((sub_45be5c(arg1, &var_90, 
                                                                                                                                                    &var_108, 0, "java/lang/String", 
                                                                                                                                                    "charAt", "(I)C") & 1) != 0)
                                                                                                                                                goto label_45dda4
                                                                                                                                            
                                                                                                                                            x2_33 = var_108
                                                                                                                                            x1_50 = x0
                                                                                                                                        
                                                                                                                                        var_88.d = x28_3 + 1
                                                                                                                                        int16_t x0_131 = (*(*arg1 + 0x168))(
                                                                                                                                            arg1, x1_50, x2_33, &var_88)
                                                                                                                                        
                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                            goto label_45dda4
                                                                                                                                        
                                                                                                                                        int64_t x2_35 = var_110
                                                                                                                                        
                                                                                                                                        if (x2_35 == 0)
                                                                                                                                            if ((sub_45be5c(arg1, &var_90, 
                                                                                                                                                    &var_110, 0, "java/lang/String", 
                                                                                                                                                    "indexOf", "(I)I") & 1) != 0)
                                                                                                                                                goto label_45dda4
                                                                                                                                            
                                                                                                                                            x2_35 = var_110
                                                                                                                                        
                                                                                                                                        var_88.d = zx.d(x0_131)
                                                                                                                                        int32_t x0_137 = (*(*arg1 + 0x198))(
                                                                                                                                            arg1, x22, x2_35, &var_88)
                                                                                                                                        
                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                            goto label_45dda4
                                                                                                                                        
                                                                                                                                        int64_t x2_26 = var_118
                                                                                                                                        
                                                                                                                                        if (x2_26 == 0)
                                                                                                                                            if ((sub_45be5c(arg1, &var_98, 
                                                                                                                                                    &var_118, 0, 
                                                                                                                                                    "java/io/ByteArrayOutputStream", 
                                                                                                                                                    "write", "(I)V") & 1) != 0)
                                                                                                                                                goto label_45dda4
                                                                                                                                            
                                                                                                                                            x2_26 = var_118
                                                                                                                                        
                                                                                                                                        var_88.d = x0_137 | x0_125 << 4
                                                                                                                                        (*(*arg1 + 0x1f8))(arg1, x0_93, x2_26, 
                                                                                                                                            &var_88)
                                                                                                                                        result = 0
                                                                                                                                        cond:0_1 =
                                                                                                                                            zx.d((*(*arg1 + 0x720))(arg1)) != 0
                                                                                                                                        x28_3 += 2
                                                                                                                                    while (not(cond:0_1))
                                                                                                                                    break
    
label_45dda4:
    result = 0
    break

if (*(x8 + 0x28) == x8_1)
    return result

__stack_chk_fail()
noreturn
