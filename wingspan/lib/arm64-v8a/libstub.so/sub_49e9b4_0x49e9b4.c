// 函数: sub_49e9b4
// 地址: 0x49e9b4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x8 = *arg1
int64_t x9 = arg1[1]
void* result

if (x9 != x8 && zx.d(*x8) - 0x30 u<= 9)
    void* result_1 = sub_49ec1c(arg1)
    result = result_1
    
    if (result_1 != 0)
    label_49ead8:
        char* x8_6 = *arg1
        
        if (arg1[1] != x8_6 && zx.d(*x8_6) == 0x49)
            void* x0_6 = sub_495d00(arg1, 0)
            
            if (x0_6 == 0)
                return nullptr
            
            void** x22_2 = arg1[0x266]
            int64_t x8_8 = x22_2[1]
            
            if (x8_8 + 0x20 u>= 0xff0)
                void** x0_7 = malloc(0x1000)
                
                if (x0_7 == 0)
                    sub_491944()
                    noreturn
                
                x8_8 = 0
                *x0_7 = x22_2
                x0_7[1] = 0
                x22_2 = x0_7
                arg1[0x266] = x0_7
            
            x22_2[1] = x8_8 + 0x20
            *(x22_2 + x8_8 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::NameWithTemplateArgs{for `(anonymous namespace)::itanium_demangle::Node'}
            *(x22_2 + x8_8 + 0x20) = result
            *(x22_2 + x8_8 + 0x28) = x0_6
            result = x22_2 + x8_8 + 0x10
            *(x22_2 + x8_8 + 0x18) = 0x1010125
else if (x9 - x8 u< 2)
label_49eacc:
    void* result_2 = sub_49ef2c(arg1, nullptr)
    result = result_2
    
    if (result_2 != 0)
        goto label_49ead8
else
    uint32_t x10_1 = zx.d(*x8)
    
    if (x10_1 != 0x64)
        goto label_49eaa8
    
    if (zx.d(x8[1]) != 0x6e)
        x10_1 = zx.d(*x8)
    label_49eaa8:
        
        if (x10_1 != 0x6f)
            goto label_49eacc
        
        if (zx.d(x8[1]) == 0x6e)
            *arg1 = &x8[2]
        
        goto label_49eacc
    
    *arg1 = &x8[2]
    void* x21_1
    
    if (x9 == &x8[2] || zx.d(x8[2]) - 0x30 u> 9)
        void* x0_1 = sub_49e8fc(arg1)
        x21_1 = x0_1
        
        if (x0_1 == 0)
            return nullptr
        
        goto label_49ea34
    
    void* x0_9 = sub_49ec1c(arg1)
    
    if (x0_9 == 0)
        return nullptr
    
    char* x8_11 = *arg1
    x21_1 = x0_9
    
    if (arg1[1] == x8_11 || zx.d(*x8_11) != 0x49)
        goto label_49ea34
    
    void* result_3 = sub_495d00(arg1, 0)
    result = result_3
    
    if (result_3 != 0)
        void** x22_3 = arg1[0x266]
        int64_t x8_13 = x22_3[1]
        
        if (x8_13 + 0x20 u>= 0xff0)
            void** x0_11 = malloc(0x1000)
            
            if (x0_11 == 0)
                sub_491944()
                noreturn
            
            x8_13 = 0
            *x0_11 = x22_3
            x0_11[1] = 0
            x22_3 = x0_11
            arg1[0x266] = x0_11
        
        x22_3[1] = x8_13 + 0x20
        *(x22_3 + x8_13 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::NameWithTemplateArgs{for `(anonymous namespace)::itanium_demangle::Node'}
        *(x22_3 + x8_13 + 0x20) = x21_1
        *(x22_3 + x8_13 + 0x28) = result
        x21_1 = x22_3 + x8_13 + 0x10
        *(x22_3 + x8_13 + 0x18) = 0x1010125
    label_49ea34:
        void** x22_1 = arg1[0x266]
        int64_t x8_4 = x22_1[1]
        
        if (x8_4 + 0x20 u>= 0xff0)
            void** x0_2 = malloc(0x1000)
            
            if (x0_2 == 0)
                sub_491944()
                noreturn
            
            x8_4 = 0
            *x0_2 = x22_1
            x0_2[1] = 0
            x22_1 = x0_2
            arg1[0x266] = x0_2
        
        x22_1[1] = x8_4 + 0x20
        result = x22_1 + x8_4 + 0x10
        *result = &_vtable_for_(anonymous namespace)::itanium_demangle::DtorName{for `(anonymous namespace)::itanium_demangle::Node'}
        *(result + 8) = 0x101012b
        *(result + 0x10) = x21_1

return result
