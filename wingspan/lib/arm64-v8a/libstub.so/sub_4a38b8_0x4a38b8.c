// 函数: sub_4a38b8
// 地址: 0x4a38b8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

char* x8 = *arg1
char const* const x21
char const* const x22

if (arg1[1] - x8 u< 2 || zx.d(*x8) != 0x54)
    x21 = nullptr
    x22 = nullptr
else if (zx.d(x8[1]) == 0x73)
    x22 = "struct"
    *arg1 = &x8[2]
    x21 = &data_4527ed[6]
else if (zx.d(*x8) != 0x54)
    x21 = nullptr
    x22 = nullptr
else if (zx.d(x8[1]) == 0x75)
    x22 = "union"
    *arg1 = &x8[2]
    x21 = &data_40f01a[5]
else if (zx.d(*x8) != 0x54 || zx.d(x8[1]) != 0x65)
    x21 = nullptr
    x22 = nullptr
else
    x22 = "enum"
    *arg1 = &x8[2]
    x21 = &data_451fd7[4]

void* result_1 = sub_4946a0(arg1, nullptr)
void* result = result_1

if (result_1 != 0 && x22 != x21)
    void** x23_1 = arg1[0x266]
    int64_t x8_4 = x23_1[1]
    
    if (x8_4 + 0x30 u>= 0xff0)
        void** x0_1 = malloc(0x1000)
        
        if (x0_1 == 0)
            sub_491944()
            noreturn
        
        x8_4 = 0
        *x0_1 = x23_1
        x0_1[1] = 0
        x23_1 = x0_1
        arg1[0x266] = x0_1
    
    x23_1[1] = x8_4 + 0x30
    *(x23_1 + x8_4 + 0x10) = &_vtable_for_(anonymous namespace)::itanium_demangle::ElaboratedTypeSpefType{for `(anonymous namespace)::itanium_demangle::Node'}
    *(x23_1 + x8_4 + 0x30) = result
    result = x23_1 + x8_4 + 0x10
    *(x23_1 + x8_4 + 0x18) = 0x1010106
    *(x23_1 + x8_4 + 0x20) = x22
    *(x23_1 + x8_4 + 0x28) = x21

return result
