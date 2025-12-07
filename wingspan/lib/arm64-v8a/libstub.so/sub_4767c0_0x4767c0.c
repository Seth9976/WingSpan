// 函数: sub_4767c0
// 地址: 0x4767c0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x26 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x26 + 0x28)
int64_t var_d0
__builtin_memset(&var_d0, 0, 0x68)
int64_t x0 = (*(*arg1 + 0xc8))()
int64_t x24 = (*(*arg1 + 0xc8))(arg1, (*(*arg1 + 0xc8))(arg1, arg3))
int64_t x0_6 = (*(*arg1 + 0xc8))(arg1, x0)
int64_t var_98
int64_t var_70
int32_t x0_8 = sub_45be5c(arg1, &var_70, &var_98, 1, "androidx/loader/app/services/", &data_40d1a3, 
    "(Ljava/lang/Object;)Ljava/lang/String;")
int64_t var_68
int64_t x0_10
char x0_12

if ((x0_8 & 1) == 0)
    var_68 = x24
    x0_10 = (*(*arg1 + 0x3a0))(arg1, var_70, var_98, &var_68)
    x0_12 = (*(*arg1 + 0x720))(arg1)

int32_t result
int64_t var_c0
int64_t var_b0
int64_t var_a8
int64_t var_80
int64_t x21_1
int64_t x22_1
int64_t x23

if ((x0_8 & 1) == 0 && zx.d(x0_12) == 0)
    if (x24 != 0)
        (*(*arg1 + 0xb8))(arg1, x24)
    
    int64_t var_78
    int64_t x1_28 = var_78
    
    if (x1_28 != 0)
        goto label_476cdc
    
    if ((sub_45bc9c(arg1, &var_78, "org/json/JSONObject") & 1) != 0)
        x23 = 0
        x22_1 = 0
        x21_1 = 0
    label_476cfc:
        x24 = x0_10
        goto label_4768e4
    
    x1_28 = var_78
label_476cdc:
    x21_1 = (*(*arg1 + 0xd8))(arg1, x1_28)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_476cf4
    
    if (x21_1 == 0)
        sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
    label_476cf4:
        x23 = 0
        x22_1 = 0
        goto label_476cfc
    
    int64_t var_a0
    int64_t x2_12 = var_a0
    
    if (x2_12 != 0)
        goto label_476d44
    
    if ((sub_45be5c(arg1, &var_78, &var_a0, 0, "org/json/JSONObject", "<init>", 
            "(Ljava/lang/String;)V") & 1) != 0)
        goto label_476cf4
    
    x2_12 = var_a0
label_476d44:
    var_68 = x0_10
    (*(*arg1 + 0x1f8))(arg1, x21_1, x2_12, &var_68)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_476cf4
    
    int64_t x2_14 = var_a8
    
    if (x2_14 != 0)
        goto label_476dd0
    
    if ((sub_45be5c(arg1, &var_70, &var_a8, 1, "androidx/loader/app/services/", &data_40e5c9, 
            "()Landroid/os/Handler;") & 1) != 0)
        goto label_476cf4
    
    x2_14 = var_a8
label_476dd0:
    x24 = (*(*arg1 + 0x3a0))(arg1, var_70, x2_14, &var_68)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_476cf4
    
    if (x0_10 != 0)
        (*(*arg1 + 0xb8))(arg1, x0_10)
    
    int64_t x2_17 = var_b0
    
    if (x2_17 != 0)
        goto label_476e3c
    
    if ((sub_45be5c(arg1, &var_80, &var_b0, 1, "androidx/loader/app/services/", &data_40e3b2, 
        "(Ljava/lang/Object;)Landroid/content/Context;") & 1) != 0)
    label_476e74:
        x23 = 0
        x22_1 = 0
        goto label_4768e4
    
    x2_17 = var_b0
label_476e3c:
    var_68 = x0_6
    x22_1 = (*(*arg1 + 0x3a0))(arg1, var_80, x2_17, &var_68)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_476e74
    
    int64_t var_88
    int64_t x1_36 = var_88
    
    if (x1_36 != 0)
        goto label_476ef8
    
    if ((sub_45bc9c(arg1, &var_88, "androidx/loader/app/services/j") & 1) != 0)
        x23 = 0
        goto label_4768e4
    
    x1_36 = var_88
label_476ef8:
    x23 = (*(*arg1 + 0xd8))(arg1, x1_36)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_4768e4
    
    if (x23 == 0)
        sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
        goto label_4768e4
    
    int64_t var_b8
    int64_t x2_18 = var_b8
    
    if (x2_18 != 0)
        goto label_476f50
    
    if ((sub_45be5c(arg1, &var_88, &var_b8, 0, "androidx/loader/app/services/j", "<init>", 
            "(Landroid/content/Context;Lorg/json/JSONObject;)V") & 1) != 0)
        goto label_4768e4
    
    x2_18 = var_b8
label_476f50:
    var_68 = x22_1
    int64_t var_60_3 = x21_1
    (*(*arg1 + 0x1f8))(arg1, x23, x2_18, &var_68)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        goto label_4768e4
    
    int64_t x2_20 = var_c0
    
    if (x2_20 != 0)
        goto label_476fc0
    
    if ((sub_45be5c(arg1, &var_80, &var_c0, 1, "androidx/loader/app/services/", 0x45250c, 
            "(Ljava/lang/Object;Ljava/lang/Object;)Z") & 1) != 0)
        goto label_4768e4
    
    x2_20 = var_c0
label_476fc0:
    var_68 = x24
    int64_t var_60_4 = x23
    (*(*arg1 + 0x3b8))(arg1, var_80, x2_20, &var_68)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) != 0)
        goto label_4768e4
else
    x23 = 0
    x22_1 = 0
    x21_1 = 0
label_4768e4:
    uint64_t x0_14 = (*(*arg1 + 0x78))(arg1)
    (*(*arg1 + 0x88))(arg1)
    int32_t x0_17 = sub_45bb84(arg1, x0_14, "java/io/IOException")
    int32_t x0_19
    
    if ((x0_17 & 1) == 0)
        x0_19 = sub_45bb84(arg1, x0_14, "org/json/JSONException")
    
    if ((x0_17 & 1) == 0 && (x0_19 & 1) == 0)
        (*(*arg1 + 0x68))(arg1, x0_14)
        result = (*(*arg1 + 0xb8))(arg1, x0_14)
    else
        if (x24 != 0)
            (*(*arg1 + 0xb8))(arg1, x24)
        
        int64_t var_c8
        int64_t x2_3 = var_c8
        
        if (x2_3 != 0)
            goto label_476994
        
        result = sub_45be5c(arg1, &var_70, &var_c8, 1, "androidx/loader/app/services/", 
            &data_40f535, "()Ljava/lang/Object;")
        
        if ((result & 1) == 0)
            x2_3 = var_c8
        label_476994:
            int64_t x0_23 = (*(*arg1 + 0x3a0))(arg1, var_70, x2_3, &var_68)
            result = (*(*arg1 + 0x720))(arg1)
            
            if ((result & 0xff) == 0)
                if (x21_1 != 0)
                    result = (*(*arg1 + 0xb8))(arg1, x21_1)
                
                if (x0_23 != 0)
                    int64_t x2_4 = var_a8
                    
                    if (x2_4 != 0)
                        goto label_476a20
                    
                    result = sub_45be5c(arg1, &var_70, &var_a8, 1, "androidx/loader/app/services/", 
                        &data_40e5c9, "()Landroid/os/Handler;")
                    
                    if ((result & 1) == 0)
                        x2_4 = var_a8
                    label_476a20:
                        int64_t x0_28 = (*(*arg1 + 0x3a0))(arg1, var_70, x2_4, &var_68)
                        result = (*(*arg1 + 0x720))(arg1)
                        
                        if ((result & 0xff) == 0)
                            (*(*arg1 + 0xb8))(arg1, x0_23)
                            int64_t x2_6 = var_b0
                            
                            if (x2_6 != 0)
                                goto label_476a90
                            
                            result = sub_45be5c(arg1, &var_80, &var_b0, 1, 
                                "androidx/loader/app/services/", &data_40e3b2, 
                                "(Ljava/lang/Object;)Landroid/content/Context;")
                            
                            if ((result & 1) == 0)
                                x2_6 = var_b0
                            label_476a90:
                                var_68 = x0_6
                                int64_t x0_33 = (*(*arg1 + 0x3a0))(arg1, var_80, x2_6, &var_68)
                                result = (*(*arg1 + 0x720))(arg1)
                                
                                if ((result & 0xff) == 0)
                                    if (x22_1 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x22_1)
                                    
                                    if (x23 != 0)
                                        (*(*arg1 + 0xb8))(arg1, x23)
                                    
                                    int64_t var_90
                                    int64_t x1_19 = var_90
                                    
                                    if (x1_19 != 0)
                                        goto label_476b28
                                    
                                    result =
                                        sub_45bc9c(arg1, &var_90, "androidx/loader/app/services/k")
                                    
                                    if ((result & 1) == 0)
                                        x1_19 = var_90
                                    label_476b28:
                                        int64_t x0_39 = (*(*arg1 + 0xd8))(arg1, x1_19)
                                        result = (*(*arg1 + 0x720))(arg1)
                                        
                                        if ((result & 0xff) == 0)
                                            if (x0_39 == 0)
                                                result = sub_45bac8(arg1, 
                                                    "java/lang/NullPointerException", 
                                                    "NullPointerException")
                                            else
                                                int64_t x2_8 = var_d0
                                                
                                                if (x2_8 != 0)
                                                    goto label_476b88
                                                
                                                result = sub_45be5c(arg1, &var_90, &var_d0, 0, 
                                                    "androidx/loader/app/services/k", "<init>", 
                                                    "(Landroid/content/Context;Ljava/lang/Exception;)V")
                                                
                                                if ((result & 1) == 0)
                                                    x2_8 = var_d0
                                                label_476b88:
                                                    var_68 = x0_33
                                                    uint64_t var_60_1 = x0_14
                                                    (*(*arg1 + 0x1f8))(arg1, x0_39, x2_8, &var_68)
                                                    result = (*(*arg1 + 0x720))(arg1)
                                                    
                                                    if ((result & 0xff) == 0)
                                                        int64_t x2_10 = var_c0
                                                        
                                                        if (x2_10 != 0)
                                                            goto label_476bf8
                                                        
                                                        result = sub_45be5c(arg1, &var_80, &var_c0, 
                                                            1, "androidx/loader/app/services/", 
                                                            0x45250c, 
                                                            "(Ljava/lang/Object;Ljava/lang/Object;)Z")
                                                        
                                                        if ((result & 1) == 0)
                                                            x2_10 = var_c0
                                                        label_476bf8:
                                                            var_68 = x0_28
                                                            int64_t var_60_2 = x0_39
                                                            (*(*arg1 + 0x3b8))(arg1, var_80, x2_10, 
                                                                &var_68)
                                                            result = (*(*arg1 + 0x720))(arg1)

if (*(x26 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
