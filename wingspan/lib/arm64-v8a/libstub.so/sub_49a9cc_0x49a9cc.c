// 函数: sub_49a9cc
// 地址: 0x49a9cc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x8 = *arg1
int64_t x9 = arg1[1]

if (x9 != x8 && x9 - x8 != 1 && zx.d(*x8) == 0x64)
    uint32_t x9_3 = zx.d(x8[1])
    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
        ** result
    
    if (x9_3 == 0x58)
        *arg1 = &x8[2]
        result = sub_49707c(arg1)
        
        if (result == 0)
            return result
        
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
            ** result_3 = result
        result = sub_49707c(arg1)
        
        if (result == 0)
            return result
        
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
            ** result_6 = result
        result = sub_49a9cc(arg1)
        
        if (result == 0)
            return result
        
        void** x23_1 = arg1[0x266]
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
            ** result_7 = result
        int64_t x8_7 = x23_1[1]
        
        if (x8_7 + 0x30 u>= 0xff0)
            void** x0_13 = malloc(0x1000)
            
            if (x0_13 == 0)
                sub_491944()
                noreturn
            
            x8_7 = 0
            *x0_13 = x23_1
            x0_13[1] = 0
            x23_1 = x0_13
            arg1[0x266] = x0_13
        
        x23_1[1] = x8_7 + 0x30
        result = x23_1 + x8_7 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::BracedRangeExpr{for `(anonymous namespace)::itanium_demangle::Node'}
        result[1].d = 0x101014a
        result[2] = result_3
        result[3] = result_6
        result[4] = result_7
        return result
    
    if (x9_3 == 0x78)
        *arg1 = &x8[2]
        result = sub_49707c(arg1)
        
        if (result == 0)
            return result
        
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
            ** result_2 = result
        result = sub_49a9cc(arg1)
        
        if (result == 0)
            return result
        
        void** x22_2 = arg1[0x266]
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
            ** result_5 = result
        int64_t x8_5 = x22_2[1]
        
        if (x8_5 + 0x30 u>= 0xff0)
            void** x0_8 = malloc(0x1000)
            
            if (x0_8 == 0)
                sub_491944()
                noreturn
            
            x8_5 = 0
            *x0_8 = x22_2
            x0_8[1] = 0
            x22_2 = x0_8
            arg1[0x266] = x0_8
        
        x22_2[1] = x8_5 + 0x30
        result = x22_2 + x8_5 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::BracedExpr{for `(anonymous namespace)::itanium_demangle::Node'}
        result[1].d = 0x1010149
        result[2] = result_2
        result[3] = result_5
        result[4].b = 1
        return result
    
    if (x9_3 == 0x69)
        *arg1 = &x8[2]
        result = sub_49ec1c(arg1)
        
        if (result == 0)
            return result
        
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
            ** result_1 = result
        result = sub_49a9cc(arg1)
        
        if (result == 0)
            return result
        
        void** x22_1 = arg1[0x266]
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
            ** result_4 = result
        int64_t x8_2 = x22_1[1]
        
        if (x8_2 + 0x30 u>= 0xff0)
            void** x0_2 = malloc(0x1000)
            
            if (x0_2 == 0)
                sub_491944()
                noreturn
            
            x8_2 = 0
            *x0_2 = x22_1
            x0_2[1] = 0
            x22_1 = x0_2
            arg1[0x266] = x0_2
        
        x22_1[1] = x8_2 + 0x30
        result = x22_1 + x8_2 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::BracedExpr{for `(anonymous namespace)::itanium_demangle::Node'}
        result[1].d = 0x1010149
        result[2] = result_1
        result[3] = result_4
        result[4].b = 0
        return result

return sub_49707c(arg1) __tailcall
