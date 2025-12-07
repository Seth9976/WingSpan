// 函数: sub_45be5c
// 地址: 0x45be5c
// 来自: E:\torrent\Cursor\Wingspan-v1.7.791-unlocked-apkvision\arm64-v8a\libstub.so

uint64_t x26 = _ReadMSR(tpidr_el0)
int64_t x8 = *(x26 + 0x28)
uint64_t result

if (*arg3 == 0)
    if ((sub_45bc9c(arg1, arg2, arg5) & 1) != 0)
        result = 1
    else
        int64_t var_80 = arg5
        int64_t var_78_1 = arg6
        int64_t var_70_1 = arg7
        pthread_mutex_lock(0x4b0cc0)
        void** i = data_4b0c70
        
        if (i == 0)
        label_45bf4c:
            pthread_mutex_unlock(0x4b0cc0)
            void* x8_2 = *arg1
            int64_t x8_3
            
            if ((arg4 & 1) == 0)
                x8_3 = *(x8_2 + 0x108)
            else
                x8_3 = *(x8_2 + 0x388)
            
            int64_t x0_2 = x8_3(arg1, *arg2, arg6, arg7)
            *arg3 = x0_2
            
            if (x0_2 == 0)
                result = 1
            else
                pthread_mutex_lock(0x4b0cc0)
                int64_t x21_2 = *arg3
                int64_t* var_60 = &var_80
                sub_45c9d8(&data_4b0c68, &var_80, 0x452b0f, &var_60)[7] = x21_2
                pthread_mutex_unlock(0x4b0cc0)
                result = zx.q(*arg3 == 0 ? 1 : 0)
        else
            int64_t* i_1 = &data_4b0c70
            
            do
                int64_t x12_3 = i[4]
                bool cond:0_1 = x12_3 u< arg5
                
                if (x12_3 == arg5)
                    int64_t x12_4 = i[5]
                    cond:0_1 = x12_4 u< arg6
                    
                    if (x12_4 == arg6)
                        cond:0_1 = i[6] u< arg7
                
                int32_t x12_1 = cond:0_1 ? 1 : 0
                int64_t x12_2
                
                x12_2 = x12_1 != 0 ? 8 : 0
                
                if (x12_1 == 0)
                    i_1 = i
                
                i = *(i + x12_2)
            while (i != 0)
            
            if (i_1 == &data_4b0c70)
                goto label_45bf4c
            
            int64_t x9_1 = i_1[4]
            
            if (x9_1 == arg5)
                int64_t x9_3 = i_1[5]
                bool cond:3_1 = x9_3 u> arg6
                
                if (x9_3 == arg6)
                    cond:3_1 = i_1[6] u> arg7
                
                if (cond:3_1)
                    goto label_45bf4c
                
                goto label_45c02c
            
            if (x9_1 u> arg5)
                goto label_45bf4c
            
        label_45c02c:
            *arg3 = i_1[7]
            pthread_mutex_unlock(0x4b0cc0)
            result = 0
else
    result = 0

if (*(x26 + 0x28) == x8)
    return result

__stack_chk_fail()
noreturn
