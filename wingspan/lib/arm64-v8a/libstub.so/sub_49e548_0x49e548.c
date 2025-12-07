// 函数: sub_49e548
// 地址: 0x49e548
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t* x22 = *(arg1 + 0x1330)
size_t x20 = arg3 - arg2
int64_t x23 = zx.q(x20.d + 0xf) & 0xfffffff0
int64_t x8 = x22[1]

if (x8 + x23 u< 0xff0)
    goto label_49e5d4

void* result

if (x23 u< 0xff1)
    int64_t** x0_2 = malloc(0x1000)
    
    if (x0_2 == 0)
        sub_491944()
        noreturn
    
    x8 = 0
    *x0_2 = x22
    x0_2[1] = 0
    x22 = x0_2
    *(arg1 + 0x1330) = x0_2
label_49e5d4:
    result = x22 + x8 + 0x10
    x22[1] = x8 + x23
    
    if (x20 != 0)
        memmove(result, arg2, x20)
else
    int64_t* x0_1 = malloc(x23 + 0x10)
    
    if (x0_1 == 0)
        sub_491944()
        noreturn
    
    result = &x0_1[2]
    *x0_1 = *x22
    x0_1[1] = 0
    *x22 = x0_1
    
    if (x20 != 0)
        memmove(result, arg2, x20)

return result
