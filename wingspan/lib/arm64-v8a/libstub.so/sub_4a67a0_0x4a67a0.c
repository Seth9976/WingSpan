// 函数: sub_4a67a0
// 地址: 0x4a67a0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (*(arg1 + 8) != *(*(arg2 + 0x10) + 8))
    jump(*(**(arg1 + 0x10) + 0x38))

int64_t x8_2 = *(arg2 + 0x20)

if (x8_2 == 0)
    *(arg2 + 0x20) = arg3
    *(arg2 + 0x30) = arg4
    *(arg2 + 0x3c) = 1
    return 

if (x8_2 != arg3)
    int32_t x8_3 = *(arg2 + 0x3c)
    *(arg2 + 0x30) = 2
    *(arg2 + 0x3c) = x8_3 + 1
    *(arg2 + 0x4e) = 1
else if (*(arg2 + 0x30) == 2)
    *(arg2 + 0x30) = arg4
