// 函数: sub_49e774
// 地址: 0x49e774
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]

if (zx.d(*(arg1 + 0x18)) == 0)
    goto label_49e7e4

int64_t x10_1 = arg2[2]
int16_t* x0

if (x8 + 2 u>= x10_1)
    int64_t oldmem = *arg2
    size_t bytes_3 = x10_1 << 1
    size_t bytes
    
    if (bytes_3 u< x8 + 2)
        bytes = x8 + 2
    else
        bytes = bytes_3
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_49e7d4
else
    x0 = *arg2
label_49e7d4:
    *(x0 + x8) = 0x3a3a
    x8 = arg2[1] + 2
    arg2[1] = x8
label_49e7e4:
    int64_t x10_2 = arg2[2]
    int64_t x0_1
    
    if (x8 + 6 u>= x10_2)
        int64_t oldmem_1 = *arg2
        int64_t bytes_4 = x10_2 << 1
        int64_t bytes_1
        
        if (bytes_4 u< x8 + 6)
            bytes_1 = x8 + 6
        else
            bytes_1 = bytes_4
        
        arg2[2] = bytes_1
        x0_1 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_1
        
        if (x0_1 != 0)
            x8 = arg2[1]
            goto label_49e834
    else
        x0_1 = *arg2
    label_49e834:
        __builtin_strncpy(x0_1 + x8, "delete", 6)
        int64_t x9_3 = arg2[1]
        int64_t x8_3 = x9_3 + 6
        arg2[1] = x8_3
        
        if (zx.d(*(arg1 + 0x19)) == 0)
            goto label_49e8a8
        
        int64_t x10_4 = arg2[2]
        void* x0_2
        
        if (x9_3 + 9 u< x10_4)
            x0_2 = *arg2
        label_49e888:
            int16_t* x8_4 = x0_2 + x8_3
            x8_4[1].b = 0x20
            *x8_4 = 0x5d5b
            arg2[1] += 3
        label_49e8a8:
            int64_t* x20_1 = *(arg1 + 0x10)
            int64_t result = (*(*x20_1 + 0x20))(x20_1, arg2)
            
            if (zx.d(*(x20_1 + 9)) != 1)
                jump(*(*x20_1 + 0x28))
            
            return result
        
        int64_t oldmem_2 = *arg2
        size_t bytes_5 = x10_4 << 1
        size_t bytes_2
        
        if (bytes_5 u< x9_3 + 9)
            bytes_2 = x9_3 + 9
        else
            bytes_2 = bytes_5
        
        arg2[2] = bytes_2
        x0_2 = realloc(oldmem_2, bytes_2)
        *arg2 = x0_2
        
        if (x0_2 != 0)
            x8_3 = arg2[1]
            goto label_49e888
sub_491944()
noreturn
