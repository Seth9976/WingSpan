// 函数: sub_496620
// 地址: 0x496620
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

void* x8 = *arg2

if (zx.d(*(x8 + 8)) != 0x29)
    goto label_4966b8

int32_t x22_1 = *(x8 + 0xc)

if (x22_1 - 2 u> 3)
    goto label_4966b8

void** x23_1 = arg1[0x266]
int64_t x8_2 = x23_1[1]

if (x8_2 + 0x10 u< 0xff0)
    goto label_4966a8

void** x0 = malloc(0x1000)

if (x0 != 0)
    x8_2 = 0
    *x0 = x23_1
    x0[1] = 0
    x23_1 = x0
    arg1[0x266] = x0
label_4966a8:
    x23_1[1] = x8_2 + 0x10
    *(x23_1 + x8_2 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::ExpandedSpecialSubstitution{for `(anonymous namespace)::itanium_demangle::Node'}
    *(x23_1 + x8_2 + 0x18) = 0x1010128
    *(x23_1 + x8_2 + 0x1c) = x22_1
    *arg2 = x23_1 + x8_2 + 0x10
label_4966b8:
    char* x8_5 = *arg1
    int64_t x9_3 = arg1[1]
    void* result
    int32_t x9_8
    int64_t x10_4
    
    if (x8_5 == x9_3 || zx.d(*x8_5) != 0x43)
        if (x9_3 == x8_5)
            return nullptr
        
        if (x9_3 - x8_5 == 1 || zx.d(*x8_5) != 0x44)
            return nullptr
        
        uint64_t x22_2 = zx.q(x8_5[1])
        
        if (x22_2.d u> 0x35 || (1 << x22_2 & 0x37000000000000) == 0)
            return nullptr
        
        *arg1 = &x8_5[2]
        
        if (arg3 != 0)
            *arg3 = 1
        
        void** x21_1 = arg1[0x266]
        int64_t x8_8 = x21_1[1]
        
        if (x8_8 + 0x20 u< 0xff0)
            goto label_496790
        
        void** x0_1 = malloc(0x1000)
        
        if (x0_1 != 0)
            x8_8 = 0
            *x0_1 = x21_1
            x0_1[1] = 0
            x21_1 = x0_1
            arg1[0x266] = x0_1
        label_496790:
            x21_1[1] = x8_8 + 0x20
            x10_4 = *arg2
            x9_8 = x22_2.d - 0x30
            result = x21_1 + x8_8 + 0x10
            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::CtorDtorName{for `(anonymous namespace)::itanium_demangle::Node'}
            *(result + 8) = 0x101012a
            *(result + 0x18) = 1
        label_496868:
            *(result + 0x10) = x10_4
            *(result + 0x1c) = x9_8
            return result
    else
        void* x10_2 = &x8_5[1]
        *arg1 = x10_2
        
        if (x10_2 == x9_3)
            return nullptr
        
        int32_t x8_6
        
        if (zx.d(*x10_2) != 0x49)
            x8_6 = 0
            
            if (x9_3 == x10_2)
                return nullptr
        else
            x10_2 = &x8_5[2]
            x8_6 = 1
            *arg1 = x10_2
            
            if (x9_3 == x10_2)
                return nullptr
        
        uint32_t x22_3 = zx.d(*x10_2)
        
        if (x22_3 - 0x31 u> 4)
            return nullptr
        
        *arg1 = x10_2 + 1
        
        if (arg3 != 0)
            *arg3 = 1
        
        if (x8_6 != 0)
            result = sub_4946a0(arg1, arg3)
        
        if (x8_6 != 0 && result == 0)
            return result
        
        void** x21_2 = arg1[0x266]
        int64_t x8_9 = x21_2[1]
        
        if (x8_9 + 0x20 u< 0xff0)
            goto label_49683c
        
        void** x0_4 = malloc(0x1000)
        
        if (x0_4 != 0)
            x8_9 = 0
            *x0_4 = x21_2
            x0_4[1] = 0
            x21_2 = x0_4
            arg1[0x266] = x0_4
        label_49683c:
            x21_2[1] = x8_9 + 0x20
            x10_4 = *arg2
            result = x21_2 + x8_9 + 0x10
            *result = &_vtable_for_(anonymous namespace)::itanium_demangle::CtorDtorName{for `(anonymous namespace)::itanium_demangle::Node'}
            x9_8 = x22_3 - 0x30
            *(result + 8) = 0x101012a
            *(result + 0x18) = 0
            goto label_496868

sub_491944()
noreturn
