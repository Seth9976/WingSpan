// 函数: sub_4951ec
// 地址: 0x4951ec
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
void** x19 = arg1
char* x9 = *arg1
int64_t x8_1 = arg1[1]
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
    ** result

if (x8_1 == x9)
    result = sub_492f20(x19)
else
    uint32_t x11_1 = zx.d(*x9)
    
    if (x11_1 == 0x4a)
        char* i = &x9[1]
        *x19 = i
        int64_t x21_1 = (x19[3] - x19[2]) s>> 3
        
        if (i == x8_1)
            goto label_495304
        
        do
            if (zx.d(*i) == 0x45)
                int64_t x9_4 = x19[2]
                int64_t x2_1 = x19[3]
                int64_t x21_2 = x21_1 << 3
                *x19 = &i[1]
                void* x0_7
                int64_t x1_3
                x0_7, x1_3 = sub_49e548(x19, x9_4 + x21_2, x2_1)
                void** x23_1 = x19[0x266]
                x19[3] = x19[2] + x21_2
                int64_t x8_13 = x23_1[1]
                
                if (x8_13 + 0x20 u>= 0xff0)
                    void** x0_8 = malloc(0x1000)
                    
                    if (x0_8 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_13 = 0
                    *x0_8 = x23_1
                    x0_8[1] = 0
                    x23_1 = x0_8
                    x19[0x266] = x0_8
                
                x23_1[1] = x8_13 + 0x20
                result = x23_1 + x8_13 + 0x10
                *result = &_vtable_for_(anonymous namespace)::itanium_demangle::TemplateArgumentPack{for `(anonymous namespace)::itanium_demangle::Node'}
                result[1].d = 0x1010121
                result[2] = x0_7
                result[3] = x1_3
                break
            
        label_495304:
            result = sub_4951ec(x19)
            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                ** result_1 = result
            
            if (result == 0)
                break
            
            sub_4953d4(&x19[2], &result_1)
            i = *x19
        while (i != x19[1])
    else if (x11_1 == 0x4c)
        if (x8_1 - x9 u< 2 || zx.d(x9[1]) != 0x5a)
            result = sub_498f40(x19)
        else
            *x19 = &x9[2]
            result = sub_4922d0(x19)
            
            if (result != 0)
                goto label_495250
    else if (x11_1 != 0x58)
        result = sub_492f20(x19)
    else
        *x19 = &x9[1]
        result = sub_49707c(x19)
        
        if (result != 0)
        label_495250:
            void* x8_3 = *x19
            
            if (x8_3 == x19[1] || zx.d(*x8_3) != 0x45)
                result = nullptr
            else
                *x19 = x8_3 + 1

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
