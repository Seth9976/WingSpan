// 函数: sub_4a8fb4
// 地址: 0x4a8fb4
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint32_t x0 = zx.d(arg1)

if (x0 == 0xff)
    return 0

switch (x0 & 7)
    case 0, 4
        return 8
    case 2
        return 2
    case 3
        return 4

abort()
noreturn
