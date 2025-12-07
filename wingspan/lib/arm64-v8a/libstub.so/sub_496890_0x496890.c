// 函数: sub_496890
// 地址: 0x496890
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x9 = *arg1
int64_t x8 = arg1[1]
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::AbiTagAttr::VTable
    ** result = arg2

if (x9 != x8)
    while (zx.d(*x9) == 0x42)
        *arg1 = &x9[1]
        int64_t x9_4
        void* x24_1
        
        if (x8 != &x9[1] && zx.d(x9[1]) - 0x30 u<= 9)
            void* x10_7 = &x9[2]
            *arg1 = x10_7
            x24_1 = x10_7
            x9_4 = zx.q(x9[1]) - 0x30
            
            if (x8 != x10_7)
                do
                    if (zx.d(*x10_7) - 0x30 u>= 0xa)
                        x24_1 = x10_7
                        break
                    
                    x24_1 = x10_7 + 1
                    *arg1 = x24_1
                    x9_4 = zx.q(*x10_7) + x9_4 * 0xa - 0x30
                    x10_7 = x24_1
                while (x8 != x24_1)
        
        if (x8 == &x9[1] || zx.d(x9[1]) - 0x30 u> 9 || x8 - x24_1 u< x9_4)
            return nullptr
        
        void* x25_1 = x24_1 + x9_4
        *arg1 = x25_1
        
        if (x24_1 == x25_1)
            return nullptr
        
        void** x26_1 = arg1[0x266]
        int64_t x8_1 = x26_1[1]
        
        if (x8_1 + 0x30 u>= 0xff0)
            void** x0 = malloc(0x1000)
            
            if (x0 == 0)
                sub_491944()
                noreturn
            
            x8_1 = 0
            *x0 = x26_1
            x0[1] = 0
            x26_1 = x0
            arg1[0x266] = x0
        
        x26_1[1] = x8_1 + 0x30
        int16_t x8_2 = *(result + 9)
        char x9_2 = *(result + 0xb)
        *(x26_1 + x8_1 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::AbiTagAttr{for `(anonymous namespace)::itanium_demangle::Node'}
        *(x26_1 + x8_1 + 0x18) = 8
        *(x26_1 + x8_1 + 0x20) = result
        *(x26_1 + x8_1 + 0x28) = x24_1
        *(x26_1 + x8_1 + 0x30) = x25_1
        *(x26_1 + x8_1 + 0x19) = x8_2
        *(x26_1 + x8_1 + 0x1b) = x9_2
        x9 = *arg1
        x8 = arg1[1]
        result = x26_1 + x8_1 + 0x10
        
        if (x9 == x8)
            return x26_1 + x8_1 + 0x10

return result
