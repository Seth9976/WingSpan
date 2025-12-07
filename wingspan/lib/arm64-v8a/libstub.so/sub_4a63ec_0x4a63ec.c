// 函数: sub_4a63ec
// 地址: 0x4a63ec
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

pthread_mutex_lock(0x4b0d98)
int32_t* x12 = data_4b0dc0

if (x12 == 0)
    x12 = &data_4b0dd0
    data_4b0dc0 = &data_4b0dd0
    data_4b0dd0 = 0x800080

void* result

if (x12 != &data_4b0fd0)
    int32_t* x11_1 = nullptr
    int32_t* x19_1
    
    do
        x19_1 = x12
        uint64_t x12_1 = zx.q(*(x12 + 2))
        
        if (((arg1 + 3) u>> 2) + 1 u< x12_1)
            int16_t x8_1 = x12_1.w - (((arg1 + 3) u>> 2) + 1).w
            *(x19_1 + 2) = x8_1
            int16_t* x8_2 = &x19_1[zx.q(x8_1)]
            *x8_2 = 0
            x8_2[1] = ((((arg1 + 3) u>> 2) + 1).d).w
            result = &x8_2[2]
            goto label_4a64c0
        
        if (((arg1 + 3) u>> 2) + 1 == x12_1)
            uint64_t x10_4 = zx.q(*x19_1)
            
            if (x11_1 == 0)
                data_4b0dc0 = &(&data_4b0dd0)[x10_4]
            else
                *x11_1 = (x10_4.d).w
            
            *x19_1 = 0
            result = &x19_1[1]
            goto label_4a64c0
        
        x12 = &(&data_4b0dd0)[zx.q(*x19_1)]
        x11_1 = x19_1
    while (zx.q(*x19_1) << 2 != 0x200)

result = nullptr
label_4a64c0:
pthread_mutex_unlock(0x4b0d98)
return result
