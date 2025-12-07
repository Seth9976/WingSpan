// 函数: sub_496a18
// 地址: 0x496a18
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
char* x8_1 = *arg1
int64_t x9 = arg1[1]
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::StructuredBindingName::VTable
    ** x0_7
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::StructuredBindingName::VTable
    ** x1_4

if (x9 != x8_1)
    uint32_t x10_1 = zx.d(*x8_1)
    
    if (x10_1 != 0x55)
        if (x10_1 - 0x31 u> 8)
            goto label_496a4c
        
        x0_7 = sub_49ec1c(arg1)
        goto label_496b94
    
    x0_7 = sub_49ad48(arg1, arg2)
label_496b94:
    x1_4 = x0_7
    
    if (x0_7 == 0)
    label_496bc0:
        
        if (*(x22 + 0x28) == x8)
            return nullptr
    else
    label_496ba0:
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::AbiTagAttr::VTable
            ** result = sub_496890(arg1, x1_4)
        
        if (*(x22 + 0x28) == x8)
            return result
    
    __stack_chk_fail()
    noreturn

label_496a4c:

if (x9 - x8_1 u< 2 || zx.d(*x8_1) != 0x44 || zx.d(x8_1[1]) != 0x43)
    x0_7 = sub_49ef2c(arg1, arg2)
    goto label_496b94

*arg1 = &x8_1[2]
int64_t x21_1 = arg1[2]
int64_t x23_1 = arg1[3]
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
    ** i_2 = sub_49ec1c(arg1)
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
    ** i_1 = i_2

if (i_2 != 0)
    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
        ** i
    
    do
        sub_4953d4(&arg1[2], &i_1)
        char* x8_4 = *arg1
        
        if (x8_4 != arg1[1] && zx.d(*x8_4) == 0x45)
            int64_t x2_1 = arg1[3]
            int64_t x21_3 = (x23_1 - x21_1) s>> 3 << 3
            int64_t x1_1 = arg1[2] + x21_3
            *arg1 = &x8_4[1]
            void* x0_4
            int64_t x1_2
            x0_4, x1_2 = sub_49e548(arg1, x1_1, x2_1)
            void** x23_2 = arg1[0x266]
            arg1[3] = arg1[2] + x21_3
            int64_t x8_8 = x23_2[1]
            
            if (x8_8 + 0x20 u>= 0xff0)
                void** x0_5 = malloc(0x1000)
                
                if (x0_5 == 0)
                    sub_491944()
                    noreturn
                
                x8_8 = 0
                *x0_5 = x23_2
                x0_5[1] = 0
                x23_2 = x0_5
                arg1[0x266] = x0_5
            
            x23_2[1] = x8_8 + 0x20
            x1_4 = x23_2 + x8_8 + 0x10
            *x1_4 = &_vtable_for_(anonymous namespace)::itanium_demangle::StructuredBindingName{for `(anonymous namespace)::itanium_demangle::Node'}
            x1_4[1].d = 0x101012e
            x1_4[2] = x0_4
            x1_4[3] = x1_2
            goto label_496ba0
        
        i = sub_49ec1c(arg1)
        i_1 = i
    while (i != 0)

goto label_496bc0
