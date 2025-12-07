// 函数: sub_4a6650
// 地址: 0x4a6650
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
void* result

if (*(arg1 + 8) == arg2[1])
    result = 1
else
    int128_t v0_1
    result, v0_1 = sub_4a681c(arg2, &_typeinfo_for___cxxabiv1::__shim_type_info, 
        &_typeinfo_for___cxxabiv1::__class_type_info)
    
    if (result != 0)
        v0_1.q = 0
        v0_1:8.q = 0
        void* result_1 = result
        int64_t var_80_1 = 0
        void* var_78_1 = arg1
        int64_t var_70_1 = -1
        int128_t var_49_1 = zx.o(0)
        int64_t var_68_1 = (zx.o(0)).q
        int32_t var_58_1 = (zx.o(0)).d
        var_49_1:9.d = 1
        (*(*result + 0x38))(result, &result_1, *arg3, 1, v0_1)
        
        if (var_58_1 != 1)
            result = nullptr
        else
            *arg3 = var_68_1
            result = 1

if (*(x21 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
