// 函数: sub_4a2b30
// 地址: 0x4a2b30
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
char* x0

if (x8 + 1 u>= x10)
    int64_t oldmem = *arg2
    size_t bytes_7 = x10 << 1
    size_t bytes
    
    if (bytes_7 u< x8 + 1)
        bytes = x8 + 1
    else
        bytes = bytes_7
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_4a2b84
else
    x0 = *arg2
label_4a2b84:
    x0[x8] = 0x28
    arg2[1] += 1
    sub_49cc90(arg1 + 0x20, arg2)
    int64_t x8_3 = arg2[1]
    int64_t x10_1 = arg2[2]
    char* x0_2
    
    if (x8_3 + 1 u>= x10_1)
        int64_t oldmem_1 = *arg2
        size_t bytes_8 = x10_1 << 1
        size_t bytes_1
        
        if (bytes_8 u< x8_3 + 1)
            bytes_1 = x8_3 + 1
        else
            bytes_1 = bytes_8
        
        arg2[2] = bytes_1
        x0_2 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_2
        
        if (x0_2 != 0)
            x8_3 = arg2[1]
            goto label_4a2be0
    else
        x0_2 = *arg2
    label_4a2be0:
        x0_2[x8_3] = 0x29
        arg2[1] += 1
        int64_t* result = *(arg1 + 0x10)
        
        if (result != 0)
            result = (*(*result + 0x28))(result, arg2)
        
        int32_t x8_12 = *(arg1 + 0x38)
        
        if ((x8_12 & 1) == 0)
            goto label_4a2c74
        
        int64_t x8_8 = arg2[1]
        int64_t x10_2 = arg2[2]
        
        if (x8_8 + 6 u>= x10_2)
            int64_t oldmem_2 = *arg2
            size_t bytes_9 = x10_2 << 1
            size_t bytes_2
            
            if (bytes_9 u< x8_8 + 6)
                bytes_2 = x8_8 + 6
            else
                bytes_2 = bytes_9
            
            arg2[2] = bytes_2
            result = realloc(oldmem_2, bytes_2)
            *arg2 = result
            
            if (result != 0)
                x8_8 = arg2[1]
                goto label_4a2c60
        else
            result = *arg2
        label_4a2c60:
            __builtin_strncpy(result + x8_8, " const", 6)
            arg2[1] += 6
            x8_12 = *(arg1 + 0x38)
        label_4a2c74:
            
            if ((x8_12 & 2) == 0)
                goto label_4a2ce0
            
            int64_t x8_13 = arg2[1]
            int64_t x10_3 = arg2[2]
            
            if (x8_13 + 9 u>= x10_3)
                int64_t oldmem_3 = *arg2
                size_t bytes_10 = x10_3 << 1
                size_t bytes_3
                
                if (bytes_10 u< x8_13 + 9)
                    bytes_3 = x8_13 + 9
                else
                    bytes_3 = bytes_10
                
                arg2[2] = bytes_3
                result = realloc(oldmem_3, bytes_3)
                *arg2 = result
                
                if (result != 0)
                    x8_13 = arg2[1]
                    goto label_4a2ccc
            else
                result = *arg2
            label_4a2ccc:
                __builtin_strncpy(result + x8_13, " volatile", 9)
                arg2[1] += 9
                x8_12 = *(arg1 + 0x38)
            label_4a2ce0:
                
                if ((x8_12 & 4) == 0)
                    goto label_4a2d48
                
                int64_t x8_17 = arg2[1]
                int64_t x10_4 = arg2[2]
                
                if (x8_17 + 9 u>= x10_4)
                    int64_t oldmem_4 = *arg2
                    size_t bytes_11 = x10_4 << 1
                    size_t bytes_4
                    
                    if (bytes_11 u< x8_17 + 9)
                        bytes_4 = x8_17 + 9
                    else
                        bytes_4 = bytes_11
                    
                    arg2[2] = bytes_4
                    result = realloc(oldmem_4, bytes_4)
                    *arg2 = result
                    
                    if (result != 0)
                        x8_17 = arg2[1]
                        goto label_4a2d38
                else
                    result = *arg2
                label_4a2d38:
                    __builtin_strncpy(result + x8_17, " restrict", 9)
                    arg2[1] += 9
                label_4a2d48:
                    uint32_t x8_21 = zx.d(*(arg1 + 0x3c))
                    int64_t x8_24
                    
                    if (x8_21 == 2)
                        int64_t x8_23 = arg2[1]
                        int64_t x10_6 = arg2[2]
                        
                        if (x8_23 + 3 u< x10_6)
                            result = *arg2
                        label_4a2de4:
                            void* x8_25 = result + x8_23
                            *(x8_25 + 2) = 0x26
                            *x8_25 = 0x2620
                            x8_24 = 3
                        label_4a2e04:
                            arg2[1] += x8_24
                        label_4a2e08:
                            int64_t* x20_1 = *(arg1 + 0x30)
                            
                            if (x20_1 != 0)
                                result = (*(*x20_1 + 0x20))(x20_1, arg2)
                                
                                if (zx.d(*(x20_1 + 9)) != 1)
                                    jump(*(*x20_1 + 0x28))
                            
                            return result
                        
                        int64_t oldmem_6 = *arg2
                        size_t bytes_13 = x10_6 << 1
                        size_t bytes_6
                        
                        if (bytes_13 u< x8_23 + 3)
                            bytes_6 = x8_23 + 3
                        else
                            bytes_6 = bytes_13
                        
                        arg2[2] = bytes_6
                        result = realloc(oldmem_6, bytes_6)
                        *arg2 = result
                        
                        if (result != 0)
                            x8_23 = arg2[1]
                            goto label_4a2de4
                    else
                        if (x8_21 != 1)
                            goto label_4a2e08
                        
                        int64_t x8_22 = arg2[1]
                        int64_t x10_5 = arg2[2]
                        
                        if (x8_22 + 2 u< x10_5)
                            result = *arg2
                        label_4a2db4:
                            *(result + x8_22) = 0x2620
                            x8_24 = 2
                            goto label_4a2e04
                        
                        int64_t oldmem_5 = *arg2
                        size_t bytes_12 = x10_5 << 1
                        size_t bytes_5
                        
                        if (bytes_12 u< x8_22 + 2)
                            bytes_5 = x8_22 + 2
                        else
                            bytes_5 = bytes_12
                        
                        arg2[2] = bytes_5
                        result = realloc(oldmem_5, bytes_5)
                        *arg2 = result
                        
                        if (result != 0)
                            x8_22 = arg2[1]
                            goto label_4a2db4
sub_491944()
noreturn
