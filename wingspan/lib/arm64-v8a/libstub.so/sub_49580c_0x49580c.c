// 函数: sub_49580c
// 地址: 0x49580c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
int64_t x0

if (x8 + 0x18 u>= x10)
    int64_t oldmem = *arg2
    int64_t bytes_2 = x10 << 1
    int64_t bytes
    
    if (bytes_2 u< x8 + 0x18)
        bytes = x8 + 0x18
    else
        bytes = bytes_2
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_49587c
else
    x0 = *arg2
label_49587c:
    __builtin_strncpy(x0 + x8, "construction vtable for ", 0x18)
    arg2[1] += 0x18
    int64_t* x21_1 = *(arg1 + 0x10)
    (*(*x21_1 + 0x20))(x21_1, arg2)
    
    if (zx.d(*(x21_1 + 9)) != 1)
        (*(*x21_1 + 0x28))(x21_1, arg2)
    
    int64_t x8_9 = arg2[1]
    int64_t x10_1 = arg2[2]
    int64_t x0_3
    
    if (x8_9 + 4 u< x10_1)
        x0_3 = *arg2
    label_495904:
        __builtin_strncpy(x0_3 + x8_9, "-in-", 4)
        arg2[1] += 4
        int64_t* x20_1 = *(arg1 + 0x18)
        int64_t result = (*(*x20_1 + 0x20))(x20_1, arg2)
        
        if (zx.d(*(x20_1 + 9)) != 1)
            jump(*(*x20_1 + 0x28))
        
        return result
    
    int64_t oldmem_1 = *arg2
    int64_t bytes_3 = x10_1 << 1
    int64_t bytes_1
    
    if (bytes_3 u< x8_9 + 4)
        bytes_1 = x8_9 + 4
    else
        bytes_1 = bytes_3
    
    arg2[2] = bytes_1
    x0_3 = realloc(oldmem_1, bytes_1)
    *arg2 = x0_3
    
    if (x0_3 != 0)
        x8_9 = arg2[1]
        goto label_495904
sub_491944()
noreturn
