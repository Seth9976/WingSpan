// 函数: sub_48f56c
// 地址: 0x48f56c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int64_t var_70
__builtin_memset(&var_70, 0, 0x20)
int64_t x0 = (*(*arg1 + 0xc8))()
int64_t x0_2 = (*(*arg1 + 0xc8))(arg1, arg3)
int32_t x22_1

if (x0 == 0)
    sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
    x22_1 = 0
else
    x22_1 = 0
    int64_t var_68
    int64_t var_58
    
    if ((sub_45c03c(arg1, &var_58, &var_68, 0, "com/unity3d/player/UnityPlayerActivity", 
            "mUnityPlayer", "Lcom/unity3d/player/UnityPlayer;") & 1) == 0)
        int64_t x0_6 = (*(*arg1 + 0x2f8))(arg1, x0, var_68)
        
        if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
            x22_1 = 0
        else if (x0_6 == 0)
            sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
            x22_1 = 0
        else
            int64_t x2_2 = var_70
            
            if (x2_2 != 0)
                goto label_48f674
            
            int64_t var_60
            
            if ((sub_45be5c(arg1, &var_60, &var_70, 0, "com/unity3d/player/UnityPlayer", 
                    "onGenericMotionEvent", "(Landroid/view/MotionEvent;)Z") & 1) != 0)
                x22_1 = 0
            else
                x2_2 = var_70
            label_48f674:
                int64_t var_50 = x0_2
                x22_1 = (*(*arg1 + 0x138))(arg1, x0_6, x2_2, &var_50)
                
                if (zx.d((*(*arg1 + 0x720))(arg1)) != 0)
                    x22_1 = 0

if (*(x23 + 0x28) == x8)
    return zx.q(x22_1)

__stack_chk_fail()
noreturn
