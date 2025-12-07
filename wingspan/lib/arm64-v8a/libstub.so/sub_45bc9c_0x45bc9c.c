// 函数: sub_45bc9c
// 地址: 0x45bc9c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x24 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x24 + 0x28)
int64_t result

if (*arg2 == 0)
    int64_t var_68_1 = 0
    int64_t var_60_1 = 0
    int64_t var_70 = arg3
    pthread_mutex_lock(0x4b0c98)
    void** x9_2 = data_4b0c88
    
    if (x9_2 == 0)
    label_45bd9c:
        pthread_mutex_unlock(0x4b0c98)
        int64_t x0_1 = (*(*arg1 + 0x30))(arg1, arg3)
        
        if (x0_1 == 0)
            result = 1
        else if (data_4b0c90 u> 0x5db)
            result = 0
            *arg2 = x0_1
        else
            pthread_mutex_lock(0x4b0c98)
            int64_t x0_3 = (*(*arg1 + 0xa8))(arg1, x0_1)
            *arg2 = x0_3
            int64_t* var_50 = &var_70
            sub_45c898(&data_4b0c80, &var_70, 0x452b0f, &var_50)[7] = x0_3
            (*(*arg1 + 0xb8))(arg1, x0_1)
            pthread_mutex_unlock(0x4b0c98)
            result = 0
    else
        int64_t* x8_3 = &data_4b0c88
        
        while (true)
            int64_t x11_1 = x9_2[4]
            
            if (x11_1 != arg3 && x11_1 u< arg3)
                x9_2 = x9_2[1]
                
                if (x9_2 == 0)
                    break
                
                continue
            
            x8_3 = x9_2
            x9_2 = *x9_2
            
            if (x9_2 == 0)
                break
        
        if (x8_3 == &data_4b0c88)
            goto label_45bd9c
        
        int64_t x9_4 = x8_3[4]
        
        if (x9_4 == arg3)
            if (x8_3[5] != 0 || x8_3[6] != 0)
                goto label_45bd9c
        else if (x9_4 u> arg3)
            goto label_45bd9c
        
        *arg2 = x8_3[7]
        pthread_mutex_unlock(0x4b0c98)
        result = 0
else
    result = 0

if (*(x24 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
