// 函数: sub_49b6bc
// 地址: 0x49b6bc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
char* x8_1 = *(arg1 + 0x10)

if (*(arg1 + 0x18) - x8_1 + 1 u>= 9)
    uint32_t x9_3 = zx.d(*x8_1)
    uint32_t x11_1 = zx.d(x8_1[1])
    int32_t x14_2
    
    if (x9_3 - 0x30 u> 9)
        x14_2 = 9
    else
        x14_2 = 0
    
    char x14_3
    
    if (x11_1 - 0x30 u> 9)
        x14_3 = -0x57
    else
        x14_3 = -0x30
    
    char x9_5 = x14_3 + x11_1.b + ((x14_2 + x9_3) << 4).b
    char var_58 = x9_5
    uint32_t x11_3 = zx.d(x8_1[2])
    uint32_t x14_4 = zx.d(x8_1[3])
    int32_t x15_3
    
    if (x11_3 - 0x30 u> 9)
        x15_3 = 9
    else
        x15_3 = 0
    
    char x15_4
    
    if (x14_4 - 0x30 u> 9)
        x15_4 = -0x57
    else
        x15_4 = -0x30
    
    char var_57_1 = x15_4 + x14_4.b + ((x15_3 + x11_3) << 4).b
    uint32_t x11_6 = zx.d(x8_1[4])
    uint32_t x14_6 = zx.d(x8_1[5])
    int32_t x15_6
    
    if (x11_6 - 0x30 u> 9)
        x15_6 = 9
    else
        x15_6 = 0
    
    char x15_7
    
    if (x14_6 - 0x30 u> 9)
        x15_7 = -0x57
    else
        x15_7 = -0x30
    
    char var_56_1 = x15_7 + x14_6.b + ((x15_6 + x11_6) << 4).b
    uint32_t x11_9 = zx.d(x8_1[6])
    uint32_t x14_8 = zx.d(x8_1[7])
    void* x8_2 = &var_58 | 2
    int32_t x10_1
    
    if (x11_9 - 0x30 u> 9)
        x10_1 = 9
    else
        x10_1 = 0
    
    char x11_10
    
    if (x14_8 - 0x30 u> 9)
        x11_10 = -0x57
    else
        x11_10 = -0x30
    
    char var_55_1 = x9_5
    char* x9_6 = x8_2
    var_58 = x11_10 + x14_8.b + ((x10_1 + x11_9) << 4).b
    bool cond:5_1
    
    do
        char x11_12 = *(x8_2 - 1)
        *(x8_2 - 1) = *x9_6
        *x9_6 = x11_12
        x9_6 = &x9_6[-1]
        cond:5_1 = x8_2 u< x9_6
        x8_2 += 1
    while (cond:5_1)
    int128_t v0
    v0.d = var_58.d
    v0.q = fconvert.d(v0.d)
    int64_t var_50
    __builtin_memset(&var_50, 0, 0x18)
    int64_t entry_x4
    int128_t entry_v1
    int128_t entry_v2
    int128_t entry_v3
    int128_t entry_v4
    int128_t entry_v5
    int128_t entry_v6
    int128_t entry_v7
    arg1 = sub_49b8a4(&var_50, 0x18, 0x18, "%af", entry_x4, v0, entry_v1, entry_v2, entry_v3, 
        entry_v4, entry_v5, entry_v6, entry_v7)
    
    if (arg1.d != 0)
        int64_t x8_3 = arg2[1]
        int64_t x10_5 = arg2[2]
        int64_t x20_1 = sx.q(arg1.d)
        int64_t bytes_2 = x8_3 + x20_1
        int64_t x0_1
        
        if (bytes_2 u>= x10_5)
            int64_t oldmem = *arg2
            int64_t bytes_1 = x10_5 << 1
            int64_t bytes
            
            bytes = bytes_1 u< bytes_2 ? bytes_2 : bytes_1
            
            arg2[2] = bytes
            x0_1 = realloc(oldmem, bytes)
            *arg2 = x0_1
            
            if (x0_1 == 0)
                sub_491944()
                noreturn
            
            x8_3 = arg2[1]
        else
            x0_1 = *arg2
        
        memmove(x0_1 + x8_3, &var_50, x20_1)
        arg2[1] += x20_1

if (*(x21 + 0x28) == x8)
    return 

__stack_chk_fail()
noreturn
