// 函数: sub_48b074
// 地址: 0x48b074
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x26 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x26 + 0x28)
int64_t var_150
__builtin_memset(&var_150, 0, 0xc0)
int64_t x0 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t result
int64_t var_e8
int64_t var_98

if (x0 == 0)
    sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
    result = 0
else if ((sub_45be5c(arg1, &var_98, &var_e8, 0, "android/graphics/Bitmap", "getWidth", 0x452601)
        & 1) != 0)
    result = 0
else
    int32_t var_90
    int32_t x0_4 = (*(*arg1 + 0x198))(arg1, x0, var_e8, &var_90)
    
    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
        result = 0
    else
        int64_t var_f0
        int64_t x2_2 = var_f0
        
        if (x2_2 != 0)
            goto label_48b1a8
        
        if ((sub_45be5c(arg1, &var_98, &var_f0, 0, "android/graphics/Bitmap", "getHeight", 0x452601)
                & 1) != 0)
            result = 0
        else
            x2_2 = var_f0
        label_48b1a8:
            int32_t x0_10 = (*(*arg1 + 0x198))(arg1, x0, x2_2, &var_90)
            
            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                result = 0
            else
                int64_t var_d8
                int64_t x2_4 = var_d8
                
                if (x2_4 != 0)
                    goto label_48b214
                
                int64_t var_a0
                
                if ((sub_45c03c(arg1, &var_a0, &var_d8, 1, "android/graphics/Bitmap$Config", 
                        "ARGB_8888", "Landroid/graphics/Bitmap$Config;") & 1) != 0)
                    result = 0
                else
                    x2_4 = var_d8
                label_48b214:
                    int64_t x0_16 = (*(*arg1 + 0x488))(arg1, var_a0, x2_4)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                        result = 0
                    else
                        int64_t var_f8
                        int64_t x2_6 = var_f8
                        
                        if (x2_6 != 0)
                            goto label_48b270
                        
                        if ((sub_45be5c(arg1, &var_98, &var_f8, 1, "android/graphics/Bitmap", 
                                "createBitmap", 
                                "(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;") & 1) != 0)
                            result = 0
                        else
                            x2_6 = var_f8
                        label_48b270:
                            var_90 = x0_4
                            int32_t var_88_1 = x0_10
                            int64_t var_80_1 = x0_16
                            result = (*(*arg1 + 0x3a0))(arg1, var_98, x2_6, &var_90)
                            
                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                result = 0
                            else
                                int64_t var_a8
                                int64_t x1_9 = var_a8
                                
                                if (x1_9 != 0)
                                    goto label_48b2e0
                                
                                if ((sub_45bc9c(arg1, &var_a8, "android/graphics/Canvas") & 1) != 0)
                                    result = 0
                                else
                                    x1_9 = var_a8
                                label_48b2e0:
                                    int64_t x0_28 = (*(*arg1 + 0xd8))(arg1, x1_9)
                                    
                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                        result = 0
                                    else if (x0_28 == 0)
                                        sub_45bac8(arg1, "java/lang/NullPointerException", 
                                            "NullPointerException")
                                        result = 0
                                    else
                                        int64_t var_100
                                        int64_t x2_8 = var_100
                                        
                                        if (x2_8 != 0)
                                            goto label_48b340
                                        
                                        if ((sub_45be5c(arg1, &var_a8, &var_100, 0, 
                                                "android/graphics/Canvas", "<init>", 
                                                "(Landroid/graphics/Bitmap;)V") & 1) != 0)
                                            result = 0
                                        else
                                            x2_8 = var_100
                                        label_48b340:
                                            var_90.q = result
                                            (*(*arg1 + 0x1f8))(arg1, x0_28, x2_8, &var_90)
                                            
                                            if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                result = 0
                                            else
                                                int64_t var_b0
                                                int64_t x1_13 = var_b0
                                                
                                                if (x1_13 != 0)
                                                    goto label_48b3a4
                                                
                                                if ((sub_45bc9c(arg1, &var_b0, 
                                                        "android/graphics/Paint") & 1) != 0)
                                                    result = 0
                                                else
                                                    x1_13 = var_b0
                                                label_48b3a4:
                                                    int64_t x0_39 = (*(*arg1 + 0xd8))(arg1, x1_13)
                                                    
                                                    if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                        result = 0
                                                    else
                                                        uint64_t x25_1 = x26
                                                        
                                                        if (x0_39 == 0)
                                                        label_48bb34:
                                                            sub_45bac8(arg1, 
                                                                "java/lang/NullPointerException", 
                                                                "NullPointerException")
                                                            result = 0
                                                            x26 = x25_1
                                                        else
                                                            int64_t var_108
                                                            int64_t x2_10 = var_108
                                                            
                                                            if (x2_10 != 0)
                                                                goto label_48b41c
                                                            
                                                            if ((sub_45be5c(arg1, &var_b0, 
                                                                    &var_108, 0, "android/graphics/Paint", 
                                                                    "<init>", "()V") & 1) != 0)
                                                                result = 0
                                                                x26 = x25_1
                                                            else
                                                                x2_10 = var_108
                                                            label_48b41c:
                                                                (*(*arg1 + 0x1f8))(arg1, x0_39, x2_10, 
                                                                    &var_90)
                                                                
                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                    result = 0
                                                                    x26 = x25_1
                                                                else
                                                                    int64_t var_b8
                                                                    int64_t x1_17 = var_b8
                                                                    
                                                                    if (x1_17 != 0)
                                                                        goto label_48b468
                                                                    
                                                                    if ((sub_45bc9c(arg1, &var_b8, 
                                                                            "android/graphics/Rect") & 1) != 0)
                                                                        result = 0
                                                                        x26 = x25_1
                                                                    else
                                                                        x1_17 = var_b8
                                                                    label_48b468:
                                                                        int64_t x0_50 =
                                                                            (*(*arg1 + 0xd8))(arg1, x1_17)
                                                                        
                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                            result = 0
                                                                            x26 = x25_1
                                                                        else
                                                                            int64_t x2_12 = var_e8
                                                                            
                                                                            if (x2_12 != 0)
                                                                                goto label_48b4d8
                                                                            
                                                                            if ((sub_45be5c(arg1, &var_98, &var_e8, 
                                                                                    0, "android/graphics/Bitmap", 
                                                                                    "getWidth", 0x452601) & 1) != 0)
                                                                                result = 0
                                                                                x26 = x25_1
                                                                            else
                                                                                x2_12 = var_e8
                                                                            label_48b4d8:
                                                                                int32_t x0_56 = (*(*arg1 + 0x198))(
                                                                                    arg1, x0, x2_12, &var_90)
                                                                                
                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                    result = 0
                                                                                    x26 = x25_1
                                                                                else
                                                                                    int64_t x2_14 = var_f0
                                                                                    
                                                                                    if (x2_14 != 0)
                                                                                        goto label_48b548
                                                                                    
                                                                                    if ((sub_45be5c(arg1, &var_98, &var_f0, 
                                                                                            0, "android/graphics/Bitmap", 
                                                                                            "getHeight", 0x452601) & 1) != 0)
                                                                                        result = 0
                                                                                        x26 = x25_1
                                                                                    else
                                                                                        x2_14 = var_f0
                                                                                    label_48b548:
                                                                                        int32_t x0_62 = (*(*arg1 + 0x198))(
                                                                                            arg1, x0, x2_14, &var_90)
                                                                                        
                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                            result = 0
                                                                                            x26 = x25_1
                                                                                        else
                                                                                            if (x0_50 == 0)
                                                                                                goto label_48bb34
                                                                                            
                                                                                            int64_t var_110
                                                                                            int64_t x2_16 = var_110
                                                                                            
                                                                                            if (x2_16 != 0)
                                                                                                goto label_48b5a8
                                                                                            
                                                                                            if ((sub_45be5c(arg1, &var_b8, 
                                                                                                    &var_110, 0, "android/graphics/Rect", 
                                                                                                    "<init>", "(IIII)V") & 1) != 0)
                                                                                                result = 0
                                                                                                x26 = x25_1
                                                                                            else
                                                                                                x2_16 = var_110
                                                                                            label_48b5a8:
                                                                                                var_90 = 0
                                                                                                int32_t var_88_2 = 0
                                                                                                var_80_1.d = x0_56
                                                                                                int32_t var_78_1 = x0_62
                                                                                                (*(*arg1 + 0x1f8))(arg1, x0_50, x2_16, 
                                                                                                    &var_90)
                                                                                                
                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                    result = 0
                                                                                                    x26 = x25_1
                                                                                                else
                                                                                                    int64_t var_c0
                                                                                                    int64_t x1_25 = var_c0
                                                                                                    
                                                                                                    if (x1_25 != 0)
                                                                                                        goto label_48b618
                                                                                                    
                                                                                                    if ((sub_45bc9c(arg1, &var_c0, 
                                                                                                            "android/graphics/RectF") & 1) != 0)
                                                                                                        result = 0
                                                                                                        x26 = x25_1
                                                                                                    else
                                                                                                        x1_25 = var_c0
                                                                                                    label_48b618:
                                                                                                        int64_t x0_73 =
                                                                                                            (*(*arg1 + 0xd8))(arg1, x1_25)
                                                                                                        
                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                            result = 0
                                                                                                            x26 = x25_1
                                                                                                        else
                                                                                                            if (x0_73 == 0)
                                                                                                                goto label_48bb34
                                                                                                            
                                                                                                            int64_t var_118
                                                                                                            int64_t x2_18 = var_118
                                                                                                            
                                                                                                            if (x2_18 != 0)
                                                                                                                goto label_48b678
                                                                                                            
                                                                                                            if ((sub_45be5c(arg1, &var_c0, 
                                                                                                                    &var_118, 0, "android/graphics/RectF", 
                                                                                                                    "<init>", "(Landroid/graphics/Rect;)V")
                                                                                                                    & 1) != 0)
                                                                                                                result = 0
                                                                                                                x26 = x25_1
                                                                                                            else
                                                                                                                x2_18 = var_118
                                                                                                            label_48b678:
                                                                                                                var_90.q = x0_50
                                                                                                                (*(*arg1 + 0x1f8))(arg1, x0_73, x2_18, 
                                                                                                                    &var_90)
                                                                                                                
                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                    result = 0
                                                                                                                    x26 = x25_1
                                                                                                                else
                                                                                                                    int64_t var_120
                                                                                                                    int64_t x2_20 = var_120
                                                                                                                    
                                                                                                                    if (x2_20 != 0)
                                                                                                                        goto label_48b6ec
                                                                                                                    
                                                                                                                    if ((sub_45be5c(arg1, &var_b0, 
                                                                                                                            &var_120, 0, "android/graphics/Paint", 
                                                                                                                            "setAntiAlias", "(Z)V") & 1) != 0)
                                                                                                                        result = 0
                                                                                                                        x26 = x25_1
                                                                                                                    else
                                                                                                                        x2_20 = var_120
                                                                                                                    label_48b6ec:
                                                                                                                        var_90.b = 1
                                                                                                                        (*(*arg1 + 0x1f8))(arg1, x0_39, x2_20, 
                                                                                                                            &var_90)
                                                                                                                        
                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                            result = 0
                                                                                                                            x26 = x25_1
                                                                                                                        else
                                                                                                                            int64_t var_128
                                                                                                                            int64_t x2_22 = var_128
                                                                                                                            
                                                                                                                            if (x2_22 != 0)
                                                                                                                                goto label_48b75c
                                                                                                                            
                                                                                                                            if ((sub_45be5c(arg1, &var_a8, 
                                                                                                                                    &var_128, 0, "android/graphics/Canvas", 
                                                                                                                                    "drawARGB", "(IIII)V") & 1) != 0)
                                                                                                                                result = 0
                                                                                                                                x26 = x25_1
                                                                                                                            else
                                                                                                                                x2_22 = var_128
                                                                                                                            label_48b75c:
                                                                                                                                var_90 = 0
                                                                                                                                int32_t var_88_3 = 0
                                                                                                                                var_80_1.d = 0
                                                                                                                                int32_t var_78_2 = 0
                                                                                                                                (*(*arg1 + 0x1f8))(arg1, x0_28, x2_22, 
                                                                                                                                    &var_90)
                                                                                                                                
                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                    result = 0
                                                                                                                                    x26 = x25_1
                                                                                                                                else
                                                                                                                                    int64_t var_130
                                                                                                                                    int64_t x2_24 = var_130
                                                                                                                                    
                                                                                                                                    if (x2_24 != 0)
                                                                                                                                        goto label_48b7e0
                                                                                                                                    
                                                                                                                                    if ((sub_45be5c(arg1, &var_b0, 
                                                                                                                                            &var_130, 0, "android/graphics/Paint", 
                                                                                                                                            "setColor", "(I)V") & 1) != 0)
                                                                                                                                        result = 0
                                                                                                                                        x26 = x25_1
                                                                                                                                    else
                                                                                                                                        x2_24 = var_130
                                                                                                                                    label_48b7e0:
                                                                                                                                        var_90 = 0xff424242
                                                                                                                                        (*(*arg1 + 0x1f8))(arg1, x0_39, x2_24, 
                                                                                                                                            &var_90)
                                                                                                                                        
                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                            result = 0
                                                                                                                                            x26 = x25_1
                                                                                                                                        else
                                                                                                                                            int64_t var_138
                                                                                                                                            int64_t x2_26 = var_138
                                                                                                                                            
                                                                                                                                            if (x2_26 != 0)
                                                                                                                                                goto label_48b850
                                                                                                                                            
                                                                                                                                            if ((sub_45be5c(arg1, &var_a8, 
                                                                                                                                                    &var_138, 0, "android/graphics/Canvas", 
                                                                                                                                                    "drawRoundRect", 
                                                                                                                                                    "(Landroid/graphics/RectF;"
                                                                                                                                            "FFLandroid/graphics/Paint;)V") & 1)
                                                                                                                                                    != 0)
                                                                                                                                                result = 0
                                                                                                                                                x26 = x25_1
                                                                                                                                            else
                                                                                                                                                x2_26 = var_138
                                                                                                                                            label_48b850:
                                                                                                                                                float v0_1 = float.s(arg4)
                                                                                                                                                var_90.q = x0_73
                                                                                                                                                float var_88_4 = v0_1
                                                                                                                                                var_80_1.d = v0_1
                                                                                                                                                var_78_2.q = x0_39
                                                                                                                                                (*(*arg1 + 0x1f8))(arg1, x0_28, x2_26, 
                                                                                                                                                    &var_90)
                                                                                                                                                
                                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                    result = 0
                                                                                                                                                    x26 = x25_1
                                                                                                                                                else
                                                                                                                                                    int64_t var_c8
                                                                                                                                                    int64_t x1_37 = var_c8
                                                                                                                                                    
                                                                                                                                                    if (x1_37 != 0)
                                                                                                                                                        goto label_48b8c4
                                                                                                                                                    
                                                                                                                                                    if ((sub_45bc9c(arg1, &var_c8, 
                                                                                                                                                            "android/graphics/PorterDuffXfermode")
                                                                                                                                                            & 1) != 0)
                                                                                                                                                        result = 0
                                                                                                                                                        x26 = x25_1
                                                                                                                                                    else
                                                                                                                                                        x1_37 = var_c8
                                                                                                                                                    label_48b8c4:
                                                                                                                                                        int64_t x0_104 =
                                                                                                                                                            (*(*arg1 + 0xd8))(arg1, x1_37)
                                                                                                                                                        
                                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                            result = 0
                                                                                                                                                            x26 = x25_1
                                                                                                                                                        else
                                                                                                                                                            int64_t var_e0
                                                                                                                                                            int64_t x2_28 = var_e0
                                                                                                                                                            
                                                                                                                                                            if (x2_28 != 0)
                                                                                                                                                                goto label_48b930
                                                                                                                                                            
                                                                                                                                                            int64_t var_d0
                                                                                                                                                            
                                                                                                                                                            if ((sub_45c03c(arg1, &var_d0, &var_e0, 
                                                                                                                                                                    1, "android/graphics/PorterDuff$Mode", 
                                                                                                                                                                    "SRC_IN", 
                                                                                                                                                                    "Landroid/graphics/PorterDuff$Mode;")
                                                                                                                                                                    & 1) != 0)
                                                                                                                                                                result = 0
                                                                                                                                                                x26 = x25_1
                                                                                                                                                            else
                                                                                                                                                                x2_28 = var_e0
                                                                                                                                                            label_48b930:
                                                                                                                                                                int64_t x0_110 =
                                                                                                                                                                    (*(*arg1 + 0x488))(arg1, var_d0, x2_28)
                                                                                                                                                                
                                                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                                    result = 0
                                                                                                                                                                    x26 = x25_1
                                                                                                                                                                else
                                                                                                                                                                    if (x0_104 == 0)
                                                                                                                                                                        goto label_48bb34
                                                                                                                                                                    
                                                                                                                                                                    int64_t var_140
                                                                                                                                                                    int64_t x2_30 = var_140
                                                                                                                                                                    
                                                                                                                                                                    if (x2_30 != 0)
                                                                                                                                                                        goto label_48b990
                                                                                                                                                                    
                                                                                                                                                                    if ((sub_45be5c(arg1, &var_c8, 
                                                                                                                                                                            &var_140, 0, 
                                                                                                                                                                            "android/graphics/PorterDuffXfermode", 
                                                                                                                                                                            "<init>", 
                                                                                                                                                                            "(Landroid/graphics/PorterDuff$Mode;)V")
                                                                                                                                                                            & 1) != 0)
                                                                                                                                                                        result = 0
                                                                                                                                                                        x26 = x25_1
                                                                                                                                                                    else
                                                                                                                                                                        x2_30 = var_140
                                                                                                                                                                    label_48b990:
                                                                                                                                                                        var_90.q = x0_110
                                                                                                                                                                        (*(*arg1 + 0x1f8))(arg1, x0_104, x2_30, 
                                                                                                                                                                            &var_90)
                                                                                                                                                                        
                                                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                                            result = 0
                                                                                                                                                                            x26 = x25_1
                                                                                                                                                                        else
                                                                                                                                                                            int64_t var_148
                                                                                                                                                                            int64_t x2_32 = var_148
                                                                                                                                                                            
                                                                                                                                                                            if (x2_32 != 0)
                                                                                                                                                                                goto label_48ba00
                                                                                                                                                                            
                                                                                                                                                                            if ((sub_45be5c(arg1, &var_b0, 
                                                                                                                                                                                    &var_148, 0, "android/graphics/Paint", 
                                                                                                                                                                                    "setXfermode", 
                                                                                                                                                                                    "(Landroid/graphics/Xfermode;"
                                                                                                                                                                            ")Landroid/graphics/Xfermode;") & 1)
                                                                                                                                                                                    != 0)
                                                                                                                                                                                result = 0
                                                                                                                                                                                x26 = x25_1
                                                                                                                                                                            else
                                                                                                                                                                                x2_32 = var_148
                                                                                                                                                                            label_48ba00:
                                                                                                                                                                                var_90.q = x0_104
                                                                                                                                                                                int64_t x0_121 = (*(*arg1 + 0x120))(
                                                                                                                                                                                    arg1, x0_39, x2_32, &var_90)
                                                                                                                                                                                
                                                                                                                                                                                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                                                    result = 0
                                                                                                                                                                                    x26 = x25_1
                                                                                                                                                                                else
                                                                                                                                                                                    if (x0_121 != 0)
                                                                                                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_121)
                                                                                                                                                                                    
                                                                                                                                                                                    int64_t x2_35 = var_150
                                                                                                                                                                                    
                                                                                                                                                                                    if (x2_35 != 0)
                                                                                                                                                                                        goto label_48ba90
                                                                                                                                                                                    
                                                                                                                                                                                    x26 = x25_1
                                                                                                                                                                                    
                                                                                                                                                                                    if ((sub_45be5c(arg1, &var_a8, 
                                                                                                                                                                                            &var_150, 0, "android/graphics/Canvas", 
                                                                                                                                                                                            "drawBitmap", 
                                                                                                                                                                                            "(Landroid/graphics/Bitmap;"
                                                                                                                                                                                    "Landroid/graphics/Rect;"
                                                                                                                                                                                    "Landroid/graphics/Rect;"
                                                                                                                                                                                    "Landroid/graphics/Paint;)V") & 1) != 0)
                                                                                                                                                                                        result = 0
                                                                                                                                                                                    else
                                                                                                                                                                                        x2_35 = var_150
                                                                                                                                                                                    label_48ba90:
                                                                                                                                                                                        var_90.q = x0
                                                                                                                                                                                        var_88_4.q = x0_50
                                                                                                                                                                                        int64_t var_80_2 = x0_50
                                                                                                                                                                                        var_78_2.q = x0_39
                                                                                                                                                                                        (*(*arg1 + 0x1f8))(arg1, x0_28, x2_35, 
                                                                                                                                                                                            &var_90)
                                                                                                                                                                                        x26 = x25_1
                                                                                                                                                                                        
                                                                                                                                                                                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                                                                                                                                                                                            result = 0

if (*(x26 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
