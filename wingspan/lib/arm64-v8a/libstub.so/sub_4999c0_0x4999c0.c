// 函数: sub_4999c0
// 地址: 0x4999c0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x11 = *arg1
void* x8 = arg1[1]

if (x8 - x11 u>= 2 && zx.d(*x11) == 0x66)
    void* x9_3
    void* x20_1
    void* x21_1
    
    if (zx.d(x11[1]) == 0x70)
        x9_3 = &x11[2]
        *arg1 = x9_3
        
        if (x9_3 != x8)
            if (zx.d(*x9_3) == 0x72)
                x9_3 = &x11[3]
                *arg1 = x9_3
            
            if (x9_3 == x8)
                x9_3 = x8
            else
                if (zx.d(*x9_3) == 0x56)
                    x9_3 += 1
                    *arg1 = x9_3
                
                if (x9_3 == x8)
                    goto label_499b24
                
                if (zx.d(*x9_3) == 0x4b)
                    x9_3 += 1
                    *arg1 = x9_3
                    
                    if (x8 != x9_3 && zx.d(*x9_3) - 0x30 u<= 9)
                        goto label_499bd0
                    
                    goto label_499b50
            
            if (x8 == x9_3 || zx.d(*x9_3) - 0x30 u> 9)
                goto label_499b50
            
            goto label_499bd0
        
    label_499b24:
        x9_3 = x8
        
        if (x8 != x9_3 && zx.d(*x9_3) - 0x30 u<= 9)
        label_499bd0:
            void* x11_2 = x9_3 + 1
            void* x10_9
            
            do
                x10_9 = x11_2
                *arg1 = x11_2
                
                if (x8 == x11_2)
                    x20_1 = x9_3
                    x9_3 = x10_9
                    x21_1 = x8
                    
                    if (x9_3 != x8)
                        goto label_499b64
                    
                    goto label_499c9c
                
                x11_2 = x10_9 + 1
            while (zx.d(*x10_9) - 0x30 u< 0xa)
            
            x20_1 = x9_3
            x21_1 = x11_2 - 1
            x9_3 = x10_9
            
            if (x9_3 != x8)
                goto label_499b64
        else
        label_499b50:
            x20_1 = nullptr
            x21_1 = nullptr
            
            if (x9_3 != x8)
            label_499b64:
                
                if (zx.d(*x9_3) == 0x5f)
                    void** x22_1 = arg1[0x266]
                    *arg1 = x9_3 + 1
                    int64_t x8_3 = x22_1[1]
                    
                    if (x8_3 + 0x20 u>= 0xff0)
                        void** x0 = malloc(0x1000)
                        
                        if (x0 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_3 = 0
                        *x0 = x22_1
                        x0[1] = 0
                        x22_1 = x0
                        arg1[0x266] = x0
                    
                    x22_1[1] = x8_3 + 0x20
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::FunctionParam::VTable
                        ** result = x22_1 + x8_3 + 0x10
                    *result = &_vtable_for_(anonymous namespace)::itanium_demangle::FunctionParam{for `(anonymous namespace)::itanium_demangle::Node'}
                    result[1].d = 0x101013b
                    result[2] = x20_1
                    result[3] = x21_1
                    return result
    else if (zx.d(*x11) == 0x66 && zx.d(x11[1]) == 0x4c)
        void* x10_4 = &x11[2]
        *arg1 = x10_4
        void* x9_8
        void* x12_1
        
        if (x8 == x10_4 || zx.d(*x10_4) - 0x30 u> 9)
            x9_8 = nullptr
            x12_1 = nullptr
        else
            void* x12_4 = &x11[3]
            
            while (true)
                void* x11_4 = x12_4
                *arg1 = x12_4
                
                if (x8 == x12_4)
                    x9_8 = x10_4
                    x10_4 = x11_4
                    x12_1 = x8
                    break
                
                x12_4 = x11_4 + 1
                
                if (zx.d(*x11_4) - 0x30 u>= 0xa)
                    x9_8 = x10_4
                    x12_1 = x12_4 - 1
                    x10_4 = x11_4
                    break
        
        if (x9_8 == x12_1 || x10_4 == x8)
            return nullptr
        
        if (zx.d(*x10_4) == 0x70)
            x9_3 = x10_4 + 1
            *arg1 = x9_3
            
            if (x9_3 == x8)
                x9_3 = x8
            else
                if (zx.d(*x9_3) == 0x72)
                    x9_3 = x10_4 + 2
                    *arg1 = x9_3
                
                if (x9_3 != x8)
                    if (zx.d(*x9_3) == 0x56)
                        x9_3 += 1
                        *arg1 = x9_3
                    
                    if (x9_3 != x8 && zx.d(*x9_3) == 0x4b)
                        x9_3 += 1
                        *arg1 = x9_3
            
            if (x8 == x9_3 || zx.d(*x9_3) - 0x30 u> 9)
                x20_1 = nullptr
                x21_1 = nullptr
            else
                void* x11_5 = x9_3 + 1
                
                while (true)
                    void* x10_12 = x11_5
                    *arg1 = x11_5
                    
                    if (x8 == x11_5)
                        x20_1 = x9_3
                        x9_3 = x10_12
                        x21_1 = x8
                        break
                    
                    x11_5 = x10_12 + 1
                    
                    if (zx.d(*x10_12) - 0x30 u>= 0xa)
                        x20_1 = x9_3
                        x21_1 = x11_5 - 1
                        x9_3 = x10_12
                        break
            
            if (x9_3 != x8)
                goto label_499b64

label_499c9c:
return nullptr
