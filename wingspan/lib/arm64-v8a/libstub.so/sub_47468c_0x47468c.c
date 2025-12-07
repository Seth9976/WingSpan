// 函数: sub_47468c
// 地址: 0x47468c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x25 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x25 + 0x28)
int64_t var_118
__builtin_memset(&var_118, 0, 0xa0)
uint64_t x0_2 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))())
int64_t var_a8
int64_t var_80
int32_t result = sub_45be5c(arg1, &var_80, &var_a8, 1, "androidx/loader/app/services/", 
    &data_40cf8c, "(Ljava/lang/Object;)Z")

if ((result & 1) == 0)
    uint64_t var_78 = x0_2
    char x0_5 = (*(*arg1 + 0x3b8))(arg1, var_80, var_a8, &var_78)
    result = (*(*arg1 + 0x720))(arg1)
    
    if (zx.d(x0_5) != 0 && (result & 0xff) == 0)
        int64_t var_b0
        int64_t x2_2 = var_b0
        
        if (x2_2 != 0)
            goto label_4747b4
        
        int64_t var_88
        void* x8_78
        uint64_t x21_2
        uint64_t x22_2
        uint64_t x23_1
        
        if ((sub_45be5c(arg1, &var_88, &var_b0, 1, "androidx/loader/app/services/", &data_40de20, 
            "(Ljava/lang/Object;)Ljava/net/HttpURLConnection;") & 1) != 0)
        label_4747ec:
            x21_2 = 0
        label_4748f0:
            x23_1 = (*(*arg1 + 0x78))(arg1)
            (*(*arg1 + 0x88))(arg1)
            
            if ((sub_45bb84(arg1, x23_1, "java/lang/Throwable") & 1) != 0)
                x22_2 = 0
            label_47491c:
                
                if (x21_2 == 0)
                    goto label_474934
                
                goto label_474930
            
        label_474efc:
            x8_78 = *arg1
        label_474f0c:
            (*(x8_78 + 0x68))(arg1, x23_1)
            result = (*(*arg1 + 0xb8))(arg1, x23_1)
        else
            x2_2 = var_b0
        label_4747b4:
            var_78 = x0_2
            uint64_t x22_1 = (*(*arg1 + 0x3a0))(arg1, var_88, x2_2, &var_78)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                goto label_4747ec
            
            int64_t var_b8
            int64_t x2_4 = var_b8
            
            if (x2_4 == 0)
                if ((sub_45be5c(arg1, &var_88, &var_b8, 1, "androidx/loader/app/services/", 
                        &data_40e86b, "(Ljava/lang/Object;)V") & 1) != 0)
                    x21_2 = x22_1
                    goto label_4748f0
                
                x2_4 = var_b8
            
            var_78 = x22_1
            (*(*arg1 + 0x478))(arg1, var_88, x2_4, &var_78)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                x21_2 = x22_1
                goto label_4748f0
            
            int64_t x2_6 = var_b0
            
            if (x2_6 == 0)
                if ((sub_45be5c(arg1, &var_88, &var_b0, 1, "androidx/loader/app/services/", 
                        &data_40de20, "(Ljava/lang/Object;)Ljava/net/HttpURLConnection;") & 1) != 0)
                    x21_2 = x22_1
                    goto label_4748f0
                
                x2_6 = var_b0
            
            var_78 = x0_2
            x21_2 = (*(*arg1 + 0x3a0))(arg1, var_88, x2_6, &var_78)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                x21_2 = x22_1
                goto label_4748f0
            
            if (x22_1 != 0)
                (*(*arg1 + 0xb8))(arg1, x22_1)
            
            int64_t var_c0
            int64_t x2_13 = var_c0
            int64_t var_90
            
            if (x2_13 == 0)
                if ((sub_45be5c(arg1, &var_90, &var_c0, 1, "androidx/loader/app/services/", 
                        0x4520ae, "(Ljava/lang/Object;)I") & 1) != 0)
                    goto label_4748f0
                
                x2_13 = var_c0
            
            var_78 = x21_2
            int32_t x0_42 = (*(*arg1 + 0x418))(arg1, var_90, x2_13, &var_78)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                goto label_4748f0
            
            int64_t var_108
            int64_t var_d0
            uint64_t var_70
            uint64_t x23_2
            
            if (x0_42 - 0xc8 u<= 0x63)
                int64_t x2_16 = var_b0
                
                if (x2_16 == 0)
                    if ((sub_45be5c(arg1, &var_88, &var_b0, 1, "androidx/loader/app/services/", 
                            &data_40de20, "(Ljava/lang/Object;)Ljava/net/HttpURLConnection;") & 1) != 0)
                        goto label_4748f0
                    
                    x2_16 = var_b0
                
                var_78 = x0_2
                x22_1 = (*(*arg1 + 0x3a0))(arg1, var_88, x2_16, &var_78)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_4748f0
                
                if (x21_2 != 0)
                    (*(*arg1 + 0xb8))(arg1, x21_2)
                
                int64_t var_c8
                int64_t x2_19 = var_c8
                
                if (x2_19 == 0)
                    if ((sub_45be5c(arg1, &var_90, &var_c8, 1, "androidx/loader/app/services/", 
                            &data_40d198, "(Ljava/lang/Object;)Ljava/io/InputStream;") & 1) != 0)
                        x21_2 = x22_1
                        goto label_4748f0
                    
                    x2_19 = var_c8
                
                var_78 = x22_1
                x21_2 = (*(*arg1 + 0x3a0))(arg1, var_90, x2_19, &var_78)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    x21_2 = x22_1
                    goto label_4748f0
                
                if (x22_1 != 0)
                    (*(*arg1 + 0xb8))(arg1, x22_1)
                
                int64_t x2_21 = var_d0
                
                if (x2_21 != 0)
                    goto label_474c98
                
                int64_t var_e0
                uint64_t x24_2
                
                if ((sub_45be5c(arg1, &var_80, &var_d0, 1, "androidx/loader/app/services/", 
                    &data_40c47f, "(Ljava/lang/Object;)Landroidx/loader/app/services/b$a;") & 1) != 0)
                label_474cd0:
                    x24_2 = 0
                label_474ce8:
                    x22_2 = (*(*arg1 + 0x78))(arg1)
                    (*(*arg1 + 0x88))(arg1)
                    
                    if ((sub_45bb84(arg1, x22_2, "java/lang/Throwable") & 1) != 0)
                        if (x24_2 != 0)
                            (*(*arg1 + 0xb8))(arg1, x24_2)
                        
                        if (x21_2 != 0)
                            int64_t x2_22 = var_e0
                            
                            if (x2_22 != 0)
                                goto label_474d68
                            
                            if ((sub_45be5c(arg1, &var_80, &var_e0, 1, 
                                "androidx/loader/app/services/", &data_40d6ed, 
                                "(Ljava/lang/Object;)V") & 1) != 0)
                            label_474db0:
                                x23_1 = (*(*arg1 + 0x78))(arg1)
                                (*(*arg1 + 0x88))(arg1)
                                int32_t x0_86 = sub_45bb84(arg1, x23_1, "java/lang/Throwable")
                                x8_78 = *arg1
                                
                                if ((x0_86 & 1) == 0)
                                    goto label_474f0c
                                
                                (*(x8_78 + 0xb8))(arg1, x21_2)
                                int64_t var_e8
                                int64_t x2_24 = var_e8
                                
                                if (x2_24 == 0)
                                    if ((sub_45be5c(arg1, &var_88, &var_e8, 1, 
                                            "androidx/loader/app/services/", &data_40e8a0, 
                                            "(Ljava/lang/Object;Ljava/lang/Object;)V") & 1) != 0)
                                        x21_2 = x23_1
                                        goto label_474ed4
                                    
                                    x2_24 = var_e8
                                
                                var_78 = x22_2
                                var_70 = x23_1
                                (*(*arg1 + 0x478))(arg1, var_88, x2_24, &var_78)
                                x21_2 = x23_1
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_474ed4
                            else
                                x2_22 = var_e0
                            label_474d68:
                                var_78 = x21_2
                                (*(*arg1 + 0x478))(arg1, var_80, x2_22, &var_78)
                                
                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                    goto label_474db0
                        
                        if (x22_2 == 0)
                            sub_45bac8(arg1, "java/lang/NullPointerException", 
                                "NullPointerException")
                            goto label_474ed4
                        
                        (*(*arg1 + 0x68))(arg1, x22_2)
                        x23_2 = x22_2
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                            goto label_474ed4
                        
                        goto label_474ac8
                    
                    (*(*arg1 + 0x68))(arg1, x22_2)
                    result = (*(*arg1 + 0xb8))(arg1, x22_2)
                else
                    x2_21 = var_d0
                label_474c98:
                    var_78 = x0_2
                    x24_2 = (*(*arg1 + 0x3a0))(arg1, var_80, x2_21, &var_78)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        goto label_474cd0
                    
                    int64_t var_d8
                    int64_t x2_38 = var_d8
                    
                    if (x2_38 == 0)
                        if ((sub_45be5c(arg1, &var_80, &var_d8, 1, "androidx/loader/app/services/", 
                                &data_40c042, "(Ljava/lang/Object;Ljava/lang/Object;)V") & 1) != 0)
                            goto label_474ce8
                        
                        x2_38 = var_d8
                    
                    var_78 = x24_2
                    var_70 = x21_2
                    (*(*arg1 + 0x478))(arg1, var_80, x2_38, &var_78)
                    result = (*(*arg1 + 0x720))(arg1)
                    
                    if ((result & 0xff) != 0)
                        goto label_474ce8
                    
                    if (x21_2 != 0)
                        int64_t x2_40 = var_e0
                        
                        if (x2_40 != 0)
                            goto label_475310
                        
                        if ((sub_45be5c(arg1, &var_80, &var_e0, 1, "androidx/loader/app/services/", 
                            &data_40d6ed, "(Ljava/lang/Object;)V") & 1) != 0)
                        label_475358:
                            x23_1 = (*(*arg1 + 0x78))(arg1)
                            (*(*arg1 + 0x88))(arg1)
                            
                            if ((sub_45bb84(arg1, x23_1, "java/lang/Throwable") & 1) == 0)
                                goto label_474efc
                            
                            x22_2 = x24_2
                        label_474930:
                            (*(*arg1 + 0xb8))(arg1, x21_2)
                        label_474934:
                            int64_t x2_9 = var_d0
                            
                            if (x2_9 != 0)
                                goto label_474970
                            
                            result = sub_45be5c(arg1, &var_80, &var_d0, 1, 
                                "androidx/loader/app/services/", &data_40c47f, 
                                "(Ljava/lang/Object;)Landroidx/loader/app/services/b$a;")
                            
                            if ((result & 1) == 0)
                                x2_9 = var_d0
                            label_474970:
                                var_78 = x0_2
                                uint64_t x0_32 = (*(*arg1 + 0x3a0))(arg1, var_80, x2_9, &var_78)
                                result = (*(*arg1 + 0x720))(arg1)
                                
                                if ((result & 0xff) == 0)
                                    if (x22_2 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x22_2)
                                    
                                    int64_t x2_11 = var_108
                                    
                                    if (x2_11 != 0)
                                        goto label_4749fc
                                    
                                    result = sub_45be5c(arg1, &var_80, &var_108, 1, 
                                        "androidx/loader/app/services/", &data_40c7b0, 
                                        "(Ljava/lang/Object;Ljava/lang/Object;)V")
                                    
                                    if ((result & 1) == 0)
                                        x2_11 = var_108
                                    label_4749fc:
                                        var_78 = x0_32
                                        uint64_t var_70_1 = x23_1
                                        (*(*arg1 + 0x478))(arg1, var_80, x2_11, &var_78)
                                        result = (*(*arg1 + 0x720))(arg1)
                        else
                            x2_40 = var_e0
                        label_475310:
                            var_78 = x21_2
                            (*(*arg1 + 0x478))(arg1, var_80, x2_40, &var_78)
                            result = (*(*arg1 + 0x720))(arg1)
                            
                            if ((result & 0xff) != 0)
                                goto label_475358
            else
                x23_2 = 0
            label_474ac8:
                int64_t x2_15 = var_b0
                
                if (x2_15 != 0)
                    goto label_474b04
                
                if ((sub_45be5c(arg1, &var_88, &var_b0, 1, "androidx/loader/app/services/", 
                    &data_40de20, "(Ljava/lang/Object;)Ljava/net/HttpURLConnection;") & 1) != 0)
                label_474b3c:
                    x22_2 = x23_2
                label_474ed4:
                    x23_1 = (*(*arg1 + 0x78))(arg1)
                    (*(*arg1 + 0x88))(arg1)
                    
                    if ((sub_45bb84(arg1, x23_1, "java/lang/Throwable") & 1) != 0)
                        goto label_47491c
                    
                    goto label_474efc
                
                x2_15 = var_b0
            label_474b04:
                var_78 = x0_2
                uint64_t x24_1 = (*(*arg1 + 0x3a0))(arg1, var_88, x2_15, &var_78)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_474b3c
                
                if (x21_2 != 0)
                    (*(*arg1 + 0xb8))(arg1, x21_2)
                
                int64_t var_f0
                int64_t x2_27 = var_f0
                
                if (x2_27 != 0)
                    goto label_474e80
                
                if ((sub_45be5c(arg1, &var_90, &var_f0, 1, "androidx/loader/app/services/", 
                    &data_40e598, "(Ljava/lang/Object;)Ljava/io/InputStream;") & 1) != 0)
                label_474eb8:
                    x22_2 = x23_2
                    x21_2 = x24_1
                    goto label_474ed4
                
                x2_27 = var_f0
            label_474e80:
                var_78 = x24_1
                uint64_t x0_94 = (*(*arg1 + 0x3a0))(arg1, var_90, x2_27, &var_78)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_474eb8
                
                if (x24_1 != 0)
                    (*(*arg1 + 0xb8))(arg1, x24_1)
                
                int64_t var_100
                int64_t var_98
                int64_t x2_34
                
                if (x0_94 == 0)
                    int64_t x2_36 = var_d0
                    
                    if (x2_36 != 0)
                        goto label_47521c
                    
                    if ((sub_45be5c(arg1, &var_80, &var_d0, 1, "androidx/loader/app/services/", 
                            &data_40c47f, "(Ljava/lang/Object;)Landroidx/loader/app/services/b$a;") & 1)
                            == 0)
                        x2_36 = var_d0
                    label_47521c:
                        var_78 = x0_2
                        x21_2 = (*(*arg1 + 0x3a0))(arg1, var_80, x2_36, &var_78)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                            if (x23_2 != 0)
                                (*(*arg1 + 0xb8))(arg1, x23_2)
                            
                            int64_t x1_65 = var_98
                            
                            if (x1_65 == 0)
                                if ((sub_45bc9c(arg1, &var_98, "java/io/IOException") & 1) != 0)
                                    goto label_474b3c
                                
                                x1_65 = var_98
                            
                            x22_2 = (*(*arg1 + 0xd8))(arg1, x1_65)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_474ed4
                            
                            int64_t var_110
                            int64_t x2_42 = var_110
                            int64_t var_a0
                            
                            if (x2_42 == 0)
                                if ((sub_45be5c(arg1, &var_a0, &var_110, 1, 
                                        "androidx/loader/app/services/b", &data_40ca99, "()[S") & 1) != 0)
                                    goto label_474ed4
                                
                                x2_42 = var_110
                            
                            uint64_t x0_164 = (*(*arg1 + 0x3a0))(arg1, var_a0, x2_42, &var_78)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_474ed4
                            
                            int64_t x2_44 = var_118
                            
                            if (x2_44 == 0)
                                if ((sub_45be5c(arg1, &var_88, &var_118, 1, 
                                        "androidx/loader/app/services/", &data_40de29, 
                                        "([SIII)Ljava/lang/String;") & 1) != 0)
                                    goto label_474ed4
                                
                                x2_44 = var_118
                            
                            var_78 = x0_164
                            var_70.d = 3
                            int32_t var_68_1 = 0x14
                            int32_t var_60_1 = 0xb5a
                            int64_t x0_170 = (*(*arg1 + 0x3a0))(arg1, var_88, x2_44, &var_78)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_474ed4
                            
                            if (x0_164 != 0)
                                (*(*arg1 + 0xb8))(arg1, x0_164)
                            
                            uint64_t x0_175 = (*(*arg1 + 0xc8))(arg1, x0_170)
                            
                            if (x22_2 == 0)
                                sub_45bac8(arg1, "java/lang/NullPointerException", 
                                    "NullPointerException")
                                goto label_474ed4
                            
                            int64_t x2_46 = var_100
                            
                            if (x2_46 == 0)
                                if ((sub_45be5c(arg1, &var_98, &var_100, 0, "java/io/IOException", 
                                        "<init>", "(Ljava/lang/String;)V") & 1) != 0)
                                    goto label_474ed4
                                
                                x2_46 = var_100
                            
                            var_78 = x0_175
                            (*(*arg1 + 0x1f8))(arg1, x22_2, x2_46, &var_78)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                goto label_474ed4
                            
                            x2_34 = var_108
                            
                            if (x2_34 == 0)
                                if ((sub_45be5c(arg1, &var_80, &var_108, 1, 
                                        "androidx/loader/app/services/", &data_40c7b0, 
                                        "(Ljava/lang/Object;Ljava/lang/Object;)V") & 1) != 0)
                                    goto label_474ed4
                                
                                x2_34 = var_108
                            
                            var_78 = x21_2
                            uint64_t var_70_3 = x22_2
                            goto label_47519c
                    
                    x21_2 = 0
                    x22_2 = x23_2
                    goto label_474ed4
                
                int64_t var_f8
                int64_t x2_28 = var_f8
                x24_1 = x0_94
                
                if (x2_28 != 0)
                    goto label_474fac
                
                if ((sub_45be5c(arg1, &var_90, &var_f8, 1, "androidx/loader/app/services/", 
                        &data_40d1a3, "(Ljava/lang/Object;)Ljava/lang/String;") & 1) != 0)
                    goto label_474eb8
                
                x2_28 = var_f8
            label_474fac:
                var_78 = x24_1
                x21_2 = (*(*arg1 + 0x3a0))(arg1, var_90, x2_28, &var_78)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_474eb8
                
                (*(*arg1 + 0xb8))(arg1, x24_1)
                int64_t x2_30 = var_d0
                
                if (x2_30 == 0)
                    if ((sub_45be5c(arg1, &var_80, &var_d0, 1, "androidx/loader/app/services/", 
                            &data_40c47f, "(Ljava/lang/Object;)Landroidx/loader/app/services/b$a;") & 1)
                            != 0)
                        goto label_474b3c
                    
                    x2_30 = var_d0
                
                var_78 = x0_2
                x22_2 = (*(*arg1 + 0x3a0))(arg1, var_80, x2_30, &var_78)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_474b3c
                
                if (x23_2 != 0)
                    (*(*arg1 + 0xb8))(arg1, x23_2)
                
                int64_t x1_50 = var_98
                
                if (x1_50 == 0)
                    if ((sub_45bc9c(arg1, &var_98, "java/io/IOException") & 1) != 0)
                        goto label_474ed4
                    
                    x1_50 = var_98
                
                int64_t x0_122 = (*(*arg1 + 0xd8))(arg1, x1_50)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_474ed4
                
                if (x0_122 == 0)
                    sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                    goto label_474ed4
                
                int64_t x2_32 = var_100
                
                if (x2_32 == 0)
                    if ((sub_45be5c(arg1, &var_98, &var_100, 0, "java/io/IOException", "<init>", 
                            "(Ljava/lang/String;)V") & 1) != 0)
                        goto label_474ed4
                    
                    x2_32 = var_100
                
                var_78 = x21_2
                (*(*arg1 + 0x1f8))(arg1, x0_122, x2_32, &var_78)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    goto label_474ed4
                
                x2_34 = var_108
                
                if (x2_34 == 0)
                    if ((sub_45be5c(arg1, &var_80, &var_108, 1, "androidx/loader/app/services/", 
                            &data_40c7b0, "(Ljava/lang/Object;Ljava/lang/Object;)V") & 1) != 0)
                        goto label_474ed4
                    
                    x2_34 = var_108
                
                var_78 = x22_2
                int64_t var_70_2 = x0_122
            label_47519c:
                (*(*arg1 + 0x478))(arg1, var_80, x2_34, &var_78)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) != 0)
                    goto label_474ed4

if (*(x25 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
