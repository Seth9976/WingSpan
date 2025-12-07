// 函数: sub_49086c
// 地址: 0x49086c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
int64_t var_50 = 0
int64_t var_48 = 0
int64_t x0 = (*(*arg1 + 0xc8))()
int32_t result

if (x0 == 0)
    result = sub_45bac8(arg1, "java/lang/NullPointerException", "NullPointerException")
else
    result = sub_45be5c(arg1, &var_48, &var_50, 0, "com/unity3d/player/UnityPlayerActivity", 
        "moveTaskToBack", "(Z)Z")
    
    if ((result & 1) == 0)
        char var_40 = 1
        (*(*arg1 + 0x138))(arg1, x0, var_50, &var_40)
        result = (*(*arg1 + 0x720))(arg1)

if (*(x21 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
