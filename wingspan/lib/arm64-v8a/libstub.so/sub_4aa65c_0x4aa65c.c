// 函数: sub_4aa65c
// 地址: 0x4aa65c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

int64_t x0 = *arg1

if (x0 != 0)
    *arg1 = x0 - 1
    return pthread_setspecific(zx.q(data_4b1210)) __tailcall

int64_t x21 = arg1[1]

for (int64_t i = 0; i != x21; i += 1)
    void* x0_5 = arg1[i + 2]
    
    if (x0_5 != 0)
        free(*(x0_5 - 8))

return free(arg1) __tailcall
