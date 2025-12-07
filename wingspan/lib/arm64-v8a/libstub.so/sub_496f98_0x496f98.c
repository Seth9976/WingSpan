// 函数: sub_496f98
// 地址: 0x496f98
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (zx.d(*(arg1 + 0x20)) != 0)
    return arg1

int64_t* x0 = *(arg1 + 0x18)
*(arg1 + 0x20) = 1
void* x0_1 = (*(*x0 + 0x18))()
*(arg1 + 0x20) = 0
return x0_1
