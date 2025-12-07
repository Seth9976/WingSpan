// 函数: sub_4a7348
// 地址: 0x4a7348
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint32_t x2 = zx.d(arg1)

if (x2 != 0xff)
    int32_t x2_1 = x2 & 0x70
    
    if (x2_1 == 0x20)
        return sub_4a7340(arg2) __tailcall
    
    if (x2_1 u> 0x20)
        if (x2_1 == 0x40)
            return sub_4a7308(arg2) __tailcall
        
        if (x2_1 != 0x50)
            if (x2_1 == 0x30)
                return sub_4a7338(arg2) __tailcall
            
            abort()
            noreturn
    else if (x2_1 != 0 && x2_1 != 0x10)
        abort()
        noreturn

return 0
