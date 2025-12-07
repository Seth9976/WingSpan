// 函数: sub_4916a0
// 地址: 0x4916a0
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x20 = *arg1
void* x0 = sub_4918fc()

if (0x434c4e47432b2b != x20 u>> 8)
    if (*x0 != 0)
        sub_491944()
        noreturn
    
    *x0 = arg1 - 0x60
    return &arg1[4]

int32_t x9 = arg1[-5].d
int32_t x9_1

if (x9 s< 0)
    x9_1 = neg.d(x9)
else
    x9_1 = x9

arg1[-5].d = x9_1 + 1
int64_t x9_3 = *x0

if (x9_3 != arg1 - 0x60)
    arg1[-6] = x9_3
    *x0 = arg1 - 0x60

*(x0 + 8) -= 1
return arg1[-1]
