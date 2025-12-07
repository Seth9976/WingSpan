// 函数: sub_499cfc
// 地址: 0x499cfc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x8 = *arg1
int64_t x10 = arg1[1]

if (x8 != x10 && zx.d(*x8) == 0x66)
    *arg1 = &x8[1]
    
    if (x10 != &x8[1])
        uint32_t x22_1 = zx.d(x8[1])
        struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
            ** result = nullptr
        uint64_t x9_3 = zx.q(x22_1 - 0x4c)
        
        if (x9_3.d u> 0x26)
            return result
        
        int32_t x21_1 = 1
        
        switch (x9_3)
            case 0, 0x20
                goto label_499d80
            case 1, 2, 3, 4, 5, 7, 8, 9, 0xa, 0xb, 0xc, 0xd, 0xe, 0xf, 0x10, 0x11, 0x12, 0x13, 
                    0x14, 0x15, 0x16, 0x17, 0x18, 0x19, 0x1a, 0x1b, 0x1c, 0x1d, 0x1e, 0x1f, 0x21, 
                    0x22, 0x23, 0x24, 0x25
                return result
            case 6, 0x26
                x21_1 = 0
            label_499d80:
                *arg1 = &x8[2]
                
                if (x10 - &x8[2] u>= 2)
                    uint32_t x10_2 = zx.d(x8[2])
                    
                    if (x10_2 != 0x61)
                        goto label_499e40
                    
                    void* const x23_1
                    void* x24_1
                    
                    if (zx.d(x8[3]) == 0x61)
                        x23_1 = &data_451fb2
                    label_49a1e8:
                        x24_1 = x23_1 + 2
                    label_49a1f4:
                        *arg1 = &x8[4]
                        result = sub_49707c(arg1)
                        
                        if (result != 0)
                            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                                ** result_2 = result
                            struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                                ** result_3
                            
                            if (x22_1 == 0x52 || x22_1 == 0x4c)
                                result = sub_49707c(arg1)
                                
                                if (result != 0)
                                    struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::NewExpr::VTable
                                        ** result_1
                                    
                                    result_1 = x21_1 != 0 ? result : result_2
                                    
                                    result_3 = x21_1 != 0 ? result_2 : result
                                    
                                    result_2 = result_1
                                    goto label_49a238
                            else
                                result_3 = nullptr
                            label_49a238:
                                void** x25_1 = arg1[0x266]
                                int64_t x8_2 = x25_1[1]
                                
                                if (x8_2 + 0x40 u>= 0xff0)
                                    void** x0_2 = malloc(0x1000)
                                    
                                    if (x0_2 == 0)
                                        sub_491944()
                                        noreturn
                                    
                                    x8_2 = 0
                                    *x0_2 = x25_1
                                    x0_2[1] = 0
                                    x25_1 = x0_2
                                    arg1[0x266] = x0_2
                                
                                x25_1[1] = x8_2 + 0x40
                                result = x25_1 + x8_2 + 0x10
                                *result = &_vtable_for_(anonymous namespace)::itanium_demangle::FoldExpr{for `(anonymous namespace)::itanium_demangle::Node'}
                                result[1].d = 0x101013e
                                result[2] = result_2
                                result[3] = result_3
                                result[4] = x23_1
                                result[5] = x24_1
                                result[6].b = x21_1.b
                        
                        return result
                    
                    x10_2 = zx.d(x8[2])
                    
                    if (x10_2 == 0x61)
                        if (zx.d(x8[3]) == 0x6e)
                            x23_1 = &data_452170
                            x24_1 = &data_452171
                            goto label_49a1f4
                        
                        x10_2 = zx.d(x8[2])
                        
                        if (x10_2 == 0x61)
                            if (zx.d(x8[3]) == 0x4e)
                                x23_1 = "&="
                                goto label_49a1e8
                            
                            x10_2 = zx.d(x8[2])
                            
                            if (x10_2 == 0x61)
                                if (zx.d(x8[3]) == 0x53)
                                    x23_1 = "="
                                    x24_1 = &data_40e9f2[1]
                                    goto label_49a1f4
                                
                                x10_2 = zx.d(x8[2])
                    
                label_499e40:
                    
                    if (x10_2 == 0x63 && zx.d(x8[3]) == 0x6d)
                        x23_1 = ","
                        x24_1 = &data_40d82a[1]
                        goto label_49a1f4
                    
                    uint32_t x10_12
                    
                    if (zx.d(x8[2]) == 0x64)
                        if (zx.d(x8[3]) == 0x73)
                            x23_1 = ".*"
                            goto label_49a1e8
                        
                        if (zx.d(x8[2]) != 0x64)
                            goto label_499ed4
                        
                        if (zx.d(x8[3]) == 0x76)
                            x23_1 = "/"
                            x24_1 = &data_40c309[1]
                            goto label_49a1f4
                        
                        x10_12 = zx.d(x8[2])
                        
                        if (x10_12 != 0x64)
                            goto label_499ed8
                        
                        if (zx.d(x8[3]) != 0x56)
                            goto label_499ed4
                        
                        x23_1 = "/="
                        goto label_49a1e8
                    
                label_499ed4:
                    x10_12 = zx.d(x8[2])
                label_499ed8:
                    
                    if (x10_12 == 0x65 && zx.d(x8[3]) == 0x6f)
                        x23_1 = "^"
                        x24_1 = &data_40ec85[1]
                        goto label_49a1f4
                    
                    uint32_t x10_16 = zx.d(x8[2])
                    
                    if (x10_16 == 0x65)
                        if (zx.d(x8[3]) == 0x4f)
                            x23_1 = "^="
                            goto label_49a1e8
                        
                        x10_16 = zx.d(x8[2])
                        
                        if (x10_16 == 0x65)
                            if (zx.d(x8[3]) == 0x71)
                                x23_1 = "=="
                                goto label_49a1e8
                            
                            x10_16 = zx.d(x8[2])
                    
                    if (x10_16 == 0x67 && zx.d(x8[3]) == 0x65)
                        x23_1 = ">="
                        goto label_49a1e8
                    
                    uint32_t x10_20 = zx.d(x8[2])
                    
                    if (x10_20 != 0x67)
                        goto label_499f94
                    
                    if (zx.d(x8[3]) == 0x74)
                        x23_1 = ">"
                        x24_1 = &data_40e25c[1]
                        goto label_49a1f4
                    
                    x10_20 = zx.d(x8[2])
                label_499f94:
                    
                    if (x10_20 == 0x6c && zx.d(x8[3]) == 0x65)
                        x23_1 = &data_451a53
                        goto label_49a1e8
                    
                    uint32_t x10_26
                    
                    if (zx.d(x8[2]) == 0x6c)
                        if (zx.d(x8[3]) == 0x73)
                            x23_1 = "<<"
                            goto label_49a1e8
                        
                        if (zx.d(x8[2]) != 0x6c)
                            goto label_49a028
                        
                        if (zx.d(x8[3]) == 0x53)
                            x23_1 = "<<="
                        label_499ff8:
                            x24_1 = x23_1 + 3
                            goto label_49a1f4
                        
                        x10_26 = zx.d(x8[2])
                        
                        if (x10_26 != 0x6c)
                            goto label_49a02c
                        
                        if (zx.d(x8[3]) != 0x74)
                            goto label_49a028
                        
                        x23_1 = "<"
                        x24_1 = &data_40bf3d[1]
                        goto label_49a1f4
                    
                label_49a028:
                    x10_26 = zx.d(x8[2])
                label_49a02c:
                    
                    if (x10_26 == 0x6d && zx.d(x8[3]) == 0x69)
                        x23_1 = "-"
                        x24_1 = &data_40d0c1[1]
                        goto label_49a1f4
                    
                    uint32_t x10_33
                    
                    if (zx.d(x8[2]) == 0x6d)
                        if (zx.d(x8[3]) == 0x49)
                            x23_1 = "-="
                            goto label_49a1e8
                        
                        if (zx.d(x8[2]) != 0x6d)
                            goto label_49a0c0
                        
                        if (zx.d(x8[3]) == 0x6c)
                            x23_1 = "*"
                            x24_1 = &data_40d62a[1]
                            goto label_49a1f4
                        
                        x10_33 = zx.d(x8[2])
                        
                        if (x10_33 != 0x6d)
                            goto label_49a0c4
                        
                        if (zx.d(x8[3]) != 0x4c)
                            goto label_49a0c0
                        
                        x23_1 = "*="
                        goto label_49a1e8
                    
                label_49a0c0:
                    x10_33 = zx.d(x8[2])
                label_49a0c4:
                    
                    if (x10_33 == 0x6e && zx.d(x8[3]) == 0x65)
                        x23_1 = "!="
                        goto label_49a1e8
                    
                    uint32_t x10_40
                    
                    if (zx.d(x8[2]) == 0x6f)
                        if (zx.d(x8[3]) == 0x6f)
                            x23_1 = "||"
                            goto label_49a1e8
                        
                        if (zx.d(x8[2]) != 0x6f)
                            goto label_49a154
                        
                        if (zx.d(x8[3]) == 0x72)
                            x23_1 = &data_451fb5
                            x24_1 = &data_451fb6
                            goto label_49a1f4
                        
                        x10_40 = zx.d(x8[2])
                        
                        if (x10_40 != 0x6f)
                            goto label_49a158
                        
                        if (zx.d(x8[3]) != 0x52)
                            goto label_49a154
                        
                        x23_1 = "|="
                        goto label_49a1e8
                    
                label_49a154:
                    x10_40 = zx.d(x8[2])
                label_49a158:
                    
                    if (x10_40 == 0x70 && zx.d(x8[3]) == 0x6c)
                        x23_1 = "+"
                        x24_1 = &data_40ec8a[1]
                        goto label_49a1f4
                    
                    uint32_t x10_44 = zx.d(x8[2])
                    
                    if (x10_44 == 0x70)
                        if (zx.d(x8[3]) == 0x4c)
                            x23_1 = "+="
                            goto label_49a1e8
                        
                        x10_44 = zx.d(x8[2])
                    
                    if (x10_44 == 0x72 && zx.d(x8[3]) == 0x6d)
                        x23_1 = &data_452ae1
                        x24_1 = &data_452ae2
                        goto label_49a1f4
                    
                    if (zx.d(x8[2]) == 0x72)
                        if (zx.d(x8[3]) == 0x4d)
                            x23_1 = &data_451a56
                            goto label_49a1e8
                        
                        if (zx.d(x8[2]) == 0x72)
                            if (zx.d(x8[3]) == 0x73)
                                x23_1 = ">>"
                                goto label_49a1e8
                            
                            if (zx.d(x8[2]) == 0x72 && zx.d(x8[3]) == 0x53)
                                x23_1 = ">>="
                                goto label_499ff8

return nullptr
