// 函数: sub_48e620
// 地址: 0x48e620
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_90
__builtin_memset(&var_90, 0, 0x40)
int64_t x0 = (*(*arg1 + 0xc8))()
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg3)
int32_t x22_1

if (x0_2 == 0)
    sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
    x22_1 = 0
else
    x22_1 = 0
    int64_t var_80
    int64_t var_58
    
    if ((sub_45be5c(arg1, &var_58, &var_80, 0, "android/view/KeyEvent", "getAction", 0x452601) & 1)
            == 0)
        int64_t var_50
        int32_t x0_6 = (*(*arg1 + 0x198))(arg1, x0_2, var_80, &var_50)
        
        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
            x22_1 = 0
        else if (x0_6 != 2)
            if (x0 == 0)
                sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                x22_1 = 0
            else
                int64_t x3_3 = var_90
                
                if (x3_3 != 0)
                    goto label_48e82c
                
                x22_1 = 0
                int64_t var_70
                
                if ((sub_45be5c(arg1, &var_70, &var_90, x3_3.d, "android/app/Activity", 
                        "dispatchKeyEvent", "(Landroid/view/KeyEvent;)Z") & 1) == 0)
                    x3_3 = var_90
                label_48e82c:
                    var_50 = x0_2
                    int32_t x0_24 = (*(*arg1 + 0x228))(arg1, x0, var_70, x3_3, &var_50)
                    
                    if (zx.d((*(*arg1 + 0x720))(arg1)) == 0)
                        x22_1 = x0_24
                    else
                        x22_1 = 0
        else if (x0 == 0)
            sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
            x22_1 = 0
        else
            int64_t var_78
            int64_t x2_2 = var_78
            
            if (x2_2 != 0)
                goto label_48e750
            
            x22_1 = 0
            int64_t var_60
            
            if ((sub_45c03c(arg1, &var_60, &var_78, 0, "com/unity3d/player/UnityPlayerActivity", 
                    "mUnityPlayer", "Lcom/unity3d/player/UnityPlayer;") & 1) == 0)
                x2_2 = var_78
            label_48e750:
                int64_t x0_12 = (*(*arg1 + 0x2f8))(arg1, x0, x2_2)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    x22_1 = 0
                else if (x0_12 == 0)
                    sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
                    x22_1 = 0
                else
                    int64_t var_88
                    int64_t x2_4 = var_88
                    
                    if (x2_4 != 0)
                        goto label_48e7b0
                    
                    int64_t var_68
                    
                    if ((sub_45be5c(arg1, &var_68, &var_88, 0, "com/unity3d/player/UnityPlayer", 
                            "injectEvent", "(Landroid/view/InputEvent;)Z") & 1) != 0)
                        x22_1 = 0
                    else
                        x2_4 = var_88
                    label_48e7b0:
                        var_50 = x0_2
                        x22_1 = (*(*arg1 + 0x138))(arg1, x0_12, x2_4, &var_50)
                        
                        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                            x22_1 = 0

if (*(x23 + 0x28) == x8)
    return zx.q(x22_1)

__stack_chk_fail()
noreturn
