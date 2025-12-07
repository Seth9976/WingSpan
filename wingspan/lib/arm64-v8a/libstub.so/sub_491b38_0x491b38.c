// 函数: sub_491b38
// 地址: 0x491b38
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
char* oldmem_2

if (arg1 != 0)
    oldmem_2 = arg2

char* result

if (arg1 != 0 && (arg2 == 0 || arg3 != 0))
    size_t x0_1 = strlen(arg1)
    void* x9_1 = &arg1[x0_1]
    int128_t var_1398
    int128_t* x23_1 = &var_1398
    void* var_13c0 = arg1
    int128_t* var_13a8_1 = &var_1398
    int128_t* var_1298
    int64_t* var_13a0_1 = &var_1298
    int128_t* var_13b0_1 = &var_1398
    int128_t* var_1128
    int64_t* var_1170_1 = &var_1128
    __builtin_memset(&var_1398, 0, 0x100)
    int128_t var_1280
    int128_t* var_1290_1 = &var_1280
    int128_t* var_1180
    int64_t* var_1288_1 = &var_1180
    var_1298 = &var_1280
    __builtin_memset(&var_1280, 0, 0x100)
    int128_t var_1168
    var_1180 = &var_1168
    int128_t* var_1178_1 = &var_1168
    __builtin_memset(&var_1168, 0, 0x40)
    int16_t var_10b8
    int16_t* var_10e0_1 = &var_10b8
    int128_t* var_10f0
    int64_t* var_1118_1 = &var_10f0
    int128_t var_1110
    var_1128 = &var_1110
    int128_t* var_1120_1 = &var_1110
    __builtin_memset(&var_1110, 0, 0x20)
    int128_t var_10d8
    var_10f0 = &var_10d8
    int128_t* var_10e8_1 = &var_10d8
    __builtin_memset(&var_10d8, 0, 0x20)
    var_10b8 = 1
    int128_t var_1090 = zx.o(0)
    char* oldmem
    __builtin_memset(&oldmem, 0, 0x18)
    int64_t var_10b0_1 = -1
    int32_t var_10a0_1 = 0
    int64_t var_10a8_1 = 0
    int128_t* var_90_1 = &var_1090
    int64_t var_13c8_1 = -1
    int32_t x8_17
    void* x22_2
    
    if (x0_1 u< 2 || zx.d(*arg1) != 0x5f)
    label_491dd8:
        x22_2 = sub_492f20(&var_13c0)
        
        if (x9_1 == var_13c0 && x22_2 != 0)
            goto label_491de8
        
        result = nullptr
        x8_17 = -2
    else
        uint32_t x8_2 = zx.d(arg1[1])
        int64_t x8_3
        
        if (x8_2 != 0x5a)
            if (x0_1 u< 3 || x8_2 != 0x5f)
                goto label_491dd8
            
            if (zx.d(arg1[2]) == 0x5a)
                x8_3 = 3
                goto label_491cfc
            
            if (x0_1 u< 4)
                goto label_491dd8
            
            int64_t x8_18
            
            if (zx.d(arg1[2]) != 0x5f || zx.d(arg1[3]) != 0x5a)
                if (x0_1 u< 5 || x8_2 != 0x5f || zx.d(arg1[2]) != 0x5f || zx.d(arg1[3]) != 0x5f
                        || zx.d(arg1[4]) != 0x5a)
                    goto label_491dd8
                
                x8_18 = 5
            else
                x8_18 = 4
            
            var_13c0 = &arg1[x8_18]
            void* x0_11 = sub_4922d0(&var_13c0)
            
            if (x0_11 == 0)
                result = nullptr
                x8_17 = -2
            else
                void* x10_2 = var_13c0
                
                if (x9_1 - x10_2 u< 0xd || zx.d(*x10_2) != 0x5f || zx.d(*(x10_2 + 1)) != 0x62
                        || zx.d(*(x10_2 + 2)) != 0x6c || zx.d(*(x10_2 + 3)) != 0x6f
                        || zx.d(*(x10_2 + 4)) != 0x63 || zx.d(*(x10_2 + 5)) != 0x6b
                        || zx.d(*(x10_2 + 6)) != 0x5f || zx.d(*(x10_2 + 7)) != 0x69
                        || zx.d(*(x10_2 + 8)) != 0x6e || zx.d(*(x10_2 + 9)) != 0x76
                        || zx.d(*(x10_2 + 0xa)) != 0x6f || zx.d(*(x10_2 + 0xb)) != 0x6b
                        || zx.d(*(x10_2 + 0xc)) != 0x65)
                    result = nullptr
                    x8_17 = -2
                else
                    void* x9_24 = x10_2 + 0xd
                    var_13c0 = x9_24
                    void* x12_2
                    
                    if (x9_24 == x9_1)
                        x12_2 = x9_24
                        x9_24 = x9_1
                    label_4920c4:
                        
                        if (x9_1 == x9_24 || zx.d(*x9_24) != 0x2e)
                            if (x9_1 == x12_2)
                                goto label_4920ec
                            
                            result = nullptr
                            x8_17 = -2
                        else
                            var_13c0 = x9_1
                        label_4920ec:
                            void** x22_3 = var_90_1
                            int64_t x8_25 = *(var_90_1 + 8)
                            
                            if (x8_25 + 0x30 u>= 0xff0)
                                void** x0_12 = malloc(0x1000)
                                
                                if (x0_12 == 0)
                                    sub_491944()
                                    noreturn
                                
                                x8_25 = 0
                                *x0_12 = x22_3
                                x0_12[1] = 0
                                x22_3 = x0_12
                                var_90_1 = x0_12
                            
                            x22_3[1] = x8_25 + 0x30
                            x22_2 = x22_3 + x8_25 + 0x10
                            *x22_2 = &_vtable_for_(anonymous namespace)::itanium_demangle::SpecialName{for `(anonymous namespace)::itanium_demangle::Node'}
                            *(x22_2 + 0x10) = "invocation function for block in "
                            *(x22_2 + 0x18) = &data_451d03[0x21]
                            *(x22_2 + 8) = 0x1010114
                            *(x22_2 + 0x20) = x0_11
                        label_491de8:
                            int128_t* var_13f0_1 = &var_1398
                            int64_t x27_1
                            
                            if (oldmem_2 == 0)
                                x27_1 = 0x400
                                char* oldmem_3 = malloc(0x400)
                                oldmem_2 = oldmem_3
                                
                                if (oldmem_3 != 0)
                                    goto label_491e18
                                
                                x23_1 = var_13f0_1
                                result = nullptr
                                x8_17 = -1
                            else
                                x27_1 = *arg3
                            label_491e18:
                                oldmem = oldmem_2
                                int64_t var_13d8_1 = 0
                                x23_1 = var_13f0_1
                                (*(*x22_2 + 0x20))(x22_2, &oldmem)
                                
                                if (zx.d(*(x22_2 + 9)) != 1)
                                    (*(*x22_2 + 0x28))(x22_2, &oldmem)
                                
                                int64_t x8_15 = var_13d8_1
                                size_t bytes_3 = x8_15 + 1
                                char* oldmem_1
                                
                                if (bytes_3 u>= x27_1)
                                    int64_t bytes_2 = x27_1 << 1
                                    size_t bytes
                                    
                                    bytes = bytes_2 u< bytes_3 ? bytes_3 : bytes_2
                                    
                                    size_t bytes_1 = bytes
                                    oldmem_1 = realloc(oldmem, bytes)
                                    oldmem = oldmem_1
                                    
                                    if (oldmem_1 == 0)
                                        sub_491944()
                                        noreturn
                                    
                                    x8_15 = var_13d8_1
                                    bytes_3 = x8_15 + 1
                                else
                                    oldmem_1 = oldmem
                                
                                oldmem_1[x8_15] = 0
                                
                                if (arg3 != 0)
                                    *arg3 = bytes_3
                                
                                result = oldmem
                                x8_17 = 0
                    else
                        int32_t x10_3
                        void* x11_2
                        
                        if (zx.d(*x9_24) != 0x5f)
                            x10_3 = 0
                            x11_2 = x9_24
                        else
                            x11_2 = x10_2 + 0xe
                            x10_3 = 1
                            x9_24 = x11_2
                            var_13c0 = x11_2
                        
                        void* x13_2
                        
                        if (x9_1 == x11_2)
                            x11_2 = nullptr
                            x13_2 = nullptr
                            x12_2 = x9_1
                        else if (zx.d(*x9_24) - 0x30 u<= 9)
                            void* x12_5 = x9_24 + 1
                            
                            while (true)
                                x9_24 = x12_5
                                var_13c0 = x12_5
                                
                                if (x9_1 == x12_5)
                                    x12_2 = x9_1
                                    x13_2 = x9_1
                                    break
                                
                                x12_5 = x9_24 + 1
                                
                                if (zx.d(*x9_24) - 0x30 u>= 0xa)
                                    x12_2 = x12_5 - 1
                                    x13_2 = x12_2
                                    break
                        else
                            x13_2 = nullptr
                            x12_2 = x11_2
                            x11_2 = nullptr
                        
                        if ((x10_3 & (x11_2 == x13_2 ? 1 : 0) & 1) == 0)
                            goto label_4920c4
                        
                        result = nullptr
                        x8_17 = -2
        else
            x8_3 = 2
        label_491cfc:
            var_13c0 = &arg1[x8_3]
            void* x0_3 = sub_4922d0(&var_13c0)
            x22_2 = x0_3
            
            if (x0_3 == 0)
                result = nullptr
                x8_17 = -2
            else
                void* x13_1 = var_13c0
                
                if (x9_1 == x13_1)
                    if (x22_2 != 0)
                        goto label_491de8
                    
                    result = nullptr
                    x8_17 = -2
                else if (zx.d(*x13_1) != 0x2e)
                    result = nullptr
                    x8_17 = -2
                else
                    int128_t* x0_4 = var_90_1
                    int64_t x8_6 = *(x0_4 + 8)
                    
                    if (x8_6 + 0x30 u>= 0xff0)
                        int128_t* var_1408_1 = x0_4
                        x0_4 = malloc(0x1000)
                        
                        if (x0_4 == 0)
                            sub_491944()
                            noreturn
                        
                        x8_6 = 0
                        var_90_1 = x0_4
                        *x0_4 = var_1408_1
                        *(x0_4 + 8) = 0
                    
                    *(x0_4 + 8) = x8_6 + 0x30
                    *(x0_4 + x8_6 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::DotSuffix{for `(anonymous namespace)::itanium_demangle::Node'}
                    *(x0_4 + x8_6 + 0x18) = 0x1010101
                    *(x0_4 + x8_6 + 0x20) = x22_2
                    *(x0_4 + x8_6 + 0x28) = x13_1
                    *(x0_4 + x8_6 + 0x30) = x9_1
                    x22_2 = x0_4 + x8_6 + 0x10
                    var_13c0 = x9_1
                    
                    if (x0_4 + x8_6 != -0x10)
                        goto label_491de8
                    
                    result = nullptr
                    x8_17 = -2
    
    if (arg4 != 0)
        *arg4 = x8_17
    
    int128_t* x0_13 = var_90_1
    
    if (x0_13 != 0)
        while (true)
            int128_t* x8_27 = *x0_13
            
            if (&var_1090 != x0_13)
                free(x0_13)
                x0_13 = x8_27
                
                if (x0_13 == 0)
                    break
            else
                x0_13 = x8_27
                
                if (x0_13 == 0)
                    break
    
    var_1090.q = 0
    var_1090:8.q = 0
    int128_t* x0_14 = var_10f0
    int128_t* var_90_3 = &var_1090
    
    if (x0_14 != &var_10d8)
        free(x0_14)
    
    int128_t* x0_15 = var_1128
    
    if (x0_15 != &var_1110)
        free(x0_15)
    
    int128_t* x0_16 = var_1180
    
    if (x0_16 != &var_1168)
        free(x0_16)
    
    int128_t* x0_17 = var_1298
    
    if (x0_17 != &var_1280)
        free(x0_17)
    
    if (var_13b0_1 != x23_1)
        free(var_13b0_1)
else
    result = nullptr
    
    if (arg4 != 0)
        *arg4 = 0xfffffffd

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
