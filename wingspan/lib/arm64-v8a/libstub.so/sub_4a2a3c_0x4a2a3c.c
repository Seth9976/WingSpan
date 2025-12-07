// 函数: sub_4a2a3c
// 地址: 0x4a2a3c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t* x0 = *(arg1 + 0x10)

if (x0 != 0)
    (*(*x0 + 0x20))(x0, arg2)
    int64_t* x0_1 = *(arg1 + 0x10)
    uint32_t x8_3 = zx.d(*(x0_1 + 9))
    
    if (x8_3 != 0)
        int32_t x0_2
        
        if (x8_3 == 2)
            x0_2 = (**x0_1)(x0_1, arg2)
        
        if (x8_3 != 2 || (x0_2 & 1) == 0)
            int64_t x8_6 = arg2[1]
            int64_t x10_1 = arg2[2]
            char* x0_3
            
            if (x8_6 + 1 u>= x10_1)
                int64_t oldmem = *arg2
                size_t bytes_1 = x10_1 << 1
                size_t bytes
                
                if (bytes_1 u< x8_6 + 1)
                    bytes = x8_6 + 1
                else
                    bytes = bytes_1
                
                arg2[2] = bytes
                x0_3 = realloc(oldmem, bytes)
                *arg2 = x0_3
                
                if (x0_3 == 0)
                    sub_491944()
                    noreturn
                
                x8_6 = arg2[1]
            else
                x0_3 = *arg2
            
            x0_3[x8_6] = 0x20
            arg2[1] += 1

int64_t* x20_1 = *(arg1 + 0x18)
int64_t result = (*(*x20_1 + 0x20))(x20_1, arg2)

if (zx.d(*(x20_1 + 9)) != 1)
    jump(*(*x20_1 + 0x28))

return result
