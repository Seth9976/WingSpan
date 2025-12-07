// 函数: sub_4a06a0
// 地址: 0x4a06a0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t* x21 = *(arg1 + 0x10)
(*(*x21 + 0x20))(x21)

if (zx.d(*(x21 + 9)) != 1)
    (*(*x21 + 0x28))(x21, arg2)

int64_t x22 = *(arg1 + 0x18)
int64_t x8_5 = *(arg1 + 0x20)
size_t x21_1 = x8_5 - x22

if (x8_5 != x22)
    int64_t x8_6 = arg2[1]
    int64_t x10_1 = arg2[2]
    int64_t bytes_2 = x8_6 + x21_1
    int64_t x0_2
    
    if (bytes_2 u>= x10_1)
        int64_t oldmem = *arg2
        int64_t bytes_1 = x10_1 << 1
        int64_t bytes
        
        bytes = bytes_1 u< bytes_2 ? bytes_2 : bytes_1
        
        arg2[2] = bytes
        x0_2 = realloc(oldmem, bytes)
        *arg2 = x0_2
        
        if (x0_2 == 0)
            sub_491944()
            noreturn
        
        x8_6 = arg2[1]
    else
        x0_2 = *arg2
    
    memmove(x0_2 + x8_6, x22, x21_1)
    arg2[1] += x21_1

int64_t* x20_1 = *(arg1 + 0x28)
int64_t result = (*(*x20_1 + 0x20))(x20_1, arg2)

if (zx.d(*(x20_1 + 9)) != 1)
    jump(*(*x20_1 + 0x28))

return result
