// 函数: sub_48fbf4
// 地址: 0x48fbf4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_68
__builtin_memset(&var_68, 0, 0x28)
int64_t x0 = (*(*arg1 + 0xc8))()
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg3)
int32_t result

if (x0 == 0)
    result = sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
else
    int64_t var_60
    int64_t var_48
    result = sub_45be5c(arg1, &var_48, &var_60, 0, "com/unity3d/player/UnityPlayerActivity", 
        "setIntent", "(Landroid/content/Intent;)V")
    
    if ((result & 1) == 0)
        int64_t var_40 = x0_2
        (*(*arg1 + 0x1f8))(arg1, x0, var_60, &var_40)
        result = (*(*arg1 + 0x720))(arg1)
        
        if ((result & 0xff) == 0)
            int64_t var_58
            int64_t x2_2 = var_58
            
            if (x2_2 != 0)
                goto label_48fd08
            
            result = sub_45c03c(arg1, &var_48, &var_58, 0, 
                "com/unity3d/player/UnityPlayerActivity", "mUnityPlayer", 
                "Lcom/unity3d/player/UnityPlayer;")
            
            if ((result & 1) == 0)
                x2_2 = var_58
            label_48fd08:
                int64_t x0_8 = (*(*arg1 + 0x2f8))(arg1, x0, x2_2)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    if (x0_8 == 0)
                        result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                            "NullPointerException")
                    else
                        int64_t x2_4 = var_68
                        
                        if (x2_4 != 0)
                            goto label_48fd68
                        
                        int64_t var_50
                        result = sub_45be5c(arg1, &var_50, &var_68, 0, 
                            "com/unity3d/player/UnityPlayer", "newIntent", 
                            "(Landroid/content/Intent;)V")
                        
                        if ((result & 1) == 0)
                            x2_4 = var_68
                        label_48fd68:
                            var_40 = x0_2
                            (*(*arg1 + 0x1f8))(arg1, x0_8, x2_4, &var_40)
                            result = (*(*arg1 + 0x720))(arg1)

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
