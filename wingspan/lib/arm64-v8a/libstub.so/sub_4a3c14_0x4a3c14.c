// 函数: sub_4a3c14
// 地址: 0x4a3c14
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

(*(**(arg1 + 0x10) + 0x20))()
int64_t x8_2 = arg2[1]
int64_t x10 = arg2[2]
char* result

if (x8_2 + 1 u>= x10)
    int64_t oldmem = *arg2
    int64_t bytes_1 = x10 << 1
    size_t bytes
    
    if (bytes_1 u< x8_2 + 1)
        bytes = x8_2 + 1
    else
        bytes = bytes_1
    
    arg2[2] = bytes
    result = realloc(oldmem, bytes)
    *arg2 = result
    
    if (result == 0)
        sub_491944()
        noreturn
    
    x8_2 = arg2[1]
else
    result = *arg2

result[x8_2] = 0x20
arg2[1] += 1
return result
