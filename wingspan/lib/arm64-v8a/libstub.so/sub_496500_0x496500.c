// 函数: sub_496500
// 地址: 0x496500
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x8 = *arg1
int64_t x9 = arg1[1]

if (x8 != x9 && zx.d(*x8) == 0x44)
    *arg1 = &x8[1]
    
    if (&x8[1] != x9 && (zx.d(x8[1]) == 0x74 || zx.d(x8[1]) == 0x54))
        *arg1 = &x8[2]
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
            ** result = sub_49707c(arg1)
        
        if (result == 0)
            return result
        
        char* x8_2 = *arg1
        
        if (x8_2 != arg1[1] && zx.d(*x8_2) == 0x45)
            void** x21_1 = arg1[0x266]
            *arg1 = &x8_2[1]
            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                ** result_1 = result
            int64_t x8_4 = x21_1[1]
            
            if (x8_4 + 0x40 u>= 0xff0)
                void** x0_1 = malloc(0x1000)
                
                if (x0_1 == 0)
                    sub_491944()
                    noreturn
                
                x8_4 = 0
                *x0_1 = x21_1
                x0_1[1] = 0
                x21_1 = x0_1
                arg1[0x266] = x0_1
            
            x21_1[1] = x8_4 + 0x40
            result = x21_1 + x8_4 + 0x10
            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::EnclosingExpr{for `(anonymous namespace)::itanium_demangle::Node'}
            result[1].d = 0x1010134
            result[2] = "decltype("
            result[3] = &data_40c13c[9]
            result[4] = result_1
            result[5] = &data_4525e5
            result[6] = &data_4525e6
            return result

return nullptr
