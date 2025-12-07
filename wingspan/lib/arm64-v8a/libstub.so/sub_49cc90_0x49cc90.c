// 函数: sub_49cc90
// 地址: 0x49cc90
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (arg1[1] == 0)
    return 

int64_t x24_1 = arg2[1]
int64_t i = 0
int32_t x23_1 = 1

do
    int64_t x26_1 = x24_1
    
    if ((x23_1 & 1) == 0)
        int64_t x9_1 = arg2[2]
        int16_t* x0
        int64_t x8_3
        
        if (x24_1 + 2 u>= x9_1)
            int64_t oldmem = *arg2
            size_t bytes_1 = x9_1 << 1
            size_t bytes
            
            if (bytes_1 u< x24_1 + 2)
                bytes = x24_1 + 2
            else
                bytes = bytes_1
            
            arg2[2] = bytes
            x0 = realloc(oldmem, bytes)
            *arg2 = x0
            
            if (x0 == 0)
                sub_491944()
                noreturn
            
            x8_3 = arg2[1]
        else
            x0 = *arg2
            x8_3 = x24_1
        
        *(x0 + x8_3) = 0x202c
        x26_1 = arg2[1] + 2
        arg2[1] = x26_1
    
    int64_t* x21_1 = *(*arg1 + (i << 3))
    (*(*x21_1 + 0x20))(x21_1, arg2)
    
    if (zx.d(*(x21_1 + 9)) != 1)
        (*(*x21_1 + 0x28))(x21_1, arg2)
    
    int64_t x8_11 = arg2[1]
    
    if (x26_1 == x8_11)
        arg2[1] = x24_1
    else
        x23_1 = 0
        x24_1 = x8_11
    
    i += 1
while (i != arg1[1])
