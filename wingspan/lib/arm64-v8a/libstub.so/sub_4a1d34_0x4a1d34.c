// 函数: sub_4a1d34
// 地址: 0x4a1d34
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (zx.d(*(arg1 + 0x18)) == 0)
    goto label_4a1db0

int64_t x8_1 = arg2[1]
int64_t x10_1 = arg2[2]
char* x0

if (x8_1 + 1 u>= x10_1)
    int64_t oldmem = *arg2
    size_t bytes_2 = x10_1 << 1
    size_t bytes
    
    if (bytes_2 u< x8_1 + 1)
        bytes = x8_1 + 1
    else
        bytes = bytes_2
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8_1 = arg2[1]
        goto label_4a1d94
else
    x0 = *arg2
label_4a1d94:
    x0[x8_1] = 0x7e
    arg2[1] += 1
label_4a1db0:
    int64_t result
    int64_t x1
    result, x1 = (*(**(arg1 + 0x10) + 0x30))()
    size_t x20_1 = x1 - result
    
    if (x1 == result)
        return result
    
    int64_t x8_6 = arg2[1]
    int64_t x10_2 = arg2[2]
    int64_t bytes_4 = x8_6 + x20_1
    int64_t x0_2
    
    if (bytes_4 u< x10_2)
        x0_2 = *arg2
    label_4a1e08:
        result = memmove(x0_2 + x8_6, result, x20_1)
        arg2[1] += x20_1
        return result
    
    int64_t oldmem_1 = *arg2
    int64_t bytes_3 = x10_2 << 1
    int64_t bytes_1
    
    bytes_1 = bytes_3 u< bytes_4 ? bytes_4 : bytes_3
    
    arg2[2] = bytes_1
    x0_2 = realloc(oldmem_1, bytes_1)
    *arg2 = x0_2
    
    if (x0_2 != 0)
        x8_6 = arg2[1]
        goto label_4a1e08
sub_491944()
noreturn
