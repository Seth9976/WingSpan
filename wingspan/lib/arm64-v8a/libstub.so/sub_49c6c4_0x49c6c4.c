// 函数: sub_49c6c4
// 地址: 0x49c6c4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
int16_t* x20 = arg1
int32_t x8_1 = *(arg1 + 0xc)
int64_t x8_5
void* x21_2

if (x8_1 == 2)
    x21_2 = &arg2[1]
    int64_t x8_3 = *x21_2
    int64_t x10_3 = *(x21_2 + 8)
    
    if (x8_3 + 3 u>= x10_3)
        void* oldmem_1 = *arg2
        size_t bytes_6 = x10_3 << 1
        size_t bytes_1
        
        if (bytes_6 u< x8_3 + 3)
            bytes_1 = x8_3 + 3
        else
            bytes_1 = bytes_6
        
        arg2[2] = bytes_1
        arg1 = realloc(oldmem_1, bytes_1)
        *arg2 = arg1
        
        if (arg1 != 0)
            x8_3 = *x21_2
            goto label_49c7b8
    else
        arg1 = *arg2
    label_49c7b8:
        void* x8_4 = arg1 + x8_3
        *(x8_4 + 2) = 0x54
        *x8_4 = 0x5424
        x8_5 = 3
    label_49c80c:
        *x21_2 += x8_5
    label_49c810:
        int32_t x8_7 = *(x20 + 0x10)
        
        if (x8_7 == 0)
            goto label_49c914
        
        if (x8_7 == 1)
            int64_t x8_10 = arg2[1]
            int64_t x10_5 = arg2[2]
            size_t bytes_11 = x8_10 + 1
            
            if (bytes_11 u< x10_5)
                arg1 = *arg2
            label_49c900:
                arg2[1] = bytes_11
                *(arg1 + x8_10) = 0x30
            label_49c914:
                
                if (*(x22 + 0x28) == x8)
                    return 
                
                __stack_chk_fail()
                noreturn
            
            void* oldmem_4 = *arg2
            size_t bytes_9 = x10_5 << 1
            size_t bytes_4
            
            bytes_4 = bytes_9 u< bytes_11 ? bytes_11 : bytes_9
            
            arg2[2] = bytes_4
            arg1 = realloc(oldmem_4, bytes_4)
            *arg2 = arg1
            
            if (arg1 != 0)
                x8_10 = arg2[1]
                bytes_11 = x8_10 + 1
                goto label_49c900
        else
            uint64_t x9_6 = zx.q(x8_7 - 1)
            void var_3b
            void* x20_1 = &var_3b
            bool cond:0_1
            
            do
                uint64_t x12_2 = x9_6 u/ 0xa
                cond:0_1 = x9_6 u> 9
                x20_1 -= 1
                *x20_1 = (x9_6.b - x12_2.b * 0xa) | 0x30
                x9_6 = x12_2
            while (cond:0_1)
            size_t x21_5 = &var_3b - x20_1
            
            if (&var_3b == x20_1)
                goto label_49c914
            
            int64_t x8_9 = arg2[1]
            int64_t x10_4 = arg2[2]
            size_t bytes_10 = x8_9 + x21_5
            void* x0
            
            if (bytes_10 u< x10_4)
                x0 = *arg2
            label_49c8c4:
                memmove(x0 + x8_9, x20_1, x21_5)
                arg2[1] += x21_5
                goto label_49c914
            
            void* oldmem_3 = *arg2
            size_t bytes_8 = x10_4 << 1
            size_t bytes_3
            
            bytes_3 = bytes_8 u< bytes_10 ? bytes_10 : bytes_8
            
            arg2[2] = bytes_3
            x0 = realloc(oldmem_3, bytes_3)
            *arg2 = x0
            
            if (x0 != 0)
                x8_9 = arg2[1]
                goto label_49c8c4
else
    int64_t x8_2
    int16_t x9_3
    
    if (x8_1 == 1)
        x21_2 = &arg2[1]
        x8_2 = *x21_2
        int64_t x10_2 = *(x21_2 + 8)
        
        if (x8_2 + 2 u< x10_2)
            arg1 = *arg2
            x9_3 = 0x4e24
        label_49c7fc:
            *(arg1 + x8_2) = x9_3
            x8_5 = 2
            goto label_49c80c
        
        void* oldmem = *arg2
        size_t bytes_5 = x10_2 << 1
        size_t bytes
        
        if (bytes_5 u< x8_2 + 2)
            bytes = x8_2 + 2
        else
            bytes = bytes_5
        
        arg2[2] = bytes
        arg1 = realloc(oldmem, bytes)
        *arg2 = arg1
        
        if (arg1 != 0)
            x8_2 = *x21_2
            x9_3 = 0x4e24
            goto label_49c7fc
    else
        if (x8_1 != 0)
            goto label_49c810
        
        x21_2 = &arg2[1]
        x8_2 = *x21_2
        int64_t x10_1 = *(x21_2 + 8)
        
        if (x8_2 + 2 u< x10_1)
            arg1 = *arg2
        label_49c7f8:
            x9_3 = 0x5424
            goto label_49c7fc
        
        void* oldmem_2 = *arg2
        size_t bytes_7 = x10_1 << 1
        size_t bytes_2
        
        if (bytes_7 u< x8_2 + 2)
            bytes_2 = x8_2 + 2
        else
            bytes_2 = bytes_7
        
        arg2[2] = bytes_2
        arg1 = realloc(oldmem_2, bytes_2)
        *arg2 = arg1
        
        if (arg1 != 0)
            x8_2 = *x21_2
            goto label_49c7f8
sub_491944()
noreturn
