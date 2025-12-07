// 函数: sub_49a2e8
// 地址: 0x49a2e8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
    ** result = sub_49707c(arg1)

if (result != 0)
    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
        ** result_1 = result
    result = sub_49707c(arg1)
    
    if (result != 0)
        void** x24_1 = arg1[0x266]
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
            ** result_2 = result
        int64_t x8_1 = x24_1[1]
        
        if (x8_1 + 0x30 u>= 0xff0)
            void** x0_1 = malloc(0x1000)
            
            if (x0_1 == 0)
                sub_491944()
                noreturn
            
            x8_1 = 0
            *x0_1 = x24_1
            x0_1[1] = 0
            x24_1 = x0_1
            arg1[0x266] = x0_1
        
        x24_1[1] = x8_1 + 0x30
        result = x24_1 + x8_1 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::BinaryExpr{for `(anonymous namespace)::itanium_demangle::Node'}
        result[1].d = 0x101012f
        result[2] = result_1
        result[3] = arg2
        result[4] = arg3
        result[5] = result_2

return result
