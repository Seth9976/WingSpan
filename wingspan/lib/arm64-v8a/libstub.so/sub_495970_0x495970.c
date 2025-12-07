// 函数: sub_495970
// 地址: 0x495970
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x22 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x22 + 0x28)
char* x9 = *arg1
int64_t x8_1 = arg1[1]
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::AbiTagAttr::VTable
    ** result

if (x9 == x8_1 || zx.d(*x9) != 0x53)
    result = nullptr
else
    *arg1 = &x9[1]
    uint64_t x11_2
    
    if (x8_1 != &x9[1])
        x11_2 = zx.q(zx.d(x9[1]) - 0x61)
    
    if (x8_1 != &x9[1] && x11_2.d u<= 0x19)
        result = nullptr
        void** x0
        int64_t x8_4
        int32_t x9_5
        void** x21_1
        
        if (x11_2.d u<= 0x12)
            switch (x11_2)
                case 0
                    x21_1 = arg1[0x266]
                    *arg1 = &x9[2]
                    x8_4 = x21_1[1]
                    
                    if (x8_4 + 0x10 u>= 0xff0)
                        x0 = malloc(0x1000)
                        
                        if (x0 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_4 = 0
                        x9_5 = 0
                    label_495b10:
                        *x0 = x21_1
                        x0[1] = 0
                        arg1[0x266] = x0
                        goto label_495c08
                    
                    x9_5 = 0
                label_495c20:
                    x21_1[1] = x8_4 + 0x10
                    result = x21_1 + x8_4 + 0x10
                    *result = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialSubstitution{for `(anonymous namespace)::itanium_demangle::Node'}
                    result[1].d = 0x1010129
                    *(result + 0xc) = x9_5
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::AbiTagAttr::VTable
                        ** result_1 = sub_496890(arg1, result)
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::AbiTagAttr::VTable
                        ** result_2 = result_1
                    
                    if (result_1 != result)
                        sub_4953d4(&arg1[0x25], &result_2)
                        result = result_1
                case 1
                    x21_1 = arg1[0x266]
                    *arg1 = &x9[2]
                    x8_4 = x21_1[1]
                    
                    if (x8_4 + 0x10 u< 0xff0)
                        x9_5 = 1
                        goto label_495c20
                    
                    x0 = malloc(0x1000)
                    
                    if (x0 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_4 = 0
                    *x0 = x21_1
                    x0[1] = 0
                    arg1[0x266] = x0
                    x9_5 = 1
                    goto label_495c08
                case 3
                    x21_1 = arg1[0x266]
                    *arg1 = &x9[2]
                    x8_4 = x21_1[1]
                    
                    if (x8_4 + 0x10 u< 0xff0)
                        x9_5 = 5
                        goto label_495c20
                    
                    x0 = malloc(0x1000)
                    
                    if (x0 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_4 = 0
                    x9_5 = 5
                    goto label_495b10
                case 8
                    x21_1 = arg1[0x266]
                    *arg1 = &x9[2]
                    x8_4 = x21_1[1]
                    
                    if (x8_4 + 0x10 u< 0xff0)
                        x9_5 = 3
                        goto label_495c20
                    
                    x0 = malloc(0x1000)
                    
                    if (x0 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_4 = 0
                    *x0 = x21_1
                    x0[1] = 0
                    arg1[0x266] = x0
                    x9_5 = 3
                    goto label_495c08
                case 0xe
                    x21_1 = arg1[0x266]
                    *arg1 = &x9[2]
                    x8_4 = x21_1[1]
                    
                    if (x8_4 + 0x10 u< 0xff0)
                        x9_5 = 4
                        goto label_495c20
                    
                    x0 = malloc(0x1000)
                    
                    if (x0 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_4 = 0
                    *x0 = x21_1
                    x0[1] = 0
                    arg1[0x266] = x0
                    x9_5 = 4
                    goto label_495c08
                case 0x12
                    x21_1 = arg1[0x266]
                    *arg1 = &x9[2]
                    x8_4 = x21_1[1]
                    
                    if (x8_4 + 0x10 u< 0xff0)
                        x9_5 = 2
                        goto label_495c20
                    
                    x0 = malloc(0x1000)
                    
                    if (x0 == 0)
                        sub_491944()
                        noreturn
                    
                    x8_4 = 0
                    *x0 = x21_1
                    x0[1] = 0
                    arg1[0x266] = x0
                    x9_5 = 2
                label_495c08:
                    x21_1 = x0
                    goto label_495c20
    else if (&x9[1] != x8_1 && zx.d(x9[1]) == 0x5f)
        int64_t* x8_2 = arg1[0x25]
        int64_t x10_3 = arg1[0x26]
        *arg1 = &x9[2]
        
        if (x8_2 == x10_3)
            result = nullptr
        else
            result = *x8_2
    else if (x8_1 == &x9[1])
        result = nullptr
    else
        uint32_t i = zx.d(x9[1])
        
        if (i u< 0x30 || (i u>= 0x3a && zx.d(i.b - 0x41) u> 0x19))
            result = nullptr
        else
            int64_t x10_6 = 0
            void* x13_1 = &x9[2]
            char* x9_3
            
            do
                x9_3 = x13_1
                int64_t x13_2
                
                if ((i & 0xff) u>= 0x3a)
                    if (zx.d(i.b - 0x41) u> 0x19)
                        x9_3 -= 1
                        break
                    
                    x13_2 = -0x37
                else
                    x13_2 = -0x30
                
                x10_6 = x13_2 + zx.q(i.b) + x10_6 * 0x24
                *arg1 = x9_3
                
                if (x8_1 == x9_3)
                    break
                
                i = zx.d(*x9_3)
                x13_1 = &x9_3[1]
            while (i u> 0x2f)
            
            if (x9_3 == x8_1 || zx.d(*x9_3) != 0x5f)
                result = nullptr
            else
                int64_t x8_11 = arg1[0x25]
                int64_t x11_5 = arg1[0x26]
                *arg1 = &x9_3[1]
                
                if (x10_6 + 1 u>= (x11_5 - x8_11) s>> 3)
                    result = nullptr
                else
                    result = *(x8_11 + ((x10_6 + 1) << 3))

if (*(x22 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
