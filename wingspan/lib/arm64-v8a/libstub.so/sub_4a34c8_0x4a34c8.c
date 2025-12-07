// 函数: sub_4a34c8
// 地址: 0x4a34c8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x10 = *arg1
void* x8 = arg1[1]
int32_t x21_1

if (x10 == x8)
label_4a358c:
    x21_1 = 0
    
    if (x10 != x8)
    label_4a35a0:
        
        if (zx.d(*x10) == 0x56)
            x10 = &x10[1]
            x21_1 |= 2
            *arg1 = x10
        
        if (x10 != x8 && zx.d(*x10) == 0x4b)
            x21_1 |= 1
            *arg1 = &x10[1]
else
    if (zx.d(*x10) == 0x55)
        void* x9_2 = &x10[1]
        *arg1 = x9_2
        
        if (x8 != x9_2 && zx.d(*x9_2) - 0x30 u<= 9)
            void* x11_3 = &x10[2]
            *arg1 = x11_3
            int64_t x10_1 = zx.q(x10[1]) - 0x30
            
            if (x8 == x11_3)
            label_4a366c:
                x9_2 = x11_3
            else
                do
                    if (zx.d(*x11_3) - 0x30 u>= 0xa)
                        goto label_4a366c
                    
                    x9_2 = x11_3 + 1
                    *arg1 = x9_2
                    x10_1 = zx.q(*x11_3) + x10_1 * 0xa - 0x30
                    x11_3 = x9_2
                while (x8 != x9_2)
            
            if (x8 - x9_2 u>= x10_1)
                void* x22_2 = x9_2 + x10_1
                void* x23_1 = x9_2
                x9_2 = x22_2
                *arg1 = x22_2
                
                if (x23_1 != x22_2)
                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::ObjCProtoName::VTable
                        * const x8_7
                    int64_t x9_12
                    int16_t x10_14
                    void* x20_2
                    int64_t x21_2
                    void** x24_1
                    
                    if (x22_2 - x23_1 u< 9 || zx.d(*x23_1) != 0x6f || zx.d(*(x23_1 + 1)) != 0x62
                            || zx.d(*(x23_1 + 2)) != 0x6a || zx.d(*(x23_1 + 3)) != 0x63
                            || zx.d(*(x23_1 + 4)) != 0x70 || zx.d(*(x23_1 + 5)) != 0x72
                            || zx.d(*(x23_1 + 6)) != 0x6f || zx.d(*(x23_1 + 7)) != 0x74
                            || zx.d(*(x23_1 + 8)) != 0x6f)
                        int64_t x0_4 = sub_4a34c8(arg1)
                        
                        if (x0_4 != 0)
                            x24_1 = arg1[0x266]
                            x21_2 = x0_4
                            int64_t x8_6 = x24_1[1]
                            
                            if (x8_6 + 0x30 u>= 0xff0)
                                void*** x0_5 = malloc(0x1000)
                                
                                if (x0_5 == 0)
                                    sub_491944()
                                    noreturn
                                
                                x8_6 = 0
                                *x0_5 = x24_1
                                x0_5[1] = 0
                                x24_1 = x0_5
                                arg1[0x266] = x0_5
                            
                            x9_12 = x8_6 + 0x30
                            x20_2 = x24_1 + x8_6
                            x10_14 = 0x102
                            x8_7 = &_vtable_for_(anonymous namespace)::itanium_demangle::VendorExtQualType{for `(anonymous namespace)::itanium_demangle::Node'}
                        label_4a37ec:
                            x24_1[1] = x9_12
                            int64_t* x20_1 = x20_2 + 0x10
                            *x20_1 = x8_7
                            x20_1[1].d = zx.d(x10_14) | 0x1010000
                            x20_1[2] = x21_2
                            x20_1[3] = x23_1
                            x20_1[4] = x22_2
                            return x20_1
                    else
                        void* x10_13 = x23_1 + 9
                        *arg1 = x10_13
                        arg1[1] = x22_2
                        
                        if (x22_2 == x10_13 || zx.d(*x10_13) - 0x30 u> 9)
                            x22_2 = nullptr
                            x23_1 = nullptr
                        else
                            int64_t x11_10
                            
                            if (x10_13 == x22_2)
                                x11_10 = -0x30
                            else
                                int64_t x11_8 = 0
                                
                                while (true)
                                    void* x12_2 = x10_13
                                    x10_13 += 1
                                    *arg1 = x10_13
                                    x11_10 = x11_8 + zx.q(*x12_2) - 0x30
                                    
                                    if (x22_2 == x10_13 || zx.d(*x10_13) - 0x30 u>= 0xa)
                                        x23_1 = x10_13
                                        goto label_4a3818
                                    
                                    x11_8 = x11_10 * 0xa
                                    
                                    if (x22_2 != x10_13)
                                        continue
                                    
                                    x11_10 = x11_8 - 0x30
                                    break
                            
                            x23_1 = x22_2
                        label_4a3818:
                            
                            if (x22_2 - x10_13 u>= x11_10)
                                x22_2 = x23_1 + x11_10
                                *arg1 = x22_2
                            else
                                x22_2 = nullptr
                                x23_1 = nullptr
                        
                        *arg1 = x9_2
                        arg1[1] = x8
                        
                        if (x23_1 != x22_2)
                            int64_t x0_7 = sub_4a34c8(arg1)
                            
                            if (x0_7 != 0)
                                x24_1 = arg1[0x266]
                                x21_2 = x0_7
                                int64_t x8_8 = x24_1[1]
                                
                                if (x8_8 + 0x30 u>= 0xff0)
                                    void** x0_8 = malloc(0x1000)
                                    
                                    if (x0_8 == 0)
                                        sub_491944()
                                        noreturn
                                    
                                    x8_8 = 0
                                    *x0_8 = x24_1
                                    x0_8[1] = 0
                                    x24_1 = x0_8
                                    arg1[0x266] = x0_8
                                
                                x9_12 = x8_8 + 0x30
                                x20_2 = x24_1 + x8_8
                                x10_14 = 0x10a
                                x8_7 = &_vtable_for_(anonymous namespace)::itanium_demangle::ObjCProtoName{for `(anonymous namespace)::itanium_demangle::Node'}
                                goto label_4a37ec
        
        return nullptr
    
    if (zx.d(*x10) != 0x72)
        goto label_4a358c
    
    x10 = &x10[1]
    x21_1 = 4
    *arg1 = x10
    
    if (x10 != x8)
        goto label_4a35a0

int64_t* x0_1 = sub_492f20(arg1)

if (x0_1 == 0 || x21_1 == 0)
    return x0_1

void** x22_1 = arg1[0x266]
int64_t x8_3 = x22_1[1]

if (x8_3 + 0x20 u>= 0xff0)
    void** x0_2 = malloc(0x1000)
    
    if (x0_2 == 0)
        sub_491944()
        noreturn
    
    x8_3 = 0
    *x0_2 = x22_1
    x0_2[1] = 0
    x22_1 = x0_2
    arg1[0x266] = x0_2

x22_1[1] = x8_3 + 0x20
int16_t x9_10 = *(x0_1 + 9)
char x12_1 = *(x0_1 + 0xb)
*(x22_1 + x8_3 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::QualType{for `(anonymous namespace)::itanium_demangle::Node'}
*(x22_1 + x8_3 + 0x20) = x0_1
*(x22_1 + x8_3 + 0x18) = 3
*(x22_1 + x8_3 + 0x1c) = x21_1
*(x22_1 + x8_3 + 0x19) = x9_10
*(x22_1 + x8_3 + 0x1b) = x12_1
return x22_1 + x8_3 + 0x10
