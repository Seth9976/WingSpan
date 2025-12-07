// 函数: sub_45bb84
// 地址: 0x45bb84
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x21 = arg2

if (arg2 != 0)
    int64_t x0 = (*(*arg1 + 0x30))(arg1, arg3)
    
    if (x0 == 0)
        x21 = 0
    else
        x21 = zx.q(zx.d((*(*arg1 + 0x100))(arg1, x21, x0)) != 0 ? 1 : 0)
        (*(*arg1 + 0xb8))(arg1, x0)

return zx.q(x21.d)
