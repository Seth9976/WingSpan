// 函数: sub_48fdd8
// 地址: 0x48fdd8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
int64_t var_70
__builtin_memset(&var_70, 0, 0x30)
int64_t x0 = (*(*arg1 + 0xc8))()
int32_t result

if (x0 == 0)
    result = sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
else
    int64_t var_68
    int64_t var_48
    result = sub_45be5c(arg1, &var_48, &var_68, 0, "android/app/Activity", "onPause", "()V")
    
    if ((result & 1) == 0)
        void var_40
        (*(*arg1 + 0x2e8))(arg1, x0, var_48, var_68, &var_40)
        result = (*(*arg1 + 0x720))(arg1)
        
        if ((result & 0xff) == 0)
            int64_t var_60
            int64_t x2_3 = var_60
            
            if (x2_3 != 0)
                goto label_48fed4
            
            int64_t var_50
            result = sub_45c03c(arg1, &var_50, &var_60, 0, 
                "com/unity3d/player/UnityPlayerActivity", "mUnityPlayer", 
                "Lcom/unity3d/player/UnityPlayer;")
            
            if ((result & 1) == 0)
                x2_3 = var_60
            label_48fed4:
                int64_t x0_6 = (*(*arg1 + 0x2f8))(arg1, x0, x2_3)
                result = (*(*arg1 + 0x720))(arg1)
                
                if ((result & 0xff) == 0)
                    if (x0_6 == 0)
                        result = sub_45bac8(arg1, "java/lang/NullPointerException", 
                            "NullPointerException")
                    else
                        int64_t x2_5 = var_70
                        
                        if (x2_5 != 0)
                            (*(*arg1 + 0x1f8))(arg1, x0_6, x2_5, &var_40)
                            result = (*(*arg1 + 0x720))(arg1)
                        else
                            int64_t var_58
                            result = sub_45be5c(arg1, &var_58, &var_70, 0, 
                                "com/unity3d/player/UnityPlayer", "onPause", "()V")
                            
                            if ((result & 1) == 0)
                                (*(*arg1 + 0x1f8))(arg1, x0_6, var_70, &var_40)
                                result = (*(*arg1 + 0x720))(arg1)

if (*(x21 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
