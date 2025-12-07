// 函数: sub_4a2148
// 地址: 0x4a2148
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x8 = zx.q(*(arg1 + 0xc))

if (x8.d u> 5)
    return 

int64_t x8_2
int64_t x8_7
char const* const x9_7
int64_t* x20_2

switch (x8)
    case 0
        x20_2 = &arg2[1]
        int64_t x8_1 = *x20_2
        int64_t x10_2 = x20_2[1]
        
        if (x8_1 + 0xe u>= x10_2)
            void* oldmem_3 = *arg2
            size_t bytes_9 = x10_2 << 1
            size_t bytes_3
            
            if (bytes_9 u< x8_1 + 0xe)
                bytes_3 = x8_1 + 0xe
            else
                bytes_3 = bytes_9
            
            arg2[2] = bytes_3
            arg1 = realloc(oldmem_3, bytes_3)
            *arg2 = arg1
            
            if (arg1 == 0)
                sub_491944()
                noreturn
            
            __builtin_strncpy(arg1 + *x20_2, "std::allocator", 0xe)
            x8_7 = 0xe
        else
            __builtin_strncpy(*arg2 + x8_1, "std::allocator", 0xe)
            x8_7 = 0xe
    case 1
        x20_2 = &arg2[1]
        int64_t x8_4 = *x20_2
        int64_t x10_6 = x20_2[1]
        
        if (x8_4 + 0x11 u>= x10_6)
            void* oldmem_4 = *arg2
            size_t bytes_10 = x10_6 << 1
            size_t bytes_4
            
            if (bytes_10 u< x8_4 + 0x11)
                bytes_4 = x8_4 + 0x11
            else
                bytes_4 = bytes_10
            
            arg2[2] = bytes_4
            arg1 = realloc(oldmem_4, bytes_4)
            *arg2 = arg1
            
            if (arg1 == 0)
                sub_491944()
                noreturn
            
            __builtin_strncpy(arg1 + *x20_2, "std::basic_string", 0x11)
            x8_7 = 0x11
        else
            __builtin_strncpy(*arg2 + x8_4, "std::basic_string", 0x11)
            x8_7 = 0x11
    case 2
        x20_2 = &arg2[1]
        int64_t x8_3 = *x20_2
        int64_t x10_4 = x20_2[1]
        
        if (x8_3 + 0xb u>= x10_4)
            void* oldmem_1 = *arg2
            size_t bytes_7 = x10_4 << 1
            size_t bytes_1
            
            if (bytes_7 u< x8_3 + 0xb)
                bytes_1 = x8_3 + 0xb
            else
                bytes_1 = bytes_7
            
            arg2[2] = bytes_1
            arg1 = realloc(oldmem_1, bytes_1)
            *arg2 = arg1
            
            if (arg1 == 0)
                sub_491944()
                noreturn
            
            __builtin_strncpy(arg1 + *x20_2, "std::string", 0xb)
            x8_7 = 0xb
        else
            __builtin_strncpy(*arg2 + x8_3, "std::string", 0xb)
            x8_7 = 0xb
    case 3
        x20_2 = &arg2[1]
        x8_2 = *x20_2
        int64_t x10_5 = x20_2[1]
        
        if (x8_2 + 0xc u>= x10_5)
            void* oldmem_2 = *arg2
            size_t bytes_8 = x10_5 << 1
            size_t bytes_2
            
            if (bytes_8 u< x8_2 + 0xc)
                bytes_2 = x8_2 + 0xc
            else
                bytes_2 = bytes_8
            
            arg2[2] = bytes_2
            arg1 = realloc(oldmem_2, bytes_2)
            *arg2 = arg1
            
            if (arg1 == 0)
                sub_491944()
                noreturn
            
            x8_2 = *x20_2
        else
            arg1 = *arg2
        
        x9_7 = "std::istream"
        goto label_4a22e4
    case 4
        x20_2 = &arg2[1]
        x8_2 = *x20_2
        int64_t x10_3 = x20_2[1]
        
        if (x8_2 + 0xc u>= x10_3)
            void* oldmem = *arg2
            size_t bytes_6 = x10_3 << 1
            size_t bytes
            
            if (bytes_6 u< x8_2 + 0xc)
                bytes = x8_2 + 0xc
            else
                bytes = bytes_6
            
            arg2[2] = bytes
            arg1 = realloc(oldmem, bytes)
            *arg2 = arg1
            
            if (arg1 == 0)
                sub_491944()
                noreturn
            
            x8_2 = *x20_2
        else
            arg1 = *arg2
        
        x9_7 = "std::ostream"
    label_4a22e4:
        int64_t x9_8 = *x9_7
        void* x8_8 = arg1 + x8_2
        __builtin_strncpy(x8_8 + 8, "ream", 4)
        *x8_8 = x9_8
        x8_7 = 0xc
    case 5
        x20_2 = &arg2[1]
        int64_t x8_5 = *x20_2
        int64_t x10_7 = x20_2[1]
        
        if (x8_5 + 0xd u>= x10_7)
            void* oldmem_5 = *arg2
            size_t bytes_11 = x10_7 << 1
            size_t bytes_5
            
            if (bytes_11 u< x8_5 + 0xd)
                bytes_5 = x8_5 + 0xd
            else
                bytes_5 = bytes_11
            
            arg2[2] = bytes_5
            arg1 = realloc(oldmem_5, bytes_5)
            *arg2 = arg1
            
            if (arg1 == 0)
                sub_491944()
                noreturn
            
            __builtin_strncpy(arg1 + *x20_2, "std::iostream", 0xd)
            x8_7 = 0xd
        else
            __builtin_strncpy(*arg2 + x8_5, "std::iostream", 0xd)
            x8_7 = 0xd

*x20_2 += x8_7
