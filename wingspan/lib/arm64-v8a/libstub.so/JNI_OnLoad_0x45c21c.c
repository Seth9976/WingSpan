// 函数: JNI_OnLoad
// 地址: 0x45c21c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x21 + 0x28)
int64_t* var_78
int64_t result

if ((*(*arg1 + 0x30))(arg1, &var_78, 0x10006) == 0)
    sub_490c44(var_78)
    int64_t x24_1 = data_4b0d68
    int64_t var_68_1 = 0
    int64_t var_60_1 = 0
    char* const var_70 = "Int"
    char* const* var_50 = &var_70
    sub_45c4f8(&data_4b0c80, &var_70, 0x452b0f, &var_50)[7] = x24_1
    int64_t x24_2 = data_4b0d60
    int64_t var_68_2 = 0
    int64_t var_60_2 = 0
    var_70 = "Long"
    var_50 = &var_70
    sub_45c4f8(&data_4b0c80, &var_70, 0x452b0f, &var_50)[7] = x24_2
    int64_t x24_3 = data_4b0d70
    int64_t var_68_3 = 0
    int64_t var_60_3 = 0
    var_70 = "Short"
    var_50 = &var_70
    sub_45c4f8(&data_4b0c80, &var_70, 0x452b0f, &var_50)[7] = x24_3
    int64_t x24_4 = data_4b0d78
    int64_t var_68_4 = 0
    int64_t var_60_4 = 0
    var_70 = "Char"
    var_50 = &var_70
    sub_45c4f8(&data_4b0c80, &var_70, 0x452b0f, &var_50)[7] = x24_4
    int64_t x24_5 = data_4b0d80
    int64_t var_68_5 = 0
    int64_t var_60_5 = 0
    var_70 = "Byte"
    var_50 = &var_70
    sub_45c4f8(&data_4b0c80, &var_70, 0x452b0f, &var_50)[7] = x24_5
    int64_t x24_6 = data_4b0d88
    int64_t var_68_6 = 0
    int64_t var_60_6 = 0
    var_70 = "Boolean"
    var_50 = &var_70
    sub_45c4f8(&data_4b0c80, &var_70, 0x452b0f, &var_50)[7] = x24_6
    int64_t x24_7 = data_4b0d58
    int64_t var_68_7 = 0
    int64_t var_60_7 = 0
    var_70 = "Float"
    var_50 = &var_70
    sub_45c4f8(&data_4b0c80, &var_70, 0x452b0f, &var_50)[7] = x24_7
    int64_t x24_8 = data_4b0d50
    int64_t var_68_8 = 0
    int64_t var_60_8 = 0
    var_70 = "Double"
    var_50 = &var_70
    sub_45c4f8(&data_4b0c80, &var_70, 0x452b0f, &var_50)[7] = x24_8
    int64_t* x0_10 = var_78
    int64_t x0_11 = (*(*x0_10 + 0x30))(x0_10, "np/dcc/protect/EntryPoint")
    int64_t* x8_5 = var_78
    int32_t x0_13 = (*(*x8_5 + 0x6b8))(x8_5, x0_11, &data_4abb78, 1)
    int64_t* x8_6 = var_78
    (*(*x8_6 + 0xb8))(x8_6, x0_11)
    
    result = x0_13 == 0 ? 0x10006 : 0
else
    result = 0xffffffff

if (*(x21 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
