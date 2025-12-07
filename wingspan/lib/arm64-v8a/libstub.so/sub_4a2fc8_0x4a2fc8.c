// 函数: sub_4a2fc8
// 地址: 0x4a2fc8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
void** x19 = arg1
char* x9 = *arg1
char* x8_1 = arg1[1]
int32_t x24

if (x9 == x8_1 || zx.d(*x9) != 0x72)
    x24 = 0
    
    if (x9 == x8_1)
        x9 = x8_1
    else
    label_4a303c:
        
        if (zx.d(*x9) == 0x56)
            x9 = &x9[1]
            x24 |= 2
            *x19 = x9
        
        if (x9 == x8_1)
            x9 = x8_1
        else if (zx.d(*x9) == 0x4b)
            x9 = &x9[1]
            x24 |= 1
            *x19 = x9
else
    x9 = &x9[1]
    x24 = 4
    *x19 = x9
    
    if (x9 != x8_1)
        goto label_4a303c
    
    x9 = x8_1

struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FunctionType::VTable
    ** result
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FunctionType::VTable
    ** result_1
void* x25_2

if (x8_1 - x9 u< 2 || zx.d(*x9) != 0x44)
label_4a3228:
    x25_2 = nullptr
label_4a322c:
    void* x8_10 = *x19
    int64_t x9_8 = x19[1]
    
    if (x9_8 - x8_10 u>= 2 && zx.d(*x8_10) == 0x44 && zx.d(*(x8_10 + 1)) == 0x78)
        x8_10 += 2
        *x19 = x8_10
    
    if (x8_10 == x9_8 || zx.d(*x8_10) != 0x46)
        result = nullptr
    else
        *x19 = x8_10 + 1
        
        if (x8_10 + 1 != x9_8 && zx.d(*(x8_10 + 1)) == 0x59)
            *x19 = x8_10 + 2
        
        result = sub_492f20(x19)
        
        if (result != 0)
            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FunctionType::VTable
                ** result_2 = result
            int64_t x26_1 = 1
            int64_t x22_1 = (x19[3] - x19[2]) s>> 3
            
            while (true)
                char* x8_15 = *x19
                int64_t x9_11 = x19[1]
                char x27_1
                
                if (x8_15 != x9_11)
                    if (zx.d(*x8_15) != 0x45)
                        if (zx.d(*x8_15) == 0x76)
                            *x19 = &x8_15[1]
                            continue
                        
                        goto label_4a32f0
                    
                    x27_1 = 0
                label_4a3398:
                    int64_t x2_1 = x19[3]
                    int64_t x22_2 = x22_1 << 3
                    int64_t x1_3 = x19[2] + x22_2
                    *x19 = &x8_15[x26_1]
                    void* x0_9
                    int64_t x1_4
                    x0_9, x1_4 = sub_49e548(x19, x1_3, x2_1)
                    void** x26_2 = x19[0x266]
                    x19[3] = x19[2] + x22_2
                    int64_t x8_20 = x26_2[1]
                    
                    if (x8_20 + 0x40 u>= 0xff0)
                        void** x0_10 = malloc(0x1000)
                        
                        if (x0_10 == 0)
                            goto label_4a34c4
                        
                        x8_20 = 0
                        *x0_10 = x26_2
                        x0_10[1] = 0
                        x26_2 = x0_10
                        x19[0x266] = x0_10
                    
                    x26_2[1] = x8_20 + 0x40
                    result = x26_2 + x8_20 + 0x10
                    *result = &_vtable_for_(anonymous namespace)::itanium_demangle::FunctionType{for `(anonymous namespace)::itanium_demangle::Node'}
                    result[1].d = 0x1000f
                    result[2] = result_2
                    result[3] = x0_9
                    result[4] = x1_4
                    result[5].d = x24
                    *(result + 0x2c) = x27_1
                    result[6] = x25_2
                    goto label_4a3354
                
            label_4a32f0:
                
                if (x9_11 - x8_15 u>= 2)
                    uint32_t x9_13 = zx.d(*x8_15)
                    
                    if (x9_13 != 0x52)
                        goto label_4a3314
                    
                    if (zx.d(x8_15[1]) == 0x45)
                        x27_1 = 1
                        x26_1 = 2
                        goto label_4a3398
                    
                    x9_13 = zx.d(*x8_15)
                label_4a3314:
                    
                    if (x9_13 == 0x4f && zx.d(x8_15[1]) == 0x45)
                        x26_1 = 2
                        x27_1 = 2
                        goto label_4a3398
                
                result = sub_492f20(x19)
                result_1 = result
                
                if (result == 0)
                    break
                
                sub_4953d4(&x19[2], &result_1)
else
    if (zx.d(x9[1]) == 0x6f)
        void** x20_1 = x19[0x266]
        *x19 = &x9[2]
        int64_t x8_3 = x20_1[1]
        
        if (x8_3 + 0x20 u<= 0xfef)
            goto label_4a30f0
        
        void** x0 = malloc(0x1000)
        
        if (x0 == 0)
        label_4a34c4:
            sub_491944()
            noreturn
        
        x8_3 = 0
        *x0 = x20_1
        x0[1] = 0
        x20_1 = x0
        x19[0x266] = x0
    label_4a30f0:
        x20_1[1] = x8_3 + 0x20
        x25_2 = x20_1 + x8_3 + 0x10
        *x25_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::NameType{for `(anonymous namespace)::itanium_demangle::Node'}
        *(x25_2 + 8) = 0x1010107
        *(x25_2 + 0x10) = "noexcept"
        *(x25_2 + 0x18) = &data_4529a2[8]
        goto label_4a322c
    
    if (zx.d(*x9) != 0x44)
        goto label_4a3228
    
    if (zx.d(x9[1]) != 0x4f)
        if (zx.d(*x9) != 0x44 || zx.d(x9[1]) != 0x77)
            goto label_4a3228
        
        void* x9_7 = &x9[2]
        *x19 = x9_7
        int64_t x21_2 = (x19[3] - x19[2]) s>> 3
        
        if (x9_7 == x8_1)
            goto label_4a3200
        
        while (true)
            if (zx.d(*x9_7) == 0x45)
                int64_t x9_20 = x19[2]
                int64_t x2_2 = x19[3]
                int64_t x21_6 = x21_2 << 3
                *x19 = x9_7 + 1
                void* x0_13
                int64_t x1_6
                x0_13, x1_6 = sub_49e548(x19, x9_20 + x21_6, x2_2)
                void** x22_4 = x19[0x266]
                x19[3] = x19[2] + x21_6
                int64_t x8_24 = x22_4[1]
                
                if (x8_24 + 0x20 u>= 0xff0)
                    void** x0_14 = malloc(0x1000)
                    
                    if (x0_14 == 0)
                        goto label_4a34c4
                    
                    x8_24 = 0
                    *x0_14 = x22_4
                    x0_14[1] = 0
                    x22_4 = x0_14
                    x19[0x266] = x0_14
                
                x22_4[1] = x8_24 + 0x20
                x25_2 = x22_4 + x8_24 + 0x10
                *x25_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::DynamicExceptionSpec{for `(anonymous namespace)::itanium_demangle::Node'}
                *(x25_2 + 8) = 0x1010111
                *(x25_2 + 0x10) = x0_13
                *(x25_2 + 0x18) = x1_6
                goto label_4a322c
            
        label_4a3200:
            result = sub_492f20(x19)
            result_1 = result
            
            if (result == 0)
                break
            
            sub_4953d4(&x19[2], &result_1)
            x9_7 = *x19
            
            if (x9_7 == x19[1])
                goto label_4a3200
    else
        *x19 = &x9[2]
        result = sub_49707c(x19)
        
        if (result != 0)
            char* x8_5 = *x19
            
            if (x8_5 != x19[1] && zx.d(*x8_5) == 0x45)
                void** x21_1 = x19[0x266]
                *x19 = &x8_5[1]
                int64_t x8_7 = x21_1[1]
                
                if (x8_7 + 0x20 u>= 0xff0)
                    void** x0_2 = malloc(0x1000)
                    
                    if (x0_2 == 0)
                        goto label_4a34c4
                    
                    x8_7 = 0
                    *x0_2 = x21_1
                    x0_2[1] = 0
                    x21_1 = x0_2
                    x19[0x266] = x0_2
                
                x21_1[1] = x8_7 + 0x20
                x25_2 = x21_1 + x8_7 + 0x10
                *x25_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::NoexceptSpec{for `(anonymous namespace)::itanium_demangle::Node'}
                *(x25_2 + 8) = 0x1010110
                *(x25_2 + 0x10) = result
                goto label_4a322c
            
            result = nullptr
label_4a3354:

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
