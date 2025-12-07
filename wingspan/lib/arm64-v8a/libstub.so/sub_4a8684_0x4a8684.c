// 函数: sub_4a8684
// 地址: 0x4a8684
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x23 = arg1[2]
int64_t x24 = arg1[3]

while (true)
    void var_680
    int32_t x0_1 = sub_4a78b8(arg2, &var_680)
    
    if (x0_1 != 5 && x0_1 != 0)
        return 2
    
    int64_t x1_1
    
    x1_1 = x0_1 == 5 ? 0x1a : 0xa
    
    if (x23(1, x1_1, *arg1, arg1, arg2, x24) != 0)
        return 2
    
    if (x0_1 == 5)
        return zx.q(x0_1)
    
    int64_t var_30
    
    if (var_30 != 0)
        int32_t x0_4 = var_30(1, 0xa, *arg1, arg1, arg2)
        
        if (x0_4 == 7)
            return zx.q(x0_4)
        
        if (x0_4 != 8)
            return 2
    
    sub_4a8578(arg2, &var_680)
