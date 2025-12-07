// 函数: sub_4a4b4c
// 地址: 0x4a4b4c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x22 = *(arg1 + 0x10)
int64_t x9 = *(arg1 + 0x18)
int64_t x8 = arg2[1]
size_t x21 = x9 - x22

if (x9 == x22)
    goto label_4a4bcc

int64_t x10_1 = arg2[2]
int64_t bytes_4 = x8 + x21
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
        x8 = arg2[1]
        goto label_4a4bbc
else
    x0 = *arg2
label_4a4bbc:
    memmove(x0 + x8, x22, x21)
    x8 = arg2[1] + x21
    arg2[1] = x8
label_4a4bcc:
    int64_t x10_2 = arg2[2]
    int64_t bytes_5 = x8 + 1
    char* x0_2
    
    if (bytes_5 u< x10_2)
        x0_2 = *arg2
    label_4a4c0c:
        arg2[1] = bytes_5
        x0_2[x8] = 0x20
        int64_t* x20_1 = *(arg1 + 0x20)
        int64_t result = (*(*x20_1 + 0x20))(x20_1, arg2)
        
        if (zx.d(*(x20_1 + 9)) != 1)
            jump(*(*x20_1 + 0x28))
        
        return result
    
    int64_t oldmem_1 = *arg2
    int64_t bytes_3 = x10_2 << 1
    int64_t bytes_1
    
    bytes_1 = bytes_3 u< bytes_5 ? bytes_5 : bytes_3
    
    arg2[2] = bytes_1
    x0_2 = realloc(oldmem_1, bytes_1)
    *arg2 = x0_2
    
    if (x0_2 != 0)
        x8 = arg2[1]
        bytes_5 = x8 + 1
        goto label_4a4c0c
sub_491944()
noreturn
