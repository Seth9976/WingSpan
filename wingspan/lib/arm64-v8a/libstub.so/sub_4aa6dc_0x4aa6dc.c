// 函数: sub_4aa6dc
// 地址: 0x4aa6dc
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x20 = arg1[1]
int64_t x0 = *arg1
void* result

if (x20 u> 8)
    int64_t x0_5 = malloc(x20 + x0 + 7)
    
    if (x0_5 == 0)
        abort()
        noreturn
    
    result = (x0_5 + x20 + 7) & neg.q(x20)
    *(result - 8) = x0_5
else
    int64_t* x0_2 = malloc(x0 + 8)
    
    if (x0_2 == 0)
        abort()
        noreturn
    
    *x0_2 = x0_2
    result = &x0_2[1]

int64_t x1 = arg1[3]
size_t x2 = *arg1

if (x1 == 0)
    memset(result, 0, x2)
else
    memcpy(result, x1, x2)

return result
