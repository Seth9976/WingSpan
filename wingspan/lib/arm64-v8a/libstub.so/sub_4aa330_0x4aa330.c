// 函数: sub_4aa330
// 地址: 0x4aa330
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (arg1 == 0 || *arg1 == 0)
    return nullptr

if (pthread_create != 0)
    pthread_mutex_lock(0x4b11d8)

int64_t* x0 = &data_4b1200
void* const result = data_4b1200

while (true)
    if (result != 0)
        if (*(result + 0x18) == arg1)
        label_4aa3c4:
            *x0 = *(result + 0x28)
        label_4aa418:
            
            if (pthread_create != 0)
            label_4aa408:
                pthread_mutex_unlock(0x4b11d8)
                
                if (result == 0)
                    break
        else
            x0 = result + 0x28
            result = *(result + 0x28)
            continue
        
        return result
    
    x0 = &data_4b1208
    
    while (true)
        result = *x0
        
        if (result == 0)
            if (pthread_create == 0)
                goto label_4aa410
            
            break
        
        if ((zx.d(*(result + 0x20)) & 1) != 0)
            if (**(result + 0x18) == arg1)
                *x0 = *(result + 0x28)
                free(*(result + 0x18))
                goto label_4aa418
        else if (*(result + 0x18) == arg1)
            goto label_4aa3c4
        
        x0 = result + 0x28
    
    goto label_4aa408

label_4aa410:
abort()
noreturn
