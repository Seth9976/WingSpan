// 函数: sub_4a681c
// 地址: 0x4a681c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x20 = _ReadMSR(tpidr_el0)
int64_t x9 = *(x20 + 0x28)
int128_t v0
v0.q = 0
v0:8.q = 0
void* x9_1 = *arg1
int64_t x10 = *(x9_1 - 0x10)
int64_t* x0 = *(x9_1 - 8)
void* var_78 = arg3
int64_t* var_70 = arg1
int64_t var_68 = arg2
int64_t x3
int64_t var_60 = x3
int128_t var_58
__builtin_memset(&var_58, 0, 0x2f)
void* result_1 = arg1 + x10
void* result
int128_t var_48

if (x0[1] == *(arg3 + 8))
    int32_t var_30_1 = 1
    (*(*x0 + 0x28))(x0, &var_78, result_1, result_1, 1, 0, v0)
    
    result = var_48.d == 1 ? result_1 : nullptr
else
    (*(*x0 + 0x30))(x0, &var_78, result_1, 1, 0, v0)
    int32_t x8_3 = var_48:0xc.d
    int32_t var_38
    
    if (x8_3 == 1)
        if (var_48.d == 1)
            result = var_58.q
        else
            result = nullptr
            
            if (var_38 == 0 && var_48:4.d == 1 && var_48:8.d == 1)
                result = var_58.q
    else if (x8_3 != 0)
        result = nullptr
    else
        bool z_1
        
        if (var_48:8.d == 1)
            z_1 = var_48:4.d == 1
        else
            z_1 = false
        
        bool z_2
        
        z_2 = z_1 ? var_38 == 1 : false
        
        result = z_2 ? var_58:8.q : nullptr

if (*(x20 + 0x28) == x9)
    return result

__stack_chk_fail()
noreturn
