// 函数: sub_4a1e30
// 地址: 0x4a1e30
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

(*(**(arg1 + 0x10) + 0x20))()
int64_t x8_2 = arg2[1]
int64_t x10 = arg2[2]
int64_t x0_1

if (x8_2 + 5 u>= x10)
    int64_t oldmem = *arg2
    int64_t bytes_3 = x10 << 1
    int64_t bytes
    
    if (bytes_3 u< x8_2 + 5)
        bytes = x8_2 + 5
    else
        bytes = bytes_3
    
    arg2[2] = bytes
    x0_1 = realloc(oldmem, bytes)
    *arg2 = x0_1
    
    if (x0_1 != 0)
        x8_2 = arg2[1]
        goto label_4a1ea8
else
    x0_1 = *arg2
label_4a1ea8:
    __builtin_strncpy(x0_1 + x8_2, "[abi:", 5)
    int64_t x8_5 = arg2[1] + 5
    arg2[1] = x8_5
    int64_t x21_1 = *(arg1 + 0x18)
    int64_t x9_1 = *(arg1 + 0x20)
    size_t x20_1 = x9_1 - x21_1
    
    if (x9_1 == x21_1)
        goto label_4a1f1c
    
    int64_t x10_1 = arg2[2]
    int64_t bytes_6 = x8_5 + x20_1
    int64_t x0_2
    
    if (bytes_6 u>= x10_1)
        int64_t oldmem_1 = *arg2
        int64_t bytes_4 = x10_1 << 1
        int64_t bytes_1
        
        bytes_1 = bytes_4 u< bytes_6 ? bytes_6 : bytes_4
        
        arg2[2] = bytes_1
        x0_2 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_2
        
        if (x0_2 != 0)
            x8_5 = arg2[1]
            goto label_4a1f0c
    else
        x0_2 = *arg2
    label_4a1f0c:
        memmove(x0_2 + x8_5, x21_1, x20_1)
        x8_5 = arg2[1] + x20_1
        arg2[1] = x8_5
    label_4a1f1c:
        int64_t x10_2 = arg2[2]
        char* result
        
        if (x8_5 + 1 u< x10_2)
            result = *arg2
        label_4a1f5c:
            result[x8_5] = 0x5d
            arg2[1] += 1
            return result
        
        int64_t oldmem_2 = *arg2
        int64_t bytes_5 = x10_2 << 1
        size_t bytes_2
        
        if (bytes_5 u< x8_5 + 1)
            bytes_2 = x8_5 + 1
        else
            bytes_2 = bytes_5
        
        arg2[2] = bytes_2
        result = realloc(oldmem_2, bytes_2)
        *arg2 = result
        
        if (result != 0)
            x8_5 = arg2[1]
            goto label_4a1f5c
sub_491944()
noreturn
