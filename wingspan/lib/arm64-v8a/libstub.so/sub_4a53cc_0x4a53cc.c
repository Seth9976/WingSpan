// 函数: sub_4a53cc
// 地址: 0x4a53cc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (zx.d(*(arg1 + 0x1c)) != 0)
    return 

int64_t* x21_1 = *(arg1 + 0x10)
*(arg1 + 0x1c) = 1
void* x0_1 = (*(*x21_1 + 0x18))(x21_1)

while (zx.d(*(x0_1 + 8)) == 0xc)
    x21_1 = *(x0_1 + 0x10)
    x0_1 = (*(*x21_1 + 0x18))(x21_1, arg2)

uint32_t x8_6 = zx.d(*(x21_1 + 0xa))

if (x8_6 == 0)
label_4a548c:
    size_t x0_7 = __strlen_chk(&data_4525e5, 2)
    
    if (x0_7 != 0)
        int64_t x8_12 = arg2[1]
        int64_t x10_1 = arg2[2]
        int64_t bytes_2 = x8_12 + x0_7
        int64_t x0_8
        
        if (bytes_2 u>= x10_1)
            int64_t oldmem = *arg2
            int64_t bytes_1 = x10_1 << 1
            int64_t bytes
            
            bytes = bytes_1 u< bytes_2 ? bytes_2 : bytes_1
            
            arg2[2] = bytes
            x0_8 = realloc(oldmem, bytes)
            *arg2 = x0_8
            
            if (x0_8 == 0)
                sub_491944()
                noreturn
            
            x8_12 = arg2[1]
        else
            x0_8 = *arg2
        
        memcpy(x0_8 + x8_12, &data_4525e5, x0_7)
        arg2[1] += x0_7
else
    int32_t x0_4
    
    if (x8_6 == 2)
        x0_4 = (*(*x21_1 + 8))(x21_1, arg2)
    
    if (x8_6 == 2 && (x0_4 & 1) != 0)
        goto label_4a548c
    
    uint32_t x8_9 = zx.d(*(x21_1 + 0xb))
    
    if (x8_9 == 0)
        goto label_4a548c
    
    if (x8_9 == 2 && ((*(*x21_1 + 0x10))(x21_1, arg2) & 1) != 0)
        goto label_4a548c

(*(*x21_1 + 0x28))(x21_1, arg2)
*(arg1 + 0x1c) = 0
