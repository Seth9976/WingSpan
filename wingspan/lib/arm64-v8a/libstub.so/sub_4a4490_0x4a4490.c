// 函数: sub_4a4490
// 地址: 0x4a4490
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
int64_t x0

if (x8 + 0xd u>= x10)
    int64_t oldmem = *arg2
    int64_t bytes_2 = x10 << 1
    int64_t bytes
    
    if (bytes_2 u< x8 + 0xd)
        bytes = x8 + 0xd
    else
        bytes = bytes_2
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_4a44fc
else
    x0 = *arg2
label_4a44fc:
    __builtin_strncpy(x0 + x8, "pixel vector[", 0xd)
    arg2[1] += 0xd
    int64_t* x20_1 = *(arg1 + 0x10)
    (*(*x20_1 + 0x20))(x20_1, arg2)
    
    if (zx.d(*(x20_1 + 9)) != 1)
        (*(*x20_1 + 0x28))(x20_1, arg2)
    
    int64_t x8_9 = arg2[1]
    int64_t x10_1 = arg2[2]
    char* result
    
    if (x8_9 + 1 u< x10_1)
        result = *arg2
    label_4a4580:
        result[x8_9] = 0x5d
        arg2[1] += 1
        return result
    
    int64_t oldmem_1 = *arg2
    int64_t bytes_3 = x10_1 << 1
    size_t bytes_1
    
    if (bytes_3 u< x8_9 + 1)
        bytes_1 = x8_9 + 1
    else
        bytes_1 = bytes_3
    
    arg2[2] = bytes_1
    result = realloc(oldmem_1, bytes_1)
    *arg2 = result
    
    if (result != 0)
        x8_9 = arg2[1]
        goto label_4a4580
sub_491944()
noreturn
