// 函数: sub_49b948
// 地址: 0x49b948
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
char* x8_1 = *(arg1 + 0x10)

if (*(arg1 + 0x18) - x8_1 + 1 u>= 0x11)
    uint32_t x12_1 = zx.d(*x8_1)
    uint32_t x13_1 = zx.d(x8_1[1])
    int32_t x14_2
    
    if (x12_1 - 0x30 u> 9)
        x14_2 = 9
    else
        x14_2 = 0
    
    char x14_3
    
    if (x13_1 - 0x30 u> 9)
        x14_3 = -0x57
    else
        x14_3 = -0x30
    
    char var_68 = x14_3 + x13_1.b + ((x14_2 + x12_1) << 4).b
    uint32_t x12_4 = zx.d(x8_1[2])
    uint32_t x13_3 = zx.d(x8_1[3])
    int32_t x14_5
    
    if (x12_4 - 0x30 u> 9)
        x14_5 = 9
    else
        x14_5 = 0
    
    char x14_6
    
    if (x13_3 - 0x30 u> 9)
        x14_6 = -0x57
    else
        x14_6 = -0x30
    
    char var_67_1 = x14_6 + x13_3.b + ((x14_5 + x12_4) << 4).b
    uint32_t x12_7 = zx.d(x8_1[4])
    uint32_t x13_5 = zx.d(x8_1[5])
    int32_t x14_8
    
    if (x12_7 - 0x30 u> 9)
        x14_8 = 9
    else
        x14_8 = 0
    
    char x14_9
    
    if (x13_5 - 0x30 u> 9)
        x14_9 = -0x57
    else
        x14_9 = -0x30
    
    char var_66_1 = x14_9 + x13_5.b + ((x14_8 + x12_7) << 4).b
    uint32_t x12_10 = zx.d(x8_1[6])
    uint32_t x13_7 = zx.d(x8_1[7])
    int32_t x14_11
    
    if (x12_10 - 0x30 u> 9)
        x14_11 = 9
    else
        x14_11 = 0
    
    char x14_12
    
    if (x13_7 - 0x30 u> 9)
        x14_12 = -0x57
    else
        x14_12 = -0x30
    
    char var_65_1 = x14_12 + x13_7.b + ((x14_11 + x12_10) << 4).b
    uint32_t x12_13 = zx.d(x8_1[8])
    uint32_t x13_9 = zx.d(x8_1[9])
    int32_t x14_14
    
    if (x12_13 - 0x30 u> 9)
        x14_14 = 9
    else
        x14_14 = 0
    
    char x14_15
    
    if (x13_9 - 0x30 u> 9)
        x14_15 = -0x57
    else
        x14_15 = -0x30
    
    char var_64_1 = x14_15 + x13_9.b + ((x14_14 + x12_13) << 4).b
    uint32_t x12_16 = zx.d(x8_1[0xa])
    uint32_t x13_11 = zx.d(x8_1[0xb])
    int32_t x14_17
    
    if (x12_16 - 0x30 u> 9)
        x14_17 = 9
    else
        x14_17 = 0
    
    char x14_18
    
    if (x13_11 - 0x30 u> 9)
        x14_18 = -0x57
    else
        x14_18 = -0x30
    
    char var_63_1 = x14_18 + x13_11.b + ((x14_17 + x12_16) << 4).b
    uint32_t x13_13 = zx.d(x8_1[0xc])
    uint32_t x14_19 = zx.d(x8_1[0xd])
    int32_t x17_1
    
    if (x13_13 - 0x30 u> 9)
        x17_1 = 9
    else
        x17_1 = 0
    
    char x16_2
    
    if (x14_19 - 0x30 u> 9)
        x16_2 = -0x57
    else
        x16_2 = -0x30
    
    char var_62_1 = x16_2 + x14_19.b + ((x17_1 + x13_13) << 4).b
    uint32_t x14_21 = zx.d(x8_1[0xe])
    uint32_t x8_2 = zx.d(x8_1[0xf])
    void* x12_20 = &var_68 | 2
    char* x13_16 = &var_68 | 6
    char x15_7 = var_68
    int32_t x9_3
    
    if (x14_21 - 0x30 u> 9)
        x9_3 = 9
    else
        x9_3 = 0
    
    char x10_1
    
    if (x8_2 - 0x30 u> 9)
        x10_1 = -0x57
    else
        x10_1 = -0x30
    
    char x8_4 = x10_1 + x8_2.b + ((x9_3 + x14_21) << 4).b
    char var_61_1 = x8_4
    var_68 = x8_4
    char var_61_2 = x15_7
    bool cond:8_1
    
    do
        char x9_5 = *(x12_20 - 1)
        *(x12_20 - 1) = *x13_16
        *x13_16 = x9_5
        x13_16 = &x13_16[-1]
        cond:8_1 = x12_20 u< x13_16
        x12_20 += 1
    while (cond:8_1)
    int128_t v0
    v0.q = var_68.q
    int128_t v1
    v1.q = 0
    v1:8.q = 0
    int128_t var_60
    __builtin_memset(&var_60, 0, 0x20)
    int64_t entry_x4
    int128_t entry_v2
    int128_t entry_v3
    int128_t entry_v4
    int128_t entry_v5
    int128_t entry_v6
    int128_t entry_v7
    arg1 = sub_49b8a4(&var_60, 0x20, 0x20, "%a", entry_x4, v0, v1, entry_v2, entry_v3, entry_v4, 
        entry_v5, entry_v6, entry_v7)
    
    if (arg1.d != 0)
        int64_t x8_6 = arg2[1]
        int64_t x10_2 = arg2[2]
        int64_t x20_1 = sx.q(arg1.d)
        int64_t bytes_2 = x8_6 + x20_1
        int64_t x0_1
        
        if (bytes_2 u>= x10_2)
            int64_t oldmem = *arg2
            int64_t bytes_1 = x10_2 << 1
            int64_t bytes
            
            bytes = bytes_1 u< bytes_2 ? bytes_2 : bytes_1
            
            arg2[2] = bytes
            x0_1 = realloc(oldmem, bytes)
            *arg2 = x0_1
            
            if (x0_1 == 0)
                sub_491944()
                noreturn
            
            x8_6 = arg2[1]
        else
            x0_1 = *arg2
        
        memmove(x0_1 + x8_6, &var_60, x20_1)
        arg2[1] += x20_1

if (*(x21 + 0x28) == x8)
    return 

__stack_chk_fail()
noreturn
