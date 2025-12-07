// 函数: sub_4a07ac
// 地址: 0x4a07ac
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
char* x0

if (x8 + 1 u>= x10)
    int64_t oldmem = *arg2
    size_t bytes_3 = x10 << 1
    size_t bytes
    
    if (bytes_3 u< x8 + 1)
        bytes = x8 + 1
    else
        bytes = bytes_3
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_4a0804
else
    x0 = *arg2
label_4a0804:
    x0[x8] = 0x28
    arg2[1] += 1
    int64_t* x21_1 = *(arg1 + 0x10)
    (*(*x21_1 + 0x20))(x21_1, arg2)
    
    if (zx.d(*(x21_1 + 9)) != 1)
        (*(*x21_1 + 0x28))(x21_1, arg2)
    
    int64_t x8_8 = arg2[1]
    int64_t x10_1 = arg2[2]
    int16_t* x0_3
    
    if (x8_8 + 2 u>= x10_1)
        int64_t oldmem_1 = *arg2
        size_t bytes_4 = x10_1 << 1
        size_t bytes_1
        
        if (bytes_4 u< x8_8 + 2)
            bytes_1 = x8_8 + 2
        else
            bytes_1 = bytes_4
        
        arg2[2] = bytes_1
        x0_3 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_3
        
        if (x0_3 != 0)
            x8_8 = arg2[1]
            goto label_4a088c
    else
        x0_3 = *arg2
    label_4a088c:
        *(x0_3 + x8_8) = 0x5b29
        arg2[1] += 2
        int64_t* x20_1 = *(arg1 + 0x18)
        (*(*x20_1 + 0x20))(x20_1, arg2)
        
        if (zx.d(*(x20_1 + 9)) != 1)
            (*(*x20_1 + 0x28))(x20_1, arg2)
        
        int64_t x8_16 = arg2[1]
        int64_t x10_2 = arg2[2]
        char* result
        
        if (x8_16 + 1 u< x10_2)
            result = *arg2
        label_4a0914:
            result[x8_16] = 0x5d
            arg2[1] += 1
            return result
        
        int64_t oldmem_2 = *arg2
        int64_t bytes_5 = x10_2 << 1
        size_t bytes_2
        
        if (bytes_5 u< x8_16 + 1)
            bytes_2 = x8_16 + 1
        else
            bytes_2 = bytes_5
        
        arg2[2] = bytes_2
        result = realloc(oldmem_2, bytes_2)
        *arg2 = result
        
        if (result != 0)
            x8_16 = arg2[1]
            goto label_4a0914
sub_491944()
noreturn
