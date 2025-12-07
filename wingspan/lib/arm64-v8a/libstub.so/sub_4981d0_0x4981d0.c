// 函数: sub_4981d0
// 地址: 0x4981d0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

*arg2 = arg1 + 2
void* x0_1 = sub_492f20(arg2)
struct (anonymous namespace)::itanium_demangle::Node::(anonymous namespace)::itanium_demangle::EnclosingExpr::VTable
    ** result

if (x0_1 != 0)
    void** x21_1 = arg2[0x266]
    int64_t x8 = x21_1[1]
    
    if (x8 + 0x40 u>= 0xff0)
        void** x0_2 = malloc(0x1000)
        
        if (x0_2 == 0)
            sub_491944()
            noreturn
        
        x8 = 0
        *x0_2 = x21_1
        x0_2[1] = 0
        x21_1 = x0_2
        arg2[0x266] = x0_2
    
    x21_1[1] = x8 + 0x40
    result = x21_1 + x8 + 0x10
    *result = &_vtable_for_(anonymous namespace)::itanium_demangle::EnclosingExpr{for `(anonymous namespace)::itanium_demangle::Node'}
    result[1].d = 0x1010134
    result[2] = "alignof ("
    result[3] = &data_40dfd6[9]
    result[4] = x0_1
    result[5] = &data_4525e5
    result[6] = &data_4525e6
else
    result = nullptr

if (*(arg3 + 0x28) == *(arg4 - 8))
    return result

__stack_chk_fail()
noreturn
