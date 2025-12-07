// 函数: sub_4a9254
// 地址: 0x4a9254
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x0_2 = strlen(arg1 + 9) + 1
void* x1 = &(arg1 + 9)[x0_2]

if (zx.d(*(arg1 + 8)) u> 3)
    if (zx.d((arg1 + 9)[x0_2]) != 8 || zx.d(*(x1 + 1)) != 0)
        return 0xff
    
    x1 += 2

if (zx.d(*(arg1 + 9)) == 0x7a)
    void var_10
    void var_8
    char* x0_7 = sub_4a8de4(sub_4a8dbc(x1, &var_10), &var_8)
    void* x0_8
    
    if (zx.d(*(arg1 + 8)) != 1)
        x0_8 = sub_4a8dbc(x0_7, &var_10)
    else
        x0_8 = &x0_7[1]
    
    void* x19_1 = arg1 + 0xa
    char* x0_9 = sub_4a8dbc(x0_8, &var_10)
    
    while (true)
        uint32_t x1_5 = zx.d(*x19_1)
        
        if (x1_5 == 0x52)
            return zx.q(*x0_9)
        
        void var_18
        
        if (x1_5 != 0x50)
            if (x1_5 != 0x4c)
                break
            
            x0_9 = &x0_9[1]
        else
            x0_9 = sub_4a90d4(*x0_9 & 0x7f, nullptr, &x0_9[1], &var_18)
        x19_1 += 1

return 0
