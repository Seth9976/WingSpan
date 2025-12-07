// 函数: sub_4a9074
// 地址: 0x4a9074
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint32_t x0 = zx.d(arg1)

if (x0 != 0xff)
    int32_t x0_1 = x0 & 0x70
    
    if (x0_1 == 0x20)
        return *(arg2 + 8)
    
    bool cond:2_1
    
    if (x0_1 u> 0x20)
        if (x0_1 == 0x30)
            return *(arg2 + 0x10)
        
        cond:2_1 = x0_1 == 0x50
        goto label_4a90b0
    
    cond:2_1 = x0_1 == 0x10
    
    if (x0_1 != 0)
    label_4a90b0:
        
        if (not(cond:2_1))
            abort()
            noreturn

return 0
