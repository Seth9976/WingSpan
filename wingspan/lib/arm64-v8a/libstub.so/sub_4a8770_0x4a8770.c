// 函数: sub_4a8770
// 地址: 0x4a8770
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void var_a40
memset(&var_a40, 0, 0x3c0)
int64_t var_728 = arg1 + 1
int64_t var_700 = 0x4000000000000000
void* result = nullptr
void var_680
int32_t var_40

if (sub_4a78b8(&var_a40, &var_680) == 0 && var_40 != 2)
    void var_678
    void* i = &var_678
    uint8_t* x2_1 = arg2 + 0x334
    int64_t* x1_1 = arg2 + 0x20
    int64_t var_58
    
    do
        uint32_t x3_1 = zx.d(*i)
        *x2_1 = x3_1.b
        
        if (x3_1 == 1 || x3_1 == 2)
            *x1_1 = *(i - 8)
        else
            *x1_1 = 0
        
        i += 0x10
        x2_1 = &x2_1[1]
        x1_1 = &x1_1[1]
    while (i != &var_58)
    
    result = arg2
    *(arg2 + 0x10) = var_58
    int16_t var_50
    *(arg2 + 0x330) = var_50
    int16_t var_18
    *(arg2 + 0x332) = var_18
    int64_t var_6f0
    *(arg2 + 0x18) = var_6f0
    int64_t var_8
    *(arg2 + 8) = var_8

return result
