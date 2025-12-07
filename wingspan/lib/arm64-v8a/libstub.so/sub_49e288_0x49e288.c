// 函数: sub_49e288
// 地址: 0x49e288
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x22 = *(arg1 + 0x10)
int64_t x9 = *(arg1 + 0x18)
int64_t x8 = arg2[1]
size_t x21 = x9 - x22

if (x9 == x22)
    goto label_49e308

int64_t x10_1 = arg2[2]
int64_t bytes_8 = x8 + x21
int64_t x0

if (bytes_8 u>= x10_1)
    int64_t oldmem = *arg2
    int64_t bytes_4 = x10_1 << 1
    int64_t bytes
    
    bytes = bytes_4 u< bytes_8 ? bytes_8 : bytes_4
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_49e2f8
else
    x0 = *arg2
label_49e2f8:
    memmove(x0 + x8, x22, x21)
    x8 = arg2[1] + x21
    arg2[1] = x8
label_49e308:
    int64_t x10_2 = arg2[2]
    char* x0_2
    
    if (x8 + 1 u>= x10_2)
        int64_t oldmem_1 = *arg2
        size_t bytes_5 = x10_2 << 1
        size_t bytes_1
        
        if (bytes_5 u< x8 + 1)
            bytes_1 = x8 + 1
        else
            bytes_1 = bytes_5
        
        arg2[2] = bytes_1
        x0_2 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_2
        
        if (x0_2 != 0)
            x8 = arg2[1]
            goto label_49e348
    else
        x0_2 = *arg2
    label_49e348:
        x0_2[x8] = 0x3c
        arg2[1] += 1
        int64_t* x0_3 = *(arg1 + 0x20)
        (*(*x0_3 + 0x20))(x0_3, arg2)
        int64_t x8_6 = arg2[1]
        int64_t x10_3 = arg2[2]
        int16_t* x0_4
        
        if (x8_6 + 2 u>= x10_3)
            int64_t oldmem_2 = *arg2
            size_t bytes_6 = x10_3 << 1
            size_t bytes_2
            
            if (bytes_6 u< x8_6 + 2)
                bytes_2 = x8_6 + 2
            else
                bytes_2 = bytes_6
            
            arg2[2] = bytes_2
            x0_4 = realloc(oldmem_2, bytes_2)
            *arg2 = x0_4
            
            if (x0_4 != 0)
                x8_6 = arg2[1]
                goto label_49e3ac
        else
            x0_4 = *arg2
        label_49e3ac:
            *(x0_4 + x8_6) = 0x283e
            arg2[1] += 2
            int64_t* x0_5 = *(arg1 + 0x28)
            (*(*x0_5 + 0x20))(x0_5, arg2)
            int64_t x8_11 = arg2[1]
            int64_t x10_4 = arg2[2]
            char* result
            
            if (x8_11 + 1 u< x10_4)
                result = *arg2
            label_49e410:
                result[x8_11] = 0x29
                arg2[1] += 1
                return result
            
            int64_t oldmem_3 = *arg2
            int64_t bytes_7 = x10_4 << 1
            size_t bytes_3
            
            if (bytes_7 u< x8_11 + 1)
                bytes_3 = x8_11 + 1
            else
                bytes_3 = bytes_7
            
            arg2[2] = bytes_3
            result = realloc(oldmem_3, bytes_3)
            *arg2 = result
            
            if (result != 0)
                x8_11 = arg2[1]
                goto label_49e410
sub_491944()
noreturn
