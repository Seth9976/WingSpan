// 函数: sub_4a2944
// 地址: 0x4a2944
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
int64_t x0

if (x8 + 0xc u>= x10)
    int64_t oldmem = *arg2
    int64_t bytes_2 = x10 << 1
    int64_t bytes
    
    if (bytes_2 u< x8 + 0xc)
        bytes = x8 + 0xc
    else
        bytes = bytes_2
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_4a29b0
else
    x0 = *arg2
label_4a29b0:
    __builtin_strncpy(x0 + x8, " [enable_if:", 0xc)
    arg2[1] += 0xc
    sub_49cc90(arg1 + 0x10, arg2)
    int64_t x8_4 = arg2[1]
    int64_t x10_1 = arg2[2]
    int64_t bytes_4 = x8_4 + 1
    char* result
    
    if (bytes_4 u< x10_1)
        result = *arg2
    label_4a2a0c:
        arg2[1] = bytes_4
        result[x8_4] = 0x5d
        return result
    
    int64_t oldmem_1 = *arg2
    int64_t bytes_3 = x10_1 << 1
    int64_t bytes_1
    
    bytes_1 = bytes_3 u< bytes_4 ? bytes_4 : bytes_3
    
    arg2[2] = bytes_1
    result = realloc(oldmem_1, bytes_1)
    *arg2 = result
    
    if (result != 0)
        x8_4 = arg2[1]
        bytes_4 = x8_4 + 1
        goto label_4a2a0c
sub_491944()
noreturn
