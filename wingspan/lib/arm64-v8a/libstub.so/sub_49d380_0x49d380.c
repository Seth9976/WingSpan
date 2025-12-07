// 函数: sub_49d380
// 地址: 0x49d380
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
int16_t* result

if (x8 + 2 u>= x10)
    int64_t oldmem = *arg2
    size_t bytes_2 = x10 << 1
    size_t bytes
    
    if (bytes_2 u< x8 + 2)
        bytes = x8 + 2
    else
        bytes = bytes_2
    
    arg2[2] = bytes
    result = realloc(oldmem, bytes)
    *arg2 = result
    
    if (result != 0)
        x8 = arg2[1]
        goto label_49d3d8
else
    result = *arg2
label_49d3d8:
    *(result + x8) = 0x7066
    int64_t x8_2 = arg2[1] + 2
    arg2[1] = x8_2
    int64_t x21_1 = *(arg1 + 0x10)
    int64_t x9_1 = *(arg1 + 0x18)
    size_t x20_1 = x9_1 - x21_1
    
    if (x9_1 == x21_1)
        return result
    
    int64_t x10_1 = arg2[2]
    int64_t bytes_4 = x8_2 + x20_1
    int64_t x0
    
    if (bytes_4 u< x10_1)
        x0 = *arg2
    label_49d43c:
        result = memmove(x0 + x8_2, x21_1, x20_1)
        arg2[1] += x20_1
        return result
    
    int64_t oldmem_1 = *arg2
    int64_t bytes_3 = x10_1 << 1
    int64_t bytes_1
    
    bytes_1 = bytes_3 u< bytes_4 ? bytes_4 : bytes_3
    
    arg2[2] = bytes_1
    x0 = realloc(oldmem_1, bytes_1)
    *arg2 = x0
    
    if (x0 != 0)
        x8_2 = arg2[1]
        goto label_49d43c
sub_491944()
noreturn
