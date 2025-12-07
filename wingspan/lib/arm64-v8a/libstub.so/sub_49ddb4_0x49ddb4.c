// 函数: sub_49ddb4
// 地址: 0x49ddb4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x9 = *(arg1 + 0x18)
int64_t x8 = *(arg1 + 0x20)

if (x8 - x9 != 1)
    goto label_49de5c

if (x9 != x8)
    char* const x10_1 = ">"
    
    do
        if (zx.d(*x9) != zx.d(*x10_1))
            goto label_49de5c
        
        x9 = &x9[1]
        x10_1 = &x10_1[1]
    while (x8 != x9)

int64_t x8_1 = arg2[1]
int64_t x10_2 = arg2[2]
char* x0

if (x8_1 + 1 u>= x10_2)
    int64_t oldmem = *arg2
    size_t bytes_7 = x10_2 << 1
    size_t bytes
    
    if (bytes_7 u< x8_1 + 1)
        bytes = x8_1 + 1
    else
        bytes = bytes_7
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8_1 = arg2[1]
        goto label_49de4c
else
    x0 = *arg2
label_49de4c:
    x0[x8_1] = 0x28
    arg2[1] += 1
label_49de5c:
    int64_t x8_4 = arg2[1]
    int64_t x10_3 = arg2[2]
    char* x0_1
    
    if (x8_4 + 1 u>= x10_3)
        int64_t oldmem_1 = *arg2
        size_t bytes_8 = x10_3 << 1
        size_t bytes_1
        
        if (bytes_8 u< x8_4 + 1)
            bytes_1 = x8_4 + 1
        else
            bytes_1 = bytes_8
        
        arg2[2] = bytes_1
        x0_1 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_1
        
        if (x0_1 != 0)
            x8_4 = arg2[1]
            goto label_49de9c
    else
        x0_1 = *arg2
    label_49de9c:
        x0_1[x8_4] = 0x28
        arg2[1] += 1
        int64_t* x21_1 = *(arg1 + 0x10)
        (*(*x21_1 + 0x20))(x21_1, arg2)
        
        if (zx.d(*(x21_1 + 9)) != 1)
            (*(*x21_1 + 0x28))(x21_1, arg2)
        
        int64_t x8_12 = arg2[1]
        int64_t x10_4 = arg2[2]
        int16_t* x0_4
        
        if (x8_12 + 2 u>= x10_4)
            int64_t oldmem_2 = *arg2
            size_t bytes_9 = x10_4 << 1
            size_t bytes_2
            
            if (bytes_9 u< x8_12 + 2)
                bytes_2 = x8_12 + 2
            else
                bytes_2 = bytes_9
            
            arg2[2] = bytes_2
            x0_4 = realloc(oldmem_2, bytes_2)
            *arg2 = x0_4
            
            if (x0_4 != 0)
                x8_12 = arg2[1]
                goto label_49df24
        else
            x0_4 = *arg2
        label_49df24:
            *(x0_4 + x8_12) = 0x2029
            int64_t x8_14 = arg2[1] + 2
            arg2[1] = x8_14
            int64_t x22_1 = *(arg1 + 0x18)
            int64_t x9_4 = *(arg1 + 0x20)
            size_t x21_2 = x9_4 - x22_1
            
            if (x9_4 == x22_1)
                goto label_49df98
            
            int64_t x10_5 = arg2[2]
            int64_t bytes_14 = x8_14 + x21_2
            int64_t x0_5
            
            if (bytes_14 u>= x10_5)
                int64_t oldmem_3 = *arg2
                int64_t bytes_10 = x10_5 << 1
                int64_t bytes_3
                
                bytes_3 = bytes_10 u< bytes_14 ? bytes_14 : bytes_10
                
                arg2[2] = bytes_3
                x0_5 = realloc(oldmem_3, bytes_3)
                *arg2 = x0_5
                
                if (x0_5 != 0)
                    x8_14 = arg2[1]
                    goto label_49df88
            else
                x0_5 = *arg2
            label_49df88:
                memmove(x0_5 + x8_14, x22_1, x21_2)
                x8_14 = arg2[1] + x21_2
                arg2[1] = x8_14
            label_49df98:
                int64_t x10_6 = arg2[2]
                int16_t* x0_7
                
                if (x8_14 + 2 u>= x10_6)
                    int64_t oldmem_4 = *arg2
                    size_t bytes_11 = x10_6 << 1
                    size_t bytes_4
                    
                    if (bytes_11 u< x8_14 + 2)
                        bytes_4 = x8_14 + 2
                    else
                        bytes_4 = bytes_11
                    
                    arg2[2] = bytes_4
                    x0_7 = realloc(oldmem_4, bytes_4)
                    *arg2 = x0_7
                    
                    if (x0_7 != 0)
                        x8_14 = arg2[1]
                        goto label_49dfd8
                else
                    x0_7 = *arg2
                label_49dfd8:
                    *(x0_7 + x8_14) = 0x2820
                    arg2[1] += 2
                    int64_t* x21_3 = *(arg1 + 0x28)
                    (*(*x21_3 + 0x20))(x21_3, arg2)
                    
                    if (zx.d(*(x21_3 + 9)) != 1)
                        (*(*x21_3 + 0x28))(x21_3, arg2)
                    
                    int64_t x8_23 = arg2[1]
                    int64_t x10_7 = arg2[2]
                    char* result
                    
                    if (x8_23 + 1 u>= x10_7)
                        int64_t oldmem_5 = *arg2
                        size_t bytes_12 = x10_7 << 1
                        size_t bytes_5
                        
                        if (bytes_12 u< x8_23 + 1)
                            bytes_5 = x8_23 + 1
                        else
                            bytes_5 = bytes_12
                        
                        arg2[2] = bytes_5
                        result = realloc(oldmem_5, bytes_5)
                        *arg2 = result
                        
                        if (result != 0)
                            x8_23 = arg2[1]
                            goto label_49e060
                    else
                        result = *arg2
                    label_49e060:
                        result[x8_23] = 0x29
                        int64_t x9_7 = arg2[1]
                        int64_t x8_24 = x9_7 + 1
                        arg2[1] = x8_24
                        char* x11_2 = *(arg1 + 0x18)
                        int64_t x10_8 = *(arg1 + 0x20)
                        
                        if (x10_8 - x11_2 != 1)
                            return result
                        
                        if (x11_2 != x10_8)
                            char* const x12_3 = ">"
                            
                            do
                                if (zx.d(*x11_2) != zx.d(*x12_3))
                                    return result
                                
                                x11_2 = &x11_2[1]
                                x12_3 = &x12_3[1]
                            while (x10_8 != x11_2)
                        
                        int64_t x10_9 = arg2[2]
                        
                        if (x9_7 + 2 u< x10_9)
                            result = *arg2
                        label_49e0f0:
                            result[x8_24] = 0x29
                            arg2[1] += 1
                            return result
                        
                        int64_t oldmem_6 = *arg2
                        size_t bytes_13 = x10_9 << 1
                        size_t bytes_6
                        
                        if (bytes_13 u< x9_7 + 2)
                            bytes_6 = x9_7 + 2
                        else
                            bytes_6 = bytes_13
                        
                        arg2[2] = bytes_6
                        result = realloc(oldmem_6, bytes_6)
                        *arg2 = result
                        
                        if (result != 0)
                            x8_24 = arg2[1]
                            goto label_49e0f0
sub_491944()
noreturn
