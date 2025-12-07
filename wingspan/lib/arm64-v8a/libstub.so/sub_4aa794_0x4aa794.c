// 函数: sub_4aa794
// 地址: 0x4aa794
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

if (pthread_create == 0)
    if (arg1[2] == 0)
        arg1[2] = sub_4aa6dc(arg1)
    
    return arg1[2]

int64_t x19_1 = arg1[2]

if (x19_1 == 0)
    pthread_once(0x4b1218, sub_4aa61c)
    pthread_mutex_lock(0x4b1220)
    x19_1 = arg1[2]
    
    if (x19_1 == 0)
        x19_1 = data_4b1248 + 1
        data_4b1248 = x19_1
        arg1[2] = x19_1
    
    pthread_mutex_unlock(0x4b1220)

int64_t* oldmem = pthread_getspecific(zx.q(data_4b1210))
int64_t* oldmem_1 = oldmem

if (oldmem != 0)
    int64_t x23_1 = oldmem[1]
    
    if (x19_1 u> x23_1)
        int64_t x21_2 = x23_1 << 1
        int64_t x21_3
        
        if (x19_1 u> x21_2)
            x21_3 = x19_1 + 0x20
        else
            x21_3 = x21_2
        
        int64_t* oldmem_3 = realloc(oldmem, (x21_3 + 2) << 3)
        oldmem_1 = oldmem_3
        
        if (oldmem_3 == 0)
            abort()
            noreturn
        
        oldmem_3[1] = x21_3
        memset(&oldmem_1[x23_1 + 2], 0, (x21_3 - x23_1) << 3)
        pthread_setspecific(zx.q(data_4b1210), oldmem_1)
else
    int64_t* oldmem_2 = calloc(x19_1 + 0x22, 8)
    oldmem_1 = oldmem_2
    
    if (oldmem_2 == 0)
        abort()
        noreturn
    
    *oldmem_1 = 1
    oldmem_1[1] = x19_1 + 0x20
    pthread_setspecific(zx.q(data_4b1210), oldmem_1)

void* x19_3 = &oldmem_1[x19_1]
void* result = *(x19_3 + 8)

if (result == 0)
    result = sub_4aa6dc(arg1)
    *(x19_3 + 8) = result

return result
