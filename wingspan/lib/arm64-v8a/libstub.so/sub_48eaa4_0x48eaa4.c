// 函数: sub_48eaa4
// 地址: 0x48eaa4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x25 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x25 + 0x28)
int64_t var_118
__builtin_memset(&var_118, 0, 0xb0)
int64_t x0 = (*(*arg1 + 0xc8))()
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg3)
int64_t x0_4 = (*(*arg1 + 0xc8))(arg1, x0)
int64_t var_b8
int64_t var_70
int32_t result =
    sub_45be5c(arg1, &var_70, &var_b8, 1, "com/cb", "a", "(Landroid/content/Context;)V")

if ((result & 1) == 0)
    int64_t var_68 = x0_4
    (*(*arg1 + 0x478))(arg1, var_70, var_b8, &var_68)
    result = (*(*arg1 + 0x720))(arg1)
    
    if ((result & 0xff) == 0)
        int64_t var_c0
        int64_t x2_2 = var_c0
        
        if (x2_2 != 0)
            goto label_48ebe8
        
        int64_t var_78
        result = sub_45be5c(arg1, &var_78, &var_c0, 1, "apkvision/sVMbOPAtE", "krjUyALI", 
            "(Landroid/app/Activity;)V")
        
        if ((result & 1) == 0)
            x2_2 = var_c0
        label_48ebe8:
            var_68 = x0
            (*(*arg1 + 0x478))(arg1, var_78, x2_2, &var_68)
            result = (*(*arg1 + 0x720))(arg1)
            
            if ((result & 0xff) == 0)
                int64_t var_c8
                int64_t x2_4 = var_c8
                
                if (x2_4 != 0)
                    goto label_48ec58
                
                int64_t var_80
                result = sub_45be5c(arg1, &var_80, &var_c8, 1, "apkvision/YnLbgyrEk", "vPoUAvVoP", 
                    "(Landroid/content/Context;)V")
                
                if ((result & 1) == 0)
                    x2_4 = var_c8
                label_48ec58:
                    var_68 = x0
                    (*(*arg1 + 0x478))(arg1, var_80, x2_4, &var_68)
                    result = (*(*arg1 + 0x720))(arg1)
                    
                    if ((result & 0xff) == 0)
                        int64_t var_d0
                        int64_t x2_6 = var_d0
                        
                        if (x2_6 != 0)
                            goto label_48ecc8
                        
                        int64_t var_88
                        result = sub_45be5c(arg1, &var_88, &var_d0, 1, 
                            "androidx/loader/app/services/l", 0x4519e5, "(Ljava/lang/Object;)V")
                        
                        if ((result & 1) == 0)
                            x2_6 = var_d0
                        label_48ecc8:
                            var_68 = x0
                            (*(*arg1 + 0x478))(arg1, var_88, x2_6, &var_68)
                            result = (*(*arg1 + 0x720))(arg1)
                            
                            if ((result & 0xff) == 0)
                                if (x0 == 0)
                                    result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                                        "NullPointerException")
                                else
                                    int64_t var_d8
                                    int64_t x2_8 = var_d8
                                    
                                    if (x2_8 != 0)
                                        goto label_48ed6c
                                    
                                    int64_t var_90
                                    result = sub_45be5c(arg1, &var_90, &var_d8, 0, 
                                        "com/unity3d/player/UnityPlayerActivity", 
                                        "requestWindowFeature", "(I)Z")
                                    
                                    if ((result & 1) == 0)
                                        x2_8 = var_d8
                                    label_48ed6c:
                                        var_68.d = 1
                                        (*(*arg1 + 0x138))(arg1, x0, x2_8, &var_68)
                                        result = (*(*arg1 + 0x720))(arg1)
                                        
                                        if ((result & 0xff) == 0)
                                            int64_t var_e0
                                            int64_t x3_6 = var_e0
                                            
                                            if (x3_6 != 0)
                                                goto label_48edd8
                                            
                                            int64_t var_98
                                            result = sub_45be5c(arg1, &var_98, &var_e0, x3_6.d, 
                                                "android/app/Activity", "onCreate", 
                                                "(Landroid/os/Bundle;)V")
                                            
                                            if ((result & 1) == 0)
                                                x3_6 = var_e0
                                            label_48edd8:
                                                var_68 = x0_2
                                                (*(*arg1 + 0x2e8))(arg1, x0, var_98, x3_6, &var_68)
                                                result = (*(*arg1 + 0x720))(arg1)
                                                
                                                if ((result & 0xff) == 0)
                                                    int64_t var_e8
                                                    int64_t x2_12 = var_e8
                                                    
                                                    if (x2_12 != 0)
                                                        goto label_48ee60
                                                    
                                                    result = sub_45be5c(arg1, &var_90, &var_e8, 0, 
                                                        "com/unity3d/player/UnityPlayerActivity", 
                                                        "getIntent", "()Landroid/content/Intent;")
                                                    
                                                    if ((result & 1) == 0)
                                                        x2_12 = var_e8
                                                    label_48ee60:
                                                        int64_t x0_25 = (*(*arg1 + 0x120))(arg1, 
                                                            x0, x2_12, &var_68)
                                                        result = (*(*arg1 + 0x720))(arg1)
                                                        
                                                        if ((result & 0xff) == 0)
                                                            if (x0_2 != 0)
                                                                (*(*arg1 + 0xb8))(arg1, x0_2)
                                                            
                                                            if (x0_4 != 0)
                                                                (*(*arg1 + 0xb8))(arg1, x0_4)
                                                            
                                                            int64_t x0_30 =
                                                                (*(*arg1 + 0x538))(arg1, "unity")
                                                            
                                                            if (x0_25 == 0)
                                                                result = sub_45bac8(arg1, 
                                                                    "java/lang/NullPointerException", 
                                                                    "NullPointerException")
                                                            else
                                                                int64_t var_f0
                                                                int64_t x2_14 = var_f0
                                                                
                                                                if (x2_14 != 0)
                                                                    goto label_48ef0c
                                                                
                                                                int64_t var_a0
                                                                result = sub_45be5c(arg1, &var_a0, 
                                                                    &var_f0, 0, "android/content/Intent", 
                                                                    "getStringExtra", 
                                                                    "
                                                                        (Ljava/lang/String;)Ljava/lang/String;")
                                                                
                                                                if ((result & 1) == 0)
                                                                    x2_14 = var_f0
                                                                label_48ef0c:
                                                                    var_68 = x0_30
                                                                    int64_t x0_33 = (*(*arg1 + 0x120))(
                                                                        arg1, x0_25, x2_14, &var_68)
                                                                    result = (*(*arg1 + 0x720))(arg1)
                                                                    
                                                                    if ((result & 0xff) == 0)
                                                                        (*(*arg1 + 0xb8))(arg1, x0_25)
                                                                        int64_t var_f8
                                                                        int64_t x2_16 = var_f8
                                                                        
                                                                        if (x2_16 != 0)
                                                                            goto label_48ef94
                                                                        
                                                                        result = sub_45be5c(arg1, &var_90, 
                                                                            &var_f8, 0, 
                                                                            "com/unity3d/player/UnityPlayerActivity", 
                                                                            "updateUnityCommandLineArguments", 
                                                                            "
                                                                                (Ljava/lang/String;)Ljava/lang/String;")
                                                                        
                                                                        if ((result & 1) == 0)
                                                                            x2_16 = var_f8
                                                                        label_48ef94:
                                                                            var_68 = x0_33
                                                                            int64_t x0_38 = (*(*arg1 + 0x120))(
                                                                                arg1, x0, x2_16, &var_68)
                                                                            result = (*(*arg1 + 0x720))(arg1)
                                                                            
                                                                            if ((result & 0xff) == 0)
                                                                                if (x0_33 != 0)
                                                                                    (*(*arg1 + 0xb8))(arg1, x0_33)
                                                                                
                                                                                int64_t x2_19 = var_e8
                                                                                
                                                                                if (x2_19 != 0)
                                                                                    goto label_48f034
                                                                                
                                                                                result = sub_45be5c(arg1, &var_90, 
                                                                                    &var_e8, 0, 
                                                                                    "com/unity3d/player/UnityPlayerActivity", 
                                                                                    "getIntent", 
                                                                                    "()Landroid/content/Intent;")
                                                                                
                                                                                if ((result & 1) == 0)
                                                                                    x2_19 = var_e8
                                                                                label_48f034:
                                                                                    int64_t x0_43 = (*(*arg1 + 0x120))(
                                                                                        arg1, x0, x2_19, &var_68)
                                                                                    result = (*(*arg1 + 0x720))(arg1)
                                                                                    
                                                                                    if ((result & 0xff) == 0)
                                                                                        if (x0_43 == 0)
                                                                                            result = sub_45bac8(arg1, 
                                                                                                "java/lang/NullPointerException", 
                                                                                                "NullPointerException")
                                                                                        else
                                                                                            int64_t var_100
                                                                                            int64_t x2_20 = var_100
                                                                                            
                                                                                            if (x2_20 != 0)
                                                                                                goto label_48f094
                                                                                            
                                                                                            result = sub_45be5c(arg1, &var_a0, 
                                                                                                &var_100, 0, "android/content/Intent", 
                                                                                                "putExtra", 
                                                                                                "(Ljava/lang/String;Ljava/lang/String;"
                                                                                            ")Landroid/content/Intent;")
                                                                                            
                                                                                            if ((result & 1) == 0)
                                                                                                x2_20 = var_100
                                                                                            label_48f094:
                                                                                                var_68 = x0_30
                                                                                                int64_t var_60_1 = x0_38
                                                                                                int64_t x0_47 = (*(*arg1 + 0x120))(
                                                                                                    arg1, x0_43, x2_20, &var_68)
                                                                                                result = (*(*arg1 + 0x720))(arg1)
                                                                                                
                                                                                                if ((result & 0xff) == 0)
                                                                                                    if (x0_47 != 0)
                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_47)
                                                                                                    
                                                                                                    if (x0_38 != 0)
                                                                                                        (*(*arg1 + 0xb8))(arg1, x0_38)
                                                                                                    
                                                                                                    int64_t var_a8
                                                                                                    int64_t x1_31 = var_a8
                                                                                                    
                                                                                                    if (x1_31 != 0)
                                                                                                        goto label_48f12c
                                                                                                    
                                                                                                    result = sub_45bc9c(arg1, &var_a8, 
                                                                                                        "com/unity3d/player/UnityPlayer")
                                                                                                    
                                                                                                    if ((result & 1) == 0)
                                                                                                        x1_31 = var_a8
                                                                                                    label_48f12c:
                                                                                                        int64_t x0_53 =
                                                                                                            (*(*arg1 + 0xd8))(arg1, x1_31)
                                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                                        
                                                                                                        if ((result & 0xff) == 0)
                                                                                                            if (x0_53 == 0)
                                                                                                                result = sub_45bac8(arg1, 
                                                                                                                    "java/lang/NullPointerException", 
                                                                                                                    "NullPointerException")
                                                                                                            else
                                                                                                                int64_t var_108
                                                                                                                int64_t x2_22 = var_108
                                                                                                                
                                                                                                                if (x2_22 != 0)
                                                                                                                    goto label_48f18c
                                                                                                                
                                                                                                                result = sub_45be5c(arg1, &var_a8, 
                                                                                                                    &var_108, 0, 
                                                                                                                    "com/unity3d/player/UnityPlayer", 
                                                                                                                    "<init>", 
                                                                                                                    "(Landroid/content/Context;"
                                                                                                                "Lcom/unity3d/player/IUnityPlayerLifecycleEvents;"
                                                                                                                ")V")
                                                                                                                
                                                                                                                if ((result & 1) == 0)
                                                                                                                    x2_22 = var_108
                                                                                                                label_48f18c:
                                                                                                                    var_68 = x0
                                                                                                                    int64_t var_60_2 = x0
                                                                                                                    (*(*arg1 + 0x1f8))(arg1, x0_53, x2_22, 
                                                                                                                        &var_68)
                                                                                                                    result = (*(*arg1 + 0x720))(arg1)
                                                                                                                    
                                                                                                                    if ((result & 0xff) == 0)
                                                                                                                        int64_t var_b0
                                                                                                                        int64_t x2_24 = var_b0
                                                                                                                        
                                                                                                                        if (x2_24 != 0)
                                                                                                                            goto label_48f210
                                                                                                                        
                                                                                                                        result = sub_45c03c(arg1, &var_90, 
                                                                                                                            &var_b0, 0, 
                                                                                                                            "com/unity3d/player/UnityPlayerActivity", 
                                                                                                                            "mUnityPlayer", 
                                                                                                                            "Lcom/unity3d/player/UnityPlayer;")
                                                                                                                        
                                                                                                                        if ((result & 1) == 0)
                                                                                                                            x2_24 = var_b0
                                                                                                                        label_48f210:
                                                                                                                            (*(*arg1 + 0x340))(arg1, x0, x2_24, 
                                                                                                                                x0_53)
                                                                                                                            result = (*(*arg1 + 0x720))(arg1)
                                                                                                                            
                                                                                                                            if ((result & 0xff) == 0)
                                                                                                                                int64_t var_110
                                                                                                                                int64_t x2_26 = var_110
                                                                                                                                
                                                                                                                                if (x2_26 != 0)
                                                                                                                                    goto label_48f268
                                                                                                                                
                                                                                                                                result = sub_45be5c(arg1, &var_90, 
                                                                                                                                    &var_110, 0, 
                                                                                                                                    "com/unity3d/player/UnityPlayerActivity", 
                                                                                                                                    "setContentView", 
                                                                                                                                    "(Landroid/view/View;)V")
                                                                                                                                
                                                                                                                                if ((result & 1) == 0)
                                                                                                                                    x2_26 = var_110
                                                                                                                                label_48f268:
                                                                                                                                    var_68 = x0_53
                                                                                                                                    (*(*arg1 + 0x1f8))(arg1, x0, x2_26, 
                                                                                                                                        &var_68)
                                                                                                                                    result = (*(*arg1 + 0x720))(arg1)
                                                                                                                                    
                                                                                                                                    if ((result & 0xff) == 0)
                                                                                                                                        int64_t x2_28 = var_b0
                                                                                                                                        
                                                                                                                                        if (x2_28 != 0)
                                                                                                                                            goto label_48f2e8
                                                                                                                                        
                                                                                                                                        result = sub_45c03c(arg1, &var_90, 
                                                                                                                                            &var_b0, 0, 
                                                                                                                                            "com/unity3d/player/UnityPlayerActivity", 
                                                                                                                                            "mUnityPlayer", 
                                                                                                                                            "Lcom/unity3d/player/UnityPlayer;")
                                                                                                                                        
                                                                                                                                        if ((result & 1) == 0)
                                                                                                                                            x2_28 = var_b0
                                                                                                                                        label_48f2e8:
                                                                                                                                            int64_t x0_66 =
                                                                                                                                                (*(*arg1 + 0x2f8))(arg1, x0, x2_28)
                                                                                                                                            result = (*(*arg1 + 0x720))(arg1)
                                                                                                                                            
                                                                                                                                            if ((result & 0xff) == 0)
                                                                                                                                                (*(*arg1 + 0xb8))(arg1, x0_53)
                                                                                                                                                
                                                                                                                                                if (x0_66 == 0)
                                                                                                                                                    result = sub_45bac8(arg1, 
                                                                                                                                                        "java/lang/NullPointerException", 
                                                                                                                                                        "NullPointerException")
                                                                                                                                                else
                                                                                                                                                    int64_t x2_30 = var_118
                                                                                                                                                    
                                                                                                                                                    if (x2_30 != 0)
                                                                                                                                                        (*(*arg1 + 0x138))(arg1, x0_66, x2_30, 
                                                                                                                                                            &var_68)
                                                                                                                                                        result = (*(*arg1 + 0x720))(arg1)
                                                                                                                                                    else
                                                                                                                                                        result = sub_45be5c(arg1, &var_a8, 
                                                                                                                                                            &var_118, 0, 
                                                                                                                                                            "com/unity3d/player/UnityPlayer", 
                                                                                                                                                            "requestFocus", "()Z")
                                                                                                                                                        
                                                                                                                                                        if ((result & 1) == 0)
                                                                                                                                                            (*(*arg1 + 0x138))(arg1, x0_66, 
                                                                                                                                                                var_118, &var_68)
                                                                                                                                                            result = (*(*arg1 + 0x720))(arg1)

if (*(x25 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
