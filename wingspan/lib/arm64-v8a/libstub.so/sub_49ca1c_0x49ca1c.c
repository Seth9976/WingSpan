// 函数: sub_49ca1c
// 地址: 0x49ca1c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

(*(**(arg1 + 0x18) + 0x20))()
int64_t* result = *(arg1 + 0x18)
uint32_t x8_2 = zx.d(*(result + 9))

if (x8_2 != 0)
    if (x8_2 == 2)
        result = (**result)(result, arg2)
    
    if (x8_2 != 2 || (result.d & 1) == 0)
        int64_t x8_5 = arg2[1]
        int64_t x10_1 = arg2[2]
        
        if (x8_5 + 1 u>= x10_1)
            void* oldmem = *arg2
            size_t bytes_1 = x10_1 << 1
            size_t bytes
            
            if (bytes_1 u< x8_5 + 1)
                bytes = x8_5 + 1
            else
                bytes = bytes_1
            
            arg2[2] = bytes
            result = realloc(oldmem, bytes)
            *arg2 = result
            
            if (result == 0)
                sub_491944()
                noreturn
            
            x8_5 = arg2[1]
        else
            result = *arg2
        
        *(result + x8_5) = 0x20
        arg2[1] += 1

return result
