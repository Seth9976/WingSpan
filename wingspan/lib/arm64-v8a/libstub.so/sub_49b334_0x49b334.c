// 函数: sub_49b334
// 地址: 0x49b334
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x20 = arg1

if (*(arg1 + 0x18) - *(arg1 + 0x10) u< 4)
    goto label_49b460

int64_t x8_2 = arg2[1]
int64_t x10_1 = arg2[2]
char* x0

if (x8_2 + 1 u>= x10_1)
    void* oldmem = *arg2
    size_t bytes_7 = x10_1 << 1
    size_t bytes
    
    if (bytes_7 u< x8_2 + 1)
        bytes = x8_2 + 1
    else
        bytes = bytes_7
    
    arg2[2] = bytes
    x0 = realloc(oldmem, bytes)
    *arg2 = x0
    
    if (x0 != 0)
        x8_2 = arg2[1]
        goto label_49b39c
else
    x0 = *arg2
label_49b39c:
    x0[x8_2] = 0x28
    int64_t x8_4 = arg2[1] + 1
    arg2[1] = x8_4
    int64_t x22_1 = *(x20 + 0x10)
    int64_t x9_2 = *(x20 + 0x18)
    size_t x21_1 = x9_2 - x22_1
    
    if (x9_2 == x22_1)
        goto label_49b410
    
    int64_t x10_2 = arg2[2]
    size_t bytes_14 = x8_4 + x21_1
    void* x0_1
    
    if (bytes_14 u>= x10_2)
        void* oldmem_1 = *arg2
        size_t bytes_8 = x10_2 << 1
        size_t bytes_1
        
        bytes_1 = bytes_8 u< bytes_14 ? bytes_14 : bytes_8
        
        arg2[2] = bytes_1
        x0_1 = realloc(oldmem_1, bytes_1)
        *arg2 = x0_1
        
        if (x0_1 != 0)
            x8_4 = arg2[1]
            goto label_49b400
    else
        x0_1 = *arg2
    label_49b400:
        memmove(x0_1 + x8_4, x22_1, x21_1)
        x8_4 = arg2[1] + x21_1
        arg2[1] = x8_4
    label_49b410:
        int64_t x10_3 = arg2[2]
        
        if (x8_4 + 1 u>= x10_3)
            void* oldmem_2 = *arg2
            size_t bytes_9 = x10_3 << 1
            size_t bytes_2
            
            if (bytes_9 u< x8_4 + 1)
                bytes_2 = x8_4 + 1
            else
                bytes_2 = bytes_9
            
            arg2[2] = bytes_2
            arg1 = realloc(oldmem_2, bytes_2)
            *arg2 = arg1
            
            if (arg1 != 0)
                x8_4 = arg2[1]
                goto label_49b450
        else
            arg1 = *arg2
        label_49b450:
            arg1[x8_4] = 0x29
            arg2[1] += 1
        label_49b460:
            char* x21_2 = *(x20 + 0x20)
            int64_t x8_15
            
            if (zx.d(*x21_2) != 0x6e)
                int64_t x8_10 = *(x20 + 0x28)
                size_t x22_2 = x8_10 - x21_2
                
                if (x8_10 == x21_2)
                    goto label_49b590
                
                int64_t x8_11 = arg2[1]
                int64_t x10_5 = arg2[2]
                size_t bytes_15 = x8_11 + x22_2
                void* x0_3
                
                if (bytes_15 u>= x10_5)
                    void* oldmem_4 = *arg2
                    size_t bytes_11 = x10_5 << 1
                    size_t bytes_4
                    
                    bytes_4 = bytes_11 u< bytes_15 ? bytes_15 : bytes_11
                    
                    arg2[2] = bytes_4
                    x0_3 = realloc(oldmem_4, bytes_4)
                    *arg2 = x0_3
                    
                    if (x0_3 != 0)
                        x8_11 = arg2[1]
                        goto label_49b540
                else
                    x0_3 = *arg2
                label_49b540:
                    memmove(x0_3 + x8_11, x21_2, x22_2)
                    x8_15 = arg2[1] + x22_2
                label_49b58c:
                    arg2[1] = x8_15
                label_49b590:
                    int64_t x21_4 = *(x20 + 0x10)
                    size_t x20_1 = *(x20 + 0x18) - x21_4
                    
                    if (x20_1 - 1 u> 2)
                        return 
                    
                    int64_t x8_19 = arg2[1]
                    int64_t x10_8 = arg2[2]
                    size_t bytes_17 = x8_19 + x20_1
                    void* x0_7
                    
                    if (bytes_17 u< x10_8)
                        x0_7 = *arg2
                    label_49b5ec:
                        memmove(x0_7 + x8_19, x21_4, x20_1)
                        arg2[1] += x20_1
                        return 
                    
                    void* oldmem_6 = *arg2
                    size_t bytes_13 = x10_8 << 1
                    size_t bytes_6
                    
                    bytes_6 = bytes_13 u< bytes_17 ? bytes_17 : bytes_13
                    
                    arg2[2] = bytes_6
                    x0_7 = realloc(oldmem_6, bytes_6)
                    *arg2 = x0_7
                    
                    if (x0_7 != 0)
                        x8_19 = arg2[1]
                        goto label_49b5ec
            else
                int64_t x8_9 = arg2[1]
                int64_t x10_4 = arg2[2]
                
                if (x8_9 + 1 u>= x10_4)
                    void* oldmem_3 = *arg2
                    size_t bytes_10 = x10_4 << 1
                    size_t bytes_3
                    
                    if (bytes_10 u< x8_9 + 1)
                        bytes_3 = x8_9 + 1
                    else
                        bytes_3 = bytes_10
                    
                    arg2[2] = bytes_3
                    arg1 = realloc(oldmem_3, bytes_3)
                    *arg2 = arg1
                    
                    if (arg1 != 0)
                        x8_9 = arg2[1]
                        goto label_49b4d4
                else
                    arg1 = *arg2
                label_49b4d4:
                    arg1[x8_9] = 0x2d
                    int64_t x8_13 = arg2[1] + 1
                    arg2[1] = x8_13
                    int64_t x10_6 = *(x20 + 0x20)
                    int64_t x9_5 = *(x20 + 0x28)
                    int64_t x22_3
                    
                    if (x9_5 != x10_6)
                        x22_3 = x10_6 + 1
                    else
                        x22_3 = x10_6
                    
                    size_t x21_3 = x9_5 - x22_3
                    
                    if (x9_5 == x22_3)
                        goto label_49b590
                    
                    int64_t x10_7 = arg2[2]
                    size_t bytes_16 = x8_13 + x21_3
                    void* x0_4
                    
                    if (bytes_16 u< x10_7)
                        x0_4 = *arg2
                    label_49b580:
                        memmove(x0_4 + x8_13, x22_3, x21_3)
                        x8_15 = arg2[1] + x21_3
                        goto label_49b58c
                    
                    void* oldmem_5 = *arg2
                    size_t bytes_12 = x10_7 << 1
                    size_t bytes_5
                    
                    bytes_5 = bytes_12 u< bytes_16 ? bytes_16 : bytes_12
                    
                    arg2[2] = bytes_5
                    x0_4 = realloc(oldmem_5, bytes_5)
                    *arg2 = x0_4
                    
                    if (x0_4 != 0)
                        x8_13 = arg2[1]
                        goto label_49b580
sub_491944()
noreturn
