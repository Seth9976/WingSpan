// 函数: sub_49cb38
// 地址: 0x49cb38
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
int64_t x0

if (x8 + 9 u>= x10)
    int64_t oldmem = *arg2
    int64_t bytes_2 = x10 << 1
    int64_t bytes
    
    if (bytes_2 u< x8 + 9)
        bytes = x8 + 9
    else
        bytes = bytes_2
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_49cba0
else
    x0 = *arg2
label_49cba0:
    __builtin_strncpy(x0 + x8, "template<", 9)
    arg2[1] += 9
    sub_49cc90(arg1 + 0x18, arg2)
    int64_t x8_4 = arg2[1]
    int64_t x10_1 = arg2[2]
    int64_t result
    
    if (x8_4 + 0xb u< x10_1)
        result = *arg2
    label_49cc10:
        __builtin_strncpy(result + x8_4, "> typename ", 0xb)
        arg2[1] += 0xb
        return result
    
    int64_t oldmem_1 = *arg2
    int64_t bytes_3 = x10_1 << 1
    int64_t bytes_1
    
    if (bytes_3 u< x8_4 + 0xb)
        bytes_1 = x8_4 + 0xb
    else
        bytes_1 = bytes_3
    
    arg2[2] = bytes_1
    result = realloc(oldmem_1, bytes_1)
    *arg2 = result
    
    if (result != 0)
        x8_4 = arg2[1]
        goto label_49cc10
sub_491944()
noreturn
