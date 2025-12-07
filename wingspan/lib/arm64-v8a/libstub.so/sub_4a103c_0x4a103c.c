// 函数: sub_4a103c
// 地址: 0x4a103c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]

if (zx.d(*(arg1 + 0x38)) == 0)
    goto label_4a10c8

int64_t x10_1 = arg2[2]
int64_t x0

if (x8 + 0xb u>= x10_1)
    int64_t oldmem = *arg2
    int64_t bytes_8 = x10_1 << 1
    int64_t bytes
    
    if (bytes_8 u< x8 + 0xb)
        bytes = x8 + 0xb
    else
        bytes = bytes_8
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_4a10b4
else
    x0 = *arg2
label_4a10b4:
    __builtin_strncpy(x0 + x8, "::operator ", 0xb)
    x8 = arg2[1] + 0xb
    arg2[1] = x8
label_4a10c8:
    int64_t x10_2 = arg2[2]
    void* x0_1
    
    if (x8 + 3 u>= x10_2)
        int64_t oldmem_1 = *arg2
        size_t bytes_9 = x10_2 << 1
        size_t bytes_1
        
        if (bytes_9 u< x8 + 3)
            bytes_1 = x8 + 3
        else
            bytes_1 = bytes_9
        
        arg2[2] = bytes_1
        x0_1 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_1
        
        if (x0_1 != 0)
            x8 = arg2[1]
            goto label_4a1104
    else
        x0_1 = *arg2
    label_4a1104:
        int16_t* x8_3 = x0_1 + x8
        x8_3[1].b = 0x77
        *x8_3 = 0x656e
        int64_t x9_3 = arg2[1]
        int64_t x8_4 = x9_3 + 3
        arg2[1] = x8_4
        
        if (zx.d(*(arg1 + 0x39)) == 0)
            goto label_4a117c
        
        int64_t x10_4 = arg2[2]
        int16_t* x0_2
        
        if (x9_3 + 5 u>= x10_4)
            int64_t oldmem_2 = *arg2
            size_t bytes_10 = x10_4 << 1
            size_t bytes_2
            
            if (bytes_10 u< x9_3 + 5)
                bytes_2 = x9_3 + 5
            else
                bytes_2 = bytes_10
            
            arg2[2] = bytes_2
            x0_2 = realloc(oldmem_2, bytes_2)
            *arg2 = x0_2
            
            if (x0_2 != 0)
                x8_4 = arg2[1]
                goto label_4a116c
        else
            x0_2 = *arg2
        label_4a116c:
            *(x0_2 + x8_4) = 0x5d5b
            x8_4 = arg2[1] + 2
            arg2[1] = x8_4
        label_4a117c:
            int64_t x10_5 = arg2[2]
            size_t bytes_16 = x8_4 + 1
            char* x0_3
            
            if (bytes_16 u>= x10_5)
                int64_t oldmem_3 = *arg2
                size_t bytes_11 = x10_5 << 1
                size_t bytes_3
                
                bytes_3 = bytes_11 u< bytes_16 ? bytes_16 : bytes_11
                
                arg2[2] = bytes_3
                x0_3 = realloc(oldmem_3, bytes_3)
                *arg2 = x0_3
                
                if (x0_3 != 0)
                    x8_4 = arg2[1]
                    bytes_16 = x8_4 + 1
                    goto label_4a11bc
            else
                x0_3 = *arg2
            label_4a11bc:
                arg2[1] = bytes_16
                x0_3[x8_4] = 0x20
                
                if (*(arg1 + 0x18) == 0)
                    goto label_4a127c
                
                int64_t x8_7 = arg2[1]
                int64_t x10_6 = arg2[2]
                char* x0_4
                
                if (x8_7 + 1 u>= x10_6)
                    int64_t oldmem_4 = *arg2
                    size_t bytes_12 = x10_6 << 1
                    size_t bytes_4
                    
                    if (bytes_12 u< x8_7 + 1)
                        bytes_4 = x8_7 + 1
                    else
                        bytes_4 = bytes_12
                    
                    arg2[2] = bytes_4
                    x0_4 = realloc(oldmem_4, bytes_4)
                    *arg2 = x0_4
                    
                    if (x0_4 != 0)
                        x8_7 = arg2[1]
                        goto label_4a1210
                else
                    x0_4 = *arg2
                label_4a1210:
                    x0_4[x8_7] = 0x28
                    arg2[1] += 1
                    sub_49cc90(arg1 + 0x10, arg2)
                    int64_t x8_10 = arg2[1]
                    int64_t x10_7 = arg2[2]
                    char* x0_6
                    
                    if (x8_10 + 1 u>= x10_7)
                        int64_t oldmem_5 = *arg2
                        size_t bytes_13 = x10_7 << 1
                        size_t bytes_5
                        
                        if (bytes_13 u< x8_10 + 1)
                            bytes_5 = x8_10 + 1
                        else
                            bytes_5 = bytes_13
                        
                        arg2[2] = bytes_5
                        x0_6 = realloc(oldmem_5, bytes_5)
                        *arg2 = x0_6
                        
                        if (x0_6 != 0)
                            x8_10 = arg2[1]
                            goto label_4a126c
                    else
                        x0_6 = *arg2
                    label_4a126c:
                        x0_6[x8_10] = 0x29
                        arg2[1] += 1
                    label_4a127c:
                        int64_t* x21_1 = *(arg1 + 0x20)
                        char* result = (*(*x21_1 + 0x20))(x21_1, arg2)
                        
                        if (zx.d(*(x21_1 + 9)) != 1)
                            result = (*(*x21_1 + 0x28))(x21_1, arg2)
                        
                        if (*(arg1 + 0x30) == 0)
                            return result
                        
                        int64_t x8_19 = arg2[1]
                        int64_t x10_8 = arg2[2]
                        char* x0_9
                        
                        if (x8_19 + 1 u>= x10_8)
                            int64_t oldmem_6 = *arg2
                            size_t bytes_14 = x10_8 << 1
                            size_t bytes_6
                            
                            if (bytes_14 u< x8_19 + 1)
                                bytes_6 = x8_19 + 1
                            else
                                bytes_6 = bytes_14
                            
                            arg2[2] = bytes_6
                            x0_9 = realloc(oldmem_6, bytes_6)
                            *arg2 = x0_9
                            
                            if (x0_9 != 0)
                                x8_19 = arg2[1]
                                goto label_4a12fc
                        else
                            x0_9 = *arg2
                        label_4a12fc:
                            x0_9[x8_19] = 0x28
                            arg2[1] += 1
                            sub_49cc90(arg1 + 0x28, arg2)
                            int64_t x8_22 = arg2[1]
                            int64_t x10_9 = arg2[2]
                            
                            if (x8_22 + 1 u< x10_9)
                                result = *arg2
                            label_4a1358:
                                result[x8_22] = 0x29
                                arg2[1] += 1
                                return result
                            
                            int64_t oldmem_7 = *arg2
                            size_t bytes_15 = x10_9 << 1
                            size_t bytes_7
                            
                            if (bytes_15 u< x8_22 + 1)
                                bytes_7 = x8_22 + 1
                            else
                                bytes_7 = bytes_15
                            
                            arg2[2] = bytes_7
                            result = realloc(oldmem_7, bytes_7)
                            *arg2 = result
                            
                            if (result != 0)
                                x8_22 = arg2[1]
                                goto label_4a1358
sub_491944()
noreturn
