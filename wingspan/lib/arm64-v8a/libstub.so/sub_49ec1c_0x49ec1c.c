// 函数: sub_49ec1c
// 地址: 0x49ec1c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x20 = *arg1
int64_t x8 = arg1[1]

if (x8 != x20 && zx.d(*x20) - 0x30 u<= 9)
    int64_t x9_5
    char* x11_4
    
    if (x20 == x8)
        x9_5 = -0x30
    label_49ecac:
        x11_4 = x20
    else
        int64_t x9_3 = 0
        char* x10_1
        
        do
            x10_1 = x20
            x20 = &x20[1]
            *arg1 = x20
            x9_5 = x9_3 + zx.q(*x10_1) - 0x30
            
            if (x8 == x20)
                goto label_49ecac
            
            if (zx.d(*x20) - 0x30 u>= 0xa)
                goto label_49ecac
            
            x9_3 = x9_5 * 0xa
        while (x8 != x20)
        
        x11_4 = x20
        x20 = &x10_1[1]
        x9_5 = x9_3 - 0x30
    
    if (x9_5 - 1 u< x8 - x11_4)
        void* x21_1 = &x20[x9_5]
        *arg1 = x21_1
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
            ** result
        
        if (x9_5 u< 0xa || zx.d(*x20) != 0x5f || zx.d(x20[1]) != 0x47 || zx.d(x20[2]) != 0x4c
                || zx.d(x20[3]) != 0x4f || zx.d(x20[4]) != 0x42 || zx.d(x20[5]) != 0x41
                || zx.d(x20[6]) != 0x4c || zx.d(x20[7]) != 0x5f || zx.d(x20[8]) != 0x5f
                || zx.d(x20[9]) != 0x4e)
            void** x22_1 = arg1[0x266]
            int64_t x8_13 = x22_1[1]
            
            if (x8_13 + 0x20 u>= 0xff0)
                void** x0_2 = malloc(0x1000)
                
                if (x0_2 == 0)
                    sub_491944()
                    noreturn
                
                x8_13 = 0
                *x0_2 = x22_1
                x0_2[1] = 0
                x22_1 = x0_2
                arg1[0x266] = x0_2
            
            x22_1[1] = x8_13 + 0x20
            result = x22_1 + x8_13 + 0x10
            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
            result[1].d = 0x1010107
            result[2] = x20
            result[3] = x21_1
        else
            void** x20_1 = arg1[0x266]
            int64_t x8_12 = x20_1[1]
            
            if (x8_12 + 0x20 u> 0xfef)
                void** x0 = malloc(0x1000)
                
                if (x0 == 0)
                    sub_491944()
                    noreturn
                
                x8_12 = 0
                *x0 = x20_1
                x0[1] = 0
                x20_1 = x0
                arg1[0x266] = x0
            
            x20_1[1] = x8_12 + 0x20
            result = x20_1 + x8_12 + 0x10
            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
            result[1].d = 0x1010107
            result[2] = "(anonymous namespace)"
            result[3] = &data_40dcc9[0x15]
        
        return result

return nullptr
