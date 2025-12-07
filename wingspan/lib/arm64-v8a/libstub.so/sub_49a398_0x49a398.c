// 函数: sub_49a398
// 地址: 0x49a398
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x8 = *arg1
int64_t x9 = arg1[1]
void* x10 = x9 - x8

if (x10 u< 3)
    if (x10 != 2)
        return sub_49e9b4(arg1)
    
    goto label_49a5b0

uint32_t x10_1 = zx.d(*x8)

if (x10_1 != 0x73)
    goto label_49a5b4

struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameWithTemplateArgs::VTable
    ** x20_1
void* x21_5
void* x22_1

if (zx.d(x8[1]) != 0x72 || zx.d(x8[2]) != 0x4e)
label_49a5b0:
    x10_1 = zx.d(*x8)
label_49a5b4:
    int32_t x23_1
    
    if (x10_1 != 0x67 || zx.d(x8[1]) != 0x73)
        x23_1 = 0
        
        if (zx.d(*x8) != 0x73 || zx.d(x8[1]) != 0x72)
            goto label_49a6c0
        
        goto label_49a608
    
    x8 = &x8[2]
    x23_1 = 1
    *arg1 = x8
    
    if (x9 - x8 u< 2 || zx.d(*x8) != 0x73 || zx.d(x8[1]) != 0x72)
    label_49a6c0:
        void* x0_19 = sub_49e9b4(arg1)
        
        if (x0_19 == 0 || x23_1 == 0)
            return x0_19
        
        void** x20_2 = arg1[0x266]
        int64_t x8_24 = x20_2[1]
        
        if (x8_24 + 0x20 u< 0xff0)
            goto label_49a718
        
        void** x0_20 = malloc(0x1000)
        
        if (x0_20 == 0)
            goto label_49a9c8
        
        x8_24 = 0
        *x0_20 = x20_2
        x0_20[1] = 0
        x20_2 = x0_20
        arg1[0x266] = x0_20
    label_49a718:
        x20_2[1] = x8_24 + 0x20
        *(x20_2 + x8_24 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::GlobalQualifiedName{for `(anonymous namespace)::itanium_demangle::Node'}
        *(x20_2 + x8_24 + 0x18) = 0x1010126
        *(x20_2 + x8_24 + 0x20) = x0_19
        return x20_2 + x8_24 + 0x10
    
label_49a608:
    *arg1 = &x8[2]
    
    if (x9 == &x8[2] || zx.d(x8[2]) - 0x30 u> 9)
        void* x0_14 = sub_49e8fc(arg1)
        
        if (x0_14 != 0)
            char* x8_19 = *arg1
            x20_1 = x0_14
            
            if (arg1[1] == x8_19 || zx.d(*x8_19) != 0x49)
                goto label_49a8d4
            
            void* x0_16 = sub_495d00(arg1, 0)
            
            if (x0_16 != 0)
                void** x22_4 = arg1[0x266]
                int64_t x8_21 = x22_4[1]
                
                if (x8_21 + 0x20 u>= 0xff0)
                    void** x0_17 = malloc(0x1000)
                    
                    if (x0_17 == 0)
                        goto label_49a9c8
                    
                    x8_21 = 0
                    *x0_17 = x22_4
                    x0_17[1] = 0
                    x22_4 = x0_17
                    arg1[0x266] = x0_17
                
                x22_4[1] = x8_21 + 0x20
                *(x22_4 + x8_21 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::NameWithTemplateArgs{for `(anonymous namespace)::itanium_demangle::Node'}
                *(x22_4 + x8_21 + 0x20) = x20_1
                *(x22_4 + x8_21 + 0x28) = x0_16
                x20_1 = x22_4 + x8_21 + 0x10
                *(x22_4 + x8_21 + 0x18) = 0x1010125
            label_49a8d4:
                void* x0_31 = sub_49e9b4(arg1)
                
                if (x0_31 != 0)
                    void** x23_2 = arg1[0x266]
                    x21_5 = x0_31
                    int64_t x8_39 = x23_2[1]
                    
                    if (x8_39 + 0x20 u< 0xff0)
                        goto label_49a928
                    
                    void** x0_32 = malloc(0x1000)
                    
                    if (x0_32 == 0)
                        goto label_49a9c8
                    
                    x8_39 = 0
                    *x0_32 = x23_2
                    x0_32[1] = 0
                    x23_2 = x0_32
                    arg1[0x266] = x0_32
                label_49a928:
                    x23_2[1] = x8_39 + 0x20
                    x22_1 = x23_2 + x8_39 + 0x10
                    *x22_1 = &_vtable_for_(anonymous namespace)::itanium_demangle::QualifiedName{for `(anonymous namespace)::itanium_demangle::Node'}
                    *(x22_1 + 8) = 0x1010116
                label_49a934:
                    *(x22_1 + 0x10) = x20_1
                    *(x22_1 + 0x18) = x21_5
                    return x22_1
    else
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
            ** x0_22 = sub_49ec1c(arg1)
        
        if (x0_22 != 0)
            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameWithTemplateArgs::VTable
                ** x21_4 = x0_22
            x20_1 = nullptr
            
            while (true)
                char* x8_27 = *arg1
                
                if (arg1[1] != x8_27 && zx.d(*x8_27) == 0x49)
                    void* x0_26 = sub_495d00(arg1, 0)
                    
                    if (x0_26 == 0)
                        return x0_26
                    
                    void** x25_1 = arg1[0x266]
                    int64_t x8_29 = x25_1[1]
                    
                    if (x8_29 + 0x20 u>= 0xff0)
                        void** x0_27 = malloc(0x1000)
                        
                        if (x0_27 == 0)
                            goto label_49a9c8
                        
                        x8_29 = 0
                        *x0_27 = x25_1
                        x0_27[1] = 0
                        x25_1 = x0_27
                        arg1[0x266] = x0_27
                    
                    x25_1[1] = x8_29 + 0x20
                    *(x25_1 + x8_29 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::NameWithTemplateArgs{for `(anonymous namespace)::itanium_demangle::Node'}
                    *(x25_1 + x8_29 + 0x20) = x21_4
                    *(x25_1 + x8_29 + 0x28) = x0_26
                    x21_4 = x25_1 + x8_29 + 0x10
                    *(x25_1 + x8_29 + 0x18) = 0x1010125
                
                struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameWithTemplateArgs::VTable
                    ** x8_34
                
                if (x20_1 == 0)
                    x20_1 = x21_4
                    
                    if (x23_1 != 0)
                        void** x20_3 = arg1[0x266]
                        int64_t x8_35 = x20_3[1]
                        
                        if (x8_35 + 0x20 u>= 0xff0)
                            void** x0_29 = malloc(0x1000)
                            
                            if (x0_29 == 0)
                                goto label_49a9c8
                            
                            x8_35 = 0
                            *x0_29 = x20_3
                            x0_29[1] = 0
                            x20_3 = x0_29
                            arg1[0x266] = x0_29
                        
                        x20_3[1] = x8_35 + 0x20
                        x8_34 = x20_3 + x8_35 + 0x10
                        *x8_34 = &_vtable_for_(anonymous namespace)::itanium_demangle::GlobalQualifiedName{for `(anonymous namespace)::itanium_demangle::Node'}
                        x8_34[1].d = 0x1010126
                        x20_1 = x8_34
                        x8_34[2] = x21_4
                else
                    void** x22_5 = arg1[0x266]
                    int64_t x8_32 = x22_5[1]
                    
                    if (x8_32 + 0x20 u>= 0xff0)
                        void** x0_28 = malloc(0x1000)
                        
                        if (x0_28 == 0)
                            goto label_49a9c8
                        
                        x8_32 = 0
                        *x0_28 = x22_5
                        x0_28[1] = 0
                        x22_5 = x0_28
                        arg1[0x266] = x0_28
                    
                    x22_5[1] = x8_32 + 0x20
                    x8_34 = x22_5 + x8_32 + 0x10
                    *x8_34 = &_vtable_for_(anonymous namespace)::itanium_demangle::QualifiedName{for `(anonymous namespace)::itanium_demangle::Node'}
                    x8_34[1].d = 0x1010116
                    x8_34[2] = x20_1
                    x20_1 = x8_34
                    x8_34[3] = x21_4
                char* x8_37 = *arg1
                
                if (x8_37 != arg1[1] && zx.d(*x8_37) == 0x45)
                    *arg1 = &x8_37[1]
                    break
                
                struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameWithTemplateArgs::VTable
                    ** x0_24 = sub_49ec1c(arg1)
                x21_4 = x0_24
                
                if (x0_24 == 0)
                    return nullptr
            
            goto label_49a8d4
else
    *arg1 = &x8[3]
    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameWithTemplateArgs::VTable
        ** x0_3 = sub_49e8fc(arg1)
    
    if (x0_3 != 0)
        char* x8_2 = *arg1
        x20_1 = x0_3
        
        if (arg1[1] == x8_2 || zx.d(*x8_2) != 0x49)
            goto label_49a4dc
        
        void* x0_5 = sub_495d00(arg1, 0)
        
        if (x0_5 != 0)
            void** x22_2 = arg1[0x266]
            int64_t x8_4 = x22_2[1]
            
            if (x8_4 + 0x20 u< 0xff0)
                goto label_49a48c
            
            void** x0_6 = malloc(0x1000)
            
            if (x0_6 == 0)
            label_49a9c8:
                sub_491944()
                noreturn
            
            x8_4 = 0
            *x0_6 = x22_2
            x0_6[1] = 0
            x22_2 = x0_6
            arg1[0x266] = x0_6
        label_49a48c:
            x22_2[1] = x8_4 + 0x20
            *(x22_2 + x8_4 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::NameWithTemplateArgs{for `(anonymous namespace)::itanium_demangle::Node'}
            *(x22_2 + x8_4 + 0x20) = x20_1
            *(x22_2 + x8_4 + 0x28) = x0_5
            x20_1 = x22_2 + x8_4 + 0x10
            *(x22_2 + x8_4 + 0x18) = 0x1010125
        label_49a4dc:
            
            while (true)
                char* x8_10 = *arg1
                
                if (x8_10 != arg1[1] && zx.d(*x8_10) == 0x45)
                    *arg1 = &x8_10[1]
                    void* x0_34 = sub_49e9b4(arg1)
                    
                    if (x0_34 == 0)
                        return nullptr
                    
                    void** x23_3 = arg1[0x266]
                    x21_5 = x0_34
                    int64_t x8_41 = x23_3[1]
                    
                    if (x8_41 + 0x20 u>= 0xff0)
                        void** x0_35 = malloc(0x1000)
                        
                        if (x0_35 == 0)
                            goto label_49a9c8
                        
                        x8_41 = 0
                        *x0_35 = x23_3
                        x0_35[1] = 0
                        x23_3 = x0_35
                        arg1[0x266] = x0_35
                    
                    x23_3[1] = x8_41 + 0x20
                    x22_1 = x23_3 + x8_41 + 0x10
                    *x22_1 = &_vtable_for_(anonymous namespace)::itanium_demangle::QualifiedName{for `(anonymous namespace)::itanium_demangle::Node'}
                    *(x22_1 + 8) = 0x1010116
                    break
                
                struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
                    ** x0_8 = sub_49ec1c(arg1)
                
                if (x0_8 == 0)
                    return nullptr
                
                char* x8_11 = *arg1
                struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NameType::VTable
                    ** x21_2 = x0_8
                
                if (arg1[1] != x8_11 && zx.d(*x8_11) == 0x49)
                    void* x0_10 = sub_495d00(arg1, 0)
                    
                    if (x0_10 == 0)
                        return x0_10
                    
                    void** x27_1 = arg1[0x266]
                    int64_t x8_13 = x27_1[1]
                    
                    if (x8_13 + 0x20 u>= 0xff0)
                        void** x0_11 = malloc(0x1000)
                        
                        if (x0_11 == 0)
                            goto label_49a9c8
                        
                        x8_13 = 0
                        *x0_11 = x27_1
                        x0_11[1] = 0
                        x27_1 = x0_11
                        arg1[0x266] = x0_11
                    
                    x27_1[1] = x8_13 + 0x20
                    *(x27_1 + x8_13 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::NameWithTemplateArgs{for `(anonymous namespace)::itanium_demangle::Node'}
                    *(x27_1 + x8_13 + 0x20) = x21_2
                    *(x27_1 + x8_13 + 0x28) = x0_10
                    x21_2 = x27_1 + x8_13 + 0x10
                    *(x27_1 + x8_13 + 0x18) = 0x1010125
                
                void** x22_3 = arg1[0x266]
                int64_t x8_7 = x22_3[1]
                
                if (x8_7 + 0x20 u>= 0xff0)
                    void** x0_12 = malloc(0x1000)
                    
                    if (x0_12 == 0)
                        goto label_49a9c8
                    
                    x8_7 = 0
                    *x0_12 = x22_3
                    x0_12[1] = 0
                    x22_3 = x0_12
                    arg1[0x266] = x0_12
                
                x22_3[1] = x8_7 + 0x20
                *(x22_3 + x8_7 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::QualifiedName{for `(anonymous namespace)::itanium_demangle::Node'}
                *(x22_3 + x8_7 + 0x18) = 0x1010116
                *(x22_3 + x8_7 + 0x20) = x20_1
                *(x22_3 + x8_7 + 0x28) = x21_2
                x20_1 = x22_3 + x8_7 + 0x10
            
            goto label_49a934
return nullptr
