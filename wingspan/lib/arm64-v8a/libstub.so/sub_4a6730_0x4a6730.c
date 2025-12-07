// 函数: sub_4a6730
// 地址: 0x4a6730
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (*(arg1 + 8) != *(*(arg2 + 0x10) + 8))
    return 

int64_t x8_1 = *(arg2 + 0x20)

if (x8_1 == 0)
    *(arg2 + 0x20) = arg3
    *(arg2 + 0x30) = arg4
    *(arg2 + 0x3c) = 1
    return 

if (x8_1 != arg3)
    int32_t x8_2 = *(arg2 + 0x3c)
    *(arg2 + 0x30) = 2
    *(arg2 + 0x3c) = x8_2 + 1
    *(arg2 + 0x4e) = 1
    return 

if (*(arg2 + 0x30) == 2)
    *(arg2 + 0x30) = arg4
