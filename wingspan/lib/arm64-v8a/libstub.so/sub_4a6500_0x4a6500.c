// 函数: sub_4a6500
// 地址: 0x4a6500
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

pthread_mutex_lock(0x4b0d98)
int16_t* x9 = data_4b0dc0

if (x9 != 0 && x9 != &data_4b0fd0)
    uint64_t x12_1 = zx.q(*(arg1 - 2))
    int16_t* x10_1 = nullptr
    void* x11_1 = arg1 - 4 + (x12_1 << 2)
    int16_t* x14_1 = x9
    uint64_t i
    
    do
        uint64_t x15_1 = zx.q(x14_1[1])
        
        if (&x14_1[x15_1 * 2] == arg1 - 4)
            x14_1[1] = x12_1.w + x15_1.w
            return pthread_mutex_unlock(0x4b0d98)
        
        if (x11_1 == x14_1)
            *(arg1 - 2) = x12_1.w + x15_1.w
            
            if (x10_1 == 0)
                data_4b0dc0 = arg1 - 4
                *(arg1 - 4) = *x11_1
            else
                *x10_1 = (((arg1 - 4).d - &data_4b0dd0) u>> 2).w
            
            return pthread_mutex_unlock(0x4b0d98)
        
        i = zx.q(*x14_1) << 2
        x10_1 = x14_1
        x14_1 = &(&data_4b0dd0)[zx.q(*x14_1)]
    while (i != 0x200)

*(arg1 - 4) = ((x9.d - &data_4b0dd0) u>> 2).w
data_4b0dc0 = arg1 - 4
return pthread_mutex_unlock(0x4b0d98)
