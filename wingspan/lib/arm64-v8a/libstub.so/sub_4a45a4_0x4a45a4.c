// 函数: sub_4a45a4
// 地址: 0x4a45a4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t* x21 = *(arg1 + 0x10)
(*(*x21 + 0x20))(x21)

if (zx.d(*(x21 + 9)) != 1)
    (*(*x21 + 0x28))(x21, arg2)

int64_t x8_5 = arg2[1]
int64_t x10 = arg2[2]
int64_t x0_2

if (x8_5 + 8 u>= x10)
    int64_t oldmem = *arg2
    int64_t bytes_2 = x10 << 1
    int64_t bytes
    
    if (bytes_2 u< x8_5 + 8)
        bytes = x8_5 + 8
    else
        bytes = bytes_2
    
    arg2[2] = bytes
    x0_2 = realloc(oldmem, bytes)
    *arg2 = x0_2
    
    if (x0_2 != 0)
        x8_5 = arg2[1]
        goto label_4a463c
else
    x0_2 = *arg2
label_4a463c:
    __builtin_strncpy(x0_2 + x8_5, " vector[", 8)
    arg2[1] += 8
    int64_t* x20_1 = *(arg1 + 0x18)
    
    if (x20_1 != 0)
        (*(*x20_1 + 0x20))(x20_1, arg2)
        
        if (zx.d(*(x20_1 + 9)) != 1)
            (*(*x20_1 + 0x28))(x20_1, arg2)
    
    int64_t x8_13 = arg2[1]
    int64_t x10_1 = arg2[2]
    char* result
    
    if (x8_13 + 1 u< x10_1)
        result = *arg2
    label_4a46c8:
        result[x8_13] = 0x5d
        arg2[1] += 1
        return result
    
    int64_t oldmem_1 = *arg2
    int64_t bytes_3 = x10_1 << 1
    size_t bytes_1
    
    if (bytes_3 u< x8_13 + 1)
        bytes_1 = x8_13 + 1
    else
        bytes_1 = bytes_3
    
    arg2[2] = bytes_1
    result = realloc(oldmem_1, bytes_1)
    *arg2 = result
    
    if (result != 0)
        x8_13 = arg2[1]
        goto label_4a46c8
sub_491944()
noreturn
