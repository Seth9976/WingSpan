// 函数: sub_4a56c8
// 地址: 0x4a56c8
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x23 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x23 + 0x28)
int32_t result = 3

if (arg1 == 1 && arg4 != 0 && arg5 != 0)
    int64_t x21_1 = arg3 & 0xffffffffffffff00
    int64_t var_78
    int128_t var_60
    int32_t result_1
    
    if ((arg2 & 1) != 0)
        int128_t v0_1
        int128_t v1_1
        v0_1, v1_1 = sub_4a5884(&var_78, arg2, x21_1 == 0x434c4e47432b2b00 ? 1 : 0, arg4, arg5)
        result = result_1
        
        if (result == 6 && x21_1 == 0x434c4e47432b2b00)
            result = 6
            *(arg4 - 0x24) = var_78.d
            int128_t var_70
            *(arg4 - 0x20) = var_70
            *(arg4 - 0x10) = var_60
    else if ((arg2 & 2) == 0)
        result = 3
    else if ((arg2 & 4) != 0)
        int64_t x21_2
        uint64_t x22_1
        
        if (x21_1 != 0x434c4e47432b2b00)
            sub_4a5884(&var_78, arg2, 0, arg4, arg5)
            
            if (result_1 != 6)
                sub_4a5e8c(0, arg4)
                noreturn
            
            x21_2 = var_78
            x22_1 = var_60.q
        else
            x21_2 = sx.q(*(arg4 - 0x24))
            var_78 = x21_2
            int128_t v0 = *(arg4 - 0x10)
            int128_t var_70_1 = *(arg4 - 0x20)
            int128_t var_60_1 = v0
            x22_1 = v0.q
        
        sub_4a7284(arg5, 0, arg4)
        sub_4a7284(arg5, 1, x21_2)
        sub_4a72f8(arg5, x22_1)
        result = 7
    else
        sub_4a5884(&var_78, arg2, x21_1 == 0x434c4e47432b2b00 ? 1 : 0, arg4, arg5)
        result = result_1
        
        if (result == 6)
            sub_4a7284(arg5, 0, arg4)
            sub_4a7284(arg5, 1, var_78)
            sub_4a72f8(arg5, var_60.q)
            result = 7

if (*(x23 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
