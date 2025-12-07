// 函数: sub_491734
// 地址: 0x491734
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void* result = sub_491918()
void* x19 = *result

if (x19 != 0)
    void* result_1 = result
    result = x19 + 0x60
    
    if (0x434c4e47432b2b != *result u>> 8)
        result = sub_4a8cc8(result)
        *result_1 = 0
    else
        int32_t x8_2 = *(x19 + 0x38)
        
        if ((x8_2 & 0x80000000) != 0)
            *(x19 + 0x38) = x8_2 + 1
            
            if (x8_2 u>= 0xffffffff)
                *result_1 = *(x19 + 0x30)
        else
            *(x19 + 0x38) = x8_2 - 1
            
            if (x8_2 == 1)
                *result_1 = *(x19 + 0x30)
                
                if (zx.q(*(x19 + 0x60)) == 1)
                    void* x20_1 = *(x19 + 8) - 0x80
                    sub_4a64d8(x19)
                    x19 = x20_1
                
                result = x19 + 0x80
                int64_t x9_1
                int32_t i
                
                do
                    x9_1 = __ldaxr(x19 + 8)
                    i = __stlxr(x9_1 - 1, x19 + 8)
                while (i != 0)
                
                if (x9_1 == 1)
                    int64_t x8_8 = *(x19 + 0x18)
                    
                    if (x8_8 != 0)
                        x8_8()
                    
                    return sub_4a64d8(x19)

return result
