// 函数: sub_49abf8
// 地址: 0x49abf8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x22 = *arg1
char* x8 = arg1[1]
char* x9_1
char* x23

if (x22 == x8)
    x9_1 = x22
    
    if (x9_1 == x8 || zx.d(*x9_1) - 0x30 u> 9)
        x22 = nullptr
        x23 = nullptr
    else
    label_49acf4:
        void* x9_4 = &x9_1[1]
        
        while (true)
            *arg1 = x9_4
            
            if (x8 == x9_4)
                x9_1 = x8
                x23 = x8
                break
            
            uint32_t x10_3 = zx.d(*x9_4)
            x9_4 += 1
            
            if (x10_3 - 0x30 u>= 0xa)
                x9_1 = x9_4 - 1
                x23 = x9_1
                break
else
    x9_1 = x22
    
    if (zx.d(*x22) == 0x6e)
        x9_1 = &x22[1]
        *arg1 = x9_1
    
    if (x9_1 != x8 && zx.d(*x9_1) - 0x30 u<= 9)
        goto label_49acf4
    
    x22 = nullptr
    x23 = nullptr

void* result = nullptr

if (x22 != x23 && x9_1 != x8)
    if (zx.d(*x9_1) != 0x45)
        return nullptr
    
    void** x24_1 = arg1[0x266]
    *arg1 = &x9_1[1]
    int64_t x8_3 = x24_1[1]
    
    if (x8_3 + 0x30 u>= 0xff0)
        void** x0 = malloc(0x1000)
        
        if (x0 == 0)
            sub_491944()
            noreturn
        
        x8_3 = 0
        *x0 = x24_1
        x0[1] = 0
        x24_1 = x0
        arg1[0x266] = x0
    
    x24_1[1] = x8_3 + 0x30
    result = x24_1 + x8_3 + 0x10
    *result = &_vtable_for_(anonymous namespace)::itanium_demangle::IntegerLiteral{for `(anonymous namespace)::itanium_demangle::Node'}
    *(result + 8) = 0x1010145
    *(result + 0x10) = arg2
    *(result + 0x18) = arg3
    *(result + 0x20) = x22
    *(result + 0x28) = x23

return result
