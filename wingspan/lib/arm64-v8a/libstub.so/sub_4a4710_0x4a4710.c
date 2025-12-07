// 函数: sub_4a4710
// 地址: 0x4a4710
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void* x8 = arg2[1]

if (x8 != 0 && zx.d(*(x8 + *arg2 - 1)) == 0x5d)
    goto label_4a4794

int64_t x10_1 = arg2[2]
char* x0

if (x8 + 1 u>= x10_1)
    int64_t oldmem = *arg2
    void* bytes_3 = x10_1 << 1
    void* bytes
    
    if (bytes_3 u< x8 + 1)
        bytes = x8 + 1
    else
        bytes = bytes_3
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_4a4784
else
    x0 = *arg2
label_4a4784:
    *(x0 + x8) = 0x20
    x8 = arg2[1] + 1
    arg2[1] = x8
label_4a4794:
    int64_t x10_2 = arg2[2]
    char* x0_1
    
    if (x8 + 1 u>= x10_2)
        int64_t oldmem_1 = *arg2
        size_t bytes_4 = x10_2 << 1
        size_t bytes_1
        
        if (bytes_4 u< x8 + 1)
            bytes_1 = x8 + 1
        else
            bytes_1 = bytes_4
        
        arg2[2] = bytes_1
        x0_1 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_1
        
        if (x0_1 != 0)
            x8 = arg2[1]
            goto label_4a47d4
    else
        x0_1 = *arg2
    label_4a47d4:
        *(x0_1 + x8) = 0x5b
        arg2[1] += 1
        int64_t* x21_1 = *(arg1 + 0x18)
        
        if (x21_1 != 0)
            (*(*x21_1 + 0x20))(x21_1, arg2)
            
            if (zx.d(*(x21_1 + 9)) != 1)
                (*(*x21_1 + 0x28))(x21_1, arg2)
        
        int64_t x8_9 = arg2[1]
        int64_t x10_3 = arg2[2]
        char* x0_4
        
        if (x8_9 + 1 u< x10_3)
            x0_4 = *arg2
        label_4a4860:
            x0_4[x8_9] = 0x5d
            arg2[1] += 1
            jump(*(**(arg1 + 0x10) + 0x28))
        
        int64_t oldmem_2 = *arg2
        int64_t bytes_5 = x10_3 << 1
        size_t bytes_2
        
        if (bytes_5 u< x8_9 + 1)
            bytes_2 = x8_9 + 1
        else
            bytes_2 = bytes_5
        
        arg2[2] = bytes_2
        x0_4 = realloc(oldmem_2, bytes_2)
        *arg2 = x0_4
        
        if (x0_4 != 0)
            x8_9 = arg2[1]
            goto label_4a4860
sub_491944()
noreturn
