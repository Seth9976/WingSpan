// 函数: sub_4a0508
// 地址: 0x4a0508
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
int64_t x0

if (x8 + 0xb u>= x10)
    int64_t oldmem = *arg2
    int64_t bytes_1 = x10 << 1
    int64_t bytes
    
    if (bytes_1 u< x8 + 0xb)
        bytes = x8 + 0xb
    else
        bytes = bytes_1
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 == 0)
        sub_491944()
        noreturn
    
    x8 = arg2[1]
else
    x0 = *arg2

__builtin_strncpy(x0 + x8, "operator\"\" ", 0xb)
arg2[1] += 0xb
int64_t* x20_1 = *(arg1 + 0x10)
int64_t result = (*(*x20_1 + 0x20))(x20_1, arg2)

if (zx.d(*(x20_1 + 9)) != 1)
    jump(*(*x20_1 + 0x28))

return result
