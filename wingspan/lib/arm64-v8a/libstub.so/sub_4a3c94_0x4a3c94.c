// 函数: sub_4a3c94
// 地址: 0x4a3c94
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x8 = arg2[1]
int64_t x10 = arg2[2]
char* x0

if (x8 + 1 u>= x10)
    int64_t oldmem = *arg2
    size_t bytes_8 = x10 << 1
    size_t bytes
    
    if (bytes_8 u< x8 + 1)
        bytes = x8 + 1
    else
        bytes = bytes_8
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8 = arg2[1]
        goto label_4a3ce8
else
    x0 = *arg2
label_4a3ce8:
    x0[x8] = 0x28
    arg2[1] += 1
    sub_49cc90(arg1 + 0x18, arg2)
    int64_t x8_3 = arg2[1]
    int64_t x10_1 = arg2[2]
    char* x0_2
    
    if (x8_3 + 1 u>= x10_1)
        int64_t oldmem_1 = *arg2
        size_t bytes_9 = x10_1 << 1
        size_t bytes_1
        
        if (bytes_9 u< x8_3 + 1)
            bytes_1 = x8_3 + 1
        else
            bytes_1 = bytes_9
        
        arg2[2] = bytes_1
        x0_2 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_2
        
        if (x0_2 != 0)
            x8_3 = arg2[1]
            goto label_4a3d44
    else
        x0_2 = *arg2
    label_4a3d44:
        x0_2[x8_3] = 0x29
        arg2[1] += 1
        int64_t* x0_3 = *(arg1 + 0x10)
        int16_t* result = (*(*x0_3 + 0x28))(x0_3, arg2)
        int32_t x8_8 = *(arg1 + 0x28)
        
        if ((x8_8 & 1) == 0)
            goto label_4a3dd4
        
        int64_t x8_9 = arg2[1]
        int64_t x10_2 = arg2[2]
        
        if (x8_9 + 6 u>= x10_2)
            int64_t oldmem_2 = *arg2
            size_t bytes_10 = x10_2 << 1
            size_t bytes_2
            
            if (bytes_10 u< x8_9 + 6)
                bytes_2 = x8_9 + 6
            else
                bytes_2 = bytes_10
            
            arg2[2] = bytes_2
            result = realloc(oldmem_2, bytes_2)
            *arg2 = result
            
            if (result != 0)
                x8_9 = arg2[1]
                goto label_4a3dc0
        else
            result = *arg2
        label_4a3dc0:
            __builtin_strncpy(result + x8_9, " const", 6)
            arg2[1] += 6
            x8_8 = *(arg1 + 0x28)
        label_4a3dd4:
            
            if ((x8_8 & 2) == 0)
                goto label_4a3e40
            
            int64_t x8_13 = arg2[1]
            int64_t x10_3 = arg2[2]
            
            if (x8_13 + 9 u>= x10_3)
                int64_t oldmem_3 = *arg2
                size_t bytes_11 = x10_3 << 1
                size_t bytes_3
                
                if (bytes_11 u< x8_13 + 9)
                    bytes_3 = x8_13 + 9
                else
                    bytes_3 = bytes_11
                
                arg2[2] = bytes_3
                result = realloc(oldmem_3, bytes_3)
                *arg2 = result
                
                if (result != 0)
                    x8_13 = arg2[1]
                    goto label_4a3e2c
            else
                result = *arg2
            label_4a3e2c:
                __builtin_strncpy(result + x8_13, " volatile", 9)
                arg2[1] += 9
                x8_8 = *(arg1 + 0x28)
            label_4a3e40:
                
                if ((x8_8 & 4) == 0)
                    goto label_4a3ea8
                
                int64_t x8_17 = arg2[1]
                int64_t x10_4 = arg2[2]
                
                if (x8_17 + 9 u>= x10_4)
                    int64_t oldmem_4 = *arg2
                    size_t bytes_12 = x10_4 << 1
                    size_t bytes_4
                    
                    if (bytes_12 u< x8_17 + 9)
                        bytes_4 = x8_17 + 9
                    else
                        bytes_4 = bytes_12
                    
                    arg2[2] = bytes_4
                    result = realloc(oldmem_4, bytes_4)
                    *arg2 = result
                    
                    if (result != 0)
                        x8_17 = arg2[1]
                        goto label_4a3e98
                else
                    result = *arg2
                label_4a3e98:
                    __builtin_strncpy(result + x8_17, " restrict", 9)
                    arg2[1] += 9
                label_4a3ea8:
                    uint32_t x8_21 = zx.d(*(arg1 + 0x2c))
                    int64_t x8_24
                    
                    if (x8_21 == 2)
                        int64_t x8_23 = arg2[1]
                        int64_t x10_6 = arg2[2]
                        
                        if (x8_23 + 3 u>= x10_6)
                            int64_t oldmem_6 = *arg2
                            size_t bytes_14 = x10_6 << 1
                            size_t bytes_6
                            
                            if (bytes_14 u< x8_23 + 3)
                                bytes_6 = x8_23 + 3
                            else
                                bytes_6 = bytes_14
                            
                            arg2[2] = bytes_6
                            result = realloc(oldmem_6, bytes_6)
                            *arg2 = result
                            
                            if (result != 0)
                                x8_23 = arg2[1]
                                goto label_4a3f44
                        else
                            result = *arg2
                        label_4a3f44:
                            void* x8_25 = result + x8_23
                            *(x8_25 + 2) = 0x26
                            *x8_25 = 0x2620
                            x8_24 = 3
                        label_4a3f64:
                            arg2[1] += x8_24
                        label_4a3f6c:
                            
                            if (*(arg1 + 0x30) == 0)
                                return result
                            
                            int64_t x8_28 = arg2[1]
                            int64_t x10_7 = arg2[2]
                            size_t bytes_16 = x8_28 + 1
                            char* x0_4
                            
                            if (bytes_16 u< x10_7)
                                x0_4 = *arg2
                            label_4a3fb0:
                                arg2[1] = bytes_16
                                x0_4[x8_28] = 0x20
                                int64_t* x20_1 = *(arg1 + 0x30)
                                result = (*(*x20_1 + 0x20))(x20_1, arg2)
                                
                                if (zx.d(*(x20_1 + 9)) != 1)
                                    jump(*(*x20_1 + 0x28))
                                
                                return result
                            
                            int64_t oldmem_7 = *arg2
                            size_t bytes_15 = x10_7 << 1
                            size_t bytes_7
                            
                            bytes_7 = bytes_15 u< bytes_16 ? bytes_16 : bytes_15
                            
                            arg2[2] = bytes_7
                            x0_4 = realloc(oldmem_7, bytes_7)
                            *arg2 = x0_4
                            
                            if (x0_4 != 0)
                                x8_28 = arg2[1]
                                bytes_16 = x8_28 + 1
                                goto label_4a3fb0
                    else
                        if (x8_21 != 1)
                            goto label_4a3f6c
                        
                        int64_t x8_22 = arg2[1]
                        int64_t x10_5 = arg2[2]
                        
                        if (x8_22 + 2 u< x10_5)
                            result = *arg2
                        label_4a3f14:
                            *(result + x8_22) = 0x2620
                            x8_24 = 2
                            goto label_4a3f64
                        
                        int64_t oldmem_5 = *arg2
                        size_t bytes_13 = x10_5 << 1
                        size_t bytes_5
                        
                        if (bytes_13 u< x8_22 + 2)
                            bytes_5 = x8_22 + 2
                        else
                            bytes_5 = bytes_13
                        
                        arg2[2] = bytes_5
                        result = realloc(oldmem_5, bytes_5)
                        *arg2 = result
                        
                        if (result != 0)
                            x8_22 = arg2[1]
                            goto label_4a3f14
sub_491944()
noreturn
