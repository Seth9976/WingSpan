// 函数: sub_4aa17c
// 地址: 0x4aa17c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (arg1 == 0 || *arg1 == 0)
    return 

*arg2 = -1
arg2[4] = 0
arg2[3] = arg1
arg2[1] = arg3
arg2[2] = arg4
arg2[4].w = 0x7f8

if (pthread_create != 0)
    pthread_mutex_lock(0x4b11d8)

arg2[5] = data_4b1200
data_4b1200 = arg2

if (pthread_create != 0)
    return pthread_mutex_unlock(0x4b11d8) __tailcall
