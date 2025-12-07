// 函数: sub_4a90d4
// 地址: 0x4a90d4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint32_t x20 = zx.d(arg1)
void* result
int64_t x1

if (x20 != 0x50)
    int64_t var_8
    
    switch (x20 & 0xf)
        case 0, 4, 0xc
            x1 = *arg3
            result = &arg3[1]
        case 1
            result = sub_4a8dbc(arg3, &var_8)
            x1 = var_8
        case 2
            int16_t* x0_5 = arg3
            x1 = zx.q(*x0_5)
            result = &x0_5[1]
        case 3
            int32_t* x0_6 = arg3
            x1 = zx.q(*x0_6)
            result = &x0_6[1]
        case 9
            result = sub_4a8de4(arg3, &var_8)
            x1 = var_8
        case 0xa
            int16_t* x0_7 = arg3
            x1 = sx.q(*x0_7)
            result = &x0_7[1]
        case 0xb
            x1 = sx.q(*arg3)
            result = arg3 + 4
        default
            abort()
            noreturn
    
    if (x1 != 0)
        int64_t* x19_2
        
        if ((x20 & 0x70) == 0x10)
            x19_2 = arg3
        else
            x19_2 = arg2
        
        x1 += x19_2
        
        if ((x20 & 0x80) != 0)
            x1 = *x1
else
    int64_t* x0 = (arg3 + 7) & 0xfffffffffffffff8
    x1 = *x0
    result = &x0[1]

*arg4 = x1
return result
