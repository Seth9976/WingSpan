// 函数: sub_49ee24
// 地址: 0x49ee24
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t* x21 = *(arg1 + 0x10)
(*(*x21 + 0x20))(x21)

if (zx.d(*(x21 + 9)) != 1)
    (*(*x21 + 0x28))(x21, arg2)

int64_t x8_5 = arg2[1]
int64_t x10 = arg2[2]
int16_t* x0_2

if (x8_5 + 2 u>= x10)
    int64_t oldmem = *arg2
    int64_t bytes_1 = x10 << 1
    size_t bytes
    
    if (bytes_1 u< x8_5 + 2)
        bytes = x8_5 + 2
    else
        bytes = bytes_1
    
    arg2[2] = bytes
    x0_2 = realloc(oldmem, bytes)
    *arg2 = x0_2
    
    if (x0_2 == 0)
        sub_491944()
        noreturn
    
    x8_5 = arg2[1]
else
    x0_2 = *arg2

*(x0_2 + x8_5) = 0x3a3a
arg2[1] += 2
int64_t* x20_1 = *(arg1 + 0x18)
int64_t result = (*(*x20_1 + 0x20))(x20_1, arg2)

if (zx.d(*(x20_1 + 9)) != 1)
    jump(*(*x20_1 + 0x28))

return result
