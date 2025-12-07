// 函数: sub_4aa458
// 地址: 0x4aa458
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (pthread_create != 0)
    pthread_mutex_lock(0x4b11d8)

int64_t* x19 = data_4b1208
int32_t* i

while (true)
    if (x19 != 0)
        if (arg1 u< *x19)
            x19 = x19[5]
            continue
        else
            int32_t* i_2 = sub_4a9c0c(x19, arg1)
            i = i_2
            
            if (i_2 != 0)
                break
    
    do
        x19 = data_4b1200
        
        if (x19 == 0)
            i = nullptr
            
            if (pthread_create == 0)
                goto label_4aa5a0
            
            goto label_4aa53c
        
        data_4b1200 = x19[5]
        i = sub_4a9c0c(x19, arg1)
        int64_t* j = data_4b1208
        int64_t** x2_1 = &data_4b1208
        
        for (; j != 0; j = j[5])
            if (*j u< *x19)
                break
            
            x2_1 = &j[5]
        
        x19[5] = j
        *x2_1 = x19
    while (i == 0)
    
    break

int64_t data

if (pthread_create != 0)
label_4aa53c:
    pthread_mutex_unlock(0x4b11d8)
    
    if (i != 0)
        goto label_4aa548
    
label_4aa5a0:
    int32_t var_8_1 = 1
    data = arg1
    i = nullptr
    int64_t var_28
    __builtin_memset(&var_28, 0, 0x20)
    
    if ((dl_iterate_phdr(callback, &data) & 0x80000000) == 0)
        int32_t* i_1
        i = i_1
        
        if (i != 0)
            *arg2 = var_28
            int64_t var_20
            arg2[1] = var_20
            int64_t var_18
            arg2[2] = var_18
else
label_4aa548:
    *arg2 = x19[1]
    uint32_t x1_2 = zx.d(x19[4].b)
    arg2[1] = x19[2]
    char x0_9 = (zx.q(x19[4].w) u>> 3).b & 0xff
    
    if ((x1_2 & 4) != 0)
        x0_9 = sub_4a94b0(i)
    
    sub_4a90d4(x0_9, sub_4a9014(x0_9, x19), &i[2], &data)
    arg2[2] = data
return i
