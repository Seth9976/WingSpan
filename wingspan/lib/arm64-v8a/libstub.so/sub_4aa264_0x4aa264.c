// 函数: sub_4aa264
// 地址: 0x4aa264
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

arg2[4] = 0
arg2[3] = arg1
arg2[4].b = 2
arg2[1] = arg3
int16_t x0 = arg2[4].w
*arg2 = -1
arg2[2] = arg4
arg2[4].w = x0 | 0x7f8

if (pthread_create != 0)
    pthread_mutex_lock(0x4b11d8)

arg2[5] = data_4b1200
data_4b1200 = arg2

if (pthread_create == 0)
    return &data_4b1038

return pthread_mutex_unlock(0x4b11d8) __tailcall
