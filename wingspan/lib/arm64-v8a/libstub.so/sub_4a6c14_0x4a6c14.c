// 函数: sub_4a6c14
// 地址: 0x4a6c14
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void* x8 = *(arg2 + 0x10)

if ((arg6 & 1) == 0)
    if (*(arg1 + 8) != *(x8 + 8))
        jump(*(**(arg1 + 0x10) + 0x28))
else if (arg1 != x8 && strcmp(*(arg1 + 8), *(x8 + 8)).d != 0)
    jump(*(**(arg1 + 0x10) + 0x28))

int64_t x9_1 = *(arg2 + 8)
*(arg2 + 0x4d) = 1

if (x9_1 != arg4)
    return 

int64_t x9_3 = *(arg2 + 0x20)
*(arg2 + 0x4c) = 1

if (x9_3 == 0)
    *(arg2 + 0x20) = arg3
    *(arg2 + 0x30) = arg5
    *(arg2 + 0x3c) = 1
    
    if (arg5 == 1)
    label_4a6d30:
        int32_t x8_6 = *(arg2 + 0x48)
        
        if (x8_6 == 1)
            *(arg2 + 0x4e) = x8_6.b
else if (x9_3 == arg3)
    int32_t x8_5 = *(arg2 + 0x30)
    
    if (x8_5 == 2)
        x8_5 = arg5
        *(arg2 + 0x30) = arg5
    
    if (x8_5 == 1)
        goto label_4a6d30
else
    int32_t x8_3 = *(arg2 + 0x3c)
    *(arg2 + 0x4e) = 1
    *(arg2 + 0x3c) = x8_3 + 1
