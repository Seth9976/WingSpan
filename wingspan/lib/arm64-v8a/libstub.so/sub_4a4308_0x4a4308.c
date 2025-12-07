// 函数: sub_4a4308
// 地址: 0x4a4308
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t result = (*(**(arg1 + 0x10) + 0x20))()
int32_t x8_2 = *(arg1 + 0xc)

if ((x8_2 & 1) != 0)
    int64_t x8_3 = arg2[1]
    int64_t x10_1 = arg2[2]
    
    if (x8_3 + 6 u>= x10_1)
        int64_t oldmem = *arg2
        int64_t bytes_3 = x10_1 << 1
        int64_t bytes
        
        if (bytes_3 u< x8_3 + 6)
            bytes = x8_3 + 6
        else
            bytes = bytes_3
        
        arg2[2] = bytes
        result = realloc(oldmem, bytes)
        *arg2 = result
        
        if (result == 0)
            sub_491944()
            noreturn
        
        x8_3 = arg2[1]
    else
        result = *arg2
    
    __builtin_strncpy(result + x8_3, " const", 6)
    arg2[1] += 6
    x8_2 = *(arg1 + 0xc)

if ((x8_2 & 2) != 0)
    int64_t x8_7 = arg2[1]
    int64_t x10_2 = arg2[2]
    
    if (x8_7 + 9 u>= x10_2)
        int64_t oldmem_1 = *arg2
        int64_t bytes_4 = x10_2 << 1
        int64_t bytes_1
        
        if (bytes_4 u< x8_7 + 9)
            bytes_1 = x8_7 + 9
        else
            bytes_1 = bytes_4
        
        arg2[2] = bytes_1
        result = realloc(oldmem_1, bytes_1)
        *arg2 = result
        
        if (result == 0)
            sub_491944()
            noreturn
        
        x8_7 = arg2[1]
    else
        result = *arg2
    
    __builtin_strncpy(result + x8_7, " volatile", 9)
    arg2[1] += 9
    x8_2 = *(arg1 + 0xc)

if ((x8_2 & 4) == 0)
    return result

int64_t x8_11 = arg2[1]
int64_t x10_3 = arg2[2]

if (x8_11 + 9 u>= x10_3)
    int64_t oldmem_2 = *arg2
    int64_t bytes_5 = x10_3 << 1
    int64_t bytes_2
    
    if (bytes_5 u< x8_11 + 9)
        bytes_2 = x8_11 + 9
    else
        bytes_2 = bytes_5
    
    arg2[2] = bytes_2
    result = realloc(oldmem_2, bytes_2)
    *arg2 = result
    
    if (result == 0)
        sub_491944()
        noreturn
    
    x8_11 = arg2[1]
else
    result = *arg2

__builtin_strncpy(result + x8_11, " restrict", 9)
arg2[1] += 9
return result
