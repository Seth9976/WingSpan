// 函数: sub_4a1380
// 地址: 0x4a1380
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x22 = *(arg1 + 0x10)
int64_t x8 = *(arg1 + 0x18)
size_t x21 = x8 - x22

if (x8 == x22)
    goto label_4a13fc

int64_t x8_1 = arg2[1]
int64_t x10_1 = arg2[2]
int64_t bytes_4 = x8_1 + x21
int64_t x0

if (bytes_4 u>= x10_1)
    int64_t oldmem = *arg2
    int64_t bytes_2 = x10_1 << 1
    int64_t bytes
    
    bytes = bytes_2 u< bytes_4 ? bytes_4 : bytes_2
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8_1 = arg2[1]
        goto label_4a13ec
else
    x0 = *arg2
label_4a13ec:
    memmove(x0 + x8_1, x22, x21)
    arg2[1] += x21
label_4a13fc:
    int64_t* x21_1 = *(arg1 + 0x20)
    int64_t result = (*(*x21_1 + 0x20))(x21_1, arg2)
    
    if (zx.d(*(x21_1 + 9)) != 1)
        result = (*(*x21_1 + 0x28))(x21_1, arg2)
    
    int64_t x21_2 = *(arg1 + 0x28)
    int64_t x8_9 = *(arg1 + 0x30)
    size_t x20_1 = x8_9 - x21_2
    
    if (x8_9 == x21_2)
        return result
    
    int64_t x8_10 = arg2[1]
    int64_t x10_2 = arg2[2]
    int64_t bytes_5 = x8_10 + x20_1
    int64_t x0_4
    
    if (bytes_5 u< x10_2)
        x0_4 = *arg2
    label_4a1488:
        result = memmove(x0_4 + x8_10, x21_2, x20_1)
        arg2[1] += x20_1
        return result
    
    int64_t oldmem_1 = *arg2
    int64_t bytes_3 = x10_2 << 1
    int64_t bytes_1
    
    bytes_1 = bytes_3 u< bytes_5 ? bytes_5 : bytes_3
    
    arg2[2] = bytes_1
    x0_4 = realloc(oldmem_1, bytes_1)
    *arg2 = x0_4
    
    if (x0_4 != 0)
        x8_10 = arg2[1]
        goto label_4a1488
sub_491944()
noreturn
