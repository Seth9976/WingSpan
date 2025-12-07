// 函数: sub_49d120
// 地址: 0x49d120
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
int16_t* x0

if (x8 + 2 u>= x10)
    int64_t oldmem = *arg2
    size_t bytes_2 = x10 << 1
    size_t bytes
    
    if (bytes_2 u< x8 + 2)
        bytes = x8 + 2
    else
        bytes = bytes_2
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_49d174
else
    x0 = *arg2
label_49d174:
    *(x0 + x8) = 0x5d5b
    int64_t x8_2 = arg2[1] + 2
    arg2[1] = x8_2
    void* x0_1 = *(arg1 + 0x10)
    
    if (zx.d(*(x0_1 + 8)) == 0x2d)
        sub_49cf98(x0_1, arg2)
        x8_2 = arg2[1]
    
    int64_t x10_1 = arg2[2]
    int64_t result
    
    if (x8_2 + 5 u< x10_1)
        result = *arg2
    label_49d1f0:
        __builtin_strncpy(result + x8_2, "{...}", 5)
        arg2[1] += 5
        return result
    
    int64_t oldmem_1 = *arg2
    int64_t bytes_3 = x10_1 << 1
    int64_t bytes_1
    
    if (bytes_3 u< x8_2 + 5)
        bytes_1 = x8_2 + 5
    else
        bytes_1 = bytes_3
    
    arg2[2] = bytes_1
    result = realloc(oldmem_1, bytes_1)
    *arg2 = result
    
    if (result != 0)
        x8_2 = arg2[1]
        goto label_49d1f0
sub_491944()
noreturn
