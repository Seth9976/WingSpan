// 函数: sub_48f3a8
// 地址: 0x48f3a8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int64_t var_70
__builtin_memset(&var_70, 0, 0x30)
int64_t x0 = (*(*arg1 + 0xc8))()
int32_t result

if (x0 == 0)
    result = sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
else
    int64_t var_60
    int64_t var_48
    result = sub_45c03c(arg1, &var_48, &var_60, 0, "com/unity3d/player/UnityPlayerActivity", 
        "mUnityPlayer", "Lcom/unity3d/player/UnityPlayer;")
    
    if ((result & 1) == 0)
        int64_t x0_3 = (*(*arg1 + 0x2f8))(arg1, x0, var_60)
        result = (*(*arg1 + 0x720))(arg1)
        
        if ((result & 0xff) == 0)
            if (x0_3 == 0)
                result = sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
            else
                int64_t var_68
                int64_t x2_3 = var_68
                
                if (x2_3 != 0)
                    goto label_48f4a8
                
                int64_t var_50
                result = sub_45be5c(arg1, &var_50, &var_68, 0, "com/unity3d/player/UnityPlayer", 
                    "destroy", "()V")
                
                if ((result & 1) == 0)
                    x2_3 = var_68
                label_48f4a8:
                    void var_40
                    (*(*arg1 + 0x1f8))(arg1, x0_3, x2_3, &var_40)
                    result = (*(*arg1 + 0x720))(arg1)
                    
                    if ((result & 0xff) == 0)
                        int64_t x3_2 = var_70
                        int64_t var_58
                        
                        if (x3_2 != 0)
                            (*(*arg1 + 0x2e8))(arg1, x0, var_58, x3_2, &var_40)
                            result = (*(*arg1 + 0x720))(arg1)
                        else
                            result = sub_45be5c(arg1, &var_58, &var_70, x3_2.d, 
                                "android/app/Activity", "onDestroy", "()V")
                            
                            if ((result & 1) == 0)
                                (*(*arg1 + 0x2e8))(arg1, x0, var_58, var_70, &var_40)
                                result = (*(*arg1 + 0x720))(arg1)

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
