// 函数: sub_4a14b0
// 地址: 0x4a14b0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
char* x0

if (x8 + 1 u>= x10)
    int64_t oldmem = *arg2
    size_t bytes_4 = x10 << 1
    size_t bytes
    
    if (bytes_4 u< x8 + 1)
        bytes = x8 + 1
    else
        bytes = bytes_4
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_4a1508
else
    x0 = *arg2
label_4a1508:
    x0[x8] = 0x28
    arg2[1] += 1
    int64_t* x21_1 = *(arg1 + 0x10)
    (*(*x21_1 + 0x20))(x21_1, arg2)
    
    if (zx.d(*(x21_1 + 9)) != 1)
        (*(*x21_1 + 0x28))(x21_1, arg2)
    
    int64_t x8_8 = arg2[1]
    int64_t x10_1 = arg2[2]
    int64_t x0_3
    
    if (x8_8 + 5 u>= x10_1)
        int64_t oldmem_1 = *arg2
        int64_t bytes_5 = x10_1 << 1
        int64_t bytes_1
        
        if (bytes_5 u< x8_8 + 5)
            bytes_1 = x8_8 + 5
        else
            bytes_1 = bytes_5
        
        arg2[2] = bytes_1
        x0_3 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_3
        
        if (x0_3 != 0)
            x8_8 = arg2[1]
            goto label_4a15a0
    else
        x0_3 = *arg2
    label_4a15a0:
        __builtin_strncpy(x0_3 + x8_8, ") ? (", 5)
        arg2[1] += 5
        int64_t* x21_2 = *(arg1 + 0x18)
        (*(*x21_2 + 0x20))(x21_2, arg2)
        
        if (zx.d(*(x21_2 + 9)) != 1)
            (*(*x21_2 + 0x28))(x21_2, arg2)
        
        int64_t x8_17 = arg2[1]
        int64_t x10_2 = arg2[2]
        int64_t x0_6
        
        if (x8_17 + 5 u>= x10_2)
            int64_t oldmem_2 = *arg2
            int64_t bytes_6 = x10_2 << 1
            int64_t bytes_2
            
            if (bytes_6 u< x8_17 + 5)
                bytes_2 = x8_17 + 5
            else
                bytes_2 = bytes_6
            
            arg2[2] = bytes_2
            x0_6 = realloc(oldmem_2, bytes_2)
            *arg2 = x0_6
            
            if (x0_6 != 0)
                x8_17 = arg2[1]
                goto label_4a1638
        else
            x0_6 = *arg2
        label_4a1638:
            __builtin_strncpy(x0_6 + x8_17, ") : (", 5)
            arg2[1] += 5
            int64_t* x20_1 = *(arg1 + 0x20)
            (*(*x20_1 + 0x20))(x20_1, arg2)
            
            if (zx.d(*(x20_1 + 9)) != 1)
                (*(*x20_1 + 0x28))(x20_1, arg2)
            
            int64_t x8_26 = arg2[1]
            int64_t x10_3 = arg2[2]
            char* result
            
            if (x8_26 + 1 u< x10_3)
                result = *arg2
            label_4a16c0:
                result[x8_26] = 0x29
                arg2[1] += 1
                return result
            
            int64_t oldmem_3 = *arg2
            int64_t bytes_7 = x10_3 << 1
            size_t bytes_3
            
            if (bytes_7 u< x8_26 + 1)
                bytes_3 = x8_26 + 1
            else
                bytes_3 = bytes_7
            
            arg2[2] = bytes_3
            result = realloc(oldmem_3, bytes_3)
            *arg2 = result
            
            if (result != 0)
                x8_26 = arg2[1]
                goto label_4a16c0
sub_491944()
noreturn
